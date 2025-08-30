package com.example;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

import java.time.ZoneId;
import java.util.Optional;
import java.time.LocalDateTime;
import java.util.TimeZone;

/* dont forget to set AzureJobsWebStorage in azure function in app settings (env variables) for Deployment*/
public class Function {
    @FunctionName("hello")
    public void run(
            @TimerTrigger(name = "timerInfo", schedule = "0 */1 * * * *") String timerInfo,
            final ExecutionContext context) {
        context.getLogger().info("Timer function executed at: " + LocalDateTime.now());
        ZoneId zoneId = ZoneId.of("UTC");
        TimeZone zone = TimeZone.getTimeZone(zoneId);
        TimeZone.setDefault(zone);
        context.getLogger().info("Timer function executed at: " + LocalDateTime.now());
    }
}
