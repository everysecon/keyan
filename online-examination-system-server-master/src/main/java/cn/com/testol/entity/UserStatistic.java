package cn.com.testol.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * user
 * @author 
 */
@Data
public class UserStatistic implements Serializable {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 身份 student:学生  teacher:是教师身份
     */
    private String role;

    /**
     * 工作职位
     */
    private String work;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     * 头像图片
     */
    private String photo;

    /**
     * 头像图片名称
     */
    private String photoName;

    private String statistic;

    private static final long serialVersionUID = 1L;
}