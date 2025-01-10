package com.example.entity;


import lombok.Data;

/**
 *
 */
@Data
public class Comment {

    //ID
    private Integer id;

    //评论内容
    private String content;

    //评论人
    private Integer userId;

    //父级ID
    private Integer pid;

    //评论时间
    private String time;

    //关联id
    private String fid;


    //模块
    private String module;

    //根节点ID
    private Integer rootId;

    private String userName;

    private String userAvatar;

}
