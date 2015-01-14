
package helper.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object preview extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template11[service.RepositoryService.RepositoryInfo,String,Boolean,Boolean,Boolean,Boolean,String,String,Boolean,Long,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: service.RepositoryService.RepositoryInfo, content: String, enableWikiLink: Boolean, enableRefsLink: Boolean, enableTaskList: Boolean, hasWritePermission: Boolean,
  style: String = "", placeholder: String = "Leave a comment", elastic: Boolean = false, uid: Long = new java.util.Date().getTime())(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._
def /*13.8*/textarea/*13.16*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*13.20*/("""
        """),format.raw/*14.9*/("""<textarea id="content"""),_display_(/*14.31*/uid),format.raw/*14.34*/("""" name="content""""),_display_(/*14.51*/if(style.nonEmpty)/*14.69*/{_display_(Seq[Any](format.raw/*14.70*/(""" """),format.raw/*14.71*/("""style=""""),_display_(/*14.79*/style),format.raw/*14.84*/(""""""")))}),format.raw/*14.86*/(""" """),format.raw/*14.87*/("""placeholder=""""),_display_(/*14.101*/placeholder),format.raw/*14.112*/("""">"""),_display_(/*14.115*/content),format.raw/*14.122*/("""</textarea>
      """)))};
Seq[Any](format.raw/*2.164*/("""
"""),format.raw/*5.1*/("""<div class="tabbable">
  <ul class="nav nav-tabs" style="height: 37px;">
    <li class="active"><a href="#tab"""),_display_(/*7.38*/uid),format.raw/*7.41*/("""" data-toggle="tab">Write</a></li>
    <li><a href="#tab"""),_display_(/*8.23*/(uid+1)),format.raw/*8.30*/("""" data-toggle="tab" id="preview"""),_display_(/*8.62*/uid),format.raw/*8.65*/("""">Preview</a></li>
  </ul>
  <div class="tab-content">
    <div class="tab-pane active" id="tab"""),_display_(/*11.42*/uid),format.raw/*11.45*/("""">
      <span id="error-content" class="error"></span>
      """),format.raw/*15.8*/("""
      """),_display_(/*16.8*/if(enableWikiLink)/*16.26*/{_display_(Seq[Any](format.raw/*16.27*/("""
        """),_display_(/*17.10*/textarea),format.raw/*17.18*/("""
      """)))}/*18.9*/else/*18.14*/{_display_(Seq[Any](format.raw/*18.15*/("""
        """),_display_(/*19.10*/helper/*19.16*/.html.attached(repository.owner, repository.name)/*19.65*/(textarea)),format.raw/*19.75*/("""
      """)))}),format.raw/*20.8*/("""
    """),format.raw/*21.5*/("""</div>
    <div class="tab-pane" id="tab"""),_display_(/*22.35*/(uid+1)),format.raw/*22.42*/("""">
      <div class="markdown-body" id="preview-area"""),_display_(/*23.51*/uid),format.raw/*23.54*/("""">
      </div>
    </div>
  </div>
</div>
<link  href=""""),_display_(/*28.15*/assets),format.raw/*28.21*/("""/vendors/google-code-prettify/prettify.css" type="text/css" rel="stylesheet"/>
<script src=""""),_display_(/*29.15*/assets),format.raw/*29.21*/("""/vendors/google-code-prettify/prettify.js"></script>
<script>
$(function()"""),format.raw/*31.13*/("""{"""),format.raw/*31.14*/("""
  """),_display_(/*32.4*/if(elastic)/*32.15*/{_display_(Seq[Any](format.raw/*32.16*/("""
    """),format.raw/*33.5*/("""$('#content"""),_display_(/*33.17*/uid),format.raw/*33.20*/("""').elastic();
  """)))}),format.raw/*34.4*/("""

  """),format.raw/*36.3*/("""$('#preview"""),_display_(/*36.15*/uid),format.raw/*36.18*/("""').click(function()"""),format.raw/*36.37*/("""{"""),format.raw/*36.38*/("""
    """),format.raw/*37.5*/("""$('#preview-area"""),_display_(/*37.22*/uid),format.raw/*37.25*/("""').html('<img src=""""),_display_(/*37.45*/assets),format.raw/*37.51*/("""/common/images/indicator.gif"> Previewing...');
    $.post('"""),_display_(/*38.14*/url(repository)),format.raw/*38.29*/("""/_preview', """),format.raw/*38.41*/("""{"""),format.raw/*38.42*/("""
      """),format.raw/*39.7*/("""content        : $('#content"""),_display_(/*39.36*/uid),format.raw/*39.39*/("""').val(),
      enableWikiLink : """),_display_(/*40.25*/enableWikiLink),format.raw/*40.39*/(""",
      enableRefsLink : """),_display_(/*41.25*/enableRefsLink),format.raw/*41.39*/(""",
      enableTaskList : """),_display_(/*42.25*/enableTaskList),format.raw/*42.39*/("""
    """),format.raw/*43.5*/("""}"""),format.raw/*43.6*/(""", function(data)"""),format.raw/*43.22*/("""{"""),format.raw/*43.23*/("""
      """),format.raw/*44.7*/("""$('#preview-area"""),_display_(/*44.24*/uid),format.raw/*44.27*/("""').html(data);
      prettyPrint();
    """),format.raw/*46.5*/("""}"""),format.raw/*46.6*/(""");
  """),format.raw/*47.3*/("""}"""),format.raw/*47.4*/(""");
"""),format.raw/*48.1*/("""}"""),format.raw/*48.2*/(""");
</script>
"""))}
  }

  def render(repository:service.RepositoryService.RepositoryInfo,content:String,enableWikiLink:Boolean,enableRefsLink:Boolean,enableTaskList:Boolean,hasWritePermission:Boolean,style:String,placeholder:String,elastic:Boolean,uid:Long,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository,content,enableWikiLink,enableRefsLink,enableTaskList,hasWritePermission,style,placeholder,elastic,uid)(context)

  def f:((service.RepositoryService.RepositoryInfo,String,Boolean,Boolean,Boolean,Boolean,String,String,Boolean,Long) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository,content,enableWikiLink,enableRefsLink,enableTaskList,hasWritePermission,style,placeholder,elastic,uid) => (context) => apply(repository,content,enableWikiLink,enableRefsLink,enableTaskList,hasWritePermission,style,placeholder,elastic,uid)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/preview.scala.html
                  HASH: 1c8d29906b297de36c594df46d9ea53992ce0d8f
                  MATRIX: 459->1|908->756|925->764|1006->768|1042->777|1091->799|1115->802|1159->819|1186->837|1225->838|1254->839|1289->847|1315->852|1348->854|1377->855|1419->869|1452->880|1483->883|1512->890|1571->340|1598->382|1734->492|1757->495|1840->552|1867->559|1925->591|1948->594|2071->690|2095->693|2184->909|2218->917|2245->935|2284->936|2321->946|2350->954|2376->963|2389->968|2428->969|2465->979|2480->985|2538->1034|2569->1044|2607->1052|2639->1057|2707->1098|2735->1105|2815->1158|2839->1161|2923->1218|2950->1224|3070->1317|3097->1323|3199->1397|3228->1398|3258->1402|3278->1413|3317->1414|3349->1419|3388->1431|3412->1434|3459->1451|3490->1455|3529->1467|3553->1470|3600->1489|3629->1490|3661->1495|3705->1512|3729->1515|3776->1535|3803->1541|3891->1602|3927->1617|3967->1629|3996->1630|4030->1637|4086->1666|4110->1669|4171->1703|4206->1717|4259->1743|4294->1757|4347->1783|4382->1797|4414->1802|4442->1803|4486->1819|4515->1820|4549->1827|4593->1844|4617->1847|4684->1887|4712->1888|4744->1893|4772->1894|4802->1897|4830->1898
                  LINES: 13->1|17->13|17->13|19->13|20->14|20->14|20->14|20->14|20->14|20->14|20->14|20->14|20->14|20->14|20->14|20->14|20->14|20->14|20->14|22->2|23->5|25->7|25->7|26->8|26->8|26->8|26->8|29->11|29->11|31->15|32->16|32->16|32->16|33->17|33->17|34->18|34->18|34->18|35->19|35->19|35->19|35->19|36->20|37->21|38->22|38->22|39->23|39->23|44->28|44->28|45->29|45->29|47->31|47->31|48->32|48->32|48->32|49->33|49->33|49->33|50->34|52->36|52->36|52->36|52->36|52->36|53->37|53->37|53->37|53->37|53->37|54->38|54->38|54->38|54->38|55->39|55->39|55->39|56->40|56->40|57->41|57->41|58->42|58->42|59->43|59->43|59->43|59->43|60->44|60->44|60->44|62->46|62->46|63->47|63->47|64->48|64->48
                  -- GENERATED --
              */
          