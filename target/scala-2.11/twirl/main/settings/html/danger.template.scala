
package settings.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object danger extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*1.87*/("""
"""),_display_(/*4.2*/html/*4.6*/.main("Danger Zone", Some(repository))/*4.44*/{_display_(Seq[Any](format.raw/*4.45*/("""
  """),_display_(/*5.4*/html/*5.8*/.menu("settings", repository)/*5.37*/{_display_(Seq[Any](format.raw/*5.38*/("""
    """),_display_(/*6.6*/menu("danger", repository)/*6.32*/{_display_(Seq[Any](format.raw/*6.33*/("""
      """),format.raw/*7.7*/("""<div class="box">
        <div class="box-header">Danger Zone</div>
        <div class="box-content">
          <form id="transfer-form" method="post" action=""""),_display_(/*10.59*/url(repository)),format.raw/*10.74*/("""/settings/transfer" validate="true" autocomplete="off">
            <fieldset>
              <label class="strong">Transfer Ownership</label>
              <div>
                Transfer this repo to another user or to group.
                <div class="pull-right">
                  """),_display_(/*16.20*/helper/*16.26*/.html.account("newOwner", 150)),format.raw/*16.56*/("""
                  """),format.raw/*17.19*/("""<input type="submit" class="btn btn-danger" value="Transfer"/>
                  <div>
                    <span id="error-newOwner" class="error"></span>
                  </div>
                </div>
              </div>
            </fieldset>
          </form>
          <form id="delete-form" method="post" action=""""),_display_(/*25.57*/url(repository)),format.raw/*25.72*/("""/settings/delete">
            <fieldset class="margin">
              <label class="strong">Delete repository</label>
              <div>
                Once you delete a repository, there is no going back.
                <input type="submit" class="btn btn-danger pull-right" value="Delete this repository"/>
              </div>
            </fieldset>
          </form>
        </div>
      </div>
    """)))}),format.raw/*36.6*/("""
  """)))}),format.raw/*37.4*/("""
""")))}),format.raw/*38.2*/("""
"""),format.raw/*39.1*/("""<script>
$(function()"""),format.raw/*40.13*/("""{"""),format.raw/*40.14*/("""
  """),format.raw/*41.3*/("""$('#delete-form').submit(function()"""),format.raw/*41.38*/("""{"""),format.raw/*41.39*/("""
    """),format.raw/*42.5*/("""return confirm('Once you delete a repository, there is no going back.\nAre you sure?');
  """),format.raw/*43.3*/("""}"""),format.raw/*43.4*/(""");
"""),format.raw/*44.1*/("""}"""),format.raw/*44.2*/(""");
</script>"""))}
  }

  def render(repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository)(context)

  def f:((service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository) => (context) => apply(repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/settings/danger.scala.html
                  HASH: f0405cb895ee51cb5f6b06f88f410e8732b8c64f
                  MATRIX: 393->1|604->86|631->129|642->133|688->171|726->172|755->176|766->180|803->209|841->210|872->216|906->242|944->243|977->250|1164->410|1200->425|1513->711|1528->717|1579->747|1626->766|1975->1088|2011->1103|2450->1512|2484->1516|2516->1518|2544->1519|2593->1540|2622->1541|2652->1544|2715->1579|2744->1580|2776->1585|2893->1675|2921->1676|2951->1679|2979->1680
                  LINES: 13->1|17->1|18->4|18->4|18->4|18->4|19->5|19->5|19->5|19->5|20->6|20->6|20->6|21->7|24->10|24->10|30->16|30->16|30->16|31->17|39->25|39->25|50->36|51->37|52->38|53->39|54->40|54->40|55->41|55->41|55->41|56->42|57->43|57->43|58->44|58->44
                  -- GENERATED --
              */
          