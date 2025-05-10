package prueba; 

import dao.DeportistaDAO;
import entidades.Deportista;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        DeportistaDAO dao = new DeportistaDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMENU");
            System.out.println("1. Insertar nuevo deportista");
            System.out.println("2. Mostrar todos los deportistas");
            System.out.println("3. Consultar informacion de un deportista");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    Deportista nuevo = new Deportista();
                    System.out.print("Nombre: ");
                    nuevo.setNombre(sc.nextLine());
                    System.out.print("Apellido: ");
                    nuevo.setApellido(sc.nextLine());
                    System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
                    nuevo.setFechaNacimiento(Date.valueOf(sc.nextLine()));
                    System.out.print("Telefono: ");
                    nuevo.setTelefono(sc.nextLine());
                    System.out.print("Email: ");
                    nuevo.setEmail(sc.nextLine());
                    System.out.print("Direccion: ");
                    nuevo.setDireccion(sc.nextLine());
                    System.out.print("Fecha de inscripcion (YYYY-MM-DD): ");
                    nuevo.setFechaInscripcion(Date.valueOf(sc.nextLine()));
                    System.out.print("Estado (Activo/Inactivo): ");
                    nuevo.setEstado(sc.nextLine());
                    System.out.print("Contacto de emergencia: ");
                    nuevo.setContactoEmergencia(sc.nextLine());

                    if (dao.insertar(nuevo)) {
                        System.out.println(" Deportista insertado correctamente.");
                    } else {
                        System.out.println(" Error al insertar deportista.");
                    }
                    break;

                case 2:
                    List<Deportista> lista = dao.obtenerTodos();
                    System.out.println("\n Lista de Deportistas ");
                    for (Deportista d : lista) {
                        System.out.println("ID: " + d.getId() + " - " + d.getNombre() + " " + d.getApellido());
                    }
                    break;

                case 3:
               
                    List<Deportista> listaConsult = dao.obtenerTodos();
                    System.out.println("\nNombre del deportista: ");
                    String nom = sc.next();
                    boolean encontrado = false;

                    // Primero buscamos al deportista
                    for (Deportista d : listaConsult) {
                        if (d.getNombre().equalsIgnoreCase(nom)) {
                            // Si lo encontramos, mostramos su información
                            System.out.println("ID: " + d.getId() + " Nombre: " + d.getNombre() + " " + d.getApellido()
                                    + "\nFecha de nacimiento: " + d.getFechaNacimiento() + "\nTelefono: " + d.getTelefono()
                                    + "\nEmail: " + d.getEmail() + "\nDireccion: " + d.getDireccion()
                                    + "\nFecha de inscripcion: " + d.getFechaInscripcion()
                                    + "\nEstado: " + d.getEstado() + "\nContacto de emergencia: " + d.getContactoEmergencia());
                            encontrado = true;
                            break;
                        }
                    }

                    // Después del bucle, verificamos si no se encontró
                    if (!encontrado) {
                        System.out.println("Deportista no existente");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Opcion invalida. Intenta de nuevo.");
            }
        }
    }
}
