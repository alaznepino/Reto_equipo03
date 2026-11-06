import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // El formato de la fecha es una global porque se utiliza en mas de una funcion
    public static Pattern patronNombre = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]{2,15}$"),
            patronNickname = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ0-9 @_-]{2,15}$");

    public static void main(String[] args) {
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
                        sc.nextLine();
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

        //error = true;
        //            do {
        //                try {
        //                System.out.println("Introduce el nombre:");
        //                j.nombre = sc.nextLine();
        //                    Pattern pat = Pattern.compile("^(?=.*[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ])[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]{2,15}$");
        //                    Matcher mat = pat.matcher(j.nombre);
        //                    if (!mat.matches()) {
        //                        throw new IllegalArgumentException("Nombre no válido");
        //                    } else error = false;
        //                } catch (IllegalArgumentException e) {
        //                    System.out.println(e.getMessage());
        //                }
        //            } while (error);


        error = true;
        do {
            try {
                System.out.println("Introduce el nombre del jugador:");
                nombre = sc.nextLine();
                Matcher mat = patronNombre.matcher(nombre);
                    if (!mat.matches()) {
                        System.out.println("Nombre no válido");
                    } else error = false;
            }catch (Exception e){
                System.out.println("Formato de nombre incorrecto");
            }

        }while(error);


        error = true;
        do {
            try {
                System.out.println("Introduce el apellido del jugador:");
                apellido = sc.nextLine();
                Matcher mat = patronNombre.matcher(apellido);
                if (!mat.matches()) {
                    System.out.println("Apellido no válido");
                } else error = false;
            }catch (Exception e){
                System.out.println("Formato de apellido incorrecto");
            }

        }while(error);

        error = true;
        do {
            try {
                System.out.println("Introduce el nacionalidad del jugador:");
                nacionalidad = sc.nextLine();
                Matcher mat = patronNombre.matcher(nacionalidad);
                if (!mat.matches()) {
                    System.out.println("Nacionalidad no válido");
                } else error = false;
            }catch (Exception e){
                System.out.println("Formato de nacionalidad incorrecto");
            }

        }while(error);


        error = true;
        do {
            try {
                System.out.println("Introduce la fecha de nacimiento del jugador (dd/mm/yyyy):");
                fechaNacimiento = sc.nextLine();
                LocalDate.parse(fechaNacimiento, formatoFecha);
                error = false;
            }catch (Exception e){
                System.out.println("Formato de fecha incorrecto");
            }
        }while(error);



        error = true;
        do {
            try {
                System.out.println("Introduce el nickname del jugador:");
                nickname = sc.nextLine();
                Matcher mat = patronNickname.matcher(nickname);
                if (!mat.matches()) {
                    System.out.println("Nickname no válido");
                } else error = false;
            }catch (Exception e){
                System.out.println("Formato de nickname incorrecto");
            }

        }while(error);


        //ESTO NO FUNCIONA
        error = true;
        do {
            try {
                System.out.println("Introduce el rol del jugador (Tanque, Dps o Support):");
                rol = sc.nextLine();
                if (rol.equalsIgnoreCase("tanque")  || rol.equalsIgnoreCase("dps") || rol.equalsIgnoreCase("suport")) {
                    valido = true;
                    System.out.println("Rol no valido");
                } else {
                    valido = false;
                }
                error = false;
            }catch (Exception e){
                System.out.println("Formato de rol incorrecto");
            }

        }while(valido || error);
        //error = true;
        //        do {
        //            try{
        //                System.out.println("Introduce el sueldo del jugador:");
        //                sueldo = sc.nextInt();
        //                if (sueldo <= 1220) {
        //                    valido = true;
        //                    System.out.println("El sueldo debe superar el sueldo minimo inter-profesional (1.221$)");
        //                } else {
        //                    valido = false;
        //                }
        //                error = false;
        //            }catch (InputMismatchException e){
        //                System.out.println("Formato de sueldo incorrecto");
        //                sc.nextLine();
        //            }
        //        } while (valido || error);
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
        jugador.append(nickname + ": " +
                "\n  Nombre: " + nombre + " " +
                "\n  Apellido: " +  apellido + " " +
                "\n  Nacionalidad: " + nacionalidad + " " +
                "\n  Fecha de nacimiento: " + fechaNacimiento + " " +
                "\n  Equipo: " +  equipo + " " +
                "\n  Rol: " +  rol + " " +
                "\n  Sueldo:" + sueldo +"$ " +
                "\n  " );
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

        equipo.append(nombre + ": " +
                "\n  Fecha de creacion: " + fechaCreacion + " " +
                "\n   Jugadores:");


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
                    equipo.append(" \n         "+ i + ". " + jugadores);
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

