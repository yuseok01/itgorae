<template>
  <div class="container py-4">
    <h2 class="text-center">게시글 목록</h2>
    <hr class="my-4" />

    <AppLoading v-if="loading" />

    <AppError v-else-if="error" :message="error.message" />

    <template v-else-if="!isExist">
      <p class="text-center py-4 text-muted">No Results</p>
    </template>

    <template v-else>
      <AppGrid :items="paginatedList">
        <template v-slot="{ item }">
          <PostItem
            :title="item.title"
            :content="item.content"
            :created-at="item.createdAt"
            @click="goPage(item.id)"
            @modal="openModal(item)"
            @preview="selectPreview(item.id)"
          ></PostItem>
        </template>
      </AppGrid>

      <AppPagination
        :current-page="params._page"
        :page-count="pageCount"
        @page="handlePageChange"
      />
    </template>
    <Teleport to="#modal">
      <PostModal
        v-model="show"
        :title="modalTitle"
        :content="modalContent"
        :created-at="modalCreatedAt"
      />
    </Teleport>

    <template v-if="previewId">
      <hr class="my-5" />
      <AppCard>
        <PostDetailView :id="previewId"></PostDetailView>
      </AppCard>
    </template>
  </div>
</template>

<script setup>
import PostItem from "@/components/posts/PostItem.vue";
import PostDetailView from "@/views/posts/PostDetailView.vue";
import PostFilter from "@/components/posts/PostFilter.vue";
import PostModal from "@/components/posts/PostModal.vue";
import { ref, computed } from "vue";
import { useRouter } from "vue-router";
import { useAxios } from "@/hooks/useAxios";

const router = useRouter();

const previewId = ref(null);
const selectPreview = (id) => (previewId.value = id);

const params = ref({
  _sort: "createdAt",
  _order: "desc",
  _page: 1,
  _limit: 6,
  title_like: "",
});
const pageSize = 6;

// 주석: posts를 기반으로 paginatedList를 계산합니다.
const paginatedList = computed(() => {
  if (!posts.value) return [];
  const start = (params.value._page - 1) * pageSize;
  const end = start + pageSize;
  return posts.value.slice(start, end); // 잘못된 참조 수정
});
const pageCount = computed(() =>
  Math.ceil(totalCount.value / params.value._limit)
);

const {
  response,
  data: posts,
  error,
  loading,
  length,
} = useAxios("/posts", { params });

const isExist = computed(() => posts.value && posts.value.length > 0);

// 주석: 전체 게시물 수를 계산합니다.
const totalCount = computed(() => length.value);

// 페이지 이동 함수
const goPage = (id) => {
  router.push({
    name: "PostDetail",
    params: {
      id,
    },
  });
};

// 모달 열기 함수
const show = ref(false);
const modalTitle = ref("");
const modalContent = ref("");
const modalCreatedAt = ref("");
const openModal = ({ title, content, createdAt }) => {
  show.value = true;
  modalTitle.value = title;
  modalContent.value = content;
  modalCreatedAt.value = createdAt;
};

// 페이지 변경 핸들러
const handlePageChange = (page) => {
  params.value._page = page;
};
</script>
<style scoped>
.container {
  background-color: rgba(255, 255, 255, 0.5); /* 흰색 배경과 투명도 0.5 설정 */
}
</style>
