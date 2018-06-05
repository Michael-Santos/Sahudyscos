function limparTudo(){
    document.getElementById('edit-id').value = "";
    document.getElementById('edit-username').style.backgroundColor = "white";
    document.getElementById('edit-username').value = "";
    document.getElementById('edit-email').style.backgroundColor = "white";
    document.getElementById('edit-email').value = "";
    document.getElementById('edit-birthday').style.backgroundColor = "white";
    document.getElementById('edit-birthday').value = "";
    document.getElementById('edit-password').style.backgroundColor = "white";
    document.getElementById('edit-password').value = "";
    document.getElementById('edit-active').checked = false;
}

function viewUser(id) {
    var roles = document.getElementById('roles-field');
    while (roles.childElementCount != 1) {
        roles.removeChild(artists.lastChild);
    }
    $.ajax({
        url:"/admin/user",
        type:"POST",
        data:' {"type": "view", "id": ' + id + '} ',
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function(user){
            document.getElementById('view-username').value = user.username;
            document.getElementById('view-email').value = user.email;
            document.getElementById('view-birthday').value = user.birthday;
            user.roles.forEach(element => {
                var input = document.createElement("input");
                input.setAttribute('type', 'text');
                input.setAttribute('id', 'view-artists');
                input.setAttribute('class', 'readonly form-control-plaintext');
                input.setAttribute('readonly', 'true');
                input.setAttribute('value', element.role);
                roles.appendChild(input);
            });
            if (user.active == true) {
                document.getElementById('view-active').checked = true;
            }
            document.getElementById('view-password').value = user.password;
        }
    });
}

counter = 1;
function editUser(id) {
    var roles = document.getElementById('edit-roles-group');
    while (roles.childElementCount != 1) {
        roles.removeChild(artists.lastChild);
    }
    $.ajax({
        url:"/admin/user",
        type:"POST",
        data:' {"type": "view", "id": ' + id + '} ',
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function(user){
            document.getElementById('edit-username').value = user.username;
            document.getElementById('edit-email').value = user.email;
            document.getElementById('edit-birthday').value = user.birthday;
            counter = 0;
            user.roles.forEach(element => {
                var input = document.createElement("input");
                input.setAttribute('type', 'text');
                input.setAttribute('id', 'edit-role-' + counter);
                input.setAttribute('class', 'readonly form-control');
                input.setAttribute('value', element.role);
                roles.appendChild(input);
            });
            if (user.active == true) {
                document.getElementById('edit-active').checked = true;
            }
            document.getElementById('edit-password').value = user.password;
        }
    });
}

function addRole() {
    var group = document.getElementById('edit-roles-group');
    var div = document.createElement("div");
    var input = document.createElement("input");
    var button = document.createElement("button");

    div.setAttribute('class', 'input-group-append my-2');
    div.setAttribute('id', 'role-' + counter);

    input.setAttribute('type', 'text');
    input.setAttribute('class', 'form-control');
    input.setAttribute('id', 'edit-artist-' + counter);

    button.setAttribute('type', 'button');
    button.setAttribute('class', 'btn btn-danger btn-sm mx-1');
    button.setAttribute('onclick', 'removeRole(' + counter + ')');
    button.innerHTML = "Remover Função";

    div.appendChild(input);
    div.appendChild(button);
    group.appendChild(div);

    counter++;
}

function removeRole(i) {
    var group = document.getElementById('edit-roles-group');
    var div = document.getElementById('role-' + i);
    group.removeChild(div);
    counter--;
}