package com.forumShiro.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 李铎
 * @since 2017-12-27
 */
public class Manage extends Model<Manage> {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员自增id
     */
	@TableId(value="mid", type= IdType.AUTO)
	private Integer mid;
    /**
     * 名字
     */
	private String mname;
    /**
     * 密码
     */
	private String mpassword;
	private String msalt;
    /**
     * 性别
     */
	private Integer msex;
    /**
     * 0超管1普管
     */
	private Integer mrole;
    /**
     * E-mail
     */
	private String memail;
	private Integer mtype;


	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMsalt() {
		return msalt;
	}

	public void setMsalt(String msalt) {
		this.msalt = msalt;
	}

	public Integer getMsex() {
		return msex;
	}

	public void setMsex(Integer msex) {
		this.msex = msex;
	}

	public Integer getMrole() {
		return mrole;
	}

	public void setMrole(Integer mrole) {
		this.mrole = mrole;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public Integer getMtype() {
		return mtype;
	}

	public void setMtype(Integer mtype) {
		this.mtype = mtype;
	}

	@Override
	protected Serializable pkVal() {
		return this.mid;
	}

	@Override
	public String toString() {
		return "Manage{" +
			", mid=" + mid +
			", mname=" + mname +
			", mpassword=" + mpassword +
			", msalt=" + msalt +
			", msex=" + msex +
			", mrole=" + mrole +
			", memail=" + memail +
			", mtype=" + mtype +
			"}";
	}
}
