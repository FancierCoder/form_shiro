package com.forumShiro.service.impl;

import com.forumShiro.model.Friend;
import com.forumShiro.mapper.FriendMapper;
import com.forumShiro.service.FriendService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 好友列表 服务实现类
 * </p>
 *
 * @author 李铎
 * @since 2017-12-01
 */
@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend> implements FriendService {

}
