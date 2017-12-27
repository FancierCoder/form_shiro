package com.forumShiro.service.impl;

import com.forumShiro.model.Menu;
import com.forumShiro.mapper.MenuMapper;
import com.forumShiro.service.MenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author 李铎
 * @since 2017-12-26
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
