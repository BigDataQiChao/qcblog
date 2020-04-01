package com.qcblog.mapper;

import com.qcblog.pojo.UserLike;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UserLikeMapper extends Mapper<UserLike> {
    @Update("update article set likenumber = (select count(*) from userlike where userlike.entity_id = article.id and userlike.status = '1')")
    public void updateLikeNumber();

    @Select("select * from userlike where entity_id = #{entityId} and user_id = #{userId}")
    public UserLike findById(@Param("entityId") Integer entityId, @Param("userId") Integer userId);

    @Select("Select entity_id,status from userlike where user_id = #{userId}")
    public List<Map<String,String>> findStatus(Integer userId);

}
