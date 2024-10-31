import java.util.Random;

public class Grid {
    private final int[][] grid;
    private final int width;
    private final int height;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new int[height][width];
        Initialize_Grid();
        CreatingObstacles();
    }

    private void Initialize_Grid() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = 0;
            }
        }
    }

    private void CreatingObstacles() {
        Random random = new Random();
        int numBarrier = width * height / 3; // Adjust as needed

        for (int i = 0; i < numBarrier; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            grid[y][x] = 1; // Barrier
        }
    }

    public void Grid_Display() {
        System.out.print("    ");
        for (int i = 0; i < width; i++) {
            System.out.printf("%-4d", i);
        }
        System.out.println();

        for (int i = 0; i < height; i++) {
            System.out.printf("%-4d", i);

            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 0) {
                    System.out.print("0   ");
                } else if (grid[i][j] == -1) {   // Display "x" for path cells
                    System.out.print("X   ");
                } else {
                    System.out.print("1   ");
                }
            }
            System.out.println();
        }
    }

    public int[][] getGrid() {
        return grid;
    }
}
