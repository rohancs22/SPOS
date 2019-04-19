package scheduler;

import java.util.Scanner;

public class priority
{
	String pno;
	int btime;
	int wtime;
	int tatime;
	int pri;
	Scanner in = new Scanner(System.in);

	void algo()
	{
		Scanner in = new Scanner(System.in);
		int pro=0;
		System.out.println("Enter the number of Processes.");
		pro=in.nextInt();
		priority[] p_array = new priority[pro];
		int i,sum=0;
		for(i=0;i<pro;i++)
		{
			p_array[i]= new priority();
			System.out.println("Enter for Process P"+i+":");
			p_array[i].pno= "P"+i;
			System.out.println("Enter burst time in minutes.");
			p_array[i].btime= in.nextInt();
			System.out.println("Enter priority.");
			p_array[i].pri= in.nextInt();
		}
		
		priority temp= new priority();
		for(i=0;i<pro-1;i++)
		{
			for(int j=i+1;j<pro;j++)
			{
				if(p_array[j].pri>p_array[i].pri)
				{
					temp= p_array[j];
					p_array[j]= p_array[i];
					p_array[i]= temp;
				}
			}
		}
		
		for(i=0;i<pro;i++)
		{
			p_array[i].wtime=sum;
			sum=sum+p_array[i].btime;
			p_array[i].tatime=sum;
		}
		
		for(i=0;i<pro;i++)
		{
			System.out.println();
			System.out.println("Process "+p_array[i].pno+":");
			System.out.println("Burst Time = "+p_array[i].btime);
			System.out.println("Wait time = "+p_array[i].wtime);
			System.out.println("Turn Around time = "+p_array[i].tatime);
		}
	
		in.close();
	}
}
