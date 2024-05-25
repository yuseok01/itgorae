<template>
    <div class="container py-4">
        <h2 class="text-center">게시글 목록</h2>
        <hr class="my-4" />

        <div v-if="loading" class="text-center py-4">
            <p>Loading...</p>
        </div>

        <div v-else-if="error" class="text-center py-4 text-danger">
            <p>{{ error.message }}</p>
        </div>

        <template v-else-if="!isExist">
            <p class="text-center py-4 text-muted">No Results</p>
        </template>

        <template v-else>
            <div class="background">
                <div class="card-row" v-for="(chunk, index) in chunkedMatches" :key="index">
                    <div class="card" v-for="match in chunk" :key="match.id" @click="goPage(match.id)">
                        <div class="card-header-box">
                            <div class="card-header">
                                {{ match.myTeamName }} vs {{ match.opposingTeamName }}
                            </div>
                        </div>
                        <div class="card-body">
                            <p>{{ match.myTeamName }}: {{ match.goals }}</p>
                            <p>{{ match.opposingTeamName }}: {{ match.conceded }}</p>
                        </div>
                        <div class="card-footer" :class="resultClass(match)">
                            <p v-if="match.goals > match.conceded">WIN</p>
                            <p v-else-if="match.goals === match.conceded">DRAW</p>
                            <p v-else>LOSE</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="pagination">
                <button
                    v-for="page in pageCount"
                    :key="page"
                    @click="handlePageChange(page)"
                    :class="{ active: params._page === page }"
                >
                    {{ page }}
                </button>
            </div>
        </template>
    </div>
</template>

<script setup>
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';
import { useMatchBoardStore } from '@/stores/matchBoard';

const router = useRouter();
const matchBoardStore = useMatchBoardStore();

const jsonString = sessionStorage.getItem('user');
const user = JSON.parse(jsonString);

const loading = ref(true);
const error = ref(null);
const params = ref({
    _page: 1,
    _limit: 6
});
const pageSize = 6;

const fetchMatches = async () => {
    loading.value = true;
    error.value = null;
    try {
        await matchBoardStore.getLatest(user.teamId);
    } catch (err) {
        error.value = err;
    } finally {
        loading.value = false;
    }
};

const chunkArray = (array, chunkSize) => {
    const results = [];
    for (let i = 0; i < array.length; i += chunkSize) {
        results.push(array.slice(i, i + chunkSize));
    }
    return results;
};

const chunkedMatches = computed(() => chunkArray(matchBoardStore.latestMatch, 3));

const goPage = (id) => {
    router.push({
        name: 'PostLockerDetailView',
        params: {
            id,
        },
    });
};

const resultClass = (match) => {
    if (match.goals > match.conceded) {
        return 'win';
    } else if (match.goals === match.conceded) {
        return 'draw';
    } else {
        return 'loss';
    }
};

const isExist = computed(() => matchBoardStore.latestMatch.length > 0);

const pageCount = computed(() =>
    Math.ceil(matchBoardStore.latestMatch.length / params.value._limit)
);

const handlePageChange = (page) => {
    params.value._page = page;
    fetchMatches();
};

if (user && user.teamId) {
    fetchMatches();
}
</script>

<style scoped>
.container {
    background-color: rgba(255, 255, 255, 0.5);
    height: auto;
    width: auto;
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
}
.card-row {
    display: flex;
    justify-content: space-between;
    margin-bottom: 20px;
}
.card {
    flex: 1;
    margin: 0 10px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 10px;
    background-color: white;
    cursor: pointer; /* 카드에 커서 포인터 추가 */
}
.card:hover {
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 호버 효과 추가 */
}
.card-header-box {
    border: 1px solid #ccc;
    border-radius: 10px;
    margin-bottom: 10px;
    background-color: #f9f9f9;
}
.card-header, .card-body, .card-footer {
    margin-bottom: 10px;
    text-align: center; /* 가운데 정렬 */
}
.card-footer p {
    font-size: 24px; /* 글자 크기 키우기 */
    margin: 0;
}
.card-footer.win {
    background-color: blue;
    color: white;
    border-radius: 10px; /* 둥글게 만들기 */
    padding: 10px;
}
.card-footer.draw {
    background-color: gray;
    color: white;
    border-radius: 10px; /* 둥글게 만들기 */
    padding: 10px;
}
.card-footer.loss {
    background-color: red;
    color: white;
    border-radius: 10px; /* 둥글게 만들기 */
    padding: 10px;
}
button {
    padding: 5px 10px;
    font-size: 16px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}
.pagination {
    display: flex;
    justify-content: center;
    margin-top: 20px;
}
.pagination button {
    padding: 5px 10px;
    margin: 0 5px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}
.pagination button.active {
    background-color: #007bff;
    color: white;
}
</style>
