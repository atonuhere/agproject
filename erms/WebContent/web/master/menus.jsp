<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://bibeault.org/tld/ccc" prefix="ccc" %>
<ccc:constantsMap className="com.gfs.erm.web.common.WebConstants" var="Constants"/> 
<c:set value="${Constants.RECORDS_PER_PAGE}" var="pageSize" />
<c:set value="${pageSize * (page- 1)}" var="counter" />

<div class="content clearfix">
	<a href="${rootpath}master/add/menu.html" class="btn btn-primary pull-right">Add</a>
</div>
<h4 class="title">Roles</h4>
<div class="content clearfix">
 
	<div id="dispTable_List">
		${pagingString}
		<table class="table table-striped overide-table" data-effect="fade">
			<thead>
			<tr>
				<th>#</th>	
				<th>Menu Name</th>	
				<th>Role</th>
				<th>Action</th>
			</tr>
			</thead>
			<tbody>
			<c:choose>
			<c:when test="${fn:length(dataList) gt 0}">
			<c:forEach items="${dataList}" var="item" varStatus="status">
					<tr id="tr${item.id}">
						<td>${status.count + counter}</td>
						<td>${item.menuName}</td>
						<td>${item.roleName}</td>
						<td>
						<ul style="list-style: none;">
							<li><a href="${rootpath}master/view/menu/${item.id}.html" title="view"><i class="icon-check"></i></a></li>
							<li><a href="${rootpath}master/update/menu/${item.id}.html" title="edit"><i class="icon-edit"></i></a></li>
							<li><a href="${rootpath}master/delete/menu/${item.id}.html" title="remove" class="delete"><i class="icon-remove"></i></a></li>
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

