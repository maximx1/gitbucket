
package helper.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object diff extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template9[Seq[util.JGitUtil.DiffInfo],service.RepositoryService.RepositoryInfo,Option[String],Option[String],Boolean,Option[Int],Boolean,Boolean,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(diffs: Seq[util.JGitUtil.DiffInfo],
  repository: service.RepositoryService.RepositoryInfo,
  newCommitId: Option[String],
  oldCommitId: Option[String],
  showIndex: Boolean,
  issueId: Option[Int],
  hasWritePermission: Boolean,
  showLineNotes: Boolean)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._
import org.eclipse.jgit.diff.DiffEntry.ChangeType

Seq[Any](format.raw/*8.57*/("""
"""),_display_(/*12.2*/if(showIndex)/*12.15*/{_display_(Seq[Any](format.raw/*12.16*/("""
  """),format.raw/*13.3*/("""<div>
    <div class="pull-right" style="margin-bottom: 10px;">
      <div class="btn-group" data-toggle="buttons-radio">
        <input type="button" id="btn-unified" class="btn btn-default btn-small active" value="Unified">
        <input type="button" id="btn-split" class="btn btn-default btn-small" value="Split">
      </div>
    </div>
    Showing <a href="javascript:void(0);" id="toggle-file-list">"""),_display_(/*20.66*/diffs/*20.71*/.size),format.raw/*20.76*/(""" """),format.raw/*20.77*/("""changed """),_display_(/*20.86*/plural(diffs.size, "file")),format.raw/*20.112*/("""</a>
  </div>
  <ul id="commit-file-list" style="display: none;">
  """),_display_(/*23.4*/diffs/*23.9*/.zipWithIndex.map/*23.26*/ { case (diff, i) =>_display_(Seq[Any](format.raw/*23.46*/("""
    """),format.raw/*24.5*/("""<li"""),_display_(/*24.9*/if(i > 0)/*24.18*/{_display_(Seq[Any](format.raw/*24.19*/(""" """),format.raw/*24.20*/("""class="border"""")))}),format.raw/*24.35*/(""">
      <a href="#diff-"""),_display_(/*25.23*/i),format.raw/*25.24*/("""">
        """),_display_(/*26.10*/if(diff.changeType == ChangeType.COPY || diff.changeType == ChangeType.RENAME)/*26.88*/{_display_(Seq[Any](format.raw/*26.89*/("""
          """),format.raw/*27.11*/("""<img src=""""),_display_(/*27.22*/assets),format.raw/*27.28*/("""/common/images/diff_move.png"/> """),_display_(/*27.61*/diff/*27.65*/.oldPath),format.raw/*27.73*/(""" """),format.raw/*27.74*/("""-> """),_display_(/*27.78*/diff/*27.82*/.newPath),format.raw/*27.90*/("""
        """)))}),format.raw/*28.10*/("""
        """),_display_(/*29.10*/if(diff.changeType == ChangeType.ADD)/*29.47*/{_display_(Seq[Any](format.raw/*29.48*/("""
          """),format.raw/*30.11*/("""<img src=""""),_display_(/*30.22*/assets),format.raw/*30.28*/("""/common/images/diff_add.png"/> """),_display_(/*30.60*/diff/*30.64*/.newPath),format.raw/*30.72*/("""
        """)))}),format.raw/*31.10*/("""
        """),_display_(/*32.10*/if(diff.changeType == ChangeType.MODIFY)/*32.50*/{_display_(Seq[Any](format.raw/*32.51*/("""
          """),format.raw/*33.11*/("""<img src=""""),_display_(/*33.22*/assets),format.raw/*33.28*/("""/common/images/diff_edit.png"/> """),_display_(/*33.61*/diff/*33.65*/.newPath),format.raw/*33.73*/("""
        """)))}),format.raw/*34.10*/("""
        """),_display_(/*35.10*/if(diff.changeType == ChangeType.DELETE)/*35.50*/{_display_(Seq[Any](format.raw/*35.51*/("""
          """),format.raw/*36.11*/("""<img src=""""),_display_(/*36.22*/assets),format.raw/*36.28*/("""/common/images/diff_delete.png"/> """),_display_(/*36.63*/diff/*36.67*/.oldPath),format.raw/*36.75*/("""
        """)))}),format.raw/*37.10*/("""
      """),format.raw/*38.7*/("""</a>
    </li>
    """)))}),format.raw/*40.6*/("""
  """),format.raw/*41.3*/("""</ul>
""")))}),format.raw/*42.2*/("""
"""),_display_(/*43.2*/diffs/*43.7*/.zipWithIndex.map/*43.24*/ { case (diff, i) =>_display_(Seq[Any](format.raw/*43.44*/("""
  """),format.raw/*44.3*/("""<a name="diff-"""),_display_(/*44.18*/i),format.raw/*44.19*/(""""></a>
  <table class="table table-bordered" commitId=""""),_display_(/*45.50*/newCommitId),format.raw/*45.61*/("""" fileName=""""),_display_(/*45.74*/diff/*45.78*/.newPath),format.raw/*45.86*/("""">
    <tr>
      <th style="font-weight: normal; line-height: 27px;" class="box-header">
        """),_display_(/*48.10*/if(diff.changeType == ChangeType.COPY || diff.changeType == ChangeType.RENAME)/*48.88*/{_display_(Seq[Any](format.raw/*48.89*/("""
          """),format.raw/*49.11*/("""<img src=""""),_display_(/*49.22*/assets),format.raw/*49.28*/("""/common/images/diff_move.png"/> """),_display_(/*49.61*/diff/*49.65*/.oldPath),format.raw/*49.73*/(""" """),format.raw/*49.74*/("""-> """),_display_(/*49.78*/diff/*49.82*/.newPath),format.raw/*49.90*/("""
          """),_display_(/*50.12*/if(newCommitId.isDefined)/*50.37*/{_display_(Seq[Any](format.raw/*50.38*/("""
            """),format.raw/*51.13*/("""<div class="pull-right align-right">
              <label class="checkbox" style="display: inline-block;"><input type="checkbox" class="toggle-notes" checked><span>Show notes</span></label>
              <a href=""""),_display_(/*53.25*/url(repository)),format.raw/*53.40*/("""/blob/"""),_display_(/*53.47*/newCommitId/*53.58*/.get),format.raw/*53.62*/("""/"""),_display_(/*53.64*/diff/*53.68*/.newPath),format.raw/*53.76*/("""" class="btn btn-small">View file @ """),_display_(/*53.114*/newCommitId/*53.125*/.get.substring(0, 10)),format.raw/*53.146*/("""</a>
            </div>
          """)))}),format.raw/*55.12*/("""
        """)))}),format.raw/*56.10*/("""
        """),_display_(/*57.10*/if(diff.changeType == ChangeType.ADD || diff.changeType == ChangeType.MODIFY)/*57.87*/{_display_(Seq[Any](format.raw/*57.88*/("""
          """),_display_(/*58.12*/if(diff.changeType == ChangeType.ADD)/*58.49*/{_display_(Seq[Any](format.raw/*58.50*/("""
            """),format.raw/*59.13*/("""<img src=""""),_display_(/*59.24*/assets),format.raw/*59.30*/("""/common/images/diff_add.png"/>
          """)))}/*60.12*/else/*60.16*/{_display_(Seq[Any](format.raw/*60.17*/("""
            """),format.raw/*61.13*/("""<img src=""""),_display_(/*61.24*/assets),format.raw/*61.30*/("""/common/images/diff_edit.png"/>
          """)))}),format.raw/*62.12*/(""" """),_display_(/*62.14*/diff/*62.18*/.newPath),format.raw/*62.26*/("""
          """),_display_(/*63.12*/if(newCommitId.isDefined)/*63.37*/{_display_(Seq[Any](format.raw/*63.38*/("""
            """),format.raw/*64.13*/("""<div class="pull-right align-right">
              <label class="checkbox" style="display: inline-block;"><input type="checkbox" class="toggle-notes" checked><span>Show notes</span></label>
              <a href=""""),_display_(/*66.25*/url(repository)),format.raw/*66.40*/("""/blob/"""),_display_(/*66.47*/newCommitId/*66.58*/.get),format.raw/*66.62*/("""/"""),_display_(/*66.64*/diff/*66.68*/.newPath),format.raw/*66.76*/("""" class="btn btn-small">View file @ """),_display_(/*66.114*/newCommitId/*66.125*/.get.substring(0, 10)),format.raw/*66.146*/("""</a>
            </div>
          """)))}),format.raw/*68.12*/("""
        """)))}),format.raw/*69.10*/("""
        """),_display_(/*70.10*/if(diff.changeType == ChangeType.DELETE)/*70.50*/{_display_(Seq[Any](format.raw/*70.51*/("""
          """),format.raw/*71.11*/("""<img src=""""),_display_(/*71.22*/assets),format.raw/*71.28*/("""/common/images/diff_delete.png"/> """),_display_(/*71.63*/diff/*71.67*/.oldPath),format.raw/*71.75*/("""
          """),_display_(/*72.12*/if(oldCommitId.isDefined)/*72.37*/{_display_(Seq[Any](format.raw/*72.38*/("""
            """),format.raw/*73.13*/("""<div class="pull-right align-right">
              <label class="checkbox" style="display: inline-block;"><input type="checkbox" class="toggle-notes" checked><span>Show notes</span></label>
              <a href=""""),_display_(/*75.25*/url(repository)),format.raw/*75.40*/("""/blob/"""),_display_(/*75.47*/oldCommitId/*75.58*/.get),format.raw/*75.62*/("""/"""),_display_(/*75.64*/diff/*75.68*/.oldPath),format.raw/*75.76*/("""" class="btn btn-small">View file @ """),_display_(/*75.114*/oldCommitId/*75.125*/.get.substring(0, 10)),format.raw/*75.146*/("""</a>
            </div>
          """)))}),format.raw/*77.12*/("""
        """)))}),format.raw/*78.10*/("""
      """),format.raw/*79.7*/("""</th>
    </tr>
    <tr>
      <td style="padding: 0;">
        """),_display_(/*83.10*/if(diff.newContent != None || diff.oldContent != None)/*83.64*/{_display_(Seq[Any](format.raw/*83.65*/("""
          """),format.raw/*84.11*/("""<div id="diffText-"""),_display_(/*84.30*/i),format.raw/*84.31*/(""""></div>
          <textarea id="newText-"""),_display_(/*85.34*/i),format.raw/*85.35*/("""" style="display: none;">"""),_display_(/*85.61*/diff/*85.65*/.newContent.getOrElse("")),format.raw/*85.90*/("""</textarea>
          <textarea id="oldText-"""),_display_(/*86.34*/i),format.raw/*86.35*/("""" style="display: none;">"""),_display_(/*86.61*/diff/*86.65*/.oldContent.getOrElse("")),format.raw/*86.90*/("""</textarea>
        """)))}/*87.11*/else/*87.16*/{_display_(Seq[Any](format.raw/*87.17*/("""
          """),format.raw/*88.11*/("""Not supported
        """)))}),format.raw/*89.10*/("""
      """),format.raw/*90.7*/("""</td>
    </tr>
  </table>
""")))}),format.raw/*93.2*/("""
"""),format.raw/*94.1*/("""<script type="text/javascript" src=""""),_display_(/*94.38*/assets),format.raw/*94.44*/("""/vendors/jsdifflib/difflib.js"></script>
<script type="text/javascript" src=""""),_display_(/*95.38*/assets),format.raw/*95.44*/("""/vendors/jsdifflib/diffview.js"></script>
<link href=""""),_display_(/*96.14*/assets),format.raw/*96.20*/("""/vendors/jsdifflib/diffview.css" type="text/css" rel="stylesheet" />
<script>
$(function()"""),format.raw/*98.13*/("""{"""),format.raw/*98.14*/("""
  """),_display_(/*99.4*/if(showIndex)/*99.17*/{_display_(Seq[Any](format.raw/*99.18*/("""
    """),format.raw/*100.5*/("""$('#toggle-file-list').click(function()"""),format.raw/*100.44*/("""{"""),format.raw/*100.45*/("""
      """),format.raw/*101.7*/("""$('#commit-file-list').toggle();
      if($(this).val() == 'Show file list')"""),format.raw/*102.44*/("""{"""),format.raw/*102.45*/("""
        """),format.raw/*103.9*/("""$(this).val('Hide file list');
      """),format.raw/*104.7*/("""}"""),format.raw/*104.8*/(""" """),format.raw/*104.9*/("""else """),format.raw/*104.14*/("""{"""),format.raw/*104.15*/("""
        """),format.raw/*105.9*/("""$(this).val('Show file list');
      """),format.raw/*106.7*/("""}"""),format.raw/*106.8*/("""
    """),format.raw/*107.5*/("""}"""),format.raw/*107.6*/(""");
  """)))}),format.raw/*108.4*/("""

  """),format.raw/*110.3*/("""// Render diffs as unified mode initially
  renderDiffs(1);

  $('#btn-unified').click(function()"""),format.raw/*113.37*/("""{"""),format.raw/*113.38*/("""
    """),format.raw/*114.5*/("""$('.container-wide').removeClass('container-wide').addClass('container');
    renderDiffs(1);
  """),format.raw/*116.3*/("""}"""),format.raw/*116.4*/(""");

  $('#btn-split').click(function()"""),format.raw/*118.35*/("""{"""),format.raw/*118.36*/("""
    """),format.raw/*119.5*/("""$('.container').removeClass('container').addClass('container-wide');
    renderDiffs(0);
  """),format.raw/*121.3*/("""}"""),format.raw/*121.4*/(""");

  function renderDiffs(viewType)"""),format.raw/*123.33*/("""{"""),format.raw/*123.34*/("""
    """),format.raw/*124.5*/("""window.viewType = viewType;
    """),_display_(/*125.6*/diffs/*125.11*/.zipWithIndex.map/*125.28*/ { case (diff, i) =>_display_(Seq[Any](format.raw/*125.48*/("""
      """),_display_(/*126.8*/if(diff.newContent != None || diff.oldContent != None)/*126.62*/{_display_(Seq[Any](format.raw/*126.63*/("""
        """),format.raw/*127.9*/("""if($('#oldText-"""),_display_(/*127.25*/i),format.raw/*127.26*/("""').length > 0)"""),format.raw/*127.40*/("""{"""),format.raw/*127.41*/("""
          """),format.raw/*128.11*/("""diffUsingJS('oldText-"""),_display_(/*128.33*/i),format.raw/*128.34*/("""', 'newText-"""),_display_(/*128.47*/i),format.raw/*128.48*/("""', 'diffText-"""),_display_(/*128.62*/i),format.raw/*128.63*/("""', viewType);
        """),format.raw/*129.9*/("""}"""),format.raw/*129.10*/("""
      """)))}),format.raw/*130.8*/("""
    """)))}),format.raw/*131.6*/("""
    """),_display_(/*132.6*/if(showLineNotes)/*132.23*/{_display_(Seq[Any](format.raw/*132.24*/("""
      """),format.raw/*133.7*/("""function getInlineContainer(where) """),format.raw/*133.42*/("""{"""),format.raw/*133.43*/("""
        """),format.raw/*134.9*/("""if (viewType == 0) """),format.raw/*134.28*/("""{"""),format.raw/*134.29*/("""
          """),format.raw/*135.11*/("""if (where === 'new') """),format.raw/*135.32*/("""{"""),format.raw/*135.33*/("""
            """),format.raw/*136.13*/("""return $('<tr class="not-diff"><td colspan="2"></td><td colspan="2" class="comment-box-container"></td></tr>');
          """),format.raw/*137.11*/("""}"""),format.raw/*137.12*/(""" """),format.raw/*137.13*/("""else if (where === 'old') """),format.raw/*137.39*/("""{"""),format.raw/*137.40*/("""
            """),format.raw/*138.13*/("""return $('<tr class="not-diff"><td colspan="2" class="comment-box-container"></td><td colspan="2"></td></tr>');
          """),format.raw/*139.11*/("""}"""),format.raw/*139.12*/("""
        """),format.raw/*140.9*/("""}"""),format.raw/*140.10*/("""
        """),format.raw/*141.9*/("""return $('<tr class="not-diff"><td colspan="3" class="comment-box-container"></td></tr>');
      """),format.raw/*142.7*/("""}"""),format.raw/*142.8*/("""
      """),format.raw/*143.7*/("""$('.inline-comment').each(function(i, v) """),format.raw/*143.48*/("""{"""),format.raw/*143.49*/("""
        """),format.raw/*144.9*/("""var $v = $(v), filename = $v.attr('filename'),
        oldline = $v.attr('oldline'), newline = $v.attr('newline');
        if (typeof $('#show-notes')[0] !== 'undefined' && !$('#show-notes')[0].checked) """),format.raw/*146.89*/("""{"""),format.raw/*146.90*/("""
          """),format.raw/*147.11*/("""$(this).hide();
        """),format.raw/*148.9*/("""}"""),format.raw/*148.10*/("""
        """),format.raw/*149.9*/("""if (typeof oldline !== 'undefined') """),format.raw/*149.45*/("""{"""),format.raw/*149.46*/("""
          """),format.raw/*150.11*/("""var tmp;
          if (typeof newline !== 'undefined') """),format.raw/*151.47*/("""{"""),format.raw/*151.48*/("""
            """),format.raw/*152.13*/("""tmp = getInlineContainer();
          """),format.raw/*153.11*/("""}"""),format.raw/*153.12*/(""" """),format.raw/*153.13*/("""else """),format.raw/*153.18*/("""{"""),format.raw/*153.19*/("""
            """),format.raw/*154.13*/("""tmp = getInlineContainer('old');
          """),format.raw/*155.11*/("""}"""),format.raw/*155.12*/("""
          """),format.raw/*156.11*/("""tmp.children('td:first').html($(this).clone().show());
          $('table[filename="' + filename + '"]').find('table.diff').find('.oldline[line-number=' + oldline  + ']')
          .parent().nextAll(':not(.not-diff):first').before(tmp);
        """),format.raw/*159.9*/("""}"""),format.raw/*159.10*/(""" """),format.raw/*159.11*/("""else """),format.raw/*159.16*/("""{"""),format.raw/*159.17*/("""
          """),format.raw/*160.11*/("""var tmp = getInlineContainer('new');
          tmp.children('td:last').html($(this).clone().show());
          $('table[filename="' + filename + '"]').find('table.diff').find('.newline[line-number=' + newline  + ']')
          .parent().nextAll(':not(.not-diff):first').before(tmp);
        """),format.raw/*164.9*/("""}"""),format.raw/*164.10*/("""
      """),format.raw/*165.7*/("""}"""),format.raw/*165.8*/(""");
      $('.toggle-notes').change(function() """),format.raw/*166.44*/("""{"""),format.raw/*166.45*/("""
        """),format.raw/*167.9*/("""if (!$(this).prop('checked')) """),format.raw/*167.39*/("""{"""),format.raw/*167.40*/("""
          """),format.raw/*168.11*/("""$(this).closest('table').find('.not-diff.inline-comment-form').remove();
        """),format.raw/*169.9*/("""}"""),format.raw/*169.10*/("""
        """),format.raw/*170.9*/("""$(this).closest('table').find('.not-diff').toggle();
      """),format.raw/*171.7*/("""}"""),format.raw/*171.8*/(""");
      """),_display_(/*172.8*/if(hasWritePermission)/*172.30*/ {_display_(Seq[Any](format.raw/*172.32*/("""
        """),format.raw/*173.9*/("""$('table.diff td').hover(
          function() """),format.raw/*174.22*/("""{"""),format.raw/*174.23*/("""
            """),format.raw/*175.13*/("""$(this).find('b').css('display', 'inline-block');
          """),format.raw/*176.11*/("""}"""),format.raw/*176.12*/(""",
          function() """),format.raw/*177.22*/("""{"""),format.raw/*177.23*/("""
            """),format.raw/*178.13*/("""$(this).find('b').css('display', 'none');
          """),format.raw/*179.11*/("""}"""),format.raw/*179.12*/("""
        """),format.raw/*180.9*/(""");
        $('table.diff th').hover(
          function() """),format.raw/*182.22*/("""{"""),format.raw/*182.23*/("""
            """),format.raw/*183.13*/("""$(this).nextAll().find('b').first().css('display', 'inline-block');
          """),format.raw/*184.11*/("""}"""),format.raw/*184.12*/(""",
          function() """),format.raw/*185.22*/("""{"""),format.raw/*185.23*/("""
            """),format.raw/*186.13*/("""$(this).nextAll().find('b').first().css('display', 'none');
          """),format.raw/*187.11*/("""}"""),format.raw/*187.12*/("""
        """),format.raw/*188.9*/(""");
        $('.add-comment').click(function() """),format.raw/*189.44*/("""{"""),format.raw/*189.45*/("""
          """),format.raw/*190.11*/("""var $this = $(this),
          $tr = $this.closest('tr'),
          $check = $this.closest('table:not(.diff)').find('.toggle-notes');
          if (!$check.prop('checked')) """),format.raw/*193.40*/("""{"""),format.raw/*193.41*/("""
            """),format.raw/*194.13*/("""$check.prop('checked', true).trigger('change');
          """),format.raw/*195.11*/("""}"""),format.raw/*195.12*/("""
          """),format.raw/*196.11*/("""if (!$tr.nextAll(':not(.not-diff):first').prev().hasClass('inline-comment-form')) """),format.raw/*196.93*/("""{"""),format.raw/*196.94*/("""
            """),format.raw/*197.13*/("""var commitId = $this.closest('.table-bordered').attr('commitId'),
            fileName = $this.closest('.table-bordered').attr('fileName'),
            oldLineNumber, newLineNumber,
            url = '"""),_display_(/*200.21*/url(repository)),format.raw/*200.36*/("""/commit/' + commitId + '/comment/_form?fileName=' + fileName"""),_display_(/*200.97*/issueId/*200.104*/.map/*200.108*/ { id =>_display_(Seq[Any](format.raw/*200.116*/(""" """),format.raw/*200.117*/("""+ '&issueId="""),_display_(/*200.130*/id),format.raw/*200.132*/("""' """)))}),format.raw/*200.135*/(""";
            if (viewType == 0) """),format.raw/*201.32*/("""{"""),format.raw/*201.33*/("""
              """),format.raw/*202.15*/("""oldLineNumber = $this.parent().prev('.oldline').attr('line-number');
              newLineNumber = $this.parent().prev('.newline').attr('line-number');
            """),format.raw/*204.13*/("""}"""),format.raw/*204.14*/(""" """),format.raw/*204.15*/("""else """),format.raw/*204.20*/("""{"""),format.raw/*204.21*/("""
              """),format.raw/*205.15*/("""oldLineNumber = $this.parent().prevAll('.oldline').attr('line-number');
              newLineNumber = $this.parent().prevAll('.newline').attr('line-number');
            """),format.raw/*207.13*/("""}"""),format.raw/*207.14*/("""
            """),format.raw/*208.13*/("""if (!isNaN(oldLineNumber) && oldLineNumber) """),format.raw/*208.57*/("""{"""),format.raw/*208.58*/("""
              """),format.raw/*209.15*/("""url += ('&oldLineNumber=' + oldLineNumber)
            """),format.raw/*210.13*/("""}"""),format.raw/*210.14*/("""
            """),format.raw/*211.13*/("""if (!isNaN(newLineNumber) && newLineNumber) """),format.raw/*211.57*/("""{"""),format.raw/*211.58*/("""
              """),format.raw/*212.15*/("""url += ('&newLineNumber=' + newLineNumber)
            """),format.raw/*213.13*/("""}"""),format.raw/*213.14*/("""
            """),format.raw/*214.13*/("""$.get(
              url,
              """),format.raw/*216.15*/("""{"""),format.raw/*216.16*/("""
                """),format.raw/*217.17*/("""dataType : 'html'
              """),format.raw/*218.15*/("""}"""),format.raw/*218.16*/(""",
              function(responseContent) """),format.raw/*219.41*/("""{"""),format.raw/*219.42*/("""
                """),format.raw/*220.17*/("""$this.hide();
                var tmp;
                if (!isNaN(oldLineNumber) && oldLineNumber) """),format.raw/*222.61*/("""{"""),format.raw/*222.62*/("""
                  """),format.raw/*223.19*/("""if (!isNaN(newLineNumber) && newLineNumber) """),format.raw/*223.63*/("""{"""),format.raw/*223.64*/("""
                    """),format.raw/*224.21*/("""tmp = getInlineContainer();
                  """),format.raw/*225.19*/("""}"""),format.raw/*225.20*/(""" """),format.raw/*225.21*/("""else """),format.raw/*225.26*/("""{"""),format.raw/*225.27*/("""
                    """),format.raw/*226.21*/("""tmp = getInlineContainer('old');
                  """),format.raw/*227.19*/("""}"""),format.raw/*227.20*/("""
                """),format.raw/*228.17*/("""}"""),format.raw/*228.18*/(""" """),format.raw/*228.19*/("""else """),format.raw/*228.24*/("""{"""),format.raw/*228.25*/("""
                  """),format.raw/*229.19*/("""tmp = getInlineContainer('new');
                """),format.raw/*230.17*/("""}"""),format.raw/*230.18*/("""
                """),format.raw/*231.17*/("""tmp.addClass('inline-comment-form').children('.comment-box-container').html(responseContent);
                $tr.nextAll(':not(.not-diff):first').before(tmp);
              """),format.raw/*233.15*/("""}"""),format.raw/*233.16*/("""
            """),format.raw/*234.13*/(""");
          """),format.raw/*235.11*/("""}"""),format.raw/*235.12*/("""
        """),format.raw/*236.9*/("""}"""),format.raw/*236.10*/(""");
        $('table.diff').on('click', '.btn-default', function() """),format.raw/*237.64*/("""{"""),format.raw/*237.65*/("""
          """),format.raw/*238.11*/("""$(this).closest('.inline-comment-form').remove();
        """),format.raw/*239.9*/("""}"""),format.raw/*239.10*/(""");
      """)))}),format.raw/*240.8*/("""
    """)))}),format.raw/*241.6*/("""
  """),format.raw/*242.3*/("""}"""),format.raw/*242.4*/("""
"""),format.raw/*243.1*/("""}"""),format.raw/*243.2*/(""");
</script>
"""))}
  }

  def render(diffs:Seq[util.JGitUtil.DiffInfo],repository:service.RepositoryService.RepositoryInfo,newCommitId:Option[String],oldCommitId:Option[String],showIndex:Boolean,issueId:Option[Int],hasWritePermission:Boolean,showLineNotes:Boolean,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(diffs,repository,newCommitId,oldCommitId,showIndex,issueId,hasWritePermission,showLineNotes)(context)

  def f:((Seq[util.JGitUtil.DiffInfo],service.RepositoryService.RepositoryInfo,Option[String],Option[String],Boolean,Option[Int],Boolean,Boolean) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (diffs,repository,newCommitId,oldCommitId,showIndex,issueId,hasWritePermission,showLineNotes) => (context) => apply(diffs,repository,newCommitId,oldCommitId,showIndex,issueId,hasWritePermission,showLineNotes)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/diff.scala.html
                  HASH: 9240884f5fdc0d401c64ce1fd4548d6c634638ec
                  MATRIX: 483->1|947->289|975->383|997->396|1036->397|1066->400|1501->808|1515->813|1541->818|1570->819|1606->828|1654->854|1749->923|1762->928|1788->945|1846->965|1878->970|1908->974|1926->983|1965->984|1994->985|2040->1000|2091->1024|2113->1025|2152->1037|2239->1115|2278->1116|2317->1127|2355->1138|2382->1144|2442->1177|2455->1181|2484->1189|2513->1190|2544->1194|2557->1198|2586->1206|2627->1216|2664->1226|2710->1263|2749->1264|2788->1275|2826->1286|2853->1292|2912->1324|2925->1328|2954->1336|2995->1346|3032->1356|3081->1396|3120->1397|3159->1408|3197->1419|3224->1425|3284->1458|3297->1462|3326->1470|3367->1480|3404->1490|3453->1530|3492->1531|3531->1542|3569->1553|3596->1559|3658->1594|3671->1598|3700->1606|3741->1616|3775->1623|3825->1643|3855->1646|3892->1653|3920->1655|3933->1660|3959->1677|4017->1697|4047->1700|4089->1715|4111->1716|4194->1772|4226->1783|4266->1796|4279->1800|4308->1808|4434->1907|4521->1985|4560->1986|4599->1997|4637->2008|4664->2014|4724->2047|4737->2051|4766->2059|4795->2060|4826->2064|4839->2068|4868->2076|4907->2088|4941->2113|4980->2114|5021->2127|5262->2341|5298->2356|5332->2363|5352->2374|5377->2378|5406->2380|5419->2384|5448->2392|5513->2430|5534->2441|5577->2462|5643->2497|5684->2507|5721->2517|5807->2594|5846->2595|5885->2607|5931->2644|5970->2645|6011->2658|6049->2669|6076->2675|6137->2717|6150->2721|6189->2722|6230->2735|6268->2746|6295->2752|6369->2795|6398->2797|6411->2801|6440->2809|6479->2821|6513->2846|6552->2847|6593->2860|6834->3074|6870->3089|6904->3096|6924->3107|6949->3111|6978->3113|6991->3117|7020->3125|7085->3163|7106->3174|7149->3195|7215->3230|7256->3240|7293->3250|7342->3290|7381->3291|7420->3302|7458->3313|7485->3319|7547->3354|7560->3358|7589->3366|7628->3378|7662->3403|7701->3404|7742->3417|7983->3631|8019->3646|8053->3653|8073->3664|8098->3668|8127->3670|8140->3674|8169->3682|8234->3720|8255->3731|8298->3752|8364->3787|8405->3797|8439->3804|8531->3869|8594->3923|8633->3924|8672->3935|8718->3954|8740->3955|8809->3997|8831->3998|8884->4024|8897->4028|8943->4053|9015->4098|9037->4099|9090->4125|9103->4129|9149->4154|9189->4176|9202->4181|9241->4182|9280->4193|9334->4216|9368->4223|9426->4251|9454->4252|9518->4289|9545->4295|9650->4373|9677->4379|9759->4434|9786->4440|9904->4530|9933->4531|9963->4535|9985->4548|10024->4549|10057->4554|10125->4593|10155->4594|10190->4601|10295->4677|10325->4678|10362->4687|10427->4724|10456->4725|10485->4726|10519->4731|10549->4732|10586->4741|10651->4778|10680->4779|10713->4784|10742->4785|10779->4791|10811->4795|10937->4892|10967->4893|11000->4898|11124->4994|11153->4995|11220->5033|11250->5034|11283->5039|11402->5130|11431->5131|11496->5167|11526->5168|11559->5173|11619->5206|11634->5211|11661->5228|11720->5248|11755->5256|11819->5310|11859->5311|11896->5320|11940->5336|11963->5337|12006->5351|12036->5352|12076->5363|12126->5385|12149->5386|12190->5399|12213->5400|12255->5414|12278->5415|12328->5437|12358->5438|12397->5446|12434->5452|12467->5458|12494->5475|12534->5476|12569->5483|12633->5518|12663->5519|12700->5528|12748->5547|12778->5548|12818->5559|12868->5580|12898->5581|12940->5594|13091->5716|13121->5717|13151->5718|13206->5744|13236->5745|13278->5758|13429->5880|13459->5881|13496->5890|13526->5891|13563->5900|13688->5997|13717->5998|13752->6005|13822->6046|13852->6047|13889->6056|14121->6259|14151->6260|14191->6271|14243->6295|14273->6296|14310->6305|14375->6341|14405->6342|14445->6353|14529->6408|14559->6409|14601->6422|14668->6460|14698->6461|14728->6462|14762->6467|14792->6468|14834->6481|14906->6524|14936->6525|14976->6536|15249->6781|15279->6782|15309->6783|15343->6788|15373->6789|15413->6800|15732->7091|15762->7092|15797->7099|15826->7100|15901->7146|15931->7147|15968->7156|16027->7186|16057->7187|16097->7198|16206->7279|16236->7280|16273->7289|16360->7348|16389->7349|16426->7359|16458->7381|16499->7383|16536->7392|16612->7439|16642->7440|16684->7453|16773->7513|16803->7514|16855->7537|16885->7538|16927->7551|17008->7603|17038->7604|17075->7613|17162->7671|17192->7672|17234->7685|17341->7763|17371->7764|17423->7787|17453->7788|17495->7801|17594->7871|17624->7872|17661->7881|17736->7927|17766->7928|17806->7939|18008->8112|18038->8113|18080->8126|18167->8184|18197->8185|18237->8196|18348->8278|18378->8279|18420->8292|18650->8494|18687->8509|18776->8570|18794->8577|18809->8581|18857->8589|18888->8590|18930->8603|18955->8605|18991->8608|19053->8641|19083->8642|19127->8657|19320->8821|19350->8822|19380->8823|19414->8828|19444->8829|19488->8844|19687->9014|19717->9015|19759->9028|19832->9072|19862->9073|19906->9088|19990->9143|20020->9144|20062->9157|20135->9201|20165->9202|20209->9217|20293->9272|20323->9273|20365->9286|20434->9326|20464->9327|20510->9344|20571->9376|20601->9377|20672->9419|20702->9420|20748->9437|20876->9536|20906->9537|20954->9556|21027->9600|21057->9601|21107->9622|21182->9668|21212->9669|21242->9670|21276->9675|21306->9676|21356->9697|21436->9748|21466->9749|21512->9766|21542->9767|21572->9768|21606->9773|21636->9774|21684->9793|21762->9842|21792->9843|21838->9860|22041->10034|22071->10035|22113->10048|22155->10061|22185->10062|22222->10071|22252->10072|22347->10138|22377->10139|22417->10150|22503->10208|22533->10209|22574->10219|22611->10225|22642->10228|22671->10229|22700->10230|22729->10231
                  LINES: 13->1|25->8|26->12|26->12|26->12|27->13|34->20|34->20|34->20|34->20|34->20|34->20|37->23|37->23|37->23|37->23|38->24|38->24|38->24|38->24|38->24|38->24|39->25|39->25|40->26|40->26|40->26|41->27|41->27|41->27|41->27|41->27|41->27|41->27|41->27|41->27|41->27|42->28|43->29|43->29|43->29|44->30|44->30|44->30|44->30|44->30|44->30|45->31|46->32|46->32|46->32|47->33|47->33|47->33|47->33|47->33|47->33|48->34|49->35|49->35|49->35|50->36|50->36|50->36|50->36|50->36|50->36|51->37|52->38|54->40|55->41|56->42|57->43|57->43|57->43|57->43|58->44|58->44|58->44|59->45|59->45|59->45|59->45|59->45|62->48|62->48|62->48|63->49|63->49|63->49|63->49|63->49|63->49|63->49|63->49|63->49|63->49|64->50|64->50|64->50|65->51|67->53|67->53|67->53|67->53|67->53|67->53|67->53|67->53|67->53|67->53|67->53|69->55|70->56|71->57|71->57|71->57|72->58|72->58|72->58|73->59|73->59|73->59|74->60|74->60|74->60|75->61|75->61|75->61|76->62|76->62|76->62|76->62|77->63|77->63|77->63|78->64|80->66|80->66|80->66|80->66|80->66|80->66|80->66|80->66|80->66|80->66|80->66|82->68|83->69|84->70|84->70|84->70|85->71|85->71|85->71|85->71|85->71|85->71|86->72|86->72|86->72|87->73|89->75|89->75|89->75|89->75|89->75|89->75|89->75|89->75|89->75|89->75|89->75|91->77|92->78|93->79|97->83|97->83|97->83|98->84|98->84|98->84|99->85|99->85|99->85|99->85|99->85|100->86|100->86|100->86|100->86|100->86|101->87|101->87|101->87|102->88|103->89|104->90|107->93|108->94|108->94|108->94|109->95|109->95|110->96|110->96|112->98|112->98|113->99|113->99|113->99|114->100|114->100|114->100|115->101|116->102|116->102|117->103|118->104|118->104|118->104|118->104|118->104|119->105|120->106|120->106|121->107|121->107|122->108|124->110|127->113|127->113|128->114|130->116|130->116|132->118|132->118|133->119|135->121|135->121|137->123|137->123|138->124|139->125|139->125|139->125|139->125|140->126|140->126|140->126|141->127|141->127|141->127|141->127|141->127|142->128|142->128|142->128|142->128|142->128|142->128|142->128|143->129|143->129|144->130|145->131|146->132|146->132|146->132|147->133|147->133|147->133|148->134|148->134|148->134|149->135|149->135|149->135|150->136|151->137|151->137|151->137|151->137|151->137|152->138|153->139|153->139|154->140|154->140|155->141|156->142|156->142|157->143|157->143|157->143|158->144|160->146|160->146|161->147|162->148|162->148|163->149|163->149|163->149|164->150|165->151|165->151|166->152|167->153|167->153|167->153|167->153|167->153|168->154|169->155|169->155|170->156|173->159|173->159|173->159|173->159|173->159|174->160|178->164|178->164|179->165|179->165|180->166|180->166|181->167|181->167|181->167|182->168|183->169|183->169|184->170|185->171|185->171|186->172|186->172|186->172|187->173|188->174|188->174|189->175|190->176|190->176|191->177|191->177|192->178|193->179|193->179|194->180|196->182|196->182|197->183|198->184|198->184|199->185|199->185|200->186|201->187|201->187|202->188|203->189|203->189|204->190|207->193|207->193|208->194|209->195|209->195|210->196|210->196|210->196|211->197|214->200|214->200|214->200|214->200|214->200|214->200|214->200|214->200|214->200|214->200|215->201|215->201|216->202|218->204|218->204|218->204|218->204|218->204|219->205|221->207|221->207|222->208|222->208|222->208|223->209|224->210|224->210|225->211|225->211|225->211|226->212|227->213|227->213|228->214|230->216|230->216|231->217|232->218|232->218|233->219|233->219|234->220|236->222|236->222|237->223|237->223|237->223|238->224|239->225|239->225|239->225|239->225|239->225|240->226|241->227|241->227|242->228|242->228|242->228|242->228|242->228|243->229|244->230|244->230|245->231|247->233|247->233|248->234|249->235|249->235|250->236|250->236|251->237|251->237|252->238|253->239|253->239|254->240|255->241|256->242|256->242|257->243|257->243
                  -- GENERATED --
              */
          