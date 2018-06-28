function limparTudo(){
    document.getElementById('name').style.backgroundColor = "white";
    document.getElementById('name').value = "";
    document.getElementById('namePerson').style.backgroundColor = "white";
    document.getElementById('namePerson').value = "";
    document.getElementById('email').style.backgroundColor = "white";
    document.getElementById('email').value = "";
    document.getElementById('password').style.backgroundColor = "white";
    document.getElementById('password').value = "";
    document.getElementById('passwordConfirmation').style.backgroundColor = "white";
    document.getElementById('passwordConfirmation').value = "";
}

$(document).ready(function() {
            
    $('form').submit(function(){
        name = document.getElementById('name').value;
        namePerson = document.getElementById('namePerson').value;
        email = document.getElementById('email').value;
        password = document.getElementById('password').value;
        passwordConfirmation = document.getElementById('passwordConfirmation').value;
        if(name == "" || namePerson == "" || email == "" || email2 == "" || senha == "" || senha2 == ""){
            alert('Preencha todos os campos obrigatórios');
            if(namePerson == ""){
                document.getElementById('namePerson').style.backgroundColor = "yellow";
            }
            if(name == ""){
                document.getElementById('name').style.backgroundColor = "yellow";
            }
            if(email == ""){
                document.getElementById('email').style.backgroundColor = "yellow";
            }
            if(password == ""){
                document.getElementById('password').style.backgroundColor = "yellow";
            }
            if(passwordConfirmation == ""){
                document.getElementById('passwordConfirmation').style.backgroundColor = "yellow";
            }
            return false;
        
        }else if(password != passwordConfirmation){
                 alert('Senhas usadas não são iguais');
                return false;
        }else{
            alert('Usuário cadastrado com sucesso!');
        }
    });
});

$(document).ready(function() {
    $(email).focusout(function() {

        var pattern = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

        if (pattern.exec($(email).val()) === null && $(email).val()) {
            $(email).popover( {
                html: true,
                trigger: 'hover',
                content: function () {
                   return 'Insira um endereço de e-mail válido.';
                }
            });
        }
    });
});