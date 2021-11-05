<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<h2>Task-details</h2>
<br>

<form:form action="saveTask" modelAttribute="task">

    <form:hidden path="id"/>

    Task <form:input path="task"/>
    <br><br>
    Priority <form:input path="priority"/>
    <br><br>
    Status <form:input path="status"/>
    <br><br>
    <input type="submit" value="OK">


</form:form>


</body>
</html>