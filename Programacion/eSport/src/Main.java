//Desarrollar un programa para guardar en memoria los datos de un equipo y de un
//jugador validando todos los campos de entrada y llevando a cabo la entrada y salida
//de datos desde consola.

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
                sc.nextLine();
                switch (numero) {
                    case 1 -> System.out.println(pedirEquipo());
                    case 2 -> System.out.println(pedirJugador());
                    case 3 -> System.out.println("Finalizando el proyecto...");
                    default -> System.out.println("Opción no válida");
                }
            }catch (InputMismatchException e){
                System.out.println("Error: Debe introducir un número entero");
                sc.nextLine();
            }
        }while(numero != 3);
    }
    public static StringBuilder pedirEquipo(){ // funcion que pide los datos del equipo
        StringBuilder equipo = new StringBuilder();
        String nombreEqui = "";
        LocalDate fechaFun = null;
        int numJugadores = 0;

        // 1. Nombre del equipo
        // Validación: Tiene que tener entre 3,8 letras y solo se puede usar _
        Pattern patNombre = Pattern.compile("^[a-zA-Z0-9_]{3,8}$");
        do{
            try{
                error = true;
                System.out.println("Nombre del equipo");
                nombreEqui = sc.nextLine();
                Matcher matNombre = patNombre.matcher(nombreEqui);
                if(!matNombre.matches()){
                    System.out.println("Error: El nombre debe tener entre 3 y 8 caracteres, no tener espacios y solo contener letras, números o '_'.");
                } else{
                    error = false;
                }
            }catch(Exception e){
                System.out.println("Error inesperado al leer la entrada por consola.");
            }
        } while (error);

        // 2. Fecha de fundación
        // Validación: la fecha tiene que ser antes de hoy
        do{
            try{
                error=true;
                System.out.println("Fecha de fundación (dd/MM/yyyy)");
                String entrada = sc.nextLine();
                fechaFun = LocalDate.parse(entrada, formato);

                if(fechaFun.isAfter(fechaHoy)){
                    System.out.println("La fecha tiene que ser anterior a hoy");
                } else{
                    error = false;
                }
            }catch(DateTimeException e){
                System.out.println("Error: no has proporcionado una fecha.");
            }
        }while (error);

        // 3. Número de jugadores
        // Validación: solo pueden ser entre 2 y 6.
        do{
            try{
                error = true;
                System.out.println("Numero de jugadores (Comprendidos entre 2 y 6)");
                numJugadores = sc.nextInt();

                if (numJugadores >= 2 && numJugadores <= 6) {
                    error = false;
                } else {
                    System.out.println("Número inválido");
                }
            }catch(InputMismatchException e){
                System.out.println("Error: Debe añadir un numero");
                sc.nextLine();
            }
        }while (error);

        return equipo.append("=====DATOS DEL EQUIPO=====\n")
                .append("Nombre equipo: ").append(nombreEqui)
                .append("\n")
                .append("Fecha fundación: ").append(fechaFun)
                .append("\n")
                .append("Numero de jugadores: ").append(numJugadores).append("\n");
    }

    public static StringBuilder pedirJugador(){ // funcion que pide los datos de los jugadores
        StringBuilder jugador = new StringBuilder();
        Pattern patNombre = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{2,30}$");
        Pattern patNick = Pattern.compile("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ_\\s]{2,30}$");
        LocalDate fechaLimite = LocalDate.now().minusYears(18);

        String dniJugador = "";
        String nombre = "";
        String apellido = "";
        String nacionalidad = "";
        LocalDate fechaNac = null;
        String nickname = "";
        String rol = "";
        double sueldo = 0;
        final double SMI = 1221.00;

        // DNI de jugador
        // Validación: debe tener 8 números y una letra mayúscula.
        do{
            try{
                error = true;
                System.out.println("Proporciona tu DNI (8 números y una letra)");
                dniJugador = sc.nextLine().toUpperCase();

                if(dniJugador.matches("^[0-9]{8}[A-Z]$")){
                    error = false;
                } else{
                    System.out.println("No es un DNI válido");
                }
            }catch(Exception e){
                System.out.println("Error al leer el DNI");
            }
        } while(error);

        // Nombre de jugador
        // Validación: Debe tener entre 2 y 30 caracteres y contener solo letras (y espacios).
        do{
            try{
                error = true;
                System.out.println("Dime tu nombre");
                nombre = sc.nextLine();

                Matcher mat = patNombre.matcher(nombre);

                if (mat.matches()) {
                    error = false;
                } else {
                    System.out.println("El nombre debe tener entre 2 y 30 caracteres y contener solo letras.");
                }

            } catch (Exception e){
                System.out.println("No has metido un nombre correcto");
            }
        } while (error);

        // Apellido de jugador
        // Validación: Debe tener entre 2 y 30 caracteres y contener solo letras (y espacios).

        do{
            try{
                error = true;
                System.out.println("Dime tu apellido");
                apellido = sc.nextLine();

                Matcher mat = patNombre.matcher(apellido);

                if (mat.matches()) {
                    error = false;
                } else {
                    System.out.println("El apellido debe tener entre 2 y 30 caracteres y contener solo letras.");
                }
            } catch(Exception e){
                System.out.println("No has metido un apellido correcto");
            }
        } while(error);

        // Nacionalidad de jugador
        // Validación: igual que el nombre y apellido.
        do{
            try{
                error = true;
                System.out.println("Dime tu nacionalidad");
                nacionalidad = sc.nextLine();

                Matcher mat = patNombre.matcher(nacionalidad);

                if (mat.matches()) {
                    error = false;
                } else {
                    System.out.println("La nacionalidad debe tener entre 2 y 30 caracteres y contener solo letras.");
                }

            }catch(Exception e){
                System.out.println("No has metido una nacionalidad correcta");
            }
        }while(error);

        // Fecha de nacimiento del jugador
        // Validación: que sea mayor de 18 años
        do{
            try{
                error = true;
                System.out.println("Fecha de nacimiento (dd/MM/yyyy)");
                String entrada = sc.nextLine();
                fechaNac = LocalDate.parse(entrada, formato);

                if(fechaNac.isAfter(fechaLimite)){
                    System.out.println("El jugador debe ser mayor de 18 años");
                } else{
                    error = false;
                }
            } catch (DateTimeParseException e){
                System.out.println("Formato de fecha incorrecta.");
            } catch(Exception e){
                System.out.println("Error en la lectura.");
            }
        } while(error);

        // Nickname del jugador
        // Validación: Puede contener letras, caracteres y barrabajas.
        do{
            try{
                error = true;
                System.out.println("Dime tu nickname");
                nickname = sc.nextLine();

                Matcher mat = patNick.matcher(nickname);

                if (mat.matches()) {
                    error = false;
                } else {
                    System.out.println("El nickname debe tener entre 2 y 30 caracteres.");
                }
            } catch(Exception e){
                System.out.println("No has metido un nickname correcto");
            }
        } while(error);

        // Rol del jugador
        // Validación: puede ser Healer, DPS o Tanque
        do{
            try{
                error = true;
                System.out.println("Dime tu rol (Healer, DPS, Tanque)");
                rol = sc.nextLine();

                if(rol.equalsIgnoreCase("healer") || rol.equalsIgnoreCase("DPS") || rol.equalsIgnoreCase("Tanque")){
                    error = false;
                } else{
                    System.out.println("Error: rol no válido.");
                }
            } catch(Exception e){
                System.out.println("Error al leer la entrada por consola.");
            }
        } while(error);

        // Sueldo del jugador
        // Validación: tiene que ser mayor al SMI
        do{
            try{
                error = true;
                System.out.println("Sueldo en euros: ");
                sueldo = sc.nextDouble();

                if(sueldo > SMI){
                    error = false;
                } else{
                    System.out.println("Error: el sueldo debe ser mayor al SMI");
                }
            } catch(InputMismatchException e){
                System.out.println("No has metido un numero correcto");
                sc.nextLine();
            }
        } while(error);
        return jugador.append("=====DATOS DEL EQUIPO=====\n")
                .append("DNI del jugador: ").append(dniJugador)
                .append("\n")
                .append("Nombre del jugador: ").append(nombre)
                .append("\n")
                .append("Apellido del jugador: ").append(apellido)
                .append("\n")
                .append("Nacionalidad del jugador: ").append(nacionalidad)
                .append("\n")
                .append("Fecha de nacimiento: ").append(fechaNac)
                .append("\n")
                .append("Nickname: ").append(nickname)
                .append("\n")
                .append("Rol: ").append(rol)
                .append("\n")
                .append("Sueldo: ").append(sueldo)
                .append("\n")
                ;
    }
}