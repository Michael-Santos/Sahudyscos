/*$(document).ready(function() {
    $.getJSON('paises.json', function (data) {
        var items = [];
        var options = '<option value="">Por favor, selecione um país</option>';
        $.each(data, function (key, val) {
            options += '<option value="' + val.name + '">' + val.name + '</option>';
        });
        $("#dropDownPaises").html(options);
    });
});*/

$(document).ready(function() {
                
    $('#mainForm').submit(function(event){
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
            event.preventDefault();
            return false;
        }
        else {
            alert('Adição feita com sucesso!');
        }
    });
});

function limparTudo(){
    document.getElementById('edit-id').value = "";
    document.getElementById('edit-name').style.backgroundColor = "white";
    document.getElementById('edit-name').value = "";
    document.getElementById('edit-rating').style.backgroundColor = "white";
    document.getElementById('edit-rating').value = "";
    document.getElementById('edit-country').style.backgroundColor = "white";
    document.getElementById('edit-country').value = "";
    document.getElementById('edit-publication').style.backgroundColor = "white";
    document.getElementById('edit-publication').value = "";
    var field = document.getElementById('edit-artists-group');
    while (field.childElementCount != 1) {
        field.removeChild(field.lastChild);
    }
    var input = document.createElement("input");
    var hiddenField = document.createElement("input");
    input.setAttribute('type', 'text');
    counter = 0;
    input.setAttribute('id', 'edit-artist-' + counter);
    input.setAttribute('class', 'form-control');
    hiddenField.setAttribute('type', 'hidden');
    hiddenField.setAttribute('id', 'edit-artist-id-' + counter);
    hiddenField.setAttribute('name', 'artistsIds');
    //hiddenField.setAttribute('th:field', '*{artists[' + counter + '].id}');
    field.appendChild(input);
    field.appendChild(hiddenField);
    artistAutocomplete(counter);
    counter++;
    document.getElementById('edit-genre').style.backgroundColor = "white";
    document.getElementById('edit-genre').value = "";
    document.getElementById('edit-alt-genre').value = "";
    document.getElementById('edit-description').value = "";
}


function viewAlbum(id) {
    var artists = document.getElementById('artists-field');
    while (artists.childElementCount != 1) {
        artists.removeChild(artists.lastChild);
    }
    $.ajax({
        url:"/admin/album",
        type:"POST",
        data:' {"type": "view", "id": ' + id + '} ',
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function(album){
            document.getElementById('view-name').value = album.name;
            document.getElementById('view-country').value = album.country;
            document.getElementById('view-rating').value = album.rating.toFixed(2);
            document.getElementById('view-publication').value = album.publication;
            var field = document.getElementById('artists-field');
            album.artists.forEach(function(obj) { 
                var input = document.createElement("input");
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

counter = 1;
function editAlbum(id) {
    var field = document.getElementById('edit-artists-group');
    while (field.childElementCount != 1) {
        field.removeChild(field.lastChild);
    }
    $.ajax({
        url:"/admin/album",
        type:"POST",
        data:' {"type": "edit", "id": ' + id + '} ',
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function(album){
            document.getElementById('edit-id').value = album.id;
            document.getElementById('edit-name').value = album.name;
            document.getElementById('edit-country').value = album.country;
            document.getElementById('edit-rating').value = album.rating.toFixed(2);
            document.getElementById('edit-publication').value = album.publication;
            counter = 0;
            album.artists.forEach(function(obj) { 
                addArtist(obj);
            });
            document.getElementById('edit-genre').value = album.genre;
            document.getElementById('edit-alt-genre').value = album.altGenre;
            document.getElementById('edit-description').value = album.description;
        }
    });
}

function deleteAlbum(albumId) {
    document.getElementById('delete-album-id').value = albumId;
}

function addArtist(obj = null) {
    var group = document.getElementById('edit-artists-group');
    var div = document.createElement("div");
    var input = document.createElement("input");
    var button = document.createElement("button");
    var hiddenField = document.createElement("input");

    div.setAttribute('class', 'input-group-append my-2');
    div.setAttribute('id', 'artist-' + counter);

    input.setAttribute('type', 'text');
    input.setAttribute('class', 'form-control');
    input.setAttribute('id', 'edit-artist-' + counter);
    if (obj != null) {
        input.setAttribute('value', obj.name);
    }

    button.setAttribute('type', 'button');
    button.setAttribute('class', 'btn btn-danger btn-sm mx-1');
    button.setAttribute('onclick', 'removeArtist(' + counter + ')');
    button.innerHTML = "Remover Banda";

    hiddenField.setAttribute('type', 'hidden');
    hiddenField.setAttribute('id', 'edit-artist-id-' + counter);
    hiddenField.setAttribute('name', 'artistsIds');
    if (obj != null) {
        hiddenField.setAttribute('value', obj.id);
    }
    //hiddenField.setAttribute('th:field', '*{artists[' + counter + '].id}');

    div.appendChild(input);
    div.appendChild(hiddenField);
    div.appendChild(button);
    group.appendChild(div);

    artistAutocomplete(counter);

    counter++;
    
}

function removeArtist(i) {
    var group = document.getElementById('edit-artists-group');
    var div = document.getElementById('artist-' + i);
    group.removeChild(div);
    counter--;
}

function artistAutocomplete(i) {
    $('#edit-artist-' + i).autocomplete({
        serviceUrl: '/admin/album/artist',
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
        appendTo: '#edit-artists-group',
        onSelect: function (suggestion) {
            var field = document.getElementById('edit-artist-' + i);
            field.setAttribute('text', suggestion.value);
            var hiddenField = document.getElementById('edit-artist-id-' + i)
            hiddenField.setAttribute('value', suggestion.data);
            var test = document.getElementById('mainForm');
            test.appendChild(hiddenField);
            //alert('You selected: ' + suggestion.value + ', ' + suggestion.data);
        }
     });
}