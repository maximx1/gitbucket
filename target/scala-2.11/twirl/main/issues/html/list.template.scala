
package issues.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object list extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template12[String,List[service.IssuesService.IssueInfo],Int,List[String],List[model.Milestone],List[model.Label],Int,Int,service.IssuesService.IssueSearchCondition,service.RepositoryService.RepositoryInfo,Boolean,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(target: String,
  issues: List[service.IssuesService.IssueInfo],
  page: Int,
  collaborators: List[String],
  milestones: List[model.Milestone],
  labels: List[model.Label],
  openCount: Int,
  closedCount: Int,
  condition: service.IssuesService.IssueSearchCondition,
  repository: service.RepositoryService.RepositoryInfo,
  hasWritePermission: Boolean)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*11.62*/("""
"""),_display_(/*14.2*/html/*14.6*/.main((if(target == "issues") "Issues" else "Pull requests") + s" - ${repository.owner}/${repository.name}", Some(repository))/*14.132*/{_display_(Seq[Any](format.raw/*14.133*/("""
  """),_display_(/*15.4*/html/*15.8*/.menu(target, repository)/*15.33*/{_display_(Seq[Any](format.raw/*15.34*/("""
    """),_display_(/*16.6*/navigation(target, true, repository, Some(condition))),format.raw/*16.59*/("""
    """),_display_(/*17.6*/listparts(target, issues, page, openCount, closedCount, condition, collaborators, milestones, labels, Some(repository), hasWritePermission)),format.raw/*17.145*/("""
    """),_display_(/*18.6*/if(hasWritePermission)/*18.28*/{_display_(Seq[Any](format.raw/*18.29*/("""
      """),format.raw/*19.7*/("""<form id="batcheditForm" method="POST">
        <input type="hidden" name="value"/>
        <input type="hidden" name="checked"/>
        <input type="hidden" name="from" value=""""),_display_(/*22.50*/target),format.raw/*22.56*/(""""/>
      </form>
    """)))}),format.raw/*24.6*/("""
  """)))}),format.raw/*25.4*/("""
""")))}),format.raw/*26.2*/("""
"""),_display_(/*27.2*/if(hasWritePermission)/*27.24*/{_display_(Seq[Any](format.raw/*27.25*/("""
"""),format.raw/*28.1*/("""<script>
$(function()"""),format.raw/*29.13*/("""{"""),format.raw/*29.14*/("""
  """),format.raw/*30.3*/("""$('a.header-link').mouseover(function(e)"""),format.raw/*30.43*/("""{"""),format.raw/*30.44*/("""
    """),format.raw/*31.5*/("""var target = e.target;
    if(e.target.tagName != 'A')"""),format.raw/*32.32*/("""{"""),format.raw/*32.33*/("""
      """),format.raw/*33.7*/("""target = e.target.parentElement;
    """),format.raw/*34.5*/("""}"""),format.raw/*34.6*/("""
    """),format.raw/*35.5*/("""$(target).children('strong'               ).css('color', '#0088cc');
    $(target).children('img.header-icon-hover').css('display', 'inline');
    $(target).children('img.header-icon'      ).css('display', 'none');
  """),format.raw/*38.3*/("""}"""),format.raw/*38.4*/(""");

  $('a.header-link').mouseout(function(e)"""),format.raw/*40.42*/("""{"""),format.raw/*40.43*/("""
    """),format.raw/*41.5*/("""var target = e.target;
    if(e.target.tagName != 'A')"""),format.raw/*42.32*/("""{"""),format.raw/*42.33*/("""
      """),format.raw/*43.7*/("""target = e.target.parentElement;
    """),format.raw/*44.5*/("""}"""),format.raw/*44.6*/("""
    """),format.raw/*45.5*/("""$(target).children('strong'               ).css('color', 'black');
    $(target).children('img.header-icon-hover').css('display', 'none');
    $(target).children('img.header-icon'      ).css('display', 'inline');
  """),format.raw/*48.3*/("""}"""),format.raw/*48.4*/(""");

  $('.table-issues input[type=checkbox]').change(function()"""),format.raw/*50.60*/("""{"""),format.raw/*50.61*/("""
    """),format.raw/*51.5*/("""if($('.table-issues input[type=checkbox]').filter(':checked').length == 0)"""),format.raw/*51.79*/("""{"""),format.raw/*51.80*/("""
      """),format.raw/*52.7*/("""$('#table-issues-control').show();
      $('#table-issues-batchedit').hide();
    """),format.raw/*54.5*/("""}"""),format.raw/*54.6*/(""" """),format.raw/*54.7*/("""else """),format.raw/*54.12*/("""{"""),format.raw/*54.13*/("""
      """),format.raw/*55.7*/("""$('#table-issues-control').hide();
      $('#table-issues-batchedit').show();
    """),format.raw/*57.5*/("""}"""),format.raw/*57.6*/("""
  """),format.raw/*58.3*/("""}"""),format.raw/*58.4*/(""").filter(':first').change();

  var submitBatchEdit = function(action, value) """),format.raw/*60.49*/("""{"""),format.raw/*60.50*/("""
    """),format.raw/*61.5*/("""var checked = $('.table-issues input[type=checkbox]').filter(':checked').map(function()"""),format.raw/*61.92*/("""{"""),format.raw/*61.93*/(""" """),format.raw/*61.94*/("""return this.value; """),format.raw/*61.113*/("""}"""),format.raw/*61.114*/(""").get().join();
    var form = $('#batcheditForm');
    form.find('input[name=value]').val(value);
    form.find('input[name=checked]').val(checked);
    form.attr('action', action);
    form.submit();
  """),format.raw/*67.3*/("""}"""),format.raw/*67.4*/(""";

  $('a.toggle-state').click(function()"""),format.raw/*69.39*/("""{"""),format.raw/*69.40*/("""
    """),format.raw/*70.5*/("""submitBatchEdit('"""),_display_(/*70.23*/url(repository)),format.raw/*70.38*/("""/issues/batchedit/state', $(this).data('id'));
  """),format.raw/*71.3*/("""}"""),format.raw/*71.4*/(""");
  $('a.toggle-label').click(function()"""),format.raw/*72.39*/("""{"""),format.raw/*72.40*/("""
    """),format.raw/*73.5*/("""submitBatchEdit('"""),_display_(/*73.23*/url(repository)),format.raw/*73.38*/("""/issues/batchedit/label', $(this).data('id'));
  """),format.raw/*74.3*/("""}"""),format.raw/*74.4*/(""");
  $('a.toggle-assign').click(function()"""),format.raw/*75.40*/("""{"""),format.raw/*75.41*/("""
    """),format.raw/*76.5*/("""submitBatchEdit('"""),_display_(/*76.23*/url(repository)),format.raw/*76.38*/("""/issues/batchedit/assign', $(this).data('name'));
  """),format.raw/*77.3*/("""}"""),format.raw/*77.4*/(""");
  $('a.toggle-milestone').click(function()"""),format.raw/*78.43*/("""{"""),format.raw/*78.44*/("""
    """),format.raw/*79.5*/("""submitBatchEdit('"""),_display_(/*79.23*/url(repository)),format.raw/*79.38*/("""/issues/batchedit/milestone', $(this).data('id'));
  """),format.raw/*80.3*/("""}"""),format.raw/*80.4*/(""");
"""),format.raw/*81.1*/("""}"""),format.raw/*81.2*/(""");
</script>
""")))}),format.raw/*83.2*/("""
"""))}
  }

  def render(target:String,issues:List[service.IssuesService.IssueInfo],page:Int,collaborators:List[String],milestones:List[model.Milestone],labels:List[model.Label],openCount:Int,closedCount:Int,condition:service.IssuesService.IssueSearchCondition,repository:service.RepositoryService.RepositoryInfo,hasWritePermission:Boolean,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(target,issues,page,collaborators,milestones,labels,openCount,closedCount,condition,repository,hasWritePermission)(context)

  def f:((String,List[service.IssuesService.IssueInfo],Int,List[String],List[model.Milestone],List[model.Label],Int,Int,service.IssuesService.IssueSearchCondition,service.RepositoryService.RepositoryInfo,Boolean) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (target,issues,page,collaborators,milestones,labels,openCount,closedCount,condition,repository,hasWritePermission) => (context) => apply(target,issues,page,collaborators,milestones,labels,openCount,closedCount,condition,repository,hasWritePermission)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/issues/list.scala.html
                  HASH: fe61ba49f5217100508adea7030e33a3a7414053
                  MATRIX: 551->1|1066->389|1094->432|1106->436|1242->562|1282->563|1312->567|1324->571|1358->596|1397->597|1429->603|1503->656|1535->662|1696->801|1728->807|1759->829|1798->830|1832->837|2038->1016|2065->1022|2118->1045|2152->1049|2184->1051|2212->1053|2243->1075|2282->1076|2310->1077|2359->1098|2388->1099|2418->1102|2486->1142|2515->1143|2547->1148|2629->1202|2658->1203|2692->1210|2756->1247|2784->1248|2816->1253|3060->1470|3088->1471|3161->1516|3190->1517|3222->1522|3304->1576|3333->1577|3367->1584|3431->1621|3459->1622|3491->1627|3733->1842|3761->1843|3852->1906|3881->1907|3913->1912|4015->1986|4044->1987|4078->1994|4187->2076|4215->2077|4243->2078|4276->2083|4305->2084|4339->2091|4448->2173|4476->2174|4506->2177|4534->2178|4640->2256|4669->2257|4701->2262|4816->2349|4845->2350|4874->2351|4922->2370|4952->2371|5183->2575|5211->2576|5280->2617|5309->2618|5341->2623|5386->2641|5422->2656|5498->2705|5526->2706|5595->2747|5624->2748|5656->2753|5701->2771|5737->2786|5813->2835|5841->2836|5911->2878|5940->2879|5972->2884|6017->2902|6053->2917|6132->2969|6160->2970|6233->3015|6262->3016|6294->3021|6339->3039|6375->3054|6455->3107|6483->3108|6513->3111|6541->3112|6585->3126
                  LINES: 13->1|27->11|28->14|28->14|28->14|28->14|29->15|29->15|29->15|29->15|30->16|30->16|31->17|31->17|32->18|32->18|32->18|33->19|36->22|36->22|38->24|39->25|40->26|41->27|41->27|41->27|42->28|43->29|43->29|44->30|44->30|44->30|45->31|46->32|46->32|47->33|48->34|48->34|49->35|52->38|52->38|54->40|54->40|55->41|56->42|56->42|57->43|58->44|58->44|59->45|62->48|62->48|64->50|64->50|65->51|65->51|65->51|66->52|68->54|68->54|68->54|68->54|68->54|69->55|71->57|71->57|72->58|72->58|74->60|74->60|75->61|75->61|75->61|75->61|75->61|75->61|81->67|81->67|83->69|83->69|84->70|84->70|84->70|85->71|85->71|86->72|86->72|87->73|87->73|87->73|88->74|88->74|89->75|89->75|90->76|90->76|90->76|91->77|91->77|92->78|92->78|93->79|93->79|93->79|94->80|94->80|95->81|95->81|97->83
                  -- GENERATED --
              */
          