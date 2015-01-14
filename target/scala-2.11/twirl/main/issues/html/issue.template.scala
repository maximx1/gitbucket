
package issues.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object issue extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template9[model.Issue,List[model.IssueComment],List[model.Label],List[String],List[scala.Tuple3[model.Milestone, Int, Int]],List[model.Label],Boolean,service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issue: model.Issue,
  comments: List[model.IssueComment],
  issueLabels: List[model.Label],
  collaborators: List[String],
  milestones: List[(model.Milestone, Int, Int)],
  labels: List[model.Label],
  hasWritePermission: Boolean,
  repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*8.87*/("""
"""),_display_(/*11.2*/html/*11.6*/.main(s"${issue.title} - Issue #${issue.issueId} - ${repository.owner}/${repository.name}", Some(repository))/*11.115*/{_display_(Seq[Any](format.raw/*11.116*/("""
  """),_display_(/*12.4*/html/*12.8*/.menu("issues", repository)/*12.35*/{_display_(Seq[Any](format.raw/*12.36*/("""
    """),format.raw/*13.5*/("""<div>
      <div class="show-title pull-right">
        """),_display_(/*15.10*/if(hasWritePermission || loginAccount.map(_.userName == issue.openedUserName).getOrElse(false))/*15.105*/{_display_(Seq[Any](format.raw/*15.106*/("""
          """),format.raw/*16.11*/("""<a class="btn btn-small" href="#" id="edit">Edit</a>
        """)))}),format.raw/*17.10*/("""
        """),format.raw/*18.9*/("""<a class="btn btn-small btn-success" href=""""),_display_(/*18.53*/url(repository)),format.raw/*18.68*/("""/issues/new">New issue</a>
      </div>
      <div class="edit-title pull-right" style="display: none;">
        <a class="btn" href="#" id="update">Save</a>  <a href="#" id="cancel">Cancel</a>
      </div>
      <h1>
        <span class="show-title">
          <span id="show-title">"""),_display_(/*25.34*/issue/*25.39*/.title),format.raw/*25.45*/("""</span>
          <span class="muted">#"""),_display_(/*26.33*/issue/*26.38*/.issueId),format.raw/*26.46*/("""</span>
        </span>
        <span class="edit-title" style="display: none;">
          <span id="error-edit-title" class="error"></span>
          <input type="text" style="width: 700px;" id="edit-title" value=""""),_display_(/*30.76*/issue/*30.81*/.title),format.raw/*30.87*/(""""/>
        </span>
      </h1>
    </div>
    """),_display_(/*34.6*/if(issue.closed)/*34.22*/ {_display_(Seq[Any](format.raw/*34.24*/("""
      """),format.raw/*35.7*/("""<span class="label label-important issue-status">Closed</span>
    """)))}/*36.7*/else/*36.12*/{_display_(Seq[Any](format.raw/*36.13*/("""
      """),format.raw/*37.7*/("""<span class="label label-success issue-status">Open</span>
    """)))}),format.raw/*38.6*/("""
    """),format.raw/*39.5*/("""<span class="muted">
      """),_display_(/*40.8*/user(issue.openedUserName, styleClass="username strong")),format.raw/*40.64*/(""" """),format.raw/*40.65*/("""opened this issue """),_display_(/*40.84*/helper/*40.90*/.html.datetimeago(issue.registeredDate)),format.raw/*40.129*/(""" """),format.raw/*40.130*/("""- """),_display_(/*40.133*/defining(
        comments.count( _.action.contains("comment") )
      )/*42.8*/{ count =>_display_(Seq[Any](format.raw/*42.18*/("""
        """),_display_(/*43.10*/count),format.raw/*43.15*/(""" """),_display_(/*43.17*/plural(count, "comment")),format.raw/*43.41*/("""
      """)))}),format.raw/*44.8*/("""
    """),format.raw/*45.5*/("""</span>
    <br/><br/>
    <hr>
    <div class="row-fluid">
      <div class="span10">
        """),_display_(/*50.10*/commentlist(Some(issue), comments, hasWritePermission, repository)),format.raw/*50.76*/("""
        """),_display_(/*51.10*/commentform(issue, true, hasWritePermission, repository)),format.raw/*51.66*/("""
      """),format.raw/*52.7*/("""</div>
      <div class="span2">
        """),_display_(/*54.10*/issueinfo(issue, comments, issueLabels, collaborators, milestones, labels, hasWritePermission, repository)),format.raw/*54.116*/("""
      """),format.raw/*55.7*/("""</div>
    </div>
  """)))}),format.raw/*57.4*/("""
""")))}),format.raw/*58.2*/("""
"""),format.raw/*59.1*/("""<script>
$(function()"""),format.raw/*60.13*/("""{"""),format.raw/*60.14*/("""
  """),format.raw/*61.3*/("""$('#edit').click(function()"""),format.raw/*61.30*/("""{"""),format.raw/*61.31*/("""
    """),format.raw/*62.5*/("""$('.edit-title').show();
    $('.show-title').hide();
    return false;
  """),format.raw/*65.3*/("""}"""),format.raw/*65.4*/(""");

  $('#update').click(function()"""),format.raw/*67.32*/("""{"""),format.raw/*67.33*/("""
    """),format.raw/*68.5*/("""$(this).attr('disabled', 'disabled');
    $.ajax("""),format.raw/*69.12*/("""{"""),format.raw/*69.13*/("""
      """),format.raw/*70.7*/("""url: '"""),_display_(/*70.14*/url(repository)),format.raw/*70.29*/("""/issues/edit_title/"""),_display_(/*70.49*/issue/*70.54*/.issueId),format.raw/*70.62*/("""',
      type: 'POST',
      data: """),format.raw/*72.13*/("""{"""),format.raw/*72.14*/("""
        """),format.raw/*73.9*/("""title   : $('#edit-title').val()
      """),format.raw/*74.7*/("""}"""),format.raw/*74.8*/("""
    """),format.raw/*75.5*/("""}"""),format.raw/*75.6*/(""").done(function(data)"""),format.raw/*75.27*/("""{"""),format.raw/*75.28*/("""
      """),format.raw/*76.7*/("""$('#show-title').empty().text(data.title);
      $('#cancel').click();
      $(this).removeAttr('disabled');
    """),format.raw/*79.5*/("""}"""),format.raw/*79.6*/(""").fail(function(req)"""),format.raw/*79.26*/("""{"""),format.raw/*79.27*/("""
      """),format.raw/*80.7*/("""$(this).removeAttr('disabled');
      $('#error-edit-title').text($.parseJSON(req.responseText).title);
    """),format.raw/*82.5*/("""}"""),format.raw/*82.6*/(""");
    return false;
  """),format.raw/*84.3*/("""}"""),format.raw/*84.4*/(""");

  $('#cancel').click(function()"""),format.raw/*86.32*/("""{"""),format.raw/*86.33*/("""
    """),format.raw/*87.5*/("""$('.edit-title').hide();
    $('.show-title').show();
    return false;
  """),format.raw/*90.3*/("""}"""),format.raw/*90.4*/(""");
"""),format.raw/*91.1*/("""}"""),format.raw/*91.2*/(""");
</script>
"""))}
  }

  def render(issue:model.Issue,comments:List[model.IssueComment],issueLabels:List[model.Label],collaborators:List[String],milestones:List[scala.Tuple3[model.Milestone, Int, Int]],labels:List[model.Label],hasWritePermission:Boolean,repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(issue,comments,issueLabels,collaborators,milestones,labels,hasWritePermission,repository)(context)

  def f:((model.Issue,List[model.IssueComment],List[model.Label],List[String],List[scala.Tuple3[model.Milestone, Int, Int]],List[model.Label],Boolean,service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (issue,comments,issueLabels,collaborators,milestones,labels,hasWritePermission,repository) => (context) => apply(issue,comments,issueLabels,collaborators,milestones,labels,hasWritePermission,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/issues/issue.scala.html
                  HASH: 4f054c77318eac62f5227de7273d74bc6305d779
                  MATRIX: 530->1|975->320|1003->363|1015->367|1134->476|1174->477|1204->481|1216->485|1252->512|1291->513|1323->518|1407->575|1512->670|1552->671|1591->682|1684->744|1720->753|1791->797|1827->812|2139->1097|2153->1102|2180->1108|2247->1148|2261->1153|2290->1161|2533->1377|2547->1382|2574->1388|2648->1436|2673->1452|2713->1454|2747->1461|2833->1530|2846->1535|2885->1536|2919->1543|3013->1607|3045->1612|3099->1640|3176->1696|3205->1697|3251->1716|3266->1722|3327->1761|3357->1762|3388->1765|3468->1837|3516->1847|3553->1857|3579->1862|3608->1864|3653->1888|3691->1896|3723->1901|3846->1997|3933->2063|3970->2073|4047->2129|4081->2136|4150->2178|4278->2284|4312->2291|4363->2312|4395->2314|4423->2315|4472->2336|4501->2337|4531->2340|4586->2367|4615->2368|4647->2373|4748->2447|4776->2448|4839->2483|4868->2484|4900->2489|4977->2538|5006->2539|5040->2546|5074->2553|5110->2568|5157->2588|5171->2593|5200->2601|5263->2636|5292->2637|5328->2646|5394->2685|5422->2686|5454->2691|5482->2692|5531->2713|5560->2714|5594->2721|5734->2834|5762->2835|5810->2855|5839->2856|5873->2863|6008->2971|6036->2972|6086->2995|6114->2996|6177->3031|6206->3032|6238->3037|6339->3111|6367->3112|6397->3115|6425->3116
                  LINES: 13->1|24->8|25->11|25->11|25->11|25->11|26->12|26->12|26->12|26->12|27->13|29->15|29->15|29->15|30->16|31->17|32->18|32->18|32->18|39->25|39->25|39->25|40->26|40->26|40->26|44->30|44->30|44->30|48->34|48->34|48->34|49->35|50->36|50->36|50->36|51->37|52->38|53->39|54->40|54->40|54->40|54->40|54->40|54->40|54->40|54->40|56->42|56->42|57->43|57->43|57->43|57->43|58->44|59->45|64->50|64->50|65->51|65->51|66->52|68->54|68->54|69->55|71->57|72->58|73->59|74->60|74->60|75->61|75->61|75->61|76->62|79->65|79->65|81->67|81->67|82->68|83->69|83->69|84->70|84->70|84->70|84->70|84->70|84->70|86->72|86->72|87->73|88->74|88->74|89->75|89->75|89->75|89->75|90->76|93->79|93->79|93->79|93->79|94->80|96->82|96->82|98->84|98->84|100->86|100->86|101->87|104->90|104->90|105->91|105->91
                  -- GENERATED --
              */
          