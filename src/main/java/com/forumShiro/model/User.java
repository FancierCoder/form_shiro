package com.forumShiro.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 李铎
 * @since 2017-12-27
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增用户id
     */
	@TableId(value="uid", type= IdType.AUTO)
	private Long uid;
    /**
     * email账号
     */
	private String uemail;
    /**
     * 密码
     */
	private String upassword;
    /**
     * 密码盐
     */
	private String usalt;
    /**
     * 昵称
     */
	private String unickname;
    /**
     * 性别
     */
	private Integer usex;
    /**
     * 生日
     */
	private Date ubirthday;
    /**
     * 等级
     */
	private Integer ulevel;
    /**
     * 头像
     */
	private String headimg;
    /**
     * 个人描述
     */
	private String ustatement;
    /**
     * 注册时间
     */
	private Date uregtime;
    /**
     * 被封状态
     */
	private Integer ustate;
    /**
     * 积分
     */
	private Integer upoint;
    /**
     * 用户类型，1为普通用户，2为管理员
     */
	private Integer utype;


	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getUsalt() {
		return usalt;
	}

	public void setUsalt(String usalt) {
		this.usalt = usalt;
	}

	public String getUnickname() {
		return unickname;
	}

	public void setUnickname(String unickname) {
		this.unickname = unickname;
	}

	public Integer getUsex() {
		return usex;
	}

	public void setUsex(Integer usex) {
		this.usex = usex;
	}

	public Date getUbirthday() {
		return ubirthday;
	}

	public void setUbirthday(Date ubirthday) {
		this.ubirthday = ubirthday;
	}

	public Integer getUlevel() {
		return ulevel;
	}

	public void setUlevel(Integer ulevel) {
		this.ulevel = ulevel;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public String getUstatement() {
		return ustatement;
	}

	public void setUstatement(String ustatement) {
		this.ustatement = ustatement;
	}

	public Date getUregtime() {
		return uregtime;
	}

	public void setUregtime(Date uregtime) {
		this.uregtime = uregtime;
	}

	public Integer getUstate() {
		return ustate;
	}

	public void setUstate(Integer ustate) {
		this.ustate = ustate;
	}

	public Integer getUpoint() {
		return upoint;
	}

	public void setUpoint(Integer upoint) {
		this.upoint = upoint;
	}

	public Integer getUtype() {
		return utype;
	}

	public void setUtype(Integer utype) {
		this.utype = utype;
	}

	@Override
	protected Serializable pkVal() {
		return this.uid;
	}

	@Override
	public String toString() {
		return "User{" +
			", uid=" + uid +
			", uemail=" + uemail +
			", upassword=" + upassword +
			", usalt=" + usalt +
			", unickname=" + unickname +
			", usex=" + usex +
			", ubirthday=" + ubirthday +
			", ulevel=" + ulevel +
			", headimg=" + headimg +
			", ustatement=" + ustatement +
			", uregtime=" + uregtime +
			", ustate=" + ustate +
			", upoint=" + upoint +
			", utype=" + utype +
			"}";
	}
}
