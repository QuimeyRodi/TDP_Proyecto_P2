package Parte_2;

public class Edge {
	protected int origen;
	protected int destino;

	public Edge(int origen, int destino) {
		this.origen = origen;
		this.destino = destino;
	}

	public int get_origen() {
		return origen;
	}

	public int get_destino() {
		return destino;
	}
	
	public String toString() {
		return "("+origen+","+destino+")";
	}
}
