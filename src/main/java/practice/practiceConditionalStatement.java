package practice;

public class practiceConditionalStatement {
    public void practiceIfStatement(int x) {
        //print the x value if condition is less than 30
        if (x < 30) ; {
            System.out.println("value of x: " + x);
        }
    }
    public void practiceIfElseStatement(int x) {
        if(x <25) {
           System.out.println("this is if statement");
        }else {
            System.out.println("this is else statement");
        }
    }
    public void switchStatement(char grade) {
        switch (grade) {
            case 'A':
                System.out.println("excellent");
                break;
            case 'B':
            case 'C':
                System.out.println("well done");
                break;
            case'D':
                System.out.println("you passed");
                break;
            case 'F':
                System.out.println("better try again");
                break;
            default:
                System.out.println("invalid grade");
        }
        System.out.println("your grade is: " + grade);
    }
    public void printGrades(char grade) {
        if(grade =='A') {
            System.out.println("excellent");
        }else if(grade == 'B') {
            System.out.println("well done");
        }else if(grade == 'C') {
            System.out.println("well done");
        }else if (grade == 'D') {
            System.out.println("you passed");
        }else if (grade == 'F') {
            System.out.println("better try again");
        }else {
            System.out.println("invalid grade");
        }
        System.out.println("your grade is: " + grade);
    }
    public void conditionalOperator() {
        int a,b;
        a = 20;
        b = (a == 1)? 30:40;
        System.out.println("value of b is: " + b);
    }
}
