<template>
  <div class="createTest testPaper">
    <div class="w">
      <div class="test-content">
        <!-- 题目内容 -->
        <div class="topics">
          {{ testData.question }}
          <div class="radio">
            <el-radio v-for="(item, index) in choiceList" :key="index" v-model="testData.userAnswer"
                      :label="item">
              {{ String.fromCharCode(65 + index) }}选项、
              {{ item }}
            </el-radio>
          </div>
          <div style="text-align: center">
            <hr>
            <el-button type="primary" size="mini" @click="submitTestpaper">确认答案并提交习题</el-button>
          </div>
        </div>
      </div>

    </div>
  </div>
</template>

<script type="text/javascript">
import "@/assets/less/testPaper.less";
import testPaperMixin from "@/mixins/testPaper-mixin";

export default {
  name: "ProblemPaperStu",
  mixins: [testPaperMixin],
  data() {
    return {
      userName: this.$store.state.userName,
      //试卷数据
      testData: {},
      isRead: false, //是否为只读模式
      switchPage: 0,
      choiceList: [],
      finishTest: false, //是否完成试卷
      //侧导航栏是否悬浮
      isFixed: false,
      topic_nav_style: "top:0px",
    };
  },
  computed: {},

  created() {
    this.getTestPaperData();
  },

  mounted() {
  },

  methods: {
    //提交试卷
    submitTestpaper() {
      console.log("11111", this.testData.userAnswer)
      // 处理post请求参数
      var request = {
        topicId: this.testData.topicId,
        userAnswer: this.testData.userAnswer,
      }
      if (this.userAnswer === null) {
        this.$message.error("选项不能为空");
      } else {
        this.$http.post('/userSubmitProblem', request).then(res => {
          if (res.code === 200) {
            this.$message.success(res.msg);
            // location.reload()
            window.close()
          }
        })
      }
    },

    //获取试卷数据
    getTestPaperData() {
      let params = {
        examId: this.$route.params.tp_id,
        classesId: this.$route.params.c_id,
      }
      this.$http.get('/recommend', {params}).then(res => {
        if (res.code === 200) {
          /* 判断用户是否已经完成试卷 */
          console.log("开始考试");
          this.finishTest = false
          this.isRead = false;
          this.testData = res.data;
          console.log("this.testData ==> ", res.data);
          this.choiceList = this.testData.choice.split("\n");
          console.log(this.choiceList)
        } else {

        }
      })
    },


    //滚动事件
    handleScroll() {
      let scrollTop =
          window.pageYOffset ||
          document.documentElement.scrollTop ||
          document.body.scrollTop; // 滚动条偏移量
      if (scrollTop > 154) {
        this.topic_nav_style = "top:" + (scrollTop + 62) + "px";
        this.isFixed = true;
      } else {
        this.isFixed = false;
      }
    },


    //点击题号定位到题目位置
    topicNav(type, index) {
      var i = this.topicNavIndex_mixin(type, index);
      console.log(i);
      document
          .getElementsByClassName("_location")
          [i - 1].scrollIntoView({behavior: "smooth", block: "start"});
    },

  }
  ,

}
;
</script>

<style>


.topic {
  max-width: 800px;
  padding: 20px;

  /*.question {*/
  /*  margin-bottom: 20px;*/
  /*  font-size: 18px;*/
  /*  line-height: 26px;*/
  /*  color: #333;*/
  /*}*/

  /*.score {*/
  /*  float: right;*/
  /*}*/

  /*.el-radio {*/
  /*  display: block;*/
  /*  margin-left: 20px;*/
  /*  color: #222;*/
  /*}*/

  /*.el-radio__label {*/
  /*  font-size: 16px;*/
  /*  line-height: 30px;*/
  /*  word-wrap: break-word;*/
  /*  white-space: normal;*/
  /*}*/

}

</style>

