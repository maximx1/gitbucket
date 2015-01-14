
package wiki.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object history extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[Option[String],List[util.JGitUtil.CommitInfo],service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(pageName: Option[String],
  commits: List[util.JGitUtil.CommitInfo],
  repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*3.87*/("""
"""),_display_(/*6.2*/html/*6.6*/.main(s"History - ${repository.owner}/${repository.name}", Some(repository))/*6.82*/{_display_(Seq[Any](format.raw/*6.83*/("""
  """),_display_(/*7.4*/html/*7.8*/.menu("wiki", repository)/*7.33*/{_display_(Seq[Any](format.raw/*7.34*/("""
    """),format.raw/*8.5*/("""<ul class="nav nav-tabs fill-width pull-left">
      <li>
        <h1 class="wiki-title">
          """),_display_(/*11.12*/if(pageName.isEmpty)/*11.32*/{_display_(Seq[Any](format.raw/*11.33*/("""
            """),format.raw/*12.13*/("""<span class="muted">History</span>
          """)))}/*13.13*/else/*13.18*/{_display_(Seq[Any](format.raw/*13.19*/("""
            """),format.raw/*14.13*/("""<span class="muted">History for</span> """),_display_(/*14.53*/pageName/*14.61*/.get),format.raw/*14.65*/("""
          """)))}),format.raw/*15.12*/("""
        """),format.raw/*16.9*/("""</h1>
      </li>
      <li class="pull-right">
        <div>
          """),_display_(/*20.12*/if(pageName.isEmpty)/*20.32*/{_display_(Seq[Any](format.raw/*20.33*/("""
            """),_display_(/*21.14*/if(loginAccount.isDefined)/*21.40*/{_display_(Seq[Any](format.raw/*21.41*/("""
              """),format.raw/*22.15*/("""<a class="btn btn-small" href=""""),_display_(/*22.47*/url(repository)),format.raw/*22.62*/("""/wiki/_new">New Page</a>
            """)))}),format.raw/*23.14*/("""
          """)))}/*24.13*/else/*24.18*/{_display_(Seq[Any](format.raw/*24.19*/("""
            """),_display_(/*25.14*/if(loginAccount.isDefined)/*25.40*/{_display_(Seq[Any](format.raw/*25.41*/("""
              """),format.raw/*26.15*/("""<a class="btn btn-small" href=""""),_display_(/*26.47*/url(repository)),format.raw/*26.62*/("""/wiki/"""),_display_(/*26.69*/urlEncode(pageName)),format.raw/*26.88*/("""/_edit">Edit Page</a>
              <a class="btn btn-small btn-success" href=""""),_display_(/*27.59*/url(repository)),format.raw/*27.74*/("""/wiki/_new">New Page</a>
            """)))}),format.raw/*28.14*/("""
          """)))}),format.raw/*29.12*/("""
        """),format.raw/*30.9*/("""</div>
      </li>
    </ul>
    <table class="table table-bordered fill-width pull-left">
      <tr>
        <th colspan="3">
          <div class="pull-left" style="padding-top: 4px;">Revisions</div>
          <div class="pull-right">
            <input type="button" id="compare" value="Compare Revisions" class="btn btn-mini"/>
          </div>
        </th>
      </tr>
      """),_display_(/*42.8*/commits/*42.15*/.map/*42.19*/ { commit =>_display_(Seq[Any](format.raw/*42.31*/("""
        """),format.raw/*43.9*/("""<tr>
          <td width="0%"><input type="checkbox" name="commitId" value=""""),_display_(/*44.73*/commit/*44.79*/.id),format.raw/*44.82*/(""""></td>
          <td>"""),_display_(/*45.16*/avatar(commit, 20)),format.raw/*45.34*/("""&nbsp;"""),_display_(/*45.41*/user(commit.authorName, commit.authorEmailAddress)),format.raw/*45.91*/("""</td>
          <td width="80%">
            <span class="muted">"""),_display_(/*47.34*/helper/*47.40*/.html.datetimeago(commit.authorTime)),format.raw/*47.76*/(""":</span>&nbsp;"""),_display_(/*47.91*/commit/*47.97*/.shortMessage),format.raw/*47.110*/("""
          """),format.raw/*48.11*/("""</td>
        </tr>
      """)))}),format.raw/*50.8*/("""
    """),format.raw/*51.5*/("""</table>
    <script>
    $(function()"""),format.raw/*53.17*/("""{"""),format.raw/*53.18*/("""
      """),format.raw/*54.7*/("""$('input[name=commitId]').click(function()"""),format.raw/*54.49*/("""{"""),format.raw/*54.50*/("""
        """),format.raw/*55.9*/("""return !($('input[name=commitId]:checked').length == 3);
      """),format.raw/*56.7*/("""}"""),format.raw/*56.8*/(""");

      $('#compare').click(function()"""),format.raw/*58.37*/("""{"""),format.raw/*58.38*/("""
        """),format.raw/*59.9*/("""var e = $('input[name=commitId]:checked');
        if(e.length == 2)"""),format.raw/*60.26*/("""{"""),format.raw/*60.27*/("""
          """),_display_(/*61.12*/if(pageName.isEmpty)/*61.32*/{_display_(Seq[Any](format.raw/*61.33*/("""
            """),format.raw/*62.13*/("""location.href = '"""),_display_(/*62.31*/url(repository)),format.raw/*62.46*/("""/wiki/_compare/' +
              $(e.get(1)).attr('value') + '...' + $(e.get(0)).attr('value');
          """)))}/*64.13*/else/*64.18*/{_display_(Seq[Any](format.raw/*64.19*/("""
            """),format.raw/*65.13*/("""location.href = '"""),_display_(/*65.31*/url(repository)),format.raw/*65.46*/("""/wiki/"""),_display_(/*65.53*/urlEncode(pageName.get)),format.raw/*65.76*/("""/_compare/' +
              $(e.get(1)).attr('value') + '...' + $(e.get(0)).attr('value');
          """)))}),format.raw/*67.12*/("""
        """),format.raw/*68.9*/("""}"""),format.raw/*68.10*/("""
      """),format.raw/*69.7*/("""}"""),format.raw/*69.8*/(""");

      $('#top').click(function()"""),format.raw/*71.33*/("""{"""),format.raw/*71.34*/("""
        """),format.raw/*72.9*/("""$('html,body').animate("""),format.raw/*72.32*/("""{"""),format.raw/*72.33*/(""" """),format.raw/*72.34*/("""scrollTop: 0 """),format.raw/*72.47*/("""}"""),format.raw/*72.48*/(""", 'fast');
      """),format.raw/*73.7*/("""}"""),format.raw/*73.8*/(""");
    """),format.raw/*74.5*/("""}"""),format.raw/*74.6*/(""");
    </script>
  """)))}),format.raw/*76.4*/("""
""")))}))}
  }

  def render(pageName:Option[String],commits:List[util.JGitUtil.CommitInfo],repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(pageName,commits,repository)(context)

  def f:((Option[String],List[util.JGitUtil.CommitInfo],service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (pageName,commits,repository) => (context) => apply(pageName,commits,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/wiki/history.scala.html
                  HASH: 04142f1c02c60c05c35fa9c6842866fe3f38865a
                  MATRIX: 436->1|718->157|745->200|756->204|840->280|878->281|907->285|918->289|951->314|989->315|1020->320|1148->421|1177->441|1216->442|1257->455|1322->502|1335->507|1374->508|1415->521|1482->561|1499->569|1524->573|1567->585|1603->594|1703->667|1732->687|1771->688|1812->702|1847->728|1886->729|1929->744|1988->776|2024->791|2093->829|2124->842|2137->847|2176->848|2217->862|2252->888|2291->889|2334->904|2393->936|2429->951|2463->958|2503->977|2610->1057|2646->1072|2715->1110|2758->1122|2794->1131|3202->1513|3218->1520|3231->1524|3281->1536|3317->1545|3421->1622|3436->1628|3460->1631|3510->1654|3549->1672|3583->1679|3654->1729|3747->1795|3762->1801|3819->1837|3861->1852|3876->1858|3911->1871|3950->1882|4007->1909|4039->1914|4105->1952|4134->1953|4168->1960|4238->2002|4267->2003|4303->2012|4393->2075|4421->2076|4489->2116|4518->2117|4554->2126|4650->2194|4679->2195|4718->2207|4747->2227|4786->2228|4827->2241|4872->2259|4908->2274|5034->2382|5047->2387|5086->2388|5127->2401|5172->2419|5208->2434|5242->2441|5286->2464|5419->2566|5455->2575|5484->2576|5518->2583|5546->2584|5610->2620|5639->2621|5675->2630|5726->2653|5755->2654|5784->2655|5825->2668|5854->2669|5898->2686|5926->2687|5960->2694|5988->2695|6038->2715
                  LINES: 13->1|19->3|20->6|20->6|20->6|20->6|21->7|21->7|21->7|21->7|22->8|25->11|25->11|25->11|26->12|27->13|27->13|27->13|28->14|28->14|28->14|28->14|29->15|30->16|34->20|34->20|34->20|35->21|35->21|35->21|36->22|36->22|36->22|37->23|38->24|38->24|38->24|39->25|39->25|39->25|40->26|40->26|40->26|40->26|40->26|41->27|41->27|42->28|43->29|44->30|56->42|56->42|56->42|56->42|57->43|58->44|58->44|58->44|59->45|59->45|59->45|59->45|61->47|61->47|61->47|61->47|61->47|61->47|62->48|64->50|65->51|67->53|67->53|68->54|68->54|68->54|69->55|70->56|70->56|72->58|72->58|73->59|74->60|74->60|75->61|75->61|75->61|76->62|76->62|76->62|78->64|78->64|78->64|79->65|79->65|79->65|79->65|79->65|81->67|82->68|82->68|83->69|83->69|85->71|85->71|86->72|86->72|86->72|86->72|86->72|86->72|87->73|87->73|88->74|88->74|90->76
                  -- GENERATED --
              */
          