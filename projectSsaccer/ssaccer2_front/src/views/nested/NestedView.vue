<template>
  <div class="container py-4 text-center">
    <ul class="nav nav-pills text-center">
      <li class="nav-item">
        <RouterLink
          class="nav-link"
          active-class="active mx-2"
          :to="{ name: 'NestedOne', replace: true }"
        >
          전체
        </RouterLink>
      </li>
      <li class="nav-item mx-2">
        <RouterLink
          class="nav-link"
          active-class="active"
          :to="{ name: 'NestedTwo', replace: true }"
        >
          서울
        </RouterLink>
      </li>
      <li class="nav-item mx-2">
        <RouterLink
          class="nav-link"
          active-class="active"
          :to="{ name: 'NestedThree', replace: true }"
        >
          경기
        </RouterLink>
      </li>
      <li class="nav-item mx-2">
        <RouterLink
          class="nav-link"
          active-class="active"
          :to="{ name: 'NestedFour', replace: true }"
        >
          대전
        </RouterLink>
      </li>
      <li class="nav-item mx-2">
        <RouterLink
          class="nav-link"
          active-class="active"
          :to="{ name: 'NestedFive', replace: true }"
        >
          대구
        </RouterLink>
      </li>
      <li class="nav-item mx-2">
        <RouterLink
          class="nav-link"
          active-class="active"
          :to="{ name: 'NestedSix', replace: true }"
        >
          광주
        </RouterLink>
      </li>
      <li class="nav-item mx-2">
        <RouterLink
          class="nav-link"
          active-class="active"
          :to="{ name: 'NestedSeven', replace: true }"
        >
          부산
        </RouterLink>
      </li>
      <li class="nav-item mx-2">
        <RouterLink
          class="nav-link"
          active-class="active"
          :to="{ name: 'NestedEight', replace: true }"
        >
          울산
        </RouterLink>
      </li>
    </ul>
    <hr class="my-4" />
    <RouterView></RouterView>
  </div>
</template>

<script setup></script>

<style scoped>
.container {
  background-color: rgba(255, 255, 255, 0.5); /* 흰색 배경과 투명도 0.5 설정 */
}
</style>
