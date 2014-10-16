<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ccc" uri="http://bibeault.org/tld/ccc" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<ccc:constantsMap className="com.gfs.erm.web.common.WebConstants" var="Constants"/>
<c:set value="${Constants.DEFAULT_ROWLIST}" var="rowList" scope="request"></c:set>  
<c:set value="${Constants.DISPLAY_GRID_DATE_FORMAT}" var="datefrmt" scope="request"></c:set> 

<div class="upper_content_bg">
	<div class="upper_content_heading" style="">
		<span style="">Incident Logs</span>
	</div>
	<div class="upper_content_button"></div>
</div>

<!-- <div class="row2">	
<a href="${rootpath}incident/jasper/incidentlog?type=PDF" title="Generate PDF" class="btn">PDF</a>
<a href="${rootpath}incident/jasper/incidentlog?type=XLS" title="Generate XLS" class="btn">XLS</a>
<a href="${rootpath}incident/jasper/incidentlog?type=RTF" title="Generate Doc" class="btn">Doc</a>
</div>
-->

<div class="box_content clear">
	
	<div id="dispTable_List">
				
		${pagingString}
		<div class="PrintArea area1 both box_content" style="width:100%">
		<table class="table table-striped table-bordered ">
			<tr>
				<th width="5%">Sl. No.</th>	
				<th width="10%">Inc. Number</th>	
				<th width="10%">Branch</th>
				<th width="10%">Inc. Date</th>
				<th width="15%">Location</th>
				<th width="20%">Type</th>
				<th width="20%">Status</th>
				<th width="10%">Action</th>
			</tr>
			<c:choose>
			<c:when test="${fn:length(dataList) gt 0}">
			<c:forEach items="${dataList}" var="item" varStatus="status">
				<tr id="auditRCA_tr_${item.id}">
					<td>${status.count + counter}</td>
					<td>${item.incNumber}</td>
					<td>${item.branch.name}</td>
					<td><c:set var="incDate" value="${item.incDate}" />
						<fmt:formatDate pattern="${request.viewDtfrmt}" value="${incDate}" /></td>
					<td>${item.incLocation}</td>
					<td>${item.incType.name}</td>
					<td>${item.incstatus.status}</td>
					<td>
					<div class="btn-group">
						
						<c:if test="${item.incstatus.id gt 1}">
							<a href='javascript:void(0);' class='btn btn-mini'	onclick="showITeamMember('${item.id}', '${item.incstatus.id}')"><i class="icon-user"></i> Acknowledge</a>
						</c:if>
						<c:if test="${item.incstatus.id eq 1}">
							<a class="btn btn-mini" href="javascript:void(0);"><i class="icon-user"></i> Not Assign </a>
						</c:if>	
						<a class="btn btn-mini dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret"></span></a>
						<ul class="dropdown-menu">	
							<c:if test="${permissions['All'] || permissions[Constants.VIEW_PERMISSION] }" >			
								<li><a href="javascript:gotoUrl('view/incidentlog/${item.id}')" ><i class="icon-check"></i> View</a></li>
							</c:if>
							<c:if test="${item.incstatus.id le 3}">
								<c:if test="${permissions['All'] || permissions[Constants.EDIT_PERMISSION] }" >
									<li><a href="javascript:gotoUrl('edit/incidentlog/${item.id}')" ><i class="icon-pencil"></i> Edit</a></li>
								</c:if>
							</c:if>	
							<!--<li class="divider"></li>
							<c:if test="${permissions['All'] || permissions[Constants.DELETE_PERMISSION] }" >
								<li><a href="javascript:doAjaxDelete('delete/incidentlog/${item.id}')" ><i class="i"></i>Delete Team</a></li>
							</c:if>
						--></ul>
					</div>
									
					</td>
										
				</tr>
				</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="8" class="error">Not Found</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
		</div>
		<input type="hidden" id="pageNum" value="${page}" />
		${pagingString}
	
	
	</div>
	<input type="hidden" id="ajaxPath" value="${rootpath}incident/incidentReport/incidentlogJson" />	
	<input type="hidden" id="pageNum" value="${page}" />
	<input type="hidden" id="searchString" value="${searchString}" />		
	<input type="hidden" id="sort" value="${sort}" />		
	<input type="hidden" id="order" value="${order}" />	
	
</div>

<div class="modal fade" id="test_modal" style="display:none;">
	<div class="modal-header">
	  <a class="close" data-dismiss="modal">&times;</a>
	  <h4 id="model_title">View Assign Members for Investigation</h4>
	</div>
	<div class="modal-body" id="modal_description" style="padding: 0px 1px;;">
		<div class="row-fluid" id="userlist"></div>
	
	</div>
	<div class="modal-footer">
		<input type="hidden" name="inc_id" id="inc_id" value="" />
		<input type="hidden" name="inc_stat_id" id="inc_stat_id" value="" />
	   	<a href="javascript:void(0)" onclick="closeModal()" class="btn" >Cancel</a>
	</div>
	
</div>

	


<script type="text/javascript">
$(function() {
	ajaxPageLoad(1,'dispTable_List','id','desc');
});



function closeModal(){
	$('#test_modal').modal('hide');
	$('#userlist').empty();
}

function showITeamMember(incid,incstatId){ 
	//alert(incstatId)
	$('#test_modal').modal('show');
	//var url = '${rootpath}ajax/iteammembers';
	var url = '${rootpath}ajax/showInvgMembers';
	$.ajax({
		type :'POST',
		url: url,
		data : {incId : incid, type : 1} ,
		//dataType: 'JSON',	
		cache: false,	//IE fix
		success: function(resp){
			//alert(resp)
			$('#userlist').html(resp);
			$('#inc_stat_id').val(incstatId);
			$('#inc_id').val(incid);
		}

	});
	
}

function iteamacknowledge(id,aprvstat){
	$('#test_modal').modal('show');
	var incStatId = $('#inc_stat_id').val();
	var incId = $('#inc_id').val();
	var setincstId =parseInt(incStatId)+1;
	//alert(incId+'//'+incStatId+'//'+setincstId);
	var url = '${rootpath}incident/incidentReport/acknowledgemem';
	$.ajax({
		type :'POST',
		url: url,
		data : { id : id, status : aprvstat , incId : incId, incStatId : incStatId, setincstId : setincstId} ,
		//dataType: 'JSON',	
		cache: false,	//IE fix
		success: function(resp){
			//alert(resp)
			//$("#gridtable").trigger("reloadGrid");
			ajaxPageLoad(1,'dispTable_List','id','desc');
			closeModal();
			
			
		}

	});
}

</script>

<style>
#modal_description{
	max-height: 290px;
	overflow: scroll;
	
}
.modal{
width : 625px;
} 
</style>