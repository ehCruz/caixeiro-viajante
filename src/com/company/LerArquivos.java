package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivos {

    private static File file;
    static int[][] a = new int[36][3];

    public static int[][] lerLinhasDoArquivo(String filePath) {
        LerArquivos.file = new File(filePath);
        String[] dadosLinha;
        try {
            Scanner sc = new Scanner(LerArquivos.file);
            for (int i = 0; i < a.length; i++) {
                dadosLinha = sc.nextLine().split(";");
                a[i][0] = Integer.parseInt(dadosLinha[0]);
                a[i][1] = Integer.parseInt(dadosLinha[1]);
                a[i][2] = Integer.parseInt(dadosLinha[2]);
            }
            sc.close();
            return a;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado, verifique se o caminho do arquivo esta correto");
        }
        return null;
    }
}
