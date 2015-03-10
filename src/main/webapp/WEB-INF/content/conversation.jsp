<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<h1>Conversation example</h1>
<br/>

<s:textfield label="Input that should not change" />
<br/>

<table style="width:50%" border="1">
    <tr>
        <td><b>Hotel name</b></td>
        <td><b>Capacity</b></td>
    </tr>
    <s:iterator value="hotels">
        <tr>
            <td><s:property value="name"/></td>
            <td><s:property value="capacity"/></td>
        </tr>
    </s:iterator>
</table>
