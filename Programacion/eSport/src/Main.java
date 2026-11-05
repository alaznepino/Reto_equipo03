import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        // Desarrollar un programa para guardar en memoria los datos de un equipo y de un
        //jugador validando todos los campos de entrada y llevando a cabo la entrada y salida
        //de datos desde consola.
        menu();

    }
    public static void mostrarMenu(){
        System.out.println("======MENU======");
        System.out.println("1. Jugador");
        System.out.println("2. Equipo");
        System.out.println("3. Salir");
    }
    public static void menu() {
        int opcion = 0;
        StringBuilder jugador, equipo;

        do {
            try {
                mostrarMenu();
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        jugador = jugador();
                        System.out.println(jugador);
                        break;
                    case 2:
                        equipo = equipo();
                        System.out.println(equipo);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("No valido");
                }

            } catch (InputMismatchException e) {
                System.out.println("Numero no valido");
                sc.nextLine();
            }
        }while (opcion != 3);
        System.out.println("Saliendo...");
    }


    public static StringBuilder jugador() {
        String nombre = null, apellido = null, nacionalidad = null, fechaNacimiento = null, nickname = null, rol = null, equipo = null;
        int sueldo = 0;
        StringBuilder jugador = new StringBuilder();
        boolean valido = false, error;
        error = true;
        do {
            try {
                System.out.println("Introduce el nombre del jugador:");
                sc.nextLine();
                nombre = sc.nextLine();
                error = false;
            }catch (Exception e){
                System.out.println("Formato de nombre incorrecto");
            }

        }while(error);


        error = true;
        do {
            try {
                System.out.println("Introduce el apellido del jugador:");
                apellido = sc.nextLine();
                error = false;
            }catch (Exception e){
                System.out.println("Formato de apellido incorrecto");
            }

        }while(error);

        error = true;
        do {
            try {
                System.out.println("Introduce el nacionalidad del jugador:");
                nacionalidad = sc.nextLine();
                error = false;
            }catch (Exception e){
                System.out.println("Formato de nacionalidad incorrecto");
            }

        }while(error);


        error = true;
        do {
            try {
                System.out.println("Introduce la fecha de nacimiento del jugador (dd/mm/yyyy):");
                fechaNacimiento = sc.nextLine();
                LocalDate fechaValida = LocalDate.parse(fechaNacimiento, formatoFecha);
                error = false;
            }catch (Exception e){
                System.out.println("Formato de fecha incorrecto");
            }
        }while(error);


        // seguir
        error = true;
        do {
            try {
                System.out.println("Introduce el nickname del jugador:");
                nickname = sc.nextLine();
                error = false;
            }catch (Exception e){
                System.out.println("Formato de nickname incorrecto");
            }

        }while(error);

        error = true;
        do {
            try {
                System.out.println("Introduce el rol del jugador:");
                rol = sc.nextLine();
                error = false;
            }catch (Exception e){
                System.out.println("Formato de rol incorrecto");
            }

        }while(error);
        error = true;
        do {
            try {
                System.out.println("Introduce el equipo el que pretenece el jugador:");
                equipo = sc.nextLine();
                error = false;
            }catch (Exception e){
                System.out.println("Formato de equipo incorrecto");
            }
        }while(error);


        error = true;
        do {
            try{
                System.out.println("Introduce el sueldo del jugador:");
                sueldo = sc.nextInt();
                if (sueldo <= 1220) {
                    valido = true;
                    System.out.println("El sueldo debe superar el sueldo minimo inter-profesional (1.221$)");
                } else {
                    valido = false;
                }
                error = false;
            }catch (InputMismatchException e){
                System.out.println("Formato de sueldo incorrecto");
                sc.nextLine();
            }
        } while (valido || error);
        //A futuro esto se sustituira por un sistema de listas (supongo)
        jugador.append(nickname + ": \n  " + nombre + " \n  " +  apellido + " \n  " + nacionalidad + " \n  " + fechaNacimiento + " \n  " +  equipo + " \n  " +  rol + " \n  " + sueldo +" \n  " );
        return jugador;

    }
    public static StringBuilder equipo(){
        String nombre = null, fechaCreacion = null, jugadores = null;
        int nJugadores = 0;
        boolean error = false;
        StringBuilder equipo = new StringBuilder();


        error = true;
        do {
            try {
                System.out.println("Introduce el nombre del equipo:");
                sc.nextLine();
                nombre = sc.nextLine();
                error = false;
            }catch (Exception e){
                System.out.println("Formato de nombre de equipo incorrecto");
            }
        }while(error);

        error = true;
        do {
            try {
                System.out.println("Introduce la fecha de creacion del equipo (dd/mm/yyyy):");
                fechaCreacion = sc.nextLine();
                error = false;
            }catch (Exception e){
                System.out.println("Formato de nombre de equipo incorrecto");
            }
        }while(error);

        equipo.append(nombre + ": \n  " + fechaCreacion + " \n   Jugadores:");


        error = true;
        do {
            try {
                System.out.println("Introduce el numero de jugadores del equipo (min 2 - max 6):");
                nJugadores = sc.nextInt();
                while (nJugadores > 6 || nJugadores < 2){
                    System.out.println("Numero de jugadores no valido");
                    System.out.println("Introduce el numero de jugadores del equipo (min 2 - max 6):");
                    nJugadores = sc.nextInt();
                }
                sc.nextLine();
                for ( int i=1 ; i <= nJugadores; i++){
                    System.out.println("Introduce el nombre del jugador Nº "+ i +":");
                    jugadores = sc.nextLine();
                    equipo.append(" \n    " + jugadores);
                }
                error = false;
            }catch (InputMismatchException e){
                System.out.println("Formato de numero de jugadres incorrecto");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Formato de nombre de jugador incorrecto");
            }

        }while(error);

        return equipo;
    }

}

