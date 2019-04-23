package edu.isu.cs.cs3308.structures.impl;

public class Edge<V, E> {

	V src;
	V dest;
	E element;

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
