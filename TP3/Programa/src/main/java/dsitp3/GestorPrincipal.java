
package dsitp3;
import java.util.Scanner;

public class GestorPrincipal 
{
    public static void main (String[]args)
    {
        RegistroDocentes registroDocentes = new RegistroDocentes();
        RegistroCursos registroCursos = new RegistroCursos();
        RegistroAlumnos registroAlumnos = new RegistroAlumnos();
        
        int opcion;
        do
        {
            Scanner entrada = new Scanner(System.in);
            System.out.println("Ingrese opción: \n1-Agregar curso \n2-Planificar curso \n3-Asignar docente \n4-Registrar inscripción \n5-Salir");
            opcion = entrada.nextInt();
            
            switch (opcion)
            {
                case 1:
                    AgregarCurso();
                    break;
                    
                case 2:
                    PlanificarCurso();
                    break;
                    
                case 3:
                    AsignarDocente();
                    break;
                    
                case 4:
                    RegistrarInscripcion();
                    break;
            }
        } while(opcion!=5);
        
        RegistroInscripciones.MostrarInscripciones();
    }
    
    public static void AgregarCurso()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Nombre del curso: ");
        String nombre = input.nextLine();
        System.out.println("Descripción: ");
        String descripcion = input.nextLine();
        RegistroDocentes.MostrarDocentes();
        System.out.println("Seleccione docente");
        int opc = input.nextInt();
        int posicion = opc - 1;
        Docente docente = RegistroDocentes.Docentes.get(posicion);
        Curso curso = new Curso(nombre,descripcion);
        curso.AgregarDocente(docente);
        RegistroCursos.Cursos.add(curso);
    }
    
    public static void PlanificarCurso()
    {
        Scanner entrada = new Scanner(System.in);
        RegistroCursos.MostrarCursos();
        System.out.println("Elija un curso: ");
        int opc1=entrada.nextInt();
        int pos=opc1 - 1;
        Curso curso = RegistroCursos.Cursos.get(pos);
        
        System.out.println("Horario: ");
        String horario;
        entrada.nextLine();
        horario = entrada.nextLine();
        curso.setHorario(horario);
        
        System.out.println ("Fechas de dictado: ");
        String fechasDictado;
        fechasDictado = entrada.nextLine();
        curso.setFechasDictado(fechasDictado);
        
        if (curso.docentes.isEmpty())
        {
            RegistroDocentes.MostrarDocentes();
            System.out.println ("Seleccione docente:");
            int opcion = entrada.nextInt();
            int posicion = opcion - 1;
            Docente docente = RegistroDocentes.Docentes.get(posicion);
            curso.AgregarDocente(docente);
        }
        
        System.out.println("Aula: ");
        String aula;
        entrada.nextLine();
        aula = entrada.nextLine();
        curso.setAula(aula);
        
        System.out.println("Cupo mínimo de alumnos: ");
        int cupoMinimo=entrada.nextInt();
        curso.setCupoMinimo(cupoMinimo);
        
        System.out.println("Cupo máximo de alumnos: ");
        int cupoMaximo = entrada.nextInt();
        curso.setCupoMaximo(cupoMaximo);
        
        System.out.println("Ingresar fecha límite de inscripción (dd/mm/aaaa): ");
        String fechaLimite;
        fechaLimite = entrada.next();
        curso.setFechaLimite(fechaLimite);
        
        curso.setEstadoCurso(true);
    }
    
    public static void AsignarDocente()
    {
        Scanner entrada = new Scanner(System.in);
        RegistroDocentes.MostrarDocentes();
        System.out.println ("Seleccione docente: ");
        int opcion = entrada.nextInt();
        int posicion = opcion - 1;
        Docente docente = RegistroDocentes.Docentes.get(posicion);
        
        RegistroCursos.MostrarCursos();
        System.out.println("Elija curso: ");
        int opc = entrada.nextInt();
        int pos = opc - 1;
        Curso curso = RegistroCursos.Cursos.get(pos);
        
        curso.AgregarDocente(docente);
        curso.MostrarDocentes();
    }
    
    public static void RegistrarInscripcion()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿Alumno registrado? \n1-Sí \n2-No");
        int opcion = entrada.nextInt();
        
        if (opcion == 2)
        {
            System.out.println("Nombre y apellido: ");
            String nombreYap;
            entrada.nextLine();
            nombreYap = entrada.nextLine();
        
            System.out.println("DNI: ");
            int dni = entrada.nextInt();
        
            System.out.println("Email: ");
            String email = entrada.next();
        
            System.out.println("Teléfono: ");
            String telefono = entrada.next();
        
            Alumno alumno = new Alumno (nombreYap,dni,email,telefono);
            RegistroAlumnos.Alumnos.add(alumno);
        }
        
        RegistroAlumnos.MostrarAlumnos();
        System.out.println("Seleccione alumno: ");
        int seleccion = entrada.nextInt();
        int posicion = seleccion - 1;
        Alumno alumno = RegistroAlumnos.Alumnos.get(posicion);
        
        RegistroCursos.MostrarCursos();
        System.out.println("Seleccionar curso: ");
        int opc = entrada.nextInt();
        int pos = opc - 1;
        Curso curso = RegistroCursos.Cursos.get(pos);
        
        Inscripcion inscripcion = new Inscripcion(alumno,curso);
        RegistroInscripciones.Inscripciones.add(inscripcion);
    }
    
}
