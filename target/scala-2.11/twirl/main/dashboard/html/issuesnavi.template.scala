
package dashboard.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object issuesnavi extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,String,service.IssuesService.IssueSearchCondition,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(filter: String,
  active: String,
  condition: service.IssuesService.IssueSearchCondition)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*3.88*/("""
"""),format.raw/*6.1*/("""<ul class="nav nav-pills-group pull-left fill-width">
  <li class=""""),_display_(/*7.15*/if(filter == "created_by")/*7.41*/{_display_(Seq[Any](format.raw/*7.42*/("""active""")))}),format.raw/*7.49*/(""" """),format.raw/*7.50*/("""first">
    <a href=""""),_display_(/*8.15*/path),format.raw/*8.19*/("""/dashboard/"""),_display_(/*8.31*/active),format.raw/*8.37*/("""/created_by"""),_display_(/*8.49*/condition/*8.58*/.copy(author = None, assigned = None).toURL),format.raw/*8.101*/("""">Created</a>
  </li>
  <li class=""""),_display_(/*10.15*/if(filter == "assigned")/*10.39*/{_display_(Seq[Any](format.raw/*10.40*/("""active""")))}),format.raw/*10.47*/("""">
    <a href=""""),_display_(/*11.15*/path),format.raw/*11.19*/("""/dashboard/"""),_display_(/*11.31*/active),format.raw/*11.37*/("""/assigned"""),_display_(/*11.47*/condition/*11.56*/.copy(author = None, assigned = None).toURL),format.raw/*11.99*/("""">Assigned</a>
  </li>
  <li class=""""),_display_(/*13.15*/if(filter == "mentioned")/*13.40*/{_display_(Seq[Any](format.raw/*13.41*/("""active""")))}),format.raw/*13.48*/(""" """),format.raw/*13.49*/("""last">
    <a href=""""),_display_(/*14.15*/path),format.raw/*14.19*/("""/dashboard/"""),_display_(/*14.31*/active),format.raw/*14.37*/("""/mentioned"""),_display_(/*14.48*/condition/*14.57*/.copy(author = None, assigned = None).toURL),format.raw/*14.100*/("""">Mentioned</a>
  </li>
  <li class="pull-right">
    <form method="GET" id="search-filter-form" action=""""),_display_(/*17.57*/path),format.raw/*17.61*/("""/dashboard/"""),_display_(/*17.73*/active),format.raw/*17.79*/("""" style="margin-bottom: 0px;">
      <input type="text" id="search-filter-box" class="input-xlarge" name="q" style="height: 24px; width: 400px;"
             value="is:"""),_display_(/*19.25*/{if(active == "issues") "issue" else "pr"}),format.raw/*19.67*/(""" """),_display_(/*19.69*/condition/*19.78*/.toFilterString),format.raw/*19.93*/(""""/>
    </form>
  </li>
</ul>
"""))}
  }

  def render(filter:String,active:String,condition:service.IssuesService.IssueSearchCondition,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(filter,active,condition)(context)

  def f:((String,String,service.IssuesService.IssueSearchCondition) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (filter,active,condition) => (context) => apply(filter,active,condition)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/dashboard/issuesnavi.scala.html
                  HASH: 607df1019ea8ea7b94e50de08b85f0c0c648ff54
                  MATRIX: 414->1|662->123|689->165|783->233|817->259|855->260|892->267|920->268|968->290|992->294|1030->306|1056->312|1094->324|1111->333|1175->376|1238->412|1271->436|1310->437|1348->444|1392->461|1417->465|1456->477|1483->483|1520->493|1538->502|1602->545|1666->582|1700->607|1739->608|1777->615|1806->616|1854->637|1879->641|1918->653|1945->659|1983->670|2001->679|2066->722|2199->828|2224->832|2263->844|2290->850|2486->1019|2549->1061|2578->1063|2596->1072|2632->1087
                  LINES: 13->1|19->3|20->6|21->7|21->7|21->7|21->7|21->7|22->8|22->8|22->8|22->8|22->8|22->8|22->8|24->10|24->10|24->10|24->10|25->11|25->11|25->11|25->11|25->11|25->11|25->11|27->13|27->13|27->13|27->13|27->13|28->14|28->14|28->14|28->14|28->14|28->14|28->14|31->17|31->17|31->17|31->17|33->19|33->19|33->19|33->19|33->19
                  -- GENERATED --
              */
          