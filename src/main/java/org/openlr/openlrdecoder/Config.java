package org.openlr.openlrdecoder;

//import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import openlr.binary.OpenLRBinaryDecoder;
import openlr.xml.OpenLRXMLEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    OpenLRBinaryDecoder binaryDecoder() {
        return new OpenLRBinaryDecoder();
    }

    @Bean
    OpenLRXMLEncoder xmlEncoder() {
        return new OpenLRXMLEncoder();
    }

//    @Bean
//    XmlMapper xmlMapper(){
//        return new XmlMapper();
//    }
}
