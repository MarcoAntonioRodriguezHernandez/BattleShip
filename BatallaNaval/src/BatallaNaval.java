import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class BatallaNaval {

    public static Scanner lector = new Scanner(System.in);
    public static int counterp1 = 0;
    public static int counterp2 = 0;
    ArrayList<String> jugadores = new ArrayList<String>();
    public static int []count = new int [2];

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        ArrayList<String> jugadores = new ArrayList<>();
        ArrayList<int[][]> asf = new ArrayList<>();

        boolean game = false;
        boolean verificacion = false;

        while (!game) {
            System.out.println("⚓\uD83E\uDE96============ Bienvenido a Battle Ship ============\uD83E\uDE96⚓");
            System.out.println("¿Que desea hacer?");
            System.out.println("1........ Jugar\uD83D\uDD2B");
            System.out.println("2........ Salir❌");
            int accion = leer.nextInt();
            accion = veri(verificacion, accion, 1, 2);

            if (accion == 1) {
                System.out.println("\uD83E\uDEE1 Ingresa el nombre del jugador " + 1 + ": ");
                String playername = lector.next();
                jugadores.add(playername);
                System.out.println("\uD83E\uDEE1 Ingresa el nombre del jugador " + 2 + ": ");
                playername = lector.next();
                jugadores.add(playername);

                int nfilas = 0;
                int ncolumnas = 0;
                int fila = 0;
                int columna = 0;

                System.out.println("***********\uD83D\uDDFA Ingresa el tamaño deseado de tu tablero \uD83D\uDDFA***********");
                System.out.println("Numero de columnas:");
                ncolumnas = leer.nextInt();
                System.out.println("Numero de filas:");
                nfilas = leer.nextInt();

                int[][] tablerovisual = new int[nfilas][ncolumnas];
                int[][] tableroPy1 = new int[nfilas][ncolumnas];
                int[][] tableroPy2 = new int[nfilas][ncolumnas];
                int[][] tabenemigo1 = new int[nfilas][ncolumnas];
                int[][] tabenemigo2 = new int[nfilas][ncolumnas];

                asf.add(tableroPy1);
                asf.add(tableroPy2);


                System.out.println("Este es tu tablero: ");
                for (int i = 0; i < nfilas; i++) {
                    for (int j = 0; j < ncolumnas; j++) {
                        System.out.print(tablerovisual[i][j] + " ");
                    }
                    System.out.println("");
                }


                System.out.println("Ingresa el número de barcos que desee tener (minimo 1 y maximo 4)");
                int btotales = leer.nextInt();
                btotales = vf(btotales, 1, 4);

                if (btotales == 1) {
                    System.out.println("==========\uD83E\uDEE1 Jugador 1 \uD83E\uDEE1==========");
                    shipsadd(btotales, tableroPy1, nfilas, ncolumnas, fila, columna);
                    System.out.println("==========\uD83E\uDEE1 Jugador 2 \uD83E\uDEE1==========");
                    shipsadd(btotales, tableroPy2, nfilas, ncolumnas, fila, columna);
                } else if (btotales == 2) {
                    System.out.println("==========\uD83E\uDEE1 Jugador 1 \uD83E\uDEE1==========");
                    shipsadd(btotales, tableroPy1, nfilas, ncolumnas, fila, columna);
                    System.out.println("==========\uD83E\uDEE1 Jugador 2 \uD83E\uDEE1==========");
                    shipsadd(btotales, tableroPy2, nfilas, ncolumnas, fila, columna);
                } else if (btotales == 3) {
                    System.out.println("==========\uD83E\uDEE1 Jugador 1 \uD83E\uDEE1==========");
                    shipsadd(btotales, tableroPy1, nfilas, ncolumnas, fila, columna);
                    System.out.println("==========\uD83E\uDEE1 Jugador 2 \uD83E\uDEE1==========");
                    shipsadd(btotales, tableroPy2, nfilas, ncolumnas, fila, columna);
                } else if (btotales == 4) {
                    System.out.println("==========\uD83E\uDEE1 Jugador 1 \uD83E\uDEE1==========");
                    shipsadd(btotales, tableroPy1, nfilas, ncolumnas, fila, columna);
                    System.out.println("==========\uD83E\uDEE1 Jugador 2 \uD83E\uDEE1==========");
                    shipsadd(btotales, tableroPy2, nfilas, ncolumnas, fila, columna);
                }

                int tfila = 0;
                int tcolumna = 0;
                int ptsP1 = 0;
                int ptsP2 = 0;
                int player = 0;
                boolean tiros = false;
                boolean tiro = false;

                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                while (!tiros) {
                    System.out.println("Turno de: " + jugadores.get(0));
                    System.out.println("Este es el territorio enemigo: \uD83D\uDDFA");
                    for (int i = 0; i < nfilas; i++) {
                        for (int j = 0; j < ncolumnas; j++) {
                            System.out.print(tabenemigo2[i][j] + " ");
                        }
                        System.out.println(" ");
                    }
                    player = 1;
                    tiro = tiradas(jugadores, tableroPy2, tfila, tcolumna, nfilas, ncolumnas, btotales, ptsP1, tiros, tiro, player);
                    if (tiro) {
                        System.out.println("============= La partida a finalizado =============");
                        System.out.println("El ganador es el jugador: " + jugadores.get(0) + " con una puntuacion de: " + counterp1);
                        game = true;
                        tiros = true;
                    }
                    if (tiros) {

                    } else {
                        System.out.println("Turno de: " + jugadores.get(1));
                        System.out.println("Este es el territorio enemigo: \uD83D\uDDFA");
                        for (int i = 0; i < nfilas; i++) {
                            for (int j = 0; j < ncolumnas; j++) {
                                System.out.print(tabenemigo1[i][j] + " ");
                            }
                            System.out.println(" ");
                        }
                        player = 2;
                        tiro = tiradas(jugadores, tableroPy1, tfila, tcolumna, nfilas, ncolumnas, btotales, ptsP2, tiros, tiro, player);
                        if (tiro) {
                            System.out.println("============= La partida a finalizado =============");
                            System.out.println("El ganador es el jugador: " + jugadores.get(1) + " con una puntuacion de: " + counterp2);
                            game = true;
                            tiros = true;
                        }
                    }

                }

            } else if (accion == 2) {
                game = true;
            }


        }
    }

    //=========================================================================================================================================
    public static int veri(boolean verificacion, int accion, int p1, int p2) {
        while (!verificacion) {
            if (accion >= p1 && accion <= p2) {
                verificacion = true;
            } else {
                System.out.println("Los valores introducidos no son validos, intentalo de nuevo");
                accion = lector.nextInt();
            }
        }
        return accion;

    }

    public static int vf(int numero, int p1, int p2) {
        boolean x = false;
        while (!x) {
            if (numero >= p1 && numero <= p2) {
                x = true;
            } else {
                System.out.println("Los valores introducidos no son validos, intentalo de nuevo");
                numero = lector.nextInt();
            }
        }
        return numero;
    }


    public static void shipsadd(int btotales, int[][] tableroPy, int nfilas, int ncolumnas, int fila, int columna) {
        boolean x = false;
        while (!x) {
            for (int i = 0; i <= btotales; i++) {
                if (i >= btotales) {
                    x = true;
                } else {
                    System.out.println("Ingresa la coordenada en fila de tu barco " + (i + 1));
                    fila = lector.nextInt();
                    fila -= 1;
                    fila = vf(fila, 0, nfilas);
                    System.out.println("Ingresa las coordenada en columna de tu barco " + (i + 1));
                    columna = lector.nextInt();
                    columna -= 1;
                    columna = vf(columna, 0, ncolumnas);
                    tableroPy[fila][columna] = 1;
                }

            }

        }
    }

    public static boolean tiradas(ArrayList<String> jugadores, int[][] tableroPy, int tfila, int tcolumna, int nfilas, int ncolumnas, int btotales, int pts, boolean tiros, boolean tiro, int player) {
        System.out.println("¿En donde desea lanzar un misil?\uD83D\uDE80");

        System.out.println("Posicion en fila: ");
        tfila = lector.nextInt();
        tfila -= 1;
        tfila = vf(tfila, 0, nfilas);
        System.out.println("Posicion en columna: ");
        tcolumna = lector.nextInt();
        tcolumna -= 1;
        tcolumna = vf(tcolumna, 0, ncolumnas);

        System.out.println("⭕ Fijando coordenadas ⭕");
        System.out.println("‼Coordenadas fijadas‼");
        if (tableroPy[tfila][tcolumna] == -1) {
            boolean y = false;
            while (!y) {
                System.out.println("Ya has lanzado un misil a esa posición, intenta otra: ");
                System.out.println("Posicion en fila: ");
                tfila = lector.nextInt();
                tfila -= 1;
                tfila = vf(tfila, 0, nfilas);
                System.out.println("Posicion en columna: ");
                tcolumna = lector.nextInt();
                tcolumna -= 1;
                tcolumna = vf(tcolumna, 0, ncolumnas);
                if (tableroPy[tfila][tcolumna] == 1) {
                    System.out.println("Disparando...\uD83D\uDE80");
                    System.out.println("✔Impacto directo✔");
                    pts += 10;
                    if(player == 1){
                    count[0] += 1;
                    } else if (player == 2) {
                        count[1] += 1;
                    }
                    tiros = puntos(count, btotales, tiros);
                    tableroPy[tfila][tcolumna] = -1;
                } else if (tableroPy[tfila][tcolumna] == 0) {
                    System.out.println("Disparando...\uD83D\uDE80");
                    System.out.println("❌ Impacto fallido ❌");
                    tableroPy[tfila][tcolumna] = -1;
                }
                if (tableroPy[tfila][tcolumna] == 0) {
                    y = true;
                }
            }
        } else if (tableroPy[tfila][tcolumna] == 1) {
            System.out.println("Disparando...\uD83D\uDE80");
            System.out.println("✔Impacto directo✔");
            pts += 10;
            if(player == 1){
                count[0] += 1;
            } else if (player == 2) {
                count[1] += 1;
            }
            tiros = puntos(count, btotales, tiros);
            tableroPy[tfila][tcolumna] = -1;
        } else if (tableroPy[tfila][tcolumna] == 0) {
            System.out.println("Disparando...\uD83D\uDE80");
            System.out.println("❌ Impacto fallido ❌");
            tableroPy[tfila][tcolumna] = -1;
        }
        return tiros;
    }

    public static boolean puntos(int count[], int btotales, boolean tiros) {
        if (count[0] >= btotales) {
            tiros = true;
        } else if (count[1] >= btotales) {
            tiros = true;
        }
        else{
            tiros = false;
        }
        return tiros;
    }
}