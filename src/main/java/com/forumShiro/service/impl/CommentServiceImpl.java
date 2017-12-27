package com.forumShiro.service.impl;

import com.forumShiro.model.Comment;
import com.forumShiro.mapper.CommentMapper;
import com.forumShiro.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
