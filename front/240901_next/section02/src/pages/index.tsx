//CSS Moudule
import SearchableLayout from "@/components/searchable-layout";
import style from "./index.module.css";
import { ReactNode, useEffect } from "react";
import books from '@/mock/books.json'
import BookItem from "@/components/book-item";
import { InferGetServerSidePropsType, InferGetStaticPropsType } from "next";
import fetchBooks from "@/lib/fetch-books";
import fetchRandomBooks from "@/lib/fetch-random-books";

//약속된 함수 SSR 설정 HOME을 실행시키기 전에 먼저 실행됨  
export const getStaticProps = async() => {

  //인수로 전달한 모든 비동기함수를 동시에 실행
const [allBooks, recoBooks] = await Promise.all([
  fetchBooks(),
  fetchRandomBooks(), //인수 전달 
]);
return {  
  props: {
    allBooks,
    recoBooks,
  },
 };
};

export default function Home({allBooks,recoBooks} : InferGetStaticPropsType<typeof getStaticProps>) {

  return (
    <div className={style.container}>
    <section>
      <h3>지금 추천하는 도서</h3>
      {recoBooks.map((book)=><BookItem key={book.id}{...book}/>)}
      </section>
    <section>
      <h3>등록된 모든 도서</h3>
      {allBooks.map((book)=><BookItem key={book.id}{...book}/>)}
    </section>
  </div>
  )
}
Home.getLayout = (page:ReactNode) => {
  return <SearchableLayout>{page}</SearchableLayout>
};