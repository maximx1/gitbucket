
package account.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object ssh extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[model.Account,List[model.SshKey],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: model.Account, sshKeys: List[model.SshKey])(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*1.86*/("""
"""),_display_(/*4.2*/html/*4.6*/.main("SSH Keys")/*4.23*/{_display_(Seq[Any](format.raw/*4.24*/("""
"""),format.raw/*5.1*/("""<div class="container">
  <div class="row-fluid">
    <div class="span3">
      """),_display_(/*8.8*/menu("ssh", settings.ssh)),format.raw/*8.33*/("""
    """),format.raw/*9.5*/("""</div>
    <div class="span9">
      <div class="box">
        <div class="box-header">SSH Keys</div>
        <div class="box-content">
          """),_display_(/*14.12*/if(sshKeys.isEmpty)/*14.31*/{_display_(Seq[Any](format.raw/*14.32*/("""
            """),format.raw/*15.13*/("""No keys
          """)))}),format.raw/*16.12*/("""
          """),_display_(/*17.12*/sshKeys/*17.19*/.zipWithIndex.map/*17.36*/ { case (key, i) =>_display_(Seq[Any](format.raw/*17.55*/("""
            """),_display_(/*18.14*/if(i != 0)/*18.24*/{_display_(Seq[Any](format.raw/*18.25*/("""
              """),format.raw/*19.15*/("""<hr>
            """)))}),format.raw/*20.14*/("""
            """),format.raw/*21.13*/("""<strong>"""),_display_(/*21.22*/key/*21.25*/.title),format.raw/*21.31*/("""</strong> ("""),_display_(/*21.43*/_root_/*21.49*/.ssh.SshUtil.fingerPrint(key.publicKey).getOrElse("Key is invalid.")),format.raw/*21.117*/(""")
            <a href=""""),_display_(/*22.23*/path),format.raw/*22.27*/("""/"""),_display_(/*22.29*/account/*22.36*/.userName),format.raw/*22.45*/("""/_ssh/delete/"""),_display_(/*22.59*/key/*22.62*/.sshKeyId),format.raw/*22.71*/("""" class="btn btn-mini btn-danger pull-right">Delete</a>
          """)))}),format.raw/*23.12*/("""
        """),format.raw/*24.9*/("""</div>
      </div>
      <form method="POST" action=""""),_display_(/*26.36*/path),format.raw/*26.40*/("""/"""),_display_(/*26.42*/account/*26.49*/.userName),format.raw/*26.58*/("""/_ssh" validate="true">
        <div class="box">
          <div class="box-header">Add an SSH Key</div>
          <div class="box-content">
            <fieldset>
              <label for="title" class="strong">Title</label>
              <div><span id="error-title" class="error"></span></div>
              <input type="text" name="title" id="title" style="width: 400px;"/>
            </fieldset>
            <fieldset>
              <label for="publicKey" class="strong">Key</label>
              <div><span id="error-publicKey" class="error"></span></div>
              <textarea name="publicKey" id="publicKey" style="width: 600px; height: 250px;"></textarea>
            </fieldset>
            <input type="submit" class="btn btn-success" value="Add"/>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
""")))}),format.raw/*47.2*/("""
"""))}
  }

  def render(account:model.Account,sshKeys:List[model.SshKey],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,sshKeys)(context)

  def f:((model.Account,List[model.SshKey]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,sshKeys) => (context) => apply(account,sshKeys)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/account/ssh.scala.html
                  HASH: e4638174e0b1d9c5adc8f8b93b27331914b8b550
                  MATRIX: 381->1|591->85|618->128|629->132|654->149|692->150|719->151|825->232|870->257|901->262|1075->409|1103->428|1142->429|1183->442|1233->461|1272->473|1288->480|1314->497|1371->516|1412->530|1431->540|1470->541|1513->556|1562->574|1603->587|1639->596|1651->599|1678->605|1717->617|1732->623|1822->691|1873->715|1898->719|1927->721|1943->728|1973->737|2014->751|2026->754|2056->763|2154->830|2190->839|2272->894|2297->898|2326->900|2342->907|2372->916|3238->1752
                  LINES: 13->1|17->1|18->4|18->4|18->4|18->4|19->5|22->8|22->8|23->9|28->14|28->14|28->14|29->15|30->16|31->17|31->17|31->17|31->17|32->18|32->18|32->18|33->19|34->20|35->21|35->21|35->21|35->21|35->21|35->21|35->21|36->22|36->22|36->22|36->22|36->22|36->22|36->22|36->22|37->23|38->24|40->26|40->26|40->26|40->26|40->26|61->47
                  -- GENERATED --
              */
          