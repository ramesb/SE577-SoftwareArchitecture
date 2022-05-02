<template>
  <div class="myRepo">
    <h1>This is My Repo page</h1>
  </div>
</template>


<script>
// @ is an alias to /src
import RepoList from '@/components/RepoList.vue'

export default {
  name: 'RepoView',
  components: {
    RepoList
  }
}
</script>