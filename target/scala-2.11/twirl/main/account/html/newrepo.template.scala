
package account.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object newrepo extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[List[String],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(groupNames: List[String])(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*1.59*/("""
"""),_display_(/*4.2*/html/*4.6*/.main("Create a New Repository")/*4.38*/{_display_(Seq[Any](format.raw/*4.39*/("""
"""),format.raw/*5.1*/("""<div style="width: 600px; margin: 10px auto;">
  <form id="form" method="post" action=""""),_display_(/*6.42*/path),format.raw/*6.46*/("""/new" validate="true">
    <fieldset>
      <label for="name" class="strong">Repository name:</label>
      <div class="btn-group" style="margin-bottom: 10px;" id="owner-dropdown">
        <button class="btn dropdown-toggle" data-toggle="dropdown">
          <span class="strong">"""),_display_(/*11.33*/avatar(loginAccount.get.userName, 20)),format.raw/*11.70*/(""" """),_display_(/*11.72*/loginAccount/*11.84*/.get.userName),format.raw/*11.97*/("""</span>
          <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
          <li><a href="javascript:void(0);" data-name=""""),_display_(/*15.57*/loginAccount/*15.69*/.get.userName),format.raw/*15.82*/(""""><i class="icon-ok"></i> <span>"""),_display_(/*15.115*/avatar(loginAccount.get.userName, 20)),format.raw/*15.152*/(""" """),_display_(/*15.154*/loginAccount/*15.166*/.get.userName),format.raw/*15.179*/("""</span></a></li>
          """),_display_(/*16.12*/groupNames/*16.22*/.map/*16.26*/ { groupName =>_display_(Seq[Any](format.raw/*16.41*/("""
            """),format.raw/*17.13*/("""<li><a href="javascript:void(0);" data-name=""""),_display_(/*17.59*/groupName),format.raw/*17.68*/(""""><i class="icon-white"></i> <span>"""),_display_(/*17.104*/avatar(groupName, 20)),format.raw/*17.125*/(""" """),_display_(/*17.127*/groupName),format.raw/*17.136*/("""</span></a></li>
          """)))}),format.raw/*18.12*/("""
        """),format.raw/*19.9*/("""</ul>
        <input type="hidden" name="owner" id="owner" value=""""),_display_(/*20.62*/loginAccount/*20.74*/.get.userName),format.raw/*20.87*/(""""/>
      </div>
      <span class="slash">/</span>
      <input type="text" name="name" id="name" />
      <span id="error-name" class="error"></span>
    </fieldset>
    <fieldset>
      <label for="description" class="strong">Description (optional):</label>
      <input type="text" name="description" id="description" style="width: 95%;"/>
    </fieldset>
    <fieldset class="margin">
      <label class="radio">
        <input type="radio" name="isPrivate" value="false" checked>
        <span class="strong"><img src=""""),_display_(/*33.41*/assets),format.raw/*33.47*/("""/common/images/repo_public.png"/>&nbsp;</i>&nbsp;Public</span><br>
        <div>
          <span>All users and guests can read this repository.</span>
        </div>
      </label>
    </fieldset>
    <fieldset>
      <label class="radio">
        <input type="radio" name="isPrivate" value="true">
        <span class="strong"><img src=""""),_display_(/*42.41*/assets),format.raw/*42.47*/("""/common/images/repo_private.png"/>&nbsp;</i>&nbsp;Private</span><br>
        <div>
          <span>Only collaborators can read this repository.</span>
        </div>
      </label>
    </fieldset>
    <fieldset class="margin">
      <label for="createReadme" class="checkbox">
        <input type="checkbox" name="createReadme" id="createReadme"/>
        <span class="strong">Initialize this repository with a README</span>
        <div>
          <span>This will allow you to <code>git clone</code> the repository immediately.</span>
        </div>
      </label>
    </fieldset>
    <fieldset class="margin">
      <input type="submit" class="btn btn-success" value="Create repository"/>
    </fieldset>
  </form>
</div>
""")))}),format.raw/*62.2*/("""
"""),format.raw/*63.1*/("""<script>
$('#owner-dropdown a').click(function()"""),format.raw/*64.40*/("""{"""),format.raw/*64.41*/("""
  """),format.raw/*65.3*/("""var userName = $(this).data('name');
  $('#owner').val(userName);

  $('#owner-dropdown i').attr('class', 'icon-white');
  $(this).find('i').attr('class', 'icon-ok');

  $('#owner-dropdown span.strong').html($(this).find('span').html());
"""),format.raw/*72.1*/("""}"""),format.raw/*72.2*/(""");
</script>
"""))}
  }

  def render(groupNames:List[String],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(groupNames)(context)

  def f:((List[String]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (groupNames) => (context) => apply(groupNames)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/account/newrepo.scala.html
                  HASH: 465750017dc97c8552b5cc2385745d290e71c79b
                  MATRIX: 365->1|548->58|575->101|586->105|626->137|664->138|691->139|805->227|829->231|1137->512|1195->549|1224->551|1245->563|1279->576|1461->731|1482->743|1516->756|1577->789|1636->826|1666->828|1688->840|1723->853|1778->881|1797->891|1810->895|1863->910|1904->923|1977->969|2007->978|2071->1014|2114->1035|2144->1037|2175->1046|2234->1074|2270->1083|2364->1150|2385->1162|2419->1175|2972->1701|2999->1707|3365->2046|3392->2052|4147->2777|4175->2778|4251->2826|4280->2827|4310->2830|4575->3068|4603->3069
                  LINES: 13->1|17->1|18->4|18->4|18->4|18->4|19->5|20->6|20->6|25->11|25->11|25->11|25->11|25->11|29->15|29->15|29->15|29->15|29->15|29->15|29->15|29->15|30->16|30->16|30->16|30->16|31->17|31->17|31->17|31->17|31->17|31->17|31->17|32->18|33->19|34->20|34->20|34->20|47->33|47->33|56->42|56->42|76->62|77->63|78->64|78->64|79->65|86->72|86->72
                  -- GENERATED --
              */
          