package user.backend.service;

import org.springframework.beans.factory.annotation.Qualifier;
import user.backend.dao.UserDao;
import org.springframework.stereotype.Service;
import user.backend.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(@Qualifier("UserRepository") UserDao userDao) {
        this.userDao = userDao;
    }

    public int insertUser(User user){
        return userDao.insertUser(user);
    }

    public int deleteUser(String uname){
        return userDao.deleteUser(uname);
    }

    public int updateUser(String uname, User user){
        return userDao.updateUser(uname, user);
    }

    public Optional<User> queryUser(String uname){
        return userDao.queryUser(uname);
    }

    public List <User> queryUsers(){return userDao.queryUsers();}

//Used for the login function
    public User findUserByName(String uname) {

        return userDao.findUserByName(uname);

    }


}
