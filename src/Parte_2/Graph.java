package Parte_2;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Filter;
//import java.util.logging.LogRecord;


public class Graph {
	private List<Edge> arcos;
	private List<Integer> nodos;
	private static Logger logger;

	public Graph() {
		arcos = new LinkedList<Edge>();
		nodos = new LinkedList<Integer>();

		if (logger == null) {
			logger = Logger.getLogger(Graph.class.getName());

			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);

			logger.setLevel(Level.WARNING);

			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()) {
				h.setLevel(Level.OFF);
			}
		}
	}

	/**
	 * Agrega el nodo "node" al grafo, si aún no pertenecía a la estructura.
	 * 
	 * @param node nodo a insertar.
	 */
	public void addNode(int node) {
		Integer nodo = node;
		int pertenece = nodos.indexOf(nodo);

		if (pertenece == -1) {
			nodos.add(nodo);
			logger.info("El nodo " + node + " fue añadido al grafo correctamente.");
		} else {
			logger.warning("El nodo " + node + " ya pertenece al grafo, por lo tanto, no fue añadido.");
		}

	}

	/**
	 * Agrega un arco entre el nodo “node1” y el nodo “node2”, si aún no existía el
	 * arco y ambos parámetros son nodos pertenecientes a la estructura.
	 * 
	 * @param node1
	 * @param node2
	 */
	public void addEdge(int node1, int node2) {
		Integer nodo1 = node1, nodo2 = node2;
		int estaNodo1, estaNodo2;
		Edge edge;
		boolean pertenecen, existe_arco = false;
		estaNodo1 = nodos.indexOf(nodo1);
		estaNodo2 = nodos.indexOf(nodo2);

		pertenecen = estaNodo1 != -1 && estaNodo2 != -1;
		if (pertenecen) {
			for (Edge arco : arcos) {
				if (arco.get_origen() == nodo1 && arco.get_destino() == nodo2) {
					existe_arco = true;
					break;
				}
			}
			if (existe_arco)
				logger.warning(
						"El arco (" + node1 + "," + node2 + ") ya pertenece al grafo, por lo tanto, no fue añadido.");

			else {
				edge = new Edge(nodo1, nodo2);
				arcos.add(edge);
				logger.info("El arco " + edge.toString() + "  fue añadido al grafo correctamente.");
			}
		} else {
			if (estaNodo1 == -1)
				logger.warning("El nodo " + nodo1 + " no pertenece al grafo, por lo cual " + "el arco (" + nodo1 + ","
						+ nodo2 + ") no fue añadido");
			if (estaNodo2 == -1)
				logger.warning("El nodo " + nodo2 + " no pertenece al grafo, por lo cual " + "el arco (" + nodo1 + ","
						+ nodo2 + ") no fue añadido");

		}
	}

	/**
	 * Remueve el nodo “node” del grafo, si el parámetro es un nodo de la
	 * estructura.
	 * 
	 * @param node
	 */
	public void removeNode(int node) {
		Integer indice, nodo = node;
		indice = nodos.indexOf(nodo);

		if (indice != -1) {
			nodos.remove(indice);
			logger.info("El nodo " + node + " fue removido correctamente.");
			if (!arcos.isEmpty()) {
				eliminarArcos(nodo, 0, arcos.size());
			}
		} else {
			logger.warning("El nodo " + node + " no pertenece al grafo.");
		}
	}

	private void eliminarArcos(Integer nodo, int pri, int ult) {
		if (pri != ult)
			if (arcos.get(pri).get_origen() == nodo || arcos.get(pri).get_destino() == nodo) {
				eliminarArcos(nodo, pri + 1, ult);
		
				logger.info("El arco (" + arcos.get(pri).get_origen()+","+arcos.get(pri).get_destino() + ") fue removido correctamente.");
				arcos.remove(pri);
			}else
				eliminarArcos(nodo, pri + 1, ult);

	}

	/**
	 * Remueve el arco entre el nodo “node1” y el nodo “node2”, si el arco formado
	 * por los parámetros pertenecen a la estructura.
	 * 
	 * @param node1
	 * @param node2
	 */
	public void removeEdge(int node1, int node2) {
		Integer nodo1 = node1, nodo2 = node2;
		boolean elimine = false;
		for (Edge arco : arcos) {
			if (arco.get_origen() == nodo1 && arco.get_destino() == nodo2) {
				arcos.remove(arco);
				elimine = true;
				break;
			}
		}
		if (!elimine)
			logger.warning("El arco (" + node1 + "," + node2 + ") no pertenece al grafo.");
		else
			logger.info("El arco (" + node1 + "," + node2 + ") fue removido correctamente.");
	}

}
