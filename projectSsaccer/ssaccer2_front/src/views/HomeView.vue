<template>
	<div class="text-wrap">
		<h2>
			프로처럼 <br />아마추어의 <br />
			최강자를 가려보자
		</h2>
		<h3>누구나 참여 할 수 있는 리그</h3>
		<P
			>감독이되어 팀을 구성하고 승점을 흭득해보세요<br />
			전국 최고의 팀은 바로 당신입니다.</P
		>
		<div class="btn-wrap container row">
			<RouterLink
				class="btn col-6 col-sm-4 mx-1"
				active-class="active"
				to="/posts"
			>
				팀 가입하기
			</RouterLink>
			<RouterLink
				class="btn col-6 col-sm-4 mx-1"
				active-class="active"
				to="/about"
			>
				리그 참가하기
			</RouterLink>
		</div>
	</div>
</template>

<script setup></script>

<style scoped>
.btn {
	color: #fff;
	font-weight: bold;
	padding: 10px 6px;
	border-radius: 24px;
	border: 1px solid #004fff;
}
.btn:hover {
	background-color: #004fff;
	border: 1px solid #004fff;
}
.text-wrap {
	width: 520px;
	height: 100vh;
	padding: 240px 60px;
	position: absolute;
	right: 0;
	top: 0;
	background-color: rgba(0, 0, 0, 0.8);
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
}
</style>
