function showEnds() {
  if (localStorage.getItem('end') == 'front') {
    var sizeFront = document.getElementsByClassName('frontend').length;
    for (let i = 0; i < sizeFront; i++) {
      document.getElementsByClassName('frontend')[i].classList.remove('hidden');
    }
    var sizeBack = document.getElementsByClassName('backend').length;
    for (let i = 0; i < sizeBack; i++) {
      document.getElementsByClassName('backend')[i].classList.add('hidden');
    }
  }
  else {
    var sizeBack = document.getElementsByClassName('backend').length;
    for (let i = 0; i < sizeBack; i++) {
      document.getElementsByClassName('backend')[i].classList.remove('hidden');
    }
    var sizeFront = document.getElementsByClassName('frontend').length;
    for (let i = 0; i < sizeFront; i++) {
      document.getElementsByClassName('frontend')[i].classList.add('hidden');
    }
  }
  var sizeQuestions = document.getElementsByClassName('question').length;
  for (let i = 0; i < sizeQuestions; i++) {
    document.getElementsByClassName('question__elem-inner')[i].classList.remove('is-flipped');
  }
}

function start() {
  if (localStorage.getItem('end') == null || localStorage.getItem('end') == 'front') {
    document.getElementsByClassName('switch')[0].classList.add('frontend-btn');
    localStorage.setItem('end', 'front');
    document.getElementsByClassName('switch__caption')[0].innerText = 'Frontend';
  }
  else {
    document.getElementsByClassName('switch')[0].classList.add('backend-btn');
    localStorage.setItem('end', 'back');
    document.getElementsByClassName('switch__caption')[0].innerText = 'Backend';
  }
  showEnds();
}

function turnSide(i) {
  document.getElementsByClassName('question__elem-inner')[i].classList.toggle('is-flipped');
}

$(function () {
  $('.switch__button').on('click', function () {
    if (localStorage.getItem('end') == 'back') {
      $('.switch').switchClass('backend-btn', 'frontend-btn', 0);
      localStorage.setItem('end', 'front');
      document.getElementsByClassName('switch__caption')[0].innerText = 'Frontend';
    }
    else {
      $('.switch').switchClass('frontend-btn', 'backend-btn', 0);
      localStorage.setItem('end', 'back');
      document.getElementsByClassName('switch__caption')[0].innerText = 'Backend';
    }
    showEnds();
  });
});

start();