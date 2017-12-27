package com.forumShiro.model.VO;

import com.forumShiro.model.Addfriend;
import com.forumShiro.model.User;

public class AddFriendVo {
    private User user;
    private Addfriend addfriend;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Addfriend getAddfriend() {
        return addfriend;
    }

    public void setAddfriend(Addfriend addfriend) {
        this.addfriend = addfriend;
    }
}
