/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi.tp3;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Alejo Fernandez
 */
public class RegistroDocentes implements Serializable
{
    public ArrayList<Docente>Docentes=new ArrayList<>();
    
    public void MostrarDocentes()
    {
        int pos=1;
        for (Docente docente: Docentes)
        {
            System.out.println(pos + "-" +docente.getNombre() +" DNI: " +docente.getDNI());
            //+ " Email:" +docente.getEmail()+ 
                    //" Tel.:" + docente.getTelefono());
            pos++;
        }
    }
}
