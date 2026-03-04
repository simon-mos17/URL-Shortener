# URL Shortener (Spring Boot)

A simple URL shortener built with **Spring Boot**.
The application allows users to create short links from long URLs and redirect to the original link.

---

## Features

* Create short links from long URLs
* Automatic Base62 encoding for short links
* Redirect from short link to original URL
* REST API for creating and resolving links
* Data stored in a relational database using **Spring Data JPA**

---

## Tech Stack

* **Java**
* **Spring Boot**
* **Spring Data JPA**
* **MySQL**
* **Maven**

---

## Project Structure

```
src/main/java/org/example/shortener
│
├── ShortLink.java            # Entity
├── ShortLinkRepository.java  # Database access
├── ShortLinkService.java     # Business logic
├── ShortLinkController.java  # REST API
├── ShortLinkRequest.java     # Request DTO
└── ShortenerApplication.java # Spring Boot entry point
```

---

## API Endpoints

### Create Short Link

```
POST /links/shorten
```

Request body:

```json
{
  "originalLink": "https://google.com"
}
```

Response:

```
abc123
```

---

### Redirect to Original Link

```
GET /links/{shortedLink}
```

Example:

```
GET /links/abc123
```

The server responds with a redirect to the original URL.

---

## How It Works

1. A URL is sent to the API.
2. The application stores the URL in the database.
3. The database ID is converted into a **Base62 encoded string**.
4. The encoded value becomes the short link.
5. When the short link is requested, the application looks up the original URL and redirects the user.

---

## Running the Application

Clone the repository:

```
git clone git@github.com:simon-mos17/URL-Shortener.git
```

Run the application:

```
./mvnw spring-boot:run
```

The server will start at:

```
http://localhost:8080
```

---

## Example Request

Create a short link:

```
POST http://localhost:8080/links/shorten
```

```json
{
  "originalLink": "https://example.com"
}
```

Open the short link:

```
http://localhost:8080/links/{shortedLink}
```

---
