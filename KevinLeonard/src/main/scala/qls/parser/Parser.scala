package qls.parser

import ql.ast._
import qls.ast.Question
import qls.ast._

import ql.parser.{Parser => QLParser}

import scala.util.parsing.combinator.JavaTokenParsers

class Parser extends JavaTokenParsers {

  val qlParsers = new QLParser

  // general parsers
  override val whiteSpace = qlParsers.whiteSpace
  def variable: Parser[Variable] = ident ^^ Variable

  def style: Parser[Style] = "style" ~> ident ~ stylesheetElements ^^ {
    case label ~ sss => Style(label, sss)
  }
  
  def stylesheetElements: Parser[List[StyleSheetElement]] = "{" ~> rep(page | defaultWidget) <~ "}"
  
  def page: Parser[StyleSheetElement] = "page" ~> variable ~ pageElements ^^ {
    case v ~ ps => Page(v, ps)
  }
  
  def pageElements: Parser[List[PageElement]] = "{" ~> rep(section) <~ "}"
  
  def section: Parser[Section] = "section" ~> stringLiteral ~ sectionElements ^^ {
    case t ~ ss => Section(t.substring(1, t.length - 1).replace("\\", ""), ss)
  }
  
  def sectionElements: Parser[List[SectionElement]] = "{" ~> rep(question | section) <~ "}"
  
  // question widget parsers
  def question: Parser[Question] = variable ~ widget ^^ {
    case v ~ w => Question(v, w)
  }
  
  // TODO: Move question type to QL
  def questionType: Parser[Type] = ("boolean" | "number" | "string") ^^ {
    case "boolean" => BooleanType()
    case "number" => NumberType()
    case "string" => StringType()
  }
  
  def widget: Parser[Widget] = widgetType ~ opt(widgetStyle) ^^ {
    case "spinbox" ~ properties => SpinBox(properties)
    case "slider" ~ properties => Slider(properties)
    case "text" ~ properties => Text(properties)
    case "textBlock" ~ properties => TextBlock(properties)
    case "radio" ~ properties => Radio(properties)
    case "dropdown" ~ properties => DropDown(properties)
  } 
  
  def defaultWidget: Parser[DefaultWidget] = "default" ~> questionType ~ widget ^^ {
    case t ~ w => DefaultWidget(t, w)
  }
  
  def widgetType: Parser[String] = ("spinbox" | "slider" | "textBlock" | "text" | "radio" | "dropdown")
  
  def widgetStyle: Parser[List[StyleProperty]] = "{" ~> rep(width | font | fontSize | fontColor) <~ "}"
  
  def width: Parser[StyleProperty] = "width:" ~> wholeNumber ^^ { v => Width(v.toInt) }
  def font: Parser[StyleProperty] = "font:" ~> stringLiteral ^^ { 
    v => Font(v.substring(1, v.length - 1).replace("\\", ""))
  }
  def fontSize: Parser[StyleProperty] = "fontSize:" ~> wholeNumber ^^ { v => FontSize(v.toInt) }
  def fontColor: Parser[StyleProperty] = "color:" ~> hexadecimalColor ^^ { v => FontColor(v) }

  def hexadecimalColor: Parser[HexadecimalColor] = "#" ~> """([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})""".r ^^ { v => new HexadecimalColor(v) }

}
