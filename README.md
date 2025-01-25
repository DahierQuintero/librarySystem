# Library system

System that allows users to perform basic book operations, 
such as adding new books, retrieving details about a specific book, 
updating book information and deleting books.

## Tools

- Spring Boot
- JPA
- MySQL

## Functionalities that the project supports

### 1.  Books
- Add a new book to the library.
- Retrieve the details of a specific book
- Update book details like title, author, etc.
- Remove a book from the library.
- View a list of all the books in the system.


## Steps to execute the project locally 

### how to clone and execute the project

- Copy the url o the repository

- Run this command ➡ ```git clone https://github.com/DahierQuintero/librarySystem.git```

- Set the environment variables for the database

![](https://i.stack.imgur.com/sbbjc.png)

- Create a database in MySQL with the same name as ```application.properties```
- Set your url to ```spring.datasource.url```
- Set your username to ```spring.datasource.username```
- Set your password to ```spring.datasource.password```

## Api endpoints

1. Create a Book
Endpoint: ```POST /api/books```

Request Body:
```json
{
   "title": "Book Title",
   "author": "Author Name",
   "published_date": "2022-01-01",
   "isbn": "1234567890"
}
```
   
Response:
```json
{
   "id": "unique-book-id",
   "title": "Book Title",
   "author": "Author Name",
   "published_date": "2022-01-01",
   "isbn": "1234567890",
   "status": "AVAILABLE"
}
```

2. Get a Book by ID
Endpoint: ```GET /api/books/{id}```.
Path Parameter: id (ID of the book).

Response:
```json
{
  "id": "book_id",
  "title": "Book Title",
  "author": "Author Name",
  "published_date": "2022-01-01",
  "isbn": "1234567890",
  "status": "AVAILABLE"
}
```

3. Update a Book
Endpoint: ```PUT /api/books/{id}```.
Path Parameter: id (ID of the book to be updated).

Request Body:
```json
{
  "title": "Updated Book Title",
  "author": "Updated Author Name",
  "published_date": "2022-02-01",
  "isbn": "9876543210",
  "status": "BORROWED"
}
```
Response:
```json
{
  "id": "book-id",
  "title": "Updated Book Title",
  "author": "Updated Author Name",
  "published_date": "2022-02-01",
  "isbn": "9876543210",
  "status": "BORROWED"
}
```

4. Delete a Book
Endpoint: ```DELETE /api/books/{id}```.
   Path Parameter: id (ID of the book to be deleted).

Response:
```json
{
  "message": "Book successfully deleted"
}
````
If the book does not exist, a 404 Not Found response will be returned.

5. List All Books
Endpoint: ```GET /api/books```

Response:
```json
[
  {
    "id": "book-id-1",
    "title": "Book Title 1",
    "author": "Author 1",
    "publishedDate": "2021-01-01",
    "isbn": "1234567890",
    "status": "AVAILABLE"
  },
  {
    "id": "book-id-2",
    "title": "Book Title 2",
    "author": "Author 2",
    "publishedDate": "2020-01-01",
    "isbn": "0987654321",
    "status": "BORROWED"
  }
]
```
