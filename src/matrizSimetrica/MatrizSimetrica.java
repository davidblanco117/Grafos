package matrizSimetrica;

public class MatrizSimetrica {

	// private int mat[][];
	private int[] vector;
	int tam;

	public MatrizSimetrica(int tam) {
		vector = new int[(tam * (tam - 1)) / 2];
		this.tam = tam;

	}
	
	
	public void mostrarVector() {
		for(int i=0;i<this.vector.length;i++) {
			System.out.print(this.vector[i]+" ");
		}
	}

	public void set(int fila, int columna, int valor) {
		if (fila < columna)
			vector[fila * tam + columna - (fila * fila + 3 * fila + 2) / 2] = valor;
		else
			vector[columna * tam + fila - (columna * columna + 3 * columna + 2) / 2] = valor;

	}

	public int get(int fila, int columna) {
		if (fila == columna)
			return 0;
		if (fila <= columna)
			return vector[fila * tam + columna - (fila * fila + 3 * fila + 2) / 2];
		else
			return vector[columna * tam + fila - (columna * columna + 3 * columna + 2) / 2];
	}

	public void generadorPorProbabilidad(double prob, int orden) {
		this.vector = new int[(orden * (orden - 1)) / 2];
		for (int i = 0; i < this.vector.length; i++) {
			this.vector[i] = (Math.random() <= prob) ? 1 : 0;/// CON PROB DE 0-1
		}
	}

	public void generadorPorAdyacencia(double ady, int orden) {
		this.vector = new int[(orden * (orden - 1)) / 2];
		for (int i = 0; i < ady * ((tam * (tam - 1)) / 2); i++) {
			this.vector[i] = 1;
		}
	}

	public boolean generadorRegular(int n, int grado) {
		if (n % 2 != 0 && grado % 2 != 0)
			return false;
		if (grado >= n)
			return false;

		int corte = 0;
		int tam = (n * (n - 1)) / 2;
		int[] grados = new int[n];
		this.vector = new int[tam];
		int i = 0, j = 0;
		while (corte < (n / 2) * grado) { ///Condicion de fin : comprueba si ya se crearon la cantidad de aristas necesarias para ese grado y esa cantidad de nodos
			if (grados[i] < grado) {///Si este nodo no alcanzo el grado pedido lo procesa
				j++;
				if (j == n)
					j = 0;
				while (grados[j] == grado||this.get(i, j) == 1||j==i ) {///Mientras que el nodo j haya cumplido con el grado, ya exista la arista que lo conecta con i o j=i avanza al siguiente
					j++;
					
					if (j == n)///si j supero el numero de nodos vuelve al nodo 0
						j = 0;
				}
				///Si supero las condiciones anteriores crea la arista que conecta i con j

				
					this.set(i, j, 1);///Crea la arista en la matriz
					grados[i]++;///Aumenta en  el grado del nodo i
					grados[j]++;///Aumenta en  el grado del nodo j
					corte++;///Aumenta en 1 la cantidad de aristas creadas
					i=j;///i continua en el nodo con el que conecto
					
				
			}
			else
				i++;
			if (i == n)
				i = 0;

		}
		return true;
	}

	public int getTam() {
		return this.tam;
	}

}
