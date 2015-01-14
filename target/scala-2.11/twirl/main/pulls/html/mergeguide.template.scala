
package pulls.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object mergeguide extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[Boolean,model.PullRequest,String,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(hasConflict: Boolean,
  pullreq: model.PullRequest,
  requestRepositoryUrl: String)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._

Seq[Any](format.raw/*3.63*/("""
"""),format.raw/*6.1*/("""<div class="pull-right">
  <input type="button" class="btn btn-success" id="merge-pull-request-button" value="Merge pull request""""),_display_(/*7.106*/if(hasConflict)/*7.121*/{_display_(Seq[Any](format.raw/*7.122*/(""" """),format.raw/*7.123*/("""disabled="true"""")))}),format.raw/*7.139*/("""/>
</div>
<div>
  """),_display_(/*10.4*/if(hasConflict)/*10.19*/{_display_(Seq[Any](format.raw/*10.20*/("""
    """),format.raw/*11.5*/("""<span class="strong">We can’t automatically merge this pull request.</span>
  """)))}/*12.5*/else/*12.10*/{_display_(Seq[Any](format.raw/*12.11*/("""
    """),format.raw/*13.5*/("""<span class="strong">This pull request can be automatically merged.</span>
  """)))}),format.raw/*14.4*/("""
"""),format.raw/*15.1*/("""</div>
<div class="small">
  """),_display_(/*17.4*/if(hasConflict)/*17.19*/{_display_(Seq[Any](format.raw/*17.20*/("""
    """),format.raw/*18.5*/("""<a href="#" id="show-command-line">Use the command line</a> to resolve conflicts before continuing.
  """)))}/*19.5*/else/*19.10*/{_display_(Seq[Any](format.raw/*19.11*/("""
    """),format.raw/*20.5*/("""You can also merge branches on the <a href="#" id="show-command-line">command line</a>.
  """)))}),format.raw/*21.4*/("""
"""),format.raw/*22.1*/("""</div>
<div id="command-line" style="display: none;">
  <hr>
  """),_display_(/*25.4*/if(hasConflict)/*25.19*/{_display_(Seq[Any](format.raw/*25.20*/("""
    """),format.raw/*26.5*/("""<span class="strong">Checkout via command line</span>
    <p>
      If you cannot merge a pull request automatically here, you have the option of checking
      it out via command line to resolve conflicts and perform a manual merge.
    </p>
  """)))}/*31.5*/else/*31.10*/{_display_(Seq[Any](format.raw/*31.11*/("""
    """),format.raw/*32.5*/("""<span class="strong">Merging via command line</span>
    <p>
      If you do not want to use the merge button or an automatic merge cannot be performed,
      you can perform a manual merge on the command line.
    </p>
  """)))}),format.raw/*37.4*/("""
  """),_display_(/*38.4*/helper/*38.10*/.html.copy("repository-url-copy", requestRepositoryUrl)/*38.65*/{_display_(Seq[Any](format.raw/*38.66*/("""
    """),format.raw/*39.5*/("""<input type="text" style="width: 500px;" value=""""),_display_(/*39.54*/requestRepositoryUrl),format.raw/*39.74*/("""" id="repository-url" readonly>
  """)))}),format.raw/*40.4*/("""
  """),format.raw/*41.3*/("""<div>
    <p>
      <span class="strong">Step 1:</span> Check out a new branch to test the changes — run this from your project directory
    </p>
    """),_display_(/*45.6*/defining(s"git checkout -b ${pullreq.requestUserName}-${pullreq.requestBranch} ${pullreq.branch}")/*45.104*/{ command =>_display_(Seq[Any](format.raw/*45.116*/("""
      """),_display_(/*46.8*/helper/*46.14*/.html.copy("merge-command-copy-1", command)/*46.57*/{_display_(Seq[Any](format.raw/*46.58*/("""
        """),format.raw/*47.9*/("""<pre style="width: 500px; float: left;">"""),_display_(/*47.50*/command),format.raw/*47.57*/("""</pre>
      """)))}),format.raw/*48.8*/("""
    """)))}),format.raw/*49.6*/("""
  """),format.raw/*50.3*/("""</div>
  <div>
    <p>
      <span class="strong">Step 2:</span> Bring in """),_display_(/*53.53*/{pullreq.requestUserName}),format.raw/*53.78*/("""'s changes and test
    </p>
    """),_display_(/*55.6*/defining(s"git pull ${requestRepositoryUrl} ${pullreq.requestBranch}")/*55.76*/{ command =>_display_(Seq[Any](format.raw/*55.88*/("""
      """),_display_(/*56.8*/helper/*56.14*/.html.copy("merge-command-copy-2", command)/*56.57*/{_display_(Seq[Any](format.raw/*56.58*/("""
        """),format.raw/*57.9*/("""<pre style="width: 500px; float: left;">"""),_display_(/*57.50*/command),format.raw/*57.57*/("""</pre>
      """)))}),format.raw/*58.8*/("""
    """)))}),format.raw/*59.6*/("""
  """),format.raw/*60.3*/("""</div>
  <div>
    <p>
      <span class="strong">Step 3:</span> Merge the changes and update the server
    </p>
    """),_display_(/*65.6*/defining(s"git checkout master\ngit merge ${pullreq.requestUserName}-${pullreq.requestBranch}\ngit push origin ${pullreq.branch}")/*65.136*/{ command =>_display_(Seq[Any](format.raw/*65.148*/("""
      """),_display_(/*66.8*/helper/*66.14*/.html.copy("merge-command-copy-3", command)/*66.57*/{_display_(Seq[Any](format.raw/*66.58*/("""
        """),format.raw/*67.9*/("""<pre style="width: 500px; float: left;">"""),_display_(/*67.50*/command),format.raw/*67.57*/("""</pre>
      """)))}),format.raw/*68.8*/("""
    """)))}),format.raw/*69.6*/("""
  """),format.raw/*70.3*/("""</div>
</div>
<script>
$(function()"""),format.raw/*73.13*/("""{"""),format.raw/*73.14*/("""
  """),format.raw/*74.3*/("""$('#show-command-line').click(function()"""),format.raw/*74.43*/("""{"""),format.raw/*74.44*/("""
    """),format.raw/*75.5*/("""$('#command-line').show();
    return false;
  """),format.raw/*77.3*/("""}"""),format.raw/*77.4*/(""");

  $('#merge-pull-request-button').click(function()"""),format.raw/*79.51*/("""{"""),format.raw/*79.52*/("""
    """),format.raw/*80.5*/("""$('#merge-pull-request').hide();
    $('#confirm-merge-form').show();
  """),format.raw/*82.3*/("""}"""),format.raw/*82.4*/(""");
"""),format.raw/*83.1*/("""}"""),format.raw/*83.2*/(""");
</script>"""))}
  }

  def render(hasConflict:Boolean,pullreq:model.PullRequest,requestRepositoryUrl:String,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(hasConflict,pullreq,requestRepositoryUrl)(context)

  def f:((Boolean,model.PullRequest,String) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (hasConflict,pullreq,requestRepositoryUrl) => (context) => apply(hasConflict,pullreq,requestRepositoryUrl)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/pulls/mergeguide.scala.html
                  HASH: 917d9fbde6fab61f48e0786580c9184585d079f9
                  MATRIX: 386->1|627->116|654->158|811->288|835->303|874->304|903->305|950->321|995->340|1019->355|1058->356|1090->361|1187->441|1200->446|1239->447|1271->452|1379->530|1407->531|1463->561|1487->576|1526->577|1558->582|1679->686|1692->691|1731->692|1763->697|1884->788|1912->789|2002->853|2026->868|2065->869|2097->874|2361->1121|2374->1126|2413->1127|2445->1132|2698->1355|2728->1359|2743->1365|2807->1420|2846->1421|2878->1426|2954->1475|2995->1495|3060->1530|3090->1533|3268->1685|3376->1783|3427->1795|3461->1803|3476->1809|3528->1852|3567->1853|3603->1862|3671->1903|3699->1910|3743->1924|3779->1930|3809->1933|3911->2008|3957->2033|4017->2067|4096->2137|4146->2149|4180->2157|4195->2163|4247->2206|4286->2207|4322->2216|4390->2257|4418->2264|4462->2278|4498->2284|4528->2287|4673->2406|4813->2536|4864->2548|4898->2556|4913->2562|4965->2605|5004->2606|5040->2615|5108->2656|5136->2663|5180->2677|5216->2683|5246->2686|5309->2721|5338->2722|5368->2725|5436->2765|5465->2766|5497->2771|5571->2818|5599->2819|5681->2873|5710->2874|5742->2879|5841->2951|5869->2952|5899->2955|5927->2956
                  LINES: 13->1|19->3|20->6|21->7|21->7|21->7|21->7|21->7|24->10|24->10|24->10|25->11|26->12|26->12|26->12|27->13|28->14|29->15|31->17|31->17|31->17|32->18|33->19|33->19|33->19|34->20|35->21|36->22|39->25|39->25|39->25|40->26|45->31|45->31|45->31|46->32|51->37|52->38|52->38|52->38|52->38|53->39|53->39|53->39|54->40|55->41|59->45|59->45|59->45|60->46|60->46|60->46|60->46|61->47|61->47|61->47|62->48|63->49|64->50|67->53|67->53|69->55|69->55|69->55|70->56|70->56|70->56|70->56|71->57|71->57|71->57|72->58|73->59|74->60|79->65|79->65|79->65|80->66|80->66|80->66|80->66|81->67|81->67|81->67|82->68|83->69|84->70|87->73|87->73|88->74|88->74|88->74|89->75|91->77|91->77|93->79|93->79|94->80|96->82|96->82|97->83|97->83
                  -- GENERATED --
              */
          