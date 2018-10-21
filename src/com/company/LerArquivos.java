package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivos {

    private static File file;

    public static void lerLinhasDoArquivo(String filePath) {
        LerArquivos.file = new File(filePath);
        try {
            Scanner sc =new Scanner(LerArquivos.file);
            String line;
            while (sc.hasNextLine()){
                line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        }catch (FileNotFoundException e){
            System.out.println("Arquivo nao encontrado, verifique se o caminho do arquivo esta correto");
        }
    }

}
