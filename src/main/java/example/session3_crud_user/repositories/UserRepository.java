package example.session3_crud_user.repositories;

import example.session3_crud_user.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
