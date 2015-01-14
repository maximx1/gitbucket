
package account.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object repositories extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[model.Account,List[String],List[service.RepositoryService.RepositoryInfo],Boolean,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: model.Account, groupNames: List[String],
  repositories: List[service.RepositoryService.RepositoryInfo],
  isGroupManager: Boolean)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*3.58*/("""
"""),_display_(/*6.2*/main(account, groupNames, "repositories", isGroupManager)/*6.59*/{_display_(Seq[Any](format.raw/*6.60*/("""
  """),_display_(/*7.4*/if(repositories.isEmpty)/*7.28*/{_display_(Seq[Any](format.raw/*7.29*/("""
    """),format.raw/*8.5*/("""No repositories
  """)))}/*9.5*/else/*9.10*/{_display_(Seq[Any](format.raw/*9.11*/("""
    """),_display_(/*10.6*/repositories/*10.18*/.map/*10.22*/ { repository =>_display_(Seq[Any](format.raw/*10.38*/("""
      """),format.raw/*11.7*/("""<div class="block">
        <div class="repository-icon">
          """),_display_(/*13.12*/helper/*13.18*/.html.repositoryicon(repository, true)),format.raw/*13.56*/("""
        """),format.raw/*14.9*/("""</div>
        <div class="repository-content">
          <div class="block-header">
            <a href=""""),_display_(/*17.23*/url(repository)),format.raw/*17.38*/("""">"""),_display_(/*17.41*/repository/*17.51*/.name),format.raw/*17.56*/("""</a>
            """),_display_(/*18.14*/if(repository.repository.isPrivate)/*18.49*/{_display_(Seq[Any](format.raw/*18.50*/("""
              """),format.raw/*19.15*/("""<i class="icon-lock"></i>
            """)))}),format.raw/*20.14*/("""
          """),format.raw/*21.11*/("""</div>
          """),_display_(/*22.12*/if(repository.repository.originUserName.isDefined)/*22.62*/{_display_(Seq[Any](format.raw/*22.63*/("""
            """),format.raw/*23.13*/("""<div class="small muted">forked from <a href=""""),_display_(/*23.60*/path),format.raw/*23.64*/("""/"""),_display_(/*23.66*/repository/*23.76*/.repository.parentUserName),format.raw/*23.102*/("""/"""),_display_(/*23.104*/repository/*23.114*/.repository.parentRepositoryName),format.raw/*23.146*/("""">"""),_display_(/*23.149*/repository/*23.159*/.repository.parentUserName),format.raw/*23.185*/("""/"""),_display_(/*23.187*/repository/*23.197*/.repository.parentRepositoryName),format.raw/*23.229*/("""</a></div>
          """)))}),format.raw/*24.12*/("""
          """),_display_(/*25.12*/if(repository.repository.description.isDefined)/*25.59*/{_display_(Seq[Any](format.raw/*25.60*/("""
            """),format.raw/*26.13*/("""<div>"""),_display_(/*26.19*/repository/*26.29*/.repository.description),format.raw/*26.52*/("""</div>
          """)))}),format.raw/*27.12*/("""
          """),format.raw/*28.11*/("""<div><span class="muted small">Updated """),_display_(/*28.51*/helper/*28.57*/.html.datetimeago(repository.repository.lastActivityDate)),format.raw/*28.114*/("""</span></div>
        </div>
      </div>
    """)))}),format.raw/*31.6*/("""
  """)))}),format.raw/*32.4*/("""
""")))}),format.raw/*33.2*/("""
"""))}
  }

  def render(account:model.Account,groupNames:List[String],repositories:List[service.RepositoryService.RepositoryInfo],isGroupManager:Boolean,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,groupNames,repositories,isGroupManager)(context)

  def f:((model.Account,List[String],List[service.RepositoryService.RepositoryInfo],Boolean) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,groupNames,repositories,isGroupManager) => (context) => apply(account,groupNames,repositories,isGroupManager)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/account/repositories.scala.html
                  HASH: 926546726e5792094b091f3a4bb8b6a6efc8615a
                  MATRIX: 439->1|737->173|764->216|829->273|867->274|896->278|928->302|966->303|997->308|1033->328|1045->333|1083->334|1115->340|1136->352|1149->356|1203->372|1237->379|1333->448|1348->454|1407->492|1443->501|1577->608|1613->623|1643->626|1662->636|1688->641|1733->659|1777->694|1816->695|1859->710|1929->749|1968->760|2013->778|2072->828|2111->829|2152->842|2226->889|2251->893|2280->895|2299->905|2347->931|2377->933|2397->943|2451->975|2482->978|2502->988|2550->1014|2580->1016|2600->1026|2654->1058|2707->1080|2746->1092|2802->1139|2841->1140|2882->1153|2915->1159|2934->1169|2978->1192|3027->1210|3066->1221|3133->1261|3148->1267|3227->1324|3304->1371|3338->1375|3370->1377
                  LINES: 13->1|19->3|20->6|20->6|20->6|21->7|21->7|21->7|22->8|23->9|23->9|23->9|24->10|24->10|24->10|24->10|25->11|27->13|27->13|27->13|28->14|31->17|31->17|31->17|31->17|31->17|32->18|32->18|32->18|33->19|34->20|35->21|36->22|36->22|36->22|37->23|37->23|37->23|37->23|37->23|37->23|37->23|37->23|37->23|37->23|37->23|37->23|37->23|37->23|37->23|38->24|39->25|39->25|39->25|40->26|40->26|40->26|40->26|41->27|42->28|42->28|42->28|42->28|45->31|46->32|47->33
                  -- GENERATED --
              */
          