
package helper.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object error extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Option[Any],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(error: Option[Any]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.22*/("""
"""),_display_(/*2.2*/if(error.isDefined)/*2.21*/{_display_(Seq[Any](format.raw/*2.22*/("""
"""),format.raw/*3.1*/("""<div class='alert alert-danger'>
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    """),_display_(/*5.6*/error),format.raw/*5.11*/("""
"""),format.raw/*6.1*/("""</div>
""")))}))}
  }

  def render(error:Option[Any]): play.twirl.api.HtmlFormat.Appendable = apply(error)

  def f:((Option[Any]) => play.twirl.api.HtmlFormat.Appendable) = (error) => apply(error)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/error.scala.html
                  HASH: e8a3fc6006a347aa39970ece6928fdef0a9a316b
                  MATRIX: 349->1|457->21|484->23|511->42|549->43|576->44|717->160|742->165|769->166
                  LINES: 13->1|16->1|17->2|17->2|17->2|18->3|20->5|20->5|21->6
                  -- GENERATED --
              */
          