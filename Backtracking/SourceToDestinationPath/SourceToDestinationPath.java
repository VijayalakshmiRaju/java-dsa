import java.util.*;

public class SourceToDestinationPath {

    /**
     * Main function to get path from source to destination
     * after eliminating cycles inside the graph.
     */
    public static List<String> getPathToDestination(List<List<String>> paths)
    {
        // Step 1: Build adjacency list (outgoing edges) and incoming counts
        Map<String, List<String>> outgoingMap = new HashMap<>(); // maps each city -> list of its destinations
        Map<String, Integer> incomingCount = new HashMap<>();    // counts how many incoming edges each city has

        for (List<String> path : paths) {
            String src = path.get(0);
            String dest = path.get(1);

            // Add destination into adjacency list of src
            outgoingMap.putIfAbsent(src, new ArrayList<>());
            outgoingMap.get(src).add(dest);

            // Maintain incoming edge count
            incomingCount.put(dest, incomingCount.getOrDefault(dest, 0) + 1);
            incomingCount.putIfAbsent(src, 0); // ensure src is also present in map
        }

        // Step 2: Find the source city (city with no incoming edges)
        String source = "";
        for (String city : incomingCount.keySet()) {
            if (incomingCount.get(city) == 0) {
                source = city;
                break;
            }
        }

        // Step 3: Find the destination city (city with no outgoing edges)
        String destination = "";
        for (String city : incomingCount.keySet()) {
            if (!outgoingMap.containsKey(city)) {
                destination = city;
                break;
            }
        }

        // Step 4: Backtracking DFS to build path from source -> destination
        List<String> pathResult = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        backtrack(source, destination, outgoingMap, visited, pathResult);

        return pathResult;
    }

    /**
     * Recursive backtracking DFS function to find a valid path.
     */
    private static boolean backtrack(String city, String destination, Map<String, List<String>> outgoingMap, Set<String> visited, List<String> pathResult) {
        // If city is null or already visited => stop (avoids cycles)
        if (city == null || visited.contains(city))
            return false;

        // Add this city to path and mark visited
        visited.add(city);
        pathResult.add(city);

        // Base condition: if we reached destination, path is complete
        if (city.equals(destination))
            return true;

        // Explore next cities (neighbors)
        if (outgoingMap.containsKey(city)) {
            for (String next : outgoingMap.get(city)) {
                if (backtrack(next, destination, outgoingMap, visited, pathResult))
                    return true; // found successful path, stop further exploration
            }
        }

        // If no path found from this city, backtrack (remove last step)
        visited.remove(city);
        pathResult.remove(pathResult.size() - 1);
        return false;
    }

    // ===================== MAIN METHOD =====================
    public static void main(String[] args) {
        // Utility method to create paths
        java.util.function.Function<String[][], List<List<String>>> makePaths = (arr) -> {
            List<List<String>> list = new ArrayList<>();
            for (String[] p : arr) list.add(Arrays.asList(p));
            return list;
        };

        // Define test cases
        List<String[][]> testCases = new ArrayList<>();
        testCases.add(new String[][]{{"A","B"},{"B","C"},{"C","D"}});              // Simple straight path
        testCases.add(new String[][]{{"A","B"}});                                 // Single edge
        testCases.add(new String[][]{{"A","B"},{"B","C"},{"C","B"},{"C","D"}});   // Cycle in middle
        testCases.add(new String[][]{{"A","B"},{"B","C"},{"C","D"},{"D","C"}});   // Cycle at end
        testCases.add(new String[][]{{"A","B"},{"C","B"},{"B","D"}});             // Multiple incoming edges
        testCases.add(new String[][]{{"A","B"},{"A","C"},{"C","D"},{"D","B"},{"B","E"}}); // Multiple outgoing edges with cycle
        testCases.add(new String[][]{{"A","D"},{"C","B"},{"B","E"},{"E","D"},{"D","C"},{"C","F"}}); // Indirect cycle
        testCases.add(new String[][]{{"A","B"},{"B","C"},{"C","D"},{"D","E"},{"E","B"},{"E","F"}}); // Bigger cycle
        testCases.add(new String[][]{{"A","B"},{"B","C"},{"C","A"},{"C","D"}});   // No city is source, since all are having incoming edges.
        testCases.add(new String[][]{{"A","B"},{"B","C"},{"C","B"},{"C","D"},{"D","E"}}); // Cycle before destination

        // Run all test cases in a loop
        int caseNum = 1;
        for (String[][] test : testCases) {
            List<List<String>> pathList = makePaths.apply(test);
            List<String> result = getPathToDestination(pathList);

            // Convert list to pretty format: A -> B -> C -> D
            String prettyPath = String.join(" -> ", result);

            System.out.println("Test Case " + caseNum + ":");
            System.out.println("Input Paths    : " + pathList);
            System.out.println("Output (List)  : " + result);
            System.out.println("Output (Pretty): " + prettyPath);
            System.out.println("--------------------------------------------------");
            caseNum++;
        }
    }
}
