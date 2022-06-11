class Solution {
    
    
    class Edge{
        int v;
        int w;

        Edge(int v, int w){
            this.v=v;
            this.w=w;
        }
    }

    int[] par;
    int[] size;

    public int findPar(int u){
        if(par[u]==u) return u;

        int p=findPar(par[u]);
        
        par[u]=p;

        return p;
    }

    public void merge(int p1, int p2){
        if(size[p1]>=size[p2]){
            par[p2]=p1;
            size[p1]+=size[p2];
        } else {
            par[p1]=p2;
            size[p2]+=size[p1];
        }
    }

    public int kruskal(int[][] edges, int n)
    {
        par = new int[n+1];
        size = new int[n+1];
        
        for(int i = 0; i<=n; i++)
        {
            par[i] = i;
            size[i] = 1;
        }
        
        Arrays.sort(edges, (int[] a, int[] b) -> {
            return a[2] - b[2];
        });
        
        int cost = 0;
        
        for(int[] edge: edges)
        {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            int p1 = findPar(u);
            int p2 = findPar(v);
            
            if(p1 != p2)
            {
                merge(p1, p2);
                cost += w;
                
            }
        }
        
        return cost;
    }
    
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int pl = pipes.length;
        
        int[][] edges = new int[pl + n][3];
        
        for(int i=0; i < pl; i++)
        {
            edges[i][0] = pipes[i][0];
            edges[i][1] = pipes[i][1];
            edges[i][2] = pipes[i][2];
        }
        
        int j = pl;
        
        for(int i = 0; i < n; i++)
        {
            edges[j][0] = 0;
            edges[j][1] = i+1;
            edges[j][2] = wells[i];
            j++;
        }
        
        return kruskal(edges, n);
    }
}