
package search.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object code extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[List[service.RepositorySearchService.FileSearchResult],Int,String,Int,service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(files: List[service.RepositorySearchService.FileSearchResult],
  issueCount: Int,
  query: String,
  page: Int,
  repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._
import service.RepositorySearchService._

Seq[Any](format.raw/*5.87*/("""
"""),_display_(/*9.2*/html/*9.6*/.main("Search Results", Some(repository))/*9.47*/{_display_(Seq[Any](format.raw/*9.48*/("""
  """),_display_(/*10.4*/menu("code", files.size, issueCount, query, repository)/*10.59*/{_display_(Seq[Any](format.raw/*10.60*/("""
    """),_display_(/*11.6*/if(files.isEmpty)/*11.23*/{_display_(Seq[Any](format.raw/*11.24*/("""
      """),format.raw/*12.7*/("""<h4>We couldn't find any code matching '"""),_display_(/*12.48*/query),format.raw/*12.53*/("""'</h4>
    """)))}/*13.7*/else/*13.12*/{_display_(Seq[Any](format.raw/*13.13*/("""
      """),format.raw/*14.7*/("""<h4>We've found """),_display_(/*14.24*/files/*14.29*/.size),format.raw/*14.34*/(""" """),format.raw/*14.35*/("""code """),_display_(/*14.41*/plural(files.size, "result")),format.raw/*14.69*/("""</h4>
    """)))}),format.raw/*15.6*/("""
    """),_display_(/*16.6*/files/*16.11*/.drop((page - 1) * CodeLimit).take(CodeLimit).map/*16.60*/ { file =>_display_(Seq[Any](format.raw/*16.70*/("""
      """),format.raw/*17.7*/("""<div>
        <h5><a href=""""),_display_(/*18.23*/url(repository)),format.raw/*18.38*/("""/blob/"""),_display_(/*18.45*/repository/*18.55*/.repository.defaultBranch),format.raw/*18.80*/("""/"""),_display_(/*18.82*/file/*18.86*/.path),format.raw/*18.91*/("""">"""),_display_(/*18.94*/file/*18.98*/.path),format.raw/*18.103*/("""</a></h5>
        <div class="small muted">Last commited """),_display_(/*19.49*/helper/*19.55*/.html.datetimeago(file.lastModified)),format.raw/*19.91*/("""</div>
        <pre class="prettyprint linenums:"""),_display_(/*20.43*/file/*20.47*/.highlightLineNumber),format.raw/*20.67*/("""" style="padding-left: 25px;">"""),_display_(/*20.98*/Html(file.highlightText)),format.raw/*20.122*/("""</pre>
      </div>
    """)))}),format.raw/*22.6*/("""
    """),_display_(/*23.6*/helper/*23.12*/.html.paginator(page, files.size, CodeLimit, 10,
      s"${url(repository)}/search?q=${urlEncode(query)}&type=code")),format.raw/*24.68*/("""
  """)))}),format.raw/*25.4*/("""
""")))}))}
  }

  def render(files:List[service.RepositorySearchService.FileSearchResult],issueCount:Int,query:String,page:Int,repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(files,issueCount,query,page,repository)(context)

  def f:((List[service.RepositorySearchService.FileSearchResult],Int,String,Int,service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (files,issueCount,query,page,repository) => (context) => apply(files,issueCount,query,page,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/search/code.scala.html
                  HASH: 16fb58caebf56f7172acf8ec49292f6dec4104ca
                  MATRIX: 459->1|825->200|852->285|863->289|912->330|950->331|980->335|1044->390|1083->391|1115->397|1141->414|1180->415|1214->422|1282->463|1308->468|1338->481|1351->486|1390->487|1424->494|1468->511|1482->516|1508->521|1537->522|1570->528|1619->556|1660->567|1692->573|1706->578|1764->627|1812->637|1846->644|1901->672|1937->687|1971->694|1990->704|2036->729|2065->731|2078->735|2104->740|2134->743|2147->747|2174->752|2259->810|2274->816|2331->852|2407->901|2420->905|2461->925|2519->956|2565->980|2620->1005|2652->1011|2667->1017|2804->1133|2838->1137
                  LINES: 13->1|22->5|23->9|23->9|23->9|23->9|24->10|24->10|24->10|25->11|25->11|25->11|26->12|26->12|26->12|27->13|27->13|27->13|28->14|28->14|28->14|28->14|28->14|28->14|28->14|29->15|30->16|30->16|30->16|30->16|31->17|32->18|32->18|32->18|32->18|32->18|32->18|32->18|32->18|32->18|32->18|32->18|33->19|33->19|33->19|34->20|34->20|34->20|34->20|34->20|36->22|37->23|37->23|38->24|39->25
                  -- GENERATED --
              */
          