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
      <div class="content">
        <div class="item" v-if="ladderStore.rankDaegu.length > 0">
          <img src="@/assets/Rank/rank1.png" alt="1등" />
          <h2>{{ ladderStore.rankDaegu[0].teamName }}</h2>
          <table>
            <tr>
              <td>경기수</td>
              <td>{{ ladderStore.rankDaegu[0].played }}</td>
            </tr>
            <tr>
              <td>승점</td>
              <td>{{ ladderStore.rankDaegu[0].points }}</td>
            </tr>
            <tr>
              <td>승</td>
              <td>{{ ladderStore.rankDaegu[0].won }}</td>
            </tr>
            <tr>
              <td>무</td>
              <td>{{ ladderStore.rankDaegu[0].drawn }}</td>
            </tr>
            <tr>
              <td>패</td>
              <td>{{ ladderStore.rankDaegu[0].lost }}</td>
            </tr>
          </table>
        </div>
        <div class="item" v-if="ladderStore.rankDaegu.length > 1">
          <img src="@/assets/Rank/rank2.png" alt="2등" />
          <h2>{{ ladderStore.rankDaegu[1].teamName }}</h2>
          <table>
            <tr>
              <td>경기수</td>
              <td>{{ ladderStore.rankDaegu[1].played }}</td>
            </tr>
            <tr>
              <td>승점</td>
              <td>{{ ladderStore.rankDaegu[1].points }}</td>
            </tr>
            <tr>
              <td>승</td>
              <td>{{ ladderStore.rankDaegu[1].won }}</td>
            </tr>
            <tr>
              <td>무</td>
              <td>{{ ladderStore.rankDaegu[1].drawn }}</td>
            </tr>
            <tr>
              <td>패</td>
              <td>{{ ladderStore.rankDaegu[1].lost }}</td>
            </tr>
          </table>
        </div>
        <div class="item" v-if="ladderStore.rankDaegu.length > 2">
          <img src="@/assets/Rank/rank3.png" alt="3등" />
          <h2>{{ ladderStore.rankDaegu[2].teamName }}</h2>
          <table>
            <tr>
              <td>경기수</td>
              <td>{{ ladderStore.rankDaegu[2].played }}</td>
            </tr>
            <tr>
              <td>승점</td>
              <td>{{ ladderStore.rankDaegu[2].points }}</td>
            </tr>
            <tr>
              <td>승</td>
              <td>{{ ladderStore.rankDaegu[2].won }}</td>
            </tr>
            <tr>
              <td>무</td>
              <td>{{ ladderStore.rankDaegu[2].drawn }}</td>
            </tr>
            <tr>
              <td>패</td>
              <td>{{ ladderStore.rankDaegu[2].lost }}</td>
            </tr>
          </table>
        </div>
      </div>
    </div>
  </body>
  <div class="container">
    <header>
      <hr class="hr" />
      <h1>2023/24 SPRING 팀 순위</h1>
    </header>
    <table class="rank-table">
      <thead>
        <tr>
          <th>순위</th>
          <th>팀</th>
          <th>경기수</th>
          <th>승점</th>
          <th>승</th>
          <th>무</th>
          <th>패</th>
          <th>득점</th>
          <th>실점</th>
          <th>득실차</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(team, index) in ladderStore.rankDaegu" :key="team.teamId">
          <td>{{ index + 1 }}</td>
          <td>{{ team.teamName }}</td>
          <td>{{ team.played }}</td>
          <td>{{ team.points }}</td>
          <td>{{ team.won }}</td>
          <td>{{ team.drawn }}</td>
          <td>{{ team.lost }}</td>
          <td>{{ team.goals }}</td>
          <td>{{ team.conceded }}</td>
          <td>{{ team.goals - team.conceded }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { ref, onMounted, onBeforeUnmount } from "vue";
import { useLadderStore } from "@/stores/ladder";

const ladderStore = useLadderStore();
const loading = ref(true);

const loadRankDaegu = async () => {
  await ladderStore.setRankDaegu();
  loading.value = false;
};

onMounted(() => {
  loadRankDaegu();
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
