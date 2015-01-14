
package pulls.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object pullreq extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template12[model.Issue,model.PullRequest,List[model.Comment],List[model.Label],List[String],List[scala.Tuple3[model.Milestone, Int, Int]],List[model.Label],Seq[Seq[util.JGitUtil.CommitInfo]],Seq[util.JGitUtil.DiffInfo],Boolean,service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issue: model.Issue,
  pullreq: model.PullRequest,
  comments: List[model.Comment],
  issueLabels: List[model.Label],
  collaborators: List[String],
  milestones: List[(model.Milestone, Int, Int)],
  labels: List[model.Label],
  dayByDayCommits: Seq[Seq[util.JGitUtil.CommitInfo]],
  diffs: Seq[util.JGitUtil.DiffInfo],
  hasWritePermission: Boolean,
  repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*11.87*/("""
"""),_display_(/*14.2*/html/*14.6*/.main(s"${issue.title} - Pull Request #${issue.issueId} - ${repository.owner}/${repository.name}", Some(repository))/*14.122*/{_display_(Seq[Any](format.raw/*14.123*/("""
  """),_display_(/*15.4*/html/*15.8*/.menu("pulls", repository)/*15.34*/{_display_(Seq[Any](format.raw/*15.35*/("""
    """),_display_(/*16.6*/defining(dayByDayCommits.flatten)/*16.39*/{ commits =>_display_(Seq[Any](format.raw/*16.51*/("""
      """),format.raw/*17.7*/("""<div>
        <div class="show-title pull-right">
          """),_display_(/*19.12*/if(hasWritePermission || loginAccount.map(_.userName == issue.openedUserName).getOrElse(false))/*19.107*/{_display_(Seq[Any](format.raw/*19.108*/("""
            """),format.raw/*20.13*/("""<a class="btn btn-small" href="#" id="edit">Edit</a>
          """)))}),format.raw/*21.12*/("""
          """),format.raw/*22.11*/("""<a class="btn btn-small btn-success" href=""""),_display_(/*22.55*/url(repository)),format.raw/*22.70*/("""/issues/new">New issue</a>
        </div>
        <div class="edit-title pull-right" style="display: none;">
          <a class="btn" href="#" id="update">Save</a>  <a href="#" id="cancel">Cancel</a>
        </div>
        <h1>
          <span class="show-title">
            <span id="show-title">"""),_display_(/*29.36*/issue/*29.41*/.title),format.raw/*29.47*/("""</span>
            <span class="muted">#"""),_display_(/*30.35*/issue/*30.40*/.issueId),format.raw/*30.48*/("""</span>
          </span>
          <span class="edit-title" style="display: none;">
            <span id="error-edit-title" class="error"></span>
            <input type="text" style="width: 700px;" id="edit-title" value=""""),_display_(/*34.78*/issue/*34.83*/.title),format.raw/*34.89*/(""""/>
          </span>
        </h1>
      </div>
      """),_display_(/*38.8*/if(issue.closed)/*38.24*/ {_display_(Seq[Any](format.raw/*38.26*/("""
        """),_display_(/*39.10*/comments/*39.18*/.flatMap{/*39.28*/{
          case comment: model.IssueComment => Some(comment)
          case _ => None
        }}/*42.10*/.find(_.action == "merge").map/*42.40*/{ comment =>_display_(Seq[Any](format.raw/*42.52*/("""
          """),format.raw/*43.11*/("""<span class="label label-info issue-status">Merged</span>
          <span class="muted">
            """),_display_(/*45.14*/user(comment.commentedUserName, styleClass="username strong")),format.raw/*45.75*/(""" """),format.raw/*45.76*/("""merged """),_display_(/*45.84*/commits/*45.91*/.size),format.raw/*45.96*/(""" """),_display_(/*45.98*/plural(commits.size, "commit")),format.raw/*45.128*/("""
            """),format.raw/*46.13*/("""into <code>"""),_display_(/*46.25*/pullreq/*46.32*/.userName),format.raw/*46.41*/(""":"""),_display_(/*46.43*/pullreq/*46.50*/.branch),format.raw/*46.57*/("""</code> from <code>"""),_display_(/*46.77*/pullreq/*46.84*/.requestUserName),format.raw/*46.100*/(""":"""),_display_(/*46.102*/pullreq/*46.109*/.requestBranch),format.raw/*46.123*/("""</code>
            """),_display_(/*47.14*/helper/*47.20*/.html.datetimeago(comment.registeredDate)),format.raw/*47.61*/("""
          """),format.raw/*48.11*/("""</span>
        """)))}/*49.10*/.getOrElse/*49.20*/ {_display_(Seq[Any](format.raw/*49.22*/("""
          """),format.raw/*50.11*/("""<span class="label label-important issue-status">Closed</span>
          <span class="muted">
            """),_display_(/*52.14*/user(issue.openedUserName, styleClass="username strong")),format.raw/*52.70*/(""" """),format.raw/*52.71*/("""wants to merge """),_display_(/*52.87*/commits/*52.94*/.size),format.raw/*52.99*/(""" """),_display_(/*52.101*/plural(commits.size, "commit")),format.raw/*52.131*/("""
            """),format.raw/*53.13*/("""into <code>"""),_display_(/*53.25*/pullreq/*53.32*/.userName),format.raw/*53.41*/(""":"""),_display_(/*53.43*/pullreq/*53.50*/.branch),format.raw/*53.57*/("""</code> from <code>"""),_display_(/*53.77*/pullreq/*53.84*/.requestUserName),format.raw/*53.100*/(""":"""),_display_(/*53.102*/pullreq/*53.109*/.requestBranch),format.raw/*53.123*/("""</code>
          </span>
        """)))}),format.raw/*55.10*/("""
      """)))}/*56.9*/else/*56.14*/{_display_(Seq[Any](format.raw/*56.15*/("""
        """),format.raw/*57.9*/("""<span class="label label-success issue-status">Open</span>
        <span class="muted">
          """),_display_(/*59.12*/user(issue.openedUserName, styleClass="username strong")),format.raw/*59.68*/(""" """),format.raw/*59.69*/("""wants to merge """),_display_(/*59.85*/commits/*59.92*/.size),format.raw/*59.97*/(""" """),_display_(/*59.99*/plural(commits.size, "commit")),format.raw/*59.129*/("""
          """),format.raw/*60.11*/("""into <code>"""),_display_(/*60.23*/pullreq/*60.30*/.userName),format.raw/*60.39*/(""":"""),_display_(/*60.41*/pullreq/*60.48*/.branch),format.raw/*60.55*/("""</code> from <code>"""),_display_(/*60.75*/pullreq/*60.82*/.requestUserName),format.raw/*60.98*/(""":"""),_display_(/*60.100*/pullreq/*60.107*/.requestBranch),format.raw/*60.121*/("""</code>
        </span>
      """)))}),format.raw/*62.8*/("""
      """),format.raw/*63.7*/("""<br/><br/>
      <ul class="nav nav-tabs fill-width pull-left" id="pullreq-tab">
        <li class="active"><a href="#conversation">Conversation <span class="badge">"""),_display_(/*65.86*/comments/*65.94*/.flatMap{/*65.104*/{
          case comment: model.IssueComment => Some(comment)
          case _: model.CommitComment => None
        }}/*68.10*/.size),format.raw/*68.15*/("""</span></a></li>
        <li><a href="#commits">Commits <span class="badge">"""),_display_(/*69.61*/commits/*69.68*/.size),format.raw/*69.73*/("""</span></a></li>
        <li><a href="#files">Files Changed <span class="badge">"""),_display_(/*70.65*/diffs/*70.70*/.size),format.raw/*70.75*/("""</span></a></li>
      </ul>
      <div class="tab-content fill-width pull-left">
        <div class="tab-pane active" id="conversation">
          """),_display_(/*74.12*/pulls/*74.17*/.html.conversation(issue, pullreq, comments, issueLabels, collaborators, milestones, labels, hasWritePermission, repository)),format.raw/*74.141*/("""
        """),format.raw/*75.9*/("""</div>
        <div class="tab-pane" id="commits">
          """),_display_(/*77.12*/pulls/*77.17*/.html.commits(dayByDayCommits, Some(comments), repository)),format.raw/*77.75*/("""
        """),format.raw/*78.9*/("""</div>
        <div class="tab-pane" id="files">
          """),_display_(/*80.12*/helper/*80.18*/.html.diff(diffs, repository, Some(commits.head.id), Some(commits.last.id), true, Some(pullreq.issueId), hasWritePermission, true)),format.raw/*80.148*/("""
        """),format.raw/*81.9*/("""</div>
      </div>
    """)))}),format.raw/*83.6*/("""
  """)))}),format.raw/*84.4*/("""
""")))}),format.raw/*85.2*/("""
"""),format.raw/*86.1*/("""<script>
$(function()"""),format.raw/*87.13*/("""{"""),format.raw/*87.14*/("""
  """),format.raw/*88.3*/("""$('#pullreq-tab a').click(function (e) """),format.raw/*88.42*/("""{"""),format.raw/*88.43*/("""
    """),format.raw/*89.5*/("""e.preventDefault();
    $(this).tab('show');
  """),format.raw/*91.3*/("""}"""),format.raw/*91.4*/(""");

  $('#edit').click(function()"""),format.raw/*93.30*/("""{"""),format.raw/*93.31*/("""
    """),format.raw/*94.5*/("""$('.edit-title').show();
    $('.show-title').hide();
    return false;
  """),format.raw/*97.3*/("""}"""),format.raw/*97.4*/(""");

  $('#update').click(function()"""),format.raw/*99.32*/("""{"""),format.raw/*99.33*/("""
    """),format.raw/*100.5*/("""$(this).attr('disabled', 'disabled');
    $.ajax("""),format.raw/*101.12*/("""{"""),format.raw/*101.13*/("""
      """),format.raw/*102.7*/("""url: '"""),_display_(/*102.14*/url(repository)),format.raw/*102.29*/("""/issues/edit_title/"""),_display_(/*102.49*/issue/*102.54*/.issueId),format.raw/*102.62*/("""',
      type: 'POST',
      data: """),format.raw/*104.13*/("""{"""),format.raw/*104.14*/("""
        """),format.raw/*105.9*/("""title   : $('#edit-title').val()
      """),format.raw/*106.7*/("""}"""),format.raw/*106.8*/("""
    """),format.raw/*107.5*/("""}"""),format.raw/*107.6*/(""").done(function(data)"""),format.raw/*107.27*/("""{"""),format.raw/*107.28*/("""
      """),format.raw/*108.7*/("""$('#show-title').empty().text(data.title);
      $('#cancel').click();
      $(this).removeAttr('disabled');
    """),format.raw/*111.5*/("""}"""),format.raw/*111.6*/(""").fail(function(req)"""),format.raw/*111.26*/("""{"""),format.raw/*111.27*/("""
      """),format.raw/*112.7*/("""$(this).removeAttr('disabled');
      $('#error-edit-title').text($.parseJSON(req.responseText).title);
    """),format.raw/*114.5*/("""}"""),format.raw/*114.6*/(""");
    return false;
  """),format.raw/*116.3*/("""}"""),format.raw/*116.4*/(""");

  $('#cancel').click(function()"""),format.raw/*118.32*/("""{"""),format.raw/*118.33*/("""
    """),format.raw/*119.5*/("""$('.edit-title').hide();
    $('.show-title').show();
    return false;
  """),format.raw/*122.3*/("""}"""),format.raw/*122.4*/(""");
"""),format.raw/*123.1*/("""}"""),format.raw/*123.2*/(""");
</script>"""))}
  }

  def render(issue:model.Issue,pullreq:model.PullRequest,comments:List[model.Comment],issueLabels:List[model.Label],collaborators:List[String],milestones:List[scala.Tuple3[model.Milestone, Int, Int]],labels:List[model.Label],dayByDayCommits:Seq[Seq[util.JGitUtil.CommitInfo]],diffs:Seq[util.JGitUtil.DiffInfo],hasWritePermission:Boolean,repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(issue,pullreq,comments,issueLabels,collaborators,milestones,labels,dayByDayCommits,diffs,hasWritePermission,repository)(context)

  def f:((model.Issue,model.PullRequest,List[model.Comment],List[model.Label],List[String],List[scala.Tuple3[model.Milestone, Int, Int]],List[model.Label],Seq[Seq[util.JGitUtil.CommitInfo]],Seq[util.JGitUtil.DiffInfo],Boolean,service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (issue,pullreq,comments,issueLabels,collaborators,milestones,labels,dayByDayCommits,diffs,hasWritePermission,repository) => (context) => apply(issue,pullreq,comments,issueLabels,collaborators,milestones,labels,dayByDayCommits,diffs,hasWritePermission,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/pulls/pullreq.scala.html
                  HASH: 054ac1e5d3767b81f94b9afa58a0fcbef21c3338
                  MATRIX: 608->1|1172->438|1200->481|1212->485|1338->601|1378->602|1408->606|1420->610|1455->636|1494->637|1526->643|1568->676|1618->688|1652->695|1740->756|1845->851|1885->852|1926->865|2021->929|2060->940|2131->984|2167->999|2493->1298|2507->1303|2534->1309|2603->1351|2617->1356|2646->1364|2897->1588|2911->1593|2938->1599|3020->1655|3045->1671|3085->1673|3122->1683|3139->1691|3157->1701|3263->1797|3302->1827|3352->1839|3391->1850|3520->1952|3602->2013|3631->2014|3666->2022|3682->2029|3708->2034|3737->2036|3789->2066|3830->2079|3869->2091|3885->2098|3915->2107|3944->2109|3960->2116|3988->2123|4035->2143|4051->2150|4089->2166|4119->2168|4136->2175|4172->2189|4220->2210|4235->2216|4297->2257|4336->2268|4372->2285|4391->2295|4431->2297|4470->2308|4604->2415|4681->2471|4710->2472|4753->2488|4769->2495|4795->2500|4825->2502|4877->2532|4918->2545|4957->2557|4973->2564|5003->2573|5032->2575|5048->2582|5076->2589|5123->2609|5139->2616|5177->2632|5207->2634|5224->2641|5260->2655|5326->2690|5352->2699|5365->2704|5404->2705|5440->2714|5566->2813|5643->2869|5672->2870|5715->2886|5731->2893|5757->2898|5786->2900|5838->2930|5877->2941|5916->2953|5932->2960|5962->2969|5991->2971|6007->2978|6035->2985|6082->3005|6098->3012|6135->3028|6165->3030|6182->3037|6218->3051|6279->3082|6313->3089|6506->3255|6523->3263|6542->3273|6669->3390|6695->3395|6799->3472|6815->3479|6841->3484|6949->3565|6963->3570|6989->3575|7165->3724|7179->3729|7325->3853|7361->3862|7450->3924|7464->3929|7543->3987|7579->3996|7666->4056|7681->4062|7833->4192|7869->4201|7924->4226|7958->4230|7990->4232|8018->4233|8067->4254|8096->4255|8126->4258|8193->4297|8222->4298|8254->4303|8328->4350|8356->4351|8417->4384|8446->4385|8478->4390|8579->4464|8607->4465|8670->4500|8699->4501|8732->4506|8810->4555|8840->4556|8875->4563|8910->4570|8947->4585|8995->4605|9010->4610|9040->4618|9104->4653|9134->4654|9171->4663|9238->4702|9267->4703|9300->4708|9329->4709|9379->4730|9409->4731|9444->4738|9585->4851|9614->4852|9663->4872|9693->4873|9728->4880|9864->4988|9893->4989|9944->5012|9973->5013|10037->5048|10067->5049|10100->5054|10202->5128|10231->5129|10262->5132|10291->5133
                  LINES: 13->1|27->11|28->14|28->14|28->14|28->14|29->15|29->15|29->15|29->15|30->16|30->16|30->16|31->17|33->19|33->19|33->19|34->20|35->21|36->22|36->22|36->22|43->29|43->29|43->29|44->30|44->30|44->30|48->34|48->34|48->34|52->38|52->38|52->38|53->39|53->39|53->39|56->42|56->42|56->42|57->43|59->45|59->45|59->45|59->45|59->45|59->45|59->45|59->45|60->46|60->46|60->46|60->46|60->46|60->46|60->46|60->46|60->46|60->46|60->46|60->46|60->46|61->47|61->47|61->47|62->48|63->49|63->49|63->49|64->50|66->52|66->52|66->52|66->52|66->52|66->52|66->52|66->52|67->53|67->53|67->53|67->53|67->53|67->53|67->53|67->53|67->53|67->53|67->53|67->53|67->53|69->55|70->56|70->56|70->56|71->57|73->59|73->59|73->59|73->59|73->59|73->59|73->59|73->59|74->60|74->60|74->60|74->60|74->60|74->60|74->60|74->60|74->60|74->60|74->60|74->60|74->60|76->62|77->63|79->65|79->65|79->65|82->68|82->68|83->69|83->69|83->69|84->70|84->70|84->70|88->74|88->74|88->74|89->75|91->77|91->77|91->77|92->78|94->80|94->80|94->80|95->81|97->83|98->84|99->85|100->86|101->87|101->87|102->88|102->88|102->88|103->89|105->91|105->91|107->93|107->93|108->94|111->97|111->97|113->99|113->99|114->100|115->101|115->101|116->102|116->102|116->102|116->102|116->102|116->102|118->104|118->104|119->105|120->106|120->106|121->107|121->107|121->107|121->107|122->108|125->111|125->111|125->111|125->111|126->112|128->114|128->114|130->116|130->116|132->118|132->118|133->119|136->122|136->122|137->123|137->123
                  -- GENERATED --
              */
          