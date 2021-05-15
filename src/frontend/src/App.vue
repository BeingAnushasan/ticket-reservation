<template>
  <div id="app">
    <div class="page-header">
      <TheHeader/>
    </div>
    <div class="page-body">
      <transition name="fadeIn" enter-active-class="animated fadeIn">
        <router-view class="view"></router-view>
      </transition>
    </div>
    <!--    <router-view/>-->
    <!--    <TheFooter/>-->
  </div>
</template>

<script>
import TheHeader from "@/components/TheHeader";
// import TheFooter from "@/components/TheFooter";
export default {
  components: {TheHeader},

}
</script>
<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}


</style>
