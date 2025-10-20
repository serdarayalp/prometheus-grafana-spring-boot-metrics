# Prometheus Java Demo (Spring Boot) — Docker Setup

Dieses Repository enthält ein Minimalbeispiel einer **Spring Boot** Java-Applikation, die Prometheus-kompatible Metriken über den Actuator bereitstellt. Zusätzlich sind **Prometheus** und **Grafana** im Docker Compose-Setup enthalten.

## Inhalte
- `app/` — Spring Boot Anwendung (Maven)
- `prometheus.yml` — Prometheus-Konfiguration
- `docker-compose.yml` — Compose-Setup für App, Prometheus, Grafana

## Schnellstart
1. Build & Start (im Projektverzeichnis):
   ```bash
   docker-compose up --build
   ```
2. App erreichbar: http://localhost:8080
   - Metriken: http://localhost:8080/actuator/prometheus
   - Beispiel-Endpoint: http://localhost:8080/hello
3. Prometheus UI: http://localhost:9090
4. Grafana UI: http://localhost:3000 (Default-Anmeldedaten: admin / admin)
   - Als Datasource in Grafana `Prometheus` hinzufügen: URL `http://prometheus:9090` (oder `http://localhost:9090` falls Grafana extern konfiguriert wird)

## Hinweise
- Dieses Projekt ist bewusst minimal gehalten — für Produktion brauchst du zusätzliche Sicherheit, Persistenz (Volumes), Monitoring-Policies und konfigurierbare Credentials.
