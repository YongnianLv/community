package com.community.dao;

import com.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lyn
 * @tip Come on!Do your way best!
 * @create 2021.03.26.19:53
 */
@Mapper
@Component
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);
    //@param注解是用于给参数起别名的
    //如果只有一个参数，且在<if>里，必须加别名
    int selectDiscussPostRows(@Param("userId")int userId);
}
