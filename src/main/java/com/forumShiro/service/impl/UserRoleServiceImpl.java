package com.forumShiro.service.impl;

import com.forumShiro.model.UserRole;
import com.forumShiro.mapper.UserRoleMapper;
import com.forumShiro.service.UserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与角色对应关系 服务实现类
 * </p>
 *
 * @author 李铎
 * @since 2017-12-26
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
