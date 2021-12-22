package com.kon.service;

import com.redislabs.modules.rejson.JReJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * note
 *
 * @author kon, created on 2021/12/21T13:53.
 * @version 1.0.0-SNAPSHOT
 */
@Component
public class JreJsonRedis {

    @Autowired
    private JReJSON jReJson;


}
