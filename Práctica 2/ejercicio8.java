package tp2.ejercicio8;

import tp2.ejercicio1y2.BinaryTree;

public class ParcialArboles2 {
	public ParcialArboles2() {
	}
	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean ok = false;
		if (arbol1.getData() == arbol2.getData()) {
			ok = true;
			if (arbol1.hasLeftChild()) {
				if (arbol2.hasLeftChild())
					ok = ok && esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild());
				else
					ok = false;
			}
			if (arbol1.hasRightChild()) {
				if (arbol2.hasRightChild())
					ok = ok && esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());
				else
					ok = false;
			}
		
		}
		else
			ok = false; 
		return ok;
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> arb1 = new BinaryTree<Integer>(10);
		arb1.addLeftChild(new BinaryTree<Integer>(2));
		arb1.addRightChild(new BinaryTree<Integer>(3));

		BinaryTree<Integer> arb2 = new BinaryTree<Integer>(10);
		arb2.addLeftChild(new BinaryTree<Integer>(2));
		arb2.addRightChild(new BinaryTree<Integer>(3));
		arb2.getLeftChild().addLeftChild(new BinaryTree<Integer>(5));
		
		ParcialArboles2 prueba = new ParcialArboles2();
		System.out.println(prueba.esPrefijo(arb1, arb2));
	}
}
