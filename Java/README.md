# ObscureLib - Java - Documentation

## Constants

```java
BigInteger BIG_HUNDRED
```
- Equals 100.

```java
BigInteger BIG_THOUSAND
```
- Equals 1000.

```java
BigInteger BIG_TEN_THOUSAND
```
- Equals 10,000.

```java
BigInteger BIG_LONG_MAX
```
- Equals `Long.MAX_VALUE` converted to a `BigInteger`.

```java
BigInteger BIG_UPPER_EXCLUDE
```
- A number must be less than `BIG_UPPER_EXCLUDE` and greater than `BIG_UPPER_EXCLUDE.negate()` to be supported by the Number to English Translation methods.

## String Padding

```java
String leftPad(String body, char pad, int length)
```
- Returns `body` with the character `pad` repeatedly added to its left end until the result is `length` characters long.
- If `body` is already `length` long or longer, then `body` will be returned as-is without modification.
- This is only guaranteed to count properly for strings that do not contain any codepoints outside of the [Basic Multilingual Plane](https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/lang/Character.html#unicode).

```java
String rightPad(String body, char pad, int length)
```
- Returns `body` with the character `pad` repeatedly added to its right end until the result is `length` characters long.
- If `body` is already `length` long or longer, then `body` will be returned as-is without modification.
- This is only guaranteed to count properly for strings that do not contain any codepoints outside of the [Basic Multilingual Plane](https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/lang/Character.html#unicode).

## String Slicing

```java
String sliceAfter(String full, String match)
```
- Finds the first occurrence of `match` in `full`, and returns the segment of `full` starting immediately after that occurrence, and extending to the end of `full`.
- This will error if `match` is not found in `full`, so it is your responsibility to ensure that `match` is definitely found somewhere in `full` before you call this method.

```java
String sliceAfterKeep(String full, String match)
```
- Finds the first occurrence of `match` in `full`, and returns the segment of `full` starting at the beginning of that occurrence, and extending to the end of `full`.
- This will error if `match` is not found in `full`, so it is your responsibility to ensure that `match` is definitely found somewhere in `full` before you call this method.

```java
String sliceBefore(String full, String match)
```
- Finds the first occurrence of `match` in `full`, and returns the segment of `full` starting at the beginning of `full`, and ending immediately before that occurrence.
- This will error if `match` is not found in `full`, so it is your responsibility to ensure that `match` is definitely found somewhere in `full` before you call this method.

```java
String sliceBeforeKeep(String full, String match)
```
- Finds the first occurrence of `match` in `full`, and returns the segment of `full` starting at the beginning of `full`, and extending to the end of that occurrence.
- This will error if `match` is not found in `full`, so it is your responsibility to ensure that `match` is definitely found somewhere in `full` before you call this method.

## String Validation

```java
boolean matchesAlphabet(String message, String alphabet)
```
- Returns `true` if every codepoint in `message` appears somewhere in `alphabet`.
- This method *will* work properly with codepoints outside of the [Basic Multilingual Plane](https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/lang/Character.html#unicode).

## Number Formatting

```java
String longWithCommas(long number)
```
- Returns a decimal string representation of `number` with commas added every three digits, counting from the right.
- Will not add commas to any number that is less than 10,000 and greater than -10,000. This is in accordance with Obscure's personal taste in numeric formatting. We think that four-digit numbers look too small to visually "deserve" commas.

```java
String bigWithCommas(BigInteger number)
```
- Returns a decimal string representation of `number` with commas added every three digits, counting from the right.
- Will not add commas to any number that is less than 10,000 and greater than -10,000. This is in accordance with Obscure's personal taste in numeric formatting. We think that four-digit numbers look too small to visually "deserve" commas.

## Number to English Translation

```java
String longToEnglish(long number)
```
- Returns an English [cardinal](https://en.wikipedia.org/wiki/English_numerals#Cardinal_numbers) spelling of `number`.
- Accepts any possible `long` as input.

```java
String longToEnglishOrdinal(long number)
```
- Returns an English [ordinal](https://en.wikipedia.org/wiki/English_numerals#Ordinal_numbers) spelling of `number`.
- Accepts any possible `long` as input.

```java
String longToEnglishOrdinalNumeric(long number)
```
- Returns an English [ordinal](https://en.wikipedia.org/wiki/English_numerals#Ordinal_numbers) representation of `number` in abbreviated form, formed by a decimal string followed by a two-character suffix.
- Accepts any possible `long` as input.

```java
String longToEnglishOrdinalNumericCommas(long number)
```
- Returns an English [ordinal](https://en.wikipedia.org/wiki/English_numerals#Ordinal_numbers) representation of `number` in abbreviated form, formed by a decimal string *with commas inserted* followed by a two-character suffix.
- Accepts any possible `long` as input.

```java
String longToEnglishOrdinalSuffix(long number)
```
- Returns only the suffix that `longToEnglishOrdinalNumeric()` would have added to the end of its output.
- Accepts any possible `long` as input.

```java
String bigToEnglish(BigInteger number)
```
- Returns an English [cardinal](https://en.wikipedia.org/wiki/English_numerals#Cardinal_numbers) spelling of `number`.
- Accepts only `BigInteger` numbers that are less than `BIG_UPPER_EXCLUDE` and greater than `BIG_UPPER_EXCLUDE.negate()`.

```java
String bigToEnglishOrdinal(BigInteger number)
```
- Returns an English [ordinal](https://en.wikipedia.org/wiki/English_numerals#Ordinal_numbers) spelling of `number`.
- Accepts only `BigInteger` numbers that are less than `BIG_UPPER_EXCLUDE` and greater than `BIG_UPPER_EXCLUDE.negate()`.

```java
String bigToEnglishOrdinalNumeric(BigInteger number)
```
- Returns an English [ordinal](https://en.wikipedia.org/wiki/English_numerals#Ordinal_numbers) representation of `number` in abbreviated form, formed by a decimal string followed by a two-character suffix.
- Accepts any possible `BigInteger` as input.

```java
String bigToEnglishOrdinalNumericCommas(BigInteger number)
```
- Returns an English [ordinal](https://en.wikipedia.org/wiki/English_numerals#Ordinal_numbers) representation of `number` in abbreviated form, formed by a decimal string *with commas inserted* followed by a two-character suffix.
- Accepts any possible `BigInteger` as input.

```java
String bigToEnglishOrdinalSuffix(BigInteger number)
```
- Returns only the suffix that `bigToEnglishOrdinalNumeric()` would have added to the end of its output.
- Accepts any possible `BigInteger` as input.