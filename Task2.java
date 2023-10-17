package Projects.CodeSoftInternship;

import java.util.Scanner;

class Calculation{
    int math;
    int history;
    int geography;
    int science;
    int marathi;

    int TotalMarks;
    int Percentage;
        
    public void Inputs(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Eeter the marks in 'Math' : ");
        math = scan.nextInt();
        System.out.print("Enter the marks in 'History' : ");
        history = scan.nextInt();
        System.out.print("Enter the marks in 'Geography' : ");
        geography = scan.nextInt();
        System.out.print("Enter the marks in 'Science' : ");
        science = scan.nextInt();
        System.out.print("Enter the marks in 'Marathi' : ");
        marathi = scan.nextInt();
    }

    public void Total(){
        TotalMarks = math + marathi + history + geography + science;
    }

    public void AvaragePercentage(){
        Percentage = TotalMarks / 5;
    }

    public void Grade(){
        if(Percentage>0 && Percentage<=100){

            switch (Percentage/10) {

            case 10: 
            case 9: System.out.println("Gread is :- A");
                break;

            case 8: System.out.println("Gread is :- B");
                break;

            case 7: System.out.println("Gread is :- C");
                break;

            case 6: System.out.println("Gread is :- D");
                break;

            case 5: System.out.println("Gread is :- P");
                break;
                
            default:System.out.println("Gread is :- F");
                break;
            }
        }
        else{
            System.out.println("Enter valid number in between 0-100...");
        }
    }
    public void Disp(){
        System.out.println("Total Marks is : " + TotalMarks);
        System.out.println("Your Persentage is : " + Percentage);
    }
}

public class Task2 {
    public static void main(String[] args) {
        Calculation c = new Calculation();
        c.Inputs();
        c.Total();
        c.AvaragePercentage();
        c.Disp();
        c.Grade();
    }
}
