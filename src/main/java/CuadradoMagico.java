import java.util.Arrays;

public class CuadradoMagico {
    public static void main(String[] args) {
        int[][] cuadrado = new int[3][3];

        int intentos = 0;
        do {
            llenarCuadrado(cuadrado);
            mostrarCuadrado(cuadrado);
            System.out.println(resultadoVerificacion(cuadrado));
            intentos++;
        } while (!esCuadradoMagico(cuadrado));

        System.out.println("intentos = " + intentos);
    }

    private static String resultadoVerificacion(int[][] cuadrado) {
        return "%s un Cuadrado Magico".formatted(esCuadradoMagico(cuadrado) ? "Es" : "No es");
    }

    private static boolean esCuadradoMagico(int[][] cuadrado) {
        return filasSuman15(cuadrado) && columnasSuman15(cuadrado) && diagonalesSuman15(cuadrado);
    }

    private static boolean diagonalesSuman15(int[][] cuadrado) {
        return diagonal1Suma15(cuadrado) && diagonal2Suma15(cuadrado);
    }

    private static boolean diagonal2Suma15(int[][] cuadrado) {
        int sumaDiagonal = 0;
        for (int i = 0; i < cuadrado.length; i++) {
            sumaDiagonal = cuadrado[i][2 - i];
        }
        return sumaDiagonal == 15;
    }

    private static boolean diagonal1Suma15(int[][] cuadrado) {
        int sumaDiagonal = 0;
        for (int i = 0; i < cuadrado.length; i++) {
            sumaDiagonal += cuadrado[i][i];
        }
        return sumaDiagonal == 15;
    }

    private static boolean columnasSuman15(int[][] cuadrado) {
        for (int i = 0; i < cuadrado.length; i++) {
            int sumaColumna = 0;
            for (int j = 0; j < cuadrado[i].length; j++) {
                sumaColumna = cuadrado[j][i];
            }
            if (sumaColumna != 15) return false;
        }
        return true;
    }

    private static boolean filasSuman15(int[][] cuadrado) {
        for (int[] fila : cuadrado) {
            int sumaFila = 0;
            for (int numero : fila) {
                sumaFila += numero;
            }
            if (sumaFila != 15) return false;
        }
        return true;
    }

    private static void mostrarCuadrado(int[][] cuadrado) {
        for (int[] fila : cuadrado) {
            System.out.println(Arrays.toString(fila));
        }
    }

    private static void llenarCuadrado(int[][] cuadrado) {
        boolean[] numerosUnicos = new boolean[9];
        for (int i = 0; i < cuadrado.length; i++) {
            for (int j = 0; j < cuadrado[i].length; j++) {
                cuadrado[i][j] = numeroUnico(numerosUnicos);
            }
        }
    }

    private static int numeroUnico(boolean[] numerosUnicos) {
        int numeroAleatorio;
        do {
            numeroAleatorio = (int) (Math.random() * 9 + 1);
        } while (numerosUnicos[numeroAleatorio - 1]);

        numerosUnicos[numeroAleatorio - 1] = true;
        return numeroAleatorio;
    }
}
