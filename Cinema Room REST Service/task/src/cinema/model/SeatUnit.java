package cinema.model;

public class SeatUnit {
    private int row;
    private int column;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice() {
        if (row <= 4) {
            this.price = 10;
        } else {
            this.price = 8;
        }

    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String toString(String type) {
        return "\n"+ '"'+ type+'"'+ ": {" +
                "row=" + row +
                ", column=" + column  +
                ", price=" +price +
                '}';
    }
}
