package practica1;

public class clase1 {
	
	public static void imprimirA (int a,int b) {
		for (int i=a;i<=b; i++) {
			System.out.println(i);
		}
	}
	public static void imprimirB (int a,int b) {
		int indice=a;
		while (indice<=b) {
			System.out.println(indice);
			indice++;
		}
	}
	
	public static void imprimirC (int a,int b) {
		if (a<=b) {
			System.out.println(a);
			a++;
			imprimirC(a,b);
		}
	}


}
