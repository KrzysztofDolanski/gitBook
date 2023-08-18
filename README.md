REST api to retrieve data from github api.
========

Requirements:
-------------

- java 17
- maven
- MySQL

Endpoints
--------

- home endpoint: localhost:3306/gitbook

- Get user by login endpoint: /users/{login}
    - example response data:
  ``` Json
  {
  "id":"123",
  "login":"example",
  "name":"Example Name",
  "type":"EXAMPLE_TYPE"
  "avatarUrl":"https://example.com/image12312"
  "createdAt":"2023-10-10 17:00:00"
  "calculations": 1
  }
  

