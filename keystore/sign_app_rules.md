# Подпись приложения

Для сборки релизной версии приложения необходимо подписать apk-файл.

Для этого необходимо сделать следующее:

* создать keystore

* создать необходимые градл-таски

* загрузить keystore в jenkins

* настроить CI в проекте

## Создание keystore

Подпись приложения будет файлом в формате *.jks.
Название файла должно соответствовать паттерну: *название_проекта_release.jks*

Для создания подписи можно воспользоваться [официальной документацией][keystore].

Также следует создать файл `keystore_release.properties`, в который поместить
следующие данные:
```
storePassword=*ключ к храниилищу*
keyPassword=*пароль к подписи*
keyAlias=*алиас*
storeFile=../keystore/*название_проекта*_release.jks
```

**Важно:**

* Не изменяйте название файла `keystore_release.properties`!

* Эти файлы необходимо поместить в директорию `keystore`.

* **Запрещено их хранение в репозитории.**

Для того, чтобы члены команды могли локально собрать релизную версию, стоит
также расшарить на них данные файлы.

## Настройка проекта для работы с keystore

Находится в build.gradle.kts модуля app, описана в блоке signingConfigs

## Загрузка в Jenkins / Настройка CI в проекте

Два файла, полученные на предыдущем этапе, `*.jks` и `*.properties` следует
загрузить в Jenkins для поддержки сборки релизной версии приложения через
**CI**(ContinuousIntegration).

Для того, чтобы загрузить файлы в систему обратитесь к администратору.

Подробнее описано [здесь][release].

## Локальная сборка релизной версии

Для того, чтобы собрать релизную версию приложения локально, необходимо
поместить файл с подписью в папку `keystore`.

[keystore]: https://developer.android.com/studio/publish/app-signing
[release]: https://jirasurf.atlassian.net/wiki/spaces/ANDDEP/pages/413237258