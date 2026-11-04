import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Escribir codigo
        try {
            char opcion;
            do {
                opcion=mostrarMenu();
                switch (opcion){
                    case 'a':
                        iniciarSesion();
                        break;
                    case 'b':
                        //mostrarPartidos();
                        break;
                    case 'c':
                        //buscarFecha();
                        break;
                }

            }while (opcion !='d');
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    public static char mostrarMenu(){
        char opcion=0;
        boolean error;
        do {
            try {
                String respuesta=JOptionPane.showInputDialog("Escribe una opcion:\n"+"a) Iniciar sesion \n"+
                        "b) mostrar partidos\n" +"c) buscar fecha\n"+"d) Salir");
                if (respuesta.length()>1)
                    throw new Exception("Solo se puede elegir una opcion del menu.");
                opcion=respuesta.toLowerCase().charAt(0);
                if (opcion !='a' && opcion !='b' && opcion !='c' && opcion !='d')
                    throw new Exception("La opcion elegida no es valida");
                error=false;

            }catch (IndexOutOfBoundsException e){
                error=true;
                JOptionPane.showMessageDialog(null,"Hay que indicar una opcion.");
            }catch (NullPointerException e){
                error=true;
                JOptionPane.showMessageDialog(null,"Si quieres terminar elige la opcion d");
            }catch (Exception e){
                error=true;
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }while (error);
        return opcion;
    }
    public static void iniciarSesion(){
        for (int i = 0; i < 1; i++) {
            boolean error;
            do {
                try {
                    String nombre = JOptionPane.showInputDialog("Introduce el usuario\n" + "El usuario tiene que tener:\n" +
                            "Minimo 4 letras");
                    String passwd = JOptionPane.showInputDialog("Introduce la contraseña");
                    if (nombre.length() <= 3)
                        throw new Exception("El nombre tiene que tener minimo 4 letras");
                    error=false;

                } catch (Exception e) {
                    error = true;
                    JOptionPane.showMessageDialog(null, "El nombre o la contraseña no son balidos.");
                }
            }while (error);
            JOptionPane.showMessageDialog(null,"Has iniciado sesion");

        }
    }
}