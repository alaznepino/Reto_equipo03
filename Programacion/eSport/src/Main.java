import java.util.Scanner;
public class Main {
    public static Scanner sc = new Scanner(System.in);

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
        int opcion;
        StringBuilder jugador;
        mostrarMenu();
        opcion = sc.nextInt();
        while (opcion != 3) {
            switch (opcion) {
                case 1:
                    jugador = jugador();
                    System.out.println(jugador);
                    break;
                case 2:
                    //equipo();
                    System.out.println("kjerkn");
                    break;
                default:
                    System.out.println("No valido");
            }
            mostrarMenu();
            opcion = sc.nextInt();
        }
        System.out.println("Saliendo...");
    }


    public static StringBuilder jugador() {
        String nombre, apellido, fechaNacimiento, nickname, rol, equipo;
        int sueldo;
        StringBuilder jugador = new StringBuilder();
        boolean valido;
        System.out.println("Introduce el nombre del jugador:");
        sc.nextLine();
        nombre = sc.nextLine();
        System.out.println("Introduce el apellido del jugador:");
        apellido = sc.nextLine();
        System.out.println("Introduce la fecha de nacimiento del jugador (dd/mm/yyyy):");
        fechaNacimiento = sc.nextLine();
        System.out.println("Introduce el nickname del jugador:");
        nickname = sc.nextLine();
        System.out.println("Introduce el rol del jugador:");
        rol = sc.nextLine();
        System.out.println("Introduce el equipo el que pretenece el jugador:");
        equipo = sc.nextLine();
        do {
            System.out.println("Introduce el sueldo del jugador:");
            sueldo = sc.nextInt();

            if (sueldo <= 1220) {
                valido = true;
                System.out.println("El sueldo debe superar el sueldo minimo inter-profesional (1.221$)");
            } else {
                valido = false;
            }
        } while (valido);
        //A futuro esto se sustituira por un sistema de listas (supongo)
        jugador.append(nickname + ": \n  " + nombre + " \n  " +  apellido + " \n  " + fechaNacimiento + " \n  " +  equipo + " \n  " +  rol + " \n  " + sueldo +" \n  " );
        return jugador;

    }

}

