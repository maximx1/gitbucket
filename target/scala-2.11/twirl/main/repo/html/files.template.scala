
package repo.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object files extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template11[String,service.RepositoryService.RepositoryInfo,List[String],List[String],util.JGitUtil.CommitInfo,List[util.JGitUtil.FileInfo],Option[scala.Tuple2[List[String], String]],Boolean,Option[Any],Option[Any],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(branch: String,
  repository: service.RepositoryService.RepositoryInfo,
  pathList: List[String],
  groupNames: List[String],
  latestCommit: util.JGitUtil.CommitInfo,
  files: List[util.JGitUtil.FileInfo],
  readme: Option[(List[String], String)],
  hasWritePermission: Boolean,
  info: Option[Any] = None,
  error: Option[Any] = None)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*10.60*/("""
"""),_display_(/*13.2*/html/*13.6*/.main(s"${repository.owner}/${repository.name}", Some(repository))/*13.72*/ {_display_(Seq[Any](format.raw/*13.74*/("""
  """),_display_(/*14.4*/html/*14.8*/.menu("code", repository, Some(branch), pathList.isEmpty, groupNames.isEmpty, info, error)/*14.98*/{_display_(Seq[Any](format.raw/*14.99*/("""
    """),format.raw/*15.5*/("""<div class="head">
      """),_display_(/*16.8*/helper/*16.14*/.html.branchcontrol(
        branch,
        repository,
        hasWritePermission
      )/*20.8*/{_display_(Seq[Any](format.raw/*20.9*/("""
        """),_display_(/*21.10*/repository/*21.20*/.branchList.map/*21.35*/ { x =>_display_(Seq[Any](format.raw/*21.42*/("""
          """),format.raw/*22.11*/("""<li><a href=""""),_display_(/*22.25*/url(repository)),format.raw/*22.40*/("""/tree/"""),_display_(/*22.47*/encodeRefName(x)),format.raw/*22.63*/("""">"""),_display_(/*22.66*/helper/*22.72*/.html.checkicon(x == branch)),format.raw/*22.100*/(""" """),_display_(/*22.102*/x),format.raw/*22.103*/("""</a></li>
        """)))}),format.raw/*23.10*/("""
      """)))}),format.raw/*24.8*/("""
      """),format.raw/*25.7*/("""<a href=""""),_display_(/*25.17*/url(repository)),format.raw/*25.32*/("""/tree/"""),_display_(/*25.39*/encodeRefName(branch)),format.raw/*25.60*/("""">"""),_display_(/*25.63*/repository/*25.73*/.name),format.raw/*25.78*/("""</a> /
      """),_display_(/*26.8*/pathList/*26.16*/.zipWithIndex.map/*26.33*/ { case (section, i) =>_display_(Seq[Any](format.raw/*26.56*/("""
        """),format.raw/*27.9*/("""<a href=""""),_display_(/*27.19*/url(repository)),format.raw/*27.34*/("""/tree/"""),_display_(/*27.41*/encodeRefName(branch)),format.raw/*27.62*/("""/"""),_display_(/*27.64*/pathList/*27.72*/.take(i + 1).mkString("/")),format.raw/*27.98*/("""">"""),_display_(/*27.101*/section),format.raw/*27.108*/("""</a> /
      """)))}),format.raw/*28.8*/("""
      """),_display_(/*29.8*/if(hasWritePermission)/*29.30*/{_display_(Seq[Any](format.raw/*29.31*/("""
        """),format.raw/*30.9*/("""<a href=""""),_display_(/*30.19*/url(repository)),format.raw/*30.34*/("""/new/"""),_display_(/*30.40*/encodeRefName(branch)),format.raw/*30.61*/("""/"""),_display_(/*30.63*/pathList/*30.71*/.mkString("/")),format.raw/*30.85*/(""""><img src=""""),_display_(/*30.98*/assets),format.raw/*30.104*/("""/common/images/newfile.png"/></a>
      """)))}),format.raw/*31.8*/("""
    """),format.raw/*32.5*/("""</div>
    <table class="table table-file-list">
      <tr>
        <th colspan="4" style="font-weight: normal;">
          <a href=""""),_display_(/*36.21*/url(repository)),format.raw/*36.36*/("""/commit/"""),_display_(/*36.45*/latestCommit/*36.57*/.id),format.raw/*36.60*/("""" class="commit-message">"""),_display_(/*36.86*/link(latestCommit.summary, repository)),format.raw/*36.124*/("""</a>
          """),_display_(/*37.12*/if(latestCommit.description.isDefined)/*37.50*/{_display_(Seq[Any](format.raw/*37.51*/("""
            """),format.raw/*38.13*/("""<a href="javascript:void(0)" onclick="$('#description-"""),_display_(/*38.68*/latestCommit/*38.80*/.id),format.raw/*38.83*/("""').toggle();" class="omit">...</a>
            <pre id="description-"""),_display_(/*39.35*/latestCommit/*39.47*/.id),format.raw/*39.50*/("""" class="commit-description" style="display: none;">"""),_display_(/*39.103*/link(latestCommit.description.get, repository)),format.raw/*39.149*/("""</pre>
          """)))}),format.raw/*40.12*/("""
        """),format.raw/*41.9*/("""</th>
      </tr>
      <tr>
        <td colspan="4" class="latest-commit">
          <div>
            <div class="pull-right align-right monospace" style="line-height: 18px;">
              <a href=""""),_display_(/*47.25*/url(repository)),format.raw/*47.40*/("""/commit/"""),_display_(/*47.49*/latestCommit/*47.61*/.id),format.raw/*47.64*/("""" class="commit-id"><span class="muted">latest commit</span> """),_display_(/*47.126*/latestCommit/*47.138*/.id.substring(0, 10)),format.raw/*47.158*/("""</a>
            </div>
            <div class="author-info">
              <div class="author">
                """),_display_(/*51.18*/avatar(latestCommit, 20)),format.raw/*51.42*/("""
                """),format.raw/*52.17*/("""<span>"""),_display_(/*52.24*/user(latestCommit.authorName, latestCommit.authorEmailAddress, "username strong")),format.raw/*52.105*/("""</span>
                <span class="muted"> authored """),_display_(/*53.48*/helper/*53.54*/.html.datetimeago(latestCommit.authorTime)),format.raw/*53.96*/("""</span>
              </div>
              """),_display_(/*55.16*/if(latestCommit.isDifferentFromAuthor)/*55.54*/ {_display_(Seq[Any](format.raw/*55.56*/("""
              """),format.raw/*56.15*/("""<div class="committer">
                <span class="icon-arrow-right"></span>
                <span>"""),_display_(/*58.24*/user(latestCommit.committerName, latestCommit.committerEmailAddress, "username strong")),format.raw/*58.111*/("""</span>
                <span class="muted"> committed """),_display_(/*59.49*/helper/*59.55*/.html.datetimeago(latestCommit.commitTime)),format.raw/*59.97*/("""</span>
              </div>
              """)))}),format.raw/*61.16*/("""
            """),format.raw/*62.13*/("""</div>
          </div>
        </td>
      </tr>
      """),_display_(/*66.8*/if(pathList.size > 0)/*66.29*/{_display_(Seq[Any](format.raw/*66.30*/("""
      """),format.raw/*67.7*/("""<tr>
        <td width="16"></td>
        <td><a href=""""),_display_(/*69.23*/url(repository)),_display_(/*69.39*/if(pathList.size > 1)/*69.60*/{_display_(Seq[Any](format.raw/*69.61*/("""/tree/"""),_display_(/*69.68*/encodeRefName(branch)),format.raw/*69.89*/("""/"""),_display_(/*69.91*/pathList/*69.99*/.init.mkString("/"))))}),format.raw/*69.119*/("""">..</a></td>
        <td></td>
        <td></td>
      </tr>
      """)))}),format.raw/*73.8*/("""
      """),_display_(/*74.8*/files/*74.13*/.map/*74.17*/ { file =>_display_(Seq[Any](format.raw/*74.27*/("""
      """),format.raw/*75.7*/("""<tr>
        <td width="16">
        """),_display_(/*77.10*/if(file.isDirectory)/*77.30*/{_display_(Seq[Any](format.raw/*77.31*/("""
          """),_display_(/*78.12*/if(file.linkUrl.isDefined)/*78.38*/{_display_(Seq[Any](format.raw/*78.39*/("""
            """),format.raw/*79.13*/("""<img src=""""),_display_(/*79.24*/assets),format.raw/*79.30*/("""/common/images/folder_link.png"/>
          """)))}/*80.13*/else/*80.18*/{_display_(Seq[Any](format.raw/*80.19*/("""
            """),format.raw/*81.13*/("""<img src=""""),_display_(/*81.24*/assets),format.raw/*81.30*/("""/common/images/folder.png"/>
          """)))}),format.raw/*82.12*/("""
        """)))}/*83.11*/else/*83.16*/{_display_(Seq[Any](format.raw/*83.17*/("""
          """),format.raw/*84.11*/("""<img src=""""),_display_(/*84.22*/assets),format.raw/*84.28*/("""/common/images/file.png"/>
        """)))}),format.raw/*85.10*/("""
        """),format.raw/*86.9*/("""</td>
        <td>
        """),_display_(/*88.10*/if(file.isDirectory)/*88.30*/{_display_(Seq[Any](format.raw/*88.31*/("""
          """),_display_(/*89.12*/if(file.linkUrl.isDefined)/*89.38*/{_display_(Seq[Any](format.raw/*89.39*/("""
            """),format.raw/*90.13*/("""<a href=""""),_display_(/*90.23*/file/*90.27*/.linkUrl),format.raw/*90.35*/("""">
              <span class="simplified-path">"""),_display_(/*91.46*/file/*91.50*/.name.split("/").toList.init/*91.78*/ match/*91.84*/ {/*92.17*/case Nil =>/*92.28*/ {}/*93.17*/case list =>/*93.29*/ {_display_(_display_(/*93.32*/list/*93.36*/.mkString("", "/", "/")))}}),format.raw/*94.16*/("""</span>"""),_display_(/*94.24*/file/*94.28*/.name.split("/").toList.last),format.raw/*94.56*/("""
            """),format.raw/*95.13*/("""</a>
          """)))}/*96.13*/else/*96.18*/{_display_(Seq[Any](format.raw/*96.19*/("""
            """),format.raw/*97.13*/("""<a href=""""),_display_(/*97.23*/url(repository)),format.raw/*97.38*/("""/tree"""),_display_(/*97.44*/{(encodeRefName(branch) :: pathList).mkString("/", "/", "/")}),_display_(/*97.106*/file/*97.110*/.name),format.raw/*97.115*/("""">
              <span class="simplified-path">"""),_display_(/*98.46*/file/*98.50*/.name.split("/").toList.init/*98.78*/ match/*98.84*/ {/*99.17*/case Nil =>/*99.28*/ {}/*100.17*/case list =>/*100.29*/ {_display_(_display_(/*100.32*/list/*100.36*/.mkString("", "/", "/")))}}),format.raw/*101.16*/("""</span>"""),_display_(/*101.24*/file/*101.28*/.name.split("/").toList.last),format.raw/*101.56*/("""
            """),format.raw/*102.13*/("""</a>
          """)))}),format.raw/*103.12*/("""
        """)))}/*104.11*/else/*104.16*/{_display_(Seq[Any](format.raw/*104.17*/("""
          """),format.raw/*105.11*/("""<a href=""""),_display_(/*105.21*/url(repository)),format.raw/*105.36*/("""/blob"""),_display_(/*105.42*/{(encodeRefName(branch) :: pathList).mkString("/", "/", "/")}),_display_(/*105.104*/file/*105.108*/.name),format.raw/*105.113*/("""">"""),_display_(/*105.116*/file/*105.120*/.name),format.raw/*105.125*/("""</a>
        """)))}),format.raw/*106.10*/("""
        """),format.raw/*107.9*/("""</td>
        <td class="mute">
          <a href=""""),_display_(/*109.21*/url(repository)),format.raw/*109.36*/("""/commit/"""),_display_(/*109.45*/file/*109.49*/.commitId),format.raw/*109.58*/("""" class="commit-message">"""),_display_(/*109.84*/link(file.message, repository)),format.raw/*109.114*/("""</a>
          ["""),_display_(/*110.13*/user(file.author, file.mailAddress)),format.raw/*110.48*/("""]
        </td>
        <td style="text-align: right;">"""),_display_(/*112.41*/helper/*112.47*/.html.datetimeago(file.time, false)),format.raw/*112.82*/("""</td>
      </tr>
      """)))}),format.raw/*114.8*/("""
    """),format.raw/*115.5*/("""</table>
    """),_display_(/*116.6*/readme/*116.12*/.map/*116.16*/ { case(filePath, content) =>_display_(Seq[Any](format.raw/*116.45*/("""
      """),format.raw/*117.7*/("""<div id="readme">
        <div class="box-header">"""),_display_(/*118.34*/filePath/*118.42*/.reverse.head),format.raw/*118.55*/("""</div>
        <div class="box-content markdown-body">"""),_display_(/*119.49*/renderMarkup(filePath, content, branch, repository, false, false)),format.raw/*119.114*/("""</div>
      </div>
    """)))}),format.raw/*121.6*/("""
  """)))}),format.raw/*122.4*/("""
""")))}),format.raw/*123.2*/("""
"""))}
  }

  def render(branch:String,repository:service.RepositoryService.RepositoryInfo,pathList:List[String],groupNames:List[String],latestCommit:util.JGitUtil.CommitInfo,files:List[util.JGitUtil.FileInfo],readme:Option[scala.Tuple2[List[String], String]],hasWritePermission:Boolean,info:Option[Any],error:Option[Any],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(branch,repository,pathList,groupNames,latestCommit,files,readme,hasWritePermission,info,error)(context)

  def f:((String,service.RepositoryService.RepositoryInfo,List[String],List[String],util.JGitUtil.CommitInfo,List[util.JGitUtil.FileInfo],Option[scala.Tuple2[List[String], String]],Boolean,Option[Any],Option[Any]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (branch,repository,pathList,groupNames,latestCommit,files,readme,hasWritePermission,info,error) => (context) => apply(branch,repository,pathList,groupNames,latestCommit,files,readme,hasWritePermission,info,error)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/repo/files.scala.html
                  HASH: ee11d34d50f15ab8280df6662490ddd5d16b05b0
                  MATRIX: 551->1|1046->369|1074->412|1086->416|1161->482|1201->484|1231->488|1243->492|1342->582|1381->583|1413->588|1465->614|1480->620|1579->711|1617->712|1654->722|1673->732|1697->747|1742->754|1781->765|1822->779|1858->794|1892->801|1929->817|1959->820|1974->826|2024->854|2054->856|2077->857|2127->876|2165->884|2199->891|2236->901|2272->916|2306->923|2348->944|2378->947|2397->957|2423->962|2463->976|2480->984|2506->1001|2567->1024|2603->1033|2640->1043|2676->1058|2710->1065|2752->1086|2781->1088|2798->1096|2845->1122|2876->1125|2905->1132|2949->1146|2983->1154|3014->1176|3053->1177|3089->1186|3126->1196|3162->1211|3195->1217|3237->1238|3266->1240|3283->1248|3318->1262|3358->1275|3386->1281|3457->1322|3489->1327|3650->1461|3686->1476|3722->1485|3743->1497|3767->1500|3820->1526|3880->1564|3923->1580|3970->1618|4009->1619|4050->1632|4132->1687|4153->1699|4177->1702|4273->1771|4294->1783|4318->1786|4399->1839|4467->1885|4516->1903|4552->1912|4781->2114|4817->2129|4853->2138|4874->2150|4898->2153|4988->2215|5010->2227|5052->2247|5193->2361|5238->2385|5283->2402|5317->2409|5420->2490|5502->2545|5517->2551|5580->2593|5651->2637|5698->2675|5738->2677|5781->2692|5910->2794|6019->2881|6102->2937|6117->2943|6180->2985|6255->3029|6296->3042|6379->3099|6409->3120|6448->3121|6482->3128|6565->3184|6601->3200|6631->3221|6670->3222|6704->3229|6746->3250|6775->3252|6792->3260|6837->3280|6936->3349|6970->3357|6984->3362|6997->3366|7045->3376|7079->3383|7144->3421|7173->3441|7212->3442|7251->3454|7286->3480|7325->3481|7366->3494|7404->3505|7431->3511|7495->3557|7508->3562|7547->3563|7588->3576|7626->3587|7653->3593|7724->3633|7753->3644|7766->3649|7805->3650|7844->3661|7882->3672|7909->3678|7976->3714|8012->3723|8067->3751|8096->3771|8135->3772|8174->3784|8209->3810|8248->3811|8289->3824|8326->3834|8339->3838|8368->3846|8443->3894|8456->3898|8493->3926|8508->3932|8519->3951|8539->3962|8551->3982|8572->3994|8603->3997|8616->4001|8664->4041|8699->4049|8712->4053|8761->4081|8802->4094|8837->4111|8850->4116|8889->4117|8930->4130|8967->4140|9003->4155|9036->4161|9119->4223|9133->4227|9160->4232|9235->4280|9248->4284|9285->4312|9300->4318|9311->4337|9331->4348|9344->4368|9366->4380|9398->4383|9412->4387|9461->4427|9497->4435|9511->4439|9561->4467|9603->4480|9651->4496|9681->4507|9695->4512|9735->4513|9775->4524|9813->4534|9850->4549|9884->4555|9968->4617|9983->4621|10011->4626|10043->4629|10058->4633|10086->4638|10132->4652|10169->4661|10249->4713|10286->4728|10323->4737|10337->4741|10368->4750|10422->4776|10475->4806|10520->4823|10577->4858|10661->4914|10677->4920|10734->4955|10790->4980|10823->4985|10864->4999|10880->5005|10894->5009|10962->5038|10997->5045|11076->5096|11094->5104|11129->5117|11212->5172|11300->5237|11356->5262|11391->5266|11424->5268
                  LINES: 13->1|26->10|27->13|27->13|27->13|27->13|28->14|28->14|28->14|28->14|29->15|30->16|30->16|34->20|34->20|35->21|35->21|35->21|35->21|36->22|36->22|36->22|36->22|36->22|36->22|36->22|36->22|36->22|36->22|37->23|38->24|39->25|39->25|39->25|39->25|39->25|39->25|39->25|39->25|40->26|40->26|40->26|40->26|41->27|41->27|41->27|41->27|41->27|41->27|41->27|41->27|41->27|41->27|42->28|43->29|43->29|43->29|44->30|44->30|44->30|44->30|44->30|44->30|44->30|44->30|44->30|44->30|45->31|46->32|50->36|50->36|50->36|50->36|50->36|50->36|50->36|51->37|51->37|51->37|52->38|52->38|52->38|52->38|53->39|53->39|53->39|53->39|53->39|54->40|55->41|61->47|61->47|61->47|61->47|61->47|61->47|61->47|61->47|65->51|65->51|66->52|66->52|66->52|67->53|67->53|67->53|69->55|69->55|69->55|70->56|72->58|72->58|73->59|73->59|73->59|75->61|76->62|80->66|80->66|80->66|81->67|83->69|83->69|83->69|83->69|83->69|83->69|83->69|83->69|83->69|87->73|88->74|88->74|88->74|88->74|89->75|91->77|91->77|91->77|92->78|92->78|92->78|93->79|93->79|93->79|94->80|94->80|94->80|95->81|95->81|95->81|96->82|97->83|97->83|97->83|98->84|98->84|98->84|99->85|100->86|102->88|102->88|102->88|103->89|103->89|103->89|104->90|104->90|104->90|104->90|105->91|105->91|105->91|105->91|105->92|105->92|105->93|105->93|105->93|105->93|105->94|105->94|105->94|105->94|106->95|107->96|107->96|107->96|108->97|108->97|108->97|108->97|108->97|108->97|108->97|109->98|109->98|109->98|109->98|109->99|109->99|109->100|109->100|109->100|109->100|109->101|109->101|109->101|109->101|110->102|111->103|112->104|112->104|112->104|113->105|113->105|113->105|113->105|113->105|113->105|113->105|113->105|113->105|113->105|114->106|115->107|117->109|117->109|117->109|117->109|117->109|117->109|117->109|118->110|118->110|120->112|120->112|120->112|122->114|123->115|124->116|124->116|124->116|124->116|125->117|126->118|126->118|126->118|127->119|127->119|129->121|130->122|131->123
                  -- GENERATED --
              */
          