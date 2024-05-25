<template>
    <header>
        <nav class="navbar navbar-expand-sm navbar-dark custom">
            <div class="container-fluid navbar-logo">
                <RouterLink class="navbar-brand" :src="logo" to="/">
                    <img :src="logo" alt="SSACCER Logo" />
                </RouterLink>
                <button
                    class="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
                >
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse navbar-menu" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <RouterLink class="nav-link fs-5" active-class="active" to="/"> Home </RouterLink>
                        </li>
                        <li class="nav-item">
                            <RouterLink class="nav-link fs-5" active-class="active" to="/ladder"> 순위전 </RouterLink>
                        </li>
                        <li class="nav-item">
                            <RouterLink class="nav-link fs-5" active-class="active" to="/posts"> 이적 시장 </RouterLink>
                        </li>
                        <li class="nav-item">
                            <RouterLink class="nav-link fs-5" active-class="active" to="/nested"> 랭 킹 </RouterLink>
                        </li>
                        <li class="nav-item">
                            <RouterLink class="nav-link fs-5" active-class="active" to="/lockerRoom">
                                락커룸
                            </RouterLink>
                        </li>
                        <li class="nav-item">
                            <RouterLink class="nav-link fs-5" active-class="active" to="/myTeam"> 팀 관리 </RouterLink>
                        </li>
                    </ul>
                    <!-- @click="goPage" -->
                    <div class="d-flex">
                        <button class="btn" type="button">
                            <!-- 로그인 안됐으면 -->
                            <RouterLink v-if="!Authenticated" class="nav-link fs-5" active-class="active" to="/login">
                                <i class="bi bi-box-arrow-in-right"></i>
                            </RouterLink>
                            <!-- 로그인됐으면 -->
                            <RouterLink v-if="Authenticated" class="nav-link fs-5" active-class="active" to="/myPage">
                                <i class="bi bi-person fs-3"></i>
                            </RouterLink>
                        </button>
                    </div>
                </div>
            </div>
        </nav>
    </header>
</template>

<script setup>
import logo from '@/assets/ssaccerlogo.png';

import { ref, computed } from 'vue';
import { useUserStore } from '@/stores/user';

const userStore = useUserStore();
const Authenticated = computed(() => userStore.Authenticated);

// const router = useRouter();
// console.log(Authenticated.value + '  TheHeader.vue');
// const goPage = () => {
//     router.push({
//         name: 'PostCreate',
//     });
// };
</script>

<style scoped>
.custom {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: rgba(0, 0, 0, 0.5);
    padding: 8px 70px;
}

.navbar-menu {
    display: flex;
    list-style: none;
    padding: 0;
}

.navbar-menu li {
    padding: 10px 50px;
    transition: all 0.3s ease;
    position: relative; /* border-bottom 공간 확보 */
}

.navbar-menu li::after {
    content: '';
    position: absolute;
    left: 50%;
    bottom: 0;
    transform: translateX(-50%);
    width: 0%;
    height: 4px;
    background-color: transparent;
    transition: width 0.3s ease, background-color 0.3s ease;
}

.navbar-menu li:hover::after {
    width: 50%; /* 원하는 길이 설정 */
    background-color: #004fff;
}

.navbar-menu li:hover {
    font-weight: bold;
}
.btn {
    color: #fff;
    font-weight: bold;
    padding: 5px 10px;
    border-radius: 24px;
    border: 1px solid #004fff;
}
.btn:hover {
    background-color: #004fff;
    border: 1px solid #004fff;
}
.navbar-brand img {
    height: 50px; /* 원하는 높이로 조절 */
    width: auto; /* 비율을 유지하면서 너비 자동 조절 */
}
</style>
