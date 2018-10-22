import java.util.ArrayList;

public class Maze {

    private Node[][] nodeMaze;
    private ArrayList<Node> baseNodes = new ArrayList<>();
    private int numOfLines;
    private ArrayList<Node> emptyNodes = new ArrayList<>();
    private Node temp;
    private int mazeDim;


    //used to color output
    private String ANSI_RESET = "\u001B[0m";
    private String ANSI_BLACK = "\u001B[30m";
    private String ANSI_RED = "\u001B[31m";
    private String ANSI_GREEN = "\u001B[32m";
    private String ANSI_YELLOW = "\u001B[33m";
    private String ANSI_BLUE = "\u001B[34m";
    private String ANSI_PURPLE = "\u001B[35m";
    private String ANSI_CYAN = "\u001B[36m";
    private String ANSI_WHITE = "\u001B[37m";



    public Maze(char[][] textMaze) {
        mazeDim = textMaze[0].length;
        nodeMaze = new Node[mazeDim][mazeDim];
        for (int x = 0; x < mazeDim; x++) {
            for (int y = 0; y < mazeDim; y++) {
                Node temp = new Node( x, y, textMaze[x][y]);
                nodeMaze[x][y] = temp;
                if(temp.getBase()){
                    baseNodes.add(temp);
                }else {
                    emptyNodes.add(temp);
                }
            }
        }
        numOfLines = baseNodes.size()/2;
        for (Node emptyNode : emptyNodes) {
            emptyNode.instantiatePossibleValues(numOfLines);
        }
    }

    public void printMaze() {                       //will print out the maze, printing each nodes value which is a char
        for (int x = 0; x < mazeDim; x++) {
            for (int y = 0; y < mazeDim; y++) {
                System.out.print(nodeMaze[x][y].getValue() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printColorMaze() {
        for (int x = 0; x < mazeDim; x++) {
            for (int y = 0; y < mazeDim; y++) {
                if(nodeMaze[x][y].getValue() == 'A') {
                    System.out.print(ANSI_CYAN + nodeMaze[x][y].getValue() + ANSI_RESET + " ");
                }else if(nodeMaze[x][y].getValue() == 'B'){
                    System.out.print(ANSI_BLACK + nodeMaze[x][y].getValue() + ANSI_RESET + " ");
                }else if(nodeMaze[x][y].getValue() == 'D'){
                    System.out.print(ANSI_BLUE + nodeMaze[x][y].getValue() + ANSI_RESET + " ");
                }else if(nodeMaze[x][y].getValue() == 'G'){
                    System.out.print(ANSI_GREEN + nodeMaze[x][y].getValue() + ANSI_RESET + " ");
                }else if(nodeMaze[x][y].getValue() == 'K'){
                    System.out.print(ANSI_CYAN + nodeMaze[x][y].getValue() + ANSI_RESET + " ");
                }else if(nodeMaze[x][y].getValue() == 'O'){
                    System.out.print(ANSI_BLUE + nodeMaze[x][y].getValue() + ANSI_RESET + " ");
                }else if(nodeMaze[x][y].getValue() == 'P') {
                    System.out.print(ANSI_PURPLE + nodeMaze[x][y].getValue() + ANSI_RESET + " ");
                }else if(nodeMaze[x][y].getValue() == 'Q'){
                    System.out.print(ANSI_GREEN + nodeMaze[x][y].getValue() + ANSI_RESET + " ");
                }else if(nodeMaze[x][y].getValue() == 'R'){
                        System.out.print(ANSI_RED + nodeMaze[x][y].getValue() + ANSI_RESET + " ");
                }else if(nodeMaze[x][y].getValue() == 'W'){
                    System.out.print(ANSI_WHITE + nodeMaze[x][y].getValue() + ANSI_RESET + " ");
                }else if(nodeMaze[x][y].getValue() == 'Y'){
                    System.out.print(ANSI_YELLOW + nodeMaze[x][y].getValue() + ANSI_RESET + " ");
                }else{
                    System.out.print(nodeMaze[x][y].getValue() + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}