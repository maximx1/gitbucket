
package repo.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object commits extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template8[List[String],String,service.RepositoryService.RepositoryInfo,Seq[Seq[util.JGitUtil.CommitInfo]],Int,Boolean,Boolean,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(pathList: List[String],
  branch: String,
  repository: service.RepositoryService.RepositoryInfo,
  commits: Seq[Seq[util.JGitUtil.CommitInfo]],
  page: Int,
  hasNext: Boolean,
  hasWritePermission: Boolean)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*7.62*/("""
"""),_display_(/*10.2*/html/*10.6*/.main(s"${repository.owner}/${repository.name}", Some(repository))/*10.72*/ {_display_(Seq[Any](format.raw/*10.74*/("""
  """),_display_(/*11.4*/html/*11.8*/.menu("code", repository)/*11.33*/{_display_(Seq[Any](format.raw/*11.34*/("""
    """),format.raw/*12.5*/("""<div class="head">
      """),_display_(/*13.8*/helper/*13.14*/.html.branchcontrol(
        branch,
        repository,
        hasWritePermission
      )/*17.8*/{_display_(Seq[Any](format.raw/*17.9*/("""
        """),_display_(/*18.10*/repository/*18.20*/.branchList.map/*18.35*/ { x =>_display_(Seq[Any](format.raw/*18.42*/("""
          """),format.raw/*19.11*/("""<li><a href=""""),_display_(/*19.25*/url(repository)),format.raw/*19.40*/("""/commits/"""),_display_(/*19.50*/encodeRefName(x)),format.raw/*19.66*/("""">"""),_display_(/*19.69*/helper/*19.75*/.html.checkicon(x == branch)),format.raw/*19.103*/(""" """),_display_(/*19.105*/x),format.raw/*19.106*/("""</a></li>
        """)))}),format.raw/*20.10*/("""
      """)))}),format.raw/*21.8*/("""
      """),_display_(/*22.8*/if(pathList.isEmpty)/*22.28*/{_display_(Seq[Any](format.raw/*22.29*/("""
        """),format.raw/*23.9*/("""<a href=""""),_display_(/*23.19*/url(repository)),format.raw/*23.34*/("""/tree/"""),_display_(/*23.41*/encodeRefName(branch)),format.raw/*23.62*/("""">"""),_display_(/*23.65*/repository/*23.75*/.name),format.raw/*23.80*/("""</a> / Commit History
      """)))}),format.raw/*24.8*/("""
      """),_display_(/*25.8*/if(pathList.nonEmpty)/*25.29*/{_display_(Seq[Any](format.raw/*25.30*/("""
        """),format.raw/*26.9*/("""<span class="muted">History for</span>
        <a href=""""),_display_(/*27.19*/url(repository)),format.raw/*27.34*/("""/tree/"""),_display_(/*27.41*/encodeRefName(branch)),format.raw/*27.62*/("""">"""),_display_(/*27.65*/repository/*27.75*/.name),format.raw/*27.80*/("""</a> /
        """),_display_(/*28.10*/pathList/*28.18*/.zipWithIndex.map/*28.35*/ { case (section, i) =>_display_(Seq[Any](format.raw/*28.58*/("""
          """),_display_(/*29.12*/if(i == pathList.length - 1)/*29.40*/{_display_(Seq[Any](format.raw/*29.41*/("""
            """),_display_(/*30.14*/section),format.raw/*30.21*/("""
          """)))}/*31.13*/else/*31.18*/{_display_(Seq[Any](format.raw/*31.19*/("""
            """),format.raw/*32.13*/("""<a href=""""),_display_(/*32.23*/url(repository)),format.raw/*32.38*/("""/tree/"""),_display_(/*32.45*/encodeRefName(branch)),format.raw/*32.66*/("""/"""),_display_(/*32.68*/pathList/*32.76*/.take(i + 1).mkString("/")),format.raw/*32.102*/("""">"""),_display_(/*32.105*/section),format.raw/*32.112*/("""</a> /
          """)))}),format.raw/*33.12*/("""
        """)))}),format.raw/*34.10*/("""
      """)))}),format.raw/*35.8*/("""
    """),format.raw/*36.5*/("""</div>
    """),_display_(/*37.6*/commits/*37.13*/.map/*37.17*/ { day =>_display_(Seq[Any](format.raw/*37.26*/("""
      """),format.raw/*38.7*/("""<table class="table table-bordered">
        <tr>
          <th>"""),_display_(/*40.16*/date(day.head.commitTime)),format.raw/*40.41*/("""</th>
        </tr>
        """),_display_(/*42.10*/day/*42.13*/.map/*42.17*/ { commit =>_display_(Seq[Any](format.raw/*42.29*/("""
        """),format.raw/*43.9*/("""<tr>
          <td>
            <div class="pull-right align-right">
              <a href=""""),_display_(/*46.25*/url(repository)),format.raw/*46.40*/("""/commit/"""),_display_(/*46.49*/commit/*46.55*/.id),format.raw/*46.58*/("""" class="btn btn-small monospace">"""),_display_(/*46.93*/commit/*46.99*/.id.substring(0, 10)),format.raw/*46.119*/("""</a><br>
              <a href=""""),_display_(/*47.25*/url(repository)),format.raw/*47.40*/("""/tree/"""),_display_(/*47.47*/commit/*47.53*/.id),format.raw/*47.56*/("""" class="small">Browse code</a>
            </div>
            <div>
              <div class="commit-avatar-image">"""),_display_(/*50.49*/avatar(commit, 40)),format.raw/*50.67*/("""</div>
              <div class="commit-message-box">
                <a href=""""),_display_(/*52.27*/url(repository)),format.raw/*52.42*/("""/commit/"""),_display_(/*52.51*/commit/*52.57*/.id),format.raw/*52.60*/("""" class="commit-message" style="font-weight: bold;">"""),_display_(/*52.113*/link(commit.summary, repository)),format.raw/*52.145*/("""</a>
                """),_display_(/*53.18*/if(commit.description.isDefined)/*53.50*/{_display_(Seq[Any](format.raw/*53.51*/("""
                  """),format.raw/*54.19*/("""<a href="javascript:void(0)" onclick="$('#description-"""),_display_(/*54.74*/commit/*54.80*/.id),format.raw/*54.83*/("""').toggle();" class="omit">...</a>
                """)))}),format.raw/*55.18*/("""
                """),format.raw/*56.17*/("""<br>
                """),_display_(/*57.18*/if(commit.description.isDefined)/*57.50*/{_display_(Seq[Any](format.raw/*57.51*/("""
                  """),format.raw/*58.19*/("""<pre id="description-"""),_display_(/*58.41*/commit/*58.47*/.id),format.raw/*58.50*/("""" style="display: none;" class="commit-description">"""),_display_(/*58.103*/link(commit.description.get, repository)),format.raw/*58.143*/("""</pre>
                """)))}),format.raw/*59.18*/("""
                """),format.raw/*60.17*/("""<div class="small">
                  """),_display_(/*61.20*/user(commit.authorName, commit.authorEmailAddress, "username")),format.raw/*61.82*/("""
                  """),format.raw/*62.19*/("""<span class="muted">authored """),_display_(/*62.49*/helper/*62.55*/.html.datetimeago(commit.authorTime)),format.raw/*62.91*/("""</span>
                  """),_display_(/*63.20*/if(commit.isDifferentFromAuthor)/*63.52*/ {_display_(Seq[Any](format.raw/*63.54*/("""
                    """),format.raw/*64.21*/("""<span class="icon-arrow-right" style="margin-top : -2px ;"></span>
                    """),_display_(/*65.22*/user(commit.committerName, commit.committerEmailAddress, "username")),format.raw/*65.90*/("""
                    """),format.raw/*66.21*/("""<span class="muted">committed """),_display_(/*66.52*/helper/*66.58*/.html.datetimeago(commit.authorTime)),format.raw/*66.94*/("""</span>
                  """)))}),format.raw/*67.20*/("""
                """),format.raw/*68.17*/("""</div>
              </div>
            </div>
          </td>
        </tr>
        """)))}),format.raw/*73.10*/("""
      """),format.raw/*74.7*/("""</table>
    """)))}),format.raw/*75.6*/("""
    """),format.raw/*76.5*/("""<div class="btn-group">
      <button class="btn" onclick="location.href='?page="""),_display_(/*77.58*/{page - 1}),format.raw/*77.68*/("""'""""),_display_(/*77.71*/if(page <= 1)/*77.84*/{_display_(Seq[Any](format.raw/*77.85*/(""" """),format.raw/*77.86*/("""disabled="true"""")))}),format.raw/*77.102*/(""">&lt; Newer</button>
      <button class="btn" onclick="location.href='?page="""),_display_(/*78.58*/{page + 1}),format.raw/*78.68*/("""'""""),_display_(/*78.71*/if(!hasNext)/*78.83*/{_display_(Seq[Any](format.raw/*78.84*/(""" """),format.raw/*78.85*/("""disabled="true"""")))}),format.raw/*78.101*/(""">Older &gt;</button>
    </div>
  """)))}),format.raw/*80.4*/("""
""")))}),format.raw/*81.2*/("""
"""))}
  }

  def render(pathList:List[String],branch:String,repository:service.RepositoryService.RepositoryInfo,commits:Seq[Seq[util.JGitUtil.CommitInfo]],page:Int,hasNext:Boolean,hasWritePermission:Boolean,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(pathList,branch,repository,commits,page,hasNext,hasWritePermission)(context)

  def f:((List[String],String,service.RepositoryService.RepositoryInfo,Seq[Seq[util.JGitUtil.CommitInfo]],Int,Boolean,Boolean) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (pathList,branch,repository,commits,page,hasNext,hasWritePermission) => (context) => apply(pathList,branch,repository,commits,page,hasNext,hasWritePermission)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/repo/commits.scala.html
                  HASH: 9ae873c6ca54b528cc577d0a5772768bae99a1b1
                  MATRIX: 465->1|831->241|859->284|871->288|946->354|986->356|1016->360|1028->364|1062->389|1101->390|1133->395|1185->421|1200->427|1299->518|1337->519|1374->529|1393->539|1417->554|1462->561|1501->572|1542->586|1578->601|1615->611|1652->627|1682->630|1697->636|1747->664|1777->666|1800->667|1850->686|1888->694|1922->702|1951->722|1990->723|2026->732|2063->742|2099->757|2133->764|2175->785|2205->788|2224->798|2250->803|2309->832|2343->840|2373->861|2412->862|2448->871|2532->928|2568->943|2602->950|2644->971|2674->974|2693->984|2719->989|2762->1005|2779->1013|2805->1030|2866->1053|2905->1065|2942->1093|2981->1094|3022->1108|3050->1115|3081->1128|3094->1133|3133->1134|3174->1147|3211->1157|3247->1172|3281->1179|3323->1200|3352->1202|3369->1210|3417->1236|3448->1239|3477->1246|3526->1264|3567->1274|3605->1282|3637->1287|3675->1299|3691->1306|3704->1310|3751->1319|3785->1326|3877->1391|3923->1416|3979->1445|3991->1448|4004->1452|4054->1464|4090->1473|4210->1566|4246->1581|4282->1590|4297->1596|4321->1599|4383->1634|4398->1640|4440->1660|4500->1693|4536->1708|4570->1715|4585->1721|4609->1724|4753->1841|4792->1859|4899->1939|4935->1954|4971->1963|4986->1969|5010->1972|5091->2025|5145->2057|5194->2079|5235->2111|5274->2112|5321->2131|5403->2186|5418->2192|5442->2195|5525->2247|5570->2264|5619->2286|5660->2318|5699->2319|5746->2338|5795->2360|5810->2366|5834->2369|5915->2422|5977->2462|6032->2486|6077->2503|6143->2542|6226->2604|6273->2623|6330->2653|6345->2659|6402->2695|6456->2722|6497->2754|6537->2756|6586->2777|6701->2865|6790->2933|6839->2954|6897->2985|6912->2991|6969->3027|7027->3054|7072->3071|7189->3157|7223->3164|7267->3178|7299->3183|7407->3264|7438->3274|7468->3277|7490->3290|7529->3291|7558->3292|7606->3308|7711->3386|7742->3396|7772->3399|7793->3411|7832->3412|7861->3413|7909->3429|7974->3464|8006->3466
                  LINES: 13->1|23->7|24->10|24->10|24->10|24->10|25->11|25->11|25->11|25->11|26->12|27->13|27->13|31->17|31->17|32->18|32->18|32->18|32->18|33->19|33->19|33->19|33->19|33->19|33->19|33->19|33->19|33->19|33->19|34->20|35->21|36->22|36->22|36->22|37->23|37->23|37->23|37->23|37->23|37->23|37->23|37->23|38->24|39->25|39->25|39->25|40->26|41->27|41->27|41->27|41->27|41->27|41->27|41->27|42->28|42->28|42->28|42->28|43->29|43->29|43->29|44->30|44->30|45->31|45->31|45->31|46->32|46->32|46->32|46->32|46->32|46->32|46->32|46->32|46->32|46->32|47->33|48->34|49->35|50->36|51->37|51->37|51->37|51->37|52->38|54->40|54->40|56->42|56->42|56->42|56->42|57->43|60->46|60->46|60->46|60->46|60->46|60->46|60->46|60->46|61->47|61->47|61->47|61->47|61->47|64->50|64->50|66->52|66->52|66->52|66->52|66->52|66->52|66->52|67->53|67->53|67->53|68->54|68->54|68->54|68->54|69->55|70->56|71->57|71->57|71->57|72->58|72->58|72->58|72->58|72->58|72->58|73->59|74->60|75->61|75->61|76->62|76->62|76->62|76->62|77->63|77->63|77->63|78->64|79->65|79->65|80->66|80->66|80->66|80->66|81->67|82->68|87->73|88->74|89->75|90->76|91->77|91->77|91->77|91->77|91->77|91->77|91->77|92->78|92->78|92->78|92->78|92->78|92->78|92->78|94->80|95->81
                  -- GENERATED --
              */
          