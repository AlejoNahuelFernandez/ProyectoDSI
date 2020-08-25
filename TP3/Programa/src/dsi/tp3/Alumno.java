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
public class Alumno implements Serializable
{
    private String NombreYApellido;
    private int DNI;
    private String email;
    private String telefono;
    
    public Alumno(String nomYap,int dni,String email,String telefono)
    {
        this.NombreYApellido=nomYap;
        this.DNI=dni;
        this.email=email;
        this.telefono=telefono;
    }
    
    public String getNombre()
    {
        return NombreYApellido;
    }
    
    public int getDNI()
    {
        return DNI;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public String getTelefono()
    {
        return telefono;
    }
    
    public void setNombre(String nombre)
    {
        this.NombreYApellido=nombre;
    }
    
    public void setDNI(int dni)
    {
        this.DNI=dni;
    }
    
    public void setEmail(String email)
    {
        this.email=email;
    }
    
    public void setTelefono(String telefono)
    {
        this.telefono=telefono;
    }
}
