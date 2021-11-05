<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2>All Tasks</h2>
<br>

<table>
    <tr>
        <th>Task</th>
        <th>Priority</th>
        <th>Status</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="tas" items="${allTas}">

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="tasId" value="${tas.id}"/>
    </c:url>

        <c:url var="deleteButton" value="/deleteTask">
            <c:param name="tasId" value="${tas.id}"/>


        </c:url>

        <tr>
            <td>${tas.task}</td>
            <td>${tas.priority}</td>
            <td>${tas.status}</td>
            <td>
                <input type="button" value="Update"
                onclick="window.location.href = '${updateButton}'"/>

                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>

    </c:forEach>

</table>
<br>

<input type="button" value="Add task"
    onclick="window.location.href = 'addNewTask'"/>

</body>

</html>