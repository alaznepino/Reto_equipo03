import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static StringBuilder plantilla=new StringBuilder();
    public static void main(String[] args) {
        // Escribir codigo
        String Equipo=JOptionPane.showInputDialog("Introduce el nombre de Equipo");
        plantilla.append(Equipo).append(":\n");
        int respuesta= Integer.parseInt(JOptionPane.showInputDialog("Cuantos jugadores vas a querer inscribir?"));
        Pattern patron=Pattern.compile("^2-6$");
        Matcher m = patron.matcher(respuesta);
        for (int i = 0; i <= respuesta ; i++) {
            try {
                int id= Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de identificación del jugador"));
                String jugador = JOptionPane.showInputDialog("Introduce el nombre del jugador");
                if (jugador.length()<3)
                    throw new Exception("El jugador tiene que tener al menos 3 letras");
                int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero del jugador"));
                elaborarPlantilla(jugador, num, Equipo, id);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }

    }
    public static void elaborarPlantilla(String jugador,int num,String Equipo, int id){
     plantilla.append(id+"-").append(jugador).append("-"+num+"\n");//Numero opcional(Por los atributos base datos)
     JOptionPane.showMessageDialog(null,plantilla);
    }
}