export default async function fetchRandomBooks()  : Promise<BookData[]>{
    const url = "http://localhost:12345/books/random";

    try{
        const response =await fetch(url);
        if(!response.ok){
            throw new Error();
        }
        return await response.json();

    }catch(err) {
        console.error(err);
        return []; //빈배열이라도 반환
    }
}