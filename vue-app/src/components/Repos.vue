<template>
  <div v-if="currentRepo" class="edit-form">
    <h4>Repo</h4>
    <form>
      <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title"
          v-model="currentRepo.title"
        />
      </div>
      <div class="form-group">
        <label for="description">Description</label>
        <input type="text" class="form-control" id="description"
          v-model="currentRepo.description"
        />
      </div>

      <div class="form-group">
        <label><strong>Status:</strong></label>
        {{ currentRepo.published ? "Published" : "Pending" }}
      </div>
    </form>

    <button class="badge badge-primary mr-2"
      v-if="currentRepo.published"
      @click="updatePublished(false)"
    >
      UnPublish
    </button>
    <button v-else class="badge badge-primary mr-2"
      @click="updatePublished(true)"
    >
      Publish
    </button>

    <button class="badge badge-danger mr-2"
      @click="deleteRepo"
    >
      Delete
    </button>

    <button type="submit" class="badge badge-success"
      @click="updateRepo"
    >
      Update
    </button>
    <p>{{ message }}</p>
  </div>

  <div v-else>
    <br />
    <p>Please click on a Repo...</p>
  </div>
</template>

<script>
import RepoDataService from "../services/RepoDataServices";

export default {
  name: "MyRepo",
  data() {
    return {
      currentRepo: null,
      message: ''
    };
  },
  methods: {
    getRepo(id) {
      RepoDataService.get(id)
        .then(response => {
          this.currentRepo = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    updatePublished(status) {
      var data = {
        id: this.currentRepo.id,
        title: this.currentRepo.title,
        description: this.currentRepo.description,
        published: status
      };

      RepoDataService.update(this.currentRepo.id, data)
        .then(response => {
          console.log(response.data);
          this.currentRepo.published = status;
          this.message = 'The status was updated successfully!';
        })
        .catch(e => {
          console.log(e);
        });
    },

    updateRepo() {
      RepoDataService.update(this.currentRepo.id, this.currentRepo)
        .then(response => {
          console.log(response.data);
          this.message = 'The Repo was updated successfully!';
        })
        .catch(e => {
          console.log(e);
        });
    },

    deleteRepo() {
      RepoDataService.delete(this.currentRepo.id)
        .then(response => {
          console.log(response.data);
          this.$router.push({ name: "Repos" });
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.message = '';
    this.getRepo(this.$route.params.id);
  }
};
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>
