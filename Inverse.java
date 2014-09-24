public class Inverse{

	public static Matrix inverse(Matrix a){
		Matrix result = Determinant.transposeMatrix(Determinant.cofactorMatrix(a));
		for(int i = 0; i<result.getWidth(); i++){
			for(int j = 0; j<result.getHeight(); j++){
				result.setValueAt(i,j, result.getValueAt(i, j)/Determinant.determinant(a));

			}
		}
		return result;
	}

}