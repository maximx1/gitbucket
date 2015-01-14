
package repo.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object guide extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[service.RepositoryService.RepositoryInfo,Boolean,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: service.RepositoryService.RepositoryInfo,
  hasWritePermission: Boolean)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*2.62*/("""
"""),_display_(/*5.2*/html/*5.6*/.main(s"${repository.owner}/${repository.name}", Some(repository))/*5.72*/ {_display_(Seq[Any](format.raw/*5.74*/("""
  """),_display_(/*6.4*/html/*6.8*/.menu("code", repository)/*6.33*/{_display_(Seq[Any](format.raw/*6.34*/("""
    """),_display_(/*7.6*/if(!hasWritePermission)/*7.29*/{_display_(Seq[Any](format.raw/*7.30*/("""
      """),format.raw/*8.7*/("""<h3>This is an empty repository</h3>
    """)))}/*9.7*/else/*9.12*/{_display_(Seq[Any](format.raw/*9.13*/("""
      """),format.raw/*10.7*/("""<h3><strong>Quick setup</strong> — if you've done this kind of thing before</h3>
      <div class="empty-repo-options">
        via <a href=""""),_display_(/*12.23*/repository/*12.33*/.httpUrl),format.raw/*12.41*/("""" class="git-protocol-selector">HTTP</a>
      """),_display_(/*13.8*/if(settings.ssh && loginAccount.isDefined)/*13.50*/{_display_(Seq[Any](format.raw/*13.51*/("""
         """),format.raw/*14.10*/("""or
         <a href=""""),_display_(/*15.20*/repository/*15.30*/.sshUrl(settings.sshPort.getOrElse(service.SystemSettingsService.DefaultSshPort), loginAccount.get.userName)),format.raw/*15.138*/("""" class="git-protocol-selector">SSH</a>
      """)))}),format.raw/*16.8*/("""
      """),format.raw/*17.7*/("""</div>
      <h3 style="margin-top: 30px;">Create a new repository on the command line</h3>
      """),_display_(/*19.8*/pre/*19.11*/ {_display_(Seq[Any](format.raw/*19.13*/("""
        """),format.raw/*20.9*/("""touch README.md
        git init
        git add README.md
        git commit -m "first commit"
        git remote add origin <span class="live-clone-url">"""),_display_(/*24.61*/repository/*24.71*/.httpUrl),format.raw/*24.79*/("""</span>
        git push -u origin master
      """)))}),format.raw/*26.8*/("""
      """),format.raw/*27.7*/("""<h3 style="margin-top: 30px;">Push an existing repository from the command line</h3>
      """),_display_(/*28.8*/pre/*28.11*/ {_display_(Seq[Any](format.raw/*28.13*/("""
        """),format.raw/*29.9*/("""git remote add origin <span class="live-clone-url">"""),_display_(/*29.61*/repository/*29.71*/.httpUrl),format.raw/*29.79*/("""</span>
        git push -u origin master
      """)))}),format.raw/*31.8*/("""
      """),format.raw/*32.7*/("""<script>
      $(function()"""),format.raw/*33.19*/("""{"""),format.raw/*33.20*/("""
        """),format.raw/*34.9*/("""$('.git-protocol-selector').click(function(e)"""),format.raw/*34.54*/("""{"""),format.raw/*34.55*/("""
          """),format.raw/*35.11*/("""e.preventDefault();
          $('.live-clone-url').text($(e.target).attr('href'));
        """),format.raw/*37.9*/("""}"""),format.raw/*37.10*/(""");
      """),format.raw/*38.7*/("""}"""),format.raw/*38.8*/(""");
      </script>
    """)))}),format.raw/*40.6*/("""
  """)))}),format.raw/*41.4*/("""
""")))}))}
  }

  def render(repository:service.RepositoryService.RepositoryInfo,hasWritePermission:Boolean,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository,hasWritePermission)(context)

  def f:((service.RepositoryService.RepositoryInfo,Boolean) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository,hasWritePermission) => (context) => apply(repository,hasWritePermission)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/repo/guide.scala.html
                  HASH: a95892a1cf199701f89720cb3ad4ddc4667e9bd8
                  MATRIX: 396->1|638->117|665->160|676->164|750->230|789->232|818->236|829->240|862->265|900->266|931->272|962->295|1000->296|1033->303|1092->346|1104->351|1142->352|1176->359|1345->501|1364->511|1393->519|1467->567|1518->609|1557->610|1595->620|1644->642|1663->652|1793->760|1870->807|1904->814|2029->913|2041->916|2081->918|2117->927|2300->1083|2319->1093|2348->1101|2427->1150|2461->1157|2579->1249|2591->1252|2631->1254|2667->1263|2746->1315|2765->1325|2794->1333|2873->1382|2907->1389|2962->1416|2991->1417|3027->1426|3100->1471|3129->1472|3168->1483|3286->1574|3315->1575|3351->1584|3379->1585|3433->1609|3467->1613
                  LINES: 13->1|18->2|19->5|19->5|19->5|19->5|20->6|20->6|20->6|20->6|21->7|21->7|21->7|22->8|23->9|23->9|23->9|24->10|26->12|26->12|26->12|27->13|27->13|27->13|28->14|29->15|29->15|29->15|30->16|31->17|33->19|33->19|33->19|34->20|38->24|38->24|38->24|40->26|41->27|42->28|42->28|42->28|43->29|43->29|43->29|43->29|45->31|46->32|47->33|47->33|48->34|48->34|48->34|49->35|51->37|51->37|52->38|52->38|54->40|55->41
                  -- GENERATED --
              */
          