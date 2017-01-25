package com.di.maven.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ws.rs.WebApplicationException;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class RESTDateParam implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd" );
    
    private java.sql.Date date;
 
    public RESTDateParam(String dateStr ) throws WebApplicationException {
        try {
            date = new java.sql.Date( df.parse( dateStr ).getTime() );
        } catch ( final ParseException ex ) {
            throw new WebApplicationException( ex );
        }
    }
 
    public java.sql.Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        if ( date != null ) {
            return date.toString();
        } else {
            return "";
        }
    }
}