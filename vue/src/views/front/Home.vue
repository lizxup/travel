<template>
  <div>
    <el-carousel height="400px" :interval="5000">
      <el-carousel-item v-for="item in data.imgs" :key="item">
        <img :src="item" alt="" style="width: 100%">
      </el-carousel-item>
    </el-carousel>

    <div style="display: flex; grid-gap:40px ;width: 80%;margin: 10px auto">
  <!--    左边游记的部分-->
      <div style="flex : 1">
        <div style="display: flex;align-items:center; border-bottom: 1px solid #ddd">
          <div class ='item' :class="{'active':data.sort === 'hot'}" @click = "loadBySort('hot')">热门游记</div>
          <div class ='item' :class="{'active':data.sort === 'new'}" @click = "loadBySort('new')">最近发表</div>
          <div style="flex: 1;text-align: right">
            <el-button @click = "goPage('/front/addTravel')"type = primary style="Padding:10px 30px" >
              <el-icon>
                <Edit/>
              </el-icon>
              写游记
            </el-button></div>
        </div>

        <div>
          <div v-for="item in data.travelList" :key="item.id" style="margin: 20px 0">
            <div style = "display: flex ;grid-gap: 20px">
              <img :src="item.cover" alt=""  style="width: 180px;height: 150px;border: 5px"/>
              <div style="flex: 1;">
                <a :href="'/front/travelDetail?id=' + item.id"><div class = "title line1"> {{item.title}}</div></a>
                <div style="color: #666;margin:20px 0;text-align: justify ; height: 55px" class="line3">{{item.descr}}</div>
                <div style="color: #666; display: flex;align-items: center" >
                  <span style="margin-right: 20px"><el-icon size="14" style="top: 2px"><Location></Location></el-icon>{{item.location}}</span>
                  <span style="margin-right: 20px">By.{{item.username}}</span>
                  <span style="margin-right: 20px"><el-icon size="14" style="top: 2px"><View/></el-icon>{{item.readCount}}</span>
                  <span style="margin-right: 20px"><el-icon size="14" style="top: 2px"><Clock/></el-icon>{{item.time}}</span>
                  <strong style="color: orange; font-size: 20px;margin-right: 5px">{{ item.praiseCount }}</strong>
                  <div class = 'top' @click="top(item)">顶</div>
                </div>
              </div>
            </div>
          </div>
          <div style="display: flex;justify-content: end" v-if="data.total">
            <el-pagination @current-change="loadTravels" siza="small" background layout="prev, pager, next" :page-size="data.pageSize" v-model:current-page="data.pageNum" :total="data.total" />
          </div>
        </div>
      </div>


      <!--    右边攻略的部分-->
      <div style="width: 300px">
  <!--      攻略部分-->
        <div>
          <div style="padding: 10px 0; display: flex; align-items: center; border-bottom: 1px solid #ddd; margin-bottom: 20px">
            <div style="flex:1;font-size: 18px">旅游攻略推荐</div>
            <a href=""><div style="color:#666;">更多>></div></a>
          </div>
          <div>
            <div v-for="item in data.articleList" :key="item.id" style="margin: 20px 0">
              <img :src="item.cover" alt="" style="width: 100%; height: 200px; border-radius: 5px">
              <a :href="'/front/articleDetail?id=' + item.id"><div class="title line1">{{ item.title }}</div></a>
            </div>
          </div>
        </div>


        <!--旅游网最新公告-->
        <div>
          <div style="padding: 10px 0; border-bottom: 1px solid #ddd">
            <div style="flex: 1; font-size: 18px">旅游网最新公告</div>
          </div>
          <div v-for="item in data.noticeList" :key="item.id" style="margin: 10px 0">
            <div style="font-size: 12px; color: #666;">{{ item.content }}</div>
          </div>
        </div>


      </div>
    </div>
  </div>

</template>

<script setup>
import { reactive } from "vue";
import img1 from "@/assets/imgs/img1.png"
import img2 from "@/assets/imgs/img2.png"
import img3 from "@/assets/imgs/img3.png"
import request from "@/utils/request.js";



const data = reactive({
  imgs:[img1,img2,img3],
  sort : "hot",
  pageNum : 1,
  pageSize:5,
  total:0,
  travelList : [],
  articleList:[],
  noticeList:[]

})
request.get('/article/selectRecommend').then(res =>{
  data.articleList = res.data
})

request.get('/notice/selectAll').then(res =>{
  // 只显示最新的两条
  data.noticeList = res.data.splice(0,2)
})

const loadBySort = (sort)=>{
  data.sort=sort
  loadTravels();

}

const goPage =(path)=>{
  location.href = path
}
const top = (id)=>{

}


const loadTravels=()=>{
  request.get('/travels/selectFrontPage', {
    params: {
      pageNum: data.pageNum,
      pageSize: data.pageSize,
      sort: data.sort
    }
  }).then(res => {
    if (res.code === '200') {
      data.travelList = res.data?.list || []
      data.total = res.data?.total
    }
  })
}
loadTravels()
</script>

<style>
.item{
  padding: 10px 20px;
  cursor: pointer;
  font-size: 18px;
}
.active{
  border-bottom: 1px solid #189500;
  color: #189500;
}

.title{
  font-size: 18px;
  color:#333;
}

.title:hover {
  color: #189500;
  text-decoration: underline;
}
</style>