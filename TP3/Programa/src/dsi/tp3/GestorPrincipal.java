/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi.tp3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Alejo Fernandez
 */
public class GestorPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        RegistroDocentes registroDocentes = new RegistroDocentes();
        RegistroCursos registroCursos = new RegistroCursos();
        RegistroAlumnos registroAlumnos = new RegistroAlumnos();
        RegistroInscripciones registroInscripciones = new RegistroInscripciones();
        
        registroAlumnos=ObtenerDatosAlumnos();
        Alumno alumno = registroAlumnos.Alumnos.get(0);
        System.out.println(alumno.getNombre());
        
        //Alumno alumno1 = new Alumno("Alejo Fernandez",42513154,"alejofernandez@hotmail.com","3564231267");
        //Alumno alumno2 = new Alumno("Franco Luque",41234678,"fluque@gmail.com","3564879032");
        //Alumno alumno3 = new Alumno("Sofia Diaz",32567342,"sdiaz@gmail.com","3564323456");
        
        //registroAlumnos.Alumnos.add(alumno1);
        //registroAlumnos.Alumnos.add(alumno2);
        //registroAlumnos.Alumnos.add(alumno3);
        
        registroCursos=ObtenerDatosCursos();
        Curso curso = registroCursos.Cursos.get(1);
        System.out.println(curso.getFechasDictado());
        //Curso curso1 = new Curso("Curso de Excel","para empresas");
        //Curso curso2 = new Curso("Curso de Java", "para estudiantes de Ing. en Sistemas");
        
        //registroCursos.Cursos.add(curso1);
        //registroCursos.Cursos.add(curso2);
        
        registroDocentes=ObtenerDatosDocentes();
        Docente docente = registroDocentes.Docentes.get(2);
        System.out.println(docente.getNombre());
        
        //Docente docente1 = new Docente("Pablo Pioli",23456782,"ppioli@hotmail.com","3564783212");
        //Docente docente2 = new Docente("Juan Pablo Ferreyra", 27890321,"jpferreyra@hotmail.com","3564674512");
        //Docente docente3 = new Docente("Marisa Perez", 20345678,"mperez@gmail.com","3564781234");
        //Docente docente4 = new Docente("Carlos Alvarez", 19345789,"carlosalvarez@gmail.com","3564123490");
        
        //registroDocentes.Docentes.add(docente1);
        //registroDocentes.Docentes.add(docente2);
        //registroDocentes.Docentes.add(docente3);
        //registroDocentes.Docentes.add(docente4);
        
        registroInscripciones = ObtenerDatosInscripciones();
        
        int opcion;
        do
        {
            Scanner entrada = new Scanner(System.in);
            System.out.println("Ingrese opción: \n1-Agregar curso \n2-Planificar curso \n3-Asignar docente \n4-Registrar inscripción \n5-Salir");
            opcion = entrada.nextInt();
            
            switch (opcion)
            {
                case 1:
                    AgregarCurso(registroDocentes,registroCursos);
                    break;
                    
                case 2:
                    PlanificarCurso(registroCursos,registroDocentes);
                    break;
                    
                case 3:
                    AsignarDocente(registroDocentes,registroCursos);
                    break;
                    
                case 4:
                    RegistrarInscripcion(registroAlumnos,registroCursos,registroInscripciones);
                    break;
            }
        } while(opcion!=5);
        
        registroInscripciones.MostrarInscripciones();
        
        GuardarDatosAlumnos(registroAlumnos);
        GuardarDatosDocentes(registroDocentes);
        GuardarDatosCursos(registroCursos);
        GuardarDatosInscripciones(registroInscripciones);
    }
    
    public static void AgregarCurso(RegistroDocentes registroDocentes,RegistroCursos registroCursos) 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Nombre del curso: ");
        String nombre = input.nextLine();
        System.out.println("Descripción: ");
        String descripcion = input.nextLine();
        registroDocentes.MostrarDocentes();
        System.out.println("Seleccione docente");
        int opc = input.nextInt();
        int posicion = opc - 1;
        Docente docente = registroDocentes.Docentes.get(posicion);
        Curso curso = new Curso(nombre,descripcion);
        curso.AgregarDocente(docente);
        
        registroCursos.Cursos.add(curso);
    }
    
    public static void PlanificarCurso(RegistroCursos registroCursos, RegistroDocentes registroDocentes)
    {
        Scanner entrada = new Scanner(System.in);
        registroCursos.MostrarCursos();
        System.out.println("Elija un curso: ");
        int opc1=entrada.nextInt();
        int pos=opc1 - 1;
        Curso curso = registroCursos.Cursos.get(pos);
        
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
            registroDocentes.MostrarDocentes();
            System.out.println ("Seleccione docente:");
            int opcion = entrada.nextInt();
            int posicion = opcion - 1;
            Docente docente = registroDocentes.Docentes.get(posicion);
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
        
        Calendar fechaLimite = new GregorianCalendar();
        String fechaString;
        System.out.println("Ingresar fecha límite de inscripción [dd/mm/aaaa]: ");
        fechaString = entrada.next();
        int dia = Integer.parseInt(fechaString.substring(0, 2));
        int mes = Integer.parseInt(fechaString.substring(3, 5)) - 1;
	int año = Integer.parseInt(fechaString.substring(6, 10));
        
        fechaLimite.set(Calendar.DATE, dia);
        fechaLimite.set(Calendar.MONTH, mes);
        fechaLimite.set(Calendar.YEAR, año);
        curso.setFechaLimite(fechaLimite);
        
        curso.setEstadoCurso(true);
    }
    
    public static void AsignarDocente(RegistroDocentes registroDocentes,RegistroCursos registroCursos)
    {
        Scanner entrada = new Scanner(System.in);
        registroDocentes.MostrarDocentes();
        System.out.println ("Seleccione docente: ");
        int opcion = entrada.nextInt();
        int posicion = opcion - 1;
        Docente docente = registroDocentes.Docentes.get(posicion);
        
        registroCursos.MostrarCursos();
        System.out.println("Elija curso: ");
        int opc = entrada.nextInt();
        int pos = opc - 1;
        Curso curso = registroCursos.Cursos.get(pos);
        
        curso.AgregarDocente(docente);
        curso.MostrarDocentes();
    }
    
    public static void RegistrarInscripcion(RegistroAlumnos registroAlumnos,RegistroCursos registroCursos,RegistroInscripciones registroInscripciones)
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
            registroAlumnos.Alumnos.add(alumno);
        }
        
        registroAlumnos.MostrarAlumnos();
        System.out.println("Seleccione alumno: ");
        int seleccion = entrada.nextInt();
        int posicion = seleccion - 1;
        Alumno alumno = registroAlumnos.Alumnos.get(posicion);
        
        registroCursos.MostrarCursos();
        System.out.println("Seleccionar curso: ");
        int opc = entrada.nextInt();
        int pos = opc - 1;
        Curso curso = registroCursos.Cursos.get(pos);
        
        Inscripcion inscripcion = new Inscripcion(alumno,curso);
        registroInscripciones.Inscripciones.add(inscripcion);
    }
    
    public static void GuardarDatosAlumnos (RegistroAlumnos registroAlumnos)
    {
        try 
        {
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(new FileOutputStream("Alumnos.json"));
            escritorObjetos.writeObject(registroAlumnos);
	} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }
    
    public static void GuardarDatosDocentes (RegistroDocentes registroDocentes)
    {
        try 
        {
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(new FileOutputStream("Docentes.json"));
            escritorObjetos.writeObject(registroDocentes);
	} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }
    
    public static void GuardarDatosCursos (RegistroCursos registroCursos)
    {
        try 
        {
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(new FileOutputStream("Cursos.json"));
            escritorObjetos.writeObject(registroCursos);
	} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }
    
    public static void GuardarDatosInscripciones (RegistroInscripciones registroInscripciones)
    {
        try 
        {
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(new FileOutputStream("Inscripciones.json"));
            escritorObjetos.writeObject(registroInscripciones);
	} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }
    
    public static RegistroAlumnos ObtenerDatosAlumnos()
    {
    RegistroAlumnos registroAlumnos = null;
		
    ObjectInputStream lectorObjetos;
    try {
	lectorObjetos = new ObjectInputStream(new FileInputStream("Alumnos.json"));
	registroAlumnos = (RegistroAlumnos) lectorObjetos.readObject();
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	} catch (IOException e) {
	e.printStackTrace();
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	return registroAlumnos;
    }
    
    public static RegistroDocentes ObtenerDatosDocentes()
    {
    RegistroDocentes registroDocentes = null;
		
    ObjectInputStream lectorObjetos;
    try {
	lectorObjetos = new ObjectInputStream(new FileInputStream("Docentes.json"));
	registroDocentes = (RegistroDocentes) lectorObjetos.readObject();
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	} catch (IOException e) {
	e.printStackTrace();
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	return registroDocentes;
    }
    
    public static RegistroCursos ObtenerDatosCursos()
    {
    RegistroCursos registroCursos = null;
		
    ObjectInputStream lectorObjetos;
    try {
	lectorObjetos = new ObjectInputStream(new FileInputStream("Cursos.json"));
	registroCursos = (RegistroCursos) lectorObjetos.readObject();
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	} catch (IOException e) {
	e.printStackTrace();
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	return registroCursos;
    }
    
    public static RegistroInscripciones ObtenerDatosInscripciones()
    {
    RegistroInscripciones registroInscripciones = null;
		
    ObjectInputStream lectorObjetos;
    try {
	lectorObjetos = new ObjectInputStream(new FileInputStream("Inscripciones.json"));
	registroInscripciones = (RegistroInscripciones) lectorObjetos.readObject();
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	} catch (IOException e) {
	e.printStackTrace();
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	return registroInscripciones;
    }
    
    
}
