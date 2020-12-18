package com.boyangsoft.sqjw.datat.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class BzdzYsDxDaoImpl implements BzdzYsDxDao{
    private static final Logger logger = LoggerFactory.getLogger(BzdzXzqhDaoImpl.class);

    @Resource
    private JdbcTemplate mysqlJdbcTemplate;
    @Resource
    private JdbcTemplate oracleJdbcTemplate;

    @Override
    public void importYs() {
    }

    @Override
    public void importDx() {
    }
}
