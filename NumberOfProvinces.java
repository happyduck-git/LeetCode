public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};
        findCircleNum(isConnected);
    }
    public static int findCircleNum(int[][] isConnected) {

        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        //for loop
        for(int i = 0; i < isConnected.length; i++) {
            if(visited[i]) continue;
            dfs(i, visited, isConnected);
            count++;
        }
        System.out.println(count);
        return count;

    }
    private static void dfs(int from, boolean[] visited, int[][] isConnected) {
        if(visited[from]) return;

        visited[from] = true;

        for(int i = 0; i < isConnected.length; i++) {
            if(isConnected[from][i] == 1) {
                dfs(i, visited, isConnected);
            }
        }
    }
}
