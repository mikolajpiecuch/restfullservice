package com.di.maven.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ws.rs.WebApplicationException;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class RESTTimeParam {
 
    private SimpleDateFormat df = new SimpleDateFormat( "mm:ss" );
    private java.sql.Time time;
 
    public RESTTimeParam(String timeStr ) throws WebApplicationException {
        try {
            time = new java.sql.Time( df.parse( timeStr ).getTime() );
        } catch ( final ParseException ex ) {
            throw new WebApplicationException( ex );
        }
    }
 
    public java.sql.Time getTime() {
        return time;
    }
 
    @Override
    public String toString() {
        if ( time != null ) {
            return time.toString();
        } else {
            return "";
        }
    }
}
