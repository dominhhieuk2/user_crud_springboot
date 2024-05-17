package example.session3_crud_user.services;

import example.session3_crud_user.models.User;
import example.session3_crud_user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public List<User> saveAll(List<User> entities) {
        return (List<User>)userRepository.saveAll(entities);
    }

    @Override
    public Optional<User> findById(String s) {
        return userRepository.findById(s);
    }

    @Override
    public boolean existsById(String s) {
        return userRepository.existsById(s);
    }

    @Override
    public List<User> findAll() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public List<User> findAllById(List<String> ids) {
        return (List<User>)userRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void deleteById(String s) {
        userRepository.deleteById(s);
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    @Override
    public void deleteAllById(List<String> strings) {
        userRepository.deleteAllById(strings);
    }

    @Override
    public void deleteAll(List<User> entities) {
        userRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public boolean checkLogin(String username, String password) {
        Optional<User> optionalUser = findById(username);
        if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(password)) {
            return true;
        }
        return false;
    }


}
