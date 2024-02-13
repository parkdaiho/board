const username = document.getElementById("username");
const password = document.getElementById("password");
const err = searchParam("err");

if(err === "unexpected-user") {
    alert("아이디와 비밀번호를 확인해주세요.");
}

function searchParam(key) {
    return new URLSearchParams(location.search).get(key);
}

function validCheck() {
    if(username === null) {
        alert("아이디를 입력해주세요.");
        return false;
    }

    if(password === null) {
        alert("비밀번호를 입력해주세요.");
        return false;
    }

    return true;
}
