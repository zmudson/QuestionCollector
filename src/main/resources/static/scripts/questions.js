
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