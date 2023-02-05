package cinema.model;

import java.util.ArrayList;
import java.util.List;


public class Seat {
    private int totalRows = 9;
    private int totalColumns = 9;

    public List<String> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<String> availableSeats) {
        this.availableSeats = availableSeats;
    }

    private static List<String> availableSeats = new ArrayList<String>();
    public static void addAvailableSeats(){
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                StringBuilder strTempo = new StringBuilder();
                strTempo.append("{" + "row:" +i + ",");
                strTempo.append(" column:").append(j).append( ",");
                if (i <= 4) {
                    strTempo.append(" price:" + 10 +"}");
                } else {
                    strTempo.append(" price:" + 8 +"}");
                }
                availableSeats.add(strTempo.toString());
            }

        }
    }
    private static Seat seatInstance;
    private Seat(){

    }
    public static Seat getInstance(){
        addAvailableSeats();
        if (seatInstance==null){
            seatInstance = new Seat();
        }
        return seatInstance;
    }


    @Override
    public String toString() {

        return '{'+
                "total_rows:" + totalRows +
                ", total_columns:" + totalColumns +
                ", available_seats:" + availableSeats+
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