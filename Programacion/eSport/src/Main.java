//Desarrollar un programa para guardar en memoria los datos de un equipo y de un
//jugador validando todos los campos de entrada y llevando a cabo la entrada y salida
//de datos desde consola.

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static boolean error;
    public static StringBuilder equipo;

    public static void main(String[] args) {
        pedirJugador();
    }

    public static void pedirEquipo(){ // funcion que pide los datos del equipo
        System.out.println("Nombre del equipo");
        String nombreEqui = sc.nextLine();

        System.out.println("Fecha de fundación");
        String fechaFund = sc.nextLine();

        System.out.println("Jugadores"); // los equipos tienen que tener 2-6 jugadores si o si
        int numJugadores = sc.nextInt();

    } // los equipos tienen que ser pares

    public static void pedirJugador(){ // funcion que pide los datos de los jugadores
        do{
            try{
                System.out.println("Dime tu nombre");
                String nombre = sc.nextLine();
                error = false;
            } catch (Exception e){
                System.out.println("No has metido un nombre correcto");
            }
        } while (error);

        do{
            try{
                System.out.println("Dime tu apellido");
                String apellido = sc.nextLine();
                error = false;
            } catch(Exception e){
                System.out.println("No has metido un apellido correcto");
            }
        } while(error);

        do{
            try{
                System.out.println("Dime tu nacionalidad");
                String nacionalidad = sc.nextLine();
                error = false;
            }catch(Exception e){
                System.out.println("No has metido una nacionalidad correcta");
            }
        }while(error);

        do{
            try{
                System.out.println("Fecha de nacimiento");
                String fechaNaci = sc.nextLine();// fecha
                error = false;
            } catch (Exception e){
                System.out.println("No has metido una fecha correcta");
            }
        } while(error);

        do{
            try{
                System.out.println("Nickname");
                String nickname = sc.nextLine();
                error = false;
            } catch(Exception e){
                System.out.println("No has metido un nickname correcto");
            }
        } while(error);

        do{
            try{
                System.out.println("Rol");
                String rol = sc.nextLine();
                error = false;
            } catch(Exception e){
                System.out.println("No has metido un rol correcto");
            }
        } while(error);

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

    public static void escribirEquipo(){
        // escribir todos los datos recogidos de un equipo
    }
}