package com.sahudyscos.web.service;

import fastily.jwiki.core.*;
import fastily.jwiki.dwrap.*;

import org.springframework.stereotype.Service;

@Service("wikiMediaService")
public class WikiMediaServiceImpl implements WikiMediaService{
    
    
    

    public void wikiconnection(){
        wikipt.login(LOGIN, PASSWORD);
        wikien.login(LOGIN, PASSWORD);
    }
    public String getDescription(String name){
        wikiconnection();
        if(wikipt.exists(name)){
            return wikipt.getTextExtract(name);
        }else if(wikien.exists(name)){
            return wikien.getTextExtract(name);
        }else{
            return null;
        }
    }
    public ImageInfo getImage(String name){
        return null;
    }


}