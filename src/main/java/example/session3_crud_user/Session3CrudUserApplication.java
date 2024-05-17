package example.session3_crud_user;

import example.session3_crud_user.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Session3CrudUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(Session3CrudUserApplication.class, args);
    }

    @Bean(name = "USER_BEAN")
    public User setUser() {
        User u = new User();
        u.setUsername("admin");
        u.setPassword("a123");
        return u;
    }

}
