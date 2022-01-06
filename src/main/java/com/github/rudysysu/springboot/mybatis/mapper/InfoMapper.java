package com.github.rudysysu.springboot.mybatis.mapper;

import com.github.rudysysu.springboot.mybatis.domain.Info;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface InfoMapper {
	@Insert("INSERT INTO info(uid, tid) VALUES(#{uid}, #{tid})")
	int insertInfo(Info info);

	@Select("SELECT * FROM info WHERE uid = #{uid}")
    List<Info> selectInfos(Map<String, Object> params);
}
