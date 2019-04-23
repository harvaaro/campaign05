package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class AbstractGraph<V, E> implements Graph<V, E> {

	Map<V, List<Edge<V, E>>> adjMap;

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
	public void insertEdge(V v, V u) {
		if (v == null && u == null)
			return;

		if (adjMap.containsKey(v)) {
			List<V> edges = adjMap.get(v);
			if (!edges.contains(u))
				edges.add(u);
		}
	}

	/**
	 * Returns an iteration of all the vertices of the graph
	 */
	@Override
	public Iterator<Edge<V,E>> vertices() {
		return null;
	}

	/**
	 * Returns an iteration of all edges of the graph
	 */
	@Override
	public Iterator<Edge<E>> edges() {
		return null;
	}

	/**
	 * Returns the edge from vertex u to vertex v, if one exists, otherwise returns null.
	 * For an undirected graph, there is no difference between getEdge(u, v) and getEdge(v, u)
	 *
	 * @param u
	 * @param v
	 */
	@Override
	public Edge<V, E> getEdge(V v, V u) {
		if (v == null || u == null)
			return null;

		if (adjMap.containsKey(v)) {
			for (Edge<V,E> edge : adjMap.get(v)) {
				if (edge.getDest().equals(u))
					return edge;
			}
		}

		return null;
	}

	/**
	 * Returns an array containing the two endpoint vertices of edge e. If the graph is directed
	 * the first vertex is the origin and the second is the destination.
	 *
	 * @param e
	 */
	@Override
	public V[] endVertices(Edge<V, E> e) {
		V[] ret = {e.getSrc(), e.getDest()};

		retrun ret;
	}

	/**
	 * For edge e incident to vertex v, returns the other vertex of the edge; an error occurs
	 * if e is not incident to v.
	 *
	 * @param v
	 * @param e
	 */
	@Override
	public V opposite(V v, Edge<V, E> e) {
		if (v != null && e != null) {

			if (e.getDest().equals(v))
				return e.getSrc();
			else
				return e.getDest();
		}
	}

	/**
	 * Returns the number of outgoing edges from vertex v.
	 *
	 * @param v
	 */
	@Override
	public int outDegree(V v) {
		return 0;
	}

	/**
	 * Returns the number of incoming edges to vertex v. For an undirected graph, this returns
	 * the same value as does outDegree(v)
	 *
	 * @param v
	 */
	@Override
	public int inDegree(Vertex<V, E> v) {
		return 0;
	}

	/**
	 * Returns an iteration of all outgoing edges from vertex v
	 *
	 * @param v
	 */
	@Override
	public Iterator<Edge<E>> outgoingEdges(Vertex<V, E> v) {
		return null;
	}

	/**
	 * Returns an iteration of all incoming edges to vertex v. For an undirected graph, this
	 * returns the same collection as does outgoingEdges(v)
	 *
	 * @param v
	 */
	@Override
	public Iterator<Edge<E>> incomingEdges(Vertex<V, E> v) {
		return null;
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
	public void insertEdge(Vertex<V, E> u, Vertex<V, E> v, E e) {

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

	/**
	 * Removes vertex v and all its incident edges from the graph
	 *
	 * @param v
	 */
	@Override
	public V removeVertex(V v) {
		//TODO remove incoming edges

		if (v != null && !adjMap.containsKey(v))
			adjMap.remove(v);

		return v;
	}

	/**
	 * Removes edge e from the graph
	 *
	 * @param e
	 */
	@Override
	public void removeEdge(V v, V u) {
		if (v == null && u == null)
			return;

		if (adjMap.containsKey(v)) {
			List<V> edges = adjMap.get(v);
			if (edges.contains(u))
				edges.remove(u);
		}
	}
}
