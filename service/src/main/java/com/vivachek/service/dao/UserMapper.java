package com.vivachek.service.dao;

import com.vivachek.core.domain.User;
import com.vivachek.core.domain.oath.UserInfoVO;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 15:18
 */
public interface UserMapper {
    /**
     * 根据账号查找
     * @param account
     * @param status
     * @return
     */
    User selectByAccount(@Param("account") String account, @Param("status") Integer status);

    /**
     * 根据用户Id查询
     * @param userId
     * @return
     */
    UserInfoVO selectByUserId(String userId);

    int insertUserSelected(User user);
}