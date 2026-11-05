import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static StringBuilder plantilla=new StringBuilder();
    public static void main(String[] args) {
        // Escribir codigo
        String Equipo=JOptionPane.showInputDialog("Introduce el nombre de Equipo");
        plantilla.append(Equipo).append(":\n");
        String respuesta;
        do {
            try {
                String jugador = JOptionPane.showInputDialog("Introduce el nombre del jugador");
                int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero del jugador"));
                elaborarPlantilla(jugador, num, Equipo);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
            respuesta = JOptionPane.showInputDialog("Quieres seguir?");
        }while(respuesta.equalsIgnoreCase("si"));



    }
    public static void elaborarPlantilla(String jugador,int num,String Equipo){
     plantilla.append(jugador).append("-"+num+"\n");
     JOptionPane.showMessageDialog(null,plantilla);
    }
}