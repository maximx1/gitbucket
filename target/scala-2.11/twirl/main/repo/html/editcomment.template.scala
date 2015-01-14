
package repo.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object editcomment extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,Int,String,String,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(content: String, commentId: Int, owner: String, repository: String)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._

Seq[Any](format.raw/*1.101*/("""
"""),format.raw/*3.1*/("""<span class="error-edit-content-"""),_display_(/*3.34*/commentId),format.raw/*3.43*/(""" """),format.raw/*3.44*/("""error"></span>
"""),_display_(/*4.2*/helper/*4.8*/.html.attached(owner, repository)/*4.41*/{_display_(Seq[Any](format.raw/*4.42*/("""
  """),format.raw/*5.3*/("""<textarea style="width: 635px; height: 100px;" id="edit-content-"""),_display_(/*5.68*/commentId),format.raw/*5.77*/("""">"""),_display_(/*5.80*/content),format.raw/*5.87*/("""</textarea>
""")))}),format.raw/*6.2*/("""
"""),format.raw/*7.1*/("""<div>
  <input type="button" class="cancel-comment-"""),_display_(/*8.47*/commentId),format.raw/*8.56*/(""" """),format.raw/*8.57*/("""btn btn-small btn-danger" value="Cancel"/>
  <input type="button" class="update-comment-"""),_display_(/*9.47*/commentId),format.raw/*9.56*/(""" """),format.raw/*9.57*/("""btn btn-small pull-right" value="Update comment"/>
</div>
<script>
$(function()"""),format.raw/*12.13*/("""{"""),format.raw/*12.14*/("""
  """),format.raw/*13.3*/("""var curriedCallback = function($box) """),format.raw/*13.40*/("""{"""),format.raw/*13.41*/("""
    """),format.raw/*14.5*/("""return function(data)"""),format.raw/*14.26*/("""{"""),format.raw/*14.27*/("""
      """),format.raw/*15.7*/("""$('.update-comment-"""),_display_(/*15.27*/commentId),format.raw/*15.36*/(""", .cancel-comment-"""),_display_(/*15.55*/commentId),format.raw/*15.64*/("""', $box).removeAttr('disabled');
      $('.commit-commentContent-"""),_display_(/*16.34*/commentId),format.raw/*16.43*/("""').empty().html(data.content);
      prettyPrint();
    """),format.raw/*18.5*/("""}"""),format.raw/*18.6*/("""
  """),format.raw/*19.3*/("""}"""),format.raw/*19.4*/("""

  """),format.raw/*21.3*/("""$(document).on('click', '.update-comment-"""),_display_(/*21.45*/commentId),format.raw/*21.54*/("""', function()"""),format.raw/*21.67*/("""{"""),format.raw/*21.68*/("""
    """),format.raw/*22.5*/("""$box = $(this).closest('.box');
    $('.update-comment-"""),_display_(/*23.25*/commentId),format.raw/*23.34*/(""", .cancel-comment-"""),_display_(/*23.53*/commentId),format.raw/*23.62*/("""', $box).attr('disabled', 'disabled');
    $.ajax("""),format.raw/*24.12*/("""{"""),format.raw/*24.13*/("""
      """),format.raw/*25.7*/("""url: '"""),_display_(/*25.14*/path),format.raw/*25.18*/("""/"""),_display_(/*25.20*/owner),format.raw/*25.25*/("""/"""),_display_(/*25.27*/repository),format.raw/*25.37*/("""/commit_comments/edit/"""),_display_(/*25.60*/commentId),format.raw/*25.69*/("""',
      type: 'POST',
      data: """),format.raw/*27.13*/("""{"""),format.raw/*27.14*/("""
        """),format.raw/*28.9*/("""content : $('#edit-content-"""),_display_(/*28.37*/commentId),format.raw/*28.46*/("""', $box).val()
      """),format.raw/*29.7*/("""}"""),format.raw/*29.8*/("""
    """),format.raw/*30.5*/("""}"""),format.raw/*30.6*/(""").done(
      curriedCallback($box)
    ).fail(function(req) """),format.raw/*32.26*/("""{"""),format.raw/*32.27*/("""
      """),format.raw/*33.7*/("""$('.update-comment-"""),_display_(/*33.27*/commentId),format.raw/*33.36*/(""", .cancel-comment-"""),_display_(/*33.55*/commentId),format.raw/*33.64*/("""', $box).removeAttr('disabled');
      $('.error-edit-content-"""),_display_(/*34.31*/commentId),format.raw/*34.40*/("""', $box).text($.parseJSON(req.responseText).content);
    """),format.raw/*35.5*/("""}"""),format.raw/*35.6*/(""");
  """),format.raw/*36.3*/("""}"""),format.raw/*36.4*/(""");

  $(document).on('click', '.cancel-comment-"""),_display_(/*38.45*/commentId),format.raw/*38.54*/("""', function()"""),format.raw/*38.67*/("""{"""),format.raw/*38.68*/("""
    """),format.raw/*39.5*/("""$box = $(this).closest('.box');
    $('.update-comment-"""),_display_(/*40.25*/commentId),format.raw/*40.34*/(""", .cancel-comment-"""),_display_(/*40.53*/commentId),format.raw/*40.62*/("""', $box).attr('disabled', 'disabled');
    $.get('"""),_display_(/*41.13*/path),format.raw/*41.17*/("""/"""),_display_(/*41.19*/owner),format.raw/*41.24*/("""/"""),_display_(/*41.26*/repository),format.raw/*41.36*/("""/commit_comments/_data/"""),_display_(/*41.60*/commentId),format.raw/*41.69*/("""', curriedCallback($box));
    return false;
  """),format.raw/*43.3*/("""}"""),format.raw/*43.4*/(""");
"""),format.raw/*44.1*/("""}"""),format.raw/*44.2*/(""");
</script>
"""))}
  }

  def render(content:String,commentId:Int,owner:String,repository:String,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(content,commentId,owner,repository)(context)

  def f:((String,Int,String,String) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (content,commentId,owner,repository) => (context) => apply(content,commentId,owner,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/repo/editcomment.scala.html
                  HASH: 9813e3d864ff9af767b7661c125d27223ab6ade7
                  MATRIX: 378->1|582->100|609->119|668->152|697->161|725->162|766->178|779->184|820->217|858->218|887->221|978->286|1007->295|1036->298|1063->305|1105->318|1132->319|1210->371|1239->380|1267->381|1382->470|1411->479|1439->480|1546->559|1575->560|1605->563|1670->600|1699->601|1731->606|1780->627|1809->628|1843->635|1890->655|1920->664|1966->683|1996->692|2089->758|2119->767|2202->823|2230->824|2260->827|2288->828|2319->832|2388->874|2418->883|2459->896|2488->897|2520->902|2603->958|2633->967|2679->986|2709->995|2787->1045|2816->1046|2850->1053|2884->1060|2909->1064|2938->1066|2964->1071|2993->1073|3024->1083|3074->1106|3104->1115|3167->1150|3196->1151|3232->1160|3287->1188|3317->1197|3365->1218|3393->1219|3425->1224|3453->1225|3542->1286|3571->1287|3605->1294|3652->1314|3682->1323|3728->1342|3758->1351|3848->1414|3878->1423|3963->1481|3991->1482|4023->1487|4051->1488|4126->1536|4156->1545|4197->1558|4226->1559|4258->1564|4341->1620|4371->1629|4417->1648|4447->1657|4525->1708|4550->1712|4579->1714|4605->1719|4634->1721|4665->1731|4716->1755|4746->1764|4820->1811|4848->1812|4878->1815|4906->1816
                  LINES: 13->1|16->1|17->3|17->3|17->3|17->3|18->4|18->4|18->4|18->4|19->5|19->5|19->5|19->5|19->5|20->6|21->7|22->8|22->8|22->8|23->9|23->9|23->9|26->12|26->12|27->13|27->13|27->13|28->14|28->14|28->14|29->15|29->15|29->15|29->15|29->15|30->16|30->16|32->18|32->18|33->19|33->19|35->21|35->21|35->21|35->21|35->21|36->22|37->23|37->23|37->23|37->23|38->24|38->24|39->25|39->25|39->25|39->25|39->25|39->25|39->25|39->25|39->25|41->27|41->27|42->28|42->28|42->28|43->29|43->29|44->30|44->30|46->32|46->32|47->33|47->33|47->33|47->33|47->33|48->34|48->34|49->35|49->35|50->36|50->36|52->38|52->38|52->38|52->38|53->39|54->40|54->40|54->40|54->40|55->41|55->41|55->41|55->41|55->41|55->41|55->41|55->41|57->43|57->43|58->44|58->44
                  -- GENERATED --
              */
          