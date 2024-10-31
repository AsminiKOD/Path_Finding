public class PathNavigating {
    private final int[][] grid;
    private final int width;
    private final int height;

    public PathNavigating(int[][] grid, int width, int height) {
        this.grid = grid;
        this.width = width;
        this.height = height;
    }

    public int[][] NavigatePath(int[] start, int[] end) {
        QueueImplementation queue = new QueueImplementation(width * height);
        boolean[][] dropped_by = new boolean[height][width];
        MapImplementation Map = new MapImplementation();

        queue.enqueue(start);
        dropped_by[start[1]][start[0]] = true;

        while (!queue.isEmpty()) {
            int[] currentIndexes = queue.dequeue();

            if (currentIndexes[0] == end[0] && currentIndexes[1] == end[1]) {

                int[][] path = new int[width * height][2];  // Rebuild the path
                int Index = 0;

                while (currentIndexes != null) {
                    path[Index++] = currentIndexes;
                    currentIndexes = Map.get(currentIndexes);
                }

                int[][] outCome = new int[Index][2];
                System.arraycopy(path, 0, outCome, 0, Index);
                return outCome;
            }

            for (int[] neighbor : CheckNearby(currentIndexes)) {
                if (!dropped_by[neighbor[1]][neighbor[0]] && grid[neighbor[1]][neighbor[0]] == 0) {
                    queue.enqueue(neighbor);
                    dropped_by[neighbor[1]][neighbor[0]] = true;
                    Map.put(neighbor, currentIndexes);
                }
            }
        }

        return null;     // No path found
    }

    private int[][] CheckNearby(int[] p) {
        int[][] nearby = new int[4][2];
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < 4; i++) {
            int newX = p[0] + moves[i][0];
            int newY = p[1] + moves[i][1];
            if (newX >= 0 && newX < width && newY >= 0 && newY < height) {
                nearby[i] = new int[]{newX, newY};
            }
        }
        return nearby;
    }
}
