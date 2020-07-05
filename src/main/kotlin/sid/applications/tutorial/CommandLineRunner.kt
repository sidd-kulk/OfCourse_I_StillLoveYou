package sid.applications.tutorial

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CommandLineRunner: CommandLineRunner {
    override fun run(vararg args: String?) {
        println("Application Started.  Go on, hit the URL")
    }
}