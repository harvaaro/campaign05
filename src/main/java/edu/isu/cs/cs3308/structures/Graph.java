package edu.isu.cs.cs3308.structures;

import edu.isu.cs.cs3308.structures.impl.Edge;

import java.util.Iterator;

/**
 * Interface defining the basic operations of a Graph ADT
 *
 * Written from the code shown in class and
 * updated to include the modified methods
 *
 * @author Isaac Griffith
 * @author Aaron Harvey
 */
public interface Graph<V, E> {

    /**
     * Returns the number of vertices of the graph
     */
    public int numVertices();

    /**
     * Returns the number of edges of the graph
     */
    public int numEdges();

    /**
     * Creates and returns a new Vertex storing element v
     *
     * @param v
     */
    public V insertVertex(V v);

    /**
     * Returns an iteration of all the vertices of the graph
     */
    public Iterator<V> vertices();

    /**
     * Returns an iteration of all edges of the graph
     */
    public Iterator<Edge<V, E>> edges();

    /**
     * Returns the edge from vertex v to vertex u, if one exists, otherwise returns null.
     * For an undirected graph, there is no difference between getEdge(v, u) and getEdge(u, v)
     *
     * @param v
     * @param u
     */
    public Edge<V, E> getEdge(V v, V u);

    /**
     * Returns an array containing the two endpoint vertices of edge e. If the graph is directed
     * the first vertex is the origin and the second is the destination.
     *
     * @param e
     */
    public V[] endVertices(Edge<V, E> e);

    /**
     * For edge e incident to vertex v, returns the other vertex of the edge; an error occurs
     * if e is not incident to v.
     *
     * @param v
     * @param e
     */
    public V opposite(V v, Edge<V, E> e);

    /**
     * Returns the number of outgoing edges from vertex v.
     *
     * @param v
     */
    public int outDegree(V v);

    /**
     * Returns the number of incoming edges to vertex v. For an undirected graph, this returns
     * the same value as does outDegree(v)
     *
     * @param v
     */
    public int inDegree(V v);

    /**
     * Returns an iteration of all outgoing edges from vertex v
     *
     * @param v
     */
    public Iterator<Edge<V, E>> outgoingEdges(V v);

    /**
     * Returns an iteration of all incoming edges to vertex v. For an undirected graph, this
     * returns the same collection as does outgoingEdges(v)
     *
     * @param v
     */
    public Iterator<Edge<V, E>> incomingEdges(V v);

    /**
     * Creates and returns a new Edge from vertex v to vertex u, storing element e; an error occurs
     * if there already exists an edge from v to u
     *
     * @param v
     * @param u
     * @param e
     */
    public void insertEdge(V v, V u, E e);

    /**
     * Removes edge e from the graph
     *
     * @param e
     */
    public void removeEdge(Edge<V, E> e);

    /**
     * Removes vertex v and all its incident edges from the graph
     *
     * @param v
     */
    public void removeVertex(V v);
}
