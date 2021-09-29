//[app](../../../index.md)/[ru.surf.template.di](../index.md)/[ModuleData](index.md)/[provideDataServices](provide-data-services.md)

# provideDataServices

[androidJvm]\

@Provides

@ElementsIntoSet

fun [provideDataServices](provide-data-services.md)(core: [CoreDataService](../../../../modules/core/core/ru.surf.core.services.dataService/-core-data-service/index.md), users: [UsersDataService](../../../../modules/users/users/ru.surf.users.services.dataService/-users-data-service/index.md)): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[IAppDatabase](../../../../modules/core/core/ru.surf.core.interfaces/-i-app-database/index.md)&gt;

List of db to clean up after logout

#### Return

list services room db

#### Author

Vitaliy Zarubin

## Parameters

androidJvm

| | |
|---|---|
| core | service [CoreDataService](../../../../modules/core/core/ru.surf.core.services.dataService/-core-data-service/index.md) room db from module core |
| users | service [UsersDataService](../../../../modules/users/users/ru.surf.users.services.dataService/-users-data-service/index.md) room db from module users |
