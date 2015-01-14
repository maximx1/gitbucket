
package issues.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object labellist extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[model.Label],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issueLabels: List[model.Label]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.34*/("""
"""),_display_(/*2.2*/if(issueLabels.isEmpty)/*2.25*/{_display_(Seq[Any](format.raw/*2.26*/("""
  """),format.raw/*3.3*/("""<li><span class="muted small">None yet</span></li>
""")))}),format.raw/*4.2*/("""
"""),_display_(/*5.2*/issueLabels/*5.13*/.map/*5.17*/ { label =>_display_(Seq[Any](format.raw/*5.28*/("""
  """),format.raw/*6.3*/("""<li><span class="issue-label" style="background-color: #"""),_display_(/*6.60*/label/*6.65*/.color),format.raw/*6.71*/("""; color: #"""),_display_(/*6.82*/label/*6.87*/.fontColor),format.raw/*6.97*/(""";">"""),_display_(/*6.101*/label/*6.106*/.labelName),format.raw/*6.116*/("""</span></li>
""")))}),format.raw/*7.2*/("""
"""))}
  }

  def render(issueLabels:List[model.Label]): play.twirl.api.HtmlFormat.Appendable = apply(issueLabels)

  def f:((List[model.Label]) => play.twirl.api.HtmlFormat.Appendable) = (issueLabels) => apply(issueLabels)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/issues/labellist.scala.html
                  HASH: 66bcfe9f6548c2fe92af545376f6198f0879d565
                  MATRIX: 359->1|479->33|506->35|537->58|575->59|604->62|685->114|712->116|731->127|743->131|791->142|820->145|903->202|916->207|942->213|979->224|992->229|1022->239|1053->243|1067->248|1098->258|1141->272
                  LINES: 13->1|16->1|17->2|17->2|17->2|18->3|19->4|20->5|20->5|20->5|20->5|21->6|21->6|21->6|21->6|21->6|21->6|21->6|21->6|21->6|21->6|22->7
                  -- GENERATED --
              */
          