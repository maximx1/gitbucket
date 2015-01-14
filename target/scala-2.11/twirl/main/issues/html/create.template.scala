
package issues.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object create extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[List[String],List[model.Milestone],List[model.Label],Boolean,service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(collaborators: List[String],
  milestones: List[model.Milestone],
  labels: List[model.Label],
  hasWritePermission: Boolean,
  repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*5.87*/("""
"""),_display_(/*8.2*/html/*8.6*/.main(s"New Issue - ${repository.owner}/${repository.name}", Some(repository))/*8.84*/{_display_(Seq[Any](format.raw/*8.85*/("""
  """),_display_(/*9.4*/html/*9.8*/.menu("issues", repository)/*9.35*/{_display_(Seq[Any](format.raw/*9.36*/("""
    """),_display_(/*10.6*/navigation("issues", false, repository)),format.raw/*10.45*/("""
    """),format.raw/*11.5*/("""<br/><br/><hr style="margin-bottom: 10px;">
    <form action=""""),_display_(/*12.20*/url(repository)),format.raw/*12.35*/("""/issues/new" method="POST" validate="true">
    <div class="row-fluid">
      <div class="span9">
        <div class="issue-avatar-image">"""),_display_(/*15.42*/avatar(loginAccount.get.userName, 48)),format.raw/*15.79*/("""</div>
        <div class="box issue-box">
          <div class="box-content">
            <span id="error-title" class="error"></span>
            <input type="text" name="title" value="" placeholder="Title" style="width: 565px;"/>
            <div>
              <span id="label-assigned">No one is assigned</span>
              """),_display_(/*22.16*/if(hasWritePermission)/*22.38*/{_display_(Seq[Any](format.raw/*22.39*/("""
                """),format.raw/*23.17*/("""<input type="hidden" name="assignedUserName" value=""/>
                """),_display_(/*24.18*/helper/*24.24*/.html.dropdown()/*24.40*/ {_display_(Seq[Any](format.raw/*24.42*/("""
                  """),format.raw/*25.19*/("""<li><a href="javascript:void(0);" class="assign" data-name=""><i class="icon-remove-circle"></i> Clear assignee</a></li>
                  """),_display_(/*26.20*/collaborators/*26.33*/.map/*26.37*/ { collaborator =>_display_(Seq[Any](format.raw/*26.55*/("""
                    """),format.raw/*27.21*/("""<li><a href="javascript:void(0);" class="assign" data-name=""""),_display_(/*27.82*/collaborator),format.raw/*27.94*/(""""><i class="icon-while"></i>"""),_display_(/*27.123*/avatar(collaborator, 20)),format.raw/*27.147*/(""" """),_display_(/*27.149*/collaborator),format.raw/*27.161*/("""</a></li>
                  """)))}),format.raw/*28.20*/("""
                """)))}),format.raw/*29.18*/("""
              """)))}),format.raw/*30.16*/("""
              """),format.raw/*31.15*/("""<div class="pull-right">
                <span id="label-milestone">No milestone</span>
                """),_display_(/*33.18*/if(hasWritePermission)/*33.40*/{_display_(Seq[Any](format.raw/*33.41*/("""
                  """),format.raw/*34.19*/("""<input type="hidden" name="milestoneId" value=""/>
                  """),_display_(/*35.20*/helper/*35.26*/.html.dropdown()/*35.42*/ {_display_(Seq[Any](format.raw/*35.44*/("""
                    """),format.raw/*36.21*/("""<li><a href="javascript:void(0);" class="milestone" data-id=""><i class="icon-remove-circle"></i> Clear this milestone</a></li>
                    """),_display_(/*37.22*/milestones/*37.32*/.filter(_.closedDate.isEmpty).map/*37.65*/ { milestone =>_display_(Seq[Any](format.raw/*37.80*/("""
                      """),format.raw/*38.23*/("""<li>
                        <a href="javascript:void(0);" class="milestone" data-id=""""),_display_(/*39.83*/milestone/*39.92*/.milestoneId),format.raw/*39.104*/("""" data-title=""""),_display_(/*39.119*/milestone/*39.128*/.title),format.raw/*39.134*/("""">
                          <i class="icon-while"></i> """),_display_(/*40.55*/milestone/*40.64*/.title),format.raw/*40.70*/("""
                          """),format.raw/*41.27*/("""<div class="small" style="padding-left: 20px;">
                            """),_display_(/*42.30*/milestone/*42.39*/.dueDate.map/*42.51*/ { dueDate =>_display_(Seq[Any](format.raw/*42.64*/("""
                              """),_display_(/*43.32*/if(isPast(dueDate))/*43.51*/{_display_(Seq[Any](format.raw/*43.52*/("""
                                """),format.raw/*44.33*/("""<img src=""""),_display_(/*44.44*/assets),format.raw/*44.50*/("""/common/images/alert.png"/><span class="milestone-alert">Due by """),_display_(/*44.115*/date(dueDate)),format.raw/*44.128*/("""</span>
                              """)))}/*45.33*/else/*45.38*/{_display_(Seq[Any](format.raw/*45.39*/("""
                                """),format.raw/*46.33*/("""<span class="muted">Due by """),_display_(/*46.61*/date(dueDate)),format.raw/*46.74*/("""</span>
                              """)))}),format.raw/*47.32*/("""
                            """)))}/*48.30*/.getOrElse/*48.40*/ {_display_(Seq[Any](format.raw/*48.42*/("""
                              """),format.raw/*49.31*/("""<span class="muted">No due date</span>
                            """)))}),format.raw/*50.30*/("""
                          """),format.raw/*51.27*/("""</div>
                        </a>
                      </li>
                    """)))}),format.raw/*54.22*/("""
                  """)))}),format.raw/*55.20*/("""
                """)))}),format.raw/*56.18*/("""
              """),format.raw/*57.15*/("""</div>
            </div>
            <hr>
            """),_display_(/*60.14*/helper/*60.20*/.html.preview(repository, "", false, true, true, hasWritePermission, "width: 565px; height: 200px; max-height: 250px;", elastic = true)),format.raw/*60.155*/("""
          """),format.raw/*61.11*/("""</div>
        </div>
        <div class="pull-right">
          <input type="submit" class="btn btn-success" value="Submit new issue"/>
        </div>
      </div>
      <div class="span3">
        """),_display_(/*68.10*/if(hasWritePermission)/*68.32*/{_display_(Seq[Any](format.raw/*68.33*/("""
          """),format.raw/*69.11*/("""<span class="strong">Labels</span>
          <div>
            <div id="label-list">
              <ul class="label-list nav nav-pills nav-stacked">
                """),_display_(/*73.18*/labels/*73.24*/.map/*73.28*/ { label =>_display_(Seq[Any](format.raw/*73.39*/("""
                  """),format.raw/*74.19*/("""<li>
                    <a href="javascript:void(0);" class="toggle-label" data-label=""""),_display_(/*75.85*/label/*75.90*/.labelName),format.raw/*75.100*/("""" data-bgcolor=""""),_display_(/*75.117*/label/*75.122*/.color),format.raw/*75.128*/("""" data-fgcolor=""""),_display_(/*75.145*/label/*75.150*/.fontColor),format.raw/*75.160*/("""">
                      <span style="background-color: #"""),_display_(/*76.56*/label/*76.61*/.color),format.raw/*76.67*/(""";" class="label-color">&nbsp;&nbsp;</span>
                      """),_display_(/*77.24*/label/*77.29*/.labelName),format.raw/*77.39*/("""
                    """),format.raw/*78.21*/("""</a>
                  </li>
                """)))}),format.raw/*80.18*/("""
              """),format.raw/*81.15*/("""</ul>
              <input type="hidden" name="labelNames" value=""/>
            </div>
          </div>
        """)))}),format.raw/*85.10*/("""
      """),format.raw/*86.7*/("""</div>
    </div>
    </form>
  """)))}),format.raw/*89.4*/("""
""")))}),format.raw/*90.2*/("""
"""),format.raw/*91.1*/("""<script>
$(function()"""),format.raw/*92.13*/("""{"""),format.raw/*92.14*/("""
  """),format.raw/*93.3*/("""$('a.assign').click(function()"""),format.raw/*93.33*/("""{"""),format.raw/*93.34*/("""
    """),format.raw/*94.5*/("""var userName = $(this).data('name');
    $('a.assign i.icon-ok').attr('class', 'icon-white');

    if(userName == '')"""),format.raw/*97.23*/("""{"""),format.raw/*97.24*/("""
      """),format.raw/*98.7*/("""$('#label-assigned').text('No one will be assigned');
    """),format.raw/*99.5*/("""}"""),format.raw/*99.6*/(""" """),format.raw/*99.7*/("""else """),format.raw/*99.12*/("""{"""),format.raw/*99.13*/("""
      """),format.raw/*100.7*/("""$('#label-assigned').html($('<span>')
        .append($('<a class="username strong">').attr('href', '"""),_display_(/*101.65*/path),format.raw/*101.69*/("""/' + userName).text(userName))
        .append(' will be assigned'));
      $('a.assign[data-name=' + jqSelectorEscape(userName) + '] i').attr('class', 'icon-ok');
    """),format.raw/*104.5*/("""}"""),format.raw/*104.6*/("""
    """),format.raw/*105.5*/("""$('input[name=assignedUserName]').val(userName);
  """),format.raw/*106.3*/("""}"""),format.raw/*106.4*/(""");

  $('a.milestone').click(function()"""),format.raw/*108.36*/("""{"""),format.raw/*108.37*/("""
    """),format.raw/*109.5*/("""var title = $(this).data('title');
    var milestoneId = $(this).data('id');
    $('a.milestone i.icon-ok').attr('class', 'icon-white');

    if(milestoneId == '')"""),format.raw/*113.26*/("""{"""),format.raw/*113.27*/("""
      """),format.raw/*114.7*/("""$('#label-milestone').text('No milestone');
    """),format.raw/*115.5*/("""}"""),format.raw/*115.6*/(""" """),format.raw/*115.7*/("""else """),format.raw/*115.12*/("""{"""),format.raw/*115.13*/("""
      """),format.raw/*116.7*/("""$('#label-milestone').html($('<span class="strong">').text(title));
      $('a.milestone[data-id=' + milestoneId + '] i').attr('class', 'icon-ok');
    """),format.raw/*118.5*/("""}"""),format.raw/*118.6*/("""
    """),format.raw/*119.5*/("""$('input[name=milestoneId]').val(milestoneId);
  """),format.raw/*120.3*/("""}"""),format.raw/*120.4*/(""");

  $('a.toggle-label').click(function()"""),format.raw/*122.39*/("""{"""),format.raw/*122.40*/("""
    """),format.raw/*123.5*/("""if($(this).data('selected') == true)"""),format.raw/*123.41*/("""{"""),format.raw/*123.42*/("""
      """),format.raw/*124.7*/("""$(this).css("""),format.raw/*124.19*/("""{"""),format.raw/*124.20*/("""
        """),format.raw/*125.9*/("""'background-color': 'white',
        'color'           : 'black',
        'font-weight'     : 'normal'
      """),format.raw/*128.7*/("""}"""),format.raw/*128.8*/(""");
      $(this).data('selected', false);
    """),format.raw/*130.5*/("""}"""),format.raw/*130.6*/(""" """),format.raw/*130.7*/("""else """),format.raw/*130.12*/("""{"""),format.raw/*130.13*/("""
      """),format.raw/*131.7*/("""$(this).css("""),format.raw/*131.19*/("""{"""),format.raw/*131.20*/("""
        """),format.raw/*132.9*/("""'background-color': '#' + $(this).data('bgcolor'),
        'color'           : '#' + $(this).data('fgcolor'),
        'font-weight'     : 'bold'
      """),format.raw/*135.7*/("""}"""),format.raw/*135.8*/(""");
      $(this).data('selected', true);
    """),format.raw/*137.5*/("""}"""),format.raw/*137.6*/("""

    """),format.raw/*139.5*/("""var labelNames = Array();
    $('a.toggle-label').each(function(i, e)"""),format.raw/*140.44*/("""{"""),format.raw/*140.45*/("""
      """),format.raw/*141.7*/("""if($(e).data('selected') == true)"""),format.raw/*141.40*/("""{"""),format.raw/*141.41*/("""
        """),format.raw/*142.9*/("""labelNames.push($(e).data('label'));
      """),format.raw/*143.7*/("""}"""),format.raw/*143.8*/("""
    """),format.raw/*144.5*/("""}"""),format.raw/*144.6*/(""");
    $('input[name=labelNames]').val(labelNames.join(','));
  """),format.raw/*146.3*/("""}"""),format.raw/*146.4*/(""");
"""),format.raw/*147.1*/("""}"""),format.raw/*147.2*/(""");
</script>
"""))}
  }

  def render(collaborators:List[String],milestones:List[model.Milestone],labels:List[model.Label],hasWritePermission:Boolean,repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(collaborators,milestones,labels,hasWritePermission,repository)(context)

  def f:((List[String],List[model.Milestone],List[model.Label],Boolean,service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (collaborators,milestones,labels,hasWritePermission,repository) => (context) => apply(collaborators,milestones,labels,hasWritePermission,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/issues/create.scala.html
                  HASH: 8f30128232d402b6c005a430d4cae89f989f53e8
                  MATRIX: 452->1|791->214|818->257|829->261|915->339|953->340|982->344|993->348|1028->375|1066->376|1098->382|1158->421|1190->426|1280->489|1316->504|1482->643|1540->680|1899->1012|1930->1034|1969->1035|2014->1052|2114->1125|2129->1131|2154->1147|2194->1149|2241->1168|2408->1308|2430->1321|2443->1325|2499->1343|2548->1364|2636->1425|2669->1437|2726->1466|2772->1490|2802->1492|2836->1504|2896->1533|2945->1551|2992->1567|3035->1582|3167->1687|3198->1709|3237->1710|3284->1729|3381->1799|3396->1805|3421->1821|3461->1823|3510->1844|3686->1993|3705->2003|3747->2036|3800->2051|3851->2074|3965->2161|3983->2170|4017->2182|4060->2197|4079->2206|4107->2212|4191->2269|4209->2278|4236->2284|4291->2311|4395->2388|4413->2397|4434->2409|4485->2422|4544->2454|4572->2473|4611->2474|4672->2507|4710->2518|4737->2524|4830->2589|4865->2602|4923->2642|4936->2647|4975->2648|5036->2681|5091->2709|5125->2722|5195->2761|5244->2791|5263->2801|5303->2803|5362->2834|5461->2902|5516->2929|5632->3014|5683->3034|5732->3052|5775->3067|5858->3123|5873->3129|6030->3264|6069->3275|6296->3475|6327->3497|6366->3498|6405->3509|6598->3675|6613->3681|6626->3685|6675->3696|6722->3715|6838->3804|6852->3809|6884->3819|6929->3836|6944->3841|6972->3847|7017->3864|7032->3869|7064->3879|7149->3937|7163->3942|7190->3948|7283->4014|7297->4019|7328->4029|7377->4050|7454->4096|7497->4111|7643->4226|7677->4233|7740->4266|7772->4268|7800->4269|7849->4290|7878->4291|7908->4294|7966->4324|7995->4325|8027->4330|8172->4447|8201->4448|8235->4455|8320->4513|8348->4514|8376->4515|8409->4520|8438->4521|8473->4528|8603->4630|8629->4634|8825->4802|8854->4803|8887->4808|8966->4859|8995->4860|9063->4899|9093->4900|9126->4905|9318->5068|9348->5069|9383->5076|9459->5124|9488->5125|9517->5126|9551->5131|9581->5132|9616->5139|9796->5291|9825->5292|9858->5297|9935->5346|9964->5347|10035->5389|10065->5390|10098->5395|10163->5431|10193->5432|10228->5439|10269->5451|10299->5452|10336->5461|10473->5570|10502->5571|10576->5617|10605->5618|10634->5619|10668->5624|10698->5625|10733->5632|10774->5644|10804->5645|10841->5654|11020->5805|11049->5806|11122->5851|11151->5852|11185->5858|11283->5927|11313->5928|11348->5935|11410->5968|11440->5969|11477->5978|11548->6021|11577->6022|11610->6027|11639->6028|11731->6092|11760->6093|11791->6096|11820->6097
                  LINES: 13->1|21->5|22->8|22->8|22->8|22->8|23->9|23->9|23->9|23->9|24->10|24->10|25->11|26->12|26->12|29->15|29->15|36->22|36->22|36->22|37->23|38->24|38->24|38->24|38->24|39->25|40->26|40->26|40->26|40->26|41->27|41->27|41->27|41->27|41->27|41->27|41->27|42->28|43->29|44->30|45->31|47->33|47->33|47->33|48->34|49->35|49->35|49->35|49->35|50->36|51->37|51->37|51->37|51->37|52->38|53->39|53->39|53->39|53->39|53->39|53->39|54->40|54->40|54->40|55->41|56->42|56->42|56->42|56->42|57->43|57->43|57->43|58->44|58->44|58->44|58->44|58->44|59->45|59->45|59->45|60->46|60->46|60->46|61->47|62->48|62->48|62->48|63->49|64->50|65->51|68->54|69->55|70->56|71->57|74->60|74->60|74->60|75->61|82->68|82->68|82->68|83->69|87->73|87->73|87->73|87->73|88->74|89->75|89->75|89->75|89->75|89->75|89->75|89->75|89->75|89->75|90->76|90->76|90->76|91->77|91->77|91->77|92->78|94->80|95->81|99->85|100->86|103->89|104->90|105->91|106->92|106->92|107->93|107->93|107->93|108->94|111->97|111->97|112->98|113->99|113->99|113->99|113->99|113->99|114->100|115->101|115->101|118->104|118->104|119->105|120->106|120->106|122->108|122->108|123->109|127->113|127->113|128->114|129->115|129->115|129->115|129->115|129->115|130->116|132->118|132->118|133->119|134->120|134->120|136->122|136->122|137->123|137->123|137->123|138->124|138->124|138->124|139->125|142->128|142->128|144->130|144->130|144->130|144->130|144->130|145->131|145->131|145->131|146->132|149->135|149->135|151->137|151->137|153->139|154->140|154->140|155->141|155->141|155->141|156->142|157->143|157->143|158->144|158->144|160->146|160->146|161->147|161->147
                  -- GENERATED --
              */
          