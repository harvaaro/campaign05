package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class AbstractGraph<V,E> implements Graph<V,E> {
	Map<V, List<E>> adjMap;



	/**
	 * Returns the number of vertices of the graph
	 */
	@Override
	public int numVertices() {
		return adjMap.keySet().size();
	}

	/**
	 * Returns the number of edges of the graph
	 */
	@Override
	public int numEdges() {
		int[] sum = {0};
		adjMap.values().forEach( v -> {
			sum[0] += v.size();
		});
		return sum[0];
	}

	/**
	 * Creates and returns a new Vertex storing element v
	 *
	 * @param v
	 */
	@Override
	public V insertVertex(V v) {
		if (v != null || !adjMap.containsKey(v))
			adjMap.put(v, new LinkedList<>());

		return v;
	}

	/**
	 * Creates and returns a new Edge from vertex u to vertex v, storing element e; an error occurs
	 * if there already exists an edge from u to v
	 *
	 * @param u
	 * @param v
	 * @param e
	 */
	@Override
	public void insertEdge(V u, V v, E e) {

	}

	/**
	 * Removes vertex v and all its incident edges from the graph
	 *
	 * @param v
	 */
	@Override
	public V removeVertex(Vertex<V, E> v) {
		return null;
	}

	/**
	 * Removes edge e from the graph
	 *
	 * @param e
	 */
	@Override
	public E removeEdge(Edge<E> e) {
		return null;
	}
}
