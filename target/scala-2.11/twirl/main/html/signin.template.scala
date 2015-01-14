
package html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object signin extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._

Seq[Any](format.raw/*1.35*/("""
"""),_display_(/*3.2*/main("Sign in")/*3.17*/{_display_(Seq[Any](format.raw/*3.18*/("""
  """),format.raw/*4.3*/("""<div class="signin-form">
    """),_display_(/*5.6*/signinform(settings)),format.raw/*5.26*/("""
  """),format.raw/*6.3*/("""</div>
""")))}),format.raw/*7.2*/("""
"""))}
  }

  def render(context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply()(context)

  def f:(() => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = () => (context) => apply()(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:10 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/signin.scala.html
                  HASH: 0b663d86b92d5041fb3ecf0bb4c1113df0fab828
                  MATRIX: 343->1|480->34|507->54|530->69|568->70|597->73|653->104|693->124|722->127|759->135
                  LINES: 13->1|16->1|17->3|17->3|17->3|18->4|19->5|19->5|20->6|21->7
                  -- GENERATED --
              */
          