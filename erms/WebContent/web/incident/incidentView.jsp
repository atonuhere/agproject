<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib uri="http://bibeault.org/tld/ccc" prefix="ccc" %>
<ccc:constantsMap className="com.gfs.erm.web.common.WebConstants" var="Constants"/>   
<c:set value="${Constants.DISPLAY_CAL_CONVERT_DATE_FORMAT}" var="datefrmt" scope="request"></c:set> 
<c:set value="${Constants.DISPLAY_INC_CATEGORY}" var="incCategory" scope="request"></c:set>  

<c:if test="${control eq 'incidentlog'}">
<div class="clear"></div>
	<div class="upper_content_heading" style="">
		<span style=""></span>
	</div>	
	
<div class="box_content" id="view_incidentlog_div">
	
	
<fieldset class="custom_fieldset">
<legend class="custom_legend">Details of Incident Log [ ${incident.incNumber} ]</legend>


<div class="row-fluid">

	<div class="span12">
		<div class="span6"> <!-- FIRST COLUMN -->
			<label style="margin-bottom: 18px;">
				<span class="bold">Reported by	: </span>${incident.reportedBy}
			</label>
			<label style="margin-bottom: 18px;">
				<span class="bold">Reported On : </span>
				<c:set var="reportedOn" value="${incident.reportedOn}" />
				<fmt:formatDate pattern="${request.datefrmt}" value="${reportedOn}" />
			</label>
		</div>
		
		<div class="span6">
			<label><span class="bold">Reporter Details : </span></label>${incident.reporterDetails}
		</div>
	</div>
	<div class="span6">
		<label>
			<span class="bold">Location of Incident : </span>${incident.incLocation}
		</label>
	</div>
	
	<div class="span6">
		<label>
			<span class="bold">Name of the Responsible Branch : </span>${incident.branchName}
		</label>
	</div>
	
	<div class="span6">
		<label>
			<span class="bold">Date of Incident : </span>
			<c:set var="incDate" value="${incident.incDate}" />
			<fmt:formatDate pattern="${request.datefrmt}" value="${incDate}" />
		</label>
	
	</div>
		
	<div class="span6"> 
		<label> <span class="bold">Type of the Incident : </span>${incident.incidentType}</label>
		
	</div>
	<div class="span6"> 
		<label><span class="bold">Incident Category : </span> ${incident.incCategory}</label>
		
	</div>
	
	
	<div class="span6"> 
	
		<label><span class="bold">Brief Description of Incident : </span></label>
		${incident.descriptions}
	</div>
	<div class="span6">
		<label><span class="bold">Action taken (after discovery of incident) : </span></label>
		${incident.actionTaken} 
	</div>
	
	
	<div class="span6">
		<label><span class="bold">Remarks : </span></label>
		${incident.remarks} 
	</div>
	<div class="span6"> 
		<label>
			<span class="bold">Incident Logged By : </span>
			<c:if test="${incident.loggedBy eq 0}">Admin</c:if>
			
		</label>
		<label><span class="bold">Status : </span>${incident.incidentStatus}</label>
	</div>
	
</div>

</fieldset>
</div>
</c:if>


<c:if test="${control=='invgReport'}">

<div class="clear"></div>
	<div class="upper_content_heading" style="">
		<span style=""></span>
	</div>	
	
<div class="box_content" id="view_incidentlog_div">
	
	
<fieldset class="custom_fieldset">
<legend class="custom_legend">Investigation Details of Incident #${invgReport.incId.incNumber}</legend>


<div class="row-fluid">

	<div class="span12">
		<div class="span6"> <!-- FIRST COLUMN -->
			<label style="margin-bottom: 18px;">
				<span class="bold">Incident Number : </span>${invgReport.incId.incNumber}
			</label>
			
		</div>
		
		<div class="span6">
			<label><span class="bold">Incident Type : </span>${invgReport.incId.incType.name}</label>
		</div>
	</div>
	<div class="span6">
		<label>
			<span class="bold">Location of Incident : </span>${invgReport.incId.incLocation}
		</label>
	</div>
	
	<div class="span6">
		<label>
			<span class="bold">Date of Incident : </span>
			<c:set var="incDate" value="${invgReport.incId.incDate}" />
			<fmt:formatDate pattern="${request.datefrmt}" value="${incDate}" />
		</label>
	
	</div>
		
	<div class="span12" style="min-height:52px;"> 
	<span class="bold">Root Cause Analysis : </span>
	
		<c:choose>
			<c:when test="${invgActionsList != null}">
			<fieldset class="custom_fieldset_mid_pad">
				<c:forEach items="${invgActionsList}" var="item" varStatus="status">
				<c:if test="${item.type=='1'}"> 
					<div> <strong>${status.count} . </strong>${item.actionDesc}</div>
				</c:if>
				</c:forEach>
			</fieldset>	
			</c:when>
			<c:otherwise>
				<div class="error">RCA Not Found</div>
			</c:otherwise>
		</c:choose>
	</div>
	
	<c:if test="${invgReport.caRequired eq true}">
		<div class="span12" style="min-height:52px;"> 
			<span class="bold">Corrective Action Analysis : </span>
			<c:choose>
				<c:when test="${invgActionsList != null}">
				<c:set var="cnt" value="1"></c:set>
				<fieldset class="custom_fieldset_mid_pad">
					<c:forEach items="${invgActionsList}" var="item" >
					<c:if test="${item.type=='2'}"> 
						<div> <strong>${cnt} . </strong>${item.actionDesc}</div>
						<c:set var="cnt" value="${cnt+1}"></c:set>
					</c:if>
					</c:forEach>
					<c:if test="${cnt=='1'}"> 
						<div class="error">CA Not Found</div>
					</c:if>
				</fieldset>	
				</c:when>
				<c:otherwise>
					<div class="error">CA Not Found</div>
				</c:otherwise>
			</c:choose>
		</div>
		
	</c:if>
	
	
	<c:if test="${invgReport.paRequired eq true}">
		<div class="span12" style="min-height:52px;"> 	
			<span class="bold">Preventive Action Analysis : </span>
			<c:choose>
				<c:when test="${invgActionsList != null}">
				<c:set var="cnt" value="1"></c:set>
				<fieldset class="custom_fieldset_mid_pad">
					<c:forEach items="${invgActionsList}" var="item" >
					<c:if test="${item.type=='3'}"> 
						<div> <strong>${cnt} . </strong>${item.actionDesc}</div>
						<c:set var="cnt" value="${cnt+1}"></c:set>
					</c:if>
					
					</c:forEach>
					<c:if test="${cnt=='1'}"> 
						<div class="error">PA Not Found</div>
					</c:if>
				</fieldset>	
				</c:when>
				<c:otherwise>
					<div class="error">PA Not Found</div>
				</c:otherwise>
			</c:choose>
		</div>
	
	</c:if>	
	
	
	<!--<c:if test="${invgReport.furActionRequired eq true}">
		<div class="span12">
			<label><span class="bold">Further Action : </span></label>
			<label>${invgReport.furAction}</label>
		</div>
	</c:if>-->
	
	<c:if test="${invgReport.recovCostReq eq true}">
		<div class="span12">
			<label><span class="bold">Recovery Cost : </span>${invgReport.recovCost}</label>
		</div>
	</c:if>
	
	<div class="bs-callout bs-callout-danger"  style="clear: both;" ><strong>Status : <span style="color:#1E1EDF;">${invgReport.incId.incstatus.status}</span></strong></div>
	
	
	
</div>

</fieldset>
</div>
</c:if>






<c:if test="${control=='invgCarPar'}">

<fieldset class="custom_fieldset">
<legend class="custom_legend">View CAR / PAR </legend>


	<c:if test="${invgReport.incId.incstatus.id >= 4 && invgReport.incId.incstatus.id < 6}">
		<div class="bs-callout bs-callout-danger">
			<span class="bold error">CA/PA Assigned. Please Acknowledge the Assignment.</span>
		</div>
	</c:if>	
			
	<div class="row-fluid" style="margin : 10px 0px;">
		<s:hidden name="control" value="%{control}"></s:hidden>
		<s:hidden name="invgReport.incId.id" id="incidentId" value="%{invgReport.incId.id}"></s:hidden>
		<s:hidden name="invgReport.id" id="incidentId" value="%{invgReport.id}"></s:hidden>
		<s:hidden name="incidentStatusId" id="incidentStatusId" value="%{invgReport.incId.incstatus.id}"></s:hidden>
		<strong>Incident Details : </strong>
	</div>
	
	<div class="row-fluid span12" id="incident_details" style="margin-left : 0px; border: 1px solid; border-radius:5px;">
	
		<div style="padding :10px;">
			<div class="span6">Incident Number : <strong>${invgReport.incId.incNumber}</strong></div>
			<div class="span6">Incident Type : ${invgReport.incId.incType.name}</div>
			<div class="span6">Incident Location : ${invgReport.incId.incLocation}</div>
			<div class="span6">Incident Date : 
				<c:set var="incDate" value="${invgReport.incId.incDate}" />
				<fmt:formatDate pattern="${request.datefrmt}" value="${incDate}" />
			</div>
		</div>
		
	</div>
		
	<div class="row-fluid" style="margin-bottom: 10px; padding-top: 10px; clear: both;"><strong>Root Cause Analysis : </strong></div>
	
	<div class="row-fluid span12" style="margin-left : 0px; border: 1px solid; border-radius:5px; ">
		<c:choose>
			<c:when test="${fn:length(invgActionsRCAList) gt 0}">
				<c:forEach items="${invgActionsRCAList}" var="item" varStatus="status" >
				 	<div class="span12" style="padding :10px"> 
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
	
	<div class="row-fluid"  style="padding-top: 10px; clear: both;" ><strong>Corrective Action Analysis : </strong></div>
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
	
	
	<div class="row-fluid" style="margin-top : 10px;" ><strong>Preventive Action Analysis : </strong></div>
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
	
	<div class="bs-callout bs-callout-danger"  style="clear: both;" ><strong>Status : <span style="color:#1E1EDF;">${invgReport.incId.incstatus.status}</span></strong></div>
	

</fieldset>

</c:if>







<c:if test="${control=='invgClosureActionPlan'}">

<fieldset class="custom_fieldset">
<legend class="custom_legend">View Closure of Actions Plans </legend>
	<div class="row-fluid">
		<s:hidden name="control" value="%{control}"></s:hidden>
		<s:hidden name="invgReport.incId.id" id="incidentId" value="%{incidentlog.id}"></s:hidden>
		<s:hidden name="invgReport.id" id="" value="%{invgReport.id}"></s:hidden>
		<s:hidden name="incidentStatusId" id="incidentStatusId" value="%{incidentlog.incstatus.id}"></s:hidden>
		<strong>Incident Details : </strong>
	</div>
	
	<div class="row-fluid span12" id="incident_details" style="margin-left : 0px; border: 1px solid; border-radius:5px;">
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
	<div class="divider_no_border"></div>
			
	<div class="row-fluid"><strong>Root Cause Analysis : </strong></div>
	<div class="row-fluid span12" style="margin-left : 0px; border: 1px solid; border-radius:5px;">
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
	<div class="divider_no_border"></div>
	
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
	<div class="divider_no_border"></div>
	
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
	
	<div class="bs-callout bs-callout-danger"  style="clear: both;" ><strong>Status : <span style="color:#1E1EDF;">${incidentlog.incstatus.status}</span></strong></div>
	
</fieldset>


</c:if>





<div style="margin-top : 100px; display: none;" class="loading"></div>

<script type="text/javascript">


function viewFollowupReport(actionId){
	
	var url = '${rootpath}ajax/viewCaPaFlwupReport';
	$.ajax({
		type :'POST',
		url: url,
		data : { actionId : actionId} ,
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


</script>

<style>
.row-fluid [class*="span"] {
    margin-left: 0%;
   
}
.row-fluid .span6{
	margin-bottom: 18px;
}
.bold{  
	font-weight: bold;
	color: #000000;
}
.box_content fieldset{
 	padding-left: 30px;
    padding-right: 30px;
}
.custom_fieldset_mid_pad{
	padding-left: 10px!important;
    padding-right: 10px!important;
    padding-top: 7px!important;
    padding-bottom: 7px!important;
    margin:10px 0px;
}
</style>