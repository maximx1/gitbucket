
package issues.labels.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object label extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[model.Label,Map[String, Int],service.RepositoryService.RepositoryInfo,Boolean,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(label: model.Label,
  counts: Map[String, Int],
  repository: service.RepositoryService.RepositoryInfo,
  hasWritePermission: Boolean)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*4.62*/("""
"""),format.raw/*7.1*/("""<tr id="label-row-"""),_display_(/*7.20*/label/*7.25*/.labelId),format.raw/*7.33*/("""">
  <td style="padding-top: 15px; padding-bottom: 15px;">
    <div class="milestone row-fluid" id="label-"""),_display_(/*9.49*/label/*9.54*/.labelId),format.raw/*9.62*/("""">
      <div class="span8">
        <div style="margin-top: 6px">
          <a href=""""),_display_(/*12.21*/url(repository)),format.raw/*12.36*/("""/issues?labels="""),_display_(/*12.52*/urlEncode(label.labelName)),format.raw/*12.78*/("""" id="label-row-content-"""),_display_(/*12.103*/label/*12.108*/.labelId),format.raw/*12.116*/("""">
            <span style="background-color: #"""),_display_(/*13.46*/label/*13.51*/.color),format.raw/*13.57*/("""; color: #"""),_display_(/*13.68*/label/*13.73*/.fontColor),format.raw/*13.83*/("""; padding: 8px; font-size: 120%; border-radius: 4px;">
              <img src=""""),_display_(/*14.26*/assets),format.raw/*14.32*/("""/common/images/label_"""),_display_(/*14.54*/(if(label.fontColor == "ffffff") "white" else "black")),format.raw/*14.108*/(""".png" style="width: 12px;"/>
              """),_display_(/*15.16*/label/*15.21*/.labelName),format.raw/*15.31*/("""
            """),format.raw/*16.13*/("""</span>
          </a>
        </div>
      </div>
      <div class=""""),_display_(/*20.20*/if(hasWritePermission)/*20.42*/{_display_(Seq[Any](format.raw/*20.43*/("""span2""")))}/*20.50*/else/*20.55*/{_display_(Seq[Any](format.raw/*20.56*/("""span4""")))}),format.raw/*20.62*/("""">
        <div class="pull-right">
          <span class="muted">"""),_display_(/*22.32*/counts/*22.38*/.get(label.labelName).getOrElse(0)),format.raw/*22.72*/(""" """),format.raw/*22.73*/("""open issues</span>
        </div>
      </div>
      """),_display_(/*25.8*/if(hasWritePermission)/*25.30*/{_display_(Seq[Any](format.raw/*25.31*/("""
        """),format.raw/*26.9*/("""<div class="span2">
          <div class="pull-right">
            <a href="javascript:void(0);" onclick="editLabel("""),_display_(/*28.63*/label/*28.68*/.labelId),format.raw/*28.76*/(""")">Edit</a>
            &nbsp;&nbsp;
            <a href="javascript:void(0);" onclick="deleteLabel("""),_display_(/*30.65*/label/*30.70*/.labelId),format.raw/*30.78*/(""")">Delete</a>
          </div>
        </div>
      """)))}),format.raw/*33.8*/("""
    """),format.raw/*34.5*/("""</div>
  </td>
</tr>
"""))}
  }

  def render(label:model.Label,counts:Map[String, Int],repository:service.RepositoryService.RepositoryInfo,hasWritePermission:Boolean,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(label,counts,repository,hasWritePermission)(context)

  def f:((model.Label,Map[String, Int],service.RepositoryService.RepositoryInfo,Boolean) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (label,counts,repository,hasWritePermission) => (context) => apply(label,counts,repository,hasWritePermission)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/issues/labels/label.scala.html
                  HASH: 9d742065f44052cadba97bdd441b10eba278df15
                  MATRIX: 434->1|726->167|753->209|798->228|811->233|839->241|972->348|985->353|1013->361|1127->448|1163->463|1206->479|1253->505|1306->530|1321->535|1351->543|1426->591|1440->596|1467->602|1505->613|1519->618|1550->628|1657->708|1684->714|1733->736|1809->790|1880->834|1894->839|1925->849|1966->862|2063->932|2094->954|2133->955|2158->962|2171->967|2210->968|2247->974|2341->1041|2356->1047|2411->1081|2440->1082|2520->1136|2551->1158|2590->1159|2626->1168|2770->1285|2784->1290|2813->1298|2941->1399|2955->1404|2984->1412|3067->1465|3099->1470
                  LINES: 13->1|20->4|21->7|21->7|21->7|21->7|23->9|23->9|23->9|26->12|26->12|26->12|26->12|26->12|26->12|26->12|27->13|27->13|27->13|27->13|27->13|27->13|28->14|28->14|28->14|28->14|29->15|29->15|29->15|30->16|34->20|34->20|34->20|34->20|34->20|34->20|34->20|36->22|36->22|36->22|36->22|39->25|39->25|39->25|40->26|42->28|42->28|42->28|44->30|44->30|44->30|47->33|48->34
                  -- GENERATED --
              */
          