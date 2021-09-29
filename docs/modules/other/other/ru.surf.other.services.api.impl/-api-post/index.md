//[other](../../../index.md)/[ru.surf.other.services.api.impl](../index.md)/[ApiPost](index.md)

# ApiPost

[androidJvm]\
interface [ApiPost](index.md)

The POST method is used to submit an entity to the specified resource, often causing a change in state or side effects on the server.

#### Author

Vitaliy Zarubin

## Functions

| Name | Summary |
|---|---|
| [signIn](sign-in.md) | [androidJvm]<br>@POST(value = "login")<br>abstract suspend fun [signIn](sign-in.md)(@Bodyrequest: [SignInRequest](../../ru.surf.other.data.requests/-sign-in-request/index.md)): Response&lt;[SignInResponse](../../ru.surf.other.data.responses/-sign-in-response/index.md)&gt; |
| [signInError](sign-in-error.md) | [androidJvm]<br>@POST(value = "login_error")<br>abstract suspend fun [signInError](sign-in-error.md)(@Bodyrequest: [SignInRequest](../../ru.surf.other.data.requests/-sign-in-request/index.md)): Response&lt;[SignInResponse](../../ru.surf.other.data.responses/-sign-in-response/index.md)&gt; |
| [signUp](sign-up.md) | [androidJvm]<br>@POST(value = "registration")<br>abstract suspend fun [signUp](sign-up.md)(@Bodyrequest: [SignUpRequest](../../ru.surf.other.data.requests/-sign-up-request/index.md)): Response&lt;[SignUpResponse](../../ru.surf.other.data.responses/-sign-up-response/index.md)&gt; |
| [signUpValidate](sign-up-validate.md) | [androidJvm]<br>@POST(value = "email_validate")<br>abstract suspend fun [signUpValidate](sign-up-validate.md)(@Bodyrequest: [SignUpValidateRequest](../../ru.surf.other.data.requests/-sign-up-validate-request/index.md)): Response&lt;[SignUpValidateResponse](../../ru.surf.other.data.responses/-sign-up-validate-response/index.md)&gt; |

## Inheritors

| Name |
|---|
| [OtherApi](../../ru.surf.other.services.api/-other-api/index.md) |
