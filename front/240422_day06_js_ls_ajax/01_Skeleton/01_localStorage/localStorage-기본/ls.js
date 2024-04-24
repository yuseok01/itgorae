//////// 페이지에 처음 들어왔을 때 
window.addEventListener("load", function () {
  let data = localStorage.getItem("data")
  if (data != null) {
    document.querySelector("#saved > li").innerText = JSON.parse(data)
  } else {
    document.querySelector('#saved > li').innerText = "저장된 내용이 없습니다."
  }
})




//////// 등록 #create 

// 1. 등록 버튼 선택(접근)
let createBtn = document.querySelector('#create')
console.log(createBtn)

// 2. 등록 버튼에 클릭 이벤트 추가
createBtn.addEventListener('click', function(){



// 2-a. input 태그  || input 아이디 선택 
let inputTag = doucnment.querySelector('#input')

// 2-b. input에서 가져온 value를 json문자열으로 바꾸기
let inputValue = JSON.stringify(inputTag.value)
 

// 2-c. localStorage에 "data" 이름으로 값 추가
localStorage.setItem("data", inputValue)

// (중요) 2-d. input태그의 value값 초기화
inputTag.value = ""
})

//////// 조회 #read 
// 코드를 작성하세요.
document.querySelector("#read").addEventListener("click", function(){
  let readTag = document.querySelector("#saved > li")
  let jsonData = localStorage.getItem("data")
  if(jsonData != null){
    let data = JSON.parse(jsonData)
    readTag.innerText = data
  }
})

//////// 삭제 #delete 
// 코드를 작성하세요.

document.querySelector("#delete").addEventListener("click",function(){
  localStorage.removeItem("data")
  doucument.querySelector("#saved > li").innerText = "저장된 내용이 없습니다."
  alert("삭제되었습니다.") 
})




