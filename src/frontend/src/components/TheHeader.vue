<template>
  <div>
  <div id="nav">
    <v-app-bar
        dense
        dark
    >
      <v-toolbar-title>
        <router-link  v-if="!isLoggedIn" to="/">ReserveIt</router-link>
        <router-link  v-if="isLoggedIn" to="/dashboard">ReserveIt</router-link>
      </v-toolbar-title>

      <v-spacer></v-spacer>

      <v-btn v-if="isLoggedIn">
        <router-link to="/reserve" >Reserve Tickets</router-link>
      </v-btn>
      <v-spacer></v-spacer>
      <v-btn v-if="!isLoggedIn">
        <router-link to="/login" >Login</router-link>
      </v-btn>

      <b-dropdown text="Account" v-if="isLoggedIn" >
        <b-dropdown-item @click="logOut()">
          Log Out
        </b-dropdown-item>
      </b-dropdown>
    </v-app-bar>
  </div>

  </div>
</template>

<script>
export default {
  name: "TheHeader",
  data() {
    return {
      form: {
        username: '',
        name: '',
      },
      modalShow: false,
    }
  },
  computed: {
    isLoggedIn() {
      return this.$cookie.isKey("token");
    }
  },
  methods: {
    openLoginModal() {
      this.modalShow = true;
    },
    logOut() {
      this.$store.dispatch("loggingOut" );
    }
  }
}
</script>

<style lang="scss">
//#nav {
//  padding: 0;
//
//  a {
//    font-weight: bold;
//    color: #2c3e50;
//
//    &.router-link-exact-active {
//      color: #42b983;
//    }
//  }
//}

</style>