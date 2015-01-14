
package admin.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object menu extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Html,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(active: String)(body: Html)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._

Seq[Any](format.raw/*1.61*/("""
"""),format.raw/*3.1*/("""<div class="container">
  <div class="row-fluid">
    <div class="span3">
      <div class="box">
        <ul class="nav nav-tabs nav-stacked side-menu">
          <li"""),_display_(/*8.15*/if(active=="users")/*8.34*/{_display_(Seq[Any](format.raw/*8.35*/(""" """),format.raw/*8.36*/("""class="active"""")))}),format.raw/*8.51*/(""">
            <a href=""""),_display_(/*9.23*/path),format.raw/*9.27*/("""/admin/users">User Management</a>
          </li>
          <li"""),_display_(/*11.15*/if(active=="system")/*11.35*/{_display_(Seq[Any](format.raw/*11.36*/(""" """),format.raw/*11.37*/("""class="active"""")))}),format.raw/*11.52*/(""">
            <a href=""""),_display_(/*12.23*/path),format.raw/*12.27*/("""/admin/system">System Settings</a>
          </li>
          <li>
            <a href=""""),_display_(/*15.23*/path),format.raw/*15.27*/("""/console/login.jsp">H2 Console</a>
          </li>
       </ul>
     </div>
    </div>
    <div class="span9">
      """),_display_(/*21.8*/body),format.raw/*21.12*/("""
    """),format.raw/*22.5*/("""</div>
  </div>
</div>"""))}
  }

  def render(active:String,body:Html,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(active)(body)(context)

  def f:((String) => (Html) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (active) => (body) => (context) => apply(active)(body)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/admin/menu.scala.html
                  HASH: 618537c5465c029538aa5e7c05d610d25d442240
                  MATRIX: 359->1|522->60|549->79|743->247|770->266|808->267|836->268|881->283|931->307|955->311|1046->375|1075->395|1114->396|1143->397|1189->412|1240->436|1265->440|1380->528|1405->532|1549->650|1574->654|1606->659
                  LINES: 13->1|16->1|17->3|22->8|22->8|22->8|22->8|22->8|23->9|23->9|25->11|25->11|25->11|25->11|25->11|26->12|26->12|29->15|29->15|35->21|35->21|36->22
                  -- GENERATED --
              */
          