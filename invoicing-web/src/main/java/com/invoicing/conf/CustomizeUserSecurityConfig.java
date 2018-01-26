package com.invoicing.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.invoicing.core.bean.base.ResultBase;
import com.invoicing.core.bean.system.Role;
import com.invoicing.core.bean.system.User;
import com.invoicing.core.service.system.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * 登录验证逻辑
 *
 * @author yong.cao
 * @since 2017年12月28日上午10:35:02
 */
@Slf4j
@Component
public class CustomizeUserSecurityConfig implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        try {
            ResultBase<User> resultBase = userService.queryUserAndRolesByUsername(username);
            if (resultBase.isSuccess() && resultBase.getValue() != null) {
                user = resultBase.getValue();
            }
            if (user != null) {
                //用于添加用户的权限。把用户权限添加到authorities
                for (Role role : user.getRoles()) {
                    authorities.add(new SimpleGrantedAuthority(role.getName()));
                }
                log.info("user:{} login success", user.getUsername());
            } else {
                log.info("user:{} not exist", username);
                return null;
            }
        } catch (Exception e) {
            log.error("loadUserByUsername error:{}", e.getMessage(), e);
            return null;
        }
        return new MyUserDetail(user.getUsername(), user.getPassword(), authorities, user.getId(), user.getRoles(),
                user.getName(), user.getOperateDate());
    }

}
