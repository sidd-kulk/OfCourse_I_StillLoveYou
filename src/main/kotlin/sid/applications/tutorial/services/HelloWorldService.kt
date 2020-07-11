package sid.applications.tutorial.services

import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class HelloWorldService {
    @PostConstruct
    fun sayHelloIn() {
        println { "Get this working" }
    }
}