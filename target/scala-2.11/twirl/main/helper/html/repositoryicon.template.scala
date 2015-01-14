
package helper.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object repositoryicon extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[service.RepositoryService.RepositoryInfo,Boolean,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: service.RepositoryService.RepositoryInfo, large: Boolean)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*1.103*/("""
"""),_display_(/*4.2*/if(repository.repository.isPrivate)/*4.37*/{_display_(Seq[Any](format.raw/*4.38*/("""
  """),format.raw/*5.3*/("""<img src=""""),_display_(/*5.14*/assets),format.raw/*5.20*/("""/common/images/repo_private"""),_display_(/*5.48*/{if(large){"_lg"}}),format.raw/*5.66*/(""".png"/>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
  """),_display_(/*7.4*/if(repository.repository.originUserName.isDefined)/*7.54*/{_display_(Seq[Any](format.raw/*7.55*/("""
    """),format.raw/*8.5*/("""<img src=""""),_display_(/*8.16*/assets),format.raw/*8.22*/("""/common/images/repo_fork"""),_display_(/*8.47*/{if(large){"_lg"}}),format.raw/*8.65*/(""".png"/>
  """)))}/*9.5*/else/*9.10*/{_display_(Seq[Any](format.raw/*9.11*/("""
    """),format.raw/*10.5*/("""<img src=""""),_display_(/*10.16*/assets),format.raw/*10.22*/("""/common/images/repo_public"""),_display_(/*10.49*/{if(large){"_lg"}}),format.raw/*10.67*/(""".png"/>
  """)))}),format.raw/*11.4*/("""
""")))}),format.raw/*12.2*/("""
"""))}
  }

  def render(repository:service.RepositoryService.RepositoryInfo,large:Boolean,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository,large)(context)

  def f:((service.RepositoryService.RepositoryInfo,Boolean) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository,large) => (context) => apply(repository,large)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/repositoryicon.scala.html
                  HASH: 79cc6cc2c7ebc20565461fd373b314d2473eef4a
                  MATRIX: 407->1|635->102|662->145|705->180|743->181|772->184|809->195|835->201|889->229|927->247|953->257|964->262|1001->263|1030->267|1088->317|1126->318|1157->323|1194->334|1220->340|1271->365|1309->383|1337->395|1349->400|1387->401|1419->406|1457->417|1484->423|1538->450|1577->468|1618->479|1650->481
                  LINES: 13->1|17->1|18->4|18->4|18->4|19->5|19->5|19->5|19->5|19->5|20->6|20->6|20->6|21->7|21->7|21->7|22->8|22->8|22->8|22->8|22->8|23->9|23->9|23->9|24->10|24->10|24->10|24->10|24->10|25->11|26->12
                  -- GENERATED --
              */
          