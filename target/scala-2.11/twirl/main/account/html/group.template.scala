
package account.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object group extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Option[model.Account],List[model.GroupMember],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: Option[model.Account], members: List[model.GroupMember])(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*1.99*/("""
"""),_display_(/*4.2*/html/*4.6*/.main(if(account.isEmpty) "Create group" else "Edit group")/*4.65*/{_display_(Seq[Any](format.raw/*4.66*/("""
"""),format.raw/*5.1*/("""<div class="container">
  <form id="form" method="post" action=""""),_display_(/*6.42*/if(account.isEmpty)/*6.61*/{_display_(Seq[Any](_display_(/*6.63*/path),format.raw/*6.67*/("""/groups/new""")))}/*6.80*/else/*6.85*/{_display_(Seq[Any](_display_(/*6.87*/path),format.raw/*6.91*/("""/"""),_display_(/*6.93*/account/*6.100*/.get.userName),format.raw/*6.113*/("""/_editgroup""")))}),format.raw/*6.125*/("""" validate="true">
      <div class="row-fluid">
        <div class="span5">
          <fieldset>
            <label for="groupName" class="strong">Group name</label>
            <div>
              <span id="error-groupName" class="error"></span>
            </div>
            <input type="text" name="groupName" id="groupName" value=""""),_display_(/*14.72*/account/*14.79*/.map(_.userName)),format.raw/*14.95*/("""""""),_display_(/*14.97*/if(account.isDefined)/*14.118*/{_display_(Seq[Any](format.raw/*14.119*/(""" """),format.raw/*14.120*/("""readonly""")))}),format.raw/*14.129*/("""/>
          </fieldset>
          <fieldset>
            <label class="strong">URL (Optional)</label>
            <div>
              <span id="error-url" class="error"></span>
            </div>
            <input type="text" name="url" id="url" style="width: 300px;" value=""""),_display_(/*21.82*/account/*21.89*/.map(_.url)),format.raw/*21.100*/(""""/>
          </fieldset>
          <fieldset>
            <label for="avatar" class="strong">Image (Optional)</label>
            """),_display_(/*25.14*/helper/*25.20*/.html.uploadavatar(account)),format.raw/*25.47*/("""
          """),format.raw/*26.11*/("""</fieldset>
        </div>
        <div class="span7">
          <fieldset>
            <label class="strong">Members</label>
            <ul id="member-list" class="collaborator">
            </ul>
            """),_display_(/*33.14*/helper/*33.20*/.html.account("memberName", 200)),format.raw/*33.52*/("""
            """),format.raw/*34.13*/("""<input type="button" class="btn" value="Add" id="addMember"/>
            <input type="hidden" id="members" name="members" value=""""),_display_(/*35.70*/members/*35.77*/.map(member => member.userName + ":" + member.isManager).mkString(",")),format.raw/*35.147*/(""""/>
            <div>
              <span class="error" id="error-members"></span>
            </div>
          </fieldset>
        </div>
      </div>
      <fieldset class="margin">
        """),_display_(/*43.10*/if(account.isDefined)/*43.31*/{_display_(Seq[Any](format.raw/*43.32*/("""
          """),format.raw/*44.11*/("""<div class="pull-right">
            <a href=""""),_display_(/*45.23*/url(account.get.userName)),format.raw/*45.48*/("""/_deletegroup" id="delete" class="btn btn-danger">Delete Group</a>
          </div>
        """)))}),format.raw/*47.10*/("""
        """),format.raw/*48.9*/("""<input type="submit" class="btn btn-success" value=""""),_display_(/*48.62*/if(account.isEmpty)/*48.81*/{_display_(Seq[Any](format.raw/*48.82*/("""Create Group""")))}/*48.96*/else/*48.101*/{_display_(Seq[Any](format.raw/*48.102*/("""Update Group""")))}),format.raw/*48.115*/(""""/>
        """),_display_(/*49.10*/if(account.isDefined)/*49.31*/{_display_(Seq[Any](format.raw/*49.32*/("""
          """),format.raw/*50.11*/("""<a href=""""),_display_(/*50.21*/url(account.get.userName)),format.raw/*50.46*/("""" class="btn">Cancel</a>
        """)))}),format.raw/*51.10*/("""
      """),format.raw/*52.7*/("""</fieldset>
  </form>
</div>
""")))}),format.raw/*55.2*/("""
"""),format.raw/*56.1*/("""<script>
$(function()"""),format.raw/*57.13*/("""{"""),format.raw/*57.14*/("""
  """),format.raw/*58.3*/("""$('input[type=submit]').click(function()"""),format.raw/*58.43*/("""{"""),format.raw/*58.44*/("""
    """),format.raw/*59.5*/("""updateMembers();
  """),format.raw/*60.3*/("""}"""),format.raw/*60.4*/(""");

  $('#addMember').click(function()"""),format.raw/*62.35*/("""{"""),format.raw/*62.36*/("""
    """),format.raw/*63.5*/("""$('#error-members').text('');
    var userName = $('#memberName').val();

    // check empty
    if($.trim(userName) == '')"""),format.raw/*67.31*/("""{"""),format.raw/*67.32*/("""
      """),format.raw/*68.7*/("""return false;
    """),format.raw/*69.5*/("""}"""),format.raw/*69.6*/("""

    """),format.raw/*71.5*/("""// check duplication
    var exists = $('#member-list li').filter(function()"""),format.raw/*72.56*/("""{"""),format.raw/*72.57*/("""
      """),format.raw/*73.7*/("""return $(this).data('name') == userName;
    """),format.raw/*74.5*/("""}"""),format.raw/*74.6*/(""").length > 0;
    if(exists)"""),format.raw/*75.15*/("""{"""),format.raw/*75.16*/("""
      """),format.raw/*76.7*/("""$('#error-members').text('User has been already added.');
      return false;
    """),format.raw/*78.5*/("""}"""),format.raw/*78.6*/("""

    """),format.raw/*80.5*/("""// check existence
    $.post('"""),_display_(/*81.14*/path),format.raw/*81.18*/("""/_user/existence', """),format.raw/*81.37*/("""{"""),format.raw/*81.38*/("""
      """),format.raw/*82.7*/("""'userName': userName
    """),format.raw/*83.5*/("""}"""),format.raw/*83.6*/(""", function(data, status)"""),format.raw/*83.30*/("""{"""),format.raw/*83.31*/("""
      """),format.raw/*84.7*/("""if(data == 'true')"""),format.raw/*84.25*/("""{"""),format.raw/*84.26*/("""
        """),format.raw/*85.9*/("""addMemberHTML(userName, false);
      """),format.raw/*86.7*/("""}"""),format.raw/*86.8*/(""" """),format.raw/*86.9*/("""else """),format.raw/*86.14*/("""{"""),format.raw/*86.15*/("""
        """),format.raw/*87.9*/("""$('#error-members').text('User does not exist.');
      """),format.raw/*88.7*/("""}"""),format.raw/*88.8*/("""
    """),format.raw/*89.5*/("""}"""),format.raw/*89.6*/(""");
  """),format.raw/*90.3*/("""}"""),format.raw/*90.4*/(""");

  $(document).on('click', '.remove', function()"""),format.raw/*92.48*/("""{"""),format.raw/*92.49*/("""
    """),format.raw/*93.5*/("""$(this).parent().remove();
  """),format.raw/*94.3*/("""}"""),format.raw/*94.4*/(""");

  // Don't submit form by ENTER key
  $('#memberName').keypress(function(e)"""),format.raw/*97.40*/("""{"""),format.raw/*97.41*/("""
    """),format.raw/*98.5*/("""return !(e.keyCode == 13);
  """),format.raw/*99.3*/("""}"""),format.raw/*99.4*/(""");

  $('#delete').click(function()"""),format.raw/*101.32*/("""{"""),format.raw/*101.33*/("""
    """),format.raw/*102.5*/("""return confirm('Once you delete this group, there is no going back.\nAre you sure?');
  """),format.raw/*103.3*/("""}"""),format.raw/*103.4*/(""");

  """),_display_(/*105.4*/members/*105.11*/.map/*105.15*/ { member =>_display_(Seq[Any](format.raw/*105.27*/("""
    """),format.raw/*106.5*/("""addMemberHTML('"""),_display_(/*106.21*/member/*106.27*/.userName),format.raw/*106.36*/("""', """),_display_(/*106.40*/member/*106.46*/.isManager),format.raw/*106.56*/(""");
  """)))}),format.raw/*107.4*/("""

  """),format.raw/*109.3*/("""function addMemberHTML(userName, isManager)"""),format.raw/*109.46*/("""{"""),format.raw/*109.47*/("""
    """),format.raw/*110.5*/("""var memberButton = $('<button type="button" class="btn btn-default btn-mini" value="false">Member</button>').data('name', userName);
    if(!isManager)"""),format.raw/*111.19*/("""{"""),format.raw/*111.20*/("""
      """),format.raw/*112.7*/("""memberButton.addClass('active');
    """),format.raw/*113.5*/("""}"""),format.raw/*113.6*/("""
    """),format.raw/*114.5*/("""var managerButton = $('<button type="button" class="btn btn-default btn-mini" value="true">Manager</button>').data('name', userName);
    if(isManager)"""),format.raw/*115.18*/("""{"""),format.raw/*115.19*/("""
      """),format.raw/*116.7*/("""managerButton.addClass('active');
    """),format.raw/*117.5*/("""}"""),format.raw/*117.6*/("""

    """),format.raw/*119.5*/("""$('#member-list').append($('<li>')
      .data('name', userName)
      .append($('<div class="btn-group is_manager" data-toggle="buttons-radio">')
        .append(memberButton)
        .append(managerButton))
      .append(' ')
      .append($('<a>').attr('href', '"""),_display_(/*125.39*/path),format.raw/*125.43*/("""/' + userName).text(userName))
      .append(' ')
      .append($('<a href="#" class="remove pull-right">(remove)</a>')));
  """),format.raw/*128.3*/("""}"""),format.raw/*128.4*/("""

  """),format.raw/*130.3*/("""function updateMembers()"""),format.raw/*130.27*/("""{"""),format.raw/*130.28*/("""
    """),format.raw/*131.5*/("""var members = $('#member-list li').map(function(i, e)"""),format.raw/*131.58*/("""{"""),format.raw/*131.59*/("""
      """),format.raw/*132.7*/("""var userName = $(e).data('name');
      return userName + ':' + $('button.active').filter(function(i, e)"""),format.raw/*133.71*/("""{"""),format.raw/*133.72*/("""
        """),format.raw/*134.9*/("""return $(e).data('name') == userName;
      """),format.raw/*135.7*/("""}"""),format.raw/*135.8*/(""").attr('value');
    """),format.raw/*136.5*/("""}"""),format.raw/*136.6*/(""").get().join(',');
    $('#members').val(members);
  """),format.raw/*138.3*/("""}"""),format.raw/*138.4*/("""
"""),format.raw/*139.1*/("""}"""),format.raw/*139.2*/(""");
</script>"""))}
  }

  def render(account:Option[model.Account],members:List[model.GroupMember],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,members)(context)

  def f:((Option[model.Account],List[model.GroupMember]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,members) => (context) => apply(account,members)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/account/group.scala.html
                  HASH: cf5958dd24e1f89b0b201d438ee5759cee09e4ab
                  MATRIX: 396->1|619->98|646->141|657->145|724->204|762->205|789->206|880->271|907->290|945->292|969->296|999->309|1011->314|1049->316|1073->320|1101->322|1117->329|1151->342|1194->354|1559->692|1575->699|1612->715|1641->717|1672->738|1712->739|1742->740|1783->749|2088->1027|2104->1034|2137->1045|2296->1177|2311->1183|2359->1210|2398->1221|2637->1433|2652->1439|2705->1471|2746->1484|2904->1615|2920->1622|3012->1692|3232->1885|3262->1906|3301->1907|3340->1918|3414->1965|3460->1990|3584->2083|3620->2092|3700->2145|3728->2164|3767->2165|3799->2179|3813->2184|3853->2185|3898->2198|3938->2211|3968->2232|4007->2233|4046->2244|4083->2254|4129->2279|4194->2313|4228->2320|4288->2350|4316->2351|4365->2372|4394->2373|4424->2376|4492->2416|4521->2417|4553->2422|4599->2441|4627->2442|4693->2480|4722->2481|4754->2486|4905->2609|4934->2610|4968->2617|5013->2635|5041->2636|5074->2642|5178->2718|5207->2719|5241->2726|5313->2771|5341->2772|5397->2800|5426->2801|5460->2808|5569->2890|5597->2891|5630->2897|5689->2929|5714->2933|5761->2952|5790->2953|5824->2960|5876->2985|5904->2986|5956->3010|5985->3011|6019->3018|6065->3036|6094->3037|6130->3046|6195->3084|6223->3085|6251->3086|6284->3091|6313->3092|6349->3101|6432->3157|6460->3158|6492->3163|6520->3164|6552->3169|6580->3170|6659->3221|6688->3222|6720->3227|6776->3256|6804->3257|6911->3336|6940->3337|6972->3342|7028->3371|7056->3372|7120->3407|7150->3408|7183->3413|7299->3501|7328->3502|7362->3509|7379->3516|7393->3520|7444->3532|7477->3537|7521->3553|7537->3559|7568->3568|7600->3572|7616->3578|7648->3588|7685->3594|7717->3598|7789->3641|7819->3642|7852->3647|8032->3798|8062->3799|8097->3806|8162->3843|8191->3844|8224->3849|8404->4000|8434->4001|8469->4008|8535->4046|8564->4047|8598->4053|8892->4319|8918->4323|9071->4448|9100->4449|9132->4453|9185->4477|9215->4478|9248->4483|9330->4536|9360->4537|9395->4544|9528->4648|9558->4649|9595->4658|9667->4702|9696->4703|9745->4724|9774->4725|9855->4778|9884->4779|9913->4780|9942->4781
                  LINES: 13->1|17->1|18->4|18->4|18->4|18->4|19->5|20->6|20->6|20->6|20->6|20->6|20->6|20->6|20->6|20->6|20->6|20->6|20->6|28->14|28->14|28->14|28->14|28->14|28->14|28->14|28->14|35->21|35->21|35->21|39->25|39->25|39->25|40->26|47->33|47->33|47->33|48->34|49->35|49->35|49->35|57->43|57->43|57->43|58->44|59->45|59->45|61->47|62->48|62->48|62->48|62->48|62->48|62->48|62->48|62->48|63->49|63->49|63->49|64->50|64->50|64->50|65->51|66->52|69->55|70->56|71->57|71->57|72->58|72->58|72->58|73->59|74->60|74->60|76->62|76->62|77->63|81->67|81->67|82->68|83->69|83->69|85->71|86->72|86->72|87->73|88->74|88->74|89->75|89->75|90->76|92->78|92->78|94->80|95->81|95->81|95->81|95->81|96->82|97->83|97->83|97->83|97->83|98->84|98->84|98->84|99->85|100->86|100->86|100->86|100->86|100->86|101->87|102->88|102->88|103->89|103->89|104->90|104->90|106->92|106->92|107->93|108->94|108->94|111->97|111->97|112->98|113->99|113->99|115->101|115->101|116->102|117->103|117->103|119->105|119->105|119->105|119->105|120->106|120->106|120->106|120->106|120->106|120->106|120->106|121->107|123->109|123->109|123->109|124->110|125->111|125->111|126->112|127->113|127->113|128->114|129->115|129->115|130->116|131->117|131->117|133->119|139->125|139->125|142->128|142->128|144->130|144->130|144->130|145->131|145->131|145->131|146->132|147->133|147->133|148->134|149->135|149->135|150->136|150->136|152->138|152->138|153->139|153->139
                  -- GENERATED --
              */
          