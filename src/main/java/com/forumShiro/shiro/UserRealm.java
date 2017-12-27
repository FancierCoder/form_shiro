package com.forumShiro.shiro;


import com.forumShiro.mapper.UserMapper;
import com.forumShiro.model.Menu;
import com.forumShiro.model.User;
import com.forumShiro.service.ManageService;
import com.forumShiro.service.MenuService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * 认证
 */
@Component
public class UserRealm extends AuthorizingRealm {
    @Resource
    private UserMapper sysUserDao;

    @Resource
    private MenuService menuService;

    @Resource
    private ManageService manageService;
    
    /**
     * 授权(验证权限时调用)
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user = (User)principals.getPrimaryPrincipal();
		//Long userId = user.getUid();
		
		List<String> permsList = null;
        //系统管理员，拥有最高权限
        if(user.getUtype() == 2){
            List<Menu> menuList = menuService.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            for(Menu menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            permsList = sysUserDao.queryAllPerms(user.getUid());
        }

		//用户权限列表
		Set<String> permsSet = new HashSet<>();
		for(String perms : permsList){
			if(StringUtils.isBlank(perms)){
				continue;
			}
			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permsSet);
		return info;
	}

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;

        //查询用户信息
		User u = new User();
		u.setUemail(token.getUsername());
        User user = sysUserDao.selectOne(u);

        //账号不存在
        if(user == null) {
            throw new UnknownAccountException("账号不存在");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getUpassword(), ByteSource.Util.bytes(user.getUsalt()), getName());
        return info;
	}

	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
		shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
		shaCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
		super.setCredentialsMatcher(shaCredentialsMatcher);
	}
}
