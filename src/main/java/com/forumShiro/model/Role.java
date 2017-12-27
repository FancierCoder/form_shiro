package com.forumShiro.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author 李铎
 * @since 2017-12-26
 */
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

	@TableId(value="role_id", type= IdType.AUTO)
	private Long roleId;
    /**
     * 角色名称
     */
	@TableField("role_name")
	private String roleName;
    /**
     * 备注
     */
	private String remark;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;


	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.roleId;
	}

	@Override
	public String toString() {
		return "Role{" +
			", roleId=" + roleId +
			", roleName=" + roleName +
			", remark=" + remark +
			", createTime=" + createTime +
			"}";
	}
}
