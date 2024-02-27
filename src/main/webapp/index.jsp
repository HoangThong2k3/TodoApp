<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ToDo List</title>
</head>
<body>

<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="Entity.ToDoEntity" %>

<header>
</header>>
<body>
<h2>ToDo List</h2>

<!-- Display ToDo items -->

    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Plan Start</th>
        <th>Plan End</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>

<%
    // Lấy danh sách từ request attribute
    List<ToDoEntity> list = (List<ToDoEntity>) request.getAttribute("list");
    if (list != null) {
    // Hiển thị danh sách
    for (ToDoEntity todo : list) {
%>
<p>ID: <%= todo.getId() %></p>
<p>Name: <%= todo.getName() %></p>
<p>Description: <%= todo.getDescription() %></p>
<p>Plan Start: <%= todo.getPlanStart() %></p>
<p>Plan End: <%= todo.getPlanEnd() %></p>
<p>Status: <%= todo.getStatus() %></p>
<hr>
<%
    }}
%>
</table>

<!-- Link to create a new ToDo -->
</body>
</html>
