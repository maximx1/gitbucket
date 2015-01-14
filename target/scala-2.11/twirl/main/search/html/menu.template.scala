
package search.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object menu extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template7[String,Int,Int,String,service.RepositoryService.RepositoryInfo,Html,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(active: String, fileCount: Int, issueCount: Int, query: String,
  repository: service.RepositoryService.RepositoryInfo)(body: Html)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*2.99*/("""
"""),_display_(/*5.2*/html/*5.6*/.menu("", repository)/*5.27*/{_display_(Seq[Any](format.raw/*5.28*/("""
  """),format.raw/*6.3*/("""<div class="row-fluid">
    <div class="span3">
      <div class="box">
        <ul class="nav nav-tabs nav-stacked side-menu">
          <li"""),_display_(/*10.15*/if(active=="code")/*10.33*/{_display_(Seq[Any](format.raw/*10.34*/(""" """),format.raw/*10.35*/("""class="active"""")))}),format.raw/*10.50*/(""">
            <a href=""""),_display_(/*11.23*/url(repository)),format.raw/*11.38*/("""/search?q="""),_display_(/*11.49*/urlEncode(query)),format.raw/*11.65*/("""&type=code">
              """),_display_(/*12.16*/if(fileCount != 0)/*12.34*/{_display_(Seq[Any](format.raw/*12.35*/("""
                """),format.raw/*13.17*/("""<span class="badge pull-right">"""),_display_(/*13.49*/fileCount),format.raw/*13.58*/("""</span>
              """)))}),format.raw/*14.16*/("""
              """),format.raw/*15.15*/("""Code
            </a>
          </li>
          <li"""),_display_(/*18.15*/if(active=="issue")/*18.34*/{_display_(Seq[Any](format.raw/*18.35*/(""" """),format.raw/*18.36*/("""class="active"""")))}),format.raw/*18.51*/(""">
            <a href=""""),_display_(/*19.23*/url(repository)),format.raw/*19.38*/("""/search?q="""),_display_(/*19.49*/urlEncode(query)),format.raw/*19.65*/("""&type=issue">
              """),_display_(/*20.16*/if(issueCount != 0)/*20.35*/{_display_(Seq[Any](format.raw/*20.36*/("""
                """),format.raw/*21.17*/("""<span class="badge pull-right">"""),_display_(/*21.49*/issueCount),format.raw/*21.59*/("""</span>
              """)))}),format.raw/*22.16*/("""
              """),format.raw/*23.15*/("""Issue
            </a>
          </li>
        </ul>
      </div>
    </div>
    <div class="span9">
      <form action=""""),_display_(/*30.22*/url(repository)),format.raw/*30.37*/("""/search" method="GET">
        <input type="text" name="q" value=""""),_display_(/*31.45*/query),format.raw/*31.50*/("""" style="width: 80%; margin-bottom: 0px;"/>
        <input type="submit" value="Search" class="btn" style="width: 15%;"/>
        <input type="hidden" name="type" value=""""),_display_(/*33.50*/active),format.raw/*33.56*/(""""/>
      </form>
      """),_display_(/*35.8*/body),format.raw/*35.12*/("""
    """),format.raw/*36.5*/("""</div>
  </div>
""")))}))}
  }

  def render(active:String,fileCount:Int,issueCount:Int,query:String,repository:service.RepositoryService.RepositoryInfo,body:Html,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(active,fileCount,issueCount,query,repository)(body)(context)

  def f:((String,Int,Int,String,service.RepositoryService.RepositoryInfo) => (Html) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (active,fileCount,issueCount,query,repository) => (body) => (context) => apply(active,fileCount,issueCount,query,repository)(body)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/search/menu.scala.html
                  HASH: 884334447df4b71dec4b18a0d6acd82e12dee59f
                  MATRIX: 416->1|705->164|732->207|743->211|772->232|810->233|839->236|1008->378|1035->396|1074->397|1103->398|1149->413|1200->437|1236->452|1274->463|1311->479|1366->507|1393->525|1432->526|1477->543|1536->575|1566->584|1620->607|1663->622|1742->674|1770->693|1809->694|1838->695|1884->710|1935->734|1971->749|2009->760|2046->776|2102->805|2130->824|2169->825|2214->842|2273->874|2304->884|2358->907|2401->922|2550->1044|2586->1059|2680->1126|2706->1131|2904->1302|2931->1308|2982->1333|3007->1337|3039->1342
                  LINES: 13->1|18->2|19->5|19->5|19->5|19->5|20->6|24->10|24->10|24->10|24->10|24->10|25->11|25->11|25->11|25->11|26->12|26->12|26->12|27->13|27->13|27->13|28->14|29->15|32->18|32->18|32->18|32->18|32->18|33->19|33->19|33->19|33->19|34->20|34->20|34->20|35->21|35->21|35->21|36->22|37->23|44->30|44->30|45->31|45->31|47->33|47->33|49->35|49->35|50->36
                  -- GENERATED --
              */
          