
package issues.milestones.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object progress extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Int,Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(total: Int, progress: Int):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*2.1*/("""<div class="milestone-progress">
  """),_display_(/*3.4*/if(progress > 0)/*3.20*/{_display_(Seq[Any](format.raw/*3.21*/("""
    """),format.raw/*4.5*/("""<span class="milestone-progress" style="width: """),_display_(/*4.53*/((progress.toDouble / total.toDouble * 100).toInt)),format.raw/*4.103*/("""%;"></span>
  """)))}),format.raw/*5.4*/("""
"""),format.raw/*6.1*/("""</div>
"""))}
  }

  def render(total:Int,progress:Int): play.twirl.api.HtmlFormat.Appendable = apply(total,progress)

  def f:((Int,Int) => play.twirl.api.HtmlFormat.Appendable) = (total,progress) => apply(total,progress)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/issues/milestones/progress.scala.html
                  HASH: dffe137c7155e0855a84bc73f2e94a12c917183f
                  MATRIX: 359->1|474->28|501->29|562->65|586->81|624->82|655->87|729->135|800->185|844->200|871->201
                  LINES: 13->1|16->1|17->2|18->3|18->3|18->3|19->4|19->4|19->4|20->5|21->6
                  -- GENERATED --
              */
          