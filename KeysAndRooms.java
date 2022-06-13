import java.util.ArrayList;
import java.util.List;

public class KeysAndRooms {
    public static void main(String[] args) {

        List<List<Integer>> rooms = new ArrayList<>() {{
            add(new ArrayList<>(){{
                add(1);
                add(3);
            }});
            add(new ArrayList<>(){{
                add(3);
                add(0);
                add(1);
            }});
            add(new ArrayList<>(){{
                add(2);
            }});
            add(new ArrayList<>(){{
                add(0);
            }});
        }};

        canVisitAllRooms(rooms);
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        dfs(0, visited, rooms);

        for(boolean b : visited) {
            if(!b) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }

    private static void dfs(int from, boolean[] visited, List<List<Integer>> rooms) {

        if(visited[from]) return;
        visited[from] = true;


        for(int i = 0; i < rooms.get(from).size(); i++) {
            if(rooms.get(from).size() != 0) {
                dfs(rooms.get(from).get(i), visited, rooms);
            }
        }
    }
}
