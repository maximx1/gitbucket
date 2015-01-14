
package admin.users.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object group extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Option[model.Account],List[model.GroupMember],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: Option[model.Account], members: List[model.GroupMember])(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*1.99*/("""
"""),_display_(/*4.2*/html/*4.6*/.main(if(account.isEmpty) "New Group" else "Update Group")/*4.64*/{_display_(Seq[Any](format.raw/*4.65*/("""
  """),_display_(/*5.4*/admin/*5.9*/.html.menu("users")/*5.28*/{_display_(Seq[Any](format.raw/*5.29*/("""
    """),format.raw/*6.5*/("""<form method="POST" action=""""),_display_(/*6.34*/if(account.isEmpty)/*6.53*/{_display_(Seq[Any](_display_(/*6.55*/path),format.raw/*6.59*/("""/admin/users/_newgroup""")))}/*6.83*/else/*6.88*/{_display_(Seq[Any](_display_(/*6.90*/path),format.raw/*6.94*/("""/admin/users/"""),_display_(/*6.108*/account/*6.115*/.get.userName),format.raw/*6.128*/("""/_editgroup""")))}),format.raw/*6.140*/("""" validate="true">
      <div class="row-fluid">
        <div class="span5">
          <fieldset>
            <label for="groupName" class="strong">Group name</label>
            <div>
              <span id="error-groupName" class="error"></span>
            </div>
            <input type="text" name="groupName" id="groupName" value=""""),_display_(/*14.72*/account/*14.79*/.map(_.userName)),format.raw/*14.95*/("""""""),_display_(/*14.97*/if(account.isDefined)/*14.118*/{_display_(Seq[Any](format.raw/*14.119*/(""" """),format.raw/*14.120*/("""readonly""")))}),format.raw/*14.129*/("""/>
            """),_display_(/*15.14*/if(account.isDefined)/*15.35*/{_display_(Seq[Any](format.raw/*15.36*/("""
              """),format.raw/*16.15*/("""<label for="removed">
                <input type="checkbox" name="removed" id="removed" value="true" """),_display_(/*17.82*/if(account.get.isRemoved)/*17.107*/{_display_(Seq[Any](format.raw/*17.108*/("""checked""")))}),format.raw/*17.116*/("""/>
                Disable
              </label>
            """)))}),format.raw/*20.14*/("""
          """),format.raw/*21.11*/("""</fieldset>
          <fieldset>
            <label class="strong">URL (Optional)</label>
            <div>
              <span id="error-url" class="error"></span>
            </div>
            <input type="text" name="url" id="url" value=""""),_display_(/*27.60*/account/*27.67*/.map(_.url)),format.raw/*27.78*/(""""/>
          </fieldset>
          <fieldset>
            <label for="avatar" class="strong">Image (Optional)</label>
            """),_display_(/*31.14*/helper/*31.20*/.html.uploadavatar(account)),format.raw/*31.47*/("""
          """),format.raw/*32.11*/("""</fieldset>
        </div>
        <div class="span7">
          <fieldset>
            <label class="strong">Members</label>
            <ul id="member-list" class="collaborator">
            </ul>
            """),_display_(/*39.14*/helper/*39.20*/.html.account("memberName", 200)),format.raw/*39.52*/("""
            """),format.raw/*40.13*/("""<input type="button" class="btn" value="Add" id="addMember"/>
            <input type="hidden" id="members" name="members" value=""""),_display_(/*41.70*/members/*41.77*/.map(member => member.userName + ":" + member.isManager).mkString(",")),format.raw/*41.147*/(""""/>
            <div>
              <span class="error" id="error-members"></span>
            </div>
          </fieldset>
        </div>
      </div>
      <fieldset class="margin">
        <input type="submit" class="btn btn-success" value=""""),_display_(/*49.62*/if(account.isEmpty)/*49.81*/{_display_(Seq[Any](format.raw/*49.82*/("""Create Group""")))}/*49.96*/else/*49.101*/{_display_(Seq[Any](format.raw/*49.102*/("""Update Group""")))}),format.raw/*49.115*/(""""/>
        <a href=""""),_display_(/*50.19*/path),format.raw/*50.23*/("""/admin/users" class="btn">Cancel</a>
      </fieldset>
    </form>
  """)))}),format.raw/*53.4*/("""
""")))}),format.raw/*54.2*/("""
"""),format.raw/*55.1*/("""<script>
$(function()"""),format.raw/*56.13*/("""{"""),format.raw/*56.14*/("""
  """),format.raw/*57.3*/("""$('input[type=submit]').click(function()"""),format.raw/*57.43*/("""{"""),format.raw/*57.44*/("""
    """),format.raw/*58.5*/("""updateMembers();
  """),format.raw/*59.3*/("""}"""),format.raw/*59.4*/(""");

  $('#addMember').click(function()"""),format.raw/*61.35*/("""{"""),format.raw/*61.36*/("""
    """),format.raw/*62.5*/("""$('#error-members').text('');
    var userName = $('#memberName').val();

    // check empty
    if($.trim(userName) == '')"""),format.raw/*66.31*/("""{"""),format.raw/*66.32*/("""
      """),format.raw/*67.7*/("""return false;
    """),format.raw/*68.5*/("""}"""),format.raw/*68.6*/("""

    """),format.raw/*70.5*/("""// check duplication
    var exists = $('#member-list li').filter(function()"""),format.raw/*71.56*/("""{"""),format.raw/*71.57*/("""
      """),format.raw/*72.7*/("""return $(this).data('name') == userName;
    """),format.raw/*73.5*/("""}"""),format.raw/*73.6*/(""").length > 0;
    if(exists)"""),format.raw/*74.15*/("""{"""),format.raw/*74.16*/("""
      """),format.raw/*75.7*/("""$('#error-members').text('User has been already added.');
      return false;
    """),format.raw/*77.5*/("""}"""),format.raw/*77.6*/("""

    """),format.raw/*79.5*/("""// check existence
    $.post('"""),_display_(/*80.14*/path),format.raw/*80.18*/("""/_user/existence', """),format.raw/*80.37*/("""{"""),format.raw/*80.38*/("""
      """),format.raw/*81.7*/("""'userName': userName
    """),format.raw/*82.5*/("""}"""),format.raw/*82.6*/(""", function(data, status)"""),format.raw/*82.30*/("""{"""),format.raw/*82.31*/("""
      """),format.raw/*83.7*/("""if(data == 'true')"""),format.raw/*83.25*/("""{"""),format.raw/*83.26*/("""
        """),format.raw/*84.9*/("""addMemberHTML(userName, false);
      """),format.raw/*85.7*/("""}"""),format.raw/*85.8*/(""" """),format.raw/*85.9*/("""else """),format.raw/*85.14*/("""{"""),format.raw/*85.15*/("""
        """),format.raw/*86.9*/("""$('#error-members').text('User does not exist.');
      """),format.raw/*87.7*/("""}"""),format.raw/*87.8*/("""
    """),format.raw/*88.5*/("""}"""),format.raw/*88.6*/(""");
  """),format.raw/*89.3*/("""}"""),format.raw/*89.4*/(""");

  $(document).on('click', '.remove', function()"""),format.raw/*91.48*/("""{"""),format.raw/*91.49*/("""
    """),format.raw/*92.5*/("""$(this).parent().remove();
  """),format.raw/*93.3*/("""}"""),format.raw/*93.4*/(""");

  // Don't submit form by ENTER key
  $('#memberName').keypress(function(e)"""),format.raw/*96.40*/("""{"""),format.raw/*96.41*/("""
    """),format.raw/*97.5*/("""return !(e.keyCode == 13);
  """),format.raw/*98.3*/("""}"""),format.raw/*98.4*/(""");

  """),_display_(/*100.4*/members/*100.11*/.map/*100.15*/ { member =>_display_(Seq[Any](format.raw/*100.27*/("""
    """),format.raw/*101.5*/("""addMemberHTML('"""),_display_(/*101.21*/member/*101.27*/.userName),format.raw/*101.36*/("""', """),_display_(/*101.40*/member/*101.46*/.isManager),format.raw/*101.56*/(""");
  """)))}),format.raw/*102.4*/("""

  """),format.raw/*104.3*/("""function addMemberHTML(userName, isManager)"""),format.raw/*104.46*/("""{"""),format.raw/*104.47*/("""
    """),format.raw/*105.5*/("""var memberButton = $('<button type="button" class="btn btn-default btn-mini" value="false">Member</button>').data('name', userName);
    if(!isManager)"""),format.raw/*106.19*/("""{"""),format.raw/*106.20*/("""
      """),format.raw/*107.7*/("""memberButton.addClass('active');
    """),format.raw/*108.5*/("""}"""),format.raw/*108.6*/("""
    """),format.raw/*109.5*/("""var managerButton = $('<button type="button" class="btn btn-default btn-mini" value="true">Manager</button>').data('name', userName);
    if(isManager)"""),format.raw/*110.18*/("""{"""),format.raw/*110.19*/("""
      """),format.raw/*111.7*/("""managerButton.addClass('active');
    """),format.raw/*112.5*/("""}"""),format.raw/*112.6*/("""

    """),format.raw/*114.5*/("""$('#member-list').append($('<li>')
      .data('name', userName)
      .append($('<div class="btn-group is_manager" data-toggle="buttons-radio">')
        .append(memberButton)
        .append(managerButton))
      .append(' ')
      .append($('<a>').attr('href', '"""),_display_(/*120.39*/path),format.raw/*120.43*/("""/' + userName).text(userName))
      .append(' ')
      .append($('<a href="#" class="remove pull-right">(remove)</a>')));
  """),format.raw/*123.3*/("""}"""),format.raw/*123.4*/("""

  """),format.raw/*125.3*/("""function updateMembers()"""),format.raw/*125.27*/("""{"""),format.raw/*125.28*/("""
    """),format.raw/*126.5*/("""var members = $('#member-list li').map(function(i, e)"""),format.raw/*126.58*/("""{"""),format.raw/*126.59*/("""
      """),format.raw/*127.7*/("""var userName = $(e).data('name');
      return userName + ':' + $('button.active').filter(function(i, e)"""),format.raw/*128.71*/("""{"""),format.raw/*128.72*/("""
        """),format.raw/*129.9*/("""return $(e).data('name') == userName;
      """),format.raw/*130.7*/("""}"""),format.raw/*130.8*/(""").attr('value');
    """),format.raw/*131.5*/("""}"""),format.raw/*131.6*/(""").get().join(',');
    $('#members').val(members);
  """),format.raw/*133.3*/("""}"""),format.raw/*133.4*/("""
"""),format.raw/*134.1*/("""}"""),format.raw/*134.2*/(""");
</script>"""))}
  }

  def render(account:Option[model.Account],members:List[model.GroupMember],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,members)(context)

  def f:((Option[model.Account],List[model.GroupMember]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,members) => (context) => apply(account,members)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/admin/users/group.scala.html
                  HASH: 5034d24630237332b66e34b9c5de64d4b1d6a360
                  MATRIX: 400->1|623->98|650->141|661->145|727->203|765->204|794->208|806->213|833->232|871->233|902->238|957->267|984->286|1022->288|1046->292|1087->316|1099->321|1137->323|1161->327|1202->341|1218->348|1252->361|1295->373|1660->711|1676->718|1713->734|1742->736|1773->757|1813->758|1843->759|1884->768|1927->784|1957->805|1996->806|2039->821|2169->924|2204->949|2244->950|2284->958|2378->1021|2417->1032|2687->1275|2703->1282|2735->1293|2894->1425|2909->1431|2957->1458|2996->1469|3235->1681|3250->1687|3303->1719|3344->1732|3502->1863|3518->1870|3610->1940|3882->2185|3910->2204|3949->2205|3981->2219|3995->2224|4035->2225|4080->2238|4129->2260|4154->2264|4254->2334|4286->2336|4314->2337|4363->2358|4392->2359|4422->2362|4490->2402|4519->2403|4551->2408|4597->2427|4625->2428|4691->2466|4720->2467|4752->2472|4903->2595|4932->2596|4966->2603|5011->2621|5039->2622|5072->2628|5176->2704|5205->2705|5239->2712|5311->2757|5339->2758|5395->2786|5424->2787|5458->2794|5567->2876|5595->2877|5628->2883|5687->2915|5712->2919|5759->2938|5788->2939|5822->2946|5874->2971|5902->2972|5954->2996|5983->2997|6017->3004|6063->3022|6092->3023|6128->3032|6193->3070|6221->3071|6249->3072|6282->3077|6311->3078|6347->3087|6430->3143|6458->3144|6490->3149|6518->3150|6550->3155|6578->3156|6657->3207|6686->3208|6718->3213|6774->3242|6802->3243|6909->3322|6938->3323|6970->3328|7026->3357|7054->3358|7088->3365|7105->3372|7119->3376|7170->3388|7203->3393|7247->3409|7263->3415|7294->3424|7326->3428|7342->3434|7374->3444|7411->3450|7443->3454|7515->3497|7545->3498|7578->3503|7758->3654|7788->3655|7823->3662|7888->3699|7917->3700|7950->3705|8130->3856|8160->3857|8195->3864|8261->3902|8290->3903|8324->3909|8618->4175|8644->4179|8797->4304|8826->4305|8858->4309|8911->4333|8941->4334|8974->4339|9056->4392|9086->4393|9121->4400|9254->4504|9284->4505|9321->4514|9393->4558|9422->4559|9471->4580|9500->4581|9581->4634|9610->4635|9639->4636|9668->4637
                  LINES: 13->1|17->1|18->4|18->4|18->4|18->4|19->5|19->5|19->5|19->5|20->6|20->6|20->6|20->6|20->6|20->6|20->6|20->6|20->6|20->6|20->6|20->6|20->6|28->14|28->14|28->14|28->14|28->14|28->14|28->14|28->14|29->15|29->15|29->15|30->16|31->17|31->17|31->17|31->17|34->20|35->21|41->27|41->27|41->27|45->31|45->31|45->31|46->32|53->39|53->39|53->39|54->40|55->41|55->41|55->41|63->49|63->49|63->49|63->49|63->49|63->49|63->49|64->50|64->50|67->53|68->54|69->55|70->56|70->56|71->57|71->57|71->57|72->58|73->59|73->59|75->61|75->61|76->62|80->66|80->66|81->67|82->68|82->68|84->70|85->71|85->71|86->72|87->73|87->73|88->74|88->74|89->75|91->77|91->77|93->79|94->80|94->80|94->80|94->80|95->81|96->82|96->82|96->82|96->82|97->83|97->83|97->83|98->84|99->85|99->85|99->85|99->85|99->85|100->86|101->87|101->87|102->88|102->88|103->89|103->89|105->91|105->91|106->92|107->93|107->93|110->96|110->96|111->97|112->98|112->98|114->100|114->100|114->100|114->100|115->101|115->101|115->101|115->101|115->101|115->101|115->101|116->102|118->104|118->104|118->104|119->105|120->106|120->106|121->107|122->108|122->108|123->109|124->110|124->110|125->111|126->112|126->112|128->114|134->120|134->120|137->123|137->123|139->125|139->125|139->125|140->126|140->126|140->126|141->127|142->128|142->128|143->129|144->130|144->130|145->131|145->131|147->133|147->133|148->134|148->134
                  -- GENERATED --
              */
          