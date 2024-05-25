<template>
  <div class="container py-4">
    <div class="background">
      <h1 class="d-flex justify-content-center align-items-center" >팀 관리</h1>
      <h2 class="d-flex justify-content-center align-items-center">- {{ user.teamName }} -</h2>
      <hr />
      <h2 class="d-flex justify-content-center align-items-center">가입신청목록</h2>

      <div class="accordion accordion-flush" id="applicationAccordion">
        <div
          class="accordion-item"
          v-for="(application, index) in applicationStore.list"
          :key="index"
        >
          <div v-if="application.applicationStatus == `pending`">
            <h2 class="accordion-header">
              <button
                class="accordion-button collapsed"
                type="button"
                :data-bs-toggle="'collapse'"
                :data-bs-target="'#flush-collapse-application-' + index"
                aria-expanded="false"
                :aria-controls="'flush-collapse-application-' + index"
              >
                제목: {{ application.title }} / 이름: {{ application.userName }}
              </button>
            </h2>
            <div
              :id="'flush-collapse-application-' + index"
              class="accordion-collapse collapse"
              data-bs-parent="#applicationAccordion"
            >
              <div class="accordion-body">
                소속팀 : {{ application.userTeamName }} <br />
                닉네임 : {{ application.nickName }} <br />
                포지션 : {{ application.position }} <br />
                내용 : {{ application.content }} <br />
                신청일 : {{ application.applicationDate }} <br />
                <div class="text-end">
                  <button
                    v-if="user.userRank <= 2"
                    type="button"
                    class="btn btn-primary me-2"
                    @click="acceptApplication(application)"
                  >
                    수락
                  </button>
                  <button
                    v-if="user.userRank <= 2"
                    type="button"
                    class="btn btn-danger"
                    @click="rejectApplication(application)"
                  >
                    거절
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <hr />
      <h1 class="d-flex justify-content-center align-items-center">매치신청</h1>


      <div class="accordion accordion-flush" id="matchRequestAccordion">
        <div
          class="accordion-item"
          v-for="(matchRequest, idx) in matchRequestStore.resList"
          :key="idx"
        >
          <h2 class="accordion-header">
            <button
              class="accordion-button collapsed"
              type="button"
              :data-bs-toggle="'collapse'"
              :data-bs-target="'#flush-collapse-match-' + idx"
              aria-expanded="false"
              :aria-controls="'flush-collapse-match-' + idx"
            >
              {{ matchRequest.teamNameFrom }} 팀의 매치 신청
            </button>
          </h2>
          <div
            :id="'flush-collapse-match-' + idx"
            class="accordion-collapse collapse"
            data-bs-parent="#matchRequestAccordion"
          >
            <div class="accordion-body">
              경기 시간  : {{ matchRequest.matchTime }} <br />
              경기 장소  : {{ matchRequest.homeStadium }} <br />
              승점       : {{matchRequest.points}}<br />
              총 전적    : {{ matchRequest.played }}<br />
              승        : {{matchRequest.won}}<br />
              무        : {{matchRequest.drawn}}<br />
              패        : {{matchRequest.lost}}<br />

              <div class="text-end">
                <button
                  v-if="user.userRank <= 2"
                  type="button"
                  class="btn btn-primary me-2"
                  @click="acceptMatch(matchRequest)"
                >
                  수락
                </button>
                <button
                  v-if="user.userRank <= 2"
                  type="button"
                  class="btn btn-danger"
                  @click="rejectMatch(matchRequest)"
                >
                  거절
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, computed } from "vue";
import { useApplicationStore } from "@/stores/application";
import { useMatchRequestStore } from "@/stores/matchRequest";
import { useMatchBoardStore } from "@/stores/matchBoard";

const applicationStore = useApplicationStore();
const matchRequestStore = useMatchRequestStore();
const matchBoardStore = useMatchBoardStore();

const jsonString = sessionStorage.getItem("user");
const user = JSON.parse(jsonString);

const getApplicationList = async () => {
  await applicationStore.getApplicationList(user.teamId);
};
const getMatchRequestList = async () => {
  await matchRequestStore.setResList(user.teamId);
};

onMounted(() => {
  getApplicationList();
  getMatchRequestList();
});

const acceptApplication = (application) => {
  // console.log(application);
  // console.log(application.id);
  // applicationStore에서 수락요청
  applicationStore.acceptApplication(application.id);
  window.location.href = "/myTeam";
};
const rejectApplication = (application) => {
  // console.log(userId);
  // applicationStore에서 거절요청
  applicationStore.rejectApplication(application.id);
  window.location.href = "/myTeam";
};

const acceptMatch = (matchRequest) => {
  console.log(matchRequest);
  // match내역 삭제
  matchRequestStore.search(matchRequest.teamIdFrom, matchRequest.teamIdTo);
  // teamBoard 추가
  // 내 팀: teamIdTo, 상대 팀: teamIdFrom
  matchBoardStore.create(matchRequest.teamIdTo, matchRequest.teamIdFrom);
  // 새로고침
  window.location.href = "/myTeam";
};

const rejectMatch = (matchRequest) => {
  console.log(matchRequest);
  // match내역 삭제
  matchRequestStore.search(matchRequest.teamIdFrom, matchRequest.teamIdTo);
  // 새로고침
  window.location.href = "/myTeam";
};
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: rgba(255, 255, 255, 0.5);
  height: auto;
  width: 100%;
}

.background {
  width: 80%;
  max-width: 1200px;
  padding: 20px;
  border-radius: 10px;
  background-color: white;
}

h1,
h2 {
  color: #007bff; /* 제목을 파란색으로 변경 */
  text-align: center;
}

hr {
  border-top: 2px solid #007bff; /* 구분선을 파란색으로 변경 */
}

.accordion-item {
  background-color: #ffffff; /* 배경색 흰색으로 변경 */
  color: #343a40; /* 텍스트 색상 어두운 회색으로 변경 */
  border: 1px solid #ddd; /* 경계선 추가 */
}

.accordion-button {
  background-color: #ffffff; /* 버튼 배경색 흰색으로 변경 */
  color: #343a40; /* 버튼 텍스트 색상 어두운 회색으로 변경 */
  border-bottom: 1px solid #ddd; /* 버튼 경계선 추가 */
}

.accordion-button:not(.collapsed) {
  color: #007bff; /* 확장된 버튼 텍스트 색상 파란색으로 변경 */
  background-color: #e9ecef; /* 확장된 버튼 배경색 밝은 회색으로 변경 */
}

.accordion-body {
  background-color: #ffffff; /* 본문 배경색 흰색으로 변경 */
  color: #343a40; /* 본문 텍스트 색상 어두운 회색으로 변경 */
  padding: 15px;
  line-height: 1.6; /* 줄 간격 조정으로 가독성 향상 */
}

.text-end .btn-primary {
  background-color: #007bff; /* 수락 버튼 파란색으로 변경 */
  border-color: #007bff;
}

.text-end .btn-danger {
  background-color: #dc3545; /* 거절 버튼 빨간색으로 변경 */
  border-color: #dc3545;
}

.text-end .btn-primary:hover,
.text-end .btn-primary:focus {
  background-color: #0056b3; /* 수락 버튼 호버 및 포커스 시 어두운 파란색으로 변경 */
  border-color: #004085;
}

.text-end .btn-danger:hover,
.text-end .btn-danger:focus {
  background-color: #c82333; /* 거절 버튼 호버 및 포커스 시 어두운 빨간색으로 변경 */
  border-color: #bd2130;
}

</style>
