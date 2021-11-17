window.addEventListener("DOMContentLoaded", () => {
	document.body.classList.remove("preload");
});

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