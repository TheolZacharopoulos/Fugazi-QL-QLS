// +build !darwin
// Mac OS X uses its own set of position-independent key codes

// 29 march 2014

package ui

import (
	"image"
)

/*
Windows and GTK+ have a limit of 2 and 3 clicks, respectively, natively supported. Fortunately, we can simulate the double/triple-click behavior to build higher-order clicks. We can use the same algorithm Windows uses on both:
	http://blogs.msdn.com/b/oldnewthing/archive/2004/10/18/243925.aspx
For GTK+, we pull the double-click time and double-click distance, which work the same as the equivalents on Windows (so the distance is in all directions), from the GtkSettings system.

On GTK+ this will also allow us to discard the GDK_BUTTON_2PRESS and GDK_BUTTON_3PRESS events, so the button press stream will be just like on other platforms.

Thanks to mclasen, garnacho_, halfline, and tristan in irc.gimp.net/#gtk+.
*/

// the zero value is a reset clickCounter ready for use
// it doesn't matter that all the non-count fields are zero: the first click will fail the curButton test straightaway, so it'll return 1 and set the rest of the structure accordingly
type clickCounter struct {
	curButton uint
	rect      image.Rectangle
	prevTime  uintptr
	count     uint
}

// x, y, xdist, ydist, and c.rect must have the same units
// so must time, maxTime, and c.prevTime
func (c *clickCounter) click(button uint, x int, y int, time uintptr, maxTime uintptr, xdist int, ydist int) uint {
	if button != c.curButton { // different button; start over
		c.count = 0
	}
	if !image.Pt(x, y).In(c.rect) { // not in the allowed region for a double-click; don't count
		c.count = 0
	}
	if (time - c.prevTime) > maxTime { // too slow; don't count
		// note the above expression; time > (c.prevTime + maxTime) can overflow!
		c.count = 0
	}
	c.count++ // if either of the above ifs happened, this will make the click count 1; otherwise it will make the click count 2, 3, 4, 5, ...

	// now we need to update the internal structures for the next test
	c.curButton = button
	c.prevTime = time
	c.rect = image.Rect(x-xdist, y-ydist,
		x+xdist, y+ydist)

	return c.count
}

// call this when losing focus, etc.
func (c *clickCounter) reset() {
	c.count = 0
}

/*
For position independence across international keyboard layouts, typewriter keys are read using scancodes (which are always set 1).
Windows provides the scancodes directly in the LPARAM.
GTK+ provides the scancodes directly from the underlying window system via GdkEventKey.hardware_keycode.
On X11, this is scancode + 8 (because X11 keyboard codes have a range of [8,255]).
Wayland is guaranteed to give the same result (thanks ebassi in irc.gimp.net/#gtk+).
On Linux, where evdev is used instead of polling scancodes directly from the keyboard, evdev's typewriter section key code constants are the same as scancodes anyway, so the rules above apply.
Typewriter section scancodes are the same across international keyboards with some exceptions that have been accounted for (see KeyEvent's documentation); see http://www.quadibloc.com/comp/scan.htm for details.
Non-typewriter keys can be handled safely using constants provided by the respective backend API.

Because GTK+ keysyms may or may not obey Num Lock, we also handle the 0-9 and . keys on the numeric keypad with scancodes (they match too).
*/

// use uintptr to be safe; the size of the scancode/hardware key code field on each platform is different
var scancodeKeys = map[uintptr]byte{
	0x02: '1',
	0x03: '2',
	0x04: '3',
	0x05: '4',
	0x06: '5',
	0x07: '6',
	0x08: '7',
	0x09: '8',
	0x0A: '9',
	0x0B: '0',
	0x0C: '-',
	0x0D: '=',
	0x0E: '\b',
	0x0F: '\t',
	0x10: 'q',
	0x11: 'w',
	0x12: 'e',
	0x13: 'r',
	0x14: 't',
	0x15: 'y',
	0x16: 'u',
	0x17: 'i',
	0x18: 'o',
	0x19: 'p',
	0x1A: '[',
	0x1B: ']',
	0x1C: '\n',
	0x1E: 'a',
	0x1F: 's',
	0x20: 'd',
	0x21: 'f',
	0x22: 'g',
	0x23: 'h',
	0x24: 'j',
	0x25: 'k',
	0x26: 'l',
	0x27: ';',
	0x28: '\'',
	0x29: '`',
	0x2B: '\\',
	0x2C: 'z',
	0x2D: 'x',
	0x2E: 'c',
	0x2F: 'v',
	0x30: 'b',
	0x31: 'n',
	0x32: 'm',
	0x33: ',',
	0x34: '.',
	0x35: '/',
	0x39: ' ',
}

var scancodeExtKeys = map[uintptr]ExtKey{
	0x47: N7,
	0x48: N8,
	0x49: N9,
	0x4B: N4,
	0x4C: N5,
	0x4D: N6,
	0x4F: N1,
	0x50: N2,
	0x51: N3,
	0x52: N0,
	0x53: NDot,
}

func fromScancode(scancode uintptr) (ke KeyEvent, ok bool) {
	if key, ok := scancodeKeys[scancode]; ok {
		ke.Key = key
		return ke, true
	}
	if extkey, ok := scancodeExtKeys[scancode]; ok {
		ke.ExtKey = extkey
		return ke, true
	}
	return ke, false
}
