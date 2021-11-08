<<<<<<< HEAD
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
}

window.onload = function () {
  if (localStorage.getItem('end') == null || localStorage.getItem('end') == 'front') {
    $('.switch').addClass('frontend-btn', 0);
    localStorage.setItem('end', 'front');
    document.getElementsByClassName('switch__caption')[0].innerText = 'Frontend';
  }
  else {
    $(".switch").addClass("backend-btn", 0);
    localStorage.setItem('end', 'back');
    document.getElementsByClassName('switch__caption')[0].innerText = 'Backend';
  }
  showEnds();
}

function turnSide(i) {
  if (document.getElementsByClassName('question')[i].style.visibility == 'hidden') {
    document.getElementsByClassName('question')[i].style.visibility = 'visible';
    document.getElementsByClassName('answer')[i].style.visibility = 'hidden';
  }
  else {
    document.getElementsByClassName('question')[i].style.visibility = 'hidden';
    document.getElementsByClassName('answer')[i].style.visibility = 'visible';
  }
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
=======

function turnSide(i) {
  if (document.getElementsByClassName('question')[i].style.visibility == "hidden") {
    document.getElementsByClassName('question')[i].style.visibility = "visible";
    document.getElementsByClassName('answer')[i].style.visibility = "hidden";
  }
  else {
    document.getElementsByClassName('question')[i].style.visibility = "hidden";
    document.getElementsByClassName('answer')[i].style.visibility = "visible";
  }
}
>>>>>>> Added feature without category handling
