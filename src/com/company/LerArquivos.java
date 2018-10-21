package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivos {

    private static File file;

    public static List lerLinhasDoArquivo(String filePath) {
        LerArquivos.file = new File(filePath);
        List<String> linhas = new ArrayList<>();
        try {
            Scanner sc = new Scanner(LerArquivos.file);
            while (sc.hasNextLine()) {
                linhas.add(sc.nextLine());
            }
            sc.close();
            return linhas;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado, verifique se o caminho do arquivo esta correto");
        }
        return null;
    }

}
