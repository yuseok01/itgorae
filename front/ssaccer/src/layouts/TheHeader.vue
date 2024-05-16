<template>
  <div class="container">
    <div class="video-wrap">
      <video :src="video" muted autoplay loop :poster="sample"></video>
    </div>
  </div>
  <header>
    <nav class="navbar">
      <div class="navbar-logo">
        <img class="logo" :src="logo" />
        <a href="">SSACCER</a>
      </div>
      <div class="navbar-menu">
        <li><a href="">Home</a></li>
        <li><a href="">이적 시장</a></li>
        <li><a href="">순위전</a></li>
        <li><a href="">팀 매뉴</a></li>
        <li><a href="">로그인</a></li>
      </div>

      <div class="navbar-icons"></div>
    </nav>
  </header>
</template>

<script setup>
import video from '@/layouts/assets/video.mp4';
import sample from '@/layouts/assets/sample-poster.jpg';
import logo from '@/layouts/assets/logo.png';
</script>
<style lang="scss" scoped>
a {
  text-decoration: none;
  color: white;
}
* {
  box-sizing: border-box;
}
.container {
  background-color: #000;
  z-index: 1;
}

// 반응형 백그라운드 비디오
.video-wrap {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  overflow: hidden;
}
.video-wrap video {
  position: absolute;
  top: 50%;
  left: 50%;
  width: auto;
  height: 100%;
  min-width: 100%;
  min-height: 100%;
  transform: translate(-50%, -50%);
  object-fit: cover;
}
header {
  margin: 0;
  position: relative;
  z-index: 2;
}
.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: rgba(0, 0, 0, 0.5);
  padding: 8px 70px;
}
.logo {
  width: 50px; /* 이미지 너비 설정 */
  height: auto; /* 이미지 높이는 자동으로 조절 (비율 유지) */
  margin-left: 30;
  background-color: transparent; /* 배경을 투명하게 설정 */
  display: block; /* 인라인 요소가 아닌 블록 요소로 설정하여 크기 조절 가능하게 함 */
}
.navbar-menu {
  display: flex;
  list-style: none;
  padding-left: 0;
}
.navbar-menu li {
  padding: 10px 50px;
  transition: border-bottom-width 0.1s;
}
.navbar-menu li:hover {
  font-weight: bold;
  height: 45px; /* 호버 시 높이 조절 */
  padding-bottom: 10px; /* 호버 시 아래 여백 조절 */
  border-bottom: 4px solid #004fff; /* 테두리 설정 */
}
</style>
