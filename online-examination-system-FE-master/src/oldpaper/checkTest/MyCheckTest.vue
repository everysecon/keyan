<template>
    <div class="content-bg">
        <div class="tab-title" >
            <div class="tabTitle-item" v-for="(item,index) in menu" :key="index" 
            :class="activeId==item.test_id?'active':''" @click="goRouter(item)" >
                {{item.title}}
                    <span v-if="index!=0" class="el-icon-close" @click.stop="removePaper(item.test_id)"></span>
            </div>
        </div>

        <div class="tab-item">
            <router-view @newTest="newTest"/>
        </div>
    </div>
</template>

<script>
import "../../../assets/less/my_tab.less"

export default {
    name:"MyCheckTest",
    data() {
        return {
            activeId: '-1',

            menu:[
                {title:"我审批过的试卷",path:"/main/myCheckTest/checkTestList",name:"CheckTestList",test_id:"-1"},
                {title:"试卷1",path:"/main/myCheckTest/checkTestList",name:"CheckTest",test_id:"0001",closable:false}
            ]
        };
    },
    created(){
        //查询sessionStorage
        if(sessionStorage['openCheckTestId']!=null){
            var openCheckTestId=JSON.parse(sessionStorage.getItem("openCheckTestId"))

            for(let i=0;i<openCheckTestId.id.length;i++){
                this.menu.push({
                    title:openCheckTestId.title[i],
                    path:"/main/myCheckTest/checkTest",
                    name:"CheckTest",
                    test_id:openCheckTestId.id[i]
                })
            }
            
            // console.log(openCheckTestId);
        }

        if(this.$route.params.test_id==undefined){
            this.activeId="-1"
        }else{
            this.activeId=this.$route.params.test_id 

        }

    },
    methods: {
        //路由跳转
        goRouter(item){
            if(this.activeId==item.test_id){
                return
            }
            this.activeId=item.test_id
            this.$router.push({
                name:item.name,
                params:{test_id:item.test_id}
            })
        },
        //打开新的试卷
        newTest(id,title){
            this.menu.push({
                title,
                path:"/main/myCheckTest/checkTest",
                name:"CheckTest",
                test_id:id
            })
            this.activeId=id;

            //sessionStorage存储   刷新后依旧有效
                //如果openCheckTestId不存在,初始化openCheckTestId
            if(sessionStorage['openCheckTestId']==null){
                var openCheckTestId={
                    title:[title],
                    id:[id]
                }
                sessionStorage.setItem('openCheckTestId', JSON.stringify(openCheckTestId));
            }else{
                var openCheckTestId=JSON.parse(sessionStorage.getItem("openCheckTestId"))
                // console.log(openCheckTestId.id);
                if(openCheckTestId.id.indexOf(id)==-1){
                    openCheckTestId.id.push(id);
                    openCheckTestId.title.push(title);
                    sessionStorage.setItem('openCheckTestId', JSON.stringify(openCheckTestId));
                }
                
            }

            this.$router.push({
                name:"CheckTest",
                params:{test_id:id}
            })
        },

        //关闭页面
        removePaper(id){
            for(let i=0; i<this.menu.length;i++){
                if(this.menu[i].test_id==id){
                    this.menu.splice(i,1);
                    break;
                }
            }

            //sessionStorage操作
            var openCheckTestId=JSON.parse(sessionStorage.getItem("openCheckTestId"))
            console.log(openCheckTestId);
            for(let i=0; i<openCheckTestId.id.length;i++){
                if(openCheckTestId.id[i]==id){
                    openCheckTestId.id.splice(i,1);
                    openCheckTestId.title.splice(i,1);
                    sessionStorage.setItem('openCheckTestId', JSON.stringify(openCheckTestId));
                    break;
                }
            }
        }

    }
}
</script>
