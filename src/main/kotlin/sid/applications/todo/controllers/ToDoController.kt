package sid.applications.todo.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import sid.applications.todo.domains.ToDo
import sid.applications.todo.repositories.ToDoRepo

@RestController
@RequestMapping("/todo")
class ToDoController(@Autowired val toDoRepo: ToDoRepo) {
    @GetMapping
    fun getTodos(): List<ToDo> {
        return toDoRepo.findAll().toList()
    }
}