package Basico;


public class CalculsArrayReals {

	/**
	 * Donat un array de reals, calculeu en quina posició hi ha el valor més alt.
	 *
	 * @param array Array de reals on fer la cerca
	 * @return Posicio on es troba el valor mínim
	 */
	public double calcularMaxim(double[] array) {
		double max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}

	/**
	 * Donat un array de reals, calculeu en quina posició hi ha el valor més baix.
	 *
	 * @param array Array de reals on fer la cerca
	 * @return Posició on es troba el valor màxim
	 */
	public double calcularMinim(double[] array) {
		double min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}
		return min;
	}

	/**
	 * Donat un array de reals, calculeu la mitjana de tots els valors que conté.
	 *
	 * @param array Array amb els valors a tractar
	 * @return Mitjana de tots els valors
	 */
	public double calcularMitjana(double[] array) {
		double suma = 0;
		for (int i = 0; i < array.length; i++) {
			suma = suma + array[i];
		}
		return suma / array.length;
	}

}
