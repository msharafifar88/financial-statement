package ir.ac.core.utils;

import io.vertx.core.json.JsonObject;

import javax.enterprise.context.Dependent;

/**
 * Created by majid on 7/27/17.
 */

@Dependent
public class MessagesUtils {
    public String getJsonExceptionMessage(String message){
        JsonObject exceptionMessage = new JsonObject();
        exceptionMessage.put("key",message);
        exceptionMessage.put("value",Configuration.getProperty(message));
        return exceptionMessage.toString();
    }
}
