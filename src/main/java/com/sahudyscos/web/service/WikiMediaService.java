package com.sahudyscos.web.service;

import fastily.jwiki.core.*;
import fastily.jwiki.dwrap.*;



public interface WikiMediaService{
    Wiki wikipt = new Wiki("pt.wikipedia.org");
    Wiki wikien = new Wiki("en.wikipedia.org");
    static final String LOGIN = "breno.oliveira1";
    static final String PASSWORD = "sahudyscos";

    public void wikiconnection();
    public String getDescription(String name);
    public String getImage(String name);


}