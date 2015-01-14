
package dashboard.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object issues extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template8[List[service.IssuesService.IssueInfo],Int,Int,Int,service.IssuesService.IssueSearchCondition,String,List[String],app.Context,play.twirl.api.HtmlFormat.Appendable] {

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
"""),_display_(/*10.2*/html/*10.6*/.main("Issues")/*10.21*/{_display_(Seq[Any](format.raw/*10.22*/("""
  """),_display_(/*11.4*/dashboard/*11.13*/.html.tab("issues")),format.raw/*11.32*/("""
  """),format.raw/*12.3*/("""<div class="container">
    """),_display_(/*13.6*/issuesnavi(filter, "issues", condition)),format.raw/*13.45*/("""
    """),_display_(/*14.6*/issueslist(issues, page, openCount, closedCount, condition, filter, groups)),format.raw/*14.81*/("""
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
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/dashboard/issues.scala.html
                  HASH: f31f14c223ec143c422e7e8914076822b3b33652
                  MATRIX: 466->1|820->229|848->272|860->276|884->291|923->292|953->296|971->305|1011->324|1041->327|1096->356|1156->395|1188->401|1284->476|1314->479|1352->487
                  LINES: 13->1|23->7|24->10|24->10|24->10|24->10|25->11|25->11|25->11|26->12|27->13|27->13|28->14|28->14|29->15|30->16
                  -- GENERATED --
              */
          