
package repo.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object forked extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[Option[service.RepositoryService.RepositoryInfo],List[scala.Tuple2[String, String]],service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(originRepository: Option[service.RepositoryService.RepositoryInfo],
  members: List[(String, String)],
  repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*3.87*/("""
"""),_display_(/*6.2*/html/*6.6*/.main(s"${repository.owner}/${repository.name}", Some(repository))/*6.72*/ {_display_(Seq[Any](format.raw/*6.74*/("""
  """),_display_(/*7.4*/html/*7.8*/.menu("network", repository)/*7.36*/{_display_(Seq[Any](format.raw/*7.37*/("""
    """),format.raw/*8.5*/("""<ul class="nav nav-tabs">
      <li class="active"><a href=""""),_display_(/*9.36*/url(repository)),format.raw/*9.51*/("""/network/members">Members</a></li>
    </ul>
    <h3>Members of the """),_display_(/*11.25*/repository/*11.35*/.name),format.raw/*11.40*/(""" """),format.raw/*11.41*/("""Network</h3>
    <div class="block">
      """),_display_(/*13.8*/if(originRepository.isDefined)/*13.38*/{_display_(Seq[Any](format.raw/*13.39*/("""
        """),_display_(/*14.10*/avatar(originRepository.get.owner, 20)),format.raw/*14.48*/("""
        """),format.raw/*15.9*/("""<span"""),_display_(/*15.15*/if(repository.owner == originRepository.get.owner)/*15.65*/{_display_(Seq[Any](format.raw/*15.66*/(""" """),format.raw/*15.67*/("""class="highlight"""")))}),format.raw/*15.85*/(""">
          <a href=""""),_display_(/*16.21*/url(originRepository.get)),format.raw/*16.46*/("""">"""),_display_(/*16.49*/originRepository/*16.65*/.get.owner),format.raw/*16.75*/("""</a> / <a href=""""),_display_(/*16.92*/path),format.raw/*16.96*/("""/"""),_display_(/*16.98*/originRepository/*16.114*/.get.owner),format.raw/*16.124*/("""/"""),_display_(/*16.126*/originRepository/*16.142*/.get.name),format.raw/*16.151*/("""">"""),_display_(/*16.154*/originRepository/*16.170*/.get.name),format.raw/*16.179*/("""</a>
        </span>
      """)))}/*18.9*/else/*18.14*/{_display_(Seq[Any](format.raw/*18.15*/("""
        """),_display_(/*19.10*/avatar(repository.repository.originUserName.get, 20)),format.raw/*19.62*/("""
        """),format.raw/*20.9*/("""<span class="highlight">
          """),_display_(/*21.12*/repository/*21.22*/.repository.originUserName),format.raw/*21.48*/(""" """),format.raw/*21.49*/("""/ """),_display_(/*21.52*/repository/*21.62*/.repository.originRepositoryName),format.raw/*21.94*/("""
        """),format.raw/*22.9*/("""</span>
      """)))}),format.raw/*23.8*/("""
      """),format.raw/*24.7*/("""(origin)
    </div>
    """),_display_(/*26.6*/members/*26.13*/.map/*26.17*/ { case (owner, name) =>_display_(Seq[Any](format.raw/*26.41*/("""
      """),format.raw/*27.7*/("""<div class="block">
        """),_display_(/*28.10*/avatar(owner, 20)),format.raw/*28.27*/("""
        """),format.raw/*29.9*/("""<span"""),_display_(/*29.15*/if(repository.owner == owner)/*29.44*/{_display_(Seq[Any](format.raw/*29.45*/(""" """),format.raw/*29.46*/("""class="highlight"""")))}),format.raw/*29.64*/(""">
          <a href=""""),_display_(/*30.21*/url(owner)),format.raw/*30.31*/("""">"""),_display_(/*30.34*/owner),format.raw/*30.39*/("""</a> / <a href=""""),_display_(/*30.56*/path),format.raw/*30.60*/("""/"""),_display_(/*30.62*/owner),format.raw/*30.67*/("""/"""),_display_(/*30.69*/name),format.raw/*30.73*/("""">"""),_display_(/*30.76*/name),format.raw/*30.80*/("""</a>
        </span>
      </div>
    """)))}),format.raw/*33.6*/("""
  """)))}),format.raw/*34.4*/("""
""")))}),format.raw/*35.2*/("""
"""))}
  }

  def render(originRepository:Option[service.RepositoryService.RepositoryInfo],members:List[scala.Tuple2[String, String]],repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(originRepository,members,repository)(context)

  def f:((Option[service.RepositoryService.RepositoryInfo],List[scala.Tuple2[String, String]],service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (originRepository,members,repository) => (context) => apply(originRepository,members,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/repo/forked.scala.html
                  HASH: 3ae582015d43855dd143432a57dc2d17fc842b29
                  MATRIX: 473->1|789->191|816->234|827->238|901->304|940->306|969->310|980->314|1016->342|1054->343|1085->348|1172->409|1207->424|1303->493|1322->503|1348->508|1377->509|1447->553|1486->583|1525->584|1562->594|1621->632|1657->641|1690->647|1749->697|1788->698|1817->699|1866->717|1915->739|1961->764|1991->767|2016->783|2047->793|2091->810|2116->814|2145->816|2171->832|2203->842|2233->844|2259->860|2290->869|2321->872|2347->888|2378->897|2424->926|2437->931|2476->932|2513->942|2586->994|2622->1003|2685->1039|2704->1049|2751->1075|2780->1076|2810->1079|2829->1089|2882->1121|2918->1130|2963->1145|2997->1152|3048->1177|3064->1184|3077->1188|3139->1212|3173->1219|3229->1248|3267->1265|3303->1274|3336->1280|3374->1309|3413->1310|3442->1311|3491->1329|3540->1351|3571->1361|3601->1364|3627->1369|3671->1386|3696->1390|3725->1392|3751->1397|3780->1399|3805->1403|3835->1406|3860->1410|3929->1449|3963->1453|3995->1455
                  LINES: 13->1|19->3|20->6|20->6|20->6|20->6|21->7|21->7|21->7|21->7|22->8|23->9|23->9|25->11|25->11|25->11|25->11|27->13|27->13|27->13|28->14|28->14|29->15|29->15|29->15|29->15|29->15|29->15|30->16|30->16|30->16|30->16|30->16|30->16|30->16|30->16|30->16|30->16|30->16|30->16|30->16|30->16|30->16|30->16|32->18|32->18|32->18|33->19|33->19|34->20|35->21|35->21|35->21|35->21|35->21|35->21|35->21|36->22|37->23|38->24|40->26|40->26|40->26|40->26|41->27|42->28|42->28|43->29|43->29|43->29|43->29|43->29|43->29|44->30|44->30|44->30|44->30|44->30|44->30|44->30|44->30|44->30|44->30|44->30|44->30|47->33|48->34|49->35
                  -- GENERATED --
              */
          