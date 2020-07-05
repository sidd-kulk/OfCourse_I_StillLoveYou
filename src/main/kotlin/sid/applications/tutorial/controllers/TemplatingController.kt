package sid.applications.tutorial.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class TemplatingController {

    @GetMapping("/template")
    fun simpleTemplate(model: Model): String {
        val viewName = "simple-template"
        model["templateName"] = "simple"
        model["templateHeader"] = "Simple Template Tutorial"
        model["templateFont"] = "bold"
        return viewName
    }
}