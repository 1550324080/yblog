package com.boot.dao;

import com.boot.pojo.user_authority;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface userAuthorityMapper {

    void changeUserAuthority(user_authority user_authority);



}