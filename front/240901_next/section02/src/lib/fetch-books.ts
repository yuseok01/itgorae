

export default async function fetchBooks(q? :string): Promise<BookData[]> {
    let url = `http://localhost:12345/book`;

    if(q){
        url += `/search?q=${q}`;
    }

    try {
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error(`Failed to fetch books: ${response.statusText}`);
        }
        return await response.json();
    } catch (err) {
        console.error('Error fetching books:', err);
        return [];
    }
}
