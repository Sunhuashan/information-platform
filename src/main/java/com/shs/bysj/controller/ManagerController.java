package com.shs.bysj.controller;

import com.shs.bysj.pojo.Manager;
import com.shs.bysj.pojo.ManagerRole;
import com.shs.bysj.pojo.Role;
import com.shs.bysj.result.Result;
import com.shs.bysj.result.ResultFactory;
import com.shs.bysj.service.IManagerMenuService;
import com.shs.bysj.service.IManagerRoleService;
import com.shs.bysj.service.IManagerService;
import com.shs.bysj.service.IRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class ManagerController {

    @Autowired
    private IManagerService managerService;
    @Autowired
    private IManagerMenuService managerMenuService;
    @Autowired
    private IManagerRoleService managerRoleService;
    @Autowired
    private IRoleService roleService;

    /**
     * 管理员登录
     */

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/admin/manager_login")
    public Result managerLogin(@RequestBody Manager manager) {

        String username = manager.getManagerUsername();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token =
                new UsernamePasswordToken(username, manager.getManagerPassword());
        try {
            subject.login(token);

            System.out.println(SecurityUtils.getSubject().getPrincipal().toString());

            return ResultFactory.buildSuccessResult("登录成功");
        } catch (AuthenticationException e) {
            return ResultFactory.buildFailResult("用户名或密码错误");
        }
    }

    /**
     * 找到当前管理员有权访问的资源
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/admin/manager_menu")
    public Result getMenuByCurrentManager(@RequestBody Manager manager){
        System.out.println(manager.toString());
        return  ResultFactory.buildSuccessResult(managerMenuService.getMenuByManager(manager));
    }

    /**
     * 找到所有管理员及其角色
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/api/admin/manager_show")
    public Result managerShow() {
       // String name = SecurityUtils.getSubject().getPrincipal().toString();
       // System.out.println(name);
        List<Manager> list = managerService.findAllManager();
        for (Manager manager : list) {
            List<Long> rids = managerRoleService.findAllByManagerId(manager.getId())
                    .stream().map(ManagerRole::getRoleId).collect(Collectors.toList());
            manager.setRoleList(roleService.findAllRoleByIds(rids));
        }
        return ResultFactory.buildSuccessResult(list);
    }

    /**
     * 删除管理员
     * @param manager
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "api/admin/manager_delete")
    public Result managerDelete(@RequestBody Manager manager) {
        Manager managerDB = managerService.findManagerByManagerName(manager.getManagerUsername());
        String name = managerDB.getManagerUsername();
        Long id = managerDB.getId();
        try {
            //删除管理员信息
            managerService.deleteManagerByManagerUsername(name);
            //删除管理员角色信息
            managerRoleService.deleteAllByManagerId(id);
            return ResultFactory.buildSuccessResult(null);
        } catch (Exception e){
            return ResultFactory.buildFailResult(null);
        }
    }

    /**
     * 添加模块管理员
     * @param manager
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/admin/addManager")
    public Result managerAdd(@RequestBody Manager manager) {
        boolean exist = managerService.isExist(manager.getManagerUsername());
        if(exist) {
            return ResultFactory.buildFailResult("用户名已存在！");
        } else {
            /**
             * 生成盐，并对用户密码进行加密,添加到数据库中
             */
            String salt = new SecureRandomNumberGenerator().nextBytes().toString();
            int times = 3;
            String encodePassword = new SimpleHash("md5", manager.getManagerPassword(), salt, times).toString();
            manager.setManagerSalt(salt);
            manager.setManagerPassword(encodePassword);
            managerService.addManager(manager);
            /**
             * 获取用户被分配的角色列表，添加到数据库中
             */
            List<Role> roleList = manager.getRoleList();
            Manager managerDB = managerService.findManagerByManagerName(manager.getManagerUsername());
            Long id = managerDB.getId();
            List<ManagerRole> managerRoleList = new ArrayList<>();
            for (Role role : roleList) {
                managerRoleList.add(new ManagerRole(id,role.getId()));
            }
            managerRoleService.addAllManagerRole(managerRoleList);
            return ResultFactory.buildSuccessResult(null);
        }
    }

    /**
     * 重置密码为： 000000
     * @param manager
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/admin/resetPassword")
    public Result resetPassword(@RequestBody Manager manager) {
        //初始密码：admin
        String initialPassword = "admin";
        String name = manager.getManagerUsername();
        Manager managerDB = managerService.findManagerByManagerName(name);
        String salt = managerDB.getManagerSalt();
        String encodePassword = new SimpleHash("md5",initialPassword,salt,3).toString();
        managerDB.setManagerPassword(encodePassword);
        //主键存在即更新，否则添加
        try{
            managerService.addManager(managerDB);
            return ResultFactory.buildSuccessResult(null);
        } catch (Exception e) {
            return ResultFactory.buildFailResult(null);
        }

    }


    /**
     * 更新管理员角色等信息
     * @param manager
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/admin/updateManager")
    public Result updateManager(@RequestBody Manager manager) {
        Manager managerDB = managerService.findManagerByManagerName(manager.getManagerUsername());
        // 根据id将当前拥有的角色删除
        managerRoleService.deleteAllByManagerId(managerDB.getId());
        //向数据库中添加新的角色信息
        List<ManagerRole> managerRoleList = new ArrayList<>();
        for (Role role : manager.getRoleList()) {
            managerRoleList.add(new ManagerRole(managerDB.getId(),role.getId()));
        }
        try{
            managerRoleService.addAllManagerRole(managerRoleList);
            return ResultFactory.buildSuccessResult(null);
        } catch (Exception e) {
            return ResultFactory.buildFailResult(null);
        }
    }

}
