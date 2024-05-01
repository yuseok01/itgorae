// data/movie.json을 가져와서
// 영화 목록 만들기.

// 페이지가 로드되면 함수 실행.
window.onload = function(){
  const likeListElement = document.querySelector('.like-list')

  let likeList = localStorage.getItem('likeList')
  if(likeList == null){
    likeListElement.innerHTML += `<p>찜 목록이 비어있습니다.</p>`
  } else {
    likeList = JSON.parse(likeList);
    likeList.forEach((like)=>{
      likeListElement.innerHTML += `<p>${like['title']}</p>`
    })
  }



  console.log('onload')

  const xhr = new XMLHttpRequest(); // 서버에 데이터를 요청하기 위함.
  const method = 'GET';
  const url = 'data/movie.json';

  xhr.open(method, url);

  // xhr.responseType = "json"

  xhr.onreadystatechange = function(){
    if(xhr.readyState === 4){
      if(xhr.status === 200){
        const res = xhr.responseText; // JSON 문자열.
        const data = JSON.parse(res);
        
        // movies를 쓸 수 있음.
        const { movies } = data;

        // movies
        const movieList = document.querySelector('.content-movie-list-ul');

        movies.forEach((movie, idx) => {
          let listItem = `<li>
            <div class="list-item">
              <img src="${movie['img']}">
              <p>${movie['title']}</p>
              <p>${movie['genre']}</p>
              <p>${movie['director']}</p>
              <button class="like-btn">찜</button>
            </div>
          </li>`
          movieList.innerHTML += listItem;
        });


        const buttons = document.querySelectorAll('.like-btn');
        // console.log(buttons); // NodeList
        for(let i=0; i<buttons.length; i++){
          let btn = buttons[i];
          
          btn.addEventListener('click', function(event){
            let currentElement = event.target;
            let parentElement = currentElement.parentElement;
            let children = parentElement.children;

            let title = children[1].innerText;
            let genre = children[2].innerText;
            let director = children[3].innerText;

            console.log(title, genre, director);


            let likeList = localStorage.getItem('likeList');
            if(likeList == null) likeList = [];
            else likeList = JSON.parse(likeList);
            console.log(likeList)
            likeList.push({title, genre, director})
            console.log(likeList);
            localStorage.setItem('likeList', JSON.stringify(likeList));


            const likeListElement = document.querySelector('.like-list');
            if(likeList.length === 1){
              likeListElement.innerHTML = `<p>찜 리스트</p>`
            }
            likeListElement.innerHTML += `<p>${title}</p>`;

          })
        }

      }
    }
  }

  xhr.send();

}