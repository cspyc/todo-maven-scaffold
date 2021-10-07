package fun.changing.todo.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @author pi
 * @date 2021/10/06 11:45 PM
 **/
public class MarkAsDoneRequest {
    @Getter
    private boolean done;

    @JsonCreator
    public MarkAsDoneRequest(@JsonProperty("done") final boolean done) {
        this.done = done;
    }
}
