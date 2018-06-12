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
    document.getElementById('edit-id').value = "";
    document.getElementById('edit-name').style.backgroundColor = "white";
    document.getElementById('edit-name').value = "";
    document.getElementById('edit-rating').style.backgroundColor = "white";
    document.getElementById('edit-rating').value = "";
    document.getElementById('edit-activity-start').style.backgroundColor = "white";
    document.getElementById('edit-activity-start').value = "";
    document.getElementById('edit-genre').style.backgroundColor = "white";
    document.getElementById('edit-genre').value = "";
    document.getElementById('edit-alt-genre').value = "";
    document.getElementById('edit-description').value = "";
}

function dynamicSearch() {
    $.ajax({
        type: "GET",
        beforeSend: function(request) {
            request.setRequestHeader("Search", true);
        },
        url: "/admin/artist",
        data: {name: "Pink Floyd"},
        success: function(msg) {
            document.getElementById('result').innerHTML = msg;
        }
    });
}

function viewArtist(id) {
    $.ajax({
        url:"/admin/artist",
        type:"POST",
        data:' {"type": "view", "id": ' + id + '} ',
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function(artist){
            document.getElementById('view-name').value = artist.name;
            document.getElementById('view-activity-start').value = artist.activityStart;
            document.getElementById('view-genre').value = artist.genre;
            document.getElementById('view-alt-genre').value = artist.altGenre;
            document.getElementById('view-description').value = artist.description;
        }
    });
}

function editArtist(id) {
    $.ajax({
        url:"/admin/artist",
        type:"POST",
        data:' {"type": "edit", "id": ' + id + '} ',
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function(artist){
            document.getElementById('edit-id').value = artist.id;
            document.getElementById('edit-name').value = artist.name;
            document.getElementById('edit-activity-start').value = artist.activityStart;
            document.getElementById('edit-genre').value = artist.genre;
            document.getElementById('edit-alt-genre').value = artist.altGenre;
            document.getElementById('edit-description').value = artist.description;
        }
    });
}