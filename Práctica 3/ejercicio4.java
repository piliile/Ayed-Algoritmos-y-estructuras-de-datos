package tp3.ejercicio4;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1y3y5.GeneralTree;

public class AnalizadorArbol {

	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();	
		if (arbol != null && !arbol.isEmpty()) {
			return calcularPromedio(arbol, cola);
		}
		return 0;
	}
	
	private double calcularPromedio (GeneralTree<AreaEmpresa> arbol, Queue<GeneralTree<AreaEmpresa>> cola) {
		double max = -1;
		
		GeneralTree<AreaEmpresa> aux;
		
		cola.enqueue(arbol); // ponemos el arbol en la cola
		
		while (!cola.isEmpty()) { // mientras la cola no esté vacía
			
			double totalNivel = 0; // acumulamos los valores del nivel actual
			int act = cola.size();
			
			for (int i = 0; i < act; i++) { // recorremos todos los nodos del nivel actual
				aux = cola.dequeue(); // sacamos el primer nodo de la cola
				
				totalNivel += aux.getData().getTardanza(); // acumulamos y sumamos el valor de tardanza del nodo
				
				for (GeneralTree<AreaEmpresa> hijo: aux.getChildren()) { // 
					cola.enqueue(hijo); // encolamos todos los hijos
				}
			}
			double promedioPorNivel = totalNivel/act; // calculamos el promedio de este nivel
			if (promedioPorNivel > max) { // si el promedio del nivel actual es mayor que el maximo, actualizamos el max que vamos a devolver --> max = el mayor promedio entre todos los niveles
				max = promedioPorNivel;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// definimos cada área para luego añadirla al árbol.
		AreaEmpresa area1 = new AreaEmpresa("m", 14);
		
		AreaEmpresa area2 = new AreaEmpresa("j", 13);
		AreaEmpresa area3 = new AreaEmpresa("k", 25);
		AreaEmpresa area4 = new AreaEmpresa("l", 10);
		
		AreaEmpresa area5 = new AreaEmpresa("a", 4);
		AreaEmpresa area6 = new AreaEmpresa("b", 7);
		AreaEmpresa area7 = new AreaEmpresa("c", 5);
		AreaEmpresa area8 = new AreaEmpresa("d", 6);
		AreaEmpresa area9 = new AreaEmpresa("e", 10);
		AreaEmpresa area10 = new AreaEmpresa("f", 18);
		AreaEmpresa area11 = new AreaEmpresa("g", 9);
		AreaEmpresa area12 = new AreaEmpresa("h", 12);
		AreaEmpresa area13 = new AreaEmpresa("i", 19);
		
		// armamos cada nodo con el valor del area correspondiente
		GeneralTree<AreaEmpresa> n1 = new GeneralTree<AreaEmpresa>(area1);
		
		GeneralTree<AreaEmpresa> n2 = new GeneralTree<AreaEmpresa>(area2);
		GeneralTree<AreaEmpresa> n3 = new GeneralTree<AreaEmpresa>(area3);
		GeneralTree<AreaEmpresa> n4 = new GeneralTree<AreaEmpresa>(area4);
	
		GeneralTree<AreaEmpresa> n5 = new GeneralTree<AreaEmpresa>(area5);
		GeneralTree<AreaEmpresa> n6 = new GeneralTree<AreaEmpresa>(area6);
		GeneralTree<AreaEmpresa> n7 = new GeneralTree<AreaEmpresa>(area7);
		GeneralTree<AreaEmpresa> n8 = new GeneralTree<AreaEmpresa>(area8);
		GeneralTree<AreaEmpresa> n9 = new GeneralTree<AreaEmpresa>(area9);
		GeneralTree<AreaEmpresa> n10 = new GeneralTree<AreaEmpresa>(area10);
		GeneralTree<AreaEmpresa> n11 = new GeneralTree<AreaEmpresa>(area11);
		GeneralTree<AreaEmpresa> n12 = new GeneralTree<AreaEmpresa>(area12);
		GeneralTree<AreaEmpresa> n13 = new GeneralTree<AreaEmpresa>(area13);
		
		// una vez armado el objeto area empresa y cada nodo del árbol, agregamos en cada nodo sus hijos correspondientes
		n1.addChild(n2);
		n1.addChild(n3);
		n1.addChild(n4);
		
		n2.addChild(n5);
		n2.addChild(n6);
		n2.addChild(n7);
		
		n3.addChild(n8);
		n3.addChild(n9);
		n3.addChild(n10);
		
		n4.addChild(n11);
		n4.addChild(n12);
		n4.addChild(n13);
		
		AnalizadorArbol aux = new AnalizadorArbol();
		
		System.out.println(aux.devolverMaximoPromedio(n1));
		//double maxProm = devolverMaximoPromedio(n1); --> esto si pongo el metodo static. es de clase podemos no tener algun objeto creado y podemos decir auto.llamamosmetodo de clase
		// auto1 = new clase --> auto1 tenemos un objeto y no podemos pedir un método de clase. 
		
	}
}
