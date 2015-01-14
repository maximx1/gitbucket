
package pulls.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object conversation extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template10[model.Issue,model.PullRequest,List[model.Comment],List[model.Label],List[String],List[scala.Tuple3[model.Milestone, Int, Int]],List[model.Label],Boolean,service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issue: model.Issue,
  pullreq: model.PullRequest,
  comments: List[model.Comment],
  issueLabels: List[model.Label],
  collaborators: List[String],
  milestones: List[(model.Milestone, Int, Int)],
  labels: List[model.Label],
  hasWritePermission: Boolean,
  repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import model.IssueComment
import view.helpers._

Seq[Any](format.raw/*9.87*/("""
"""),format.raw/*13.1*/("""<div class="row-fluid">
  <div class="span10">
    <div id="comment-list">
      """),_display_(/*16.8*/issues/*16.14*/.html.commentlist(Some(issue), comments, hasWritePermission, repository, Some(pullreq))),format.raw/*16.101*/("""
    """),format.raw/*17.5*/("""</div>
    """),_display_(/*18.6*/defining(comments.flatMap {
      case comment: IssueComment => Some(comment)
      case other => None
    }.exists(_.action == "merge"))/*21.35*/{ merged =>_display_(Seq[Any](format.raw/*21.46*/("""
      """),_display_(/*22.8*/if(hasWritePermission && !issue.closed)/*22.47*/{_display_(Seq[Any](format.raw/*22.48*/("""
        """),format.raw/*23.9*/("""<div class="box issue-comment-box" style="background-color: #d8f5cd;">
          <div class="box-content"class="issue-content" style="border: 1px solid #95c97e; padding: 10px;">
            <div id="merge-pull-request">
              <div class="check-conflict" style="display: none;">
                <img src=""""),_display_(/*27.28*/assets),format.raw/*27.34*/("""/common/images/indicator.gif"/> Checking...
              </div>
            </div>
            <div id="confirm-merge-form" style="display: none;">
              <form method="POST" action=""""),_display_(/*31.44*/url(repository)),format.raw/*31.59*/("""/pull/"""),_display_(/*31.66*/issue/*31.71*/.issueId),format.raw/*31.79*/("""/merge">
                <div class="strong">
                  Merge pull request #"""),_display_(/*33.40*/issue/*33.45*/.issueId),format.raw/*33.53*/(""" """),format.raw/*33.54*/("""from """),_display_(/*33.60*/{pullreq.requestUserName}),format.raw/*33.85*/("""/"""),_display_(/*33.87*/{pullreq.requestBranch}),format.raw/*33.110*/("""
                """),format.raw/*34.17*/("""</div>
                <span id="error-message" class="error"></span>
                <textarea name="message" style="width: 635px; height: 80px;">"""),_display_(/*36.79*/issue/*36.84*/.title),format.raw/*36.90*/("""</textarea>
                <div>
                  <input type="button" class="btn" value="Cancel" id="cancel-merge-pull-request"/>
                  <input type="submit" class="btn btn-success" value="Confirm merge"/>
                </div>
              </form>
            </div>
          </div>
        </div>
      """)))}),format.raw/*45.8*/("""
      """),_display_(/*46.8*/if(hasWritePermission && issue.closed && pullreq.userName == pullreq.requestUserName && merged &&
        pullreq.repositoryName == pullreq.requestRepositoryName && repository.branchList.contains(pullreq.requestBranch))/*47.122*/{_display_(Seq[Any](format.raw/*47.123*/("""
        """),format.raw/*48.9*/("""<div class="box issue-comment-box" style="background-color: #d0eeff;">
          <div class="box-content"class="issue-content" style="border: 1px solid #87a8c9; padding: 10px;">
            <a href=""""),_display_(/*50.23*/url(repository)),format.raw/*50.38*/("""/pull/"""),_display_(/*50.45*/issue/*50.50*/.issueId),format.raw/*50.58*/("""/delete/"""),_display_(/*50.67*/encodeRefName(pullreq.requestBranch)),format.raw/*50.103*/("""" class="btn btn-info pull-right delete-branch" data-name=""""),_display_(/*50.163*/pullreq/*50.170*/.requestBranch),format.raw/*50.184*/("""">Delete branch</a>
            <div>
              <span class="strong">Pull request successfully merged and closed</span>
            </div>
            <span class="small muted">You're all set-the <span class="label label-info monospace">"""),_display_(/*54.100*/pullreq/*54.107*/.requestBranch),format.raw/*54.121*/("""</span> branch can be safely deleted.</span>
          </div>
        </div>
        """)))}),format.raw/*57.10*/("""
        """),_display_(/*58.10*/issues/*58.16*/.html.commentform(issue, !merged, hasWritePermission, repository)),format.raw/*58.81*/("""
      """)))}),format.raw/*59.8*/("""
  """),format.raw/*60.3*/("""</div>
  <div class="span2">
    """),_display_(/*62.6*/issues/*62.12*/.html.issueinfo(issue, comments, issueLabels, collaborators, milestones, labels, hasWritePermission, repository)),format.raw/*62.124*/("""
  """),format.raw/*63.3*/("""</div>
</div>
<script>
$(function()"""),format.raw/*66.13*/("""{"""),format.raw/*66.14*/("""
  """),format.raw/*67.3*/("""$('#cancel-merge-pull-request').click(function()"""),format.raw/*67.51*/("""{"""),format.raw/*67.52*/("""
    """),format.raw/*68.5*/("""$('#confirm-merge-form').hide();
    $('#merge-pull-request').show();
  """),format.raw/*70.3*/("""}"""),format.raw/*70.4*/(""");

  """),_display_(/*72.4*/if(hasWritePermission)/*72.26*/{_display_(Seq[Any](format.raw/*72.27*/("""
    """),format.raw/*73.5*/("""$('.check-conflict').show();
    $.get('"""),_display_(/*74.13*/url(repository)),format.raw/*74.28*/("""/pull/"""),_display_(/*74.35*/issue/*74.40*/.issueId),format.raw/*74.48*/("""/mergeguide', function(data)"""),format.raw/*74.76*/("""{"""),format.raw/*74.77*/(""" """),format.raw/*74.78*/("""$('.check-conflict').html(data); """),format.raw/*74.111*/("""}"""),format.raw/*74.112*/(""");

    $('.delete-branch').click(function(e)"""),format.raw/*76.42*/("""{"""),format.raw/*76.43*/("""
      """),format.raw/*77.7*/("""var branchName = $(e.target).data('name');
      return confirm('Are you sure you want to remove the ' + branchName + ' branch?');
    """),format.raw/*79.5*/("""}"""),format.raw/*79.6*/(""");
  """)))}),format.raw/*80.4*/("""
"""),format.raw/*81.1*/("""}"""),format.raw/*81.2*/(""");
</script>"""))}
  }

  def render(issue:model.Issue,pullreq:model.PullRequest,comments:List[model.Comment],issueLabels:List[model.Label],collaborators:List[String],milestones:List[scala.Tuple3[model.Milestone, Int, Int]],labels:List[model.Label],hasWritePermission:Boolean,repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(issue,pullreq,comments,issueLabels,collaborators,milestones,labels,hasWritePermission,repository)(context)

  def f:((model.Issue,model.PullRequest,List[model.Comment],List[model.Label],List[String],List[scala.Tuple3[model.Milestone, Int, Int]],List[model.Label],Boolean,service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (issue,pullreq,comments,issueLabels,collaborators,milestones,labels,hasWritePermission,repository) => (context) => apply(issue,pullreq,comments,issueLabels,collaborators,milestones,labels,hasWritePermission,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/pulls/conversation.scala.html
                  HASH: 10772b377a1d9e91a485a4c5cb713cef27986228
                  MATRIX: 550->1|1046->345|1074->414|1182->496|1197->502|1306->589|1338->594|1376->606|1522->743|1571->754|1605->762|1653->801|1692->802|1728->811|2068->1124|2095->1130|2314->1322|2350->1337|2384->1344|2398->1349|2427->1357|2539->1442|2553->1447|2582->1455|2611->1456|2644->1462|2690->1487|2719->1489|2764->1512|2809->1529|2984->1677|2998->1682|3025->1688|3378->2011|3412->2019|3641->2238|3681->2239|3717->2248|3944->2448|3980->2463|4014->2470|4028->2475|4057->2483|4093->2492|4151->2528|4239->2588|4256->2595|4292->2609|4562->2851|4579->2858|4615->2872|4732->2958|4769->2968|4784->2974|4870->3039|4908->3047|4938->3050|4998->3084|5013->3090|5147->3202|5177->3205|5240->3240|5269->3241|5299->3244|5375->3292|5404->3293|5436->3298|5535->3370|5563->3371|5596->3378|5627->3400|5666->3401|5698->3406|5766->3447|5802->3462|5836->3469|5850->3474|5879->3482|5935->3510|5964->3511|5993->3512|6055->3545|6085->3546|6158->3591|6187->3592|6221->3599|6383->3734|6411->3735|6447->3741|6475->3742|6503->3743
                  LINES: 13->1|26->9|27->13|30->16|30->16|30->16|31->17|32->18|35->21|35->21|36->22|36->22|36->22|37->23|41->27|41->27|45->31|45->31|45->31|45->31|45->31|47->33|47->33|47->33|47->33|47->33|47->33|47->33|47->33|48->34|50->36|50->36|50->36|59->45|60->46|61->47|61->47|62->48|64->50|64->50|64->50|64->50|64->50|64->50|64->50|64->50|64->50|64->50|68->54|68->54|68->54|71->57|72->58|72->58|72->58|73->59|74->60|76->62|76->62|76->62|77->63|80->66|80->66|81->67|81->67|81->67|82->68|84->70|84->70|86->72|86->72|86->72|87->73|88->74|88->74|88->74|88->74|88->74|88->74|88->74|88->74|88->74|88->74|90->76|90->76|91->77|93->79|93->79|94->80|95->81|95->81
                  -- GENERATED --
              */
          