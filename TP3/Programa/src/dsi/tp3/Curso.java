/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi.tp3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Alejo Fernandez
 */
public class Curso implements Serializable
{
    private String nombre;
    private String descripcion;
    private String horario;
    private String fechasDictado;
    public ArrayList<Docente>docentes = new ArrayList();
    private String aula;
    private int cupoMinimo;
    private int cupoMaximo;
    private Calendar fechaLimiteInscripcion;
    private boolean estadoCurso;
    
    public Curso(String nombre, String descripcion)
    {
        this.nombre = nombre;
        this.descripcion=descripcion;
    }
    
    public void AgregarDocente(Docente docente)
    {
        docentes.add(docente);
    }
    
    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }
    
    public void setDescripcion(String descripcion)
    {
        this.descripcion=descripcion;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public String getDescripcion()
    {
        return descripcion;
    }
    
    public void setHorario(String horario)
    {
        this.horario=horario;
    }
    
    public void setFechasDictado(String fechas)
    {
        this.fechasDictado=fechas;
    }
    
    public void setAula(String aula)
    {
        this.aula=aula;
    }
    
    public void setCupoMinimo(int cupoMin)
    {
        this.cupoMinimo=cupoMin;
    }
    
    public void setCupoMaximo(int cupoMax)
    {
        this.cupoMaximo=cupoMax;
    }
    
    public void setFechaLimite(Calendar fecha)
    {
        this.fechaLimiteInscripcion=fecha;
    }
    
    public void setEstadoCurso(boolean estado)
    {
        this.estadoCurso=estado;
    }
    public void MostrarDocentes()
    {
        int pos = 1;
        System.out.println ("Docentes del curso: " +nombre + " " + descripcion);
        
        for (Docente docente: docentes)
        {
            System.out.println(pos + "-" +docente.getNombre() +" DNI: " +docente.getDNI());
            pos++;
        }
    }
    
    public String getHorario()
    {
        return horario;
    }
    
    public String getFechasDictado()
    {
        return fechasDictado;
    }
    
    public String getAula()
    {
        return aula;
    }
    
    public int getCupoMinimo()
    {
        return cupoMinimo;
    }
    
    public int getCupoMaximo()
    {
        return cupoMaximo;
    }
    
    public Calendar getFechaLimite()
    {
        return fechaLimiteInscripcion;
    }
    
    public boolean getEstadoCurso()
    {
        return estadoCurso;
    }
}
