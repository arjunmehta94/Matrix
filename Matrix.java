import java.util.Scanner;

public class Matrix{

	public Element[][] matrix;
	private int width;
	private int height;

	public Matrix(int w, int h){
		this.width = w;
		this.height = h;
		this.matrix = new Element[this.width][this.height];
		for(int i = 0; i<width; i++){
			for(int j = 0; j<height; j++){
				matrix[i][j] = new Element(-1);
			}
		}
	}

	public int getWidth(){
		return this.width;
	}

	public int getHeight(){
		return this.height;
	}

	public double[] getRow(int row){
		double[] result = new double[this.width];
		for(int i = 0; i<this.width; i++){
			result[i] = this.getValueAt(row, i);
		}
		return result;

	}

	public double[] getCol(int col){
		double[] result = new double[this.height];
		for(int i = 0; i<this.height; i++){
			result[i] = this.getValueAt(i, col);
		}
		return result;
	}
	public boolean isSquareMatrix(){
		return this.width == this.height;
	}

	public int size(){
		return this.width * this.height;
	}
	public double getValueAt(int w, int h){
		return matrix[w][h].getValue();
	}

	public void setValueAt(int w, int h, double val){
		matrix[w][h].setValue(val);
	}


	public String toString(){
		String result = new String();
		for(int i = 0; i<width; i++){
			result += "|\t";
			for(int j = 0; j<height; j++){
				result += this.getValueAt(i, j) + "\t";
			}
			result += "|";
			result += "\n";
		}
		return result;
	}

	public void SetUp(){
		Scanner in = new Scanner(System.in);
		for(int i = 0; i<width; i++){
			for(int j = 0; j<height; j++){
				System.out.println("Enter entry at:" + "(" + i + ", " + j + ")");
				this.setValueAt(i, j, in.nextDouble());
			}
		}
	}

	public static void main(String args[]){
		System.out.println("Please enter your matrix");

		Scanner in1 = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		System.out.println("Enter the width:");
		int width = in1.nextInt();
		System.out.println("Enter the height:");
		int height = in2.nextInt();
		Matrix m = new Matrix(width, height);
		//System.out.println(m.matrix[0][0]);
		m.SetUp();
		//System.out.println(m.matrix[0]);

		// for(int i = 0; i<width; i++){
		// 	System.out.print(m.matrix[0][i].getValue()+"\t");
		// }
		// Scanner in3 = new Scanner(System.in);
		// Scanner in4 = new Scanner(System.in);
		// System.out.println("Enter the width:");
		// int width1 = in3.nextInt();
		// System.out.println("Enter the height:");
		// int height1 = in4.nextInt();
		// Matrix m1 = new Matrix(width1, height1);
		// m1.SetUp();
		System.out.println(m);
		// System.out.println(m1);
		// System.out.println(MatrixAlgebra.add(m, m1));
		// System.out.println(MatrixAlgebra.multiply(m,m1));

		System.out.println(Determinant.determinant(m));
		System.out.println(Determinant.transposeMatrix(m));
		//System.out.println(MatrixAlgebra.multiply(m, Determinant.transposeMatrix(Determinant.cofactorMatrix(m))));
		System.out.println(Inverse.inverse(m));
		System.out.println(MatrixAlgebra.multiply(m, Inverse.inverse(m)));

	}





}