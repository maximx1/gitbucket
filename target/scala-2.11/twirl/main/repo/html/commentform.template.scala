
package repo.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object commentform extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template8[String,Option[String],Option[Int],Option[Int],Option[Int],Boolean,service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(commitId: String,
  fileName: Option[String] = None,
  oldLineNumber: Option[Int] = None,
  newLineNumber: Option[Int] = None,
  issueId: Option[Int] = None,
  hasWritePermission: Boolean,
  repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*7.87*/("""
"""),_display_(/*10.2*/if(loginAccount.isDefined)/*10.28*/{_display_(Seq[Any](format.raw/*10.29*/("""
  """),_display_(/*11.4*/if(!fileName.isDefined)/*11.27*/{_display_(Seq[Any](format.raw/*11.28*/("""<hr/><br/>""")))}),format.raw/*11.39*/("""
  """),format.raw/*12.3*/("""<form method="POST" validate="true" style="max-width: 874px;">
    """),_display_(/*13.6*/if(!fileName.isDefined)/*13.29*/{_display_(Seq[Any](format.raw/*13.30*/("""
      """),format.raw/*14.7*/("""<div class="issue-avatar-image">"""),_display_(/*14.40*/avatar(loginAccount.get.userName, 48)),format.raw/*14.77*/("""</div>
    """)))}),format.raw/*15.6*/("""
    """),format.raw/*16.5*/("""<div class="box issue-comment-box">
      <div class="box-content">
        """),_display_(/*18.10*/helper/*18.16*/.html.preview(repository, "", false, true, true, hasWritePermission, "width: 635px; height: 100px; max-height: 150px;", elastic = true)),format.raw/*18.151*/("""
      """),format.raw/*19.7*/("""</div>
      """),_display_(/*20.8*/if(fileName.isDefined)/*20.30*/{_display_(Seq[Any](format.raw/*20.31*/("""
        """),format.raw/*21.9*/("""<div class="pull-right" style="margin-top: 10px;">
          <input type="button" class="btn btn-default" value="Cancel"/>
          <input type="submit" class="btn btn-success btn-inline-comment" formaction=""""),_display_(/*23.88*/url(repository)),format.raw/*23.103*/("""/commit/"""),_display_(/*23.112*/commitId),format.raw/*23.120*/("""/comment/new" value="Comment"/>
        </div>
      """)))}),format.raw/*25.8*/("""
    """),format.raw/*26.5*/("""</div>
    """),_display_(/*27.6*/if(!fileName.isDefined)/*27.29*/{_display_(Seq[Any](format.raw/*27.30*/("""
      """),format.raw/*28.7*/("""<div class="pull-right">
        <input type="submit" class="btn btn-success" formaction=""""),_display_(/*29.67*/url(repository)),format.raw/*29.82*/("""/commit/"""),_display_(/*29.91*/commitId),format.raw/*29.99*/("""/comment/new" value="Comment on this commit"/>
      </div>
    """)))}),format.raw/*31.6*/("""
    """),_display_(/*32.6*/issueId/*32.13*/.map/*32.17*/ { issueId =>_display_(Seq[Any](format.raw/*32.30*/(""" """),format.raw/*32.31*/("""<input type="hidden" name="issueId" value=""""),_display_(/*32.75*/issueId),format.raw/*32.82*/(""""> """)))}),format.raw/*32.86*/("""
    """),_display_(/*33.6*/fileName/*33.14*/.map/*33.18*/ { fileName =>_display_(Seq[Any](format.raw/*33.32*/(""" """),format.raw/*33.33*/("""<input type="hidden" name="fileName" value=""""),_display_(/*33.78*/fileName),format.raw/*33.86*/(""""> """)))}),format.raw/*33.90*/("""
    """),_display_(/*34.6*/oldLineNumber/*34.19*/.map/*34.23*/ { oldLineNumber =>_display_(Seq[Any](format.raw/*34.42*/(""" """),format.raw/*34.43*/("""<input type="hidden" name="oldLineNumber" value=""""),_display_(/*34.93*/oldLineNumber),format.raw/*34.106*/(""""> """)))}),format.raw/*34.110*/("""
    """),_display_(/*35.6*/newLineNumber/*35.19*/.map/*35.23*/ { newLineNumber =>_display_(Seq[Any](format.raw/*35.42*/(""" """),format.raw/*35.43*/("""<input type="hidden" name="newLineNumber" value=""""),_display_(/*35.93*/newLineNumber),format.raw/*35.106*/(""""> """)))}),format.raw/*35.110*/("""
  """),format.raw/*36.3*/("""</form>
  <script>
    $('.btn-inline-comment').click(function(e) """),format.raw/*38.48*/("""{"""),format.raw/*38.49*/("""
      """),format.raw/*39.7*/("""e.preventDefault();
      $form = $(e.target).attr('disabled', 'disabled').closest('form');
      var param = """),format.raw/*41.19*/("""{"""),format.raw/*41.20*/("""}"""),format.raw/*41.21*/(""";
      $($form.serializeArray()).each(function(i, v) """),format.raw/*42.53*/("""{"""),format.raw/*42.54*/("""
        """),format.raw/*43.9*/("""param[v.name] = v.value;
      """),format.raw/*44.7*/("""}"""),format.raw/*44.8*/(""");
      $.ajax("""),format.raw/*45.14*/("""{"""),format.raw/*45.15*/("""
        """),format.raw/*46.9*/("""url: '"""),_display_(/*46.16*/url(repository)),format.raw/*46.31*/("""/commit/"""),_display_(/*46.40*/commitId),format.raw/*46.48*/("""/comment/_data/new',
        type: 'POST',
        data: param
      """),format.raw/*49.7*/("""}"""),format.raw/*49.8*/(""").done(function(data) """),format.raw/*49.30*/("""{"""),format.raw/*49.31*/("""
        """),format.raw/*50.9*/("""var tmp;
        if (window.viewType == 0) """),format.raw/*51.35*/("""{"""),format.raw/*51.36*/("""
          """),format.raw/*52.11*/("""tmp = '"""),_display_(/*52.19*/(oldLineNumber, newLineNumber)/*52.49*/ match/*52.55*/ {/*53.13*/case (Some(_), None) =>/*53.36*/ {_display_(Seq[Any](format.raw/*53.38*/("""<td colspan="2" class="comment-box-container"></td><td colspan="2"></td>""")))}/*54.13*/case (None, Some(_)) =>/*54.36*/ {_display_(Seq[Any](format.raw/*54.38*/("""<td colspan="2"></td><td colspan="2" class="comment-box-container"></td>""")))}/*55.13*/case _ =>/*55.22*/ {_display_(Seq[Any](format.raw/*55.24*/("""<td colspan="3" class="comment-box-container"></td>""")))}}),format.raw/*56.12*/("""'
        """),format.raw/*57.9*/("""}"""),format.raw/*57.10*/(""" """),format.raw/*57.11*/("""else """),format.raw/*57.16*/("""{"""),format.raw/*57.17*/("""
          """),format.raw/*58.11*/("""tmp = '<td colspan="3" class="comment-box-container"></td>'
        """),format.raw/*59.9*/("""}"""),format.raw/*59.10*/("""
        """),format.raw/*60.9*/("""$form.closest('tr').removeClass('inline-comment-form').html(tmp).find('.comment-box-container').html(data);
        $('#comment-list').append(data);
        if (typeof $('#show-notes')[0] !== 'undefined' && !$('#show-notes')[0].checked) """),format.raw/*62.89*/("""{"""),format.raw/*62.90*/("""
          """),format.raw/*63.11*/("""$('#comment-list').children('.inline-comment').hide();
        """),format.raw/*64.9*/("""}"""),format.raw/*64.10*/("""
      """),format.raw/*65.7*/("""}"""),format.raw/*65.8*/(""").fail(function(req) """),format.raw/*65.29*/("""{"""),format.raw/*65.30*/("""
        """),format.raw/*66.9*/("""$('.btn-inline-comment').removeAttr('disabled');
        $('#error-content', $form).html($.parseJSON(req.responseText).content);
      """),format.raw/*68.7*/("""}"""),format.raw/*68.8*/(""");
    """),format.raw/*69.5*/("""}"""),format.raw/*69.6*/(""")
  </script>
""")))}),format.raw/*71.2*/("""
"""))}
  }

  def render(commitId:String,fileName:Option[String],oldLineNumber:Option[Int],newLineNumber:Option[Int],issueId:Option[Int],hasWritePermission:Boolean,repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(commitId,fileName,oldLineNumber,newLineNumber,issueId,hasWritePermission,repository)(context)

  def f:((String,Option[String],Option[Int],Option[Int],Option[Int],Boolean,service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (commitId,fileName,oldLineNumber,newLineNumber,issueId,hasWritePermission,repository) => (context) => apply(commitId,fileName,oldLineNumber,newLineNumber,issueId,hasWritePermission,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/repo/commentform.scala.html
                  HASH: ec2d72cceaf22f77f2156916f0e3213c6497ab6f
                  MATRIX: 460->1|862->277|890->320|925->346|964->347|994->351|1026->374|1065->375|1107->386|1137->389|1231->457|1263->480|1302->481|1336->488|1396->521|1454->558|1496->570|1528->575|1632->652|1647->658|1804->793|1838->800|1878->814|1909->836|1948->837|1984->846|2221->1056|2258->1071|2295->1080|2325->1088|2409->1142|2441->1147|2479->1159|2511->1182|2550->1183|2584->1190|2702->1281|2738->1296|2774->1305|2803->1313|2898->1378|2930->1384|2946->1391|2959->1395|3010->1408|3039->1409|3110->1453|3138->1460|3173->1464|3205->1470|3222->1478|3235->1482|3287->1496|3316->1497|3388->1542|3417->1550|3452->1554|3484->1560|3506->1573|3519->1577|3576->1596|3605->1597|3682->1647|3717->1660|3753->1664|3785->1670|3807->1683|3820->1687|3877->1706|3906->1707|3983->1757|4018->1770|4054->1774|4084->1777|4178->1843|4207->1844|4241->1851|4379->1961|4408->1962|4437->1963|4519->2017|4548->2018|4584->2027|4642->2058|4670->2059|4714->2075|4743->2076|4779->2085|4813->2092|4849->2107|4885->2116|4914->2124|5010->2193|5038->2194|5088->2216|5117->2217|5153->2226|5224->2269|5253->2270|5292->2281|5327->2289|5366->2319|5381->2325|5392->2340|5424->2363|5464->2365|5556->2451|5588->2474|5628->2476|5720->2562|5738->2571|5778->2573|5862->2637|5899->2647|5928->2648|5957->2649|5990->2654|6019->2655|6058->2666|6153->2734|6182->2735|6218->2744|6483->2981|6512->2982|6551->2993|6641->3056|6670->3057|6704->3064|6732->3065|6781->3086|6810->3087|6846->3096|7008->3231|7036->3232|7070->3239|7098->3240|7143->3255
                  LINES: 13->1|23->7|24->10|24->10|24->10|25->11|25->11|25->11|25->11|26->12|27->13|27->13|27->13|28->14|28->14|28->14|29->15|30->16|32->18|32->18|32->18|33->19|34->20|34->20|34->20|35->21|37->23|37->23|37->23|37->23|39->25|40->26|41->27|41->27|41->27|42->28|43->29|43->29|43->29|43->29|45->31|46->32|46->32|46->32|46->32|46->32|46->32|46->32|46->32|47->33|47->33|47->33|47->33|47->33|47->33|47->33|47->33|48->34|48->34|48->34|48->34|48->34|48->34|48->34|48->34|49->35|49->35|49->35|49->35|49->35|49->35|49->35|49->35|50->36|52->38|52->38|53->39|55->41|55->41|55->41|56->42|56->42|57->43|58->44|58->44|59->45|59->45|60->46|60->46|60->46|60->46|60->46|63->49|63->49|63->49|63->49|64->50|65->51|65->51|66->52|66->52|66->52|66->52|66->53|66->53|66->53|66->54|66->54|66->54|66->55|66->55|66->55|66->56|67->57|67->57|67->57|67->57|67->57|68->58|69->59|69->59|70->60|72->62|72->62|73->63|74->64|74->64|75->65|75->65|75->65|75->65|76->66|78->68|78->68|79->69|79->69|81->71
                  -- GENERATED --
              */
          