export const routes = [
    {
        path: '/login',
        name: 'Login',
        component: () => import( '../views/Login.vue'),
        meta: {
            title: '登录'
        },
    },
    {
        path: '/register',
        name: 'Register',
        component: () => import( '../views/Register.vue'),
        meta: {
            title: '注册'
        },
    },

    {
        path: '/main',
        name: 'Main',
        component: () => import( '../views/Main.vue'),
        // meta:{
        //   title:'考试汇'
        // },
        children: [
            {
                path: 'home',
                name: 'Home',
                component: () => import('../views/main/Home.vue'),
                meta: {
                    title: '智慧导学系统'
                },
            },
            {
                path: "me",
                name: "Me",
                component: () => import('../views/main/Me.vue'),
                meta: {
                    title: '个体中心'
                },
            },
            // {
            //     path: "classes",
            //     name: "Classes",
            //     component: () => import('../views/classes/Index.vue'),
            //     children: [
            //         {
            //             path: "classesList",
            //             name: "ClassesList",
            //             component: () => import('../views/classes/ClassesList.vue')
            //         },
            //         {
            //             path: "classesSpace/:id",
            //             name: "ClassesSpace",
            //             component: () => import('../views/classes/ClassesSpace.vue'),
            //             meta: {
            //                 title: '班级空间'
            //             },
            //         },
            //         {
            //             path: "testSituation",
            //             name: "TestSituation",
            //             component: () => import('../views/classes/TestSituation.vue'),
            //             meta: {
            //                 title: '班级考试情况'
            //             },
            //         },
            //     ]
            // },
            {
                path: "problemRecommend",
                name: "ProblemRecommend",
                component: () => import('../views/problem/problemRecommend.vue'),
                meta: {
                    title: '习题推荐'
                },
            },
            {
                path: "ProblemHistory",
                name: "ProblemHistory",
                component: () => import('../views/problem/problemHistory.vue'),
                meta: {
                    title: '答题记录'
                },
            },
            {
                path: "problemStatistic",
                name: "problemStatistic",
                component: () => import('../views/problem/problemStatistic.vue'),
                meta: {
                    title: '习题推荐'
                },
            },


            {
                path: "topic",
                name: "Topic",
                component: () => import('../views/main/Topic.vue')
            },
            {
                path: "myTest",
                name: "MyTest",
                component: () => import('../views/myExam/MyTest.vue'),
                meta: {
                    title: '我的试卷'
                },
            },
            {
                path: "myFinishTest",
                name: "MyFinishTest",
                component: () => import('../views/main/MyFinishTest.vue')
            },
            {
                path: "myCheckTest",
                name: "MyCheckTest",
                component: () => import('../views/main/MyCheckTest.vue'),
            },
            {
                path: "myMessage",
                name: "MyMessage",
                component: () => import('../views/main/myMessage/MyMessage.vue'),
                children: [
                    {
                        path: "sendMessage",
                        name: "SendMessage",
                        component: () => import('../views/main/myMessage/SendMessage.vue'),
                    },
                    {
                        path: "inboxes",
                        name: "Inboxes",
                        component: () => import('../views/main/myMessage/Inboxes.vue'),
                    }
                ]
            }
        ]
    },

    {
        path: '/testPaperStu/:tp_id/:c_id',
        name: 'TestPaperStu',
        component: () => import( '../views/testPaper/TestPaperStu.vue'),
    },
    {
        path: '/testPaperTch/:type',
        name: 'createExam',
        component: () => import( '../views/testPaper/TestPaperTch.vue'),
        meta: {
            title: '新建试卷'
        },
    },
    {
        path: '/problemPaperTch/:type',
        name: 'problemPaperTch',
        component: () => import( '../views/problem/ProblemPaperStu.vue'),
        meta: {
            title: '新建试卷'
        },
    },
    {
        path: '/testPaperTch/:type/:tp_id',
        name: 'editExam',
        component: () => import( '../views/testPaper/TestPaperTch.vue'),
        meta: {
            title: '修改试卷'
        },
    },
    {
        path: '/markTestPaper',
        name: 'MarkTestPaper',
        component: () => import( '../views/testPaper/MarkTestPaper.vue'),
        meta: {
            title: '批改试卷'
        }
    },


    {
        path: '/*',
        redirect: {
            name: 'Home'
        }
    }
]