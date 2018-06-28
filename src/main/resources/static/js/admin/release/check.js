$(document).ready(function() {
                
    /*$('#mainForm').submit(function(event){
        cod_barras = document.getElementById('edit-id').value;
        album = document.getElementById('edit-album').value;
        label = document.getElementById('edit-label').value;
        format = document.getElementById('edit-format').value;
        type = document.getElementById('edit-type').value;
        price = document.getElementById('edit-price').value;
        amount_sold = document.getElementById('edit-amount-sold').value;
        amount_available = document.getElementById('edit-amount-available').value;
        sale = document.getElementById('edit-sale').value;
        release_date = document.getElementById('edit-release-date').value;

        if(cod_barras == "" || album == "" || label == "" || format == "" || type == "" || price == "" || amount_sold == "" || amount_available || sale == "" || release_date == "") {
            alert('Preencha todos os campos obrigatórios');
            if(cod_barras == ""){
                document.getElementById('edit-id').style.backgroundColor = "yellow";
            }
            if(album == ""){
                document.getElementById('edit-album').style.backgroundColor = "yellow";
            } 
            if(label == ""){
                document.getElementById('edit-label').style.backgroundColor = "yellow";
            }
            if(format == ""){
                document.getElementById('edit-format').style.backgroundColor = "yellow";
            }
            if(type == ""){
                document.getElementById('edit-type').style.backgroundColor = "yellow";
            }
            if(price == ""){
                document.getElementById('edit-price').style.backgroundColor = "yellow";
            }
            if(amount_sold == ""){
                document.getElementById('edit-amount-sold').style.backgroundColor = "yellow";
            }
            if(amount_available == ""){
                document.getElementById('edit-amount-available').style.backgroundColor = "yellow";
            }
            if(sale == ""){
                document.getElementById('edit-sale').style.backgroundColor = "yellow";
            }
            if(release_date == ""){
                document.getElementById('edit-release-date').style.backgroundColor = "yellow";
            }
            return false;
            event.preventDefault();
        }
        else {
            alert('Adição feita com sucesso!');
        }
    });*/

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
        url:"/admin/release",
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
    document.getElementById('delete-id').value = id;
    document.getElementById('delete-album-id').value = albumId;
}