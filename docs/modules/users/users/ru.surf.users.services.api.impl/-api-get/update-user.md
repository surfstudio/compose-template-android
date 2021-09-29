//[users](../../../index.md)/[ru.surf.users.services.api.impl](../index.md)/[ApiGet](index.md)/[updateUser](update-user.md)

# updateUser

[androidJvm]\

@GET(value = "users/{id}")

abstract suspend fun [updateUser](update-user.md)(@Path(value = "id")id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): Response&lt;[UserResponse](../../ru.surf.users.data.responses/-user-response/index.md)&gt;

Update user model

## Parameters

androidJvm

| | |
|---|---|
| id | user identifier |
