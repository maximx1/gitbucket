
package admin.users.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object user extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Option[model.Account],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: Option[model.Account])(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._

Seq[Any](format.raw/*1.65*/("""
"""),_display_(/*3.2*/html/*3.6*/.main(if(account.isEmpty) "New User" else "Update User")/*3.62*/{_display_(Seq[Any](format.raw/*3.63*/("""
  """),_display_(/*4.4*/admin/*4.9*/.html.menu("users")/*4.28*/{_display_(Seq[Any](format.raw/*4.29*/("""
    """),format.raw/*5.5*/("""<form method="POST" action=""""),_display_(/*5.34*/if(account.isEmpty)/*5.53*/{_display_(Seq[Any](_display_(/*5.55*/path),format.raw/*5.59*/("""/admin/users/_newuser""")))}/*5.82*/else/*5.87*/{_display_(Seq[Any](_display_(/*5.89*/path),format.raw/*5.93*/("""/admin/users/"""),_display_(/*5.107*/account/*5.114*/.get.userName),format.raw/*5.127*/("""/_edituser""")))}),format.raw/*5.138*/("""" validate="true">
      <div class="row-fluid">
        <div class="span6">
          <fieldset>
            <label for="userName" class="strong">Username:</label>
            <div>
              <span id="error-userName" class="error"></span>
            </div>
            <input type="text" name="userName" id="userName" value=""""),_display_(/*13.70*/account/*13.77*/.map(_.userName)),format.raw/*13.93*/("""""""),_display_(/*13.95*/if(account.isDefined)/*13.116*/{_display_(Seq[Any](format.raw/*13.117*/(""" """),format.raw/*13.118*/("""readonly""")))}),format.raw/*13.127*/("""/>
            """),_display_(/*14.14*/if(account.isDefined)/*14.35*/{_display_(Seq[Any](format.raw/*14.36*/("""
              """),format.raw/*15.15*/("""<label for="removed">
                <input type="checkbox" name="removed" id="removed" value="true" """),_display_(/*16.82*/if(account.get.isRemoved)/*16.107*/{_display_(Seq[Any](format.raw/*16.108*/("""checked""")))}),format.raw/*16.116*/("""/>
                Disable
              </label>
              <div>
                <span id="error-removed" class="error"></span>
              </div>
            """)))}),format.raw/*22.14*/("""
          """),format.raw/*23.11*/("""</fieldset>
          """),_display_(/*24.12*/if(account.map(_.password.nonEmpty).getOrElse(true))/*24.64*/{_display_(Seq[Any](format.raw/*24.65*/("""
            """),format.raw/*25.13*/("""<fieldset>
              <label for="password" class="strong">
                Password
                """),_display_(/*28.18*/if(account.isDefined)/*28.39*/{_display_(Seq[Any](format.raw/*28.40*/("""
                  """),format.raw/*29.19*/("""(Input to change password)
                """)))}),format.raw/*30.18*/("""
                """),format.raw/*31.17*/(""":
              </label>
              <div>
                <span id="error-password" class="error"></span>
              </div>
              <input type="password" name="password" id="password" value="" autocomplete="off"/>
            </fieldset>
          """)))}),format.raw/*38.12*/("""
          """),format.raw/*39.11*/("""<fieldset>
            <label for="fullName" class="strong">Full Name:</label>
            <div>
              <span id="error-fullName" class="error"></span>
            </div>
            <input type="text" name="fullName" id="fullName" value=""""),_display_(/*44.70*/account/*44.77*/.map(_.fullName)),format.raw/*44.93*/(""""/>
          </fieldset>
          <fieldset>
            <label for="mailAddress" class="strong">Mail Address:</label>
            <div>
              <span id="error-mailAddress" class="error"></span>
            </div>
            <input type="text" name="mailAddress" id="mailAddress" value=""""),_display_(/*51.76*/account/*51.83*/.map(_.mailAddress)),format.raw/*51.102*/(""""/>
          </fieldset>
          <fieldset>
            <label class="strong">User Type:</label>
            <label class="radio" for="userType_Normal">
              <input type="radio" name="isAdmin" id="userType_Normal" value="false""""),_display_(/*56.85*/if(account.isEmpty || !account.get.isAdmin)/*56.128*/{_display_(Seq[Any](format.raw/*56.129*/(""" """),format.raw/*56.130*/("""checked""")))}),format.raw/*56.138*/("""/> Normal
            </label>
            <label class="radio" for="userType_Admin">
              <input type="radio" name="isAdmin" id="userType_Admin" value="true""""),_display_(/*59.83*/if(account.isDefined && account.get.isAdmin)/*59.127*/{_display_(Seq[Any](format.raw/*59.128*/(""" """),format.raw/*59.129*/("""checked""")))}),format.raw/*59.137*/("""/> Administrator
            </label>
          </fieldset>
          <fieldset>
            <label class="strong">URL (Optional):</label>
            <div>
              <span id="error-url" class="error"></span>
            </div>
            <input type="text" name="url" id="url" style="width: 400px;" value=""""),_display_(/*67.82*/account/*67.89*/.map(_.url)),format.raw/*67.100*/(""""/>
          </fieldset>
        </div>
        <div class="span6">
          <fieldset>
            <label for="avatar" class="strong">Image (Optional)</label>
            """),_display_(/*73.14*/helper/*73.20*/.html.uploadavatar(account)),format.raw/*73.47*/("""
          """),format.raw/*74.11*/("""</fieldset>
        </div>
      </div>
      <fieldset class="margin">
        <input type="submit" class="btn btn-success" value=""""),_display_(/*78.62*/if(account.isEmpty)/*78.81*/{_display_(Seq[Any](format.raw/*78.82*/("""Create User""")))}/*78.95*/else/*78.100*/{_display_(Seq[Any](format.raw/*78.101*/("""Update User""")))}),format.raw/*78.113*/(""""/>
        <a href=""""),_display_(/*79.19*/path),format.raw/*79.23*/("""/admin/users" class="btn">Cancel</a>
      </fieldset>
    </form>
  """)))}),format.raw/*82.4*/("""
""")))}),format.raw/*83.2*/("""
"""))}
  }

  def render(account:Option[model.Account],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(account)(context)

  def f:((Option[model.Account]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (account) => (context) => apply(account)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/admin/users/user.scala.html
                  HASH: e28ccd841f9f887f612922ba13642909f0296486
                  MATRIX: 375->1|542->64|569->84|580->88|644->144|682->145|711->149|723->154|750->173|788->174|819->179|874->208|901->227|939->229|963->233|1003->256|1015->261|1053->263|1077->267|1118->281|1134->288|1168->301|1210->312|1570->645|1586->652|1623->668|1652->670|1683->691|1723->692|1753->693|1794->702|1837->718|1867->739|1906->740|1949->755|2079->858|2114->883|2154->884|2194->892|2392->1059|2431->1070|2481->1093|2542->1145|2581->1146|2622->1159|2754->1264|2784->1285|2823->1286|2870->1305|2945->1349|2990->1366|3283->1628|3322->1639|3596->1886|3612->1893|3649->1909|3974->2207|3990->2214|4031->2233|4298->2473|4351->2516|4391->2517|4421->2518|4461->2526|4656->2694|4710->2738|4750->2739|4780->2740|4820->2748|5161->3062|5177->3069|5210->3080|5412->3255|5427->3261|5475->3288|5514->3299|5674->3432|5702->3451|5741->3452|5772->3465|5786->3470|5826->3471|5870->3483|5919->3505|5944->3509|6044->3579|6076->3581
                  LINES: 13->1|16->1|17->3|17->3|17->3|17->3|18->4|18->4|18->4|18->4|19->5|19->5|19->5|19->5|19->5|19->5|19->5|19->5|19->5|19->5|19->5|19->5|19->5|27->13|27->13|27->13|27->13|27->13|27->13|27->13|27->13|28->14|28->14|28->14|29->15|30->16|30->16|30->16|30->16|36->22|37->23|38->24|38->24|38->24|39->25|42->28|42->28|42->28|43->29|44->30|45->31|52->38|53->39|58->44|58->44|58->44|65->51|65->51|65->51|70->56|70->56|70->56|70->56|70->56|73->59|73->59|73->59|73->59|73->59|81->67|81->67|81->67|87->73|87->73|87->73|88->74|92->78|92->78|92->78|92->78|92->78|92->78|92->78|93->79|93->79|96->82|97->83
                  -- GENERATED --
              */
          