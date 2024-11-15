<template>
    <div class="topic">


        <div class="topic" v-for="(t, index) in topicData" :key="index">
          <div class="question" v-if="t.topic_type != '3'">
            <span class="question_nunber">{{ index + 1 }}、</span>
            {{ t.question }}
            <span class="score">({{ t.score }}分)</span>
          </div>
          <div class="fillInBlank-question" v-else>
            <span class="question_nunber">{{ index + 1 }}、</span>
            <span class="con" v-for="(q, index) in t.question" :key="index">
              {{ q }} <span v-if="index != t.question.length - 1">_____</span>
            </span>
            <span class="score">({{ t.score }}分)</span>
          </div>

          <!-- 单选题 -->
          <div class="radio" v-if="t.topic_type == 0">
            <el-radio
              v-for="(item, index) in t.choice"
              :key="index"
              v-model="t.user_answer"
              :label="item"
            >
              {{ item }}
            </el-radio>
            {{ t.user_answer }}
          </div>
          <!-- 多选题 -->
          <div class="checkbox" v-if="t.topic_type == 1">
            <el-checkbox-group v-model="t.user_answer">
              <el-checkbox
                :label="item"
                v-for="(item, index) in t.choice"
                :key="index"
              ></el-checkbox>
            </el-checkbox-group>
            {{ t.user_answer }}
          </div>
          <!-- 判断题 -->
          <div class="TrueOrFalse" v-if="t.topic_type == 2">
            <el-radio v-model="t.user_answer" label="true">正确</el-radio>
            <el-radio v-model="t.user_answer" label="false">错误</el-radio>
            {{ t.user_answer }}
          </div>
          <!-- 填空题 -->
          <div class="fillInBlank" v-if="t.topic_type == 3">
            <el-input
              v-for="(q, index) in t.question"
              :key="index"
              type="textarea"
              autosize
              placeholder="请回答"
              v-model="t.user_answer[index]"
            >
            </el-input>
            {{ t.user_answer }}
          </div>
          <!-- 简答题 -->
          <div class="text" v-if="t.topic_type == 4">
            <el-input
              type="textarea"
              v-model="t.user_answer"
              :autosize="{ minRows: 3, maxRows: 10 }"
              placeholder="请回答"
            >
            </el-input>
            {{ t.user_answer }}
          </div>
        </div>


        
    </div>
</template>

<script>
import "../assets/less/topic.less"
export default {
    name:"Topic",

    // props:{
    //     type:Number|String,
    //     default(){
    //         return -1;
    //     },

    // },

    props:['number'],

    data(){
        return{
            topicData:[
                {
                    t_id:'1',
                    //题目类型==>  0:单选题  1:多选题  2:判断题  3:填空题  4:简答题
                    topic_type:0,
                    question:'这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目',
                    choice:[
                        'A、  选项',
                        'B、选项1111111111111 111111 1ssssss,111 1111111 111111111111 111111111111111 111111111111110000 00 000000000000000000000 000000 00000000 0000000000000000 000000000000',
                        'C、  选项',
                        'D、  选项',
                    ],
                    user_answer:'',
                    correct_answer:'A',
                    analysis:'这是答案分析',
                    score:'10',
                    subject_id:'1'
                },
                {
                    t_id:'2',
                    //题目类型==>  0:单选题  1:多选题  2:判断题  3:填空题  4:简答题
                    topic_type:'1',
                    question:'这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目',
                    choice:[
                        'A、  选项',
                        'B、选项1111111111111 111111 1ssssss,111 1111111 111111111111 111111111111111 111111111111110000 00 000000000000000000000 000000 00000000 0000000000000000 000000000000',
                        'C、  选项',
                        'D、  选项',
                    ],
                    user_answer:'',
                    correct_answer:'A',
                    analysis:'这是答案分析',
                    score:'10',
                    subject_id:'1'
                },
                {
                    t_id:'3',
                    //题目类型==>  0:单选题  1:多选题  2:判断题  3:填空题  4:简答题
                    topic_type:'2',
                    question:'这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目',
                    choice:[
                        'A、  选项',
                        'B、选项1111111111111 111111 1ssssss,111 1111111 111111111111 111111111111111 111111111111110000 00 000000000000000000000 000000 00000000 0000000000000000 000000000000',
                        'C、  选项',
                        'D、  选项',
                    ],
                    user_answer:'',
                    correct_answer:'A',
                    analysis:'这是答案分析',
                    score:'10',
                    subject_id:'1'
                },
                {
                    t_id:'4',
                    //题目类型==>  0:单选题  1:多选题  2:判断题  3:填空题  4:简答题
                    topic_type:'3',
                    question:'这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目',
                    choice:[
                        'A、  选项',
                        'B、选项1111111111111 111111 1ssssss,111 1111111 111111111111 111111111111111 111111111111110000 00 000000000000000000000 000000 00000000 0000000000000000 000000000000',
                        'C、  选项',
                        'D、  选项',
                    ],
                    user_answer:'',
                    correct_answer:'A',
                    analysis:'这是答案分析',
                    score:'10',
                    subject_id:'1'
                },
                {
                    t_id:'5',
                    //题目类型==>  0:单选题  1:多选题  2:判断题  3:填空题  4:简答题
                    topic_type:'4',
                    question:'这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目这是题目',
                    choice:[
                        'A、  选项',
                        'B、选项1111111111111 111111 1ssssss,111 1111111 111111111111 111111111111111 111111111111110000 00 000000000000000000000 000000 00000000 0000000000000000 000000000000',
                        'C、  选项',
                        'D、  选项',
                    ],
                    user_answer:'',
                    correct_answer:'A',
                    analysis:'这是答案分析',
                    score:'10',
                    subject_id:'1'
                },
            ],

            testData:{
                t_id: '1',
                name: '试卷题目',
                create_id: '1',
                creator_name: 'admin',
                create_date: '2020-11-21',
                subject_id: '1',
                subject_name: '这是科目类型',
                total_score: '100',
                pass_mark: '60',
                auto_mack: '1',
                topic_num: '20',
                permit_copy: '1',
                repeat_test: '1',
            },
        }
    }
}
</script>

