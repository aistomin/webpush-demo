# Web Push + Java. Demo.

1. Clone the repository.
2. Go to https://simple-push-demo.vercel.app/ and create a subscription (make sure that notification is working using the button on their site).
3. Open `com.github.aistomin.webpush.demo.WebPushDemoApplication` and replace the subscription data with your data. Push service must already be properly configured. 
4. Run `mvn compile exec:java -Dexec.mainClass="com.github.aistomin.webpush.demo.WebPushDemoApplication"` in the sources' root directory.
5. See the console output and check if you received the notification.

I suggest https://simple-push-demo.vercel.app/ as a nice testing tool, but you may, of course, use your server configuration to test your stuff.