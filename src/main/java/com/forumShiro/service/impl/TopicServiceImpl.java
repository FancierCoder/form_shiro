package com.forumShiro.service.impl;

import com.forumShiro.model.Topic;
import com.forumShiro.mapper.TopicMapper;
import com.forumShiro.service.TopicService;
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
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {

}
