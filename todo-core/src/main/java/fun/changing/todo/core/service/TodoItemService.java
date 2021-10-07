/**
 * @author Me
 *
 */
package fun.changing.todo.core.service;

import fun.changing.todo.core.dto.TodoParameter;
import fun.changing.todo.core.entity.TodoItem;
import fun.changing.todo.core.repository.TodoItemRepository;
import org.springframework.stereotype.Service;

/**
 * @author pi
 * @since 2021/10/06 10:57 PM
 **/
@Service
public class TodoItemService {
    /**
     * TodoItem repository 数据存储
     */
    private final TodoItemRepository repository;

    /**
     * 构造函数
     *
     * @param repository 数据存储
     */
    public TodoItemService(final TodoItemRepository repository) {
        this.repository = repository;
    }

    /**
     * 添加item项目
     *
     * @param parameter 项目入参
     * @return 添加的项目结果
     */
    public TodoItem addTodoItem(final TodoParameter parameter) {
        if (parameter == null) {
            throw new IllegalArgumentException("Null or empty content is not allowed");
        }
        final TodoItem item = new TodoItem(parameter.getContent());
        return this.repository.save(item);
    }
}
