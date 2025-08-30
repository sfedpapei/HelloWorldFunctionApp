package com.example;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import java.util.Optional;
import java.time.LocalDateTime;

/* dont forget to set AzureJobsWebStorage in azure function in app settings (env variables) for Deployment*/
public class Function {
    @FunctionName("hello")
    public void run(
            @TimerTrigger(name = "timerInfo", schedule = "0 */10 * * * *") String timerInfo,
            final ExecutionContext context) {
        context.getLogger().info("Timer function executed at: " + LocalDateTime.now());
    }
}
