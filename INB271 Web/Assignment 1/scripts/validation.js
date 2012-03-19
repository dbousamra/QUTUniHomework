function validate_form ( )
{
    valid = true;

    if ( document.form.name.value == "" )
    {
        alert ( "Please fill in the 'Your Name' box." );
        valid = false;
		
    }
	
	else if ( ( document.form.password.value.length < 6 ))
        {
                alert ( "Your password must contain at least 6 characters" );
                valid = false;
        }
		
	else if ( ( !emailValidate(document.form.email.value) ))
        {
                alert ( "Your email must be valid" );
                valid = false;
        }
	
	else if ( ( document.form.equipment[0].checked == false ) && ( document.form.equipment[1].checked == false ) )
        {
                alert ( "Please tell us if you have a kart or not" );
                valid = false;
        }
	else if ( ( document.form.series[0].checked == false ) &&  ( document.form.series[1].checked == false ) && 
			( document.form.series[2].checked ==  false ) &&  ( document.form.series[3].checked == false ) ) 
		{
                alert ( "Please tick what series you would like to compete in" );
                valid = false;
        }

    return valid;
}


// Filthiest hack job of an email validation, but it's so simple I figured I'd use it :D
// Checks whether there's a period (.) after the 3rd char in a string, and for @ character 
// anywhere after first char
function emailValidate(str) {

   return (str.indexOf(".") > 2) && (str.indexOf("@") > 0);
 


}

