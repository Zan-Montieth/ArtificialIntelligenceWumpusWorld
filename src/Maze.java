import java.util.ArrayList;

public class Maze {

    private Node[][] nodeMaze;
    private ArrayList<Node> baseNodes = new ArrayList<>();
    private ArrayList<Node> emptyNodes = new ArrayList<>();
    private int mazeDim;


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

    public void printBaseNodes(){                   //prints all none empty nodes
        for (Node baseNode : baseNodes) {
            System.out.print(baseNode.getValue() + " ");
        }
        System.out.println();
    }
}