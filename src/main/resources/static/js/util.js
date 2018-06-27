/*  Thanks milon
*   https://gist.github.com/milon/6ae8115219e0589b3fd2599c7a11dd5a
*/

var url = document.URL;
var hash = url.substring(url.indexOf('#'));
var searchData = {};

$( document ).ready(function() {
  $('#search-input').keypress(function(x) {
    if(x.which == 13) {
        dynamicSearch('/');
    }
  });
});

$(".nav-tabs").find("li a").each(function(key, val) {
    if (hash == $(val).attr('href')) {
        $(val).click();
    }

    $(val).click(function(ky, vl) {
        location.hash = $(this).attr('href');
    });
});

function changeAlbumCover(tag, mbid) {
    var reqUrl = "https://coverartarchive.org/release-group/" + mbid + "/front";
    $.ajax({
            url:reqUrl,
            type:"GET",
            statusCode: {
                200: function (response) {
                    tag.setAttribute("src", reqUrl);
                }
            }
    });
    // TODO Melhorar isso
    tag.setAttribute('onload', '');
}

function changeReleaseCover(tag, mbid) {
    var reqUrl = "https://coverartarchive.org/release/" + mbid + "/front";
    $.ajax({
            url:reqUrl,
            type:"GET",
            statusCode: {
                200: function (response) {
                    tag.setAttribute("src", reqUrl);
                }
            }
    });
    // TODO Melhorar isso
    tag.setAttribute('onload', '');
}

function hideCarousel(show = true) {
  if ($('#advertisement').is(":visible") && show) {
    $('#advertisement').toggle('slow', function() {
        // Animation complete.
    });
  }
}

function dynamicSearch(url) {
    hideCarousel();
    var table = document.getElementById('result');
    var spinner = document.createElement("img");
    table.innerHTML = '';
    spinner.setAttribute('src', '/img/animation/spinner.svg');
    table.appendChild(spinner);
    var searchInput = document.getElementById('search-input');
    searchData[$('#searchSel').find(":selected").attr('id')] = searchInput.value;
    $.ajax({
        type: "GET",
        beforeSend: function (request) {
            request.setRequestHeader("Update-Table", true);
        },
        dataType: "html",
        data: searchData,
        url: url,
        success: function (msg) {
            table.innerHTML = msg;
        }
    });
}

function dynamicUpdate(url) {
    var table = document.getElementById('result');
    var spinner = document.createElement("img");
    table.innerHTML = '';
    spinner.setAttribute('src', '/img/animation/spinner.svg');
    table.appendChild(spinner);
    $.ajax({
        type: "GET",
        beforeSend: function (request) {
            request.setRequestHeader("Update-Table", true);
        },
        dataType: "html",
        url: url,
        success: function (msg) {
            table.innerHTML = msg;
        }
    });
}

function dynamicFilter(url) {
    hideCarousel();
    var table = document.getElementById('result');
    var spinner = document.createElement("img");
    table.innerHTML = '';
    spinner.setAttribute('src', '/img/animation/spinner.svg');
    table.appendChild(spinner);
    $.ajax({
        type: "GET",
        beforeSend: function (request) {
            request.setRequestHeader("Update-Table", true);
        },
        data: searchData,
        dataType: "html",
        url: url,
        success: function (msg) {
            table.innerHTML = msg;
        }
    });
}

function updateFilter(value, field, url) {
	console.log(value);
	jQueryField = '#' + field;
	console.log($(jQueryField));
	$(jQueryField).toggle('slow', function() {
		var filter = document.createElement("div");
		filter.setAttribute("class", "input-group-append");
		filter.setAttribute("id", 'chosen-' + field);
		filter.innerHTML = value.innerHTML;

		var button = document.createElement("button");
		button.setAttribute('type', 'button');
    	button.setAttribute('class', 'btn btn-danger btn-sm mx-1');
    	button.setAttribute('onclick', 'clearFilter("' + field + '","' + value.getAttribute('id') + '","' + url + '")');
		button.innerHTML = "&times;";

		filter.appendChild(button);

    $(jQueryField).parent().append(filter);

    searchData[value.getAttribute('id')] = value.innerHTML;

    dynamicFilter(url);

    });
}

function clearFilter(field, id, url) {
  hideCarousel(true);

  jQueryField = '#' + field;

  var x = document.getElementById(field + '-item');
  x.removeChild(x.lastChild);

  $(jQueryField).toggle('slow', function() {

        delete searchData[id];

        dynamicFilter(url);

    });
}
