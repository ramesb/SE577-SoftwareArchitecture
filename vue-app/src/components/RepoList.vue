<template>
  <div class="list row">
    <div class="col-md-8">
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Search by title"
          v-model="title"/>
        <div class="input-group-append">
          <button class="btn btn-outline-secondary" type="button"
            @click="searchTitle"
          >
            Search
          </button>
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <h4>Repos List</h4>
      <ul class="list-group">
        <li class="list-group-item"
          :class="{ active: index == currentIndex }"
          v-for="(Repo, index) in Repos"
          :key="index"
          @click="setActiveRepo(Repo, index)"
        >
          {{ Repo.title }}
        </li>
      </ul>

      <button class="m-3 btn btn-sm btn-danger" @click="removeAllRepos">
        Remove All
      </button>
    </div>
    <div class="col-md-6">
      <div v-if="currentRepo">
        <h4>Repo</h4>
        <div>
          <label><strong>Title:</strong></label> {{ currentRepo.title }}
        </div>
        <div>
          <label><strong>Description:</strong></label> {{ currentRepo.description }}
        </div>
        <div>
          <label><strong>Status:</strong></label> {{ currentRepo.published ? "Published" : "Pending" }}
        </div>

        <router-link :to="'/Repos/' + currentRepo.id" class="badge badge-warning">Edit</router-link>
      </div>
      <div v-else>
        <br />
        <p>Please click on a Repo...</p>
      </div>
    </div>
  </div>
</template>

<script>
import RepoDataService from "../services/RepoDataServices";

export default {
  name: "Repos-list",
  data() {
    return {
      Repos: [],
      currentRepo: null,
      currentIndex: -1,
      title: ""
    };
  },
  methods: {
    retrieveRepos() {
      RepoDataService.getAll()
        .then(response => {
          this.Repos = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    refreshList() {
      this.retrieveRepos();
      this.currentRepo = null;
      this.currentIndex = -1;
    },

    setActiveRepo(Repo, index) {
      this.currentRepo = Repo;
      this.currentIndex = Repo ? index : -1;
    },

    removeAllRepos() {
      RepoDataService.deleteAll()
        .then(response => {
          console.log(response.data);
          this.refreshList();
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    searchTitle() {
      RepoDataService.findByTitle(this.title)
        .then(response => {
          this.Repos = response.data;
          this.setActiveRepo(null);
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.retrieveRepos();
  }
};

</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>
