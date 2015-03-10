package qls.ast

import ql.ast.Type

sealed trait Widget
case class SpinBox(properties: Option[List[StyleProperty]]) extends Widget
case class Slider(properties: Option[List[StyleProperty]]) extends Widget
case class Text(properties: Option[List[StyleProperty]]) extends Widget
case class TextBlock(properties: Option[List[StyleProperty]]) extends Widget
case class Radio(properties: Option[List[StyleProperty]]) extends Widget
case class DropDown(properties: Option[List[StyleProperty]]) extends Widget

case class DefaultWidget(_type: Type, widget: Widget)