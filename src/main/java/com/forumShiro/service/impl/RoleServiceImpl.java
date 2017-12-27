package com.forumShiro.service.impl;

import com.forumShiro.model.Role;
import com.forumShiro.mapper.RoleMapper;
import com.forumShiro.service.RoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author 李铎
 * @since 2017-12-26
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
