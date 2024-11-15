<template>
  <div class="login register">
    <div class="info">
      <p>注册账号<span @click="goRouter('login')">返回</span></p>
      <el-form
        :model="form"
        status-icon
        :rules="rules"
        label-width="auto"
        ref="registerForm"
      >
        <el-form-item label="用户名" prop="name">
          <el-input v-model="form.name" placeholder="请输入您的用户名"></el-input>
        </el-form-item>

        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入邮箱地址"></el-input>
        </el-form-item>

        <el-form-item label="密码" prop="password">
          <el-input type="password"  v-model="form.password" placeholder="请输入密码"></el-input>
        </el-form-item>

        <el-form-item label="确认密码" prop="checkPass">
          <el-input type="password"  v-model="form.checkPass" placeholder="请再次输入密码"></el-input>
        </el-form-item>

        <el-form-item label="手机号码" prop="phone">
          <el-input v-model="form.phone" placeholder="可不填"></el-input>
        </el-form-item>
        <el-form-item label="性別" prop="sex">
        <el-radio v-for="(item) in sexList" v-model="form.sex"
                  :label="item">
          {{ item }}
        </el-radio>
        </el-form-item>
        <div class="register-but" @click="register('registerForm')">注册</div>

      </el-form>
    </div>
  </div>
</template>

<script>
import "../assets/less/login.less"
export default {
  name: "Register",
  data() {
       var checkName = (rule, value, callback) => {
            var reg = /^[\u4e00-\u9fa5\w]{3,16}$/;
            if(!reg.test(value)){
                callback(new Error('用户名只能是3-16位汉字、字母、数字、下划线'));
            }else{
                callback()
            }
        };
        var checkPassword = (rule, value, callback) => { 
            var reg = /^\w{6,16}$/;
            if(!reg.test(value)){
                callback(new Error('用户名只能是6-16位字母、数字、下划线'));
            }else{
                callback()
            }
        };
        var checkPassword2 = (rule, value, callback) => { 
            if(value!=this.form.password){
                callback(new Error('两次输入密码不一致!'));
            }else{
                callback()
            }
        };
        var checkPhone = (rule, value, callback) => { 
            if(value==""){
                callback()
            }
            var reg = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
            if(!reg.test(value)){
                callback(new Error('请输入正确的手机号码'));
            }else{
                callback()
            }
        };
        var checkEmail = (rule, value, callback) => {
            if(value==""){
                callback()
            }
            var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
            if(!reg.test(value)){
                callback(new Error('请输入正确的邮箱地址'));
            }else{
                callback()
            }
        };
    return {
      sexList: ['男','女'],
      form: {
          name: '',
          password:'',
          checkPass:'',
          phone:'',
          email:'',
        sex:'',
      },
      rules:{
          name:[
              { required: true, message: '请输入您的用户名', trigger: 'blur' },
              { validator: checkName, trigger: 'change' },
          ],
          password:[
              { required: true, message: '请输入密码', trigger: 'blur' },
              { validator: checkPassword, trigger: 'change' },
          ],
          checkPass:[
              { required: true, message: '请再次输入密码', trigger: 'blur' },
              { validator: checkPassword2, trigger: 'blur' },
          ],
          phone:[
              { validator: checkPhone, trigger: 'blur' },
          ],
          email:[
              { required: true, message: '请输入邮箱地址', trigger: 'blur' },
              { validator: checkEmail, trigger: 'blur' },
          ],
        sex:[
          { required: true, message: '请输入性別', trigger: 'blur' },
        ]
      },
        
    };
  },
  methods:{
    //表单提交
    register(formName){
      console.log(this.sexList)
        this.$refs[formName].validate((valid) => {
          if (valid) {

            // 处理post请求参数
            var request={
                userName:this.form.name,
                password:this.form.password,
                email:this.form.email,
                phone:this.form.phone,
                sex:this.form.sex,
            }
            this.$http.post('/register',request).then(res =>{
              if(res.code == 200){
                this.goRouter({name:"Login"})
                this.$message.success("注册成功");
              }
            })
            
          } else {
            console.log('error submit!!');
            return false;
          }
        });
    },

    //路由跳转
    goRouter(path){
      this.$router.push(path)
    },
  }
};
</script>

<style lang="less" scoped>
.register .info{
  height: 560px;
}
</style>
