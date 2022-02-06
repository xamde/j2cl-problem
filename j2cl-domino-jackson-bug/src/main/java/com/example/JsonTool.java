package com.example;

import org.dominokit.jackson.stream.JsonReader;
import org.dominokit.jackson.stream.JsonToken;
import org.dominokit.jackson.stream.impl.DefaultJsonReader;
import org.dominokit.jackson.stream.impl.StringReader;

import java.util.function.Consumer;
import java.util.logging.Logger;

public class JsonTool {

    private static final Logger log = Logger.getLogger(JsonTool.class.getName());

    public static void parse(String json) {
        StringReader sr = new StringReader(json);
        JsonReader jr = new DefaultJsonReader(sr);

        while (jr.peek() != JsonToken.END_DOCUMENT) {
            log.info("token "+jr.peek());
            switch (jr.peek()) {
                case BEGIN_OBJECT: {
                    jr.beginObject();
                    break;
                }
                case END_OBJECT: {
                    jr.endObject();
                    break;
                }
                case BEGIN_ARRAY: {
                    jr.beginArray();
                    break;
                }
                case END_ARRAY: {
                    jr.endArray();
                    break;
                }
                case NAME: {
                    String name = jr.nextName();
                    break;
                }
                case STRING:
                    log.info("string: "+jr.nextString());
                    break;
                case BOOLEAN:
                    log.info("bool: "+jr.nextBoolean());
                    break;
                case NUMBER:
                    log.info("number: "+jr.nextNumber().doubleValue());
                    break;
                case NULL:
                    jr.nextNull();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        String json ="{ \"fooooo\": \"bar\"}";
        JsonTool.parse(json);
    }

}
