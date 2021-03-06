package com.interview.basic.graph.questions.mst;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

import com.interview.basic.graph.model.WeightedGraph;
import com.interview.basic.graph.model.WeightedGraph.Edge;
import com.interview.lectures.unionfind.EnhancedQuickUnionWeightTree;
import com.interview.lectures.unionfind.IUnionFind;

/**
 * Basic Idea: 
 *   1. sort the edge by weight in ascending order
 *   2. add next edge to tree T unless doing so would create a cycle.
 * Time: O(E log E)
 * 	If edges are already sorted, order of growth is E log* V.
 * 
 * Pf. Kruskal's algorithm is a special case of the greedy MST algorithm.
 * 	Suppose Kruskal's algorithm colors the edge e = v–w black.
 * 	Cut = set of vertices connected to v in tree T.
 * 	No crossing edge is black.	
 * 	No crossing edge has lower weight.
 * @author stefanie
 *
 */
public class KruskalMSTSolver extends MSTSolver{

	public KruskalMSTSolver(WeightedGraph g) {
		super(g);
	}

	@Override
	public void solve() {
		mst = new ArrayDeque<Edge>();
//		Iterable<Edge> edges = g.getSortedEdge(true);
//		IUnionFind uf = new EnhancedQuickUnionWeightTree(g.V);
//		for(Edge edge: edges){
//			if(mst.size() >= g.V - 1) break;
//			if(uf.connected(edge.s, edge.t)) continue;
//			uf.union(edge.s, edge.t);
//			mst.add(edge);
//			weight += edge.w;
//		}
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.addAll(g.edges());
		IUnionFind uf = new EnhancedQuickUnionWeightTree(g.V);
		while(!pq.isEmpty() && mst.size() < g.V -1){
			Edge edge = pq.poll();
			if(uf.connected(edge.s, edge.t)) continue;
			uf.union(edge.s, edge.t);
			mst.add(edge);
			weight += edge.w;
		}
	}
	
	

}
