package com.forumShiro.control;


import com.forumShiro.mapper.DzMapper;
import com.forumShiro.mapper.LogtableMapper;
import com.forumShiro.mapper.TopicMapper;
import com.forumShiro.mapper.UserMapper;
import com.forumShiro.model.Dz;
import com.forumShiro.model.Logtable;
import com.forumShiro.model.Topic;
import com.forumShiro.model.User;
import com.forumShiro.util.IpUtil;
import com.forumShiro.util.LevelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 李铎
 * @since 2017-12-01
 */
@Controller
@RequestMapping("/topic")
public class TopicController {
    @Resource
    private TopicMapper topicMapper;

    @Resource
    private LogtableMapper logtableMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private DzMapper dzMapper;

    /*帖子点赞*/
    @RequestMapping("/addtopicclick")
    public synchronized void addclick(@RequestParam("tid") long tid, @RequestParam("uid") long uid, HttpServletResponse response) throws IOException {
        Topic topic = topicMapper.selectById(tid);
        topic.setTzan(topic.getTzan() + 1);
        Integer j = topicMapper.updateById(topic);

        Dz dz = new Dz();
        dz.setDzfromuid(uid);
        dz.setDztopicid(tid);
        Integer i = dzMapper.insert(dz);

        PrintWriter writer = response.getWriter();
        if (j == 1 && i == 1)
            writer.write("success");
        else
            writer.write("false");

    }

    @RequestMapping("/addTopic")
    public void addTopic(@RequestParam("sid") int sid, @RequestParam("topic") String topic, @RequestParam("content") String content, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Topic newTopic = new Topic();
        User u = (User) request.getSession().getAttribute("user");
        long uid = u.getUid();
        newTopic.setTuid(uid);
        newTopic.setTsid(sid);
        newTopic.setTtopic(topic);
        newTopic.setTcontent(content);
        int i = topicMapper.insert(newTopic);
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (i == 1) {
            /**插入发表帖子记录**/
            Logtable logtable = new Logtable(u.getUid(), new IpUtil().getIp(request), 5);
            logtableMapper.insert(logtable);
            /** 发表一个加8分最多一天加80分 就是发布帖子超过10个就不会在加了**/
            int count = logtableMapper.todayTopicCount(u.getUid(), new Date());
            if (count <= 10) {
                int newpoint = u.getUpoint() + 8;
                int level = LevelUtil.point2Level(newpoint);
                u.setUpoint(newpoint);
                u.setUlevel(level);
                userMapper.updateById(u);
                request.getSession().setAttribute("user", u);
            }
            if (pw != null) {
                pw.write("success");
            }
        } else {
            if (pw != null) {
                pw.write("failed");
            }
        }
        if (pw != null) {
            pw.close();
        }
    }

}
