import Vue from 'vue'
import VueRouter from 'vue-router'
import cookie from 'vue-cookies';


import Home from '../views/Home.vue'
import Login from "@/components/Login";
import Reserve from "../views/Reserve"
import Dashboard from"@/components/Dashboard"

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home,
        meta: {
            guest: true,
        }
    },
    {
        path: '/dashboard',
        name: 'Dashboard',
        component: Dashboard,
        meta: {
            requiresAuth: true,
        }
    },
    {
        path: '/login',
        name: 'Login',
        component: Login,
        meta: {
            requiresAuth: false,
        }
    },
    {
        path: '/reserve',
        name: 'Reserve Ticket',
        component: Reserve,
        meta: {
            requiresAuth: true,
        }
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})


router.beforeEach((to, from, next) => {
    if (to.meta.title) document.title = to.meta.title;
    const path = ["/login", "/"];
    if (
        path.includes(to.path) ||
        cookie.isKey("token")
    ) {
        return next();
    }
    next("/login");
});


export default router
