package ArtificialIntelligence.ComputerVision;

import java.util.Scanner;

public class CaptchaCracker {

    public static void main(){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){

            scanner.next();
        }

    }
}

class Triplet{
    private int num1;
    private int num2;
    private int num3;

    public Triplet(int num1, int num2, int num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getNum3() {
        return num3;
    }
}