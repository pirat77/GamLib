# Games Library

The REST API created using Spring Boot.

## Stored resources:
  - games
  ```
  id                (Long)
  title             (String)
  released date     (Date)
  genre             (Genre)
  game logo         (String)
  rating            (float)
  description       (String)
  ```
  - studios
  ```
  id                (Long)
  name              (String)
  found date        (Date)
  country           (String)
  studio logo       (String)
  ```
  - platforms
  ```
  id                (Long)
  name              (String)
  cpu name          (String)
  cpu clock speed   (float)
  memory            (float)
  internal storage  (float)
  platform logo     (String)
  ```
## Additional types:
  - Genre - defines game category
  ```
  FPS
  RPG
  RTS
  TPP
  ARCADE
  RACER
  SPORT
  FIGHT
  ADVENTURE
  LOGIC
  ```
  - ReturnMessage - created to send a proper reply message
  ```
  timestamp         (Date)
  status            (int)
  error             (String)
  message           (String)
  path              (String)
  ```
  
## Endpoints:
  - paths:
  ```
  /game
  /studio
  /platform
  ```
  - methods:
    - GET
    - POST
    - PUT
    - DELETE
    
## Launching:
  - start-up:
  ```
  ./mvnw spring-boot:run
  ```
