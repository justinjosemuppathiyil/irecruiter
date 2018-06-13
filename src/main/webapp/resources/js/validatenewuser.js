//Form validation
function validateNewUser(theForm) {
    var reason = "";
	reason += validateRole(theForm.role);
   	reason += validateUsername(theForm.username);
   	reason += validatePass(theForm.password);

 	if(reason != "") {
    	alert(reason);
 		return false;
	}
 	return true;
}
 
function validatePass(pass) {
    var error = "";
    //var illegalChars = /\W/; // allow letters, numbers, and underscores

    if (pass.value == "") {
        pass.style.background = 'Yellow';
        error = "You didn't enter your password.\n";
    } 
	else if ((pass.value.length < 3) ) {
        pass.style.background = 'Yellow';
        error = "The password must be min 3 character long.\n";
    }
    return error;
}
function validateRole(fld) {
	   var error = "";
    if (fld.value == "") {
   		fld.style.background = 'Yellow';
        error = "You didn't enter your role.\n";
    } 
	else {
        fld.style.background = 'White';
    }
    return error;
}
//Username check
function validateUsername(fld) {
    var error = "";

    if (fld.value == "") {
        fld.style.background = 'Yellow';
        error = "You didn't enter your User Name.\n";
    } 
	else if (!(fld.value.length > 3) ) {
		  fld.style.background = 'Yellow';
        error = "The username must conatin more than 3 characters.\n";
    } 
	else {
        fld.style.background = 'White';
    }
    return error;
}
  
function checkuname()
{
	var error="";
	theForm=document.forms['f'];
	var un=theForm.username;
	
	if(un.value=="")
	{	un.style.background = 'Yellow';

		alert("You didnt enter the username.\n");
		}
		else if (!(fn.value.length > 3) ) {
		  fn.style.background = 'Yellow';
        alert( "The username must conatin more than 3 characters.\n");
    } 
	else
	{
		un.style.background = 'White';
	}
}

function checkpass()
{
	var error="";
	theForm=document.forms['registrationForm'];
	var pass=theForm.password;
	
	if(pass.value=="")
	{
		pass.style.background = 'Yellow';
		alert("You didnt enter the password.\n");
	}
		else if ((pass.value.length < 3) ) {
        pass.style.background = 'Yellow';
        alert("The password must be min 3 character long.\n");
    }

	else
	{
		pass.style.background = 'White';
	}
}


function checkRole()
{
	var error = "";
	theForm=document.forms['registrationForm'];
	var fld=theForm.role;

	if (fld.value == "") 
	{
   		fld.style.background = 'Yellow';
        alert("You didn't enter your role.\n");
    } 
	else 
	{
        fld.style.background = 'White';
    }
}





