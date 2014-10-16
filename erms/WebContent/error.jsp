<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="/struts-tags" prefix="s" %>

<h4 class="title">Error Occurred!!</h4>

<div class="alert alert-danger">
	${message}
	<s:actionerror/>
	<s:actionmessage/>
</div>
<p>Exception object transfered to valuestack <s:property value="[0].top"/></p>
<p><s:property value="%{exception.message}"/></p>
<p>Exception Details: <s:property value="exceptionStack" /></p>