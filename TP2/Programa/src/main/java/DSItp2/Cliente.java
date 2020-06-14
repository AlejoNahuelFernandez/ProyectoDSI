
package DSItp2;

public class Cliente 
{
    private String NombreYApellido;
    private String empresa;
    private String domicilioDeObra;
    private String email;
    private String telefono;
    
    public Cliente (String NomYAp, String empresa, String domicilio, String email, String telefono)
    {
        this.NombreYApellido = NomYAp;
        this.domicilioDeObra = domicilio;
        this.email = email;
        this.empresa = empresa;
        this.telefono = telefono;
    }
    
    public String getNombre()
    {
        return NombreYApellido;
    }
    public String getEmpresa()
    {
        return empresa;
    }
            
}
