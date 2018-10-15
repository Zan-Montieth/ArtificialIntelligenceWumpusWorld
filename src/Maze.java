import java.util.ArrayList;

public class Maze {

    private Node[][] nodeMaze;
    private ArrayList<Node> baseNodes = new ArrayList<>();
    private ArrayList<Node> emptyNodes = new ArrayList<>();
    private int mazeDim;


    //used to color output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";



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
    }

    public void solveMaze(){                                                                                            //will solve our maze
                                                                                                                        //forward checking setting nodes up for forward checking
        //TODO Solve the maze
    }

    private Node checkNieghborsFor(Node inNode, char inSearchFor){                                                      //can be used to find empty spaces or partner
        if( 0 <= inNode.getX() + 1 && inNode.getX() + 1 < mazeDim && inSearchFor == nodeMaze[inNode.getX() + 1][inNode.getY()].getValue()){
            return nodeMaze[inNode.getX()+1][inNode.getY()];
        }else if( 0 <= inNode.getX() - 1 && inNode.getX() - 1 < mazeDim && inSearchFor == nodeMaze[inNode.getX() - 1][inNode.getY()].getValue()){
            return nodeMaze[inNode.getX()-1][inNode.getY()];
        }else if( 0 <= inNode.getY() + 1 && inNode.getY() + 1 < mazeDim && inSearchFor == nodeMaze[inNode.getX()][inNode.getY() + 1].getValue()){
            return nodeMaze[inNode.getX()][inNode.getY()+1];
        }else if( 0 <= inNode.getY() - 1 && inNode.getY() - 1 < mazeDim && inSearchFor == nodeMaze[inNode.getX()][inNode.getY() - 1].getValue()){
            return nodeMaze[inNode.getX()][inNode.getY()-1];
        }else{
            return null;
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

    public void printBaseNodes(){                   //prints all none empty nodes
        for (Node baseNode : baseNodes) {
            if(baseNode.getValue() == 'A') {
                System.out.print(ANSI_CYAN + baseNode.getValue() + ANSI_RESET + " ");
            }else if(baseNode.getValue() == 'B'){
                System.out.print(ANSI_BLACK + baseNode.getValue() + ANSI_RESET + " ");
            }else if(baseNode.getValue() == 'D'){
                System.out.print(ANSI_BLUE + baseNode.getValue() + ANSI_RESET + " ");
            }else if(baseNode.getValue() == 'G'){
                System.out.print(ANSI_GREEN + baseNode.getValue() + ANSI_RESET + " ");
            }else if(baseNode.getValue() == 'K'){
                System.out.print(ANSI_CYAN + baseNode.getValue() + ANSI_RESET + " ");
            }else if(baseNode.getValue() == 'O'){
                System.out.print(ANSI_BLUE + baseNode.getValue() + ANSI_RESET + " ");
            }else if(baseNode.getValue() == 'P') {
                System.out.print(ANSI_PURPLE + baseNode.getValue() + ANSI_RESET + " ");
            }else if(baseNode.getValue() == 'Q'){
                System.out.print(ANSI_GREEN + baseNode.getValue() + ANSI_RESET + " ");
            }else if(baseNode.getValue() == 'R'){
                System.out.print(ANSI_RED + baseNode.getValue() + ANSI_RESET + " ");
            }else if(baseNode.getValue() == 'W'){
                System.out.print(ANSI_WHITE + baseNode.getValue() + ANSI_RESET + " ");
            }else if(baseNode.getValue() == 'Y'){
                System.out.print(ANSI_YELLOW + baseNode.getValue() + ANSI_RESET + " ");
            }
        }
        System.out.println();
    }
}