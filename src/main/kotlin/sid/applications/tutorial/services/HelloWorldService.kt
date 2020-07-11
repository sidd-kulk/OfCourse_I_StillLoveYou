package sid.applications.tutorial.services

import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service // SPECIALIZATION OF @COMPONENT
class HelloWorldService {
    @PostConstruct
    fun sayHelloIn() {
        println { "Get this working" }
    }
}