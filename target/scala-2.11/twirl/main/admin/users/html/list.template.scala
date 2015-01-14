
package admin.users.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object list extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[List[model.Account],Map[String, List[String]],Boolean,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(users: List[model.Account], members: Map[String, List[String]], includeRemoved: Boolean)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*1.122*/("""
"""),_display_(/*4.2*/html/*4.6*/.main("Manage Users")/*4.27*/{_display_(Seq[Any](format.raw/*4.28*/("""
  """),_display_(/*5.4*/admin/*5.9*/.html.menu("users")/*5.28*/{_display_(Seq[Any](format.raw/*5.29*/("""
    """),format.raw/*6.5*/("""<div class="pull-right" style="margin-bottom: 4px;">
      <a href=""""),_display_(/*7.17*/path),format.raw/*7.21*/("""/admin/users/_newuser" class="btn">New User</a>
      <a href=""""),_display_(/*8.17*/path),format.raw/*8.21*/("""/admin/users/_newgroup" class="btn">New Group</a>
    </div>
    <label for="includeRemoved">
      <input type="checkbox" id="includeRemoved" name="includeRemoved" """),_display_(/*11.73*/if(includeRemoved)/*11.91*/{_display_(Seq[Any](format.raw/*11.92*/("""checked""")))}),format.raw/*11.100*/("""/>
      Include removed users
    </label>
    <table class="table table-bordered table-hover">
      """),_display_(/*15.8*/users/*15.13*/.map/*15.17*/ { account =>_display_(Seq[Any](format.raw/*15.30*/("""
        """),format.raw/*16.9*/("""<tr>
          <td """),_display_(/*17.16*/if(account.isRemoved)/*17.37*/{_display_(Seq[Any](format.raw/*17.38*/("""style="background-color: #dddddd;"""")))}),format.raw/*17.73*/(""">
            <div class="pull-right">
              """),_display_(/*19.16*/if(account.isGroupAccount)/*19.42*/{_display_(Seq[Any](format.raw/*19.43*/("""
                """),format.raw/*20.17*/("""<a href=""""),_display_(/*20.27*/path),format.raw/*20.31*/("""/admin/users/"""),_display_(/*20.45*/account/*20.52*/.userName),format.raw/*20.61*/("""/_editgroup">Edit</a>
              """)))}/*21.17*/else/*21.22*/{_display_(Seq[Any](format.raw/*21.23*/("""
                """),format.raw/*22.17*/("""<a href=""""),_display_(/*22.27*/path),format.raw/*22.31*/("""/admin/users/"""),_display_(/*22.45*/account/*22.52*/.userName),format.raw/*22.61*/("""/_edituser">Edit</a>
              """)))}),format.raw/*23.16*/("""
            """),format.raw/*24.13*/("""</div>
            <div class="strong">
              """),_display_(/*26.16*/avatar(account.userName, 20)),format.raw/*26.44*/("""
              """),format.raw/*27.15*/("""<a href=""""),_display_(/*27.25*/url(account.userName)),format.raw/*27.46*/("""">"""),_display_(/*27.49*/account/*27.56*/.userName),format.raw/*27.65*/("""</a>
              """),_display_(/*28.16*/if(account.isGroupAccount)/*28.42*/{_display_(Seq[Any](format.raw/*28.43*/("""
                """),format.raw/*29.17*/("""(Group)
              """)))}/*30.17*/else/*30.22*/{_display_(Seq[Any](format.raw/*30.23*/("""
                """),_display_(/*31.18*/if(account.isAdmin)/*31.37*/{_display_(Seq[Any](format.raw/*31.38*/("""
                  """),format.raw/*32.19*/("""(Administrator)
                """)))}/*33.19*/else/*33.24*/{_display_(Seq[Any](format.raw/*33.25*/("""
                  """),format.raw/*34.19*/("""(Normal)
                """)))}),format.raw/*35.18*/("""
              """)))}),format.raw/*36.16*/("""
              """),_display_(/*37.16*/if(account.isGroupAccount)/*37.42*/{_display_(Seq[Any](format.raw/*37.43*/("""
                """),_display_(/*38.18*/members(account.userName)/*38.43*/.map/*38.47*/ { userName =>_display_(Seq[Any](format.raw/*38.61*/("""
                  """),_display_(/*39.20*/avatar(userName, 20, tooltip = true)),format.raw/*39.56*/("""
                """)))}),format.raw/*40.18*/("""
              """)))}),format.raw/*41.16*/("""
            """),format.raw/*42.13*/("""</div>
            <div>
              <hr>
              """),_display_(/*45.16*/if(!account.isGroupAccount)/*45.43*/{_display_(Seq[Any](format.raw/*45.44*/("""
                """),format.raw/*46.17*/("""<i class="icon-envelope"></i> """),_display_(/*46.48*/account/*46.55*/.mailAddress),format.raw/*46.67*/("""
              """)))}),format.raw/*47.16*/("""
              """),_display_(/*48.16*/account/*48.23*/.url.map/*48.31*/ { url =>_display_(Seq[Any](format.raw/*48.40*/("""
                """),format.raw/*49.17*/("""<i class="icon-home"></i> """),_display_(/*49.44*/url),format.raw/*49.47*/("""
              """)))}),format.raw/*50.16*/("""
            """),format.raw/*51.13*/("""</div>
            <div>
              <span class="muted">Registered:</span> """),_display_(/*53.55*/datetime(account.registeredDate)),format.raw/*53.87*/("""
              """),format.raw/*54.15*/("""<span class="muted">Updated:</span> """),_display_(/*54.52*/datetime(account.updatedDate)),format.raw/*54.81*/("""
              """),_display_(/*55.16*/if(!account.isGroupAccount)/*55.43*/{_display_(Seq[Any](format.raw/*55.44*/("""
                """),format.raw/*56.17*/("""<span class="muted">Last Login:</span> """),_display_(/*56.57*/account/*56.64*/.lastLoginDate.map(datetime)),format.raw/*56.92*/("""
              """)))}),format.raw/*57.16*/("""
            """),format.raw/*58.13*/("""</div>
          </td>
        </tr>
      """)))}),format.raw/*61.8*/("""
    """),format.raw/*62.5*/("""</table>
  """)))}),format.raw/*63.4*/("""
""")))}),format.raw/*64.2*/("""
"""),format.raw/*65.1*/("""<script>
$(function()"""),format.raw/*66.13*/("""{"""),format.raw/*66.14*/("""
  """),format.raw/*67.3*/("""$('#includeRemoved').click(function()"""),format.raw/*67.40*/("""{"""),format.raw/*67.41*/("""
    """),format.raw/*68.5*/("""location.href = '"""),_display_(/*68.23*/path),format.raw/*68.27*/("""/admin/users?includeRemoved=' + this.checked;
  """),format.raw/*69.3*/("""}"""),format.raw/*69.4*/(""");
"""),format.raw/*70.1*/("""}"""),format.raw/*70.2*/(""");
</script>"""))}
  }

  def render(users:List[model.Account],members:Map[String, List[String]],includeRemoved:Boolean,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(users,members,includeRemoved)(context)

  def f:((List[model.Account],Map[String, List[String]],Boolean) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (users,members,includeRemoved) => (context) => apply(users,members,includeRemoved)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/admin/users/list.scala.html
                  HASH: ac13d19202881eb56f3d901676e84be07e87316e
                  MATRIX: 407->1|654->121|681->164|692->168|721->189|759->190|788->194|800->199|827->218|865->219|896->224|991->293|1015->297|1105->361|1129->365|1322->531|1349->549|1388->550|1428->558|1558->662|1572->667|1585->671|1636->684|1672->693|1719->713|1749->734|1788->735|1854->770|1935->824|1970->850|2009->851|2054->868|2091->878|2116->882|2157->896|2173->903|2203->912|2259->950|2272->955|2311->956|2356->973|2393->983|2418->987|2459->1001|2475->1008|2505->1017|2572->1053|2613->1066|2695->1121|2744->1149|2787->1164|2824->1174|2866->1195|2896->1198|2912->1205|2942->1214|2989->1234|3024->1260|3063->1261|3108->1278|3150->1302|3163->1307|3202->1308|3247->1326|3275->1345|3314->1346|3361->1365|3413->1399|3426->1404|3465->1405|3512->1424|3569->1450|3616->1466|3659->1482|3694->1508|3733->1509|3778->1527|3812->1552|3825->1556|3877->1570|3924->1590|3981->1626|4030->1644|4077->1660|4118->1673|4204->1732|4240->1759|4279->1760|4324->1777|4382->1808|4398->1815|4431->1827|4478->1843|4521->1859|4537->1866|4554->1874|4601->1883|4646->1900|4700->1927|4724->1930|4771->1946|4812->1959|4918->2038|4971->2070|5014->2085|5078->2122|5128->2151|5171->2167|5207->2194|5246->2195|5291->2212|5358->2252|5374->2259|5423->2287|5470->2303|5511->2316|5585->2360|5617->2365|5659->2377|5691->2379|5719->2380|5768->2401|5797->2402|5827->2405|5892->2442|5921->2443|5953->2448|5998->2466|6023->2470|6098->2518|6126->2519|6156->2522|6184->2523
                  LINES: 13->1|17->1|18->4|18->4|18->4|18->4|19->5|19->5|19->5|19->5|20->6|21->7|21->7|22->8|22->8|25->11|25->11|25->11|25->11|29->15|29->15|29->15|29->15|30->16|31->17|31->17|31->17|31->17|33->19|33->19|33->19|34->20|34->20|34->20|34->20|34->20|34->20|35->21|35->21|35->21|36->22|36->22|36->22|36->22|36->22|36->22|37->23|38->24|40->26|40->26|41->27|41->27|41->27|41->27|41->27|41->27|42->28|42->28|42->28|43->29|44->30|44->30|44->30|45->31|45->31|45->31|46->32|47->33|47->33|47->33|48->34|49->35|50->36|51->37|51->37|51->37|52->38|52->38|52->38|52->38|53->39|53->39|54->40|55->41|56->42|59->45|59->45|59->45|60->46|60->46|60->46|60->46|61->47|62->48|62->48|62->48|62->48|63->49|63->49|63->49|64->50|65->51|67->53|67->53|68->54|68->54|68->54|69->55|69->55|69->55|70->56|70->56|70->56|70->56|71->57|72->58|75->61|76->62|77->63|78->64|79->65|80->66|80->66|81->67|81->67|81->67|82->68|82->68|82->68|83->69|83->69|84->70|84->70
                  -- GENERATED --
              */
          