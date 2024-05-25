<template>
  <div class="row g-3">
    <div
      v-for="(item, index) in items"
      :key="index"
      class="col-12 col-md-6 col-lg-4"
    >
      <slot :item="item" :index="index"></slot>
    </div>
  </div>
</template>

<script setup>
defineProps({
  items: Array,
});
</script>
