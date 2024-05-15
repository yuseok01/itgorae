<template>
  <div class="container">
    <div class="video-wrap">
      <video :src="video" muted autoplay loop :poster="sample"></video>
    </div>
    <div class="text-wrap">
      <h2>디데이 <br />들어갈자리 <br />디데이</h2>
      <h3>랭크 들어갈자리</h3>
      <p>랭크 1등부터 3등까지<br />지역별로 조회할 수 있는 그런 페이지</p>
      <div class="btn-wrap">
        <a class="btn-wrap">
          <a class="btn" href="#">팀 등록하기</a>
          <a class="btn ghost-btn" href="#"> 가입하기</a>
        </a>
      </div>
    </div>
  </div>
</template>

<script setup>
import video from '@/layouts/assets/video.mp4';
import sample from '@/layouts/assets/sample-poster.jpg';
</script>

<style lang="scss" scoped>
* {
  box-sizing: border-box;
}
a {
  text-decoration: none;
}
.container {
  background-color: #000;
}
.text-wrap {
  width: 520px;
  height: 100vh;
  padding: 240px 60px;
  position: absolute;
  right: 0;
  top: 0;
  background-color: #000;
  z-index: 1;
}
.text-wrap h2 {
  color: #fff;
  font-size: 64px;
  line-height: 80px;
  font-weight: lighter;
  margin-bottom: 40px;
}
.text-wrap h3 {
  color: #fff;
  font-size: 24px;
  line-height: 30px;
  margin-bottom: 20px;
}
.text-wrap p {
  color: #fff;
  font-size: 16px;
  line-height: 1.8;
  margin-bottom: 20px;
}
//반응형 백그라운드 비디오
.video-wrap {
  position: relative;
  width: calc(100% - 520px); //text rap사이즈 랑 비교
}
.video-wrap video {
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  height: 100vh;
}

.btn {
  display: inline-block;
  color: #fff;
  font-weight: bold;
  padding: 12px 20px;
  border-radius: 24px;
}
// 엑티브 설정필요
//버튼이지만 고스트 버튼인 애들
.ghost-btn {
  backgorund-color: transparent;
  border: 1px solid #004fff;
}
</style>
