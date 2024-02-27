<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ToDo List</title>
</head>
<body>

<h2>ToDo List</h2>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Plan Start</th>
        <th>Plan End</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="todo" items="${todoList}">
        <tr>
            <td>${todo.id}</td>
            <td>${todo.name}</td>
            <td>${todo.description}</td>
            <td>${todo.planStart}</td>
            <td>${todo.planEnd}</td>
            <td>${todo.status}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
