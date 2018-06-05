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