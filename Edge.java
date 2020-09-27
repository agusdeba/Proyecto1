package Parte_2;

public class Edge {
	private Integer origen, destino;

	public Edge(int origen, int destino) {
		this.origen = origen;
		this.destino = destino;
	}

	public boolean equals(Edge arco) {
		return origen == arco.getOrigen() && destino == arco.getDestino();
	}

	public Integer getOrigen() {
		return origen;
	}

	public Integer getDestino() {
		return destino;
	}
	public String toString() {
		return "Arco: ( "+origen+" , "+destino+" )";
	}
}
