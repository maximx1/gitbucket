
package helper.xml

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object feed extends BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with play.twirl.api.Template2[List[model.Activity],app.Context,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(activities: List[model.Activity])(implicit context: app.Context):play.twirl.api.XmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*1.67*/("""<?xml version="1.0" encoding="UTF-8"?>
"""),format.raw/*4.1*/("""<feed xmlns="http://www.w3.org/2005/Atom" xmlns:media="http://search.yahoo.com/mrss/" xml:lang="en-US">
  <id>tag:"""),_display_(/*5.12*/context/*5.19*/.host),format.raw/*5.24*/(""",2013:gitbucket</id>
  <title>Gitbucket's activities</title>
  <link type="application/atom+xml" rel="self" href=""""),_display_(/*7.55*/context/*7.62*/.baseUrl),format.raw/*7.70*/("""/activities.atom"/>
  <author>
    <name>Gitbucket</name>
    <uri>"""),_display_(/*10.11*/context/*10.18*/.baseUrl),format.raw/*10.26*/("""</uri>
  </author>
  <updated>"""),_display_(/*12.13*/datetimeRFC3339(if(activities.isEmpty) new java.util.Date else activities.map(_.activityDate).max)),format.raw/*12.111*/("""</updated>
  """),_display_(/*13.4*/activities/*13.14*/.map/*13.18*/ { activity =>_display_(Seq[Any](format.raw/*13.32*/("""
  """),format.raw/*14.3*/("""<entry>
    <id>tag:"""),_display_(/*15.14*/context/*15.21*/.host),format.raw/*15.26*/(""","""),_display_(/*15.28*/date(activity.activityDate)),format.raw/*15.55*/(""":activity:"""),_display_(/*15.66*/activity/*15.74*/.activityId),format.raw/*15.85*/("""</id>
    <published>"""),_display_(/*16.17*/datetimeRFC3339(activity.activityDate)),format.raw/*16.55*/("""</published>
    <updated>"""),_display_(/*17.15*/datetimeRFC3339(activity.activityDate)),format.raw/*17.53*/("""</updated>
    <link type="text/html" rel="alternate" href=""""),_display_(/*18.51*/context/*18.58*/.baseUrl),format.raw/*18.66*/("""/"""),_display_(/*18.68*/activity/*18.76*/.userName),format.raw/*18.85*/("""/"""),_display_(/*18.87*/activity/*18.95*/.repositoryName),format.raw/*18.110*/("""" />
    <title type="html">"""),_display_(/*19.25*/activity/*19.33*/.activityType),format.raw/*19.46*/("""</title>
    <author>
      <name>"""),_display_(/*21.14*/activity/*21.22*/.activityUserName),format.raw/*21.39*/("""</name>
      <uri>"""),_display_(/*22.13*/url(activity.activityUserName)),format.raw/*22.43*/("""</uri>
    </author>
    <content type="html">"""),_display_(/*24.27*/activityMessage(activity.message)),format.raw/*24.60*/("""</content>
  </entry>
  """)))}),format.raw/*26.4*/("""
"""),format.raw/*27.1*/("""</feed>
"""))}
  }

  def render(activities:List[model.Activity],context:app.Context): play.twirl.api.XmlFormat.Appendable = apply(activities)(context)

  def f:((List[model.Activity]) => (app.Context) => play.twirl.api.XmlFormat.Appendable) = (activities) => (context) => apply(activities)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/feed.scala.xml
                  HASH: b9f4860c3f557f6ab05b2f832e23f02288139eb3
                  MATRIX: 364->1|554->66|619->146|760->261|775->268|800->273|941->388|956->395|984->403|1079->471|1095->478|1124->486|1182->517|1302->615|1342->629|1361->639|1374->643|1426->657|1456->660|1504->681|1520->688|1546->693|1575->695|1623->722|1661->733|1678->741|1710->752|1759->774|1818->812|1872->839|1931->877|2019->938|2035->945|2064->953|2093->955|2110->963|2140->972|2169->974|2186->982|2223->997|2279->1026|2296->1034|2330->1047|2392->1082|2409->1090|2447->1107|2494->1127|2545->1157|2619->1204|2673->1237|2728->1262|2756->1263
                  LINES: 13->1|17->1|18->4|19->5|19->5|19->5|21->7|21->7|21->7|24->10|24->10|24->10|26->12|26->12|27->13|27->13|27->13|27->13|28->14|29->15|29->15|29->15|29->15|29->15|29->15|29->15|29->15|30->16|30->16|31->17|31->17|32->18|32->18|32->18|32->18|32->18|32->18|32->18|32->18|32->18|33->19|33->19|33->19|35->21|35->21|35->21|36->22|36->22|38->24|38->24|40->26|41->27
                  -- GENERATED --
              */
          