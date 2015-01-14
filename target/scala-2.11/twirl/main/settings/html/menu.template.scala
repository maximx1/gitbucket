
package settings.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object menu extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,service.RepositoryService.RepositoryInfo,Html,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(active: String, repository: service.RepositoryService.RepositoryInfo)(body: Html)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*1.115*/("""
"""),format.raw/*4.1*/("""<div class="row-fluid">
  <div class="span3">
    <div class="box">
      <ul class="nav nav-tabs nav-stacked side-menu">
        <li"""),_display_(/*8.13*/if(active=="options")/*8.34*/{_display_(Seq[Any](format.raw/*8.35*/(""" """),format.raw/*8.36*/("""class="active"""")))}),format.raw/*8.51*/(""">
          <a href=""""),_display_(/*9.21*/url(repository)),format.raw/*9.36*/("""/settings/options">Options</a>
        </li>
        <li"""),_display_(/*11.13*/if(active=="collaborators")/*11.40*/{_display_(Seq[Any](format.raw/*11.41*/(""" """),format.raw/*11.42*/("""class="active"""")))}),format.raw/*11.57*/(""">
          <a href=""""),_display_(/*12.21*/url(repository)),format.raw/*12.36*/("""/settings/collaborators">Collaborators</a>
        </li>
        <li"""),_display_(/*14.13*/if(active=="hooks")/*14.32*/{_display_(Seq[Any](format.raw/*14.33*/(""" """),format.raw/*14.34*/("""class="active"""")))}),format.raw/*14.49*/(""">
          <a href=""""),_display_(/*15.21*/url(repository)),format.raw/*15.36*/("""/settings/hooks">Service Hooks</a>
        </li>
        <li"""),_display_(/*17.13*/if(active=="danger")/*17.33*/{_display_(Seq[Any](format.raw/*17.34*/(""" """),format.raw/*17.35*/("""class="active"""")))}),format.raw/*17.50*/(""">
          <a href=""""),_display_(/*18.21*/url(repository)),format.raw/*18.36*/("""/settings/danger">Danger Zone</a>
        </li>
      </ul>
    </div>
  </div>
  <div class="span9">
    """),_display_(/*24.6*/body),format.raw/*24.10*/("""
  """),format.raw/*25.3*/("""</div>
</div>
"""))}
  }

  def render(active:String,repository:service.RepositoryService.RepositoryInfo,body:Html,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(active,repository)(body)(context)

  def f:((String,service.RepositoryService.RepositoryInfo) => (Html) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (active,repository) => (body) => (context) => apply(active,repository)(body)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/settings/menu.scala.html
                  HASH: 719109465cee2ad60b7005225cb992b99d523f84
                  MATRIX: 403->1|643->114|670->156|830->290|859->311|897->312|925->313|970->328|1018->350|1053->365|1137->422|1173->449|1212->450|1241->451|1287->466|1336->488|1372->503|1468->572|1496->591|1535->592|1564->593|1610->608|1659->630|1695->645|1783->706|1812->726|1851->727|1880->728|1926->743|1975->765|2011->780|2144->887|2169->891|2199->894
                  LINES: 13->1|17->1|18->4|22->8|22->8|22->8|22->8|22->8|23->9|23->9|25->11|25->11|25->11|25->11|25->11|26->12|26->12|28->14|28->14|28->14|28->14|28->14|29->15|29->15|31->17|31->17|31->17|31->17|31->17|32->18|32->18|38->24|38->24|39->25
                  -- GENERATED --
              */
          