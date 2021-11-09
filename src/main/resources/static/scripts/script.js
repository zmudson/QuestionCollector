<<<<<<< HEAD
function selectingTeam(teamSelectId, courseSelectId, categorySelectId) {
	const teamSelect = document.getElementById(teamSelectId);
	const courseSelect = document.getElementById(courseSelectId);
	const categorySelect = document.getElementById(categorySelectId);

	const courseOptions = courseSelect.querySelectorAll("option");

	courseOptions.forEach((option) => {
		// console.log(option);
		option.style.display = "none";
    // console.log(option.dataset.section);
		if (teamSelect.value.toLowerCase() === option.dataset.section.toLowerCase()) {
			option.style.display = "inline";
		}
	});

  // change displayed categories after switching sections
  courseSelect.selectedIndex = 0;
=======
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
>>>>>>> 65ebe6cf6e00070d4662c890ecd7c5e2878d8f13
}

/// mobile navigation

const btnNav = document.querySelector(".btn-mobile");
const headerEl = document.querySelector(".header");

if (btnNav) {
<<<<<<< HEAD
	btnNav.addEventListener("click", function () {
		headerEl.classList.toggle("nav-open");
	});
=======
  btnNav.addEventListener("click", function () {
    console.log("click");
    headerEl.classList.toggle("nav-open");
  });
>>>>>>> 65ebe6cf6e00070d4662c890ecd7c5e2878d8f13
}
