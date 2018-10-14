import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) throws IOException {
        Maze fiveMaze     = readMazeIn("5x5maze.txt");
        //Maze sevenMaze    = readMazeIn("7x7maze.txt");
        //Maze eightMaze    = readMazeIn("8x8maze.txt");
        //Maze nineMaze     = readMazeIn("9x9maze.txt");
        //Maze tenMaze      = readMazeIn("10x10maze.txt");
        //Maze twelveMaze   = readMazeIn("12x12maze.txt");
        //Maze fourteenMaze = readMazeIn("14x14maze.txt");

        fiveMaze.printMaze();
        System.out.println("Program Done");
    }

    private static Maze readMazeIn(String mazeName) throws IOException {
        ArrayList<String> maze = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(mazeName));
        try {
            String line = br.readLine();
            while (line != null) {
                maze.add(line);
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        char[][] newMaze = new char[maze.size()][maze.get(0).length()];
        for (int i = 0; i < maze.size(); i++) {
            newMaze[i] = maze.get(i).toCharArray();
        }
        Maze charMaze = new Maze(newMaze);
        return charMaze;


    }
}