package com.boyangsoft.sqjw.datat.service;

import com.boyangsoft.sqjw.datat.dao.BzdzXzqhDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class BzdzService {

    @Resource
    private BzdzXzqhDao bzdzXzqhDao;

    public String transfer(){
        return bzdzXzqhDao.importXzqh();
    }
}
