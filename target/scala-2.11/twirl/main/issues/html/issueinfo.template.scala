
package issues.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object issueinfo extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template9[model.Issue,List[model.Comment],List[model.Label],List[String],List[scala.Tuple3[model.Milestone, Int, Int]],List[model.Label],Boolean,service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issue: model.Issue,
  comments: List[model.Comment],
  issueLabels: List[model.Label],
  collaborators: List[String],
  milestones: List[(model.Milestone, Int, Int)],
  labels: List[model.Label],
  hasWritePermission: Boolean,
  repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import view.helpers._

Seq[Any](format.raw/*8.87*/("""
"""),format.raw/*10.1*/("""<div style="margin-bottom: 8px;">
  <span class="muted small strong">Labels</span>
  """),_display_(/*12.4*/if(hasWritePermission)/*12.26*/{_display_(Seq[Any](format.raw/*12.27*/("""
    """),format.raw/*13.5*/("""<div class="pull-right">
      """),_display_(/*14.8*/helper/*14.14*/.html.dropdown(right = true)/*14.42*/ {_display_(Seq[Any](format.raw/*14.44*/("""
        """),_display_(/*15.10*/labels/*15.16*/.map/*15.20*/ { label =>_display_(Seq[Any](format.raw/*15.31*/("""
          """),format.raw/*16.11*/("""<li>
            <a href="#" class="toggle-label" data-label-id=""""),_display_(/*17.62*/label/*17.67*/.labelId),format.raw/*17.75*/("""">
              """),_display_(/*18.16*/helper/*18.22*/.html.checkicon(issueLabels.exists(_.labelId == label.labelId))),format.raw/*18.85*/("""
              """),format.raw/*19.15*/("""<span class="label" style="background-color: #"""),_display_(/*19.62*/label/*19.67*/.color),format.raw/*19.73*/(""";">&nbsp;</span>
              """),_display_(/*20.16*/label/*20.21*/.labelName),format.raw/*20.31*/("""
            """),format.raw/*21.13*/("""</a>
          </li>
        """)))}),format.raw/*23.10*/("""
      """)))}),format.raw/*24.8*/("""
    """),format.raw/*25.5*/("""</div>
  """)))}),format.raw/*26.4*/("""
"""),format.raw/*27.1*/("""</div>
<ul class="label-list nav nav-pills nav-stacked">
  """),_display_(/*29.4*/labellist(issueLabels)),format.raw/*29.26*/("""
"""),format.raw/*30.1*/("""</ul>
<hr/>
<div style="margin-bottom: 8px;">
  <span class="muted small strong">Milestone</span>
  """),_display_(/*34.4*/if(hasWritePermission)/*34.26*/{_display_(Seq[Any](format.raw/*34.27*/("""
    """),format.raw/*35.5*/("""<div class="pull-right">
      """),_display_(/*36.8*/helper/*36.14*/.html.dropdown(right = true)/*36.42*/ {_display_(Seq[Any](format.raw/*36.44*/("""
        """),format.raw/*37.9*/("""<li><a href="javascript:void(0);" class="milestone" data-id=""><i class="icon-remove-circle"></i> Clear this milestone</a></li>
        """),_display_(/*38.10*/milestones/*38.20*/.filter(_._1.closedDate.isEmpty).map/*38.56*/ { case (milestone, _, _) =>_display_(Seq[Any](format.raw/*38.84*/("""
          """),format.raw/*39.11*/("""<li>
            <a href="javascript:void(0);" class="milestone" data-id=""""),_display_(/*40.71*/milestone/*40.80*/.milestoneId),format.raw/*40.92*/("""" data-title=""""),_display_(/*40.107*/milestone/*40.116*/.title),format.raw/*40.122*/("""">
              """),_display_(/*41.16*/helper/*41.22*/.html.checkicon(Some(milestone.milestoneId) == issue.milestoneId)),format.raw/*41.87*/(""" """),_display_(/*41.89*/milestone/*41.98*/.title),format.raw/*41.104*/("""
              """),format.raw/*42.15*/("""<div class="small" style="padding-left: 20px;">
                """),_display_(/*43.18*/milestone/*43.27*/.dueDate.map/*43.39*/ { dueDate =>_display_(Seq[Any](format.raw/*43.52*/("""
                  """),_display_(/*44.20*/if(isPast(dueDate))/*44.39*/{_display_(Seq[Any](format.raw/*44.40*/("""
                    """),format.raw/*45.21*/("""<img src=""""),_display_(/*45.32*/assets),format.raw/*45.38*/("""/common/images/alert.png"/><span class="milestone-alert">Due by """),_display_(/*45.103*/date(dueDate)),format.raw/*45.116*/("""</span>
                  """)))}/*46.21*/else/*46.26*/{_display_(Seq[Any](format.raw/*46.27*/("""
                    """),format.raw/*47.21*/("""<span class="muted">Due by """),_display_(/*47.49*/date(dueDate)),format.raw/*47.62*/("""</span>
                  """)))}),format.raw/*48.20*/("""
                """)))}/*49.18*/.getOrElse/*49.28*/ {_display_(Seq[Any](format.raw/*49.30*/("""
                  """),format.raw/*50.19*/("""<span class="muted">No due date</span>
                """)))}),format.raw/*51.18*/("""
              """),format.raw/*52.15*/("""</div>
            </a>
          </li>
        """)))}),format.raw/*55.10*/("""
      """)))}),format.raw/*56.8*/("""
    """),format.raw/*57.5*/("""</div>
  """)))}),format.raw/*58.4*/("""
"""),format.raw/*59.1*/("""</div>
<div id="milestone-progress-area">
  """),_display_(/*61.4*/issue/*61.9*/.milestoneId.map/*61.25*/ { milestoneId =>_display_(Seq[Any](format.raw/*61.42*/("""
    """),_display_(/*62.6*/milestones/*62.16*/.collect/*62.24*/ { case (milestone, openCount, closeCount) if(milestone.milestoneId == milestoneId) =>_display_(Seq[Any](format.raw/*62.110*/("""
      """),_display_(/*63.8*/issues/*63.14*/.milestones.html.progress(openCount + closeCount, closeCount)),format.raw/*63.75*/("""
    """)))}),format.raw/*64.6*/("""
  """)))}),format.raw/*65.4*/("""
"""),format.raw/*66.1*/("""</div>
<span id="label-milestone">
  """),_display_(/*68.4*/issue/*68.9*/.milestoneId.map/*68.25*/ { milestoneId =>_display_(Seq[Any](format.raw/*68.42*/("""
    """),_display_(/*69.6*/milestones/*69.16*/.collect/*69.24*/ { case (milestone, _, _) if(milestone.milestoneId == milestoneId) =>_display_(Seq[Any](format.raw/*69.93*/("""
      """),format.raw/*70.7*/("""<span class="strong small">"""),_display_(/*70.35*/milestone/*70.44*/.title),format.raw/*70.50*/("""</span>
    """)))}),format.raw/*71.6*/("""
  """)))}/*72.4*/.getOrElse/*72.14*/ {_display_(Seq[Any](format.raw/*72.16*/("""
    """),format.raw/*73.5*/("""<span class="muted small">No milestone</span>
  """)))}),format.raw/*74.4*/("""
"""),format.raw/*75.1*/("""</span>
<hr/>
<div style="margin-bottom: 8px;">
  <span class="muted small strong">Assignee</span>
  """),_display_(/*79.4*/if(hasWritePermission)/*79.26*/{_display_(Seq[Any](format.raw/*79.27*/("""
    """),format.raw/*80.5*/("""<div class="pull-right">
      """),_display_(/*81.8*/helper/*81.14*/.html.dropdown(right = true)/*81.42*/ {_display_(Seq[Any](format.raw/*81.44*/("""
        """),format.raw/*82.9*/("""<li><a href="javascript:void(0);" class="assign" data-name=""><i class="icon-remove-circle"></i> Clear assignee</a></li>
        """),_display_(/*83.10*/collaborators/*83.23*/.map/*83.27*/ { collaborator =>_display_(Seq[Any](format.raw/*83.45*/("""
          """),format.raw/*84.11*/("""<li>
            <a href="javascript:void(0);" class="assign" data-name=""""),_display_(/*85.70*/collaborator),format.raw/*85.82*/("""">
              """),_display_(/*86.16*/helper/*86.22*/.html.checkicon(Some(collaborator) == issue.assignedUserName)),_display_(/*86.84*/avatar(collaborator, 20)),format.raw/*86.108*/(""" """),_display_(/*86.110*/collaborator),format.raw/*86.122*/("""
            """),format.raw/*87.13*/("""</a>
          </li>
        """)))}),format.raw/*89.10*/("""
      """)))}),format.raw/*90.8*/("""
    """),format.raw/*91.5*/("""</div>
  """)))}),format.raw/*92.4*/("""
"""),format.raw/*93.1*/("""</div>
<span id="label-assigned">
  """),_display_(/*95.4*/issue/*95.9*/.assignedUserName.map/*95.30*/ { userName =>_display_(Seq[Any](format.raw/*95.44*/("""
    """),_display_(/*96.6*/avatar(userName, 20)),format.raw/*96.26*/(""" """),_display_(/*96.28*/user(userName, styleClass="username strong small")),format.raw/*96.78*/("""
  """)))}/*97.4*/.getOrElse/*97.14*/{_display_(Seq[Any](format.raw/*97.15*/("""
    """),format.raw/*98.5*/("""<span class="muted small">No one</span>
  """)))}),format.raw/*99.4*/("""
"""),format.raw/*100.1*/("""</span>
<hr/>
<div style="margin-bottom: 8px;">
  """),_display_(/*103.4*/defining((issue.openedUserName :: comments.map(_.commentedUserName)).distinct)/*103.82*/{ participants =>_display_(Seq[Any](format.raw/*103.99*/("""
    """),format.raw/*104.5*/("""<div class="muted small strong">"""),_display_(/*104.38*/participants/*104.50*/.size),format.raw/*104.55*/(""" """),_display_(/*104.57*/plural(participants.size, "participant")),format.raw/*104.97*/("""</div>
    """),_display_(/*105.6*/participants/*105.18*/.map/*105.22*/ { participant =>_display_(Seq[Any](format.raw/*105.39*/(""" """),_display_(/*105.41*/avatarLink(participant, 20, tooltip = true)),format.raw/*105.84*/(""" """)))}),format.raw/*105.86*/("""
  """)))}),format.raw/*106.4*/("""
"""),format.raw/*107.1*/("""</div>
<script>
$(function()"""),format.raw/*109.13*/("""{"""),format.raw/*109.14*/("""
  """),format.raw/*110.3*/("""$('a.toggle-label').click(function()"""),format.raw/*110.39*/("""{"""),format.raw/*110.40*/("""
    """),format.raw/*111.5*/("""var path, icon;
    var i = $(this).children('i');
    if(i.hasClass('icon-ok'))"""),format.raw/*113.30*/("""{"""),format.raw/*113.31*/("""
      """),format.raw/*114.7*/("""path = 'delete';
      icon = 'icon-white';
    """),format.raw/*116.5*/("""}"""),format.raw/*116.6*/(""" """),format.raw/*116.7*/("""else """),format.raw/*116.12*/("""{"""),format.raw/*116.13*/("""
      """),format.raw/*117.7*/("""path = 'new';
      icon = 'icon-ok';
    """),format.raw/*119.5*/("""}"""),format.raw/*119.6*/("""
    """),format.raw/*120.5*/("""$.post('"""),_display_(/*120.14*/url(repository)),format.raw/*120.29*/("""/issues/"""),_display_(/*120.38*/issue/*120.43*/.issueId),format.raw/*120.51*/("""/label/' + path,
    """),format.raw/*121.5*/("""{"""),format.raw/*121.6*/("""
      """),format.raw/*122.7*/("""labelId : $(this).data('label-id')
    """),format.raw/*123.5*/("""}"""),format.raw/*123.6*/(""",
    function(data)"""),format.raw/*124.19*/("""{"""),format.raw/*124.20*/("""
      """),format.raw/*125.7*/("""i.removeClass().addClass(icon);
      $('ul.label-list').empty().html(data);
    """),format.raw/*127.5*/("""}"""),format.raw/*127.6*/(""");
    return false;
  """),format.raw/*129.3*/("""}"""),format.raw/*129.4*/(""");

  $('a.milestone').click(function()"""),format.raw/*131.36*/("""{"""),format.raw/*131.37*/("""
    """),format.raw/*132.5*/("""var title = $(this).data('title');
    var milestoneId = $(this).data('id');
    $.post('"""),_display_(/*134.14*/url(repository)),format.raw/*134.29*/("""/issues/"""),_display_(/*134.38*/issue/*134.43*/.issueId),format.raw/*134.51*/("""/milestone',
    """),format.raw/*135.5*/("""{"""),format.raw/*135.6*/("""
      """),format.raw/*136.7*/("""milestoneId: milestoneId
    """),format.raw/*137.5*/("""}"""),format.raw/*137.6*/(""",
    function(data)"""),format.raw/*138.19*/("""{"""),format.raw/*138.20*/("""
      """),format.raw/*139.7*/("""console.log(data);
      $('a.milestone i.icon-ok').attr('class', 'icon-white');
      if(milestoneId == '')"""),format.raw/*141.28*/("""{"""),format.raw/*141.29*/("""
        """),format.raw/*142.9*/("""$('#label-milestone').html($('<span class="muted small">').text('No milestone'));
        $('#milestone-progress-area').empty();
      """),format.raw/*144.7*/("""}"""),format.raw/*144.8*/(""" """),format.raw/*144.9*/("""else """),format.raw/*144.14*/("""{"""),format.raw/*144.15*/("""
        """),format.raw/*145.9*/("""$('#label-milestone').html($('<span class="strong small">').text(title));
        $('#milestone-progress-area').html(data);
        $('a.milestone[data-id=' + milestoneId + '] i').attr('class', 'icon-ok');
      """),format.raw/*148.7*/("""}"""),format.raw/*148.8*/("""
    """),format.raw/*149.5*/("""}"""),format.raw/*149.6*/(""");
  """),format.raw/*150.3*/("""}"""),format.raw/*150.4*/(""");

  $('a.assign').click(function()"""),format.raw/*152.33*/("""{"""),format.raw/*152.34*/("""
    """),format.raw/*153.5*/("""var $this = $(this);
    var userName = $this.data('name');
    $.post('"""),_display_(/*155.14*/url(repository)),format.raw/*155.29*/("""/issues/"""),_display_(/*155.38*/issue/*155.43*/.issueId),format.raw/*155.51*/("""/assign',
    """),format.raw/*156.5*/("""{"""),format.raw/*156.6*/("""
      """),format.raw/*157.7*/("""assignedUserName: userName
    """),format.raw/*158.5*/("""}"""),format.raw/*158.6*/(""",
    function()"""),format.raw/*159.15*/("""{"""),format.raw/*159.16*/("""
      """),format.raw/*160.7*/("""$('a.assign i.icon-ok').attr('class', 'icon-white');
      if(userName == '')"""),format.raw/*161.25*/("""{"""),format.raw/*161.26*/("""
        """),format.raw/*162.9*/("""$('#label-assigned').html($('<span class="muted small">').text('No one'));
      """),format.raw/*163.7*/("""}"""),format.raw/*163.8*/(""" """),format.raw/*163.9*/("""else """),format.raw/*163.14*/("""{"""),format.raw/*163.15*/("""
        """),format.raw/*164.9*/("""$('#label-assigned').empty()
          .append($this.find('img.avatar-mini').clone(false)).append(' ')
          .append($('<a class="username strong small">').attr('href', '"""),_display_(/*166.73*/context/*166.80*/.path),format.raw/*166.85*/("""/' + userName).text(userName));
        $('a.assign[data-name=' + jqSelectorEscape(userName) + '] i').attr('class', 'icon-ok');
      """),format.raw/*168.7*/("""}"""),format.raw/*168.8*/("""
    """),format.raw/*169.5*/("""}"""),format.raw/*169.6*/(""");
  """),format.raw/*170.3*/("""}"""),format.raw/*170.4*/(""");

"""),format.raw/*172.1*/("""}"""),format.raw/*172.2*/(""");
</script>
"""))}
  }

  def render(issue:model.Issue,comments:List[model.Comment],issueLabels:List[model.Label],collaborators:List[String],milestones:List[scala.Tuple3[model.Milestone, Int, Int]],labels:List[model.Label],hasWritePermission:Boolean,repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(issue,comments,issueLabels,collaborators,milestones,labels,hasWritePermission,repository)(context)

  def f:((model.Issue,List[model.Comment],List[model.Label],List[String],List[scala.Tuple3[model.Milestone, Int, Int]],List[model.Label],Boolean,service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (issue,comments,issueLabels,collaborators,milestones,labels,hasWritePermission,repository) => (context) => apply(issue,comments,issueLabels,collaborators,milestones,labels,hasWritePermission,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/issues/issueinfo.scala.html
                  HASH: c0abe86746124d75e6bcac580171b8b42e96492d
                  MATRIX: 529->1|952->315|980->339|1092->425|1123->447|1162->448|1194->453|1252->485|1267->491|1304->519|1344->521|1381->531|1396->537|1409->541|1458->552|1497->563|1590->629|1604->634|1633->642|1678->660|1693->666|1777->729|1820->744|1894->791|1908->796|1935->802|1994->834|2008->839|2039->849|2080->862|2141->892|2179->900|2211->905|2251->915|2279->916|2365->976|2408->998|2436->999|2563->1100|2594->1122|2633->1123|2665->1128|2723->1160|2738->1166|2775->1194|2815->1196|2851->1205|3015->1342|3034->1352|3079->1388|3145->1416|3184->1427|3286->1502|3304->1511|3337->1523|3380->1538|3399->1547|3427->1553|3472->1571|3487->1577|3573->1642|3602->1644|3620->1653|3648->1659|3691->1674|3783->1739|3801->1748|3822->1760|3873->1773|3920->1793|3948->1812|3987->1813|4036->1834|4074->1845|4101->1851|4194->1916|4229->1929|4275->1957|4288->1962|4327->1963|4376->1984|4431->2012|4465->2025|4523->2052|4560->2070|4579->2080|4619->2082|4666->2101|4753->2157|4796->2172|4876->2221|4914->2229|4946->2234|4986->2244|5014->2245|5085->2290|5098->2295|5123->2311|5178->2328|5210->2334|5229->2344|5246->2352|5371->2438|5405->2446|5420->2452|5502->2513|5538->2519|5572->2523|5600->2524|5664->2562|5677->2567|5702->2583|5757->2600|5789->2606|5808->2616|5825->2624|5932->2693|5966->2700|6021->2728|6039->2737|6066->2743|6109->2756|6131->2760|6150->2770|6190->2772|6222->2777|6301->2826|6329->2827|6457->2929|6488->2951|6527->2952|6559->2957|6617->2989|6632->2995|6669->3023|6709->3025|6745->3034|6902->3164|6924->3177|6937->3181|6993->3199|7032->3210|7133->3284|7166->3296|7211->3314|7226->3320|7308->3382|7354->3406|7384->3408|7418->3420|7459->3433|7520->3463|7558->3471|7590->3476|7630->3486|7658->3487|7721->3524|7734->3529|7764->3550|7816->3564|7848->3570|7889->3590|7918->3592|7989->3642|8011->3646|8030->3656|8069->3657|8101->3662|8174->3705|8203->3706|8281->3757|8369->3835|8425->3852|8458->3857|8519->3890|8541->3902|8568->3907|8598->3909|8660->3949|8699->3961|8721->3973|8735->3977|8791->3994|8821->3996|8886->4039|8920->4041|8955->4045|8984->4046|9041->4074|9071->4075|9102->4078|9167->4114|9197->4115|9230->4120|9339->4200|9369->4201|9404->4208|9480->4256|9509->4257|9538->4258|9572->4263|9602->4264|9637->4271|9707->4313|9736->4314|9769->4319|9806->4328|9843->4343|9880->4352|9895->4357|9925->4365|9974->4386|10003->4387|10038->4394|10105->4433|10134->4434|10183->4454|10213->4455|10248->4462|10357->4543|10386->4544|10437->4567|10466->4568|10534->4607|10564->4608|10597->4613|10715->4703|10752->4718|10789->4727|10804->4732|10834->4740|10879->4757|10908->4758|10943->4765|11000->4794|11029->4795|11078->4815|11108->4816|11143->4823|11280->4931|11310->4932|11347->4941|11510->5076|11539->5077|11568->5078|11602->5083|11632->5084|11669->5093|11909->5305|11938->5306|11971->5311|12000->5312|12033->5317|12062->5318|12127->5354|12157->5355|12190->5360|12291->5433|12328->5448|12365->5457|12380->5462|12410->5470|12452->5484|12481->5485|12516->5492|12575->5523|12604->5524|12649->5540|12679->5541|12714->5548|12820->5625|12850->5626|12887->5635|12996->5716|13025->5717|13054->5718|13088->5723|13118->5724|13155->5733|13358->5908|13375->5915|13402->5920|13564->6054|13593->6055|13626->6060|13655->6061|13688->6066|13717->6067|13749->6071|13778->6072
                  LINES: 13->1|23->8|24->10|26->12|26->12|26->12|27->13|28->14|28->14|28->14|28->14|29->15|29->15|29->15|29->15|30->16|31->17|31->17|31->17|32->18|32->18|32->18|33->19|33->19|33->19|33->19|34->20|34->20|34->20|35->21|37->23|38->24|39->25|40->26|41->27|43->29|43->29|44->30|48->34|48->34|48->34|49->35|50->36|50->36|50->36|50->36|51->37|52->38|52->38|52->38|52->38|53->39|54->40|54->40|54->40|54->40|54->40|54->40|55->41|55->41|55->41|55->41|55->41|55->41|56->42|57->43|57->43|57->43|57->43|58->44|58->44|58->44|59->45|59->45|59->45|59->45|59->45|60->46|60->46|60->46|61->47|61->47|61->47|62->48|63->49|63->49|63->49|64->50|65->51|66->52|69->55|70->56|71->57|72->58|73->59|75->61|75->61|75->61|75->61|76->62|76->62|76->62|76->62|77->63|77->63|77->63|78->64|79->65|80->66|82->68|82->68|82->68|82->68|83->69|83->69|83->69|83->69|84->70|84->70|84->70|84->70|85->71|86->72|86->72|86->72|87->73|88->74|89->75|93->79|93->79|93->79|94->80|95->81|95->81|95->81|95->81|96->82|97->83|97->83|97->83|97->83|98->84|99->85|99->85|100->86|100->86|100->86|100->86|100->86|100->86|101->87|103->89|104->90|105->91|106->92|107->93|109->95|109->95|109->95|109->95|110->96|110->96|110->96|110->96|111->97|111->97|111->97|112->98|113->99|114->100|117->103|117->103|117->103|118->104|118->104|118->104|118->104|118->104|118->104|119->105|119->105|119->105|119->105|119->105|119->105|119->105|120->106|121->107|123->109|123->109|124->110|124->110|124->110|125->111|127->113|127->113|128->114|130->116|130->116|130->116|130->116|130->116|131->117|133->119|133->119|134->120|134->120|134->120|134->120|134->120|134->120|135->121|135->121|136->122|137->123|137->123|138->124|138->124|139->125|141->127|141->127|143->129|143->129|145->131|145->131|146->132|148->134|148->134|148->134|148->134|148->134|149->135|149->135|150->136|151->137|151->137|152->138|152->138|153->139|155->141|155->141|156->142|158->144|158->144|158->144|158->144|158->144|159->145|162->148|162->148|163->149|163->149|164->150|164->150|166->152|166->152|167->153|169->155|169->155|169->155|169->155|169->155|170->156|170->156|171->157|172->158|172->158|173->159|173->159|174->160|175->161|175->161|176->162|177->163|177->163|177->163|177->163|177->163|178->164|180->166|180->166|180->166|182->168|182->168|183->169|183->169|184->170|184->170|186->172|186->172
                  -- GENERATED --
              */
          