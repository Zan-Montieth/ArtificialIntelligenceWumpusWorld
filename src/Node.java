class Node {
    private int xCoord;
    private int yCoord;
    private boolean[] attributes ; //0 Breeze, 1 wumpus, 2 stench, 3 pit, 4 glitter, 5 gold, 6 start.

    public Node (int inX, int inY, boolean[] inAttributes) {
        xCoord = inX;
        yCoord = inY;
        attributes = inAttributes;
    }
}