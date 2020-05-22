package com.revature.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class JsonParseUtil {
    private static ObjectMapper om = new ObjectMapper();

    //taking in an input stream(req.getInputStream()),
    // the type (Cat.class)
    // and the resp(resp)
	public static Logger log = Logger.getLogger(JsonParseUtil.class);

    // and it will return our json objects
    public static <T> T parseJsonInput(InputStream stream, Class<T> type, HttpServletResponse resp)
            throws IOException {
        T t = null;
        try {
            t = om.readValue(stream, type);
        } catch (JsonProcessingException e) {
            log.info(e);
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST); //status code 400 (client error)
        }

        return t;
    }
}
