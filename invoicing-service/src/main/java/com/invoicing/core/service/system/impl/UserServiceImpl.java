package com.invoicing.core.service.system.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicing.common.utils.EncodeUtil;
import com.invoicing.common.web.Constants;
import com.invoicing.core.bean.base.Page;
import com.invoicing.core.bean.base.ResultBase;
import com.invoicing.core.bean.system.Role;
import com.invoicing.core.bean.system.RoleUser;
import com.invoicing.core.bean.system.RoleUserQuery;
import com.invoicing.core.bean.system.User;
import com.invoicing.core.bean.system.UserDTO;
import com.invoicing.core.bean.system.UserQuery;
import com.invoicing.core.bean.system.UserQuery.Criteria;
import com.invoicing.core.bean.system.UserQueryDTO;
import com.invoicing.core.dao.system.RoleUserDao;
import com.invoicing.core.dao.system.UserDao;
import com.invoicing.core.service.system.UserService;
import com.invoicing.enums.ErrorCodeEnum;
import com.invoicing.exception.BizException;
import com.invoicing.utils.BeanConvertionHelp;
import com.invoicing.utils.CheckParamsUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 后台用户Service实现
 * 
 * @author caoyong
 * @time 2017年11月16日 上午11:29:06
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao     userDao;
    @Autowired
    private RoleUserDao roleUserDao;

    @Override
    public ResultBase<List<User>> queryUserList(UserQueryDTO query) throws BizException {
        ResultBase<List<User>> result = new ResultBase<>();
        log.info("queryUserList start. query:{}",
                ToStringBuilder.reflectionToString(query, ToStringStyle.DEFAULT_STYLE));
        try {
            UserQuery example = new UserQuery();
            Criteria criteria = example.createCriteria().andIsDeletedEqualTo(Constants.CONSTANTS_N);
            if (StringUtils.isNotBlank(query.getUsername())) {
                criteria.andUsernameEqualTo(query.getUsername());
            }
            List<User> users = userDao.selectByExample(example);
            result.setValue(users);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setErrorCode(ErrorCodeEnum.UNKOWN_ERROR.getCode());
            result.setErrorMsg(ErrorCodeEnum.UNKOWN_ERROR.getMsg());
            log.error("queryUserList error:", e.getMessage(), e);
        }
        log.info("queryUserList end.");
        return result;
    }

    @Override
    public Page<User> queryUserPage(UserQueryDTO query) throws BizException {
        log.info("queryUserPage start. query:{}",
                ToStringBuilder.reflectionToString(query, ToStringStyle.DEFAULT_STYLE));
        Page<User> page = new Page<>();
        try {
            UserQuery example = new UserQuery();
            int count = userDao.countByExample(example);
            example.setPageNo(query.getPageNo());
            example.setPageSize(query.getLimit());
            example.setStartRow(query.getStart());
            Criteria criteria = example.createCriteria().andIsDeletedEqualTo(Constants.CONSTANTS_N);
            if (StringUtils.isNotBlank(query.getUsername())) {
                criteria.andUsernameEqualTo(query.getUsername());
            }
            List<User> rows = userDao.selectByExample(example);
            //设置结果及分页对象
            if (null != rows && !rows.isEmpty()) {
                log.info("queryUserPage results:{}", count);
                log.info("queryUserPage rows:{}",
                        ToStringBuilder.reflectionToString(rows, ToStringStyle.DEFAULT_STYLE));
                page.setStart(query.getStart());
                page.setResults(count);
                page.setLimit(query.getLimit());
                page.setPage(query.getPage());
                page.setPageNo(query.getPageNo());
                page.setRows(rows);
                page.setIsSuccess(true);
            }
            //分页展示
            String url = "/user/userList.do";
            page.pageView(url, null);
        } catch (Exception e) {
            log.error("queryUserPage error:{}", e.getMessage(), e);
            page.setError("数据库查询用户分页失败");
            page.setErrorCode(e.getMessage());
            page.setErrorCode(e.getMessage());
            page.setResults(0);
        }
        log.info("queryUserPage end.");
        return page;
    }

    @Override
    public ResultBase<User> queryUserById(Integer id) throws BizException {
        log.info("queryUserById start id:{}", id);
        ResultBase<User> result = new ResultBase<>();
        try {
            User menu = userDao.selectByPrimaryKey(id);
            result.setSuccess(true);
            result.setValue(menu);
        } catch (Exception e) {
            result.setErrorCode(ErrorCodeEnum.UNKOWN_ERROR.getCode());
            result.setErrorMsg(ErrorCodeEnum.UNKOWN_ERROR.getMsg());
            log.error("queryUserById error:{}", e.getMessage(), e);
        }
        log.info("queryUserById end.");
        return result;
    }

    @Override
    public ResultBase<Integer> updateUserByUserDTO(UserDTO userDTO) throws BizException {
        log.info("updateUserByUserDTO start.menuDTO:{}",
                ToStringBuilder.reflectionToString(userDTO, ToStringStyle.DEFAULT_STYLE));
        ResultBase<Integer> result = new ResultBase<>();
        try {
            CheckParamsUtil.check(userDTO, UserDTO.class, "id");
            User record = BeanConvertionHelp.copyBeanFieldValue(User.class, userDTO);
            if (StringUtils.isNotBlank(userDTO.getPassword())) {
                //查询用户
                User user = userDao.selectByPrimaryKey(userDTO.getId());
                if (!user.getPassword().equals(userDTO.getPassword())) {
                    record.setPassword(EncodeUtil.encodePassword(userDTO.getPassword()));
                }
            }
            record.setUpdateTime(new Date());
            int count = userDao.updateByPrimaryKeySelective(record);
            //更新角色用户
            //1.查询出当前用户所有的角色
            RoleUserQuery example = new RoleUserQuery();
            example.createCriteria().andUserIdEqualTo(String.valueOf(userDTO.getId()));
            List<RoleUser> roleUsers = roleUserDao.selectByExample(example);
            //用户所选的角色id
            List<String> roleUserIds = userDTO.getRoleIdList().stream().map(String::valueOf)
                    .collect(Collectors.toList());
            //用户本次要删除的角色
            List<String> delRoleUserIds;
            //用户本次要新增的角色
            List<String> newRoleUserIds = new ArrayList<>();
            if (roleUserIds != null && !roleUserIds.isEmpty()) {
                //2.筛选出所有需要删除的roleUserIds,在用户原来的所有角色中不包含所选的，即需要删除的
                delRoleUserIds = roleUsers.stream().filter(roleUser -> !roleUserIds.contains(roleUser.getRoleId()))
                        .map(RoleUser::getRoleId).collect(Collectors.toList());
                if (null != delRoleUserIds && !delRoleUserIds.isEmpty()) {
                    userDTO.setIsDeleted(Constants.CONSTANTS_Y);
                    userDTO.setRoleIds(delRoleUserIds);
                    count += updateRoleUserIsDeletedByUserDTO(userDTO).getValue();
                }
                //3.所有要新增的roleUserIds，所选角色中在原来角色中找不到的，需要新增
                roleUserIds.stream().forEach(roleId -> {
                    boolean noneMatch = roleUsers.stream().noneMatch(roleUser -> roleUser.getRoleId().equals(roleId));
                    if (noneMatch) {
                        newRoleUserIds.add(roleId);
                    }
                });
                //新增，调用批量插入方法
                if (!newRoleUserIds.isEmpty()) {
                    count += roleUserDao.insertBatch(record);
                }
                //4.找出原来删除过的，这次又需要添加的
                List<String> updateRoleUserIds = roleUsers.stream()
                        .filter(roleUser -> Constants.CONSTANTS_Y.equals(roleUser.getIsDeleted())
                                && roleUserIds.contains(roleUser.getRoleId()))
                        .map(RoleUser::getRoleId).collect(Collectors.toList());
                if (null != updateRoleUserIds && !updateRoleUserIds.isEmpty()) {
                    userDTO.setRoleIds(updateRoleUserIds);
                    userDTO.setIsDeleted(Constants.CONSTANTS_N);
                    count += updateRoleUserIsDeletedByUserDTO(userDTO).getValue();
                }
            } else {
                //所有的都不选，删除该用户所有的角色
                if (null != roleUsers && !roleUsers.isEmpty()) {
                    RoleUser roleUserRecord = new RoleUser();
                    roleUserRecord.setIsDeleted(Constants.CONSTANTS_Y);
                    roleUserRecord.setUpdateTime(new Date());
                    count += roleUserDao.updateByExampleSelective(roleUserRecord, example);
                }
            }
            if (count > 0) {
                result.setValue(count);
            }
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("updateUserByUserDTO Exception:{}", e.getMessage(), e);
            result.setErrorCode(ErrorCodeEnum.UNKOWN_ERROR.getCode());
            result.setErrorMsg(ErrorCodeEnum.UNKOWN_ERROR.getMsg());
            throw new BizException(ErrorCodeEnum.UNKOWN_ERROR, e.getMessage(), e);
        }
        log.info("updateUserByUserDTO end.");
        return result;
    }

    @Override
    public ResultBase<Integer> saveUserByUserDTO(UserDTO userDTO) throws BizException {
        log.info("saveUserByUserDTO start.menuDTO:{}",
                ToStringBuilder.reflectionToString(userDTO, ToStringStyle.DEFAULT_STYLE));
        ResultBase<Integer> result = new ResultBase<>();
        try {
            User record = BeanConvertionHelp.copyBeanFieldValue(User.class, userDTO);
            record.setCreateTime(new Date());
            record.setUpdateTime(new Date());
            record.setPassword(EncodeUtil.encodePassword(userDTO.getPassword()));
            record.setIsDeleted(Constants.CONSTANTS_N);
            record.setModifier(Constants.SYSTEM);
            record.setCreator(Constants.SYSTEM);
            record.setIsEnable(userDTO.isUseable() ? 1 : 0);
            int count = userDao.insertSelective(record);
            //保存角色用户
            count += roleUserDao.insertBatch(record);
            result.setSuccess(true);
            result.setValue(count);
        } catch (Exception e) {
            log.error("saveUserByUserDTO Exception:{}", e.getMessage(), e);
            result.setErrorCode(ErrorCodeEnum.UNKOWN_ERROR.getCode());
            result.setErrorMsg(ErrorCodeEnum.UNKOWN_ERROR.getMsg());
            throw new BizException(ErrorCodeEnum.UNKOWN_ERROR, e.getMessage(), e);
        }
        log.info("saveUserByUserDTO end.");
        return result;
    }

    @Override
    public ResultBase<Integer> deleteUserById(Integer id) throws BizException {
        log.info("deleteUserById start. id:{}", id);
        ResultBase<Integer> result = new ResultBase<>();
        if (null == id) {
            throw new BizException(ErrorCodeEnum.PARAMETER_CAN_NOT_BE_NULL.getMsg(), id + "为空");
        }
        try {
            User record = new User();
            record.setId(id);
            record.setIsDeleted(Constants.CONSTANTS_Y);
            record.setUpdateTime(new Date());
            int count = userDao.updateByPrimaryKeySelective(record);
            if (count > 0) {
                result.setValue(count);
            }
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("deleteUserById Exception:{}", e.getMessage(), e);
            result.setErrorCode(ErrorCodeEnum.UNKOWN_ERROR.getCode());
            result.setErrorMsg(ErrorCodeEnum.UNKOWN_ERROR.getMsg());
            throw new BizException(ErrorCodeEnum.UNKOWN_ERROR, e.getMessage(), e);
        }
        log.info("deleteUserById end,{} row(s) affected", result.getValue());
        return result;
    }

    @Override
    public ResultBase<Integer> updateRoleUserIsDeletedByUserDTO(UserDTO userDTO) throws BizException {
        log.info("deleteRoleMenuByRoleDTO start.roleDTO:{}",
                ToStringBuilder.reflectionToString(userDTO, ToStringStyle.DEFAULT_STYLE));
        ResultBase<Integer> result = new ResultBase<>();
        try {
            int count = 0;
            RoleUserQuery example = new RoleUserQuery();
            example.createCriteria().andUserIdEqualTo(String.valueOf(userDTO.getId()))
                    .andRoleIdIn(userDTO.getRoleIds());
            RoleUser record = new RoleUser();
            record.setIsDeleted(userDTO.getIsDeleted());
            record.setUpdateTime(new Date());
            count += roleUserDao.updateByExampleSelective(record, example);
            result.setSuccess(true);
            result.setValue(count);
        } catch (Exception e) {
            result.setErrorCode(ErrorCodeEnum.UNKOWN_ERROR.getCode());
            result.setErrorMsg(ErrorCodeEnum.UNKOWN_ERROR.getMsg());
            log.error("deleteRoleMenusByRoleDTO error:{}", e.getMessage(), e);
        }
        log.info("deleteRoleMenusByRoleDTO end.");
        return result;
    }

    @Override
    public ResultBase<User> queryUserRoleById(Integer id) throws BizException {
        log.info("queryUserRoleById start id:{}", id);
        ResultBase<User> result = new ResultBase<>();
        try {
            User user = userDao.selectByPrimaryKey(id);
            List<Role> roles = userDao.selectUserRoleById(id);
            result.setSuccess(true);
            if (user != null && roles != null && !roles.isEmpty()) {
                user.setRoles(roles);
            }
            result.setValue(user);
        } catch (Exception e) {
            result.setErrorCode(ErrorCodeEnum.UNKOWN_ERROR.getCode());
            result.setErrorMsg(ErrorCodeEnum.UNKOWN_ERROR.getMsg());
            log.error("queryUserRoleById error:{}", e.getMessage(), e);
        }
        log.info("queryUserRoleById end.");
        return result;
    }

    @Override
    public ResultBase<User> queryUserAndRolesByUsername(String username) throws BizException {
        log.info("queryUserAndRolesByUsername start. username:{}", username);
        ResultBase<User> result = new ResultBase<>();
        try {
            User user = userDao.queryUserAndRolesByUsername(username);
            if (null != user) {
                result.setSuccess(true);
                result.setValue(user);
            }
        } catch (Exception e) {
            result.setErrorCode(ErrorCodeEnum.UNKOWN_ERROR.getCode());
            result.setErrorMsg(ErrorCodeEnum.UNKOWN_ERROR.getMsg());
            log.error("queryUserAndRolesByUsername error:{}", e.getMessage(), e);
        }
        log.info("queryUserAndRolesByUsername end.");
        return result;
    }

    @Override
    public ResultBase<Integer> updateUserOperateDateByUserId(Integer userId) throws BizException {
        log.info("updateUserOperateDateByUserId start, userId:{}", userId);
        ResultBase<Integer> result = new ResultBase<>();
        try {
            User user = new User();
            user.setId(userId);
            user.setOperateDate(new Date());
            userDao.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            result.setErrorCode(ErrorCodeEnum.UNKOWN_ERROR.getCode());
            result.setErrorMsg(ErrorCodeEnum.UNKOWN_ERROR.getMsg());
            log.error("updateUserOperateDateByUserId error:{}", e.getMessage(), e);
        }
        log.info("updateUserOperateDateByUserId end.");
        return null;
    }

    @Override
    public ResultBase<Integer> enableUserById(Integer id) throws BizException {
        log.info("enableUserById start.id:{}", id);
        ResultBase<Integer> result = new ResultBase<>();
        try {
            //查询用户
            User user = userDao.selectByPrimaryKey(id);
            Integer isEnable = user.getIsEnable();
            //更新
            User updateUser = new User();
            updateUser.setId(id);
            updateUser.setIsEnable(isEnable == 0 ? 1 : 0);
            updateUser.setUpdateTime(new Date());
            userDao.updateByPrimaryKeySelective(updateUser);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("enableUserById Exception:{}", e.getMessage(), e);
            result.setErrorCode(ErrorCodeEnum.UNKOWN_ERROR.getCode());
            result.setErrorMsg(ErrorCodeEnum.UNKOWN_ERROR.getMsg());
            throw new BizException(ErrorCodeEnum.UNKOWN_ERROR, e.getMessage(), e);
        }
        log.info("enableUserById end.");
        return result;
    }

}
