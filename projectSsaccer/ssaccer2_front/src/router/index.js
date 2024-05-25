import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import LadderView from "@/views/LadderView.vue";
import PostCreateView from "@/views/posts/PostCreateView.vue";
import PostDetailView from "@/views/posts/PostDetailView.vue";
import PostListView from "@/views/posts/PostListView.vue";
import PostEditView from "@/views/posts/PostEditView.vue";
import PostJoinFormView from "@/views/posts/PostJoinFormView.vue";
import NotFoundView from "@/views/NotFoundView.vue";
import NestedView from "@/views/nested/NestedView.vue";
import NestedOneView from "@/views/nested/NestedOneView.vue";
import NestedTwoView from "@/views/nested/NestedTwoView.vue";
import NestedThreeView from "@/views/nested/NestedThreeView.vue";
import NestedFourView from "@/views/nested/NestedFourView.vue";
import NestedFiveView from "@/views/nested/NestedFiveView.vue";
import NestedSixView from "@/views/nested/NestedSixView.vue";
import NestedSevenView from "@/views/nested/NestedSevenView.vue";
import NestedEightView from "@/views/nested/NestedEightView.vue";
import NestedHomeView from "@/views/nested/NestedHomeView.vue";
import LoginView from "@/views/LoginView.vue";
import MyPageView from "@/views/MyPageView.vue";
import MyTeamView from "@/views/MyTeamView.vue";
import LockerRoomView from "@/views/LockerRoomView.vue";
import PostLockerDetailView from "@/views/posts/PostLockerDetailView.vue";
import { useUserStore } from "@/stores/user";
import { ref, computed } from "vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: HomeView,
  },
  {
    path: "/login",
    name: "Login",
    component: LoginView,
  },
  {
    path: "/myPage",
    name: "MyPage",
    component: MyPageView,
  },
  {
    path: "/lockerRoom",
    name: "LockerRoom",
    component: LockerRoomView,
  },
  {
    path: "/lockerRoom/:id",
    name: "PostLockerDetailView",
    component: PostLockerDetailView,
  },
  {
    path: "/myTeam",
    name: "MyTeam",
    component: MyTeamView,
  },
  {
    path: "/ladder",
    name: "Ladder",
    component: LadderView,
  },
  {
    path: "/posts",
    name: "PostList",
    component: PostListView,
  },
  {
    path: "/posts/create",
    name: "PostCreate",
    component: PostCreateView,
  },
  {
    path: "/posts/:id",
    name: "PostDetail",
    component: PostDetailView,
    props: true,
    // props: route => ({ id: parseInt(route.params.id) }),
  },
  {
    path: "/posts/:id/join",
    name: "JoinForm",
    component: PostJoinFormView,
    props: true,
  },
  {
    path: "/posts/:id/edit",
    name: "PostEdit",
    component: PostEditView,
  },

  {
    path: "/:pathMatch(.*)*",
    name: "NotFound",
    component: NotFoundView,
  },
  {
    path: "/nested",
    name: "Nested",
    component: NestedView,
    children: [
      {
        path: "",
        name: "NestedHome",
        component: NestedHomeView,
      },
      {
        path: "one",
        name: "NestedOne",
        component: NestedOneView,
      },
      {
        path: "two",
        name: "NestedTwo",
        component: NestedTwoView,
      },
      {
        path: "three",
        name: "NestedThree",
        component: NestedThreeView,
      },
      {
        path: "four",
        name: "NestedFour",
        component: NestedFourView,
      },
      {
        path: "five",
        name: "NestedFive",
        component: NestedFiveView,
      },
      {
        path: "six",
        name: "NestedSix",
        component: NestedSixView,
      },
      {
        path: "seven",
        name: "NestedSeven",
        component: NestedSevenView,
      },
      {
        path: "eight",
        name: "NestedEight",
        component: NestedEightView,
      },
    ],
  },
];
function removeQueryString(to) {
  if (Object.keys(to.query).length > 0) {
    return { path: to.path, query: {} };
  }
}
const router = createRouter({
  history: createWebHistory(),
  // history: createWebHashHistory(),
  routes,
});

router.beforeEach(async (to, from, next) => {
  const userStore = await useUserStore();

  // 유저 로그인 인증여부 확인 및 무한 리디렉션 방지
  if (
    !userStore.Authenticated &&
    to.name !== "Login" &&
    to.name !== "Home" &&
    to.path !== "/nested"
  ) {
    console.log("로그인하세요!");
    // 유저를 로그인 페이지로 리디렉션
    return next({ name: "Login" });
  }

  // 로그인 페이지로 이동 시 인증되어 있다면 마이페이지로 리디렉션
  if (userStore.Authenticated && to.name === "Login") {
    return next({ name: "MyPage" });
  } else next();
});

export default router;
