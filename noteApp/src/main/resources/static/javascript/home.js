const cookieArr = document.cookie.split("=");
const userId = cookieArr[1];

const submitForm = document.getElementById('note-form');
const noteContainer = document.getElementById("note-container");

let noteBody = document.getElementById("note-body");
let updateNoteBtn = document.getElementById("update-note-btn");

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