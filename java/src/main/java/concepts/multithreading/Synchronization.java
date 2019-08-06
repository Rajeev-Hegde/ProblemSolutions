package concepts.multithreading;

class TicketResource {

    private static TicketResource ticketResource = new TicketResource();
    private Integer availableTickets= 30;

    private TicketResource() {
    }

    public static TicketResource getInstance(){
        return ticketResource;
    }

    public synchronized void bookTicket(String user, Integer numOfTicketsToBook){

        if(numOfTicketsToBook<= availableTickets){
            System.out.println("Hi "+ user+ ": "+ numOfTicketsToBook+" tickets booked successfully!");
            availableTickets-= numOfTicketsToBook;
        }
        else{
            System.out.println("Hi "+ user+ ": Those many tickets are not available. Available tickets as of now: "
                    + availableTickets);
        }

    }


}

public class Synchronization {

    static class TicketBooking implements Runnable{
        private TicketResource ticketResource;
        private int ticketsToBook;
        private String userName;

        public TicketBooking(TicketResource ticketResource,int ticketsToBook,String userName) {
            this.ticketResource = ticketResource;
            this.ticketsToBook=ticketsToBook;
            this.userName= userName;
        }

        @Override
        public void run() {
            ticketResource.bookTicket(userName,ticketsToBook);
        }
    }


    public static void main(String[] args) {
        TicketResource ticketResource= TicketResource.getInstance();
        TicketBooking user1 = new TicketBooking(ticketResource,10,"User 1");
        TicketBooking user2 = new TicketBooking(ticketResource,10,"User 2");
        TicketBooking user3 = new TicketBooking(ticketResource,10,"User 3");

        TicketBooking user4 = new TicketBooking(ticketResource,1,"User 4");
        TicketBooking user5 = new TicketBooking(ticketResource,1,"User 5");
        TicketBooking user6 = new TicketBooking(ticketResource,1,"User 6");

        new Thread(user1).start();
        new Thread(user2).start();
        new Thread(user3).start();
        new Thread(user4).start();
        new Thread(user5).start();
        new Thread(user6).start();
    }



}
