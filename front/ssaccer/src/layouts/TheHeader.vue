<template>
  <header>
    <h1>
      <a href="#">
        <img class="logo" :src="logo" />
      </a>
    </h1>
    <nav class="main-navigation">
      <a class="active" href="#">이적 시장</a>
      <a href="#">리그</a>
      <a href="#">팀 매뉴</a>
      <a class="btn ghost-btn" href="#">가입하기</a>
    </nav>
  </header>
</template>

<script setup>
import logo from '@/layouts/assets/logo.png';
</script>

<style lang="scss" scoped>
a {
  text-decoration: none;
}
* {
  box-sizing: border-box;
}
.logo {
  width: 150px; /* 이미지 너비 설정 */
  height: auto; /* 이미지 높이는 자동으로 조절 (비율 유지) */
  background-color: transparent; /* 배경을 투명하게 설정 */
  display: block; /* 인라인 요소가 아닌 블록 요소로 설정하여 크기 조절 가능하게 함 */
}
header {
  background-color: rgba(0, 0, 0, 0);
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  padding: 30px;
  z-index: 3;
}
header h1 {
  float: left;
}
.main-navigation {
  float: right;
}
.main-navigation a {
  color: #fff;
  margin-left: 40px;
}
.main-navigation a.active {
  font-weight: bold;
  border-botton: 2px solid #004fff;
} // 엑티브 설정필요
.btn {
  display: inline-block;
  color: #fff;
  font-weight: bold;
  padding: 12px 20px;
  border-radius: 24px;
  background-color: #004fff;
}
// 엑티브 설정필요
//버튼이지만 고스트 버튼인 애들
.ghost-btn {
  backgorund-color: transparent;
  border: 1px solid #004fff;
}
</style>
