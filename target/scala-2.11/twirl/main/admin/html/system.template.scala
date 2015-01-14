
package admin.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object system extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Option[Any],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(info: Option[Any])(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import util.Directory._
import view.helpers._

Seq[Any](format.raw/*1.52*/("""
"""),_display_(/*5.2*/html/*5.6*/.main("System Settings")/*5.30*/{_display_(Seq[Any](format.raw/*5.31*/("""
  """),_display_(/*6.4*/menu("system")/*6.18*/{_display_(Seq[Any](format.raw/*6.19*/("""
    """),_display_(/*7.6*/helper/*7.12*/.html.information(info)),format.raw/*7.35*/("""
    """),format.raw/*8.5*/("""<form action=""""),_display_(/*8.20*/path),format.raw/*8.24*/("""/admin/system" method="POST" validate="true">
      <div class="box">
        <div class="box-header">System Settings</div>
        <div class="box-content">
          <!--====================================================================-->
          <!-- GITBUCKET_HOME -->
          <!--====================================================================-->
          <label class="strong">GITBUCKET_HOME</label>
          """),_display_(/*16.12*/GitBucketHome),format.raw/*16.25*/("""
          """),format.raw/*17.11*/("""<!--====================================================================-->
          <!-- Base URL -->
          <!--====================================================================-->
          <hr>
          <label><span class="strong">Base URL</span> (e.g. <code>http://example.com/gitbucket</code>)</label>
          <fieldset>
              <div class="controls">
                <input type="text" name="baseUrl" id="baseUrl" style="width: 400px" value=""""),_display_(/*24.93*/settings/*24.101*/.baseUrl),format.raw/*24.109*/(""""/>
                <span id="error-baseUrl" class="error"></span>
              </div>
          </fieldset>
          <p class="muted">
            The base URL is used for redirect, notification email, git repository URL box and more.
            If the base URL is empty, GitBucket generates URL from request information.
            You can use this property to adjust URL difference between the reverse proxy and GitBucket.
          </p>
          <!--====================================================================-->
          <!-- Information -->
          <!--====================================================================-->
          <hr>
          <label><span class="strong">Information</span> (HTML is available)</label>
          <fieldset>
            <textarea name="information" style="width: 600px; height: 100px;">"""),_display_(/*39.80*/settings/*39.88*/.information),format.raw/*39.100*/("""</textarea>
          </fieldset>
          <!--====================================================================-->
          <!-- Account registration -->
          <!--====================================================================-->
          <hr>
          <label class="strong">Account registration</label>
          <fieldset>
            <label class="radio">
              <input type="radio" name="allowAccountRegistration" value="true""""),_display_(/*48.80*/if(settings.allowAccountRegistration)/*48.117*/{_display_(Seq[Any](format.raw/*48.118*/(""" """),format.raw/*48.119*/("""checked""")))}),format.raw/*48.127*/(""">
              <span class="strong">Allow</span> - Users can create accounts by themselves.
            </label>
            <label class="radio">
              <input type="radio" name="allowAccountRegistration" value="false""""),_display_(/*52.81*/if(!settings.allowAccountRegistration)/*52.119*/{_display_(Seq[Any](format.raw/*52.120*/(""" """),format.raw/*52.121*/("""checked""")))}),format.raw/*52.129*/(""">
              <span class="strong">Deny</span> - Only administrators can create accounts.
            </label>
          </fieldset>
          <!--====================================================================-->
          <!-- Services -->
          <!--====================================================================-->
          <hr>
          <label class="strong">Services</label>
          <fieldset>
            <label class="checkbox">
              <input type="checkbox" name="gravatar""""),_display_(/*63.54*/if(settings.gravatar)/*63.75*/{_display_(Seq[Any](format.raw/*63.76*/(""" """),format.raw/*63.77*/("""checked""")))}),format.raw/*63.85*/("""/>
              Use Gravatar for Profile-Images
            </label>
          </fieldset>
          <!--====================================================================-->
          <!-- SSH access -->
          <!--====================================================================-->
          <hr>
          <label class="strong">SSH access</label>
          <fieldset>
            <label class="checkbox">
              <input type="checkbox" id="ssh" name="ssh""""),_display_(/*74.58*/if(settings.ssh)/*74.74*/{_display_(Seq[Any](format.raw/*74.75*/(""" """),format.raw/*74.76*/("""checked""")))}),format.raw/*74.84*/("""/>
              Enable SSH access to git repository
            </label>
          </fieldset>
          <div class="form-horizontal ssh">
            <div class="control-group">
              <label class="control-label" for="sshPort">SSH Port</label>
              <div class="controls">
                <input type="text" id="sshPort" name="sshPort" value=""""),_display_(/*82.72*/settings/*82.80*/.sshPort),format.raw/*82.88*/(""""/>
                <span id="error-sshPort" class="error"></span>
              </div>
            </div>
          </div>
          <p class="muted">
            Base URL is required if SSH access is enabled.
          </p>
          <!--====================================================================-->
          <!-- Authentication -->
          <!--====================================================================-->
          <hr>
          <label class="strong">Authentication</label>
          <fieldset>
            <label class="checkbox">
              <input type="checkbox" id="ldapAuthentication" name="ldapAuthentication""""),_display_(/*97.88*/if(settings.ldap)/*97.105*/{_display_(Seq[Any](format.raw/*97.106*/(""" """),format.raw/*97.107*/("""checked""")))}),format.raw/*97.115*/("""/>
              LDAP
            </label>
          </fieldset>
          <div class="form-horizontal ldap">
            <div class="control-group">
              <label class="control-label" for="ldapHost">LDAP Host</label>
              <div class="controls">
                <input type="text" id="ldapHost" name="ldap.host" value=""""),_display_(/*105.75*/settings/*105.83*/.ldap.map(_.host)),format.raw/*105.100*/(""""/>
                <span id="error-ldap_host" class="error"></span>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="ldapPort">LDAP Port</label>
              <div class="controls">
                <input type="text" id="ldapPort" name="ldap.port" class="input-mini" value=""""),_display_(/*112.94*/settings/*112.102*/.ldap.map(_.port)),format.raw/*112.119*/(""""/>
                <span id="error-ldap_port" class="error"></span>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="ldapBindDN">Bind DN</label>
              <div class="controls">
                <input type="text" id="ldapBindDN" name="ldap.bindDN" value=""""),_display_(/*119.79*/settings/*119.87*/.ldap.map(_.bindDN)),format.raw/*119.106*/(""""/>
                <span id="error-ldap_bindDN" class="error"></span>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="ldapBindPassword">Bind Password</label>
              <div class="controls">
                <input type="password" id="ldapBindPassword" name="ldap.bindPassword" value=""""),_display_(/*126.95*/settings/*126.103*/.ldap.map(_.bindPassword)),format.raw/*126.128*/(""""/>
                <span id="error-ldap_bindPassword" class="error"></span>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="ldapBaseDN">Base DN</label>
              <div class="controls">
                <input type="text" id="ldapBaseDN" name="ldap.baseDN" value=""""),_display_(/*133.79*/settings/*133.87*/.ldap.map(_.baseDN)),format.raw/*133.106*/(""""/>
                <span id="error-ldap_baseDN" class="error"></span>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="ldapUserNameAttribute">User name attribute</label>
              <div class="controls">
                <input type="text" id="ldapUserNameAttribute" name="ldap.userNameAttribute" value=""""),_display_(/*140.101*/settings/*140.109*/.ldap.map(_.userNameAttribute)),format.raw/*140.139*/(""""/>
                <span id="error-ldap_userNameAttribute" class="error"></span>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="ldapAdditionalFilterCondition">Additional filter condition</label>
              <div class="controls">
                <input type="text" id="ldapAdditionalFilterCondition" name="ldap.additionalFilterCondition" value=""""),_display_(/*147.117*/settings/*147.125*/.ldap.map(_.additionalFilterCondition)),format.raw/*147.163*/(""""/>
                <span id="error-ldap_additionalFilterCondition" class="error"></span>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="ldapFullNameAttribute">Full name attribute</label>
              <div class="controls">
                <input type="text" id="ldapFullNameAttribute" name="ldap.fullNameAttribute" value=""""),_display_(/*154.101*/settings/*154.109*/.ldap.map(_.fullNameAttribute)),format.raw/*154.139*/(""""/>
                <span id="error-ldap_fullNameAttribute" class="error"></span>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="ldapMailAttribute">Mail address attribute</label>
              <div class="controls">
                <input type="text" id="ldapMailAttribute" name="ldap.mailAttribute" value=""""),_display_(/*161.93*/settings/*161.101*/.ldap.map(_.mailAttribute)),format.raw/*161.127*/(""""/>
                <span id="error-ldap_mailAttribute" class="error"></span>
              </div>
            </div>
            <div class="control-group">
              <div class="controls">
                <label class="checkbox">
                  <input type="checkbox" name="ldap.tls""""),_display_(/*168.58*/if(settings.ldap.flatMap(_.tls).getOrElse(false))/*168.107*/{_display_(Seq[Any](format.raw/*168.108*/(""" """),format.raw/*168.109*/("""checked""")))}),format.raw/*168.117*/("""/> Enable TLS
                </label>
              </div>
            </div>
            <div class="control-group">
              <div class="controls">
                <label class="checkbox">
                  <input type="checkbox" name="ldap.ssl""""),_display_(/*175.58*/if(settings.ldap.flatMap(_.ssl).getOrElse(false))/*175.107*/{_display_(Seq[Any](format.raw/*175.108*/(""" """),format.raw/*175.109*/("""checked""")))}),format.raw/*175.117*/("""/> Enable SSL
                </label>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="ldapBindDN">Keystore</label>
              <div class="controls">
                <input type="text" id="ldapKeystore" name="ldap.keystore" value=""""),_display_(/*182.83*/settings/*182.91*/.ldap.map(_.keystore)),format.raw/*182.112*/(""""/>
                <span id="error-ldap_keystore" class="error"></span>
              </div>
            </div>
          </div>
          <!--====================================================================-->
          <!-- Notification email -->
          <!--====================================================================-->
          <hr>
          <label class="strong">Notification email</label>
          <fieldset>
            <label class="checkbox">
              <input type="checkbox" id="notification" name="notification""""),_display_(/*194.76*/if(settings.notification)/*194.101*/{_display_(Seq[Any](format.raw/*194.102*/(""" """),format.raw/*194.103*/("""checked""")))}),format.raw/*194.111*/("""/>
              Send notifications
            </label>
          </fieldset>
          <div class="form-horizontal notification">
            <div class="control-group">
              <label class="control-label" for="smtpHost">SMTP Host</label>
              <div class="controls">
                <input type="text" id="smtpHost" name="smtp.host" value=""""),_display_(/*202.75*/settings/*202.83*/.smtp.map(_.host)),format.raw/*202.100*/(""""/>
                <span id="error-smtp_host" class="error"></span>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="smtpPort">SMTP Port</label>
              <div class="controls">
                <input type="text" id="smtpPort" name="smtp.port" class="input-mini" value=""""),_display_(/*209.94*/settings/*209.102*/.smtp.map(_.port)),format.raw/*209.119*/(""""/>
                <span id="error-smtp_port" class="error"></span>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="smtpUser">SMTP User</label>
              <div class="controls">
                <input type="text" id="smtpUser" name="smtp.user" value=""""),_display_(/*216.75*/settings/*216.83*/.smtp.map(_.user)),format.raw/*216.100*/(""""/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="smtpPassword">SMTP Password</label>
              <div class="controls">
                <input type="password" id="smtpPassword" name="smtp.password" value=""""),_display_(/*222.87*/settings/*222.95*/.smtp.map(_.password)),format.raw/*222.116*/(""""/>
              </div>
            </div>
            <div class="control-group">
              <div class="controls">
                <label class="checkbox">
                  <input type="checkbox" name="smtp.ssl""""),_display_(/*228.58*/if(settings.smtp.flatMap(_.ssl).getOrElse(false))/*228.107*/{_display_(Seq[Any](format.raw/*228.108*/(""" """),format.raw/*228.109*/("""checked""")))}),format.raw/*228.117*/("""/> Enable SSL
                </label>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="fromAddress">FROM Address</label>
              <div class="controls">
                <input type="text" id="fromAddress" name="smtp.fromAddress" value=""""),_display_(/*235.85*/settings/*235.93*/.smtp.map(_.fromAddress)),format.raw/*235.117*/(""""/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="fromName">FROM Name</label>
              <div class="controls">
                <input type="text" id="fromName" name="smtp.fromName" value=""""),_display_(/*241.79*/settings/*241.87*/.smtp.map(_.fromName)),format.raw/*241.108*/(""""/>
              </div>
            </div>
          </div>
        </div>
      </div>
      <fieldset>
        <input type="submit" class="btn btn-success" value="Apply changes"/>
      </fieldset>
    </form>
  """)))}),format.raw/*251.4*/("""
""")))}),format.raw/*252.2*/("""
"""),format.raw/*253.1*/("""<script>
$(function()"""),format.raw/*254.13*/("""{"""),format.raw/*254.14*/("""
  """),format.raw/*255.3*/("""$('#ssh').change(function()"""),format.raw/*255.30*/("""{"""),format.raw/*255.31*/("""
    """),format.raw/*256.5*/("""$('.ssh input').prop('disabled', !$(this).prop('checked'));
  """),format.raw/*257.3*/("""}"""),format.raw/*257.4*/(""").change();

  $('#notification').change(function()"""),format.raw/*259.39*/("""{"""),format.raw/*259.40*/("""
    """),format.raw/*260.5*/("""$('.notification input').prop('disabled', !$(this).prop('checked'));
  """),format.raw/*261.3*/("""}"""),format.raw/*261.4*/(""").change();

  $('#ldapAuthentication').change(function()"""),format.raw/*263.45*/("""{"""),format.raw/*263.46*/("""
    """),format.raw/*264.5*/("""$('.ldap input').prop('disabled', !$(this).prop('checked'));
  """),format.raw/*265.3*/("""}"""),format.raw/*265.4*/(""").change();
"""),format.raw/*266.1*/("""}"""),format.raw/*266.2*/(""");
</script>"""))}
  }

  def render(info:Option[Any],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(info)(context)

  def f:((Option[Any]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (info) => (context) => apply(info)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/admin/system.scala.html
                  HASH: 1d2d6ccdb155d2aa7a0b5e1cd3ab1a12b509e70d
                  MATRIX: 361->1|561->51|588->119|599->123|631->147|669->148|698->152|720->166|758->167|789->173|803->179|846->202|877->207|918->222|942->226|1399->656|1433->669|1472->680|1965->1146|1983->1154|2013->1162|2888->2010|2905->2018|2939->2030|3422->2486|3469->2523|3509->2524|3539->2525|3579->2533|3834->2761|3882->2799|3922->2800|3952->2801|3992->2809|4529->3319|4559->3340|4598->3341|4627->3342|4666->3350|5168->3825|5193->3841|5232->3842|5261->3843|5300->3851|5689->4213|5706->4221|5735->4229|6409->4876|6436->4893|6476->4894|6506->4895|6546->4903|6911->5240|6929->5248|6969->5265|7352->5620|7371->5628|7411->5645|7779->5985|7797->5993|7839->6012|8237->6382|8256->6390|8304->6415|8680->6763|8698->6771|8740->6790|9156->7177|9175->7185|9228->7215|9687->7645|9706->7653|9767->7691|10202->8097|10221->8105|10274->8135|10691->8524|10710->8532|10759->8558|11080->8851|11140->8900|11181->8901|11212->8902|11253->8910|11535->9164|11595->9213|11636->9214|11667->9215|11708->9223|12051->9538|12069->9546|12113->9567|12688->10114|12724->10139|12765->10140|12796->10141|12837->10149|13224->10508|13242->10516|13282->10533|13665->10888|13684->10896|13724->10913|14088->11249|14106->11257|14146->11274|14465->11565|14483->11573|14527->11594|14774->11813|14834->11862|14875->11863|14906->11864|14947->11872|15297->12194|15315->12202|15362->12226|15665->12501|15683->12509|15727->12530|15974->12746|16007->12748|16036->12749|16086->12770|16116->12771|16147->12774|16203->12801|16233->12802|16266->12807|16356->12869|16385->12870|16465->12921|16495->12922|16528->12927|16627->12998|16656->12999|16742->13056|16772->13057|16805->13062|16896->13125|16925->13126|16965->13138|16994->13139
                  LINES: 13->1|18->1|19->5|19->5|19->5|19->5|20->6|20->6|20->6|21->7|21->7|21->7|22->8|22->8|22->8|30->16|30->16|31->17|38->24|38->24|38->24|53->39|53->39|53->39|62->48|62->48|62->48|62->48|62->48|66->52|66->52|66->52|66->52|66->52|77->63|77->63|77->63|77->63|77->63|88->74|88->74|88->74|88->74|88->74|96->82|96->82|96->82|111->97|111->97|111->97|111->97|111->97|119->105|119->105|119->105|126->112|126->112|126->112|133->119|133->119|133->119|140->126|140->126|140->126|147->133|147->133|147->133|154->140|154->140|154->140|161->147|161->147|161->147|168->154|168->154|168->154|175->161|175->161|175->161|182->168|182->168|182->168|182->168|182->168|189->175|189->175|189->175|189->175|189->175|196->182|196->182|196->182|208->194|208->194|208->194|208->194|208->194|216->202|216->202|216->202|223->209|223->209|223->209|230->216|230->216|230->216|236->222|236->222|236->222|242->228|242->228|242->228|242->228|242->228|249->235|249->235|249->235|255->241|255->241|255->241|265->251|266->252|267->253|268->254|268->254|269->255|269->255|269->255|270->256|271->257|271->257|273->259|273->259|274->260|275->261|275->261|277->263|277->263|278->264|279->265|279->265|280->266|280->266
                  -- GENERATED --
              */
          