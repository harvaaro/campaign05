package edu.isu.cs.cs3308.structures.impl;

import java.util.Objects;

/**
 * Written from teh code shown in class
 *
 * @author Isaac Griffith
 */
public class Edge<V, E> {

	V src;
	V dest;
	E element;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Edge)) return false;
		Edge<?, ?> edge = (Edge<?, ?>) o;
		return getSrc().equals(edge.getSrc()) &&
				getDest().equals(edge.getDest());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getSrc(), getDest());
	}

	public Edge(V src, V dest, E element) {
		this.src = src;
		this.dest = dest;
		this.element = element;
	}

	public V getSrc() {
		return src;
	}

	public void setSrc(V src) {
		this.src = src;
	}

	public V getDest() {
		return dest;
	}

	public void setDest(V dest) {
		this.dest = dest;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}
}
