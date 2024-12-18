package org.example;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        Scanner in = new Scanner(System.in);
        System.out.print("Input: ");
        String str = in.nextLine();
        System.out.println(calc(str));

    }

    public static void validateInput(String input) throws InvalidInputException {

        if (input.length() < 3 || input.length() > 5) {
            throw new InvalidInputException("throws Exception");
        }


        String[] delimtr = {"+", "-", "*", "/"};// проверяем наличие более одного символа оператора
        int k = 0;
        String delimetr = null;
        int Ser = 0;
        for (int i = 0; i < delimtr.length; i++) {
            if (input.indexOf(delimtr[i]) != -1) {
                k = k + 1;
                Ser = input.indexOf(delimtr[i]);
                delimetr = delimtr[i];
            }
        }

        if (k != 1) {
            throw new InvalidInputException("throws Exception");
        }
        int Sl1 = Integer.parseInt(input.substring(0, Ser));
        int Sl2 = Integer.parseInt(input.substring(Ser + 1, input.length()));


        if (Sl1 > 11 || Sl1 < 0 || Sl2 > 11 || Sl2 < 0) {
            throw new InvalidInputException("throws Exception");
        }


    }


    public static String calc(String inp) {
        String Rezult=null;
        try {
            validateInput(inp);
        } catch (InvalidInputException e) {
            System.out.println("throws Exception ");
            System.exit(0);

        }
        String[] delimtr = {"+", "-", "*", "/"};// проверяем наличие более одного символа оператора
        String operator = null;
        int Ser = 0;
        for (int i = 0; i < delimtr.length; i++) {
            if (inp.indexOf(delimtr[i]) != -1) {
                Ser = inp.indexOf(delimtr[i]);
                operator = delimtr[i];
            }
        }
        int Sl1 = Integer.parseInt(inp.substring(0, Ser));
        int Sl2 = Integer.parseInt(inp.substring(Ser + 1, inp.length()));
        switch (operator) {
            case "+":
                Rezult = Integer.toString(Sl1 + Sl2);
                break;
            case "-":
                Rezult = Integer.toString(Sl1 - Sl2);
                break;
            case "*":
                Rezult = Integer.toString(Sl1 * Sl2);
                break;
            case "/":
                Rezult = Integer.toString(Sl1 / Sl2);
                break;
        }
        return Rezult;

    }
}