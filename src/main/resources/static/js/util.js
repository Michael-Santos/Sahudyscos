/*  Thanks milon
*   https://gist.github.com/milon/6ae8115219e0589b3fd2599c7a11dd5a
*/

var url = document.URL;
var hash = url.substring(url.indexOf('#'));

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

function dynamicSearch(url) {
    var table = document.getElementById('result');
    var spinner = document.createElement("img");
    table.innerHTML = '';
    spinner.setAttribute('src', '/img/animation/spinner.svg');
    table.appendChild(spinner);
    var searchInput = document.getElementById('search-input');
    var searchData = ({[$('#searchSel').find(":selected").attr('id')]: searchInput.value})
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