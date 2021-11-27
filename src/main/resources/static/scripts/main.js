window.addEventListener("DOMContentLoaded", () => {
	document.body.classList.remove("preload");
	
    	/// Set current year
    	const yearEl = document.querySelector(".year");
    	const currentYear = new Date().getFullYear();
    	yearEl.textContent = currentYear;
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

// Fixing flexbox gap property missing in some Safari versions
function checkFlexGap() {
	var flex = document.createElement("div");
	flex.style.display = "flex";
	flex.style.flexDirection = "column";
	flex.style.rowGap = "1px";

	flex.appendChild(document.createElement("div"));
	flex.appendChild(document.createElement("div"));

	document.body.appendChild(flex);
	var isSupported = flex.scrollHeight === 1;
	flex.parentNode.removeChild(flex);
	console.log(isSupported);

	if (!isSupported) document.body.classList.add("no-flexbox-gap");
}
checkFlexGap();