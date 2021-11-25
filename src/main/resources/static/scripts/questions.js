const switchElement = document.querySelector(".switch");
const caption = switchElement.querySelector(".switch__caption");
const questionList = document.querySelector(".question-list");
let isFrontendActive;
let isBackendStarter = true;
let isLoaded = false;

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
    loadQuestions();
}

function handleQuestions(questions){
    questionList.innerHTML = "";
    questions.forEach(question => {
        // card
        const card = document.createElement("div");
        card.classList.add(question.section);
        card.addEventListener("click", e => {
            e.currentTarget.querySelector(".question__elem-inner").classList.toggle("is-flipped");
        });

        // inner element
        const innerElement = document.createElement("div");
        innerElement.classList.add("question__elem-inner");
        card.appendChild(innerElement);

        // question
        const questionElement = document.createElement("div");
        questionElement.classList.add("question");
        innerElement.appendChild(questionElement);

        // question text
        const questionText = document.createElement("div");
        questionText.classList.add("question__text");
        questionText.textContent = question.description

        // course
        const course = document.createElement("div");
        course.classList.add("course");
        course.textContent = question.course;

        // category
        const category = document.createElement("div");
        category.classList.add("category");
        category.textContent = question.category
        questionElement.appendChild(category);

        questionElement.appendChild(category);
        questionElement.appendChild(questionText);
        questionElement.appendChild(course);

        // answer
        const answer = document.createElement("div");
        answer.classList.add("answer");
        innerElement.appendChild(answer);

        // answer title
        const answerTitle = document.createElement("div");
        answerTitle.classList.add("answer__title");
        answer.textContent = "Answer:";
        answer.appendChild(answerTitle);

        // answer text
        const answerText = document.createElement("div");
        answerText.classList.add("answer__text");
        answerText.textContent = question.answer;
        answer.appendChild(answerText);

        questionList.appendChild(card);
    });
}

function loadQuestions(){
    fetch("/api/questions?" + new URLSearchParams({
        section: sessionStorage.getItem("section")
    }))
        .then(response => response.json())
        .then(questions =>{
            if(!isLoaded){
                isLoaded = true;
                setTimeout(() => {
                    document.body.classList.remove("loading");
                    document.body.querySelector(".loader-container").remove();
                }, 1000);
            }
            handleQuestions(questions);
        });
}

function init() {
    if (!sessionStorage.getItem("section")) {
        sessionStorage.setItem("section", "frontend");
    }
    isFrontendActive = sessionStorage.getItem("section") === "frontend";
    if (isFrontendActive) {
        switchElement.classList.add("frontend-btn");
    } else {
        switchElement.classList.add("backend-btn-starter");
    }
    caption.textContent = sessionStorage.getItem("section");
    loadQuestions();
    document.body.classList.remove("unloaded");
}

window.addEventListener('DOMContentLoaded', init);

switchElement.querySelector(".switch__button").addEventListener("click", toggle);

document.querySelector('.random').addEventListener('click', () => {
    window.location.reload();
});