import java.util.*;
import java.util.Arrays;
public class KnapSackTopDown {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number of Items");
        int n=sc.nextInt();
        int[] weightItem=new int[n];
        int tempweight;
        int i=0;
        System.out.println("Please enter the Total weight of the Items");
        int totalbagweight=sc.nextInt();
        System.out.println("Total weight of the Bag is :"+totalbagweight);
        System.out.println("Enter the weight of Items");
        for(i=0;i<n;i++)
        {
            tempweight=sc.nextInt();
            weightItem[i]=tempweight;
        }
        int[] valueItem=new int[n];
        int tempvalue;

        System.out.println("Enter the value of Items");
        for(i=0;i<n;i++)
        {
            tempvalue=sc.nextInt();
            valueItem[i]=tempvalue;
        }
        System.out.println("Weight of the Items are :");
        for(i=0;i<n;i++)
        {
            System.out.print(weightItem[i]+" ");
        }
        System.out.println("Value of the Items are as follow");
        for(i=0;i<n;i++)
        {
            System.out.print(valueItem[i]+" ");
        }
        //System.out.println(t[1][1]);

        //System.out.println(t[1][1]);
        int maxProfit=knapSack(weightItem,valueItem,n,totalbagweight);
        System.out.println("Final answer is "+maxProfit);


    }
    static int knapSack(int weight[],int values[],int n,int totalbagweight)
    {
        int[][] t=new int[n+1][totalbagweight+1];
        int i=0;
        int j=0;
        for(i=0;i<n+1;i++)
        {
            for(j=0;j<totalbagweight+1;j++)
            {
                if(i==0 || j==0)
                {
                    t[i][j]=0;
                }
                else if(weight[n-1]<=totalbagweight)
                {
                    t[n][totalbagweight]=Math.max(values[n-1]+t[n-1][totalbagweight-weight[n-1]],t[n-1][totalbagweight]);
                }
                else
                {
                    t[n][totalbagweight]=t[n-1][totalbagweight];
                }
            }
        }
        return t[n][totalbagweight];
    }
}
