# CSC340-Assignment3 
# Characters CRUD API
---

## Table of Contents

- [Installation & Setup](#installation--setup)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Demo Video](#demo-video)

---

The application will start at **http://localhost:8080**.

---

## API Endpoints

Base URL: `http://localhost:8080/api/characters`

---

### 1. Get All Characters

```http
GET /api/characters/
```

**Description**: Retrieve all characters in the database.

**Response**: `200 OK`

```json
[
  {
    "characterId": 1,
    "name": "Poppy",
    "description": "Just a yordle with a hammer.",
    "age": 999,
    "region": "Demacia",
    "role": "tank"
  }
]
```

---

### 2. Get Character by ID

```http
GET /api/characters/{id}
```

**Description**: Retrieve a single character by their ID.

**Path Parameters**: `id` (Long) — the ID of the character

**Response**: `200 OK` or `404 Not Found`

```json
{
  "characterId": 1,
  "name": "Poppy",
  "description": "Just a yordle with a hammer.",
  "age": 999,
  "region": "Demacia",
  "role": "tank"
}
```

---

### 3. Create a Character

```http
POST /api/characters/
```

**Description**: Add a new character to the database.

**Request Body**:
```json
{
  "name": "Poppy",
  "description": "Just a yordle with a hammer.",
  "age": 999,
  "region": "Demacia",
  "role": "tank"
}
```

**Response**: `200 OK` or `404 Not Found`

```json
{
  "characterId": 1,
  "name": "Poppy",
  "description": "Just a yordle with a hammer.",
  "age": 999,
  "region": "Demacia",
  "role": "tank"
}
```

---

### 4. Update a Character

```http
PUT /api/characters/{id}
```

**Description**: Update an existing character by their ID.

**Path Parameters**: `id` (Long) — the ID of the character to update

**Request Body**:
```json
{
  "name": "Poppy",
  "description": "The Keeper of the Hammer.",
  "age": 999,
  "region": "Demacia",
  "role": "tank"
}
```

**Response**: `200 OK` or `404 Not Found`

```json
{
  "characterId": 1,
  "name": "Poppy",
  "description": "The Keeper of the Hammer.",
  "age": 999,
  "region": "Demacia",
  "role": "tank"
}
```

---

### 5. Delete a Character

```http
DELETE /api/characters/{id}
```

**Description**: Delete a character by their ID.

**Path Parameters**: `id` (Long) — the ID of the character to delete

**Response**: `204 No Content` or `404 Not Found`

---

### 6. Get Characters by Region

```http
GET /api/characters/region?region={region}
```

**Description**: Retrieve all characters from a given region. If no region is provided, returns all characters sorted by region alphabetically.

**Query Parameters**: `region` (String, optional)

**Example**: `GET /api/characters/region?region=Demacia`

**Response**: `200 OK`

```json
[
  {
    "characterId": 1,
    "name": "Poppy",
    "description": "Just a yordle with a hammer.",
    "age": 999,
    "region": "Demacia",
    "role": "tank"
  }
]
```

---

### 7. Get Characters by Role

```http
GET /api/characters/role?role={role}
```

**Description**: Retrieve all characters with a given role. If no role is provided, returns all characters sorted by role alphabetically.

**Query Parameters**: `role` (String, optional)

**Example**: `GET /api/characters/role?role=tank`

**Response**: `200 OK`

```json
[
  {
    "characterId": 1,
    "name": "Poppy",
    "description": "Just a yordle with a hammer.",
    "age": 999,
    "region": "Demacia",
    "role": "tank"
  }
]
```

---

### 8. Search Characters by Name

```http
GET /api/characters/search?name={name}
```

**Description**: Retrieve all characters whose name contains the given string (case insensitive). If no name is provided, returns all characters.

**Query Parameters**: `name` (String, optional)

**Example**: `GET /api/characters/search?name=pop`

**Response**: `200 OK`

```json
[
  {
    "characterId": 1,
    "name": "Poppy",
    "description": "Just a yordle with a hammer.",
    "age": 999,
    "region": "Demacia",
    "role": "tank"
  }
]
```

---

## Demo Video

[Assignment03-recording.mov](https://uncg-my.sharepoint.com/:v:/g/personal/tplambert_uncg_edu/IQAA9GFxJ073RpiPmQ1VmtP5AUsDTjf-GoUDF1U8HX-3pC0?e=UDKcGG&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D)