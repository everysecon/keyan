<template>
  <div class="myTest content-bg ">
    <div class="tab-title">
      <div class="tabTitle-item active">习题统计</div>
    </div>
    <div class="tab-item">
      <div class="table">
        <el-table :data="testPaperList" style="width: 100%" v-loading="loading">
          <el-table-column label="用户编号" width="110">
            <template slot-scope="scope">E{{scope.row.userId}} </template>
          </el-table-column>
          <el-table-column label="用户姓名" min-width="220">
            <template slot-scope="scope">{{scope.row.userName}} </template>
          </el-table-column>
          <el-table-column label="性别" min-width="220">
            <template slot-scope="scope">{{scope.row.sex}} </template>
          </el-table-column>
          <el-table-column label="手机号码" min-width="220">
            <template slot-scope="scope">{{scope.row.phone}} </template>
          </el-table-column>
          <el-table-column label="正确率" min-width="220">
            <template slot-scope="scope">{{scope.row.statistic}} </template>
          </el-table-column>
          <!-- <el-table-column prop="subjectName" label="试卷类型" width="100"> </el-table-column> -->
          <!--          <el-table-column label="操作" width="240" fixed="right">-->
          <!--            <template slot-scope="scope">-->
          <!--              <el-button type="primary" size="mini" plain @click="releaseTest(scope.row.examId,scope.row.examName)">发布考试</el-button>-->
          <!--              <el-button v-if="scope.row.releasing === 0" type="info" size="mini" plain @click="editTestPaper(scope.row.examId)">编辑</el-button>-->
          <!--              <el-button v-if="scope.row.releasing === 0" type="danger" size="mini" plain @click="deleteTest(scope.row.examId)">删除</el-button>-->
          <!--              <el-button v-if="scope.row.releasing === 1" type="info" size="mini" plain @click="editTestPaper(scope.row.examId)">查看试卷</el-button>-->
          <!--            </template>-->
          <!--          </el-table-column>-->

        </el-table>
      </div>

      <div class="page">
        <el-pagination background layout="total, prev, pager, next,jumper" @current-change="currentChange" :total="total" :page-size="pageSize" />
      </div>

      <!-- 发布考试弹框 -->
      <ReleaseTest ref="releaseTestDialog"/>

    </div>
  </div>
</template>

<script>
import "../../assets/less/my_tab.less";

export default {
  name: "problemStatistic",
  data() {
    return {
      loading: true,
      testPaperList: [],// 所有的试卷列表

      // 分页
      currentPage: 1,
      pageSize: 10,
      total: null,

      keyword: '',
    };
  },

  created() {
    this.getTestPaperList();
  },

  methods: {
    //获取试卷列表
    getTestPaperList(val='') {
      // this.loading = true
      let params = {
        pageSize: this.pageSize,
        currentPage: this.currentPage,
        keyword: val
      };
      setTimeout(() => {
        this.$http.get("/statisticUserProblem", { params }).then((res) => {
          this.testPaperList = res.data.content;
          this.total = parseInt(res.data.total);
          this.loading = false
        });
      }, 500);
      this.loading = false
    },









    //切换分页时触发
    currentChange(val) {
      this.currentPage = val;
      this.getTestPaperList();
    },
  },
};
</script>

<style lang="less" scoped>
.myTest{
  .tab-item{
    padding: 10px 20px;
  }
  .table{
    margin-top: 24px;
  }
  .releaseTest .el-dialog{
    .el-dialog__header{
      text-align: center;
      font-size: 16px;
    }
    .el-dialog__body{
      padding-top: 0px;
      padding-bottom: 0px;
      text-align: center;
    }
    .pagination{
      text-align: center;
    }
    .el-date-editor{
      margin: 38px 0px;
    }
  }
}
.list-header {
  position: relative;
  background: #fafafa;
  padding: 6px 24px;
  border-radius: 4px;
  height: 60px;
  box-sizing: border-box;
  box-shadow: 0 2px 4px 0 rgb(0 0 0 / 12%), 0 0 6px 0 rgb(0 0 0 / 4%);

  span.list-title {
    display: inline-block;
    margin-right: 30px;
    font-size: 16px;
    line-height: 48px;
  }

  .create {
    background: #4788cc;
    color: #fff;
    border-color: #f6f6f6;
  }
  .query {
    position: absolute;
    right: 24px;
    top: 14px;
    width: 400px;
    height: 40px;
  }
  .query .el-input {
    width: 320px;
    margin-right: 20px;
  }
  .query .el-button {
    background: #4788cc;
    border-color: #4788cc;
    transition: 1s;
  }
}
</style>
