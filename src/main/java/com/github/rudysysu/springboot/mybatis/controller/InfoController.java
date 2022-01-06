package com.github.rudysysu.springboot.mybatis.controller;

import com.github.rudysysu.springboot.mybatis.domain.Info;
import com.github.rudysysu.springboot.mybatis.service.InfoService;
import com.github.rudysysu.springboot.mybatis.service.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/info")
public class InfoController {
    private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);

    @Autowired
    private InfoService infoService;

    @PostMapping(value = "/insert", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public void insertFlow(@RequestBody Map<String, Object> payload) throws Exception {
        try {
            Long uid = Long.parseLong(payload.get("uid").toString());
            Long tid = Long.parseLong(payload.get("tid").toString());
            this.infoService.insertInfo(uid, tid);
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            LOG.error(e.toString(), e);
            throw e;
        }
    }

    @GetMapping(value = "/selectInfosByUid", produces = "application/json;charset=UTF-8")
    public List<Info> selectInfos(@RequestParam Long uid) throws Exception{
        try {
            return this.infoService.selectInfos(uid);
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            LOG.error(e.toString(), e);
            throw e;
        }
    }
}
