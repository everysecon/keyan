<template>
  <div class="markTest">
    <TopTab title="审批试卷">
      <div class="content">
        <!-- <el-tabs v-model="activeName" type="border-card" @tab-click="handleClick">
          <el-tab-pane label="待审批" name="mark">待审批</el-tab-pane>
          <el-tab-pane label="审批完成" name="finish">审批完成</el-tab-pane>
          <el-tab-pane label="全部" name="all">

            <el-collapse v-model="activeTestPaperList" @change="handleChange">
              <el-collapse-item :title="item.examName" :name="item.examId" v-for="(item , index) in testPaperList" :key="index">

                <el-table :data="item.classesList" style="width: 100%">
                  <el-table-column label="班级id">
                    <template slot-scope="scope">C{{scope.row.classesId}} </template>
                  </el-table-column>
                  <el-table-column prop="classesName" label="班级"></el-table-column>
                  <el-table-column label="考试时间" width="320">
                    <template slot-scope="scope">{{scope.row.startDate}} 至 {{scope.row.deadline}}</template>
                  </el-table-column>
                  <el-table-column prop="peopleNum" label="人数"></el-table-column>
                  <el-table-column label="操作">
                    <template slot-scope="scope">
                      <el-button type="primary" size="small" @click="openPaper(scope.row.c_id, scope.row.classes.name)" plain>审批试卷</el-button>
                    </template>
                  </el-table-column>
                  <el-table-column prop="status" label="状态" width="200">
                  </el-table-column>

                </el-table>
              </el-collapse-item>
            </el-collapse>

          </el-tab-pane>
        </el-tabs> -->

        <el-collapse v-model="activeTestPaperList" @change="handleChange">
          <el-collapse-item :title="'E'+item.examId+' '+item.examName" :name="item.examId" v-for="(item , index) in testPaperList" :key="index">

            <el-table :data="item.classesList" style="width: 100%">
              <el-table-column label="班级id">
                <template slot-scope="scope">C{{scope.row.classesId}} </template>
              </el-table-column>
              <el-table-column prop="classesName" label="班级"></el-table-column>
              <el-table-column label="考试时间" width="320">
                <template slot-scope="scope">{{scope.row.startDate}} 至 {{scope.row.deadline}}</template>
              </el-table-column>
              <el-table-column prop="peopleNum" label="人数"></el-table-column>
              <el-table-column label="操作">
                <template slot-scope="scope">
                  <el-button type="primary" size="small" @click="openPaper(scope.row.classesId, item.examId)" plain>审批试卷</el-button>
                </template>
              </el-table-column>
              <el-table-column prop="status" label="状态" width="200">
              </el-table-column>

            </el-table>
          </el-collapse-item>
        </el-collapse>

      </div>

    </TopTab>
  </div>
</template>

<script>
import TopTab from "../../components/TopTab.vue";
import "../../assets/less/main/markTest.less";
export default {
  name: "MyCheckTest",
  components: {
    TopTab,
  },
  data() {
    return {
      activeName: "all",
      testPaperList: [],
      activeTestPaperList: [],
      tableData: [
        {
          number: "C00011",
          name: "王小虎",
          status: "审批完成",
          people_num: 3 + " 人",
        },
      ],
    };
  },
  created() {
    this.getTestPaperList();
  },
  methods: {
    handleClick() {
      console.log(this.activeName);
      if (this.activeName == "all") {
        this.activeTestPaperList = this.testPaperList;
      }
      if (this.activeName == "finish") {
        this.activeTestPaperList = this.testPaperList;
        this.activeTestPaperList.classesList = this.activeTestPaperList.classesList.filter(
          (item) => {
            return item.status;
          }
        );
      }
      if (this.activeName == "all") {
        this.activeTestPaperList = this.testPaperList;
      }
    },

    //获取试卷列表
    getTestPaperList() {
      this.$http.get("/getTestPaperByU_id", {}).then((res) => {
        if (res.code == 200) {
          for (let i = 0; i < res.data.length; i++) {
            res.data[i].classesList = [];
          }
          this.testPaperList = res.data;
        } else {
          this.$message(res.msg);
        }
      });
    },

    //获取发布试卷记录
    getTestPaper_classes(tp_id) {
      let params = {
        examId: tp_id,
      };
      this.$http.get("/queryClassesList", { params }).then((res) => {
        let data = res.data;
        if (res.code == 200) {
          for (let i = 0; i < data.length; i++) {
            data[i].status = data[i].status == 0 ? "待审批" : "审批完成";
          }

          for (let j = 0; j < this.testPaperList.length; j++) {
            if (tp_id == this.testPaperList[j].examId) {
              this.testPaperList[j].classesList = data;
            }
          }
        }
      });
    },

    handleChange(val) {
      console.log(val);
      for (let i = 0; i < val.length; i++) {
        console.log(111);
        this.getTestPaper_classes(val[i]);
      }
      console.log(this.testPaperList);
    },

    openPaper(classesId,examId){
      this.$router.push({
        path: "/main/classes/testSituation",
        query: { cId: classesId, tpId: examId },
      });
    }
  },
};
</script>

<style lang="less" scoped>

</style>


