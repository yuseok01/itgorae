const list = document.querySelectorAll('a')

list.forEach((a) => {
  let color
  if (a.innerText == 'add') {
    color = 'btn-dark'
  } else if (a.innerText == 'hello') {
    color = 'btn-outline-dark'
  } else if (a.innerText == 'say hi') {
    color = 'btn-primary'
  } else if (a.innerText == 'say bye') {
    color = 'btn-warning'
  } else if (a.innerText == 'warning') {
    color = 'btn-danger'
  } else if (a.innerText == 'only click available') {
    color = 'btn-success'
  }
  a.classList.add('btn', color, 'btn-sm', 'mx-1', 'my-1')
  
  if(a.innerText != 'add') {
    a.classList.add('d-block')
  }
})

const pTag = document.querySelector('p')
pTag.style.display = 'inline'



