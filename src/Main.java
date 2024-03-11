import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ScannerException{
        System.out.println("INPUT");
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        String[] data = str.split(regexActions[signalValue(str)]);
        int sigForm = sign (str);
        String dataLeft = data[0];
        String dataRight = data[1];
        if (dataLeft.matches("\\D+")) {
            if (dataLeft.length() > 10 || dataRight.length() > 10 || signalValue(str) == -1 || plusSignal(str) >= 2 || minusSignal(str) >= 2 || astSignal(str) >= 2 || slashSignal(str) >= 2) {
                throw new ScannerException("Некорректное выражение,формат операции не удовлетворяет заданию");
            } else {
                if (sigForm == 1) {
                    String result = dataLeft + dataRight;
                    System.out.println('"' + result + '"');
                } else if (sigForm == 2) {
                    String result = dataLeft.replace(dataRight, "");
                    System.out.println('"' + result + '"');
                } else if (sigForm == 4) {
                    int n = Integer.parseInt(dataRight);
                    if (n > 10) {
                        throw new ScannerException("Некорректный ввод. Введите число от 1 до 10.");
                    } else {
                        String result = dataLeft.substring(0, dataLeft.length() / n);
                        System.out.println('"' + result + '"');
                    }
                } else if (sigForm == 3) {
                    int n = Integer.parseInt(dataRight);
                    if (n > 10) {
                        throw new ScannerException("Некорректный ввод. Введите число от 1 до 10.");
                    } else {
                        String result = multiplyString(dataLeft, n);
                        System.out.println('"' + result.substring(0, 40) + "···" + '"');
                    }
                }

            }
        } else {
            throw new ScannerException("Некорректный ввод.");
        }
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