
package dashboard.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object issueslist extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template8[List[service.IssuesService.IssueInfo],Int,Int,Int,service.IssuesService.IssueSearchCondition,String,List[String],app.Context,play.twirl.api.HtmlFormat.Appendable] {

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
"""),format.raw/*17.3*/("""
"""),format.raw/*18.1*/("""<table class="table table-bordered table-hover table-issues">
  <tr>
    <th style="background-color: #eee;">
      """),_display_(/*21.8*/dashboard/*21.17*/.html.header(openCount, closedCount, condition, groups)),format.raw/*21.72*/("""
    """),format.raw/*22.5*/("""</th>
  </tr>
  """),_display_(/*24.4*/issues/*24.10*/.map/*24.14*/ { case IssueInfo(issue, labels, milestone, commentCount) =>_display_(Seq[Any](format.raw/*24.74*/("""
  """),format.raw/*25.3*/("""<tr>
    <td style="padding-top: 15px; padding-bottom: 15px;">
      """),_display_(/*27.8*/if(issue.isPullRequest)/*27.31*/{_display_(Seq[Any](format.raw/*27.32*/("""
        """),format.raw/*28.9*/("""<img src=""""),_display_(/*28.20*/assets),format.raw/*28.26*/("""/common/images/pullreq-"""),_display_(/*28.50*/(if(issue.closed) "closed" else "open")),format.raw/*28.89*/(""".png"/>
      """)))}/*29.9*/else/*29.14*/{_display_(Seq[Any](format.raw/*29.15*/("""
        """),format.raw/*30.9*/("""<img src=""""),_display_(/*30.20*/assets),format.raw/*30.26*/("""/common/images/issue-"""),_display_(/*30.48*/(if(issue.closed) "closed" else "open")),format.raw/*30.87*/(""".png"/>
      """)))}),format.raw/*31.8*/("""
      """),format.raw/*32.7*/("""<a href=""""),_display_(/*32.17*/path),format.raw/*32.21*/("""/"""),_display_(/*32.23*/issue/*32.28*/.userName),format.raw/*32.37*/("""/"""),_display_(/*32.39*/issue/*32.44*/.repositoryName),format.raw/*32.59*/("""">"""),_display_(/*32.62*/issue/*32.67*/.repositoryName),format.raw/*32.82*/("""</a>&nbsp;&#xFF65;
      """),_display_(/*33.8*/if(issue.isPullRequest)/*33.31*/{_display_(Seq[Any](format.raw/*33.32*/("""
        """),format.raw/*34.9*/("""<a href=""""),_display_(/*34.19*/path),format.raw/*34.23*/("""/"""),_display_(/*34.25*/issue/*34.30*/.userName),format.raw/*34.39*/("""/"""),_display_(/*34.41*/issue/*34.46*/.repositoryName),format.raw/*34.61*/("""/pull/"""),_display_(/*34.68*/issue/*34.73*/.issueId),format.raw/*34.81*/("""" class="issue-title">"""),_display_(/*34.104*/issue/*34.109*/.title),format.raw/*34.115*/("""</a>
      """)))}/*35.9*/else/*35.14*/{_display_(Seq[Any](format.raw/*35.15*/("""
        """),format.raw/*36.9*/("""<a href=""""),_display_(/*36.19*/path),format.raw/*36.23*/("""/"""),_display_(/*36.25*/issue/*36.30*/.userName),format.raw/*36.39*/("""/"""),_display_(/*36.41*/issue/*36.46*/.repositoryName),format.raw/*36.61*/("""/issues/"""),_display_(/*36.70*/issue/*36.75*/.issueId),format.raw/*36.83*/("""" class="issue-title">"""),_display_(/*36.106*/issue/*36.111*/.title),format.raw/*36.117*/("""</a>
      """)))}),format.raw/*37.8*/("""
      """),_display_(/*38.8*/labels/*38.14*/.map/*38.18*/ { label =>_display_(Seq[Any](format.raw/*38.29*/("""
        """),format.raw/*39.9*/("""<span class="label-color small" style="background-color: #"""),_display_(/*39.68*/label/*39.73*/.color),format.raw/*39.79*/("""; color: #"""),_display_(/*39.90*/label/*39.95*/.fontColor),format.raw/*39.105*/("""; padding-left: 4px; padding-right: 4px">"""),_display_(/*39.147*/label/*39.152*/.labelName),format.raw/*39.162*/("""</span>
      """)))}),format.raw/*40.8*/("""
      """),format.raw/*41.7*/("""<span class="pull-right muted">
        """),_display_(/*42.10*/issue/*42.15*/.assignedUserName.map/*42.36*/ { userName =>_display_(Seq[Any](format.raw/*42.50*/("""
          """),_display_(/*43.12*/avatar(userName, 20, tooltip = true)),format.raw/*43.48*/("""
        """)))}),format.raw/*44.10*/("""
        """),_display_(/*45.10*/if(commentCount > 0)/*45.30*/{_display_(Seq[Any](format.raw/*45.31*/("""
          """),format.raw/*46.11*/("""<a href=""""),_display_(/*46.21*/path),format.raw/*46.25*/("""/"""),_display_(/*46.27*/issue/*46.32*/.userName),format.raw/*46.41*/("""/"""),_display_(/*46.43*/issue/*46.48*/.repositoryName),format.raw/*46.63*/("""/issues/"""),_display_(/*46.72*/issue/*46.77*/.issueId),format.raw/*46.85*/("""" class="issue-comment-count">
            <img src=""""),_display_(/*47.24*/assets),format.raw/*47.30*/("""/common/images/comment-active.png"> """),_display_(/*47.67*/commentCount),format.raw/*47.79*/("""
          """),format.raw/*48.11*/("""</a>
        """)))}/*49.11*/else/*49.16*/{_display_(Seq[Any](format.raw/*49.17*/("""
          """),format.raw/*50.11*/("""<a href=""""),_display_(/*50.21*/path),format.raw/*50.25*/("""/"""),_display_(/*50.27*/issue/*50.32*/.userName),format.raw/*50.41*/("""/"""),_display_(/*50.43*/issue/*50.48*/.repositoryName),format.raw/*50.63*/("""/issues/"""),_display_(/*50.72*/issue/*50.77*/.issueId),format.raw/*50.85*/("""" class="issue-comment-count" style="color: silver;">
            <img src=""""),_display_(/*51.24*/assets),format.raw/*51.30*/("""/common/images/comment.png"> """),_display_(/*51.60*/commentCount),format.raw/*51.72*/("""
          """),format.raw/*52.11*/("""</a>
        """)))}),format.raw/*53.10*/("""
      """),format.raw/*54.7*/("""</span>
      <div class="small muted" style="margin-left: 20px; margin-top: 5px;">
        #"""),_display_(/*56.11*/issue/*56.16*/.issueId),format.raw/*56.24*/(""" """),format.raw/*56.25*/("""opened by """),_display_(/*56.36*/user(issue.openedUserName, styleClass="username")),format.raw/*56.85*/(""" """),_display_(/*56.87*/datetime(issue.registeredDate)),format.raw/*56.117*/("""
        """),_display_(/*57.10*/milestone/*57.19*/.map/*57.23*/ { milestone =>_display_(Seq[Any](format.raw/*57.38*/("""
          """),format.raw/*58.11*/("""<span style="margin: 20px;"><a href=""""),_display_(/*58.49*/condition/*58.58*/.copy(milestoneId = Some(Some(1))).toURL),format.raw/*58.98*/("""" class="username"><img src=""""),_display_(/*58.128*/assets),format.raw/*58.134*/("""/common/images/milestone.png"> """),_display_(/*58.166*/milestone),format.raw/*58.175*/("""</a></span>
        """)))}),format.raw/*59.10*/("""
      """),format.raw/*60.7*/("""</div>
    </td>
  </tr>
  """)))}),format.raw/*63.4*/("""
"""),format.raw/*64.1*/("""</table>
<div class="pull-right">
  """),_display_(/*66.4*/helper/*66.10*/.html.paginator(page, (if(condition.state == "open") openCount else closedCount), service.IssuesService.IssueLimit, 10, condition.toURL)),format.raw/*66.146*/("""
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
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/dashboard/issueslist.scala.html
                  HASH: 3496a61fe6f268bfea566e70a53e5bd9a29e5145
                  MATRIX: 470->1|863->229|891->765|919->766|1062->883|1080->892|1156->947|1188->952|1231->969|1246->975|1259->979|1357->1039|1387->1042|1483->1112|1515->1135|1554->1136|1590->1145|1628->1156|1655->1162|1706->1186|1766->1225|1799->1241|1812->1246|1851->1247|1887->1256|1925->1267|1952->1273|2001->1295|2061->1334|2106->1349|2140->1356|2177->1366|2202->1370|2231->1372|2245->1377|2275->1386|2304->1388|2318->1393|2354->1408|2384->1411|2398->1416|2434->1431|2486->1457|2518->1480|2557->1481|2593->1490|2630->1500|2655->1504|2684->1506|2698->1511|2728->1520|2757->1522|2771->1527|2807->1542|2841->1549|2855->1554|2884->1562|2935->1585|2950->1590|2978->1596|3008->1609|3021->1614|3060->1615|3096->1624|3133->1634|3158->1638|3187->1640|3201->1645|3231->1654|3260->1656|3274->1661|3310->1676|3346->1685|3360->1690|3389->1698|3440->1721|3455->1726|3483->1732|3525->1744|3559->1752|3574->1758|3587->1762|3636->1773|3672->1782|3758->1841|3772->1846|3799->1852|3837->1863|3851->1868|3883->1878|3953->1920|3968->1925|4000->1935|4045->1950|4079->1957|4147->1998|4161->2003|4191->2024|4243->2038|4282->2050|4339->2086|4380->2096|4417->2106|4446->2126|4485->2127|4524->2138|4561->2148|4586->2152|4615->2154|4629->2159|4659->2168|4688->2170|4702->2175|4738->2190|4774->2199|4788->2204|4817->2212|4898->2266|4925->2272|4989->2309|5022->2321|5061->2332|5094->2347|5107->2352|5146->2353|5185->2364|5222->2374|5247->2378|5276->2380|5290->2385|5320->2394|5349->2396|5363->2401|5399->2416|5435->2425|5449->2430|5478->2438|5582->2515|5609->2521|5666->2551|5699->2563|5738->2574|5783->2588|5817->2595|5938->2689|5952->2694|5981->2702|6010->2703|6048->2714|6118->2763|6147->2765|6199->2795|6236->2805|6254->2814|6267->2818|6320->2833|6359->2844|6424->2882|6442->2891|6503->2931|6561->2961|6589->2967|6649->2999|6680->3008|6732->3029|6766->3036|6824->3064|6852->3065|6915->3102|6930->3108|7088->3244|7116->3245
                  LINES: 13->1|24->7|25->17|26->18|29->21|29->21|29->21|30->22|32->24|32->24|32->24|32->24|33->25|35->27|35->27|35->27|36->28|36->28|36->28|36->28|36->28|37->29|37->29|37->29|38->30|38->30|38->30|38->30|38->30|39->31|40->32|40->32|40->32|40->32|40->32|40->32|40->32|40->32|40->32|40->32|40->32|40->32|41->33|41->33|41->33|42->34|42->34|42->34|42->34|42->34|42->34|42->34|42->34|42->34|42->34|42->34|42->34|42->34|42->34|42->34|43->35|43->35|43->35|44->36|44->36|44->36|44->36|44->36|44->36|44->36|44->36|44->36|44->36|44->36|44->36|44->36|44->36|44->36|45->37|46->38|46->38|46->38|46->38|47->39|47->39|47->39|47->39|47->39|47->39|47->39|47->39|47->39|47->39|48->40|49->41|50->42|50->42|50->42|50->42|51->43|51->43|52->44|53->45|53->45|53->45|54->46|54->46|54->46|54->46|54->46|54->46|54->46|54->46|54->46|54->46|54->46|54->46|55->47|55->47|55->47|55->47|56->48|57->49|57->49|57->49|58->50|58->50|58->50|58->50|58->50|58->50|58->50|58->50|58->50|58->50|58->50|58->50|59->51|59->51|59->51|59->51|60->52|61->53|62->54|64->56|64->56|64->56|64->56|64->56|64->56|64->56|64->56|65->57|65->57|65->57|65->57|66->58|66->58|66->58|66->58|66->58|66->58|66->58|66->58|67->59|68->60|71->63|72->64|74->66|74->66|74->66|75->67
                  -- GENERATED --
              */
          