package Parte_2;

public class Tester {
	public static void main(String [] args) {
		Graph grafo = new Graph();
		
		grafo.addNode(2);
		grafo.addNode(9);
		grafo.addNode(3);
		grafo.addNode(5);
		grafo.addNode(9);
		grafo.addNode(0);
		grafo.addNode(4);
		
		grafo.addEdge(0, 2);
		grafo.addEdge(2, 4);
		grafo.addEdge(20, 9);
		grafo.addEdge(2, 4);
		
		grafo.removeNode(2);
		grafo.removeEdge(2,4);
	}
}
