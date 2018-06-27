package com.sahudyscos.web.service;

import java.util.*;
import fastily.jwiki.core.*;
import fastily.jwiki.dwrap.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service("wikiMediaService")
public class WikiMediaServiceImpl implements WikiMediaService{
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    

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
    public String getImage(String name){
        int i = 0, j = -1;
        ArrayList<ImageInfo> images;
        ArrayList<String> im;
        if(wikien.exists(name)){
            im = wikien.getImagesOnPage(name);
            for(String a : im){
                if(a.contains(".svg")){
                    j = i;
                    //break;
                }
                i++;
            }
            if(j != -1){
                images = wikien.getImageInfo(im.get(i-1));
            
                if(!images.isEmpty()){
                    logger.info(((images.get(0)).url).toString());
                    return ((images.get(0)).url).toString();
                }
            } 
        } 
            return null;
        
    }


}