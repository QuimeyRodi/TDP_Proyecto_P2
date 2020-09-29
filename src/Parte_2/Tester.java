package Parte_2;

public class Tester {
	public static void main(String[] args) {
		Graph grafo = new Graph();

		grafo.addNode(29);
		grafo.addNode(56);
		grafo.addNode(98);
		grafo.addNode(45);
		grafo.addNode(56);

		grafo.addEdge(29, 45);
		grafo.addEdge(45, 29);
		grafo.addEdge(98, 45);
		grafo.addEdge(45, 3);

		grafo.removeNode(29);
		grafo.addEdge(29, 45);
	}
}
