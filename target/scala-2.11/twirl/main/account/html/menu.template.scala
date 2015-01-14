
package account.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object menu extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Boolean,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(active: String, ssh: Boolean)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._

Seq[Any](format.raw/*1.63*/("""
"""),format.raw/*3.1*/("""<div class="box">
  <ul class="nav nav-tabs nav-stacked side-menu">
    <li"""),_display_(/*5.9*/if(active=="profile")/*5.30*/{_display_(Seq[Any](format.raw/*5.31*/(""" """),format.raw/*5.32*/("""class="active"""")))}),format.raw/*5.47*/(""">
      <a href=""""),_display_(/*6.17*/path),format.raw/*6.21*/("""/"""),_display_(/*6.23*/loginAccount/*6.35*/.get.userName),format.raw/*6.48*/("""/_edit">Profile</a>
    </li>
    """),_display_(/*8.6*/if(ssh)/*8.13*/{_display_(Seq[Any](format.raw/*8.14*/("""
    """),format.raw/*9.5*/("""<li"""),_display_(/*9.9*/if(active=="ssh")/*9.26*/{_display_(Seq[Any](format.raw/*9.27*/(""" """),format.raw/*9.28*/("""class="active"""")))}),format.raw/*9.43*/(""">
      <a href=""""),_display_(/*10.17*/path),format.raw/*10.21*/("""/"""),_display_(/*10.23*/loginAccount/*10.35*/.get.userName),format.raw/*10.48*/("""/_ssh">SSH Keys</a>
    </li>
    """)))}),format.raw/*12.6*/("""
  """),format.raw/*13.3*/("""</ul>
</div>
"""))}
  }

  def render(active:String,ssh:Boolean,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(active,ssh)(context)

  def f:((String,Boolean) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (active,ssh) => (context) => apply(active,ssh)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/account/menu.scala.html
                  HASH: 1f2b4f179ba392e8e0c99a60342d7b9cb5a41c4c
                  MATRIX: 364->1|529->62|556->81|657->157|686->178|724->179|752->180|797->195|841->213|865->217|893->219|913->231|946->244|1006->279|1021->286|1059->287|1090->292|1119->296|1144->313|1182->314|1210->315|1255->330|1300->348|1325->352|1354->354|1375->366|1409->379|1474->414|1504->417
                  LINES: 13->1|16->1|17->3|19->5|19->5|19->5|19->5|19->5|20->6|20->6|20->6|20->6|20->6|22->8|22->8|22->8|23->9|23->9|23->9|23->9|23->9|23->9|24->10|24->10|24->10|24->10|24->10|26->12|27->13
                  -- GENERATED --
              */
          