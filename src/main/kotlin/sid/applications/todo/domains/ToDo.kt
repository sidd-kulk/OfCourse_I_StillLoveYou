package sid.applications.todo.domains

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class ToDo (@Id @GeneratedValue var id: Long?,
            var title: String,
            var description: String,
            var time: LocalDateTime)