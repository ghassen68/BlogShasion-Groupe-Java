/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author Ghassen
 */
public class controle_mail {
    public static boolean emailisValid(String email)
{
	if( email!=null && email.trim().length()>0 )
		return email.matches("^[a-zA-Z0-9\\.\\-\\_]+@([a-zA-Z0-9\\-\\_\\.]+\\.)+([a-zA-Z]{2,4})$");
	return false;
}
    
}
