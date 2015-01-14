
package account.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object activity extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[model.Account,List[String],List[model.Activity],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: model.Account, groupNames: List[String], activities: List[model.Activity])(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*1.117*/("""
"""),_display_(/*4.2*/main(account, groupNames, "activity")/*4.39*/{_display_(Seq[Any](format.raw/*4.40*/("""
  """),format.raw/*5.3*/("""<div class="pull-right">
    <a href=""""),_display_(/*6.15*/path),format.raw/*6.19*/("""/"""),_display_(/*6.21*/{account.userName}),format.raw/*6.39*/(""".atom"><img src=""""),_display_(/*6.57*/assets),format.raw/*6.63*/("""/common/images/feed.png" alt="activities"></a>
  </div>
  """),_display_(/*8.4*/helper/*8.10*/.html.activities(activities)),format.raw/*8.38*/("""
""")))}),format.raw/*9.2*/("""
"""))}
  }

  def render(account:model.Account,groupNames:List[String],activities:List[model.Activity],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,groupNames,activities)(context)

  def f:((model.Account,List[String],List[model.Activity]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,groupNames,activities) => (context) => apply(account,groupNames,activities)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/account/activity.scala.html
                  HASH: 163bc63d8b7f8cfc17eb4a4edd62e11649d104f4
                  MATRIX: 401->1|643->116|670->159|715->196|753->197|782->200|847->239|871->243|899->245|937->263|981->281|1007->287|1091->346|1105->352|1153->380|1184->382
                  LINES: 13->1|17->1|18->4|18->4|18->4|19->5|20->6|20->6|20->6|20->6|20->6|20->6|22->8|22->8|22->8|23->9
                  -- GENERATED --
              */
          