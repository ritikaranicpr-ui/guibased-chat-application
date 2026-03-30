import java.util.Scanner;
class SI
{
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
        System.out.println("Enter principal amount: ");
        double principal=obj.nextDouble();
        System.out.println("Enter rate of interest: ");
        double rate=obj.nextDouble();
        System.out.println("Enter the time(in years): ");
        double time=obj.nextDouble();
        double simpleint=(principal*rate*time)/100;
        System.out.println("\n---Calculate SI---");
        System.out.println("Principal: "+principal);
        System.out.println("Rate: "+rate);
        System.out.println("Time: "+time+"years");
        System.out.println("Simple Interest= "+simpleint);
        Scanner.close();
    }
}