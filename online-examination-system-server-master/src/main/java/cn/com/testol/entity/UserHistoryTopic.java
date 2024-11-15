package cn.com.testol.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * topic
 * @author 
 */
@Data
public class UserHistoryTopic implements Serializable {
    private String userId;
    /**
     * 题目id
     */
    private Integer topicId;

    /**
     * 创建者id
     */
    private Integer creatorId;

    /**
     * 科目类型id
     */
    private Integer subjectId;

    /**
     * 科目类型名称
     */
    private String subjectName;

    /**
     * 题目
     */
    private String question;

    /**
     * 选项
     */
    private String choice;

    /**
     * 图片
     */
    private String photo;

    /**
     * 题目类型  0:单选题 1:多选题 2:判断题 3:填空题 4:简答题
     */
    private Integer topicType;

    /**
     * 正确答案
     */
    private String correctAnswer;

    /**
     * 分数
     */
    private Double score;

    /**
     * 难度  简单,中等(默认),困难
     */
    private String difficulty;

    /**
     * 答案分析
     */
    private String analysis;

    /**
     * 非必填:0   必填:1
     */
    private Integer required;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;


    /**
     * 试卷id
     */
    @ApiModelProperty(value="试卷id")
    private Integer examId;


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
    private Date answerTime;

    private static final long serialVersionUID = 1L;
}