package edu.isu.cs.cs3308.structures;

import java.util.Iterator;

/**
 * Interface defining the basic operations of a Graph ADT
 */
public interface Graph<V, E> {

    /** Returns the number of vertices of the graph */
    int numVertices();

    /** Returns an iteration of all the vertices of the graph */
    Iterator<Vertex<V, E>> vertices();

    /** Returns the number of edges of the graph */
    int numEdges();

    /** Returns an iteration of all edges of the graph */
    Iterator<Edge<E>> edges();

    /** Returns the edge from vertex u to vertex v, if one exists, otherwise returns null.
     *  For an undirected graph, there is no difference between getEdge(u, v) and getEdge(v, u)
     */
    Edge<E> getEdge(Vertex<V, E> u, Vertex<V, E> v);

    /** Returns an array containing the two endpoint vertices of edge e. If the graph is directed
     *  the first vertex is the origin and the second is the destination.
     */
    Vertex<V, E>[] endVertices(Edge<E> e);

    /** For edge e incident to vertex v, returns the other vertex of the edge; an error occurs
     *  if e is not incident to v.
     */
    Vertex<V, E> opposite(Vertex<V, E> v, Edge<E> e);

    /** Returns the number of outgoing edges from vertex v. */
    int outDegree(Vertex<V, E> v);

    /** Returns the number of incoming edges to vertex v. For an undirected graph, this returns
    *  the same value as does outDegree(v)
    */
    int inDegree(Vertex<V, E> v);

    /** Returns an iteration of all outgoing edges from vertex v */
    Iterator<Edge<E>> outgoingEdges(Vertex<V, E> v);

    /** Returns an iteration of all incoming edges to vertex v. For an undirected graph, this
     *  returns the same collection as does outgoingEdges(v)
     */
    Iterator<Edge<E>> incomingEdges(Vertex<V, E> v);

    /** Creates and returns a new Vertex storing element v */
    Vertex<V, E> insertVertex(V v);

    /** Creates and returns a new Edge from vertex u to vertex v, storing element e; an error occurs
     * if there already exists an edge from u to v
     */
    void insertEdge(Vertex<V, E> u, Vertex<V, E> v, E e);

    /** Removes vertex v and all its incident edges from the graph */
    V removeVertex(Vertex<V, E> v);

    /** Removes edge e from the graph */
    E removeEdge(Edge<E> e);
}
