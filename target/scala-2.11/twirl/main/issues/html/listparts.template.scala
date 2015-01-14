
package issues.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._



/**/
object listparts extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template12[String,List[service.IssuesService.IssueInfo],Int,Int,Int,service.IssuesService.IssueSearchCondition,List[String],List[model.Milestone],List[model.Label],Option[service.RepositoryService.RepositoryInfo],Boolean,app.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(target: String,
  issues: List[service.IssuesService.IssueInfo],
  page: Int,
  openCount: Int,
  closedCount: Int,
  condition: service.IssuesService.IssueSearchCondition,
  collaborators: List[String] = Nil,
  milestones: List[model.Milestone] = Nil,
  labels: List[model.Label] = Nil,
  repository: Option[service.RepositoryService.RepositoryInfo] = None,
  hasWritePermission: Boolean = false)(implicit context: app.Context):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import context._
import view.helpers._
import service.IssuesService.IssueInfo

Seq[Any](format.raw/*11.70*/("""
"""),format.raw/*15.1*/("""<br>
"""),_display_(/*16.2*/if(condition.nonEmpty)/*16.24*/{_display_(Seq[Any](format.raw/*16.25*/("""
  """),format.raw/*17.3*/("""<div>
    <a href=""""),_display_(/*18.15*/service/*18.22*/.IssuesService.IssueSearchCondition().toURL),format.raw/*18.65*/("""" class="header-link">
      <img src=""""),_display_(/*19.18*/assets),format.raw/*19.24*/("""/common/images/clear.png" class="header-icon"/>
      <img src=""""),_display_(/*20.18*/assets),format.raw/*20.24*/("""/common/images/clear_hover.png" class="header-icon-hover" style="display: none;"/>
      <span class="strong">Clear current search query, filters, and sorts</span>
    </a>
  </div>
""")))}),format.raw/*24.2*/("""
"""),format.raw/*25.1*/("""<table class="table table-bordered table-hover table-issues">
  <tr>
    <th style="background-color: #eee;">
      <input type="checkbox"/>
      <span class="small">
        <a class="button-link"""),_display_(/*30.31*/if(condition.state == "open")/*30.60*/{_display_(Seq[Any](format.raw/*30.61*/(""" """),format.raw/*30.62*/("""selected""")))}),format.raw/*30.71*/("""" href=""""),_display_(/*30.80*/condition/*30.89*/.copy(state = "open").toURL),format.raw/*30.116*/("""">
          <img src=""""),_display_(/*31.22*/assets),format.raw/*31.28*/("""/common/images/status-open"""),_display_(/*31.55*/(if(condition.state == "open"){"-active"})),format.raw/*31.97*/(""".png"/>
          """),_display_(/*32.12*/openCount),format.raw/*32.21*/(""" """),format.raw/*32.22*/("""Open
        </a>&nbsp;&nbsp;
        <a class="button-link"""),_display_(/*34.31*/if(condition.state == "closed")/*34.62*/{_display_(Seq[Any](format.raw/*34.63*/(""" """),format.raw/*34.64*/("""selected""")))}),format.raw/*34.73*/("""" href=""""),_display_(/*34.82*/condition/*34.91*/.copy(state = "closed").toURL),format.raw/*34.120*/("""">
          <img src=""""),_display_(/*35.22*/assets),format.raw/*35.28*/("""/common/images/status-closed"""),_display_(/*35.57*/(if(condition.state == "closed"){"-active"})),format.raw/*35.101*/(""".png"/>
          """),_display_(/*36.12*/closedCount),format.raw/*36.23*/(""" """),format.raw/*36.24*/("""Closed
        </a>
      </span>
      <div class="pull-right" id="table-issues-control">
        """),_display_(/*40.10*/helper/*40.16*/.html.dropdown("Author", flat = true)/*40.53*/ {_display_(Seq[Any](format.raw/*40.55*/("""
          """),_display_(/*41.12*/collaborators/*41.25*/.map/*41.29*/ { collaborator =>_display_(Seq[Any](format.raw/*41.47*/("""
            """),format.raw/*42.13*/("""<li>
              <a href=""""),_display_(/*43.25*/condition/*43.34*/.copy(author = (if(condition.author == Some(collaborator)) None else Some(collaborator))).toURL),format.raw/*43.129*/("""">
                """),_display_(/*44.18*/helper/*44.24*/.html.checkicon(condition.author == Some(collaborator))),format.raw/*44.79*/("""
                """),_display_(/*45.18*/avatar(collaborator, 20)),format.raw/*45.42*/(""" """),_display_(/*45.44*/collaborator),format.raw/*45.56*/("""
              """),format.raw/*46.15*/("""</a>
            </li>
          """)))}),format.raw/*48.12*/("""
        """)))}),format.raw/*49.10*/("""
        """),_display_(/*50.10*/helper/*50.16*/.html.dropdown("Label", flat = true)/*50.52*/ {_display_(Seq[Any](format.raw/*50.54*/("""
          """),_display_(/*51.12*/labels/*51.18*/.map/*51.22*/ { label =>_display_(Seq[Any](format.raw/*51.33*/("""
            """),format.raw/*52.13*/("""<li>
              <a href=""""),_display_(/*53.25*/condition/*53.34*/.copy(labels = (if(condition.labels.contains(label.labelName)) condition.labels - label.labelName else condition.labels + label.labelName)).toURL),format.raw/*53.179*/("""">
                """),_display_(/*54.18*/helper/*54.24*/.html.checkicon(condition.labels.contains(label.labelName))),format.raw/*54.83*/("""
                """),format.raw/*55.17*/("""<span style="background-color: #"""),_display_(/*55.50*/label/*55.55*/.color),format.raw/*55.61*/(""";" class="label-color">&nbsp;&nbsp;</span>
                """),_display_(/*56.18*/label/*56.23*/.labelName),format.raw/*56.33*/("""
              """),format.raw/*57.15*/("""</a>
            </li>
          """)))}),format.raw/*59.12*/("""
        """)))}),format.raw/*60.10*/("""
        """),_display_(/*61.10*/helper/*61.16*/.html.dropdown("Milestone", flat = true)/*61.56*/ {_display_(Seq[Any](format.raw/*61.58*/("""
          """),format.raw/*62.11*/("""<li>
            <a href=""""),_display_(/*63.23*/condition/*63.32*/.copy(milestoneId = Some(None)).toURL),format.raw/*63.69*/("""">
              """),_display_(/*64.16*/helper/*64.22*/.html.checkicon(condition.milestoneId == Some(None))),format.raw/*64.74*/(""" """),format.raw/*64.75*/("""Issues with no milestone
            </a>
          </li>
          """),_display_(/*67.12*/milestones/*67.22*/.filter(_.closedDate.isEmpty).map/*67.55*/ { milestone =>_display_(Seq[Any](format.raw/*67.70*/("""
            """),format.raw/*68.13*/("""<li>
              <a href=""""),_display_(/*69.25*/condition/*69.34*/.copy(milestoneId = Some(Some(milestone.milestoneId))).toURL),format.raw/*69.94*/("""">
                """),_display_(/*70.18*/helper/*70.24*/.html.checkicon(condition.milestoneId == Some(Some(milestone.milestoneId)))),format.raw/*70.99*/(""" """),_display_(/*70.101*/milestone/*70.110*/.title),format.raw/*70.116*/("""
              """),format.raw/*71.15*/("""</a>
            </li>
          """)))}),format.raw/*73.12*/("""
        """)))}),format.raw/*74.10*/("""
        """),_display_(/*75.10*/helper/*75.16*/.html.dropdown("Assignee", flat = true)/*75.55*/ {_display_(Seq[Any](format.raw/*75.57*/("""
          """),_display_(/*76.12*/collaborators/*76.25*/.map/*76.29*/ { collaborator =>_display_(Seq[Any](format.raw/*76.47*/("""
            """),format.raw/*77.13*/("""<li>
              <a href=""""),_display_(/*78.25*/condition/*78.34*/.copy(assigned = Some(collaborator)).toURL),format.raw/*78.76*/("""">
                """),_display_(/*79.18*/helper/*79.24*/.html.checkicon(condition.assigned == Some(collaborator))),format.raw/*79.81*/("""
                """),_display_(/*80.18*/avatar(collaborator, 20)),format.raw/*80.42*/(""" """),_display_(/*80.44*/collaborator),format.raw/*80.56*/("""
              """),format.raw/*81.15*/("""</a>
            </li>
          """)))}),format.raw/*83.12*/("""
        """)))}),format.raw/*84.10*/("""
        """),_display_(/*85.10*/helper/*85.16*/.html.dropdown("Sort", flat = true)/*85.51*/{_display_(Seq[Any](format.raw/*85.52*/("""
          """),format.raw/*86.11*/("""<li>
            <a href=""""),_display_(/*87.23*/condition/*87.32*/.copy(sort="created",  direction="desc").toURL),format.raw/*87.78*/("""">
            """),_display_(/*88.14*/helper/*88.20*/.html.checkicon(condition.sort == "created"  && condition.direction == "desc")),format.raw/*88.98*/(""" """),format.raw/*88.99*/("""Newest
            </a>
          </li>
          <li>
            <a href=""""),_display_(/*92.23*/condition/*92.32*/.copy(sort="created",  direction="asc" ).toURL),format.raw/*92.78*/("""">
            """),_display_(/*93.14*/helper/*93.20*/.html.checkicon(condition.sort == "created"  && condition.direction == "asc")),format.raw/*93.97*/(""" """),format.raw/*93.98*/("""Oldest
            </a>
          </li>
          <li>
            <a href=""""),_display_(/*97.23*/condition/*97.32*/.copy(sort="comments", direction="desc").toURL),format.raw/*97.78*/("""">
            """),_display_(/*98.14*/helper/*98.20*/.html.checkicon(condition.sort == "comments"  && condition.direction == "desc")),format.raw/*98.99*/(""" """),format.raw/*98.100*/("""Most commented
            </a>
          </li>
          <li>
            <a href=""""),_display_(/*102.23*/condition/*102.32*/.copy(sort="comments", direction="asc" ).toURL),format.raw/*102.78*/("""">
            """),_display_(/*103.14*/helper/*103.20*/.html.checkicon(condition.sort == "comments"  && condition.direction == "asc")),format.raw/*103.98*/(""" """),format.raw/*103.99*/("""Least commented
            </a>
          </li>
          <li>
            <a href=""""),_display_(/*107.23*/condition/*107.32*/.copy(sort="updated",  direction="desc").toURL),format.raw/*107.78*/("""">
            """),_display_(/*108.14*/helper/*108.20*/.html.checkicon(condition.sort == "updated"  && condition.direction == "desc")),format.raw/*108.98*/(""" """),format.raw/*108.99*/("""Recently updated
            </a>
          </li>
          <li>
            <a href=""""),_display_(/*112.23*/condition/*112.32*/.copy(sort="updated",  direction="asc" ).toURL),format.raw/*112.78*/("""">
            """),_display_(/*113.14*/helper/*113.20*/.html.checkicon(condition.sort == "updated"  && condition.direction == "asc")),format.raw/*113.97*/(""" """),format.raw/*113.98*/("""Least recently updated
            </a>
          </li>
        """)))}),format.raw/*116.10*/("""
      """),format.raw/*117.7*/("""</div>
      """),_display_(/*118.8*/if(hasWritePermission)/*118.30*/{_display_(Seq[Any](format.raw/*118.31*/("""
        """),format.raw/*119.9*/("""<div class="pull-right" id="table-issues-batchedit">
          """),_display_(/*120.12*/helper/*120.18*/.html.dropdown("Mark as", flat = true)/*120.56*/ {_display_(Seq[Any](format.raw/*120.58*/("""
            """),format.raw/*121.13*/("""<li><a href="javascript:void(0);" class="toggle-state" data-id="open">Open</a></li>
            <li><a href="javascript:void(0);" class="toggle-state" data-id="close">Close</a></li>
          """)))}),format.raw/*123.12*/("""
          """),_display_(/*124.12*/helper/*124.18*/.html.dropdown("Label", flat = true)/*124.54*/ {_display_(Seq[Any](format.raw/*124.56*/("""
            """),_display_(/*125.14*/labels/*125.20*/.map/*125.24*/ { label =>_display_(Seq[Any](format.raw/*125.35*/("""
              """),format.raw/*126.15*/("""<li>
                <a href="javascript:void(0);" class="toggle-label" data-id=""""),_display_(/*127.78*/label/*127.83*/.labelId),format.raw/*127.91*/("""">
                  <i class="icon-white"></i>
                  <span class="label" style="background-color: #"""),_display_(/*129.66*/label/*129.71*/.color),format.raw/*129.77*/(""";">&nbsp;</span>
                  """),_display_(/*130.20*/label/*130.25*/.labelName),format.raw/*130.35*/("""
                """),format.raw/*131.17*/("""</a>
              </li>
            """)))}),format.raw/*133.14*/("""
          """)))}),format.raw/*134.12*/("""
          """),_display_(/*135.12*/helper/*135.18*/.html.dropdown("Milestone", flat = true)/*135.58*/ {_display_(Seq[Any](format.raw/*135.60*/("""
            """),format.raw/*136.13*/("""<li><a href="javascript:void(0);" class="toggle-milestone" data-id="">No milestone</a></li>
            """),_display_(/*137.14*/milestones/*137.24*/.filter(_.closedDate.isEmpty).map/*137.57*/ { milestone =>_display_(Seq[Any](format.raw/*137.72*/("""
              """),format.raw/*138.15*/("""<li><a href="javascript:void(0);" class="toggle-milestone" data-id=""""),_display_(/*138.84*/milestone/*138.93*/.milestoneId),format.raw/*138.105*/("""">"""),_display_(/*138.108*/milestone/*138.117*/.title),format.raw/*138.123*/("""</a></li>
            """)))}),format.raw/*139.14*/("""
          """)))}),format.raw/*140.12*/("""
          """),_display_(/*141.12*/helper/*141.18*/.html.dropdown("Assignee", flat = true)/*141.57*/ {_display_(Seq[Any](format.raw/*141.59*/("""
            """),format.raw/*142.13*/("""<li><a href="javascript:void(0);" class="toggle-assign" data-name=""><i class="icon-remove-circle"></i> Clear assignee</a></li>
            """),_display_(/*143.14*/collaborators/*143.27*/.map/*143.31*/ { collaborator =>_display_(Seq[Any](format.raw/*143.49*/("""
              """),format.raw/*144.15*/("""<li><a href="javascript:void(0);" class="toggle-assign" data-name=""""),_display_(/*144.83*/collaborator),format.raw/*144.95*/(""""><i class="icon-white"></i>"""),_display_(/*144.124*/avatar(collaborator, 20)),format.raw/*144.148*/(""" """),_display_(/*144.150*/collaborator),format.raw/*144.162*/("""</a></li>
            """)))}),format.raw/*145.14*/("""
          """)))}),format.raw/*146.12*/("""
        """),format.raw/*147.9*/("""</div>
      """)))}),format.raw/*148.8*/("""
    """),format.raw/*149.5*/("""</th>
  </tr>
  """),_display_(/*151.4*/if(issues.isEmpty)/*151.22*/{_display_(Seq[Any](format.raw/*151.23*/("""
    """),format.raw/*152.5*/("""<tr>
      <td style="padding: 20px; background-color: #eee; text-align: center;">
        """),_display_(/*154.10*/if(target == "issues")/*154.32*/{_display_(Seq[Any](format.raw/*154.33*/("""
          """),format.raw/*155.11*/("""No issues to show.
        """)))}/*156.11*/else/*156.16*/{_display_(Seq[Any](format.raw/*156.17*/("""
          """),format.raw/*157.11*/("""No pull requests to show.
        """)))}),format.raw/*158.10*/("""
        """),_display_(/*159.10*/if(condition.labels.nonEmpty || condition.milestoneId.isDefined)/*159.74*/{_display_(Seq[Any](format.raw/*159.75*/("""
          """),format.raw/*160.11*/("""<a href=""""),_display_(/*160.21*/condition/*160.30*/.copy(labels = Set.empty, milestoneId = None).toURL),format.raw/*160.81*/("""">Clear active filters.</a>
        """)))}/*161.11*/else/*161.16*/{_display_(Seq[Any](format.raw/*161.17*/("""
          """),_display_(/*162.12*/if(repository.isDefined)/*162.36*/{_display_(Seq[Any](format.raw/*162.37*/("""
            """),_display_(/*163.14*/if(target == "issues")/*163.36*/{_display_(Seq[Any](format.raw/*163.37*/("""
              """),format.raw/*164.15*/("""<a href=""""),_display_(/*164.25*/url(repository.get)),format.raw/*164.44*/("""/issues/new">Create a new issue.</a>
            """)))}/*165.15*/else/*165.20*/{_display_(Seq[Any](format.raw/*165.21*/("""
              """),format.raw/*166.15*/("""<a href=""""),_display_(/*166.25*/url(repository.get)),format.raw/*166.44*/("""/compare">Create a new pull request.</a>
            """)))}),format.raw/*167.14*/("""
          """)))}),format.raw/*168.12*/("""
        """)))}),format.raw/*169.10*/("""
      """),format.raw/*170.7*/("""</td>
    </tr>
  """)))}),format.raw/*172.4*/("""
  """),_display_(/*173.4*/issues/*173.10*/.map/*173.14*/ { case IssueInfo(issue, labels, milestone, commentCount) =>_display_(Seq[Any](format.raw/*173.74*/("""
    """),format.raw/*174.5*/("""<tr>
      <td style="padding-top: 15px; padding-bottom: 15px;">
        """),_display_(/*176.10*/if(hasWritePermission)/*176.32*/{_display_(Seq[Any](format.raw/*176.33*/("""
          """),format.raw/*177.11*/("""<input type="checkbox" value=""""),_display_(/*177.42*/issue/*177.47*/.issueId),format.raw/*177.55*/(""""/>
        """)))}),format.raw/*178.10*/("""
        """),format.raw/*179.9*/("""<img src=""""),_display_(/*179.20*/assets),format.raw/*179.26*/("""/common/images/issue-"""),_display_(/*179.48*/(if(issue.closed) "closed" else "open")),format.raw/*179.87*/(""".png" style="margin-right: 20px;"/>
        """),_display_(/*180.10*/if(repository.isEmpty)/*180.32*/{_display_(Seq[Any](format.raw/*180.33*/("""
          """),format.raw/*181.11*/("""<a href=""""),_display_(/*181.21*/path),format.raw/*181.25*/("""/"""),_display_(/*181.27*/issue/*181.32*/.userName),format.raw/*181.41*/("""/"""),_display_(/*181.43*/issue/*181.48*/.repositoryName),format.raw/*181.63*/("""">"""),_display_(/*181.66*/issue/*181.71*/.repositoryName),format.raw/*181.86*/("""</a>&nbsp;&#xFF65;
        """)))}),format.raw/*182.10*/("""
        """),_display_(/*183.10*/if(target == "issues")/*183.32*/{_display_(Seq[Any](format.raw/*183.33*/("""
          """),format.raw/*184.11*/("""<a href=""""),_display_(/*184.21*/path),format.raw/*184.25*/("""/"""),_display_(/*184.27*/issue/*184.32*/.userName),format.raw/*184.41*/("""/"""),_display_(/*184.43*/issue/*184.48*/.repositoryName),format.raw/*184.63*/("""/issues/"""),_display_(/*184.72*/issue/*184.77*/.issueId),format.raw/*184.85*/("""" class="issue-title">"""),_display_(/*184.108*/issue/*184.113*/.title),format.raw/*184.119*/("""</a>
        """)))}/*185.11*/else/*185.16*/{_display_(Seq[Any](format.raw/*185.17*/("""
          """),format.raw/*186.11*/("""<a href=""""),_display_(/*186.21*/path),format.raw/*186.25*/("""/"""),_display_(/*186.27*/issue/*186.32*/.userName),format.raw/*186.41*/("""/"""),_display_(/*186.43*/issue/*186.48*/.repositoryName),format.raw/*186.63*/("""/pull/"""),_display_(/*186.70*/issue/*186.75*/.issueId),format.raw/*186.83*/("""" class="issue-title">"""),_display_(/*186.106*/issue/*186.111*/.title),format.raw/*186.117*/("""</a>
        """)))}),format.raw/*187.10*/("""
        """),_display_(/*188.10*/labels/*188.16*/.map/*188.20*/ { label =>_display_(Seq[Any](format.raw/*188.31*/("""
          """),format.raw/*189.11*/("""<span class="label-color small" style="background-color: #"""),_display_(/*189.70*/label/*189.75*/.color),format.raw/*189.81*/("""; color: #"""),_display_(/*189.92*/label/*189.97*/.fontColor),format.raw/*189.107*/("""; padding-left: 4px; padding-right: 4px">"""),_display_(/*189.149*/label/*189.154*/.labelName),format.raw/*189.164*/("""</span>
        """)))}),format.raw/*190.10*/("""
        """),format.raw/*191.9*/("""<span class="pull-right small">
          """),_display_(/*192.12*/issue/*192.17*/.assignedUserName.map/*192.38*/ { userName =>_display_(Seq[Any](format.raw/*192.52*/("""
            """),_display_(/*193.14*/avatar(userName, 20, tooltip = true)),format.raw/*193.50*/("""
          """)))}),format.raw/*194.12*/("""
          """),_display_(/*195.12*/if(commentCount > 0)/*195.32*/{_display_(Seq[Any](format.raw/*195.33*/("""
            """),format.raw/*196.13*/("""<a href=""""),_display_(/*196.23*/path),format.raw/*196.27*/("""/"""),_display_(/*196.29*/issue/*196.34*/.userName),format.raw/*196.43*/("""/"""),_display_(/*196.45*/issue/*196.50*/.repositoryName),format.raw/*196.65*/("""/issues/"""),_display_(/*196.74*/issue/*196.79*/.issueId),format.raw/*196.87*/("""" class="issue-comment-count">
              <img src=""""),_display_(/*197.26*/assets),format.raw/*197.32*/("""/common/images/comment-active.png"> """),_display_(/*197.69*/commentCount),format.raw/*197.81*/("""
            """),format.raw/*198.13*/("""</a>
          """)))}/*199.13*/else/*199.18*/{_display_(Seq[Any](format.raw/*199.19*/("""
            """),format.raw/*200.13*/("""<a href=""""),_display_(/*200.23*/path),format.raw/*200.27*/("""/"""),_display_(/*200.29*/issue/*200.34*/.userName),format.raw/*200.43*/("""/"""),_display_(/*200.45*/issue/*200.50*/.repositoryName),format.raw/*200.65*/("""/issues/"""),_display_(/*200.74*/issue/*200.79*/.issueId),format.raw/*200.87*/("""" class="issue-comment-count" style="color: silver;">
              <img src=""""),_display_(/*201.26*/assets),format.raw/*201.32*/("""/common/images/comment.png"> """),_display_(/*201.62*/commentCount),format.raw/*201.74*/("""
            """),format.raw/*202.13*/("""</a>
          """)))}),format.raw/*203.12*/("""
        """),format.raw/*204.9*/("""</span>
        <div class="small muted" style="margin-left: 40px; margin-top: 5px;">
          #"""),_display_(/*206.13*/issue/*206.18*/.issueId),format.raw/*206.26*/(""" """),format.raw/*206.27*/("""opened  """),_display_(/*206.36*/helper/*206.42*/.html.datetimeago(issue.registeredDate)),format.raw/*206.81*/(""" """),format.raw/*206.82*/("""by """),_display_(/*206.86*/user(issue.openedUserName, styleClass="username")),format.raw/*206.135*/("""
          """),_display_(/*207.12*/milestone/*207.21*/.map/*207.25*/ { milestone =>_display_(Seq[Any](format.raw/*207.40*/("""
            """),format.raw/*208.13*/("""<span style="margin: 20px;"><a href=""""),_display_(/*208.51*/condition/*208.60*/.copy(milestoneId = Some(Some(1))).toURL),format.raw/*208.100*/("""" class="username"><img src=""""),_display_(/*208.130*/assets),format.raw/*208.136*/("""/common/images/milestone.png"> """),_display_(/*208.168*/milestone),format.raw/*208.177*/("""</a></span>
          """)))}),format.raw/*209.12*/("""
        """),format.raw/*210.9*/("""</div>
      </td>
    </tr>
  """)))}),format.raw/*213.4*/("""
"""),format.raw/*214.1*/("""</table>
<div class="pull-right">
  """),_display_(/*216.4*/helper/*216.10*/.html.paginator(page, (if(condition.state == "open") openCount else closedCount), service.IssuesService.IssueLimit, 10, condition.toURL)),format.raw/*216.146*/("""
"""),format.raw/*217.1*/("""</div>

"""))}
  }

  def render(target:String,issues:List[service.IssuesService.IssueInfo],page:Int,openCount:Int,closedCount:Int,condition:service.IssuesService.IssueSearchCondition,collaborators:List[String],milestones:List[model.Milestone],labels:List[model.Label],repository:Option[service.RepositoryService.RepositoryInfo],hasWritePermission:Boolean,context:app.Context): play.twirl.api.HtmlFormat.Appendable = apply(target,issues,page,openCount,closedCount,condition,collaborators,milestones,labels,repository,hasWritePermission)(context)

  def f:((String,List[service.IssuesService.IssueInfo],Int,Int,Int,service.IssuesService.IssueSearchCondition,List[String],List[model.Milestone],List[model.Label],Option[service.RepositoryService.RepositoryInfo],Boolean) => (app.Context) => play.twirl.api.HtmlFormat.Appendable) = (target,issues,page,openCount,closedCount,condition,collaborators,milestones,labels,repository,hasWritePermission) => (context) => apply(target,issues,page,openCount,closedCount,condition,collaborators,milestones,labels,repository,hasWritePermission)(context)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 14 00:04:12 CST 2015
                  SOURCE: /home/justin/Development/apps/gitbucket/src/main/twirl/issues/listparts.scala.html
                  HASH: f105ac804551506250c46d28f6f59532fb92a2c3
                  MATRIX: 564->1|1159->430|1187->512|1219->518|1250->540|1289->541|1319->544|1366->564|1382->571|1446->614|1513->654|1540->660|1632->725|1659->731|1872->914|1900->915|2125->1113|2163->1142|2202->1143|2231->1144|2271->1153|2307->1162|2325->1171|2374->1198|2425->1222|2452->1228|2506->1255|2569->1297|2615->1316|2645->1325|2674->1326|2761->1386|2801->1417|2840->1418|2869->1419|2909->1428|2945->1437|2963->1446|3014->1475|3065->1499|3092->1505|3148->1534|3214->1578|3260->1597|3292->1608|3321->1609|3448->1709|3463->1715|3509->1752|3549->1754|3588->1766|3610->1779|3623->1783|3679->1801|3720->1814|3776->1843|3794->1852|3911->1947|3958->1967|3973->1973|4049->2028|4094->2046|4139->2070|4168->2072|4201->2084|4244->2099|4309->2133|4350->2143|4387->2153|4402->2159|4447->2195|4487->2197|4526->2209|4541->2215|4554->2219|4603->2230|4644->2243|4700->2272|4718->2281|4885->2426|4932->2446|4947->2452|5027->2511|5072->2528|5132->2561|5146->2566|5173->2572|5260->2632|5274->2637|5305->2647|5348->2662|5413->2696|5454->2706|5491->2716|5506->2722|5555->2762|5595->2764|5634->2775|5688->2802|5706->2811|5764->2848|5809->2866|5824->2872|5897->2924|5926->2925|6022->2994|6041->3004|6083->3037|6136->3052|6177->3065|6233->3094|6251->3103|6332->3163|6379->3183|6394->3189|6490->3264|6520->3266|6539->3275|6567->3281|6610->3296|6675->3330|6716->3340|6753->3350|6768->3356|6816->3395|6856->3397|6895->3409|6917->3422|6930->3426|6986->3444|7027->3457|7083->3486|7101->3495|7164->3537|7211->3557|7226->3563|7304->3620|7349->3638|7394->3662|7423->3664|7456->3676|7499->3691|7564->3725|7605->3735|7642->3745|7657->3751|7701->3786|7740->3787|7779->3798|7833->3825|7851->3834|7918->3880|7961->3896|7976->3902|8075->3980|8104->3981|8208->4058|8226->4067|8293->4113|8336->4129|8351->4135|8449->4212|8478->4213|8582->4290|8600->4299|8667->4345|8710->4361|8725->4367|8825->4446|8855->4447|8968->4532|8987->4541|9055->4587|9099->4603|9115->4609|9215->4687|9245->4688|9359->4774|9378->4783|9446->4829|9490->4845|9506->4851|9606->4929|9636->4930|9751->5017|9770->5026|9838->5072|9882->5088|9898->5094|9997->5171|10027->5172|10124->5237|10159->5244|10200->5258|10232->5280|10272->5281|10309->5290|10401->5354|10417->5360|10465->5398|10506->5400|10548->5413|10773->5606|10813->5618|10829->5624|10875->5660|10916->5662|10958->5676|10974->5682|10988->5686|11038->5697|11082->5712|11192->5794|11207->5799|11237->5807|11378->5920|11393->5925|11421->5931|11485->5967|11500->5972|11532->5982|11578->5999|11648->6037|11692->6049|11732->6061|11748->6067|11798->6107|11839->6109|11881->6122|12014->6227|12034->6237|12077->6270|12131->6285|12175->6300|12272->6369|12291->6378|12326->6390|12358->6393|12378->6402|12407->6408|12462->6431|12506->6443|12546->6455|12562->6461|12611->6500|12652->6502|12694->6515|12863->6656|12886->6669|12900->6673|12957->6691|13001->6706|13097->6774|13131->6786|13189->6815|13236->6839|13267->6841|13302->6853|13357->6876|13401->6888|13438->6897|13483->6911|13516->6916|13560->6933|13588->6951|13628->6952|13661->6957|13781->7049|13813->7071|13853->7072|13893->7083|13941->7112|13955->7117|13995->7118|14035->7129|14102->7164|14140->7174|14214->7238|14254->7239|14294->7250|14332->7260|14351->7269|14424->7320|14481->7358|14495->7363|14535->7364|14575->7376|14609->7400|14649->7401|14691->7415|14723->7437|14763->7438|14807->7453|14845->7463|14886->7482|14956->7533|14970->7538|15010->7539|15054->7554|15092->7564|15133->7583|15219->7637|15263->7649|15305->7659|15340->7666|15390->7685|15421->7689|15437->7695|15451->7699|15550->7759|15583->7764|15685->7838|15717->7860|15757->7861|15797->7872|15856->7903|15871->7908|15901->7916|15946->7929|15983->7938|16022->7949|16050->7955|16100->7977|16161->8016|16234->8061|16266->8083|16306->8084|16346->8095|16384->8105|16410->8109|16440->8111|16455->8116|16486->8125|16516->8127|16531->8132|16568->8147|16599->8150|16614->8155|16651->8170|16711->8198|16749->8208|16781->8230|16821->8231|16861->8242|16899->8252|16925->8256|16955->8258|16970->8263|17001->8272|17031->8274|17046->8279|17083->8294|17120->8303|17135->8308|17165->8316|17217->8339|17233->8344|17262->8350|17296->8365|17310->8370|17350->8371|17390->8382|17428->8392|17454->8396|17484->8398|17499->8403|17530->8412|17560->8414|17575->8419|17612->8434|17647->8441|17662->8446|17692->8454|17744->8477|17760->8482|17789->8488|17835->8502|17873->8512|17889->8518|17903->8522|17953->8533|17993->8544|18080->8603|18095->8608|18123->8614|18162->8625|18177->8630|18210->8640|18281->8682|18297->8687|18330->8697|18379->8714|18416->8723|18487->8766|18502->8771|18533->8792|18586->8806|18628->8820|18686->8856|18730->8868|18770->8880|18800->8900|18840->8901|18882->8914|18920->8924|18946->8928|18976->8930|18991->8935|19022->8944|19052->8946|19067->8951|19104->8966|19141->8975|19156->8980|19186->8988|19270->9044|19298->9050|19363->9087|19397->9099|19439->9112|19475->9129|19489->9134|19529->9135|19571->9148|19609->9158|19635->9162|19665->9164|19680->9169|19711->9178|19741->9180|19756->9185|19793->9200|19830->9209|19845->9214|19875->9222|19982->9301|20010->9307|20068->9337|20102->9349|20144->9362|20192->9378|20229->9387|20355->9485|20370->9490|20400->9498|20430->9499|20467->9508|20483->9514|20544->9553|20574->9554|20606->9558|20678->9607|20718->9619|20737->9628|20751->9632|20805->9647|20847->9660|20913->9698|20932->9707|20995->9747|21054->9777|21083->9783|21144->9815|21176->9824|21231->9847|21268->9856|21331->9888|21360->9889|21424->9926|21440->9932|21599->10068|21628->10069
                  LINES: 13->1|28->11|29->15|30->16|30->16|30->16|31->17|32->18|32->18|32->18|33->19|33->19|34->20|34->20|38->24|39->25|44->30|44->30|44->30|44->30|44->30|44->30|44->30|44->30|45->31|45->31|45->31|45->31|46->32|46->32|46->32|48->34|48->34|48->34|48->34|48->34|48->34|48->34|48->34|49->35|49->35|49->35|49->35|50->36|50->36|50->36|54->40|54->40|54->40|54->40|55->41|55->41|55->41|55->41|56->42|57->43|57->43|57->43|58->44|58->44|58->44|59->45|59->45|59->45|59->45|60->46|62->48|63->49|64->50|64->50|64->50|64->50|65->51|65->51|65->51|65->51|66->52|67->53|67->53|67->53|68->54|68->54|68->54|69->55|69->55|69->55|69->55|70->56|70->56|70->56|71->57|73->59|74->60|75->61|75->61|75->61|75->61|76->62|77->63|77->63|77->63|78->64|78->64|78->64|78->64|81->67|81->67|81->67|81->67|82->68|83->69|83->69|83->69|84->70|84->70|84->70|84->70|84->70|84->70|85->71|87->73|88->74|89->75|89->75|89->75|89->75|90->76|90->76|90->76|90->76|91->77|92->78|92->78|92->78|93->79|93->79|93->79|94->80|94->80|94->80|94->80|95->81|97->83|98->84|99->85|99->85|99->85|99->85|100->86|101->87|101->87|101->87|102->88|102->88|102->88|102->88|106->92|106->92|106->92|107->93|107->93|107->93|107->93|111->97|111->97|111->97|112->98|112->98|112->98|112->98|116->102|116->102|116->102|117->103|117->103|117->103|117->103|121->107|121->107|121->107|122->108|122->108|122->108|122->108|126->112|126->112|126->112|127->113|127->113|127->113|127->113|130->116|131->117|132->118|132->118|132->118|133->119|134->120|134->120|134->120|134->120|135->121|137->123|138->124|138->124|138->124|138->124|139->125|139->125|139->125|139->125|140->126|141->127|141->127|141->127|143->129|143->129|143->129|144->130|144->130|144->130|145->131|147->133|148->134|149->135|149->135|149->135|149->135|150->136|151->137|151->137|151->137|151->137|152->138|152->138|152->138|152->138|152->138|152->138|152->138|153->139|154->140|155->141|155->141|155->141|155->141|156->142|157->143|157->143|157->143|157->143|158->144|158->144|158->144|158->144|158->144|158->144|158->144|159->145|160->146|161->147|162->148|163->149|165->151|165->151|165->151|166->152|168->154|168->154|168->154|169->155|170->156|170->156|170->156|171->157|172->158|173->159|173->159|173->159|174->160|174->160|174->160|174->160|175->161|175->161|175->161|176->162|176->162|176->162|177->163|177->163|177->163|178->164|178->164|178->164|179->165|179->165|179->165|180->166|180->166|180->166|181->167|182->168|183->169|184->170|186->172|187->173|187->173|187->173|187->173|188->174|190->176|190->176|190->176|191->177|191->177|191->177|191->177|192->178|193->179|193->179|193->179|193->179|193->179|194->180|194->180|194->180|195->181|195->181|195->181|195->181|195->181|195->181|195->181|195->181|195->181|195->181|195->181|195->181|196->182|197->183|197->183|197->183|198->184|198->184|198->184|198->184|198->184|198->184|198->184|198->184|198->184|198->184|198->184|198->184|198->184|198->184|198->184|199->185|199->185|199->185|200->186|200->186|200->186|200->186|200->186|200->186|200->186|200->186|200->186|200->186|200->186|200->186|200->186|200->186|200->186|201->187|202->188|202->188|202->188|202->188|203->189|203->189|203->189|203->189|203->189|203->189|203->189|203->189|203->189|203->189|204->190|205->191|206->192|206->192|206->192|206->192|207->193|207->193|208->194|209->195|209->195|209->195|210->196|210->196|210->196|210->196|210->196|210->196|210->196|210->196|210->196|210->196|210->196|210->196|211->197|211->197|211->197|211->197|212->198|213->199|213->199|213->199|214->200|214->200|214->200|214->200|214->200|214->200|214->200|214->200|214->200|214->200|214->200|214->200|215->201|215->201|215->201|215->201|216->202|217->203|218->204|220->206|220->206|220->206|220->206|220->206|220->206|220->206|220->206|220->206|220->206|221->207|221->207|221->207|221->207|222->208|222->208|222->208|222->208|222->208|222->208|222->208|222->208|223->209|224->210|227->213|228->214|230->216|230->216|230->216|231->217
                  -- GENERATED --
              */
          