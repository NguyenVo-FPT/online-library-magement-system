document.addEventListener("DOMContentLoaded", function () {
    var modal = document.getElementById("signupModal");
    var btn = document.querySelector(".header a[href='signup.html']");
    var closeBtn = document.querySelector(".close");

    btn.addEventListener("click", function (event) {
        event.preventDefault(); // Ngăn chặn mở trang mới
        modal.style.display = "block";
    });

    closeBtn.addEventListener("click", function () {
        modal.style.display = "none";
    });

    window.addEventListener("click", function (event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    });
});
