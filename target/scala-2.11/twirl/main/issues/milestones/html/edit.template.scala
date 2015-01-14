
package issues.milestones.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object edit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Option[model.Milestone],service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(milestone: Option[model.Milestone], repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*1.123*/("""
"""),_display_(/*4.2*/html/*4.6*/.main(s"Milestones - ${repository.owner}/${repository.name}")/*4.67*/{_display_(Seq[Any](format.raw/*4.68*/("""
  """),_display_(/*5.4*/html/*5.8*/.menu("issues", repository)/*5.35*/{_display_(Seq[Any](format.raw/*5.36*/("""
    """),_display_(/*6.6*/if(milestone.isEmpty)/*6.27*/{_display_(Seq[Any](format.raw/*6.28*/("""
      """),format.raw/*7.7*/("""<h4>New milestone</h4>
      <div class="muted">Create a new milestone to help organize your issues and pull requests.</div>
    """)))}/*9.7*/else/*9.12*/{_display_(Seq[Any](format.raw/*9.13*/("""
      """),_display_(/*10.8*/issues/*10.14*/.html.navigation("milestones", false, repository)),format.raw/*10.63*/("""
      """),format.raw/*11.7*/("""<br><br>
    """)))}),format.raw/*12.6*/("""
    """),format.raw/*13.5*/("""<hr style="margin-top: 12px; margin-bottom: 18px;" class="fill-width"/>
    <form method="POST" action=""""),_display_(/*14.34*/url(repository)),format.raw/*14.49*/("""/issues/milestones/"""),_display_(/*14.69*/if(milestone.isEmpty)/*14.90*/{_display_(Seq[Any](format.raw/*14.91*/("""new""")))}/*14.95*/else/*14.99*/{_display_(Seq[Any](_display_(/*14.101*/milestone/*14.110*/.get.milestoneId),format.raw/*14.126*/("""/edit""")))}),format.raw/*14.132*/("""" validate="true">
      <fieldset>
        <input type="text" id="title" name="title" style="width: 500px;" value=""""),_display_(/*16.82*/milestone/*16.91*/.map(_.title)),format.raw/*16.104*/("""" placeholder="Title"/>
        <span id="error-title" class="error"></span>
      </fieldset>
      <fieldset>
        <label for="description" class="strong">Description</label>
        <textarea id="description" name="description" style="width: 500px; height: 150px;">"""),_display_(/*21.93*/milestone/*21.102*/.map(_.description)),format.raw/*21.121*/("""</textarea>
        <span id="error-description" class="error"></span>
      </fieldset>
      <fieldset>
        <label for="dueDate" class="strong">Due Date</label>
        """),_display_(/*26.10*/helper/*26.16*/.html.datepicker("dueDate", milestone.flatMap(_.dueDate))),format.raw/*26.73*/("""
        """),format.raw/*27.9*/("""<span id="error-dueDate" class="error"></span>
      </fieldset>
      <hr>
      <div class="pull-right">
        """),_display_(/*31.10*/if(milestone.isEmpty)/*31.31*/{_display_(Seq[Any](format.raw/*31.32*/("""
          """),format.raw/*32.11*/("""<input type="submit" class="btn" value="Create milestone"/>
        """)))}/*33.11*/else/*33.16*/{_display_(Seq[Any](format.raw/*33.17*/("""
          """),_display_(/*34.12*/if(milestone.get.closedDate.isDefined)/*34.50*/{_display_(Seq[Any](format.raw/*34.51*/("""
            """),format.raw/*35.13*/("""<input type="button" class="btn" value="Open" id="open"
                   onclick="location.href='"""),_display_(/*36.45*/url(repository)),format.raw/*36.60*/("""/issues/milestones/"""),_display_(/*36.80*/milestone/*36.89*/.get.milestoneId),format.raw/*36.105*/("""/close';"/>
          """)))}/*37.13*/else/*37.18*/{_display_(Seq[Any](format.raw/*37.19*/("""
            """),format.raw/*38.13*/("""<input type="button" class="btn" value="Close" id="close"
                   onclick="location.href='"""),_display_(/*39.45*/url(repository)),format.raw/*39.60*/("""/issues/milestones/"""),_display_(/*39.80*/milestone/*39.89*/.get.milestoneId),format.raw/*39.105*/("""/open';"/>
          """)))}),format.raw/*40.12*/("""
          """),format.raw/*41.11*/("""<input type="submit" class="btn" value="Update milestone"/>
        """)))}),format.raw/*42.10*/("""
      """),format.raw/*43.7*/("""</div>
    </form>
  """)))}),format.raw/*45.4*/("""
""")))}),format.raw/*46.2*/("""
"""))}
  }

  def render(milestone:Option[model.Milestone],repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(milestone,repository)(context)

  def f:((Option[model.Milestone],service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (milestone,repository) => (context) => apply(milestone,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/issues/milestones/edit.scala.html
                  HASH: bbbb6eeb1a9fade1544a486cd739ca65781d713b
                  MATRIX: 424->1|672->122|699->165|710->169|779->230|817->231|846->235|857->239|892->266|930->267|961->273|990->294|1028->295|1061->302|1208->433|1220->438|1258->439|1292->447|1307->453|1377->502|1411->509|1455->523|1487->528|1619->633|1655->648|1702->668|1732->689|1771->690|1794->694|1807->698|1847->700|1866->709|1904->725|1942->731|2086->848|2104->857|2139->870|2438->1142|2457->1151|2498->1170|2701->1346|2716->1352|2794->1409|2830->1418|2973->1534|3003->1555|3042->1556|3081->1567|3169->1637|3182->1642|3221->1643|3260->1655|3307->1693|3346->1694|3387->1707|3514->1807|3550->1822|3597->1842|3615->1851|3653->1867|3695->1891|3708->1896|3747->1897|3788->1910|3917->2012|3953->2027|4000->2047|4018->2056|4056->2072|4109->2094|4148->2105|4248->2174|4282->2181|4334->2203|4366->2205
                  LINES: 13->1|17->1|18->4|18->4|18->4|18->4|19->5|19->5|19->5|19->5|20->6|20->6|20->6|21->7|23->9|23->9|23->9|24->10|24->10|24->10|25->11|26->12|27->13|28->14|28->14|28->14|28->14|28->14|28->14|28->14|28->14|28->14|28->14|28->14|30->16|30->16|30->16|35->21|35->21|35->21|40->26|40->26|40->26|41->27|45->31|45->31|45->31|46->32|47->33|47->33|47->33|48->34|48->34|48->34|49->35|50->36|50->36|50->36|50->36|50->36|51->37|51->37|51->37|52->38|53->39|53->39|53->39|53->39|53->39|54->40|55->41|56->42|57->43|59->45|60->46
                  -- GENERATED --
              */
          