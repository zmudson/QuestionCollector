const teamSelect = document.getElementById("team");
const courseSelect = document.getElementById("courses");
const categorySelect = document.getElementById("category");

function getCourses(section){
    fetch("/api/submit/courses?" + new URLSearchParams({
        section
    }))
        .then(response => response.json())
        .then(courses =>{
            courses.sort((courseA, courseB) => courseA.id - courseB.id);
            handleCourseOptions(courses);
        });
}

function getCategories(courseId){
    fetch("/api/submit/categories?" + new URLSearchParams({
        courseId
    }))
        .then(response => response.json())
        .then(categories =>{
            categories.sort((categoryA, categoryB) => categoryA.id - categoryB.id);
            handleCategoriesOptions(categories);
        });
}

function handleCourseOptions(courses){
    courseSelect.innerHTML = "";
    for (const course of courses) {
        const option = document.createElement("option");
        option.value = course.id;
        option.textContent = course.name;
        courseSelect.appendChild(option);
    }
}

function handleCategoriesOptions(categories){
    categorySelect.innerHTML = "";
    for (const category of categories) {
        const option = document.createElement("option");
        option.value = category.id;
        option.textContent = category.name;
        categorySelect.appendChild(option);
    }
}

function init(){
    getCourses(sessionStorage.getItem("section"));
}

window.addEventListener('DOMContentLoaded', init);



courseSelect.addEventListener("change", e => {
    getCategories(e.currentTarget.value);
});

teamSelect.addEventListener("change", e => {
    console.dir(e.currentTarget);
    getCourses(e.currentTarget.value);
    categorySelect.innerHTML = "";
});
