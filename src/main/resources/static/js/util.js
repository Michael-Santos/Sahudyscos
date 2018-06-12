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