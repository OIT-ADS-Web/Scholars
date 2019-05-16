FROM maven:3.3-jdk-8 AS build

COPY . /app/
#COPY pom.xml /app/
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true
WORKDIR /app

#
# Package stage
#

#FROM openjdk:8
#COPY --from=build /usr/src/vivo-template/VIVO/installer/webapp/target/vivo.war /usr/local/vivo
#COPY --from=build /app/target/middleware-0.2.0-SNAPSHOT.jar /usr/local/lib/middleware.jar
EXPOSE 9000
#ENTRYPOINT ["mvn","spring-boot:run"]

#3. From middleware directory 
# /middleware/src/main/resources/application.yml you will need 
# to configure the connection to your VIVO triplestore.

#4. From middleware directory run mvn spring-boot:run

# recommanded by TAMU
# mvn spring-boot:run