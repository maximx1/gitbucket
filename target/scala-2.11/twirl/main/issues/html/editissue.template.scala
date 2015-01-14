
package issues.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object editissue extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Option[String],Int,String,String,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(content: Option[String], issueId: Int, owner: String, repository: String)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._

Seq[Any](format.raw/*1.107*/("""
"""),_display_(/*3.2*/helper/*3.8*/.html.attached(owner, repository)/*3.41*/{_display_(Seq[Any](format.raw/*3.42*/("""
  """),format.raw/*4.3*/("""<textarea style="width: 635px; height: 100px; max-height: 300px;" id="edit-content">"""),_display_(/*4.88*/content/*4.95*/.getOrElse("")),format.raw/*4.109*/("""</textarea>
""")))}),format.raw/*5.2*/("""
"""),format.raw/*6.1*/("""<div>
  <input type="button" id="cancel-issue" class="btn btn-small btn-danger" value="Cancel"/>
  <input type="button" id="update-issue" class="btn btn-small pull-right" value="Update comment"/>
</div>
<script>
$(function()"""),format.raw/*11.13*/("""{"""),format.raw/*11.14*/("""
  """),format.raw/*12.3*/("""var callback = function(data)"""),format.raw/*12.32*/("""{"""),format.raw/*12.33*/("""
    """),format.raw/*13.5*/("""$('#update, #cancel').removeAttr('disabled');
    $('#issueContent').empty().html(data.content);
  """),format.raw/*15.3*/("""}"""),format.raw/*15.4*/(""";

  $('#update-issue').click(function()"""),format.raw/*17.38*/("""{"""),format.raw/*17.39*/("""
    """),format.raw/*18.5*/("""$('#update, #cancel').attr('disabled', 'disabled');
    $.ajax("""),format.raw/*19.12*/("""{"""),format.raw/*19.13*/("""
      """),format.raw/*20.7*/("""url: '"""),_display_(/*20.14*/path),format.raw/*20.18*/("""/"""),_display_(/*20.20*/owner),format.raw/*20.25*/("""/"""),_display_(/*20.27*/repository),format.raw/*20.37*/("""/issues/edit/"""),_display_(/*20.51*/issueId),format.raw/*20.58*/("""',
      type: 'POST',
      data: """),format.raw/*22.13*/("""{"""),format.raw/*22.14*/("""
        """),format.raw/*23.9*/("""content : $('#edit-content').val()
      """),format.raw/*24.7*/("""}"""),format.raw/*24.8*/("""
    """),format.raw/*25.5*/("""}"""),format.raw/*25.6*/(""").done(
      callback
    ).fail(function(req) """),format.raw/*27.26*/("""{"""),format.raw/*27.27*/("""
      """),format.raw/*28.7*/("""$('#update, #cancel').removeAttr('disabled');
    """),format.raw/*29.5*/("""}"""),format.raw/*29.6*/(""");
  """),format.raw/*30.3*/("""}"""),format.raw/*30.4*/(""");

  $('#cancel-issue').click(function()"""),format.raw/*32.38*/("""{"""),format.raw/*32.39*/("""
    """),format.raw/*33.5*/("""$('#update, #cancel').attr('disabled', 'disabled');
    $.get('"""),_display_(/*34.13*/path),format.raw/*34.17*/("""/"""),_display_(/*34.19*/owner),format.raw/*34.24*/("""/"""),_display_(/*34.26*/repository),format.raw/*34.36*/("""/issues/_data/"""),_display_(/*34.51*/issueId),format.raw/*34.58*/("""', callback);
    return false;
  """),format.raw/*36.3*/("""}"""),format.raw/*36.4*/(""");
"""),format.raw/*37.1*/("""}"""),format.raw/*37.2*/(""");
</script>
"""))}
  }

  def render(content:Option[String],issueId:Int,owner:String,repository:String,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(content,issueId,owner,repository)(context)

  def f:((Option[String],Int,String,String) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (content,issueId,owner,repository) => (context) => apply(content,issueId,owner,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/issues/editissue.scala.html
                  HASH: 9a1e358a5f405cfcb06459b8bd5740add6a74f1e
                  MATRIX: 386->1|596->106|623->126|636->132|677->165|715->166|744->169|855->254|870->261|905->275|947->288|974->289|1226->513|1255->514|1285->517|1342->546|1371->547|1403->552|1529->651|1557->652|1625->692|1654->693|1686->698|1777->761|1806->762|1840->769|1874->776|1899->780|1928->782|1954->787|1983->789|2014->799|2055->813|2083->820|2146->855|2175->856|2211->865|2279->906|2307->907|2339->912|2367->913|2443->961|2472->962|2506->969|2583->1019|2611->1020|2643->1025|2671->1026|2740->1067|2769->1068|2801->1073|2892->1137|2917->1141|2946->1143|2972->1148|3001->1150|3032->1160|3074->1175|3102->1182|3163->1216|3191->1217|3221->1220|3249->1221
                  LINES: 13->1|16->1|17->3|17->3|17->3|17->3|18->4|18->4|18->4|18->4|19->5|20->6|25->11|25->11|26->12|26->12|26->12|27->13|29->15|29->15|31->17|31->17|32->18|33->19|33->19|34->20|34->20|34->20|34->20|34->20|34->20|34->20|34->20|34->20|36->22|36->22|37->23|38->24|38->24|39->25|39->25|41->27|41->27|42->28|43->29|43->29|44->30|44->30|46->32|46->32|47->33|48->34|48->34|48->34|48->34|48->34|48->34|48->34|48->34|50->36|50->36|51->37|51->37
                  -- GENERATED --
              */
          