package cn.com.testol.dao;

import cn.com.testol.entity.UserHistoryTopic;
import cn.com.testol.entity.UserStatistic;
import cn.com.testol.entity.UserTopic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserTopicDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserTopic record);

    int insertSelective(UserTopic record);

    UserTopic selectByPrimaryKey(Integer id);

    int updateByForeignKeySelective(UserTopic record);

    int updateByPrimaryKey(UserTopic record);


    List<UserHistoryTopic> selectHistoryProblem(Integer userId);

    List<UserStatistic> selectUserStatisticSuccess(Integer userId);


    List<UserStatistic> selectUserStatistic(Integer userId);




}