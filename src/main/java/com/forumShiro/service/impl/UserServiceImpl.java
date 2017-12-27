package com.forumShiro.service.impl;

import com.forumShiro.model.User;
import com.forumShiro.mapper.UserMapper;
import com.forumShiro.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 李铎
 * @since 2017-12-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
