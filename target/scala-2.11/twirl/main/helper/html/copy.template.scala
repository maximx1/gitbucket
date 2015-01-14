
package helper.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object copy extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(id: String, value: String)(html: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.41*/("""
"""),format.raw/*2.1*/("""<div class="input-append" style="margin-bottom: 0px;">
  """),_display_(/*3.4*/html),format.raw/*3.8*/("""
  """),format.raw/*4.3*/("""<span id=""""),_display_(/*4.14*/id),format.raw/*4.16*/("""" class="add-on btn" data-clipboard-text=""""),_display_(/*4.59*/value),format.raw/*4.64*/("""" data-placement="bottom" title="copy to clipboard"><i class="icon-check"></i></span>
</div>
<script>
// copy to clipboard
(function() """),format.raw/*8.13*/("""{"""),format.raw/*8.14*/("""
  """),format.raw/*9.3*/("""// Check flash availablibity
  var flashAvailable = false;
  try """),format.raw/*11.7*/("""{"""),format.raw/*11.8*/("""
    """),format.raw/*12.5*/("""var flashObject = new ActiveXObject('ShockwaveFlash.ShockwaveFlash');
    if(flashObject) flashAvailable = true;
  """),format.raw/*14.3*/("""}"""),format.raw/*14.4*/(""" """),format.raw/*14.5*/("""catch (e) """),format.raw/*14.15*/("""{"""),format.raw/*14.16*/("""
    """),format.raw/*15.5*/("""if (navigator.mimeTypes
        && navigator.mimeTypes['application/x-shockwave-flash'] != undefined
        && navigator.mimeTypes['application/x-shockwave-flash'].enabledPlugin) """),format.raw/*17.80*/("""{"""),format.raw/*17.81*/("""
      """),format.raw/*18.7*/("""flashAvailable = true;
    """),format.raw/*19.5*/("""}"""),format.raw/*19.6*/("""
  """),format.raw/*20.3*/("""}"""),format.raw/*20.4*/("""
  """),format.raw/*21.3*/("""// if flash is not available, remove the copy button.
  if(!flashAvailable) """),format.raw/*22.23*/("""{"""),format.raw/*22.24*/("""
    """),format.raw/*23.5*/("""$('#"""),_display_(/*23.10*/id),format.raw/*23.12*/("""').remove();
    return
  """),format.raw/*25.3*/("""}"""),format.raw/*25.4*/("""

  """),format.raw/*27.3*/("""// Find ZeroClipboard.swf file URI from ZeroClipboard JavaScript file path.
  // NOTE(tanacasino) I think this way is wrong... but i don't know correct way.
  var moviePath = (function() """),format.raw/*29.31*/("""{"""),format.raw/*29.32*/("""
    """),format.raw/*30.5*/("""var zclipjs = "ZeroClipboard.min.js";
    var scripts = document.getElementsByTagName("script");
    var i = scripts.length;
    while(i--) """),format.raw/*33.16*/("""{"""),format.raw/*33.17*/("""
      """),format.raw/*34.7*/("""var match = scripts[i].src.match(zclipjs + "$");
      if(match) """),format.raw/*35.17*/("""{"""),format.raw/*35.18*/("""
        """),format.raw/*36.9*/("""return match.input.substr(0, match.input.length - 6) + 'swf';
      """),format.raw/*37.7*/("""}"""),format.raw/*37.8*/("""
    """),format.raw/*38.5*/("""}"""),format.raw/*38.6*/("""
  """),format.raw/*39.3*/("""}"""),format.raw/*39.4*/(""")();
  var clip = new ZeroClipboard($("#"""),_display_(/*40.37*/id),format.raw/*40.39*/(""""), """),format.raw/*40.43*/("""{"""),format.raw/*40.44*/("""
    """),format.raw/*41.5*/("""moviePath: moviePath
  """),format.raw/*42.3*/("""}"""),format.raw/*42.4*/(""");
  var title = $('#"""),_display_(/*43.20*/id),format.raw/*43.22*/("""').attr('title');
  $('#"""),_display_(/*44.8*/id),format.raw/*44.10*/("""').removeAttr('title')
  clip.htmlBridge = "#global-zeroclipboard-html-bridge";
  clip.on('complete', function(client, args) """),format.raw/*46.46*/("""{"""),format.raw/*46.47*/("""
    """),format.raw/*47.5*/("""$(clip.htmlBridge).attr('title', 'copied!').tooltip('fixTitle').tooltip('show');
    $(clip.htmlBridge).attr('title', title).tooltip('fixTitle');
  """),format.raw/*49.3*/("""}"""),format.raw/*49.4*/(""");
  $(clip.htmlBridge).tooltip("""),format.raw/*50.30*/("""{"""),format.raw/*50.31*/("""
    """),format.raw/*51.5*/("""title: title,
    placement: $('#"""),_display_(/*52.21*/id),format.raw/*52.23*/("""').attr('data-placement')
  """),format.raw/*53.3*/("""}"""),format.raw/*53.4*/(""");
"""),format.raw/*54.1*/("""}"""),format.raw/*54.2*/(""")();
</script>
"""))}
  }

  def render(id:String,value:String,html:Html): play.twirl.api.HtmlFormat.Appendable = apply(id,value)(html)

  def f:((String,String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (id,value) => (html) => apply(id,value)(html)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/copy.scala.html
                  HASH: 73a4e39f2c116a49dcc20aea82af47eb69e7ef56
                  MATRIX: 355->1|482->40|509->41|592->99|615->103|644->106|681->117|703->119|772->162|797->167|959->302|987->303|1016->306|1108->371|1136->372|1168->377|1310->492|1338->493|1366->494|1404->504|1433->505|1465->510|1673->690|1702->691|1736->698|1790->725|1818->726|1848->729|1876->730|1906->733|2010->809|2039->810|2071->815|2103->820|2126->822|2179->848|2207->849|2238->853|2453->1040|2482->1041|2514->1046|2682->1186|2711->1187|2745->1194|2838->1259|2867->1260|2903->1269|2998->1337|3026->1338|3058->1343|3086->1344|3116->1347|3144->1348|3212->1389|3235->1391|3267->1395|3296->1396|3328->1401|3378->1424|3406->1425|3455->1447|3478->1449|3529->1474|3552->1476|3705->1601|3734->1602|3766->1607|3941->1755|3969->1756|4029->1788|4058->1789|4090->1794|4151->1828|4174->1830|4229->1858|4257->1859|4287->1862|4315->1863
                  LINES: 13->1|16->1|17->2|18->3|18->3|19->4|19->4|19->4|19->4|19->4|23->8|23->8|24->9|26->11|26->11|27->12|29->14|29->14|29->14|29->14|29->14|30->15|32->17|32->17|33->18|34->19|34->19|35->20|35->20|36->21|37->22|37->22|38->23|38->23|38->23|40->25|40->25|42->27|44->29|44->29|45->30|48->33|48->33|49->34|50->35|50->35|51->36|52->37|52->37|53->38|53->38|54->39|54->39|55->40|55->40|55->40|55->40|56->41|57->42|57->42|58->43|58->43|59->44|59->44|61->46|61->46|62->47|64->49|64->49|65->50|65->50|66->51|67->52|67->52|68->53|68->53|69->54|69->54
                  -- GENERATED --
              */
          