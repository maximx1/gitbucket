
package wiki.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object compare extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template8[Option[String],String,String,Seq[util.JGitUtil.DiffInfo],service.RepositoryService.RepositoryInfo,Boolean,Option[Any],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(pageName: Option[String],
  from: String,
  to: String,
  diffs: Seq[util.JGitUtil.DiffInfo],
  repository: service.RepositoryService.RepositoryInfo,
  hasWritePermission: Boolean,
  info: Option[Any])(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._
import org.eclipse.jgit.diff.DiffEntry.ChangeType

Seq[Any](format.raw/*7.52*/("""
"""),_display_(/*11.2*/html/*11.6*/.main(s"Compare Revisions - ${repository.owner}/${repository.name}", Some(repository))/*11.92*/{_display_(Seq[Any](format.raw/*11.93*/("""
  """),_display_(/*12.4*/helper/*12.10*/.html.information(info)),format.raw/*12.33*/("""
  """),_display_(/*13.4*/html/*13.8*/.menu("wiki", repository)/*13.33*/{_display_(Seq[Any](format.raw/*13.34*/("""
    """),format.raw/*14.5*/("""<ul class="nav nav-tabs fill-width pull-left">
      <li>
        <h1 class="wiki-title"><span class="muted">Compare Revisions</span></h1>
      </li>
      <li class="pull-right">
        <div class="btn-group">
        """),_display_(/*20.10*/if(pageName.isDefined)/*20.32*/{_display_(Seq[Any](format.raw/*20.33*/("""
          """),format.raw/*21.11*/("""<a class="btn btn-small" href=""""),_display_(/*21.43*/url(repository)),format.raw/*21.58*/("""/wiki/"""),_display_(/*21.65*/urlEncode(pageName)),format.raw/*21.84*/("""">View Page</a>
          <a class="btn btn-small" href=""""),_display_(/*22.43*/url(repository)),format.raw/*22.58*/("""/wiki/"""),_display_(/*22.65*/urlEncode(pageName)),format.raw/*22.84*/("""/_history">Back to Page History</a>
        """)))}/*23.11*/else/*23.16*/{_display_(Seq[Any](format.raw/*23.17*/("""
          """),format.raw/*24.11*/("""<a class="btn btn-small" href=""""),_display_(/*24.43*/url(repository)),format.raw/*24.58*/("""/wiki/_history">Back to Wiki History</a>
        """)))}),format.raw/*25.10*/("""
        """),format.raw/*26.9*/("""</div>
      </li>
    </ul>
    """),_display_(/*29.6*/helper/*29.12*/.html.diff(diffs, repository, None, None, false, None, false, false)),format.raw/*29.80*/("""
    """),_display_(/*30.6*/if(hasWritePermission)/*30.28*/{_display_(Seq[Any](format.raw/*30.29*/("""
      """),format.raw/*31.7*/("""<div>
        """),_display_(/*32.10*/if(pageName.isDefined)/*32.32*/{_display_(Seq[Any](format.raw/*32.33*/("""
          """),format.raw/*33.11*/("""<a href=""""),_display_(/*33.21*/url(repository)),format.raw/*33.36*/("""/wiki/"""),_display_(/*33.43*/urlEncode(pageName)),format.raw/*33.62*/("""/_revert/"""),_display_(/*33.72*/from),format.raw/*33.76*/("""..."""),_display_(/*33.80*/to),format.raw/*33.82*/("""" class="btn">Revert Changes</a>
        """)))}/*34.11*/else/*34.16*/{_display_(Seq[Any](format.raw/*34.17*/("""
          """),format.raw/*35.11*/("""<a href=""""),_display_(/*35.21*/url(repository)),format.raw/*35.36*/("""/wiki/_revert/"""),_display_(/*35.51*/from),format.raw/*35.55*/("""..."""),_display_(/*35.59*/to),format.raw/*35.61*/("""" class="btn">Revert Changes</a>
        """)))}),format.raw/*36.10*/("""
      """),format.raw/*37.7*/("""</div>
    """)))}),format.raw/*38.6*/("""
  """)))}),format.raw/*39.4*/("""
""")))}),format.raw/*40.2*/("""
"""))}
  }

  def render(pageName:Option[String],from:String,to:String,diffs:Seq[util.JGitUtil.DiffInfo],repository:service.RepositoryService.RepositoryInfo,hasWritePermission:Boolean,info:Option[Any],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(pageName,from,to,diffs,repository,hasWritePermission,info)(context)

  def f:((Option[String],String,String,Seq[util.JGitUtil.DiffInfo],service.RepositoryService.RepositoryInfo,Boolean,Option[Any]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (pageName,from,to,diffs,repository,hasWritePermission,info) => (context) => apply(pageName,from,to,diffs,repository,hasWritePermission,info)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/wiki/compare.scala.html
                  HASH: 457c8ea4297a7f328828ec62430378bfe43157a9
                  MATRIX: 467->1|876->234|904->328|916->332|1011->418|1050->419|1080->423|1095->429|1139->452|1169->456|1181->460|1215->485|1254->486|1286->491|1535->713|1566->735|1605->736|1644->747|1703->779|1739->794|1773->801|1813->820|1898->878|1934->893|1968->900|2008->919|2072->965|2085->970|2124->971|2163->982|2222->1014|2258->1029|2339->1079|2375->1088|2435->1122|2450->1128|2539->1196|2571->1202|2602->1224|2641->1225|2675->1232|2717->1247|2748->1269|2787->1270|2826->1281|2863->1291|2899->1306|2933->1313|2973->1332|3010->1342|3035->1346|3066->1350|3089->1352|3150->1395|3163->1400|3202->1401|3241->1412|3278->1422|3314->1437|3356->1452|3381->1456|3412->1460|3435->1462|3508->1504|3542->1511|3584->1523|3618->1527|3650->1529
                  LINES: 13->1|24->7|25->11|25->11|25->11|25->11|26->12|26->12|26->12|27->13|27->13|27->13|27->13|28->14|34->20|34->20|34->20|35->21|35->21|35->21|35->21|35->21|36->22|36->22|36->22|36->22|37->23|37->23|37->23|38->24|38->24|38->24|39->25|40->26|43->29|43->29|43->29|44->30|44->30|44->30|45->31|46->32|46->32|46->32|47->33|47->33|47->33|47->33|47->33|47->33|47->33|47->33|47->33|48->34|48->34|48->34|49->35|49->35|49->35|49->35|49->35|49->35|49->35|50->36|51->37|52->38|53->39|54->40
                  -- GENERATED --
              */
          