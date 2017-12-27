import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.forumShiro.mapper.CommentMapper;
import com.forumShiro.model.Comment;
import com.forumShiro.model.User;
import com.forumShiro.service.UserService;
import com.forumShiro.shiro.ShiroUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath*:config/spring-*.xml")
public class Test1 {
    @Resource
    UserService userService;

    @Resource
    CommentMapper commentMapper;

    @Test
    public void test1() {
        User user1 = new User();
        user1.setUsex(0);
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        wrapper.setEntity(user1);
        EntityWrapper<Comment> wrapper1 = new EntityWrapper<>();
        wrapper1.setEntity(new Comment());
        List<Comment> comments = commentMapper.selectPage(new RowBounds(2, 5), null);
        System.out.println(comments.size());
        User user = userService.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    public void test2() {
        RandomStringUtils.random(25);
        String s = ShiroUtils.sha256("adminn", RandomStringUtils.random(25));
        System.out.println(s);
    }

}
