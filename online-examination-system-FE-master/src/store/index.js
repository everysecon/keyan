import Vue from 'vue'
import Vuex from 'vuex'
import api from '@/api/axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    activeName: 'Home',// 导航栏激活名称

    tchNav: [
      {
        i:"el-icon-s-home",
        title:"首页",
        path:"/main/home",
        name:"Home",
      },
      // {
      //   i:"el-icon-s-grid",
      //   title:"我的班级",
      //   path:"/main/classes/classesList",
      //   name:["Classes","ClassesList","ClassesSpace"]
      // },
      // {
      //   i:"el-icon-document-copy",
      //   title:"我的试卷",
      //   path:"/main/myTest",
      //   name:"MyTest"
      // },
      {
        i:"el-icon-s-grid",
        title:"习题推荐",
        path:"/main/problemRecommend",
        name:["ProblemRecommend"]
      },
      {
        i:"el-icon-s-grid",
        title:"答题记录",
        path:"/main/problemHistory",
        name:["ProblemHistory"]
      },
      {
        i:"el-icon-s-grid",
        title:"习题统计",
        path:"/main/problemStatistic",
        name:["ProblemStatistic"]
      },
      // {
      //   i:"el-icon-tickets",
      //   title:"我的题库",
      //   path:"/main/topic",
      //   name:"Topic"
      // },
      // {
      //   i:"el-icon-document-checked",
      //   title:"审批试卷",
      //   path:"/main/myCheckTest",
      //   name:"MyCheckTest"
      // },
      // {
      //   i:"el-icon-message",
      //   title:"我的消息",
      //   path:"/main/myMessage/inboxes",
      //   name:["Inboxes","SendMessage","MyMessage"]
      // },
      {
        i:"el-icon-user",
        title:"个人中心",
        path:"/main/me",
        name:"Me"
      },
      // {
      //   i:"iconfont icon-laoshi",
      //   title:"变更为学生身份",
      //   path:"/main/changeStatus",
      //   name:"ChangeStatus"
      // }
    ],
    stuNav: [
      {
        i:"el-icon-s-home",
        title:"首页",
        path:"/main/home",
        name:"Home"
      },
      {
        i:"el-icon-s-grid",
        title:"我的班级",
        path:"/main/classes/classesList",
        name:["Classes","ClassesList","ClassesSpace"]
      },
      {
        i:"el-icon-s-grid",
        title:"习题推荐",
        path:"/main/problemRecommend",
        name:["ProblemRecommend"]
      },
      {
        i:"el-icon-edit-outline",
        title:"我考过的试卷",
        path:"/main/MyFinishTest",
        name:"MyFinishTest"
      },
      // {
      //   i:"el-icon-message",
      //   title:"我的消息",
      //   path:"/main/myMessage/inboxes",
      //   name:["Inboxes","SendMessage","MyMessage"]
      // },
      {
        i:"el-icon-user",
        title:"个人中心",
        path:"/main/me",
        name:"Me"
      },
      // {
      //   i:"iconfont icon-laoshi",
      //   title:"变更为教师身份",
      //   path:"/main/changeStatus",
      //   name:"ChangeStatus"
      // }
    ],
    userName: '',
    userPhoto: '',
    userRole: 'student',

    joinWayType: [
      {key: 'all' , value: '允许任何人加入'},
      {key: 'apply' , value: '需要管理员同意申请'},
      {key: 'no' , value: '不允许任何人加入'},
    ]
  },
  mutations: {
    setActiveName(state,data){
      state.activeName = data
    },

    setUserName(state,data){
      state.userName = data
    },

    setUserRole(state,data){
      state.userRole = data
    },

    setUserPhoto(state,data){
      if(data){
        state.userPhoto = Vue.prototype.$imageBaseUrl + data
      }else{
        state.userPhoto = null
      }
    },
    setTestData(state,data){
      state.testData = data
    }

  },
  actions: {
    async getRole({commit ,state}){
      const res = await api.get("/getUserById",{})
      commit('setUserRole', res.data.role)
      commit('setUserName', res.data.userName)
      commit('setUserPhoto',  res.data.photo)
      return res.data;
    }
  },
  modules: {
  }
})
