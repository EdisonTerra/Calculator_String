import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        System.out.println("INPUT");
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        String[] str = input.split(signalValue(input));
        String dataLeft = str[0];
        String dataRight = str[1];
        if (str.length != 2) {
            throw new IllegalArgumentException("Неверный формат выражения");
        }

        if (!dataLeft.startsWith("\"") || !dataLeft.endsWith("\"")) {
            throw new IllegalArgumentException("Операнды должны быть в кавычках");
        }
        if (dataLeft.length() > 12 || dataRight.length() > 12) {
            throw new IllegalArgumentException("Некорректное выражение,формат операции не удовлетворяет заданию");
        } else {
            System.out.println('"' + calc(dataLeft, sValue(input), dataRight) + '"');
        }
    }
    public static String calc(String a, String c, String b){
        String result = null;
        switch (c) {
            case "+":
                a = a.substring(1, a.length() - 1);
                b = b.substring(1, b.length() - 1);
                result = a + b;
                break;
            case "-":
                a = a.substring(1, a.length() - 1);
                b = b.substring(1, b.length() - 1);
                result = a.replace(b, "");
                break;
            case "*":
                a = a.substring(1, a.length() - 1);
                int multiplier = Integer.parseInt(b);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < multiplier; i++) {
                    sb.append(a);
                }
                result = sb.toString();
                break;
            case "/":
                a = a.substring(1, a.length() - 1);
                int divisor = Integer.parseInt(b);
                int quotient = a.length() / divisor;
                result = a.substring(0, quotient);
                break;
        }
        if (result.length() > 40) {
            result = result.substring(0, 40) + "...";
        }
        return result;
    }
    public static String signalValue(String valueSignal) {
        String[] actions = {"+", "-", "/", "*"};
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (valueSignal.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        //String[] regexActions = {"\\+", "-", "/", "\\*"};
        String[] regexActions = {"\s\\+\s", "\s-\s" , "\s/\s", "\s\\*\s"};
        String regexAction = regexActions[actionIndex];
        return regexAction;
    }
    public static String sValue(String valueSignal) {
        String[] actions = {"+", "-", "/", "*"};
        String s = null;
        for (int i = 0; i < actions.length; i++) {
            if (valueSignal.contains(actions[i])) {
                s = actions[i];
                break;
            }
        }
        return s;
    }
}
