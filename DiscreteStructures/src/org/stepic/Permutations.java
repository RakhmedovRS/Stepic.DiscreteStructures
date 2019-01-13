package org.stepic;

import java.util.Scanner;

/**
 * @author rassoll
 * @created 13.01.2018
 */
public class Permutations
{
	private static int m;

	private static byte[][] result;
	private static int count = 0;

	private static void genStr(byte[] first, byte[] second)
	{
		if (first.length == m)
		{
			result[count++] = first;
		}
		else
		{
			for (int i = 0; i < second.length; i++)
			{
				byte[] first1 = new byte[first.length + 1];
				System.arraycopy(first, 0, first1, 0, first.length);

				first1[first1.length - 1] = second[i];

				byte[] second1 = new byte[i + (second.length - (i + 1))];
				System.arraycopy(second, 0, second1, 0, i);
				System.arraycopy(second, i + 1, second1, i, second1.length - i);

				genStr(first1, second1);
			}
		}
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();

		m = k;

		int l = factorial(n) / factorial(n - k);
		result = new byte[l][];

		StringBuilder sb = new StringBuilder();
		byte[] a = new byte[n];

		for (byte i = 0; i < n; i++)
		{
			a[i] = i;
		}

		genStr(new byte[]{}, a);

		for (int i = 0; i < l; i++)
		{
			for (int j = 0; j < k; j++)
			{
				sb.append(result[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static int factorial(int n)
	{
		int fact = 1;
		for (int i = 1; i <= n; i++)
		{
			fact *= i;
		}
		return fact;
	}
}
