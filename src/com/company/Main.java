package com.company;

import java.util.Scanner;

public class Main {
    private int[][] pesos;
    private int[] arr = {1, 2, 3, 4, 5, 6};
    final static int NUM_VERTICE = 6;
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().processar();
    }

    private void processar() {
        this.pesos = LerArquivos.lerLinhasDoArquivo("C:\\Users\\Eduardo Cruz\\IdeaProjects\\caixeiro-viajante\\Arquivos\\Rota01.txt");
        int op;
        while (true) {
            System.out.println("1- Selecionar Arquivo\n" +
                    "9- Sair");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    Calcular.calcularRotas(Combinatorio.combinatorio(this.arr, this.arr.length - 1), this.pesos);
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcao " + op + " invalida");
            }
        }
    }

}
