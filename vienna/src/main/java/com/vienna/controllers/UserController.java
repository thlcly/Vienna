package com.vienna.controllers;


import com.vienna.commons.JsonResult;
import com.vienna.commons.ServiceException;
import com.vienna.domain.tables.pojos.TUser;
import com.vienna.serivces.UserService;
import com.vienna.utils.Md5Util;
import com.vienna.vos.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

import static com.vienna.commons.ApiError.USER_DELETE_FAIL;
import static com.vienna.commons.ApiError.USER_MD5_ENCRYPT_FAIL;
import static com.vienna.controllers.ViennaRoutes.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = USER_ROOT)
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户登录
     *
     * @author ys
     * @createTime 2016年9月19日
     * @description:
     */
    @RequestMapping(value = USER_LOGIN, method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public JsonResult login(TUser u) {
        try {
            String pwd = Md5Util.sign(u.getPassword(), "UTF-8");
            userService.login(u.getName(), pwd).orElseThrow(() -> new ServiceException("用户名或者密码不正确"));
            return JsonResult.ok();
        } catch (Exception e) {
            log.error("密码加密出错");
            return JsonResult.error(USER_MD5_ENCRYPT_FAIL);
        }
    }

    /**
     * 注册或者是修改取决于是否传有id
     *
     * @author ys
     * @createTime 2016年9月19日
     * @description:
     */
    @RequestMapping(value = USER_SAVEORUPDATE, method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public JsonResult saveUser(User user) {
        if (user.getId() == null) {
            String encryptedPwd = encryptPwd(user.getPassword()).orElseThrow(() -> new ServiceException("保存用户失败"));
            user.setPassword(encryptedPwd);
        }
        return userService.saveOrUpdate(user) ? JsonResult.ok() : JsonResult.error();
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = USER_DELETE, method = DELETE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public JsonResult delete(Integer userId) {
        return userService.delete(userId) ? JsonResult.ok() : JsonResult.error(USER_DELETE_FAIL);
    }

    /*======================================= 私有方法 =======================================*/

    private Optional<String> encryptPwd(String password) {

        try {
            return Optional.of(Md5Util.sign(password));
        } catch (Exception e) {
            log.error("MD5加密失败", e);
            return Optional.empty();
        }
    }

}
