package com.example.mapper;
import com.example.entity.Praise;
import org.apache.ibatis.annotations.*;


@Mapper
public interface PraiseMapper {

    @Insert("insert into praise(fid,user_id) values (#{fid},#{userId})")
    void insert(Praise praise);

//    @Param 保证映射不出错
    @Delete("delete from praise where fid = #{fid} and user_id=#{userId}")
    void deleteByFidAndUserId(@Param("fid") Integer fid,@Param("userId") Integer userId);

    @Select("select * from praise  where fid = #{fid} and user_id=#{userId}")
    Praise seleteByFidAndUserId(@Param("fid") Integer fid,@Param("userId") Integer userId);

    @Select("select count(*) from praise where fid = #{fid}")
    Integer selectCount(Integer fid);

}
