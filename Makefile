default: runProgram

Person.class: Person.java
	javac Person.java

MapADT.class: MapADT.java
	javac MapADT.java

RestaurantReservation.class: RestaurantReservation.java
	javac RestaurantReservation.java

RestaurantReservationApp.class: RestaurantReservationApp.java
	javac RestaurantReservationApp.java

runProgram: RestaurantReservationApp.class
	java RestaurantReservationApp

RestaurantReservationTest.class: RestaurantReservationTest.java RestaurantReservation.java
	javac -cp .:junit5.jar RestaurantReservationTest.java -Xlint

test: RestaurantReservationTest.class
	java -jar junit5.jar --class-path . --scan-classpath
clean:	
	rm *.class
