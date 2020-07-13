package sid.applications.todo.services

import sid.applications.extensions.uniqueBy
import sid.applications.todo.domains.ToDo

class ToDoService {

    fun todosByDate(todos: List<ToDo>): List<ToDo> {
        return todos.sortedByDescending { it.time }
    }

    fun overlappingTodos(todos: List<ToDo>) = todos.uniqueBy { it.title }
}




