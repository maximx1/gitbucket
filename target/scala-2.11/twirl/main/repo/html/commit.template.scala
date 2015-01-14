
package repo.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object commit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template10[String,util.JGitUtil.CommitInfo,List[String],List[String],List[model.Comment],service.RepositoryService.RepositoryInfo,Seq[util.JGitUtil.DiffInfo],Option[String],Boolean,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(commitId: String,
  commit: util.JGitUtil.CommitInfo,
  branches: List[String],
  tags: List[String],
  comments: List[model.Comment],
  repository: service.RepositoryService.RepositoryInfo,
  diffs: Seq[util.JGitUtil.DiffInfo],
  oldCommitId: Option[String],
  hasWritePermission: Boolean)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._
import util.Implicits._

Seq[Any](format.raw/*9.62*/("""
"""),_display_(/*13.2*/html/*13.6*/.main(commit.shortMessage, Some(repository))/*13.50*/{_display_(Seq[Any](format.raw/*13.51*/("""
  """),_display_(/*14.4*/html/*14.8*/.menu("code", repository)/*14.33*/{_display_(Seq[Any](format.raw/*14.34*/("""
    """),format.raw/*15.5*/("""<table class="table table-bordered">
      <tr>
        <th>
          <div class="pull-right align-right">
            <a href=""""),_display_(/*19.23*/url(repository)),format.raw/*19.38*/("""/tree/"""),_display_(/*19.45*/commit/*19.51*/.id),format.raw/*19.54*/("""" class="btn btn-small">Browse code</a>
          </div>
          <div class="commit-log">"""),_display_(/*21.36*/link(commit.summary, repository)),format.raw/*21.68*/("""</div>
          """),_display_(/*22.12*/if(commit.description.isDefined)/*22.44*/{_display_(Seq[Any](format.raw/*22.45*/("""
            """),format.raw/*23.13*/("""<pre class="commit-description">"""),_display_(/*23.46*/link(commit.description.get, repository)),format.raw/*23.86*/("""</pre>
          """)))}),format.raw/*24.12*/("""
          """),format.raw/*25.11*/("""<div class="small" style="font-weight: normal;">
            """),_display_(/*26.14*/if(branches.nonEmpty)/*26.35*/{_display_(Seq[Any](format.raw/*26.36*/("""
              """),format.raw/*27.15*/("""<span class="muted">
                <img src=""""),_display_(/*28.28*/assets),format.raw/*28.34*/("""/common/images/branch.png"/>
                """),_display_(/*29.18*/branches/*29.26*/.zipWithIndex.map/*29.43*/ { case (branch, i) =>_display_(Seq[Any](format.raw/*29.65*/("""
                  """),format.raw/*30.19*/("""<a href=""""),_display_(/*30.29*/url(repository)),format.raw/*30.44*/("""/tree/"""),_display_(/*30.51*/encodeRefName(branch)),format.raw/*30.72*/("""" class="branch" id="branch-"""),_display_(/*30.101*/i),format.raw/*30.102*/("""">"""),_display_(/*30.105*/branch),format.raw/*30.111*/("""</a>
                """)))}),format.raw/*31.18*/("""
              """),format.raw/*32.15*/("""</span>
            """)))}),format.raw/*33.14*/("""
            """),_display_(/*34.14*/if(tags.nonEmpty)/*34.31*/{_display_(Seq[Any](format.raw/*34.32*/("""
              """),format.raw/*35.15*/("""<span class="muted">
                <img src=""""),_display_(/*36.28*/assets),format.raw/*36.34*/("""/common/images/tag.png"/>
                """),_display_(/*37.18*/tags/*37.22*/.zipWithIndex.map/*37.39*/ { case (tag, i) =>_display_(Seq[Any](format.raw/*37.58*/("""
                  """),format.raw/*38.19*/("""<a href=""""),_display_(/*38.29*/url(repository)),format.raw/*38.44*/("""/tree/"""),_display_(/*38.51*/tag),format.raw/*38.54*/("""" class="tag" id="tag-"""),_display_(/*38.77*/i),format.raw/*38.78*/("""">"""),_display_(/*38.81*/tag),format.raw/*38.84*/("""</a>
                """)))}),format.raw/*39.18*/("""
              """),format.raw/*40.15*/("""</span>
            """)))}),format.raw/*41.14*/("""
          """),format.raw/*42.11*/("""</div>
        </th>
      </tr>
      <tr>
        <td>
          <div class="pull-right monospace small" style="text-align: right;">
            <div>
              """),_display_(/*49.16*/if(commit.parents.size == 0)/*49.44*/{_display_(Seq[Any](format.raw/*49.45*/("""
                """),format.raw/*50.17*/("""<span class="muted">0 parent</span>
              """)))}),format.raw/*51.16*/("""
              """),_display_(/*52.16*/if(commit.parents.size == 1)/*52.44*/{_display_(Seq[Any](format.raw/*52.45*/("""
                """),format.raw/*53.17*/("""<span class="muted">1 parent</span>
                <a href=""""),_display_(/*54.27*/url(repository)),format.raw/*54.42*/("""/commit/"""),_display_(/*54.51*/commit/*54.57*/.parents(0)),format.raw/*54.68*/("""" class="commit-id">"""),_display_(/*54.89*/commit/*54.95*/.parents(0).substring(0, 7)),format.raw/*54.122*/("""</a>
              """)))}),format.raw/*55.16*/("""
              """),format.raw/*56.15*/("""<span class="muted">commit</span> """),_display_(/*56.50*/commit/*56.56*/.id),format.raw/*56.59*/("""
            """),format.raw/*57.13*/("""</div>
            """),_display_(/*58.14*/if(commit.parents.size > 1)/*58.41*/{_display_(Seq[Any](format.raw/*58.42*/("""
              """),format.raw/*59.15*/("""<div>
                <span class="muted">"""),_display_(/*60.38*/commit/*60.44*/.parents.size),format.raw/*60.57*/(""" """),format.raw/*60.58*/("""parents
                """),_display_(/*61.18*/commit/*61.24*/.parents.map/*61.36*/ { parent =>_display_(Seq[Any](format.raw/*61.48*/("""
                  """),format.raw/*62.19*/("""<a href=""""),_display_(/*62.29*/url(repository)),format.raw/*62.44*/("""/commit/"""),_display_(/*62.53*/parent),format.raw/*62.59*/("""" class="commit-id">"""),_display_(/*62.80*/parent/*62.86*/.substring(0, 7)),format.raw/*62.102*/("""</a>
                """)))}/*63.18*/.mkHtml(" + ")),format.raw/*63.32*/("""
                """),format.raw/*64.17*/("""</span>
              </div>
            """)))}),format.raw/*66.14*/("""
          """),format.raw/*67.11*/("""</div>

          <div class="author-info">
            <div class="author">
              """),_display_(/*71.16*/avatar(commit, 20)),format.raw/*71.34*/("""
              """),format.raw/*72.15*/("""<span>"""),_display_(/*72.22*/user(commit.authorName, commit.authorEmailAddress, "username strong")),format.raw/*72.91*/("""</span>
              <span class="muted">authored """),_display_(/*73.45*/helper/*73.51*/.html.datetimeago(commit.authorTime)),format.raw/*73.87*/("""</span>
            </div>
            """),_display_(/*75.14*/if(commit.isDifferentFromAuthor)/*75.46*/ {_display_(Seq[Any](format.raw/*75.48*/("""
            """),format.raw/*76.13*/("""<div class="committer">
              <span class="icon-arrow-right"></span>
              <span>"""),_display_(/*78.22*/user(commit.committerName, commit.committerEmailAddress, "username strong")),format.raw/*78.97*/("""</span>
              <span class="muted"> committed """),_display_(/*79.47*/helper/*79.53*/.html.datetimeago(commit.commitTime)),format.raw/*79.89*/("""</span>
            </div>
            """)))}),format.raw/*81.14*/("""
          """),format.raw/*82.11*/("""</div>
        </td>
      </tr>
    </table>
    """),_display_(/*86.6*/helper/*86.12*/.html.diff(diffs, repository, Some(commit.id), oldCommitId, true, None, hasWritePermission, true)),format.raw/*86.109*/("""
    """),format.raw/*87.5*/("""<label class="checkbox">
      <input type="checkbox" id="show-notes"> Show line notes below
    </label>
    <div id="comment-list">
      """),_display_(/*91.8*/issues/*91.14*/.html.commentlist(None, comments, hasWritePermission, repository, None)),format.raw/*91.85*/("""
    """),format.raw/*92.5*/("""</div>
    """),_display_(/*93.6*/commentform(commitId = commitId, hasWritePermission = hasWritePermission, repository = repository)),format.raw/*93.104*/("""
  """)))}),format.raw/*94.4*/("""
""")))}),format.raw/*95.2*/("""
"""),format.raw/*96.1*/("""<script>
$(function()"""),format.raw/*97.13*/("""{"""),format.raw/*97.14*/("""
  """),format.raw/*98.3*/("""$('a.branch:first, a.tag:first').css("""),format.raw/*98.40*/("""{"""),format.raw/*98.41*/("""
    """),format.raw/*99.5*/("""'font-weight': 'bold',
    'color': '#555555'
  """),format.raw/*101.3*/("""}"""),format.raw/*101.4*/(""");

  """),_display_(/*103.4*/if(branches.size > 5)/*103.25*/{_display_(Seq[Any](format.raw/*103.26*/("""
    """),format.raw/*104.5*/("""// hide branches
    """),_display_(/*105.6*/for(i <- 1 to branches.size - 2) yield /*105.38*/{_display_(Seq[Any](format.raw/*105.39*/("""
      """),format.raw/*106.7*/("""$('#branch-"""),_display_(/*106.19*/i),format.raw/*106.20*/("""').hide();
    """)))}),format.raw/*107.6*/("""
    """),format.raw/*108.5*/("""// add omit link
    $('#branch-"""),_display_(/*109.17*/(branches.size - 1)),format.raw/*109.36*/("""').before(
      $('<a href="javascript:void(0);" class="omit">...</a>').click(function()"""),format.raw/*110.79*/("""{"""),format.raw/*110.80*/("""
        """),_display_(/*111.10*/for(i <- 1 to branches.size - 2) yield /*111.42*/{_display_(Seq[Any](format.raw/*111.43*/("""
          """),format.raw/*112.11*/("""$('#branch-"""),_display_(/*112.23*/i),format.raw/*112.24*/("""').show();
          this.remove();
        """)))}),format.raw/*114.10*/("""
      """),format.raw/*115.7*/("""}"""),format.raw/*115.8*/(""")
    );
  """)))}),format.raw/*117.4*/("""

  """),_display_(/*119.4*/if(tags.size > 5)/*119.21*/{_display_(Seq[Any](format.raw/*119.22*/("""
    """),format.raw/*120.5*/("""// hide tags
    """),_display_(/*121.6*/for(i <- 1 to tags.size - 2) yield /*121.34*/{_display_(Seq[Any](format.raw/*121.35*/("""
      """),format.raw/*122.7*/("""$('#tag-"""),_display_(/*122.16*/i),format.raw/*122.17*/("""').hide();
    """)))}),format.raw/*123.6*/("""
    """),format.raw/*124.5*/("""// add omit link
    $('#tag-"""),_display_(/*125.14*/(tags.size - 1)),format.raw/*125.29*/("""').before(
      $('<a href="javascript:void(0);" class="omit">...</a>').click(function()"""),format.raw/*126.79*/("""{"""),format.raw/*126.80*/("""
        """),_display_(/*127.10*/for(i <- 1 to tags.size - 2) yield /*127.38*/{_display_(Seq[Any](format.raw/*127.39*/("""
          """),format.raw/*128.11*/("""$('#tag-"""),_display_(/*128.20*/i),format.raw/*128.21*/("""').show();
          this.remove();
        """)))}),format.raw/*130.10*/("""
      """),format.raw/*131.7*/("""}"""),format.raw/*131.8*/(""")
    );
  """)))}),format.raw/*133.4*/("""

  """),format.raw/*135.3*/("""$('#show-notes').change(function() """),format.raw/*135.38*/("""{"""),format.raw/*135.39*/("""
    """),format.raw/*136.5*/("""if (this.checked) """),format.raw/*136.23*/("""{"""),format.raw/*136.24*/("""
      """),format.raw/*137.7*/("""$('.inline-comment').show();
    """),format.raw/*138.5*/("""}"""),format.raw/*138.6*/(""" """),format.raw/*138.7*/("""else """),format.raw/*138.12*/("""{"""),format.raw/*138.13*/("""
      """),format.raw/*139.7*/("""$('.inline-comment').hide();
      $('.diff .inline-comment').show();
    """),format.raw/*141.5*/("""}"""),format.raw/*141.6*/("""
  """),format.raw/*142.3*/("""}"""),format.raw/*142.4*/(""");
"""),format.raw/*143.1*/("""}"""),format.raw/*143.2*/(""");
</script>
<style type="text/css">
a.branch, a.tag """),format.raw/*146.17*/("""{"""),format.raw/*146.18*/("""
  """),format.raw/*147.3*/("""color: #888888;
  margin-right: 4px;
"""),format.raw/*149.1*/("""}"""),format.raw/*149.2*/("""

"""),format.raw/*151.1*/("""a.omit """),format.raw/*151.8*/("""{"""),format.raw/*151.9*/("""
  """),format.raw/*152.3*/("""margin-right: 4px;
"""),format.raw/*153.1*/("""}"""),format.raw/*153.2*/("""
"""),format.raw/*154.1*/("""</style>
"""))}
  }

  def render(commitId:String,commit:util.JGitUtil.CommitInfo,branches:List[String],tags:List[String],comments:List[model.Comment],repository:service.RepositoryService.RepositoryInfo,diffs:Seq[util.JGitUtil.DiffInfo],oldCommitId:Option[String],hasWritePermission:Boolean,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(commitId,commit,branches,tags,comments,repository,diffs,oldCommitId,hasWritePermission)(context)

  def f:((String,util.JGitUtil.CommitInfo,List[String],List[String],List[model.Comment],service.RepositoryService.RepositoryInfo,Seq[util.JGitUtil.DiffInfo],Option[String],Boolean) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (commitId,commit,branches,tags,comments,repository,diffs,oldCommitId,hasWritePermission) => (context) => apply(commitId,commit,branches,tags,comments,repository,diffs,oldCommitId,hasWritePermission)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/repo/commit.scala.html
                  HASH: b55f1c3397bb4b56a38392b3a67b907794526dd1
                  MATRIX: 519->1|991->323|1019->391|1031->395|1084->439|1123->440|1153->444|1165->448|1199->473|1238->474|1270->479|1427->609|1463->624|1497->631|1512->637|1536->640|1655->732|1708->764|1753->782|1794->814|1833->815|1874->828|1934->861|1995->901|2044->919|2083->930|2172->992|2202->1013|2241->1014|2284->1029|2359->1077|2386->1083|2459->1129|2476->1137|2502->1154|2562->1176|2609->1195|2646->1205|2682->1220|2716->1227|2758->1248|2815->1277|2838->1278|2869->1281|2897->1287|2950->1309|2993->1324|3045->1345|3086->1359|3112->1376|3151->1377|3194->1392|3269->1440|3296->1446|3366->1489|3379->1493|3405->1510|3462->1529|3509->1548|3546->1558|3582->1573|3616->1580|3640->1583|3690->1606|3712->1607|3742->1610|3766->1613|3819->1635|3862->1650|3914->1671|3953->1682|4148->1850|4185->1878|4224->1879|4269->1896|4351->1947|4394->1963|4431->1991|4470->1992|4515->2009|4604->2071|4640->2086|4676->2095|4691->2101|4723->2112|4771->2133|4786->2139|4835->2166|4886->2186|4929->2201|4991->2236|5006->2242|5030->2245|5071->2258|5118->2278|5154->2305|5193->2306|5236->2321|5306->2364|5321->2370|5355->2383|5384->2384|5436->2409|5451->2415|5472->2427|5522->2439|5569->2458|5606->2468|5642->2483|5678->2492|5705->2498|5753->2519|5768->2525|5806->2541|5847->2563|5882->2577|5927->2594|6000->2636|6039->2647|6158->2739|6197->2757|6240->2772|6274->2779|6364->2848|6443->2900|6458->2906|6515->2942|6582->2982|6623->3014|6663->3016|6704->3029|6829->3127|6925->3202|7006->3256|7021->3262|7078->3298|7149->3338|7188->3349|7265->3400|7280->3406|7399->3503|7431->3508|7598->3649|7613->3655|7705->3726|7737->3731|7775->3743|7895->3841|7929->3845|7961->3847|7989->3848|8038->3869|8067->3870|8097->3873|8162->3910|8191->3911|8223->3916|8299->3964|8328->3965|8362->3972|8393->3993|8433->3994|8466->3999|8515->4021|8564->4053|8604->4054|8639->4061|8679->4073|8702->4074|8749->4090|8782->4095|8843->4128|8884->4147|9002->4236|9032->4237|9070->4247|9119->4279|9159->4280|9199->4291|9239->4303|9262->4304|9339->4349|9374->4356|9403->4357|9446->4369|9478->4374|9505->4391|9545->4392|9578->4397|9623->4415|9668->4443|9708->4444|9743->4451|9780->4460|9803->4461|9850->4477|9883->4482|9941->4512|9978->4527|10096->4616|10126->4617|10164->4627|10209->4655|10249->4656|10289->4667|10326->4676|10349->4677|10426->4722|10461->4729|10490->4730|10533->4742|10565->4746|10629->4781|10659->4782|10692->4787|10739->4805|10769->4806|10804->4813|10865->4846|10894->4847|10923->4848|10957->4853|10987->4854|11022->4861|11124->4935|11153->4936|11184->4939|11213->4940|11244->4943|11273->4944|11355->4997|11385->4998|11416->5001|11481->5038|11510->5039|11540->5041|11575->5048|11604->5049|11635->5052|11682->5071|11711->5072|11740->5073
                  LINES: 13->1|26->9|27->13|27->13|27->13|27->13|28->14|28->14|28->14|28->14|29->15|33->19|33->19|33->19|33->19|33->19|35->21|35->21|36->22|36->22|36->22|37->23|37->23|37->23|38->24|39->25|40->26|40->26|40->26|41->27|42->28|42->28|43->29|43->29|43->29|43->29|44->30|44->30|44->30|44->30|44->30|44->30|44->30|44->30|44->30|45->31|46->32|47->33|48->34|48->34|48->34|49->35|50->36|50->36|51->37|51->37|51->37|51->37|52->38|52->38|52->38|52->38|52->38|52->38|52->38|52->38|52->38|53->39|54->40|55->41|56->42|63->49|63->49|63->49|64->50|65->51|66->52|66->52|66->52|67->53|68->54|68->54|68->54|68->54|68->54|68->54|68->54|68->54|69->55|70->56|70->56|70->56|70->56|71->57|72->58|72->58|72->58|73->59|74->60|74->60|74->60|74->60|75->61|75->61|75->61|75->61|76->62|76->62|76->62|76->62|76->62|76->62|76->62|76->62|77->63|77->63|78->64|80->66|81->67|85->71|85->71|86->72|86->72|86->72|87->73|87->73|87->73|89->75|89->75|89->75|90->76|92->78|92->78|93->79|93->79|93->79|95->81|96->82|100->86|100->86|100->86|101->87|105->91|105->91|105->91|106->92|107->93|107->93|108->94|109->95|110->96|111->97|111->97|112->98|112->98|112->98|113->99|115->101|115->101|117->103|117->103|117->103|118->104|119->105|119->105|119->105|120->106|120->106|120->106|121->107|122->108|123->109|123->109|124->110|124->110|125->111|125->111|125->111|126->112|126->112|126->112|128->114|129->115|129->115|131->117|133->119|133->119|133->119|134->120|135->121|135->121|135->121|136->122|136->122|136->122|137->123|138->124|139->125|139->125|140->126|140->126|141->127|141->127|141->127|142->128|142->128|142->128|144->130|145->131|145->131|147->133|149->135|149->135|149->135|150->136|150->136|150->136|151->137|152->138|152->138|152->138|152->138|152->138|153->139|155->141|155->141|156->142|156->142|157->143|157->143|160->146|160->146|161->147|163->149|163->149|165->151|165->151|165->151|166->152|167->153|167->153|168->154
                  -- GENERATED --
              */
          