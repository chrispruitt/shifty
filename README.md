# shifty
Resident Duty Hours Code Challenge

To run this application use:
- maven
- tomcat7
- java 7

The USER API is fully functional using the paths below.( localhost:8080/api/user will list all users)
The UI can be accessed by the base application url. If you are running it on localhost:8080 then:
  - home - localhost:8080
  - schedule - localhost:8080/schedule

API ROOT
- /api

Implemented Methods
- User API CRUD operations (these methods are complete and functional)
  - /user GET - gets all users
  - /user/{userId} GET - get user by id
  - /user POST - creates a user (accepts user object in json form)
  - /user/{userId} PUT - updates a user (accepts user object in json form)
  - /user/{userId} DELETE - deletes a user
  
Non Implemented Methods
- Shift API
  - /user/{userId}/shift
  - etc... (this would follow the same pattern as the USER API above.
  
- DutyHourAnalysis API
  - /user/{userId}/analysis GET - URL Parameters {startDate} - generates an analysis for a user for a 4 week period.
