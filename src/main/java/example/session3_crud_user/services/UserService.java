package example.session3_crud_user.services;

import example.session3_crud_user.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User entity);

    List<User> saveAll(List<User> entities);

    Optional<User> findById(String s);

    boolean existsById(String s);

    List<User> findAll();

    List<User> findAllById(List<String> ids);

    long count();

    void deleteById(String s);

    void delete(User entity);

    void deleteAllById(List<String> strings);

    void deleteAll(List<User> entities);

    void deleteAll();

    boolean checkLogin(String username, String password);
}
