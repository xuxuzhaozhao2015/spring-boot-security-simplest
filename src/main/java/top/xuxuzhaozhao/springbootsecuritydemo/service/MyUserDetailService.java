package top.xuxuzhaozhao.springbootsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // System.out.println("--------------用户名：" + s + "---------------");
        // String password = passwordEncoder.encode("123456");
        // System.out.println("--------------123456加密后：" + password + "---------------");

        String password = userService.findPasswordByUserName(s);
        if(password == null){
            return null;
        }
        password = passwordEncoder.encode(password);

        Collection<GrantedAuthority> authList = getAuthorities();

        return new User(s,password, authList);
    }

    /**
     * 获取用户的角色权限,为了降低实验的难度，这里去掉了根据用户名获取角色的步骤
     */
    private Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority("PRODUCT_ADD"));
        authList.add(new SimpleGrantedAuthority("PRODUCT_UPDATE"));
        return authList;

    }
}
