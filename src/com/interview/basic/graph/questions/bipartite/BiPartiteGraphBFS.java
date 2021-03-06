package com.interview.basic.graph.questions.bipartite;

import com.interview.basic.graph.model.BFSearcher;
import com.interview.basic.graph.model.Graph;
import com.interview.basic.graph.model.Processor;

public class BiPartiteGraphBFS extends BiPartiteGraph{
	public boolean isBiPartite = true;

	public BiPartiteGraphBFS(Graph g) {
		super(g);
		searcher = new BFSearcher(g){
			private boolean flag = true;
			@Override
			public void bfsInner(Processor p) {
				while(!queue.isEmpty()){
					int s = queue.poll();
					if(s == -1){
						flag = !flag;
						if(!queue.isEmpty())	queue.add(-1);
						continue;
					}
					if(marked[s]) {
						if(flags[s] != flag) {
							isBiPartite = false;
							return;
						} else {
							continue;
						}
					}
					flags[s] = flag;
					marked[s] = true;
					if(g.adj[s] != null){
						for(int t : g.adj[s]){
							if(marked[t]) {
								if(flags[t] == flag) {
									isBiPartite = false;
									return;
								} else {
									continue;
								}
							}
							queue.add(t);
						}
					}
				}
			}
			@Override
			public void search(int s, Processor p) {
				queue.add(s);
				queue.add(-1);
				bfsInner(p);
			}
		};
	}

	@Override
	public boolean isBiPartite() {
		return isBiPartite;
	}
	
	
}
