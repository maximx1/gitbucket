
package pulls.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object compare extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template13[Seq[Seq[util.JGitUtil.CommitInfo]],Seq[util.JGitUtil.DiffInfo],List[scala.Tuple2[String, String]],List[model.Comment],String,String,String,String,service.RepositoryService.RepositoryInfo,service.RepositoryService.RepositoryInfo,service.RepositoryService.RepositoryInfo,Boolean,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(commits: Seq[Seq[util.JGitUtil.CommitInfo]],
  diffs: Seq[util.JGitUtil.DiffInfo],
  members: List[(String, String)],
  comments: List[model.Comment],
  originId: String,
  forkedId: String,
  sourceId: String,
  commitId: String,
  repository: service.RepositoryService.RepositoryInfo,
  originRepository: service.RepositoryService.RepositoryInfo,
  forkedRepository: service.RepositoryService.RepositoryInfo,
  hasWritePermission: Boolean)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*12.62*/("""
"""),_display_(/*15.2*/html/*15.6*/.main(s"Pull Requests - ${repository.owner}/${repository.name}", Some(repository))/*15.88*/{_display_(Seq[Any](format.raw/*15.89*/("""
  """),_display_(/*16.4*/html/*16.8*/.menu("pulls", repository)/*16.34*/{_display_(Seq[Any](format.raw/*16.35*/("""
    """),format.raw/*17.5*/("""<div class="pullreq-info">
      <div id="compare-info">
        <a href="#" id="edit-compare-condition" class="btn btn-mini pull-right">Edit</a>
        <span class="label label-info monospace">"""),_display_(/*20.51*/originRepository/*20.67*/.owner),format.raw/*20.73*/(""":"""),_display_(/*20.75*/originId),format.raw/*20.83*/("""</span> ... <span class="label label-info monospace">"""),_display_(/*20.137*/forkedRepository/*20.153*/.owner),format.raw/*20.159*/(""":"""),_display_(/*20.161*/forkedId),format.raw/*20.169*/("""</span>
      </div>
      <div id="compare-edit" style="display: none;">
        <a href="#" id="cancel-condition-editing" class="pull-right"><i class="icon-remove-circle"></i></a>
        """),_display_(/*24.10*/helper/*24.16*/.html.dropdown(originRepository.owner + "/" + originRepository.name, "base fork")/*24.97*/ {_display_(Seq[Any](format.raw/*24.99*/("""
          """),_display_(/*25.12*/members/*25.19*/.map/*25.23*/ { case (owner, name) =>_display_(Seq[Any](format.raw/*25.47*/("""
            """),format.raw/*26.13*/("""<li><a href="#" class="origin-owner" data-owner=""""),_display_(/*26.63*/owner),format.raw/*26.68*/("""" data-name=""""),_display_(/*26.82*/name),format.raw/*26.86*/("""">"""),_display_(/*26.89*/helper/*26.95*/.html.checkicon(owner == originRepository.owner)),format.raw/*26.143*/(""" """),_display_(/*26.145*/owner),format.raw/*26.150*/("""/"""),_display_(/*26.152*/name),format.raw/*26.156*/("""</a></li>
          """)))}),format.raw/*27.12*/("""
        """)))}),format.raw/*28.10*/("""
        """),_display_(/*29.10*/helper/*29.16*/.html.dropdown(originId, "base")/*29.48*/ {_display_(Seq[Any](format.raw/*29.50*/("""
          """),_display_(/*30.12*/originRepository/*30.28*/.branchList.map/*30.43*/ { branch =>_display_(Seq[Any](format.raw/*30.55*/("""
            """),format.raw/*31.13*/("""<li><a href="#" class="origin-branch" data-branch=""""),_display_(/*31.65*/encodeRefName(branch)),format.raw/*31.86*/("""">"""),_display_(/*31.89*/helper/*31.95*/.html.checkicon(branch == originId)),format.raw/*31.130*/(""" """),_display_(/*31.132*/branch),format.raw/*31.138*/("""</a></li>
          """)))}),format.raw/*32.12*/("""
        """)))}),format.raw/*33.10*/("""
        """),format.raw/*34.9*/("""...
        """),_display_(/*35.10*/helper/*35.16*/.html.dropdown(forkedRepository.owner + "/" + forkedRepository.name, "head fork")/*35.97*/ {_display_(Seq[Any](format.raw/*35.99*/("""
          """),_display_(/*36.12*/members/*36.19*/.map/*36.23*/ { case (owner, name) =>_display_(Seq[Any](format.raw/*36.47*/("""
            """),format.raw/*37.13*/("""<li><a href="#" class="forked-owner" data-owner=""""),_display_(/*37.63*/owner),format.raw/*37.68*/("""" data-name=""""),_display_(/*37.82*/name),format.raw/*37.86*/("""">"""),_display_(/*37.89*/helper/*37.95*/.html.checkicon(owner == forkedRepository.owner)),format.raw/*37.143*/(""" """),_display_(/*37.145*/owner),format.raw/*37.150*/("""/"""),_display_(/*37.152*/name),format.raw/*37.156*/("""</a></li>
          """)))}),format.raw/*38.12*/("""
        """)))}),format.raw/*39.10*/("""
        """),_display_(/*40.10*/helper/*40.16*/.html.dropdown(forkedId, "compare")/*40.51*/ {_display_(Seq[Any](format.raw/*40.53*/("""
          """),_display_(/*41.12*/forkedRepository/*41.28*/.branchList.map/*41.43*/ { branch =>_display_(Seq[Any](format.raw/*41.55*/("""
            """),format.raw/*42.13*/("""<li><a href="#" class="forked-branch" data-branch=""""),_display_(/*42.65*/encodeRefName(branch)),format.raw/*42.86*/("""">"""),_display_(/*42.89*/helper/*42.95*/.html.checkicon(branch == forkedId)),format.raw/*42.130*/(""" """),_display_(/*42.132*/branch),format.raw/*42.138*/("""</a></li>
          """)))}),format.raw/*43.12*/("""
        """)))}),format.raw/*44.10*/("""
      """),format.raw/*45.7*/("""</div>
    </div>
    """),_display_(/*47.6*/if(commits.nonEmpty && hasWritePermission)/*47.48*/{_display_(Seq[Any](format.raw/*47.49*/("""
      """),format.raw/*48.7*/("""<div style="margin-bottom: 10px;" id="create-pull-request">
        <a href="#" class="btn btn-success" id="show-form">Create pull request</a>
      </div>
      <div id="pull-request-form" class="box" style="display: none;">
          <div class="box-content">
            <form method="POST" action=""""),_display_(/*53.42*/path),format.raw/*53.46*/("""/"""),_display_(/*53.48*/originRepository/*53.64*/.owner),format.raw/*53.70*/("""/"""),_display_(/*53.72*/originRepository/*53.88*/.name),format.raw/*53.93*/("""/pulls/new" validate="true">
              <div style="width: 240px; position: absolute; margin-left: 610px;">
                <div class="check-conflict" style="display: none;">
                  <img src=""""),_display_(/*56.30*/assets),format.raw/*56.36*/("""/common/images/indicator.gif"/> Checking...
                </div>
              </div>
              <div style="width: 600px; border-right: 1px solid #d4d4d4;">
                <span class="error" id="error-title"></span>
                <input type="text" name="title" style="width: 580px" placeholder="Title"/>
                """),_display_(/*62.18*/helper/*62.24*/.html.preview(repository, "", false, true, true, hasWritePermission, "width: 580px; height: 200px;")),format.raw/*62.124*/("""
                """),format.raw/*63.17*/("""<input type="hidden" name="targetUserName" value=""""),_display_(/*63.68*/originRepository/*63.84*/.owner),format.raw/*63.90*/(""""/>
                <input type="hidden" name="targetBranch" value=""""),_display_(/*64.66*/originId),format.raw/*64.74*/(""""/>
                <input type="hidden" name="requestUserName" value=""""),_display_(/*65.69*/forkedRepository/*65.85*/.owner),format.raw/*65.91*/(""""/>
                <input type="hidden" name="requestRepositoryName" value=""""),_display_(/*66.75*/forkedRepository/*66.91*/.name),format.raw/*66.96*/(""""/>
                <input type="hidden" name="requestBranch" value=""""),_display_(/*67.67*/forkedId),format.raw/*67.75*/(""""/>
                <input type="hidden" name="commitIdFrom" value=""""),_display_(/*68.66*/sourceId),format.raw/*68.74*/(""""/>
                <input type="hidden" name="commitIdTo" value=""""),_display_(/*69.64*/commitId),format.raw/*69.72*/(""""/>
              </div>
            </form>
          </div>
      </div>
    """)))}),format.raw/*74.6*/("""
    """),_display_(/*75.6*/if(commits.isEmpty)/*75.25*/{_display_(Seq[Any](format.raw/*75.26*/("""
      """),format.raw/*76.7*/("""<table class="table table-bordered table-hover table-issues">
        <tr>
          <td style="padding: 20px; background-color: #eee; text-align: center;">
            <h4>There isn't anything to compare.</h4>
            <span class="strong">"""),_display_(/*80.35*/originRepository/*80.51*/.owner),format.raw/*80.57*/(""":"""),_display_(/*80.59*/originId),format.raw/*80.67*/("""</span> and <span class="strong">"""),_display_(/*80.101*/forkedRepository/*80.117*/.owner),format.raw/*80.123*/(""":"""),_display_(/*80.125*/forkedId),format.raw/*80.133*/("""</span> are identical.
          </td>
        </tr>
      </table>
    """)))}/*84.7*/else/*84.12*/{_display_(Seq[Any](format.raw/*84.13*/("""
      """),_display_(/*85.8*/pulls/*85.13*/.html.commits(commits, Some(comments), repository)),format.raw/*85.63*/("""
      """),_display_(/*86.8*/helper/*86.14*/.html.diff(diffs, repository, Some(commitId), Some(sourceId), true, None, hasWritePermission, false)),format.raw/*86.114*/("""
      """),format.raw/*87.7*/("""<p>Showing you all comments on commits in this comparison.</p>
      """),_display_(/*88.8*/issues/*88.14*/.html.commentlist(None, comments, hasWritePermission, repository, None)),format.raw/*88.85*/("""
    """)))}),format.raw/*89.6*/("""
  """)))}),format.raw/*90.4*/("""
""")))}),format.raw/*91.2*/("""
"""),format.raw/*92.1*/("""<script>
$(function()"""),format.raw/*93.13*/("""{"""),format.raw/*93.14*/("""
  """),format.raw/*94.3*/("""$('#edit-compare-condition').click(function()"""),format.raw/*94.48*/("""{"""),format.raw/*94.49*/("""
    """),format.raw/*95.5*/("""$('#compare-info').hide();
    $('#compare-edit').show();
  """),format.raw/*97.3*/("""}"""),format.raw/*97.4*/(""");

  $('#cancel-condition-editing').click(function()"""),format.raw/*99.50*/("""{"""),format.raw/*99.51*/("""
    """),format.raw/*100.5*/("""$('#compare-info').show();
    $('#compare-edit').hide();
  """),format.raw/*102.3*/("""}"""),format.raw/*102.4*/(""");

  $('a.origin-owner, a.forked-owner, a.origin-branch, a.forked-branch').click(function()"""),format.raw/*104.89*/("""{"""),format.raw/*104.90*/("""
    """),format.raw/*105.5*/("""var e = $(this);
    e.parents('ul').find('i').attr('class', 'icon-white');
    e.find('i').attr('class', 'icon-ok');
    e.parents('div.btn-group').find('button span.strong').text(e.text());

    """),_display_(/*110.6*/if(members.isEmpty)/*110.25*/{_display_(Seq[Any](format.raw/*110.26*/("""
      """),format.raw/*111.7*/("""location.href = '"""),_display_(/*111.25*/url(repository)),format.raw/*111.40*/("""/compare/' +
        $.trim($('i.icon-ok').parents('a.origin-branch').data('branch')) + '...' +
        $.trim($('i.icon-ok').parents('a.forked-branch').data('branch'));
    """)))}/*114.7*/else/*114.12*/{_display_(Seq[Any](format.raw/*114.13*/("""
      """),format.raw/*115.7*/("""location.href = '"""),_display_(/*115.25*/path),format.raw/*115.29*/("""/' +
        $.trim($('i.icon-ok').parents('a.forked-owner' ).data('owner')) + '/' +
        $.trim($('i.icon-ok').parents('a.forked-owner' ).data('name')) +'/compare/' +
        $.trim($('i.icon-ok').parents('a.origin-owner' ).data('owner')) + ':' +
        $.trim($('i.icon-ok').parents('a.origin-branch').data('branch')) + '...' +
        $.trim($('i.icon-ok').parents('a.forked-owner' ).data('owner')) + ':' +
        $.trim($('i.icon-ok').parents('a.forked-branch').data('branch'));
    """)))}),format.raw/*122.6*/("""
  """),format.raw/*123.3*/("""}"""),format.raw/*123.4*/(""");

  $('#show-form').click(function()"""),format.raw/*125.35*/("""{"""),format.raw/*125.36*/("""
    """),format.raw/*126.5*/("""$(this).hide();
    $('#pull-request-form').show();
  """),format.raw/*128.3*/("""}"""),format.raw/*128.4*/(""");

  """),_display_(/*130.4*/if(hasWritePermission)/*130.26*/{_display_(Seq[Any](format.raw/*130.27*/("""
    """),format.raw/*131.5*/("""function checkConflict(from, to, noConflictHandler, hasConflictHandler)"""),format.raw/*131.76*/("""{"""),format.raw/*131.77*/("""
      """),format.raw/*132.7*/("""$('.check-conflict').show();
      $.get('"""),_display_(/*133.15*/url(repository)),format.raw/*133.30*/("""/compare/' + from + '...' + to + '/mergecheck',
        function(data)"""),format.raw/*134.23*/("""{"""),format.raw/*134.24*/(""" """),format.raw/*134.25*/("""$('.check-conflict').html(data); """),format.raw/*134.58*/("""}"""),format.raw/*134.59*/(""");
    """),format.raw/*135.5*/("""}"""),format.raw/*135.6*/("""

    """),_display_(/*137.6*/if(members.isEmpty)/*137.25*/{_display_(Seq[Any](format.raw/*137.26*/("""
      """),format.raw/*138.7*/("""checkConflict(
        $.trim($('i.icon-ok').parents('a.origin-branch').data('branch')),
        $.trim($('i.icon-ok').parents('a.forked-branch').data('branch'))
      );
    """)))}/*142.7*/else/*142.12*/{_display_(Seq[Any](format.raw/*142.13*/("""
      """),format.raw/*143.7*/("""checkConflict(
        $.trim($('i.icon-ok').parents('a.origin-owner' ).data('owner')) + ":" +
        $.trim($('i.icon-ok').parents('a.origin-branch').data('branch')),
        $.trim($('i.icon-ok').parents('a.forked-owner' ).data('owner')) + ":" +
        $.trim($('i.icon-ok').parents('a.forked-branch').data('branch'))
      );
    """)))}),format.raw/*149.6*/("""
  """)))}),format.raw/*150.4*/("""
"""),format.raw/*151.1*/("""}"""),format.raw/*151.2*/(""");
</script>
"""))}
  }

  def render(commits:Seq[Seq[util.JGitUtil.CommitInfo]],diffs:Seq[util.JGitUtil.DiffInfo],members:List[scala.Tuple2[String, String]],comments:List[model.Comment],originId:String,forkedId:String,sourceId:String,commitId:String,repository:service.RepositoryService.RepositoryInfo,originRepository:service.RepositoryService.RepositoryInfo,forkedRepository:service.RepositoryService.RepositoryInfo,hasWritePermission:Boolean,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(commits,diffs,members,comments,originId,forkedId,sourceId,commitId,repository,originRepository,forkedRepository,hasWritePermission)(context)

  def f:((Seq[Seq[util.JGitUtil.CommitInfo]],Seq[util.JGitUtil.DiffInfo],List[scala.Tuple2[String, String]],List[model.Comment],String,String,String,String,service.RepositoryService.RepositoryInfo,service.RepositoryService.RepositoryInfo,service.RepositoryService.RepositoryInfo,Boolean) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (commits,diffs,members,comments,originId,forkedId,sourceId,commitId,repository,originRepository,forkedRepository,hasWritePermission) => (context) => apply(commits,diffs,members,comments,originId,forkedId,sourceId,commitId,repository,originRepository,forkedRepository,hasWritePermission)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/pulls/compare.scala.html
                  HASH: 51a317326e85439546aa0871e3a2b994b951d921
                  MATRIX: 628->1|1228->474|1256->517|1268->521|1359->603|1398->604|1428->608|1440->612|1475->638|1514->639|1546->644|1769->840|1794->856|1821->862|1850->864|1879->872|1961->926|1987->942|2015->948|2045->950|2075->958|2293->1149|2308->1155|2398->1236|2438->1238|2477->1250|2493->1257|2506->1261|2568->1285|2609->1298|2686->1348|2712->1353|2753->1367|2778->1371|2808->1374|2823->1380|2893->1428|2923->1430|2950->1435|2980->1437|3006->1441|3058->1462|3099->1472|3136->1482|3151->1488|3192->1520|3232->1522|3271->1534|3296->1550|3320->1565|3370->1577|3411->1590|3490->1642|3532->1663|3562->1666|3577->1672|3634->1707|3664->1709|3692->1715|3744->1736|3785->1746|3821->1755|3861->1768|3876->1774|3966->1855|4006->1857|4045->1869|4061->1876|4074->1880|4136->1904|4177->1917|4254->1967|4280->1972|4321->1986|4346->1990|4376->1993|4391->1999|4461->2047|4491->2049|4518->2054|4548->2056|4574->2060|4626->2081|4667->2091|4704->2101|4719->2107|4763->2142|4803->2144|4842->2156|4867->2172|4891->2187|4941->2199|4982->2212|5061->2264|5103->2285|5133->2288|5148->2294|5205->2329|5235->2331|5263->2337|5315->2358|5356->2368|5390->2375|5439->2398|5490->2440|5529->2441|5563->2448|5893->2751|5918->2755|5947->2757|5972->2773|5999->2779|6028->2781|6053->2797|6079->2802|6314->3010|6341->3016|6700->3348|6715->3354|6837->3454|6882->3471|6960->3522|6985->3538|7012->3544|7108->3613|7137->3621|7236->3693|7261->3709|7288->3715|7393->3793|7418->3809|7444->3814|7541->3884|7570->3892|7666->3961|7695->3969|7789->4036|7818->4044|7928->4124|7960->4130|7988->4149|8027->4150|8061->4157|8333->4402|8358->4418|8385->4424|8414->4426|8443->4434|8505->4468|8531->4484|8559->4490|8589->4492|8619->4500|8710->4574|8723->4579|8762->4580|8796->4588|8810->4593|8881->4643|8915->4651|8930->4657|9052->4757|9086->4764|9182->4834|9197->4840|9289->4911|9325->4917|9359->4921|9391->4923|9419->4924|9468->4945|9497->4946|9527->4949|9600->4994|9629->4995|9661->5000|9748->5060|9776->5061|9857->5114|9886->5115|9919->5120|10007->5180|10036->5181|10157->5273|10187->5274|10220->5279|10445->5477|10474->5496|10514->5497|10549->5504|10595->5522|10632->5537|10826->5713|10840->5718|10880->5719|10915->5726|10961->5744|10987->5748|11511->6241|11542->6244|11571->6245|11638->6283|11668->6284|11701->6289|11783->6343|11812->6344|11846->6351|11878->6373|11918->6374|11951->6379|12051->6450|12081->6451|12116->6458|12187->6501|12224->6516|12323->6586|12353->6587|12383->6588|12445->6621|12475->6622|12510->6629|12539->6630|12573->6637|12602->6656|12642->6657|12677->6664|12872->6841|12886->6846|12926->6847|12961->6854|13328->7190|13363->7194|13392->7195|13421->7196
                  LINES: 13->1|28->12|29->15|29->15|29->15|29->15|30->16|30->16|30->16|30->16|31->17|34->20|34->20|34->20|34->20|34->20|34->20|34->20|34->20|34->20|34->20|38->24|38->24|38->24|38->24|39->25|39->25|39->25|39->25|40->26|40->26|40->26|40->26|40->26|40->26|40->26|40->26|40->26|40->26|40->26|40->26|41->27|42->28|43->29|43->29|43->29|43->29|44->30|44->30|44->30|44->30|45->31|45->31|45->31|45->31|45->31|45->31|45->31|45->31|46->32|47->33|48->34|49->35|49->35|49->35|49->35|50->36|50->36|50->36|50->36|51->37|51->37|51->37|51->37|51->37|51->37|51->37|51->37|51->37|51->37|51->37|51->37|52->38|53->39|54->40|54->40|54->40|54->40|55->41|55->41|55->41|55->41|56->42|56->42|56->42|56->42|56->42|56->42|56->42|56->42|57->43|58->44|59->45|61->47|61->47|61->47|62->48|67->53|67->53|67->53|67->53|67->53|67->53|67->53|67->53|70->56|70->56|76->62|76->62|76->62|77->63|77->63|77->63|77->63|78->64|78->64|79->65|79->65|79->65|80->66|80->66|80->66|81->67|81->67|82->68|82->68|83->69|83->69|88->74|89->75|89->75|89->75|90->76|94->80|94->80|94->80|94->80|94->80|94->80|94->80|94->80|94->80|94->80|98->84|98->84|98->84|99->85|99->85|99->85|100->86|100->86|100->86|101->87|102->88|102->88|102->88|103->89|104->90|105->91|106->92|107->93|107->93|108->94|108->94|108->94|109->95|111->97|111->97|113->99|113->99|114->100|116->102|116->102|118->104|118->104|119->105|124->110|124->110|124->110|125->111|125->111|125->111|128->114|128->114|128->114|129->115|129->115|129->115|136->122|137->123|137->123|139->125|139->125|140->126|142->128|142->128|144->130|144->130|144->130|145->131|145->131|145->131|146->132|147->133|147->133|148->134|148->134|148->134|148->134|148->134|149->135|149->135|151->137|151->137|151->137|152->138|156->142|156->142|156->142|157->143|163->149|164->150|165->151|165->151
                  -- GENERATED --
              */
          