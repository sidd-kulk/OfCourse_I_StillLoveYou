package sid.applications.tutorial.controllers

import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
internal class TemplatingControllerTest(@Autowired val mockMvc: MockMvc) {

    @Test
    fun `should return template content`(){
        mockMvc.perform(get("/template"))
               .andExpect(status().isOk)
               .andExpect { containsString("Simple Template Tutorial") }
    }
}