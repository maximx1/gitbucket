
package wiki.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object pages extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[List[String],service.RepositoryService.RepositoryInfo,Boolean,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(pages: List[String],
  repository: service.RepositoryService.RepositoryInfo,
  hasWritePermission: Boolean)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*3.62*/("""
"""),_display_(/*6.2*/html/*6.6*/.main(s"Pages - ${repository.owner}/${repository.name}", Some(repository))/*6.80*/{_display_(Seq[Any](format.raw/*6.81*/("""
  """),_display_(/*7.4*/html/*7.8*/.menu("wiki", repository)/*7.33*/{_display_(Seq[Any](format.raw/*7.34*/("""
    """),format.raw/*8.5*/("""<ul class="nav nav-tabs fill-width pull-left">
      <li>
        <h1 class="wiki-title"><span class="muted">Pages</span></h1>
      </li>
      <li class="pull-right">
        <div class="btn-group">
          """),_display_(/*14.12*/if(hasWritePermission)/*14.34*/{_display_(Seq[Any](format.raw/*14.35*/("""
            """),format.raw/*15.13*/("""<a class="btn btn-small" href=""""),_display_(/*15.45*/url(repository)),format.raw/*15.60*/("""/wiki/_new">New Page</a>
          """)))}),format.raw/*16.12*/("""
        """),format.raw/*17.9*/("""</div>
      </li>
    </ul>
    <ul class="pull-left">
      """),_display_(/*21.8*/pages/*21.13*/.map/*21.17*/ { page =>_display_(Seq[Any](format.raw/*21.27*/("""
        """),format.raw/*22.9*/("""<li><a href=""""),_display_(/*22.23*/url(repository)),format.raw/*22.38*/("""/wiki/"""),_display_(/*22.45*/urlEncode(page)),format.raw/*22.60*/("""">"""),_display_(/*22.63*/page),format.raw/*22.67*/("""</a></li>
      """)))}),format.raw/*23.8*/("""
    """),format.raw/*24.5*/("""</ul>
  """)))}),format.raw/*25.4*/("""
""")))}))}
  }

  def render(pages:List[String],repository:service.RepositoryService.RepositoryInfo,hasWritePermission:Boolean,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(pages,repository,hasWritePermission)(context)

  def f:((List[String],service.RepositoryService.RepositoryInfo,Boolean) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (pages,repository,hasWritePermission) => (context) => apply(pages,repository,hasWritePermission)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/wiki/pages.scala.html
                  HASH: 9003bc327f98278fa49b7d6e7dfec79c7b05dee4
                  MATRIX: 409->1|674->140|701->183|712->187|794->261|832->262|861->266|872->270|905->295|943->296|974->301|1213->513|1244->535|1283->536|1324->549|1383->581|1419->596|1486->632|1522->641|1611->704|1625->709|1638->713|1686->723|1722->732|1763->746|1799->761|1833->768|1869->783|1899->786|1924->790|1971->807|2003->812|2042->821
                  LINES: 13->1|19->3|20->6|20->6|20->6|20->6|21->7|21->7|21->7|21->7|22->8|28->14|28->14|28->14|29->15|29->15|29->15|30->16|31->17|35->21|35->21|35->21|35->21|36->22|36->22|36->22|36->22|36->22|36->22|36->22|37->23|38->24|39->25
                  -- GENERATED --
              */
          