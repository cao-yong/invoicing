package com.invoicing.core.controller.system;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.invoicing.core.bean.base.BaseResponse;
import com.invoicing.core.bean.base.Page;
import com.invoicing.core.bean.base.ResultBase;
import com.invoicing.core.bean.system.Role;
import com.invoicing.core.bean.system.RoleQueryDTO;
import com.invoicing.core.bean.system.User;
import com.invoicing.core.bean.system.UserDTO;
import com.invoicing.core.bean.system.UserQueryDTO;
import com.invoicing.core.service.system.RoleService;
import com.invoicing.core.service.system.UserService;
import com.invoicing.enums.ErrorCodeEnum;
import com.invoicing.exception.BizException;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户管理
 * 
 * @author caoyong
 * @time 2017年11月15日 下午4:38:48
 */
@Slf4j
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/userList.do")
    public String userList(Model model, UserQueryDTO query) {
        log.info("request userList start,query:{}",
                ToStringBuilder.reflectionToString(query, ToStringStyle.DEFAULT_STYLE));
        try {
            Page<User> page = userService.queryUserPage(query);
            model.addAttribute("page", page);
        } catch (BizException e) {
            log.error("userList BizException:{}", e.getMessage(), e);
        } catch (Exception e) {
            log.error("userList Exception:{}", e.getMessage(), e);
        }
        log.info("request userList end.");
        return "/system/userList";
    }

    @RequestMapping("/newUser.do")
    public String newUser(Model model) {
        log.info("request newUser start.");
        try {
            RoleQueryDTO query = new RoleQueryDTO();
            ResultBase<List<Role>> result = roleService.queryRoleList(query);
            if (result.isSuccess() && !result.getValue().isEmpty()) {
                model.addAttribute("roles", result.getValue());
            }
        } catch (BizException e) {
            log.error("request newUser BizException:{}", e.getMessage(), e);
        } catch (Exception e) {
            log.error("request newUser Exception:{}", e.getMessage(), e);
        }
        log.info("request newUser end.");
        model.addAttribute("user", new User());
        return "/system/userForm";
    }

    @RequestMapping("/editUser.do")
    public String editUser(Model model, Integer id) {
        log.info("request editUser start.");
        try {
            RoleQueryDTO query = new RoleQueryDTO();
            ResultBase<List<Role>> result = roleService.queryRoleList(query);
            if (result.isSuccess() && !result.getValue().isEmpty()) {
                model.addAttribute("roles", result.getValue());
            }
            ResultBase<User> userResult = userService.queryUserRoleById(id);
            if (userResult.isSuccess() && null != userResult.getValue()) {
                model.addAttribute("user", userResult.getValue());
            }
        } catch (BizException e) {
            log.error("request editUser BizException:{}", e.getMessage(), e);
        } catch (Exception e) {
            log.error("request editUser Exception:{}", e.getMessage(), e);
        }
        log.info("request editUser end.");
        return "/system/userForm";
    }

    /**
     * 删除用户
     * 
     * @param id
     * @return
     */
    @RequestMapping("/deleteUser.json")
    @ResponseBody
    public BaseResponse deleteUser(Integer id) {
        log.info("request deleteUser start.");
        BaseResponse resp = new BaseResponse();
        try {
            ResultBase<Integer> result = userService.deleteUserById(id);
            resp.setCode(result.getErrorCode());
            resp.setMsg(result.getErrorMsg());
            resp.setSuccess(result.isSuccess());
        } catch (BizException e) {
            log.error("deleteUser BizException:{}", e.getMessage(), e);
            resp.setMsg(ErrorCodeEnum.UNKOWN_ERROR.getMsg());
        } catch (Exception e) {
            log.error("deleteUser Exception:{}", e.getMessage(), e);
            resp.setMsg(ErrorCodeEnum.UNKOWN_ERROR.getMsg());
        }
        log.info("request deleteUser end.");
        return resp;
    }

    /**
     * 停用、启用 用户
     * 
     * @param id
     * @return
     */
    @RequestMapping("/enableUser.json")
    @ResponseBody
    public BaseResponse enableUser(Integer id) {
        log.info("request enableUser start.");
        BaseResponse resp = new BaseResponse();
        try {
            ResultBase<Integer> result = userService.enableUserById(id);
            resp.setCode(result.getErrorCode());
            resp.setMsg(result.getErrorMsg());
            resp.setSuccess(result.isSuccess());
        } catch (BizException e) {
            log.error("enableUser BizException:{}", e.getMessage(), e);
            resp.setMsg(ErrorCodeEnum.UNKOWN_ERROR.getMsg());
        } catch (Exception e) {
            log.error("enableUser Exception:{}", e.getMessage(), e);
            resp.setMsg(ErrorCodeEnum.UNKOWN_ERROR.getMsg());
        }
        log.info("request enableUser end.");
        return resp;
    }

    @RequestMapping("/isExistUser.json")
    @ResponseBody
    public BaseResponse isExistUser(UserQueryDTO query) {
        BaseResponse resp = new BaseResponse();
        log.info("request isExistUser start, username:{}", query.getUsername());
        try {
            ResultBase<List<User>> users = userService.queryUserList(query);
            if (users.isSuccess() && null != users.getValue() && !users.getValue().isEmpty()) {
                resp.setMsg(ErrorCodeEnum.USER_EXIST.getMsg());
                resp.setCode(ErrorCodeEnum.USER_EXIST.getCode());
            }
            if (users.isSuccess() && users.getValue().isEmpty()) {
                resp.setSuccess(true);
            }
        } catch (BizException e) {
            log.error("request isExistUser BizException:{}", e.getMessage(), e);
            resp.setMsg(ErrorCodeEnum.UNKOWN_ERROR.getMsg());
        } catch (Exception e) {
            resp.setMsg(ErrorCodeEnum.UNKOWN_ERROR.getMsg());
            log.error("request isExistUser Exception:{}", e.getMessage(), e);
        }
        log.info("request isExistUser end.");
        return resp;
    }

    @RequestMapping("/saveUser.json")
    @ResponseBody
    public BaseResponse saveUser(UserDTO userDTO) {
        BaseResponse resp = new BaseResponse();
        log.info("request saveUser start, user:{}",
                ToStringBuilder.reflectionToString(userDTO, ToStringStyle.DEFAULT_STYLE));
        try {
            ResultBase<Integer> result;
            if (null == userDTO.getId()) {
                result = userService.saveUserByUserDTO(userDTO);
            } else {
                result = userService.updateUserByUserDTO(userDTO);
            }
            if (result.isSuccess() && result.getValue() > 0) {
                resp.setSuccess(true);
            }
        } catch (BizException e) {
            log.error("request saveUser BizException:{}", e.getMessage(), e);
            resp.setMsg(ErrorCodeEnum.UNKOWN_ERROR.getMsg());
        } catch (Exception e) {
            resp.setMsg(ErrorCodeEnum.UNKOWN_ERROR.getMsg());
            log.error("request saveUser Exception:{}", e.getMessage(), e);
        }
        log.info("request saveUser end.");
        return resp;
    }
}
