package pojoDatas;

public class HerOkuRestPut02Pojo {
    /*
     "firstname" : "Drake",
    "lastname" : "F..",
    "totalprice" : 4000,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2022-01-01",
        "checkout" : "2023-01-01"
    },
      "additionalneeds": "Full Stack Test Automation Course with API and Appium"
     */
   private String firstname;
   private String lastname;
   private int totalprice;
   private boolean depositpaid;
   private String additionalneeds;
   private HerOkuBookingDatesPut02Pojo bookingdates;

    public HerOkuRestPut02Pojo() {
    }

    public HerOkuRestPut02Pojo(String firstname, String lastname, int totalprice, boolean depositpaid,String additionalneeds, HerOkuBookingDatesPut02Pojo bookingdates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.additionalneeds=additionalneeds;
        this.bookingdates = bookingdates;
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

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public HerOkuBookingDatesPut02Pojo getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(HerOkuBookingDatesPut02Pojo bookingdates) {
        this.bookingdates = bookingdates;
    }

    @Override
    public String toString() {
        return "{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid='" + depositpaid + '\'' +
                ", additionalneeds='" + additionalneeds + '\'' +
                ", bookingdates=" + bookingdates +
                '}';
    }
}

