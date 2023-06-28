const cookieArr = document.cookie.split("=");
const userId = cookieArr[1];

const submitForm = document.getElementById('note-form');
const noteContainer = document.getElementById("note-container");

let noteBody = document.getElementById("note-body");
let updateNoteBtn = document.getElementById("update-note-button");

const headers = {
    "Content-Type":'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/notes/';

const handleLogout = () => {
    let c= document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

const handleSubmit = async (e) => {
    e.preventDefault()
    let bodyObj = {
        body: document.getElementById("note-input").value
    }
    await addNote(bodyObj);
    document.getElementById("note-input").value = '' 
}

async function addNote(obj){
    const response = await fetch(`${baseUrl}user/${userId}`, {
        method:"POST",
        body: JSON.stringify(obj),
        headers: headers
    }).catch(err => console.error(err.message))
    if(response.status == 200){
        return getNotes(userId)
    }
}
const getNotes = async (userId) =>{
    await fetch(`${baseUrl}user/${userId}`, {
        method:"GET",
        headers:headers
    }).then(response => response.json()).then(data=> createNoteCards(data)).catch(err => console.error(err))
}
const getNoteById = async (noteId) => {
    await fetch(baseUrl+noteId, {
        method:"GET",
        headers:headers
    }).then(res => res.json()).then(data => populateModal(data)).catch(err => console.error(err.message))

}

const handleNoteEdit = async (noteId) => {
    let bodyObj = {
        id:noteId,
        body: noteBody.value
    }

    await fetch(baseUrl, {
        method:"PUT",
        body: JSON.stringify(bodyObj),
        headers: headers
    }).catch(err => console.error(err))

    return getNotes(userId)
}

const handleDelete = async (noteId) => {
    await fetch(baseUrl + noteId, {
        method:"DELETE",
        headers:headers
    }).catch(err => console.error(err))
    return getNotes(userId)
}

const createNoteCards = (array) => {
    noteContainer.innerHTML = '';
    array.forEach(obj => {
        let noteCard = document.createElement("div")
        noteCard.classList.add("m-2")
        noteCard.innerHTML = `
        <div class="card d-flex" style="width:18rem; height:18rem;">
    <p class="card-text">${obj.body}</p>
    <div class="card-body d-flex flex-column justify-content-between">
        <button type="button" class="btn btn-danger" onclick="handleDelete(${obj.id})">Delete</button>
        <button onclick="getNoteById(${obj.id})" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#note-edit-modal">Edit</button>
    </div>
</div>
        `
        noteContainer.append(noteCard);
    })
}

const populateModal = (obj) => {
    noteBody.innerText = ''
    noteBody.innerText = obj.body
    updateNoteBtn.setAttribute('data-note-id', obj.id)

}

getNotes(userId);

submitForm.addEventListener("submit", handleSubmit)

updateNoteBtn.addEventListener("click", (e) =>{
    let noteId = e.target.getAttribute('data-note-id')
    handleNoteEdit(noteId)
})