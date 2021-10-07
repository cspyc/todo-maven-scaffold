package fun.changing.todo.core.repository;

import fun.changing.todo.core.entity.TodoItem;
import org.springframework.data.repository.Repository;

/**
 * @author pi
 * @date 2021/10/03 11:55 PM
 **/
public interface TodoItemRepository extends Repository<TodoItem, Long> {


    /**
     * 返回所有数据
     *
     * @return 查询结果
     */
    Iterable<TodoItem> findAll();

    TodoItem save(TodoItem todoItem);
}
