
package dashboard.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object pulls extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template8[List[service.IssuesService.IssueInfo],Int,Int,Int,service.IssuesService.IssueSearchCondition,String,List[String],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issues: List[service.IssuesService.IssueInfo],
  page: Int,
  openCount: Int,
  closedCount: Int,
  condition: service.IssuesService.IssueSearchCondition,
  filter: String,
  groups: List[String])(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*7.55*/("""
"""),_display_(/*10.2*/html/*10.6*/.main("Pull Requests")/*10.28*/{_display_(Seq[Any](format.raw/*10.29*/("""
  """),_display_(/*11.4*/dashboard/*11.13*/.html.tab("pulls")),format.raw/*11.31*/("""
  """),format.raw/*12.3*/("""<div class="container">
    """),_display_(/*13.6*/issuesnavi(filter, "pulls", condition)),format.raw/*13.44*/("""
    """),_display_(/*14.6*/pullslist(issues, page, openCount, closedCount, condition, filter, groups)),format.raw/*14.80*/("""
  """),format.raw/*15.3*/("""</div>
""")))}),format.raw/*16.2*/("""
"""))}
  }

  def render(issues:List[service.IssuesService.IssueInfo],page:Int,openCount:Int,closedCount:Int,condition:service.IssuesService.IssueSearchCondition,filter:String,groups:List[String],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(issues,page,openCount,closedCount,condition,filter,groups)(context)

  def f:((List[service.IssuesService.IssueInfo],Int,Int,Int,service.IssuesService.IssueSearchCondition,String,List[String]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (issues,page,openCount,closedCount,condition,filter,groups) => (context) => apply(issues,page,openCount,closedCount,condition,filter,groups)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/dashboard/pulls.scala.html
                  HASH: d495c945d93b3cc744bfaedd279aa0f3e8faaf33
                  MATRIX: 465->1|819->229|847->272|859->276|890->298|929->299|959->303|977->312|1016->330|1046->333|1101->362|1160->400|1192->406|1287->480|1317->483|1355->491
                  LINES: 13->1|23->7|24->10|24->10|24->10|24->10|25->11|25->11|25->11|26->12|27->13|27->13|28->14|28->14|29->15|30->16
                  -- GENERATED --
              */
          