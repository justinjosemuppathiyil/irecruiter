//Form validation
function validateQualification(theForm) {
    var reason = "";
	reason += validateCoursename(theForm.courseName);
   	reason += validateSpecialization(theForm.specilization);
   	reason += validatePassyear(theForm.passYear);
	reason += validateInstitute(theForm.institute);
   	reason += validateGpa(theForm.gpa);

 	if(reason != "") {
    	alert(reason);
 		return false;
	}
 	return true;
}
 
function validatePassyear(passyear) {
    var error = "";
    //var illegalChars = /\W/; // allow letters, numbers, and underscores

    if (pass.value == "") {
        pass.style.background = 'Yellow';
        error = "You didn't enter year of pass out.\n";
    } 
	else if ((passyear.value.length != 4) ) {
        pass.style.background = 'Yellow';
        error = "The year must be 4 digits.\n";
    }
    return error;
}
function validateCoursename(fld) {
	   var error = "";
    if (fld.value == "") {
   		fld.style.background = 'Yellow';
        error = "You didn't enter your Course Name.\n";
    } 
	else {
        fld.style.background = 'White';
    }
    return error;
}
//Username check
function validateSpecialization(fld) {
    var error = "";

    if (fld.value == "") {
        fld.style.background = 'Yellow';
        error = "You didn't enter your Specialization.\n";
    } 
	else {
        fld.style.background = 'White';
    }
    return error;
}
function validateInstitute(fld) {
    var error = "";

    if (fld.value == "") {
        fld.style.background = 'Yellow';
        error = "You didn't enter your institute or university name.\n";
    } 
	else {
        fld.style.background = 'White';
    }
    return error;
}
function validateGpa(fld) {
    var error = "";

    if (fld.value == "") {
        fld.style.background = 'Yellow';
        error = "You didn't enter your GPA SCORE OR %.\n";
    } 
	else {
        fld.style.background = 'White';
    }
    return error;
}
  
function checkcourse()
{
	var error="";
	theForm=document.forms['SeekerQualificationForm'];
	var un=theForm.courseName;
	
	if(un.value=="")
	{	un.style.background = 'Yellow';

		alert("You didnt enter the Course Name.\n");
		}
	else
	{
		un.style.background = 'White';
	}
}

function checkpass()
{
	var error="";
	theForm=document.forms['SeekerQualificationForm'];
	var pass=theForm.passYear;
	
	if(pass.value=="")
	{
		pass.style.background = 'Yellow';
		alert("You didnt enter the year of passout\n");
	}
		else if ((pass.value.length != 4) ) {
        pass.style.background = 'Yellow';
        alert("The year must be 4 digits\n");
    }

	else
	{
		pass.style.background = 'White';
	}
}


function checkspecial()
{
	var error = "";
	theForm=document.forms['SeekerQualificationForm'];
	var fld=theForm.specilization;

	if (fld.value == "") 
	{
   		fld.style.background = 'Yellow';
        alert("You didn't enter your specialization.\n");
    } 
	else 
	{
        fld.style.background = 'White';
    }
}
function checksintitute()
{
	var error = "";
	theForm=document.forms['SeekerQualificationForm'];
	var fld=theForm.institute;

	if (fld.value == "") 
	{
   		fld.style.background = 'Yellow';
        alert("You didn't enter your Institute or University name.\n");
    } 
	else 
	{
        fld.style.background = 'White';
    }
}
function checkgpa()
{
	var error = "";
	theForm=document.forms['SeekerQualificationForm'];
	var fld=theForm.gpa;

	if (fld.value == "") 
	{
   		fld.style.background = 'Yellow';
        alert("You didn't enter your GPA or %.\n");
    } 
	else 
	{
        fld.style.background = 'White';
    }
}





