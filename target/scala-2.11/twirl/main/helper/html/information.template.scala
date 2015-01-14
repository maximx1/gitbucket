
package helper.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object information extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Option[Any],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(info: Option[Any]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.21*/("""
"""),_display_(/*2.2*/if(info.isDefined)/*2.20*/{_display_(Seq[Any](format.raw/*2.21*/("""
  """),format.raw/*3.3*/("""<div class="alert alert-info">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    """),_display_(/*5.6*/info),format.raw/*5.10*/("""
  """),format.raw/*6.3*/("""</div>
""")))}),format.raw/*7.2*/("""
"""))}
  }

  def render(info:Option[Any]): play.twirl.api.HtmlFormat.Appendable = apply(info)

  def f:((Option[Any]) => play.twirl.api.HtmlFormat.Appendable) = (info) => apply(info)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/information.scala.html
                  HASH: 1d121e3a567eb925c2b92453ee8da8ff7563798e
                  MATRIX: 355->1|462->20|489->22|515->40|553->41|582->44|721->158|745->162|774->165|811->173
                  LINES: 13->1|16->1|17->2|17->2|17->2|18->3|20->5|20->5|21->6|22->7
                  -- GENERATED --
              */
          