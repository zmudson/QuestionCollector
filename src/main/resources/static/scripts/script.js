window.addEventListener('DOMContentLoaded', () => {
	document.body.classList.remove('preload');
});

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


	const mainMenu = document.querySelector(".mainMenu");
	const closeMenu = document.querySelector(".closeMenu");
	const openMenu = document.querySelector(".openMenu");

	openMenu.addEventListener("click", () => {
	mainMenu.style.display = "flex";
	mainMenu.style.top = "0";
	mainMenu.style.gap = "2.4rem";
});
	closeMenu.addEventListener("click", () => {
	mainMenu.style.top = "-100%";
});

