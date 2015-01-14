
package dashboard.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object tab extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(active: String = "")(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*1.54*/("""
"""),format.raw/*4.1*/("""<div class="dashboard-nav">
  <div class="container">
    <a href=""""),_display_(/*6.15*/path),format.raw/*6.19*/("""/" """),_display_(/*6.23*/if(active == "")/*6.39*/{_display_(Seq[Any](format.raw/*6.40*/(""" """),format.raw/*6.41*/("""class="active"""")))}),format.raw/*6.56*/(""">
      <img src=""""),_display_(/*7.18*/assets),format.raw/*7.24*/("""/common/images/menu-feed.png">
      News Feed
    </a>
    """),_display_(/*10.6*/if(loginAccount.isDefined)/*10.32*/{_display_(Seq[Any](format.raw/*10.33*/("""
      """),format.raw/*11.7*/("""<a href=""""),_display_(/*11.17*/path),format.raw/*11.21*/("""/dashboard/pulls" """),_display_(/*11.40*/if(active == "pulls" )/*11.62*/{_display_(Seq[Any](format.raw/*11.63*/(""" """),format.raw/*11.64*/("""class="active"""")))}),format.raw/*11.79*/(""">
        <img src=""""),_display_(/*12.20*/assets),format.raw/*12.26*/("""/common/images/menu-pulls.png">
        Pull Requests
      </a>
      <a href=""""),_display_(/*15.17*/path),format.raw/*15.21*/("""/dashboard/issues" """),_display_(/*15.41*/if(active == "issues")/*15.63*/{_display_(Seq[Any](format.raw/*15.64*/(""" """),format.raw/*15.65*/("""class="active"""")))}),format.raw/*15.80*/(""">
        <img src=""""),_display_(/*16.20*/assets),format.raw/*16.26*/("""/common/images/menu-issues.png">
        Issues
      </a>
    """)))}),format.raw/*19.6*/("""
  """),format.raw/*20.3*/("""</div>
</div>
<style type="text/css">
div.dashboard-nav """),format.raw/*23.19*/("""{"""),format.raw/*23.20*/("""
  """),format.raw/*24.3*/("""border-bottom: 1px solid #ddd;
  text-align: right;
  height: 32px;
  margin-bottom: 20px;
"""),format.raw/*28.1*/("""}"""),format.raw/*28.2*/("""

"""),format.raw/*30.1*/("""div.dashboard-nav a  """),format.raw/*30.22*/("""{"""),format.raw/*30.23*/("""
  """),format.raw/*31.3*/("""line-height: 10px;
  margin-left: 20px;
  padding-bottom: 13px;
  padding-left: 4px;
  padding-right: 4px;
  color: #888;
"""),format.raw/*37.1*/("""}"""),format.raw/*37.2*/("""

"""),format.raw/*39.1*/("""div.dashboard-nav a:hover  """),format.raw/*39.28*/("""{"""),format.raw/*39.29*/("""
  """),format.raw/*40.3*/("""text-decoration: none;
"""),format.raw/*41.1*/("""}"""),format.raw/*41.2*/("""

"""),format.raw/*43.1*/("""div.dashboard-nav a.active """),format.raw/*43.28*/("""{"""),format.raw/*43.29*/("""
  """),format.raw/*44.3*/("""border-bottom: 2px solid #bb4444;
  color: #333;
"""),format.raw/*46.1*/("""}"""),format.raw/*46.2*/("""
"""),format.raw/*47.1*/("""</style>"""))}
  }

  def render(active:String,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(active)(context)

  def f:((String) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (active) => (context) => apply(active)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/dashboard/tab.scala.html
                  HASH: f6fa2e439fc1089eb317397b3304586ddb5d55f9
                  MATRIX: 357->1|535->53|562->95|656->163|680->167|710->171|734->187|772->188|800->189|845->204|890->223|916->229|1003->290|1038->316|1077->317|1111->324|1148->334|1173->338|1219->357|1250->379|1289->380|1318->381|1364->396|1412->417|1439->423|1547->504|1572->508|1619->528|1650->550|1689->551|1718->552|1764->567|1812->588|1839->594|1933->658|1963->661|2047->717|2076->718|2106->721|2224->812|2252->813|2281->815|2330->836|2359->837|2389->840|2538->962|2566->963|2595->965|2650->992|2679->993|2709->996|2759->1019|2787->1020|2816->1022|2871->1049|2900->1050|2930->1053|3006->1102|3034->1103|3062->1104
                  LINES: 13->1|17->1|18->4|20->6|20->6|20->6|20->6|20->6|20->6|20->6|21->7|21->7|24->10|24->10|24->10|25->11|25->11|25->11|25->11|25->11|25->11|25->11|25->11|26->12|26->12|29->15|29->15|29->15|29->15|29->15|29->15|29->15|30->16|30->16|33->19|34->20|37->23|37->23|38->24|42->28|42->28|44->30|44->30|44->30|45->31|51->37|51->37|53->39|53->39|53->39|54->40|55->41|55->41|57->43|57->43|57->43|58->44|60->46|60->46|61->47
                  -- GENERATED --
              */
          