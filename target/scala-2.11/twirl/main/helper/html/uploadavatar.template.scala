
package helper.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object uploadavatar extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Option[model.Account],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: Option[model.Account])(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._

Seq[Any](format.raw/*1.65*/("""
"""),format.raw/*3.1*/("""<div id="avatar" class="muted">
  """),_display_(/*4.4*/if(account.nonEmpty && account.get.image.nonEmpty)/*4.54*/{_display_(Seq[Any](format.raw/*4.55*/("""
    """),format.raw/*5.5*/("""<img src=""""),_display_(/*5.16*/path),format.raw/*5.20*/("""/"""),_display_(/*5.22*/account/*5.29*/.get.userName),format.raw/*5.42*/("""/_avatar" style="with: 120px; height: 120px;"/>
  """)))}/*6.5*/else/*6.10*/{_display_(Seq[Any](format.raw/*6.11*/("""
    """),format.raw/*7.5*/("""<div id="clickable">Upload Image</div>
  """)))}),format.raw/*8.4*/("""
"""),format.raw/*9.1*/("""</div>
"""),_display_(/*10.2*/if(account.nonEmpty && account.get.image.nonEmpty)/*10.52*/{_display_(Seq[Any](format.raw/*10.53*/("""
  """),format.raw/*11.3*/("""<label>
    <input type="checkbox" name="clearImage"/> Clear image
  </label>
""")))}),format.raw/*14.2*/("""
"""),format.raw/*15.1*/("""<input type="hidden" name="fileId" value=""/>
"""),_display_(/*16.2*/if(account.isEmpty || account.get.image.isEmpty)/*16.50*/{_display_(Seq[Any](format.raw/*16.51*/("""
"""),format.raw/*17.1*/("""<script>
$(function()"""),format.raw/*18.13*/("""{"""),format.raw/*18.14*/("""
  """),format.raw/*19.3*/("""var dropzone = new Dropzone('div#clickable', """),format.raw/*19.48*/("""{"""),format.raw/*19.49*/("""
    """),format.raw/*20.5*/("""url: '"""),_display_(/*20.12*/path),format.raw/*20.16*/("""/upload/image',
    previewsContainer: 'div#avatar',
    parallelUploads: 1,
    thumbnailWidth: 120,
    thumbnailHeight: 120
  """),format.raw/*25.3*/("""}"""),format.raw/*25.4*/(""");

  dropzone.on("success", function(file, id)"""),format.raw/*27.44*/("""{"""),format.raw/*27.45*/("""
    """),format.raw/*28.5*/("""$('div#clickable').remove();
    $('input[name=fileId]').val(id);
  """),format.raw/*30.3*/("""}"""),format.raw/*30.4*/(""");
"""),format.raw/*31.1*/("""}"""),format.raw/*31.2*/(""");
</script>
""")))}),format.raw/*33.2*/("""
"""),format.raw/*34.1*/("""<style type="text/css">
div.dz-filename, div.dz-size, div.dz-progress, div.dz-success-mark, div.dz-error-mark, div.dz-error-message """),format.raw/*35.109*/("""{"""),format.raw/*35.110*/("""
  """),format.raw/*36.3*/("""display: none;
"""),format.raw/*37.1*/("""}"""),format.raw/*37.2*/("""

"""),format.raw/*39.1*/("""div#clickable """),format.raw/*39.15*/("""{"""),format.raw/*39.16*/("""
  """),format.raw/*40.3*/("""width: 100%;
  text-align: center;
  line-height: 120px;
"""),format.raw/*43.1*/("""}"""),format.raw/*43.2*/("""

"""),format.raw/*45.1*/("""div#avatar """),format.raw/*45.12*/("""{"""),format.raw/*45.13*/("""
  """),format.raw/*46.3*/("""background-color: #f8f8f8;
  border: 1px dashed silver;
  width: 120px;
  height: 120px;
"""),format.raw/*50.1*/("""}"""),format.raw/*50.2*/("""
"""),format.raw/*51.1*/("""</style>"""))}
  }

  def render(account:Option[model.Account],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(account)(context)

  def f:((Option[model.Account]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (account) => (context) => apply(account)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/uploadavatar.scala.html
                  HASH: 414dc3784e6a511c267757eb5ef598796f6a83e8
                  MATRIX: 378->1|545->64|572->83|632->118|690->168|728->169|759->174|796->185|820->189|848->191|863->198|896->211|964->263|976->268|1014->269|1045->274|1116->316|1143->317|1177->325|1236->375|1275->376|1305->379|1414->458|1442->459|1515->506|1572->554|1611->555|1639->556|1688->577|1717->578|1747->581|1820->626|1849->627|1881->632|1915->639|1940->643|2096->772|2124->773|2199->820|2228->821|2260->826|2355->894|2383->895|2413->898|2441->899|2485->913|2513->914|2674->1046|2704->1047|2734->1050|2776->1065|2804->1066|2833->1068|2875->1082|2904->1083|2934->1086|3018->1143|3046->1144|3075->1146|3114->1157|3143->1158|3173->1161|3289->1250|3317->1251|3345->1252
                  LINES: 13->1|16->1|17->3|18->4|18->4|18->4|19->5|19->5|19->5|19->5|19->5|19->5|20->6|20->6|20->6|21->7|22->8|23->9|24->10|24->10|24->10|25->11|28->14|29->15|30->16|30->16|30->16|31->17|32->18|32->18|33->19|33->19|33->19|34->20|34->20|34->20|39->25|39->25|41->27|41->27|42->28|44->30|44->30|45->31|45->31|47->33|48->34|49->35|49->35|50->36|51->37|51->37|53->39|53->39|53->39|54->40|57->43|57->43|59->45|59->45|59->45|60->46|64->50|64->50|65->51
                  -- GENERATED --
              */
          