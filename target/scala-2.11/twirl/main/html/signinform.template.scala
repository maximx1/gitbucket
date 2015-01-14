
package html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object signinform extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[service.SystemSettingsService.SystemSettings,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(systemSettings: service.SystemSettingsService.SystemSettings)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._

Seq[Any](format.raw/*1.95*/("""
"""),format.raw/*3.1*/("""<table class="table table-bordered">
  <tr>
    <th class="metal">
      """),_display_(/*6.8*/if(systemSettings.allowAccountRegistration)/*6.51*/{_display_(Seq[Any](format.raw/*6.52*/("""
        """),format.raw/*7.9*/("""<div class="pull-right">
          <a href=""""),_display_(/*8.21*/path),format.raw/*8.25*/("""/register" class="btn btn-mini">Create new account</a>
        </div>
      """)))}),format.raw/*10.8*/("""
      """),format.raw/*11.7*/("""Sign in
    </th>
  </tr>
  <tr>
    <td>
      <form action=""""),_display_(/*16.22*/path),format.raw/*16.26*/("""/signin" method="POST" validate="true">
        <label for="userName">Username:</label>
        <span id="error-userName" class="error"></span>
        <input type="text" name="userName" id="userName" style="width: 95%"/>
        <label for="password">Password:</label>
        <span id="error-password" class="error"></span>
        <input type="password" name="password" id="password" style="width: 95%"/>
        <div>
          <input type="submit" class="btn btn-success" value="Sign in"/>
        </div>
      </form>
    </td>
  </tr>
</table>"""))}
  }

  def render(systemSettings:service.SystemSettingsService.SystemSettings,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(systemSettings)(context)

  def f:((service.SystemSettingsService.SystemSettings) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (systemSettings) => (context) => apply(systemSettings)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:10 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/signinform.scala.html
                  HASH: 08022c68b7134ae16a3bc5fb319127cd40ffeadb
                  MATRIX: 392->1|589->94|616->113|715->187|766->230|804->231|839->240|910->285|934->289|1041->366|1075->373|1165->436|1190->440
                  LINES: 13->1|16->1|17->3|20->6|20->6|20->6|21->7|22->8|22->8|24->10|25->11|30->16|30->16
                  -- GENERATED --
              */
          