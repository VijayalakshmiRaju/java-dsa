import java.util.ArrayList;
import java.util.List;

public class MinimumMeetingRooms {
    /**
     * Finds the minimum number of rooms required to hold all valid meetings.
     * A meeting is considered valid only if its required capacity <= room capacity.
     *
     * @param meetings Array of meetings [start, end, people]
     * @param capacity Room capacity (max number of people allowed in one room)
     * @return Minimum number of rooms required
     */
    public static int minRooms(int[][] meetings, int capacity) {
        List<int[]> events = new ArrayList<>();

        // Step 1: Convert each valid meeting into 2 events: start (+1) and end (-1)
        for (int[] meeting : meetings) {
            if (meeting[2] <= capacity) { // Only keep meetings that fit room capacity
                events.add(new int[]{meeting[0], +1}); // +1 means one meeting starts
                events.add(new int[]{meeting[1], -1}); // -1 means one meeting ends
            }
        }

        // If no valid meetings, no rooms needed
        if (events.isEmpty())
            return 0;

        // Step 2: Sort events by time
        // If two events have same time, process "end" (-1) before "start" (+1)
        // This avoids counting a room as occupied when a meeting ends and another starts at same time.
        events.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int rooms = 0, maxRooms = 0;

        // Step 3: Sweep through timeline
        for (int[] event : events) {
            rooms += event[1];          // Update active room count (+1 start, -1 end)
            maxRooms = Math.max(rooms, maxRooms); // Track peak room usage
        }

        return maxRooms; // Minimum rooms required = maximum overlap
    }

    public static void main(String[] args) {
        // Test cases stored in an array of objects
        Object[][] testCases = {
                {new int[][]{{9, 10, 3}, {9, 12, 5}, {11, 12, 8}}, 10, 2, "Overlapping meetings"},
                {new int[][]{{9, 10, 15}, {10, 11, 5}}, 10, 1, "Ignore meeting exceeding capacity"},
                {new int[][]{{9, 10, 3}, {10, 11, 4}, {11, 12, 5}}, 10, 1, "Back-to-back meetings"},
                {new int[][]{{9, 12, 3}, {10, 12, 5}, {11, 12, 4}}, 10, 3, "All overlapping meetings"},
                {new int[][]{}, 10, 0, "No meetings"},
                {new int[][]{{9, 10, 2}, {9, 10, 3}, {9, 10, 4}}, 10, 3, "Same time meetings"},
                {new int[][]{{9, 10, 2}, {10, 11, 3}, {11, 12, 4}}, 10, 1, "Meetings start when others end"}
        };

        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-5s | %-35s | %-8s | %-8s | %-4s\n",
                "Test", "Description", "Expected", "Actual", "Result");
        System.out.println("----------------------------------------------------------------------------");

        for (int i = 0; i < testCases.length; i++) {
            int[][] meetings = (int[][]) testCases[i][0];
            int capacity = (int) testCases[i][1];
            int expected = (int) testCases[i][2];
            String description = (String) testCases[i][3];

            int result = minRooms(meetings, capacity);
            String status = (result == expected ? "PASS" : "FAIL");

            System.out.printf("%-5d | %-35s | %-8d | %-8d | %-4s\n",
                    i + 1, description, expected, result, status);
        }

        System.out.println("----------------------------------------------------------------------------");
    }
}
