package user.backend.dao;

import user.backend.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository("UserRepository")
public class JdbcUserRepository implements UserDao{

   @Autowired
   private JdbcTemplate jdbcTemplate;


    @Override
    public int insertUser(User user) {
        String sql = "INSERT INTO USERS (UNAME, PWORD) VALUES (?,?)";
        return jdbcTemplate.update(sql,
                new Object[] {user.getUname(), user.getPword()});
    }

    @Override
    public int updateUser(String uname, User user) {
        String sql = "UPDATE USERS SET UNAME=?, PWORD=? WHERE UNAME =?";
        return jdbcTemplate.update(sql, new Object[] {user.getUname(), user.getPword(), uname});

    }

    @Override
    public int deleteUser(String uname) {
        String sql = "DELETE FROM USERS WHERE UNAME=?";
        return jdbcTemplate.update(sql,uname);
    }

    @Override
    public Optional<User> queryUser(String uname) {
        User user = null;
        try {
            String sql = "SELECT * FROM USERS WHERE UNAME=?";
            user = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(User.class),uname);
            return Optional.ofNullable(user);
        }
        catch(IncorrectResultSizeDataAccessException e){
            return Optional.ofNullable(user);
        }
    }
//Used to validate login
    @Override

    public User findUserByName(String uname) {

       User user = new User();
        try {
            String sql = "SELECT * FROM USERS WHERE UNAME=?";
            user = jdbcTemplate.queryForObject(sql,
                    BeanPropertyRowMapper.newInstance(User.class), uname);
            return user;
        }
        catch (IncorrectResultSizeDataAccessException e){
            return user;
        }

    }

    @Override
    public List<User> queryUsers(){
        String sql = "SELECT * FROM USERS";
        return jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(User.class));
    }
}
