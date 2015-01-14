
package wiki.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object page extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[String,service.WikiService.WikiPageInfo,List[String],service.RepositoryService.RepositoryInfo,Boolean,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(pageName: String,
  page: service.WikiService.WikiPageInfo,
  pages: List[String],
  repository: service.RepositoryService.RepositoryInfo,
  hasWritePermission: Boolean)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import service.WikiService._
import view.helpers._

Seq[Any](format.raw/*5.62*/("""
"""),_display_(/*9.2*/html/*9.6*/.main(s"${pageName} - ${repository.owner}/${repository.name}", Some(repository))/*9.86*/{_display_(Seq[Any](format.raw/*9.87*/("""
  """),_display_(/*10.4*/html/*10.8*/.menu("wiki", repository)/*10.33*/{_display_(Seq[Any](format.raw/*10.34*/("""
    """),format.raw/*11.5*/("""<ul class="nav nav-tabs fill-width pull-left">
      <li>
        <h1 class="wiki-title">"""),_display_(/*13.33*/pageName),format.raw/*13.41*/("""</h1>
        <div class="small">
          <span class="muted"><strong>"""),_display_(/*15.40*/page/*15.44*/.committer),format.raw/*15.54*/("""</strong> edited this page """),_display_(/*15.82*/helper/*15.88*/.html.datetimeago(page.time)),format.raw/*15.116*/("""</span>
        </div>
      </li>
      <li class="pull-right">
        """),_display_(/*19.10*/if(hasWritePermission)/*19.32*/{_display_(Seq[Any](format.raw/*19.33*/("""
          """),format.raw/*20.11*/("""<div>
            <a class="btn btn-small" href=""""),_display_(/*21.45*/url(repository)),format.raw/*21.60*/("""/wiki/"""),_display_(/*21.67*/urlEncode(pageName)),format.raw/*21.86*/("""/_edit">Edit Page</a>
            <a class="btn btn-small btn-success" href=""""),_display_(/*22.57*/url(repository)),format.raw/*22.72*/("""/wiki/_new">New Page</a>
          </div>
        """)))}),format.raw/*24.10*/("""
      """),format.raw/*25.7*/("""</li>
    </ul>
    <div style="width: 200px;" class="pull-right">
      <table class="table table-bordered">
        <tr>
          <th class="metal">Pages <span class="label">"""),_display_(/*30.56*/pages/*30.61*/.length),format.raw/*30.68*/("""</span></th>
        </tr>
        <tr>
          <td>
            <ul style="margin-left: 0px; margin-bottom: 0px; word-break: break-all; width: 182px;">
            """),_display_(/*35.14*/pages/*35.19*/.map/*35.23*/ { page =>_display_(Seq[Any](format.raw/*35.33*/("""
              """),format.raw/*36.15*/("""<li style="margin-left:0px; list-style-type: none;"><a href=""""),_display_(/*36.77*/url(repository)),format.raw/*36.92*/("""/wiki/"""),_display_(/*36.99*/urlEncode(page)),format.raw/*36.114*/("""">"""),_display_(/*36.117*/page),format.raw/*36.121*/("""</a></li>
            """)))}),format.raw/*37.14*/("""
            """),format.raw/*38.13*/("""</ul>
          </td>
        </tr>
      </table>
      <div class="small">
        <strong>Clone this wiki locally</strong>
      </div>
      """),_display_(/*45.8*/helper/*45.14*/.html.copy("repository-url-copy", httpUrl(repository))/*45.68*/{_display_(Seq[Any](format.raw/*45.69*/("""
        """),format.raw/*46.9*/("""<input type="text" value=""""),_display_(/*46.36*/httpUrl(repository)),format.raw/*46.55*/("""" id="repository-url" style="width: 160px;" readonly>
      """)))}),format.raw/*47.8*/("""
      """),_display_(/*48.8*/if(settings.ssh && loginAccount.isDefined)/*48.50*/{_display_(Seq[Any](format.raw/*48.51*/("""
        """),format.raw/*49.9*/("""<div class="small">
          <span class="mute">You can clone <a href="javascript:void(0);" id="repository-url-http">HTTP</a> or <a href="javascript:void(0);" id="repository-url-ssh">SSH</a>.</span>
        </div>
      """)))}),format.raw/*52.8*/("""
    """),format.raw/*53.5*/("""</div>
    <div style="width: 650px;" class="pull-left">
      <div class="markdown-body">
        """),_display_(/*56.10*/markdown(page.content, repository, true, false)),format.raw/*56.57*/("""
      """),format.raw/*57.7*/("""</div>
    </div>
  """)))}),format.raw/*59.4*/("""
""")))}),format.raw/*60.2*/("""
"""),_display_(/*61.2*/if(settings.ssh && loginAccount.isDefined)/*61.44*/{_display_(Seq[Any](format.raw/*61.45*/("""
  """),format.raw/*62.3*/("""<script>
  $(function()"""),format.raw/*63.15*/("""{"""),format.raw/*63.16*/("""
    """),format.raw/*64.5*/("""$('#repository-url-http').click(function()"""),format.raw/*64.47*/("""{"""),format.raw/*64.48*/("""
      """),format.raw/*65.7*/("""$('#repository-url').val('"""),_display_(/*65.34*/httpUrl(repository)),format.raw/*65.53*/("""');
      $('#repository-url-copy').attr('data-clipboard-text', $('#repository-url').val());
    """),format.raw/*67.5*/("""}"""),format.raw/*67.6*/(""");
    $('#repository-url-ssh').click(function()"""),format.raw/*68.46*/("""{"""),format.raw/*68.47*/("""
      """),format.raw/*69.7*/("""$('#repository-url').val('"""),_display_(/*69.34*/sshUrl(repository, settings, loginAccount.get.userName)),format.raw/*69.89*/("""');
      $('#repository-url-copy').attr('data-clipboard-text', $('#repository-url').val());
    """),format.raw/*71.5*/("""}"""),format.raw/*71.6*/(""");
  """),format.raw/*72.3*/("""}"""),format.raw/*72.4*/(""");
  </script>
""")))}))}
  }

  def render(pageName:String,page:service.WikiService.WikiPageInfo,pages:List[String],repository:service.RepositoryService.RepositoryInfo,hasWritePermission:Boolean,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(pageName,page,pages,repository,hasWritePermission)(context)

  def f:((String,service.WikiService.WikiPageInfo,List[String],service.RepositoryService.RepositoryInfo,Boolean) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (pageName,page,pages,repository,hasWritePermission) => (context) => apply(pageName,page,pages,repository,hasWritePermission)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/wiki/page.scala.html
                  HASH: 7e5f7ebbf68fdd0ac58bb169562c3c9039e7bbc5
                  MATRIX: 448->1|804->202|831->275|842->279|930->359|968->360|998->364|1010->368|1044->393|1083->394|1115->399|1232->489|1261->497|1361->570|1374->574|1405->584|1460->612|1475->618|1525->646|1626->720|1657->742|1696->743|1735->754|1812->804|1848->819|1882->826|1922->845|2027->923|2063->938|2145->989|2179->996|2384->1174|2398->1179|2426->1186|2621->1354|2635->1359|2648->1363|2696->1373|2739->1388|2828->1450|2864->1465|2898->1472|2935->1487|2966->1490|2992->1494|3046->1517|3087->1530|3259->1676|3274->1682|3337->1736|3376->1737|3412->1746|3466->1773|3506->1792|3597->1853|3631->1861|3682->1903|3721->1904|3757->1913|4009->2135|4041->2140|4168->2240|4236->2287|4270->2294|4321->2315|4353->2317|4381->2319|4432->2361|4471->2362|4501->2365|4552->2388|4581->2389|4613->2394|4683->2436|4712->2437|4746->2444|4800->2471|4840->2490|4964->2587|4992->2588|5068->2636|5097->2637|5131->2644|5185->2671|5261->2726|5385->2823|5413->2824|5445->2829|5473->2830
                  LINES: 13->1|22->5|23->9|23->9|23->9|23->9|24->10|24->10|24->10|24->10|25->11|27->13|27->13|29->15|29->15|29->15|29->15|29->15|29->15|33->19|33->19|33->19|34->20|35->21|35->21|35->21|35->21|36->22|36->22|38->24|39->25|44->30|44->30|44->30|49->35|49->35|49->35|49->35|50->36|50->36|50->36|50->36|50->36|50->36|50->36|51->37|52->38|59->45|59->45|59->45|59->45|60->46|60->46|60->46|61->47|62->48|62->48|62->48|63->49|66->52|67->53|70->56|70->56|71->57|73->59|74->60|75->61|75->61|75->61|76->62|77->63|77->63|78->64|78->64|78->64|79->65|79->65|79->65|81->67|81->67|82->68|82->68|83->69|83->69|83->69|85->71|85->71|86->72|86->72
                  -- GENERATED --
              */
          