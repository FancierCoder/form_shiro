package com.forumShiro.service.impl;

import com.forumShiro.model.RoleMenu;
import com.forumShiro.mapper.RoleMenuMapper;
import com.forumShiro.service.RoleMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色与菜单对应关系 服务实现类
 * </p>
 *
 * @author 李铎
 * @since 2017-12-26
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

}
