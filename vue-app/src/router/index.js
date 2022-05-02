import { createWebHistory, createRouter } from "vue-router";
import HomeView from '../views/HomeView.vue'
const routes =  [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: "/myRepo",
    alias: "/repos",
    name: "MyRepos",
    component: () => import('../components/RepoList')
  },
  {
    path: "/repos/:id",
    name: "repo-details",
    component: () => import('../components/Repos')
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router