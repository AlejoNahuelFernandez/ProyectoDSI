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
public class RegistroCursos implements Serializable
{
    public ArrayList<Curso>Cursos=new ArrayList<>();
    
    public void MostrarCursos()
    {
        int pos=1;
        for (Curso curso: Cursos)
        {
            
            System.out.println(pos + "-" + curso.getNombre() + " " + curso.getDescripcion());
            pos++;
            //curso.MostrarDocentes();
        }
    }
}
