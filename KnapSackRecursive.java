import java.util.Arrays;
import java.util.Scanner;

public class KnapSack1 {
    public static int[][] t= new int[100][100];
    public static void setMat(int t[][])
    {
        int i=0;
        int j=0;
        for(i=0;i<100;i++)
        {
            for(j=0;j<100;j++)
            {
                t[i][j]=-1;
            }
        }
    }

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
        setMat(t);
        //System.out.println(t[1][1]);
        int maxProfit=knapSack(weightItem,valueItem,n,totalbagweight);
        System.out.println("Final answer is "+maxProfit);


    }
    static int knapSack(int[] weight, int[] value, int n, int totalweight)
    {
      if(n==0 || totalweight==0)
      {
          return 0;
      }
      if(t[n][totalweight]!=-1)
      {
          return t[n][totalweight];
      }
      if(weight[n-1]<=totalweight)
      {
          return t[n][totalweight]=Math.max(value[n-1]+knapSack(weight,value,n-1,totalweight-weight[n-1]),knapSack(weight,value,n-1,totalweight));
      }
      else
      {
          return t[n][totalweight]=knapSack(weight,value,n-1,totalweight);
      }
    }
}
