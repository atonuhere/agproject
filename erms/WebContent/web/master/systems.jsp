<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://bibeault.org/tld/ccc" prefix="ccc" %>
<ccc:constantsMap className="com.gfs.erm.web.common.WebConstants" var="Constants"/> 
<c:set value="${Constants.RECORDS_PER_PAGE}" var="pageSize" />
<c:set value="${pageSize * (page- 1)}" var="counter" />

<c:if test="${control eq 'incidentLog'}">
<div class="content clearfix">
	<a href="${rootpath}incident/add.html" class="btn btn-primary pull-right">Add</a>
</div>
<h4 class="title">Incident Logs</h4>
<div class="content clearfix">
 
	<div id="dispTable_List">
		${pagingString}
		<table class="table table-striped overide-table" data-effect="fade">
			<thead>
			<tr>
				<th>#</th>	
				<th>Inc. Number</th>	
				<th>Branch</th>
				<th>Inc. Date</th>
				<th>Location</th>
				<th>Type</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
			</thead>
			<tbody>
			<c:choose>
			<c:when test="${fn:length(dataList) gt 0}">
			<c:forEach items="${dataList}" var="item" varStatus="status">
					<tr id="tr${item.id}">
						<td>${status.count + counter}</td>
						<td>${item.incNumber}</td>
						<td>${item.branchName}</td>
						<td>${item.incidentDate}</td>
						<td>${item.incLocation}</td>
						<td>${item.incidentType}</td>
						<td>${item.incidentStatus}</td>
						<td>
						<ul style="list-style: none;">
							<li><a href="${rootpath}incident/view/${item.id}.html" title="view"><i class="icon-check"></i></a></li>
							<li><a href="${rootpath}incident/update/${item.id}.html" title="edit"><i class="icon-edit"></i></a></li>
							<li><a href="${rootpath}incident/delete/${item.id}.html" title="remove" class="delete"><i class="icon-remove"></i></a></li>
						</ul>					
						</td>
					</tr>
			</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="8" class="error">No Record(s) found</td>
				</tr>
			</c:otherwise>
			</c:choose>
			</tbody>
		</table>
		${pagingString}
		
	</div>
	<input type="hidden" id="ajaxPath" value="${ajaxPath}" />
	<input type="hidden" id="pageNum" value="${page}" />
	<input type="hidden" id="searchString" value="${searchString}" />		
	<input type="hidden" id="sort" value="${sort}" />		
	<input type="hidden" id="order" value="${order}" />	
</div>
</c:if>

<c:if test="${control eq 'incidentAssign'}">
	<h4 class="title">Incident Logs for Assignment</h4>
	<div class="content clearfix">
		<table class="table table-striped overide-table" data-effect="fade">
		<thead>
		<tr>
			<th>#</th>	
			<th>Inc. Number</th>	
			<th>Branch</th>
			<th>Inc. Date</th>
			<th>Location</th>
			<th>Type</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
		</thead>
		<tbody>
		<c:choose>
		<c:when test="${fn:length(dataList) gt 0}">
		<c:forEach items="${dataList}" var="item" varStatus="status">
		
				<tr id="tr${item.id}">
					<td>${status.count + counter}</td>
					<td>${item.incNumber}</td>
					<td>${item.branchName}</td>
					<td>${item.incidentDate}</td>
					<td>${item.incLocation}</td>
					<td>${item.incidentType}</td>
					<td>${item.incidentStatus}</td>
					<td>
						<ul>
							<li>
								<a href="${rootpath}ajax/assignMember.html" class="btn btn-mini" data-toggle="modal" data-target="#myModal"> 
									<i class="fa fa-search"></i>
								</a>
							</li>
						</ul>
					</td>
				</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="8" class="error">No Record(s) found</td>
			</tr>
		</c:otherwise>
		</c:choose>
		</tbody>
		</table>
	</div>
</c:if>



<c:if test="${control eq 'submitInvestigationReports'}">
	<h4 class="title">Submit Investigation Report</h4>
	<div class="content clearfix">
		<table class="table table-striped overide-table" data-effect="fade">
		<thead>
		<tr>
			<th>#</th>	
			<th>Inc. Number</th>	
			<th>Branch</th>
			<th>Inc. Date</th>
			<th>Location</th>
			<th>Type</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
		</thead>
		<tbody>
		<c:choose>
		<c:when test="${fn:length(dataList) gt 0}">
		<c:forEach items="${dataList}" var="item" varStatus="status">
		
				<tr id="tr${item.id}">
					<td>${status.count + counter}</td>
					<td>${item.incNumber}</td>
					<td>${item.branchName}</td>
					<td>${item.incidentDate}</td>
					<td>${item.incLocation}</td>
					<td>${item.incidentType}</td>
					<td>${item.incidentStatus}</td>
					<td>
						<ul>
							<li><a href="${rootpath}incident/submitInvestigationReport/${item.id}.html" title="view"><i class="icon-check"></i></a></li>
						</ul>
					</td>
				</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="8" class="error">No Record(s) found</td>
			</tr>
		</c:otherwise>
		</c:choose>
		</tbody>
		</table>
	</div>
</c:if>



<c:if test="${control eq 'reviewInvestigationReports'}">
	<h4 class="title">Review Investigation Report</h4>
	<div class="content clearfix">
		<table class="table table-striped overide-table" data-effect="fade">
		<thead>
		<tr>
			<th>#</th>	
			<th>Inc. Number</th>	
			<th>Branch</th>
			<th>Inc. Date</th>
			<th>Location</th>
			<th>Type</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
		</thead>
		<tbody>
		<c:choose>
		<c:when test="${fn:length(dataList) gt 0}">
		<c:forEach items="${dataList}" var="item" varStatus="status">
		
				<tr id="tr${item.id}">
					<td>${status.count + counter}</td>
					<td>${item.incNumber}</td>
					<td>${item.branchName}</td>
					<td>${item.incidentDate}</td>
					<td>${item.incLocation}</td>
					<td>${item.incidentType}</td>
					<td>${item.incidentStatus}</td>
					<td>
						<ul>
							<li><a href="${rootpath}incident/viewReport/${item.id}.html" title="view"><i class="icon-check"></i></a></li>
						</ul>
					</td>
				</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="8" class="error">No Record(s) found</td>
			</tr>
		</c:otherwise>
		</c:choose>
		</tbody>
		</table>
	</div>
</c:if>
