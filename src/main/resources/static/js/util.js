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
    
    $('[data-toggle="popover"]').popover();
    
    $("#sidebar").mCustomScrollbar({
        theme: "minimal"
    });

    $('#dismiss, .overlay').on('click', function () {
        // hide sidebar
        $('#sidebar').removeClass('active');
        // hide overlay
        $('.overlay').removeClass('active');
    });

    $('#sidebarCollapse').on('click', function () {
        // open sidebar
        $('#sidebar').addClass('active');
        // fade in the overlay
        $('.overlay').addClass('active');
        $('.collapse.in').toggleClass('in');
        $('a[aria-expanded=true]').attr('aria-expanded', 'false');
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

function changeArtistImage(tag, mbid) {
    var reqUrl = "http://musicbrainz.org/ws/2/artist/" + mbid;
    $.ajax({
            url:reqUrl,
            data:{
                inc: "url-rels",
                fmt: "json"
            },
            type:"GET",
            dataType:"json",
            statusCode: {
                200: function (response) {
                    console.log(response);
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

function dynamicSearch(url, add = true) {
    hideCarousel();
    var table = document.getElementById('result');
    var spinner = document.createElement("img");
    table.innerHTML = '';
    spinner.setAttribute('src', '/img/animation/spinner.svg');
    table.appendChild(spinner);
    var searchInput = document.getElementById('search-input');
    if (searchInput != '') {
        searchData[$('#searchSel').find(":selected").attr('id')] = searchInput.value;
    }
    if (add == false) {
        searchData = {};
        searchData[$('#searchSel').find(":selected").attr('id')] = searchInput.value;
    }
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
            $('[data-toggle="popover"]').popover();
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
            $('[data-toggle="popover"]').popover();
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
            $('[data-toggle="popover"]').popover();
        }
    });
}

function updateFilter(chosen_value, field, url) {
	jQueryField = '#' + field;
	$(jQueryField).toggle('slow', function() {
		var filter = document.createElement("div");
		filter.setAttribute("class", "list-group-item active");
		filter.setAttribute("id", 'chosen-' + field);
        filter.innerHTML = chosen_value.innerHTML;

		var button = document.createElement("button");
		button.setAttribute('type', 'button');
    	button.setAttribute('class', 'btn btn-danger btn-sm mx-1 float-right');
    	button.setAttribute('onclick', 'clearFilter("' + field + '","' + field + '","' + url + '")');

        var icon = document.createElement("i");
        icon.setAttribute('class', 'fas fa-times');

        button.appendChild(icon);

		filter.appendChild(button);

    $(jQueryField + '-menu').parent().append(filter);

    searchData[field.replace('_', '.')] = chosen_value.getAttribute('value').replace('*',',');

    dynamicFilter(url);

    });
}

function clearFilter(field, id, url) {
  hideCarousel(true);

  jQueryField = '#' + field;

  var x = document.getElementById(field + '-item');
  x.removeChild(x.lastChild);

  $(jQueryField).toggle('slow', function() {

        delete searchData[id.replace('_', '.')];

        dynamicFilter(url);

    });
}