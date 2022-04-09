package said.ekazhev;
import java.lang.Integer;


import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static String from_10_in_16(Integer number){

        StringBuilder hexadecimalNumber = new StringBuilder();
        Integer quotient = number;

        while (quotient>0){
            Integer remainder = quotient % 16;
            switch (remainder) {
                case 10: hexadecimalNumber.append("A");
                    break;
                case 11: hexadecimalNumber.append("B");
                    break;
                case 12: hexadecimalNumber.append("C");
                    break;
                case 13: hexadecimalNumber.append("D");
                    break;
                case 14: hexadecimalNumber.append("E");
                    break;
                case 15: hexadecimalNumber.append("F");
                    break;
                default: hexadecimalNumber.append(remainder);
            }
            quotient /= 16;
        }
        hexadecimalNumber = hexadecimalNumber.reverse();
        return hexadecimalNumber.toString();
    }

    public static Long from_10_in_2(Long number) {
        if (number == 0) {
            return number;
        }

        StringBuilder binaryNumber = new StringBuilder();
        Long quotient = number;

        while (quotient > 0) {
            long remainder = quotient % 2;
            binaryNumber.append(remainder);
            quotient /= 2;
        }

        binaryNumber = binaryNumber.reverse();
        return Long.valueOf(binaryNumber.toString());
    }

    public static Long from_2_in_10(Long binaryNumber) {
        long decimalNumber = 0;
        long index = 1;

        while (binaryNumber > 0) {
            long lastDigit = binaryNumber % 10;
            binaryNumber = binaryNumber / 10;
            decimalNumber += lastDigit * index;
            index = index * 2;
        }
        return decimalNumber;
    }

    public static void main(String[] args) {

        System.out.println("Введите число от 0 до 10000:");
        Scanner scanner = new Scanner(System.in);

        try{
            long number = scanner.nextInt();
            if(number < 10000 && number > 0 ){
                Long binaryNumber = from_10_in_2(number);
                System.out.println("Число " + number + " в двоичной системе счисления: " + binaryNumber);
                System.out.println("Число " + binaryNumber + " в десятичной системе счисления: " + from_2_in_10(binaryNumber));
                Integer decimalNumber = from_2_in_10(binaryNumber).intValue();
                System.out.println("Число " + decimalNumber + " в шестнадцатеричной системе счисления: " + from_10_in_16(decimalNumber));

            } else {System.out.println("Значение вышло за пределы диапазона");}
        }catch(Exception e){
            System.out.println("Введены неверные данные: " + e.getClass().getSimpleName());
        }
    }
}
