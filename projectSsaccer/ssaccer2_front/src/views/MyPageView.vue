<template>
  <div class="container py-4 text-center d-flex justify-content-center">
    <div class="card hex-card">
      <div class="card-image">
        <img :src="user.userImage" class="card-img-top" alt="..." />
      </div>
      <div class="card-body">
        <h5 class="card-title">{{ user.userName }}</h5>
        <p class="card-text">
          <span>별명: {{ user.nickName }}</span
          ><br />
          <span>포지션: {{ user.position }}</span
          ><br />
          <span>골: {{ user.userGoals }}</span
          ><br />
          <span>어시스트: {{ user.userAssists }}</span>
        </p>
        <button @click="logout" class="btn btn-primary">로그아웃</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import { useUserStore } from "@/stores/user";

const store = useUserStore();
const router = useRouter();
const logout = () => {
  store.userLogout();
  router.push({ name: "Home" });
};

const jsonString = sessionStorage.getItem("user");
const user = JSON.parse(jsonString);
</script>

<style scoped>
.container {
  background-color: rgba(255, 255, 255, 0.5); /* 흰색 배경과 투명도 0.5 설정 */
}

.hex-card {
  position: relative;
  width: 220px; /* 카드의 너비를 조금 좁게 조정 */
  height: 420px; /* 카드의 높이를 길게 조정 */
  background-color: #fff;
  margin: 20px;
  clip-path: polygon(50% 0%, 100% 25%, 100% 75%, 50% 100%, 0% 75%, 0% 25%);
  border: 10px solid gold; /* 금색 테두리 */
  overflow: hidden;
}

.card-image {
  position: relative;
  width: 120%;
  height: 65%; /* 이미지 높이를 전체 높이의 65%로 조정 */
  overflow: hidden;
}

.card-img-top {
  width: 100%;
  height: 100%;
  object-fit: cover;
  clip-path: polygon(50% 0%, 100% 25%, 100% 75%, 50% 100%, 0% 75%, 0% 25%);
}

.card-body {
  padding: 15px;
}

.card-title {
  font-size: 1.5em;
  margin-bottom: 10px;
}

.card-text {
  font-size: 1em;
  line-height: 1.5;
}
</style>
