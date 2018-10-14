import java.util.ArrayList;

public class Maze {

    private Node[][] nodeMaze;
    private ArrayList<Node> baseNodes = new ArrayList<>();
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
                }
            }
        }
    }

    public void printMaze() {
        for (int x = 0; x < mazeDim; x++) {
            for (int y = 0; y < mazeDim; y++) {
                System.out.print(nodeMaze[x][y].getValue() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printBaseNodes(){
        for (Node baseNode : baseNodes) {
            System.out.print(baseNode.getValue() + " ");
        }
        System.out.println();
    }
}