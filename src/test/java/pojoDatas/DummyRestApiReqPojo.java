package pojoDatas;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyRestApiReqPojo {

    private String status;
    private DummyRestApiExPojo data;
    private String message;

   public DummyRestApiReqPojo() {
   }

   public DummyRestApiReqPojo(String status, DummyRestApiExPojo data, String message) {
       this.status = status;
       this.data = data;
       this.message = message;
   }

   public String getStatus() {
       return status;
   }

   public void setStatus(String status) {
       this.status = status;
   }

   public DummyRestApiExPojo getDummyRestApiPojo() {
       return data;
   }

   public void setDummyRestApiPojo(DummyRestApiExPojo dummyRestApiPojo) {
       this.data = dummyRestApiPojo;
   }

   public String getMessage() {
       return message;
   }

   public void setMessage(String message) {
       this.message = message;
   }

   @Override
   public String toString() {
       return "DummyResTApiReqPojo{" +
                "status='" + status + '\'' +
                ", dummyRestApiPojo=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}


