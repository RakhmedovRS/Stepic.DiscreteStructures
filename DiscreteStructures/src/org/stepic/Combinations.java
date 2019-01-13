package org.stepic;

import java.util.Scanner;

/**
 * @author rassoll
 * @created 13.01.2018
 */
public class Combinations
{
	private static int[] createAndFillArray(int size)
	{
		int array[] = new int[size];
		for (int i = 0; i < size; i++)
		{
			array[i] = i;
		}

		return array;
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int K = s.nextInt();
		int N = s.nextInt();

		int[] arr = createAndFillArray(K);
		int i, j;

		do
		{
			for (i = 0; i < K; i++)
			{
				System.out.print(arr[i] + " ");
			}
			System.out.print("\n");

			for (j = K - 1; j >= 0 && arr[j] >= N - K + j; j--)
				;

			if (j >= 0)
			{
				arr[j]++;
				for (i = j + 1; i < K; i++)
				{
					arr[i] = arr[i - 1] + 1;
				}
			}
			else
			{
				break;
			}
		}
		while (true);
	}
}