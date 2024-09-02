import SearchableLayout from "@/components/searchable-layout";
import { useRouter } from "next/router";
import { ReactNode } from "react";
import books from "@/mock/books.json";
import BookItem from "@/components/book-item";

export default function Page() {
  // 함수 이름을 'SearchPage'로 변경
  return <div>
    {books.map((book)=>(
      <BookItem key={book.id} {...book}/>
    ))}
    </div>
}

Page.getLayout =(page:ReactNode)=>{
  return <SearchableLayout>{page} </SearchableLayout>
}