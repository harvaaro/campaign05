package edu.isu.cs.cs3308.structures.impl;

import java.util.Iterator;

/**
 * A class for a graph
 *
 * @author Aaron Harvey
 */
public class ImplGraph<V, E> extends AbstractGraph<V, E> {
	void PrintConfig() {
		System.out.println("\nCurrent Network Configuration:");
		System.out.println("-----------------------------");

		Iterator<V> vertices = this.vertices();
		Iterator<Edge<V, E>> edges = this.edges();
		for (int v = 0; v < numVertices(); v++) {
			V vertex = vertices.next();

			Iterator<Edge<V, E>> outEdges = this.outgoingEdges(vertex);
			int outNum = this.outDegree(vertex);

			for (int e = 0; e < outNum; e++) {
				Edge<V, E> edge = outEdges.next();

				V[] edgeVertices = this.endVertices(edge);
				if (edge.getWeight() != null) {
					System.out.println(edgeVertices[0] + "\t->\t" + edgeVertices[1] + "\t(" + edge.getWeight() + ")");
				} else {
					System.out.println(edgeVertices[0] + "\t->\t" + edgeVertices[1]);
				}
			}
		}

		System.out.println("\n-----------------------------");
	}
}
