package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.util.Scanner;

public class MiEntradaSalida {

    // 1. El Scanner se hace PRIVADO para protegerlo.
    // Solo esta clase puede usarlo.
    private static Scanner sc = new Scanner(System.in);


    public static int solicitarEntero(String mensaje) {
        // Variable que almacenará el entero introducido por teclado.
        int integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                integer = Integer.parseInt(sc.nextLine());
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico.
                System.out.println("Error: Debe introducir un número entero.");
            }


        }


        return integer;
    }


    public static int solicitarEnteroPositivo(String mensaje) {
        // Variable que almacenará el entero introducido por teclado.
        int integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto.
            try {
                integer = Integer.parseInt(sc.nextLine());


                // Comprobamos la segunda condición: que sea positivo.
                if (integer >= 0) {
                    // Si llegamos hasta aquí, el dato es correcto.
                    flag = false;
                } else {
                    // 2. Mensaje de error específico (error de lógica, no de formato).
                    System.out.println("Error: El número debe ser positivo o cero.");
                }
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico (error de formato).
                System.out.println("Error: Debe introducir un número entero.");
            }


        }


        return integer;
    }


    public static int solicitarEnteroEnRango(String mensaje, int limiteInferior, int limiteSuperior) {
        // Variable que almacenará el entero introducido por teclado.
        int integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto.
            try {
                integer = Integer.parseInt(sc.nextLine());


                // Comprobamos la segunda condición: el rango.
                if (integer >= limiteInferior && integer <= limiteSuperior) {
                    // Si llegamos hasta aquí, el dato es correcto.
                    flag = false;
                } else {
                    // 2. Mensaje de error específico (error de lógica).
                    System.out.println("Error: El número debe estar entre " + limiteInferior + " y " + limiteSuperior + ".");
                }
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico (error de formato).
                System.out.println("Error: Debe introducir un número entero.");
            }


        }


        return integer;
    }


    public static char solicitarCaracter(String mensaje) {
        char c = '0';
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el carácter por pantalla.
            System.out.println(mensaje);


            try {
                // Obtenemos el primer carácter de la línea.
                c = sc.nextLine().charAt(0);
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción (porque el usuario no escribió nada).
            catch (StringIndexOutOfBoundsException e) { // Es más específico que IndexOutOfBoundsException
                // 2. Mensaje de error específico.
                System.out.println("Error: No ha introducido ningún carácter. Inténtelo de nuevo.");
            }


        }


        return c;
    }


    public static char solicitarCaracterSN(String mensaje) {
        char c = '0';
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el carácter por pantalla.
            System.out.println(mensaje);


            String cadena = sc.nextLine();


            // Comprobamos que la longitud sea de 1 solo carácter.
            if (cadena.length() == 1) {
                c = cadena.toUpperCase().charAt(0);


                // Comprobamos si es S o N.
                if (c == 'S' || c == 'N') {
                    // Si llegamos hasta aquí, el dato es correcto.
                    flag = false;
                } else {
                    // 2. Mensaje de error específico (carácter incorrecto).
                    System.out.println("Error: Respuesta no válida. Debe introducir 'S' o 'N'.");
                }
            } else {
                // 2. Mensaje de error específico (longitud incorrecta).
                System.out.println("Error: Debe introducir un solo carácter ('S' o 'N').");
            }
        }


        return c;
    }


    public static String solicitarCadena(String mensaje) {
        String cadena = "";
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el string por pantalla.
            System.out.println(mensaje);


            // 3. Usamos .trim() para eliminar espacios en blanco al inicio y al final.
            cadena = sc.nextLine().trim();


            // Comprobamos que la cadena no esté vacía después de quitarle los espacios.
            if (!cadena.isEmpty()) {
                // Si llegamos hasta aquí, el dato es correcto.
                flag = false;
            } else {
                // 2. Mensaje de error específico.
                System.out.println("Error: No puede introducir una cadena vacía.");
            }
        }


        return cadena;
    }


    public static char solicitarCaracter(String mensaje, char caracter) {
        char c = '0';
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el carácter por pantalla.
            System.out.println(mensaje);


            try {
                // Obtenemos el primer carácter de la línea.
                c = sc.nextLine().charAt(0);
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción (porque el usuario no escribió nada).
            catch (StringIndexOutOfBoundsException e) { // Es más específico que IndexOutOfBoundsException
                // 2. Mensaje de error específico.
                System.out.println("Error: No ha introducido ningún carácter. Inténtelo de nuevo.");
            }
        }
        return c;
    }


    public static float solicitarFloatEnRango(String mensaje, float limiteInferior, float limiteSuperior) {
        float flotante = 0;
        boolean flag = true;
        while (flag) {
            System.out.println(mensaje);
            try {
                flotante = Float.parseFloat(sc.nextLine());
                if (flotante >= limiteInferior && flotante <= limiteSuperior) {
                    flag = false;
                } else {
                    System.out.println("Error: El número debe estar entre " + limiteInferior + " y " + limiteSuperior + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe introducir un número decimal válido.");
            }
        }
        return flotante;
    }


    public static char solicitarCaracterFM(String mensaje) {
        char c = '0';
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el carácter por pantalla.
            System.out.println(mensaje);


            String cadena = sc.nextLine();


            // Comprobamos que la longitud sea de 1 solo carácter.
            if (cadena.length() == 1) {
                c = cadena.toUpperCase().charAt(0);


                // Comprobamos si es S o N.
                if (c == 'F' || c == 'M') {
                    // Si llegamos hasta aquí, el dato es correcto.
                    flag = false;
                } else {
                    // 2. Mensaje de error específico (carácter incorrecto).
                    System.out.println("Error: Respuesta no válida. Debe introducir 'F' o 'M'.");
                }
            }
        }


        return c;
    }


    public static double solicitarDoublePositivo(String mensaje) {
        double decimal = 0;
        boolean flag = true;
        while (flag) {
            System.out.println(mensaje);
            try {
                decimal = Double.parseDouble(sc.nextLine());
                if (decimal >= 0) {
                    flag = false;
                } else {
                    System.out.println("Error: El número debe ser positivo o cero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe introducir un número decimal válido.");
            }
        }
        return decimal;
    }


    public static LocalDate solicitarLocalDate(String mensaje) {
        System.out.println(mensaje);
        // 3. Le pedimos la fecha al usuario en año, mes y día
        int dia = solicitarEnteroEnRango("Introduce el día", 1, 31);
        int mes = solicitarEnteroEnRango("Introduce el mes", 1, 12);
        int anyo = solicitarEntero("Introduce el año");
        LocalDate localDate = LocalDate.of(anyo, mes, dia);
        return localDate;
    }


    public static Period solicitarPeriodo(String mensaje) {
        System.out.println(mensaje);
        // 3. Le pedimos al usuario los años, meses y días del periodo
        int anyo = solicitarEnteroPositivo("Introduce los años");
        int mes = solicitarEnteroPositivo("Introduce los meses");
        int dia = solicitarEntero("Introduce los días");
        Period periodo = Period.of(dia, mes, anyo);
        return periodo;
    }


    public static boolean solicitarBoolean(String mensaje) {
        char c = '0';
        boolean booleano = true;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el carácter por pantalla.
            System.out.println(mensaje);


            String cadena = sc.nextLine();


            // Comprobamos que la longitud sea de 1 solo carácter.
            if (cadena.length() == 1) {
                c = cadena.toUpperCase().charAt(0);


                // Comprobamos si es S o N.
                if (c == 'S' || c == 'N') {
                    // Si llegamos hasta aquí, el dato es correcto.
                    flag = false;
                } else {
                    // 2. Mensaje de error específico (carácter incorrecto).
                    System.out.println("Error: Respuesta no válida. Debe introducir 'S' o 'N'.");
                }
            } else {
                // 2. Mensaje de error específico (longitud incorrecta).
                System.out.println("Error: Debe introducir un solo carácter ('S' o 'N').");
            }
        }
        if (c == 'N') {
            booleano = false;
        }
        return booleano;
    }

    public static LocalDate sumarDiasMesesAnyosAFecha(LocalDate fecha, Period periodo) {
        fecha = fecha.plusDays(periodo.getDays());
        fecha = fecha.plusMonths(periodo.getMonths());
        fecha = fecha.plusYears(periodo.getYears());
        return fecha;
    }

    public static boolean generarBooleanAleatorio() {
        // 1. Crear una instancia de Random
        Random generador = new Random();
        // 2. Generar el boolean aleatorio
        boolean valorAleatorio = generador.nextBoolean();
        return valorAleatorio;
    }

    public static boolean noTieneVocales(String texto) {
        // Si coincide con el patrón de tener vocales, devolvemos false
        if (texto.matches(".*[aeiouAEIOU].*")) {
            return false;
        }
        return true; // Si no tenía ninguna, es válido
    }

    public static boolean esTodoMinusculas(String texto) {
        if (texto.isEmpty()) {
            return false;
        }

        for (int i = 0; i < texto.length(); i++) {
            char letraActual = texto.charAt(i);

            // Si la letra NO es minúscula, devolvemos false inmediatamente
            if (!Character.isLowerCase(letraActual)) {
                return false;
            }
        }

        return true;
    }

    public static boolean esTodoMayusculas(String texto) {
        // Si el texto está vacío, ya no nos vale
        if (texto.isEmpty()) {
            return false;
        }

        // Recorremos el String posición por posición
        for (int i = 0; i < texto.length(); i++) {
            char letraActual = texto.charAt(i);

            // Si la letra NO es mayúscula, el texto ya está mal y salimos
            if (!Character.isUpperCase(letraActual)) {
                return false;
            }
        }

        // Si el bucle termina y nadie ha devuelto false, es que todo estaba perfecto
        return true;
    }

    public static boolean esTodoNumeros(String texto) {
        if (texto == null || texto.isEmpty()) return false;
        return texto.matches("[0-9]+");
    }

    public static boolean ComprobarIntEnRango(int valor, int min, int max) {
        boolean encontrado = false;
        if (valor >= min && valor <= max) {
            encontrado = true;
        }
        return encontrado;
    }

    public static boolean ComprobarDoubleEnRango(double valor, double min, double max) {
        boolean encontrado = false;
        if (valor >= min && valor <= max) {
            encontrado = true;
        }
        return encontrado;
    }

    public static int generarIntAleatorioEnRango(int min, int max) {
        Random random = new Random();
        // Genera un número aleatorio entre 10 y 50 (ambos incluidos)
        return min + random.nextInt(max - min + 1);
    }

    public static String solicitarCadenaNumeroBytesConcreto(int limite, String mensaje) {
        String cadena=solicitarCadena(mensaje);
        while(cadena.getBytes().length!=limite){
            System.out.println("Número de Bytes incorrecto, introduce otro texto");
            cadena=solicitarCadena(mensaje);
        }
        return cadena;
    }

    public static String solicitarCadenaConLimiteBytes(int limite, String mensaje) {
        String cadena=solicitarCadena(mensaje);
        while(cadena.getBytes().length>limite) {
            System.out.println("Número de Bytes incorrecto, introduce otro texto");
            cadena = solicitarCadena(mensaje);
        }
        return cadena;
    }
}