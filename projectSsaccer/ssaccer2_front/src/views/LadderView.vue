<template>
    <div class="container py-4">
        <div class="background">
            <h1 class="title">클럽 수</h1>
            <div class="total-clubs">
                <span class="total-number">{{ filteredList.length }}</span>
            </div>
            <div class="search-location">
                <button
                    v-for="(active, region) in regionFilters"
                    :key="region"
                    @click="toggleRegionFilter(region)"
                    :class="{ active: active }"
                >
                    {{ region }}
                </button>
            </div>
            <table class="club-table">
                <thead>
                    <tr>
                        <th>팀로고</th>
                        <th>팀이름</th>
                        <th>승</th>
                        <th>무</th>
                        <th>패</th>
                        <th>경기수</th>
                        <th>승점</th>
                        <th>득점</th>
                        <th>도움</th>
                        <th>실점</th>
                        <th>지역</th>
                        <th>홈구장</th>
                        <th v-if="user.userRank <= 2">경기 신청</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="team in paginatedList" :key="team.id">
                        <td><img :src="team.teamImg" alt="Team Logo" /></td>
                        <td>{{ team.teamName }}</td>
                        <td>{{ team.won }}</td>
                        <td>{{ team.drawn }}</td>
                        <td>{{ team.lost }}</td>
                        <td>{{ team.played }}</td>
                        <td>{{ team.points }}</td>
                        <td>{{ team.goals }}</td>
                        <td>{{ team.assists }}</td>
                        <td>{{ team.conceded }}</td>
                        <td>{{ team.region }}</td>
                        <td>{{ team.homeStadium }}</td>
                        <td v-if="user.userRank <= 2">
                            <button
                                @click="toggleClick(team.id)"
                                :class="{
                                    clicked: team.clicked,
                                    'not-clicked': !team.clicked,
                                }"
                            >
                                {{ team.clicked ? '신청 완료' : '대전 신청' }}
                            </button>
                        </td>
                    </tr>
                </tbody>
            </table>
            <AppPagination :current-page="params._page" :page-count="pageCount" @page="handlePageChange" />
        </div>
    </div>
</template>

<script setup>
import { ref, watch, computed } from 'vue';
import { useLadderStore } from '@/stores/ladder'; // Pinia 스토어 가져오기
import { useMatchRequestStore } from '@/stores/matchRequest';
import { useUserStore } from '@/stores/user';

const ladderStore = useLadderStore(); // Pinia 스토어 사용
const matchRequestStore = useMatchRequestStore();
const userStore = useUserStore();

const jsonString = sessionStorage.getItem('user');
const user = JSON.parse(jsonString);

// 로그인 user 정보
const userTeamId = ref(1);
userTeamId.value = userStore.teamId;

// console.log(userTeamId.value + ' -----------------');

const list = ref([]); // 팀 목록 저장
const regionFilters = ref({
    전체: true,
    서울: false,
    경기: false,
    대전: false,
    대구: false,
    부산: false,
    울산: false,
    광주: false,
});

const params = ref({ _page: 1 });
const pageSize = 10; // 한 페이지에 보여줄 아이템 수

const paginatedList = computed(() => {
    const start = (params.value._page - 1) * pageSize;
    const end = start + pageSize;
    return filteredList.value.slice(start, end);
});

const pageCount = computed(() => {
    return Math.ceil(filteredList.value.length / pageSize);
});
const filteredList = ref([]);

const getList = async () => {
    await ladderStore.getTeamList(); // Pinia 스토어에서 팀 목록 가져오기
    list.value = ladderStore.list; // 로컬 상태에 저장
    updateFilteredList();
};
getList();

const toggleClick = (teamId) => {
    const team = list.value.find((team) => team.id === teamId);
    if (team) {
        team.clicked = !team.clicked;
    }
    if (team.clicked) {
        if (user.teamId == teamId) {
            team.clicked = !team.clicked;
            alert('같은 팀에는 신청 불가합니다.');
            return;
        }
        matchRequestStore.request(user.teamId, teamId);
    } else {
        // 검색 + 삭제
        matchRequestStore.search(user.teamId, teamId);
    }
};

const toggleRegionFilter = (region) => {
    // 선택한 지역의 값을 토글
    regionFilters.value[region] = !regionFilters.value[region];
    if (region !== '전체') {
        regionFilters.value['전체'] = false; // '전체'를 선택해제
    }
    if (region === '전체' && regionFilters.value['전체']) {
        for (const key in regionFilters.value) {
            if (key !== '전체') {
                regionFilters.value[key] = false; // 다른 모든 지역 선택해제
            }
        }
    }
    updateFilteredList();
};

const updateFilteredList = () => {
    const activeRegions = Object.keys(regionFilters.value).filter((region) => regionFilters.value[region]);
    if (activeRegions.length === 0 || activeRegions.includes('전체')) {
        filteredList.value = list.value;
    } else {
        filteredList.value = list.value.filter((team) => activeRegions.includes(team.region));
    }
};
const handlePageChange = (page) => {
    params.value._page = page;
};

// 데이터 변경 사항 감지 및 업데이트
watch(list, updateFilteredList, { deep: true });
watch(regionFilters, updateFilteredList, { deep: true });
watch(params, updateFilteredList, { deep: true });
</script>

<style scoped>
.container {
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: rgba(255, 255, 255, 0.5); /* 흰색 배경과 투명도 0.5 설정 */
    height: auto;
    width: auto;
}
body {
    font-family: 'Arial', sans-serif;
    background-color: #2c3e50;
    color: #ecf0f1;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    height: auto;
    width: auto;
}

.background {
    width: 80%;
    max-width: 1200px;
    background-color: #34495e;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
    height: auto;
    width: auto;
}

.title {
    text-align: center;
    font-size: 2.5rem;
    margin-bottom: 20px;
}

.total-clubs {
    text-align: center;
    margin-bottom: 20px;
}

.total-number {
    font-size: 3rem;
    font-weight: bold;
}

.search-button,
.my-club-button {
    padding: 10px 20px;
    font-size: 1rem;
    border: none;
    border-radius: 5px;
    background-color: #e67e22;
    color: #fff;
    cursor: pointer;
}

.search-button:hover,
.my-club-button:hover {
    background-color: #d35400;
}

.club-table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
    table-layout: auto;
}

.club-table th,
.club-table td {
    padding: 10px;
    text-align: center;
    border: 1px solid #7f8c8d;
    white-space: nowrap;
}

.club-table th {
    background-color: #004fff;
}

.club-table tbody tr:nth-child(even) {
    background-color: #3b5998;
}

.club-table tbody tr:nth-child(odd) {
    background-color: #34495e;
}

.club-table img {
    width: 30px;
    height: 30px;
}
button {
    border-radius: 12px; /* 둥근 모서리 */
    padding: 5px 10px;
    border: none;
    cursor: pointer;
}

.clicked {
    background-color: white;
    color: black;
}

.not-clicked {
    background-color: #e67e22;
    color: white;
}

.search-location {
    display: flex;
    justify-content: center; /* 중앙 정렬 */
    flex-wrap: wrap; /* 버튼이 여러 줄로 배치될 수 있도록 설정 */
    gap: 10px; /* 버튼 간의 간격 설정 */
    margin-bottom: 20px;
}

.search-location button {
    border-radius: 12px; /* 둥근 모서리 */
    padding: 5px 10px;
    border: none;
    border-radius: 5px;
    background-color: #fff;
    color: #000;
    cursor: pointer;
    margin: 5px;
}

.search-location button:hover,
.search-location button.active {
    background-color: #004fff;
}
</style>
