$(document).ready(function() {

    $('#mainForm').submit(function(){
        username = document.getElementById('view-username').value;
        email = document.getElementById('view-email').value;
        publication = document.getElementById('view-birthday').value;
        password = document.getElementById('view-password').value;
        if(username == "" || email == "" || publication == "" || password == "") {
            alert('Preencha todos os campos obrigatórios');
            if(username == ""){
                document.getElementById('name').style.backgroundColor = "yellow";
            }
            if(email == ""){
                document.getElementById('genre').style.backgroundColor = "yellow";
            }

            if(publication == ""){
                document.getElementById('genre').style.backgroundColor = "yellow";
            }

             if(password == ""){
                document.getElementById('genre').style.backgroundColor = "yellow";
             }
            return false;
        }
        else {
            alert('Adição feita com sucesso!');
        }
    });

    $('#edit-album').autocomplete({
        serviceUrl: '/admin/release/album',
        minChars: 3,
		paramName: "name",
	    delimiter: ",",
	    transformResult: function(response) {
		    return {
		        //must convert json to javascript object before process
		        suggestions: $.map($.parseJSON(response), function(item) {
		            return { value: item.name, data: item.id };
		        })
		    };
        },
        appendTo: '#album-group',
        onSelect: function (suggestion) {
            var input = document.getElementById('edit-album-id');
            input.setAttribute('value', suggestion.data);
            //alert('You selected: ' + suggestion.value + ', ' + suggestion.data);
        }
     });

     $('#edit-label').autocomplete({
        serviceUrl: '/admin/release/label',
        minChars: 3,
		paramName: "name",
	    delimiter: ",",
	    transformResult: function(response) {
		    return {
		        //must convert json to javascript object before process
		        suggestions: $.map($.parseJSON(response), function(item) {
		            return { value: item.name, data: item.id };
		        })
		    };
        },
        appendTo: '#label-group',
        onSelect: function (suggestion) {
            var input = document.getElementById('edit-label-id');
            input.setAttribute('value', suggestion.data);
            //alert('You selected: ' + suggestion.value + ', ' + suggestion.data);
        }
     });
});

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
        roles.removeChild(roles.lastChild);
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
                input.setAttribute('id', 'view-roles');
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
        roles.removeChild(roles.lastChild);
    }
    $.ajax({
        url:"/admin/user",
        type:"POST",
        data:' {"type": "view", "id": ' + id + '} ',
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function(user){
            document.getElementById('edit-id').value = user.id;
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
				input.setAttribute('name', 'roles');
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
    input.setAttribute('id', 'edit-role-' + counter);
	input.setAttribute('name', 'roles');

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

function deleteUser(id) {
    document.getElementById('delete-user-id').value = id;
}
