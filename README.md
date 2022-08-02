# Kotlin Spring Boot

- Course catalog service
- Rest API to manage course catalog for an online learning platform
- DB to store course information

# Running in different environments

Set up individual application.yml file for different environment
- `application.yml` - default
- `application-prod.yml` - prod
- `application-dev.yml` - dev

To run in different environments, modify run configuration and set `VM options` to `-Dspring.profiles.active=<environment>`
- no values set means it is in default mode
- `-Dspring.profiles.active=prod`
- `-Dspring.profiles.active=dev`