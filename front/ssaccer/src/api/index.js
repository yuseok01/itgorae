import axios from 'axios';

function create(baseURL, options) {
  const instance = axios.create(Object.assign({ baseURL }, options));
  return instance;
}
//base 경로 설정

export const posts = create(`${import.meta.env.VITE_APP_API_URL}posts/`);
//base url 내보내기
//다른 api 사용할때
