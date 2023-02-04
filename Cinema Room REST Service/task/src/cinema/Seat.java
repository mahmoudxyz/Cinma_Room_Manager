package cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Seat {
    int totalRows = 9;
    int totalColumns = 9;
    List<String> availableSeats = new ArrayList<String>();
    public void addAvailableSeats(){
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                availableSeats.add("{"+"row:" + i + "\n");
                availableSeats.add("column:" + j +"}");
            }
        }
    }


    @Override
    public String toString() {
        addAvailableSeats();
        return '{'+
                "total_rows=" + totalRows +
                ", total_columns=" + totalColumns +
                ", available_seats=" + availableSeats+
                '}';
    }

    public int getTotalRows () {
            return totalRows;
        }

        public void setTotalRows ( int totalRows){
            this.totalRows = totalRows;
        }

        public int getTotalColumns () {
            return totalColumns;
        }

        public void setTotalColumns ( int totalColumns){
            this.totalColumns = totalColumns;
        }


    }