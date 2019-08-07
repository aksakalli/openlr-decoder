package org.openlr.openlrdecoder;

import openlr.binary.ByteArray;
import openlr.LocationReference;
import openlr.binary.OpenLRBinaryDecoder;
import openlr.binary.impl.LocationReferenceBinaryImpl;
import openlr.rawLocRef.RawLocationReference;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class OpenlrDecoderController {
    @RequestMapping("/")
    public RawLocationReference decode(@RequestParam String data) throws Exception  {
        LocationReference lr = new LocationReferenceBinaryImpl("decoder", new ByteArray(data));
        OpenLRBinaryDecoder decoder = new OpenLRBinaryDecoder();
        RawLocationReference rawLocRef = decoder.decodeData(lr);
        return rawLocRef;
    }
}
