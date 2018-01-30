function validate() {
var number = /^[0-9]{10}$/;

if(!document.formName.phone.value.match(number)){
	alert("Phone Number Not Invalid");
	return false;
}

else
	return true;
}