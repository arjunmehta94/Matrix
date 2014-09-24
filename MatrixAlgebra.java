public class MatrixAlgebra{

	public static boolean sameOrder(Matrix a, Matrix b){
		return a.getWidth() == b.getWidth() && a.getHeight() == b.getHeight();
	}

	public static boolean widthAndHeight(Matrix a, Matrix b){
		return a.getWidth() == b.getHeight();
	}

	public static Matrix add(Matrix a, Matrix b){
		if(sameOrder(a,b)){
			Matrix result = new Matrix(a.getWidth(), a.getHeight());
			for(int i = 0; i<a.getWidth(); i++){
				for(int j = 0; j<a.getHeight(); j++){
					result.setValueAt(i, j, a.getValueAt(i, j) + b.getValueAt(i,j));
				}
			}
			return result;
		}
		else{
			return null;
		}
	}

	public static Matrix subtract(Matrix a, Matrix b){
		if(sameOrder(a,b)){
			Matrix result = new Matrix(a.getWidth(), a.getHeight());
			for(int i = 0; i<a.getWidth(); i++){
				for(int j = 0; j<a.getHeight(); j++){
					result.setValueAt(i, j, a.getValueAt(i, j) - b.getValueAt(i,j));
				}
			}
			return result;
		}
		else{
			return null;
		}
	}
	public static double dotProduct(double[] a, double[] b){
		if(a.length == b.length){
			double total = 0;
			for(int i = 0; i<a.length; i++){
				total += (double)a[i] * (double)b[i];
			}	
			return total;
		}
		return Double.MIN_VALUE;
		
	}
	public static Matrix multiply(Matrix a, Matrix b){
		if(widthAndHeight(a, b)){
			Matrix result = new Matrix(a.getHeight(), b.getWidth());
			for(int i = 0; i<result.getWidth(); i++){
				for(int j = 0; j<result.getHeight(); j++){
					result.setValueAt(i, j, dotProduct(a.getRow(i), b.getCol(j)));
				}
			}
			return result;
		}
		return null;
	}

}





