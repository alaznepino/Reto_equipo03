import javax.swing.*;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    static String nombreJugadores;
    static String apellido1;
    static String apellido2;
    static String nacionalidad;
    static String nickname;
    static String rol;
    static String fechaNacimiento;
    static double sueldo;
    static double SMI = 1.221;
    static String equiposRegistrados = "";
    static int numeroEquipos = 0;
    static String nombreEquipo,jugadores,fechaIniciado;
    static int numeroJugadores;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
     int option;
     do {
         option = mostrarMenu();
         switch (option){
             case 1:
                 gestionarInscripcion();
                 break;
             case 2:
                 gestionarJugadores();
                 break;
             case 3:
                 gestionarCalendario();
                 break;
             case 4:
                 JOptionPane.showMessageDialog(null,
                         "Saliendo del programa...");
                 break;
             default:
                 JOptionPane.showMessageDialog(null,
                         "Opcion no valida");
         }
     } while (option !=4);
    }
    public static int mostrarMenu(){
        String menu = " CAMPEONATO E-SPORT \n"
                + "1. Gestionar inscripciones\n"
                + "2. Gestionar Jugadores\n"
                + "3. Gestionar campeonato\n"
                + "4. Salir\n\n"
                + "Seleccione una opcion:";
        String respuesta = JOptionPane.showInputDialog(menu);

        if (respuesta == null) {
            return 4;
        }

        return Integer.parseInt(respuesta);
    }

    public static void gestionarInscripcion() {
        nombreEquipo = JOptionPane.showInputDialog(
                "Introduzca el nombre del equipo:");

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        fechaIniciado = JOptionPane.showInputDialog(
                "Introduzca la fecha de fundación: ");
        boolean fechaCorrecta = false;

        do {
            try {
                LocalDate.parse(fechaIniciado, formato);
                fechaCorrecta = true;

            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null,
                        "Fecha incorrecta. Utilice el formato dd/MM/yyyy");

                fechaIniciado = JOptionPane.showInputDialog(
                        "Introduzca de nuevo la fecha de fundación:");
            }

        } while (!fechaCorrecta);

        do {
            numeroJugadores = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos jugadores tiene el equipo?"));

            if (numeroJugadores < 2 || numeroJugadores > 6) {
                JOptionPane.showMessageDialog(null,
                        "El equipo debe tener entre 2 y 6 jugadores.");
            }

        } while (numeroJugadores < 2 || numeroJugadores > 6);


    }
    public static void gestionarJugadores(){
        nombreJugadores = JOptionPane.showInputDialog("Introduzca el nombre del jugador:");

        apellido1 = JOptionPane.showInputDialog("Introduzca el primer apellido del jugador:");

        apellido2 = JOptionPane.showInputDialog("Introduzca el segundo apellido del jugador:");

        nacionalidad = JOptionPane.showInputDialog("Introduzca la nacionalidad del jugador:");

        nickname = JOptionPane.showInputDialog("Introduzca el nickname del jugador:");

        rol = JOptionPane.showInputDialog("Introduzca el rol del jugador:");

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        fechaNacimiento = JOptionPane.showInputDialog("Introduzca la fecha de nacimiento (dd/MM/yyyy):");

        boolean fechaCorrecta = false;

        do {
            try {
                LocalDate.parse(fechaNacimiento, formato);
                fechaCorrecta = true;

            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null,
                        "Fecha incorrecta. Utilice el formato dd/MM/yyyy");

                fechaNacimiento = JOptionPane.showInputDialog("Introduzca de nuevo la fecha de nacimiento:");
            }

        } while (!fechaCorrecta);

        do {
            sueldo = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el sueldo mensual del jugador:"));

            if (sueldo <= SMI) {
                JOptionPane.showMessageDialog(null,
                        "El sueldo debe ser superior al SMI (1221 euros).");
            }

        } while (sueldo <= SMI);
    }

    public static void gestionarCalendario() {

        if (numeroEquipos < 2) {
            JOptionPane.showMessageDialog(null,
                    "No hay suficientes equipos para generar el calendario.");
        } else if (numeroEquipos % 2 != 0) {
            JOptionPane.showMessageDialog(null,
                    "El número de equipos debe ser par.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Equipos inscritos:\n" + equiposRegistrados);
        }

    }
}