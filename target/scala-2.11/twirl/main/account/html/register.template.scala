
package account.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object register extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*1.35*/("""
"""),_display_(/*4.2*/html/*4.6*/.main("Create your account")/*4.34*/{_display_(Seq[Any](format.raw/*4.35*/("""
"""),format.raw/*5.1*/("""<div class="container">
  <h3>Create your account</h3>
  <form action=""""),_display_(/*7.18*/path),format.raw/*7.22*/("""/register" method="POST" validate="true">
    <div class="row-fluid">
      <div class="span6">
        <fieldset>
          <label for="userName" class="strong">Username:</label>
          <input type="text" name="userName" id="userName" value=""/>
          <span id="error-userName" class="error"></span>
        </fieldset>
        <fieldset>
          <label for="password" class="strong">
            Password:
          </label>
          <input type="password" name="password" id="password" value=""/>
          <span id="error-password" class="error"></span>
        </fieldset>
        <fieldset>
          <label for="fullName" class="strong">Full Name:</label>
          <input type="text" name="fullName" id="fullName" value=""/>
          <span id="error-fullName" class="error"></span>
        </fieldset>
        <fieldset>
          <label for="mailAddress" class="strong">Mail Address:</label>
          <input type="text" name="mailAddress" id="mailAddress" value=""/>
          <span id="error-mailAddress" class="error"></span>
        </fieldset>
        <fieldset>
          <label for="url" class="strong">URL (optional):</label>
          <input type="text" name="url" id="url" style="width: 400px;" value=""/>
          <span id="error-url" class="error"></span>
        </fieldset>
      </div>
      <div class="span6">
        <fieldset>
          <label for="avatar" class="strong">Image (optional):</label>
          """),_display_(/*41.12*/helper/*41.18*/.html.uploadavatar(None)),format.raw/*41.42*/("""
        """),format.raw/*42.9*/("""</fieldset>
      </div>
    </div>
    <fieldset class="margin">
      <input type="submit" class="btn btn-success" value="Create account"/>
    </fieldset>
  </form>
</div>
""")))}),format.raw/*50.2*/("""
"""))}
  }

  def render(context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply()(context)

  def f:(() => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = () => (context) => apply()(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/account/register.scala.html
                  HASH: 0936ae513951780e97d5c3998b271f58e011b85e
                  MATRIX: 353->1|512->34|539->77|550->81|586->109|624->110|651->111|749->183|773->187|2249->1636|2264->1642|2309->1666|2345->1675|2551->1851
                  LINES: 13->1|17->1|18->4|18->4|18->4|18->4|19->5|21->7|21->7|55->41|55->41|55->41|56->42|64->50
                  -- GENERATED --
              */
          