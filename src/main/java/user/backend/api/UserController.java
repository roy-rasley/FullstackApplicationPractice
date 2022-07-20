package user.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Controller needs the model and the service to function
import user.backend.model.User;
import user.backend.service.UserService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "users")//localhost:8080/users/
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Default homepage
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    int insertUser(@RequestBody User user){return userService.insertUser(user);}

    //PUT mapping(Update function)
    @PutMapping(value = "{uname}")
    int updateUser(@PathVariable("uname") String uname, @RequestBody User user){
        return userService.updateUser(uname, user);
    }

    //DELETE mapping(Delete function)
    @DeleteMapping(value = "{uname}")
    int deleteUser(@PathVariable("uname") String uname){
        return userService.deleteUser(uname);
    }

    //GET mapping(QueryUser function)
    @GetMapping(value = "{uname}")
    Optional <User> queryUser(@PathVariable("uname") String uname){
        return userService.queryUser(uname);
    }

    //GET mapping(QueryUsers function)
    @GetMapping
    List<User> queryUsers() {return userService.queryUsers();}




    //User login
    @PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> loginUser(@RequestBody User userData){
        System.out.println(userData);
        User user = userService.findUserByName(userData.getUname());
        if(user.getPword().equals(userData.getPword())){
            return ResponseEntity.ok(user);
        }
        return (ResponseEntity<?>) ResponseEntity.internalServerError();

    }
}
