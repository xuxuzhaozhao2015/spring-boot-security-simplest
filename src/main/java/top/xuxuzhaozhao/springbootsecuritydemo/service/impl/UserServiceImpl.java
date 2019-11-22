package top.xuxuzhaozhao.springbootsecuritydemo.service.impl;

import org.springframework.stereotype.Service;
import top.xuxuzhaozhao.springbootsecuritydemo.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

    /**
     * 模拟操作数据库
     * @param username
     * @return
     */
    @Override
    public String findPasswordByUserName(String username) {
        if(username.equals("admin")){
            return "123456";
        }
        return null;
    }
}
