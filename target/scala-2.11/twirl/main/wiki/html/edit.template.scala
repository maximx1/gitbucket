
package wiki.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object edit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,Option[service.WikiService.WikiPageInfo],service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(pageName: String,
  page: Option[service.WikiService.WikiPageInfo],
  repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*3.87*/("""
"""),_display_(/*6.2*/html/*6.6*/.main(s"${if(pageName.isEmpty) "New Page" else pageName} - ${repository.owner}/${repository.name}", Some(repository))/*6.123*/{_display_(Seq[Any](format.raw/*6.124*/("""
  """),_display_(/*7.4*/html/*7.8*/.menu("wiki", repository)/*7.33*/{_display_(Seq[Any](format.raw/*7.34*/("""
    """),format.raw/*8.5*/("""<ul class="nav nav-tabs fill-width pull-left">
      <li>
        <h1 class="wiki-title"><span class="muted">Editing</span> """),_display_(/*10.68*/if(pageName.isEmpty)/*10.88*/{_display_(Seq[Any](format.raw/*10.89*/("""New Page""")))}/*10.99*/else/*10.104*/{_display_(_display_(/*10.106*/pageName))}),format.raw/*10.115*/("""</h1>
      </li>
      <li class="pull-right">
        <div>
          """),_display_(/*14.12*/if(page.isDefined)/*14.30*/{_display_(Seq[Any](format.raw/*14.31*/("""
            """),format.raw/*15.13*/("""<a class="btn btn-small" href=""""),_display_(/*15.45*/url(repository)),format.raw/*15.60*/("""/wiki/"""),_display_(/*15.67*/urlEncode(pageName)),format.raw/*15.86*/("""/_delete" id="delete">Delete Page</a>
            <a class="btn btn-small" href=""""),_display_(/*16.45*/url(repository)),format.raw/*16.60*/("""/wiki/"""),_display_(/*16.67*/urlEncode(pageName)),format.raw/*16.86*/("""/_history">Page History</a>
          """)))}),format.raw/*17.12*/("""
          """),format.raw/*18.11*/("""<a class="btn btn-small btn-success" href=""""),_display_(/*18.55*/url(repository)),format.raw/*18.70*/("""/wiki/_new">New Page</a>
        </div>
      </li>
    </ul>
    <form action=""""),_display_(/*22.20*/url(repository)),format.raw/*22.35*/("""/wiki/"""),_display_(/*22.42*/if(page.isEmpty)/*22.58*/{_display_(Seq[Any](format.raw/*22.59*/("""_new""")))}/*22.65*/else/*22.70*/{_display_(Seq[Any](format.raw/*22.71*/("""_edit""")))}),format.raw/*22.77*/("""" method="POST" validate="true">
      <span id="error-pageName" class="error"></span>
      <input type="text" name="pageName" value=""""),_display_(/*24.50*/pageName),format.raw/*24.58*/("""" style="width: 850px; font-weight: bold;" placeholder="Input a page name."/>
      """),_display_(/*25.8*/helper/*25.14*/.html.preview(repository, page.map(_.content).getOrElse(""), true, false, false, false, "width: 850px; height: 400px;", "")),format.raw/*25.137*/("""
      """),format.raw/*26.7*/("""<input type="text" name="message" value="" style="width: 850px;" placeholder="Write a small message here explaining this change. (Optional)"/>
      <input type="hidden" name="currentPageName" value=""""),_display_(/*27.59*/pageName),format.raw/*27.67*/(""""/>
      <input type="hidden" name="id" value=""""),_display_(/*28.46*/page/*28.50*/.map(_.id)),format.raw/*28.60*/(""""/>
      <input type="submit" value="Save" class="btn btn-success">
    </form>
  """)))}),format.raw/*31.4*/("""
""")))}),format.raw/*32.2*/("""
"""),format.raw/*33.1*/("""<script>
$(function()"""),format.raw/*34.13*/("""{"""),format.raw/*34.14*/("""
  """),format.raw/*35.3*/("""$('#delete').click(function()"""),format.raw/*35.32*/("""{"""),format.raw/*35.33*/("""
    """),format.raw/*36.5*/("""return confirm('Are you sure you want to delete this page?'); 
  """),format.raw/*37.3*/("""}"""),format.raw/*37.4*/(""");
"""),format.raw/*38.1*/("""}"""),format.raw/*38.2*/(""");
</script>
"""))}
  }

  def render(pageName:String,page:Option[service.WikiService.WikiPageInfo],repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(pageName,page,repository)(context)

  def f:((String,Option[service.WikiService.WikiPageInfo],service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (pageName,page,repository) => (context) => apply(pageName,page,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/wiki/edit.scala.html
                  HASH: edfd49a51dc0e02004b6814a7a07daf4f35664d0
                  MATRIX: 435->1|716->156|743->199|754->203|880->320|919->321|948->325|959->329|992->354|1030->355|1061->360|1213->485|1242->505|1281->506|1309->516|1323->521|1354->523|1387->532|1487->605|1514->623|1553->624|1594->637|1653->669|1689->684|1723->691|1763->710|1872->792|1908->807|1942->814|1982->833|2052->872|2091->883|2162->927|2198->942|2306->1023|2342->1038|2376->1045|2401->1061|2440->1062|2464->1068|2477->1073|2516->1074|2553->1080|2716->1216|2745->1224|2856->1309|2871->1315|3016->1438|3050->1445|3278->1646|3307->1654|3383->1703|3396->1707|3427->1717|3541->1801|3573->1803|3601->1804|3650->1825|3679->1826|3709->1829|3766->1858|3795->1859|3827->1864|3919->1929|3947->1930|3977->1933|4005->1934
                  LINES: 13->1|19->3|20->6|20->6|20->6|20->6|21->7|21->7|21->7|21->7|22->8|24->10|24->10|24->10|24->10|24->10|24->10|24->10|28->14|28->14|28->14|29->15|29->15|29->15|29->15|29->15|30->16|30->16|30->16|30->16|31->17|32->18|32->18|32->18|36->22|36->22|36->22|36->22|36->22|36->22|36->22|36->22|36->22|38->24|38->24|39->25|39->25|39->25|40->26|41->27|41->27|42->28|42->28|42->28|45->31|46->32|47->33|48->34|48->34|49->35|49->35|49->35|50->36|51->37|51->37|52->38|52->38
                  -- GENERATED --
              */
          