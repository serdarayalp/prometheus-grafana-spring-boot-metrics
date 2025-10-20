# ---- Build Stage ----

# Nutzt ein Maven-Image mit OpenJDK 21.
# "AS build" benennt diese Stage als build, damit sie in der nächsten Stage referenziert werden kann.
FROM maven:3.9.6-eclipse-temurin-21 AS build
# Setzt das Arbeitsverzeichnis im Container auf /build. Alle folgenden Befehle laufen in diesem Verzeichnis.
WORKDIR /build
# Kopiert die pom.xml ins Arbeitsverzeichnis. Die pom.xml enthält die Maven-Build-Definitionen und Abhängigkeiten.
COPY pom.xml .
# Kopiert den gesamten Quellcode ins Container-Verzeichnis /build/src.
COPY src ./src
# Führt Maven aus, um die Anwendung zu bauen (package).
#   -B = Batch-Modus (keine interaktiven Eingaben).
#   -DskipTests = Tests werden übersprungen, nur Build der Anwendung.
#   Ergebnis: Eine ausführbare JAR-Datei im Verzeichnis /build/target/.
RUN mvn -B -DskipTests package


# ---- Runtime Stage ----
# Nutzt ein schlankes Java 21 JRE-Image (kein Maven, kein JDK), nur die Laufzeitumgebung für Java.
# Vorteil: Das fertige Image ist viel kleiner, da Build-Tools nicht enthalten sind.
FROM eclipse-temurin:21-jre
# Arbeitsverzeichnis im Container ist /app.
WORKDIR /app

# Kopiert die fertige JAR-Datei aus der Build-Stage in das Runtime-Image.
# "--from=build" sagt Docker, dass es die Dateien aus der Stage namens build nehmen soll.
COPY --from=build /build/target/*.jar app.jar

# Informiert Docker, dass die Anwendung auf Port 8080 läuft.
# Das ist nur deklarativ. Ports müssen beim Start noch mit -p gemappt werden.
EXPOSE 8080
# Definiert den Startbefehl des Containers: die JAR-Datei wird mit Java gestartet.
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
