<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://bibeault.org/tld/ccc" prefix="ccc" %>
<ccc:constantsMap className="com.gfs.erm.web.common.WebConstants" var="Constants"/>
<c:set value="${Constants.DISPLAY_CAL_CONVERT_DATE_FORMAT}" var="datefrmt" scope="request"></c:set> 
<c:set value="${Constants.DISPLAY_CAL_DATE_FORMAT}" var="datefmt" scope="request"></c:set>   
<c:set value="${Constants.DISPLAY_INC_CATEGORY}" var="incCategory" scope="request"></c:set>  


<c:if test="${control eq 'incidentLog'}">

	<h4 class="title">Update Incident Log # ${incident.incNumber}</h4>

	<s:form  method="post" action="save" namespace="/incident" name="addIncidentLogForm" >
		<input type="hidden" name="incident.incidentStatusId" value="1" />
		<input type="hidden" name="incident.active" value="1" />
		<input type="hidden" name="incident.incNumber" value="${incident.incNumber}" />
		<input type="hidden" name="incident.id" value="${incident.id}" />
		<input type="hidden" name="incident.loggedBy" value="${loguser.id}" />
		
		<div class="form-control">
			<label class="form-label" for="incident_reportedBy">Reported By</label>
			<input type="text" class="" placeholder="Reported by" name="incident.reportedBy" id="incident_reportedBy" value="${incident.reportedBy}"/>						           
		</div>
		<div class="form-control">		
			<label class="form-label" for="reporterDetails">Reporter Details</label>
			<textarea name="incident.reporterDetails" id="reporterDetails" >${incident.reporterDetails}</textarea>
		</div>
		<div class="form-control input-append" id="datetimepicker_report">
			<label class="form-label" for="reported_on">Reported On</label>
			<sj:datepicker name="reported_on" id="reported_on" key="label.reportedon" 
				displayFormat="%{#request.datefmt}" tooltip="Reported on" 
				changeYear="true" changeMonth="true" value="%{incident.reportedOn}" />
		</div>
		<div class="form-control input-append" id="datetimepicker_incidentDate">
			<label class="form-label" for="incidentDate">Incident Date</label>
			<sj:datepicker name="inc_date" id="inc_date"  key="label.incDate"
				displayFormat="%{#request.datefmt}" value="%{incident.incDate}"
				changeYear="true" changeMonth="true" yearRange="%{#request.caldtRange}" />
		</div>
		<div class="form-control">
			<label class="form-label" for="incident_branchId">Name of affected office</label>
			<select name="incident.branchId"  id="incident_branchId" >
				<option value="${incident.branchId}">Select Branch</option>
				<c:forEach items="${dataArr['branchList']}" var="item">
					<option value="${item.id}">${item.name}</option>
				</c:forEach>
			</select>	
		</div>		
	
		<div class="form-control">
			<label class="form-label" for="incident_incidentTypeId">Incident type</label>
			<select name="incident.incidentTypeId"  id="incident_incidentTypeId" >
				<option value="${incident.incidentTypeId}">Select Incident Type</option>
				<c:forEach items="${dataArr['incidentTypeList']}" var="item">
					<option value="${item.id}">${item.name}</option>
				</c:forEach>
			</select>
				
		</div>
		<div class="form-control">
			<label class="form-label" for="incident_incCategory">Incident Category</label>
			<select name="incident.incCategory"  id="incident_incCategory" >
				<option value="${incident.incCategory}">Select Incident Category</option>
				<c:forEach items="${incCategory}" var="item" varStatus="status">
					<option value="${status.count}">${item}</option>
				</c:forEach>
			</select>
					
		</div>
		<div class="form-control">
			<label class="form-label" for="incident_incLocation">Incident Location</label>
			<input type="text" class="" placeholder="Incident Location" name="incident.incLocation" id="incident_incLocation" value="${incident.incLocation}"/>	
		</div>
		<div class="form-control">
			<label class="form-label" for="incident_descriptions">Incident Description</label>
			<textarea class="" rows="4" cols="12"  placeholder="incident description" name="incident.descriptions" id="incident_descriptions" >${incident.descriptions}</textarea>
		</div>
		<div class="form-control">		
				<label class="form-label" for="incident_actionTaken">Taken Actions</label>
				<input type="text" class="" placeholder="action taken" 	name="incident_actionTaken" value="${incident.actionTaken}"/>											           			
		</div>
		<div class="form-control">			
				<label class="form-label" for="incident_remarks">Remarks about incident</label>
				<input type="text" class="" placeholder="give remarks" 	name="incident.remarks" id="incident_remarks" value="${incident.remarks}"/>											           			
		</div>
		
		 
		
	
		
		
		
		
		
		
		
		
		<div class="form-group">
			<input type="submit" class="button" value="Update">
			
		</div>
	
	
	</s:form>
	
	<style>
	.s2j-combobox-input{
		width: 300px!important;
	}
	</style>
</c:if>








<c:if test="${control=='invgReport'}">

<fieldset class="custom_fieldset">
<legend class="custom_legend">Update Submited Investigation Report</legend>

<s:form id="" method="post" action="updateReport" name="addinvgReportForm"  theme="bootstrap" cssClass="form-vertical" >
	
	<div class="row-fluid">
		<s:hidden name="control" value="%{control}"></s:hidden>
		<s:hidden name="invgReport.incId.id" id="incidentId" value="%{invgReport.incId.id}"></s:hidden>
		<s:hidden name="invgReport.id" id="incidentId" value="%{invgReport.id}"></s:hidden>
		<s:hidden name="incidentStatusId" id="incidentStatusId" value="%{invgReport.incId.incstatus.id}"></s:hidden>
		<!--<a href="javascript:void(0);" onclick="showincidentlog()" class="btn btn-info">Select Incident</a>-->
		<strong>Incident Details : </strong>
	</div>
	
	<div class="row-fluid span12 form-actions" id="incident_details" style="margin-left : 0px; border: 1px solid;">
	
		<div style="padding :5px;">
			<div class="span6">Incident Number : <strong>${invgReport.incId.incNumber}</strong></div>
			<div class="span6">Incident Type : ${invgReport.incId.incType.name}</div>
			<div class="span6">Incident Location : ${invgReport.incId.incLocation}</div>
			<div class="span6">Incident Date : 
				<c:set var="incDate" value="${invgReport.incId.incDate}" />
				<fmt:formatDate pattern="${request.datefrmt}" value="${incDate}" />
			</div>
		</div>
		
	</div>

	
<div class="row-fluid" id="">
	
	
	<!-- <<<<<<<<<<<<<  FOR RCA START >>>>>>>>>>>>>>>>>> -->
	
	<div class="span12"> 
		<!--<s:checkbox name="invgReport.rcaRequired" id="rcaCheck"  key="label.rcareq" ></s:checkbox>-->
		<input type="radio" name="invgReport.rcaRequired" value="true" checked="checked" /> RCA Required
	</div>
	<div  id="rcaChecked" style="">
		
		<div class="span12" id="rcaActionDiv"> 
			<span class="bold">Root Cause Analysis : </span>
			<c:set var="rcaCnt" value="0"></c:set>	
			<c:choose>
				<c:when test="${fn:length(invgActionsRCAList) gt 0}">
					<c:forEach items="${invgActionsRCAList}" var="item" >
					 	<textarea name="rcaActionList[${rcaCnt}].actionDesc" id="rcaactiondes${rcaCnt}" style="width: 648px; height: 60px;">${item.actionDesc}</textarea>
							<input type="hidden" name="rcaActionList[${rcaCnt}].id" value="${item.id}" />
							<c:set var="rcaCnt" value="${rcaCnt+1}"></c:set>
					 </c:forEach>
				</c:when>
				<c:otherwise>
					<s:textarea name="rcaActionList[0].actionDesc" id="rcaactiondes0" cssStyle="width: 648px; height: 60px;" ></s:textarea>
				</c:otherwise>
			</c:choose>
		</div>
			
		<div class="span12"> 
			<input type="hidden" id= "rcaActionCount"  value="${rcaCnt}" />
			<a href="javascript:void(0)" onclick="addActionDesc('rca')" class="btn btn-info btn-mini" >Add more RCA</a>
			<a href="javascript:void(0)" onclick="delActionDesc('rca')" class="btn btn-danger btn-mini" >Delete RCA</a>
		</div>
		
	</div>
	
	<!-- <<<<<<<<<<<<<  FOR RCA END >>>>>>>>>>>>>>>>>> -->
	
	
	
	<!-- <<<<<<<<<<<<<  FOR CA START >>>>>>>>>>>>>>>>>> -->
	
	<div class="span12"> 
		<s:checkbox name="invgReport.caRequired" id="caCheck" key="label.caReq"></s:checkbox>
	</div>
	
	<div  id="caChecked" style="">
		<div class="span12" id="caActionDiv"> 
			<span class="bold">Corrective Action Analysis : </span>
			<c:set var="caCnt" value="0"></c:set>
			<c:choose>
				<c:when test="${fn:length(invgActionsCAList) gt 0}">
					<c:forEach items="${invgActionsCAList}" var="item" >
					 	<textarea name="caActionList[${caCnt}].actionDesc" id="caactiondes${caCnt}" style="width: 648px; height: 60px;">${item.actionDesc}</textarea>
							<input type="hidden" name="caActionList[${caCnt}].id" value="${item.id}" />
							<c:set var="caCnt" value="${caCnt+1}"></c:set>
					 </c:forEach>
				</c:when>
				<c:otherwise>
					<s:textarea name="caActionList[0].actionDesc" id="caactiondes0" cssStyle="width: 648px; height: 60px;" ></s:textarea>
				</c:otherwise>
			</c:choose>
		</div>
				
		<div class="span12"> 
			<input type="hidden" id= "caActionCount"  value="${caCnt}" />
			<a href="javascript:void(0)" onclick="addActionDesc('ca')" class="btn btn-info btn-mini" >Add more CA</a>
			<a href="javascript:void(0)" onclick="delActionDesc('ca')" class="btn btn-danger btn-mini" >Delete CA</a>
		</div>
	
	</div>
	<!-- <<<<<<<<<<<<<  FOR CA END >>>>>>>>>>>>>>>>>> -->
	
	<!-- <<<<<<<<<<<<<  FOR PA START >>>>>>>>>>>>>>>>>> -->
	
	<div class="span12"> 
		<s:checkbox name="invgReport.paRequired" id="paCheck" key="label.paReq"></s:checkbox>
	</div>
	
	<div  id="paChecked" style="">	
		<div class="span12" id="paActionDiv"> 	
			<span class="bold">Preventive Action Analysis : </span>
			<c:set var="paCnt" value="0"></c:set>
			<c:choose>
				<c:when test="${fn:length(invgActionsPAList) gt 0}">
					<c:forEach items="${invgActionsPAList}" var="item" >
					 	<textarea name="paActionList[${paCnt}].actionDesc" id="paactiondes${paCnt}" style="width: 648px; height: 60px;">${item.actionDesc}</textarea>
							<input type="hidden" name="paActionList[${paCnt}].id" value="${item.id}" />
							<c:set var="paCnt" value="${paCnt+1}"></c:set>
					 </c:forEach>
				</c:when>
				<c:otherwise>
					<s:textarea name="paActionList[0].actionDesc" id="paactiondes0" cssStyle="width: 648px; height: 60px;" ></s:textarea>
				</c:otherwise>
			</c:choose>
				
		</div>
	
		<div class="span12"> 
			<input type="hidden" id= "paActionCount"  value="${paCnt}" />
			<a href="javascript:void(0)" onclick="addActionDesc('pa')" class="btn btn-info btn-mini" >Add more PA</a>
			<a href="javascript:void(0)" onclick="delActionDesc('pa')" class="btn btn-danger btn-mini" >Delete PA</a>
		</div>
	</div>
	
	<!-- <<<<<<<<<<<<<  FOR PA END >>>>>>>>>>>>>>>>>> -->
	
	
	
	<div class="span12"> 
		<div class="span6"> 
			<s:checkbox name="invgReport.recovCostReq" id="recovCheck" key="label.recovReq"></s:checkbox>
		</div>
		<div class="span6"> 
			<div  id="recovChecked" class="${(invgReport.recovCostReq == 'true')? 'show' : 'hide'}">
				<s:textfield name="invgReport.recovCost" key="label.recovCost"></s:textfield>
			</div>
		</div>
	</div>
	
	
	<div class="span12"> 
		<s:hidden name="invgReport.furActionRequired" ></s:hidden>
	</div>
	<div  id="furChecked" class="span12"  style="display: none;">
		<s:hidden name="invgReport.furAction" ></s:hidden>
	</div>
	
	
	<div class="span12 center"> 
		<s:submit key="label.save" cssClass="btn btn-inverse"></s:submit>
	</div>
	

</div>
</s:form>
</fieldset>

</c:if>




<c:if test="${control=='invgCarPar'}">

<fieldset class="custom_fieldset">
<legend class="custom_legend">Submit CAR / PAR </legend>

<s:form id="" method="post" action="saveInvgCarPar" name="addinvgCarParForm"  theme="bootstrap" cssClass="form-vertical" >
	<c:if test="${invgReport.incId.incstatus.id >= 4 && invgReport.incId.incstatus.id < 6}">
		<div class="bs-callout bs-callout-danger">
			<span class="bold error">CA/PA Assigned. Please Acknowledge the Assignment.</span>
		</div>
	</c:if>	
			
	<div class="row-fluid">
		<s:hidden name="control" value="%{control}"></s:hidden>
		<s:hidden name="invgReport.incId.id" id="incidentId" value="%{invgReport.incId.id}"></s:hidden>
		<s:hidden name="invgReport.id" id="incidentId" value="%{invgReport.id}"></s:hidden>
		<s:hidden name="incidentStatusId" id="incidentStatusId" value="%{invgReport.incId.incstatus.id}"></s:hidden>
		<strong>Incident Details : </strong>
	</div>
	
	<div class="row-fluid span12 form-actions" id="incident_details" style="margin-left : 0px; border: 1px solid;">
	
		<div style="padding :5px;">
			<div class="span6">Incident Number : <strong>${invgReport.incId.incNumber}</strong></div>
			<div class="span6">Incident Type : ${invgReport.incId.incType.name}</div>
			<div class="span6">Incident Location : ${invgReport.incId.incLocation}</div>
			<div class="span6">Incident Date : 
				<c:set var="incDate" value="${invgReport.incId.incDate}" />
				<fmt:formatDate pattern="${request.datefrmt}" value="${incDate}" />
			</div>
		</div>
		
	</div>
		
	<div class="row-fluid"><strong>Root Cause Analysis : </strong></div>
	
	<div class="row-fluid span12 form-actions" style="margin-left : 0px; border: 1px solid; ">
		<c:choose>
			<c:when test="${fn:length(invgActionsRCAList) gt 0}">
				<c:forEach items="${invgActionsRCAList}" var="item" varStatus="status" >
				 	<div class="span12" style="padding :2px 5px;"> 
				 	<span>${status.count} . </span>
				 	<span>${item.actionDesc}</span>
				 	</div>
				 </c:forEach>
			</c:when>
			<c:otherwise>
				<div class="span12 error" style="padding :2px 5px;"> Not Found </div>
			</c:otherwise>
		</c:choose>
	
	</div>
	
	<div class="row-fluid" ><strong>Corrective Action Analysis : </strong></div>
	<div class="row-fluid span12" style="margin :0px; padding: 10px 0px;">
	<c:choose>
		<c:when test="${fn:length(invgActionsCAList) gt 0}">
			<c:forEach items="${invgActionsCAList}" var="item" varStatus="status" >
			<div class="span12" style="padding :10px 0px;"> 	
			 	<div class="span12" style="padding :2px 0px;"> 
				 	<span>${status.count} . </span>
				 	<span>${item.actionDesc}</span>
				 </div>	
				 
				 <div class="row-fluid span12 form-actions"  style="border: 0px solid; padding: 5px 10px;">
					<div class="span2" id="viewFollowupReport_div_${item.id}">	
						<a href="javascript:void(0)" onclick="viewFollowupReport(${item.id})" class="btn btn-info btn-mini" >View CAR</a>
					</div>
					<div class="span2" id="hideFollowupReport_div_${item.id}" style="display: none;">
						<a href="javascript: void(0)" onclick="hideFollowupReport(${item.id})" class="btn btn-primary btn-mini" >Hide CAR</a>
					</div>
					<c:if test="${(invgReport.incId.incstatus.id > 5) && (invgReport.incId.incstatus.id < 7)}">
						<div class="span2">
							<a href="javascript:void(0)" onclick="AddFollowupReport(${item.id})" class="btn btn-danger btn-mini" >Add CAR</a>
						</div>
					</c:if>
					<div class="span1"> 
							<div class="ajax_small_loading" id="ajax_small_loading_${item.id}"  style="display: none;"></div>
					</div>
				</div>
				<!-- ADD CAR START -->
				<div class="row-fluid span12" id="add_report_form_${item.id}" style="border: 1px solid; padding: 10px 10px; display : none;">
				 	<c:set var="itmid" value="${item.id}" scope="request"></c:set>
				 	<div class="span6" id="car_stat_radio_${item.id}">
				 		<s:radio name="carStatusRadio%{#request.itmid}"  list="#{'1':'Complete','2':'Revised'}" onclick="changeCarParStatus('%{#request.itmid}')" ></s:radio>
				 		<input type="hidden" name="itemId" id="" value="${item.id}" />
				 	</div>
				 	<div class="span6" >
				 		<label id="complete_date_${item.id}">Completed Date</label>
				 		<label id="revised_date_${item.id}" style="display: none;">Revised Date</label>
				 		<sj:datepicker name="compltDate" id="compltDate%{#request.itmid}"  parentTheme="bootstrap" displayFormat="%{#request.datefmt}" changeYear="true" changeMonth="true" />
				 	</div> 
				 	
				 	<div class="span12" >
				 	<label id="complete_description_${item.id}">Remarks</label> 
				 	<label id="revised_description_${item.id}" style="display: none;">Revised Reason</label>
				 		<s:textarea name=""  id="compltDesc%{#request.itmid}" cssStyle="width: 648px; height: 60px;" ></s:textarea>
				 	</div>
				 	
				 	<div class="center"><a href="javascript:void(0);" onclick="saveCarParStatus(${item.id}, ${item.invg.id}, ${invgReport.incId.id})" class="btn btn-primary btn-mini">Save</a></div>
				 </div>
				 
				 <!-- ADD CAR END -->
				 
			 	<div class="row-fluid span12" id="view_report_list_${item.id}" style="display:none; border: 0px solid; padding: 10px 10px;"></div>
			 </div> 
			 </c:forEach>
		</c:when>
		<c:otherwise>
			<div class="span12 error" style="padding :2px 5px;"> Not Found </div>
		</c:otherwise>
	</c:choose>
	</div>
	
	
	<div class="row-fluid" ><strong>Preventive Action Analysis : </strong></div>
	<div class="row-fluid span12" style="margin :0px; padding: 10px 0px;">
	<c:choose>
		<c:when test="${fn:length(invgActionsPAList) gt 0}">
			<c:forEach items="${invgActionsPAList}" var="item" varStatus="status" >
			 <div class="span12" style="padding :10px 0px;"> 
			 	
			 	<div class="span12" style="padding :2px 0px;"> 
				 	<span>${status.count} . </span>
				 	<span>${item.actionDesc}</span>
				 </div>	
				 
				 <div class="row-fluid span12 form-actions"  style="border: 0px solid; padding: 5px 10px;">
				 				
				 	<div class="span2" id="viewFollowupReport_div_${item.id}">	
						<a href="javascript:void(0)" onclick="viewFollowupReport(${item.id})" class="btn btn-info btn-mini" >View PAR</a>
					</div>
					<div class="span2" id="hideFollowupReport_div_${item.id}" style="display: none;">
						<a href="javascript:void(0)" onclick="hideFollowupReport(${item.id})" class="btn btn-primary btn-mini" >Hide PAR</a>
					</div>
					<c:if test="${(invgReport.incId.incstatus.id > 5) && (invgReport.incId.incstatus.id < 7)}">
					<div class="span2">
						<a href="javascript:void(0)" onclick="AddFollowupReport(${item.id})" class="btn btn-danger btn-mini" >Add PAR</a>
					</div>
					</c:if>
					<div class="span1"> 
						<div class="ajax_small_loading" id="ajax_small_loading_${item.id}"  style="display: none;"></div>
					</div>
				 
				 </div>
				 
				 <!-- ADD CAR START -->
				 
				<div class="row-fluid span12" id="add_report_form_${item.id}" style="border: 1px solid; padding: 10px 10px; display : none;">
				 	<c:set var="itmid" value="${item.id}" scope="request"></c:set>
				 	<div class="span6" id="car_stat_radio_${item.id}">
				 		<s:radio name="carStatusRadio%{#request.itmid}"  list="#{'1':'Complete','2':'Revised'}" onclick="changeCarParStatus('%{#request.itmid}')" ></s:radio>
				 		<input type="hidden" name="itemId" id="" value="${item.id}" />
				 	</div>
				 	<div class="span6" >
				 		<label id="complete_date_${item.id}">Completed Date</label>
				 		<label id="revised_date_${item.id}" style="display: none;">Revised Date</label>
				 		<sj:datepicker name="compltDate" id="compltDate%{#request.itmid}"  parentTheme="bootstrap" displayFormat="%{#request.datefmt}" changeYear="true" changeMonth="true" />
				 	</div> 
				 	
				 	<div class="span12" >
				 	<label id="complete_description_${item.id}">Remarks</label> 
				 	<label id="revised_description_${item.id}" style="display: none;">Revised Reason</label>
				 		<s:textarea name=""  id="compltDesc%{#request.itmid}" cssStyle="width: 648px; height: 60px;" ></s:textarea>
				 	</div>
				 	
				 	<div class="center"><a href="javascript:void(0);" onclick="saveCarParStatus(${item.id}, ${item.invg.id}, ${invgReport.incId.id})" class="btn btn-primary btn-mini">Save</a></div>
				 </div>
				  
				 <!-- ADD CAR START -->
				  
			 	 <div class="row-fluid span12" id="view_report_list_${item.id}" style="display:none; border: 0px solid; padding: 10px 10px;"></div>
			 
			 </div>
				 
			 </c:forEach>
		</c:when>
		<c:otherwise>
			<div class="span12 error" style="padding :2px 5px;"> Not Found </div>
		</c:otherwise>
	</c:choose>
	</div>

</s:form>
</fieldset>

<style>
.radio{
	display: inline-block;
}
</style>
</c:if>







<c:if test="${control=='invgClosureActionPlan'}">

<fieldset class="custom_fieldset">
<legend class="custom_legend"> Closure of Actions Plans </legend>

<s:form id="" method="post" action="saveInvgClosureActionPlan" name="invgClosureActionPlan"  theme="bootstrap" cssClass="form-vertical" >
	
	<div class="row-fluid">
		<s:hidden name="control" value="%{control}"></s:hidden>
		<s:hidden name="invgReport.incId.id" id="incidentId" value="%{incidentlog.id}"></s:hidden>
		<s:hidden name="invgReport.id" id="" value="%{invgReport.id}"></s:hidden>
		<s:hidden name="incidentStatusId" id="incidentStatusId" value="%{incidentlog.incstatus.id}"></s:hidden>
		<strong>Incident Details : </strong>
	</div>
	
	<div class="row-fluid span12 form-actions" id="incident_details" style="margin-left : 0px; border: 1px solid;">
		<div style="padding :5px;">
			<div class="span6">Incident Number : <strong>${incidentlog.incNumber}</strong></div>
			<div class="span6">Incident Type : ${incidentlog.incType.name}</div>
			<div class="span6">Incident Location : ${incidentlog.incLocation}</div>
			<div class="span6">Incident Date : 
				<c:set var="incDate" value="${incidentlog.incDate}" />
				<fmt:formatDate pattern="${request.datefrmt}" value="${incDate}" />
			</div>
		</div>
		
	</div>
		
	<div class="row-fluid"><strong>Root Cause Analysis : </strong></div>
	<div class="row-fluid span12 form-actions" style="margin-left : 0px; border: 1px solid; ">
		<c:choose>
			<c:when test="${fn:length(invgActionsRCAList) gt 0}">
				<c:forEach items="${invgActionsRCAList}" var="item" varStatus="status" >
				 	<div class="span12" style="padding :2px 5px;"> 
				 	<span>${status.count} . </span>
				 	<span>${item.actionDesc}</span>
				 	</div>
				 </c:forEach>
			</c:when>
			<c:otherwise>
				<div class="span12 error" style="padding :2px 5px;"> Not Found </div>
			</c:otherwise>
		</c:choose>
	
	</div>
	
	<div class="row-fluid" ><strong>Corrective Action Analysis : </strong></div>
	<div class="row-fluid span12" style="margin :0px; padding: 10px 0px;">
	<c:choose>
		<c:when test="${fn:length(invgActionsCAList) gt 0}">
			<c:forEach items="${invgActionsCAList}" var="item" varStatus="status" >
			<div class="span12" style="padding :10px 0px;"> 	
			 	<div class="span12" style="padding :2px 0px;"> 
				 	<span>${status.count} . </span>
				 	<span>${item.actionDesc}</span>
				 </div>	
				 
				 <div class="row-fluid span12"  style="border: 0px solid; padding: 5px 10px;">
				 	<div class="span2" id="viewFollowupReport_div_${item.id}">	
				 		<a href="javascript:void(0)" onclick="viewFollowupReport(${item.id})" class="btn btn-info btn-mini" >View CAR</a>
					</div>
					<div class="span2" id="hideFollowupReport_div_${item.id}" style="display: none;">
				 		<a href="javascript:void(0)" onclick="hideFollowupReport(${item.id})" class="btn btn-primary btn-mini" >Hide CAR</a>
				 	</div>
					<div class="span1"> 
				 		<div class="ajax_small_loading" id="ajax_small_loading_${item.id}"  style="display: none;"></div>
				 	</div>
				 	
				</div>
				<div class="row-fluid span12" id="view_report_list_${item.id}" style="display:none; border: 0px solid; padding: 10px 10px;"></div>
			 
			 </div> 
			 </c:forEach>
		</c:when>
		<c:otherwise>
			<div class="span12 error" style="padding :2px 5px;"> Not Found </div>
		</c:otherwise>
	</c:choose>
	</div>
	
	
	<div class="row-fluid" ><strong>Preventive Action Analysis : </strong></div>
	<div class="row-fluid span12" style="margin :0px; padding: 10px 0px;">
	<c:choose>
		<c:when test="${fn:length(invgActionsPAList) gt 0}">
			<c:forEach items="${invgActionsPAList}" var="item" varStatus="status" >
			 <div class="span12" style="padding :10px 0px;"> 
			 	
			 	<div class="span12" style="padding :2px 0px;"> 
				 	<span>${status.count} . </span>
				 	<span>${item.actionDesc}</span>
				</div>	
				<div class="row-fluid span12"  style="border: 0px solid; padding: 5px 10px;"> 
					<div class="span2" id="viewFollowupReport_div_${item.id}">	
						<a href="javascript:void(0)" onclick="viewFollowupReport(${item.id})" class="btn btn-info btn-mini" >View PAR</a>
					</div>
					<div class="span2" id="hideFollowupReport_div_${item.id}" style="display: none;">
						<a href="javascript:void(0)" onclick="hideFollowupReport(${item.id})" class="btn btn-primary btn-mini" >Hide PAR</a>
					</div>
					<div class="span1"> 
							<div class="ajax_small_loading" id="ajax_small_loading_${item.id}"  style="display: none;"></div>
					</div>
				</div>
							
				<div class="row-fluid span12" id="view_report_list_${item.id}" style="display:none; border: 0px solid; padding: 10px 10px;"></div>
			 
			</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<div class="span12 error" style="padding :2px 5px;"> Not Found </div>
		</c:otherwise>
	</c:choose>
	</div>
	
	<c:if test="${incidentlog.incstatus.id le 7}">
		<div class="center">
			<a href="javascript:void(0)" onclick="CloseInvgReport()" class="btn btn-danger" >Close Investigation</a>
		</div>
	</c:if>
	
</s:form>
</fieldset>


</c:if>








<!-------*****************INCIDENT log Modal Box FOR SCHEDULE LIST **********************/ -->

<div class="modal fade" id="incidentlog_modal" style="width: 700px; display:none;">
  <div class="modal-header">
    <a class="close" data-dismiss="modal">&times;</a>
    <h3>List of Incident</h3>
  </div>
  <div class="modal-body" id="incidentlog_description"></div>
  
  <div class="modal-footer">
   <!-- <a href="javascript:void(0)" onclick="closeModal()" class="btn" data-dismiss="modal">Cancel</a>
    <a href="javascript:void(0)" class="btn btn-primary" onclick="approveAuditSchedule()" >Approve</a>
    <input type="hidden" name="schedule_id" id="schedule_id" value="" />-->
  </div>

</div>

<!-------*****************INCIDENT log Modal Box End**********************/ -->



<script type="text/javascript">

$(function() {

	// for RCA
	
	//var rca_count ="<c:out value='${rcaCnt}'/>";
	var ca_count ="<c:out value='${caCnt}'/>";
	var pa_count ="<c:out value='${paCnt}'/>";
	
	/*if(rca_count == 0){
		 $("#rcaChecked").hide();
	}else{
		 $("#rcaChecked").show();
	}
	*/
	
	if(ca_count == 0){
		 $("#caChecked").hide();
	}else{
		 $("#caChecked").show();
	}
	
	if(pa_count == 0){
		 $("#paChecked").hide();
	}else{
		 $("#paChecked").show();
	}
	
	// for RCA
	/*$('#rcaCheck').click(function () {
		if ($(this).is(':checked')) {
			 $("#rcaChecked").show(400);
			
		 } else {
			  $("#rcaChecked").hide(400);
			
		}
	});
*/
	
	
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

	if ($('#caCheck').is(':checked')) {
		 $("#caChecked").show(400);
		
	 } else {
		  $("#caChecked").hide(400);
		
	}

	if ($('#paCheck').is(':checked')) {
		 $("#paChecked").show(400);
		
	 } else {
		  $("#paChecked").hide(400);
		
	}
	

	// for FURTHER ACTION
	/*$('#furCheck').click(function () {
		if ($(this).is(':checked')) {
			 $("#furChecked").show(400);
			
		 } else {
			  $("#furChecked").hide(400);
			
		}
	});
*/
	// for RECOVERY COST
	$('#recovCheck').click(function () {
		if ($(this).is(':checked')) {
			 $("#recovChecked").show(400);
			
		 } else {
			  $("#recovChecked").hide(400);
			
		}
	});
	
	
});


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

function delActionDesc(typ){
	
	if(typ == 'rca'){
		var count = $('#rcaActionCount').val();
		var rca_count ="<c:out value='${rcaCnt}'/>";
		
		if(count >rca_count){
			var setcnt = parseInt(count-1);
			$("#rcaactiondes"+setcnt).remove();
			$('#rcaActionCount').val(setcnt);
		}else{
			alert('Not Deleted');
		}
			
	}
	else if(typ == 'ca'){
		var count = $('#caActionCount').val();
		var ca_count ="<c:out value='${caCnt}'/>";
		if(count > ca_count){
			var setcnt = parseInt(count-1);
			$("#caactiondes"+setcnt).remove();
			$('#caActionCount').val(setcnt);
		}else{
			alert('Not Deleted');
		}
			
	}
	else{
		var count = $('#paActionCount').val();
		var pa_count ="<c:out value='${paCnt}'/>";
		if(count > pa_count){
			var setcnt = parseInt(count-1);
			$("#paactiondes"+setcnt).remove();
			$('#paActionCount').val(setcnt);

		}else{
			alert('Not Deleted');
		}
	}	
}

function closeModal(){
	//alert('please approve');
	$('#incidentlog_modal').modal('hide');
	$('#incidentlog_description').html('');
}

function showincidentlog(){   
	$('#incidentlog_modal').modal('show');
	var url = '${rootpath}'+'incident/showincidentLog';
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
				
				htm +='<tr id="inc_row_'+(i+1)+'"><td>'+ (i+1) +'.</td><td>'+ item.incNumber + '</td><td>'+ item.incLocation + '</td><td>'+formatDate(item.incDate)+'</td><td>'+ item.incType.name + '</td><td><a href=\"javascript:void(0)\" onclick=\"selectIncident('+ item.id +', '+(i+1)+')\" class=\"btn btn-mini btn-primary\" >Select</a></td></tr>';
	            
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
	//alert(inc_no+'//'+inc_loc+'//'+inc_dt+'//'+inc_typ);
	var htm = '';
	htm+='<div style="padding :5px;">';
	htm+='<div class="span6">Incident Number : <strong>'+inc_no+'</strong></div>';
	htm+='<div class="span6">Incident Type : '+inc_typ+'</div>';
	htm+='<div class="span6">Incident Location : '+inc_loc+'</div>';
	htm+='<div class="span6">Incident Date : '+inc_dt+'</div>';
	htm+='</div>';
	$('#incident_details').show();
	$('#incident_details').html(htm);
	$('#incidentId').val(incId);
	closeModal();
}


////>>>>>>>>>>>>>>>> FOR CAR / PAR START <<<<<<<<<<<<<<<<< ///////

function AddFollowupReport(actnId){
	$('#add_report_form_'+actnId).show();
}


function viewFollowupReport(actionId){
	
	var url = '${rootpath}ajax/viewCaPaFlwupReport';
	$.ajax({
		type :'POST',
		url: url,
		data : { actionId : actionId},
		cache: false,	//IE fix
		beforeSend : function(){ $('#ajax_small_loading_'+actionId).show(); },
		success: function(resp){
			//alert(resp);
			$('#ajax_small_loading_'+actionId).hide();
			$('#view_report_list_'+actionId).html(resp);
			$('#view_report_list_'+actionId).show();
			$('#add_report_form_'+actionId).hide();

			$('#hideFollowupReport_div_'+actionId).show();
			$('#viewFollowupReport_div_'+actionId).hide();
		}
	});
}

function hideFollowupReport(actionId){
	
	$('#viewFollowupReport_div_'+actionId).show();
	$('#hideFollowupReport_div_'+actionId).hide();
	$('#view_report_list_'+actionId).hide();
	$('#add_report_form_'+actionId).hide();
}

function changeCarParStatus(id){

	var val = $("#car_stat_radio_"+id+" input[type='radio']:checked").val();
	//alert(val);
	if(val == 1){
		$("#complete_date_"+id).show();
		$("#complete_description_"+id).show();
		$("#revised_date_"+id).hide();
		$("#revised_description_"+id).hide();
		

	}else{
		
		$("#complete_date_"+id).hide();
		$("#complete_description_"+id).hide();
		$("#revised_date_"+id).show();
		$("#revised_description_"+id).show();
	}
	
}

function saveCarParStatus(actionId, invgId, incId) {

	var url = '${rootpath}ajax/saveCarParStatus';
	var chked_val = $("#car_stat_radio_"+actionId+" input[type='radio']:checked").val();

	var dateVal = $('#compltDate'+actionId).val();
	var description = $('#compltDesc'+actionId).val();
			
	$.ajax({
		type :'POST',
		url: url,
		data : {actionId : actionId, chked_val: chked_val, dateVal : dateVal, description : description, invgId : invgId, incId: incId},
		cache: false,	//IE fix
		success: function(resp){
			if(resp == 1){
				alert('Successfully Submited Report');
				$('#add_report_form_'+actionId).hide();
				viewFollowupReport(actionId);
				
			}else{
				alert('Not Submited');
			}	
			
		}
	});
}

/*****>>>>>>>>>>>>>>>> FOR CAR / PAR END <<<<<<<<<<<<<<<<< ****/


function CloseInvgReport(){
	
	alert("Are You sure want to close the Inciden Investigation?");
	var url = '${rootpath}ajax/closeIncidentStatus';
	var incId =$('#incidentId').val();
	$.ajax({
		type :'POST',
		url: url,
		data : {incId : incId},
		cache: false,	//IE fix
		success: function(resp){
			//alert(resp);
			if(resp == 1){
				alert('Successfully Colsed');
				gotoUrl('${rootpath}incident/followUpInvestigation/invgClosureActionPlan');
							
			}else{
				alert('Not Colse');
			}	
			
		}
	});
}


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

.show{
	display: block;
}
.hide{
	display: none;
}
</style>