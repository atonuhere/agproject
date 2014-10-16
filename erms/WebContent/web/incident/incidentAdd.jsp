<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://bibeault.org/tld/ccc" prefix="ccc" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<ccc:constantsMap className="com.gfs.erm.web.common.WebConstants" var="Constants"/>
<c:set var="loguser" value="${sessionScope[Constants.CURRENT_USER_SESSION]}"/>
<c:set value="${Constants.DISPLAY_CAL_DATE_FORMAT}" var="datefrmt" scope="request"></c:set>   
<c:set value="${Constants.DISPLAY_INC_CATEGORY}" var="incCategory" scope="request"></c:set>  
<c:set value="${Constants.CAL_DATE_RANGE}" var="caldtRange" scope="request"></c:set>  

<c:if test="${control eq 'incidentLog'}">

	<h4 class="title">Report an Incident</h4>

	<form  method="post" action="/incident/save.html" name="addIncidentLogForm" class="form-horizontal">
		<input type="hidden" name="incident.incidentStatusId" value="1" />
		<input type="hidden" name="incident.active" value="1" />
		<input type="hidden" name="incident.loggedBy" value="${loguser.id}" />
		
	
		<div class="form-control">
			<label class="form-label" for="incident_reportedBy">${bundle[label.reportedby]}</label>
			<input type="text" class="" placeholder="Reported by" name="incident.reportedBy" id="incident_reportedBy"/>						           
		</div>
		
		<div class="form-control input-append" id="datetimepicker_report">
			<label class="form-label" for="reported_on">Reported On</label>
			<input data-format="${datefrmt}" type="text" name="reported_on" id="reported_on"></input>
			<span class="add-on">
			  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
			   </i>
			 </span>
		</div>	 	
	 	<div class="form-control">		
			<label class="form-label" for="reporterDetails">Reporter Details</label>
			<textarea name="incident.reporterDetails" id="reporterDetails"></textarea>
		</div>	
		<div class="form-control">
			<label class="form-label" for="incident_incLocation">Incident Location</label>
			<input type="text" class="" placeholder="Incident Location" name="incident.incLocation" id="incident_incLocation"/>	
		</div>
		
		
		<div class="form-control input-append" id="datetimepicker_incidentDate">
			<label class="form-label" for="incidentDate">Incident Date</label>
			<input data-format="${datefrmt}" type="text" name="incidentDate" id="incidentDate"></input>
			<span class="add-on">
			  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
			   </i>
			 </span>
		</div>
		
		<div class="form-control">
			<label class="form-label" for="incident_branchId">Name of affected office</label>
			<select name="incident.branchId"  id="incident_branchId" >
				<option value="">Select Branch</option>
				<c:forEach items="${dataArr['branchList']}" var="item">
					<option value="${item.id}">${item.name}</option>
				</c:forEach>
			</select>	
		</div>		
	
		<div class="form-control">
			<label class="form-label" for="incident_incidentTypeId">Incident type</label>
			<select name="incident.incidentTypeId"  id="incident_incidentTypeId" >
				<option value="">Select Incident Type</option>
				<c:forEach items="${dataArr['incidentTypeList']}" var="item">
					<option value="${item.id}">${item.name}</option>
				</c:forEach>
			</select>
				
		</div>
		<div class="form-control">
			<label class="form-label" for="incident_incCategory">Incident Category</label>
			<select name="incident.incCategory"  id="incident_incCategory" >
				<option value="">Select Incident Category</option>
				<c:forEach items="${incCategory}" var="item" varStatus="status">
					<option value="${status.count}">${item}</option>
				</c:forEach>
			</select>
					
		</div>
		<div class="form-control">
			<label class="form-label" for="incident_descriptions">Incident Description</label>
			<textarea class="" rows="4" cols="12"  placeholder="incident description" name="incident.descriptions" id="incident_descriptions"></textarea>
		</div>
	
		<div class="form-control">			
				<label class="form-label" for="incident_actionTaken">Taken Actions</label>
				<input type="text" class="" placeholder="action taken" 	name="incident_actionTaken"/>											           			
		</div>
		<div class="form-control">			
				<label class="form-label" for="incident_remarks">Remarks about incident</label>
				<input type="text" class="" placeholder="give remarks" 	name="incident.remarks" id="incident_remarks"/>											           			
		</div>
		
		<div class="form-group">
			<input type="submit" class="button" value="Save">
			
		</div>
	
	</form>
	
</c:if>


<c:if test="${control eq 'submitInvestigationReport'}">

	<h4 class="title">Report an Incident</h4>

	<form  method="post" action="/incident/save.html" name="addIncidentLogForm" class="form-horizontal">
	
	</form>
</c:if>

	
<script type="text/javascript">
$(function() {

	// for CA
	$('#caCheck').click(function () {
		if ($(this).is(':checked')) {
			 $("#caChecked").show(400);
		} else {
			  $("#caChecked").hide(400);
		}
	});
	// for PA
	$('#paCheck').click(function () {
		if ($(this).is(':checked')) {
			 $("#paChecked").show(400);
		} else {
			  $("#paChecked").hide(400);
		}
	});

	

	// for RECOVERY COST
	$('#recovCheck').click(function () {
		if ($(this).is(':checked')) {
			 $("#recovChecked").show(400);
		} else {
			  $("#recovChecked").hide(400);
		}
	});
	
	//initialize calendar
	$('#datetimepicker_report').datetimepicker({
	      language: 'en',
	      pick12HourFormat: true
	    });
	//initialize calendar
	$('#datetimepicker_incidentDate').datetimepicker({
	      language: 'en',
	      pick12HourFormat: true
	    });

	
	
}); // END DOCUMENT READY

// ADD MULTIPLE RCA/CA/PA 
function addActionDesc(typ){  

	if(typ == 'rca'){
		var cnt = $('#rcaActionCount').val();
		$('#rcaActionDiv').append('<textarea name="rcaActionList['+cnt+'].actionDesc" id="rcaactiondes'+cnt+'" style="width: 648px; height: 60px;"></textarea>');
		cnt++;
		$('#rcaActionCount').val(cnt);
	}
	else if(typ == 'ca'){
		var cnt = $('#caActionCount').val();
		$('#caActionDiv').append('<textarea name="caActionList['+cnt+'].actionDesc" id="caactiondes'+cnt+'" style="width: 648px; height: 60px;"></textarea>');
		cnt++;
		$('#caActionCount').val(cnt);
	}
	else{
		var cnt = $('#paActionCount').val();
		$('#paActionDiv').append('<textarea name="paActionList['+cnt+'].actionDesc" id="paactiondes'+cnt+'" style="width: 648px; height: 60px;"></textarea>');
		cnt++;
		$('#paActionCount').val(cnt);
	}
		
}

//DELETE MULTIPLE RCA/CA/PA 
function delActionDesc(typ){

	if(typ == 'rca'){
		var count = $('#rcaActionCount').val();
		if(count >1){
			var setcnt = parseInt(count-1);
			$("#rcaactiondes"+setcnt).remove();
			$('#rcaActionCount').val(setcnt);
		}else{
			alert('Not Deleted');
		}
			
	}
	else if(typ == 'ca'){
		var count = $('#caActionCount').val();
		if(count >1){
			var setcnt = parseInt(count-1);
			$("#caactiondes"+setcnt).remove();
			$('#caActionCount').val(setcnt);
		}else{
			alert('Not Deleted');
		}
			
	}
	else{
		var count = $('#paActionCount').val();
		if(count >1){
			var setcnt = parseInt(count-1);
			$("#paactiondes"+setcnt).remove();
			$('#paActionCount').val(setcnt);

		}else{
			alert('Not Deleted');
		}
	}	
}

 // CLOSE MODAL BOX
function closeModal(){
	
	$('#incidentlog_modal').modal('hide');
	$('#incidentlog_description').html('');
}

 /// >>>>>>>>>>>>>>>> INVESTIGATION OF INCIDENT START <<<<<<<<<<<<<<<<<<<///
function showincidentlog(){   
	$('#incidentlog_modal').modal('show');
	var url = '${rootpath}'+'incident/incidentReport/showincidentLog';
	var htm = '';
	$.ajax({
		type :'POST',
		url: url,
		//data : { id : scheduleId } ,
		dataType: 'JSON',			
		cache: false,	//IE fix
		success: function(resp){
			//alert(resp)
			htm +='<table class="table table-striped table-bordered">';
			htm +='<tr><th>Sl. No.</th><th>Incident No.</th><th>Location</th><th>Date</th><th>Type</th><th>Action</th></tr>';
			$.each(resp, function(i, item) {
				
				htm +='<tr id="inc_row_'+(i+1)+'"><td>'+ (i+1) +'.</td><td>'+ item.incNumber + '</td><td>'+ item.incLocation + '</td><td>'+formatDate(item.incDate)+'</td><td>'+ item.incType.name + '</td><td><input type="hidden" id="descriptions_'+(i+1)+'" value="'+ item.descriptions + '" /><a href=\"javascript:void(0)\" onclick=\"selectIncident('+ item.id +', '+(i+1)+')\" class=\"btn btn-mini btn-primary\" >Select</a></td></tr>';
	            
			});
			
			htm +='</table>';

			$('#incidentlog_description').html(htm);
		}
	});

}

function selectIncident(incId,rowId){    
	
	var inc_no = $("#inc_row_"+rowId+" td:nth-child(2)").html();
	var inc_loc = $("#inc_row_"+rowId+" td:nth-child(3)").html();
	var inc_dt = $("#inc_row_"+rowId+" td:nth-child(4)").html();
	var inc_typ = $("#inc_row_"+rowId+" td:nth-child(5)").html();
	var inc_descriptions = $('#descriptions_'+rowId).val();
	//alert(inc_no+'//'+inc_loc+'//'+inc_dt+'//'+inc_typ);
	var htm = '';
	htm+='<div style="padding :5px;">';
	htm+='<div class="span6">Incident Number : <strong>'+inc_no+'</strong></div>';
	htm+='<div class="span6">Incident Type : '+inc_typ+'</div>';
	htm+='<div class="span6">Incident Location : '+inc_loc+'</div>';
	htm+='<div class="span6">Incident Date : '+inc_dt+'</div>';
	htm+='<div class="span12">Description of Incident : '+inc_descriptions+'</div>';
	htm+='</div>';
	$('#incident_details').show();
	$('#incident_details').html(htm);
	$('#incidentId').val(incId);
	closeModal();
}

/// >>>>>>>>>>>>>>>> INVESTIGATION OF INCIDENT END <<<<<<<<<<<<<<<<<<<///



</script>	


<style>
	
.row-fluid [class*="span"] {
    margin-left: 0%;
   
}

#incidentlog_description{
	max-height: 290px;
	overflow: scroll;
}

.form-actions{
	padding-right : 0px!important;
	padding-left : 0px!important; 
}	


</style>

