
package repo.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object blob extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template7[String,service.RepositoryService.RepositoryInfo,List[String],util.JGitUtil.ContentInfo,util.JGitUtil.CommitInfo,Boolean,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(branch: String,
  repository: service.RepositoryService.RepositoryInfo,
  pathList: List[String],
  content: util.JGitUtil.ContentInfo,
  latestCommit: util.JGitUtil.CommitInfo,
  hasWritePermission: Boolean)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*6.62*/("""
"""),_display_(/*9.2*/html/*9.6*/.main(s"${repository.owner}/${repository.name}", Some(repository))/*9.72*/ {_display_(Seq[Any](format.raw/*9.74*/("""
  """),_display_(/*10.4*/html/*10.8*/.menu("code", repository)/*10.33*/{_display_(Seq[Any](format.raw/*10.34*/("""
    """),format.raw/*11.5*/("""<div class="head">
      """),_display_(/*12.8*/helper/*12.14*/.html.branchcontrol(
        branch,
        repository,
        hasWritePermission
      )/*16.8*/{_display_(Seq[Any](format.raw/*16.9*/("""
        """),_display_(/*17.10*/repository/*17.20*/.branchList.map/*17.35*/ { x =>_display_(Seq[Any](format.raw/*17.42*/("""
          """),format.raw/*18.11*/("""<li><a href=""""),_display_(/*18.25*/url(repository)),format.raw/*18.40*/("""/blob/"""),_display_(/*18.47*/encodeRefName(x)),format.raw/*18.63*/("""/"""),_display_(/*18.65*/pathList/*18.73*/.mkString("/")),format.raw/*18.87*/("""">"""),_display_(/*18.90*/helper/*18.96*/.html.checkicon(x == branch)),format.raw/*18.124*/(""" """),_display_(/*18.126*/x),format.raw/*18.127*/("""</a></li>
        """)))}),format.raw/*19.10*/("""
      """)))}),format.raw/*20.8*/("""
      """),format.raw/*21.7*/("""<a href=""""),_display_(/*21.17*/url(repository)),format.raw/*21.32*/("""/tree/"""),_display_(/*21.39*/encodeRefName(branch)),format.raw/*21.60*/("""">"""),_display_(/*21.63*/repository/*21.73*/.name),format.raw/*21.78*/("""</a> /
      """),_display_(/*22.8*/pathList/*22.16*/.zipWithIndex.map/*22.33*/ { case (section, i) =>_display_(Seq[Any](format.raw/*22.56*/("""
        """),_display_(/*23.10*/if(i == pathList.length - 1)/*23.38*/{_display_(Seq[Any](format.raw/*23.39*/("""
          """),_display_(/*24.12*/section),format.raw/*24.19*/("""
        """)))}/*25.11*/else/*25.16*/{_display_(Seq[Any](format.raw/*25.17*/("""
          """),format.raw/*26.11*/("""<a href=""""),_display_(/*26.21*/url(repository)),format.raw/*26.36*/("""/tree/"""),_display_(/*26.43*/encodeRefName(branch)),format.raw/*26.64*/("""/"""),_display_(/*26.66*/pathList/*26.74*/.take(i + 1).mkString("/")),format.raw/*26.100*/("""">"""),_display_(/*26.103*/section),format.raw/*26.110*/("""</a> /
        """)))}),format.raw/*27.10*/("""
      """)))}),format.raw/*28.8*/("""
    """),format.raw/*29.5*/("""</div>

    <table class="table table-bordered blobview">
      <tr>
        <th style="font-weight: normal;">
          <div class="pull-left">
            """),_display_(/*35.14*/avatar(latestCommit, 20)),format.raw/*35.38*/("""
            """),_display_(/*36.14*/user(latestCommit.authorName, latestCommit.authorEmailAddress, "username strong")),format.raw/*36.95*/("""
            """),format.raw/*37.13*/("""<span class="muted">"""),_display_(/*37.34*/helper/*37.40*/.html.datetimeago(latestCommit.commitTime)),format.raw/*37.82*/("""</span>
            <a href=""""),_display_(/*38.23*/url(repository)),format.raw/*38.38*/("""/commit/"""),_display_(/*38.47*/latestCommit/*38.59*/.id),format.raw/*38.62*/("""" class="commit-message">"""),_display_(/*38.88*/link(latestCommit.summary, repository)),format.raw/*38.126*/("""</a>
          </div>
          <div class="btn-group pull-right">
            """),_display_(/*41.14*/if(hasWritePermission && content.viewType == "text" && repository.branchList.contains(branch))/*41.108*/{_display_(Seq[Any](format.raw/*41.109*/("""
              """),format.raw/*42.15*/("""<a class="btn btn-mini" href=""""),_display_(/*42.46*/url(repository)),format.raw/*42.61*/("""/edit/"""),_display_(/*42.68*/encodeRefName(branch)),format.raw/*42.89*/("""/"""),_display_(/*42.91*/pathList/*42.99*/.mkString("/")),format.raw/*42.113*/("""">Edit</a>
            """)))}),format.raw/*43.14*/("""
            """),format.raw/*44.13*/("""<a class="btn btn-mini" href="?raw=true">Raw</a>
            <a class="btn btn-mini" href=""""),_display_(/*45.44*/url(repository)),format.raw/*45.59*/("""/commits/"""),_display_(/*45.69*/encodeRefName(branch)),format.raw/*45.90*/("""/"""),_display_(/*45.92*/pathList/*45.100*/.mkString("/")),format.raw/*45.114*/("""">History</a>
            """),_display_(/*46.14*/if(hasWritePermission)/*46.36*/{_display_(Seq[Any](format.raw/*46.37*/("""
              """),format.raw/*47.15*/("""<a class="btn btn-mini btn-danger" href=""""),_display_(/*47.57*/url(repository)),format.raw/*47.72*/("""/remove/"""),_display_(/*47.81*/encodeRefName(branch)),format.raw/*47.102*/("""/"""),_display_(/*47.104*/pathList/*47.112*/.mkString("/")),format.raw/*47.126*/("""">Delete</a>
            """)))}),format.raw/*48.14*/("""
          """),format.raw/*49.11*/("""</div>
        </th>
      </tr>
      <tr>
        <td>
          """),_display_(/*54.12*/if(content.viewType == "text")/*54.42*/{_display_(Seq[Any](format.raw/*54.43*/("""
            """),_display_(/*55.14*/defining(pathList.reverse.head)/*55.45*/ { file =>_display_(Seq[Any](format.raw/*55.55*/("""
              """),_display_(/*56.16*/if(renderableSuffixes.find(suffix => file.toLowerCase.endsWith(suffix)))/*56.88*/ {_display_(Seq[Any](format.raw/*56.90*/("""
                """),format.raw/*57.17*/("""<div class="box-content markdown-body" style="border: none; padding-left: 16px; padding-right: 16px;">
                  """),_display_(/*58.20*/renderMarkup(pathList, content.content.get, branch, repository, false, false)),format.raw/*58.97*/("""
                """),format.raw/*59.17*/("""</div>
              """)))}/*60.17*/else/*60.22*/{_display_(Seq[Any](format.raw/*60.23*/("""
                """),format.raw/*61.17*/("""<pre class="prettyprint linenums blob">"""),_display_(/*61.57*/content/*61.64*/.content.get),format.raw/*61.76*/("""</pre>
              """)))}),format.raw/*62.16*/("""
            """)))}),format.raw/*63.14*/("""
          """)))}),format.raw/*64.12*/("""
          """),_display_(/*65.12*/if(content.viewType == "image")/*65.43*/{_display_(Seq[Any](format.raw/*65.44*/("""
            """),format.raw/*66.13*/("""<img src="?raw=true"/>
          """)))}),format.raw/*67.12*/("""
          """),_display_(/*68.12*/if(content.viewType == "large" || content.viewType == "binary")/*68.75*/{_display_(Seq[Any](format.raw/*68.76*/("""
            """),format.raw/*69.13*/("""<div style="text-align: center; padding-top: 20px; padding-bottom: 20px;">
              <a href="?raw=true">View Raw</a><br>
              <br>
              (Sorry about that, but we can't show files that are this big right now)
            </div>
          """)))}),format.raw/*74.12*/("""
        """),format.raw/*75.9*/("""</td>
      </tr>
    </table>
  """)))}),format.raw/*78.4*/("""
""")))}),format.raw/*79.2*/("""
"""),format.raw/*80.1*/("""<script src=""""),_display_(/*80.15*/assets),format.raw/*80.21*/("""/vendors/jquery/jquery.ba-hashchange.js"></script>
<script>
$(window).load(function()"""),format.raw/*82.26*/("""{"""),format.raw/*82.27*/("""
  """),format.raw/*83.3*/("""$(window).hashchange(function()"""),format.raw/*83.34*/("""{"""),format.raw/*83.35*/("""
    """),format.raw/*84.5*/("""updateHighlighting();
  """),format.raw/*85.3*/("""}"""),format.raw/*85.4*/(""").hashchange();

  $('pre.prettyprint ol.linenums li').each(function(i, e)"""),format.raw/*87.58*/("""{"""),format.raw/*87.59*/("""
    """),format.raw/*88.5*/("""var pre = $('pre.prettyprint');
    pre.append($('<div class="source-line-num">')
       .data('line', (i + 1))
       .css("""),format.raw/*91.13*/("""{"""),format.raw/*91.14*/("""
      """),format.raw/*92.7*/("""cursor  : 'pointer',
      position: 'absolute',
      top     : $(e).position().top + 'px',
      left    : pre.position().left + 'px',
      width   : ($(e).position().left - pre.position().left) + 'px',
      height  : '16px'
    """),format.raw/*98.5*/("""}"""),format.raw/*98.6*/("""));
  """),format.raw/*99.3*/("""}"""),format.raw/*99.4*/(""");

  $('div.source-line-num').click(function(e)"""),format.raw/*101.45*/("""{"""),format.raw/*101.46*/("""
    """),format.raw/*102.5*/("""var line = $(e.target).data('line');
    var hash = location.hash;
    if(e.shiftKey == true && hash.match(/#L\d+(-L\d+)?/))"""),format.raw/*104.58*/("""{"""),format.raw/*104.59*/("""
      """),format.raw/*105.7*/("""var lines = hash.split('-');
      location.hash = lines[0] + '-L' + line;
    """),format.raw/*107.5*/("""}"""),format.raw/*107.6*/(""" """),format.raw/*107.7*/("""else """),format.raw/*107.12*/("""{"""),format.raw/*107.13*/("""
      """),format.raw/*108.7*/("""location.hash = '#L' + line;
    """),format.raw/*109.5*/("""}"""),format.raw/*109.6*/("""
  """),format.raw/*110.3*/("""}"""),format.raw/*110.4*/(""");
"""),format.raw/*111.1*/("""}"""),format.raw/*111.2*/(""");

/**
 * Hightlight lines which are specified by URL hash.
 */
function updateHighlighting()"""),format.raw/*116.30*/("""{"""),format.raw/*116.31*/("""
  """),format.raw/*117.3*/("""var hash = location.hash;
  if(hash.match(/#L\d+(-L\d+)?/))"""),format.raw/*118.34*/("""{"""),format.raw/*118.35*/("""
    """),format.raw/*119.5*/("""$('li.highlight').removeClass('highlight');
    var lines = hash.substr(1).split('-');
    if(lines.length == 1)"""),format.raw/*121.26*/("""{"""),format.raw/*121.27*/("""
      """),format.raw/*122.7*/("""$('#' + lines[0]).addClass('highlight');
      $(window).scrollTop($('#' + lines[0]).offset().top - 40);
    """),format.raw/*124.5*/("""}"""),format.raw/*124.6*/(""" """),format.raw/*124.7*/("""else if(lines.length > 1)"""),format.raw/*124.32*/("""{"""),format.raw/*124.33*/("""
      """),format.raw/*125.7*/("""var start = parseInt(lines[0].substr(1));
      var end   = parseInt(lines[1].substr(1));
      for(var i = start; i <= end; i++)"""),format.raw/*127.40*/("""{"""),format.raw/*127.41*/("""
        """),format.raw/*128.9*/("""$('#L' + i).addClass('highlight');
      """),format.raw/*129.7*/("""}"""),format.raw/*129.8*/("""
      """),format.raw/*130.7*/("""$(window).scrollTop($('#L' + start).offset().top - 40);
    """),format.raw/*131.5*/("""}"""),format.raw/*131.6*/("""
  """),format.raw/*132.3*/("""}"""),format.raw/*132.4*/("""
"""),format.raw/*133.1*/("""}"""),format.raw/*133.2*/("""
"""),format.raw/*134.1*/("""</script>"""))}
  }

  def render(branch:String,repository:service.RepositoryService.RepositoryInfo,pathList:List[String],content:util.JGitUtil.ContentInfo,latestCommit:util.JGitUtil.CommitInfo,hasWritePermission:Boolean,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(branch,repository,pathList,content,latestCommit,hasWritePermission)(context)

  def f:((String,service.RepositoryService.RepositoryInfo,List[String],util.JGitUtil.ContentInfo,util.JGitUtil.CommitInfo,Boolean) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (branch,repository,pathList,content,latestCommit,hasWritePermission) => (context) => apply(branch,repository,pathList,content,latestCommit,hasWritePermission)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/repo/blob.scala.html
                  HASH: 6dac2d57ad3a2ea2d0ef25e0c4f869032ee7b80a
                  MATRIX: 466->1|832->241|859->284|870->288|944->354|983->356|1013->360|1025->364|1059->389|1098->390|1130->395|1182->421|1197->427|1296->518|1334->519|1371->529|1390->539|1414->554|1459->561|1498->572|1539->586|1575->601|1609->608|1646->624|1675->626|1692->634|1727->648|1757->651|1772->657|1822->685|1852->687|1875->688|1925->707|1963->715|1997->722|2034->732|2070->747|2104->754|2146->775|2176->778|2195->788|2221->793|2261->807|2278->815|2304->832|2365->855|2402->865|2439->893|2478->894|2517->906|2545->913|2574->924|2587->929|2626->930|2665->941|2702->951|2738->966|2772->973|2814->994|2843->996|2860->1004|2908->1030|2939->1033|2968->1040|3015->1056|3053->1064|3085->1069|3270->1227|3315->1251|3356->1265|3458->1346|3499->1359|3547->1380|3562->1386|3625->1428|3682->1458|3718->1473|3754->1482|3775->1494|3799->1497|3852->1523|3912->1561|4019->1641|4123->1735|4163->1736|4206->1751|4264->1782|4300->1797|4334->1804|4376->1825|4405->1827|4422->1835|4458->1849|4513->1873|4554->1886|4673->1978|4709->1993|4746->2003|4788->2024|4817->2026|4835->2034|4871->2048|4925->2075|4956->2097|4995->2098|5038->2113|5107->2155|5143->2170|5179->2179|5222->2200|5252->2202|5270->2210|5306->2224|5363->2250|5402->2261|5497->2329|5536->2359|5575->2360|5616->2374|5656->2405|5704->2415|5747->2431|5828->2503|5868->2505|5913->2522|6062->2644|6160->2721|6205->2738|6246->2761|6259->2766|6298->2767|6343->2784|6410->2824|6426->2831|6459->2843|6512->2865|6557->2879|6600->2891|6639->2903|6679->2934|6718->2935|6759->2948|6824->2982|6863->2994|6935->3057|6974->3058|7015->3071|7307->3332|7343->3341|7407->3375|7439->3377|7467->3378|7508->3392|7535->3398|7648->3483|7677->3484|7707->3487|7766->3518|7795->3519|7827->3524|7878->3548|7906->3549|8008->3623|8037->3624|8069->3629|8221->3753|8250->3754|8284->3761|8544->3994|8572->3995|8605->4001|8633->4002|8710->4050|8740->4051|8773->4056|8926->4180|8956->4181|8991->4188|9098->4267|9127->4268|9156->4269|9190->4274|9220->4275|9255->4282|9316->4315|9345->4316|9376->4319|9405->4320|9436->4323|9465->4324|9588->4418|9618->4419|9649->4422|9737->4481|9767->4482|9800->4487|9941->4599|9971->4600|10006->4607|10143->4716|10172->4717|10201->4718|10255->4743|10285->4744|10320->4751|10478->4880|10508->4881|10545->4890|10614->4931|10643->4932|10678->4939|10766->4999|10795->5000|10826->5003|10855->5004|10884->5005|10913->5006|10942->5007
                  LINES: 13->1|22->6|23->9|23->9|23->9|23->9|24->10|24->10|24->10|24->10|25->11|26->12|26->12|30->16|30->16|31->17|31->17|31->17|31->17|32->18|32->18|32->18|32->18|32->18|32->18|32->18|32->18|32->18|32->18|32->18|32->18|32->18|33->19|34->20|35->21|35->21|35->21|35->21|35->21|35->21|35->21|35->21|36->22|36->22|36->22|36->22|37->23|37->23|37->23|38->24|38->24|39->25|39->25|39->25|40->26|40->26|40->26|40->26|40->26|40->26|40->26|40->26|40->26|40->26|41->27|42->28|43->29|49->35|49->35|50->36|50->36|51->37|51->37|51->37|51->37|52->38|52->38|52->38|52->38|52->38|52->38|52->38|55->41|55->41|55->41|56->42|56->42|56->42|56->42|56->42|56->42|56->42|56->42|57->43|58->44|59->45|59->45|59->45|59->45|59->45|59->45|59->45|60->46|60->46|60->46|61->47|61->47|61->47|61->47|61->47|61->47|61->47|61->47|62->48|63->49|68->54|68->54|68->54|69->55|69->55|69->55|70->56|70->56|70->56|71->57|72->58|72->58|73->59|74->60|74->60|74->60|75->61|75->61|75->61|75->61|76->62|77->63|78->64|79->65|79->65|79->65|80->66|81->67|82->68|82->68|82->68|83->69|88->74|89->75|92->78|93->79|94->80|94->80|94->80|96->82|96->82|97->83|97->83|97->83|98->84|99->85|99->85|101->87|101->87|102->88|105->91|105->91|106->92|112->98|112->98|113->99|113->99|115->101|115->101|116->102|118->104|118->104|119->105|121->107|121->107|121->107|121->107|121->107|122->108|123->109|123->109|124->110|124->110|125->111|125->111|130->116|130->116|131->117|132->118|132->118|133->119|135->121|135->121|136->122|138->124|138->124|138->124|138->124|138->124|139->125|141->127|141->127|142->128|143->129|143->129|144->130|145->131|145->131|146->132|146->132|147->133|147->133|148->134
                  -- GENERATED --
              */
          