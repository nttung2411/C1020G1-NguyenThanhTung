package debug_xulyngoaile.bai_tap;

public class Triangle {
    private int edgeOne;
    private int edgeTwo;
    private int edgeThree;

    public int getEdgeOne() {
        return edgeOne;
    }

    public void setEdgeOne(int edgeOne) {
        this.edgeOne = edgeOne;
    }

    public int getEdgeTwo() {
        return edgeTwo;
    }

    public void setEdgeTwo(int edgeTwo) {
        this.edgeTwo = edgeTwo;
    }

    public int getEdgeThree() {
        return edgeThree;
    }

    public void setEdgeThree(int edgeThree) {
        this.edgeThree = edgeThree;
    }

    public Triangle(int edgeOne, int edgeTwo, int edgeThree) throws IllegalTriangleException {
        if (edgeOne < 1 || edgeTwo < 1 || edgeThree < 1 || edgeOne + edgeTwo < edgeThree
                || edgeOne + edgeThree < edgeTwo || edgeTwo + edgeThree < edgeOne) {
            throw new IllegalTriangleException("Không phải tam giác");
        }
            this.edgeOne = edgeOne;
            this.edgeTwo = edgeTwo;
            this.edgeThree = edgeThree;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "edgeOne=" + edgeOne +
                ", edgeTwo=" + edgeTwo +
                ", edgeThree=" + edgeThree +
                '}';
    }
}
