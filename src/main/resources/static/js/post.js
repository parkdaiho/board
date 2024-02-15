const addBtn = document.getElementById("add_btn");

if(addBtn) {
    addBtn.addEventListener("click", () => {
        if(!validCheck()) {
            return false;
        }

        let body = JSON.stringify({
            title: document.getElementById("title").value,
            contents: document.getElementById("contents").value
        });

        fetch("/api/post", {
            method: "POST",
            headers: {
                "Content-type": "application/json"
            },
            body: body,
        })
            .then(response => {
                if(response.ok) {
                    alert("글쓰기 성공");
                    location.replace(response.headers.get("Location"));
                } else {
                    alert("글쓰기 실패");
                    location.replace("/posts");
                }
            });
    });
}

const modifyBtn = document.getElementById("modify_btn");

if(modifyBtn) {
    modifyBtn.addEventListener("click", () => {
        if(!validCheck()) {
            return false;
        }

        let body = JSON.stringify({
            title: document.getElementById("title").value,
            contents: document.getElementById("contents").value
        });

        let id = document.getElementById("id").value;

        fetch("/api/post/" + id, {
            method: "PUT",
            headers: {
                "Content-type": "application/json"
            },
            body: body,
        })
            .then(response => {
                if(response.ok) {
                    alert("글수정 성공");
                    location.replace(response.headers.get("Location"));
                } else {
                    alert("글수정 실패");
                    location.replace("/posts/" + id);
                }
            });
    });
}

const deleteBtn = document.getElementById("delete_btn");

if(deleteBtn) {
    deleteBtn.addEventListener("click", () =>{
        let id = document.getElementById("id").value;

        fetch("/api/post/" + id, {
            method: "DELETE",
            headers: {
                "Content-type": "application/json"
            },
        })
            .then(response => {
                if(response.ok) {
                    alert("글삭제 성공");
                    location.replace("/posts");
                } else {
                    alert("글삭제 실패");
                    location.replace("/posts/" + id);
                }
            });
    });
}

const validCheck = function () {
    let title = document.getElementById("title");
    let contents = document.getElementById("contents");

    if(title.value === "") {
        alert("제목을 입력해주세요.");
        title.focus();
        return false;
    }

    if(contents.value === "") {
        alert("내용을 입력해주세요.");
        contents.focus();
        return false;
    }

    return true;
};