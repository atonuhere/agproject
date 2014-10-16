<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="/struts-tags" prefix="s" %>

<h4>Runtime Error Occurred!!</h4>
<p><s:actionerror /> </p>
<p>Exception Name: <s:property value="exception" /> </p>  
<p>Exception Details: <s:property value="exceptionStack" /></p>  