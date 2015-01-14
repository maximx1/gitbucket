
package account.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object members extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[model.Account,List[String],Boolean,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: model.Account, members: List[String], isGroupManager: Boolean)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*1.105*/("""
"""),_display_(/*4.2*/main(account, Nil, "members", isGroupManager)/*4.47*/{_display_(Seq[Any](format.raw/*4.48*/("""
  """),_display_(/*5.4*/if(members.isEmpty)/*5.23*/{_display_(Seq[Any](format.raw/*5.24*/("""
    """),format.raw/*6.5*/("""No members
  """)))}/*7.5*/else/*7.10*/{_display_(Seq[Any](format.raw/*7.11*/("""
    """),_display_(/*8.6*/members/*8.13*/.map/*8.17*/ { userName =>_display_(Seq[Any](format.raw/*8.31*/("""
      """),format.raw/*9.7*/("""<div class="block">
        <div class="block-header">
          """),_display_(/*11.12*/avatar(userName, 20)),format.raw/*11.32*/(""" """),format.raw/*11.33*/("""<a href=""""),_display_(/*11.43*/url(userName)),format.raw/*11.56*/("""">"""),_display_(/*11.59*/userName),format.raw/*11.67*/("""</a>
        </div>
      </div>
    """)))}),format.raw/*14.6*/("""
  """)))}),format.raw/*15.4*/("""
""")))}))}
  }

  def render(account:model.Account,members:List[String],isGroupManager:Boolean,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,members,isGroupManager)(context)

  def f:((model.Account,List[String],Boolean) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,members,isGroupManager) => (context) => apply(account,members,isGroupManager)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/account/members.scala.html
                  HASH: 964d25649770b1728f3a1ccfc598788daef163d9
                  MATRIX: 387->1|617->104|644->147|697->192|735->193|764->197|791->216|829->217|860->222|891->237|903->242|941->243|972->249|987->256|999->260|1050->274|1083->281|1176->347|1217->367|1246->368|1283->378|1317->391|1347->394|1376->402|1444->440|1478->444
                  LINES: 13->1|17->1|18->4|18->4|18->4|19->5|19->5|19->5|20->6|21->7|21->7|21->7|22->8|22->8|22->8|22->8|23->9|25->11|25->11|25->11|25->11|25->11|25->11|25->11|28->14|29->15
                  -- GENERATED --
              */
          