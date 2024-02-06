const addButton = document.getElementById("add-btn");

if(addButton) {
    addButton.addEventListener("click", () => {
        fetch('/post' ,{
            method: "POST",
            headers: {
                "Content-type": "application/json",
            },
            body: JSON.stringify({
                userId: document.getElementById('userId').value,
                title: document.getElementById('title').value,
                contents: document.getElementById('contents').value,
            })
        })
            .then((response) => {
                alert("글쓰기 완료");
                location.href = '/posts/' + response.body;
            });
    });
}