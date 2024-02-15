const usernameRegx = /[a-zA-Z0-9]{8,16}/;
const passwordRegx = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[~\\!@#$%^&*()\-_+=]).{8,20}$/;
const nicknameRegx = /[a-zA-Z가-힣0-9]{4,16}/;

function validCheck() {

    let username = document.getElementById("username");
    let password = document.getElementById("password");
    let nickname = document.getElementById("nickname");

    if(username.value === "") {
        alert("아이디를 입력해주세요.");
        username.focus();
        return false;
    } else if(!usernameValidCheck(username.value)) {
        alert("아이디는 알파벳 소문자, 대문자, 숫자로 이루어진 8자리 이상 16자리 이하인 문자열");
        username.focus();
        return false;
    } else if(password.value === "") {
        alert("비밀번호를 입력해주세요.");
        password.focus();
        return false;
    } else if(!passwordValidCheck(password.value)) {
        alert("비밀번호는 알파벳 소문자, 대문자, 숫자, 특수 문자 각각을 최소한 하나씩 포함하는 8자리 이상 20자리 이하인 문자열");
        password.focus();
        return false;
    } else if(nickname.value === "") {
        alert('닉네임을 입력해주세요.');
        nickname.focus();
        return false;
    } else if(!nicknameValidCheck(nickname.value)) {
        alert("닉네임은 특수문자를 포함하지 않는 4자리 이상 16자리 이하의 문자열");
        nickname.focus();
        return false;
    }

    return true;
}

function passwordValidCheck(password) {
    return passwordRegx.test(password);
}

function usernameValidCheck(username) {
    return usernameRegx.test(username);
}

function nicknameValidCheck(nickname) {
    return nicknameRegx.test(nickname);
}
