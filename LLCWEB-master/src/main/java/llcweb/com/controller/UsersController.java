package llcweb.com.controller;

import llcweb.com.dao.repository.UsersRepository;
import llcweb.com.domain.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create by: Huang
 * Despcription:
 * Date: 2018/8/23/023
 * Time: 10:11
 */
@RestController
public class UsersController {

    
    @Autowired
    private UsersRepository usersRepository;
    private Object Users;

    /**
     * 查询所有Users列表
     * @return
     */
    @GetMapping(value = "/users")
    public List<llcweb.com.domain.models.Users> UsersList(){
        return usersRepository.findAll();
    }

    /**
     * 添加一个Users
     * @param usersname
     * @return
     */
    @PostMapping(value = "/users")
    public Users usersAdd(@RequestParam("usersname") String usersname,
                          @RequestParam("password") String password){
        Users users = new Users();
        users.setUsername(usersname);
        users.setPassword(password);

        return usersRepository.save((String) Users);
    }

    /**
     * 查询一个Users
     * @param id
     * @return
     */
    @GetMapping(value = "/users/{id}")
    public Users usersFindOne(@PathVariable("id") Integer id){
        return usersRepository.findOne(id);
    }

    /**
     * 更新一个Users
     * @param id
     * @param usersname
     * @param password
     * @return
     */
    @PutMapping(value = "/users/{id}")
    public Users usersUpdate(@PathVariable("id") Integer id,
                            @RequestParam("usersname") String usersname,
                            @RequestParam("password") String password){
        Users users = new Users();
        users.setId(id);
        users.setUsername(usersname);
        users.setPassword(password);

        return usersRepository.save((String) Users);
    }

    /**
     * 删除一个Users
     * @param id
     */
    @DeleteMapping(value = "/users/{id}")
    public void UsersDelete(@PathVariable("id") Integer id){
        usersRepository.delete(id);
    }

    /**
     * 通过姓名查询
     * @param usersname
     * @return
     */
    @GetMapping(value="/Users/usersname{usersname}")
    public List<Users> usersListByUsersname(@PathVariable("usersname") String usersname){
        return usersRepository.findByUsersname(usersname);
    }
}
