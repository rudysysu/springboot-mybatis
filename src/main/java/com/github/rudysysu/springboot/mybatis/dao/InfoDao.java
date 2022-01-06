package com.github.rudysysu.springboot.mybatis.dao;

import com.github.rudysysu.springboot.mybatis.domain.Info;
import com.github.rudysysu.springboot.mybatis.dao.exception.DaoException;
import com.github.rudysysu.springboot.mybatis.mapper.InfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InfoDao {
	private static final Logger LOG = LoggerFactory.getLogger(InfoDao.class);

	@Autowired
	private InfoMapper infoMapper;

	public int insertInfo(Info info) throws DaoException {
		try {
			return this.infoMapper.insertInfo(info);
		} catch (Exception e) {
			LOG.error(e.toString(), e);
			throw new DaoException(e);
		}
	}

	public List<Info> selectInfos(Long uid) throws DaoException {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("uid", uid);
			return this.infoMapper.selectInfos(params);
		} catch (Exception e) {
			LOG.error(e.toString(), e);
			throw new DaoException(e);
		}
	}
}