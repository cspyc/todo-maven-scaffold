package fun.changing.todo.api.resource;

import com.google.common.base.Strings;
import fun.changing.todo.api.dto.AddTodoItemRequest;
import fun.changing.todo.api.dto.MarkAsDoneRequest;
import fun.changing.todo.core.dto.TodoParameter;
import fun.changing.todo.core.entity.TodoItem;
import fun.changing.todo.core.service.TodoItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * @author pi
 * @date 2021/10/03 10:31 PM
 **/
@RestController
@RequestMapping("/todo-items")
public class TodoItemResource {
    private final TodoItemService service;

    public TodoItemResource(final TodoItemService todoItemService) {
        this.service = todoItemService;
    }

    @PostMapping
    public ResponseEntity addTodoItem(@RequestBody final AddTodoItemRequest request) {
        if (Strings.isNullOrEmpty(request.getContent())) {
            return ResponseEntity.badRequest().build();
        }

        final TodoParameter parameter = TodoParameter.of(request.getContent());
        final TodoItem item = this.service.addTodoItem(parameter);

        final URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getIndex())
                .toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity markAsDone(@PathVariable("id") final int id, @RequestBody final MarkAsDoneRequest request) {
        return ResponseEntity.ok().build();
    }
}
