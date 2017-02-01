package com.example.student3.bokunofirstrpg;

import java.util.Scanner;

/**
 * Created by student3 on 26.01.17.
 */
public class Player {
    static int hp, gold, mp;
    static int MakeChoise(int max){
        Scanner scanner = new Scanner(System.in);
        int choise = 0;
        do {
            choise = scanner.nextInt();
            if (choise > max) System.out.println("Неверный номер");
        } while (choise > max);

        return choise;
    }
}
