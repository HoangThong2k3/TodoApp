package TodoRepository;

import Entity.ToDoEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoRepository {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/todoapp";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "123456789";


    public TodoRepository() {
    }

    // Tạo kết nối đến cơ sở dữ liệu
    private Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ToDoEntity getToDoById(int todoId) {
        ToDoEntity todo = null;
        try {
            String query = "SELECT * FROM ToDoTable WHERE id = ?";
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, todoId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String description = resultSet.getString("description");
                        Date planStart = resultSet.getDate("planStart");
                        Date planEnd = resultSet.getDate("planEnd");
                        int status = resultSet.getInt("status");

                        todo = new ToDoEntity(name, description, planStart, planEnd, status, id);
                        todo.setId(id);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todo;
    }

    public void updateToDo(ToDoEntity todo) {
        try {
            String query = "UPDATE ToDoTable SET name = ?, description = ?, planStart = ?, planEnd = ?, status = ? WHERE id = ?";
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, todo.getName());
                preparedStatement.setString(2, todo.getDescription());
                preparedStatement.setDate(3, new java.sql.Date(todo.getPlanStart().getTime()));
                preparedStatement.setDate(4, new java.sql.Date(todo.getPlanEnd().getTime()));
                preparedStatement.setInt(5, todo.getStatus());
                preparedStatement.setInt(6, todo.getId());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteToDo(int todoId) {
        try {
            String query = "DELETE FROM ToDoTable WHERE id = ?";
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, todoId);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<ToDoEntity> getAllToDos() {
        List<ToDoEntity> todos = new ArrayList<>();
        try {
            String query = "SELECT * FROM ToDoTable";
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    Date planStart = resultSet.getDate("planStart");
                    Date planEnd = resultSet.getDate("planEnd");
                    int status = resultSet.getInt("status");

                    ToDoEntity todo = new ToDoEntity(name, description, planStart, planEnd, status, id);
                    todo.setId(id);
                    todos.add(todo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }

}

