
package issues.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object editcomment extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,Int,String,String,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(content: String, commentId: Int, owner: String, repository: String)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._

Seq[Any](format.raw/*1.101*/("""
"""),format.raw/*3.1*/("""<span id="error-edit-content-"""),_display_(/*3.31*/commentId),format.raw/*3.40*/("""" class="error"></span>
"""),_display_(/*4.2*/helper/*4.8*/.html.attached(owner, repository)/*4.41*/{_display_(Seq[Any](format.raw/*4.42*/("""
  """),format.raw/*5.3*/("""<textarea style="width: 635px; height: 100px;" id="edit-content-"""),_display_(/*5.68*/commentId),format.raw/*5.77*/("""">"""),_display_(/*5.80*/content),format.raw/*5.87*/("""</textarea>
""")))}),format.raw/*6.2*/("""
"""),format.raw/*7.1*/("""<div>
  <input type="button" id="cancel-comment-"""),_display_(/*8.44*/commentId),format.raw/*8.53*/("""" class="btn btn-small btn-danger" value="Cancel"/>
  <input type="button" id="update-comment-"""),_display_(/*9.44*/commentId),format.raw/*9.53*/("""" class="btn btn-small pull-right" value="Update comment"/>
</div>
<script>
$(function()"""),format.raw/*12.13*/("""{"""),format.raw/*12.14*/("""
  """),format.raw/*13.3*/("""var callback = function(data)"""),format.raw/*13.32*/("""{"""),format.raw/*13.33*/("""
    """),format.raw/*14.5*/("""$('#update-comment-"""),_display_(/*14.25*/commentId),format.raw/*14.34*/(""", #cancel-comment-"""),_display_(/*14.53*/commentId),format.raw/*14.62*/("""').removeAttr('disabled');
    $('#commentContent-"""),_display_(/*15.25*/commentId),format.raw/*15.34*/("""').empty().html(data.content);
    prettyPrint();
  """),format.raw/*17.3*/("""}"""),format.raw/*17.4*/(""";

  $('#update-comment-"""),_display_(/*19.23*/commentId),format.raw/*19.32*/("""').click(function()"""),format.raw/*19.51*/("""{"""),format.raw/*19.52*/("""
    """),format.raw/*20.5*/("""$('#update-comment-"""),_display_(/*20.25*/commentId),format.raw/*20.34*/(""", #cancel-comment-"""),_display_(/*20.53*/commentId),format.raw/*20.62*/("""').attr('disabled', 'disabled');
    $.ajax("""),format.raw/*21.12*/("""{"""),format.raw/*21.13*/("""
      """),format.raw/*22.7*/("""url: '"""),_display_(/*22.14*/path),format.raw/*22.18*/("""/"""),_display_(/*22.20*/owner),format.raw/*22.25*/("""/"""),_display_(/*22.27*/repository),format.raw/*22.37*/("""/issue_comments/edit/"""),_display_(/*22.59*/commentId),format.raw/*22.68*/("""',
      type: 'POST',
      data: """),format.raw/*24.13*/("""{"""),format.raw/*24.14*/("""
        """),format.raw/*25.9*/("""issueId : 0,	// TODO
        content : $('#edit-content-"""),_display_(/*26.37*/commentId),format.raw/*26.46*/("""').val()
      """),format.raw/*27.7*/("""}"""),format.raw/*27.8*/("""
    """),format.raw/*28.5*/("""}"""),format.raw/*28.6*/(""").done(
      callback
    ).fail(function(req) """),format.raw/*30.26*/("""{"""),format.raw/*30.27*/("""
      """),format.raw/*31.7*/("""$('#update-comment-"""),_display_(/*31.27*/commentId),format.raw/*31.36*/(""", #cancel-comment-"""),_display_(/*31.55*/commentId),format.raw/*31.64*/("""').removeAttr('disabled');
      $('#error-edit-content-"""),_display_(/*32.31*/commentId),format.raw/*32.40*/("""').text($.parseJSON(req.responseText).content);
    """),format.raw/*33.5*/("""}"""),format.raw/*33.6*/(""");
  """),format.raw/*34.3*/("""}"""),format.raw/*34.4*/(""");

  $('#cancel-comment-"""),_display_(/*36.23*/commentId),format.raw/*36.32*/("""').click(function()"""),format.raw/*36.51*/("""{"""),format.raw/*36.52*/("""
    """),format.raw/*37.5*/("""$('#update-comment-"""),_display_(/*37.25*/commentId),format.raw/*37.34*/(""", #cancel-comment-"""),_display_(/*37.53*/commentId),format.raw/*37.62*/("""').attr('disabled', 'disabled');
    $.get('"""),_display_(/*38.13*/path),format.raw/*38.17*/("""/"""),_display_(/*38.19*/owner),format.raw/*38.24*/("""/"""),_display_(/*38.26*/repository),format.raw/*38.36*/("""/issue_comments/_data/"""),_display_(/*38.59*/commentId),format.raw/*38.68*/("""', callback);
    return false;
  """),format.raw/*40.3*/("""}"""),format.raw/*40.4*/(""");
"""),format.raw/*41.1*/("""}"""),format.raw/*41.2*/(""");
</script>
"""))}
  }

  def render(content:String,commentId:Int,owner:String,repository:String,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(content,commentId,owner,repository)(context)

  def f:((String,Int,String,String) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (content,commentId,owner,repository) => (context) => apply(content,commentId,owner,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/issues/editcomment.scala.html
                  HASH: 3ca054cee5bf81dc82bdb86e81139bb2ae241f41
                  MATRIX: 380->1|584->100|611->119|667->149|696->158|746->183|759->189|800->222|838->223|867->226|958->291|987->300|1016->303|1043->310|1085->323|1112->324|1187->373|1216->382|1337->477|1366->486|1482->574|1511->575|1541->578|1598->607|1627->608|1659->613|1706->633|1736->642|1782->661|1812->670|1890->721|1920->730|1999->782|2027->783|2079->808|2109->817|2156->836|2185->837|2217->842|2264->862|2294->871|2340->890|2370->899|2442->943|2471->944|2505->951|2539->958|2564->962|2593->964|2619->969|2648->971|2679->981|2728->1003|2758->1012|2821->1047|2850->1048|2886->1057|2970->1114|3000->1123|3042->1138|3070->1139|3102->1144|3130->1145|3206->1193|3235->1194|3269->1201|3316->1221|3346->1230|3392->1249|3422->1258|3506->1315|3536->1324|3615->1376|3643->1377|3675->1382|3703->1383|3756->1409|3786->1418|3833->1437|3862->1438|3894->1443|3941->1463|3971->1472|4017->1491|4047->1500|4119->1545|4144->1549|4173->1551|4199->1556|4228->1558|4259->1568|4309->1591|4339->1600|4400->1634|4428->1635|4458->1638|4486->1639
                  LINES: 13->1|16->1|17->3|17->3|17->3|18->4|18->4|18->4|18->4|19->5|19->5|19->5|19->5|19->5|20->6|21->7|22->8|22->8|23->9|23->9|26->12|26->12|27->13|27->13|27->13|28->14|28->14|28->14|28->14|28->14|29->15|29->15|31->17|31->17|33->19|33->19|33->19|33->19|34->20|34->20|34->20|34->20|34->20|35->21|35->21|36->22|36->22|36->22|36->22|36->22|36->22|36->22|36->22|36->22|38->24|38->24|39->25|40->26|40->26|41->27|41->27|42->28|42->28|44->30|44->30|45->31|45->31|45->31|45->31|45->31|46->32|46->32|47->33|47->33|48->34|48->34|50->36|50->36|50->36|50->36|51->37|51->37|51->37|51->37|51->37|52->38|52->38|52->38|52->38|52->38|52->38|52->38|52->38|54->40|54->40|55->41|55->41
                  -- GENERATED --
              */
          