package fun.changing.todo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import fun.changing.todo.core.repository.TodoItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author pi
 * @date 2021/10/03 10:40 PM
 **/
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class TodoItemResourceTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TodoItemRepository repository;

    @Autowired
    private ObjectMapper mapper;

    private TypeFactory factory = TypeFactory.defaultInstance();

    @Test
    public void should_add_item() throws Exception {
        String todoItem = "{" +
                "\"content\": \"foo\"" +
                "}";
        mockMvc.perform(post("/todo-items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(todoItem))
                .andExpect(status().isCreated());

        assertThat(repository.findAll()).anyMatch(item -> item.getContent().equals("foo"));
    }
}
