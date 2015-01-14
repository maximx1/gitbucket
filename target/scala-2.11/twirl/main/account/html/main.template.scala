
package account.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[model.Account,List[String],String,Boolean,Html,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: model.Account, groupNames: List[String], active: String,
  isGroupManager: Boolean = false)(body: Html)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*2.78*/("""
"""),_display_(/*5.2*/html/*5.6*/.main(account.userName)/*5.29*/{_display_(Seq[Any](format.raw/*5.30*/("""
  """),format.raw/*6.3*/("""<div class="container">
    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span4">
          <div class="block">
            <div class="account-image">"""),_display_(/*11.41*/avatar(account.userName, 270)),format.raw/*11.70*/("""</div>
            <div class="account-fullname">"""),_display_(/*12.44*/account/*12.51*/.fullName),format.raw/*12.60*/("""</div>
            <div class="account-username">"""),_display_(/*13.44*/account/*13.51*/.userName),format.raw/*13.60*/("""</div>
          </div>
          <div class="block">
            """),_display_(/*16.14*/if(account.url.isDefined)/*16.39*/{_display_(Seq[Any](format.raw/*16.40*/("""
              """),format.raw/*17.15*/("""<div><i class="icon-home"></i> <a href=""""),_display_(/*17.56*/account/*17.63*/.url),format.raw/*17.67*/("""">"""),_display_(/*17.70*/account/*17.77*/.url),format.raw/*17.81*/("""</a></div>
            """)))}),format.raw/*18.14*/("""
            """),format.raw/*19.13*/("""<div><i class="icon-time"></i> <span class="muted">Joined on</span> """),_display_(/*19.82*/date(account.registeredDate)),format.raw/*19.110*/("""</div>
          </div>
          """),_display_(/*21.12*/if(groupNames.nonEmpty)/*21.35*/{_display_(Seq[Any](format.raw/*21.36*/("""
            """),format.raw/*22.13*/("""<div>
              <div>Groups</div>
              """),_display_(/*24.16*/groupNames/*24.26*/.map/*24.30*/ { groupName =>_display_(Seq[Any](format.raw/*24.45*/("""
                """),format.raw/*25.17*/("""<a href=""""),_display_(/*25.27*/url(groupName)),format.raw/*25.41*/("""">"""),_display_(/*25.44*/avatar(groupName, 36, tooltip = true)),format.raw/*25.81*/("""</a>
              """)))}),format.raw/*26.16*/("""
            """),format.raw/*27.13*/("""</div>
          """)))}),format.raw/*28.12*/("""

        """),format.raw/*30.9*/("""</div>
        <div class="span8">
          <ul class="nav nav-tabs" style="margin-bottom: 5px;">
            <li"""),_display_(/*33.17*/if(active == "repositories")/*33.45*/{_display_(Seq[Any](format.raw/*33.46*/(""" """),format.raw/*33.47*/("""class="active"""")))}),format.raw/*33.62*/("""><a href=""""),_display_(/*33.73*/url(account.userName)),format.raw/*33.94*/("""?tab=repositories">Repositories</a></li>
            """),_display_(/*34.14*/if(account.isGroupAccount)/*34.40*/{_display_(Seq[Any](format.raw/*34.41*/("""
              """),format.raw/*35.15*/("""<li"""),_display_(/*35.19*/if(active == "members")/*35.42*/{_display_(Seq[Any](format.raw/*35.43*/(""" """),format.raw/*35.44*/("""class="active"""")))}),format.raw/*35.59*/("""><a href=""""),_display_(/*35.70*/url(account.userName)),format.raw/*35.91*/("""?tab=members">Members</a></li>
            """)))}/*36.15*/else/*36.20*/{_display_(Seq[Any](format.raw/*36.21*/("""
              """),format.raw/*37.15*/("""<li"""),_display_(/*37.19*/if(active == "activity")/*37.43*/{_display_(Seq[Any](format.raw/*37.44*/(""" """),format.raw/*37.45*/("""class="active"""")))}),format.raw/*37.60*/("""><a href=""""),_display_(/*37.71*/url(account.userName)),format.raw/*37.92*/("""?tab=activity">Public Activity</a></li>
            """)))}),format.raw/*38.14*/("""
            """),_display_(/*39.14*/if(loginAccount.isDefined && loginAccount.get.userName == account.userName)/*39.89*/{_display_(Seq[Any](format.raw/*39.90*/("""
              """),format.raw/*40.15*/("""<li class="pull-right">
                <div class="button-group">
                  <a href=""""),_display_(/*42.29*/url(account.userName)),format.raw/*42.50*/("""/_edit" class="btn">Edit Your Profile</a>
                </div>
              </li>
            """)))}),format.raw/*45.14*/("""
            """),_display_(/*46.14*/if(loginAccount.isDefined && account.isGroupAccount && isGroupManager)/*46.84*/{_display_(Seq[Any](format.raw/*46.85*/("""
              """),format.raw/*47.15*/("""<li class="pull-right">
                <div class="button-group">
                  <a href=""""),_display_(/*49.29*/url(account.userName)),format.raw/*49.50*/("""/_editgroup" class="btn">Edit Group</a>
                </div>
              </li>
            """)))}),format.raw/*52.14*/("""
          """),format.raw/*53.11*/("""</ul>
          """),_display_(/*54.12*/body),format.raw/*54.16*/("""
        """),format.raw/*55.9*/("""</div>
      </div>
    </div>
  </div>
""")))}),format.raw/*59.2*/("""
"""))}
  }

  def render(account:model.Account,groupNames:List[String],active:String,isGroupManager:Boolean,body:Html,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,groupNames,active,isGroupManager)(body)(context)

  def f:((model.Account,List[String],String,Boolean) => (Html) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,groupNames,active,isGroupManager) => (body) => (context) => apply(account,groupNames,active,isGroupManager)(body)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/account/main.scala.html
                  HASH: b89b1f8c3679362893262f71689ae37e2052d43b
                  MATRIX: 396->1|666->145|693->188|704->192|735->215|773->216|802->219|1015->405|1065->434|1142->484|1158->491|1188->500|1265->550|1281->557|1311->566|1405->633|1439->658|1478->659|1521->674|1589->715|1605->722|1630->726|1660->729|1676->736|1701->740|1756->764|1797->777|1893->846|1943->874|2005->909|2037->932|2076->933|2117->946|2197->999|2216->1009|2229->1013|2282->1028|2327->1045|2364->1055|2399->1069|2429->1072|2487->1109|2538->1129|2579->1142|2628->1160|2665->1170|2807->1285|2844->1313|2883->1314|2912->1315|2958->1330|2996->1341|3038->1362|3119->1416|3154->1442|3193->1443|3236->1458|3267->1462|3299->1485|3338->1486|3367->1487|3413->1502|3451->1513|3493->1534|3556->1579|3569->1584|3608->1585|3651->1600|3682->1604|3715->1628|3754->1629|3783->1630|3829->1645|3867->1656|3909->1677|3993->1730|4034->1744|4118->1819|4157->1820|4200->1835|4322->1930|4364->1951|4493->2049|4534->2063|4613->2133|4652->2134|4695->2149|4817->2244|4859->2265|4986->2361|5025->2372|5069->2389|5094->2393|5130->2402|5201->2443
                  LINES: 13->1|18->2|19->5|19->5|19->5|19->5|20->6|25->11|25->11|26->12|26->12|26->12|27->13|27->13|27->13|30->16|30->16|30->16|31->17|31->17|31->17|31->17|31->17|31->17|31->17|32->18|33->19|33->19|33->19|35->21|35->21|35->21|36->22|38->24|38->24|38->24|38->24|39->25|39->25|39->25|39->25|39->25|40->26|41->27|42->28|44->30|47->33|47->33|47->33|47->33|47->33|47->33|47->33|48->34|48->34|48->34|49->35|49->35|49->35|49->35|49->35|49->35|49->35|49->35|50->36|50->36|50->36|51->37|51->37|51->37|51->37|51->37|51->37|51->37|51->37|52->38|53->39|53->39|53->39|54->40|56->42|56->42|59->45|60->46|60->46|60->46|61->47|63->49|63->49|66->52|67->53|68->54|68->54|69->55|73->59
                  -- GENERATED --
              */
          