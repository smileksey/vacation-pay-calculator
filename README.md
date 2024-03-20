# Тестовое задание "Калькулятор отпускных"
Микросервис на SpringBoot + Java 11 c одним API: **GET** `/calculate`

Приложение принимает среднюю зарплату работника за 12 месяцев и количество дней отпуска - отвечает суммой отпускных, которые придут сотруднику.

При запросе также можно указать точную дату начала отпуска, тогда сумма отпускных будет посчитана с учетом государственных праздников и выходных, выпадающих на период отпуска.


## Примеры запросов

1. Простой запрос для расчета отпускных по количеству дней отпуска и средней зарплате.

   **(GET)** http://localhost:8080/calculate?avgSalary=80000&days=14

    Ответ:

    ```json
    {
        "paymentValue": 38225.32
    }
    ```

    ![screen](https://github.com/smileksey/vacation-pay-calculator/blob/master/src/main/resources/postman1.jpg?raw=true)

3. Запрос для расчета отпускных с учетом государственных праздников, выпадающих на период отпуска. Дополнительно указывается дата начала отпуска в формате "dd-MM-yyyy".

   **(GET)** http://localhost:8080/calculate?avgSalary=80000&days=14&dateOfStart=01-03-2024

   Ответ:
   
    ```json
    {
        "paymentValue": 35494.94
    }
    ```
    
    ![screen](https://github.com/smileksey/vacation-pay-calculator/blob/master/src/main/resources/postman2.jpg?raw=true)

   ---

   ### Docker image:

   https://hub.docker.com/r/smileksey/payment-calculator
    
