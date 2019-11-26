# OpenLR Decoder

  [![Build Status](https://travis-ci.org/aksakalli/openlr-decoder.svg)](https://travis-ci.org/aksakalli/openlr-decoder)
  [![Docker Pulls](https://img.shields.io/docker/pulls/aksakalli/openlr-decoder)](https://hub.docker.com/r/aksakalli/openlr-decoder)
  [![Docker Cloud Build Status](https://img.shields.io/docker/cloud/build/aksakalli/openlr-decoder)](https://hub.docker.com/r/aksakalli/openlr-decoder/builds)

A web API to decode base 64 string into OpenLR objects
using the [the standard implementation](https://github.com/tomtom-international/openlr).

## Usage

```bash
# run the decoder web API
$ docker run -d --name openlr-decoder -p 8080:8080 aksakalli/openlr-decoder
# decode base 64 text with get endpoint 
$ curl http://localhost:8080/?data=CwRbWyNG9RpsCQCb/jsbtAT/6/+jK1lE
```
That would return a decoded Reference point object.
(See the [white paper](https://www.openlr-association.com/fileadmin/user_upload/openlr-whitepaper_v1.5.pdf) for details)

```json
{
    "id": "decoder",
    "returnCode": null,
    "offsets": {},
    "locationReferencePoints": [
        {
            "bearing": 140.625,
            "distanceToNext": 557,
            "frc": "FRC_3",
            "fow": "MULTIPLE_CARRIAGEWAY",
            "sequenceNumber": 1,
            "lfrc": "FRC_3",
            "lastLRP": false,
            "longitudeDeg": 6.126819848985067,
            "latitudeDeg": 49.608517884971576
        },
        {
            "bearing": 230.625,
            "distanceToNext": 264,
            "frc": "FRC_3",
            "fow": "SINGLE_CARRIAGEWAY",
            "sequenceNumber": 2,
            "lfrc": "FRC_5",
            "lastLRP": false,
            "longitudeDeg": 6.128369849029585,
            "latitudeDeg": 49.603987884936856
        },
        {
            "bearing": 196.875,
            "distanceToNext": 0,
            "frc": "FRC_2",
            "fow": "SLIPROAD",
            "sequenceNumber": 3,
            "lfrc": "FRC_7",
            "lastLRP": true,
            "longitudeDeg": 6.128159849031252,
            "latitudeDeg": 49.58552788500302
        }
    ],
    "locationType": "LINE_LOCATION",
    "geoCoordinates": null,
    "sideOfRoad": null,
    "orientation": null,
    "cornerPoints": null,
    "lowerLeftPoint": null,
    "upperRightPoint": null,
    "centerPoint": null,
    "radius": -1,
    "numberOfColumns": -1,
    "numberOfRows": -1,
    "valid": true
}
```

## License

Released under [the Apache License](LICENSE).
