import javax.swing.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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
                 gestionarCalendario();
                 break;
             case 3:
                 gestionarCampeonato();
                 break;
             case 4:
                 JOptionPane.showMessageDialog(null,
                         "Saliendo del programa...");
             default:
                 JOptionPane.showMessageDialog(null,
                         "Opcion no valida");
         }
     } while (option !=4);
    }
    public static int mostrarMenu(){
        String menu = " CAMPEONATO E-SPORT \n"
                + "1. Gestionar inscripciones\n"
                + "2. Generar calendario\n"
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
        JOptionPane.showMessageDialog(null,
                "Gestion de inscripciones");
    }

    public static void gestionarCalendario() {
        JOptionPane.showMessageDialog(null,
                "Gestion de calendario");
    }

    public static void gestionarCampeonato() {
        JOptionPane.showMessageDialog(null,
                "Gestion de campeonato");
    }
}