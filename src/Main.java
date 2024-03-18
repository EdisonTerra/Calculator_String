import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ScannerException{
        System.out.println("INPUT");
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        String[] data = str.split(regexActions[signalValue(str)]);
        String dataLeft = data[0];
        String dataRight = data[1];
        if (dataLeft.length() > 10 || dataRight.length() > 10 || signalValue(str) == -1 || plusSignal(str) >= 2 || minusSignal(str) >= 2 || astSignal(str) >= 2 || slashSignal(str) >= 2) {
            throw new ScannerException("Некорректное выражение,формат операции не удовлетворяет заданию");
        } else {
            if (sign (str) == 1) {
                System.out.println('"' + calc (dataLeft, sign (str), dataRight) + '"');
            } else if (sign (str) == 2) {
                System.out.println('"' + calc (dataLeft, sign (str), dataRight) + '"');
            } else if (sign (str) == 4) {
                if (Integer.parseInt(dataRight)> 10) {
                    throw new ScannerException("Некорректный ввод. Введите число от 1 до 10.");
                } else {
                    System.out.println('"' + calc (dataLeft, sign (str), dataRight) + '"');
                }
            } else if (sign (str) == 3) {
                if (Integer.parseInt(dataRight) > 10) {
                    throw new ScannerException("Некорректный ввод. Введите число от 1 до 10.");
                } else {
                    System.out.println('"' + calc (dataLeft, sign (str), dataRight) + '"');
                }
            }
        }
    }
    public static String calc (String a, int c, String b) {
        String result = null;
        if (c == 1) {
            result = a + b;
        } else if (c == 2) {
            result = a.replace(b, "");
        } else if (c == 3) {
            result = multiplyString(a, Integer.parseInt(b));
        } else if (c == 4) {
            result = a.substring(0, a.length() / Integer.parseInt(b));
        }
        return result;
    }
    public static String multiplyString(String str, int n) {
        return String.valueOf(str).repeat(Math.max(0, n));
    }
    public static int signalValue(String valueSignal) {
        String[] actions = {"+", "-", "/", "*"};
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (valueSignal.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        return actionIndex;
    }
    public static int sign (String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // Обработка символа c
            if (c == '+') {
                count = 1;
            } else if (c == '-') {
                count = 2;
            } else if (c == '*') {
                count = 3;
            } else if (c == '/') {
                count = 4;
            }
        }
        return count;
    }
    public static int plusSignal (String plus){
        int plusCount = 0;
        for (int i = 0; i < plus.length(); i++) {
            char c = plus.charAt(i); // Обработка символа c
            if (c == '+') {
                plusCount++;
            }
        }
        return plusCount;
    }
    public static int minusSignal (String minus){
        int minusCount = 0;
        for (int i = 0; i < minus.length(); i++) {
            char c = minus.charAt(i); // Обработка символа c
            if (c == '-') {
                minusCount++;
            }
        }
        return minusCount;
    }
    public static int astSignal (String ast){
        int asteriskCount = 0;
        for (int i = 0; i < ast.length(); i++) {
            char c = ast.charAt(i); // Обработка символа c
            if (c == '-') {
                asteriskCount++;
            }
        }
        return asteriskCount;
    }
    public static int slashSignal (String slash){
        int slashCount = 0;
        for (int i = 0; i < slash.length(); i++) {
            char c = slash.charAt(i); // Обработка символа c
            if (c == '-') {
                slashCount++;
            }
        }
        return slashCount;
    }
    public static class ScannerException extends Exception{
        ScannerException(String description) {
            super(description);
        }
    }

}