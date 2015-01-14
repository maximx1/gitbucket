
package helper.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object attached extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,String,Html,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(owner: String, repository: String)(textarea: Html)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._

Seq[Any](format.raw/*1.84*/("""
"""),format.raw/*3.1*/("""<div class="muted attachable">
  """),_display_(/*4.4*/textarea),format.raw/*4.12*/("""
  """),format.raw/*5.3*/("""<div class="clickable">Attach images by dragging &amp; dropping, or selecting them.</div>
</div>
"""),_display_(/*7.2*/defining("(id=\")([\\w\\-]*)(\")".r.findFirstMatchIn(textarea.body).map(_.group(2)))/*7.86*/{ textareaId =>_display_(Seq[Any](format.raw/*7.101*/("""
"""),format.raw/*8.1*/("""<script>
$(function()"""),format.raw/*9.13*/("""{"""),format.raw/*9.14*/("""
  """),format.raw/*10.3*/("""try """),format.raw/*10.7*/("""{"""),format.raw/*10.8*/("""
    """),format.raw/*11.5*/("""$([$('#"""),_display_(/*11.13*/textareaId),format.raw/*11.23*/("""').closest('div')[0], $('#"""),_display_(/*11.50*/textareaId),format.raw/*11.60*/("""').next('div')[0]]).dropzone("""),format.raw/*11.89*/("""{"""),format.raw/*11.90*/("""
      """),format.raw/*12.7*/("""url: '"""),_display_(/*12.14*/path),format.raw/*12.18*/("""/upload/image/"""),_display_(/*12.33*/owner),format.raw/*12.38*/("""/"""),_display_(/*12.40*/repository),format.raw/*12.50*/("""',
      maxFilesize: 10,
      acceptedFiles: 'image/*',
      dictInvalidFileType: 'Unfortunately, we don\'t support that file type. Try again with a PNG, GIF, or JPG.',
      previewTemplate: "<div class=\"dz-preview\">\n  <div class=\"dz-progress\"><span class=\"dz-upload\" data-dz-uploadprogress>Uploading your images...</span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>",
      success: function(file, id) """),format.raw/*17.35*/("""{"""),format.raw/*17.36*/("""
        """),format.raw/*18.9*/("""var images = '\n![' + file.name.split('.')[0] + ']("""),_display_(/*18.61*/baseUrl),format.raw/*18.68*/("""/"""),_display_(/*18.70*/owner),format.raw/*18.75*/("""/"""),_display_(/*18.77*/repository),format.raw/*18.87*/("""/_attached/' + id + ')';
        $('#"""),_display_(/*19.14*/textareaId),format.raw/*19.24*/("""').val($('#"""),_display_(/*19.36*/textareaId),format.raw/*19.46*/("""').val() + images);
        $(file.previewElement).prevAll('div.dz-preview').addBack().remove();
      """),format.raw/*21.7*/("""}"""),format.raw/*21.8*/("""
    """),format.raw/*22.5*/("""}"""),format.raw/*22.6*/(""");
  """),format.raw/*23.3*/("""}"""),format.raw/*23.4*/(""" """),format.raw/*23.5*/("""catch(e) """),format.raw/*23.14*/("""{"""),format.raw/*23.15*/("""
    """),format.raw/*24.5*/("""if (e.message !== "Dropzone already attached.") """),format.raw/*24.53*/("""{"""),format.raw/*24.54*/("""
      """),format.raw/*25.7*/("""throw e;
    """),format.raw/*26.5*/("""}"""),format.raw/*26.6*/("""
  """),format.raw/*27.3*/("""}"""),format.raw/*27.4*/("""

  """),format.raw/*29.3*/("""// Adjust clickable area width
  $('#"""),_display_(/*30.8*/textareaId),format.raw/*30.18*/("""').next('div.clickable').css('width', ($('#"""),_display_(/*30.62*/textareaId),format.raw/*30.72*/("""').width() + 8) + 'px');
"""),format.raw/*31.1*/("""}"""),format.raw/*31.2*/(""");
</script>
""")))}),format.raw/*33.2*/("""
"""))}
  }

  def render(owner:String,repository:String,textarea:Html,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(owner,repository)(textarea)(context)

  def f:((String,String) => (Html) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (owner,repository) => (textarea) => (context) => apply(owner,repository)(textarea)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/attached.scala.html
                  HASH: 36edb50ab25d5a0891d9cc08bf3a8d46d84af24f
                  MATRIX: 371->1|557->83|584->102|643->136|671->144|700->147|823->245|915->329|968->344|995->345|1043->366|1071->367|1101->370|1132->374|1160->375|1192->380|1227->388|1258->398|1312->425|1343->435|1400->464|1429->465|1463->472|1497->479|1522->483|1564->498|1590->503|1619->505|1650->515|2138->975|2167->976|2203->985|2282->1037|2310->1044|2339->1046|2365->1051|2394->1053|2425->1063|2490->1101|2521->1111|2560->1123|2591->1133|2721->1236|2749->1237|2781->1242|2809->1243|2841->1248|2869->1249|2897->1250|2934->1259|2963->1260|2995->1265|3071->1313|3100->1314|3134->1321|3174->1334|3202->1335|3232->1338|3260->1339|3291->1343|3355->1381|3386->1391|3457->1435|3488->1445|3540->1470|3568->1471|3612->1485
                  LINES: 13->1|16->1|17->3|18->4|18->4|19->5|21->7|21->7|21->7|22->8|23->9|23->9|24->10|24->10|24->10|25->11|25->11|25->11|25->11|25->11|25->11|25->11|26->12|26->12|26->12|26->12|26->12|26->12|26->12|31->17|31->17|32->18|32->18|32->18|32->18|32->18|32->18|32->18|33->19|33->19|33->19|33->19|35->21|35->21|36->22|36->22|37->23|37->23|37->23|37->23|37->23|38->24|38->24|38->24|39->25|40->26|40->26|41->27|41->27|43->29|44->30|44->30|44->30|44->30|45->31|45->31|47->33
                  -- GENERATED --
              */
          