
package helper.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object forkrepository extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[service.RepositoryService.RepositoryInfo,Map[String, Boolean],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: service.RepositoryService.RepositoryInfo,
  groupAndPerm: Map[String, Boolean])(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*2.69*/("""
"""),format.raw/*5.1*/("""  """),format.raw/*5.3*/("""<h2 class="facebox-header">Where should we fork this repository?</h2>
  <form action=""""),_display_(/*6.18*/url(repository)),format.raw/*6.33*/("""/fork" id="fork" method="post">
    <div class="owner-select-grid">
      <div class="owner-select-target js-fork-owner-select-target enabled">"""),_display_(/*8.77*/avatar(loginAccount.get.userName, 100)),format.raw/*8.115*/("""<span class="owner css-truncate" title="@"""),_display_(/*8.158*/loginAccount/*8.170*/.get.userName),format.raw/*8.183*/("""">@"""),_display_(/*8.188*/loginAccount/*8.200*/.get.userName),format.raw/*8.213*/("""</span></div>
    """),_display_(/*9.6*/for((groupName, isManager) <- groupAndPerm) yield /*9.49*/ {_display_(Seq[Any](format.raw/*9.51*/("""
      """),_display_(/*10.8*/if(isManager)/*10.21*/ {_display_(Seq[Any](format.raw/*10.23*/("""
      """),format.raw/*11.7*/("""<div class="owner-select-target js-fork-owner-select-target enabled">"""),_display_(/*11.77*/avatar(groupName, 100)),format.raw/*11.99*/("""<span class="owner css-truncate" title="@"""),_display_(/*11.142*/groupName),format.raw/*11.151*/("""">@"""),_display_(/*11.156*/groupName),format.raw/*11.165*/("""</span></div>
      """)))}/*12.9*/else/*12.14*/{_display_(Seq[Any](format.raw/*12.15*/("""
      """),format.raw/*13.7*/("""<div title="You don't have permission to fork here."  class="owner-select-target js-fork-owner-select-target disabled">"""),_display_(/*13.127*/avatar(groupName, 100)),format.raw/*13.149*/("""<span class="owner css-truncate" title="@"""),_display_(/*13.192*/groupName),format.raw/*13.201*/("""">@"""),_display_(/*13.206*/groupName),format.raw/*13.215*/("""</span></div>
      """)))}),format.raw/*14.8*/("""
    """)))}),format.raw/*15.6*/("""
    """),format.raw/*16.5*/("""</div>
    <input id="account" name="account" type="hidden" />
</form>"""))}
  }

  def render(repository:service.RepositoryService.RepositoryInfo,groupAndPerm:Map[String, Boolean],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository,groupAndPerm)(context)

  def f:((service.RepositoryService.RepositoryInfo,Map[String, Boolean]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository,groupAndPerm) => (context) => apply(repository,groupAndPerm)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/forkrepository.scala.html
                  HASH: 4a894bcba5075ad4229a4bee726a412cc17493fc
                  MATRIX: 420->1|669->124|696->166|724->168|837->255|872->270|1042->414|1101->452|1170->495|1191->507|1225->520|1256->525|1277->537|1311->550|1355->569|1413->612|1452->614|1486->622|1508->635|1548->637|1582->644|1679->714|1722->736|1792->779|1823->788|1855->793|1886->802|1925->824|1938->829|1977->830|2011->837|2159->957|2203->979|2273->1022|2304->1031|2336->1036|2367->1045|2418->1066|2454->1072|2486->1077
                  LINES: 13->1|18->2|19->5|19->5|20->6|20->6|22->8|22->8|22->8|22->8|22->8|22->8|22->8|22->8|23->9|23->9|23->9|24->10|24->10|24->10|25->11|25->11|25->11|25->11|25->11|25->11|25->11|26->12|26->12|26->12|27->13|27->13|27->13|27->13|27->13|27->13|27->13|28->14|29->15|30->16
                  -- GENERATED --
              */
          