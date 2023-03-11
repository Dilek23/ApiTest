package pojoDatas;

public class ZippoPotamPlaces {
    /*
            "place name": "Maltepe Mah.",
            "longitude": "32.3609",
            "state": "İstanbul",
            "state abbreviation": "34",
            "latitude": "40.1589"
        }
    ]
}
Java'da POJO, "Plain Old Java Object" kısaltmasıyla bilinen, temel bir Java sınıfıdır.
Expectedd data ve Actual dataları depolamak için kullanıyoruz
1)Fieldler Private
2)Parametresiz cons.
3)Parametreli cons
4)Getterstter
5)toString
     */
    private String placeName;
    private String longittude;
    private String state;
    private String stateabbreviation;
    private String latitude;

    public ZippoPotamPlaces(String placeName, String longittude, String state, String stateabbreviation, String latitude) {
        this.placeName = placeName;
        this.longittude = longittude;
        this.state = state;
        this.stateabbreviation = stateabbreviation;
        this.latitude = latitude;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getLongittude() {
        return longittude;
    }

    public void setLongittude(String longittude) {
        this.longittude = longittude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateabbreviation() {
        return stateabbreviation;
    }

    public void setStateabbreviation(String stateabbreviation) {
        this.stateabbreviation = stateabbreviation;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "{" +
                "placeName='" + placeName + '\'' +
                ", longittude='" + longittude + '\'' +
                ", state='" + state + '\'' +
                ", stateabbreviation='" + stateabbreviation + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
