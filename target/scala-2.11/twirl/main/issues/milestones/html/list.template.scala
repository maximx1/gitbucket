
package issues.milestones.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object list extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,List[scala.Tuple3[model.Milestone, Int, Int]],service.RepositoryService.RepositoryInfo,Boolean,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(state: String,
  milestones: List[(model.Milestone, Int, Int)],
  repository: service.RepositoryService.RepositoryInfo,
  hasWritePermission: Boolean)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*4.62*/("""
"""),_display_(/*7.2*/html/*7.6*/.main(s"Milestones - ${repository.owner}/${repository.name}")/*7.67*/{_display_(Seq[Any](format.raw/*7.68*/("""
  """),_display_(/*8.4*/html/*8.8*/.menu("issues", repository)/*8.35*/{_display_(Seq[Any](format.raw/*8.36*/("""
    """),_display_(/*9.6*/issues/*9.12*/.html.navigation("milestones", hasWritePermission, repository)),format.raw/*9.74*/("""
    """),format.raw/*10.5*/("""<br>
    <table class="table table-bordered table-hover table-issues">
      <tr>
        <th style="background-color: #eee;">
          <span class="small">
            <a class="button-link"""),_display_(/*15.35*/if(state == "open")/*15.54*/{_display_(Seq[Any](format.raw/*15.55*/(""" """),format.raw/*15.56*/("""selected""")))}),format.raw/*15.65*/("""" href="?state=open">
              <img src=""""),_display_(/*16.26*/assets),format.raw/*16.32*/("""/common/images/milestone"""),_display_(/*16.57*/(if(state == "open"){"-active"})),format.raw/*16.89*/(""".png"/>
              """),_display_(/*17.16*/milestones/*17.26*/.count(_._1.closedDate.isEmpty)),format.raw/*17.57*/(""" """),format.raw/*17.58*/("""Open
            </a>&nbsp;&nbsp;
            <a class="button-link"""),_display_(/*19.35*/if(state == "closed")/*19.56*/{_display_(Seq[Any](format.raw/*19.57*/(""" """),format.raw/*19.58*/("""selected""")))}),format.raw/*19.67*/("""" href="?state=closed">
              <img src=""""),_display_(/*20.26*/assets),format.raw/*20.32*/("""/common/images/milestone"""),_display_(/*20.57*/(if(state == "closed"){"-active"})),format.raw/*20.91*/(""".png"/>
              """),_display_(/*21.16*/milestones/*21.26*/.count(_._1.closedDate.isDefined)),format.raw/*21.59*/(""" """),format.raw/*21.60*/("""Closed
            </a>
          </span>
        </th>
      </tr>
      """),_display_(/*26.8*/defining(milestones.filter { case (milestone, _, _) =>
        milestone.closedDate.map(_ => state == "closed").getOrElse(state == "open")
      })/*28.9*/{ milestones =>_display_(Seq[Any](format.raw/*28.24*/("""
        """),_display_(/*29.10*/milestones/*29.20*/.map/*29.24*/ { case (milestone, openCount, closedCount) =>_display_(Seq[Any](format.raw/*29.70*/("""
        """),format.raw/*30.9*/("""<tr>
          <td style="padding-top: 15px; padding-bottom: 15px;">
            <div class="milestone row-fluid">
              <div class="span4">
                <a href=""""),_display_(/*34.27*/url(repository)),format.raw/*34.42*/("""/issues?milestone="""),_display_(/*34.61*/milestone/*34.70*/.milestoneId),format.raw/*34.82*/("""&state=open" class="milestone-title">"""),_display_(/*34.120*/milestone/*34.129*/.title),format.raw/*34.135*/("""</a>
                <div style="margin-top: 6px">
                  """),_display_(/*36.20*/if(milestone.closedDate.isDefined)/*36.54*/{_display_(Seq[Any](format.raw/*36.55*/("""
                    """),format.raw/*37.21*/("""<span class="muted">Closed """),_display_(/*37.49*/helper/*37.55*/.html.datetimeago(milestone.closedDate.get)),format.raw/*37.98*/("""</span>
                  """)))}/*38.21*/else/*38.26*/{_display_(Seq[Any](format.raw/*38.27*/("""
                    """),_display_(/*39.22*/milestone/*39.31*/.dueDate.map/*39.43*/ { dueDate =>_display_(Seq[Any](format.raw/*39.56*/("""
                      """),_display_(/*40.24*/if(isPast(dueDate))/*40.43*/{_display_(Seq[Any](format.raw/*40.44*/("""
                        """),format.raw/*41.25*/("""<img src=""""),_display_(/*41.36*/assets),format.raw/*41.42*/("""/common/images/alert.png"/><span class="muted milestone-alert">Due by """),_display_(/*41.113*/date(dueDate)),format.raw/*41.126*/("""</span>
                      """)))}/*42.25*/else/*42.30*/{_display_(Seq[Any](format.raw/*42.31*/("""
                        """),format.raw/*43.25*/("""<span class="muted">Due by """),_display_(/*43.53*/date(dueDate)),format.raw/*43.66*/("""</span>
                      """)))}),format.raw/*44.24*/("""
                    """)))}/*45.22*/.getOrElse/*45.32*/ {_display_(Seq[Any](format.raw/*45.34*/("""
                      """),format.raw/*46.23*/("""<span class="muted">No due date</span>
                    """)))}),format.raw/*47.22*/("""
                  """)))}),format.raw/*48.20*/("""
                """),format.raw/*49.17*/("""</div>
              </div>
              <div class="span8">
                """),_display_(/*52.18*/progress(openCount + closedCount, closedCount)),format.raw/*52.64*/("""
                """),format.raw/*53.17*/("""<div>
                  <div>
                    """),_display_(/*55.22*/if(closedCount == 0)/*55.42*/{_display_(Seq[Any](format.raw/*55.43*/("""
                      """),format.raw/*56.23*/("""0%
                    """)))}/*57.23*/else/*57.28*/{_display_(Seq[Any](format.raw/*57.29*/("""
                      """),_display_(/*58.24*/((closedCount.toDouble / (openCount + closedCount).toDouble * 100).toInt)),format.raw/*58.97*/("""%
                    """)))}),format.raw/*59.22*/(""" """),format.raw/*59.23*/("""<span class="muted">complete</span> &nbsp;&nbsp;
                    """),_display_(/*60.22*/openCount),format.raw/*60.31*/(""" """),format.raw/*60.32*/("""<span class="muted">open</span> &nbsp;&nbsp;
                    """),_display_(/*61.22*/closedCount),format.raw/*61.33*/(""" """),format.raw/*61.34*/("""<span class="muted">closed</span>
                  </div>
                  <div class="milestone-menu">
                    """),_display_(/*64.22*/if(hasWritePermission)/*64.44*/{_display_(Seq[Any](format.raw/*64.45*/("""
                      """),format.raw/*65.23*/("""<a href=""""),_display_(/*65.33*/url(repository)),format.raw/*65.48*/("""/issues/milestones/"""),_display_(/*65.68*/milestone/*65.77*/.milestoneId),format.raw/*65.89*/("""/edit">Edit</a> &nbsp;&nbsp;
                      """),_display_(/*66.24*/if(milestone.closedDate.isDefined)/*66.58*/{_display_(Seq[Any](format.raw/*66.59*/("""
                        """),format.raw/*67.25*/("""<a href=""""),_display_(/*67.35*/url(repository)),format.raw/*67.50*/("""/issues/milestones/"""),_display_(/*67.70*/milestone/*67.79*/.milestoneId),format.raw/*67.91*/("""/open">Open</a> &nbsp;&nbsp;
                      """)))}/*68.25*/else/*68.30*/{_display_(Seq[Any](format.raw/*68.31*/("""
                        """),format.raw/*69.25*/("""<a href=""""),_display_(/*69.35*/url(repository)),format.raw/*69.50*/("""/issues/milestones/"""),_display_(/*69.70*/milestone/*69.79*/.milestoneId),format.raw/*69.91*/("""/close">Close</a> &nbsp;&nbsp;
                      """)))}),format.raw/*70.24*/("""
                      """),format.raw/*71.23*/("""<a href=""""),_display_(/*71.33*/url(repository)),format.raw/*71.48*/("""/issues/milestones/"""),_display_(/*71.68*/milestone/*71.77*/.milestoneId),format.raw/*71.89*/("""/delete" class="delete">Delete</a>
                    """)))}),format.raw/*72.22*/("""
                  """),format.raw/*73.19*/("""</div>
                </div>
              </div>
            </div>
            """),_display_(/*77.14*/if(milestone.description.isDefined)/*77.49*/{_display_(Seq[Any](format.raw/*77.50*/("""
              """),format.raw/*78.15*/("""<div class="milestone-description">
                """),_display_(/*79.18*/markdown(milestone.description.get, repository, false, false)),format.raw/*79.79*/("""
              """),format.raw/*80.15*/("""</div>
            """)))}),format.raw/*81.14*/("""
          """),format.raw/*82.11*/("""</td>
        </tr>
        """)))}),format.raw/*84.10*/("""
        """),_display_(/*85.10*/if(milestones.isEmpty)/*85.32*/{_display_(Seq[Any](format.raw/*85.33*/("""
        """),format.raw/*86.9*/("""<tr>
          <td style="padding: 20px; background-color: #eee; text-align: center;">
            No milestones to show.
            """),_display_(/*89.14*/if(hasWritePermission)/*89.36*/{_display_(Seq[Any](format.raw/*89.37*/("""
              """),format.raw/*90.15*/("""<a href=""""),_display_(/*90.25*/url(repository)),format.raw/*90.40*/("""/issues/milestones/new">Create a new milestone.</a>
            """)))}),format.raw/*91.14*/("""
          """),format.raw/*92.11*/("""</td>
        </tr>
        """)))}),format.raw/*94.10*/("""
      """)))}),format.raw/*95.8*/("""
    """),format.raw/*96.5*/("""</table>
  """)))}),format.raw/*97.4*/("""
""")))}),format.raw/*98.2*/("""
"""),format.raw/*99.1*/("""<script>
$(function()"""),format.raw/*100.13*/("""{"""),format.raw/*100.14*/("""
  """),format.raw/*101.3*/("""$('a.delete').click(function()"""),format.raw/*101.33*/("""{"""),format.raw/*101.34*/("""
    """),format.raw/*102.5*/("""return confirm('Once you delete this milestone, there is no going back.\nAre you sure?');
  """),format.raw/*103.3*/("""}"""),format.raw/*103.4*/(""");
"""),format.raw/*104.1*/("""}"""),format.raw/*104.2*/(""");
</script>
"""))}
  }

  def render(state:String,milestones:List[scala.Tuple3[model.Milestone, Int, Int]],repository:service.RepositoryService.RepositoryInfo,hasWritePermission:Boolean,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(state,milestones,repository,hasWritePermission)(context)

  def f:((String,List[scala.Tuple3[model.Milestone, Int, Int]],service.RepositoryService.RepositoryInfo,Boolean) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (state,milestones,repository,hasWritePermission) => (context) => apply(state,milestones,repository,hasWritePermission)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/issues/milestones/list.scala.html
                  HASH: 80dd472e7b9552026fda9bdb2000db58d555304d
                  MATRIX: 461->1|769->183|796->226|807->230|876->291|914->292|943->296|954->300|989->327|1027->328|1058->334|1072->340|1154->402|1186->407|1405->599|1433->618|1472->619|1501->620|1541->629|1615->676|1642->682|1694->707|1747->739|1797->762|1816->772|1868->803|1897->804|1992->872|2022->893|2061->894|2090->895|2130->904|2206->953|2233->959|2285->984|2340->1018|2390->1041|2409->1051|2463->1084|2492->1085|2593->1160|2748->1307|2801->1322|2838->1332|2857->1342|2870->1346|2954->1392|2990->1401|3192->1576|3228->1591|3274->1610|3292->1619|3325->1631|3391->1669|3410->1678|3438->1684|3535->1754|3578->1788|3617->1789|3666->1810|3721->1838|3736->1844|3800->1887|3846->1915|3859->1920|3898->1921|3947->1943|3965->1952|3986->1964|4037->1977|4088->2001|4116->2020|4155->2021|4208->2046|4246->2057|4273->2063|4372->2134|4407->2147|4457->2179|4470->2184|4509->2185|4562->2210|4617->2238|4651->2251|4713->2282|4754->2304|4773->2314|4813->2316|4864->2339|4955->2399|5006->2419|5051->2436|5157->2515|5224->2561|5269->2578|5347->2629|5376->2649|5415->2650|5466->2673|5509->2698|5522->2703|5561->2704|5612->2728|5706->2801|5760->2824|5789->2825|5886->2895|5916->2904|5945->2905|6038->2971|6070->2982|6099->2983|6253->3110|6284->3132|6323->3133|6374->3156|6411->3166|6447->3181|6494->3201|6512->3210|6545->3222|6624->3274|6667->3308|6706->3309|6759->3334|6796->3344|6832->3359|6879->3379|6897->3388|6930->3400|7001->3453|7014->3458|7053->3459|7106->3484|7143->3494|7179->3509|7226->3529|7244->3538|7277->3550|7362->3604|7413->3627|7450->3637|7486->3652|7533->3672|7551->3681|7584->3693|7671->3749|7718->3768|7828->3851|7872->3886|7911->3887|7954->3902|8034->3955|8116->4016|8159->4031|8210->4051|8249->4062|8309->4091|8346->4101|8377->4123|8416->4124|8452->4133|8614->4268|8645->4290|8684->4291|8727->4306|8764->4316|8800->4331|8896->4396|8935->4407|8995->4436|9033->4444|9065->4449|9107->4461|9139->4463|9167->4464|9217->4485|9247->4486|9278->4489|9337->4519|9367->4520|9400->4525|9520->4617|9549->4618|9580->4621|9609->4622
                  LINES: 13->1|20->4|21->7|21->7|21->7|21->7|22->8|22->8|22->8|22->8|23->9|23->9|23->9|24->10|29->15|29->15|29->15|29->15|29->15|30->16|30->16|30->16|30->16|31->17|31->17|31->17|31->17|33->19|33->19|33->19|33->19|33->19|34->20|34->20|34->20|34->20|35->21|35->21|35->21|35->21|40->26|42->28|42->28|43->29|43->29|43->29|43->29|44->30|48->34|48->34|48->34|48->34|48->34|48->34|48->34|48->34|50->36|50->36|50->36|51->37|51->37|51->37|51->37|52->38|52->38|52->38|53->39|53->39|53->39|53->39|54->40|54->40|54->40|55->41|55->41|55->41|55->41|55->41|56->42|56->42|56->42|57->43|57->43|57->43|58->44|59->45|59->45|59->45|60->46|61->47|62->48|63->49|66->52|66->52|67->53|69->55|69->55|69->55|70->56|71->57|71->57|71->57|72->58|72->58|73->59|73->59|74->60|74->60|74->60|75->61|75->61|75->61|78->64|78->64|78->64|79->65|79->65|79->65|79->65|79->65|79->65|80->66|80->66|80->66|81->67|81->67|81->67|81->67|81->67|81->67|82->68|82->68|82->68|83->69|83->69|83->69|83->69|83->69|83->69|84->70|85->71|85->71|85->71|85->71|85->71|85->71|86->72|87->73|91->77|91->77|91->77|92->78|93->79|93->79|94->80|95->81|96->82|98->84|99->85|99->85|99->85|100->86|103->89|103->89|103->89|104->90|104->90|104->90|105->91|106->92|108->94|109->95|110->96|111->97|112->98|113->99|114->100|114->100|115->101|115->101|115->101|116->102|117->103|117->103|118->104|118->104
                  -- GENERATED --
              */
          