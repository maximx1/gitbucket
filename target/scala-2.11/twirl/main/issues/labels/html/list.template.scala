
package issues.labels.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object list extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[List[model.Label],Map[String, Int],service.RepositoryService.RepositoryInfo,Boolean,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(labels: List[model.Label],
  counts: Map[String, Int],
  repository: service.RepositoryService.RepositoryInfo,
  hasWritePermission: Boolean)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*4.62*/("""
"""),_display_(/*7.2*/html/*7.6*/.main(s"Labels - ${repository.owner}/${repository.name}")/*7.63*/{_display_(Seq[Any](format.raw/*7.64*/("""
  """),_display_(/*8.4*/html/*8.8*/.menu("issues", repository)/*8.35*/{_display_(Seq[Any](format.raw/*8.36*/("""
    """),_display_(/*9.6*/issues/*9.12*/.html.navigation("labels", hasWritePermission, repository)),format.raw/*9.70*/("""
    """),format.raw/*10.5*/("""<br>
    <table class="table table-bordered table-hover table-issues" id="new-label-table" style="display: none;">
      <tr><td></td></tr>
    </table>
    <table class="table table-bordered table-hover table-issues">
      <tr id="label-row-header">
        <th style="background-color: #eee;">
          <span class="small">"""),_display_(/*17.32*/labels/*17.38*/.size),format.raw/*17.43*/(""" """),format.raw/*17.44*/("""labels</span>
        </th>
      </tr>
      """),_display_(/*20.8*/labels/*20.14*/.map/*20.18*/ { label =>_display_(Seq[Any](format.raw/*20.29*/("""
        """),_display_(/*21.10*/_root_/*21.16*/.issues.labels.html.label(label, counts, repository, hasWritePermission)),format.raw/*21.88*/("""
      """)))}),format.raw/*22.8*/("""
      """),_display_(/*23.8*/if(labels.isEmpty)/*23.26*/{_display_(Seq[Any](format.raw/*23.27*/("""
        """),format.raw/*24.9*/("""<tr>
          <td style="padding: 20px; background-color: #eee; text-align: center;">
            No labels to show.
            """),_display_(/*27.14*/if(hasWritePermission)/*27.36*/{_display_(Seq[Any](format.raw/*27.37*/("""
              """),format.raw/*28.15*/("""<a href=""""),_display_(/*28.25*/url(repository)),format.raw/*28.40*/("""/issues/labels/new">Create a new label.</a>
            """)))}),format.raw/*29.14*/("""
          """),format.raw/*30.11*/("""</td>
        </tr>
      """)))}),format.raw/*32.8*/("""
    """),format.raw/*33.5*/("""</table>
  """)))}),format.raw/*34.4*/("""
""")))}),format.raw/*35.2*/("""
"""),format.raw/*36.1*/("""<script>
$(function()"""),format.raw/*37.13*/("""{"""),format.raw/*37.14*/("""
  """),format.raw/*38.3*/("""$('#new-label-button').click(function(e)"""),format.raw/*38.43*/("""{"""),format.raw/*38.44*/("""
    """),format.raw/*39.5*/("""if($('#edit-label-area-new').size() != 0)"""),format.raw/*39.46*/("""{"""),format.raw/*39.47*/("""
      """),format.raw/*40.7*/("""$('div#edit-label-area-new').remove();
      $('#new-label-table').hide();
    """),format.raw/*42.5*/("""}"""),format.raw/*42.6*/(""" """),format.raw/*42.7*/("""else """),format.raw/*42.12*/("""{"""),format.raw/*42.13*/("""
      """),format.raw/*43.7*/("""$.get('"""),_display_(/*43.15*/url(repository)),format.raw/*43.30*/("""/issues/labels/new',
        function(data)"""),format.raw/*44.23*/("""{"""),format.raw/*44.24*/("""
          """),format.raw/*45.11*/("""$('#new-label-table').show().find('tr td').append(data);
        """),format.raw/*46.9*/("""}"""),format.raw/*46.10*/("""
      """),format.raw/*47.7*/(""");
    """),format.raw/*48.5*/("""}"""),format.raw/*48.6*/("""
  """),format.raw/*49.3*/("""}"""),format.raw/*49.4*/(""");
"""),format.raw/*50.1*/("""}"""),format.raw/*50.2*/(""");

function deleteLabel(labelId)"""),format.raw/*52.30*/("""{"""),format.raw/*52.31*/("""
  """),format.raw/*53.3*/("""if(confirm('Once you delete this label, there is no going back.\nAre you sure?'))"""),format.raw/*53.84*/("""{"""),format.raw/*53.85*/("""
    """),format.raw/*54.5*/("""$.post('"""),_display_(/*54.14*/url(repository)),format.raw/*54.29*/("""/issues/labels/' + labelId + '/delete', function()"""),format.raw/*54.79*/("""{"""),format.raw/*54.80*/("""
      """),format.raw/*55.7*/("""$('tr#label-row-' + labelId).remove();
    """),format.raw/*56.5*/("""}"""),format.raw/*56.6*/(""");
  """),format.raw/*57.3*/("""}"""),format.raw/*57.4*/("""
"""),format.raw/*58.1*/("""}"""),format.raw/*58.2*/("""

"""),format.raw/*60.1*/("""function editLabel(labelId)"""),format.raw/*60.28*/("""{"""),format.raw/*60.29*/("""
  """),format.raw/*61.3*/("""$.get('"""),_display_(/*61.11*/url(repository)),format.raw/*61.26*/("""/issues/labels/' + labelId + '/edit',
    function(data)"""),format.raw/*62.19*/("""{"""),format.raw/*62.20*/("""
      """),format.raw/*63.7*/("""$('#label-' + labelId).hide().parent().append(data);
    """),format.raw/*64.5*/("""}"""),format.raw/*64.6*/("""
  """),format.raw/*65.3*/(""");
"""),format.raw/*66.1*/("""}"""),format.raw/*66.2*/("""
"""),format.raw/*67.1*/("""</script>
"""))}
  }

  def render(labels:List[model.Label],counts:Map[String, Int],repository:service.RepositoryService.RepositoryInfo,hasWritePermission:Boolean,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(labels,counts,repository,hasWritePermission)(context)

  def f:((List[model.Label],Map[String, Int],service.RepositoryService.RepositoryInfo,Boolean) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (labels,counts,repository,hasWritePermission) => (context) => apply(labels,counts,repository,hasWritePermission)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/issues/labels/list.scala.html
                  HASH: 2bffe9cbeca629e0a5dd2e7a5e89570df4afa60b
                  MATRIX: 439->1|738->174|765->217|776->221|841->278|879->279|908->283|919->287|954->314|992->315|1023->321|1037->327|1115->385|1147->390|1502->718|1517->724|1543->729|1572->730|1645->777|1660->783|1673->787|1722->798|1759->808|1774->814|1867->886|1905->894|1939->902|1966->920|2005->921|2041->930|2199->1061|2230->1083|2269->1084|2312->1099|2349->1109|2385->1124|2473->1181|2512->1192|2569->1219|2601->1224|2643->1236|2675->1238|2703->1239|2752->1260|2781->1261|2811->1264|2879->1304|2908->1305|2940->1310|3009->1351|3038->1352|3072->1359|3178->1438|3206->1439|3234->1440|3267->1445|3296->1446|3330->1453|3365->1461|3401->1476|3472->1519|3501->1520|3540->1531|3632->1596|3661->1597|3695->1604|3729->1611|3757->1612|3787->1615|3815->1616|3845->1619|3873->1620|3934->1653|3963->1654|3993->1657|4102->1738|4131->1739|4163->1744|4199->1753|4235->1768|4313->1818|4342->1819|4376->1826|4446->1869|4474->1870|4506->1875|4534->1876|4562->1877|4590->1878|4619->1880|4674->1907|4703->1908|4733->1911|4768->1919|4804->1934|4888->1990|4917->1991|4951->1998|5035->2055|5063->2056|5093->2059|5123->2062|5151->2063|5179->2064
                  LINES: 13->1|20->4|21->7|21->7|21->7|21->7|22->8|22->8|22->8|22->8|23->9|23->9|23->9|24->10|31->17|31->17|31->17|31->17|34->20|34->20|34->20|34->20|35->21|35->21|35->21|36->22|37->23|37->23|37->23|38->24|41->27|41->27|41->27|42->28|42->28|42->28|43->29|44->30|46->32|47->33|48->34|49->35|50->36|51->37|51->37|52->38|52->38|52->38|53->39|53->39|53->39|54->40|56->42|56->42|56->42|56->42|56->42|57->43|57->43|57->43|58->44|58->44|59->45|60->46|60->46|61->47|62->48|62->48|63->49|63->49|64->50|64->50|66->52|66->52|67->53|67->53|67->53|68->54|68->54|68->54|68->54|68->54|69->55|70->56|70->56|71->57|71->57|72->58|72->58|74->60|74->60|74->60|75->61|75->61|75->61|76->62|76->62|77->63|78->64|78->64|79->65|80->66|80->66|81->67
                  -- GENERATED --
              */
          