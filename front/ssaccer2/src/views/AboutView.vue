<template>
	<div class="container py-4">
		<h2>li 태그로 팀 board 나열 대전 신청</h2>
		<p>{{ $route.path }}</p>
		<button class="btn btn-primary" @click="$router.push('/')">
			Home으로 이동
		</button>
		<h2>Store</h2>
		<p>counter: {{ counter }}</p>
		<p>doubleCount: {{ doubleCount }}</p>
		<p>doubleCountPlusOne: {{ doubleCountPlusOne }}</p>
		<button @click="increment()">Click!!</button>
	</div>
</template>

<script setup>
import { useRoute } from 'vue-router';
import { useCounterStore } from '@/stores/counter';
import { storeToRefs } from 'pinia';

const route = useRoute();
console.log('route.path: ', route.path);

const store = useCounterStore();

const { counter, doubleCount, doubleCountPlusOne } = storeToRefs(store);
const { increment } = store;
counter.value = 100;
// increment();
// increment();
// increment();
</script>

<style scoped>
.container {
	background-color: rgba(255, 255, 255, 0.5); /* 흰색 배경과 투명도 0.5 설정 */
}
</style>
