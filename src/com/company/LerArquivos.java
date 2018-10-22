package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivos {

    private static File file;

    public static List<Integer> lerLinhasDoArquivo(String filePath) {
        LerArquivos.file = new File(filePath);
        List<Integer> linhas = new ArrayList<>();
        try {
            Scanner sc = new Scanner(LerArquivos.file);
            while (sc.hasNextLine()) {
//                linhas.add(sc.nextLine());
                linhas.add(LerArquivos.tratarDadosArquivo(sc.nextLine()));
            }
            sc.close();
            return linhas;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado, verifique se o caminho do arquivo esta correto");
        }
        return null;
    }

    private static int tratarDadosArquivo(String linha) {
        String dadosLinha[] = linha.split(";");
        Integer origem = Integer.parseInt(dadosLinha[0]);
        Integer destino = Integer.parseInt(dadosLinha[1]);
        Integer peso = Integer.parseInt(dadosLinha[2]);
        return peso;
    }
}
