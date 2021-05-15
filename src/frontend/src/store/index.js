import Vue from "vue";
import Vuex from "vuex";
import router from "../router";
import cookie from 'vue-cookies';

// import AUTH from "../resources/Auth";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    //Global  control states
    backend_URL: "http://192.168.1.23:8085",
    isLoggedIn: false,


    // User Data
    token: cookie.get("token") || "",
    username: "user-name",

    count: 0,
  },
  mutations: {
    increment(state) {
      state.count++;
    },

    loggedIn(state) {
      state.isLoggedIn = true;
      router.push("/dashboard");

    },
    updateUserInfo(state, info){
      state.token = info.token || "";
      state.username = info.username;
    },
    signOut(state) {
      state.isLoggedIn = false;
      localStorage.removeItem("token");
      cookie.remove("token");
      router.push("/login");
      state.username = "";
    },
  },
  actions: {
    loggingIn (context, info){
      context.commit("loggedIn");
      context.commit("updateUserInfo", info);
    },
    loggingOut (context){
      context.commit("signOut");
    }
  },
  modules: {},
});
