package fun.changing.todo.core;

import fun.changing.todo.core.dto.TodoParameter;
import fun.changing.todo.core.entity.TodoItem;
import fun.changing.todo.core.repository.TodoItemRepository;
import fun.changing.todo.core.service.TodoItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author pi
 * @date 2021/10/06 11:11 PM
 **/
public class TodoItemServiceTest {
    private TodoItemService service;
    private TodoItemRepository repository;

    @BeforeEach
    public void setUp() {
        this.repository = mock(TodoItemRepository.class);
        this.service = new TodoItemService(this.repository);
    }

    @Test
    public void should_add_todo_item() throws Exception {
        when(repository.save(any())).then(returnsFirstArg());
        TodoItem item = service.addTodoItem(TodoParameter.of("foo"));
        assertThat(item.getContent()).isEqualTo("foo");

        verify(repository).save(any());
    }

    @Test
    public void should_throw_exception_for_null_todo_item() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->service.addTodoItem(null));

    }
}
