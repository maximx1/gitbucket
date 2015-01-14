
package helper.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object checkicon extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Boolean,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(condition: => Boolean):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.25*/("""
"""),_display_(/*2.2*/if(condition)/*2.15*/{_display_(Seq[Any](format.raw/*2.16*/("""
  """),format.raw/*3.3*/("""<i class="icon-ok"></i>
""")))}/*4.3*/else/*4.8*/{_display_(Seq[Any](format.raw/*4.9*/("""
  """),format.raw/*5.3*/("""<i class="icon-white"></i>
""")))}))}
  }

  def render(condition:Boolean): play.twirl.api.HtmlFormat.Appendable = apply(condition)

  def f:(( => Boolean) => play.twirl.api.HtmlFormat.Appendable) = (condition) => apply(condition)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/checkicon.scala.html
                  HASH: 2b6bac9253a24b2fb2b5e99838047cec4c30b1d4
                  MATRIX: 349->1|460->24|487->26|508->39|546->40|575->43|617->69|628->74|665->75|694->78
                  LINES: 13->1|16->1|17->2|17->2|17->2|18->3|19->4|19->4|19->4|20->5
                  -- GENERATED --
              */
          