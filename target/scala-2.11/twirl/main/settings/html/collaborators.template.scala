
package settings.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object collaborators extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[List[String],Boolean,service.RepositoryService.RepositoryInfo,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(collaborators: List[String],
  isGroupRepository: Boolean,
  repository: service.RepositoryService.RepositoryInfo)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*3.87*/("""
"""),_display_(/*6.2*/html/*6.6*/.main("Settings", Some(repository))/*6.41*/{_display_(Seq[Any](format.raw/*6.42*/("""
  """),_display_(/*7.4*/html/*7.8*/.menu("settings", repository)/*7.37*/{_display_(Seq[Any](format.raw/*7.38*/("""
    """),_display_(/*8.6*/menu("collaborators", repository)/*8.39*/{_display_(Seq[Any](format.raw/*8.40*/("""
      """),format.raw/*9.7*/("""<h3>Manage Collaborators</h3>
      <ul class="collaborator">
        """),_display_(/*11.10*/collaborators/*11.23*/.map/*11.27*/ { collaboratorName =>_display_(Seq[Any](format.raw/*11.49*/("""
          """),format.raw/*12.11*/("""<li>
            <a href=""""),_display_(/*13.23*/url(collaboratorName)),format.raw/*13.44*/("""">"""),_display_(/*13.47*/collaboratorName),format.raw/*13.63*/("""</a>
            """),_display_(/*14.14*/if(!isGroupRepository)/*14.36*/{_display_(Seq[Any](format.raw/*14.37*/("""
              """),format.raw/*15.15*/("""<a href=""""),_display_(/*15.25*/url(repository)),format.raw/*15.40*/("""/settings/collaborators/remove?name="""),_display_(/*15.77*/collaboratorName),format.raw/*15.93*/("""" class="remove">(remove)</a>
            """)))}/*16.15*/else/*16.20*/{_display_(Seq[Any](format.raw/*16.21*/("""
              """),_display_(/*17.16*/if(repository.managers.contains(collaboratorName))/*17.66*/{_display_(Seq[Any](format.raw/*17.67*/("""
                """),format.raw/*18.17*/("""(Manager)
              """)))}),format.raw/*19.16*/("""
            """)))}),format.raw/*20.14*/("""
          """),format.raw/*21.11*/("""</li>
        """)))}),format.raw/*22.10*/("""
      """),format.raw/*23.7*/("""</ul>
      """),_display_(/*24.8*/if(!isGroupRepository)/*24.30*/{_display_(Seq[Any](format.raw/*24.31*/("""
        """),format.raw/*25.9*/("""<form method="POST" action=""""),_display_(/*25.38*/url(repository)),format.raw/*25.53*/("""/settings/collaborators/add" validate="true" autocomplete="off">
          <div>
            <span class="error" id="error-userName"></span>
          </div>
          """),_display_(/*29.12*/helper/*29.18*/.html.account("userName", 300)),format.raw/*29.48*/("""
          """),format.raw/*30.11*/("""<input type="submit" class="btn" value="Add"/>
        </form>
      """)))}),format.raw/*32.8*/("""
    """)))}),format.raw/*33.6*/("""
  """)))}),format.raw/*34.4*/("""
""")))}),format.raw/*35.2*/("""
"""))}
  }

  def render(collaborators:List[String],isGroupRepository:Boolean,repository:service.RepositoryService.RepositoryInfo,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(collaborators,isGroupRepository,repository)(context)

  def f:((List[String],Boolean,service.RepositoryService.RepositoryInfo) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (collaborators,isGroupRepository,repository) => (context) => apply(collaborators,isGroupRepository,repository)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/settings/collaborators.scala.html
                  HASH: 33d9fbc48ba1419dffd28b356b689a7f14f91b89
                  MATRIX: 421->1|693->147|720->190|731->194|774->229|812->230|841->234|852->238|889->267|927->268|958->274|999->307|1037->308|1070->315|1168->386|1190->399|1203->403|1263->425|1302->436|1356->463|1398->484|1428->487|1465->503|1510->521|1541->543|1580->544|1623->559|1660->569|1696->584|1760->621|1797->637|1859->681|1872->686|1911->687|1954->703|2013->753|2052->754|2097->771|2153->796|2198->810|2237->821|2283->836|2317->843|2356->856|2387->878|2426->879|2462->888|2518->917|2554->932|2750->1101|2765->1107|2816->1137|2855->1148|2955->1218|2991->1224|3025->1228|3057->1230
                  LINES: 13->1|19->3|20->6|20->6|20->6|20->6|21->7|21->7|21->7|21->7|22->8|22->8|22->8|23->9|25->11|25->11|25->11|25->11|26->12|27->13|27->13|27->13|27->13|28->14|28->14|28->14|29->15|29->15|29->15|29->15|29->15|30->16|30->16|30->16|31->17|31->17|31->17|32->18|33->19|34->20|35->21|36->22|37->23|38->24|38->24|38->24|39->25|39->25|39->25|43->29|43->29|43->29|44->30|46->32|47->33|48->34|49->35
                  -- GENERATED --
              */
          