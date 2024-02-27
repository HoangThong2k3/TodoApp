import Entity.ToDoEntity;
import TodoRepository.TodoRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestTodoRepository {

    TodoRepository todoRepository = new TodoRepository();

    @Test
    public void testGetAllToDos() {
         List<ToDoEntity> todoList = todoRepository.getAllToDos();
         for (ToDoEntity todo : todoList) {
             System.out.println(todo.getName());
         }
    }
}
