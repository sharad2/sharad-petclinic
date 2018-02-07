Profile hsqldb runs on a local in memory database
Profile gcloudmysql runs on a preconfigured google cloud database
Deploy to google cloud via command line: mvnw -DskipTests=true -P gcloudmysql appengine:deploy

Google doc tutorial: https://cloud.google.com/community/tutorials/run-spring-petclinic-on-app-engine-cloudsql
Run the existing install in google cloud: https://spring-pet-clinic-sharad.appspot.com/vets

TODO: https://spring.io/guides/gs/authenticating-ldap/