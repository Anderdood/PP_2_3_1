package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void save(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userDao.save(user);
    }

    @Transactional
    @Override
    public void update(Long id, String name, String email) {
        User user = findById(id);
        if (user != null) {
            user.setName(name);
            user.setEmail(email);
            userDao.update(user);
        }
    }

}
