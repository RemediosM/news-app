package com.kodolamacz.newsapp;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class UserInput {

    String filePath() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj plik wraz ze ścieżką do zapisania danych");
        return scan.nextLine();
    }

    String apiKey(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj swój API KEY");
        return  scan.nextLine();

    }


}
