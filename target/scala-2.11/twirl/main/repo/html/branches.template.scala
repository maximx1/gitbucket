
package repo.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object branches extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[Seq[scala.Tuple2[String, java.util.Date]],Boolean,service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(branchInfo: Seq[(String, java.util.Date)],
  hasWritePermission: Boolean,
  repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*3.87*/("""
"""),_display_(/*6.2*/html/*6.6*/.main(s"${repository.owner}/${repository.name}", Some(repository))/*6.72*/ {_display_(Seq[Any](format.raw/*6.74*/("""
  """),_display_(/*7.4*/html/*7.8*/.menu("code", repository)/*7.33*/{_display_(Seq[Any](format.raw/*7.34*/("""
    """),format.raw/*8.5*/("""<h1>Branches</h1>
    <table class="table table-bordered">
      <tr>
        <th width="40%">Branch</th>
        <th width="20%">Last update</th>
        <th width="20%">Compare</th>
        <th width="20%">Download</th>
      </tr>
      """),_display_(/*16.8*/branchInfo/*16.18*/.map/*16.22*/ { case (branchName, latestUpdateDate) =>_display_(Seq[Any](format.raw/*16.63*/("""
        """),format.raw/*17.9*/("""<tr>
          <td>
            <a href=""""),_display_(/*19.23*/url(repository)),format.raw/*19.38*/("""/tree/"""),_display_(/*19.45*/encodeRefName(branchName)),format.raw/*19.70*/("""">"""),_display_(/*19.73*/branchName),format.raw/*19.83*/("""</a>
            """),_display_(/*20.14*/if(hasWritePermission && repository.repository.defaultBranch != branchName)/*20.89*/{_display_(Seq[Any](format.raw/*20.90*/("""
              """),format.raw/*21.15*/("""<a href=""""),_display_(/*21.25*/url(repository)),format.raw/*21.40*/("""/delete/"""),_display_(/*21.49*/encodeRefName(branchName)),format.raw/*21.74*/("""" class="btn btn-danger btn-mini pull-right delete-branch" data-name=""""),_display_(/*21.145*/branchName),format.raw/*21.155*/("""">Delete branch</a>
            """)))}),format.raw/*22.14*/("""
          """),format.raw/*23.11*/("""</td>
          <td>
            """),_display_(/*25.14*/helper/*25.20*/.html.datetimeago(latestUpdateDate, false)),format.raw/*25.62*/("""
          """),format.raw/*26.11*/("""</td>
          <td>
            """),_display_(/*28.14*/if(repository.repository.defaultBranch == branchName)/*28.67*/{_display_(Seq[Any](format.raw/*28.68*/("""
              """),format.raw/*29.15*/("""Base branch
            """)))}/*30.15*/else/*30.20*/{_display_(Seq[Any](format.raw/*30.21*/("""
              """),format.raw/*31.15*/("""<a href=""""),_display_(/*31.25*/url(repository)),format.raw/*31.40*/("""/compare/"""),_display_(/*31.50*/{encodeRefName(repository.repository.defaultBranch)}),format.raw/*31.102*/("""..."""),_display_(/*31.106*/{encodeRefName(branchName)}),format.raw/*31.133*/("""">to """),_display_(/*31.139*/{repository.repository.defaultBranch}),format.raw/*31.176*/("""</a>
            """)))}),format.raw/*32.14*/("""
          """),format.raw/*33.11*/("""</td>
          <td>
            <a href=""""),_display_(/*35.23*/url(repository)),format.raw/*35.38*/("""/archive/"""),_display_(/*35.48*/{encodeRefName(branchName)}),format.raw/*35.75*/(""".zip">ZIP</a>
            <a href=""""),_display_(/*36.23*/url(repository)),format.raw/*36.38*/("""/archive/"""),_display_(/*36.48*/{encodeRefName(branchName)}),format.raw/*36.75*/(""".tar.gz">TAR.GZ</a>
          </td>
        </tr>
      """)))}),format.raw/*39.8*/("""
    """),format.raw/*40.5*/("""</table>
  """)))}),format.raw/*41.4*/("""
""")))}),format.raw/*42.2*/("""
"""),format.raw/*43.1*/("""<script>
$(function()"""),format.raw/*44.13*/("""{"""),format.raw/*44.14*/("""
  """),format.raw/*45.3*/("""$('.delete-branch').click(function(e)"""),format.raw/*45.40*/("""{"""),format.raw/*45.41*/("""
    """),format.raw/*46.5*/("""var branchName = $(e.target).data('name');
    return confirm('Are you sure you want to remove the ' + branchName + ' branch?');
  """),format.raw/*48.3*/("""}"""),format.raw/*48.4*/(""");
"""),format.raw/*49.1*/("""}"""),format.raw/*49.2*/(""");
</script>"""))}
  }

  def render(branchInfo:Seq[scala.Tuple2[String, java.util.Date]],hasWritePermission:Boolean,repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(branchInfo,hasWritePermission,repository)(context)

  def f:((Seq[scala.Tuple2[String, java.util.Date]],Boolean,service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (branchInfo,hasWritePermission,repository) => (context) => apply(branchInfo,hasWritePermission,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/repo/branches.scala.html
                  HASH: 151b943540df504aa27fed55df29e1334bd9cab9
                  MATRIX: 441->1|728->162|755->205|766->209|840->275|879->277|908->281|919->285|952->310|990->311|1021->316|1288->557|1307->567|1320->571|1399->612|1435->621|1504->663|1540->678|1574->685|1620->710|1650->713|1681->723|1726->741|1810->816|1849->817|1892->832|1929->842|1965->857|2001->866|2047->891|2146->962|2178->972|2242->1005|2281->1016|2342->1050|2357->1056|2420->1098|2459->1109|2520->1143|2582->1196|2621->1197|2664->1212|2708->1238|2721->1243|2760->1244|2803->1259|2840->1269|2876->1284|2913->1294|2987->1346|3019->1350|3068->1377|3102->1383|3161->1420|3210->1438|3249->1449|3319->1492|3355->1507|3392->1517|3440->1544|3503->1580|3539->1595|3576->1605|3624->1632|3711->1689|3743->1694|3785->1706|3817->1708|3845->1709|3894->1730|3923->1731|3953->1734|4018->1771|4047->1772|4079->1777|4237->1908|4265->1909|4295->1912|4323->1913
                  LINES: 13->1|19->3|20->6|20->6|20->6|20->6|21->7|21->7|21->7|21->7|22->8|30->16|30->16|30->16|30->16|31->17|33->19|33->19|33->19|33->19|33->19|33->19|34->20|34->20|34->20|35->21|35->21|35->21|35->21|35->21|35->21|35->21|36->22|37->23|39->25|39->25|39->25|40->26|42->28|42->28|42->28|43->29|44->30|44->30|44->30|45->31|45->31|45->31|45->31|45->31|45->31|45->31|45->31|45->31|46->32|47->33|49->35|49->35|49->35|49->35|50->36|50->36|50->36|50->36|53->39|54->40|55->41|56->42|57->43|58->44|58->44|59->45|59->45|59->45|60->46|62->48|62->48|63->49|63->49
                  -- GENERATED --
              */
          