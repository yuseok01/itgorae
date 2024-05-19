import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import MarketView from '../views/MarketView.vue';
import LeagueView from '../views/LeagueView.vue';
import TeamView from '../views/TeamView.vue';
import LoginView from '../views/LoginView.vue';
import PostCreateView from '../views/posts/PostCreateView.vue';
import PostDetailView from '../views/posts/PostDetailView.vue';
import PostEditView from '../views/posts/PostEditView.vue';
import PostListView from '../views/posts/PostListView.vue';
import NotFoundView from '../views/NotFoundView.vue';
import NestedView from '../views/nested/NestedView.vue';
import NestedOneView from '../views/nested/NestedOne.vue';
import NestedTwoView from '../views/nested/NestedTwo.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomeView,
  },
  {
    path: '/Market',
    name: 'Market',
    component: MarketView,
  },
  {
    path: '/League',
    name: 'League',
    component: LeagueView,
  },
  {
    path: '/Team',
    name: 'Team',
    component: TeamView,
  },
  {
    path: '/Login',
    name: 'Login',
    component: LoginView,
  },
  {
    path: '/posts',
    name: 'PostList',
    component: PostListView,
  },
  {
    path: '/posts/create',
    name: 'PostCreate',
    component: PostCreateView,
  },
  {
    path: '/posts/:id',
    name: 'PostDetail',
    component: PostDetailView,
    props: true,
    // props: route => ({id: parseInt(route.params.id),
    // }),
  },
  {
    path: '/posts/:id/edit',
    name: 'PostEdit',
    component: PostEditView,
  },
  {
    path: '/:pathMatch(.*)*',
    name: 'NotFound',
    component: NotFoundView,
  },
  {
    path: '/nested',
    name: 'Nested',
    component: NestedView,
    children: [
      {
        path: 'one',
        name: 'NestedOne',
        component: NestedOneView,
      },
      {
        path: 'two',
        name: 'NestedTwo',
        component: NestedTwoView,
      },
    ],
  },

  // /*
  // ? 쿼리로 받기 searchText : love
  // #hash로 받기
  // */
];

const router = createRouter({
  history: createWebHistory('/'),
  routes,
});

export default router;
