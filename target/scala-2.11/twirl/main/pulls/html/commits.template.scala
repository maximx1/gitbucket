
package pulls.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object commits extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[Seq[Seq[util.JGitUtil.CommitInfo]],Option[List[model.Comment]],service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(commits: Seq[Seq[util.JGitUtil.CommitInfo]],
  comments: Option[List[model.Comment]] = None,
  repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*3.87*/("""
"""),format.raw/*6.1*/("""<div class="box">
  <table class="table table-file-list" style="border: 1px solid silver;">
    """),_display_(/*8.6*/commits/*8.13*/.map/*8.17*/ { day =>_display_(Seq[Any](format.raw/*8.26*/("""
      """),format.raw/*9.7*/("""<tr>
        <th colspan="3" class="box-header" style="font-weight: normal;">"""),_display_(/*10.74*/date(day.head.commitTime)),format.raw/*10.99*/("""</th>
      </tr>
      """),_display_(/*12.8*/day/*12.11*/.map/*12.15*/ { commit =>_display_(Seq[Any](format.raw/*12.27*/("""
        """),format.raw/*13.9*/("""<tr>
          <td style="width: 20%;">
            """),_display_(/*15.14*/avatar(commit, 20)),format.raw/*15.32*/("""
            """),_display_(/*16.14*/user(commit.authorName, commit.authorEmailAddress, "username")),format.raw/*16.76*/("""
          """),format.raw/*17.11*/("""</td>
          <td>"""),_display_(/*18.16*/commit/*18.22*/.shortMessage),format.raw/*18.35*/("""</td>
          <td style="width: 10%; text-align: right">
            <span class="badge" style="display: inline">"""),_display_(/*20.58*/if(comments.isDefined)/*20.80*/{_display_(Seq[Any](format.raw/*20.81*/("""
              """),_display_(/*21.16*/comments/*21.24*/.get.flatMap{/*21.38*/{
                case comment: model.CommitComment => Some(comment)
                case other => None
              }}/*24.16*/.count(t => t.commitId == commit.id && !t.pullRequest)),format.raw/*24.70*/("""
            """)))}),format.raw/*25.14*/("""</span>
          </td>
          <td style="width: 10%; text-align: right;">
            <a href=""""),_display_(/*28.23*/url(repository)),format.raw/*28.38*/("""/commit/"""),_display_(/*28.47*/commit/*28.53*/.id),format.raw/*28.56*/("""" class="monospace">"""),_display_(/*28.77*/commit/*28.83*/.id.substring(0, 7)),format.raw/*28.102*/("""</a>
          </td>
        </tr>
      """)))}),format.raw/*31.8*/("""
    """)))}),format.raw/*32.6*/("""
  """),format.raw/*33.3*/("""</table>
</div>
"""))}
  }

  def render(commits:Seq[Seq[util.JGitUtil.CommitInfo]],comments:Option[List[model.Comment]],repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(commits,comments,repository)(context)

  def f:((Seq[Seq[util.JGitUtil.CommitInfo]],Option[List[model.Comment]],service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (commits,comments,repository) => (context) => apply(commits,comments,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/pulls/commits.scala.html
                  HASH: 0fc65a00fad1c4007c59f846661d7a83f4d429c3
                  MATRIX: 454->1|760->181|787->223|909->320|924->327|936->331|982->340|1015->347|1120->425|1166->450|1217->475|1229->478|1242->482|1292->494|1328->503|1408->556|1447->574|1488->588|1571->650|1610->661|1658->682|1673->688|1707->701|1850->817|1881->839|1920->840|1963->856|1980->864|2002->878|2131->997|2206->1051|2251->1065|2378->1165|2414->1180|2450->1189|2465->1195|2489->1198|2537->1219|2552->1225|2593->1244|2665->1286|2701->1292|2731->1295
                  LINES: 13->1|19->3|20->6|22->8|22->8|22->8|22->8|23->9|24->10|24->10|26->12|26->12|26->12|26->12|27->13|29->15|29->15|30->16|30->16|31->17|32->18|32->18|32->18|34->20|34->20|34->20|35->21|35->21|35->21|38->24|38->24|39->25|42->28|42->28|42->28|42->28|42->28|42->28|42->28|42->28|45->31|46->32|47->33
                  -- GENERATED --
              */
          