package tp3.ejercicio11;

import tp3.ejercicio1y3y5.*;
import tp1.ejercicio8.Queue;

public class ParcialArboles {
	
	public static boolean resolver(GeneralTree<Integer> arbol) {
		boolean aux = false;
		if (arbol != null && !arbol.isEmpty()) {
			aux = helper(arbol);
		}
		return aux;
	}
	
	private static boolean helper(GeneralTree<Integer> a) {
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		GeneralTree<Integer> nodoAux;
		boolean ok = true; // asumimos q cumple y si no cumple lo modificamos
		int nivelAnterior = 0;
		cola.enqueue(a);
		while (!cola.isEmpty() && ok) {
			int act = cola.size();
			if (act != nivelAnterior + 1) { // si no tiene exactamente 1+ que el anterior cortamos el while
				ok = false;
			}
			else { // si cumple seguimos procesando niveles
				for (int i = 0; i < act; i++) {
					nodoAux = cola.dequeue();
					for (GeneralTree<Integer> hijo: nodoAux.getChildren()) {
						cola.enqueue(hijo);
					}
				}
			}
		}
		return ok;
	}
	
}
