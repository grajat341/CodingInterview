class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i <= 500 ; i++)
        {
            graph.put(i,new ArrayList<>());
        }

        dfs(graph,root);

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        queue.add(target.val);
        int level = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i = 0 ; i < size ; i++)
            {
                int tmp = queue.poll();
                if(level==k)
                {
                    ans.add(tmp);
                }
                for(int adjNode:graph.get(tmp))
                {
                    if(visited.contains(adjNode))
                        continue;
                    visited.add(adjNode);
                    queue.add(adjNode);
                }
            }
            level++;
        }

        return ans;
    }

    public void dfs(HashMap<Integer,List<Integer>> graph,TreeNode root)
    {
        if(root == null)
        {
            return;
        }

        dfs(graph,root.left);

        if(root.left!=null)
        {
            graph.get(root.left.val).add(root.val);
            graph.get(root.val).add(root.left.val);
        }

        if(root.right!=null)
        {
            graph.get(root.right.val).add(root.val);
            graph.get(root.val).add(root.right.val);
        }

        dfs(graph,root.right);
    }
}