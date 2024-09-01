import { useRouter } from "next/router";

export default function Page() {
  // 함수 이름을 'Page'로 수정
  const router = useRouter();
  const { id } = router.query;

  return <h1>Book Catch-All Routes {id}</h1>;
}
