/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi.tp3;

import java.io.Serializable;

/**
 *
 * @author Alejo Fernandez
 */
public class Inscripcion implements Serializable
{
    private Alumno alumno;
    private Curso curso;
    
    public Inscripcion(Alumno alumno, Curso curso)
    {
        this.alumno=alumno;
        this.curso=curso;
    }
    
    public String getAlumno()
    {
        return alumno.getNombre();
    }
    
    public String getCurso()
    {
        return curso.getNombre() + " " + curso.getDescripcion();
    }
    
    public void setAlumno(Alumno alumno)
    {
        this.alumno=alumno;
    }
    
    public void setCurso(Curso curso)
    {
        this.curso=curso;
    }
    
}
