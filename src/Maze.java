public class Maze {

    char[][] maze;
    private int mazeDim;


    public Maze(char[][] textMaze) {
        mazeDim = textMaze[0].length;
        maze = new char[mazeDim][mazeDim];
        for (int x = 0; x < mazeDim; x++) {
            for (int y = 0; y < mazeDim; y++) {
                maze[x][y] = textMaze[x][y];
            }
        }
        System.out.println("MazeDim is " + mazeDim);
    }

    public void printMaze() {
        for (int x = 0; x < mazeDim; x++) {
            for (int y = 0; y < mazeDim; y++) {
                System.out.print(maze[x][y] + " ");
            }
            System.out.print("\n");
        }
    }
}