package practice;

public class practiceLoop {
    public void whileLoop() {
        //print numbers 10 to 30
        int x = 9;
        while (x <= 31) {
            System.out.println("value of x: " + x);
            x++;
        }
    }

    public void forLoop() {
        //print numbers of 20 to 40
        for (int x = 20; x <= 40; x++) {
            System.out.println("value of x: " + x);
        }
    }
    public void doWhileLoop() {
        //print numbers 30 to 50
        int x = 30;
        do{
            System.out.println("value of x; " + x);
            x++;
        }while (x <= 50);
    }
}
