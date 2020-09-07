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
public class RegistroAlumnos implements Serializable
{
    public ArrayList<Alumno>Alumnos=new ArrayList<>();
    
    public void MostrarAlumnos()
    {
        int pos=1;
        for (Alumno alumno: Alumnos)
        {
            System.out.println(pos + "-Nombre:" +alumno.getNombre() + " DNI:" +alumno.getDNI() + " Email:" +alumno.getEmail() + 
                    " Tel.:" +alumno.getTelefono());
            pos++;
        }
    }
}
