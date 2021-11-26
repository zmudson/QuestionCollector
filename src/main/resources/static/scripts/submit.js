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
    const placeholderOption = document.getElementById("coursesPlaceholder").cloneNode(true);
    courseSelect.innerHTML = "";
    courseSelect.appendChild(placeholderOption);
    for (const course of courses) {
        const option = document.createElement("option");
        option.value = course.id;
        option.textContent = course.name;
        courseSelect.appendChild(option);
    }
    handleCategoriesOptions([]);
}

function handleCategoriesOptions(categories){
    const placeholderOption = document.getElementById("categoryPlaceholder").cloneNode(true);
    categorySelect.innerHTML = "";
    categorySelect.appendChild(placeholderOption);
    for (const category of categories) {
        const option = document.createElement("option");
        option.value = category.id;
        option.textContent = category.name;
        categorySelect.appendChild(option);
    }
}

teamSelect.addEventListener("change", e => {
    getCourses(e.currentTarget.value);

});

courseSelect.addEventListener("change", e => {
    getCategories(e.currentTarget.value);
});



