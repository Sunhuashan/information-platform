package com.shs.bysj.utils;

import java.sql.Date;

/**
 * @Author: shs
 * @Data: 2022/5/2 16:02
 */
public class DateUtil {
    public static Date getSqlDate() {
        java.util.Date date = new java.util.Date();
        Date sqlDate = new Date(date.getTime());
        return sqlDate;
    }
}
