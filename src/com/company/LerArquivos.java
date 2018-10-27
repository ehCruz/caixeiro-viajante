package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <h1>Classe generica para a leitura de arquivos textos</h1>
 * <p>Necessario adaptar a sua aplicacao</p>
 * @author Eduardo Henrique Cruz
 */
public class LerArquivos {

    private static File file;
    static int[][] a = new int[6][6];

    /**
     * <h1>Metodo de leitura de arquivos</h1>
     * @param filePath - caminho absoluto do arquivo no sistema
     * @return - Para este caso, retorna uma matriz 6 x 6 somente com o peso de cada rota
     */
    public static int[][] lerLinhasDoArquivo(String filePath) {
        LerArquivos.file = new File(filePath);
        String[] dadosLinha;
        try {
            Scanner sc = new Scanner(LerArquivos.file);
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    dadosLinha = sc.nextLine().split(";");
                    a[i][j] = Integer.parseInt(dadosLinha[2]);
                }
            }
            sc.close();
            return a;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado, verifique se o caminho do arquivo esta correto");
        }
        return null;
    }
}
