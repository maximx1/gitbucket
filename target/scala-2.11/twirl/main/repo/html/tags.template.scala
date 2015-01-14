
package repo.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object tags extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*1.87*/("""
"""),_display_(/*4.2*/html/*4.6*/.main(s"${repository.owner}/${repository.name}", Some(repository))/*4.72*/ {_display_(Seq[Any](format.raw/*4.74*/("""
  """),_display_(/*5.4*/html/*5.8*/.menu("code", repository)/*5.33*/{_display_(Seq[Any](format.raw/*5.34*/("""
    """),format.raw/*6.5*/("""<h1>Tags</h1>
    <table class="table table-bordered">
      <tr>
        <th width="40%">Tag</th>
        <th width="20%">Date</th>
        <th width="20%">Commit</th>
        <th width="20%">Download</th>
      </tr>
      """),_display_(/*14.8*/repository/*14.18*/.tags.reverse.map/*14.35*/ { tag =>_display_(Seq[Any](format.raw/*14.44*/("""
        """),format.raw/*15.9*/("""<tr>
          <td><a href=""""),_display_(/*16.25*/url(repository)),format.raw/*16.40*/("""/tree/"""),_display_(/*16.47*/encodeRefName(tag.name)),format.raw/*16.70*/("""">"""),_display_(/*16.73*/tag/*16.76*/.name),format.raw/*16.81*/("""</a></td>
          <td>"""),_display_(/*17.16*/helper/*17.22*/.html.datetimeago(tag.time, false)),format.raw/*17.56*/("""</td>
          <td class="monospace"><a href=""""),_display_(/*18.43*/url(repository)),format.raw/*18.58*/("""/commit/"""),_display_(/*18.67*/tag/*18.70*/.id),format.raw/*18.73*/("""">"""),_display_(/*18.76*/tag/*18.79*/.id.substring(0, 10)),format.raw/*18.99*/("""</a></td>
          <td>
              <a href=""""),_display_(/*20.25*/url(repository)),format.raw/*20.40*/("""/archive/"""),_display_(/*20.50*/{encodeRefName(tag.name)}),format.raw/*20.75*/(""".zip">ZIP</a>
              <a href=""""),_display_(/*21.25*/url(repository)),format.raw/*21.40*/("""/archive/"""),_display_(/*21.50*/{encodeRefName(tag.name)}),format.raw/*21.75*/(""".tar.gz">TAR.GZ</a>
          </td>
        </tr>
      """)))}),format.raw/*24.8*/("""
    """),format.raw/*25.5*/("""</table>
  """)))}),format.raw/*26.4*/("""
""")))}))}
  }

  def render(repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository)(context)

  def f:((service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository) => (context) => apply(repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/repo/tags.scala.html
                  HASH: 856c25dfac3a4bbb19bd13b89a40534e42f12a3f
                  MATRIX: 387->1|598->86|625->129|636->133|710->199|749->201|778->205|789->209|822->234|860->235|891->240|1143->466|1162->476|1188->493|1235->502|1271->511|1327->540|1363->555|1397->562|1441->585|1471->588|1483->591|1509->596|1561->621|1576->627|1631->661|1706->709|1742->724|1778->733|1790->736|1814->739|1844->742|1856->745|1897->765|1973->814|2009->829|2046->839|2092->864|2157->902|2193->917|2230->927|2276->952|2363->1009|2395->1014|2437->1026
                  LINES: 13->1|17->1|18->4|18->4|18->4|18->4|19->5|19->5|19->5|19->5|20->6|28->14|28->14|28->14|28->14|29->15|30->16|30->16|30->16|30->16|30->16|30->16|30->16|31->17|31->17|31->17|32->18|32->18|32->18|32->18|32->18|32->18|32->18|32->18|34->20|34->20|34->20|34->20|35->21|35->21|35->21|35->21|38->24|39->25|40->26
                  -- GENERATED --
              */
          