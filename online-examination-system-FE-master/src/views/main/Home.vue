<template>
  <div class="home">
    <TopTab title="首页">
      <div class="tab-content">
        <div class="home-introduce">
          <div>
            <p>智慧导学系统</p>
            <p>智慧导学系统</p>
          </div>
        </div>

        <ul class="home-header">
          <li @click="ProblemRecommend">习题推荐</li>
          <li @click="ProblemHistory">答题记录</li>
          <li @click="problemStatistic">习题统计</li>
          <li @click="me">个人资料</li>
          <!--          <template v-if="$role('student')">-->
<!--            <li @click="myClasses">我的班级</li>-->
<!--            <li @click="finishTest">我参加过的考试</li>-->
<!--            <li>功能开发中,敬请期待</li>-->
<!--          </template>-->
<!--          <template v-if="$role('teacher')">-->
<!--            <li @click="createClasses">创建班级</li>-->
<!--            <li @click="createExam">创建试卷</li>-->
<!--            <li @click="myClasses">我的班级</li>-->
<!--          </template>-->
        </ul>
<!--        <ul class="home-content">-->
<!--          <li class="myMessage">暂无消息通知</li>-->
<!--          <li class="more">功能开发中,敬请期待</li>-->
<!--        </ul>-->
      </div>
    </TopTab>


    <!-- 创建班级对话框 -->
    <CreateClasses ref="createClasses" @success="getClasses()" />
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from "@/components/HelloWorld.vue";
import TopTab from "../../components/TopTab.vue";
import "../../assets/less/main/home.less";
import { mapMutations } from "vuex";
import CreateClasses from '@/views/classes/components/CreateClasses.vue'

export default {
  name: "Home",
  components: {TopTab, CreateClasses },
  data() {
    return {
      enterClasses_id: "",
    };
  },
  created() {},
  watch: {},
  methods: {
    ...mapMutations(["setActiveName"]),

    // 个人中心
    me() {
      this.$router.push({
        name: "Me",
      });
      this.setActiveName("Me");
    },
    ProblemRecommend() {
      this.$router.push({
        name: "ProblemRecommend",
      });
      this.setActiveName("ProblemRecommend");
    },
    ProblemHistory() {
      this.$router.push({
        name: "ProblemHistory",
      });
      this.setActiveName("ProblemHistory");
    },
    problemStatistic() {
      this.$router.push({
        name: "problemStatistic",
      });
      this.setActiveName("problemStatistic");
    },
    
    // 我的班级
    myClasses() {
      this.$router.push({
        name: "ClassesList",
      });
      this.setActiveName(["Classes","ClassesList","ClassesSpace"]);
    },

    // 我参加过的考试
    finishTest() {
      this.$router.push({
        name: "MyFinishTest",
      });
      this.setActiveName("MyFinishTest");
    },

    // 创建试卷
    createExam() {
      const { href } = this.$router.resolve({
        name: "createExam",
        params: { type: 'add'}
      });
      window.open(href, "_blank");
    },

    // 创建班级
    createClasses() {
      this.$refs.createClasses.dialog = true  
    },

    
  },
};
</script>
