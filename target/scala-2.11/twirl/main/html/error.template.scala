
package html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object error extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.48*/("""
"""),_display_(/*2.2*/main("Error")/*2.15*/{_display_(Seq[Any](format.raw/*2.16*/("""
  """),format.raw/*3.3*/("""<h1>"""),_display_(/*3.8*/title),format.raw/*3.13*/("""</h1>
""")))}))}
  }

  def render(title:String,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(title)(context)

  def f:((String) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (title) => (context) => apply(title)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:10 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/error.scala.html
                  HASH: 045b6a09dfa5cbfae923adb939d14b293ed1325b
                  MATRIX: 349->1|483->47|510->49|531->62|569->63|598->66|628->71|653->76
                  LINES: 13->1|16->1|17->2|17->2|17->2|18->3|18->3|18->3
                  -- GENERATED --
              */
          