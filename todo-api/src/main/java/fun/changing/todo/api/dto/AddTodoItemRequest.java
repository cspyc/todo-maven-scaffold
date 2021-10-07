package fun.changing.todo.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @author pi
 * @since 2021/10/06 10:48 PM
 **/
public class AddTodoItemRequest {

    @Getter
    private String content;

    @JsonCreator
    public AddTodoItemRequest(@JsonProperty("content") final String content) {
        this.content = content;
    }
}
