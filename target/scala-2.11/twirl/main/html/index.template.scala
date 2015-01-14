
package html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[List[model.Activity],List[service.RepositoryService.RepositoryInfo],List[service.RepositoryService.RepositoryInfo],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(activities: List[model.Activity],
  recentRepositories: List[service.RepositoryService.RepositoryInfo],
  userRepositories: List[service.RepositoryService.RepositoryInfo])(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*3.99*/("""
"""),_display_(/*6.2*/main("GitBucket")/*6.19*/{_display_(Seq[Any](format.raw/*6.20*/("""
  """),_display_(/*7.4*/dashboard/*7.13*/.html.tab()),format.raw/*7.24*/("""
  """),format.raw/*8.3*/("""<div class="container">
    <div class="row-fluid">
      <div class="span8">
        <div class="pull-right">
          <a href=""""),_display_(/*12.21*/path),format.raw/*12.25*/("""/activities.atom"><img src=""""),_display_(/*12.54*/assets),format.raw/*12.60*/("""/common/images/feed.png" alt="activities"></a>
        </div>
        """),_display_(/*14.10*/helper/*14.16*/.html.activities(activities)),format.raw/*14.44*/("""
      """),format.raw/*15.7*/("""</div>

      <div class="span4">
        """),_display_(/*18.10*/settings/*18.18*/.information.map/*18.34*/ { information =>_display_(Seq[Any](format.raw/*18.51*/("""
          """),format.raw/*19.11*/("""<div class="alert alert-info" style="background-color: white; color: #555; border-color: #4183c4; font-size: small; line-height: 120%;">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            """),_display_(/*21.14*/Html(information)),format.raw/*21.31*/("""
          """),format.raw/*22.11*/("""</div>
        """)))}),format.raw/*23.10*/("""
        """),_display_(/*24.10*/if(loginAccount.isEmpty)/*24.34*/{_display_(Seq[Any](format.raw/*24.35*/("""
          """),_display_(/*25.12*/signinform(settings)),format.raw/*25.32*/("""
        """)))}/*26.11*/else/*26.16*/{_display_(Seq[Any](format.raw/*26.17*/("""
          """),format.raw/*27.11*/("""<table class="table table-bordered">
            <tr>
              <th class="metal">
                <div class="pull-right">
                  <a href=""""),_display_(/*31.29*/path),format.raw/*31.33*/("""/new" class="btn btn-success btn-mini">New repository</a>
                </div>
                Your repositories ("""),_display_(/*33.37*/userRepositories/*33.53*/.size),format.raw/*33.58*/(""")
              </th>
            </tr>
            """),_display_(/*36.14*/if(userRepositories.isEmpty)/*36.42*/{_display_(Seq[Any](format.raw/*36.43*/("""
              """),format.raw/*37.15*/("""<tr>
                <td>No repositories</td>
              </tr>
            """)))}/*40.15*/else/*40.20*/{_display_(Seq[Any](format.raw/*40.21*/("""
              """),_display_(/*41.16*/userRepositories/*41.32*/.map/*41.36*/ { repository =>_display_(Seq[Any](format.raw/*41.52*/("""
                """),format.raw/*42.17*/("""<tr>
                  <td>
                    """),_display_(/*44.22*/helper/*44.28*/.html.repositoryicon(repository, false)),format.raw/*44.67*/("""
                    """),_display_(/*45.22*/if(repository.owner == loginAccount.get.userName)/*45.71*/{_display_(Seq[Any](format.raw/*45.72*/("""
                      """),format.raw/*46.23*/("""<a href=""""),_display_(/*46.33*/url(repository)),format.raw/*46.48*/(""""><span class="strong">"""),_display_(/*46.72*/repository/*46.82*/.name),format.raw/*46.87*/("""</span></a>
                    """)))}/*47.23*/else/*47.28*/{_display_(Seq[Any](format.raw/*47.29*/("""
                      """),format.raw/*48.23*/("""<a href=""""),_display_(/*48.33*/url(repository)),format.raw/*48.48*/("""">"""),_display_(/*48.51*/repository/*48.61*/.owner),format.raw/*48.67*/("""/<span class="strong">"""),_display_(/*48.90*/repository/*48.100*/.name),format.raw/*48.105*/("""</span></a>
                    """)))}),format.raw/*49.22*/("""
                  """),format.raw/*50.19*/("""</td>
                </tr>
              """)))}),format.raw/*52.16*/("""
            """)))}),format.raw/*53.14*/("""
          """),format.raw/*54.11*/("""</table>
        """)))}),format.raw/*55.10*/("""
        """),format.raw/*56.9*/("""<table class="table table-bordered">
          <tr>
            <th class="metal">
              Recent updated repositories
            </th>
          </tr>
          """),_display_(/*62.12*/if(recentRepositories.isEmpty)/*62.42*/{_display_(Seq[Any](format.raw/*62.43*/("""
            """),format.raw/*63.13*/("""<tr>
              <td>No repositories</td>
            </tr>
          """)))}/*66.13*/else/*66.18*/{_display_(Seq[Any](format.raw/*66.19*/("""
            """),_display_(/*67.14*/recentRepositories/*67.32*/.map/*67.36*/ { repository =>_display_(Seq[Any](format.raw/*67.52*/("""
              """),format.raw/*68.15*/("""<tr>
                <td>
                  """),_display_(/*70.20*/helper/*70.26*/.html.repositoryicon(repository, false)),format.raw/*70.65*/("""
                  """),format.raw/*71.19*/("""<a href=""""),_display_(/*71.29*/url(repository)),format.raw/*71.44*/("""">"""),_display_(/*71.47*/repository/*71.57*/.owner),format.raw/*71.63*/("""/<span class="strong">"""),_display_(/*71.86*/repository/*71.96*/.name),format.raw/*71.101*/("""</span></a>
                </td>
              </tr>
            """)))}),format.raw/*74.14*/("""
          """)))}),format.raw/*75.12*/("""
        """),format.raw/*76.9*/("""</table>
      </div>
    </div>
  </div>
""")))}),format.raw/*80.2*/("""
"""))}
  }

  def render(activities:List[model.Activity],recentRepositories:List[service.RepositoryService.RepositoryInfo],userRepositories:List[service.RepositoryService.RepositoryInfo],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(activities,recentRepositories,userRepositories)(context)

  def f:((List[model.Activity],List[service.RepositoryService.RepositoryInfo],List[service.RepositoryService.RepositoryInfo]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (activities,recentRepositories,userRepositories) => (context) => apply(activities,recentRepositories,userRepositories)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:10 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/index.scala.html
                  HASH: c7dc9e4b9e9fac2b45c727dff72d6bd2e8342c59
                  MATRIX: 457->1|786->204|813->247|838->264|876->265|905->269|922->278|953->289|982->292|1140->423|1165->427|1221->456|1248->462|1346->533|1361->539|1410->567|1444->574|1514->617|1531->625|1556->641|1611->658|1650->669|1913->905|1951->922|1990->933|2037->949|2074->959|2107->983|2146->984|2185->996|2226->1016|2255->1027|2268->1032|2307->1033|2346->1044|2529->1200|2554->1204|2698->1321|2723->1337|2749->1342|2829->1395|2866->1423|2905->1424|2948->1439|3046->1519|3059->1524|3098->1525|3141->1541|3166->1557|3179->1561|3233->1577|3278->1594|3354->1643|3369->1649|3429->1688|3478->1710|3536->1759|3575->1760|3626->1783|3663->1793|3699->1808|3750->1832|3769->1842|3795->1847|3847->1881|3860->1886|3899->1887|3950->1910|3987->1920|4023->1935|4053->1938|4072->1948|4099->1954|4149->1977|4169->1987|4196->1992|4260->2025|4307->2044|4381->2087|4426->2101|4465->2112|4514->2130|4550->2139|4747->2309|4786->2339|4825->2340|4866->2353|4958->2427|4971->2432|5010->2433|5051->2447|5078->2465|5091->2469|5145->2485|5188->2500|5260->2545|5275->2551|5335->2590|5382->2609|5419->2619|5455->2634|5485->2637|5504->2647|5531->2653|5581->2676|5600->2686|5627->2691|5725->2758|5768->2770|5804->2779|5877->2822
                  LINES: 13->1|19->3|20->6|20->6|20->6|21->7|21->7|21->7|22->8|26->12|26->12|26->12|26->12|28->14|28->14|28->14|29->15|32->18|32->18|32->18|32->18|33->19|35->21|35->21|36->22|37->23|38->24|38->24|38->24|39->25|39->25|40->26|40->26|40->26|41->27|45->31|45->31|47->33|47->33|47->33|50->36|50->36|50->36|51->37|54->40|54->40|54->40|55->41|55->41|55->41|55->41|56->42|58->44|58->44|58->44|59->45|59->45|59->45|60->46|60->46|60->46|60->46|60->46|60->46|61->47|61->47|61->47|62->48|62->48|62->48|62->48|62->48|62->48|62->48|62->48|62->48|63->49|64->50|66->52|67->53|68->54|69->55|70->56|76->62|76->62|76->62|77->63|80->66|80->66|80->66|81->67|81->67|81->67|81->67|82->68|84->70|84->70|84->70|85->71|85->71|85->71|85->71|85->71|85->71|85->71|85->71|85->71|88->74|89->75|90->76|94->80
                  -- GENERATED --
              */
          