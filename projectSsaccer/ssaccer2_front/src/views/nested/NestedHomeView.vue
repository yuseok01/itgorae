<template>
  <body>
    <div class="container">
      <header>
        <h1>SEASON DDAY</h1>
        <div class="countdown-timer">
          <div class="timer">
            <div>
              <div>{{ days }}</div>
              <div class="label">DAYS</div>
            </div>
            <div>
              <div>{{ hours }}</div>
              <div class="label">HOURS</div>
            </div>
            <div>
              <div>{{ minutes }}</div>
              <div class="label">MINS</div>
            </div>
            <div>
              <div>{{ seconds }}</div>
              <div class="label">SECS</div>
            </div>
          </div>
        </div>
      </header>
      <hr class="hr" />
      <h1 class="row justify-content-md-center">
        24 SPRING SEASON 리그전에 참가하세요
      </h1>
    </div>
  </body>
</template>

<script setup>
import { ref, onMounted, onBeforeUnmount } from "vue";
import { useLadderStore } from "@/stores/ladder";

const ladderStore = useLadderStore();
const loading = ref(true);

const loadRankAll = async () => {
  await ladderStore.setRankAll();
  loading.value = false;
};

onMounted(() => {
  loadRankAll();
});

const endTime = new Date("2024-05-31T00:00:00").getTime();
const days = ref("00");
const hours = ref("00");
const minutes = ref("00");
const seconds = ref("00");
let timer = null;

const updateTimer = () => {
  const now = new Date().getTime();
  const distance = endTime - now;

  if (distance < 0) {
    clearInterval(timer);
    return;
  }

  days.value = Math.floor(distance / (1000 * 60 * 60 * 24));
  hours.value = Math.floor(
    (distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)
  );
  minutes.value = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
  seconds.value = Math.floor((distance % (1000 * 60)) / 1000);
};

onMounted(() => {
  updateTimer();
  timer = setInterval(updateTimer, 1000);
});

onBeforeUnmount(() => {
  clearInterval(timer);
});
</script>

<style scoped>
body {
  font-family: "Arial", sans-serif;
  margin: 0;
  padding: 0;
  background-color: #f0f0f0;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}

header {
  text-align: center;
  margin-bottom: 50px;
}

header h1 {
  font-size: 2.5em;
  color: #333;
}
.hr {
  border: 0;
  height: 5px; /* 굵기를 5px로 설정 */
  background-color: black; /* 색상을 블랙으로 설정 */
  margin: 20px 0; /* 위아래 여백 설정 */
}

header p {
  font-size: 1.2em;
  color: #666;
}

.content {
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
}

.item {
  background: #fff;
  border-radius: 10px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  margin: 20px;
  padding: 20px;
  text-align: center;
  width: 22%;
}

.item img {
  max-width: 50px;
  margin-bottom: 20px;
}

.item h2 {
  font-size: 1.5em;
  color: #333;
  margin-bottom: 10px;
}

.item p {
  font-size: 1em;
  color: #666;
}
table {
  width: 100%;
  border-collapse: collapse;
  margin: 0 auto;
}
th,
td {
  padding: 5px;
}
td {
  border: none;
}
td:not(:last-child) {
  border-right: 1px solid gray;
}
header h1 {
  font-size: 2em;
  color: #333;
}

.rank-table {
  width: 100%;
  border-collapse: collapse;
  margin: 0 auto;
}

.rank-table th,
.rank-table td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: center;
}

.rank-table th {
  background-color: #004fff;
  color: black;
}

.rank-table tr:nth-child {
  background-color: #f9f9f9;
}

.rank-table tr:hover {
  background-color: #ddd;
}
.countdown-timer {
  text-align: center;
}

.timer {
  display: flex;
  justify-content: center;
  gap: 10px; /* 타이머 숫자 사이 간격 */
  font-size: 2em; /* 타이머 숫자 크기 줄이기 */
  font-family: "Digital-7 Mono", sans-serif; /* 디지털 스타일 폰트 */
}

.timer div {
  text-align: center;
  background-color: #fff; /* 배경색을 검정으로 설정 */
  border: 3px solid #000; /* 테두리를 흰색으로 설정 */
  padding: 10px 20px; /* 패딩 설정 */
  border-radius: 5px; /* 모서리를 둥글게 설정 */
}

.label {
  font-size: 0.5em;
  color: #000; /* 레이블 글자 색을 흰색으로 설정 */
  margin-top: 10px;
}
</style>
