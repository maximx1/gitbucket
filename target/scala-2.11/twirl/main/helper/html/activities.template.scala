
package helper.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object activities extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[List[model.Activity],app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(activities: List[model.Activity])(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._
def /*63.2*/detailActivity/*63.16*/(activity: model.Activity, image: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*63.61*/("""
  """),format.raw/*64.3*/("""<div class="activity-icon-large"><img src=""""),_display_(/*64.47*/assets),format.raw/*64.53*/("""/common/images/"""),_display_(/*64.69*/image),format.raw/*64.74*/(""""/></div>
  <div class="activity-content">
    <div class="muted small">"""),_display_(/*66.31*/helper/*66.37*/.html.datetimeago(activity.activityDate)),format.raw/*66.77*/("""</div>
    <div class="strong">
      """),_display_(/*68.8*/avatar(activity.activityUserName, 16)),format.raw/*68.45*/("""
      """),_display_(/*69.8*/activityMessage(activity.message)),format.raw/*69.41*/("""
    """),format.raw/*70.5*/("""</div>
    """),_display_(/*71.6*/activity/*71.14*/.additionalInfo.map/*71.33*/ { additionalInfo =>_display_(Seq[Any](format.raw/*71.53*/("""
      """),format.raw/*72.7*/("""<div class=" activity-message">"""),_display_(/*72.39*/additionalInfo),format.raw/*72.53*/("""</div>
    """)))}),format.raw/*73.6*/("""
  """),format.raw/*74.3*/("""</div>
""")))};def /*77.2*/customActivity/*77.16*/(activity: model.Activity, image: String)(additionalInfo: Any):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*77.82*/("""
  """),format.raw/*78.3*/("""<div class="activity-icon-large"><img src=""""),_display_(/*78.47*/assets),format.raw/*78.53*/("""/common/images/"""),_display_(/*78.69*/image),format.raw/*78.74*/(""""/></div>
  <div class="activity-content">
    <div class="muted small">"""),_display_(/*80.31*/helper/*80.37*/.html.datetimeago(activity.activityDate)),format.raw/*80.77*/("""</div>
    <div class="strong">
      """),_display_(/*82.8*/avatar(activity.activityUserName, 16)),format.raw/*82.45*/("""
      """),_display_(/*83.8*/activityMessage(activity.message)),format.raw/*83.41*/("""
    """),format.raw/*84.5*/("""</div>
    """),_display_(/*85.6*/additionalInfo),format.raw/*85.20*/("""
  """),format.raw/*86.3*/("""</div>
""")))};def /*89.2*/simpleActivity/*89.16*/(activity: model.Activity, image: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*89.61*/("""
  """),format.raw/*90.3*/("""<div class="activity-icon-small"><img src=""""),_display_(/*90.47*/assets),format.raw/*90.53*/("""/common/images/"""),_display_(/*90.69*/image),format.raw/*90.74*/(""""/></div>
  <div class="activity-content">
    <div>
      """),_display_(/*93.8*/avatar(activity.activityUserName, 16)),format.raw/*93.45*/("""
      """),_display_(/*94.8*/activityMessage(activity.message)),format.raw/*94.41*/("""
      """),format.raw/*95.7*/("""<span class="muted small">"""),_display_(/*95.34*/helper/*95.40*/.html.datetimeago(activity.activityDate)),format.raw/*95.80*/("""</span>
    </div>
  </div>
""")))};
Seq[Any](format.raw/*1.67*/("""
"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/if(activities.isEmpty)/*5.24*/{_display_(Seq[Any](format.raw/*5.25*/("""
  """),format.raw/*6.3*/("""No activity
""")))}/*7.3*/else/*7.8*/{_display_(Seq[Any](format.raw/*7.9*/("""
  """),_display_(/*8.4*/activities/*8.14*/.map/*8.18*/ { activity =>_display_(Seq[Any](format.raw/*8.32*/("""
    """),format.raw/*9.5*/("""<div class="block">
      """),_display_(/*10.8*/(activity.activityType match {
        case "open_issue"        => detailActivity(activity, "activity-issue.png")
        case "comment_issue"     => detailActivity(activity, "activity-comment.png")
        case "comment_commit"    => detailActivity(activity, "activity-comment.png")
        case "close_issue"       => detailActivity(activity, "activity-issue-close.png")
        case "reopen_issue"      => detailActivity(activity, "activity-issue-reopen.png")
        case "open_pullreq"      => detailActivity(activity, "activity-merge.png")
        case "merge_pullreq"     => detailActivity(activity, "activity-merge.png")
        case "create_repository" => simpleActivity(activity, "activity-create-repository.png")
        case "create_branch"     => simpleActivity(activity, "activity-branch.png")
        case "delete_branch"     => simpleActivity(activity, "activity-delete.png")
        case "create_tag"        => simpleActivity(activity, "activity-tag.png")
        case "delete_tag"        => simpleActivity(activity, "activity-delete.png")
        case "fork"              => simpleActivity(activity, "activity-fork.png")
        case "push"  => customActivity(activity, "activity-commit.png"){
          <div class="small activity-message">
            {activity.additionalInfo.get.split("\n").reverse.take(4).zipWithIndex.map{ case (commit, i) =>
              if(i == 3){
                <div>...</div>
              } else {
                if(commit.nonEmpty){
                  <div>
                     <a href={s"${path}/${activity.userName}/${activity.repositoryName}/commit/${commit. substring(0, 40)}"} class="monospace">{commit.substring(0, 7)}</a>
                     <span>{commit.substring(41)}</span>
                  </div>
                }
              }
            }}
          </div>
        }
        case "create_wiki" => customActivity(activity, "activity-wiki.png"){
          <div class="small activity-message">
            Created <a href={s"${path}/${activity.userName}/${activity.repositoryName}/wiki/${activity.additionalInfo.get}"}>{activity.additionalInfo.get}</a>.
          </div>
        }
        case "edit_wiki" => customActivity(activity, "activity-wiki.png"){
          activity.additionalInfo.get.split(":") match {
            case Array(pageName, commitId) =>
              <div class="small activity-message">
                Edited <a href={s"${path}/${activity.userName}/${activity.repositoryName}/wiki/${pageName}"}>{pageName}</a>.
                <a href={s"${path}/${activity.userName}/${activity.repositoryName}/wiki/${pageName}/_compare/${commitId.substring(0, 7)}^...${commitId.substring(0, 7)}"}>View the diff »</a>
              </div>
            case Array(pageName) =>
              <div class="small activity-message">
                Edited <a href={s"${path}/${activity.userName}/${activity.repositoryName}/wiki/${pageName}"}>{pageName}</a>.
              </div>
          }
        }
      })),format.raw/*58.9*/("""
    """),format.raw/*59.5*/("""</div>
  """)))}),format.raw/*60.4*/("""
""")))}),format.raw/*61.2*/("""

"""),format.raw/*75.2*/("""

"""),format.raw/*87.2*/("""

"""),format.raw/*98.2*/("""

"""))}
  }

  def render(activities:List[model.Activity],context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(activities)(context)

  def f:((List[model.Activity]) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (activities) => (context) => apply(activities)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:13 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/helper/activities.scala.html
                  HASH: 670f7accc85b32006fcfe76b0a8183a8359da8d3
                  MATRIX: 375->1|550->3216|573->3230|695->3275|725->3278|796->3322|823->3328|866->3344|892->3349|992->3422|1007->3428|1068->3468|1133->3507|1191->3544|1225->3552|1279->3585|1311->3590|1349->3602|1366->3610|1394->3629|1452->3649|1486->3656|1545->3688|1580->3702|1622->3714|1652->3717|1683->3728|1706->3742|1849->3808|1879->3811|1950->3855|1977->3861|2020->3877|2046->3882|2146->3955|2161->3961|2222->4001|2287->4040|2345->4077|2379->4085|2433->4118|2465->4123|2503->4135|2538->4149|2568->4152|2599->4163|2622->4177|2744->4222|2774->4225|2845->4269|2872->4275|2915->4291|2941->4296|3027->4356|3085->4393|3119->4401|3173->4434|3207->4441|3261->4468|3276->4474|3337->4514|3405->66|3432->108|3459->110|3489->132|3527->133|3556->136|3586->150|3597->155|3634->156|3663->160|3681->170|3693->174|3744->188|3775->193|3828->220|6824->3196|6856->3201|6896->3211|6928->3213|6957->3725|6986->4160|7015->4543
                  LINES: 13->1|16->63|16->63|18->63|19->64|19->64|19->64|19->64|19->64|21->66|21->66|21->66|23->68|23->68|24->69|24->69|25->70|26->71|26->71|26->71|26->71|27->72|27->72|27->72|28->73|29->74|30->77|30->77|32->77|33->78|33->78|33->78|33->78|33->78|35->80|35->80|35->80|37->82|37->82|38->83|38->83|39->84|40->85|40->85|41->86|42->89|42->89|44->89|45->90|45->90|45->90|45->90|45->90|48->93|48->93|49->94|49->94|50->95|50->95|50->95|50->95|54->1|55->4|56->5|56->5|56->5|57->6|58->7|58->7|58->7|59->8|59->8|59->8|59->8|60->9|61->10|109->58|110->59|111->60|112->61|114->75|116->87|118->98
                  -- GENERATED --
              */
          