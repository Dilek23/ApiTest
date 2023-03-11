package pojoDatas;

public class BookingDatespojo {
    /*
     "firstname" : "Drake",
    "lastname" : "F..",
    "totalprice" : 4000,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2022-01-01",
        "checkout" : "2023-01-01"
    },
    "additionalneeds" : "API and Appium"
}
     */
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private String additionalneeds;
    private HerOkuBookingDatesPut02Pojo bookingDates;

    public BookingDatespojo() {
    }

    public BookingDatespojo(String firstname, String lastname, int totalprice, boolean depositpaid,
                            String additionalneeds, HerOkuBookingDatesPut02Pojo bookingDates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.additionalneeds = additionalneeds;
        this.bookingDates = bookingDates;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public HerOkuBookingDatesPut02Pojo getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(HerOkuBookingDatesPut02Pojo bookingDates) {
        this.bookingDates = bookingDates;
    }

    @Override
    public String toString() {
        return  "{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", additionalneeds='" + additionalneeds + '\'' +
                ", bookingDates=" + bookingDates +
                '}';
    }
}
