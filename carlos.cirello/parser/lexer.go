package parser

import (
	"io"
	"log"
	"os"
	"strings"
	"text/scanner"
)

// The parser expects the lexer to return 0 on EOF.
const eof = 0

const (
	// FormTokenText - Reserved Word
	FormTokenText = "form"
	// IfTokenText - Reserved Word
	IfTokenText = "if"
	// ElseTokenText - Reserved Word
	ElseTokenText = "else"
	// StringQuestionTokenText - Reserved Word
	StringQuestionTokenText = "string"
	// IntQuestionTokenText - Reserved Word
	IntQuestionTokenText = "integer"
	// BoolQuestionTokenText - Reserved Word
	BoolQuestionTokenText = "bool"
	// ComputedQuestionTokenText - Reserved Word
	ComputedQuestionTokenText = "computed"

	// LessThanTokenText - Reserved Symbols
	LessThanTokenText = `<`
	// LessOrEqualsThanTokenText - Reserved Symbols
	LessOrEqualsThanTokenText = `<=`
	// MoreThanTokenText - Reserved Symbols
	MoreThanTokenText = `>`
	// MoreOrEqualsThanTokenText - Reserved Symbols
	MoreOrEqualsThanTokenText = `>=`
	// EqualsToTokenText - Reserved Symbols
	EqualsToTokenText = `==`

	singleQuotedChar  = `'`
	doubleQuotedChar  = `"`
	literalQuotedChar = "`"
)

type lexer struct {
	scanner scanner.Scanner

	pos scanner.Position
}

func newLexer(stream io.Reader, fn string) *lexer {
	var s scanner.Scanner
	s.Init(stream)
	s.Whitespace = 1<<'\t' | 1<<'\n' | 1<<'\r' | 1<<' '
	s.Filename = fn

	return &lexer{
		scanner: s,
	}
}

// The parser calls this method to get each new token.
func (x *lexer) Lex(yylval *qlSymType) int {
	tok := x.scanner.Scan()

	if tok == scanner.EOF {
		return eof
	}

	txt := x.scanner.TokenText()
	nextRune := string(x.scanner.Peek())
	typ := TextToken

	if tok == scanner.Float || tok == scanner.Int {
		typ = NumericToken
	} else if txt == FormTokenText {
		typ = FormToken
	} else if txt == StringQuestionTokenText {
		typ = StringQuestionToken
	} else if txt == IntQuestionTokenText {
		typ = IntQuestionToken
	} else if txt == BoolQuestionTokenText {
		typ = BoolQuestionToken
	} else if txt == ComputedQuestionTokenText {
		typ = ComputedQuestionToken
	} else if txt == IfTokenText {
		typ = IfToken
	} else if txt == ElseTokenText {
		typ = ElseToken
	} else if (txt + nextRune) == LessOrEqualsThanTokenText {
		x.scanner.Scan()
		typ = LessOrEqualsThanToken
		txt = LessOrEqualsThanTokenText
	} else if (txt + nextRune) == MoreOrEqualsThanTokenText {
		x.scanner.Scan()
		typ = MoreOrEqualsThanToken
		txt = MoreOrEqualsThanTokenText
	} else if (txt + nextRune) == EqualsToTokenText {
		x.scanner.Scan()
		typ = EqualsToToken
		txt = EqualsToTokenText
	} else if txt == MoreThanTokenText {
		typ = MoreThanToken
	} else if txt == LessThanTokenText {
		typ = LessThanToken
	} else if txt == "{" || txt == "}" || txt == "(" || txt == ")" || txt == "+" || txt == "-" ||
		txt == "*" || txt == "/" || txt == "=" {
		typ = int(txt[0])
	} else if strings.HasPrefix(txt, singleQuotedChar) ||
		strings.HasPrefix(txt, doubleQuotedChar) ||
		strings.HasPrefix(txt, literalQuotedChar) {
		typ = QuotedStringToken
		txt = stripSurroundingQuotes(txt)
	}

	yylval.content = txt
	yylval.position = x.scanner.Pos()

	x.pos = x.scanner.Pos()

	return typ
}

// The parser calls this method on a parse error.
func (x *lexer) Error(s string) {
	log.Printf("%s:%d:%d:parse error: %s", x.pos.Filename, x.pos.Line, x.pos.Column, s)
	os.Exit(1)
}

func stripSurroundingQuotes(str string) string {
	return str[1 : len(str)-1]
}
