import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ArrayList<String> partida = new ArrayList<>();
        ArrayList<String> jugadores = new ArrayList<>();
        boolean game = false;
        boolean verificacion = false;

        while (!game) {
            System.out.println("⚓\uD83E\uDE96============ Bienvenido a Battle Ship ============\uD83E\uDE96⚓");
            System.out.println("¿Que desea hacer?");
            System.out.println("1........ Jugar\uD83D\uDD2B");
            System.out.println("2........ Salir❌");
            int accion = leer.nextInt();

            accion = veri(verificacion, accion, 3, 0);

            if (accion == 1) {
                //Agregar nombre de jugadores
                System.out.println("Ingresa el nombre del primer jugador: \uD83E\uDEE1");
                String jugador1 = leer.next();
                System.out.println("Ingresa el nombre del segundo jugador: \uD83E\uDEE1");
                String jugador2 = leer.next();
                jugadores.add(jugador1);
                jugadores.add(jugador2);
                System.out.println("Los jugadores son: " + jugadores.get(0) + " \uD83E\uDEE1 y " + jugadores.get(1) + " \uD83E\uDEE1");

                int nfilas = 0;
                int ncolumnas = 0;
                int F = 0;
                int C = 0;

                System.out.println("***********\uD83D\uDDFA Ingresa el tamaño de tu tablero \uD83D\uDDFA***********");
                System.out.println("Numero de columnas: ");
                ncolumnas = leer.nextInt();
                System.out.println("Numero de filas: ");
                nfilas = leer.nextInt();

                //Creacion del arreglos bidimensional
                int[][] tablero = new int[nfilas][ncolumnas];
                int[][] tablero1 = new int[nfilas][ncolumnas];
                int[][] tablero2 = new int[nfilas][ncolumnas];
                System.out.println("Este es su tablero : ");

                for (int i = 0; i < nfilas; i++) {
                    for (int j = 0; j < ncolumnas; j++) {
                        System.out.print(" o ");
                    }
                    System.out.println(" ");
                }
                //Solicitar el numero de barcos que desea
                System.out.println("\uD83D\uDEF3Ingresa el número de barcos que desee tener (minimo 1 y maximo 4)\uD83D\uDEF3");
                int btotales = leer.nextInt();

                btotales = vf(btotales, 5, 0);

                if (btotales == 1) {
                    System.out.println("===========\uD83E\uDEE1 Jugador 1 \uD83E\uDEE1===========");
                    int player1 = 1;
                    agregarbarcos(btotales, player1, F, C, tablero1, nfilas, ncolumnas);
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("===========\uD83E\uDEE1 Jugador 2 \uD83E\uDEE1===========");
                    int player2 = 2;
                    agregarbarcos(btotales, player2, F, C, tablero2, nfilas, ncolumnas);

                } else if (btotales == 2) {
                    System.out.println("===========\uD83E\uDEE1 Jugador 1 \uD83E\uDEE1===========");
                    int player1 = 1;
                    agregarbarcos(btotales, player1, F, C, tablero1, nfilas, ncolumnas);
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("===========\uD83E\uDEE1 Jugador 2 \uD83E\uDEE1===========");
                    int player2 = 1;
                    agregarbarcos(btotales, player2, F, C, tablero2, nfilas, ncolumnas);

                } else if (btotales == 3) {
                    System.out.println("===========\uD83E\uDEE1 Jugador 1 \uD83E\uDEE1===========");
                    int player1 = 1;
                    agregarbarcos(btotales, player1, F, C, tablero1, nfilas, ncolumnas);
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("===========\uD83E\uDEE1 Jugador 2 \uD83E\uDEE1===========");
                    int player2 = 1;
                    agregarbarcos(btotales, player2, F, C, tablero2, nfilas, ncolumnas);

                } else if (btotales == 4) {
                    System.out.println("===========\uD83E\uDEE1 Jugador 1 \uD83E\uDEE1===========");
                    int player1 = 1;
                    agregarbarcos(btotales, player1, F, C, tablero1, nfilas, ncolumnas);
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("===========\uD83E\uDEE1 Jugador 2 \uD83E\uDEE1===========");
                    int player2 = 1;
                    agregarbarcos(btotales, player2, F, C, tablero2, nfilas, ncolumnas);
                }

                //Aqui comienzan las tiradas
                int misiFila = 0;
                int misiColumna = 0;
                int ptosPlayer1 = 0;
                int ptosPlayer2 = 0;

                boolean shoots = false;
                while (!shoots) {

                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("//////// Turno del jugador 1 ////////");
                    int jugador = 1;
                    System.out.println("Este es el territorio enemigo: \uD83D\uDDFA");
                    for (int i = 0; i < nfilas; i++) {
                        for (int j = 0; j < ncolumnas; j++) {
                            System.out.print(tablero[i][j] + " ");
                        }
                        System.out.println("");
                    }

                    disparos(jugador, tablero2, tablero1, misiFila, misiColumna, nfilas, ncolumnas, ptosPlayer1, ptosPlayer2);

                    System.out.println("//////// Turno del jugador 2 ////////");
                    System.out.println("Este es el territorio enemigo: \uD83D\uDDFA");

                    for (int i = 0; i < nfilas; i++) {
                        for (int j = 0; j < ncolumnas; j++) {
                            System.out.print(tablero[i][j] + " ");
                        }
                        System.out.println("");
                    }

                    disparos(jugador, tablero2, tablero1, misiFila, misiColumna, nfilas, ncolumnas, ptosPlayer1, ptosPlayer2);
                /*
                System.out.println("¿En donde desea lanzar un misil?\uD83D\uDE80");
                System.out.println("Posicion en filas: ");
                misiFila = leer.nextInt();
                misiFila = vf(misiFila-1, nfilas+1, -1);
                System.out.println("Posicion en columnas: ");
                misiColumna = leer.nextInt();
                misiColumna = vf(misiColumna, ncolumnas+1, -1);
                System.out.println("⚠⚠ Fijando coordenadas ⚠⚠");
                System.out.println("‼Coordenadas fijadas‼");
                System.out.println("Disparando...\uD83D\uDE80");
                if(tablero1[misiFila][misiColumna] == 0){
                    System.out.println("❌ Impacto fallido ❌");
                }
                else{
                    System.out.println("✔Impacto directo✔");
                }
                */
                }
            } else if (accion == 2) {
                game = true;
            }
        }


    }

    public static int veri(boolean verificacion, int accion, int p1, int p2) {
        while (!verificacion) {
            if (accion < p1 && accion > p2) {
                verificacion = true;
            } else {
                System.out.println("Los valores introducidos no son validos, intentelo de nuevo.");
                accion = lector.nextInt();
            }
        }
        return accion;
    }

    //Funcion de verificacion sin booleano
    public static int vf(int acc, int p1, int p2) {
        boolean verifi = false;
        while (!verifi) {
            if (acc < p1 && acc > p2) {
                verifi = true;
            } else {
                System.out.println("Los valores introducidos no son validos, intentelo de nuevo.");
                acc = lector.nextInt();
            }
        }
        return acc;
    }

    //Funcion destinada para agregar barcos
    public static void agregarbarcos(int btotales, int jugador, int F, int C, int[][] tablero, int nfilas, int ncolumnas) {

        if (jugador == 1) {
            System.out.println("Ingrese las cordenadas donde pondra sus barcos:");
            for (int i = 0; i <= btotales - 1; i++) {
                System.out.println("Ingrese la posicion en fila del barco " + (i + 1));
                F = lector.nextInt();
                F -= 1;
                F = vf(F, nfilas + 1, -1);
                System.out.println("Ingrese la posicion en columna del barco " + (i + 1));
                C = lector.nextInt();
                C -= 1;
                C = vf(C, ncolumnas + 1, -1);
                System.out.println("Ingrese un numero identificador para su barco");
                tablero[F][C] = lector.nextInt();
            }
            jugador = 0;
            if (jugador == 0) {
                for (int i = 0; i < nfilas; i++) {
                    for (int j = 0; j < ncolumnas; j++) {
                        System.out.print(tablero[i][j] + " ");
                    }
                    System.out.println("");
                }
            }
        } else if (jugador == 2) {
            System.out.println("Ingrese las cordenadas donde pondra sus barcos: ");
            for (int i = 0; i <= btotales - 1; i++) {

                System.out.println("Ingrese la posicion en fila del barco " + (i + 1));
                F = lector.nextInt();
                F -= 1;
                F = vf(F, nfilas + 1, -1);
                System.out.println("Ingrese la posicion en columna del barco " + (i + 1));
                C = lector.nextInt();
                C -= 1;
                C = vf(C, ncolumnas + 1, -1);
                System.out.println("Ingrese un numero identificador para su barco");
                tablero[F][C] = lector.nextInt();
            }
            jugador = 0;
            if (jugador == 0) {
                for (int i = 0; i < nfilas; i++) {
                    for (int j = 0; j < ncolumnas; j++) {
                        System.out.print(tablero[i][j] + " ");
                    }
                    System.out.println("");
                }
            }
        }

    }

    public static int disparos(int jugador, int[][] tablero2, int[][] tablero1, int misiFila, int misiColumna, int nfilas, int ncolumnas, int ptosPlayer1, int ptosPlayer2) {


        if (jugador == 1) {
            System.out.println("¿En donde desea lanzar un misil?\uD83D\uDE80");
            System.out.println("Posicion en filas: ");
            misiFila = lector.nextInt();
            misiFila = vf(misiFila, nfilas + 1, -1);
            System.out.println("Posicion en columnas: ");
            misiColumna = lector.nextInt();
            misiColumna = vf(misiColumna, ncolumnas + 1, -1);
            System.out.println("⭕ Fijando coordenadas ⭕");
            System.out.println("‼Coordenadas fijadas‼");
            System.out.println("Disparando...\uD83D\uDE80");
            if (tablero2[misiFila - 1][misiColumna - 1] == -2) {
                System.out.println("Ya has lanzado un misil a esa posición, intenta otra: ");


            } else if (tablero2[misiFila - 1][misiColumna - 1] == 1) {
                System.out.println("✔Impacto directo✔");
                ptosPlayer1 += 10;
                tablero2[misiFila - 1][misiColumna - 1] = -2;

            } else if (tablero2[misiFila - 1][misiColumna - 1] == 0) {
                System.out.println("❌ Impacto fallido ❌");

            }
        } else if (jugador == 2) {
            System.out.println("¿En donde desea lanzar un misil?\uD83D\uDE80");
            System.out.println("Posicion en filas: ");
            misiFila = lector.nextInt();
            misiFila = vf(misiFila, nfilas + 1, -1);
            System.out.println("Posicion en columnas: ");
            misiColumna = lector.nextInt();
            misiColumna = vf(misiColumna, ncolumnas + 1, -1);
            System.out.println("⭕ Fijando coordenadas ⭕");
            System.out.println("‼Coordenadas fijadas‼");
            System.out.println("Disparando...\uD83D\uDE80");
            if (tablero1[misiFila - 1][misiColumna - 1] == -2) {
                System.out.println("Ya has lanzado un misil a esa posición, intenta otra: ");


            } else if (tablero1[misiFila - 1][misiColumna - 1] == 1) {
                System.out.println("✔Impacto directo✔");
                ptosPlayer2 += 10;
                tablero1[misiFila - 1][misiColumna - 1] = -2;

            } else if (tablero1[misiFila - 1][misiColumna - 1] == 0) {
                System.out.println("❌ Impacto fallido ❌");

            }
        }
        return 5;

    }

}