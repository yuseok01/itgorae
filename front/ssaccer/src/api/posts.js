import { posts } from '.';
// 해당폴더에있는 index 파일 고정 경로가져오기

export function getPosts(params) {
  // console.log('API 호출 URL:', posts.defaults.baseURL); // 기본 URL 확인
  // console.log('API 호출 매개변수:', params); // 매개변수 확인
  return posts.get('/', { params });
}
//게시글 list 조회

export function getPostById(id) {
  return posts.get(`/${id}`);
}
//게시글 id로 조회

export function createPost(data) {
  return posts.post('', data);
}
//게시글 등록
export function updatePost(id, data) {
  return posts.patch(`/${id}`, data);
}

export function deletePost(id) {
  return posts.delete(`/${id}`);
}
