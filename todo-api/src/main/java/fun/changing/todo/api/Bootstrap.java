package fun.changing.todo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author pi
 * @date 2021/10/03 9:59 PM
 **/

@SpringBootApplication
@EnableJpaRepositories("fun.changing.todo.core")
@EntityScan("fun.changing.todo.core")
@ComponentScan("fun.changing.todo")
public class Bootstrap {
    public static void main(final String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }
}
