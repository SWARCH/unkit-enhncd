/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.businesslogic.controller;

import com.novell.ldap.LDAPAttribute;
import com.novell.ldap.LDAPAttributeSet;
import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author lorenags
 */
public class LoginLdapController implements Serializable {

    private static final long serialVersionUID = 1L;
    private LDAPConnection lc = new LDAPConnection();

    public String login(String user, String password) {

        System.out.println("ESTOY EN LOGIN LDAP CONTROLLER :D, user: " + user + ", password" + password);
        if (connect()) {
            if (validatePassword(user, password)) {
                return "Inicio de sesión satisfactorio.";
            } else {
                return "Usuario y/o contraseña incorrectos.";
            }
        } else {
            return "Conexión al servidor LDAP fallida.";
        }
    }

    public Boolean connect() {

        /*String ldapHost = "127.0.0.1";
        String dn = "cn=admin,dc=arqsoft,dc=unal,dc=edu,dc=co";
        String password = "Dulcinea985";*/
        
        String ldapHost = "192.168.2.10";
        String dn = "cn=admin,dc=arqsoft,dc=unal,dc=edu,dc=co";
        String password = "arqsoft20162";

        int ldapPort = LDAPConnection.DEFAULT_PORT;
        int ldapVersion = LDAPConnection.LDAP_V3;

        try {
            lc.connect(ldapHost, ldapPort);
            System.out.println("==== Conectado al servidor LDAP ====");
            lc.bind(ldapVersion, dn, password.getBytes("UTF8"));
            System.out.println("==== Autenticado en el servidor ====");
            return true;
        } catch (LDAPException | UnsupportedEncodingException ex) {
            System.out.println("==== ERROR al conectarse al servidor LDAP ====");
            return false;
        }

    }

    public Boolean validatePassword(String user, String password) {

        String dn = "cn=" + user + ",ou=Unkit,dc=arqsoft,dc=unal,dc=edu,dc=co";

        try {
            lc.bind(dn, password);

            System.out.println("==== Contraseña validada ====");
            return true;
        } catch (LDAPException ex) {
            System.out.println("==== ERROR al validar la contraseña ====");
            return false;
        }
    }

    public boolean createEmployeeLDAP(String userName, String password) {
        boolean isSuccesfull = false;

        LDAPConnection lc = new LDAPConnection();

        LDAPAttribute attribute = null;

        LDAPAttributeSet attributeSet = new LDAPAttributeSet();

        attributeSet.add(new LDAPAttribute("objectclass", new String("inetOrgPerson")));

        attributeSet.add(new LDAPAttribute("cn", new String[]{userName}));

        attributeSet.add(new LDAPAttribute("givenname", userName));

        attributeSet.add(new LDAPAttribute("sn", userName));

        attributeSet.add(new LDAPAttribute("userpassword", password));

        String dn = "cn=" + userName + ",ou=Unkit,dc=arqsoft,dc=unal,dc=edu,dc=co";

        LDAPEntry newEntry = new LDAPEntry(dn, attributeSet);

        try {

            String ldapHost = "192.168.2.10";
            String loginDN = "cn=admin,dc=arqsoft,dc=unal,dc=edu,dc=co";
            String passwordL = "arqsoft20162";

            int ldapPort = LDAPConnection.DEFAULT_PORT;
            int ldapVersion = LDAPConnection.LDAP_V3;

            lc.connect(ldapHost, ldapPort);

            lc.bind(ldapVersion, loginDN, passwordL);
            lc.add(newEntry);

            System.out.println("\nAdded object: " + dn + " successfully.");

            // disconnect with the server
            lc.disconnect();
            isSuccesfull = true;

        } catch (LDAPException e) {

            System.out.println("Error:  " + e.toString());
            isSuccesfull = false;
        }

        return isSuccesfull;
    }
}
