import java.util.Scanner;

public class RobotStateMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = getSuitableOutput(scanner, "Enter width : ");
        int height = getSuitableOutput(scanner, "Enter height : ");

        Grid grid = new Grid(width, height);
        grid.Grid_Display();

        int[][] gridData = grid.getGrid();

        int[] start = getInput("Enter starting point (column, row): ", scanner, gridData, width, height);
        int[] end = getInput("Enter ending point (column, row): ", scanner, gridData, width, height);

        PathNavigating PathNavigating = new PathNavigating(gridData, width, height);
        int[][] path = PathNavigating.NavigatePath(start, end);

        if (path != null) {
            System.out.println("Path found:");
            PathShowingInGrid(gridData, path);      // Mark the path in the grid
            grid.Grid_Display();      // Display the grid with the marked path
        } else {
            System.out.println("No path found!");
        }

        scanner.close();
    }

    static int getSuitableOutput(Scanner scanner, String prompt) {    //to get an input which satisfy condition.
        int input;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a positive integer.");
                System.out.print(prompt);
                scanner.next();
            }
            input = scanner.nextInt();
            if (input <= 0) {
                System.out.println("Invalid input! Please enter a positive integer.");
            }
        } while (input <= 0);
        return input;
    }

    static int[] getInput(String prompt, Scanner scanner, int[][] grid, int width, int height) {         //get input from user
        int[] point;
        do {
            point = getValues(scanner, prompt);
            if (point[0] < 0 || point[0] >= width || point[1] < 0 || point[1] >= height) {
                System.out.println("Invalid input! Please enter a valid location within the grid's dimensions.");
            } else if (grid[point[1]][point[0]] == 1) {
                System.out.println("Invalid input! This location contains an obstacle. Please choose another location.");
            }
        } while (point[0] < 0 || point[0] >= width || point[1] < 0 || point[1] >= height || grid[point[1]][point[0]] == 1);
        return point;
    }


    static int[] getValues(Scanner scanner, String prompt) {    //to get starting and ending point
        System.out.print(prompt);
        int column = scanner.nextInt();
        int row = scanner.nextInt();
        return new int[]{column, row};
    }

    static void PathShowingInGrid(int[][] grid, int[][] path) {
        for (int[] point : path) {
            grid[point[1]][point[0]] = -1; // Marking the path cell with -1
        }
    }
}
