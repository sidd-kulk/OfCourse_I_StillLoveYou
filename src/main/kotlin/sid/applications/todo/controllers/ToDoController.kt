package sid.applications.todo.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import sid.applications.todo.domains.ToDo
import sid.applications.todo.domains.ToDoRequest
import sid.applications.todo.repositories.ToDoRepo

@RestController
@RequestMapping("/todo")
class ToDoController(@Autowired private val toDoRepo: ToDoRepo) {
    @GetMapping
    fun getTodos(): List<ToDo> {
        return toDoRepo.findAll().toList()
    }

    @PostMapping
    fun createTodo(@RequestBody todo: ToDoRequest): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.CREATED)
    }
}