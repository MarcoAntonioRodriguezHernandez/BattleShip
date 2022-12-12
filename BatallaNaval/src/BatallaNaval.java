import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class BatallaNaval {

    public static Scanner lector = new Scanner(System.in);
    ArrayList<String> jugadores = new ArrayList<String>();
    public static int[] count = new int[2];
    public static int[] pts = new int[3];
    // Puntos a alcanzar de cada jugador
    // Posicion 0 = Jugador 1
    // Posicion 1 = Jugador 2


    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        ArrayList<String> jugadores = new ArrayList<>();

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
                int barcos = 0;
                int player = 0;

                if (btotales == 1) {
                    barcos = 1;
                    System.out.println("==========\uD83E\uDEE1 Jugador 1 \uD83E\uDEE1==========");
                    player = 1;
                    shipsadd(btotales, tableroPy1, nfilas, ncolumnas, fila, columna, barcos, player);
                    System.out.println("==========\uD83E\uDEE1 Jugador 2 \uD83E\uDEE1==========");
                    player = 2;
                    shipsadd(btotales, tableroPy2, nfilas, ncolumnas, fila, columna, barcos, player);
                } else if (btotales == 2) {
                    barcos = 2;
                    System.out.println("==========\uD83E\uDEE1 Jugador 1 \uD83E\uDEE1==========");
                    player = 1;
                    shipsadd(btotales, tableroPy1, nfilas, ncolumnas, fila, columna, barcos, player);
                    System.out.println("==========\uD83E\uDEE1 Jugador 2 \uD83E\uDEE1==========");
                    player = 2;
                    shipsadd(btotales, tableroPy2, nfilas, ncolumnas, fila, columna, barcos, player);
                } else if (btotales == 3) {
                    barcos = 3;
                    System.out.println("==========\uD83E\uDEE1 Jugador 1 \uD83E\uDEE1==========");
                    player = 1;
                    shipsadd(btotales, tableroPy1, nfilas, ncolumnas, fila, columna, barcos, player);
                    System.out.println("==========\uD83E\uDEE1 Jugador 2 \uD83E\uDEE1==========");
                    player = 2;
                    shipsadd(btotales, tableroPy2, nfilas, ncolumnas, fila, columna, barcos, player);
                } else if (btotales == 4) {
                    barcos = 4;
                    System.out.println("==========\uD83E\uDEE1 Jugador 1 \uD83E\uDEE1==========");
                    player = 1;
                    shipsadd(btotales, tableroPy1, nfilas, ncolumnas, fila, columna, barcos, player);
                    System.out.println("==========\uD83E\uDEE1 Jugador 2 \uD83E\uDEE1==========");
                    player = 2;
                    shipsadd(btotales, tableroPy2, nfilas, ncolumnas, fila, columna, barcos, player);
                }

                for (int i = 0; i < nfilas; i++) {
                    for (int j = 0; j < ncolumnas; j++) {
                        System.out.print(tableroPy1[i][j] + " ");
                    }
                    System.out.println(" ");
                }
                System.out.println("========================================");
                for (int i = 0; i < nfilas; i++) {
                    for (int j = 0; j < ncolumnas; j++) {
                        System.out.print(tableroPy2[i][j] + " ");
                    }
                    System.out.println(" ");
                }

                int tfila = 0;
                int tcolumna = 0;
                int ptsP1 = 0;
                int ptsP2 = 0;
                boolean tiros = false;
                boolean tiro = false;

                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                while (!tiros) {
                    System.out.println("Turno de: " + jugadores.get(0));
                    System.out.println("====================== Indice =======================");
                    System.out.println("========== Numero 0 = Espacio sin explorar ========== ");
                    System.out.println("========== Numero 8 = Espacio explorado sin exito === ");
                    System.out.println("========== Numero 2 = Espacio con impacto =========== ");
                    System.out.println("===================================================== ");
                    System.out.println("Este es el territorio enemigo: \uD83D\uDDFA");
                    for (int i = 0; i < nfilas; i++) {
                        for (int j = 0; j < ncolumnas; j++) {
                            System.out.print(tabenemigo2[i][j] + " ");
                        }
                        System.out.println(" ");
                    }
                    player = 1;
                    tiro = tiradas(jugadores, tableroPy2, tabenemigo2, tfila, tcolumna, nfilas, ncolumnas, btotales, ptsP1, tiros, tiro, player);
                    if (tiro) {
                        System.out.println("============= La partida a finalizado =============");
                        System.out.println("El ganador es el jugador: " + jugadores.get(0) + " con una puntuacion de: " + count[0]);
                        game = true;
                        tiros = true;
                    } else {
                        System.out.println("Turno de: " + jugadores.get(1));
                        System.out.println("====================== Indice =======================");
                        System.out.println("========== Numero 0 = Espacio sin explorar ========== ");
                        System.out.println("========== Numero 8 = Espacio explorado sin exito === ");
                        System.out.println("========== Numero 2 = Espacio con impacto =========== ");
                        System.out.println("===================================================== ");
                        System.out.println("Este es el territorio enemigo: \uD83D\uDDFA");
                        for (int i = 0; i < nfilas; i++) {
                            for (int j = 0; j < ncolumnas; j++) {
                                System.out.print(tabenemigo1[i][j] + " ");
                            }
                            System.out.println(" ");
                        }
                        player = 2;
                        tiro = tiradas(jugadores, tableroPy1, tabenemigo1, tfila, tcolumna, nfilas, ncolumnas, btotales, ptsP2, tiros, tiro, player);
                        if (tiro) {
                            System.out.println("============= La partida a finalizado =============");
                            System.out.println("El ganador es el jugador: " + jugadores.get(1) + " con una puntuacion de: " + count[1]);
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


    public static void shipsadd(int btotales, int[][] tableroPy, int nfilas, int ncolumnas, int fila, int columna, int barcos, int player) {
        for (int i = 0; i < btotales; i++) {
            System.out.println("De que tamaño deseea su barco " + (i + 1) + " (minimo 1 casilla y maximo 3)");
            barcos = lector.nextInt();
            barcos = vf(barcos, 1, 3);
            if (barcos == 1) {
                System.out.println("Ingresa la coordenada en fila de tu barco " + (i + 1));
                fila = lector.nextInt();
                fila -= 1;
                fila = vf(fila, 0, nfilas - 1);
                System.out.println("Ingresa la coordenada en columna de tu barco " + (i + 1));
                columna = lector.nextInt();
                columna -= 1;
                columna = vf(columna, 0, ncolumnas - 1);
                tableroPy[fila][columna] = 1;
                if (player == 1) {
                    pts[0] += 1;
                } else {
                    pts[1] += 1;
                }
            } else if (barcos == 2) {
                System.out.println("Ingresa la primer coordenada en fila de tu barco " + (i + 1));
                fila = lector.nextInt();
                fila -= 1;
                fila = vf(fila, 0, nfilas - 1);
                System.out.println("Ingresa la primer coordenada en columna de tu barco " + (i + 1));
                columna = lector.nextInt();
                columna -= 1;
                columna = vf(columna, 0, ncolumnas - 1);
                tableroPy[fila][columna] = 1;

                System.out.println("Ingresa la segunda coordenada en fila de tu barco " + (i + 1));
                fila = lector.nextInt();
                fila -= 1;
                fila = vf(fila, 0, nfilas - 1);
                System.out.println("Ingresa la segunda coordenada en columna de tu barco " + (i + 1));
                columna = lector.nextInt();
                columna -= 1;
                columna = vf(columna, 0, ncolumnas - 1);
                tableroPy[fila][columna] = 1;
                if (player == 1) {
                    pts[0] += 2;
                } else {
                    pts[1] += 2;
                }

            } else if (barcos == 3) {
                System.out.println("Ingresa la primer coordenada en fila de tu barco " + (i + 1));
                fila = lector.nextInt();
                fila -= 1;
                fila = vf(fila, 0, nfilas - 1);
                System.out.println("Ingresa la primer coordenada en columna de tu barco " + (i + 1));
                columna = lector.nextInt();
                columna -= 1;
                columna = vf(columna, 0, ncolumnas - 1);
                tableroPy[fila][columna] = 1;

                System.out.println("Ingresa la segunda coordenada en fila de tu barco " + (i + 1));
                fila = lector.nextInt();
                fila -= 1;
                fila = vf(fila, 0, nfilas - 1);
                System.out.println("Ingresa la segunda coordenada en columna de tu barco " + (i + 1));
                columna = lector.nextInt();
                columna -= 1;
                columna = vf(columna, 0, ncolumnas - 1);
                tableroPy[fila][columna] = 1;
                tableroPy[fila - 1][columna] = 1;
                if (player == 1) {
                    pts[0] += 3;
                } else {
                    pts[1] += 3;
                }
            }

        }

    }

    public static boolean tiradas(ArrayList<String> jugadores, int[][] tableroPy, int[][] tabenemigo, int tfila, int tcolumna, int nfilas, int ncolumnas, int btotales, int pts, boolean tiros, boolean tiro, int player) {
        System.out.println("¿En donde desea lanzar un misil?\uD83D\uDE80");

        System.out.println("Posicion en fila: ");
        tfila = lector.nextInt();
        tfila -= 1;
        tfila = vf(tfila, 0, nfilas - 1);
        System.out.println("Posicion en columna: ");
        tcolumna = lector.nextInt();
        tcolumna -= 1;
        tcolumna = vf(tcolumna, 0, ncolumnas - 1);

        System.out.println("⭕ Fijando coordenadas ⭕");
        System.out.println("‼Coordenadas fijadas‼");
        if (tableroPy[tfila][tcolumna] == -1) {
            boolean y = false;
            while (!y) {
                System.out.println("Ya has lanzado un misil a esa posición, intenta otra: ");
                System.out.println("Posicion en fila: ");
                tfila = lector.nextInt();
                tfila -= 1;
                tfila = vf(tfila, 0, nfilas - 1);
                System.out.println("Posicion en columna: ");
                tcolumna = lector.nextInt();
                tcolumna -= 1;
                tcolumna = vf(tcolumna, 0, ncolumnas - 1);
                if (tableroPy[tfila][tcolumna] == 1) {
                    System.out.println("Disparando...\uD83D\uDE80");
                    System.out.println("✔Impacto directo✔");
                    pts += 10;
                    if (player == 1) {
                        count[0] += 1;
                    } else if (player == 2) {
                        count[1] += 1;
                    }
                    tiros = points(count, btotales, tiros);
                    tableroPy[tfila][tcolumna] = -1;
                    tabenemigo[tfila][tcolumna] = 2;
                    y = true;
                } else if (tableroPy[tfila][tcolumna] == 0) {
                    System.out.println("Disparando...\uD83D\uDE80");
                    System.out.println("❌ Impacto fallido ❌");
                    tableroPy[tfila][tcolumna] = -1;
                    tabenemigo[tfila][tcolumna] = 8;
                    y = true;

                }
                if (tableroPy[tfila][tcolumna] == 0) {
                    y = true;
                }
            }
        } else if (tableroPy[tfila][tcolumna] == 1) {
            System.out.println("Disparando...\uD83D\uDE80");
            System.out.println("✔Impacto directo✔");
            pts += 10;
            if (player == 1) {
                count[0] += 1;
            } else if (player == 2) {
                count[1] += 1;
            }
            tiros = points(count, btotales, tiros);
            tableroPy[tfila][tcolumna] = -1;
            tabenemigo[tfila][tcolumna] = 2;
        } else if (tableroPy[tfila][tcolumna] == 0) {
            System.out.println("Disparando...\uD83D\uDE80");
            System.out.println("❌ Impacto fallido ❌");
            tableroPy[tfila][tcolumna] = -1;
            tabenemigo[tfila][tcolumna] = 8;
        }
        return tiros;
    }

    public static boolean points(int[] count, int btotales, boolean tiros) {
        if (count[0] >= pts[1]) {
            tiros = true;
        } else if (count[1] >= pts[0]) {
            tiros = true;
        } else {
            tiros = false;
        }
        return tiros;
    }
}