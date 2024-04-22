import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    @Test
    public void testSortCompare() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("msk", "spb", 100, 3, 12); //2
        Ticket ticket2 = new Ticket("spb", "msk", 200, 4, 6);
        Ticket ticket3 = new Ticket("msk", "spb", 700, 9, 15); //3
        Ticket ticket4 = new Ticket("msk", "kz", 300, 18, 23);
        Ticket ticket5 = new Ticket("msk", "spb", 50, 1, 3); //1

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket5, ticket1, ticket3};
        Assertions.assertArrayEquals(aviaSouls.search("msk", "spb"), expected);
    }

    @Test
    public void testSortCompareEmpty() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("msk", "spb", 100, 3, 12);
        Ticket ticket2 = new Ticket("spb", "msk", 200, 4, 6);
        Ticket ticket3 = new Ticket("msk", "spb", 700, 9, 15);
        Ticket ticket4 = new Ticket("msk", "kz", 300, 18, 23);
        Ticket ticket5 = new Ticket("msk", "spb", 50, 1, 3);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {};
        Assertions.assertArrayEquals(aviaSouls.search("kz", "spb"), expected);
    }

    @Test
    public void testComparable() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("msk", "spb", 100, 9, 15); //2
        Ticket ticket2 = new Ticket("spb", "msk", 200, 4, 6);
        Ticket ticket3 = new Ticket("msk", "spb", 700, 3, 12); //3
        Ticket ticket4 = new Ticket("msk", "kz", 300, 18, 23);
        Ticket ticket5 = new Ticket("msk", "spb", 50, 1, 3); //1

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5, ticket1, ticket3};
        Assertions.assertArrayEquals(aviaSouls.searchAndSortBy("msk", "spb", comparator), expected);

    }

    @Test
    public void testComparableEmpty() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("msk", "spb", 100, 9, 15); //2
        Ticket ticket2 = new Ticket("spb", "msk", 200, 4, 6);
        Ticket ticket3 = new Ticket("msk", "spb", 700, 3, 12); //3
        Ticket ticket4 = new Ticket("msk", "kz", 300, 18, 23);
        Ticket ticket5 = new Ticket("msk", "spb", 50, 1, 3); //1

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Assertions.assertArrayEquals(aviaSouls.searchAndSortBy("kz", "spb", comparator), expected);

    }
}
