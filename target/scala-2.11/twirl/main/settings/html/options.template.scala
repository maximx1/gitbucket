
package settings.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object options extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[service.RepositoryService.RepositoryInfo,Option[Any],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: service.RepositoryService.RepositoryInfo, info: Option[Any])(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*1.106*/("""
"""),_display_(/*4.2*/html/*4.6*/.main("Settings", Some(repository))/*4.41*/{_display_(Seq[Any](format.raw/*4.42*/("""
  """),_display_(/*5.4*/html/*5.8*/.menu("settings", repository)/*5.37*/{_display_(Seq[Any](format.raw/*5.38*/("""
    """),_display_(/*6.6*/menu("options", repository)/*6.33*/{_display_(Seq[Any](format.raw/*6.34*/("""
      """),_display_(/*7.8*/helper/*7.14*/.html.information(info)),format.raw/*7.37*/("""
      """),format.raw/*8.7*/("""<form id="form" method="post" action=""""),_display_(/*8.46*/url(repository)),format.raw/*8.61*/("""/settings/options" validate="true">
        <div class="box">
          <div class="box-header">Settings</div>
          <div class="box-content">
            <fieldset>
              <label for="repositoryName" class="strong">Repository Name:</label>
              <input type="text" name="repositoryName" id="repositoryName" value=""""),_display_(/*14.84*/repository/*14.94*/.name),format.raw/*14.99*/(""""/>
              <span id="error-repositoryName" class="error"></span>
            </fieldset>
            <fieldset class="margin">
              <label for="description" class="strong">Description:</label>
              <input type="text" name="description" id="description" style="width: 600px;" value=""""),_display_(/*19.100*/repository/*19.110*/.repository.description),format.raw/*19.133*/(""""/>
            </fieldset>
            <fieldset class="margin">
              <label for="defaultBranch" class="strong">Default Branch:</label>
              <select name="defaultBranch" id="defaultBranch""""),_display_(/*23.63*/if(repository.branchList.isEmpty)/*23.96*/{_display_(Seq[Any](format.raw/*23.97*/(""" """),format.raw/*23.98*/("""disabled""")))}),format.raw/*23.107*/(""">
                """),_display_(/*24.18*/if(repository.branchList.isEmpty)/*24.51*/{_display_(Seq[Any](format.raw/*24.52*/("""
                  """),format.raw/*25.19*/("""<option value="none" selected>No Branch</option>
                """)))}/*26.19*/else/*26.24*/{_display_(Seq[Any](format.raw/*26.25*/("""
                  """),_display_(/*27.20*/repository/*27.30*/.branchList.map/*27.45*/ { branch =>_display_(Seq[Any](format.raw/*27.57*/("""
                    """),format.raw/*28.21*/("""<option"""),_display_(/*28.29*/if(branch==repository.repository.defaultBranch)/*28.76*/{_display_(Seq[Any](format.raw/*28.77*/(""" """),format.raw/*28.78*/("""selected""")))}),format.raw/*28.87*/(""">"""),_display_(/*28.89*/branch),format.raw/*28.95*/("""</option>
                  """)))}),format.raw/*29.20*/("""
                """)))}),format.raw/*30.18*/("""
              """),format.raw/*31.15*/("""</select>
              """),_display_(/*32.16*/if(repository.branchList.isEmpty)/*32.49*/{_display_(Seq[Any](format.raw/*32.50*/("""
                """),format.raw/*33.17*/("""<input type="hidden" name="defaultBranch" value="none"/>
              """)))}),format.raw/*34.16*/("""
              """),format.raw/*35.15*/("""<span class="error" id="error-defaultBranch"></span>
            </fieldset>
            <fieldset class="margin">
              <label class="radio">
                <input type="radio" name="isPrivate" value="false"
                  """),_display_(/*40.20*/if(!repository.repository.isPrivate              )/*40.70*/{_display_(Seq[Any](format.raw/*40.71*/(""" """),format.raw/*40.72*/("""checked  """)))}),format.raw/*40.82*/("""
                  """),_display_(/*41.20*/if(repository.repository.parentUserName.isDefined)/*41.70*/{_display_(Seq[Any](format.raw/*41.71*/(""" """),format.raw/*41.72*/("""disabled """)))}),format.raw/*41.82*/("""
                """),format.raw/*42.17*/(""">
                <span class="strong">Public</span><br>
                <div>
                  <span>All users and guests can read this repository.</span>
                </div>
              </label>
            </fieldset>
            <fieldset>
              <label class="radio">
                <input type="radio" name="isPrivate" value="true"
                  """),_display_(/*52.20*/if(repository.repository.isPrivate               )/*52.70*/{_display_(Seq[Any](format.raw/*52.71*/(""" """),format.raw/*52.72*/("""checked  """)))}),format.raw/*52.82*/("""
                  """),_display_(/*53.20*/if(repository.repository.parentUserName.isDefined)/*53.70*/{_display_(Seq[Any](format.raw/*53.71*/(""" """),format.raw/*53.72*/("""disabled """)))}),format.raw/*53.82*/("""
                """),format.raw/*54.17*/(""">
                <span class="strong">Private</span><br>
                <div>
                  <span>Only collaborators can read this repository.</span>
                </div>
              </label>
            </fieldset>
          </div>
        </div>
        """),format.raw/*93.11*/("""
        """),format.raw/*94.9*/("""<fieldset>
          <input type="submit" class="btn btn-success" value="Apply changes"/>
        </fieldset>
      </form>
    """)))}),format.raw/*98.6*/("""
  """)))}),format.raw/*99.4*/("""
""")))}),format.raw/*100.2*/("""
"""))}
  }

  def render(repository:service.RepositoryService.RepositoryInfo,info:Option[Any],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository,info)(context)

  def f:((service.RepositoryService.RepositoryInfo,Option[Any]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository,info) => (context) => apply(repository,info)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/settings/options.scala.html
                  HASH: 497134828902474c2a6ef95dc73432516deb9b3a
                  MATRIX: 406->1|637->105|664->148|675->152|718->187|756->188|785->192|796->196|833->225|871->226|902->232|937->259|975->260|1008->268|1022->274|1065->297|1098->304|1163->343|1198->358|1560->693|1579->703|1605->708|1941->1016|1961->1026|2006->1049|2241->1257|2283->1290|2322->1291|2351->1292|2392->1301|2438->1320|2480->1353|2519->1354|2566->1373|2651->1440|2664->1445|2703->1446|2750->1466|2769->1476|2793->1491|2843->1503|2892->1524|2927->1532|2983->1579|3022->1580|3051->1581|3091->1590|3120->1592|3147->1598|3207->1627|3256->1645|3299->1660|3351->1685|3393->1718|3432->1719|3477->1736|3580->1808|3623->1823|3887->2060|3946->2110|3985->2111|4014->2112|4055->2122|4102->2142|4161->2192|4200->2193|4229->2194|4270->2204|4315->2221|4713->2592|4772->2642|4811->2643|4840->2644|4881->2654|4928->2674|4987->2724|5026->2725|5055->2726|5096->2736|5141->2753|5435->4088|5471->4097|5630->4226|5664->4230|5697->4232
                  LINES: 13->1|17->1|18->4|18->4|18->4|18->4|19->5|19->5|19->5|19->5|20->6|20->6|20->6|21->7|21->7|21->7|22->8|22->8|22->8|28->14|28->14|28->14|33->19|33->19|33->19|37->23|37->23|37->23|37->23|37->23|38->24|38->24|38->24|39->25|40->26|40->26|40->26|41->27|41->27|41->27|41->27|42->28|42->28|42->28|42->28|42->28|42->28|42->28|42->28|43->29|44->30|45->31|46->32|46->32|46->32|47->33|48->34|49->35|54->40|54->40|54->40|54->40|54->40|55->41|55->41|55->41|55->41|55->41|56->42|66->52|66->52|66->52|66->52|66->52|67->53|67->53|67->53|67->53|67->53|68->54|77->93|78->94|82->98|83->99|84->100
                  -- GENERATED --
              */
          