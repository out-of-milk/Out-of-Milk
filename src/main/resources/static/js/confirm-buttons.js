let updateCatBTN = document.getElementById("update-categories-form");
let deletePantryBTN = document.getElementById("delete-pantry-form");
let deleteGroceryBTN = document.getElementById("delete-grocery-form");
let emailGroceryBTN = document.getElementById("email-grocery-btn");




updateCatBTN.addEventListener('submit', function (e) {
    let text = "Do you want to update favorite categories?";
    if (confirm(text) == true) {
        return true;
    } else {
        e.preventDefault();
    }
})
deletePantryBTN.addEventListener('submit', function (e) {
    let text = "Do you want to remove all items from your pantry list?";
    if (confirm(text) == true) {
        return true;
    } else {
        e.preventDefault();
    }
})
deleteGroceryBTN.addEventListener('submit', function (e) {
    let text = "Do you want to remove all items from your grocery list";
    if (confirm(text) == true) {
        return true;
    } else {
        e.preventDefault();
    }
})
emailGroceryBTN.addEventListener('submit', function (e) {
    let text = "Do you want to email your grocery list";
    if (confirm(text) == true) {
        return true;
    } else {
        e.preventDefault();
    }
})

