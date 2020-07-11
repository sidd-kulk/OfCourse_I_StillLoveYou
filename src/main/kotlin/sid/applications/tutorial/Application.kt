package sid.applications.tutorial

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application // Empty class

fun main(args: Array<String>) {
    val context = runApplication<Application>(*args) {
        setBannerMode(Banner.Mode.CONSOLE)
    }
    context.beanDefinitionNames.sorted().forEach { println(it) }
}
