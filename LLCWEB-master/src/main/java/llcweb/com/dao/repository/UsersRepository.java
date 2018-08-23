package llcweb.com.dao.repository;


import llcweb.com.domain.models.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by:Ricardo
 * Description: 用户类的repository类
 * Date: 2018/8/21
 * Time: 13:36
 */
 //Integer 是id 的类型
public interface UsersRepository extends JpaRepository<Users,Integer>{
    Page<Users> findAll(Specification<Users> spec, Pageable pageable);
    Users findByUsernameAndPassword(String userName, String password);
    Users findByUsername(String userName);

    Users save(String Users);

    //通过姓名查询
    public List<Users> findByUsersname(String usersname);
}
