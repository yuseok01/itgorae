<template>
  <div>

  </div>
</template>

<script>
export default {
  setup () {
    const original = reactive({
      count : 0,
    });
    original.count++;
    console.log(original.count);
  
    return {}
  }
}
</script>

<style lang="scss" scoped>

</style>