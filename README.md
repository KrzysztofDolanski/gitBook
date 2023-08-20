REST api to retrieve data from github api.
========

Requirements:
-------------

- java 17
- maven
- MySQL

Schema name
-------
- gitbook

Schema name for tests
-----------
- gitbooktests

Endpoints
--------

- home endpoint: localhost:3306/gitbook

- Get user by login endpoint: /users/{login}
    - example response data:
  ``` Json
  {
  "id":12344,
  "login":"example",
  "name":"Example Name",
  "type":"User"
  "avatarUrl":"https://avatars.githubusercontent.com/u/109437?v=4"
  "createdAt":"2023-10-10T17:00:00Z"
  "calculations": 1
  }
  

