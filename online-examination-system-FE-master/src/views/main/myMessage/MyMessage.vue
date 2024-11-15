<!--
<template>
  <TopTab title="我的消息">
    <div class="MyMessage">
      <div class="title">
        加入班级申请
      </div>

      <div class="table apply">
        <el-table :data="applyList" style="width: 100%" v-loading="loading">
          <el-table-column label="申请人id" width="140">
            <template slot-scope="scope">U{{scope.row.studentId}} </template>
          </el-table-column>
          <el-table-column prop="studentName" label="申请人"> </el-table-column>
          <el-table-column prop="applyDate" label="申请日期" width="184"> </el-table-column>
          <el-table-column label="班级id" width="140">
            <template slot-scope="scope">C{{scope.row.classesId}} </template>
          </el-table-column>
          <el-table-column prop="classesName" label="班级名称"> </el-table-column>
          <el-table-column prop="operate" label="操作" width="200">
            <template slot-scope="scope">
              <el-button type="primary" size="small" @click="approval(scope.row.id,1)" plain>同意</el-button>
              <el-button type="danger" size="small" @click="approval(scope.row.id,2)" plain>拒绝</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>

      <div class="page">
        <el-pagination background layout="total, prev, pager, next,jumper" @current-change="currentChange" :total="total" :page-size="pageSize" />
      </div>

    </div>
  </TopTab>
</template>

<script>
import TopTab from "@/components/TopTab.vue";

export default {
  name: "MyMessage",
  components: {
    TopTab,
  },
  data() {
    return {
      applyList: [],

      //分页
      currentPage: 1,
      pageSize: 10,
      total: null,

      loading: false,
    };
  },
  created() {
    this.getApplyList();
  },
  methods: {
    //
    getApplyList() {
      this.loading = true;
      let params = {
        pageSize: this.pageSize,
        currentPage: this.currentPage,
      };
      setTimeout(() => {
        this.$http.get("/approval/list", { params }).then(res => {
          this.applyList = res.data.content;
          this.total = res.data.total;
          this.loading = false;
        });
      }, 500);
    },

    approval(id,status){
      let params = {
        approvalId: id,
        status
      };
      this.$http.get("/approval",{params}).then(res =>{
        if(res.code == 200){
          if(status === 1) this.$message.success('同意申请完成');
          if(status === 2) this.$message.success('已拒绝');
          this.getApplyList();
        }
      })
    },

    // 获取消息列表
    getMessage() {},


    // 切换分页时触发
    currentChange(val) {
      this.currentPage = val
      this.getApplyList()
    },

  },
};
</script>

<style lang="less" scoped>
.MyMessage {
  padding: 24px;

  .title{
    width: 120px;
    background: #fafafa;
    margin-bottom: 12px;
    padding: 12px;
    text-align: center;
  }
}
</style>
-->
