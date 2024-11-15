package cn.com.testol.controller;

import cn.com.testol.DTO.UserGradeDTO;
import cn.com.testol.entity.Topic;
import cn.com.testol.entity.UserTopic;
import cn.com.testol.service.MarkExamService;
import cn.com.testol.utils.JwtUtil;
import cn.com.testol.utils.Msg;
import cn.com.testol.utils.Page;
import cn.com.testol.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
public class MarkExamController {
    @Autowired
    private MarkExamService markExamService;


    @ApiOperation(value = "获取班级考试下")
    @GetMapping("/getUserGradeList")
    public Msg getUserGradeList(HttpServletRequest request,@RequestParam Integer classesId,@RequestParam Integer examId,
                                @RequestParam int pageSize,@RequestParam int currentPage){
        String token =  request.getHeader("token");
        if(!JwtUtil.getUserStatus(token).equals("teacher")){
            return ResultUtil.error(400,"用户身份不正确");
        }

        int teacher_id=Integer.parseInt(JwtUtil.getUserId(token));

        Msg result = markExamService.selectByClassesId(classesId,examId,teacher_id);
        Page page = new Page(pageSize,currentPage);
        page.build((List) result.getData());
        return ResultUtil.success(page);

    }

    @ApiOperation(value = "获取学生答卷")
    @GetMapping("/getStuExamInfo")
    public Msg getStuExamInfo(HttpServletRequest request,@RequestParam Integer classesId,@RequestParam Integer examId,@RequestParam Integer userId){
        String token =  request.getHeader("token");
        if(!JwtUtil.getUserStatus(token).equals("teacher")){
            return ResultUtil.error(400,"用户身份不正确");
        }
        int teacher_id=Integer.parseInt(JwtUtil.getUserId(token));


        return markExamService.selestStuExamInfo(classesId,examId,userId);
    }

    @ApiOperation(value = "批改试卷(教师角色)")
    @PutMapping("/tchMarkExam")
    public Msg tchMarkExam(HttpServletRequest request, @RequestBody UserGradeDTO userGradeDTO){
        String token =  request.getHeader("token");
        //获取token中的id
        int teacher_id=Integer.parseInt(JwtUtil.getUserId(token));

        return markExamService.tchMarkExam(userGradeDTO,teacher_id);
    }



    @ApiOperation(value = "推荐习题")
    @GetMapping("/recommend")
    public Msg recommend(HttpServletRequest request){
        String token =  request.getHeader("token");
        int teacher_id=Integer.parseInt(JwtUtil.getUserId(token));
        Msg topic =  markExamService.recommend(teacher_id);
        return topic;
    }










    @ApiOperation(value = "用户提交习题")
    @PostMapping("/userSubmitProblem")
    public Msg userSubmitProblem(HttpServletRequest request, @RequestBody UserTopic userTopic){
        if (Objects.isNull(userTopic) || StringUtils.isEmpty(userTopic.getUserAnswer())) {
            return ResultUtil.error(500, "请选择答案后提交");
        }
        String token =  request.getHeader("token");
        int teacher_id=Integer.parseInt(JwtUtil.getUserId(token));
        userTopic.setUserId(teacher_id);
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        userTopic.setAnswerTime(timestamp);
        userTopic.setTopicStatus("0");
        userTopic.setUserScore(10.0);
        return markExamService.userSubmitProblem(userTopic);
    }


    @ApiOperation(value = "查询做题历史记录接口")
    @GetMapping("/getHistoryProblem")
    public Msg getHistoryProblem(HttpServletRequest request, @RequestParam int pageSize,@RequestParam int currentPage){
        String token = request.getHeader("token");
        int teacher_id = Integer.parseInt(JwtUtil.getUserId(token));
        Msg result = markExamService.getHistoryProblem(teacher_id);
        if (Objects.isNull(result)) {
            return ResultUtil.success("");
        }
        Page page = new Page(pageSize,currentPage);
        page.build((List) result.getData());
        return ResultUtil.success(page);
    }


    @ApiOperation(value = "统计人员练习")
    @GetMapping("/statisticUserProblem")
    public Msg statisticUserProblem(HttpServletRequest request, @RequestParam int pageSize,@RequestParam int currentPage){
        String token =  request.getHeader("token");
//        if(!JwtUtil.getUserStatus(token).equals("teacher")){
//            return ResultUtil.error(400,"用户身份不正确");
//        }
        int teacher_id = Integer.parseInt(JwtUtil.getUserId(token));
        Msg result = markExamService.statisticUserProblem(teacher_id);
        if (Objects.isNull(result)) {
            return ResultUtil.success("");
        }
        Page page = new Page(pageSize,currentPage);
        page.build((List) result.getData());
        return ResultUtil.success(page);
    }

}
