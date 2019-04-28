package edu.isu.cs.cs3308.structures.impl;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * A class for parsing the file out
 *
 * @author Aaron Harvey
 */
public class FileParser {
	List<String> ReadFile(String file) {
		List<String> list = new LinkedList<>();

		try {
			list = Files.readAllLines(Paths.get(file));
		} catch (IOException ex) {
			System.out.println("IOExcption: " + ex);
		}

		return list;
	}

	<V, E> UnweightedGraph<V, E> Parse(List<String> list) {
		// TODO
		UnweightedGraph<V, E> ugraph = new UnweightedGraph<>();
		WeightedGraph<V, E> wgraph = new WeightedGraph<>();

		System.out.println("\nCurrent Network Configuration:");
		System.out.println("-----------------------------");

		for (String node : list) {
			String[] split1 = node.split(":");
			String[] split2 = split1[1].split(" ");

			for (int i = 1; i < split2.length; i++) {
				String[] split3 = split2[i].split("\\(");
				split2[i] = split3[0];
				if (split3.length > 1) {
					String weight = split3[1].substring(0, split3[1].length() - 1);
					System.out.println(split1[0] + "\t->\t" + split2[i] + "\t(" + weight + ")");
				} else {
					System.out.println(split1[0] + "\t->\t" + split2[i]);
				}
			}
		}

		System.out.println("\n-----------------------------");

		return ugraph;
	}
}