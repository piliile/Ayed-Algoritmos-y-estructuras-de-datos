package tp3.ejercicio9;

import tp3.ejercicio1y3y5.*;
import java.util.List;

public class ParcialArboles {
	
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		boolean aux = false;
		if (arbol != null && !arbol.isEmpty()) {
			aux = devuelvoValorSeleccion(arbol);
		}
		return aux;
	}
	
	private static boolean devuelvoValorSeleccion(GeneralTree<Integer> a) {
		boolean ok = true;
		int min = 9999;
		if (a.hasChildren()) {
			for (GeneralTree<Integer> hijo: a.getChildren()) {
				if (hijo.getData() < min) {
					min = hijo.getData();
				}
				if (!devuelvoValorSeleccion(hijo)) {
					ok = false;
				}
			}
			if (a.getData() != min) {
				ok = false;
			}
		}
		
		return ok;
	}
}
