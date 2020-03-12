package com.vivachek.service.impl;

import com.vivachek.core.aop.ChangeSource;
import com.vivachek.core.domain.User;
import com.vivachek.core.domain.jwt.JwtDomain;
import com.vivachek.core.domain.oath.HeadParam;
import com.vivachek.core.domain.oath.UserInfoVO;
import com.vivachek.core.domain.redis.KeyConfig;
import com.vivachek.core.domain.req.LoginReq;
import com.vivachek.core.domain.rs.LoginRes;
import com.vivachek.core.domain.rs.ResponseCode;
import com.vivachek.core.properties.OathProperties;
import com.vivachek.core.utils.AssertUtils;
import com.vivachek.core.utils.JwtUtils;
import com.vivachek.core.utils.MD5Utils;
import com.vivachek.core.utils.OathUtils;
import com.vivachek.service.UserService;
import com.vivachek.service.dao.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 21:03
 */
@Service
//@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OathProperties oathProperties;

    @Override
    public UserInfoVO getUserInfoByUserId(String accessToken,String userId){
        //直接从缓存中取
        UserInfoVO userInfoVO= (UserInfoVO) redisTemplate.opsForValue().get(accessToken);
        if (userInfoVO==null){
            //从数据库中获取
            userInfoVO=userMapper.selectByUserId(userId);
        }
        //存储在redis中
        if (Objects.nonNull(userInfoVO)) {
            //设置token的失效时间
            redisTemplate.opsForValue().set(accessToken,userInfoVO,oathProperties.getAccessTokenExpire(), TimeUnit.MILLISECONDS);
        }
        return userInfoVO;
    }

    @Override
    public LoginRes login(LoginReq req) {
        HeadParam headParam = OathUtils.getHeadParam();
        User user=null;
        switch (headParam.getPlatform()){
            //后台用户登录
            case HeadParam.Platform.API_BACK:
                user=userMapper.selectByAccount(req.getAccount(),1);
                break;
            //前台登录
            case HeadParam.Platform.API_FORNT:
                user=userMapper.selectByAccount(req.getAccount(),1);
                break;
                default:
                    break;
        }
        AssertUtils.assertTrue(user!=null, ResponseCode.ACCOUNT_PWD_NOT_TURE);
        //校验账号
        String encode = MD5Utils.encode(req.getPassword(), user.getSalt());
        //校验密码
        AssertUtils.assertTrue(StringUtils.equals(encode,user.getPassword()), ResponseCode.ACCOUNT_PWD_NOT_TURE);
        //生成token和refreshToken
        String accessToken = createToken(user, true);
        String refreshToken = createToken(user, false);
        //获取权限...
        LoginRes res=LoginRes.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
        return res;
    }

    /**
     * 生成AccessToken
     * @param user
     * @return
     */
    private String createToken(User user,boolean isAccessToken){
        JwtDomain jwtDomain = JwtDomain.builder()
                .jti(OathUtils.getHeadParam().getClientId())
                .secret(oathProperties.getSecret())
                .sub(user.getId())
                .issAt(new Date())
                .expireAt(isAccessToken?new Date(new Date().getTime() + oathProperties.getAccessTokenExpire()):new Date(new Date().getTime()+oathProperties.getRefreshTokenExpire()))
                .issure(oathProperties.getIssure())
                .build();
        return JwtUtils.createJWT(jwtDomain);
    }


    @Override
    public void register(LoginReq req) {
        //查询账号是否存在
        User user = userMapper.selectByAccount(req.getAccount(), 1);
        AssertUtils.assertTrue(user==null,ResponseCode.ACCOUNT_EXIST);
        String salt=UUID.randomUUID().toString();
        user=User.builder()
                .account(req.getAccount())
                .createTime(new Date())
                .id(UUID.randomUUID().toString())
                .status(1)
                .password(MD5Utils.encode(req.getPassword(),salt))
                .salt(salt)
                .status(1)
                .build();
        int i = userMapper.insertUserSelected(user);
        AssertUtils.assertTrue(i==1);
    }

    @Override
    @ChangeSource
    public UserInfoVO selectByUserId(String id) {
        UserInfoVO infoVO = userMapper.selectByUserId(id);
        return infoVO;
    }
}