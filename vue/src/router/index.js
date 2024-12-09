import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {path: '/',redirect:'/manager/home'},
    {
      path: "/manager",
      component:()=>import("@/views/Manager.vue"),
      children:[
        {path: "home", meta:{name:"系统首页"} , component:()=>import("@/views/manager/Home.vue"),},
        {path: "admin", meta:{name:"管理员信息"} , component:()=>import("@/views/manager/Admin.vue"),},
        {path: "person", meta:{name:"个人资料"} , component:()=>import("@/views/manager/Person.vue"),},
        {path: "password", meta:{name:"修改密码"} , component:()=>import("@/views/manager/Password.vue"),},
        {path: "notice", meta:{name:"系统公告"} , component:()=>import("@/views/manager/Notice.vue"),},
        {path: "article", meta:{name:"旅游攻略"} , component:()=>import("@/views/manager/Article.vue"),},
        {path: "routes", meta:{name:"旅游路线"} , component:()=>import("@/views/manager/Routes.vue"),},
        {path: "travels", meta:{name:"游记信息"} , component:()=>import("@/views/manager/Travels.vue"),},
        {path: "user", meta:{name:"用户管理"} , component:()=>import("@/views/manager/User.vue"),},
        ]
    },
    {path:'/login',component:()=>import('@/views/login.vue')},
    {path:'/adminlogin',component:()=>import('@/views/AdminLogin.vue')},
    {path:'/register',component:()=>import('@/views/register.vue')},
    {path:'/404',component:()=>import('@/views/404.vue')},
    {path:'/:pathMatch(.*)',redirect:"/404"},

    {
      path: "/front",
      component:()=>import("@/views/Front.vue"),
      children:[
        {path: "home", component:()=>import("@/views/front/Home.vue")},
        {path: "person", component:()=>import("@/views/front/Person.vue"),},
        {path: "password", component:()=>import("@/views/front/Password.vue"),},
        {path: "addTravel", component:()=>import("@/views/front/AddTravel.vue"),},
        {path: "travels", component:()=>import("@/views/front/Travels.vue"),},
        {path: "travelDetail", component:()=>import("@/views/front/TravelDetail.vue"),},

      ]
    },
  ]
})

export default router