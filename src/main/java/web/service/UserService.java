package web.service;


import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User findById(Long id);

    public void delete(Long id);

    @Transactional
    void save(String name, String email);

    void update(Long id, String name, String email);
}
