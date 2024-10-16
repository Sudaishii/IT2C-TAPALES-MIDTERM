package NurseApp;

import static NurseApp.config.connectDB;
import nurse.nurse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC5
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        config cfg = new config();
        nurse nrs = new nurse();
        
        nrs.Nurse();
        
    }
    
}
