package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Graph;

import java.util.*;

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

	}

	/**
	 * Returns an iteration of all edges of the graph
	 */
	@Override
	public Iterator<Edge<V, E>> edges() {
		List<Edge<V, E>> edges = new ArrayList<>();

		for (List<Edge<V, E>> list : adjMap.values()) {
			edges.addAll(list);
		}

		return edges.iterator();
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
		if (v != null && adjMap.containsKey(v)) {
			return adjMap.get(v).size();
		}

		return 0;
	}

	/**
	 * Returns the number of incoming edges to vertex v. For an undirected graph, this returns
	 * the same value as does outDegree(v)
	 *
	 * @param v
	 */
	@Override
	public int inDegree(V v) {
		int inDegree = 0;

		if (v != null) {
			for (V k : adjMap.keySet()) {
				// prevent self loop
				if (!k.equals(v)) {
					Edge<V, E> e = new Edge<>(k, v, null);

					if (adjMap.get(k).contains(e)) {
						inDegree++;
					}
				}

			}
		}

		return inDegree;
	}

	/**
	 * Returns an iteration of all outgoing edges from vertex v
	 *
	 * @param v
	 */
	@Override
	public Iterator<Edge<V, E>> outgoingEdges(V v) {
		return null;
	}

	/**
	 * Returns an iteration of all incoming edges to vertex v. For an undirected graph, this
	 * returns the same collection as does outgoingEdges(v)
	 *
	 * @param v
	 */
	@Override
	public Iterator<Edge<V, E>> incomingEdges(V v) {
		List<Edge<V, E>> edges = new ArrayList<>();

		if (v != null) {
			for (V k : adjMap.keySet()) {
				// prevent self loop
				if (!k.equals(v)) {
					for (Edge<V, E> edge : adjMap.get(k)) {
						if (edge.getDest().equals(v))
							edges.add(edge);
					}
				}

			}
		}

		return edges.iterator();
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
	public void insertEdge(V v, V u, E e) {
		if (v == null || u == null)
			return;

		if (adjMap.containsKey(v)) {
			List<Edge<V, E>> edges = adjMap.get(v);
			Edge<V, E> edge = new Edge<>(v, u, e);
			if (!adjMap.get(v).contains(edge))
				adjMap.get(v).add(edge);
		}
	}

	/**
	 * Removes edge e from the graph
	 *
	 * @param e
	 */
	@Override
	public void removeEdge(Edge<V, E> e) {
		if (e != null) {
			if (adjMap.containsKey(e.getSrc())) {
				adjMap.get(e.getSrc()).remove(e);
			}
		}
	}

	/**
	 * Removes vertex v and all its incident edges from the graph
	 *
	 * @param v
	 */
	@Override
	public void removeVertex(V v) {
		if (v != null) {
			if (adjMap.containsKey(v)) {
				adjMap.remove(v);
			}


			List<Edge<V,E>> edges = new ArrayList<>();
			for (List<Edge<V, E>> list: adjMap.values()) {
				for (Edge<V, E> e : edges) {
					if (e.getDest().equals(v))
						edges.add(e);
				}
			}

			for (Edge<V, E> edge : edges) {
				adjMap.get(edge.getSrc()).remove(edge);
			}
		}
	}

}
