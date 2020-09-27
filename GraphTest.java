package Parte_2;

public class GraphTest {
	public static void main(String [] args) {
		Graph grafo = new Graph();
		
		grafo.addNode(29);
        grafo.addNode(32);
        grafo.addNode(56);
        grafo.addNode(98);
        grafo.addNode(45);
        grafo.addNode(12);
        grafo.addNode(12);
        grafo.addNode(3);
        
        grafo.addEdge(29, 45);
        grafo.addEdge(45, 29);
        grafo.addEdge(45, 3);
        grafo.addEdge(3, 45);
        grafo.addEdge(3, 45);
        grafo.addEdge(3, 11);
        
        
        grafo.removeNode(29);
        grafo.removeNode(29);
        grafo.addEdge(29, 45);
        grafo.removeNode(3);
        
		
	
	
	}
}
