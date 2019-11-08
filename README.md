Для сборки и запуска данного проекта необходимо выполнить пункты, представленные ниже.

##Создание базы данных

Необходимо создать базу данных Mysql. Для этого нужно выполнить следующую команду в консоли mysql.
```
CREATE SCHEMA `horologium` DEFAULT CHARACTER SET utf8;
```

##Сборка клиентской части

Перейти в каталог модуля horologium-client.
```
$ cd horologium-client/
```
Выполнить загрузку зависимостей.
```
$ npm i
```
Необходимо также собрать проект.
```
$ npm run build
```
В файле package.json описаны скрипты для запуска сборки и тестов. Для запуска клиентской части выполнить команду:
```
$ npm start
```

##Сборка и запуск spring-boot приложения
В корне проекта отредактировать файл local-boot.properties, в котором находятся индивидуальные параметры запуска.
```
spring.datasource.username=*username*
spring.datasource.password=*pass*
spring.profiles.active=*profile*
```
* Пользователь базы данных.
* Если пользователь БД совпадает с пользователем системы, то пароль можно оставить пустым.
* Список включенных профилей.

Для запуска приложения выполнить следующую команду.
```
./gradlew bootRun
```