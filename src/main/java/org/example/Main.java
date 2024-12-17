package org.example;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ScriptException {

        Scanner in = new Scanner(System.in);
        System.out.print("Input: ");
        String str = in.nextLine();
        System.out.println(calc(str));

    }


    public static String calc(String inp) {
        String[] delimtr ={"+","-","*","/"};// проверяем наличие более одного символа оператора
        int k=0;
        String delimetr=null;
        int Ser=0;
        for (int i = 0; i < delimtr.length; i++) {
           if (inp.indexOf(delimtr[i])!=-1)
           {
               k=k+1;
               Ser=inp.indexOf(delimtr[i]);
               delimetr=delimtr[i];
           }
        }

        if (k!=1)
        {
            return ("Исключение: Введенная строка не соотвествует условиям.");
        }




        int Sl1=Integer.parseInt(inp.substring(0,Ser));
        int Sl2=Integer.parseInt(inp.substring(Ser+1,inp.length()));

        String operator=delimetr;
        String Rezult;

               if (Sl1 < 11 && Sl1 > 0 && Sl2 <11 && Sl2 > 0) {
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
                        default:
                            return ("Исключение: Введенная строка не соотвествует условиям.");

                    }
                    return Rezult;
                }
                else {
                    return ("Исключение: Введенная строка не соотвествует условиям.");
                }


            }







    }