package com.invoicing.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.invoicing.core.bean.base.ResultBase;
import com.invoicing.core.bean.system.Menu;
import com.invoicing.core.bean.system.User;
import com.invoicing.core.service.system.MenuService;
import com.invoicing.exception.BizException;

import lombok.extern.slf4j.Slf4j;

/**
 * 后台管理
 * 
 * @author yong.cao
 * @since 2017年6月1日下午10:59:02
 */

@RequestMapping(value = "/control")
@Controller
@Slf4j
public class CenterController {
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/index.do")
    public String index(Model model, HttpServletRequest request) {
        log.info("index start");
        try {
            HttpSession session = request.getSession();
            User currentUser = (User) session.getAttribute("currentUser");
            //查询出页面的菜单
            ResultBase<List<Menu>> result = menuService.queryMenuListByUser(currentUser);
            List<Menu> menus = result.getValue();
            model.addAttribute("menus", menus);
            model.addAttribute("currentUser", currentUser);

        } catch (BizException e) {
            log.error("index BizException:{}", e.getMessage(), e);
        } catch (Exception e) {
            log.error("index Exception:{}", e.getMessage(), e);
        }
        log.info("index end.");
        return "index";
    }

    @RequestMapping(value = { "/login.do" })
    public String login() {
        return "/system/login";
    }
}
