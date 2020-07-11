package sid.applications.todo

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ToDoApplication // Empty class

fun main(args: Array<String>) {
    val context = runApplication<ToDoApplication>(*args) {
        setBannerMode(Banner.Mode.CONSOLE)
    }
}
