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
public class RegistroInscripciones implements Serializable
{
    public ArrayList<Inscripcion>Inscripciones=new ArrayList<>();
    
    public void MostrarInscripciones()
    {
        int pos = 1;
        for (Inscripcion inscripcion: Inscripciones)
        {
            System.out.println(pos + "- Alumno: " + inscripcion.getAlumno() + " Curso: " + inscripcion.getCurso());
            pos++;
        }
    }
}
