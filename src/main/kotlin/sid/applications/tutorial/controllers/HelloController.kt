package sid.applications.tutorial.controllers

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
internal class HelloController {

    @GetMapping("/truth")
    fun truth(model: Model): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return "Time is tough, hang in there.  ${LocalDateTime.now().format(formatter)}"
    }

}