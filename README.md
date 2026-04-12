# Press & Regret (Backend)

Ein browserbasiertes Reaktionsspiel, entwickelt von Sara und Emily im Rahmen eines Hochschulprojekts an der HWR Berlin.

---
## Über das Spiel
**Press & Regret** testet deine Reaktion, Konzentration und Geduld. Das Spiel ist inspiriert von klassischen "Don't press the button"-Spielen und fordert den Spieler heraus, genau auf die Anweisungen zu achten — denn manchmal ist die richtige Antwort das genaue Gegenteil von dem, was man erwartet.

Das Spiel besteht aus drei Schwierigkeitsstufen mit je 5 Leveln. Jedes Level hat einen Timer und einen großen Button mit einer Anweisung. Die Schwierigkeitsstufen bauen aufeinander auf — es empfiehlt sich, mit **Easy** zu beginnen.

---

## Voraussetzungen

- Java 17
- Gradle (oder den mitgelieferten Wrapper `./gradlew` verwenden)

## Installation & Start

```bash
# Repository klonen
git clone 
cd press-regret-backend

# Backend starten
./gradlew bootRun
```
Das Backend läuft auf: `http://localhost:8080`

Swagger UI (API-Dokumentation): `http://localhost:8080/swagger-ui/index.html`

Das Frontend befindet sich im Repo: `https://github.com/Sara20029/Press-Regret-PR-`


## Technologien

- Spring Boot 4 (Kotlin)
- Spring Web MVC (REST)
- Springdoc OpenAPI / Swagger UI
- Gradle