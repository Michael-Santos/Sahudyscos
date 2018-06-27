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
    document.getElementById('edit-name').style.backgroundColor = "white";
    document.getElementById('edit-name').value = "";
    document.getElementById('edit-activity-start').style.backgroundColor = "white";
    document.getElementById('edit-activity-start').value = "";
    document.getElementById('edit-genre').style.backgroundColor = "white";
    document.getElementById('edit-genre').value = "";
    document.getElementById('edit-alt-genre').value = "";
    document.getElementById('edit-email').value = "";
    document.getElementById('edit-phone').value = "";
    document.getElementById('edit-alt-phone').value = "";
}

function viewLabel(id) {
    $.ajax({
        url:"/admin/label",
        type:"POST",
        data:' {"type": "view", "id": ' + id + '} ',
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function(label){
            document.getElementById('view-name').value = label.name;
            document.getElementById('view-activity-start').value = label.activityStart;
            document.getElementById('view-genre').value = label.genre;
            document.getElementById('view-alt-genre').value = label.altGenre;
            document.getElementById('view-phone').value = label.phone;
            document.getElementById('view-alt-phone').value = label.altPhone;
        }
    });
}

function editLabel(id) {
    $.ajax({
        url:"/admin/label",
        type:"POST",
        data:' {"type": "edit", "id": ' + id + '} ',
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function(label){
            document.getElementById('edit-id').value = label.id;
            document.getElementById('edit-name').value = label.name;
            document.getElementById('edit-activity-start').value = label.activityStart;
            document.getElementById('edit-genre').value = label.genre;
            document.getElementById('edit-alt-genre').value = label.altGenre;
            document.getElementById('edit-phone').value = label.phone;
            document.getElementById('edit-alt-phone').value = label.altPhone;
        }
    });
}

function deleteLabel(id) {
    document.getElementById('delete-label-id').value = id;
}