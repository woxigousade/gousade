package com.gousade.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@ApiModel(/*value = "User",*/ description = "用户实体类")
@Data
public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1283526925605483104L;

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private String userId;

    private String userName;

    @JSONField(serialize = false)
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    @Schema(hidden = true) // swagger文档中隐藏此属性
    private String password;

    @JSONField(serialize = false)
    @Schema(hidden = true)
    private String salt;

    @TableField(fill = FieldFill.INSERT)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String remark;

    private String phoneNumber;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastlogintime;

    private boolean delflag;

    @ApiModelProperty(value = "用户头像路径")
    private String avatarPath;

    @TableField(fill = FieldFill.INSERT)
    @Version
    private Integer version;

    @TableField(exist = false)
    private Set<String> roles;

    @TableField(exist = false)
    private Set<String> urls;

    @TableField(exist = false) // 不在数据库表中 但java逻辑中需要使用
    private String roleIds;

    /**
     * 无参构造
     */
    public User() {
        super();
    }

    public User(String id) {
        this.userId = id;
    }

    /**
     * 全参构造
     */
    public User(String userId, String username, String password, String salt) {
        super();
        this.userId = userId;
        this.userName = username;
        this.password = password;
        this.salt = salt;
    }

    public User(String userId, String userName, String phonenumber, Set<String> urls, Set<String> roles) {
        this.userId = userId;
        this.userName = userName;
        this.phoneNumber = phonenumber;
        this.urls = urls;
        this.roles = roles;
    }

}
