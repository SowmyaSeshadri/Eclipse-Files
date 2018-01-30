function callRss(){
	var domain = event.target.value;
	alert("India");
	NewsRequest(domain);
}

var XMLHttpRequest = XMLHttpRequest;

function NewsRequest(domain){
    var request = new XMLHttpRequest();
    var url = 'AjaxRss'+"?domain="+domain;
    request.open('GET',url);
    request.onreadystatechange = function(){
        if(this.readyState == this.DONE && this.status ==200){
           parseTodoItems(this.responseText);
            } 
            else {
            	alert("Error");
            }
        };
    request.send();
}


function parseTodoItems(todoJSON){
    if(todoJSON == null || todoJSON.trim() == '')
        return;

    var todoArray = JSON.parse(todoJSON);
    if(todoArray.length == 0){
        return;
    }
    for(var i = 0;i<todoArray.length;i++){
        console.log("CAme inside for loop");
    }
}