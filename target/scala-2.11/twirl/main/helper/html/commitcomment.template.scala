
package helper.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object commitcomment extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[model.CommitComment,Boolean,service.RepositoryService.RepositoryInfo,Option[String],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(comment: model.CommitComment,
  hasWritePermission: Boolean,
  repository: service.RepositoryService.RepositoryInfo,
  latestCommitId: Option[String] = None)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*4.72*/("""
"""),format.raw/*7.1*/("""<div class=""""),_display_(/*7.14*/if(comment.fileName.isDefined && (!latestCommitId.isDefined || latestCommitId.get == comment.commitId))/*7.117*/{_display_(Seq[Any](format.raw/*7.118*/("""inline-comment""")))}),format.raw/*7.133*/("""" """),_display_(/*7.136*/if(comment.fileName.isDefined)/*7.166*/{_display_(Seq[Any](format.raw/*7.167*/("""filename="""),_display_(/*7.177*/comment/*7.184*/.fileName.get)))}),format.raw/*7.198*/(""" """),_display_(/*7.200*/if(comment.newLine.isDefined)/*7.229*/{_display_(Seq[Any](format.raw/*7.230*/("""newline="""),_display_(/*7.239*/comment/*7.246*/.newLine.get)))}),format.raw/*7.259*/(""" """),_display_(/*7.261*/if(comment.oldLine.isDefined)/*7.290*/{_display_(Seq[Any](format.raw/*7.291*/("""oldline="""),_display_(/*7.300*/comment/*7.307*/.oldLine.get)))}),format.raw/*7.320*/(""">
  <div class="issue-avatar-image">"""),_display_(/*8.36*/avatar(comment.commentedUserName, 48)),format.raw/*8.73*/("""</div>
  <div class="box commit-comment-box commit-comment-"""),_display_(/*9.54*/comment/*9.61*/.commentId),format.raw/*9.71*/("""">
    <div class="box-header-small">
      """),_display_(/*11.8*/user(comment.commentedUserName, styleClass="username strong")),format.raw/*11.69*/("""
        """),format.raw/*12.9*/("""<span class="muted">
          commented
          """),_display_(/*14.12*/if(comment.pullRequest)/*14.35*/{_display_(Seq[Any](format.raw/*14.36*/("""
            """),format.raw/*15.13*/("""on this Pull Request
          """)))}/*16.12*/else/*16.16*/{_display_(Seq[Any](format.raw/*16.17*/("""
            """),_display_(/*17.14*/if(comment.fileName.isDefined)/*17.44*/{_display_(Seq[Any](format.raw/*17.45*/("""
              """),format.raw/*18.15*/("""on """),_display_(/*18.19*/comment/*18.26*/.fileName.get),format.raw/*18.39*/("""
            """)))}),format.raw/*19.14*/("""
            """),format.raw/*20.13*/("""in <a href=""""),_display_(/*20.26*/path),format.raw/*20.30*/("""/"""),_display_(/*20.32*/repository/*20.42*/.owner),format.raw/*20.48*/("""/"""),_display_(/*20.50*/repository/*20.60*/.name),format.raw/*20.65*/("""/commit/"""),_display_(/*20.74*/comment/*20.81*/.commitId),format.raw/*20.90*/("""">"""),_display_(/*20.93*/comment/*20.100*/.commitId.substring(0, 7)),format.raw/*20.125*/("""</a>
          """)))}),format.raw/*21.12*/("""
          """),_display_(/*22.12*/helper/*22.18*/.html.datetimeago(comment.registeredDate)),format.raw/*22.59*/("""
        """),format.raw/*23.9*/("""</span>
      <span class="pull-right">
        """),_display_(/*25.10*/if(hasWritePermission || loginAccount.map(_.userName == comment.commentedUserName).getOrElse(false))/*25.110*/{_display_(Seq[Any](format.raw/*25.111*/("""
          """),format.raw/*26.11*/("""<a href="#" data-comment-id=""""),_display_(/*26.41*/comment/*26.48*/.commentId),format.raw/*26.58*/(""""><i class="icon-pencil"></i></a>&nbsp;
          <a href="#" data-comment-id=""""),_display_(/*27.41*/comment/*27.48*/.commentId),format.raw/*27.58*/(""""><i class="icon-remove-circle"></i></a>
        """)))}),format.raw/*28.10*/("""
      """),format.raw/*29.7*/("""</span>
    </div>
    <div class="box-content commit-commentContent-"""),_display_(/*31.52*/comment/*31.59*/.commentId),format.raw/*31.69*/("""">
      """),_display_(/*32.8*/markdown(comment.content, repository, false, true, true, hasWritePermission)),format.raw/*32.84*/("""
    """),format.raw/*33.5*/("""</div>
  </div>
</div>
"""))}
  }

  def render(comment:model.CommitComment,hasWritePermission:Boolean,repository:service.RepositoryService.RepositoryInfo,latestCommitId:Option[String],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(comment,hasWritePermission,repository,latestCommitId)(context)

  def f:((model.CommitComment,Boolean,service.RepositoryService.RepositoryInfo,Option[String]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (comment,hasWritePermission,repository,latestCommitId) => (context) => apply(comment,hasWritePermission,repository,latestCommitId)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/commitcomment.scala.html
                  HASH: 754347a96b82be0b037f10c79799a6934d99eeee
                  MATRIX: 441->1|756->190|783->232|822->245|934->348|973->349|1019->364|1049->367|1088->397|1127->398|1164->408|1180->415|1218->429|1247->431|1285->460|1324->461|1360->470|1376->477|1413->490|1442->492|1480->521|1519->522|1555->531|1571->538|1608->551|1671->588|1728->625|1814->685|1829->692|1859->702|1930->747|2012->808|2048->817|2127->869|2159->892|2198->893|2239->906|2290->938|2303->942|2342->943|2383->957|2422->987|2461->988|2504->1003|2535->1007|2551->1014|2585->1027|2630->1041|2671->1054|2711->1067|2736->1071|2765->1073|2784->1083|2811->1089|2840->1091|2859->1101|2885->1106|2921->1115|2937->1122|2967->1131|2997->1134|3014->1141|3061->1166|3108->1182|3147->1194|3162->1200|3224->1241|3260->1250|3336->1299|3446->1399|3486->1400|3525->1411|3582->1441|3598->1448|3629->1458|3736->1538|3752->1545|3783->1555|3864->1605|3898->1612|3995->1682|4011->1689|4042->1699|4078->1709|4175->1785|4207->1790
                  LINES: 13->1|20->4|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|21->7|22->8|22->8|23->9|23->9|23->9|25->11|25->11|26->12|28->14|28->14|28->14|29->15|30->16|30->16|30->16|31->17|31->17|31->17|32->18|32->18|32->18|32->18|33->19|34->20|34->20|34->20|34->20|34->20|34->20|34->20|34->20|34->20|34->20|34->20|34->20|34->20|34->20|34->20|35->21|36->22|36->22|36->22|37->23|39->25|39->25|39->25|40->26|40->26|40->26|40->26|41->27|41->27|41->27|42->28|43->29|45->31|45->31|45->31|46->32|46->32|47->33
                  -- GENERATED --
              */
          