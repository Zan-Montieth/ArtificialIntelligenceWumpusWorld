class Node {
    private int xCoord;
    private int yCoord;
    private char value;
    private Boolean base;

    public Node (int inX, int inY, char inValue) {
        xCoord = inX;
        yCoord = inY;
        value = inValue;
        base = value != '_';
    }

    public char getValue(){
        return value;
    }

    public Boolean getBase() {
        return base;
    }
}