document.addEventListener("DOMContentLoaded", function () {

    const form = document.querySelector("form");

    form.addEventListener("submit", function (event) {
        let isValid = true;

        clearErrors();

        const clothName = document.getElementById("clothName").value.trim();
        const brandName = document.getElementById("brandName").value.trim();
        const categoryName = document.getElementById("categoryName").value.trim();
        const size = document.getElementById("size").value.trim();
        const color = document.getElementById("color").value.trim();
        const price = document.getElementById("price").value.trim();
        const stockQty = document.getElementById("stockQuantity").value.trim();
        const availability = document.getElementById("availabilityStatus").value;

        if (clothName === "") {
            showError("clothNameMsg", "Cloth name is required");
            isValid = false;
        }

        if (brandName === "") {
            showError("brandNameMsg", "Brand name is required");
            isValid = false;
        }

        if (categoryName === "") {
            showError("categoryNameMsg", "Category name is required");
            isValid = false;
        }

        if (size === "") {
            showError("sizeMsg", "Size is required");
            isValid = false;
        }

        if (color === "") {
            showError("colorMsg", "Color is required");
            isValid = false;
        }

        if (price === "") {
            showError("priceMsg", "Price is required");
            isValid = false;
        } else if (isNaN(price) || Number(price) <= 0) {
            showError("priceMsg", "Price must be a positive number");
            isValid = false;
        }

        if (stockQty === "") {
            showError("stockQuantityMsg", "Stock quantity is required");
            isValid = false;
        } else if (isNaN(stockQty) || Number(stockQty) < 0) {
            showError("stockQuantityMsg", "Stock must be 0 or more");
            isValid = false;
        }

        if (availability === "") {
            showError("availabilityStatusMsg", "Please select availability status");
            isValid = false;
        }

        if (!isValid) {
            event.preventDefault();
        }
    });

    function showError(id, message) {
        document.getElementById(id).innerText = message;
    }

    function clearErrors() {
        const errorFields = document.querySelectorAll("small.text-danger");
        errorFields.forEach(field => field.innerText = "");
    }
});
