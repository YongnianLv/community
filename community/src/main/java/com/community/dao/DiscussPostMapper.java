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

    // 分页查询帖子
    //orderMode 如果传入1按照热度来排
    List<DiscussPost> selectDiscussPosts(
            @Param("userId") int userId,
            @Param("offset") int offset,
            @Param("limit") int limit,
            @Param("orderMode") int orderMode);

    //查询用户的帖子 @param注解是用于给参数起别名的
    //如果只有一个参数，且在<if>里，必须加别名
    int selectDiscussPostRows(@Param("userId")int userId);

    //插入一条帖子
    int insertDiscussPost(DiscussPost discussPost);

    //通过id查找帖子
    DiscussPost selectDiscussPostById(int id);

    //更新帖子评论数量
    int updateCommentCount(int id, int CommentCount);

    //更新帖子类型 0：普通 1：置顶
    int updateType(int id,int type);

    //更新帖子状态 0：正常 1：精华 2：拉黑
    int updateStatus(int id,int status);

    //更新帖子分数
    void updateScore(@Param("id") int id, @Param("score") double score);
}
