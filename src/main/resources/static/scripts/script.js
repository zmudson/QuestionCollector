window.addEventListener("DOMContentLoaded", () => {
	document.body.classList.remove("preload");
});

const teamSelect = document.getElementById("team");
const courseSelect = document.getElementById("courses");
const categorySelect = document.getElementById("category");

function handleTeamSelect() {

	const courseOptions = courseSelect.querySelectorAll("option");

	courseOptions.forEach((option) => {
		option.style.display = "none";
		if (
			teamSelect.value.toLowerCase() === option.dataset.section.toLowerCase()
		) {
			option.style.display = "inline";
		}
	});

	// change displayed categories after switching sections
	// teamSelect.selectedIndex = 0;
	// courseSelect.selectedIndex = 0;
	// categorySelect.selectedIndex = 0;
}

teamSelect.addEventListener("change", handleTeamSelect);



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
