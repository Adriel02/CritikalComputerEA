/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

/**
 *
 * @author Adriel
 */
public class unknownCommand extends Controller.controller{

    @Override
    public void process() {
        try {
            forward("/unknown.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(unknownCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(unknownCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
