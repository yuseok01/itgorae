import { useRouter } from "next/router";

export default function SearchPage() {
  // 함수 이름을 'SearchPage'로 변경
  const router = useRouter();
  const { q } = router.query;

  return <h1>Search {q}</h1>;
}
