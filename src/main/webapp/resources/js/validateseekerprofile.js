//Form validation
function validateSeekerProfile(theForm) {
    var reason = "";
 	//var em=theForm.emailf;
    //document.write("Entered emai"+em);
	reason += validateDistrict(theForm.seekerDistrict);
	reason += validateName(theForm.seekerName);
	reason += validateAddress(theForm.seekerAddress);

	reason += validateStreet(theForm.seekerStreet);
	reason += validateState(theForm.seekerState);
	reason += validateCountry(theForm.seekerCountry);
   	reason += validatePin(theForm.seekerPIN);
	reason += validateWebsiteaddr(theForm.websiteaddr);
   	reason += validateEmail1(theForm.seekerEmail1);
	reason += validateEmail2(theForm.seekerEmail2);
   	reason += validatePhone1(theForm.seekerPhone1 );
	reason += validatePhone1(theForm.seekerPhone2 );

 	if(reason != "") {
    	alert(reason);
 		return false;
	}
 	return true;
}
 //first name
 function validateName(fld) {
	   var error = "";

    if (fld.value == "") {
   		fld.style.background = 'Yellow';
        error = "You didn't enter company name.\n";
    }
	else {
        fld.style.background = 'White';
    }
    return error;
}
function validateStreet(fld) {
	   var error = "";
    if (fld.value == "") {
   		fld.style.background = 'Yellow';
        error = "You didn't enter Street.\n";
    } 
	else {
        fld.style.background = 'White';
    }
    return error;
}
//State
function validateState(fld) {
	   var error = "";
    if (fld.value == "") {
   		fld.style.background = 'Yellow';
        error = "You didn't enter  state.\n";
    } 
	else {
        fld.style.background = 'White';
    }
    return error;
}

//Country
function validateCountry(fld) {
	   var error = "";
    if (fld.value == "") {
   		fld.style.background = 'Yellow';
        error = "You didn't enter country.\n";
    } 
	else {
        fld.style.background = 'White';
    }
    return error;
}
function validateDistrict(fld) {
	   var error = "";
    if (fld.value == "") {
   		fld.style.background = 'Yellow';
        error = "You didn't enter district.\n";
    } 
	else {
        fld.style.background = 'White';
    }
    return error;
}
function validateAddress(fld) {
	   var error = "";
    if (fld.value == "") {
   		fld.style.background = 'Yellow';
        error = "You didn't enter address.\n";
    } 
	else {
        fld.style.background = 'White';
    }
    return error;
}
function validatePin(fld) {
	   var error = "";
    if (fld.value == "") {
   		fld.style.background = 'Yellow';
        error = "You didn't enter pin.\n";
    } 
	else {
        fld.style.background = 'White';
    }
    return error;
}
 function validateWebsiteaddr(fld) {
	   var error = "";
    if (fld.value == "") {
   		fld.style.background = 'Yellow';
        error = "You didn't enter website.\n";
    } 
	else {
        fld.style.background = 'White';
    }
    return error;
}
//Email check
function trim(s)
{
   	return s.replace(/^\s+|\s+$/, '');
}

 
function validateEmail1(fld) {
    var error="";
    var tfld = trim(fld.value);                        // value of field with whitespace trimmed off
    var emailFilter = /^[^@]+@[^@.]+\.[^@]*\w\w$/ ;
    var illegalChars= /[\(\)\<\>\,\;\:\\\"\[\]]/ ;

    if (fld.value == "") {
        fld.style.background = 'Yellow';
        error = "You didn't enter an email address.\n";
    } 
	else if (!emailFilter.test(tfld)) {              //test email for illegal characters
        fld.style.background = 'Yellow';
        error = "Please enter a valid email address.\n";
    } 
	else if (fld.value.match(illegalChars)) {
        fld.style.background = 'Yellow';
        error = "The email address contains illegal characters.\n";
    } 
	else {
        fld.style.background = 'White';
    }
    return error;
}
function validateEmail2(fld) {
    var error="";
    var tfld = trim(fld.value);                        // value of field with whitespace trimmed off
    var emailFilter = /^[^@]+@[^@.]+\.[^@]*\w\w$/ ;
    var illegalChars= /[\(\)\<\>\,\;\:\\\"\[\]]/ ;

	if (!emailFilter.test(tfld)) {              //test email for illegal characters
        fld.style.background = 'Yellow';
        error = "Please enter a valid email address.\n";
    } 
	else if (fld.value.match(illegalChars)) {
        fld.style.background = 'Yellow';
        error = "The email address contains illegal characters.\n";
    } 
	else {
        fld.style.background = 'White';
    }
    return error;
}

//Phone nnmber check
function validatePhone1(fld) {
    var error = "";
    var stripped = fld.value;

   if (fld.value == "") {
        error = "You didn't enter a phone number.\n";
        fld.style.background = 'Yellow';
    } 
	else if (isNaN(parseInt(stripped))) {
        error = "The phone number contains illegal characters.\n";
        fld.style.background = 'Yellow';
    } 
	else if (!(stripped.length == 10)) {
        error = "The phone number is the wrong length.Must be 10 digits. \n";
        fld.style.background = 'Yellow';
    }
    return error;
}
function validatePhone2(fld) {
    var error = "";
    var stripped = fld.value;
	if (isNaN(parseInt(stripped))) {
        error = "The phone number contains illegal characters.\n";
        fld.style.background = 'Yellow';
    } 
	else if (!(stripped.length == 10)) {
        error = "The phone number is the wrong length.Must be 10 digits. \n";
        fld.style.background = 'Yellow';
    }
    return error;
}

function checkname()
{
	var error="";
	theForm=document.forms['manageSeekerForm'];
	var fn=theForm.seekerName;
	
	if(fn.value=="")
	{	fn.style.background = 'Yellow';

		alert("You didnt enter name.\n");
		}
	else
	{
		fn.style.background = 'White';
	}
}
function checkstreet()
{
	var error = "";
	theForm=document.forms['manageSeekerForm'];
	var fld=theForm.seekerStreet;

	if (fld.value == "") 
	{
   		fld.style.background = 'Yellow';
        alert("You didn't enter your street.\n");
    } 
	else 
	{
        fld.style.background = 'White';
    }
}

function checkstate()
{
	var error = "";
	theForm=document.forms['manageSeekerForm'];
	var fld=theForm.seekerState;

	if (fld.value == "") 
	{
   		fld.style.background = 'Yellow';
        alert("You didn't enter state.\n");
    } 
	else 
	{
        fld.style.background = 'White';
    }
}

function checkcountry()
{
	var error = "";
	theForm=document.forms['manageSeekerForm'];
	var fld=theForm.seekerCountry;

	if (fld.value == "") 
	{
   		fld.style.background = 'Yellow';
        alert("You didn't enter country.\n");
    } 
	else 
	{
        fld.style.background = 'White';
    }
}

function checkaddress()
{
	var error = "";
	theForm=document.forms['manageSeekerForm'];
	var fld=theForm.seekerAddress;

	if (fld.value == "") 
	{
   		fld.style.background = 'Yellow';
        alert("You didn't enter address.\n");
    } 
	else 
	{
        fld.style.background = 'White';
    }
}
function checkdistrict()
{
	var error = "";
	theForm=document.forms['manageSeekerForm'];
	var fld=theForm.seekerDistrict;

	if (fld.value == "") 
	{
   		fld.style.background = 'Yellow';
        alert("You didn't enter district.\n");
    } 
	else 
	{
        fld.style.background = 'White';
    }
}
function checkwebsiteaddr()
{
	var error = "";
	theForm=document.forms['manageSeekerForm'];
	var fld=theForm.websiteaddr;

	if (fld.value == "") 
	{
   		fld.style.background = 'Yellow';
        alert("You didn't enter website.\n");
    } 
	else 
	{
        fld.style.background = 'White';
    }
}
function checkpin()
{
	var error = "";
	theForm=document.forms['manageSeekerForm'];
	var fld=theForm.seekerPIN;

	if (fld.value == "") 
	{
   		fld.style.background = 'Yellow';
        alert("You didn't enter pin.\n");
    } 
	else 
	{
        fld.style.background = 'White';
    }
}

function checkemail1()
{
	var error="";
	theForm=document.forms['manageSeekerForm'];
	var fld=theForm.seekerEmail1;

    var tfld = trim(fld.value);                        // value of field with whitespace trimmed off
    var emailFilter = /^[^@]+@[^@.]+\.[^@]*\w\w$/ ;
    var illegalChars= /[\(\)\<\>\,\;\:\\\"\[\]]/ ;

    if (fld.value == "") {
        fld.style.background = 'Yellow';
        error = "You didn't enter an email address.\n";
    } 
	else if (!emailFilter.test(tfld)) {              //test email for illegal characters
        fld.style.background = 'Yellow';
        error = "Please enter a valid email address.\n";
    } 
	else if (fld.value.match(illegalChars)) {
        fld.style.background = 'Yellow';
        error = "The email address contains illegal characters.\n";
    }
	if(error!="")
	{
		alert(error);
	}
	else 
	{
        fld.style.background = 'White';
    }
}
function checkemail2()
{
	var error="";
	theForm=document.forms['manageSeekerForm'];
	var fld=theForm.seekerEmail2;

    var tfld = trim(fld.value);                        // value of field with whitespace trimmed off
    var emailFilter = /^[^@]+@[^@.]+\.[^@]*\w\w$/ ;
    var illegalChars= /[\(\)\<\>\,\;\:\\\"\[\]]/ ;
	
	if (!emailFilter.test(tfld)) {              //test email for illegal characters
        fld.style.background = 'Yellow';
        error = "Please enter a valid email address.\n";
    } 
	else if (fld.value.match(illegalChars)) {
        fld.style.background = 'Yellow';
        error = "The email address contains illegal characters.\n";
    }
	if(error!="")
	{
		alert(error);
	}
	else 
	{
        fld.style.background = 'White';
    }
}

function checkphone1()
{
	var error = "";
	theForm=document.forms['manageSeekerForm'];
	var fld=theForm.seekerPhone1;

    var stripped = fld.value;

   	if (fld.value == "") 
	{
        error = "You didn't enter a phone number.\n";
        fld.style.background = 'Yellow';
    } 
	else if (isNaN(parseInt(stripped))) 
	{
        error = "The phone number contains illegal characters.\n";
        fld.style.background = 'Yellow';
    } 
	else if (!(stripped.length == 10)) 
	{
        error = "The phone number is the wrong length.Must be 10 digits. \n";
        fld.style.background = 'Yellow';
    }
	if(error!="")
	{
		alert(error);
	}
	else
	{
		fld.style.background = 'White';
	}
}
function checkphone2()
{
	var error = "";
	theForm=document.forms['manageSeekerForm'];
	var fld=theForm.seekerPhone2;

    var stripped = fld.value;
	if (isNaN(parseInt(stripped))) 
	{
        error = "The phone number contains illegal characters.\n";
        fld.style.background = 'Yellow';
    } 
	else if (!(stripped.length == 10)) 
	{
        error = "The phone number is the wrong length.Must be 10 digits. \n";
        fld.style.background = 'Yellow';
    }
	if(error!="")
	{
		alert(error);
	}
	else
	{
		fld.style.background = 'White';
	}
}


 
