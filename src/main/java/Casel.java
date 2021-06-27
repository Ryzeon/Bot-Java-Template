import manager.StartCasel;

import javax.security.auth.login.LoginException;


/**
 * Project: Casel
 * Date: 06/02/2021 @ 22:53
 * Class: StartBot
 */
public class Casel {
    public static void main(String[] args) throws LoginException {
        //load start class
        StartCasel.INTANCE.startBot();
    }
}