<template>
  <div>
    <h2>home view</h2>
    <hr class="my-4" />
    <button class="btn btn-primary" @click="goAboutPage">About으로 이동</button>
    <hr class="my-4" />
    <div class="row g-3">
      <AppGrid :items="items" v-slot="{ item }">
        <AppCard>{{ item }}</AppCard>
      </AppGrid>
      </div>
    </div>
  </div>
</template>


<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';


const router = useRouter();
const goAboutPage = () => {
  router.push('/about');
};

const items = ref(['사과', '딸기', '포도', '바나나']);
</script>

<style lang="scss" scoped></style>
