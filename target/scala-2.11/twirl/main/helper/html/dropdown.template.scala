
package helper.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object dropdown extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template7[String,String,Boolean,String,Boolean,Boolean,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(value : String  = "",
  prefix: String  = "",
  mini  : Boolean = true,
  style : String  = "",
  right : Boolean = false,
  flat  : Boolean = false)(body: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*6.39*/("""
"""),format.raw/*7.1*/("""<div class="btn-group" """),_display_(/*7.25*/if(style.nonEmpty)/*7.43*/{_display_(Seq[Any](format.raw/*7.44*/("""style=""""),_display_(/*7.52*/style),format.raw/*7.57*/(""""""")))}),format.raw/*7.59*/(""">
  <button
      """),_display_(/*9.8*/if(flat)/*9.16*/{_display_(Seq[Any](format.raw/*9.17*/("""style="border: none; background-color: #eee;"""")))}),format.raw/*9.63*/("""
      """),format.raw/*10.7*/("""class="dropdown-toggle """),_display_(/*10.31*/if(!flat)/*10.40*/{_display_(Seq[Any](format.raw/*10.41*/("""btn""")))}/*10.46*/else/*10.51*/{_display_(Seq[Any](format.raw/*10.52*/("""flat""")))}),format.raw/*10.57*/(""" """),_display_(/*10.59*/if(mini)/*10.67*/{_display_(Seq[Any](format.raw/*10.68*/("""btn-mini""")))}/*10.78*/else/*10.83*/{_display_(Seq[Any](format.raw/*10.84*/("""btn-small""")))}),format.raw/*10.94*/("""" data-toggle="dropdown">
    """),_display_(/*11.6*/if(value.isEmpty)/*11.23*/{_display_(Seq[Any](format.raw/*11.24*/("""
      """),format.raw/*12.7*/("""<i class="icon-cog"></i>
    """)))}/*13.7*/else/*13.12*/{_display_(Seq[Any](format.raw/*13.13*/("""
      """),_display_(/*14.8*/if(prefix.nonEmpty)/*14.27*/{_display_(Seq[Any](format.raw/*14.28*/("""
        """),format.raw/*15.9*/("""<span class="muted">"""),_display_(/*15.30*/prefix),format.raw/*15.36*/(""":</span>
      """)))}),format.raw/*16.8*/("""
      """),format.raw/*17.7*/("""<span class="strong">"""),_display_(/*17.29*/value),format.raw/*17.34*/("""</span>
    """)))}),format.raw/*18.6*/("""
    """),format.raw/*19.5*/("""<span class="caret"></span>
  </button>
  <ul class="dropdown-menu"""),_display_(/*21.28*/if(right)/*21.37*/{_display_(Seq[Any](format.raw/*21.38*/(""" """),format.raw/*21.39*/("""pull-right""")))}),format.raw/*21.50*/("""">
    """),_display_(/*22.6*/body),format.raw/*22.10*/("""
  """),format.raw/*23.3*/("""</ul>
</div>
"""))}
  }

  def render(value:String,prefix:String,mini:Boolean,style:String,right:Boolean,flat:Boolean,body:Html): play.twirl.api.HtmlFormat.Appendable = apply(value,prefix,mini,style,right,flat)(body)

  def f:((String,String,Boolean,String,Boolean,Boolean) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (value,prefix,mini,style,right,flat) => (body) => apply(value,prefix,mini,style,right,flat)(body)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/dropdown.scala.html
                  HASH: 485791088ad40770705858a1ef83bc3dcceffe03
                  MATRIX: 390->1|640->163|667->164|717->188|743->206|781->207|815->215|840->220|872->222|916->241|932->249|970->250|1046->296|1080->303|1131->327|1149->336|1188->337|1211->342|1224->347|1263->348|1299->353|1328->355|1345->363|1384->364|1412->374|1425->379|1464->380|1505->390|1562->421|1588->438|1627->439|1661->446|1709->477|1722->482|1761->483|1795->491|1823->510|1862->511|1898->520|1946->541|1973->547|2019->563|2053->570|2102->592|2128->597|2171->610|2203->615|2297->682|2315->691|2354->692|2383->693|2425->704|2459->712|2484->716|2514->719
                  LINES: 13->1|21->6|22->7|22->7|22->7|22->7|22->7|22->7|22->7|24->9|24->9|24->9|24->9|25->10|25->10|25->10|25->10|25->10|25->10|25->10|25->10|25->10|25->10|25->10|25->10|25->10|25->10|25->10|26->11|26->11|26->11|27->12|28->13|28->13|28->13|29->14|29->14|29->14|30->15|30->15|30->15|31->16|32->17|32->17|32->17|33->18|34->19|36->21|36->21|36->21|36->21|36->21|37->22|37->22|38->23
                  -- GENERATED --
              */
          