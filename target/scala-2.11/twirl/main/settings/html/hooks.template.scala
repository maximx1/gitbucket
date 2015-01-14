
package settings.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object hooks extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[List[model.WebHook],Option[Any],service.RepositoryService.RepositoryInfo,Option[Any],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(webHooks: List[model.WebHook],
  enteredUrl: Option[Any],
  repository: service.RepositoryService.RepositoryInfo,
  info: Option[Any])(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*4.52*/("""
"""),_display_(/*7.2*/html/*7.6*/.main("Settings", Some(repository))/*7.41*/{_display_(Seq[Any](format.raw/*7.42*/("""
  """),_display_(/*8.4*/html/*8.8*/.menu("settings", repository)/*8.37*/{_display_(Seq[Any](format.raw/*8.38*/("""
    """),_display_(/*9.6*/menu("hooks", repository)/*9.31*/{_display_(Seq[Any](format.raw/*9.32*/("""
      """),_display_(/*10.8*/helper/*10.14*/.html.information(info)),format.raw/*10.37*/("""
      """),format.raw/*11.7*/("""<h3>WebHook URLs</h3>
      <ul>
        """),_display_(/*13.10*/webHooks/*13.18*/.map/*13.22*/ { webHook =>_display_(Seq[Any](format.raw/*13.35*/("""
          """),format.raw/*14.11*/("""<li>"""),_display_(/*14.16*/webHook/*14.23*/.url),format.raw/*14.27*/(""" """),format.raw/*14.28*/("""<a href=""""),_display_(/*14.38*/url(repository)),format.raw/*14.53*/("""/settings/hooks/delete?url="""),_display_(/*14.81*/urlEncode(webHook.url)),format.raw/*14.103*/("""" class="remove">(remove)</a></li>
        """)))}),format.raw/*15.10*/("""
      """),format.raw/*16.7*/("""</ul>
      <form method="POST" validate="true">
        <div>
          <span class="error" id="error-url"></span>
        </div>
        <input type="text" name="url" id="url" value=""""),_display_(/*21.56*/enteredUrl),format.raw/*21.66*/("""" style="width: 300px; margin-bottom: 0px;"/>
        <input type="submit" class="btn" formaction=""""),_display_(/*22.55*/url(repository)),format.raw/*22.70*/("""/settings/hooks/add"  value="Add"/>
        <input type="submit" class="btn" formaction=""""),_display_(/*23.55*/url(repository)),format.raw/*23.70*/("""/settings/hooks/test" value="Test Hook"/>
      </form>
    """)))}),format.raw/*25.6*/("""
  """)))}),format.raw/*26.4*/("""
""")))}),format.raw/*27.2*/("""
"""))}
  }

  def render(webHooks:List[model.WebHook],enteredUrl:Option[Any],repository:service.RepositoryService.RepositoryInfo,info:Option[Any],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(webHooks,enteredUrl,repository,info)(context)

  def f:((List[model.WebHook],Option[Any],service.RepositoryService.RepositoryInfo,Option[Any]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (webHooks,enteredUrl,repository,info) => (context) => apply(webHooks,enteredUrl,repository,info)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/settings/hooks.scala.html
                  HASH: 36eba6393b853c8cd0c9f21d69a4b671235c4130
                  MATRIX: 436->1|728->167|755->210|766->214|809->249|847->250|876->254|887->258|924->287|962->288|993->294|1026->319|1064->320|1098->328|1113->334|1157->357|1191->364|1260->406|1277->414|1290->418|1341->431|1380->442|1412->447|1428->454|1453->458|1482->459|1519->469|1555->484|1610->512|1654->534|1729->578|1763->585|1976->771|2007->781|2134->881|2170->896|2287->986|2323->1001|2414->1062|2448->1066|2480->1068
                  LINES: 13->1|20->4|21->7|21->7|21->7|21->7|22->8|22->8|22->8|22->8|23->9|23->9|23->9|24->10|24->10|24->10|25->11|27->13|27->13|27->13|27->13|28->14|28->14|28->14|28->14|28->14|28->14|28->14|28->14|28->14|29->15|30->16|35->21|35->21|36->22|36->22|37->23|37->23|39->25|40->26|41->27
                  -- GENERATED --
              */
          