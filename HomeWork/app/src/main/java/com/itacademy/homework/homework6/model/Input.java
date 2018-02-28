package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @return Методы для работы со строками и числами в консоли
 */
public class Input {

        public static String inputString() {
            String result = null;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                result = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }


        public static int inputNumber() {
            String input = "";
            int result = 0;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                input = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                result = Integer.parseInt(input);
            } catch (Exception e) {
                try {
                    throw new Exception();
                } catch (Exception e1) {
                    System.err.println("Неверный формат введённых данных, введите целое число:" + e1.getMessage());
                }
                result = inputNumber();
            }

            return result;
        }

    }
