package cn.com.testol.service;

import cn.com.testol.DTO.StuSubmitExamDTO;
import cn.com.testol.DTO.UserGradeDTO;
import cn.com.testol.entity.UserTopic;
import cn.com.testol.utils.Msg;

public interface MarkExamService {
    public Msg submitTestPaper(StuSubmitExamDTO stuSubmitExamDTO,Integer userId);

    public Msg selectByClassesId(Integer classesId,Integer examId,Integer userId);

    public Msg selestStuExamInfo(Integer classesId, Integer examId, Integer userId);

    //教师批改试卷
    public Msg tchMarkExam(UserGradeDTO userGradeDTO, Integer userId);


    /**
     * 习题推荐接口
     * @param
     * @param userId
     * @return
     */
    public Msg recommend(Integer userId);


    /**
     * 提交习题答案接口
     * @return
     */
    public Msg userSubmitProblem(UserTopic userTopic);


    public Msg getHistoryProblem(Integer userId);



    public Msg statisticUserProblem(Integer userId);

}
