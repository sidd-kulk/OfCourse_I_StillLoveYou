package sid.applications.todo.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import sid.applications.todo.domains.ToDo

@Repository
interface ToDoRepo: CrudRepository<ToDo, Long>