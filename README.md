# M223 Multi-User-Applikationen objektorientiert realisieren
Dieses Projekt verwendet Quarkus "Java Framework". Die offizielle Website: https://quarkus.io/.

Das Projekt ist besteht aus einer einfachen REST-API, die es ermöglicht Buchung und und Benutzer, zu erstellen, zu lesen, zu aktualisieren und zu löschen: https://github.com/yannick2005/M223---Multi-User-Applikationen.

## Setup
1. Machen Sie eine Kopie(Fork) von diesem Projekt.
1. Stellen Sie sicher das der Postgres-Server auf „Port 5432“ läuft.
1. Öffnen Sie das Projekt in ihrem Editor.

## Startup
1. `./mvnw compile quarkus:dev` Projekt starten
2. Gehen Sie auf http://localhost:8080.
3. http://localhost:8080/q/swagger-ui/.

## Datenbank
Die Daten werden in einer PostgreSQL-Datenbank gespeichert. In der Entwicklungsumgebung wird diese in der docker-compose-yml konfiguriert.

Datenbankadministration
Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet zli@example.com und das Passwort zli*123. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:

## Datenbank Setup
- Host name/address:`db`
- Port: `5432`
- username: `postgres`
- password: `postgres`

# Test-Daten
Die Testdaten befinden sich in /src/main/resources/import.sql.

## Automatische Tests
Die automatischen Tests können mit ./mvnw quarkus:test ausgeführt werden. Für die automatischen Tests wird nicht die PostgreSQL-Datenbank verwendet, sondern eine H2-Datenbank, welche sich  während der Ausführung im Arbeitsspeicherbefindet.

## Mock Data
<table>
 <tr>
    <td><b style="font-size:15px">Admin</b></td>
    <td><b style="font-size:15px">Member</b></td>
 </tr>
 <tr>
    <td>

- `email` Michi.Michersen@bluewin.com
- `password` smallMichi123
    </td>
    <td>

- `email` manu44@gmail.com
- `password` Manuuu123
    </td>
 </tr>
</table>