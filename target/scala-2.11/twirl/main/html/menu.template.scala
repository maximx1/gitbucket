
package html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object menu extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template9[String,service.RepositoryService.RepositoryInfo,Option[String],Boolean,Boolean,Option[Any],Option[Any],Html,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(active: String,
  repository: service.RepositoryService.RepositoryInfo,
  id: Option[String] = None,
  expand: Boolean = false,
  isNoGroup: Boolean = true,
  info: Option[Any] = None,
  error: Option[Any] = None)(body: Html)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._
def /*11.2*/sidemenu/*11.10*/(path: String, name: String, label: String, count: Int = 0):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*11.73*/("""
  """),format.raw/*12.3*/("""<li """),_display_(/*12.8*/if(active == name)/*12.26*/{_display_(Seq[Any](format.raw/*12.27*/("""class="active"""")))}),format.raw/*12.42*/(""">
    <div class=""""),_display_(/*13.18*/if(active == name)/*13.36*/{_display_(Seq[Any](format.raw/*13.37*/("""margin""")))}/*13.45*/else/*13.50*/{_display_(Seq[Any](format.raw/*13.51*/("""gradient""")))}),format.raw/*13.60*/(""" """),format.raw/*13.61*/("""pull-left"></div>
    <a href=""""),_display_(/*14.15*/url(repository)),_display_(/*14.31*/path),format.raw/*14.35*/("""""""),format.raw/*14.125*/(""">
      """),_display_(/*15.8*/if(active == name)/*15.26*/{_display_(Seq[Any](format.raw/*15.27*/("""
        """),format.raw/*16.9*/("""<img src=""""),_display_(/*16.20*/assets),format.raw/*16.26*/("""/common/images/menu-"""),_display_(/*16.47*/{name}),format.raw/*16.53*/("""-active.png">
      """)))}/*17.9*/else/*17.14*/{_display_(Seq[Any](format.raw/*17.15*/("""
        """),format.raw/*18.9*/("""<img src=""""),_display_(/*18.20*/assets),format.raw/*18.26*/("""/common/images/menu-"""),_display_(/*18.47*/{name}),format.raw/*18.53*/("""-active.png" class="menu-icon-active" style="display:none;">
        <img src=""""),_display_(/*19.20*/assets),format.raw/*19.26*/("""/common/images/menu-"""),_display_(/*19.47*/{name}),format.raw/*19.53*/(""".png"        class="menu-icon">
      """)))}),format.raw/*20.8*/("""
      """),_display_(/*21.8*/if(expand)/*21.18*/{_display_(Seq[Any](format.raw/*21.19*/(""" """),_display_(/*21.21*/label)))}),format.raw/*21.27*/("""
      """),_display_(/*22.8*/if(expand && count > 0)/*22.31*/{_display_(Seq[Any](format.raw/*22.32*/("""
        """),format.raw/*23.9*/("""<div class="pull-right"><span class="label">"""),_display_(/*23.54*/count),format.raw/*23.59*/("""</span></div>
      """)))}),format.raw/*24.8*/("""
    """),format.raw/*25.5*/("""</a>
  </li>
""")))};def /*29.2*/sidemenuPlugin/*29.16*/(path: String, name: String, label: String, icon: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*29.77*/("""
  """),format.raw/*30.3*/("""<li """),_display_(/*30.8*/if(active == name)/*30.26*/{_display_(Seq[Any](format.raw/*30.27*/("""class="active"""")))}),format.raw/*30.42*/(""">
    <div class=""""),_display_(/*31.18*/if(active == name)/*31.36*/{_display_(Seq[Any](format.raw/*31.37*/("""margin""")))}/*31.45*/else/*31.50*/{_display_(Seq[Any](format.raw/*31.51*/("""gradient""")))}),format.raw/*31.60*/(""" """),format.raw/*31.61*/("""pull-left"></div>
    <a href=""""),_display_(/*32.15*/url(repository)),_display_(/*32.31*/path),format.raw/*32.35*/(""""><img src=""""),_display_(/*32.48*/icon),format.raw/*32.52*/(""""/>"""),_display_(/*32.56*/if(expand)/*32.66*/{_display_(Seq[Any](format.raw/*32.67*/(""" """),_display_(/*32.69*/label)))}),format.raw/*32.75*/("""</a>
  </li>
""")))};
Seq[Any](format.raw/*7.72*/("""
"""),format.raw/*10.1*/("""
"""),format.raw/*27.2*/("""

"""),format.raw/*34.2*/("""

"""),format.raw/*36.1*/("""<div class="container">
  """),_display_(/*37.4*/helper/*37.10*/.html.information(info)),format.raw/*37.33*/("""
  """),_display_(/*38.4*/helper/*38.10*/.html.error(error)),format.raw/*38.28*/("""
  """),_display_(/*39.4*/if(repository.commitCount > 0)/*39.34*/{_display_(Seq[Any](format.raw/*39.35*/("""
    """),format.raw/*40.5*/("""<div class="pull-right">
      <div class="input-prepend">
      """),_display_(/*42.8*/if(loginAccount.isEmpty)/*42.32*/{_display_(Seq[Any](format.raw/*42.33*/("""
        """),format.raw/*43.9*/("""<a title="You must be signed in to fork a repository" href=""""),_display_(/*43.70*/path),format.raw/*43.74*/("""/signin" class="btn btn-small" style="margin-bottom: 10px;">Fork</a>
      """)))}/*44.9*/else/*44.14*/{_display_(Seq[Any](format.raw/*44.15*/("""
        """),_display_(/*45.10*/if(isNoGroup)/*45.23*/ {_display_(Seq[Any](format.raw/*45.25*/("""
          """),format.raw/*46.11*/("""<a href=""""),_display_(/*46.21*/path),format.raw/*46.25*/("""/"""),_display_(/*46.27*/repository/*46.37*/.owner),format.raw/*46.43*/("""/"""),_display_(/*46.45*/repository/*46.55*/.name),format.raw/*46.60*/("""/fork" class="btn btn-small" style="margin-bottom: 10px;" data-account=""""),_display_(/*46.133*/loginAccount/*46.145*/.get.userName),format.raw/*46.158*/("""">Fork</a>
        """)))}/*47.11*/else/*47.16*/{_display_(Seq[Any](format.raw/*47.17*/("""
          """),format.raw/*48.11*/("""<a href=""""),_display_(/*48.21*/path),format.raw/*48.25*/("""/"""),_display_(/*48.27*/repository/*48.37*/.owner),format.raw/*48.43*/("""/"""),_display_(/*48.45*/repository/*48.55*/.name),format.raw/*48.60*/("""/fork" class="btn btn-small" rel="facebox" style="margin-bottom: 10px;">Fork</a>
        """)))}),format.raw/*49.10*/("""
      """)))}),format.raw/*50.8*/("""
        """),format.raw/*51.9*/("""<span class="add-on count"><a href=""""),_display_(/*51.46*/url(repository)),format.raw/*51.61*/("""/network/members">"""),_display_(/*51.80*/repository/*51.90*/.forkedCount),format.raw/*51.102*/("""</a></span>
      </div>
    </div>
  """)))}),format.raw/*54.4*/("""
  """),format.raw/*55.3*/("""<div class="head">
    """),_display_(/*56.6*/helper/*56.12*/.html.repositoryicon(repository, true)),format.raw/*56.50*/("""
    """),format.raw/*57.5*/("""<a href=""""),_display_(/*57.15*/url(repository.owner)),format.raw/*57.36*/("""">"""),_display_(/*57.39*/repository/*57.49*/.owner),format.raw/*57.55*/("""</a> / <a href=""""),_display_(/*57.72*/url(repository)),format.raw/*57.87*/("""" class="strong">"""),_display_(/*57.105*/repository/*57.115*/.name),format.raw/*57.120*/("""</a>

    """),_display_(/*59.6*/defining(repository.repository)/*59.37*/{ x =>_display_(Seq[Any](format.raw/*59.43*/("""
      """),_display_(/*60.8*/if(repository.repository.originRepositoryName.isDefined)/*60.64*/{_display_(Seq[Any](format.raw/*60.65*/("""
        """),format.raw/*61.9*/("""<div class="forked">
          forked from <a href=""""),_display_(/*62.33*/path),format.raw/*62.37*/("""/"""),_display_(/*62.39*/x/*62.40*/.parentUserName),format.raw/*62.55*/("""/"""),_display_(/*62.57*/x/*62.58*/.parentRepositoryName),format.raw/*62.79*/("""">"""),_display_(/*62.82*/x/*62.83*/.parentUserName),format.raw/*62.98*/("""/"""),_display_(/*62.100*/x/*62.101*/.parentRepositoryName),format.raw/*62.122*/("""</a>
        </div>
      """)))}),format.raw/*64.8*/("""
    """)))}),format.raw/*65.6*/("""
  """),format.raw/*66.3*/("""</div>
</div>
<hr style="margin-bottom: 20px;"/>
<div class="container body">
  <div style="width: """),_display_(/*70.23*/if(expand)/*70.33*/{_display_(Seq[Any](format.raw/*70.34*/("""170px""")))}/*70.41*/else/*70.46*/{_display_(Seq[Any](format.raw/*70.47*/("""40px""")))}),format.raw/*70.52*/(""";" class="pull-right">
    <ul class="sidemenu">
      <li style="height: 12px"><div class="gradient pull-left" style="height: 12px"></div></li>
      """),_display_(/*73.8*/sidemenu(""       , "code"  , "Code")),format.raw/*73.45*/("""
      """),_display_(/*74.8*/sidemenu("/issues", "issues", "Issues", repository.issueCount)),format.raw/*74.70*/("""
      """),_display_(/*75.8*/sidemenu("/pulls" , "pulls" , "Pull Requests", repository.pullCount)),format.raw/*75.76*/("""
      """),_display_(/*76.8*/sidemenu("/wiki"  , "wiki"  , "Wiki")),format.raw/*76.45*/("""
      """),_display_(/*77.8*/if(loginAccount.isDefined && (loginAccount.get.isAdmin || repository.managers.contains(loginAccount.get.userName)))/*77.123*/{_display_(Seq[Any](format.raw/*77.124*/("""
        """),_display_(/*78.10*/sidemenu("/settings", "settings", "Settings")),format.raw/*78.55*/("""
      """)))}),format.raw/*79.8*/("""
      """),format.raw/*80.7*/("""<li style="height: 12px"><div class="gradient pull-left" style="height: 12px"></div></li>
    </ul>
    """),_display_(/*82.6*/if(expand)/*82.16*/{_display_(Seq[Any](format.raw/*82.17*/("""
      """),format.raw/*83.7*/("""<div class="small">
        <strong id="repository-url-proto">HTTP</strong> <span class="mute">clone URL</span>
      </div>
      """),_display_(/*86.8*/helper/*86.14*/.html.copy("repository-url-copy", repository.httpUrl)/*86.67*/{_display_(Seq[Any](format.raw/*86.68*/("""
        """),format.raw/*87.9*/("""<input type="text" value=""""),_display_(/*87.36*/repository/*87.46*/.httpUrl),format.raw/*87.54*/("""" id="repository-url" readonly>
      """)))}),format.raw/*88.8*/("""
      """),_display_(/*89.8*/if(settings.ssh && loginAccount.isDefined)/*89.50*/{_display_(Seq[Any](format.raw/*89.51*/("""
        """),format.raw/*90.9*/("""<div class="small">
          <span class="mute">You can clone <a href="javascript:void(0);" id="repository-url-http">HTTP</a> or <a href="javascript:void(0);" id="repository-url-ssh">SSH</a>.</span>
        </div>
      """)))}),format.raw/*93.8*/("""
      """),_display_(/*94.8*/id/*94.10*/.map/*94.14*/ { id =>_display_(Seq[Any](format.raw/*94.22*/("""
        """),format.raw/*95.9*/("""<div style="margin-top: 10px;">
          <a href=""""),_display_(/*96.21*/{url(repository)}),format.raw/*96.38*/("""/archive/"""),_display_(/*96.48*/{encodeRefName(id)}),format.raw/*96.67*/(""".zip" class="btn btn-small" style="width: 147px;"><i class="icon-download-alt"></i>Download ZIP</a>
        </div>
        <div style="margin-top: 10px;">
          <a href=""""),_display_(/*99.21*/{url(repository)}),format.raw/*99.38*/("""/archive/"""),_display_(/*99.48*/{encodeRefName(id)}),format.raw/*99.67*/(""".tar.gz" class="btn btn-small" style="width: 147px;"><i class="icon-download-alt"></i>Download TAR.GZ</a>
        </div>
      """)))}),format.raw/*101.8*/("""
    """)))}),format.raw/*102.6*/("""
  """),format.raw/*103.3*/("""</div>
  <div style="margin-right: """),_display_(/*104.30*/if(expand)/*104.40*/{_display_(Seq[Any](format.raw/*104.41*/("""180px""")))}/*104.48*/else/*104.53*/{_display_(Seq[Any](format.raw/*104.54*/("""50px""")))}),format.raw/*104.59*/(""";">
    """),_display_(/*105.6*/if(expand)/*105.16*/{_display_(Seq[Any](format.raw/*105.17*/("""
      """),_display_(/*106.8*/repository/*106.18*/.repository.description.map/*106.45*/ { description =>_display_(Seq[Any](format.raw/*106.62*/("""
        """),format.raw/*107.9*/("""<p class="description">"""),_display_(/*107.33*/description),format.raw/*107.44*/("""</p>
      """)))}),format.raw/*108.8*/("""
      """),format.raw/*109.7*/("""<div style="border: 1px solid #eee; padding: 4px; margin-bottom: 10px;">
        <table class="fill-width">
          <tr>
            <td style="width: 33%; text-align: center;">
              <a href=""""),_display_(/*113.25*/url(repository)),format.raw/*113.40*/("""/commits/"""),_display_(/*113.50*/encodeRefName(id.getOrElse(""))),format.raw/*113.81*/("""" class="header-link">
                <img src=""""),_display_(/*114.28*/assets),format.raw/*114.34*/("""/common/images/header-commits-hover.png" class="header-icon-hover" style="display: none;"/>
                <img src=""""),_display_(/*115.28*/assets),format.raw/*115.34*/("""/common/images/header-commits.png"       class="header-icon"/>
                <strong>"""),_display_(/*116.26*/repository/*116.36*/.commitCount),format.raw/*116.48*/("""</strong> commits
              </a>
            </td>
            <td style="width: 33%; text-align: center;">
              <a href=""""),_display_(/*120.25*/url(repository)),format.raw/*120.40*/("""/branches" class="header-link" class="header-link">
                <img src=""""),_display_(/*121.28*/assets),format.raw/*121.34*/("""/common/images/header-branches-hover.png" class="header-icon-hover" style="display: none;"/>
                <img src=""""),_display_(/*122.28*/assets),format.raw/*122.34*/("""/common/images/header-branches.png"       class="header-icon"/>
                <strong>"""),_display_(/*123.26*/repository/*123.36*/.branchList.length),format.raw/*123.54*/("""</strong> branches
              </a>
            </td>
            <td style="width: 33%; text-align: center;">
              <a href=""""),_display_(/*127.25*/url(repository)),format.raw/*127.40*/("""/tags" class="header-link" class="header-link">
                <img src=""""),_display_(/*128.28*/assets),format.raw/*128.34*/("""/common/images/header-tags-hover.png" class="header-icon-hover" style="display: none;"/>
                <img src=""""),_display_(/*129.28*/assets),format.raw/*129.34*/("""/common/images/header-tags.png"       class="header-icon"/>
                <strong>"""),_display_(/*130.26*/repository/*130.36*/.tags.length),format.raw/*130.48*/("""</strong> releases
              </a>
            </td>
          </tr>
        </table>
      </div>
    """)))}),format.raw/*136.6*/("""
    """),_display_(/*137.6*/body),format.raw/*137.10*/("""
  """),format.raw/*138.3*/("""</div>
</div>
<script>
$(function()"""),format.raw/*141.13*/("""{"""),format.raw/*141.14*/("""
  """),format.raw/*142.3*/("""$('a.header-link').mouseover(function(e)"""),format.raw/*142.43*/("""{"""),format.raw/*142.44*/("""
    """),format.raw/*143.5*/("""var target = e.target;
    if(e.target.tagName != 'A')"""),format.raw/*144.32*/("""{"""),format.raw/*144.33*/("""
      """),format.raw/*145.7*/("""target = e.target.parentElement;
    """),format.raw/*146.5*/("""}"""),format.raw/*146.6*/("""
    """),format.raw/*147.5*/("""$(target).children('strong'               ).css('color', '#0088cc');
    $(target).children('img.header-icon-hover').css('display', 'inline');
    $(target).children('img.header-icon'      ).css('display', 'none');
  """),format.raw/*150.3*/("""}"""),format.raw/*150.4*/(""");

  $('a.header-link').mouseout(function(e)"""),format.raw/*152.42*/("""{"""),format.raw/*152.43*/("""
    """),format.raw/*153.5*/("""var target = e.target;
    if(e.target.tagName != 'A')"""),format.raw/*154.32*/("""{"""),format.raw/*154.33*/("""
      """),format.raw/*155.7*/("""target = e.target.parentElement;
    """),format.raw/*156.5*/("""}"""),format.raw/*156.6*/("""
    """),format.raw/*157.5*/("""$(target).children('strong'               ).css('color', 'black');
    $(target).children('img.header-icon-hover').css('display', 'none');
    $(target).children('img.header-icon'      ).css('display', 'inline');
  """),format.raw/*160.3*/("""}"""),format.raw/*160.4*/(""");

  $('ul.sidemenu a').mouseover(function(e)"""),format.raw/*162.43*/("""{"""),format.raw/*162.44*/("""
    """),format.raw/*163.5*/("""var target = e.target;
    if(e.target.tagName == "IMG")"""),format.raw/*164.34*/("""{"""),format.raw/*164.35*/("""
      """),format.raw/*165.7*/("""target = e.target.parentElement;
    """),format.raw/*166.5*/("""}"""),format.raw/*166.6*/("""
    """),format.raw/*167.5*/("""$(target).prev    ('div.gradient'        ).css('border-left', '1px solid silver');
    $(target).children('img.menu-icon-active').css('display', 'inline');
    $(target).children('img.menu-icon'       ).css('display', 'none');
  """),format.raw/*170.3*/("""}"""),format.raw/*170.4*/(""");

  $('ul.sidemenu a').mouseout(function(e)"""),format.raw/*172.42*/("""{"""),format.raw/*172.43*/("""
    """),format.raw/*173.5*/("""var target = e.target;
    if(e.target.tagName == "IMG")"""),format.raw/*174.34*/("""{"""),format.raw/*174.35*/("""
      """),format.raw/*175.7*/("""target = e.target.parentElement;
    """),format.raw/*176.5*/("""}"""),format.raw/*176.6*/("""
    """),format.raw/*177.5*/("""$(target).prev    ('div.gradient'        ).css('border-left', '1px solid #eee');
    $(target).children('img.menu-icon-active').css('display', 'none');
    $(target).children('img.menu-icon'       ).css('display', 'inline');
  """),format.raw/*180.3*/("""}"""),format.raw/*180.4*/(""");

  $('a[rel*=facebox]').facebox();

  $(document).on("click", ".js-fork-owner-select-target", function() """),format.raw/*184.70*/("""{"""),format.raw/*184.71*/("""
    """),format.raw/*185.5*/("""if (!$(this).hasClass("disabled")) """),format.raw/*185.40*/("""{"""),format.raw/*185.41*/("""
      """),format.raw/*186.7*/("""var account = $(this).text().replace("@", "");
      $("#account").val(account);
      $("#fork").submit();
    """),format.raw/*189.5*/("""}"""),format.raw/*189.6*/("""
  """),format.raw/*190.3*/("""}"""),format.raw/*190.4*/(""");

  """),_display_(/*192.4*/if(loginAccount.isDefined)/*192.30*/{_display_(Seq[Any](format.raw/*192.31*/("""
    """),format.raw/*193.5*/("""$(document).on("click", "a[data-account]", function(e) """),format.raw/*193.60*/("""{"""),format.raw/*193.61*/("""
      """),format.raw/*194.7*/("""e.preventDefault();
      var form = $('<form/>', """),format.raw/*195.31*/("""{"""),format.raw/*195.32*/("""
        """),format.raw/*196.9*/("""action: $(this).attr('href'),
        method: "post"
      """),format.raw/*198.7*/("""}"""),format.raw/*198.8*/(""");
      var account = $('<input/>', """),format.raw/*199.35*/("""{"""),format.raw/*199.36*/("""
        """),format.raw/*200.9*/("""type: "hidden",
        name: "account",
        value: $(this).data('account')
      """),format.raw/*203.7*/("""}"""),format.raw/*203.8*/(""");
      form.append(account);
      form.submit();
    """),format.raw/*206.5*/("""}"""),format.raw/*206.6*/(""");
  """)))}),format.raw/*207.4*/("""

  """),_display_(/*209.4*/if(settings.ssh && loginAccount.isDefined)/*209.46*/{_display_(Seq[Any](format.raw/*209.47*/("""
    """),format.raw/*210.5*/("""$('#repository-url-http').click(function()"""),format.raw/*210.47*/("""{"""),format.raw/*210.48*/("""
      """),format.raw/*211.7*/("""$('#repository-url-proto').text('HTTP');
      $('#repository-url').val('"""),_display_(/*212.34*/repository/*212.44*/.httpUrl),format.raw/*212.52*/("""');
      $('#repository-url-copy').attr('data-clipboard-text', $('#repository-url').val());
    """),format.raw/*214.5*/("""}"""),format.raw/*214.6*/(""");

    $('#repository-url-ssh').click(function()"""),format.raw/*216.46*/("""{"""),format.raw/*216.47*/("""
      """),format.raw/*217.7*/("""$('#repository-url-proto').text('SSH');
      $('#repository-url').val('"""),_display_(/*218.34*/repository/*218.44*/.sshUrl(settings.sshPort.getOrElse(service.SystemSettingsService.DefaultSshPort), loginAccount.get.userName)),format.raw/*218.152*/("""');
      $('#repository-url-copy').attr('data-clipboard-text', $('#repository-url').val());
    """),format.raw/*220.5*/("""}"""),format.raw/*220.6*/(""");
  """)))}),format.raw/*221.4*/("""
"""),format.raw/*222.1*/("""}"""),format.raw/*222.2*/(""");
</script>
"""))}
  }

  def render(active:String,repository:service.RepositoryService.RepositoryInfo,id:Option[String],expand:Boolean,isNoGroup:Boolean,info:Option[Any],error:Option[Any],body:Html,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(active,repository,id,expand,isNoGroup,info,error)(body)(context)

  def f:((String,service.RepositoryService.RepositoryInfo,Option[String],Boolean,Boolean,Option[Any],Option[Any]) => (Html) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (active,repository,id,expand,isNoGroup,info,error) => (body) => (context) => apply(active,repository,id,expand,isNoGroup,info,error)(body)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/menu.scala.html
                  HASH: fc3e25cf82518ef7ffdf6aa742a8817f2ec74fe2
                  MATRIX: 449->1|816->302|833->310|973->373|1003->376|1034->381|1061->399|1100->400|1146->415|1192->434|1219->452|1258->453|1284->461|1297->466|1336->467|1376->476|1405->477|1464->509|1500->525|1525->529|1555->619|1590->628|1617->646|1656->647|1692->656|1730->667|1757->673|1805->694|1832->700|1871->722|1884->727|1923->728|1959->737|1997->748|2024->754|2072->775|2099->781|2206->861|2233->867|2281->888|2308->894|2377->933|2411->941|2430->951|2469->952|2498->954|2528->960|2562->968|2594->991|2633->992|2669->1001|2741->1046|2767->1051|2818->1072|2850->1077|2887->1094|2910->1108|3048->1169|3078->1172|3109->1177|3136->1195|3175->1196|3221->1211|3267->1230|3294->1248|3333->1249|3359->1257|3372->1262|3411->1263|3451->1272|3480->1273|3539->1305|3575->1321|3600->1325|3640->1338|3665->1342|3696->1346|3715->1356|3754->1357|3783->1359|3813->1365|3866->258|3894->300|3922->1091|3951->1379|3980->1381|4033->1408|4048->1414|4092->1437|4122->1441|4137->1447|4176->1465|4206->1469|4245->1499|4284->1500|4316->1505|4408->1571|4441->1595|4480->1596|4516->1605|4604->1666|4629->1670|4723->1747|4736->1752|4775->1753|4812->1763|4834->1776|4874->1778|4913->1789|4950->1799|4975->1803|5004->1805|5023->1815|5050->1821|5079->1823|5098->1833|5124->1838|5225->1911|5247->1923|5282->1936|5321->1957|5334->1962|5373->1963|5412->1974|5449->1984|5474->1988|5503->1990|5522->2000|5549->2006|5578->2008|5597->2018|5623->2023|5744->2113|5782->2121|5818->2130|5882->2167|5918->2182|5964->2201|5983->2211|6017->2223|6086->2262|6116->2265|6166->2289|6181->2295|6240->2333|6272->2338|6309->2348|6351->2369|6381->2372|6400->2382|6427->2388|6471->2405|6507->2420|6553->2438|6573->2448|6600->2453|6637->2464|6677->2495|6721->2501|6755->2509|6820->2565|6859->2566|6895->2575|6975->2628|7000->2632|7029->2634|7039->2635|7075->2650|7104->2652|7114->2653|7156->2674|7186->2677|7196->2678|7232->2693|7262->2695|7273->2696|7316->2717|7373->2744|7409->2750|7439->2753|7566->2853|7585->2863|7624->2864|7649->2871|7662->2876|7701->2877|7737->2882|7915->3034|7973->3071|8007->3079|8090->3141|8124->3149|8213->3217|8247->3225|8305->3262|8339->3270|8464->3385|8504->3386|8541->3396|8607->3441|8645->3449|8679->3456|8810->3561|8829->3571|8868->3572|8902->3579|9060->3711|9075->3717|9137->3770|9176->3771|9212->3780|9266->3807|9285->3817|9314->3825|9383->3864|9417->3872|9468->3914|9507->3915|9543->3924|9795->4146|9829->4154|9840->4156|9853->4160|9899->4168|9935->4177|10014->4229|10052->4246|10089->4256|10129->4275|10331->4450|10369->4467|10406->4477|10446->4496|10605->4624|10642->4630|10673->4633|10737->4669|10757->4679|10797->4680|10823->4687|10837->4692|10877->4693|10914->4698|10950->4707|10970->4717|11010->4718|11045->4726|11065->4736|11102->4763|11158->4780|11195->4789|11247->4813|11280->4824|11323->4836|11358->4843|11590->5047|11627->5062|11665->5072|11718->5103|11796->5153|11824->5159|11971->5278|11999->5284|12115->5372|12135->5382|12169->5394|12333->5530|12370->5545|12477->5624|12505->5630|12653->5750|12681->5756|12798->5845|12818->5855|12858->5873|13023->6010|13060->6025|13163->6100|13191->6106|13335->6222|13363->6228|13476->6313|13496->6323|13530->6335|13668->6442|13701->6448|13727->6452|13758->6455|13822->6490|13852->6491|13883->6494|13952->6534|13982->6535|14015->6540|14098->6594|14128->6595|14163->6602|14228->6639|14257->6640|14290->6645|14535->6862|14564->6863|14638->6908|14668->6909|14701->6914|14784->6968|14814->6969|14849->6976|14914->7013|14943->7014|14976->7019|15219->7234|15248->7235|15323->7281|15353->7282|15386->7287|15471->7343|15501->7344|15536->7351|15601->7388|15630->7389|15663->7394|15920->7623|15949->7624|16023->7669|16053->7670|16086->7675|16171->7731|16201->7732|16236->7739|16301->7776|16330->7777|16363->7782|16618->8009|16647->8010|16784->8118|16814->8119|16847->8124|16911->8159|16941->8160|16976->8167|17116->8280|17145->8281|17176->8284|17205->8285|17239->8292|17275->8318|17315->8319|17348->8324|17432->8379|17462->8380|17497->8387|17576->8437|17606->8438|17643->8447|17730->8506|17759->8507|17825->8544|17855->8545|17892->8554|18006->8640|18035->8641|18119->8697|18148->8698|18185->8704|18217->8709|18269->8751|18309->8752|18342->8757|18413->8799|18443->8800|18478->8807|18580->8881|18600->8891|18630->8899|18755->8996|18784->8997|18862->9046|18892->9047|18927->9054|19028->9127|19048->9137|19179->9245|19304->9342|19333->9343|19370->9349|19399->9350|19428->9351
                  LINES: 13->1|22->11|22->11|24->11|25->12|25->12|25->12|25->12|25->12|26->13|26->13|26->13|26->13|26->13|26->13|26->13|26->13|27->14|27->14|27->14|27->14|28->15|28->15|28->15|29->16|29->16|29->16|29->16|29->16|30->17|30->17|30->17|31->18|31->18|31->18|31->18|31->18|32->19|32->19|32->19|32->19|33->20|34->21|34->21|34->21|34->21|34->21|35->22|35->22|35->22|36->23|36->23|36->23|37->24|38->25|40->29|40->29|42->29|43->30|43->30|43->30|43->30|43->30|44->31|44->31|44->31|44->31|44->31|44->31|44->31|44->31|45->32|45->32|45->32|45->32|45->32|45->32|45->32|45->32|45->32|45->32|48->7|49->10|50->27|52->34|54->36|55->37|55->37|55->37|56->38|56->38|56->38|57->39|57->39|57->39|58->40|60->42|60->42|60->42|61->43|61->43|61->43|62->44|62->44|62->44|63->45|63->45|63->45|64->46|64->46|64->46|64->46|64->46|64->46|64->46|64->46|64->46|64->46|64->46|64->46|65->47|65->47|65->47|66->48|66->48|66->48|66->48|66->48|66->48|66->48|66->48|66->48|67->49|68->50|69->51|69->51|69->51|69->51|69->51|69->51|72->54|73->55|74->56|74->56|74->56|75->57|75->57|75->57|75->57|75->57|75->57|75->57|75->57|75->57|75->57|75->57|77->59|77->59|77->59|78->60|78->60|78->60|79->61|80->62|80->62|80->62|80->62|80->62|80->62|80->62|80->62|80->62|80->62|80->62|80->62|80->62|80->62|82->64|83->65|84->66|88->70|88->70|88->70|88->70|88->70|88->70|88->70|91->73|91->73|92->74|92->74|93->75|93->75|94->76|94->76|95->77|95->77|95->77|96->78|96->78|97->79|98->80|100->82|100->82|100->82|101->83|104->86|104->86|104->86|104->86|105->87|105->87|105->87|105->87|106->88|107->89|107->89|107->89|108->90|111->93|112->94|112->94|112->94|112->94|113->95|114->96|114->96|114->96|114->96|117->99|117->99|117->99|117->99|119->101|120->102|121->103|122->104|122->104|122->104|122->104|122->104|122->104|122->104|123->105|123->105|123->105|124->106|124->106|124->106|124->106|125->107|125->107|125->107|126->108|127->109|131->113|131->113|131->113|131->113|132->114|132->114|133->115|133->115|134->116|134->116|134->116|138->120|138->120|139->121|139->121|140->122|140->122|141->123|141->123|141->123|145->127|145->127|146->128|146->128|147->129|147->129|148->130|148->130|148->130|154->136|155->137|155->137|156->138|159->141|159->141|160->142|160->142|160->142|161->143|162->144|162->144|163->145|164->146|164->146|165->147|168->150|168->150|170->152|170->152|171->153|172->154|172->154|173->155|174->156|174->156|175->157|178->160|178->160|180->162|180->162|181->163|182->164|182->164|183->165|184->166|184->166|185->167|188->170|188->170|190->172|190->172|191->173|192->174|192->174|193->175|194->176|194->176|195->177|198->180|198->180|202->184|202->184|203->185|203->185|203->185|204->186|207->189|207->189|208->190|208->190|210->192|210->192|210->192|211->193|211->193|211->193|212->194|213->195|213->195|214->196|216->198|216->198|217->199|217->199|218->200|221->203|221->203|224->206|224->206|225->207|227->209|227->209|227->209|228->210|228->210|228->210|229->211|230->212|230->212|230->212|232->214|232->214|234->216|234->216|235->217|236->218|236->218|236->218|238->220|238->220|239->221|240->222|240->222
                  -- GENERATED --
              */
          