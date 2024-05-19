<template>
	<header>
		<nav class="navbar navbar-expand-sm navbar-dark custom">
			<div class="container-fluid navbar-logo">
				<RouterLink class="navbar-brand" :src="logo" to="/">SSACCER</RouterLink>
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
				<div
					class="collapse navbar-collapse navbar-menu"
					id="navbarSupportedContent"
				>
					<ul class="navbar-nav me-auto">
						<li class="nav-item">
							<RouterLink class="nav-link fs-5" active-class="active" to="/">
								Home
							</RouterLink>
						</li>
						<li class="nav-item">
							<RouterLink
								class="nav-link fs-5"
								active-class="active"
								to="/about"
							>
								순위전
							</RouterLink>
						</li>
						<li class="nav-item">
							<RouterLink
								class="nav-link fs-5"
								active-class="active"
								to="/posts"
							>
								이적 시장
							</RouterLink>
						</li>
						<li class="nav-item">
							<RouterLink
								class="nav-link fs-5"
								active-class="active"
								to="/nested"
							>
								랭 킹
							</RouterLink>
						</li>
						<li class="nav-item">
							<RouterLink class="nav-link fs-5" active-class="active" to="/my">
								로그인
							</RouterLink>
						</li>
					</ul>
					<div class="d-flex">
						<button
							class="btn btn-outline-light fs-4"
							type="button"
							@click="goPage"
						>
							글쓰기
						</button>
					</div>
				</div>
			</div>
		</nav>
	</header>
</template>

<script setup>
import logo from '@/layouts/assets/logo.png';
import { useRouter } from 'vue-router';

const router = useRouter();
const goPage = () => {
	router.push({
		name: 'PostCreate',
	});
};
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
</style>
