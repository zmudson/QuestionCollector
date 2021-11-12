const switchElement = document.querySelector(".switch");
const caption = switchElement.querySelector(".switch__caption");
const questionList = document.querySelector(".question-list");
let isFrontendActive;
let isBackendStarter = true;

function toggle() {
    if (isBackendStarter) {
        switchElement.classList.replace('backend-btn-starter', 'backend-btn');
        isBackendStarter = false;
    }
    if (isFrontendActive) {
        switchElement.classList.remove("frontend-btn");
        switchElement.classList.add("backend-btn");
        sessionStorage.setItem("section", "backend");
        caption.textContent = sessionStorage.getItem("section");
    } else {
        switchElement.classList.remove("backend-btn");
        switchElement.classList.add("frontend-btn");
        sessionStorage.setItem("section", "frontend");
        caption.textContent = sessionStorage.getItem("section");
    }
    isFrontendActive = !isFrontendActive;
    handleQuestions();
}

function initQuestions() {
    const list = questionList.querySelectorAll(".question__elem");
    list.forEach(question => {
        question.addEventListener("click", e => {
            e.currentTarget.querySelector(".question__elem-inner").classList.toggle("is-flipped");
        });
    });
}

function handleQuestions() {
    const list = questionList.querySelectorAll(".question__elem");
    const activeSection = sessionStorage.getItem("section");
    list.forEach(question => {
        question.style.display = !question.classList.contains(activeSection) ? "none" : "block";
    });
}

function init() {
    if (!sessionStorage.getItem("section")) {
        sessionStorage.setItem("section", "frontend");
    }
    isFrontendActive = sessionStorage.getItem("section") == "frontend";
    if (isFrontendActive) {
        switchElement.classList.add("frontend-btn");
    } else {
        switchElement.classList.add("backend-btn-starter");
    }
    caption.textContent = sessionStorage.getItem("section");
    initQuestions();
    handleQuestions();
    // document.body.classList.remove("unloaded");
}

window.addEventListener('DOMContentLoaded', init);

switchElement.querySelector(".switch__button").addEventListener("click", toggle);

document.querySelector('.random').addEventListener('click', () => {
    window.location.reload();
});