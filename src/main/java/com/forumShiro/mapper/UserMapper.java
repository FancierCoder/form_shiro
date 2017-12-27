package com.forumShiro.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.forumShiro.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 李铎
 * @since 2017-12-01
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);
}