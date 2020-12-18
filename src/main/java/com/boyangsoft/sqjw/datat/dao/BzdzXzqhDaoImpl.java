package com.boyangsoft.sqjw.datat.dao;

import com.boyangsoft.sqjw.datat.util.DateTimeUtil;
import com.boyangsoft.sqjw.datat.util.IntUtil;
import com.boyangsoft.sqjw.datat.util.StrUtil;
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
    public void importXzqh() {
        Map m = this.oracleJdbcTemplate.queryForMap("select count(*) as xzqh_count from tb_bzdz_ys_xzqh");
        int pagecount = (Integer.parseInt(m.get("xzqh_count").toString())/1000)+1;
        /*
        按照1000条的数据进行导入
         */
        logger.info("开始导入行政区划表，总行数："+m.get("xzqh_count").toString()+",进行分页导入，总页数为："+pagecount);
        String insertSql="";
        long startTime=System.currentTimeMillis();
        //for(int i=0;i<=pagecount;i++){
        for(int i=0;i<=1;i++){
            String sSql="select * from (select rownum no,t.* from tb_bzdz_ys_xzqh t) where no>"+i*1000+" and no <="+(i*1000+1000);
            logger.info(sSql);
            List<Map<String, Object>> list = oracleJdbcTemplate.queryForList(sSql);
            logger.info("导入【"+(i+1)+"】页");
            for(Map v : list){
                insertSql = "insert into tb_xzqh (xzqhid, xzqhdm, xzqhmc,sjxzqhid, dzyslx,zd, qymj,"+
                        "zrs ,gxgajgdm ,gxgajgmc ,bz,cjrsfzh,crjmc,crjs ,zhgxrsfzh,zhgxrmc ,zhgxsj ,"+
                        "dzysjb , wyxbm , yxzt ) values ("+
                        StrUtil.getStr(v.get("XZQHID"))+","+
                        StrUtil.getStr(v.get("XZQHDM"))+","+
                        StrUtil.getStr(v.get("XZQHMC"))+","+
                        StrUtil.getStr(v.get("SJXZQHID"))+","+
                        StrUtil.getStr(v.get("DZYSLX"))+","+
                        StrUtil.getStr(v.get("ZD"))+","+
                        IntUtil.getStr(v.get("QYMJ"))+","+
                        IntUtil.getStr(v.get("ZRS"))+","+
                        StrUtil.getStr(v.get("GXGAJGDM"))+","+
                        StrUtil.getStr(v.get("GXGAJGMC"))+","+
                        StrUtil.getStr(v.get("BZ"))+","+
                        StrUtil.getStr(v.get("DJR_SFHM"))+","+
                        StrUtil.getStr(v.get("DJR_XM"))+","+
                        DateTimeUtil.getStr(v.get("DJSJ"))+","+
                        StrUtil.getStr(v.get("XGR_SFHM"))+","+
                        StrUtil.getStr(v.get("XGR_XM"))+","+
                        DateTimeUtil.getStr(v.get("XGSJ"))+","+
                        StrUtil.getStr(v.get("DZYSJB"))+","+
                        StrUtil.getStr(v.get("WYXBM"))+","+
                        StrUtil.getStr(v.get("YXZT"))+")";
                mysqlJdbcTemplate.execute(insertSql);
            }
        }
        long endTime=System.currentTimeMillis(); //获取结束时间
        logger.info("导入运行时间： "+(endTime-startTime)/1000+"s");
        logger.info("导入完成，导入总行数为：");

    }
}
