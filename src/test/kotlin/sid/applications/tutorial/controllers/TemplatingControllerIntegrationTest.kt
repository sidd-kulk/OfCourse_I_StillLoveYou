package sid.applications.tutorial.controllers

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import java.net.URI

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class TemplatingControllerIntegrationTest(@Autowired val restTemplate: TestRestTemplate) {
    @Test
    fun `get simple template`(){
        val responseEntity = restTemplate.getForEntity<String>(URI("/template"))
        Assertions.assertEquals(HttpStatus.OK, responseEntity.statusCode)
        assertThat(responseEntity.body).contains("Simple Template Tutorial")
    }
}