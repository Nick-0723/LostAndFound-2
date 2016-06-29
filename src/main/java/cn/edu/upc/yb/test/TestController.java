package cn.edu.upc.yb.test;

import cn.edu.upc.yb.model.User;
import cn.edu.upc.yb.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yyljj on 16-6-16.
 */
@RestController
//@Controller
public class TestController {

    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "/prams", method = RequestMethod.GET)
    public Page<User> page(@RequestParam(value = "page", defaultValue = "0") Integer page,
                           @RequestParam(value = "size", defaultValue = "15") Integer size) {
        Pageable pageable = new PageRequest(page,size);
        return userDao.findAll(pageable);

    }


}