<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<head>
    <script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
</head>

<h1>Conversation example</h1>

<s:form>

    <div id="container">
        <table style="width:50%" border="1">
            <tr>
                <td><b>Hotel name</b></td>
                <td><b>Capacity</b></td>
            </tr>
            <s:iterator value="hotels">
                <tr>
                    <td><s:property value="name"/></td>
                    <td><s:textfield type="text" name="capacity"/></td>
                </tr>
            </s:iterator>
        </table>
    </div>

    <s:submit value="Add new row" method="addRow"/>

</s:form>