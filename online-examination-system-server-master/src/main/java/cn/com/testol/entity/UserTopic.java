package cn.com.testol.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * user_topic
 * @author 
 */
@ApiModel(value="cn.com.testol.entity.UserTopic")
@Data
public class UserTopic implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    private Integer id;

    /**
     * 用户id
     */
    @ApiModelProperty(value="用户id")
    private Integer userId;

    /**
     * 班级id
     */
    @ApiModelProperty(value="班级id")
    private Integer classesId;

    /**
     * 试卷id
     */
    @ApiModelProperty(value="试卷id")
    private Integer examId;

    /**
     * 题目id
     */
    @ApiModelProperty(value="题目id")
    private Integer topicId;

    /**
     * 用户答案
     */
    @ApiModelProperty(value="用户答案")
    private String userAnswer;

    /**
     * 用户得分
     */
    @ApiModelProperty(value="用户得分")
    private Double userScore;

    /**
     * 0:待批改 1:批改完成
     */
    @ApiModelProperty(value="0:待批改 1:批改完成")
    private String topicStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date answerTime;

    private static final long serialVersionUID = 1L;
}