
package dashboard.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object header extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Int,Int,service.IssuesService.IssueSearchCondition,List[String],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(openCount: Int,
  closedCount: Int,
  condition: service.IssuesService.IssueSearchCondition,
  groups: List[String])(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*4.55*/("""
"""),format.raw/*7.1*/("""<span class="small">
  <a class="button-link"""),_display_(/*8.25*/if(condition.state == "open")/*8.54*/{_display_(Seq[Any](format.raw/*8.55*/(""" """),format.raw/*8.56*/("""selected""")))}),format.raw/*8.65*/("""" href=""""),_display_(/*8.74*/condition/*8.83*/.copy(state = "open").toURL),format.raw/*8.110*/("""">
    <img src=""""),_display_(/*9.16*/assets),format.raw/*9.22*/("""/common/images/status-open"""),_display_(/*9.49*/(if(condition.state == "open"){"-active"})),format.raw/*9.91*/(""".png"/>
    """),_display_(/*10.6*/openCount),format.raw/*10.15*/(""" """),format.raw/*10.16*/("""Open
  </a>&nbsp;&nbsp;
  <a class="button-link"""),_display_(/*12.25*/if(condition.state == "closed")/*12.56*/{_display_(Seq[Any](format.raw/*12.57*/(""" """),format.raw/*12.58*/("""selected""")))}),format.raw/*12.67*/("""" href=""""),_display_(/*12.76*/condition/*12.85*/.copy(state = "closed").toURL),format.raw/*12.114*/("""">
    <img src=""""),_display_(/*13.16*/assets),format.raw/*13.22*/("""/common/images/status-closed"""),_display_(/*13.51*/(if(condition.state == "closed"){"-active"})),format.raw/*13.95*/(""".png"/>
    """),_display_(/*14.6*/closedCount),format.raw/*14.17*/(""" """),format.raw/*14.18*/("""Closed
  </a>
</span>
<div class="pull-right" id="table-issues-control">
  """),_display_(/*18.4*/helper/*18.10*/.html.dropdown("Visibility", flat = true)/*18.51*/{_display_(Seq[Any](format.raw/*18.52*/("""
    """),format.raw/*19.5*/("""<li>
      <a href=""""),_display_(/*20.17*/(condition.copy(visibility = (if(condition.visibility == Some("private")) None else Some("private"))).toURL)),format.raw/*20.125*/("""">
        """),_display_(/*21.10*/helper/*21.16*/.html.checkicon(condition.visibility == Some("private"))),format.raw/*21.72*/("""
        """),format.raw/*22.9*/("""Private repository only
      </a>
    </li>
    <li>
      <a href=""""),_display_(/*26.17*/(condition.copy(visibility = (if(condition.visibility == Some("public")) None else Some("public"))).toURL)),format.raw/*26.123*/("""">
        """),_display_(/*27.10*/helper/*27.16*/.html.checkicon(condition.visibility == Some("public"))),format.raw/*27.71*/("""
        """),format.raw/*28.9*/("""Public repository only
      </a>
    </li>
  """)))}),format.raw/*31.4*/("""
  """),_display_(/*32.4*/helper/*32.10*/.html.dropdown("Organization", flat = true)/*32.53*/{_display_(Seq[Any](format.raw/*32.54*/("""
    """),_display_(/*33.6*/groups/*33.12*/.map/*33.16*/ { group =>_display_(Seq[Any](format.raw/*33.27*/("""
      """),format.raw/*34.7*/("""<li>
        <a href=""""),_display_(/*35.19*/((if(condition.groups.contains(group)) condition.copy(groups = condition.groups - group) else condition.copy(groups = condition.groups + group)).toURL)),format.raw/*35.170*/("""">
          """),_display_(/*36.12*/helper/*36.18*/.html.checkicon(condition.groups.contains(group))),format.raw/*36.67*/("""
          """),_display_(/*37.12*/avatar(group, 20)),format.raw/*37.29*/(""" """),_display_(/*37.31*/group),format.raw/*37.36*/("""
        """),format.raw/*38.9*/("""</a>
      </li>
    """)))}),format.raw/*40.6*/("""
  """)))}),format.raw/*41.4*/("""
  """),_display_(/*42.4*/helper/*42.10*/.html.dropdown("Sort", flat = true)/*42.45*/{_display_(Seq[Any](format.raw/*42.46*/("""
    """),format.raw/*43.5*/("""<li>
      <a href=""""),_display_(/*44.17*/condition/*44.26*/.copy(sort="created",  direction="desc").toURL),format.raw/*44.72*/("""">
        """),_display_(/*45.10*/helper/*45.16*/.html.checkicon(condition.sort == "created"  && condition.direction == "desc")),format.raw/*45.94*/(""" """),format.raw/*45.95*/("""Newest
      </a>
    </li>
    <li>
      <a href=""""),_display_(/*49.17*/condition/*49.26*/.copy(sort="created",  direction="asc" ).toURL),format.raw/*49.72*/("""">
        """),_display_(/*50.10*/helper/*50.16*/.html.checkicon(condition.sort == "created"  && condition.direction == "asc")),format.raw/*50.93*/(""" """),format.raw/*50.94*/("""Oldest
      </a>
    </li>
    <li>
      <a href=""""),_display_(/*54.17*/condition/*54.26*/.copy(sort="comments", direction="desc").toURL),format.raw/*54.72*/("""">
       """),_display_(/*55.9*/helper/*55.15*/.html.checkicon(condition.sort == "comments"  && condition.direction == "desc")),format.raw/*55.94*/(""" """),format.raw/*55.95*/("""Most commented
      </a>
    </li>
    <li>
      <a href=""""),_display_(/*59.17*/condition/*59.26*/.copy(sort="comments", direction="asc" ).toURL),format.raw/*59.72*/("""">
        """),_display_(/*60.10*/helper/*60.16*/.html.checkicon(condition.sort == "comments"  && condition.direction == "asc")),format.raw/*60.94*/(""" """),format.raw/*60.95*/("""Least commented
      </a>
    </li>
    <li>
      <a href=""""),_display_(/*64.17*/condition/*64.26*/.copy(sort="updated",  direction="desc").toURL),format.raw/*64.72*/("""">
        """),_display_(/*65.10*/helper/*65.16*/.html.checkicon(condition.sort == "updated"  && condition.direction == "desc")),format.raw/*65.94*/(""" """),format.raw/*65.95*/("""Recently updated
      </a>
    </li>
    <li>
      <a href=""""),_display_(/*69.17*/condition/*69.26*/.copy(sort="updated",  direction="asc" ).toURL),format.raw/*69.72*/("""">
        """),_display_(/*70.10*/helper/*70.16*/.html.checkicon(condition.sort == "updated"  && condition.direction == "asc")),format.raw/*70.93*/(""" """),format.raw/*70.94*/("""Least recently updated
      </a>
    </li>
  """)))}),format.raw/*73.4*/("""
"""),format.raw/*74.1*/("""</div>"""))}
  }

  def render(openCount:Int,closedCount:Int,condition:service.IssuesService.IssueSearchCondition,groups:List[String],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(openCount,closedCount,condition,groups)(context)

  def f:((Int,Int,service.IssuesService.IssueSearchCondition,List[String]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (openCount,closedCount,condition,groups) => (context) => apply(openCount,closedCount,condition,groups)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/dashboard/header.scala.html
                  HASH: 7db38a7fc65d2b6410b036fdd3c04f93c67bff57
                  MATRIX: 417->1|691->149|718->191|789->236|826->265|864->266|892->267|931->276|966->285|983->294|1031->321|1075->339|1101->345|1154->372|1216->414|1255->427|1285->436|1314->437|1389->485|1429->516|1468->517|1497->518|1537->527|1573->536|1591->545|1642->574|1687->592|1714->598|1770->627|1835->671|1874->684|1906->695|1935->696|2037->772|2052->778|2102->819|2141->820|2173->825|2221->846|2351->954|2390->966|2405->972|2482->1028|2518->1037|2615->1107|2743->1213|2782->1225|2797->1231|2873->1286|2909->1295|2986->1342|3016->1346|3031->1352|3083->1395|3122->1396|3154->1402|3169->1408|3182->1412|3231->1423|3265->1430|3315->1453|3488->1604|3529->1618|3544->1624|3614->1673|3653->1685|3691->1702|3720->1704|3746->1709|3782->1718|3834->1740|3868->1744|3898->1748|3913->1754|3957->1789|3996->1790|4028->1795|4076->1816|4094->1825|4161->1871|4200->1883|4215->1889|4314->1967|4343->1968|4423->2021|4441->2030|4508->2076|4547->2088|4562->2094|4660->2171|4689->2172|4769->2225|4787->2234|4854->2280|4891->2291|4906->2297|5006->2376|5035->2377|5123->2438|5141->2447|5208->2493|5247->2505|5262->2511|5361->2589|5390->2590|5479->2652|5497->2661|5564->2707|5603->2719|5618->2725|5717->2803|5746->2804|5836->2867|5854->2876|5921->2922|5960->2934|5975->2940|6073->3017|6102->3018|6179->3065|6207->3066
                  LINES: 13->1|20->4|21->7|22->8|22->8|22->8|22->8|22->8|22->8|22->8|22->8|23->9|23->9|23->9|23->9|24->10|24->10|24->10|26->12|26->12|26->12|26->12|26->12|26->12|26->12|26->12|27->13|27->13|27->13|27->13|28->14|28->14|28->14|32->18|32->18|32->18|32->18|33->19|34->20|34->20|35->21|35->21|35->21|36->22|40->26|40->26|41->27|41->27|41->27|42->28|45->31|46->32|46->32|46->32|46->32|47->33|47->33|47->33|47->33|48->34|49->35|49->35|50->36|50->36|50->36|51->37|51->37|51->37|51->37|52->38|54->40|55->41|56->42|56->42|56->42|56->42|57->43|58->44|58->44|58->44|59->45|59->45|59->45|59->45|63->49|63->49|63->49|64->50|64->50|64->50|64->50|68->54|68->54|68->54|69->55|69->55|69->55|69->55|73->59|73->59|73->59|74->60|74->60|74->60|74->60|78->64|78->64|78->64|79->65|79->65|79->65|79->65|83->69|83->69|83->69|84->70|84->70|84->70|84->70|87->73|88->74
                  -- GENERATED --
              */
          