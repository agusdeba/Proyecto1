package Parte_2;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

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

			logger.setLevel(Level.FINE);

			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()) {
				h.setLevel(Level.OFF);
			}
		}
	}

	/**
	 * Agrega el nodo “node” al grafo, si aún no pertenecía a la estructura.
	 * 
	 * @param node nodo a insertar.
	 */
	public void addNode(int node) {
		Integer nodo = node;

		if (nodos.indexOf(nodo) == -1) {
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
		Integer origen = node1, destino = node2;
		int indiceNodo1, indiceNodo2;
		boolean pertenecen;
		indiceNodo1 = nodos.indexOf(origen);
		indiceNodo2 = nodos.indexOf(destino);
		Edge newEdge = new Edge(origen, destino);
		pertenecen = indiceNodo1 != -1 && indiceNodo2 != -1;

		if (pertenecen) {
			if (!estaArco(newEdge)) {
				arcos.add(newEdge);
				logger.info("El arco con origen " + node1 + " y extremo " + node2
						+ "  fue añadido al grafo correctamente.");
			} else {
				logger.warning("El arco con origen " + node1 + " y extremo " + node2
						+ "  ya pertenece al grafo, por lo tanto, no fue añadido.");
			}
		} else {
			if (indiceNodo1 == -1) {
				logger.info("El nodo " + node1 + " no pertenece al grafo.");
			}
			if (indiceNodo2 == -1) {
				logger.info("El nodo " + node2 + " no pertenece al grafo.");
			}
		}
	}

	/**
	 * Retorna true en caso de que el arco parametrizado pertenezca al grafo, false
	 * caso contrario.
	 * 
	 * @param edge arco a buscar.
	 * @return
	 */
	private boolean estaArco(Edge edge) {
		boolean esta = false;

		for (Edge arcoActual : arcos) {
			if (arcoActual.equals(edge)) {
				esta = true;
				break;
			}
		}

		return esta;
	}

	/**
	 * Remueve el nodo “node” del grafo, si el parámetro es un nodo de la
	 * estructura.
	 * 
	 * @param node
	 */
	public void removeNode(int node) {
		Integer nodo = node;
		int index = nodos.indexOf(nodo);
		
		if (index != -1) {
			removerArcos(nodo, 0);
			nodos.remove(index);
			logger.info("El nodo " + node + " fue removido correctamente.");
		} else {
			logger.warning("El nodo " + node + " no pertenece al grafo.");
		}
	}

	/**
	 * Remueve los arcos adyacentes e incidentes a un nodo.
	 * 
	 * @param nodo
	 * @param indice
	 */
	private void removerArcos(int nodo, int indice) {
		if (indice < arcos.size()) {
			removerArcos(nodo, indice + 1);
			if (arcos.get(indice).getOrigen() == nodo || arcos.get(indice).getDestino() == nodo) {
				logger.info("Arco eliminado: " + arcos.get(indice).toString());
				arcos.remove(indice);
			}
		}
	}

	/**
	 * Remueve el arco entre el nodo “node1” y el nodo “node2”, si el arco formado
	 * por los parámetros pertenecen a la estructura.
	 * 
	 * @param node1
	 * @param node2
	 */
	public void removeEdge(int node1, int node2) {
		Integer origen = node1, destino = node2;
		Edge edge = new Edge(origen, destino);
		boolean esta = false;

		for (Edge arcoActual : arcos) {
			if (arcoActual.equals(edge)) {
				esta = true;
				arcos.remove(arcoActual);
				break;
			}
		}

		if (esta) {
			logger.info("El arco con origen " + origen + " y destino " + destino + " fue removido correctamente");
		} else {
			logger.warning("El arco con origen " + origen + " y destino " + destino
					+ " no pertenece al grafo, por lo que no hubo modificaciones.");
		}

	}

}