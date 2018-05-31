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
    document.getElementById('edit-album').style.backgroundColor = "white";
    document.getElementById('edit-album').value = "";
    document.getElementById('edit-label').style.backgroundColor = "white";
    document.getElementById('edit-label').value = "";
    document.getElementById('edit-format').style.backgroundColor = "white";
    document.getElementById('edit-format').value = "";
    document.getElementById('edit-type').style.backgroundColor = "white";
    document.getElementById('edit-type').value = "";
    document.getElementById('edit-price').style.backgroundColor = "white";
    document.getElementById('edit-price').value = "";
    document.getElementById('edit-amount-sold').style.backgroundColor = "white";
    document.getElementById('edit-amount-sold').value = "";
    document.getElementById('edit-amount-available').style.backgroundColor = "white";
    document.getElementById('edit-amount-available').value = "";
    document.getElementById('edit-sale').checked = false;
    document.getElementById('edit-release-date').style.backgroundColor = "white";
    document.getElementById('edit-release-date').value = "";
}

function viewRelease(id, albumId) {
    $.ajax({
        url:"/admin/release",
        type:"POST",
        data:' {"type": "view", "id": ' + id + ', "albumId": ' + albumId + '} ',
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function(release){
            document.getElementById('view-id').value = release.id;
            document.getElementById('view-album').value = release.album.name;
            document.getElementById('view-label').value = release.label.name;
            document.getElementById('view-format').value = release.format;
            document.getElementById('view-type').value = release.type;
            document.getElementById('view-price').value = release.price;
            document.getElementById('view-amount-sold').value = release.amountSold;
            document.getElementById('view-amount-available').value = release.amountAvailable;
            if (release.onSaleStatus == true) {
                document.getElementById('view-sale').checked = true;
            }
            document.getElementById('view-release-date').value = release.releaseDate;
        }
    });
}

function editRelease(id, albumId) {
    $.ajax({
        url:"/admin/label",
        type:"POST",
        data:' {"type": "edit", "id": ' + id + ', "albumId": ' + albumId + '} ',
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function(release){
            document.getElementById('edit-id').value = release.id;
            document.getElementById('edit-album').value = release.album.name;
            document.getElementById('edit-label').value = release.label.name;
            document.getElementById('edit-format').value = release.format;
            document.getElementById('edit-type').value = release.type;
            document.getElementById('edit-price').value = release.price;
            document.getElementById('edit-amount-sold').value = release.amountSold;
            document.getElementById('edit-amount-available').value = release.amountAvailable;
            if (release.onSaleStatus == true) {
                document.getElementById('edit-sale').checked = true;
            }
            document.getElementById('edit-release-date').value = release.releaseDate;
        }
    });
}

function deleteRelease(id, albumId) {
    document.getElementById('delete-id') = id;
    document.getElementById('delete-album-id') = albumId;
}