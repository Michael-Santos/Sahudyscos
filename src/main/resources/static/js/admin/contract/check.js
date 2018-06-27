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

    $('#edit-artist').autocomplete({
        serviceUrl: '/admin/contract/artist',
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
        appendTo: '#artist-group',
        onSelect: function (suggestion) {
            var input = document.getElementById('edit-artist-id');
            input.setAttribute('value', suggestion.data);
            //alert('You selected: ' + suggestion.value + ', ' + suggestion.data);
        }
     });

     $('#edit-label').autocomplete({
        serviceUrl: '/admin/contract/label',
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
    document.getElementById('edit-artist').style.backgroundColor = "white";
    document.getElementById('edit-artist').value = "";
    document.getElementById('edit-label').style.backgroundColor = "white";
    document.getElementById('edit-label').value = "";
}

function viewContract(artistId, labelId) {
    $.ajax({
        url:"/admin/contract",
        type:"POST",
        data:' {"type": "view", "artistId": ' + artistId  + ', "labelId": ' + labelId + '} ',
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function(contract){
            document.getElementById('view-artist').value = contract.artistName;
            document.getElementById('view-label').value = contract.labelName;
        }
    });
}

function editContract(artistId, labelId) {
    $.ajax({
        url:"/admin/contract",
        type:"POST",
        data:' {"type": "edit", "artistId": ' + artistId  + ', "labelId": ' + labelId + '} ',
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function(contract){
            document.getElementById('edit-artist-id').value = contract.artistId;
            document.getElementById('edit-label-id').value = contract.labelId;
            document.getElementById('edit-artist').value = contract.artistName;
            document.getElementById('edit-label').value = contract.labelName;
        }
    });
}

function deleteContract(artistId, labelId) {
    document.getElementById('delete-artist-id').value = artistId;
    document.getElementById('delete-label-id').value = labelId;
}