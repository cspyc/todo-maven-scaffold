package fun.changing.todo.core.exception;

/**
 * @author pi
 * @date 2021/10/06 10:56 PM
 **/
public class TodoItemException extends RuntimeException {
    public TodoItemException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
