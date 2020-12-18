package com.boyangsoft.sqjw.datat.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 这个类是行政区划导入的类
 */
@Repository
public class BzdzXzqhDaoImpl implements BzdzXzqhDao {

    private static final Logger logger = LoggerFactory.getLogger(BzdzXzqhDaoImpl.class);

    @Resource
    private JdbcTemplate mysqlJdbcTemplate;

    @Resource
    private JdbcTemplate oracleJdbcTemplate;


    @Override
    public String importXzqh() {
        Map m = this.oracleJdbcTemplate.queryForMap("select count(*) as xzqh_count from tb_bzdz_ys_xzqh");

        int pagecount = (Integer.parseInt(m.get("xzqh_count").toString())/1000)+1;


        /*
        按照1000条的数据进行导入
         */


        logger.info("开始导入行政区划表，总行数："+m.get("xzqh_count").toString()+",进行分页导入，总页数为："+pagecount);

        String insertSql="";

        for(int i=0;i<=pagecount;i++){
            List<Map<String, Object>> list = oracleJdbcTemplate.queryForList("select * from tb_bzdz_ys_xzqh where rownum>"+i*1000+" and rownum <="+(i*1000+1000)+"");

            //insertSql = "insert into tb_xzqh () values "

            logger.info("导入【"+(i+1)+"】页");
        }

        logger.info("导入完成，导入总行数维：");
        return "jdbctemplate"+m.toString();
    }
}
