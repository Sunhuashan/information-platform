package com.shs.bysj.pojo;

import java.sql.Date;

/**
 * @Author: shs
 * @Data: 2022/4/29 11:13
 */
public class Comment {
    private Long id;
    private Long parent;
    private Long postsId;
    private String content;
    private Date date;
    private String releaseName;
    private String replyName;
}
