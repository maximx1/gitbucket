
package search.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object issues extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[List[service.RepositorySearchService.IssueSearchResult],Int,String,Int,service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issues: List[service.RepositorySearchService.IssueSearchResult],
  fileCount: Int,
  query: String,
  page: Int,
  repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._
import service.RepositorySearchService._

Seq[Any](format.raw/*5.87*/("""
"""),_display_(/*9.2*/html/*9.6*/.main("Search Results", Some(repository))/*9.47*/{_display_(Seq[Any](format.raw/*9.48*/("""
  """),_display_(/*10.4*/menu("issue", fileCount, issues.size, query, repository)/*10.60*/{_display_(Seq[Any](format.raw/*10.61*/("""
    """),_display_(/*11.6*/if(issues.isEmpty)/*11.24*/{_display_(Seq[Any](format.raw/*11.25*/("""
      """),format.raw/*12.7*/("""<h4>We couldn't find any code matching '"""),_display_(/*12.48*/query),format.raw/*12.53*/("""'</h4>
    """)))}/*13.7*/else/*13.12*/{_display_(Seq[Any](format.raw/*13.13*/("""
      """),format.raw/*14.7*/("""<h4>We've found """),_display_(/*14.24*/issues/*14.30*/.size),format.raw/*14.35*/(""" """),format.raw/*14.36*/("""code """),_display_(/*14.42*/plural(issues.size, "result")),format.raw/*14.71*/("""</h4>
    """)))}),format.raw/*15.6*/("""
    """),_display_(/*16.6*/issues/*16.12*/.drop((page - 1) * IssueLimit).take(IssueLimit).map/*16.63*/ { issue =>_display_(Seq[Any](format.raw/*16.74*/("""
      """),format.raw/*17.7*/("""<div class="block">
        <div class="pull-right muted">#"""),_display_(/*18.41*/issue/*18.46*/.issueId),format.raw/*18.54*/("""</div>
        <h4 style="margin-top: 0px;"><a href=""""),_display_(/*19.48*/url(repository)),format.raw/*19.63*/("""/"""),_display_(/*19.65*/if(issue.isPullRequest)/*19.88*/{_display_(Seq[Any](format.raw/*19.89*/("""pull""")))}/*19.95*/else/*19.100*/{_display_(Seq[Any](format.raw/*19.101*/("""issues""")))}),format.raw/*19.108*/("""/"""),_display_(/*19.110*/issue/*19.115*/.issueId),format.raw/*19.123*/("""">"""),_display_(/*19.126*/issue/*19.131*/.title),format.raw/*19.137*/("""</a></h4>
        """),_display_(/*20.10*/if(issue.highlightText.nonEmpty)/*20.42*/{_display_(Seq[Any](format.raw/*20.43*/("""
          """),format.raw/*21.11*/("""<pre>"""),_display_(/*21.17*/Html(issue.highlightText)),format.raw/*21.42*/("""</pre>
        """)))}),format.raw/*22.10*/("""
        """),format.raw/*23.9*/("""<div class="small muted">
          Opened by <a href=""""),_display_(/*24.31*/url(issue.openedUserName)),format.raw/*24.56*/("""" class="username">"""),_display_(/*24.76*/issue/*24.81*/.openedUserName),format.raw/*24.96*/("""</a>
          """),_display_(/*25.12*/helper/*25.18*/.html.datetimeago(issue.registeredDate)),format.raw/*25.57*/("""
          """),_display_(/*26.12*/if(issue.commentCount > 0)/*26.38*/{_display_(Seq[Any](format.raw/*26.39*/("""
            """),format.raw/*27.13*/("""&nbsp;&nbsp;<i class="icon-comment"></i><span class="strong">"""),_display_(/*27.75*/issue/*27.80*/.commentCount),format.raw/*27.93*/("""</span> """),_display_(/*27.102*/plural(issue.commentCount, "comment")),format.raw/*27.139*/("""
          """)))}),format.raw/*28.12*/("""
        """),format.raw/*29.9*/("""</div>
      </div>
    """)))}),format.raw/*31.6*/("""
    """),_display_(/*32.6*/helper/*32.12*/.html.paginator(page, issues.size, IssueLimit, 10,
      s"${url(repository)}/search?q=${urlEncode(query)}&type=issue")),format.raw/*33.69*/("""
  """)))}),format.raw/*34.4*/("""
""")))}))}
  }

  def render(issues:List[service.RepositorySearchService.IssueSearchResult],fileCount:Int,query:String,page:Int,repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(issues,fileCount,query,page,repository)(context)

  def f:((List[service.RepositorySearchService.IssueSearchResult],Int,String,Int,service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (issues,fileCount,query,page,repository) => (context) => apply(issues,fileCount,query,page,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/search/issues.scala.html
                  HASH: 59d4aae8304edf769193df52571da6e7ab27914e
                  MATRIX: 462->1|829->201|856->286|867->290|916->331|954->332|984->336|1049->392|1088->393|1120->399|1147->417|1186->418|1220->425|1288->466|1314->471|1344->484|1357->489|1396->490|1430->497|1474->514|1489->520|1515->525|1544->526|1577->532|1627->561|1668->572|1700->578|1715->584|1775->635|1824->646|1858->653|1945->713|1959->718|1988->726|2069->780|2105->795|2134->797|2166->820|2205->821|2229->827|2243->832|2283->833|2322->840|2352->842|2367->847|2397->855|2428->858|2443->863|2471->869|2517->888|2558->920|2597->921|2636->932|2669->938|2715->963|2762->979|2798->988|2881->1044|2927->1069|2974->1089|2988->1094|3024->1109|3067->1125|3082->1131|3142->1170|3181->1182|3216->1208|3255->1209|3296->1222|3385->1284|3399->1289|3433->1302|3470->1311|3529->1348|3572->1360|3608->1369|3663->1394|3695->1400|3710->1406|3850->1525|3884->1529
                  LINES: 13->1|22->5|23->9|23->9|23->9|23->9|24->10|24->10|24->10|25->11|25->11|25->11|26->12|26->12|26->12|27->13|27->13|27->13|28->14|28->14|28->14|28->14|28->14|28->14|28->14|29->15|30->16|30->16|30->16|30->16|31->17|32->18|32->18|32->18|33->19|33->19|33->19|33->19|33->19|33->19|33->19|33->19|33->19|33->19|33->19|33->19|33->19|33->19|33->19|34->20|34->20|34->20|35->21|35->21|35->21|36->22|37->23|38->24|38->24|38->24|38->24|38->24|39->25|39->25|39->25|40->26|40->26|40->26|41->27|41->27|41->27|41->27|41->27|41->27|42->28|43->29|45->31|46->32|46->32|47->33|48->34
                  -- GENERATED --
              */
          