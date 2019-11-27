package org.openlr.openlrdecoder;

import openlr.LocationReference;
import openlr.PhysicalFormatException;
import openlr.binary.ByteArray;
import openlr.binary.OpenLRBinaryDecoder;
import openlr.binary.impl.LocationReferenceBinaryImpl;
import openlr.rawLocRef.RawLocationReference;
import openlr.xml.OpenLRXMLEncoder;
import openlr.xml.generated.OpenLR;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenlrDecoderController {

    private final OpenLRBinaryDecoder binaryDecoder;
    private final OpenLRXMLEncoder xmlEncoder;

    public OpenlrDecoderController(OpenLRBinaryDecoder binaryDecoder, OpenLRXMLEncoder xmlEncoder) {
        this.binaryDecoder = binaryDecoder;
        this.xmlEncoder = xmlEncoder;
    }

    @RequestMapping("/")
    public OpenLR decode(@RequestParam String data) throws PhysicalFormatException {
        ByteArray byteArray = new ByteArray(data);
        LocationReference lr = new LocationReferenceBinaryImpl("", byteArray);
        RawLocationReference rawLocRef = this.binaryDecoder.decodeData(lr);
        LocationReference xmlLocationReference = this.xmlEncoder.encodeData(rawLocRef);
        OpenLR xmlData = (OpenLR) xmlLocationReference.getLocationReferenceData();
        return xmlData;
    }
}
