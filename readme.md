# # Yandex.Praktikum 3rd Sprint's Project. "QA-Scooter"

A set of automated API tests for ["Scooter"](https://qa-scooter.praktikum-services.ru/).
Project's API design is stored in the document: ["Ez-scooter"](https://qa-scooter.praktikum-services.ru/docs/). 

Postman-collection, used while working on the project: [Sprint_3](https://www.getpostman.com/collections/90c27015076e8ed5d4ed).

## Project's Contents

Project consits of 4 main parts:
1. main/java/org.example.pojo - plain old java objects, used to generate request messages and parse response messages using serialization.
2. main/java/org.example.api - project API models. 2 main interfaces are created to work with "Courier" and "Order" pojo: **CourierApiClient** и **OrderApiClient**.
3. test/java/org.example.api.steps - methods with a @Step annotation, used to interact with API clients during test execution. 
4. test/java/org.example.api - test cases, separated by API's according to the initial study project's task.

### Test Scenarios

Only main study project tasks were completed.

**Main tasks**
* Creation of a courier instance: **CourierCreationTest**
  * it is possible to create a courier;
  * it's impossible to create two identical couriers;
  * you have to provide all mandatory values to create a courier.
* Courier login: **CourierLoginTest**
  * courier can log in;
  * you have to provide all mandatory values to log in;
  * log in attempt with wrong credentials provides an error;
* Order creation: **OrderCreationTest** - **parameterized** test suite.
  * it is possible to specify one of the colors — BLACK or GREY;
  * it is possible to specify both colors;
  * it is possible to not specify any color;
* List of orders: **OrderListRequestingTest**
  * it is possible to get the list of orders.

## Tests Execution

Local environment preparation instruction is shared below.

### Prerequisites

Prepare local environment according to the guide: ["Local development env"](https://practicum.yandex.ru/learn/qa-automation-engineer-java/courses/e2bf18c2-97c5-43f8-af20-80c52142e6f2/sprints/16356/topics/a1b6de5a-dd0d-418b-97ea-02258aa40b07/lessons/054c3a94-f4ee-46a4-8a5b-b5d373b9ada3/)
Download the project, store in local repository and execute, using IDE IntelliJ IDEA.

### Additional Information

Abstract class "BaseTest" contains WebDriver settings used for test execution.
Application contains a bug preventing positive order flow execution in Chrome browser. It is recommended to install [YandexDriver](https://github.com/yandex/YandexDriver) for tests execution.

## Author

* **Artem Kot**

## Acknowledgment

* Thanks to John Orokoukvu for a demonstration of architectural patterns used for API testing in the ["RestAssured"](https://disk.yandex.ru/d/OA86DvMnJqwYDw/GMT20220625-160149_Recording_1920x1080.mp4) webinar. 
