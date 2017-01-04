public class Determinant{

	public static double minor(Matrix a, int w, int h){
		if(a.isSquareMatrix()){
			double[] tmpArr = new double[(a.getWidth() - 1)*(a.getHeight()-1)];
			Matrix tmp = new Matrix(a.getWidth() - 1, a.getHeight() - 1);
			int count = 0;
			for(int i = 0; i<a.getWidth(); i++){
				for(int j = 0; j<a.getHeight(); j++){
					if(i == w || j == h){

					}
					else{
						tmpArr[count] = a.getValueAt(i, j);
						count++;
					}
				}
			}
			
			for(int k = 0; k<tmpArr.length; k++){
				tmp.setValueAt(k%tmp.getWidth(), k/tmp.getHeight(), tmpArr[k]);
			}
			return determinant(tmp);
		}
		else{
			return Double.MIN_VALUE;
		}
	}

	public static double determinant(Matrix a){
		if(a.size() == 1){
			return a.getValueAt(0, 0);
		}
		else if(a.size() == 4){
			return (a.getValueAt(0, 0) * a.getValueAt(1,1) - a.getValueAt(0,1) * a.getValueAt(1,0));
		}
		else{
			double total = 0;
			double[] tmp = a.getRow(0);
			for(int i = 0; i<tmp.length; i++){
				total += tmp[i] * cofactor(a, 0, i);
			}
			return total;
		}
	}

	public static double cofactor(Matrix a, int w, int h){
		return pow(-1, w+h) * minor(a, w, h);
	}

	public static Matrix cofactorMatrix(Matrix a){
		Matrix result = new Matrix(a.getWidth(), a.getHeight());
		for(int i = 0; i<a.getWidth(); i++){
			for(int j = 0; j<a.getHeight(); j++){
				result.setValueAt(i, j, cofactor(a, i, j));
			}
		}
		return result;
	}

	public static Matrix transposeMatrix(Matrix a){
		Matrix result = new Matrix(a.getHeight(), a.getWidth());
		for(int col = 0; col<a.getHeight(); col++){
			for(int row = 0; row<a.getWidth(); row++){
				result.setValueAt(col, row, a.getValueAt(row, col));
			}
		}
		return result;
	}
	public static int pow(int base, int index){
		if(base == 0){
			return 0;
		}
		else if(base == 1){
			return 1;
		}
		else if(index == 0){
			return 1;
		}
		else if(index == 1){
			return base;
		}
		else{
			return base * pow(base, index-1);
		}

	}

}