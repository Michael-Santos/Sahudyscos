$(document).ready(function() {
    $.getJSON('paises.json', function (data) {
        var items = [];
        var options = '<option value="">Por favor, selecione um país</option>';
        $.each(data, function (key, val) {
            options += '<option value="' + val.name + '">' + val.name + '</option>';
        });
        $("#dropDownPaises").html(options);
    });
});

$(document).ready(function() {
                
    $('mainform').submit(function(){
        name = document.getElementById('name').value;
        rating = document.getElementById('rating').value;
        publication = document.getElementById('publication').value;
        artists = document.getElementById('artists').value;
        genre = document.getElementById('genre').value;
        if(name == "" || rating == "" || publication == "" || artists == "" || genre == "") {
            alert('Preencha todos os campos obrigatórios');
            if(name == ""){
                document.getElementById('name').style.backgroundColor = "yellow";
            }
            if(rating == ""){
                document.getElementById('rating').style.backgroundColor = "yellow";
            }
            if(publication == ""){
                document.getElementById('publication').style.backgroundColor = "yellow";
            }
            if(artists == ""){
                document.getElementById('artists').style.backgroundColor = "yellow";
            }
            if(genre == ""){
                document.getElementById('genre').style.backgroundColor = "yellow";
            }
            return false;
        }
        else {
            alert('Adição feita com sucesso!');
        }
    });
});

function limparTudo(){
    document.getElementById('name').style.backgroundColor = "white";
    document.getElementById('name').value = "";
    document.getElementById('rating').style.backgroundColor = "white";
    document.getElementById('rating').value = "";
    document.getElementById('publication').style.backgroundColor = "white";
    document.getElementById('publication').value = "";
    document.getElementById('artists').style.backgroundColor = "white";
    document.getElementById('artists').value = "";
    document.getElementById('genre').style.backgroundColor = "white";
    document.getElementById('genre').value = "";
    document.getElementById('alt-genre').value = "";
    document.getElementById('description').value = "";
}

function viewAlbum(id) {
$.ajax({
    url:"/admin/album",
    type:"POST",
    data:' {"type": "view", "id": ' + id + '} ',
    contentType:"application/json; charset=utf-8",
    dataType:"json",
    success: function(album){
        document.getElementById('view-name').value = album.name;
        document.getElementById('view-country').value = album.country;
        document.getElementById('view-rating').value = album.rating;
        document.getElementById('view-publication').value = album.publication;
        var field = document.getElementById('artists-field');
        album.artists.forEach(function(obj) { 
            var input = document.createElement("input");
            input.setAttribute('name', 'artists');
            input.setAttribute('type', 'text');
            input.setAttribute('id', 'view-artists');
            input.setAttribute('class', 'readonly form-control-plaintext');
            input.setAttribute('readonly', 'true');
            input.setAttribute('value', obj.name);
            field.appendChild(input);
        });
        document.getElementById('view-genre').value = album.genre;
        document.getElementById('view-alt-genre').value = album.altGenre;
        document.getElementById('view-description').value = album.description;
    }
  });
}

function editAlbum(id) {
    $.ajax({
        url:"/admin/album",
        type:"POST",
        data:' {"type": "edit", "id": ' + id + '} ',
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function(album){
            document.getElementById('edit-name').value = album.name;
            document.getElementById('edit-country').value = album.country;
            document.getElementById('edit-rating').value = album.rating;
            document.getElementById('edit-publication').value = album.publication;
            var field = document.getElementById('artists-field');
            album.artists.forEach(function(obj) { 
                var input = document.createElement("input");
                input.setAttribute('name', 'artists');
                input.setAttribute('type', 'text');
                input.setAttribute('id', 'edit-artists');
                input.setAttribute('class', 'readonly form-control-plaintext');
                input.setAttribute('readonly', 'true');
                input.setAttribute('value', obj.name);
                field.appendChild(input);
            });
            document.getElementById('edit-genre').value = album.genre;
            document.getElementById('edit-alt-genre').value = album.altGenre;
            document.getElementById('edit-description').value = album.description;
        }
      });
    }