window.addEventListener("DOMContentLoaded", () => {
	document.body.classList.remove("preload");
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
		if (
			teamSelect.value.toLowerCase() === option.dataset.section.toLowerCase()
		) {
			option.style.display = "inline";
		}
	});

	// change displayed categories after switching sections
	courseSelect.selectedIndex = 0;
}

/// mobile navigation

const mainMenu = document.querySelector(".mainMenu");
const closeMenuButton = document.querySelector(".closeMenu");
const openMenuButton = document.querySelector(".openMenu");

openMenuButton.addEventListener("click", () => {
	mainMenu.classList.toggle('main-menu--visible');
});
closeMenuButton.addEventListener("click", () => {
	mainMenu.classList.toggle('main-menu--visible');
});
