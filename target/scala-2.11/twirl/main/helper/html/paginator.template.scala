
package helper.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object paginator extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Int,Int,Int,Int,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(page: Int, count: Int, limit: Int, width: Int, baseURL: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.66*/("""
"""),_display_(/*2.2*/defining(view.Pagination(page, count, limit, width))/*2.54*/{ p =>_display_(Seq[Any](format.raw/*2.60*/("""
  """),_display_(/*3.4*/if(p.count > p.limit)/*3.25*/{_display_(Seq[Any](format.raw/*3.26*/("""
    """),format.raw/*4.5*/("""<div class="pagination">
      <ul>
        """),_display_(/*6.10*/if(page == 1)/*6.23*/{_display_(Seq[Any](format.raw/*6.24*/("""
          """),format.raw/*7.11*/("""<li class="disabled"><span>&#9664;</span></li>
        """)))}/*8.11*/else/*8.16*/{_display_(Seq[Any](format.raw/*8.17*/("""
          """),format.raw/*9.11*/("""<li><a href=""""),_display_(/*9.25*/baseURL),format.raw/*9.32*/("""&page="""),_display_(/*9.39*/(page - 1)),format.raw/*9.49*/("""">&#9664;</a></li>
        """)))}),format.raw/*10.10*/("""
        """),_display_(/*11.10*/for(i <- 1 to p.max) yield /*11.30*/{_display_(Seq[Any](format.raw/*11.31*/("""
          """),_display_(/*12.12*/if(i == p.max && p.omitRight)/*12.41*/{_display_(Seq[Any](format.raw/*12.42*/("""
            """),format.raw/*13.13*/("""<li><span>&hellip;</span></li>
          """)))}),format.raw/*14.12*/("""
          """),_display_(/*15.12*/if(i == page)/*15.25*/{_display_(Seq[Any](format.raw/*15.26*/("""
            """),format.raw/*16.13*/("""<li class="active"><span>"""),_display_(/*16.39*/i),format.raw/*16.40*/("""</span></li>
          """)))}/*17.13*/else/*17.18*/{_display_(Seq[Any](format.raw/*17.19*/("""
            """),_display_(/*18.14*/if(p.visibleFor(i))/*18.33*/{_display_(Seq[Any](format.raw/*18.34*/("""
              """),format.raw/*19.15*/("""<li><a href=""""),_display_(/*19.29*/baseURL),format.raw/*19.36*/("""&page="""),_display_(/*19.43*/i),format.raw/*19.44*/("""">"""),_display_(/*19.47*/i),format.raw/*19.48*/("""</a></li>
            """)))}),format.raw/*20.14*/("""
          """)))}),format.raw/*21.12*/("""
          """),_display_(/*22.12*/if(i == 1 && p.omitLeft)/*22.36*/{_display_(Seq[Any](format.raw/*22.37*/("""
            """),format.raw/*23.13*/("""<li><span>&hellip;</span></li>
          """)))}),format.raw/*24.12*/("""
        """)))}),format.raw/*25.10*/("""
        """),_display_(/*26.10*/if(page == p.max)/*26.27*/{_display_(Seq[Any](format.raw/*26.28*/("""
          """),format.raw/*27.11*/("""<li class="disabled"><span>&#9654;</span></li>
        """)))}/*28.11*/else/*28.16*/{_display_(Seq[Any](format.raw/*28.17*/("""
          """),format.raw/*29.11*/("""<li><a href=""""),_display_(/*29.25*/baseURL),format.raw/*29.32*/("""&page="""),_display_(/*29.39*/(page + 1)),format.raw/*29.49*/("""">&#9654;</a></li>
        """)))}),format.raw/*30.10*/("""
      """),format.raw/*31.7*/("""</ul>
    </div>
  """)))}),format.raw/*33.4*/("""
""")))}),format.raw/*34.2*/("""
"""))}
  }

  def render(page:Int,count:Int,limit:Int,width:Int,baseURL:String): play.twirl.api.HtmlFormat.Appendable = apply(page,count,limit,width,baseURL)

  def f:((Int,Int,Int,Int,String) => play.twirl.api.HtmlFormat.Appendable) = (page,count,limit,width,baseURL) => apply(page,count,limit,width,baseURL)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/paginator.scala.html
                  HASH: 21bc86e214e94f797335b2fb1d0a2ca4eca6dc76
                  MATRIX: 364->1|516->65|543->67|603->119|646->125|675->129|704->150|742->151|773->156|844->201|865->214|903->215|941->226|1015->283|1027->288|1065->289|1103->300|1143->314|1170->321|1203->328|1233->338|1292->366|1329->376|1365->396|1404->397|1443->409|1481->438|1520->439|1561->452|1634->494|1673->506|1695->519|1734->520|1775->533|1828->559|1850->560|1893->585|1906->590|1945->591|1986->605|2014->624|2053->625|2096->640|2137->654|2165->661|2199->668|2221->669|2251->672|2273->673|2327->696|2370->708|2409->720|2442->744|2481->745|2522->758|2595->800|2636->810|2673->820|2699->837|2738->838|2777->849|2852->906|2865->911|2904->912|2943->923|2984->937|3012->944|3046->951|3077->961|3136->989|3170->996|3220->1016|3252->1018
                  LINES: 13->1|16->1|17->2|17->2|17->2|18->3|18->3|18->3|19->4|21->6|21->6|21->6|22->7|23->8|23->8|23->8|24->9|24->9|24->9|24->9|24->9|25->10|26->11|26->11|26->11|27->12|27->12|27->12|28->13|29->14|30->15|30->15|30->15|31->16|31->16|31->16|32->17|32->17|32->17|33->18|33->18|33->18|34->19|34->19|34->19|34->19|34->19|34->19|34->19|35->20|36->21|37->22|37->22|37->22|38->23|39->24|40->25|41->26|41->26|41->26|42->27|43->28|43->28|43->28|44->29|44->29|44->29|44->29|44->29|45->30|46->31|48->33|49->34
                  -- GENERATED --
              */
          