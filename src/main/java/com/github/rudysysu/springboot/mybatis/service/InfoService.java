package com.github.rudysysu.springboot.mybatis.service;

import com.github.rudysysu.springboot.mybatis.domain.Info;
import com.github.rudysysu.springboot.mybatis.dao.InfoDao;
import com.github.rudysysu.springboot.mybatis.dao.exception.DaoException;
import com.github.rudysysu.springboot.mybatis.service.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {
    private static final Logger LOG = LoggerFactory.getLogger(InfoService.class);

    @Autowired
    private InfoDao infoDao;

    public void insertInfo(Long uid, Long tid) throws ServiceException {
        Info info = new Info();
        info.setUid(uid);
        info.setTid(tid);

        try {
            infoDao.insertInfo(info);
        } catch (DaoException e) {
            throw new ServiceException(e);
        } catch (Exception e) {
            LOG.error(e.toString(), e);
            throw new ServiceException(e);
        }
    }

    public List<Info> selectInfos(Long uid) throws ServiceException {
        try {
            return infoDao.selectInfos(uid);
        } catch (DaoException e) {
            throw new ServiceException(e);
        } catch (Exception e) {
            LOG.error(e.toString(), e);
            throw new ServiceException(e);
        }
    }
}
