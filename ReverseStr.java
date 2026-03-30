import java.util.Scanner;
class ReverseStr 
{
        static String rev(String str){
		String r="";
		for(int i=str.length()-1;i>=0;i--)
		{
			r=r+str.charAt(i);
		}
		return r;
	}
	public static void main(String args[])
	{
	ReverseStr sc=new ReverseStr();
	System.out.println("Enter a string:");
	String input=sc.nextLine();
	String result=rev(input);
	System.out.println("Reverse string: "+result);
	//sc.close();
	}
}