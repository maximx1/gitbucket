
package dashboard.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object pullslist extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template8[List[service.IssuesService.IssueInfo],Int,Int,Int,service.IssuesService.IssueSearchCondition,String,List[String],app.Context,play.twirl.api.HtmlFormat.Appendable] {

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
import service.IssuesService.IssueInfo

Seq[Any](format.raw/*7.55*/("""
"""),format.raw/*35.3*/("""
"""),format.raw/*36.1*/("""<table class="table table-bordered table-hover table-issues">
  <tr>
    <th style="background-color: #eee;">
      """),_display_(/*39.8*/dashboard/*39.17*/.html.header(openCount, closedCount, condition, groups)),format.raw/*39.72*/("""
    """),format.raw/*40.5*/("""</th>
  </tr>
  """),_display_(/*42.4*/issues/*42.10*/.map/*42.14*/ { case IssueInfo(issue, labels, milestone, commentCount) =>_display_(Seq[Any](format.raw/*42.74*/("""
  """),format.raw/*43.3*/("""<tr>
    <td>
      <img src=""""),_display_(/*45.18*/assets),format.raw/*45.24*/("""/common/images/pullreq-"""),_display_(/*45.48*/(if(issue.closed) "closed" else "open")),format.raw/*45.87*/(""".png"/>
      <a href=""""),_display_(/*46.17*/path),format.raw/*46.21*/("""/"""),_display_(/*46.23*/issue/*46.28*/.userName),format.raw/*46.37*/("""/"""),_display_(/*46.39*/issue/*46.44*/.repositoryName),format.raw/*46.59*/("""/pull/"""),_display_(/*46.66*/issue/*46.71*/.issueId),format.raw/*46.79*/("""" class="issue-title">"""),_display_(/*46.102*/issue/*46.107*/.title),format.raw/*46.113*/("""</a>
      <span class="pull-right muted">#"""),_display_(/*47.40*/issue/*47.45*/.issueId),format.raw/*47.53*/("""</span>
        <div style="margin-left: 20px;">
          """),_display_(/*49.12*/issue/*49.17*/.content.map/*49.29*/ { content =>_display_(Seq[Any](format.raw/*49.42*/("""
            """),_display_(/*50.14*/cut(content, 90)),format.raw/*50.30*/("""
          """)))}/*51.12*/.getOrElse/*51.22*/ {_display_(Seq[Any](format.raw/*51.24*/("""
            """),format.raw/*52.13*/("""<span class="muted">No description available</span>
          """)))}),format.raw/*53.12*/("""
        """),format.raw/*54.9*/("""</div>
      <div class="small muted" style="margin-left: 20px;">
        """),_display_(/*56.10*/avatarLink(issue.openedUserName, 20)),format.raw/*56.46*/(""" """),format.raw/*56.47*/("""by """),_display_(/*56.51*/user(issue.openedUserName, styleClass="username")),format.raw/*56.100*/(""" """),_display_(/*56.102*/datetime(issue.registeredDate)),format.raw/*56.132*/("""&nbsp;
        """),_display_(/*57.10*/if(commentCount > 0)/*57.30*/{_display_(Seq[Any](format.raw/*57.31*/("""
          """),format.raw/*58.11*/("""<i class="icon-comment"></i><a href=""""),_display_(/*58.49*/path),format.raw/*58.53*/("""/"""),_display_(/*58.55*/issue/*58.60*/.userName),format.raw/*58.69*/("""/"""),_display_(/*58.71*/issue/*58.76*/.repositoryName),format.raw/*58.91*/("""/issues/"""),_display_(/*58.100*/issue/*58.105*/.issueId),format.raw/*58.113*/("""" class="issue-comment-count">"""),_display_(/*58.144*/commentCount),format.raw/*58.156*/(""" """),_display_(/*58.158*/plural(commentCount, "comment")),format.raw/*58.189*/("""</a>
        """)))}),format.raw/*59.10*/("""
      """),format.raw/*60.7*/("""</div>
    </td>
  </tr>
  """)))}),format.raw/*63.4*/("""
"""),format.raw/*64.1*/("""</table>
<div class="pull-right">
  """),_display_(/*66.4*/helper/*66.10*/.html.paginator(page, (if(condition.state == "open") openCount else closedCount), service.PullRequestService.PullRequestLimit, 10, condition.toURL)),format.raw/*66.157*/("""
"""),format.raw/*67.1*/("""</div>
"""))}
  }

  def render(issues:List[service.IssuesService.IssueInfo],page:Int,openCount:Int,closedCount:Int,condition:service.IssuesService.IssueSearchCondition,filter:String,groups:List[String],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(issues,page,openCount,closedCount,condition,filter,groups)(context)

  def f:((List[service.IssuesService.IssueInfo],Int,Int,Int,service.IssuesService.IssueSearchCondition,String,List[String]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (issues,page,openCount,closedCount,condition,filter,groups) => (context) => apply(issues,page,openCount,closedCount,condition,filter,groups)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/dashboard/pullslist.scala.html
                  HASH: 62283f8812660f934daaa940019dd4d0d6a6e147
                  MATRIX: 469->1|862->229|890->1852|918->1853|1061->1970|1079->1979|1155->2034|1187->2039|1230->2056|1245->2062|1258->2066|1356->2126|1386->2129|1444->2160|1471->2166|1522->2190|1582->2229|1633->2253|1658->2257|1687->2259|1701->2264|1731->2273|1760->2275|1774->2280|1810->2295|1844->2302|1858->2307|1887->2315|1938->2338|1953->2343|1981->2349|2052->2393|2066->2398|2095->2406|2182->2466|2196->2471|2217->2483|2268->2496|2309->2510|2346->2526|2377->2538|2396->2548|2436->2550|2477->2563|2571->2626|2607->2635|2709->2710|2766->2746|2795->2747|2826->2751|2897->2800|2927->2802|2979->2832|3022->2848|3051->2868|3090->2869|3129->2880|3194->2918|3219->2922|3248->2924|3262->2929|3292->2938|3321->2940|3335->2945|3371->2960|3408->2969|3423->2974|3453->2982|3512->3013|3546->3025|3576->3027|3629->3058|3674->3072|3708->3079|3766->3107|3794->3108|3857->3145|3872->3151|4041->3298|4069->3299
                  LINES: 13->1|24->7|25->35|26->36|29->39|29->39|29->39|30->40|32->42|32->42|32->42|32->42|33->43|35->45|35->45|35->45|35->45|36->46|36->46|36->46|36->46|36->46|36->46|36->46|36->46|36->46|36->46|36->46|36->46|36->46|36->46|37->47|37->47|37->47|39->49|39->49|39->49|39->49|40->50|40->50|41->51|41->51|41->51|42->52|43->53|44->54|46->56|46->56|46->56|46->56|46->56|46->56|46->56|47->57|47->57|47->57|48->58|48->58|48->58|48->58|48->58|48->58|48->58|48->58|48->58|48->58|48->58|48->58|48->58|48->58|48->58|48->58|49->59|50->60|53->63|54->64|56->66|56->66|56->66|57->67
                  -- GENERATED --
              */
          