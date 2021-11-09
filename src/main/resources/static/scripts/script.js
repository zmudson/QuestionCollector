function selectingTeam(s1, s2, cat) {
  const team = document.getElementById(s1);

  const course = document.getElementById(s2);
  const category = document.getElementById(cat);

  course.innerHTML = "";

  let optionArray = [];

  if (team.value == "frontend") {
    optionArray = [
      "html&css|HTML&CSS",
      "typescript|TypeScript",
      "angular|Angular",
    ];
  }
  if (team.value == "backend") {
    optionArray = ["spring|Spring"];
  }
  for (let option in optionArray) {
    const pair = optionArray[option].split("|");
    const opt = document.createElement("option");
    opt.value = pair[0];
    opt.innerHTML = pair[1];
    course.options.add(opt);
    category.value = "";
  }
}

/// mobile navigation

const btnNav = document.querySelector(".btn-mobile");
const headerEl = document.querySelector(".header");

if (btnNav) {
  btnNav.addEventListener("click", function () {
    headerEl.classList.toggle("nav-open");
  });
}
