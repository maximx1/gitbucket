
package helper.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object branchcontrol extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,service.RepositoryService.RepositoryInfo,Boolean,Html,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(branch: String  = "",
  repository: service.RepositoryService.RepositoryInfo,
  hasWritePermission: Boolean)(body: Html)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*3.74*/("""
"""),_display_(/*6.2*/helper/*6.8*/.html.dropdown(
  value = if(branch.length == 40) branch.substring(0, 10) else branch,
  prefix = if(branch.length == 40) "tree" else if(repository.branchList.contains(branch)) "branch" else "tree",
  mini = true
)/*10.2*/ {_display_(Seq[Any](format.raw/*10.4*/("""
  """),format.raw/*11.3*/("""<li><div id="branch-control-title">Switch branches<button id="branch-control-close" class="pull-right">&times</button></div></li>
  <li><input id="branch-control-input" type="text" placeholder="Find or create branch ..."/></li>
  """),_display_(/*13.4*/body),format.raw/*13.8*/("""
  """),_display_(/*14.4*/if(hasWritePermission)/*14.26*/ {_display_(Seq[Any](format.raw/*14.28*/("""
    """),format.raw/*15.5*/("""<li id="create-branch" style="display: none;">
      <a><form action=""""),_display_(/*16.25*/url(repository)),format.raw/*16.40*/("""/branches" method="post" style="margin: 0;">
        <span class="new-branch-name">Create branch:&nbsp;<span class="new-branch"></span></span>
        <br><span style="padding-left: 17px;">from&nbsp;'"""),_display_(/*18.59*/branch),format.raw/*18.65*/("""'</span>
        <input type="hidden" name="new">
        <input type="hidden" name="from" value=""""),_display_(/*20.50*/branch),format.raw/*20.56*/("""">
      </form></a>
    </li>
  """)))}),format.raw/*23.4*/("""
""")))}),format.raw/*24.2*/("""
"""),format.raw/*25.1*/("""<script>
  $(function()"""),format.raw/*26.15*/("""{"""),format.raw/*26.16*/("""
    """),format.raw/*27.5*/("""$('#branch-control-input').parent().click(function(e) """),format.raw/*27.59*/("""{"""),format.raw/*27.60*/("""
      """),format.raw/*28.7*/("""e.stopPropagation();
    """),format.raw/*29.5*/("""}"""),format.raw/*29.6*/(""");
    $('#branch-control-close').click(function() """),format.raw/*30.49*/("""{"""),format.raw/*30.50*/("""
      """),format.raw/*31.7*/("""$('[data-toggle="dropdown"]').parent().removeClass('open');
    """),format.raw/*32.5*/("""}"""),format.raw/*32.6*/(""");
    $('#branch-control-input').keyup(function() """),format.raw/*33.49*/("""{"""),format.raw/*33.50*/("""
      """),format.raw/*34.7*/("""var inputVal = $('#branch-control-input').val();
      $.each($('#branch-control-input').parent().parent().find('a'), function(index, elem) """),format.raw/*35.92*/("""{"""),format.raw/*35.93*/("""
        """),format.raw/*36.9*/("""if (!inputVal || !elem.text.trim() || elem.text.trim().lastIndexOf(inputVal, 0) >= 0) """),format.raw/*36.95*/("""{"""),format.raw/*36.96*/("""
          """),format.raw/*37.11*/("""$(elem).parent().show();
        """),format.raw/*38.9*/("""}"""),format.raw/*38.10*/(""" """),format.raw/*38.11*/("""else """),format.raw/*38.16*/("""{"""),format.raw/*38.17*/("""
          """),format.raw/*39.11*/("""$(elem).parent().hide();
        """),format.raw/*40.9*/("""}"""),format.raw/*40.10*/("""
      """),format.raw/*41.7*/("""}"""),format.raw/*41.8*/(""");
      """),_display_(/*42.8*/if(hasWritePermission)/*42.30*/ {_display_(Seq[Any](format.raw/*42.32*/("""
        """),format.raw/*43.9*/("""if (inputVal) """),format.raw/*43.23*/("""{"""),format.raw/*43.24*/("""
          """),format.raw/*44.11*/("""$('#create-branch').parent().find('li:last-child').show().find('.new-branch').text(inputVal);
        """),format.raw/*45.9*/("""}"""),format.raw/*45.10*/(""" """),format.raw/*45.11*/("""else """),format.raw/*45.16*/("""{"""),format.raw/*45.17*/("""
          """),format.raw/*46.11*/("""$('#create-branch').parent().find('li:last-child').hide();
        """),format.raw/*47.9*/("""}"""),format.raw/*47.10*/("""
      """)))}),format.raw/*48.8*/("""
    """),format.raw/*49.5*/("""}"""),format.raw/*49.6*/(""");
    """),_display_(/*50.6*/if(hasWritePermission)/*50.28*/ {_display_(Seq[Any](format.raw/*50.30*/("""
      """),format.raw/*51.7*/("""$('#create-branch').click(function() """),format.raw/*51.44*/("""{"""),format.raw/*51.45*/("""
        """),format.raw/*52.9*/("""$(this).find('input[name="new"]').val($('.dropdown-menu input').val())
        $(this).find('form').submit()
       """),format.raw/*54.8*/("""}"""),format.raw/*54.9*/(""");
    """)))}),format.raw/*55.6*/("""
    """),format.raw/*56.5*/("""$('.btn-group').click(function() """),format.raw/*56.38*/("""{"""),format.raw/*56.39*/("""
      """),format.raw/*57.7*/("""$('#branch-control-input').val('');
      $('.dropdown-menu li').show();
      $('#create-branch').hide();
    """),format.raw/*60.5*/("""}"""),format.raw/*60.6*/(""");
  """),format.raw/*61.3*/("""}"""),format.raw/*61.4*/(""");
</script>
"""))}
  }

  def render(branch:String,repository:service.RepositoryService.RepositoryInfo,hasWritePermission:Boolean,body:Html,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(branch,repository,hasWritePermission)(body)(context)

  def f:((String,service.RepositoryService.RepositoryInfo,Boolean) => (Html) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (branch,repository,hasWritePermission) => (body) => (context) => apply(branch,repository,hasWritePermission)(body)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/branchcontrol.scala.html
                  HASH: 071536cbd7e271af7986cf1ad6378962447a44c3
                  MATRIX: 418->1|696->153|723->196|736->202|958->416|997->418|1027->421|1284->652|1308->656|1338->660|1369->682|1409->684|1441->689|1539->760|1575->775|1803->976|1830->982|1956->1081|1983->1087|2047->1121|2079->1123|2107->1124|2158->1147|2187->1148|2219->1153|2301->1207|2330->1208|2364->1215|2416->1240|2444->1241|2523->1292|2552->1293|2586->1300|2677->1364|2705->1365|2784->1416|2813->1417|2847->1424|3015->1564|3044->1565|3080->1574|3194->1660|3223->1661|3262->1672|3322->1705|3351->1706|3380->1707|3413->1712|3442->1713|3481->1724|3541->1757|3570->1758|3604->1765|3632->1766|3668->1776|3699->1798|3739->1800|3775->1809|3817->1823|3846->1824|3885->1835|4014->1937|4043->1938|4072->1939|4105->1944|4134->1945|4173->1956|4267->2023|4296->2024|4334->2032|4366->2037|4394->2038|4428->2046|4459->2068|4499->2070|4533->2077|4598->2114|4627->2115|4663->2124|4806->2240|4834->2241|4872->2249|4904->2254|4965->2287|4994->2288|5028->2295|5166->2406|5194->2407|5226->2412|5254->2413
                  LINES: 13->1|19->3|20->6|20->6|24->10|24->10|25->11|27->13|27->13|28->14|28->14|28->14|29->15|30->16|30->16|32->18|32->18|34->20|34->20|37->23|38->24|39->25|40->26|40->26|41->27|41->27|41->27|42->28|43->29|43->29|44->30|44->30|45->31|46->32|46->32|47->33|47->33|48->34|49->35|49->35|50->36|50->36|50->36|51->37|52->38|52->38|52->38|52->38|52->38|53->39|54->40|54->40|55->41|55->41|56->42|56->42|56->42|57->43|57->43|57->43|58->44|59->45|59->45|59->45|59->45|59->45|60->46|61->47|61->47|62->48|63->49|63->49|64->50|64->50|64->50|65->51|65->51|65->51|66->52|68->54|68->54|69->55|70->56|70->56|70->56|71->57|74->60|74->60|75->61|75->61
                  -- GENERATED --
              */
          