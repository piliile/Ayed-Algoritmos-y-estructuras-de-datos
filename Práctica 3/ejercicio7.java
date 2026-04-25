package tp3.ejercicio7;

import java.util.List;
import java.util.ArrayList;
import tp3.ejercicio1y3y5.*;

public class Caminos {
	private GeneralTree<Integer> arbol;
	
	public Caminos(GeneralTree<Integer> a) {
	    this.arbol = a;
	}
	
	public List<Integer> caminoAHojaMasLejana() {
		List<Integer> caminoActual = new ArrayList<>();
		List<Integer> caminoMaximo = new ArrayList<>();
		
		if (arbol != null && !arbol.isEmpty()) {
			calculoHojaMasLejana(arbol, caminoActual, caminoMaximo);
		}
		
		return caminoMaximo;
	}
	
	private void calculoHojaMasLejana(GeneralTree<Integer> a, List<Integer> act, List<Integer> max) {
		
		act.add(a.getData());
		
		if (a.isLeaf()) {
			if (act.size() > max.size()) {
				max.clear();
				max.addAll(act);
			}
		}
		else {
			for (GeneralTree<Integer> hijo: a.getChildren()) {
					calculoHojaMasLejana(hijo, act, max);
			}
		}		
		act.remove(act.size() - 1);
	}	
	
	public static void main(String[] args) {
		GeneralTree<Integer> n12 = new GeneralTree<>(12);
	    GeneralTree<Integer> n17 = new GeneralTree<>(17);
	    GeneralTree<Integer> n9 = new GeneralTree<>(9);
	    GeneralTree<Integer> n15 = new GeneralTree<>(15);
	    GeneralTree<Integer> n10 = new GeneralTree<>(10);
	    GeneralTree<Integer> n6 = new GeneralTree<>(6);
	    GeneralTree<Integer> n8 = new GeneralTree<>(8);
	    GeneralTree<Integer> n14 = new GeneralTree<>(14);
	    GeneralTree<Integer> n18 = new GeneralTree<>(18);
	    GeneralTree<Integer> n1 = new GeneralTree<>(1);
	    GeneralTree<Integer> n16 = new GeneralTree<>(16);
	    GeneralTree<Integer> n7 = new GeneralTree<>(7);

	    n12.addChild(n17);
	    n12.addChild(n9);
	    n12.addChild(n15);

	    n17.addChild(n10);
	    n17.addChild(n6);
	    
	    n9.addChild(n8);

		n15.addChild(n14);
	    n15.addChild(n18);

	    n6.addChild(n1);

	    n14.addChild(n16);
	    n14.addChild(n7);
		    
		Caminos aux = new Caminos(n12);
		System.out.println(aux.caminoAHojaMasLejana());
	}
}
