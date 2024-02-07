const addButton = document.getElementById("add-btn");

if(addButton) {
    addButton.addEventListener("click", () => {
        fetch('/post' ,{
            method: "POST",
            headers: {
                "Content-type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                contents: document.getElementById('contents').value,
            }),
        })
            .then((response) => {
                if(response.status === 201) {
                    alert('글쓰기 완료');
                    location.href = response.headers.get("Location");
                }
            })
    });
}

const modifyButton = document.getElementById("modify-btn");

if(modifyButton) {
    modifyButton.addEventListener("click", () => {
        let postId = document.getElementById("post_id").value;
        fetch('/post/' + postId, {
            method: "PUT",
            headers: {
                "Content-type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById("title").value,
                contents: document.getElementById("contents").value,
            }),
        })
            .then((response) => {
                if(response.status === 201) {
                    alert("수정완료");
                    location.href = response.headers.get("Location");
                }
            })
    })
}

const deleteButton = document.getElementById("delete-btn");

if(deleteButton) {
    deleteButton.addEventListener("click", () => {
        let postId = document.getElementById("post_id").value;
        fetch('/post/' + postId, {
            method: "DELETE",
        })
            .then(response => {
                if(response.status === 200) {
                    alert("삭제완료");
                    location.href = "/posts";
                }
            })
    });
}