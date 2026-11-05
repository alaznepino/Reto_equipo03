//Desarrollar un programa para guardar en memoria los datos de un equipo y de un
//jugador validando todos los campos de entrada y llevando a cabo la entrada y salida
//de datos desde consola.

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static boolean error;
    public static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static LocalDate fechaHoy = LocalDate.now();


    public static void main(String[] args) {
        menu();
    }

    public static void  menu() {
        int numero = 0;
        do {
            try {
                System.out.println("Escoge el dato a añadir \n" +
                        "1. Datos del equipo \n" +
                        "2. Datos del jugador \n" +
                        "3. Salir"
                );
                numero = sc.nextInt();
                switch (numero) {
                    case 1 -> System.out.println(pedirEquipo());
                    case 2 -> pedirJugador();
                    case 3 -> System.out.println("Finalizando el proyecto...");
                    default -> System.out.println("Opción no válida");
                }
            }catch (InputMismatchException e){
                System.out.println("No es un número");
                sc.next();
            }
        }while(numero != 3);
    }
    public static StringBuilder pedirEquipo(){ // funcion que pide los datos del equipo
        StringBuilder equipo = new StringBuilder();
        String nombreEqui = "";
        LocalDate fechaFun = null;
        String numJugadores = "";

        do{
            try{
                sc.nextLine();
                System.out.println("Nombre del equipo");
                nombreEqui = sc.nextLine();
            }catch(Exception e){
                System.out.println("Nombre no válido");
            }
        } while (error);

        error=true;
        do{
            try{
                System.out.println("Fecha de fundación (dd/MM/yyyy)"); // la fecha tiene que ser antes de hoy
                String entrada = sc.nextLine();
                fechaFun = LocalDate.parse(entrada, formato);

                if(fechaFun.isAfter(fechaHoy)){
                    System.out.println("La fecha tiene que ser anterior a hoy");
                } else{
                    error = false;
                }
            }catch(Exception e){
                System.out.println("Fecha incorrecta");
            }
        }while (error);

        error = true;
        do{
            try{
                System.out.println("Jugadores"); // los equipos tienen que tener 2-6 jugadores si o si
                numJugadores = sc.nextLine();

                Pattern pat = Pattern.compile("^[2-6]$");
                Matcher mat = pat.matcher(numJugadores);
                if (mat.matches ()) {
                    error = false;
                } else {
                    System.out.println("Número inválido");
                }
            }catch(Exception e){
                System.out.println("No has añadido un numero");
            }
        }while (error);

        return equipo.append("=====DATOS DEL EQUIPO=====\n")
                .append("Nombre equipo: ").append(nombreEqui)
                .append("\n")
                .append("Fecha fundación: ").append(fechaFun)
                .append("\n")
                .append("Numero de jugadores: ").append(numJugadores).append("\n");
    }

    public static void pedirJugador(){ // funcion que pide los datos de los jugadores
        error = true;

        do{
            try{
                sc.nextLine();
                System.out.println("Proporciona tu DNI");
                String dniJugador = sc.nextLine();
            }catch(Exception e){
                System.out.println("No es un DNI válido");
            }
        } while(error);


        error = true;
        do{
            try{
                System.out.println("Dime tu nombre");
                String nombre = sc.nextLine();
                error = false;
            } catch (Exception e){
                System.out.println("No has metido un nombre correcto");
            }
        } while (error);

        error = true;
        do{
            try{
                System.out.println("Dime tu apellido");
                String apellido = sc.nextLine();
                error = false;
            } catch(Exception e){
                System.out.println("No has metido un apellido correcto");
            }
        } while(error);

        error = true;
        do{
            try{
                System.out.println("Dime tu nacionalidad");
                String nacionalidad = sc.nextLine();
                error = false;
            }catch(Exception e){
                System.out.println("No has metido una nacionalidad correcta");
            }
        }while(error);

        error = true;
        do{
            try{
                System.out.println("Fecha de nacimiento (dd/MM/yyyy)");
                String entrada = sc.nextLine();
                LocalDate fechaNac = LocalDate.parse(entrada, formato);
                error = false;
            } catch (Exception e){
                System.out.println("No has metido una fecha correcta");
            }
        } while(error);

        error = true;
        do{
            try{
                System.out.println("Nickname");
                String nickname = sc.nextLine();
                error = false;
            } catch(Exception e){
                System.out.println("No has metido un nickname correcto");
            }
        } while(error);

        error = true;
        do{
            try{
                System.out.println("Rol"); //healer, dps, tanque
                String rol = sc.nextLine();
                error = false;
            } catch(Exception e){
                System.out.println("No has metido un rol correcto");
            }
        } while(error);

        error = true;
        do{
            try{
                System.out.println("Sueldo");
                double sueldo = sc.nextDouble();
                error = false;
            } catch(Exception e){
                System.out.println("No has metido un numero correcto");
            }
        } while(error);
    }
}