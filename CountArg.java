import java.util.Scanner;
class ReverseStr 
{
	Static String rev(String str){
		String r="";
		for(int i=str.length()-1;i>=0;i--)
		{
			r=r+str.charAt(i);
		}
		return r;
	}
	public static void main(String args[])
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter a string:");
	String input=sc.next();
	String result=rev(input);
	System.out.println("Reverse string: "+result);
	sc.close();
	}
}