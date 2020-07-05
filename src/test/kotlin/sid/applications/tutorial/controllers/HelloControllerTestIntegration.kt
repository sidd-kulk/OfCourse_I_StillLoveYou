package sid.applications.tutorial.controllers

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.net.URI

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // TODO: What does this do?
class HelloControllerIntegrationTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `should return the truth for truth endpoint`(){
        val responseEntity: ResponseEntity<String> = restTemplate.getForEntity<String>(URI("/truth"))
        assertEquals(HttpStatus.OK, responseEntity.statusCode)
        assertThat(responseEntity.body).contains("Time is tough, hang in there")
    }
}