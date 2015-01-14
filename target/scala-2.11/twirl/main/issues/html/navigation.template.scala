
package issues.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object navigation extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,Boolean,service.RepositoryService.RepositoryInfo,Option[service.IssuesService.IssueSearchCondition],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(active: String,
  newButton: Boolean,
  repository: service.RepositoryService.RepositoryInfo,
  condition: Option[service.IssuesService.IssueSearchCondition] = None)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*4.103*/("""
"""),format.raw/*7.1*/("""<ul class="nav nav-pills-group  pull-left fill-width">
  <li class=""""),_display_(/*8.15*/if(active == "issues"    )/*8.41*/{_display_(Seq[Any](format.raw/*8.42*/("""active""")))}),format.raw/*8.49*/(""" """),format.raw/*8.50*/("""first"><a href=""""),_display_(/*8.67*/url(repository)),format.raw/*8.82*/("""/issues">Issues</a></li>
  <li class=""""),_display_(/*9.15*/if(active == "pulls"     )/*9.41*/{_display_(Seq[Any](format.raw/*9.42*/("""active""")))}),format.raw/*9.49*/(""""><a href=""""),_display_(/*9.61*/url(repository)),format.raw/*9.76*/("""/pulls">Pull requests</a></li>
  <li class=""""),_display_(/*10.15*/if(active == "labels"    )/*10.41*/{_display_(Seq[Any](format.raw/*10.42*/("""active""")))}),format.raw/*10.49*/(""""><a href=""""),_display_(/*10.61*/url(repository)),format.raw/*10.76*/("""/issues/labels">Labels</a></li>
  <li class=""""),_display_(/*11.15*/if(active == "milestones")/*11.41*/{_display_(Seq[Any](format.raw/*11.42*/("""active""")))}),format.raw/*11.49*/(""" """),format.raw/*11.50*/("""last"><a href=""""),_display_(/*11.66*/url(repository)),format.raw/*11.81*/("""/issues/milestones">Milestones</a></li>
  <li class="pull-right">
    <form method="GET" id="search-filter-form" style="margin-bottom: 0px;">
      """),_display_(/*14.8*/condition/*14.17*/.map/*14.21*/ { condition =>_display_(Seq[Any](format.raw/*14.36*/("""
        """),_display_(/*15.10*/if(loginAccount.isDefined)/*15.36*/{_display_(Seq[Any](format.raw/*15.37*/("""
          """),format.raw/*16.11*/("""<div class="input-prepend" style="margin-bottom: 0px;">
            <div class="btn-group">
              <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" style="height: 34px;">
                Filter
                <span class="caret"></span>
              </button>
              <ul class="dropdown-menu">
                <li><a href="?q=is:open">Open issues and pull requests</a></li>
                <li><a href="?q=is:open+is:issue+author:"""),_display_(/*24.58*/urlEncode(loginAccount.get.userName)),format.raw/*24.94*/("""">Your issues</a></li>
                <li><a href="?q=is:open+is:pr+author:"""),_display_(/*25.55*/urlEncode(loginAccount.get.userName)),format.raw/*25.91*/("""">Your pull requests</a></li>
                <li><a href="?q=is:open+assignee:"""),_display_(/*26.51*/urlEncode(loginAccount.get.userName)),format.raw/*26.87*/("""">Everything assigned to you</a></li>
                """),format.raw/*29.19*/("""
              """),format.raw/*30.15*/("""</ul>
            </div>
            <input type="text" id="search-filter-box" class="input-xlarge" name="q" style="height: 24px;" value="is:"""),_display_(/*32.118*/{if(active == "issues") "issue" else "pr"}),format.raw/*32.160*/(""" """),_display_(/*32.162*/condition/*32.171*/.toFilterString),format.raw/*32.186*/(""""/>
          </div>
        """)))}/*34.11*/else/*34.16*/{_display_(Seq[Any](format.raw/*34.17*/("""
          """),format.raw/*35.11*/("""<input type="text" id="search-filter-box" class="input-xlarge" name="q" style="height: 24px;" value="is:"""),_display_(/*35.116*/{if(active == "issues") "issue" else "pr"}),format.raw/*35.158*/(""" """),_display_(/*35.160*/condition/*35.169*/.toFilterString),format.raw/*35.184*/(""""/>
        """)))}),format.raw/*36.10*/("""
      """)))}),format.raw/*37.8*/("""
      """),_display_(/*38.8*/if(loginAccount.isDefined)/*38.34*/{_display_(Seq[Any](format.raw/*38.35*/("""
        """),format.raw/*39.9*/("""<div class="btn-group">
          """),_display_(/*40.12*/if(newButton)/*40.25*/{_display_(Seq[Any](format.raw/*40.26*/("""
            """),_display_(/*41.14*/if(active == "issues")/*41.36*/{_display_(Seq[Any](format.raw/*41.37*/("""
              """),format.raw/*42.15*/("""<a class="btn btn-success" href=""""),_display_(/*42.49*/url(repository)),format.raw/*42.64*/("""/issues/new" style="height: 24px;">New issue</a>
            """)))}),format.raw/*43.14*/("""
            """),_display_(/*44.14*/if(active == "pulls")/*44.35*/{_display_(Seq[Any](format.raw/*44.36*/("""
              """),format.raw/*45.15*/("""<a class="btn btn-success" href=""""),_display_(/*45.49*/url(repository)),format.raw/*45.64*/("""/compare" style="height: 24px;">New pull request</a>
            """)))}),format.raw/*46.14*/("""
            """),_display_(/*47.14*/if(active == "labels")/*47.36*/{_display_(Seq[Any](format.raw/*47.37*/("""
              """),format.raw/*48.15*/("""<a class="btn btn-success" href="javascript:void(0);" id="new-label-button" style="height: 24px;">New label</a>
            """)))}),format.raw/*49.14*/("""
            """),_display_(/*50.14*/if(active == "milestones")/*50.40*/{_display_(Seq[Any](format.raw/*50.41*/("""
              """),format.raw/*51.15*/("""<a class="btn btn-success" href=""""),_display_(/*51.49*/url(repository)),format.raw/*51.64*/("""/issues/milestones/new" style="height: 24px;">New milestone</a>
            """)))}),format.raw/*52.14*/("""
          """)))}),format.raw/*53.12*/("""
        """),format.raw/*54.9*/("""</div>
      """)))}),format.raw/*55.8*/("""
    """),format.raw/*56.5*/("""</form>
  </li>
</ul>
"""))}
  }

  def render(active:String,newButton:Boolean,repository:service.RepositoryService.RepositoryInfo,condition:Option[service.IssuesService.IssueSearchCondition],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(active,newButton,repository,condition)(context)

  def f:((String,Boolean,service.RepositoryService.RepositoryInfo,Option[service.IssuesService.IssueSearchCondition]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (active,newButton,repository,condition) => (context) => apply(active,newButton,repository,condition)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/issues/navigation.scala.html
                  HASH: 068e7066f0577b771850758dbfd0ea8cfb64b269
                  MATRIX: 461->1|785->198|812->240|907->309|941->335|979->336|1016->343|1044->344|1087->361|1122->376|1187->415|1221->441|1259->442|1296->449|1334->461|1369->476|1441->521|1476->547|1515->548|1553->555|1592->567|1628->582|1701->628|1736->654|1775->655|1813->662|1842->663|1885->679|1921->694|2096->843|2114->852|2127->856|2180->871|2217->881|2252->907|2291->908|2330->919|2828->1390|2885->1426|2989->1503|3046->1539|3153->1619|3210->1655|3292->1853|3335->1868|3505->2010|3569->2052|3599->2054|3618->2063|3655->2078|3704->2109|3717->2114|3756->2115|3795->2126|3928->2231|3992->2273|4022->2275|4041->2284|4078->2299|4122->2312|4160->2320|4194->2328|4229->2354|4268->2355|4304->2364|4366->2399|4388->2412|4427->2413|4468->2427|4499->2449|4538->2450|4581->2465|4642->2499|4678->2514|4771->2576|4812->2590|4842->2611|4881->2612|4924->2627|4985->2661|5021->2676|5118->2742|5159->2756|5190->2778|5229->2779|5272->2794|5428->2919|5469->2933|5504->2959|5543->2960|5586->2975|5647->3009|5683->3024|5791->3101|5834->3113|5870->3122|5914->3136|5946->3141
                  LINES: 13->1|20->4|21->7|22->8|22->8|22->8|22->8|22->8|22->8|22->8|23->9|23->9|23->9|23->9|23->9|23->9|24->10|24->10|24->10|24->10|24->10|24->10|25->11|25->11|25->11|25->11|25->11|25->11|25->11|28->14|28->14|28->14|28->14|29->15|29->15|29->15|30->16|38->24|38->24|39->25|39->25|40->26|40->26|41->29|42->30|44->32|44->32|44->32|44->32|44->32|46->34|46->34|46->34|47->35|47->35|47->35|47->35|47->35|47->35|48->36|49->37|50->38|50->38|50->38|51->39|52->40|52->40|52->40|53->41|53->41|53->41|54->42|54->42|54->42|55->43|56->44|56->44|56->44|57->45|57->45|57->45|58->46|59->47|59->47|59->47|60->48|61->49|62->50|62->50|62->50|63->51|63->51|63->51|64->52|65->53|66->54|67->55|68->56
                  -- GENERATED --
              */
          