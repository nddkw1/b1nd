const description = document.getElementById("description");
const message = ["프론트엔드 개발을 하고 있는 장준우입니다.", "빠르게 변화하는 흐름에 유연하게 뛰어드는 개발자, 장준우입니다."];

function changeMessage() {
    if (description.innerHTML == message[0]) {
        description.innerHTML = message[1];
    } else {
        description.innerHTML = message[0];
    }
};

description.addEventListener("click", changeMessage);