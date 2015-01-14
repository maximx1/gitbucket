
package issues.labels.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object edit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Option[model.Label],service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(label: Option[model.Label], repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*1.115*/("""
"""),_display_(/*4.2*/defining(label.map(_.labelId).getOrElse("new"))/*4.49*/{ labelId =>_display_(Seq[Any](format.raw/*4.61*/("""
"""),format.raw/*5.1*/("""<div id="edit-label-area-"""),_display_(/*5.27*/labelId),format.raw/*5.34*/("""">
  <form style="margin-bottom: 0px;">
    <input type="text" id="labelName-"""),_display_(/*7.39*/labelId),format.raw/*7.46*/("""" style="width: 300px; margin-bottom: 0px;" value=""""),_display_(/*7.98*/label/*7.103*/.map(_.labelName)),format.raw/*7.120*/("""""""),_display_(/*7.122*/if(labelId == "new")/*7.142*/{_display_(Seq[Any](format.raw/*7.143*/(""" """),format.raw/*7.144*/("""placeholder="New label name"""")))}),format.raw/*7.173*/("""/>
    <div id="label-color-"""),_display_(/*8.27*/labelId),format.raw/*8.34*/("""" class="input-append color bscp" data-color="#"""),_display_(/*8.82*/label/*8.87*/.map(_.color).getOrElse("888888")),format.raw/*8.120*/("""" data-color-format="hex" style="width: 100px; margin-bottom: 0px;">
      <input type="text" class="span3" id="labelColor-"""),_display_(/*9.56*/labelId),format.raw/*9.63*/("""" value="#"""),_display_(/*9.74*/label/*9.79*/.map(_.color).getOrElse("888888")),format.raw/*9.112*/("""" readonly style="width: 100px;">
      <span class="add-on"><i style="background-color: #"""),_display_(/*10.58*/label/*10.63*/.map(_.color).getOrElse("888888")),format.raw/*10.96*/(""";"></i></span>
    </div>
    <script>
    $('div#label-color-"""),_display_(/*13.25*/labelId),format.raw/*13.32*/("""').colorpicker();
    </script>
    <span class="pull-right">
      <span id="label-error-"""),_display_(/*16.30*/labelId),format.raw/*16.37*/("""" class="error"></span>
      <input type="button" id="cancel-"""),_display_(/*17.40*/labelId),format.raw/*17.47*/("""" class="btn label-edit-cancel" value="Cancel">
      <input type="button" id="submit-"""),_display_(/*18.40*/labelId),format.raw/*18.47*/("""" class="btn btn-success" style="margin-bottom: 0px;" value=""""),_display_(/*18.109*/(if(labelId == "new") "Create label"  else "Save changes")),format.raw/*18.167*/(""""/>
    </span>
  </form>
</div>
<script>
$(function()"""),format.raw/*23.13*/("""{"""),format.raw/*23.14*/("""
  """),format.raw/*24.3*/("""$('#submit-"""),_display_(/*24.15*/labelId),format.raw/*24.22*/("""').click(function(e)"""),format.raw/*24.42*/("""{"""),format.raw/*24.43*/("""
    """),format.raw/*25.5*/("""$.post('"""),_display_(/*25.14*/url(repository)),format.raw/*25.29*/("""/issues/labels/"""),_display_(/*25.45*/{if(labelId == "new") "new" else labelId + "/edit"}),format.raw/*25.96*/("""', """),format.raw/*25.99*/("""{"""),format.raw/*25.100*/("""
      """),format.raw/*26.7*/("""'labelName' : $('#labelName-"""),_display_(/*26.36*/labelId),format.raw/*26.43*/("""').val(),
      'labelColor': $('#labelColor-"""),_display_(/*27.37*/labelId),format.raw/*27.44*/("""').val()
    """),format.raw/*28.5*/("""}"""),format.raw/*28.6*/(""", function(data, status)"""),format.raw/*28.30*/("""{"""),format.raw/*28.31*/("""
      """),format.raw/*29.7*/("""$('div#edit-label-area-"""),_display_(/*29.31*/labelId),format.raw/*29.38*/("""').remove();
      """),_display_(/*30.8*/if(labelId == "new")/*30.28*/{_display_(Seq[Any](format.raw/*30.29*/("""
        """),format.raw/*31.9*/("""$('#new-label-table').hide();
        // Insert row into the top of table
        $('#label-row-header').after(data);
      """)))}/*34.9*/else/*34.14*/{_display_(Seq[Any](format.raw/*34.15*/("""
        """),format.raw/*35.9*/("""// Replace table row
        $('#label-row-"""),_display_(/*36.24*/labelId),format.raw/*36.31*/("""').after(data).remove();
      """)))}),format.raw/*37.8*/("""
    """),format.raw/*38.5*/("""}"""),format.raw/*38.6*/(""").fail(function(xhr, status, error)"""),format.raw/*38.41*/("""{"""),format.raw/*38.42*/("""
      """),format.raw/*39.7*/("""var errors = JSON.parse(xhr.responseText);
      if(errors.labelName)"""),format.raw/*40.27*/("""{"""),format.raw/*40.28*/("""
        """),format.raw/*41.9*/("""$('span#label-error-"""),_display_(/*41.30*/labelId),format.raw/*41.37*/("""').text(errors.labelName);
      """),format.raw/*42.7*/("""}"""),format.raw/*42.8*/(""" """),format.raw/*42.9*/("""else if(errors.labelColor)"""),format.raw/*42.35*/("""{"""),format.raw/*42.36*/("""
        """),format.raw/*43.9*/("""$('span#label-error-"""),_display_(/*43.30*/labelId),format.raw/*43.37*/("""').text(errors.labelColor);
      """),format.raw/*44.7*/("""}"""),format.raw/*44.8*/(""" """),format.raw/*44.9*/("""else """),format.raw/*44.14*/("""{"""),format.raw/*44.15*/("""
        """),format.raw/*45.9*/("""$('span#label-error-"""),_display_(/*45.30*/labelId),format.raw/*45.37*/("""').text('error');
      """),format.raw/*46.7*/("""}"""),format.raw/*46.8*/("""
    """),format.raw/*47.5*/("""}"""),format.raw/*47.6*/(""");
    return false;
  """),format.raw/*49.3*/("""}"""),format.raw/*49.4*/(""");

  $('#cancel-"""),_display_(/*51.15*/labelId),format.raw/*51.22*/("""').click(function(e)"""),format.raw/*51.42*/("""{"""),format.raw/*51.43*/("""
    """),format.raw/*52.5*/("""$('div#edit-label-area-"""),_display_(/*52.29*/labelId),format.raw/*52.36*/("""').remove();
    """),_display_(/*53.6*/if(labelId == "new")/*53.26*/{_display_(Seq[Any](format.raw/*53.27*/("""
      """),format.raw/*54.7*/("""$('#new-label-table').hide();
    """)))}/*55.7*/else/*55.12*/{_display_(Seq[Any](format.raw/*55.13*/("""
      """),format.raw/*56.7*/("""$('#label-"""),_display_(/*56.18*/labelId),format.raw/*56.25*/("""').show();
    """)))}),format.raw/*57.6*/("""
  """),format.raw/*58.3*/("""}"""),format.raw/*58.4*/(""");
"""),format.raw/*59.1*/("""}"""),format.raw/*59.2*/(""");
</script>
""")))}),format.raw/*61.2*/("""
"""))}
  }

  def render(label:Option[model.Label],repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(label,repository)(context)

  def f:((Option[model.Label],service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (label,repository) => (context) => apply(label,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/issues/labels/edit.scala.html
                  HASH: ed4abff2c56b38e4e47d1490e429a06a26959d9b
                  MATRIX: 416->1|656->114|683->157|738->204|787->216|814->217|866->243|893->250|997->328|1024->335|1102->387|1116->392|1154->409|1183->411|1212->431|1251->432|1280->433|1340->462|1395->491|1422->498|1496->546|1509->551|1563->584|1713->708|1740->715|1777->726|1790->731|1844->764|1962->855|1976->860|2030->893|2120->956|2148->963|2266->1054|2294->1061|2384->1124|2412->1131|2526->1218|2554->1225|2644->1287|2724->1345|2806->1399|2835->1400|2865->1403|2904->1415|2932->1422|2980->1442|3009->1443|3041->1448|3077->1457|3113->1472|3156->1488|3228->1539|3259->1542|3289->1543|3323->1550|3379->1579|3407->1586|3480->1632|3508->1639|3548->1652|3576->1653|3628->1677|3657->1678|3691->1685|3742->1709|3770->1716|3816->1736|3845->1756|3884->1757|3920->1766|4063->1892|4076->1897|4115->1898|4151->1907|4222->1951|4250->1958|4312->1990|4344->1995|4372->1996|4435->2031|4464->2032|4498->2039|4595->2108|4624->2109|4660->2118|4708->2139|4736->2146|4796->2179|4824->2180|4852->2181|4906->2207|4935->2208|4971->2217|5019->2238|5047->2245|5108->2279|5136->2280|5164->2281|5197->2286|5226->2287|5262->2296|5310->2317|5338->2324|5389->2348|5417->2349|5449->2354|5477->2355|5527->2378|5555->2379|5600->2397|5628->2404|5676->2424|5705->2425|5737->2430|5788->2454|5816->2461|5860->2479|5889->2499|5928->2500|5962->2507|6015->2543|6028->2548|6067->2549|6101->2556|6139->2567|6167->2574|6213->2590|6243->2593|6271->2594|6301->2597|6329->2598|6373->2612
                  LINES: 13->1|17->1|18->4|18->4|18->4|19->5|19->5|19->5|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|22->8|22->8|22->8|22->8|22->8|23->9|23->9|23->9|23->9|23->9|24->10|24->10|24->10|27->13|27->13|30->16|30->16|31->17|31->17|32->18|32->18|32->18|32->18|37->23|37->23|38->24|38->24|38->24|38->24|38->24|39->25|39->25|39->25|39->25|39->25|39->25|39->25|40->26|40->26|40->26|41->27|41->27|42->28|42->28|42->28|42->28|43->29|43->29|43->29|44->30|44->30|44->30|45->31|48->34|48->34|48->34|49->35|50->36|50->36|51->37|52->38|52->38|52->38|52->38|53->39|54->40|54->40|55->41|55->41|55->41|56->42|56->42|56->42|56->42|56->42|57->43|57->43|57->43|58->44|58->44|58->44|58->44|58->44|59->45|59->45|59->45|60->46|60->46|61->47|61->47|63->49|63->49|65->51|65->51|65->51|65->51|66->52|66->52|66->52|67->53|67->53|67->53|68->54|69->55|69->55|69->55|70->56|70->56|70->56|71->57|72->58|72->58|73->59|73->59|75->61
                  -- GENERATED --
              */
          