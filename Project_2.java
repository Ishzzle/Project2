package project_2;

import java.util.Random;

public class Project_2 {
	
	public static void dijkstraSP(int input[][], int start)
	{
		int x = input[0].length;
		
		//Calculate the distance for the nodes we've visited
		int distance[] = new int[x];
		
		//To determine if the node has already been visited
		boolean bool[] = new boolean[x];
		
		distance[0] = 0;
		
		//To initialize the distant values
		for(int i = 0; i < x; i++) {
			distance[i] = Integer.MAX_VALUE; //Close enough to infinity
			bool[i] = false; //Because we have not visited any nodes yet
		}
		distance[0] = 0;
		for (int j = 0; j < x; j++) {
			int index = minDist(distance, bool);
			bool[index] = true;
			for (int k = 0; k < x; k++) {
				if (!bool[k]&&input[index][k]!= 0 && distance[index]!= Integer.MAX_VALUE && distance[index]+input[index][k]< distance[k])
				{
					distance[k] = distance[index] + input[index][k];
				}
				
			}
		}
		for (int a = 0; a < x; a++) {
			int b = a+1;
			System.out.println("Shortest Path from "+b+" is:");
			if (distance[a]==2147483647)
                System.out.print("INF ");
			else
			System.out.println(distance[a]);}
		System.out.println();
	}
	
	//Helper method to find the minimum distance
	public static int minDist(int distance[], boolean bool[]) 
	{
		int index = -1;
		int x = distance.length;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < x; i++) {
			if(bool[i] == false && distance[i] <= min) {
				min = distance[i];
				index = i;
			}
		}
		return index;
	}
	
	//Floyd Warshall Algorithm
	public static void floydW(int input[][])
    {
        int n = input.length;
		int distance[][] = new int[n][n];
		for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                distance[u][v] = input[u][v];
            }
		}
		for (int k = 0; k < n; k++) {
			for (int u = 0; u < n; u++) {
				for (int v = 0; v < n; v++) {
					if (distance[u][k] + distance[k][v] < distance[u][v])
					{
						distance[u][v] = distance[u][k] + distance[k][v];
					}
				}
			}
		}
		for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
            {
                    System.out.print(distance[i][j]+"   ");
            }
            System.out.println();
        }
    }
	
	public static int[][] create(int n){
		
		Random random = new Random();
		int[][] output = new int[n][n];
		for(int i = 0; i<n; i++) 
		{
			for(int j = 0; j<n;j++) 
			{
				output[i][j] = random.nextInt(100);
				//System.out.print(output[i][j] + ", ");
			}
			//System.out.println("");
		}
		return output;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int input[][] = create(10);
	int x = input[0][0];
	//System.out.print("\n\n" + x);
	
	//long startTime = System.nanoTime();
	dijkstraSP(input, input[0][0]);
	//long elapsedTime = System.nanoTime() - startTime;
	//System.out.print("**The time to execute Dijkstra's Algorithm is "+elapsedTime+" nanoseconds**\n");
	
	//long floydstartTime = System.nanoTime();
	floydW(input);
	//long floydelapsedTime = System.nanoTime() - floydstartTime;
	//System.out.print("**The time to execute FLoyd Warshall Algorithm is "+floydelapsedTime+" nanoseconds**\n");
	   
	}
}
