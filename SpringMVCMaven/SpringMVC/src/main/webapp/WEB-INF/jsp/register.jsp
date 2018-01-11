<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
            <link href="/SpringMVC/src/main/webapp/WEB-INF/css/logincss.css" type="text/css" rel="stylesheet" />
        </head>
        <body>
            <form:form id="regForm" modelAttribute="emp" action="registerProcess" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="id">id</form:label>
                        </td>
                        <td>
                            <form:input path="id" name="id" id="id" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="name">Name</form:label>
                        </td>
                        <td>
                            <form:input path="name" name="name" id="name" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="dept">Dept</form:label>
                        </td>
                        <td>
                            <form:input path="dept" name="dept" id="dept" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="age">Age</form:label>
                        </td>
                        <td>
                            <form:input path="age" name="age" id="age" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="salary">salary</form:label>
                        </td>
                        <td>
                            <form:input path="salary" name="salary" id="salary" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="location">location</form:label>
                        </td>
                        <td>
                            <form:input path="location" name="location" id="location" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <form:button id="register" name="register">Register</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                    
                </table>
            </form:form>
        </body>
        </html>