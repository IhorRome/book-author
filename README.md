# book-author
## How to launch
 - CLone this project to your IDE
 - Create MySQL database using MySql Workbrench (or terminal)
 - Change data about database url, MySQL username and password in application.properties file to yours
 - Also in application.properties file change spring.jpa.hibernate.ddl-auto value to 'create' if its your first launch of this project - then turn it back to 'validate'
 - Run project
 - Now using any tool which can send Http requests (for example Postman) you can do following things:</br>
 add, update, delete Author in DB
 add, update, delete Book in DB
 find all books by author name
 find most selling book by author name (or books if there are some of them with the greatest value of sold amount)
 find most published book by author name (or books if there are some of them with the greatest value of published amount)
 find list of most selling books by part of author name
 find list of most published books by part of author name
 find list of most successful books by part of author name
