package sid.applications.todo.controllers

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.json.JsonParserFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.boot.test.web.client.postForEntity
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath
import sid.applications.todo.domains.ToDoRequest
import java.net.URI


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class ToDoControllerIntegrationTest (@Autowired val restTemplate: TestRestTemplate) {

    private val headers = HttpHeaders()

    @BeforeEach
    fun beforeAll(){
        headers.contentType = MediaType.APPLICATION_JSON
    }

    @Test
    fun `should get todo items`() {

        val httpEntity = HttpEntity(ToDoRequest("title", "description"), headers)
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

    @Test
    fun `should delete todo item`() {
        val httpEntity = HttpEntity(ToDoRequest("title", "description"), headers)
        restTemplate.postForEntity<String>(URI("/todo"), httpEntity)

        val response = restTemplate.getForEntity<String>("/todo")
        
        val x =  JsonParserFactory.getJsonParser().parseList(response.body) // TODO - Find a more elegant way
        val id = ((x[0] as Map<*,*>)["id"])

        restTemplate.delete("/todo/$id")

        val responseAfterDelete = restTemplate.getForEntity<String>("/todo")
        assertThat(responseAfterDelete.statusCode).isEqualTo(HttpStatus.OK)
        jsonPath("$", responseAfterDelete.body).isEmpty
    }
}