
package html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,Option[service.RepositoryService.RepositoryInfo],Html,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, repository: Option[service.RepositoryService.RepositoryInfo] = None)(body: Html)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*1.129*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>"""),_display_(/*8.13*/title),format.raw/*8.18*/("""</title>
    <link rel="icon" href=""""),_display_(/*9.29*/assets),format.raw/*9.35*/("""/common/images/favicon.png" type="image/vnd.microsoft.icon" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Le styles -->
    <link href=""""),_display_(/*12.18*/assets),format.raw/*12.24*/("""/vendors/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href=""""),_display_(/*13.18*/assets),format.raw/*13.24*/("""/vendors/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src=""""),_display_(/*16.21*/assets),format.raw/*16.27*/("""/vendors/bootstrap/js/html5shiv.js"></script>
    <![endif]-->
    <link href=""""),_display_(/*18.18*/assets),format.raw/*18.24*/("""/vendors/datepicker/css/datepicker.css" rel="stylesheet">
    <link href=""""),_display_(/*19.18*/assets),format.raw/*19.24*/("""/vendors/colorpicker/css/bootstrap-colorpicker.css" rel="stylesheet">
    <link href=""""),_display_(/*20.18*/assets),format.raw/*20.24*/("""/vendors/google-code-prettify/prettify.css" type="text/css" rel="stylesheet"/>
    <link href=""""),_display_(/*21.18*/assets),format.raw/*21.24*/("""/vendors/facebox/facebox.css" rel="stylesheet"/>
    <link href=""""),_display_(/*22.18*/assets),format.raw/*22.24*/("""/common/css/gitbucket.css" rel="stylesheet">
    <script src=""""),_display_(/*23.19*/assets),format.raw/*23.25*/("""/vendors/jquery/jquery-1.9.1.js"></script>
    <script src=""""),_display_(/*24.19*/assets),format.raw/*24.25*/("""/vendors/dropzone/dropzone.js"></script>
    <script src=""""),_display_(/*25.19*/assets),format.raw/*25.25*/("""/common/js/validation.js"></script>
    <script src=""""),_display_(/*26.19*/assets),format.raw/*26.25*/("""/common/js/gitbucket.js"></script>
    <script src=""""),_display_(/*27.19*/assets),format.raw/*27.25*/("""/vendors/bootstrap/js/bootstrap.js"></script>
    <script src=""""),_display_(/*28.19*/assets),format.raw/*28.25*/("""/vendors/datepicker/js/bootstrap-datepicker.js"></script>
    <script src=""""),_display_(/*29.19*/assets),format.raw/*29.25*/("""/vendors/colorpicker/js/bootstrap-colorpicker.js"></script>
    <script src=""""),_display_(/*30.19*/assets),format.raw/*30.25*/("""/vendors/google-code-prettify/prettify.js"></script>
    <script src=""""),_display_(/*31.19*/assets),format.raw/*31.25*/("""/vendors/zclip/ZeroClipboard.min.js"></script>
    <script src=""""),_display_(/*32.19*/assets),format.raw/*32.25*/("""/vendors/elastic/jquery.elastic.source.js"></script>
    <script src=""""),_display_(/*33.19*/assets),format.raw/*33.25*/("""/vendors/facebox/facebox.js"></script>
  </head>
  <body>
    <form id="search" action=""""),_display_(/*36.32*/path),format.raw/*36.36*/("""/search" method="POST">
      <div class="navbar">
        <div class="navbar-inner">
          <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="brand" href=""""),_display_(/*45.37*/path),format.raw/*45.41*/("""/">
              <img src=""""),_display_(/*46.26*/assets),format.raw/*46.32*/("""/common/images/gitbucket.png"/>GitBucket
              """),_display_(/*47.16*/defining(servlet.AutoUpdate.getCurrentVersion)/*47.62*/{ version =>_display_(Seq[Any](format.raw/*47.74*/("""
                """),format.raw/*48.17*/("""<span class="header-version">"""),_display_(/*48.47*/version/*48.54*/.majorVersion),format.raw/*48.67*/("""."""),_display_(/*48.69*/version/*48.76*/.minorVersion),format.raw/*48.89*/("""</span>
              """)))}),format.raw/*49.16*/("""
            """),format.raw/*50.13*/("""</a>
            <div class="nav-collapse collapse pull-right header-menu">
              """),_display_(/*52.16*/repository/*52.26*/.map/*52.30*/ { repository =>_display_(Seq[Any](format.raw/*52.46*/("""
                """),format.raw/*53.17*/("""<input type="text" name="query" style="width: 300px; margin-bottom: 0px;" placeholder="Search this repository"/>
                <input type="hidden" name="owner" value=""""),_display_(/*54.59*/repository/*54.69*/.owner),format.raw/*54.75*/(""""/>
                <input type="hidden" name="repository" value=""""),_display_(/*55.64*/repository/*55.74*/.name),format.raw/*55.79*/(""""/>
              """)))}),format.raw/*56.16*/("""
              """),_display_(/*57.16*/if(loginAccount.isDefined)/*57.42*/{_display_(Seq[Any](format.raw/*57.43*/("""
                """),format.raw/*58.17*/("""<a href=""""),_display_(/*58.27*/url(loginAccount.get.userName)),format.raw/*58.57*/("""" class="username menu">"""),_display_(/*58.82*/avatar(loginAccount.get.userName, 20)),format.raw/*58.119*/(""" """),_display_(/*58.121*/loginAccount/*58.133*/.get.userName),format.raw/*58.146*/("""</a>
                <a class="dropdown-toggle menu" data-toggle="dropdown" href="#"><i class="icon-plus"></i><span class="caret" style="vertical-align: middle;"></span></a>
                <ul class="dropdown-menu">
                  <li><a href=""""),_display_(/*61.33*/path),format.raw/*61.37*/("""/new">New repository</a></li>
                  <li><a href=""""),_display_(/*62.33*/path),format.raw/*62.37*/("""/groups/new">New group</a></li>
                </ul>
                <a href=""""),_display_(/*64.27*/url(loginAccount.get.userName)),format.raw/*64.57*/("""/_edit" class="menu" data-toggle="tooltip" data-placement="bottom" title="Account settings"><i class="icon-user"></i></a>
                """),_display_(/*65.18*/if(loginAccount.get.isAdmin)/*65.46*/{_display_(Seq[Any](format.raw/*65.47*/("""
                  """),format.raw/*66.19*/("""<a href=""""),_display_(/*66.29*/path),format.raw/*66.33*/("""/admin/users" class="menu" data-toggle="tooltip" data-placement="bottom" title="Administration"><i class="icon-wrench"></i></a>
                """)))}),format.raw/*67.18*/("""
                """),format.raw/*68.17*/("""<a href=""""),_display_(/*68.27*/path),format.raw/*68.31*/("""/signout" class="menu-last" data-toggle="tooltip" data-placement="bottom" title="Sign out"><i class="icon-share-alt"></i></a>
              """)))}/*69.17*/else/*69.22*/{_display_(Seq[Any](format.raw/*69.23*/("""
                """),format.raw/*70.17*/("""<a href=""""),_display_(/*70.27*/path),format.raw/*70.31*/("""/signin?redirect="""),_display_(/*70.49*/urlEncode(currentPath)),format.raw/*70.71*/("""" class="btn btn-last" id="signin">Sign in</a>
              """)))}),format.raw/*71.16*/("""
            """),format.raw/*72.13*/("""</div><!--/.nav-collapse -->
          </div>
        </div>
      </div>
    </form>
    """),_display_(/*77.6*/body),format.raw/*77.10*/("""
    """),format.raw/*78.5*/("""<script>
      $(function()"""),format.raw/*79.19*/("""{"""),format.raw/*79.20*/("""
        """),format.raw/*80.9*/("""$('#search').submit(function()"""),format.raw/*80.39*/("""{"""),format.raw/*80.40*/("""
          """),format.raw/*81.11*/("""return $.trim($(this).find('input[name=query]').val()) != '';
        """),format.raw/*82.9*/("""}"""),format.raw/*82.10*/(""");
      """),format.raw/*83.7*/("""}"""),format.raw/*83.8*/(""");
    </script>
  </body>
</html>
"""))}
  }

  def render(title:String,repository:Option[service.RepositoryService.RepositoryInfo],body:Html,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(title,repository)(body)(context)

  def f:((String,Option[service.RepositoryService.RepositoryInfo]) => (Html) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (title,repository) => (body) => (context) => apply(title,repository)(body)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:10 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/main.scala.html
                  HASH: 77219c00147e8798d496087c76e75a3ac0acccae
                  MATRIX: 402->1|656->128|683->170|780->241|805->246|868->283|894->289|1099->467|1126->473|1226->546|1253->552|1450->722|1477->728|1584->808|1611->814|1713->889|1740->895|1854->982|1881->988|2004->1084|2031->1090|2124->1156|2151->1162|2241->1225|2268->1231|2356->1292|2383->1298|2469->1357|2496->1363|2577->1417|2604->1423|2684->1476|2711->1482|2802->1546|2829->1552|2932->1628|2959->1634|3064->1712|3091->1718|3189->1789|3216->1795|3308->1860|3335->1866|3433->1937|3460->1943|3576->2032|3601->2036|4050->2458|4075->2462|4131->2491|4158->2497|4241->2553|4296->2599|4346->2611|4391->2628|4448->2658|4464->2665|4498->2678|4527->2680|4543->2687|4577->2700|4631->2723|4672->2736|4790->2827|4809->2837|4822->2841|4876->2857|4921->2874|5119->3045|5138->3055|5165->3061|5259->3128|5278->3138|5304->3143|5354->3162|5397->3178|5432->3204|5471->3205|5516->3222|5553->3232|5604->3262|5656->3287|5715->3324|5745->3326|5767->3338|5802->3351|6078->3600|6103->3604|6192->3666|6217->3670|6324->3750|6375->3780|6541->3919|6578->3947|6617->3948|6664->3967|6701->3977|6726->3981|6902->4126|6947->4143|6984->4153|7009->4157|7169->4299|7182->4304|7221->4305|7266->4322|7303->4332|7328->4336|7373->4354|7416->4376|7509->4438|7550->4451|7667->4542|7692->4546|7724->4551|7779->4578|7808->4579|7844->4588|7902->4618|7931->4619|7970->4630|8067->4700|8096->4701|8132->4710|8160->4711
                  LINES: 13->1|17->1|18->4|22->8|22->8|23->9|23->9|26->12|26->12|27->13|27->13|30->16|30->16|32->18|32->18|33->19|33->19|34->20|34->20|35->21|35->21|36->22|36->22|37->23|37->23|38->24|38->24|39->25|39->25|40->26|40->26|41->27|41->27|42->28|42->28|43->29|43->29|44->30|44->30|45->31|45->31|46->32|46->32|47->33|47->33|50->36|50->36|59->45|59->45|60->46|60->46|61->47|61->47|61->47|62->48|62->48|62->48|62->48|62->48|62->48|62->48|63->49|64->50|66->52|66->52|66->52|66->52|67->53|68->54|68->54|68->54|69->55|69->55|69->55|70->56|71->57|71->57|71->57|72->58|72->58|72->58|72->58|72->58|72->58|72->58|72->58|75->61|75->61|76->62|76->62|78->64|78->64|79->65|79->65|79->65|80->66|80->66|80->66|81->67|82->68|82->68|82->68|83->69|83->69|83->69|84->70|84->70|84->70|84->70|84->70|85->71|86->72|91->77|91->77|92->78|93->79|93->79|94->80|94->80|94->80|95->81|96->82|96->82|97->83|97->83
                  -- GENERATED --
              */
          