package sid.applications.todo.domains

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class ToDo (@Id @GeneratedValue var id: Long? = null,
            var title: String,
            var description: String,
            var time: LocalDateTime = LocalDateTime.now()) {

    override fun toString(): String {
        return "ToDo with title $title, deescription $description and created at $time"
    }
}


class ToDoRequest(
    var title: String,
    var description: String
)