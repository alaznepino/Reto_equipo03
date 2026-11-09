# Reto_equipo03

Este código en Java es una aplicación de consola diseñada para gestionar y validar información de equipos y jugadores de eSports o videojuegos competitivos.

Funciona mediante un menú interactivo que permite introducir, verificar y mostrar datos estructurados asegurándose de que cumplan con ciertas reglas de validación.

¿Qué hace exactamente?
Menú Principal (menu):
Muestra opciones en pantalla para elegir entre registrar un equipo, registrar un jugador o salir del programa. Controla que el usuario introduzca un número entero válido.

Registro de Equipos (pedirEquipo):
Pide por consola y valida los siguientes datos:

Nombre del equipo: Debe tener entre 3 y 8 caracteres, sin espacios, permitiendo solo letras, números y guiones bajos (_).

Fecha de fundación: Se introduce en formato dd/MM/yyyy y comprueba que sea una fecha anterior al día actual.

Número de jugadores: Debe ser un valor numérico comprendido entre 2 y 6 integrantes.

Registro de Jugadores (pedirJugador):
Pide por consola y valida los detalles de un jugador:

Nombre, Apellido y Nacionalidad: Deben tener entre 2 y 30 caracteres y contener únicamente letras (y espacios), admitiendo tildes y eñes.

Fecha de nacimiento: Valida que el formato sea correcto y que el jugador sea mayor de 18 años.

Nickname: Permite letras, números, espacios y guiones bajos (de 2 a 30 caracteres).

Rol: Valida que pertenezca exclusivamente a uno de los tres roles permitidos: Healer, DPS o Tanque.

Equipo asociado: Valida el nombre del equipo con las mismas reglas del nickname.

Sueldo: Comprueba que sea una cantidad numérica mayor al Salario Mínimo Interprofesional establecido en el código (1221.00 €).

Al finalizar cada proceso, el programa recopila toda la información introducida, la formatea usando StringBuilder y muestra un resumen por pantalla. También incluye bloques de control de excepciones (try-catch) para evitar que el programa falle si el usuario introduce un tipo de dato incorrecto (por ejemplo, texto en lugar de un número).
