
package issues.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object commentform extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[model.Issue,Boolean,Boolean,service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issue: model.Issue,
  reopenable: Boolean,
  hasWritePermission: Boolean,
  repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*4.87*/("""
"""),_display_(/*7.2*/if(loginAccount.isDefined)/*7.28*/{_display_(Seq[Any](format.raw/*7.29*/("""
  """),format.raw/*8.3*/("""<hr/><br/>
  <form method="POST" validate="true">
    <div class="issue-avatar-image">"""),_display_(/*10.38*/avatar(loginAccount.get.userName, 48)),format.raw/*10.75*/("""</div>
      <div class="box issue-comment-box">
      <div class="box-content">
        """),_display_(/*13.10*/helper/*13.16*/.html.preview(repository, "", false, true, true, hasWritePermission, "width: 635px; height: 100px; max-height: 150px;", elastic = true)),format.raw/*13.151*/("""
      """),format.raw/*14.7*/("""</div>
    </div>
    <div class="pull-right">
      <input type="hidden" name="issueId" value=""""),_display_(/*17.51*/issue/*17.56*/.issueId),format.raw/*17.64*/(""""/>
      <input type="submit" class="btn btn-success" formaction=""""),_display_(/*18.65*/url(repository)),format.raw/*18.80*/("""/issue_comments/new" value="Comment"/>
      """),_display_(/*19.8*/if((reopenable || !issue.closed) && (hasWritePermission || issue.openedUserName == loginAccount.get.userName))/*19.118*/{_display_(Seq[Any](format.raw/*19.119*/("""
        """),format.raw/*20.9*/("""<input type="submit" class="btn" formaction=""""),_display_(/*20.55*/url(repository)),format.raw/*20.70*/("""/issue_comments/state" value=""""),_display_(/*20.101*/{if(issue.closed) "Reopen" else "Close"}),format.raw/*20.141*/("""" id="action"/>
      """)))}),format.raw/*21.8*/("""
    """),format.raw/*22.5*/("""</div>
  </form>
""")))}),format.raw/*24.2*/("""
"""),format.raw/*25.1*/("""<script>
$(function()"""),format.raw/*26.13*/("""{"""),format.raw/*26.14*/("""
  """),format.raw/*27.3*/("""$('#action').click(function()"""),format.raw/*27.32*/("""{"""),format.raw/*27.33*/("""
    """),format.raw/*28.5*/("""$('<input type="hidden">').attr('name', 'action').val($(this).val().toLowerCase()).appendTo('form');
  """),format.raw/*29.3*/("""}"""),format.raw/*29.4*/(""");
"""),format.raw/*30.1*/("""}"""),format.raw/*30.2*/(""");
</script>
"""))}
  }

  def render(issue:model.Issue,reopenable:Boolean,hasWritePermission:Boolean,repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(issue,reopenable,hasWritePermission,repository)(context)

  def f:((model.Issue,Boolean,Boolean,service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (issue,reopenable,hasWritePermission,repository) => (context) => apply(issue,reopenable,hasWritePermission,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/issues/commentform.scala.html
                  HASH: e0c24b160efd1e89a2c640b8b9110b7080e0f367
                  MATRIX: 424->1|711->162|738->205|772->231|810->232|839->235|953->322|1011->359|1128->449|1143->455|1300->590|1334->597|1458->694|1472->699|1501->707|1596->775|1632->790|1704->836|1824->946|1864->947|1900->956|1973->1002|2009->1017|2068->1048|2130->1088|2183->1111|2215->1116|2263->1134|2291->1135|2340->1156|2369->1157|2399->1160|2456->1189|2485->1190|2517->1195|2647->1298|2675->1299|2705->1302|2733->1303
                  LINES: 13->1|20->4|21->7|21->7|21->7|22->8|24->10|24->10|27->13|27->13|27->13|28->14|31->17|31->17|31->17|32->18|32->18|33->19|33->19|33->19|34->20|34->20|34->20|34->20|34->20|35->21|36->22|38->24|39->25|40->26|40->26|41->27|41->27|41->27|42->28|43->29|43->29|44->30|44->30
                  -- GENERATED --
              */
          