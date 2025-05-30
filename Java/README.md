## ObscureLib - Java

```java
String leftPad(String body, char pad, int length)
```
- Returns `body` with the character `pad` repeatedly added to its left end until the result is `length` characters long.
- If `body` is already `length` long or longer, then `body` will be returned as-is without modification.
- This is only guaranteed to count properly for strings that do not contain any codepoints outside of the [Basic Multilingual Plane](https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/lang/Character.html#unicode).