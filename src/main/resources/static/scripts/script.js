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
}

/// mobile navigation

const btnNav = document.querySelector(".btn-mobile");
const headerEl = document.querySelector(".header");
let mobileNavOpenBool = false;

if (btnNav) {
	btnNav.addEventListener("click", () => {
		headerEl.classList.toggle("nav-open");
		mobileNavOpenBool = !mobileNavOpenBool;
	});
}
