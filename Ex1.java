import java.util.*;
public class Ex1 {
    public static void main(String[] args) {
        System.out.println("Enter a list of numbers (Please input a '[' at the start and a ']' at the end of the list):\n");
        String numbers = stringInput();
        
        System.out.println("These are the numbers that you entered in the list: ");
        LispList<Integer> list;
        list = parseStringToInt(numbers);
        System.out.println(list);
        System.out.println("In this list, the length is: "+Length(list));
        System.out.println("Enter a number to find out how many times it repeats in the list: ");
        int userNum = intInput();
        System.out.println("The number "+userNum+" Appears in the list "+Count(list,userNum)+" times.");
    }
    public static int Length(LispList<Integer> nums)
    {
    	int n = 0;
    	for(;!nums.isEmpty(); nums=nums.tail())
    	{
    		if(nums.head()!=null)
    		{
    			n++;
    		}
    	}
    	
    	return n-1;
    }
    public static int Count(LispList<Integer> num, int n)
    {
    	int repeat = 0;
    	for(;!num.isEmpty(); num=num.tail())
    	{
    		if(num.head() == n)
    		{
    			repeat++;
    		}
    	
    	}
    	
    	return repeat;	
    }
	public static boolean ordered(LispList<Integer> num)
	{
		///CODE INCOMING.
	}
    public static int intInput(){
        Scanner scn = new Scanner(System.in);
        int response = scn.nextInt();
        return response;
    }
    public static String stringInput(){
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        return in;
    }
    public static LispList<Integer> parseStringToInt(String n)
    {
       String number = n.trim();
        String contains = number.substring(1,number.length()-1).trim();
        if(contains.length()== 0||number.charAt(0)!='['|| number.charAt(number.length()-1)!=']'){
            return LispList.empty();
        }
        String[] numArr = contains.split(",");
        LispList<Integer> numsList = LispList.empty();
        for(int i = numArr.length-1; i>=0; i--)
        {
            String arr = numArr[i].trim();
            numsList = numsList.cons(Integer.parseInt(arr));
        }
        return numsList;
    }

}