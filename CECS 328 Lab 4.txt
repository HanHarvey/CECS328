package cecs328.lab.pkg4;
/**
 * CECS 328 LAB 4
 * @author Han
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class MSS 
{
        public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		System.out.println("Enter a positive integer");
		Scanner in = new Scanner(System.in);
		Random ran = new Random();
		int n = in.nextInt();
		for(int i = 0; i < n; i++)
		{
			a.add(ran.nextInt(100 + 1 + 100) - 100);
		}
		
		for(int i = 0; i < a.size(); i++)
		{
			System.out.print(a.get(i) + " ");
		}
		System.out.println();
		System.out.println("MSS is " + MSSn(a));
		System.out.println("MSS nlogn is " + MSSnlogn(a,0,a.size()-1));
	}
	public static int MSSn(ArrayList<Integer> a)
	{
            int max = 0;
            int sum = 0;
            for(int i = 0; i < a.size(); i++)
            {
		sum += a.get(i);
		if(sum > max)
		{
                    max = sum;
		}
		else if (sum < 0)
                {
                    sum = 0;
                }
            }
            return max;
        }
	public static int MSSnlogn(ArrayList<Integer> a, int start, int end)
	{
            if(a.size() - 1 == 0)
       	    {
		return 0;
            }
       	    if(end - start + 1 == 1)
            {
		return a.get(0);
            }
            int mid = (end + start) / 2;
            int sum = 0;	
            int lsum = 0;
            for(int i = mid; i >= start; i--)
            {
                sum += a.get(i);
		if(sum > lsum)
                {
                    lsum = sum;
		}
            }
            int sum2 = 0;
            int rsum = 0;	
            for(int i = mid + 1; i <= end; i++)
            {
		sum2 += a.get(i);
		if(sum2 > rsum)
		{
                    rsum = sum2;
		}
            }
            int z = rsum + lsum;
            int x = MSSnlogn(a,start,mid);
            int y = MSSnlogn(a,mid+1,end);
            return Math.max(Math.max(x, y),z);
	}
}