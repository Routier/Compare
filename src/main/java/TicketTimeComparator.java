import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        // ваш код
        int flyTime1 = t1.getTimeTo() - t1.getTimeFrom();
        int flyTime2 = t2.getTimeTo() - t2.getTimeFrom();

        if (flyTime1 > flyTime2) {
            return 1;
        } else if (flyTime1 < flyTime2) {
            return -1;
        } else {
            return 0;
        }
    }
}