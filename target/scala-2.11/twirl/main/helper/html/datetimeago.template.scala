
package helper.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object datetimeago extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[java.util.Date,Boolean,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(latestUpdatedDate: java.util.Date,
  recentOnly: Boolean = true):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import view.helpers._

Seq[Any](format.raw/*2.30*/("""
"""),format.raw/*4.1*/("""<span data-toggle="tooltip" title=""""),_display_(/*4.37*/datetime(latestUpdatedDate)),format.raw/*4.64*/("""">
  """),_display_(/*5.4*/if(recentOnly)/*5.18*/{_display_(Seq[Any](format.raw/*5.19*/("""
    """),_display_(/*6.6*/datetimeAgoRecentOnly(latestUpdatedDate)),format.raw/*6.46*/("""
  """)))}/*7.4*/else/*7.8*/{_display_(Seq[Any](format.raw/*7.9*/("""
    """),_display_(/*8.6*/datetimeAgo(latestUpdatedDate)),format.raw/*8.36*/("""
  """)))}),format.raw/*9.4*/("""
"""),format.raw/*10.1*/("""</span>
"""))}
  }

  def render(latestUpdatedDate:java.util.Date,recentOnly:Boolean): play.twirl.api.HtmlFormat.Appendable = apply(latestUpdatedDate,recentOnly)

  def f:((java.util.Date,Boolean) => play.twirl.api.HtmlFormat.Appendable) = (latestUpdatedDate,recentOnly) => apply(latestUpdatedDate,recentOnly)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/datetimeago.scala.html
                  HASH: 917b6521ac52e69bd67f3ef391c007789a026ad6
                  MATRIX: 366->1|540->66|567->90|629->126|676->153|707->159|729->173|767->174|798->180|858->220|879->224|890->228|927->229|958->235|1008->265|1041->269|1069->270
                  LINES: 13->1|17->2|18->4|18->4|18->4|19->5|19->5|19->5|20->6|20->6|21->7|21->7|21->7|22->8|22->8|23->9|24->10
                  -- GENERATED --
              */
          