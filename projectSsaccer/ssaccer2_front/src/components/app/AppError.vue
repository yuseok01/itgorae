<template>
	<div class="text-center text-danger py-4">
		{{ message }}
	</div>
</template>
<!-- 에러메세지 -->
<script setup>
defineProps({
	message: String,
});
</script>
