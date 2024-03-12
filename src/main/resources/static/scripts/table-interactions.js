//wait until page loads
window.onload = function () {
    //select all edit links
    const editLinks = document.querySelectorAll('.edit');
    console.log(editLinks);

    for (const link of editLinks) {
        link.onclick = editRecord;
    }

    //select all delete links
    const deleteLinks = document.querySelectorAll('.delete');
    console.log(deleteLinks);

    for (const link of deleteLinks) {
        link.onclick = deleteRecord;
    }
}

function deleteRecord(evt) {
    //look for the id we are deleting
    const deleteLink = evt.target;
    const row = deleteLink.parentElement.parentElement;
    const cells = row.children;

    const id = cells[0].innerHTML;

    //send the fetch request

    //how do we remove the row
    row.remove();
}

function editRecord(evt) {
    console.log(evt.target);

    //look for the id we are editing
    const editLink = evt.target;
    const row = editLink.parentElement.parentElement;
    const cells = row.children;

    const id = cells[0].innerHTML;
    console.log(`Editing id ${id}`);

    const species = cells[2].innerHTML;
    console.log(`Editing species ${species}`);

    //replace the text with an input element
    cells[2].innerHTML = `<input type="text" id="species" value="${species}">`;

    const color = cells[3].innerHTML;
    console.log(`Editing color ${color}`);
    cells[3].innerHTML = `<input type="text" id="color" value="${color}">`;

}