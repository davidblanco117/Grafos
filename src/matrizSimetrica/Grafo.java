package matrizSimetrica;

public class Grafo {

	MatrizSimetrica mat;
	
	public Grafo(int tam) {
		mat=new MatrizSimetrica(tam);
		
	}
	
	
	public int getGradoMaximo() {
		int max=0;
		int acum=0;
		for(int i=0;i<this.mat.getTam();i++) {
			for(int j=0;j<this.mat.getTam();j++) {
				acum+=this.mat.get(i, j);
			}
			if(acum>max)
				max=acum;
			acum=0;
		}
		return max;
		
	}
	public boolean generadorRegular(int n, int grado) {
		return this.mat.generadorRegular(n, grado);
	}
	

	public int getGradoMinimo() {
		int min=0;
		int acum=0;
		
		for(int i=0;i<this.mat.getTam();i++) 
			min+=this.mat.get(0,i);
		
		for(int i=1;i<this.mat.getTam();i++) {
			for(int j=0;j<this.mat.getTam();j++) {
				acum+=this.mat.get(i, j);
			}
			if(acum<min)
				min=acum;
			acum=0;
		}
		return min;
		
	}
	
	
	public void mostrarVector() {
		this.mat.mostrarVector();
	}
	
	public int getCantAristas() {
		int cantAristasExis=0;
		for(int i=0;i<this.mat.getTam();i++) {
			for(int j=0;j<this.mat.getTam();j++) {
				cantAristasExis+=this.mat.get(i, j);
			}
		}
		return cantAristasExis/2;
	}
	
	
	
	public double getPorcentajeDeAdyacencia() {	
		int cantAristasMax=(this.mat.getTam()*(this.mat.getTam()-1))/2;
		return ((double)this.getCantAristas()/(double)cantAristasMax)*100;	
	}
	
	public void generadorPorProbabilidad(double prob, int orden) {
		this.mat.generadorPorProbabilidad(prob, orden);
	}
	
	public void generadorPorAdyacencia(double prob, int orden) {
		this.mat.generadorPorAdyacencia(prob, orden);
	}
	
	public static void main(String[] args) {
		
		
		Grafo grafo = new Grafo(10);
		grafo.generadorRegular(10,8 );
		grafo.mostrarVector();
		/*Grafo grafoAlea = new Grafo(20);
		Grafo grafo3=new Grafo(4);
		
		
		grafo3.mat.set(0, 1, 1);
		grafo3.mat.set(0, 2, 2);
		grafo3.mat.set(0, 3, 3);
		grafo3.mat.set(1, 2, 4);
		grafo3.mat.set(1, 3, 5);
		grafo3.mat.set(2, 3, 6);
		
		
		grafoAlea.generadorPorAdyacencia(0.05, 20);
		
		grafo.mat.set(0, 1, 1);
		grafo.mat.set(1, 2, 1);
		grafo.mat.set(1, 3, 1);
		grafo.mat.set(2, 4, 1);
		grafo.mat.set(3, 4, 1);
		
		System.out.println(grafoAlea.getGradoMaximo());
		System.out.println(grafoAlea.getGradoMinimo());
		System.out.println(grafoAlea.getPorcentajeDeAdyacencia()+"%");
		System.out.println(grafoAlea.getCantAristas());
		*/
	}
	
	
	
	
}
