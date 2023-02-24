package com.github.aistomin.webpush.demo;

import nl.martijndwars.webpush.Notification;
import nl.martijndwars.webpush.PushService;
import org.apache.http.HttpResponse;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Demo app.
 */
public class WebPushDemoApplication {

    /**
     * Entry point.
     *
     * @param args Pointless arguments :)
     * @throws Exception If something goes wrong.
     */
    public static void main(final String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        System.out.println("Run application .....");
        // Create you own subscription(s) using https://simple-push-demo.vercel.app/
        final List<Map<String, String>> subscriptions = Arrays.asList(
            new HashMap<String, String>() {{
                put("name", "My Chrome subscription");
                put("endpoint", "https://fcm.googleapis.com/fcm/send/fZCWtul6CYM:APA91bGbgQ-y7twdGcT-WXoMv3sNg254S5S4Ws6muj0hYnb-PqYDjLGUf7-zv3aSbleGbTXIJdulepDMfyt-HUzfiRhRjZPyP2ION07sXDrvcl-Ps_vi8U6lGuZiQ3Hywl7KlXrIAyMO");
                put("key", "BPDTfWKFdjt0olR0UVLn7N_NPZ6taIIDDUboWBDJwcmNal6E714-2aT5V-_dnn15kiToMkioSTZTE_jNOrWEPSI");
                put("auth", "Wm_F5UopYEwQdCgG8rRFBA");
            }}
        );
        // The service below is configured using constants from https://github.com/gauntface/simple-push-demo/blob/main/frontend/scripts/constants.js
        final PushService service = new PushService(
            "BDd3_hVL9fZi9Ybo2UUzA284WG5FZR30_95YeZJsiApwXKpNcF1rRPF3foIiBHXRdJI2Qhumhf6_LFTeZaNndIo",
            "xKZKYRNdFFn8iQIF2MH54KTfUHwH105zBdzMR7SI3xI",
            "mailto:mail@example.com"
        );
        for (final Map<String, String> subscription : subscriptions) {
            final String name = subscription.get("name");
            System.out.printf("Send notification to '%s' .....%n", name);
            final HttpResponse response = service.send(
                new Notification(
                    subscription.get("endpoint"),
                    subscription.get("key"),
                    subscription.get("auth"),
                    "Hey there!!! I'm notifying you!!!"
                )
            );
            System.out.printf("Notification is sent to '%s'. Response: %s.%n", name, response.getStatusLine().toString());
        }
        System.out.println("Done.");
    }
}
