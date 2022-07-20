package user.backend.dao;


import user.backend.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    //ORDER
    //DAO -> ObjectRepository -> ObjectService -> ObjectController

    //INSERT USER
    int insertUser(User user);

    //UPDATE USER
    int updateUser(String uname, User user);

    //DELETE USER
    int deleteUser(String uname);

    //GET USER BY NAME
    Optional <User> queryUser(String uname);

    //GET ALL USERS
    List <User> queryUsers();

    //THIS FUNCTION IS USED FOR THE LOGIN
    User findUserByName(String uname);


}
