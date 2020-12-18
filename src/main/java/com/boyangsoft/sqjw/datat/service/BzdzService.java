package com.boyangsoft.sqjw.datat.service;

import com.boyangsoft.sqjw.datat.dao.BzdzXzqhDao;
import com.boyangsoft.sqjw.datat.dao.BzdzYsDxDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class BzdzService {

    @Resource
    private BzdzXzqhDao bzdzXzqhDao;
    @Resource
    private BzdzYsDxDao bzdzYsDxDao;

    public void transferXzqh(){
        bzdzXzqhDao.importXzqh();
    }
    public void transferBzdz(){
        bzdzYsDxDao.importYs();
        bzdzYsDxDao.importDx();

    }
}
