package util;


public class Matrix 
{
	private double[][] edges;


	public Matrix(int nrNodes)
	{
		edges = new double[nrNodes][nrNodes];
	}
	
	public void set(int row, int col, double weight)
	{
		// store the weight at the given row and column.
		edges[row][col] = weight;
	}

	public double get(int row, int col)
	{
		// return the weight at the given row and column.
		return edges[row][col];
	}
}