<script setup>
import TheHeader from '@/layouts/TheHeader.vue';
import TheView from '@/layouts/TheView.vue';
import video from '@/assets/video.mp4';
import audio from '@/assets/mp3.mp3';
</script>

<template id="app">
	<div class="background">
		<div class="video-wrap">
			<video :src="video" muted autoplay loop :poster="sample"></video>
		</div>
		<div class="overlay">
			<TheHeader />
			<div class="content">
				<TheView />
				<AppAlert />
			</div>
		</div>
	</div>
	<audio controls volume="0.2" autoplay class="audio-player">
		<source :src="audio" type="audio/mp3" />
		your browser does not support the audio tag
	</audio>
</template>

<style scoped>
.background {
	position: relative;
	width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
}

.video-wrap {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: -1;
	overflow: hidden;
}

.video-wrap video {
	width: 100%;
	height: 100%;
	object-fit: cover;
}

.container {
	max-width: 940px;
}
.audio-player {
	position: fixed;
	bottom: 0;
	left: 50%;
	transform: translateX(-50%);
	width: 10%;
	background: rgba(0, 0, 0, 0.2);
	padding: 10px;
	box-sizing: border-box;
	transition: background 0.3s ease;
}
.audio-player {
	opacity: 0.7;
	transition: opacity 0.3s ease;
}
.audio-container:hover .audio-player {
	opacity: 1;
}
</style>
