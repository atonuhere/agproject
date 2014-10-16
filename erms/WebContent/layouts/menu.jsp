<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<c:if test="${menu eq 'incident'}" >

<div class="widget">
   <h4 class="title">
       <span>Incident Reporting</span>
    </h4>
    
    <ul class="nav nav-tabs nav-stacked">
		<li><a href="${rootpath}incident/add.html" class="${(submenu == 'incidentAdd') ? '\"active\"' : ''}">Report Incident</a></li>
		<li><a href="${rootpath}incident/assignInvestigation.html" class="${(submenu == 'incidentAssign') ? '\"active\"' : ''}">Assign for  investigation</a></li>
		<li><a href="${rootpath}incident/index.html" class="${(submenu == 'incidentLog') ? '\"active\"' : ''}">Incident Logs</a></li>
    </ul>
</div>

<div class="widget">
   <h4 class="title">
       <span>Investigation of Incident</span>
    </h4>
    <ul class="nav nav-tabs nav-stacked">
		<li><a href="${rootpath}incident/submitInvestigationReports.html" class="${(submenu eq 'submitInvestigationReports') ? 'active': '' }">Submit Report</a></li>
		<li><a href="${rootpath}incident/reviewInvestigationReports.html" class="${(submenu eq 'reviewInvestigationReports') ? 'active': '' }">Review Report</a></li>		
    </ul>
</div>

<div class="widget">
   <h4 class="title">
       <span>Follow-up of Incident Investigation</span>
    </h4>
    <ul class="nav nav-tabs nav-stacked">
		<li><a href="#">CAR / PAR</a></li>
		<li><a href="#">Closure of Actions Plans</a></li>
		<li><a href="#">Incident Logs</a></li>
    </ul>
</div>
<div class="widget">
   <h4 class="title">
       <span>Incident Analysis</span>
    </h4>
    <ul class="nav nav-tabs nav-stacked">
		<li><a href="#">Analysis of Open Issues</a></li>
		
    </ul>
</div>

</c:if>
<c:if test="${menu eq 'master'}" >
<div class="widget">
   <h4 class="title">
       <span>Master Maintenance</span>
    </h4>
    <ul class="dropdown">
		<li><a href="${rootpath}master/roles.html" class="${(submenu eq 'roles') ? 'active': '' }">Roles</a></li>
		<li><a href="${rootpath}master/menus.html" class="${(submenu eq 'menus') ? 'active': '' }">Menus</a></li>
		<li><a href="${rootpath}master/permissions.html" class="${(submenu eq 'permissions') ? 'active': '' }">Permissions</a></li>
		<li><a href="${rootpath}master/users.html" class="${(submenu eq 'users') ? 'active': '' }">Users</a></li>
		<li><a href="${rootpath}master/systems.html" class="${(submenu eq 'systems') ? 'active': '' }">System Configuration</a></li>
    </ul>
</div>
</c:if>
			
			