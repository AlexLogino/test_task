1️⃣ ЗАПУСК

Для локального запуска необходимы:
- Java 21
- Maven 3.9+
- Google Chrome (последняя версия)
- VPN (если из России)

 Команда для Windows (PowerShell / CMD), macOS, Linux
- mvn test
- по умолчанию - без браузера
- если нужен браузер добавить (-Dselenide.headless=false)

===================
===================

Для запуска в Docker наличие
- Docker
- Docker Compose v2

Команда (в run.sh)
- docker-compose up --build --abort-on-container-exit


или (Docker Compose v2):
- docker compose up --build --abort-on-container-exit

===================
===================

2️⃣ РЕЗУЛЬТАТЫ

В обоих случаях запуска результаты прогона в:
- target/allure-results

Каталог проброшен из контейнера на хост через volumes.

Генерация Allure отчёта (локально)
- mvn allure:serve

Если установлен Allure CLI:
- allure serve target/allure-results
