
package helper.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object datepicker extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Option[java.util.Date],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(name: String, value: Option[java.util.Date]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import view.helpers

Seq[Any](format.raw/*1.47*/("""
"""),format.raw/*3.1*/("""<div id=""""),_display_(/*3.11*/name),format.raw/*3.15*/("""" class="input-append date" data-date-format="yyyy-mm-dd" data-date=""""),_display_(/*3.85*/value/*3.90*/.map(helpers.date)),format.raw/*3.108*/("""">
  <input class="span2" name=""""),_display_(/*4.31*/name),format.raw/*4.35*/("""" type="text" readonly="" value=""""),_display_(/*4.69*/value/*4.74*/.map(helpers.date)),format.raw/*4.92*/("""" size="16"/>
  <span class="add-on"><i class="icon-calendar"></i></span>
</div>
<script>
$(function()"""),format.raw/*8.13*/("""{"""),format.raw/*8.14*/("""
  """),format.raw/*9.3*/("""$('#"""),_display_(/*9.8*/name),format.raw/*9.12*/("""').datepicker();
"""),format.raw/*10.1*/("""}"""),format.raw/*10.2*/(""");
</script>
"""))}
  }

  def render(name:String,value:Option[java.util.Date]): play.twirl.api.HtmlFormat.Appendable = apply(name,value)

  def f:((String,Option[java.util.Date]) => play.twirl.api.HtmlFormat.Appendable) = (name,value) => apply(name,value)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/datepicker.scala.html
                  HASH: 36abf14e29784784f26422b2c295559200ddeb8e
                  MATRIX: 372->1|524->46|551->68|587->78|611->82|707->152|720->157|759->175|818->208|842->212|902->246|915->251|953->269|1082->371|1110->372|1139->375|1169->380|1193->384|1237->401|1265->402
                  LINES: 13->1|16->1|17->3|17->3|17->3|17->3|17->3|17->3|18->4|18->4|18->4|18->4|18->4|22->8|22->8|23->9|23->9|23->9|24->10|24->10
                  -- GENERATED --
              */
          