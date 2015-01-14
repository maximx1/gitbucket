
package repo.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object delete extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[String,service.RepositoryService.RepositoryInfo,List[String],String,util.JGitUtil.ContentInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(branch: String,
  repository: service.RepositoryService.RepositoryInfo,
  pathList: List[String],
  fileName: String,
  content: util.JGitUtil.ContentInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*5.69*/("""
"""),_display_(/*8.2*/html/*8.6*/.main(s"Deleting ${path} at ${fileName} - ${repository.owner}/${repository.name}", Some(repository))/*8.106*/ {_display_(Seq[Any](format.raw/*8.108*/("""
  """),_display_(/*9.4*/html/*9.8*/.menu("code", repository)/*9.33*/{_display_(Seq[Any](format.raw/*9.34*/("""
    """),format.raw/*10.5*/("""<form method="POST" action=""""),_display_(/*10.34*/url(repository)),format.raw/*10.49*/("""/remove" validate="true">
      <div class="head">
        <a href=""""),_display_(/*12.19*/url(repository)),format.raw/*12.34*/("""/tree/"""),_display_(/*12.41*/encodeRefName(branch)),format.raw/*12.62*/("""">"""),_display_(/*12.65*/repository/*12.75*/.name),format.raw/*12.80*/("""</a> /
        """),_display_(/*13.10*/pathList/*13.18*/.zipWithIndex.map/*13.35*/ { case (section, i) =>_display_(Seq[Any](format.raw/*13.58*/("""
          """),format.raw/*14.11*/("""<a href=""""),_display_(/*14.21*/url(repository)),format.raw/*14.36*/("""/tree/"""),_display_(/*14.43*/encodeRefName(branch)),format.raw/*14.64*/("""/"""),_display_(/*14.66*/pathList/*14.74*/.take(i + 1).mkString("/")),format.raw/*14.100*/("""">"""),_display_(/*14.103*/section),format.raw/*14.110*/("""</a> /
        """)))}),format.raw/*15.10*/("""
        """),_display_(/*16.10*/fileName),format.raw/*16.18*/("""
        """),format.raw/*17.9*/("""<input type="hidden" name="fileName" id="fileName" value=""""),_display_(/*17.68*/fileName),format.raw/*17.76*/(""""/>
        <input type="hidden" name="branch" id="branch" value=""""),_display_(/*18.64*/branch),format.raw/*18.70*/(""""/>
        <input type="hidden" name="path" id="path" value=""""),_display_(/*19.60*/pathList/*19.68*/.mkString("/")),format.raw/*19.82*/(""""/>
      </div>
      <table class="table table-bordered">
        <th style="font-weight: normal;" class="box-header">
          """),_display_(/*23.12*/fileName),format.raw/*23.20*/("""
          """),format.raw/*24.11*/("""<div class="pull-right align-right">
            <a href=""""),_display_(/*25.23*/url(repository)),format.raw/*25.38*/("""/blob/"""),_display_(/*25.45*/branch),format.raw/*25.51*/("""/"""),_display_(/*25.53*/{(pathList ::: List(fileName)).mkString("/")}),format.raw/*25.98*/("""" class="btn btn-small">View</a>
          </div>
        </th>
        <tr>
          <td>
            <div id="diffText"></div>
            <textarea id="newText" style="display: none;"></textarea>
            <textarea id="oldText" style="display: none;">"""),_display_(/*32.60*/content/*32.67*/.content),format.raw/*32.75*/("""</textarea>
          </td>
        </tr>
      </table>
      <div class="issue-avatar-image">"""),_display_(/*36.40*/avatar(loginAccount.get.userName, 48)),format.raw/*36.77*/("""</div>
        <div class="box issue-comment-box">
        <div class="box-content">
          <div>
            <strong>Commit changes</strong>
          </div>
          <div>
            <input type="text" name="message" style="width: 98%;"/>
          </div>
          <div style="text-align: right;">
            <a href=""""),_display_(/*46.23*/url(repository)),format.raw/*46.38*/("""/blob/"""),_display_(/*46.45*/encodeRefName(branch)),format.raw/*46.66*/("""/"""),_display_(/*46.68*/pathList/*46.76*/.mkString("/")),format.raw/*46.90*/("""" class="btn btn-danger">Cancel</a>
            <input type="submit" id="commit" class="btn btn-success" value="Commit changes"/>
          </div>
        </div>
      </div>
    </form>
  """)))}),format.raw/*52.4*/("""
""")))}),format.raw/*53.2*/("""
"""),format.raw/*54.1*/("""<script type="text/javascript" src=""""),_display_(/*54.38*/assets),format.raw/*54.44*/("""/vendors/jsdifflib/difflib.js"></script>
<script type="text/javascript" src=""""),_display_(/*55.38*/assets),format.raw/*55.44*/("""/vendors/jsdifflib/diffview.js"></script>
<link href=""""),_display_(/*56.14*/assets),format.raw/*56.20*/("""/vendors/jsdifflib/diffview.css" type="text/css" rel="stylesheet" />
<script>
$(function()"""),format.raw/*58.13*/("""{"""),format.raw/*58.14*/("""
  """),format.raw/*59.3*/("""diffUsingJS('oldText', 'newText', 'diffText', 1);
"""),format.raw/*60.1*/("""}"""),format.raw/*60.2*/(""");
</script>"""))}
  }

  def render(branch:String,repository:service.RepositoryService.RepositoryInfo,pathList:List[String],fileName:String,content:util.JGitUtil.ContentInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(branch,repository,pathList,fileName,content)(context)

  def f:((String,service.RepositoryService.RepositoryInfo,List[String],String,util.JGitUtil.ContentInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (branch,repository,pathList,fileName,content) => (context) => apply(branch,repository,pathList,fileName,content)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/repo/delete.scala.html
                  HASH: 1f5ddcf2295a0cf4471ec9b74acf16f8b6858510
                  MATRIX: 442->1|755->188|782->231|793->235|902->335|942->337|971->341|982->345|1015->370|1053->371|1085->376|1141->405|1177->420|1273->489|1309->504|1343->511|1385->532|1415->535|1434->545|1460->550|1503->566|1520->574|1546->591|1607->614|1646->625|1683->635|1719->650|1753->657|1795->678|1824->680|1841->688|1889->714|1920->717|1949->724|1996->740|2033->750|2062->758|2098->767|2184->826|2213->834|2307->901|2334->907|2424->970|2441->978|2476->992|2635->1124|2664->1132|2703->1143|2789->1202|2825->1217|2859->1224|2886->1230|2915->1232|2981->1277|3267->1536|3283->1543|3312->1551|3435->1647|3493->1684|3848->2012|3884->2027|3918->2034|3960->2055|3989->2057|4006->2065|4041->2079|4261->2269|4293->2271|4321->2272|4385->2309|4412->2315|4517->2393|4544->2399|4626->2454|4653->2460|4771->2550|4800->2551|4830->2554|4907->2604|4935->2605
                  LINES: 13->1|21->5|22->8|22->8|22->8|22->8|23->9|23->9|23->9|23->9|24->10|24->10|24->10|26->12|26->12|26->12|26->12|26->12|26->12|26->12|27->13|27->13|27->13|27->13|28->14|28->14|28->14|28->14|28->14|28->14|28->14|28->14|28->14|28->14|29->15|30->16|30->16|31->17|31->17|31->17|32->18|32->18|33->19|33->19|33->19|37->23|37->23|38->24|39->25|39->25|39->25|39->25|39->25|39->25|46->32|46->32|46->32|50->36|50->36|60->46|60->46|60->46|60->46|60->46|60->46|60->46|66->52|67->53|68->54|68->54|68->54|69->55|69->55|70->56|70->56|72->58|72->58|73->59|74->60|74->60
                  -- GENERATED --
              */
          