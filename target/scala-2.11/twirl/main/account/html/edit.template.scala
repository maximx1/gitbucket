
package account.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object edit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[model.Account,Option[Any],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: model.Account, info: Option[Any])(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._
import util.LDAPUtil

Seq[Any](format.raw/*1.76*/("""
"""),_display_(/*5.2*/html/*5.6*/.main("Edit your profile")/*5.32*/{_display_(Seq[Any](format.raw/*5.33*/("""
"""),format.raw/*6.1*/("""<div class="container">
  <div class="row-fluid">
    <div class="span3">
      """),_display_(/*9.8*/menu("profile", settings.ssh)),format.raw/*9.37*/("""
    """),format.raw/*10.5*/("""</div>
    <div class="span9">
      """),_display_(/*12.8*/helper/*12.14*/.html.information(info)),format.raw/*12.37*/("""
      """),_display_(/*13.8*/if(LDAPUtil.isDummyMailAddress(account))/*13.48*/{_display_(Seq[Any](format.raw/*13.49*/("""<div class="alert alert-danger">Please register your mail address.</div>""")))}),format.raw/*13.122*/("""
      """),format.raw/*14.7*/("""<form action=""""),_display_(/*14.22*/url(account.userName)),format.raw/*14.43*/("""/_edit" method="POST" validate="true">
      <div class="box">
        <div class="box-header">Profile</div>
        <div class="box-content">
          <div class="row-fluid">
            <div class="span6">
              """),_display_(/*20.16*/if(account.password.nonEmpty)/*20.45*/{_display_(Seq[Any](format.raw/*20.46*/("""
                """),format.raw/*21.17*/("""<fieldset>
                  <label for="password" class="strong">
                    Password (input to change password):
                  </label>
                  <input type="password" name="password" id="password" value=""/>
                  <span id="error-password" class="error"></span>
                </fieldset>
              """)))}),format.raw/*28.16*/("""
              """),format.raw/*29.15*/("""<fieldset>
                <label for="fullName" class="strong">Full Name:</label>
                <input type="text" name="fullName" id="fullName" value=""""),_display_(/*31.74*/account/*31.81*/.fullName),format.raw/*31.90*/(""""/>
                <span id="error-fullName" class="error"></span>
              </fieldset>
              <fieldset>
                <label for="mailAddress" class="strong">Mail Address:</label>
                <input type="text" name="mailAddress" id="mailAddress" value=""""),_display_(/*36.80*/if(!LDAPUtil.isDummyMailAddress(account))/*36.121*/{_display_(_display_(/*36.123*/account/*36.130*/.mailAddress))}),format.raw/*36.143*/(""""/>
                <span id="error-mailAddress" class="error"></span>
              </fieldset>
              <fieldset>
                <label for="url" class="strong">URL (optional):</label>
                <input type="text" name="url" id="url" style="width: 300px;" value=""""),_display_(/*41.86*/account/*41.93*/.url),format.raw/*41.97*/(""""/>
                <span id="error-url" class="error"></span>
              </fieldset>
            </div>
            <div class="span6">
              <fieldset>
                <label for="avatar" class="strong">Image (optional):</label>
                """),_display_(/*48.18*/helper/*48.24*/.html.uploadavatar(Some(account))),format.raw/*48.57*/("""
              """),format.raw/*49.15*/("""</fieldset>
            </div>
          </div>
          <div style="margin-top: 20px;">
            <div class="pull-right">
              <a href=""""),_display_(/*54.25*/path),format.raw/*54.29*/("""/"""),_display_(/*54.31*/account/*54.38*/.userName),format.raw/*54.47*/("""/_delete" class="btn btn-danger" id="delete">Delete account</a>
            </div>
            <input type="submit" class="btn btn-success" value="Save"/>
            """),_display_(/*57.14*/if(!LDAPUtil.isDummyMailAddress(account))/*57.55*/{_display_(Seq[Any](format.raw/*57.56*/("""<a href=""""),_display_(/*57.66*/url(account.userName)),format.raw/*57.87*/("""" class="btn">Cancel</a>""")))}),format.raw/*57.112*/("""
          """),format.raw/*58.11*/("""</div>
        </div>
      </div>
    </form>
  </div>
</div>
""")))}),format.raw/*64.2*/("""
"""),format.raw/*65.1*/("""<script>
$(function()"""),format.raw/*66.13*/("""{"""),format.raw/*66.14*/("""
  """),format.raw/*67.3*/("""$('#delete').click(function()"""),format.raw/*67.32*/("""{"""),format.raw/*67.33*/("""
    """),format.raw/*68.5*/("""return confirm('Once you delete your account, there is no going back.\nAre you sure?');
  """),format.raw/*69.3*/("""}"""),format.raw/*69.4*/(""");
"""),format.raw/*70.1*/("""}"""),format.raw/*70.2*/(""");
</script>
"""))}
  }

  def render(account:model.Account,info:Option[Any],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,info)(context)

  def f:((model.Account,Option[Any]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,info) => (context) => apply(account,info)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/account/edit.scala.html
                  HASH: e35cd4a2b18ae1bb80816f46ef2ccc0822eaa65f
                  MATRIX: 375->1|596->75|623->140|634->144|668->170|706->171|733->172|839->253|888->282|920->287|984->325|999->331|1043->354|1077->362|1126->402|1165->403|1270->476|1304->483|1346->498|1388->519|1639->743|1677->772|1716->773|1761->790|2134->1132|2177->1147|2360->1303|2376->1310|2406->1319|2709->1595|2760->1636|2791->1638|2808->1645|2845->1658|3151->1937|3167->1944|3192->1948|3478->2207|3493->2213|3547->2246|3590->2261|3768->2412|3793->2416|3822->2418|3838->2425|3868->2434|4063->2602|4113->2643|4152->2644|4189->2654|4231->2675|4288->2700|4327->2711|4421->2775|4449->2776|4498->2797|4527->2798|4557->2801|4614->2830|4643->2831|4675->2836|4792->2926|4820->2927|4850->2930|4878->2931
                  LINES: 13->1|18->1|19->5|19->5|19->5|19->5|20->6|23->9|23->9|24->10|26->12|26->12|26->12|27->13|27->13|27->13|27->13|28->14|28->14|28->14|34->20|34->20|34->20|35->21|42->28|43->29|45->31|45->31|45->31|50->36|50->36|50->36|50->36|50->36|55->41|55->41|55->41|62->48|62->48|62->48|63->49|68->54|68->54|68->54|68->54|68->54|71->57|71->57|71->57|71->57|71->57|71->57|72->58|78->64|79->65|80->66|80->66|81->67|81->67|81->67|82->68|83->69|83->69|84->70|84->70
                  -- GENERATED --
              */
          