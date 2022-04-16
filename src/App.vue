<template>
  <div id="app" class="main-container">
    <header></header>
    <router-view></router-view>
    <footer></footer>
  </div>
  <div class="page">
    <router-view></router-view>
    <div class="help-text">
      <p>viewing my repositories goes here.</p>
      <a href="https://github.com/ramesb/SE577-week-1">View Source Code</a>
    </div>
  </div>

</template>

<script>
export default {
  name: 'app'
}
</script>