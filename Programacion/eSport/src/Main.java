import javax.swing.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static StringBuilder plantilla=new StringBuilder();

    // Credenciales de prueba (en un caso real vendrían de una base de datos)
    private static  String ADMIN_USER = "";
    private static  String ADMIN_PASS = "";
    private static  String USER_USER = "";
    private static  String USER_PASS = "";

    public static void main(String[] args) {
        menuInicio();
        System.out.println("\n¡Gracias por usar el sistema!");
    }

    // --- MENÚ DE INICIO / ELECCIÓN DE ROL ---
    public static void menuInicio() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== BIENVENIDO AL SISTEMA ===");
            System.out.println("1. Iniciar sesión como ADMINISTRADOR");
            System.out.println("2. Iniciar sesión como USUARIO");
            System.out.println("3. Salir");
            System.out.println("4. Registrarse");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer tras leer un int

            switch (opcion) {
                case 1:
                    if (autenticar("ADMINISTRADOR", ADMIN_USER, ADMIN_PASS)) {
                        menuAdministrador(); // Acceso a menú con permisos elevados
                    }
                    break;
                case 2:
                    if (autenticar("USUARIO", USER_USER, USER_PASS)) {
                        menuUsuario(); // Acceso a menú limitado
                    }
                    break;
                case 3:
                    salir = true;
                    break;
                case 4:
                    registrarCuenta();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    public static void registrarCuenta(){
        try{
            System.out.println("Introduzca el tipo de cuenta");
            String tipo= scanner.nextLine();
            System.out.println("Introduce el usuario");
            String us=scanner.nextLine();
            System.out.println("Introduce contraseña");
            String cnt=scanner.nextLine();
            if (tipo.equalsIgnoreCase("administrador")){
                ADMIN_USER=us;
                ADMIN_PASS=cnt;
            }else {
                USER_USER=us;
                USER_PASS=cnt;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // --- MÉTODO REUTILIZABLE DE LOGIN ---
    public static boolean autenticar(String rol, String usuarioCorrecto, String passCorrecta) {
        System.out.println("\n--- LOGIN DE " + rol + " ---");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Contraseña: ");
        String pass = scanner.nextLine();

        if (usuario.equals(usuarioCorrecto) && pass.equals(passCorrecta)) {
            System.out.println("¡Acceso concedido como " + rol + "!");
            return true;
        } else {
            System.out.println("Error: Usuario o contraseña incorrectos.");
            return false;
        }
    }

    // --- MENÚ AVANZADO: ADMINISTRADOR ---
    public static void menuAdministrador() {
        boolean cerrarSesion = false;

        while (!cerrarSesion) {
            System.out.println("\n=== PANEL DE CONTROL (ADMINISTRADOR) ===");
            System.out.println("1. Ver catálogo de equipos");
            System.out.println("2. Añadir / Editar equipos");
            System.out.println("3. Eliminar equipos");
            System.out.println("4. Gestionar usuarios y permisos");
            System.out.println("5. Ver informes de los equipos");
            System.out.println("6. Cerrar Sesión");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("-> Mostrando catálogo completo...\n"+plantilla);
                    break;
                case 2:
                    editarEquipos();
                    break;
                case 3:
                    System.out.println("-> Producto eliminado.");
                    break;
                case 4:
                    System.out.println("-> Lista de usuarios registrados...");
                    break;
                case 5:
                    System.out.println("-> Generando informe de auditoría...");
                    break;
                case 6:
                    cerrarSesion = true; // Sale del bucle del Admin y vuelve a menuInicio()
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    public static void editarEquipos(){
        try {
            String Equipo = JOptionPane.showInputDialog("Introduce el nombre de Equipo");
            plantilla.append(Equipo).append(":\n");
            int respuesta = Integer.parseInt(JOptionPane.showInputDialog("Cuantos jugadores vas a querer inscribir?"));
            if (respuesta < 2 && respuesta > 6) {
                throw new Exception("Tienen que ser minimo 2 y maximo 6");
            } else {
                for (int i = 0; i <= respuesta; i++) {
                    try {
                        int id = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de identificación del jugador"));
                        String jugador = JOptionPane.showInputDialog("Introduce el nombre del jugador");
                        if (jugador.length() < 3)
                            throw new Exception("El jugador tiene que tener al menos 3 letras");
                        int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero del jugador"));
                        elaborarPlantilla(jugador, num, Equipo, id);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }
    public static void elaborarPlantilla(String jugador,int num,String Equipo, int id){
        plantilla.append(id+"-").append(jugador).append("-"+num+"\n");//Numero opcional(Por los atributos base datos)
        JOptionPane.showMessageDialog(null,plantilla);
    }


    // --- MENÚ RESTRICTO: USUARIO ESTÁNDAR ---
    public static void menuUsuario() {
        boolean cerrarSesion = false;

        while (!cerrarSesion) {
            System.out.println("\n=== ÁREA DE USUARIO ===");
            System.out.println("1. Ver catálogo de productos");
            System.out.println("2. Ver mi perfil");
            System.out.println("3. Cerrar Sesión");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("-> Mostrando catálogo...");
                    break;
                case 2:
                    System.out.println("-> Datos de tu perfil de usuario...");
                    break;
                case 3:
                    cerrarSesion = true; // Sale del bucle del Usuario y vuelve a menuInicio()
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}