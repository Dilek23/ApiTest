package testData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyRestApiTestData {
/*
    Then
    Status Code un "200" olduğunu Assert et
            And
    Kullanıcı en son daki employee nin isminin "Doris Wilder" olduğunu dogrular
    And
    Kullanıcı 6. employee nin salary sinin 372000 olduğunu doğrular
    And
    Kullanıcı 21, 23 ve 59 yaşlarında employee olduğunu doğrular

 */
/*
           {
            "id": 1,
            "employee_name": "Tiger Nixon",
            "employee_salary": 320800,
            "employee_age": 61,
            "profile_image": ""
        },
 */

public List<Map<String,Object>> expectedDataList = new ArrayList<>();

public List<Map<String,Object>> setUpDummyRestTestData() {


    //1. Expected Data
    HashMap<String, Object> expectedDataStatus = new HashMap<>();
    expectedDataStatus.put("StatusCode", 200);

    // 2.Expected Data
    HashMap<String, Object> expectedDataName = new HashMap<>();
    expectedDataName.put("EmployeeName", "Doris Wilder");

    //3.Expected Data
    HashMap<String, Object> expectedDataSalary = new HashMap<>();
    expectedDataSalary.put("EmployeeSalary", 372000);

    //4.Expected Data
    List<Integer> expectedDataAges = new ArrayList<>();
    expectedDataAges.add(21);
    expectedDataAges.add(23);
    expectedDataAges.add(59);

    HashMap<String, Object> expectedDataMapAges = new HashMap<>();
    expectedDataMapAges.put("EmployeeAges", expectedDataAges);

    expectedDataList.add(expectedDataStatus);
    expectedDataList.add(expectedDataName);
    expectedDataList.add(expectedDataSalary);
    expectedDataList.add(expectedDataMapAges);

    return expectedDataList;


}
    /*
  {
 "status": "success",
 "data": {
     "name": "Drake F.",
     "salary": "40000",
     "age": "27",
     "id": 4545
 },
  */
    public List<Map<String,Object>> bodyExpectedData(String message, String status,String data,String name,String salary, String age, int id) {


        HashMap<String, Object> expectedDataName = new HashMap<>();
        expectedDataName.put("name", name);
        expectedDataName.put("salary", salary);
        expectedDataName.put("age", age);
        expectedDataName.put("id", id);
        HashMap<String, Object> bodyExpectedDataMap = new HashMap<>();
        bodyExpectedDataMap.put("status", status);
        bodyExpectedDataMap.put("message", message);
        bodyExpectedDataMap.put("data", expectedDataName);

        expectedDataList.add(bodyExpectedDataMap);


        return expectedDataList;
    }

        public HashMap<String,String> setExpectedDataForDelete(String status,String data,String message){

            HashMap<String,String> expectedData = new HashMap<>();
            expectedData.put("status",status);
            expectedData.put("data",data);
            expectedData.put("message",message);

            return expectedData;
        }
   }



