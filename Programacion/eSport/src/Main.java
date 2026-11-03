import java.util.Scanner;
public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Desarrollar un programa para guardar en memoria los datos de un equipo y de un
        //jugador validando todos los campos de entrada y llevando a cabo la entrada y salida
        //de datos desde consola.


    }

    public static void menu() {
        int opcion;
        System.out.println("======MENU======");
        System.out.println("1. Jugador");
        System.out.println("2. Equipo");
        System.out.println("3. Salir");
        opcion = sc.nextInt();
        while (opcion != 3)
            switch (opcion) {
                case 1:
                    jugador();
                    break;
                case 2:
                    equipo();
                    break;
                default:
                    System.out.println("No valido");
            }

    }


    public static StringBuilder jugador() {
        String nombre, apellido, fechaNacimiento, nickname, rol;
        int sueldo;
        StringBuilder jugador = new StringBuilder();
        boolean valido;
        System.out.println("Introduce el nombre del jugador:");
        nombre = sc.nextLine();
        System.out.println("Introduce el apellido del jugador:");
        apellido = sc.nextLine();
        System.out.println("Introduce la fecha de nacimiento del jugador:");
        fechaNacimiento = sc.nextLine();
        System.out.println("Introduce el nickname del jugador:");
        nickname = sc.nextLine();
        System.out.println("Introduce el rol del jugador:");
        rol = sc.nextLine();
        do {
            System.out.println("Introduce el sueldo del jugador:");
            sueldo = sc.nextInt();
            if (sueldo <= 1.221) {
                valido = true;
                System.out.println("El sueldo deve superar el sueldo minimo inter-profesional (1.221$)");
            } else {
                valido = false;
            }
        } while (valido);
        jugador.append(nombre + " " + apellido + " " + fechaNacimiento + " " + nickname + " " + rol);


    }
}

