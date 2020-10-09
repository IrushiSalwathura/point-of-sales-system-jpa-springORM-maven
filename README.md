# POINT OF SALES SYSTEM (LAYERED ARCHITECTURE WITH JPA(HIBERNATE) AND SPRING ORM)

This POS System is revamped according the Layered Architecture in order to loose couple and  higher the cohesion between the controller and the model of the system. In this project Spring integrates with an ORM framework Hibernate implementation of Java Persistence API (JPA). Therefore, Spring gets to know about JPA and the two frameworks execute parallely. The main advantages of integrating both frameworks will be, less coding is required, Integrated Transaction Management and easy to test.

## Setup

> - Either fork or download the repository using the URL <https://github.com/IrushiSalwathura/point-of-sales-system-jpa-springORM-maven.git>
> - To fork use the command git clone https://github.com/IrushiSalwathura/point-of-sales-system-jpa-springORM-maven.git

## Technologies/Frameworks Used

The project is created with:
* Apache Maven
* Spring framework (Spring Core)
* Hibernate ORM (JPA provider)

## Dependencies

* JDBC
* JFoenix
* Jasper Reports
* Project Lombok
* Hibernate Core (Consists JPA)
* Spring Context (Consists Spring Core)
* Spring ORM

(All dependencies are added in the pom.xml file)

## Screenshots
- **Main Interface**
>![][1]
>---
>![][2]
- **Place Order Interface**
>![][3]

[1]: https://github.com/IrushiSalwathura/point-of-sales-system-jpa-springORM-maven/blob/master/src/main/resources/asset/screenshots/pos-main.png
[2]: https://github.com/IrushiSalwathura/point-of-sales-system-jpa-springORM-maven/blob/master/src/main/resources/asset/screenshots/pos-main-customer.png
[3]: https://github.com/IrushiSalwathura/point-of-sales-system-jpa-springORM-maven/blob/master/src/main/resources/asset/screenshots/pos-placeorder.png


## License
[MIT](https://github.com/IrushiSalwathura/point-of-sales-system-jpa-springORM-maven/blob/master/LICENSE.txt)




