
package issues.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object commentlist extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[Option[model.Issue],List[model.Comment],Boolean,service.RepositoryService.RepositoryInfo,Option[model.PullRequest],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issue: Option[model.Issue],
  comments: List[model.Comment],
  hasWritePermission: Boolean,
  repository: service.RepositoryService.RepositoryInfo,
  pullreq: Option[model.PullRequest] = None)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*5.76*/("""
"""),_display_(/*8.2*/if(issue.isDefined)/*8.21*/{_display_(Seq[Any](format.raw/*8.22*/("""
  """),format.raw/*9.3*/("""<div class="issue-avatar-image">"""),_display_(/*9.36*/avatar(issue.get.openedUserName, 48)),format.raw/*9.72*/("""</div>
  <div class="box issue-comment-box">
    <div class="box-header-small">
      """),_display_(/*12.8*/user(issue.get.openedUserName, styleClass="username strong")),format.raw/*12.68*/(""" """),format.raw/*12.69*/("""<span class="muted">commented """),_display_(/*12.100*/helper/*12.106*/.html.datetimeago(issue.get.registeredDate)),format.raw/*12.149*/("""</span>
      <span class="pull-right">
        """),_display_(/*14.10*/if(hasWritePermission || loginAccount.map(_.userName == issue.get.openedUserName).getOrElse(false))/*14.109*/{_display_(Seq[Any](format.raw/*14.110*/("""
          """),format.raw/*15.11*/("""<a href="#" data-issue-id=""""),_display_(/*15.39*/issue/*15.44*/.get.issueId),format.raw/*15.56*/(""""><i class="icon-pencil"></i></a>
        """)))}),format.raw/*16.10*/("""
      """),format.raw/*17.7*/("""</span>
    </div>
    <div class="box-content issue-content" id="issueContent">
      """),_display_(/*20.8*/markdown(issue.get.content getOrElse "No description provided.", repository, false, true, true, hasWritePermission)),format.raw/*20.123*/("""
    """),format.raw/*21.5*/("""</div>
  </div>
""")))}),format.raw/*23.2*/("""

"""),_display_(/*25.2*/comments/*25.10*/.map/*25.14*/ {/*26.3*/case comment: model.IssueComment =>/*26.38*/ {_display_(Seq[Any](format.raw/*26.40*/("""
    """),_display_(/*27.6*/if(comment.action != "close" && comment.action != "reopen" && comment.action != "delete_branch")/*27.102*/{_display_(Seq[Any](format.raw/*27.103*/("""
      """),format.raw/*28.7*/("""<div class="issue-avatar-image">"""),_display_(/*28.40*/avatar(comment.commentedUserName, 48)),format.raw/*28.77*/("""</div>
      <div class="box issue-comment-box" id="comment-"""),_display_(/*29.55*/comment/*29.62*/.commentId),format.raw/*29.72*/("""">
        <div class="box-header-small">
          """),_display_(/*31.12*/user(comment.commentedUserName, styleClass="username strong")),format.raw/*31.73*/("""
          """),format.raw/*32.11*/("""<span class="muted">
            """),_display_(/*33.14*/if(comment.action == "comment")/*33.45*/{_display_(Seq[Any](format.raw/*33.46*/("""
              """),format.raw/*34.15*/("""commented
            """)))}/*35.15*/else/*35.20*/{_display_(Seq[Any](format.raw/*35.21*/("""
              """),_display_(/*36.16*/if(pullreq.isEmpty)/*36.35*/{_display_(Seq[Any](format.raw/*36.36*/(""" """),format.raw/*36.37*/("""referenced the issue """)))}/*36.60*/else/*36.65*/{_display_(Seq[Any](format.raw/*36.66*/(""" """),format.raw/*36.67*/("""referenced the pull request """)))}),format.raw/*36.96*/("""
            """)))}),format.raw/*37.14*/("""
            """),_display_(/*38.14*/helper/*38.20*/.html.datetimeago(comment.registeredDate)),format.raw/*38.61*/("""
          """),format.raw/*39.11*/("""</span>
          <span class="pull-right">
            """),_display_(/*41.14*/if(comment.action != "commit" && comment.action != "merge" && comment.action != "refer"
                  && (hasWritePermission || loginAccount.map(_.userName == comment.commentedUserName).getOrElse(false)))/*42.121*/{_display_(Seq[Any](format.raw/*42.122*/("""
              """),format.raw/*43.15*/("""<a href="#" data-comment-id=""""),_display_(/*43.45*/comment/*43.52*/.commentId),format.raw/*43.62*/(""""><i class="icon-pencil"></i></a>&nbsp;
              <a href="#" data-comment-id=""""),_display_(/*44.45*/comment/*44.52*/.commentId),format.raw/*44.62*/(""""><i class="icon-remove-circle"></i></a>
            """)))}),format.raw/*45.14*/("""
          """),format.raw/*46.11*/("""</span>
        </div>
        <div class="box-content"class="issue-content" id="commentContent-"""),_display_(/*48.75*/comment/*48.82*/.commentId),format.raw/*48.92*/("""">
          """),_display_(/*49.12*/if(comment.action == "commit" && comment.content.split(" ").last.matches("[a-f0-9]{40}"))/*49.101*/{_display_(Seq[Any](format.raw/*49.102*/("""
            """),_display_(/*50.14*/defining(comment.content.substring(comment.content.length - 40))/*50.78*/{ id =>_display_(Seq[Any](format.raw/*50.85*/("""
              """),format.raw/*51.15*/("""<div class="pull-right"><a href=""""),_display_(/*51.49*/path),format.raw/*51.53*/("""/"""),_display_(/*51.55*/repository/*51.65*/.owner),format.raw/*51.71*/("""/"""),_display_(/*51.73*/repository/*51.83*/.name),format.raw/*51.88*/("""/commit/"""),_display_(/*51.97*/id),format.raw/*51.99*/("""" class="monospace">"""),_display_(/*51.120*/id/*51.122*/.substring(0, 7)),format.raw/*51.138*/("""</a></div>
              """),_display_(/*52.16*/markdown(comment.content.substring(0, comment.content.length - 41), repository, false, true, true, hasWritePermission)),format.raw/*52.134*/("""
            """)))}),format.raw/*53.14*/("""
          """)))}/*54.13*/else/*54.18*/{_display_(Seq[Any](format.raw/*54.19*/("""
            """),_display_(/*55.14*/if(comment.action == "refer")/*55.43*/{_display_(Seq[Any](format.raw/*55.44*/("""
              """),_display_(/*56.16*/defining(comment.content.split(":"))/*56.52*/{ case Array(issueId, rest @ _*) =>_display_(Seq[Any](format.raw/*56.87*/("""
                """),format.raw/*57.17*/("""<strong><a href=""""),_display_(/*57.35*/path),format.raw/*57.39*/("""/"""),_display_(/*57.41*/repository/*57.51*/.owner),format.raw/*57.57*/("""/"""),_display_(/*57.59*/repository/*57.69*/.name),format.raw/*57.74*/("""/issues/"""),_display_(/*57.83*/issueId),format.raw/*57.90*/("""">Issue #"""),_display_(/*57.100*/issueId),format.raw/*57.107*/("""</a>: """),_display_(/*57.114*/rest/*57.118*/.mkString(":")),format.raw/*57.132*/("""</strong>
              """)))}),format.raw/*58.16*/("""
            """)))}/*59.15*/else/*59.20*/{_display_(Seq[Any](format.raw/*59.21*/("""
              """),_display_(/*60.16*/markdown(comment.content, repository, false, true, true, hasWritePermission)),format.raw/*60.92*/("""
            """)))}),format.raw/*61.14*/("""
          """)))}),format.raw/*62.12*/("""
        """),format.raw/*63.9*/("""</div>
      </div>
    """)))}),format.raw/*65.6*/("""
    """),_display_(/*66.6*/if(comment.action == "merge")/*66.35*/{_display_(Seq[Any](format.raw/*66.36*/("""
      """),format.raw/*67.7*/("""<div class="small" style="margin-top: 10px; margin-bottom: 10px;">
        <span class="label label-info">Merged</span>
        """),_display_(/*69.10*/avatar(comment.commentedUserName, 20)),format.raw/*69.47*/("""
        """),_display_(/*70.10*/user(comment.commentedUserName, styleClass="username strong")),format.raw/*70.71*/(""" """),format.raw/*70.72*/("""merged commit <code>"""),_display_(/*70.93*/pullreq/*70.100*/.map(_.commitIdTo.substring(0, 7))),format.raw/*70.134*/("""</code> into
        """),_display_(/*71.10*/if(pullreq.get.requestUserName == repository.owner)/*71.61*/{_display_(Seq[Any](format.raw/*71.62*/("""
          """),format.raw/*72.11*/("""<span class="label label-info monospace">"""),_display_(/*72.53*/pullreq/*72.60*/.map(_.branch)),format.raw/*72.74*/("""</span> from <span class="label label-info monospace">"""),_display_(/*72.129*/pullreq/*72.136*/.map(_.requestBranch)),format.raw/*72.157*/("""</span>
        """)))}/*73.11*/else/*73.16*/{_display_(Seq[Any](format.raw/*73.17*/("""
          """),format.raw/*74.11*/("""<span class="label label-info monospace">"""),_display_(/*74.53*/pullreq/*74.60*/.map(_.userName)),format.raw/*74.76*/(""":"""),_display_(/*74.78*/pullreq/*74.85*/.map(_.branch)),format.raw/*74.99*/("""</span> from <span class="label label-info monospace">"""),_display_(/*74.154*/pullreq/*74.161*/.map(_.requestUserName)),format.raw/*74.184*/(""":"""),_display_(/*74.186*/pullreq/*74.193*/.map(_.requestBranch)),format.raw/*74.214*/("""</span>
        """)))}),format.raw/*75.10*/("""
        """),_display_(/*76.10*/helper/*76.16*/.html.datetimeago(comment.registeredDate)),format.raw/*76.57*/("""
      """),format.raw/*77.7*/("""</div>
    """)))}),format.raw/*78.6*/("""
    """),_display_(/*79.6*/if(comment.action == "close" || comment.action == "close_comment")/*79.72*/{_display_(Seq[Any](format.raw/*79.73*/("""
      """),format.raw/*80.7*/("""<div class="small issue-comment-action">
        <span class="label label-important">Closed</span>
        """),_display_(/*82.10*/avatar(comment.commentedUserName, 20)),format.raw/*82.47*/("""
        """),_display_(/*83.10*/if(issue.isDefined && issue.get.isPullRequest)/*83.56*/{_display_(Seq[Any](format.raw/*83.57*/("""
          """),_display_(/*84.12*/user(comment.commentedUserName, styleClass="username strong")),format.raw/*84.73*/(""" """),format.raw/*84.74*/("""closed the pull request """),_display_(/*84.99*/helper/*84.105*/.html.datetimeago(comment.registeredDate)),format.raw/*84.146*/("""
        """)))}/*85.11*/else/*85.16*/{_display_(Seq[Any](format.raw/*85.17*/("""
          """),_display_(/*86.12*/user(comment.commentedUserName, styleClass="username strong")),format.raw/*86.73*/(""" """),format.raw/*86.74*/("""closed the issue """),_display_(/*86.92*/helper/*86.98*/.html.datetimeago(comment.registeredDate)),format.raw/*86.139*/("""
        """)))}),format.raw/*87.10*/("""
      """),format.raw/*88.7*/("""</div>
    """)))}),format.raw/*89.6*/("""
    """),_display_(/*90.6*/if(comment.action == "reopen" || comment.action == "reopen_comment")/*90.74*/{_display_(Seq[Any](format.raw/*90.75*/("""
      """),format.raw/*91.7*/("""<div class="small issue-comment-action">
        <span class="label label-success">Reopened</span>
        """),_display_(/*93.10*/avatar(comment.commentedUserName, 20)),format.raw/*93.47*/("""
        """),_display_(/*94.10*/user(comment.commentedUserName, styleClass="username strong")),format.raw/*94.71*/(""" """),format.raw/*94.72*/("""reopened the issue """),_display_(/*94.92*/helper/*94.98*/.html.datetimeago(comment.registeredDate)),format.raw/*94.139*/("""
      """),format.raw/*95.7*/("""</div>
    """)))}),format.raw/*96.6*/("""
    """),_display_(/*97.6*/if(comment.action == "delete_branch")/*97.43*/{_display_(Seq[Any](format.raw/*97.44*/("""
      """),format.raw/*98.7*/("""<div class="small issue-comment-action">
        <span class="label">Deleted</span>
        """),_display_(/*100.10*/avatar(comment.commentedUserName, 20)),format.raw/*100.47*/("""
        """),_display_(/*101.10*/user(comment.commentedUserName, styleClass="username strong")),format.raw/*101.71*/(""" """),format.raw/*101.72*/("""deleted the <span class="label label-info monospace">"""),_display_(/*101.126*/pullreq/*101.133*/.map(_.requestBranch)),format.raw/*101.154*/("""</span> branch """),_display_(/*101.170*/helper/*101.176*/.html.datetimeago(comment.registeredDate)),format.raw/*101.217*/("""
      """),format.raw/*102.7*/("""</div>
    """)))}),format.raw/*103.6*/("""
  """)))}/*105.3*/case comment: model.CommitComment =>/*105.39*/ {_display_(Seq[Any](format.raw/*105.41*/("""
    """),_display_(/*106.6*/helper/*106.12*/.html.commitcomment(comment, hasWritePermission, repository, pullreq.map(_.commitIdTo))),format.raw/*106.99*/("""
  """)))}}),format.raw/*108.2*/("""
"""),format.raw/*109.1*/("""<script>
$(function()"""),format.raw/*110.13*/("""{"""),format.raw/*110.14*/("""
"""),_display_(/*111.2*/if(issue.isDefined)/*111.21*/{_display_(Seq[Any](format.raw/*111.22*/("""
  """),format.raw/*112.3*/("""$('.issue-comment-box i.icon-pencil').click(function()"""),format.raw/*112.57*/("""{"""),format.raw/*112.58*/("""
    """),format.raw/*113.5*/("""var id  = $(this).closest('a').data('comment-id');
    var url = '"""),_display_(/*114.17*/url(repository)),format.raw/*114.32*/("""/issue_comments/_data/' + id;
    var $content = $('#commentContent-' + id);

    if(!id)"""),format.raw/*117.12*/("""{"""),format.raw/*117.13*/("""
      """),format.raw/*118.7*/("""id  = $(this).closest('a').data('issue-id');
      url = '"""),_display_(/*119.15*/url(repository)),format.raw/*119.30*/("""/issues/_data/' + id;
      $content = $('#issueContent');
    """),format.raw/*121.5*/("""}"""),format.raw/*121.6*/("""

    """),format.raw/*123.5*/("""$.get(url,
    """),format.raw/*124.5*/("""{"""),format.raw/*124.6*/("""
      """),format.raw/*125.7*/("""dataType : 'html'
    """),format.raw/*126.5*/("""}"""),format.raw/*126.6*/(""",
    function(data)"""),format.raw/*127.19*/("""{"""),format.raw/*127.20*/("""
      """),format.raw/*128.7*/("""$content.empty().html(data);
    """),format.raw/*129.5*/("""}"""),format.raw/*129.6*/(""");
    return false;
  """),format.raw/*131.3*/("""}"""),format.raw/*131.4*/(""");
  $('.issue-comment-box i.icon-remove-circle').click(function()"""),format.raw/*132.64*/("""{"""),format.raw/*132.65*/("""
    """),format.raw/*133.5*/("""if(confirm('Are you sure you want to delete this?')) """),format.raw/*133.58*/("""{"""),format.raw/*133.59*/("""
      """),format.raw/*134.7*/("""var id = $(this).closest('a').data('comment-id');
      $.post('"""),_display_(/*135.16*/url(repository)),format.raw/*135.31*/("""/issue_comments/delete/' + id,
      function(data)"""),format.raw/*136.21*/("""{"""),format.raw/*136.22*/("""
        """),format.raw/*137.9*/("""if(data > 0) """),format.raw/*137.22*/("""{"""),format.raw/*137.23*/("""
          """),format.raw/*138.11*/("""$('#comment-' + id).prev('div.issue-avatar-image').remove();
          $('#comment-' + id).remove();
        """),format.raw/*140.9*/("""}"""),format.raw/*140.10*/("""
      """),format.raw/*141.7*/("""}"""),format.raw/*141.8*/(""");
    """),format.raw/*142.5*/("""}"""),format.raw/*142.6*/("""
    """),format.raw/*143.5*/("""return false;
  """),format.raw/*144.3*/("""}"""),format.raw/*144.4*/(""");
""")))}),format.raw/*145.2*/("""
  """),format.raw/*146.3*/("""$(document).on('click', '.commit-comment-box i.icon-pencil', function()"""),format.raw/*146.74*/("""{"""),format.raw/*146.75*/("""
    """),format.raw/*147.5*/("""var id  = $(this).closest('a').data('comment-id');
    var url = '"""),_display_(/*148.17*/url(repository)),format.raw/*148.32*/("""/commit_comments/_data/' + id;
    var $content = $('.commit-commentContent-' + id, $(this).closest('.box'));

    $.get(url,
    """),format.raw/*152.5*/("""{"""),format.raw/*152.6*/("""
      """),format.raw/*153.7*/("""dataType : 'html'
    """),format.raw/*154.5*/("""}"""),format.raw/*154.6*/(""",
    function(data)"""),format.raw/*155.19*/("""{"""),format.raw/*155.20*/("""
      """),format.raw/*156.7*/("""$content.empty().html(data);
    """),format.raw/*157.5*/("""}"""),format.raw/*157.6*/(""");
    return false;
  """),format.raw/*159.3*/("""}"""),format.raw/*159.4*/(""");
  $(document).on('click', '.commit-comment-box i.icon-remove-circle', function()"""),format.raw/*160.81*/("""{"""),format.raw/*160.82*/("""
    """),format.raw/*161.5*/("""if(confirm('Are you sure you want to delete this?')) """),format.raw/*161.58*/("""{"""),format.raw/*161.59*/("""
      """),format.raw/*162.7*/("""var id = $(this).closest('a').data('comment-id');
      $.post('"""),_display_(/*163.16*/url(repository)),format.raw/*163.31*/("""/commit_comments/delete/' + id,
      function(data)"""),format.raw/*164.21*/("""{"""),format.raw/*164.22*/("""
        """),format.raw/*165.9*/("""if(data > 0) """),format.raw/*165.22*/("""{"""),format.raw/*165.23*/("""
          """),format.raw/*166.11*/("""$('.commit-comment-' + id).closest('.not-diff').remove();
          $('.commit-comment-' + id).closest('.inline-comment').remove();
        """),format.raw/*168.9*/("""}"""),format.raw/*168.10*/("""
      """),format.raw/*169.7*/("""}"""),format.raw/*169.8*/(""");
    """),format.raw/*170.5*/("""}"""),format.raw/*170.6*/("""
    """),format.raw/*171.5*/("""return false;
  """),format.raw/*172.3*/("""}"""),format.raw/*172.4*/(""");

  var extractMarkdown = function(data)"""),format.raw/*174.39*/("""{"""),format.raw/*174.40*/("""
    """),format.raw/*175.5*/("""$('body').append('<div id="tmp"></div>');
    $('#tmp').html(data);
    var markdown = $('#tmp textarea').val();
    $('#tmp').remove();
    return markdown;
  """),format.raw/*180.3*/("""}"""),format.raw/*180.4*/(""";

  var replaceTaskList = function(issueContentHtml, checkboxes) """),format.raw/*182.64*/("""{"""),format.raw/*182.65*/("""
    """),format.raw/*183.5*/("""var ss = [],
        markdown = extractMarkdown(issueContentHtml),
        xs = markdown.split(/- \[[x| ]\]/g);
    for (var i=0; i<xs.length; i++) """),format.raw/*186.37*/("""{"""),format.raw/*186.38*/("""
      """),format.raw/*187.7*/("""ss.push(xs[i]);
      if (checkboxes.eq(i).prop('checked')) ss.push('- [x]');
      else ss.push('- [ ]');
    """),format.raw/*190.5*/("""}"""),format.raw/*190.6*/("""
    """),format.raw/*191.5*/("""ss.pop();
    return ss.join('');
  """),format.raw/*193.3*/("""}"""),format.raw/*193.4*/(""";

  $('div[class*=commit-commentContent-]').on('click', ':checkbox', function(ev)"""),format.raw/*195.80*/("""{"""),format.raw/*195.81*/("""
    """),format.raw/*196.5*/("""var $commentContent = $(ev.target).parents('div[class*=commit-commentContent-]'),
        commentId = $commentContent.attr('class').match(/commit-commentContent-.+/)[0].replace(/commit-commentContent-/, ''),
        checkboxes = $commentContent.find(':checkbox');
    $.get('"""),_display_(/*199.13*/url(repository)),format.raw/*199.28*/("""/commit_comments/_data/' + commentId,
      """),format.raw/*200.7*/("""{"""),format.raw/*200.8*/("""
        """),format.raw/*201.9*/("""dataType : 'html'
      """),format.raw/*202.7*/("""}"""),format.raw/*202.8*/(""",
      function(responseContent)"""),format.raw/*203.32*/("""{"""),format.raw/*203.33*/("""
        """),format.raw/*204.9*/("""$.ajax("""),format.raw/*204.16*/("""{"""),format.raw/*204.17*/("""
          """),format.raw/*205.11*/("""url: '"""),_display_(/*205.18*/url(repository)),format.raw/*205.33*/("""/commit_comments/edit/' + commentId,
          type: 'POST',
          data: """),format.raw/*207.17*/("""{"""),format.raw/*207.18*/("""
            """),format.raw/*208.13*/("""issueId : 0,
            content : replaceTaskList(responseContent, checkboxes)
          """),format.raw/*210.11*/("""}"""),format.raw/*210.12*/(""",
          success: function(data) """),format.raw/*211.35*/("""{"""),format.raw/*211.36*/("""
            """),format.raw/*212.13*/("""$('.commit-commentContent-' + commentId).html(data.content);
          """),format.raw/*213.11*/("""}"""),format.raw/*213.12*/("""
        """),format.raw/*214.9*/("""}"""),format.raw/*214.10*/(""");
      """),format.raw/*215.7*/("""}"""),format.raw/*215.8*/("""
    """),format.raw/*216.5*/(""");
  """),format.raw/*217.3*/("""}"""),format.raw/*217.4*/(""");

  """),_display_(/*219.4*/if(issue.isDefined)/*219.23*/{_display_(Seq[Any](format.raw/*219.24*/("""
  """),format.raw/*220.3*/("""$('#issueContent').on('click', ':checkbox', function(ev)"""),format.raw/*220.59*/("""{"""),format.raw/*220.60*/("""
    """),format.raw/*221.5*/("""var checkboxes = $('#issueContent :checkbox');
    $.get('"""),_display_(/*222.13*/url(repository)),format.raw/*222.28*/("""/issues/_data/"""),_display_(/*222.43*/issue/*222.48*/.get.issueId),format.raw/*222.60*/("""',
      """),format.raw/*223.7*/("""{"""),format.raw/*223.8*/("""
        """),format.raw/*224.9*/("""dataType : 'html'
      """),format.raw/*225.7*/("""}"""),format.raw/*225.8*/(""",
      function(responseContent)"""),format.raw/*226.32*/("""{"""),format.raw/*226.33*/("""
        """),format.raw/*227.9*/("""$.ajax("""),format.raw/*227.16*/("""{"""),format.raw/*227.17*/("""
          """),format.raw/*228.11*/("""url: '"""),_display_(/*228.18*/url(repository)),format.raw/*228.33*/("""/issues/edit/"""),_display_(/*228.47*/issue/*228.52*/.get.issueId),format.raw/*228.64*/("""',
          type: 'POST',
          data: """),format.raw/*230.17*/("""{"""),format.raw/*230.18*/("""
            """),format.raw/*231.13*/("""title   : $('#issueTitle').text(),
            content : replaceTaskList(responseContent, checkboxes)
          """),format.raw/*233.11*/("""}"""),format.raw/*233.12*/("""
        """),format.raw/*234.9*/("""}"""),format.raw/*234.10*/(""");
      """),format.raw/*235.7*/("""}"""),format.raw/*235.8*/("""
    """),format.raw/*236.5*/(""");
  """),format.raw/*237.3*/("""}"""),format.raw/*237.4*/(""");

  $('div[id^=commentContent-]').on('click', ':checkbox', function(ev)"""),format.raw/*239.70*/("""{"""),format.raw/*239.71*/("""
    """),format.raw/*240.5*/("""var $commentContent = $(ev.target).parents('div[id^=commentContent-]'),
        commentId = $commentContent.attr('id').replace(/commentContent-/, ''),
        checkboxes = $commentContent.find(':checkbox');
    $.get('"""),_display_(/*243.13*/url(repository)),format.raw/*243.28*/("""/issue_comments/_data/' + commentId,
      """),format.raw/*244.7*/("""{"""),format.raw/*244.8*/("""
        """),format.raw/*245.9*/("""dataType : 'html'
      """),format.raw/*246.7*/("""}"""),format.raw/*246.8*/(""",
      function(responseContent)"""),format.raw/*247.32*/("""{"""),format.raw/*247.33*/("""
        """),format.raw/*248.9*/("""$.ajax("""),format.raw/*248.16*/("""{"""),format.raw/*248.17*/("""
          """),format.raw/*249.11*/("""url: '"""),_display_(/*249.18*/url(repository)),format.raw/*249.33*/("""/issue_comments/edit/' + commentId,
          type: 'POST',
          data: """),format.raw/*251.17*/("""{"""),format.raw/*251.18*/("""
            """),format.raw/*252.13*/("""issueId : 0,
            content : replaceTaskList(responseContent, checkboxes)
          """),format.raw/*254.11*/("""}"""),format.raw/*254.12*/("""
        """),format.raw/*255.9*/("""}"""),format.raw/*255.10*/(""");
      """),format.raw/*256.7*/("""}"""),format.raw/*256.8*/("""
    """),format.raw/*257.5*/(""");
  """),format.raw/*258.3*/("""}"""),format.raw/*258.4*/(""");

  """)))}),format.raw/*260.4*/("""

"""),format.raw/*262.1*/("""}"""),format.raw/*262.2*/(""");
</script>
"""))}
  }

  def render(issue:Option[model.Issue],comments:List[model.Comment],hasWritePermission:Boolean,repository:service.RepositoryService.RepositoryInfo,pullreq:Option[model.PullRequest],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(issue,comments,hasWritePermission,repository,pullreq)(context)

  def f:((Option[model.Issue],List[model.Comment],Boolean,service.RepositoryService.RepositoryInfo,Option[model.PullRequest]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (issue,comments,hasWritePermission,repository,pullreq) => (context) => apply(issue,comments,hasWritePermission,repository,pullreq)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/issues/commentlist.scala.html
                  HASH: 019959b5acad8f92f5c5c1f2bb54c98c5c73493c
                  MATRIX: 470->1|820->225|847->268|874->287|912->288|941->291|1000->324|1056->360|1169->447|1250->507|1279->508|1338->539|1354->545|1419->588|1495->637|1604->736|1644->737|1683->748|1738->776|1752->781|1785->793|1859->836|1893->843|2007->931|2144->1046|2176->1051|2223->1068|2252->1071|2269->1079|2282->1083|2292->1088|2336->1123|2376->1125|2408->1131|2514->1227|2554->1228|2588->1235|2648->1268|2706->1305|2794->1366|2810->1373|2841->1383|2921->1436|3003->1497|3042->1508|3103->1542|3143->1573|3182->1574|3225->1589|3267->1613|3280->1618|3319->1619|3362->1635|3390->1654|3429->1655|3458->1656|3499->1679|3512->1684|3551->1685|3580->1686|3640->1715|3685->1729|3726->1743|3741->1749|3803->1790|3842->1801|3926->1858|4144->2066|4184->2067|4227->2082|4284->2112|4300->2119|4331->2129|4442->2213|4458->2220|4489->2230|4574->2284|4613->2295|4737->2392|4753->2399|4784->2409|4825->2423|4924->2512|4964->2513|5005->2527|5078->2591|5123->2598|5166->2613|5227->2647|5252->2651|5281->2653|5300->2663|5327->2669|5356->2671|5375->2681|5401->2686|5437->2695|5460->2697|5509->2718|5521->2720|5559->2736|5612->2762|5752->2880|5797->2894|5828->2907|5841->2912|5880->2913|5921->2927|5959->2956|5998->2957|6041->2973|6086->3009|6159->3044|6204->3061|6249->3079|6274->3083|6303->3085|6322->3095|6349->3101|6378->3103|6397->3113|6423->3118|6459->3127|6487->3134|6525->3144|6554->3151|6589->3158|6603->3162|6639->3176|6695->3201|6728->3216|6741->3221|6780->3222|6823->3238|6920->3314|6965->3328|7008->3340|7044->3349|7099->3374|7131->3380|7169->3409|7208->3410|7242->3417|7398->3546|7456->3583|7493->3593|7575->3654|7604->3655|7652->3676|7669->3683|7725->3717|7774->3739|7834->3790|7873->3791|7912->3802|7981->3844|7997->3851|8032->3865|8115->3920|8132->3927|8175->3948|8211->3966|8224->3971|8263->3972|8302->3983|8371->4025|8387->4032|8424->4048|8453->4050|8469->4057|8504->4071|8587->4126|8604->4133|8649->4156|8679->4158|8696->4165|8739->4186|8787->4203|8824->4213|8839->4219|8901->4260|8935->4267|8977->4279|9009->4285|9084->4351|9123->4352|9157->4359|9292->4467|9350->4504|9387->4514|9442->4560|9481->4561|9520->4573|9602->4634|9631->4635|9683->4660|9699->4666|9762->4707|9791->4718|9804->4723|9843->4724|9882->4736|9964->4797|9993->4798|10038->4816|10053->4822|10116->4863|10157->4873|10191->4880|10233->4892|10265->4898|10342->4966|10381->4967|10415->4974|10550->5082|10608->5119|10645->5129|10727->5190|10756->5191|10803->5211|10818->5217|10881->5258|10915->5265|10957->5277|10989->5283|11035->5320|11074->5321|11108->5328|11229->5421|11288->5458|11326->5468|11409->5529|11439->5530|11522->5584|11540->5591|11584->5612|11629->5628|11646->5634|11710->5675|11745->5682|11788->5694|11811->5701|11857->5737|11898->5739|11931->5745|11947->5751|12056->5838|12092->5844|12121->5845|12171->5866|12201->5867|12230->5869|12259->5888|12299->5889|12330->5892|12413->5946|12443->5947|12476->5952|12571->6019|12608->6034|12726->6123|12756->6124|12791->6131|12878->6190|12915->6205|13006->6268|13035->6269|13069->6275|13112->6290|13141->6291|13176->6298|13226->6320|13255->6321|13304->6341|13334->6342|13369->6349|13430->6382|13459->6383|13510->6406|13539->6407|13634->6473|13664->6474|13697->6479|13779->6532|13809->6533|13844->6540|13937->6605|13974->6620|14054->6671|14084->6672|14121->6681|14163->6694|14193->6695|14233->6706|14370->6815|14400->6816|14435->6823|14464->6824|14499->6831|14528->6832|14561->6837|14605->6853|14634->6854|14669->6858|14700->6861|14800->6932|14830->6933|14863->6938|14958->7005|14995->7020|15153->7150|15182->7151|15217->7158|15267->7180|15296->7181|15345->7201|15375->7202|15410->7209|15471->7242|15500->7243|15551->7266|15580->7267|15692->7350|15722->7351|15755->7356|15837->7409|15867->7410|15902->7417|15995->7482|16032->7497|16113->7549|16143->7550|16180->7559|16222->7572|16252->7573|16292->7584|16460->7724|16490->7725|16525->7732|16554->7733|16589->7740|16618->7741|16651->7746|16695->7762|16724->7763|16795->7805|16825->7806|16858->7811|17046->7971|17075->7972|17170->8038|17200->8039|17233->8044|17410->8192|17440->8193|17475->8200|17614->8311|17643->8312|17676->8317|17740->8353|17769->8354|17880->8436|17910->8437|17943->8442|18247->8718|18284->8733|18356->8777|18385->8778|18422->8787|18474->8811|18503->8812|18565->8845|18595->8846|18632->8855|18668->8862|18698->8863|18738->8874|18773->8881|18810->8896|18916->8973|18946->8974|18988->8987|19107->9077|19137->9078|19202->9114|19232->9115|19274->9128|19374->9199|19404->9200|19441->9209|19471->9210|19508->9219|19537->9220|19570->9225|19603->9230|19632->9231|19666->9238|19695->9257|19735->9258|19766->9261|19851->9317|19881->9318|19914->9323|20001->9382|20038->9397|20081->9412|20096->9417|20130->9429|20167->9438|20196->9439|20233->9448|20285->9472|20314->9473|20376->9506|20406->9507|20443->9516|20479->9523|20509->9524|20549->9535|20584->9542|20621->9557|20663->9571|20678->9576|20712->9588|20784->9631|20814->9632|20856->9645|20997->9757|21027->9758|21064->9767|21094->9768|21131->9777|21160->9778|21193->9783|21226->9788|21255->9789|21357->9862|21387->9863|21420->9868|21667->10087|21704->10102|21775->10145|21804->10146|21841->10155|21893->10179|21922->10180|21984->10213|22014->10214|22051->10223|22087->10230|22117->10231|22157->10242|22192->10249|22229->10264|22334->10340|22364->10341|22406->10354|22525->10444|22555->10445|22592->10454|22622->10455|22659->10464|22688->10465|22721->10470|22754->10475|22783->10476|22821->10483|22851->10485|22880->10486
                  LINES: 13->1|21->5|22->8|22->8|22->8|23->9|23->9|23->9|26->12|26->12|26->12|26->12|26->12|26->12|28->14|28->14|28->14|29->15|29->15|29->15|29->15|30->16|31->17|34->20|34->20|35->21|37->23|39->25|39->25|39->25|39->26|39->26|39->26|40->27|40->27|40->27|41->28|41->28|41->28|42->29|42->29|42->29|44->31|44->31|45->32|46->33|46->33|46->33|47->34|48->35|48->35|48->35|49->36|49->36|49->36|49->36|49->36|49->36|49->36|49->36|49->36|50->37|51->38|51->38|51->38|52->39|54->41|55->42|55->42|56->43|56->43|56->43|56->43|57->44|57->44|57->44|58->45|59->46|61->48|61->48|61->48|62->49|62->49|62->49|63->50|63->50|63->50|64->51|64->51|64->51|64->51|64->51|64->51|64->51|64->51|64->51|64->51|64->51|64->51|64->51|64->51|65->52|65->52|66->53|67->54|67->54|67->54|68->55|68->55|68->55|69->56|69->56|69->56|70->57|70->57|70->57|70->57|70->57|70->57|70->57|70->57|70->57|70->57|70->57|70->57|70->57|70->57|70->57|70->57|71->58|72->59|72->59|72->59|73->60|73->60|74->61|75->62|76->63|78->65|79->66|79->66|79->66|80->67|82->69|82->69|83->70|83->70|83->70|83->70|83->70|83->70|84->71|84->71|84->71|85->72|85->72|85->72|85->72|85->72|85->72|85->72|86->73|86->73|86->73|87->74|87->74|87->74|87->74|87->74|87->74|87->74|87->74|87->74|87->74|87->74|87->74|87->74|88->75|89->76|89->76|89->76|90->77|91->78|92->79|92->79|92->79|93->80|95->82|95->82|96->83|96->83|96->83|97->84|97->84|97->84|97->84|97->84|97->84|98->85|98->85|98->85|99->86|99->86|99->86|99->86|99->86|99->86|100->87|101->88|102->89|103->90|103->90|103->90|104->91|106->93|106->93|107->94|107->94|107->94|107->94|107->94|107->94|108->95|109->96|110->97|110->97|110->97|111->98|113->100|113->100|114->101|114->101|114->101|114->101|114->101|114->101|114->101|114->101|114->101|115->102|116->103|117->105|117->105|117->105|118->106|118->106|118->106|119->108|120->109|121->110|121->110|122->111|122->111|122->111|123->112|123->112|123->112|124->113|125->114|125->114|128->117|128->117|129->118|130->119|130->119|132->121|132->121|134->123|135->124|135->124|136->125|137->126|137->126|138->127|138->127|139->128|140->129|140->129|142->131|142->131|143->132|143->132|144->133|144->133|144->133|145->134|146->135|146->135|147->136|147->136|148->137|148->137|148->137|149->138|151->140|151->140|152->141|152->141|153->142|153->142|154->143|155->144|155->144|156->145|157->146|157->146|157->146|158->147|159->148|159->148|163->152|163->152|164->153|165->154|165->154|166->155|166->155|167->156|168->157|168->157|170->159|170->159|171->160|171->160|172->161|172->161|172->161|173->162|174->163|174->163|175->164|175->164|176->165|176->165|176->165|177->166|179->168|179->168|180->169|180->169|181->170|181->170|182->171|183->172|183->172|185->174|185->174|186->175|191->180|191->180|193->182|193->182|194->183|197->186|197->186|198->187|201->190|201->190|202->191|204->193|204->193|206->195|206->195|207->196|210->199|210->199|211->200|211->200|212->201|213->202|213->202|214->203|214->203|215->204|215->204|215->204|216->205|216->205|216->205|218->207|218->207|219->208|221->210|221->210|222->211|222->211|223->212|224->213|224->213|225->214|225->214|226->215|226->215|227->216|228->217|228->217|230->219|230->219|230->219|231->220|231->220|231->220|232->221|233->222|233->222|233->222|233->222|233->222|234->223|234->223|235->224|236->225|236->225|237->226|237->226|238->227|238->227|238->227|239->228|239->228|239->228|239->228|239->228|239->228|241->230|241->230|242->231|244->233|244->233|245->234|245->234|246->235|246->235|247->236|248->237|248->237|250->239|250->239|251->240|254->243|254->243|255->244|255->244|256->245|257->246|257->246|258->247|258->247|259->248|259->248|259->248|260->249|260->249|260->249|262->251|262->251|263->252|265->254|265->254|266->255|266->255|267->256|267->256|268->257|269->258|269->258|271->260|273->262|273->262
                  -- GENERATED --
              */
          