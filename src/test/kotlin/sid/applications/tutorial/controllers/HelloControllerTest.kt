package sid.applications.tutorial.controllers

import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
internal class HelloControllerTest (@Autowired val mockMvc: MockMvc) {

    @Test
    fun `should return the truth for truth endpoint`() {
        mockMvc.perform( get("/truth"))
               .andDo(print())
               .andExpect(status().isOk)
               .andExpect(content().string(containsString("Time is tough, hang in there")))
    }
}