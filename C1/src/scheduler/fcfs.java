package scheduler;

import java.util.Scanner;

public class fcfs 
{
	int pno;
	int btime;
	int wtime;
	int tatime;
	Scanner in = new Scanner(System.in);

	void algo()
	{
		Scanner in = new Scanner(System.in);
		int pro=0;
		System.out.println("Enter the number of Processes.");
		pro=in.nextInt();
		fcfs[] p_array = new fcfs[pro];
		int i=0,sum=0;
		for(i=0;i<pro;i++)
		{
			p_array[i]= new fcfs();
			System.out.println("Enter for Process P"+i+":");
			System.out.println("Enter burst time in minutes.");
			p_array[i].btime= in.nextInt();
			p_array[i].wtime=sum;
			sum=sum+p_array[i].btime;
			p_array[i].tatime=sum;
		}
		for(i=0;i<pro;i++)
		{
			System.out.println();
			System.out.println("Process P"+i+":");
			System.out.println("Burst Time = "+p_array[i].btime);
			System.out.println("Wait time = "+p_array[i].wtime);
			System.out.println("Turn Around time = "+p_array[i].tatime);
		}
		in.close();
	}
}
