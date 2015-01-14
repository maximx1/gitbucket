
package repo.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object editor extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[String,service.RepositoryService.RepositoryInfo,List[String],Option[String],util.JGitUtil.ContentInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(branch: String,
  repository: service.RepositoryService.RepositoryInfo,
  pathList: List[String],
  fileName: Option[String],
  content: util.JGitUtil.ContentInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*5.69*/("""
"""),_display_(/*8.2*/html/*8.6*/.main(if(fileName.isEmpty) "New File" else s"Editing ${fileName.get} at ${branch} - ${repository.owner}/${repository.name}", Some(repository))/*8.148*/ {_display_(Seq[Any](format.raw/*8.150*/("""
  """),_display_(/*9.4*/html/*9.8*/.menu("code", repository)/*9.33*/{_display_(Seq[Any](format.raw/*9.34*/("""
    """),format.raw/*10.5*/("""<form method="POST" action=""""),_display_(/*10.34*/url(repository)),format.raw/*10.49*/("""/"""),_display_(/*10.51*/if(fileName.isEmpty)/*10.71*/{_display_(Seq[Any](format.raw/*10.72*/("""create""")))}/*10.79*/else/*10.83*/{_display_(Seq[Any](format.raw/*10.84*/("""update""")))}),format.raw/*10.91*/("""" validate="true">
      <span class="error" id="error-newFileName"></span>
      <div class="head">
        <a href=""""),_display_(/*13.19*/url(repository)),format.raw/*13.34*/("""/tree/"""),_display_(/*13.41*/encodeRefName(branch)),format.raw/*13.62*/("""">"""),_display_(/*13.65*/repository/*13.75*/.name),format.raw/*13.80*/("""</a> /
        """),_display_(/*14.10*/pathList/*14.18*/.zipWithIndex.map/*14.35*/ { case (section, i) =>_display_(Seq[Any](format.raw/*14.58*/("""
          """),format.raw/*15.11*/("""<a href=""""),_display_(/*15.21*/url(repository)),format.raw/*15.36*/("""/tree/"""),_display_(/*15.43*/encodeRefName(branch)),format.raw/*15.64*/("""/"""),_display_(/*15.66*/pathList/*15.74*/.take(i + 1).mkString("/")),format.raw/*15.100*/("""">"""),_display_(/*15.103*/section),format.raw/*15.110*/("""</a> /
        """)))}),format.raw/*16.10*/("""
        """),format.raw/*17.9*/("""<input type="text" name="newFileName" id="newFileName" placeholder="Name your file..." value=""""),_display_(/*17.104*/fileName),format.raw/*17.112*/(""""/>
        <input type="hidden" name="oldFileName" id="oldFileName" value=""""),_display_(/*18.74*/fileName),format.raw/*18.82*/(""""/>
        <input type="hidden" name="branch" id="branch" value=""""),_display_(/*19.64*/branch),format.raw/*19.70*/(""""/>
        <input type="hidden" name="path" id="path" value=""""),_display_(/*20.60*/pathList/*20.68*/.mkString("/")),format.raw/*20.82*/(""""/>
      </div>
      <table class="table table-bordered">
        <tr>
          <th>
            <div class="pull-right">
              <select id="wrap" class="input-medium" style="margin-bottom: 0px; height: 26px; padding: 0px;">
                <optgroup label="Line Wrap Mode">
                  <option value="false">No wrap</option>
                  <option value="true">Soft wrap</option>
                </optgroup>
              </select>
            </div>
            <div class="btn-group" data-toggle="buttons-radio">
              <input type="button" id="btn-code" class="btn btn-default btn-small active" value="Code">
              <input type="button" id="btn-preview" class="btn btn-default btn-small" value="Preview">
            </div>
          </th>
        </tr>
        <tr>
          <td>
            <div id="editor" style="width: 100%; height: 600px;"></div>
            <div id="preview" style="width: 100%; display: none;"></div>
          </td>
        </tr>
      </table>
      <div class="issue-avatar-image">"""),_display_(/*46.40*/avatar(loginAccount.get.userName, 48)),format.raw/*46.77*/("""</div>
        <div class="box issue-comment-box">
        <div class="box-content">
          <div>
            <strong>Commit changes</strong>
          </div>
          <div>
            <input type="text" name="message" style="width: 98%;"/>
          </div>
          <div style="text-align: right;">
            """),_display_(/*56.14*/if(fileName.isEmpty)/*56.34*/{_display_(Seq[Any](format.raw/*56.35*/("""
              """),format.raw/*57.15*/("""<a href=""""),_display_(/*57.25*/url(repository)),format.raw/*57.40*/("""/tree/"""),_display_(/*57.47*/encodeRefName(branch)),format.raw/*57.68*/("""/"""),_display_(/*57.70*/{pathList.mkString("/")}),format.raw/*57.94*/("""" class="btn btn-danger">Cancel</a>
            """)))}/*58.15*/else/*58.20*/{_display_(Seq[Any](format.raw/*58.21*/("""
              """),format.raw/*59.15*/("""<a href=""""),_display_(/*59.25*/url(repository)),format.raw/*59.40*/("""/blob/"""),_display_(/*59.47*/encodeRefName(branch)),format.raw/*59.68*/("""/"""),_display_(/*59.70*/{(pathList ++ Seq(fileName.get)).mkString("/")}),format.raw/*59.117*/("""" class="btn btn-danger">Cancel</a>
            """)))}),format.raw/*60.14*/("""
            """),format.raw/*61.13*/("""<input type="submit" id="commit" class="btn btn-success" value="Commit changes" disabled="true"/>
            <input type="hidden" id="charset" name="charset" value=""""),_display_(/*62.70*/content/*62.77*/.charset),format.raw/*62.85*/(""""/>
            <input type="hidden" id="lineSeparator" name="lineSeparator" value=""""),_display_(/*63.82*/content/*63.89*/.lineSeparator),format.raw/*63.103*/(""""/>
            <input type="hidden" id="content" name="content" value=""/>
            <input type="hidden" id="initial" value=""""),_display_(/*65.55*/content/*65.62*/.content),format.raw/*65.70*/(""""/>
          </div>
        </div>
      </div>
    </form>
  """)))}),format.raw/*70.4*/("""
""")))}),format.raw/*71.2*/("""
"""),format.raw/*72.1*/("""<script src=""""),_display_(/*72.15*/assets),format.raw/*72.21*/("""/vendors/ace/ace.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src=""""),_display_(/*73.38*/assets),format.raw/*73.44*/("""/vendors/jsdifflib/difflib.js"></script>
<script type="text/javascript" src=""""),_display_(/*74.38*/assets),format.raw/*74.44*/("""/vendors/jsdifflib/diffview.js"></script>
<link href=""""),_display_(/*75.14*/assets),format.raw/*75.20*/("""/vendors/jsdifflib/diffview.css" type="text/css" rel="stylesheet" />
<script>
$(function()"""),format.raw/*77.13*/("""{"""),format.raw/*77.14*/("""
  """),format.raw/*78.3*/("""$('#editor').text($('#initial').val());
  var editor = ace.edit("editor");
  editor.setTheme("ace/theme/monokai");
  //editor.getSession().setUseWrapMode(false);

  """),_display_(/*83.4*/if(fileName.isDefined)/*83.26*/{_display_(Seq[Any](format.raw/*83.27*/("""
    """),format.raw/*84.5*/("""editor.getSession().setMode("ace/mode/"""),_display_(/*84.44*/editorType(fileName.get)),format.raw/*84.68*/("""");
  """)))}),format.raw/*85.4*/("""

  """),format.raw/*87.3*/("""editor.on('change', function()"""),format.raw/*87.33*/("""{"""),format.raw/*87.34*/("""
    """),format.raw/*88.5*/("""updateCommitButtonStatus();
  """),format.raw/*89.3*/("""}"""),format.raw/*89.4*/(""");

  function updateCommitButtonStatus()"""),format.raw/*91.38*/("""{"""),format.raw/*91.39*/("""
    """),format.raw/*92.5*/("""if(editor.getValue() == $('#initial').val() && $('#newFileName').val() == $('#oldFileName').val())"""),format.raw/*92.103*/("""{"""),format.raw/*92.104*/("""
      """),format.raw/*93.7*/("""$('#commit').attr('disabled', true);
    """),format.raw/*94.5*/("""}"""),format.raw/*94.6*/(""" """),format.raw/*94.7*/("""else """),format.raw/*94.12*/("""{"""),format.raw/*94.13*/("""
      """),format.raw/*95.7*/("""$('#commit').attr('disabled', false);
    """),format.raw/*96.5*/("""}"""),format.raw/*96.6*/("""
  """),format.raw/*97.3*/("""}"""),format.raw/*97.4*/("""

  """),format.raw/*99.3*/("""$('#wrap').change(function()"""),format.raw/*99.31*/("""{"""),format.raw/*99.32*/("""
    """),format.raw/*100.5*/("""if($('#wrap option:selected').val() == 'true')"""),format.raw/*100.51*/("""{"""),format.raw/*100.52*/("""
      """),format.raw/*101.7*/("""editor.getSession().setUseWrapMode(true);
    """),format.raw/*102.5*/("""}"""),format.raw/*102.6*/(""" """),format.raw/*102.7*/("""else """),format.raw/*102.12*/("""{"""),format.raw/*102.13*/("""
      """),format.raw/*103.7*/("""editor.getSession().setUseWrapMode(false);
    """),format.raw/*104.5*/("""}"""),format.raw/*104.6*/("""
  """),format.raw/*105.3*/("""}"""),format.raw/*105.4*/(""");

  $('#newFileName').watch(function()"""),format.raw/*107.37*/("""{"""),format.raw/*107.38*/("""
    """),format.raw/*108.5*/("""updateCommitButtonStatus();
  """),format.raw/*109.3*/("""}"""),format.raw/*109.4*/(""");

  $('#commit').click(function()"""),format.raw/*111.32*/("""{"""),format.raw/*111.33*/("""
    """),format.raw/*112.5*/("""$('#content').val(editor.getValue());
  """),format.raw/*113.3*/("""}"""),format.raw/*113.4*/(""");

  $('#btn-code').click(function()"""),format.raw/*115.34*/("""{"""),format.raw/*115.35*/("""
    """),format.raw/*116.5*/("""$('#editor').show();
    $('#preview').hide();
  """),format.raw/*118.3*/("""}"""),format.raw/*118.4*/(""");

  $('#btn-preview').click(function()"""),format.raw/*120.37*/("""{"""),format.raw/*120.38*/("""
    """),format.raw/*121.5*/("""$('#editor').hide();
    $('#preview').show()

    """),_display_(/*124.6*/if(renderableSuffixes.find(suffix => fileName.map(_.toLowerCase.endsWith(suffix)).getOrElse(false)))/*124.106*/ {_display_(Seq[Any](format.raw/*124.108*/("""
      """),format.raw/*125.7*/("""// update preview
      $('#preview').html('<img src=""""),_display_(/*126.38*/assets),format.raw/*126.44*/("""/common/images/indicator.gif"> Previewing...');
      $.post('"""),_display_(/*127.16*/url(repository)),format.raw/*127.31*/("""/_preview', """),format.raw/*127.43*/("""{"""),format.raw/*127.44*/("""
        """),format.raw/*128.9*/("""content        : editor.getValue(),
        enableWikiLink : false,
        enableRefsLink : false,
        enableTaskList : false
      """),format.raw/*132.7*/("""}"""),format.raw/*132.8*/(""", function(data)"""),format.raw/*132.24*/("""{"""),format.raw/*132.25*/("""
        """),format.raw/*133.9*/("""$('#preview').empty().append(
          $('<div class="markdown-body" style="padding-left: 16px; padding-right: 16px;">').html(data));
        prettyPrint();
      """),format.raw/*136.7*/("""}"""),format.raw/*136.8*/(""");
    """)))}/*137.7*/else/*137.12*/{_display_(Seq[Any](format.raw/*137.13*/("""
      """),format.raw/*138.7*/("""// Show diff
      $('#preview').empty()
        .append($('<div id="diffText">'))
        .append($('<textarea id="newText" style="display: none;">').html(editor.getValue()))
        .append($('<textarea id="oldText" style="display: none;">').html($('#initial').val()));
      diffUsingJS('oldText', 'newText', 'diffText', 1);
    """)))}),format.raw/*144.6*/("""
  """),format.raw/*145.3*/("""}"""),format.raw/*145.4*/(""");
"""),format.raw/*146.1*/("""}"""),format.raw/*146.2*/(""");
</script>
"""))}
  }

  def render(branch:String,repository:service.RepositoryService.RepositoryInfo,pathList:List[String],fileName:Option[String],content:util.JGitUtil.ContentInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(branch,repository,pathList,fileName,content)(context)

  def f:((String,service.RepositoryService.RepositoryInfo,List[String],Option[String],util.JGitUtil.ContentInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (branch,repository,pathList,fileName,content) => (context) => apply(branch,repository,pathList,fileName,content)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/repo/editor.scala.html
                  HASH: 51ff6ab19b4e12c0ffd93ee43c7d401ea38afe7a
                  MATRIX: 450->1|771->196|798->239|809->243|960->385|1000->387|1029->391|1040->395|1073->420|1111->421|1143->426|1199->455|1235->470|1264->472|1293->492|1332->493|1358->500|1371->504|1410->505|1448->512|1594->631|1630->646|1664->653|1706->674|1736->677|1755->687|1781->692|1824->708|1841->716|1867->733|1928->756|1967->767|2004->777|2040->792|2074->799|2116->820|2145->822|2162->830|2210->856|2241->859|2270->866|2317->882|2353->891|2476->986|2506->994|2610->1071|2639->1079|2733->1146|2760->1152|2850->1215|2867->1223|2902->1237|3977->2285|4035->2322|4381->2641|4410->2661|4449->2662|4492->2677|4529->2687|4565->2702|4599->2709|4641->2730|4670->2732|4715->2756|4783->2806|4796->2811|4835->2812|4878->2827|4915->2837|4951->2852|4985->2859|5027->2880|5056->2882|5125->2929|5205->2978|5246->2991|5440->3158|5456->3165|5485->3173|5597->3258|5613->3265|5649->3279|5806->3409|5822->3416|5851->3424|5945->3488|5977->3490|6005->3491|6046->3505|6073->3511|6207->3618|6234->3624|6339->3702|6366->3708|6448->3763|6475->3769|6593->3859|6622->3860|6652->3863|6844->4029|6875->4051|6914->4052|6946->4057|7012->4096|7057->4120|7094->4127|7125->4131|7183->4161|7212->4162|7244->4167|7301->4197|7329->4198|7398->4239|7427->4240|7459->4245|7586->4343|7616->4344|7650->4351|7718->4392|7746->4393|7774->4394|7807->4399|7836->4400|7870->4407|7939->4449|7967->4450|7997->4453|8025->4454|8056->4458|8112->4486|8141->4487|8174->4492|8249->4538|8279->4539|8314->4546|8388->4592|8417->4593|8446->4594|8480->4599|8510->4600|8545->4607|8620->4654|8649->4655|8680->4658|8709->4659|8778->4699|8808->4700|8841->4705|8899->4735|8928->4736|8992->4771|9022->4772|9055->4777|9123->4817|9152->4818|9218->4855|9248->4856|9281->4861|9358->4910|9387->4911|9456->4951|9486->4952|9519->4957|9598->5009|9709->5109|9751->5111|9786->5118|9869->5173|9897->5179|9988->5242|10025->5257|10066->5269|10096->5270|10133->5279|10298->5416|10327->5417|10372->5433|10402->5434|10439->5443|10631->5607|10660->5608|10687->5617|10701->5622|10741->5623|10776->5630|11140->5963|11171->5966|11200->5967|11231->5970|11260->5971
                  LINES: 13->1|21->5|22->8|22->8|22->8|22->8|23->9|23->9|23->9|23->9|24->10|24->10|24->10|24->10|24->10|24->10|24->10|24->10|24->10|24->10|27->13|27->13|27->13|27->13|27->13|27->13|27->13|28->14|28->14|28->14|28->14|29->15|29->15|29->15|29->15|29->15|29->15|29->15|29->15|29->15|29->15|30->16|31->17|31->17|31->17|32->18|32->18|33->19|33->19|34->20|34->20|34->20|60->46|60->46|70->56|70->56|70->56|71->57|71->57|71->57|71->57|71->57|71->57|71->57|72->58|72->58|72->58|73->59|73->59|73->59|73->59|73->59|73->59|73->59|74->60|75->61|76->62|76->62|76->62|77->63|77->63|77->63|79->65|79->65|79->65|84->70|85->71|86->72|86->72|86->72|87->73|87->73|88->74|88->74|89->75|89->75|91->77|91->77|92->78|97->83|97->83|97->83|98->84|98->84|98->84|99->85|101->87|101->87|101->87|102->88|103->89|103->89|105->91|105->91|106->92|106->92|106->92|107->93|108->94|108->94|108->94|108->94|108->94|109->95|110->96|110->96|111->97|111->97|113->99|113->99|113->99|114->100|114->100|114->100|115->101|116->102|116->102|116->102|116->102|116->102|117->103|118->104|118->104|119->105|119->105|121->107|121->107|122->108|123->109|123->109|125->111|125->111|126->112|127->113|127->113|129->115|129->115|130->116|132->118|132->118|134->120|134->120|135->121|138->124|138->124|138->124|139->125|140->126|140->126|141->127|141->127|141->127|141->127|142->128|146->132|146->132|146->132|146->132|147->133|150->136|150->136|151->137|151->137|151->137|152->138|158->144|159->145|159->145|160->146|160->146
                  -- GENERATED --
              */
          