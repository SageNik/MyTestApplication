# MyTestApplication

Here is a test assignment we talked about.

Prerequisites
- IDE: Android Studio https://developer.android.com/studio
- Programming language: Kotlin
- version control: Git
- database: https://realm.io

Specification
- Android 5.0+
- Use TabLayout with 2 tabs "My Posts" and "Internet Posts"
- create "Post" model in Realm with 2 fields: "title" (string) and "body" (string)
- on the first tab:
    - user should see a list of "My Posts": show full "title" and 2 lines of "body"
    - user should be able to create, edit or delete "My Posts"
    - "My Posts" should be stored in Realm
- on the second tab:
    - download and parse JSON, save it to Realm "Internet Posts": https://jsonplaceholder.typicode.com/posts
    - display downloaded "Internet Posts" in a list the same way as on the first tab
    - "Internet Posts" should be stored in Realm as well
