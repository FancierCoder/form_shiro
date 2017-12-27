package com.forumShiro.control;


import com.forumShiro.mapper.*;
import com.forumShiro.model.Comment;
import com.forumShiro.model.Logtable;
import com.forumShiro.model.Topic;
import com.forumShiro.model.User;
import com.forumShiro.model.VO.CommentVo;
import com.forumShiro.util.DateUtil;
import com.forumShiro.util.HtmlUtil;
import com.forumShiro.util.IpUtil;
import com.forumShiro.websocket.SystemWebSocketHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.socket.TextMessage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 李铎
 * @since 2017-12-01
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private TopicMapper topicMapper;
    @Resource
    private SectionMapper sectionMapper;
    @Resource
    private LogtableMapper logtableMapper;
    @Resource
    private SystemWebSocketHandler systemWebSocketHandler;



    public static CommentVo comment2Vo(Comment comment, UserMapper userMapper, TopicMapper topicMapper) {

        CommentVo cvo = new CommentVo();
        cvo.setCid(comment.getCid());
        cvo.setContent(comment.getContent());
        cvo.setTimeinterval(DateUtil.date(comment.getCtime(), 1));
        cvo.setRootid(comment.getRootcid());
        cvo.setParentuid(comment.getParentuid());
        cvo.setCzan(comment.getCzan());
        cvo.setUid(comment.getCuid());   //自己的uid
        cvo.setParentcid(comment.getParentcid());
        //自己的昵称,头像,账号
        User me = userMapper.selectById(comment.getCuid());
        cvo.setHeadimg(me.getHeadimg());
        cvo.setNickname(me.getUnickname());
        cvo.setFromuemail(me.getUemail());
        //parent的昵称
        Long parentuid = comment.getParentuid();
        if (parentuid != 0) {
            User parent = userMapper.selectById(parentuid);
            cvo.setParentunickname(parent.getUnickname());
        }
        //帖子信息，id和标题
        cvo.setTid(comment.getCtid());
        Topic t = topicMapper.selectById(comment.getCtid());
        cvo.setTtopic(t.getTtopic());
        return cvo;
    }


    /*发表评论*/
    @RequestMapping("/addComment")
    public void addComment(@RequestParam("content") String content, @RequestParam("tid") long tid,
                           @RequestParam(value = "rootcid", required = false, defaultValue = "0") long rootcid,
                           @RequestParam(value = "parentuid", required = false, defaultValue = "0") long parentuid,
                           @RequestParam(value = "parentcid", required = false, defaultValue = "0") long parentcid,
                           HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        Long uid = user.getUid();
        Comment comment = new Comment();
        comment.setContent(HtmlUtil.filter(content));
        comment.setCtid(tid);
        comment.setCuid(uid);
        comment.setRootcid(rootcid);
        comment.setParentuid(parentuid);
        comment.setParentcid(parentcid);
        int i = commentMapper.insert(comment);
        //操作记录
        Logtable logtable = new Logtable(user.getUid(), new IpUtil().getIp(request), 7);
        logtableMapper.insert(logtable);
        PrintWriter pw = null;
        if (i == 1) {
            System.out.println("增加评论成功");
            Topic topic = topicMapper.selectById(tid);
            int unreadCount = commentMapper.unreadCount(topic.getTuid());
            systemWebSocketHandler.sendMessageToUser(topic.getTuid(), new TextMessage(unreadCount + ""));
            try {
                pw = response.getWriter();
                pw.write("success");
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                pw = response.getWriter();
                pw.write("err");
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
