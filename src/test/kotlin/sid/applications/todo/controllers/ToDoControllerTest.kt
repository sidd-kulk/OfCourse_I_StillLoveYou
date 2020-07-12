package sid.applications.todo.controllers

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.boot.test.web.client.postForEntity
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import sid.applications.todo.domains.ToDoRequest
import java.net.URI
import javax.print.attribute.standard.Media

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class ToDoControllerTest (@Autowired val restTemplate: TestRestTemplate) {

    private val headers = HttpHeaders()

    @BeforeEach
    fun beforeAll(){
        headers.contentType = MediaType.APPLICATION_JSON
    }

    @Test
    fun getTodos() {

        val httpEntity = HttpEntity(ToDoRequest("abcd", "abcd"), headers)
        restTemplate.postForEntity<String>(URI("/todo"), httpEntity)

        val response = restTemplate.getForEntity<String>("/todo")

        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).contains("abcd")
    }

    @Test
    fun `should create todo item with title and description`() {
        val httpEntity = HttpEntity(ToDoRequest("", ""), headers)
        val response = restTemplate.postForEntity<String>(URI("/todo"), httpEntity)
        assertThat(response.statusCode).isEqualTo(HttpStatus.CREATED)
    }
}