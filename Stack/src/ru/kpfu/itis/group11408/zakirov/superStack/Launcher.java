package ru.kpfu.itis.group11408.zakirov.superStack;

import java.util.Scanner;

/**
 * Created by Anvar on 23.03.2015.
 */
public class Launcher {
    public static void main(String[] args) {
        SuperStack<Integer> superStack = new SuperStack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println("Please, write brackets sequence.");
        System.out.println("Pojalyusta, vvedite posledovatelnost skobok.");
        String str = scanner.next();

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '('){
                superStack.push(1);
            }else{
                if (superStack.size() == 0){
                    System.out.println("Sequence of brackets is WRONG!");
                    return;
                }else{
                    superStack.pop();
                }
            }
        }

        System.out.println("Sequence of brackets is " + ((superStack.size() == 0) ? "RIGHT" : "WRONG") + "!");
    }
}
