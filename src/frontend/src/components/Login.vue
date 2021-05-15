<template>
  <div class="container" style="max-width: 700px; align-content: center">
    <br />

    <div class="card bg-light" >
      <article class="card-body mx-auto" style="max-width: 700px;">
        <h4 class="card-title mt-3 text-center">Log In</h4>

        <form>
          <!-- form-group// -->
          <div class="form-group input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                <i class="fa fa-envelope"></i>
              </span>
            </div>
            <input
                v-model="form.username"
                name=""
                class="form-control"
                placeholder="Email address or Username"
                type="text"
            />
          </div>

          <!-- form-group end.// -->
          <div class="form-group input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                <i class="fa fa-lock"></i>
              </span>
            </div>
            <input
                class="form-control"
                placeholder=" password"
                v-model="form.password"
                type="password"
            />
          </div>

          <!-- form-group// -->
          <div class="form-group">
            <button
                type="submit"
                @click="onSubmit($event)"
                class="btn btn-primary btn-block"
            >
              Log In
            </button>
          </div>
          <!-- form-group// -->
        </form>

      </article>
    </div>
    <!-- card.// -->
  </div>
  <!--container end.//-->
</template>

<script>
import API from "../resources/API";
import decode from "jwt-decode";


export default {
  data() {
    return {
      form: {
        username: "",
        password: "",
      },
      show: true,
      isLoggedIn: this.$store.state.isLoggedIn,
    };
  },

  methods: {
    sayHello() {
      // API.sayHello();
    },
    onSubmit(evt) {
      evt.preventDefault();
      // alert(JSON.stringify(this.form));
      API.authenticate(this.form)
          .then((response) => {
            const token = response.data.jwt;
            const username = decode(token).sub;
            console.log("the token is: "+token+" And the username is: "+username);
            localStorage.setItem("token", JSON.stringify(token));
            this.$cookie.config('1d');
            this.$cookie.set("token", JSON.stringify(token));
            this.$store.dispatch("loggingIn",{ token, username} );

          })
          .then(this.$store.dispatch("loggingIn"))
          .then(this.$store.commit("updateUserInfo"))
          .catch(function(error) {
            console.log("Error message!: " + error);
            alert("Wrong Username Or Password: " + error);

            // return Promise.reject(error);
          });
    },
    onReset(evt) {
      evt.preventDefault();
      // this.$router.to("SignUp");
    },
  },
};
</script>

<style>
.divider-text {
  position: relative;
  text-align: center;
  margin-top: 15px;
  margin-bottom: 15px;
}
.divider-text span {
  padding: 7px;
  font-size: 12px;
  position: relative;
  z-index: 2;
}
.divider-text:after {
  content: "";
  position: absolute;
  width: 100%;
  border-bottom: 1px solid #ddd;
  top: 55%;
  left: 0;
  z-index: 1;
}

.btn-facebook {
  background-color: #405d9d;
  color: #fff;
}
.btn-twitter {
  background-color: #42aeec;
  color: #fff;
}
</style>
