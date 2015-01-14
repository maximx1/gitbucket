
package helper.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object account extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Int,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(id: String, width: Int)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._

Seq[Any](format.raw/*1.57*/("""
"""),format.raw/*3.1*/("""<input type="text" name=""""),_display_(/*3.27*/id),format.raw/*3.29*/("""" id=""""),_display_(/*3.36*/id),format.raw/*3.38*/("""" style="width: """),_display_(/*3.55*/{width}),format.raw/*3.62*/("""px; margin-bottom: 0px;"/>
<script>
$(function()"""),format.raw/*5.13*/("""{"""),format.raw/*5.14*/("""
  """),format.raw/*6.3*/("""$('#"""),_display_(/*6.8*/id),format.raw/*6.10*/("""').typeahead("""),format.raw/*6.23*/("""{"""),format.raw/*6.24*/("""
    """),format.raw/*7.5*/("""source: function (query, process) """),format.raw/*7.39*/("""{"""),format.raw/*7.40*/("""
      """),format.raw/*8.7*/("""return $.get('"""),_display_(/*8.22*/path),format.raw/*8.26*/("""/_user/proposals', """),format.raw/*8.45*/("""{"""),format.raw/*8.46*/(""" """),format.raw/*8.47*/("""query: query """),format.raw/*8.60*/("""}"""),format.raw/*8.61*/(""",
        function (data) """),format.raw/*9.25*/("""{"""),format.raw/*9.26*/("""
          """),format.raw/*10.11*/("""return process(data.options);
        """),format.raw/*11.9*/("""}"""),format.raw/*11.10*/(""");
    """),format.raw/*12.5*/("""}"""),format.raw/*12.6*/("""
  """),format.raw/*13.3*/("""}"""),format.raw/*13.4*/(""");
"""),format.raw/*14.1*/("""}"""),format.raw/*14.2*/(""");
</script>
"""))}
  }

  def render(id:String,width:Int,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(id,width)(context)

  def f:((String,Int) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (id,width) => (context) => apply(id,width)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/account.scala.html
                  HASH: a186810502650a4af4382d4ad0a52cd772689a8b
                  MATRIX: 362->1|521->56|548->75|600->101|622->103|655->110|677->112|720->129|747->136|822->184|850->185|879->188|909->193|931->195|971->208|999->209|1030->214|1091->248|1119->249|1152->256|1193->271|1217->275|1263->294|1291->295|1319->296|1359->309|1387->310|1440->336|1468->337|1507->348|1572->386|1601->387|1635->394|1663->395|1693->398|1721->399|1751->402|1779->403
                  LINES: 13->1|16->1|17->3|17->3|17->3|17->3|17->3|17->3|17->3|19->5|19->5|20->6|20->6|20->6|20->6|20->6|21->7|21->7|21->7|22->8|22->8|22->8|22->8|22->8|22->8|22->8|22->8|23->9|23->9|24->10|25->11|25->11|26->12|26->12|27->13|27->13|28->14|28->14
                  -- GENERATED --
              */
          