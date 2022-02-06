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
            switch (jr.peek()) {
                case BEGIN_OBJECT: {
                    jr.beginObject();
                    log.info("beginObject");
                    break;
                }
                case END_OBJECT: {
                    jr.endObject();
                    log.info("endObject");
                    break;
                }
                case BEGIN_ARRAY: {
                    jr.beginArray();
                    log.info("beginArray");
                    break;
                }
                case END_ARRAY: {
                    jr.endArray();
                    log.info("endArray");
                    break;
                }
                case NAME: {
                    String name = jr.nextName();
                    log.info("name '"+name+"'");
                    break;
                }
                case STRING:
                case BOOLEAN:
                case NUMBER:
                case NULL:
                    switch (jr.peek()) {
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
                            log.info("null");
                            break;
                    }
            }
        }
    }

    public static void main(String[] args) {
        String json ="{ \"fooooo\": \"bar\"}";
        JsonTool.parse(json);
    }

}
