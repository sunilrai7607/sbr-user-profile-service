#User Profile Service

##Description:
#### Sample User Profile Service

```commandline
./gradlew clean build
```
Below code to validate request
```java
public class XSSUtils {
    public static String stripXSS(String value) {
        if (value == null) {
            return null;
        }
        value = ESAPI.encoder()
                .canonicalize(value)
                .replaceAll("\0", "");
        return Jsoup.clean(value, Whitelist.none());
    }
}
```