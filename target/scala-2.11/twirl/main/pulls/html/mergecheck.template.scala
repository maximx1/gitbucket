
package pulls.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object mergecheck extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Boolean,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(hasConflict: Boolean):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.24*/("""
"""),_display_(/*2.2*/if(hasConflict)/*2.17*/{_display_(Seq[Any](format.raw/*2.18*/("""
  """),format.raw/*3.3*/("""<h4>We can’t automatically merge these branches</h4>
  <p>Don't worry, you can still submit the pull request.</p>
""")))}/*5.3*/else/*5.8*/{_display_(Seq[Any](format.raw/*5.9*/("""
  """),format.raw/*6.3*/("""<h4 style="color: #468847;">Able to merge</h4>
  <p>These branches can be automatically merged.</p>
""")))}),format.raw/*8.2*/("""
"""),format.raw/*9.1*/("""<input type="submit" class="btn btn-success btn-block" value="Create pull request"/>
"""))}
  }

  def render(hasConflict:Boolean): play.twirl.api.HtmlFormat.Appendable = apply(hasConflict)

  def f:((Boolean) => play.twirl.api.HtmlFormat.Appendable) = (hasConflict) => apply(hasConflict)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/pulls/mergecheck.scala.html
                  HASH: e94e967069a5798ceee4683bc76fd99e3454ea05
                  MATRIX: 349->1|459->23|486->25|509->40|547->41|576->44|708->160|719->165|756->166|785->169|915->270|942->271
                  LINES: 13->1|16->1|17->2|17->2|17->2|18->3|20->5|20->5|20->5|21->6|23->8|24->9
                  -- GENERATED --
              */
          