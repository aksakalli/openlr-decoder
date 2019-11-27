# OpenLR Decoder

  [![Build Status](https://travis-ci.org/aksakalli/openlr-decoder.svg)](https://travis-ci.org/aksakalli/openlr-decoder)
  [![Docker Pulls](https://img.shields.io/docker/pulls/aksakalli/openlr-decoder)](https://hub.docker.com/r/aksakalli/openlr-decoder)
  [![Docker Cloud Build Status](https://img.shields.io/docker/cloud/build/aksakalli/openlr-decoder)](https://hub.docker.com/r/aksakalli/openlr-decoder/builds)

A web API to decode base 64 string into OpenLR™ objects
using the [the standard implementation](https://github.com/tomtom-international/openlr).

> **OpenLR** is a royalty-free open standard for "procedures and formats for the encoding, transmission,
> and decoding of local data irrespective of the map" developed by [TomTom](https://www.tomtom.com/).
  
(See the [white paper](https://www.openlr-association.com/fileadmin/user_upload/openlr-whitepaper_v1.5.pdf) for details)

## How to run

You need to clone the project and run the spring boot app

```bash
git clone https://github.com/aksakalli/openlr-decoder.git && cd openlr-decoder
./mvnw spring-boot:run
```

Or run the docker image which is built automatically from this repo via Docker Cloud:

```bash
docker run -d --name openlr-decoder -p 8080:8080 aksakalli/openlr-decoder
```

## Usage

### JSON object

```bash
curl http://localhost:8080/?data=CwRbWyNG9RpsCQCb/jsbtAT/6/+jK1lE
```

Output:

```json
{
  "locationID": "",
  "binaryLocationReferences": null,
  "additionalInformation": null,
  "xmllocationReference": {
    "lineLocationReference": {
      "locationReferencePoint": [
        {
          "coordinates": {
            "longitude": 6.126819848985067,
            "latitude": 49.608517884971576
          },
          "lineAttributes": {
            "frc": "FRC_3",
            "fow": "MULTIPLE_CARRIAGEWAY",
            "bear": 141
          },
          "pathAttributes": {
            "lfrcnp": "FRC_3",
            "dnp": 557
          }
        },
        {
          "coordinates": {
            "longitude": 6.128369849029585,
            "latitude": 49.603987884936856
          },
          "lineAttributes": {
            "frc": "FRC_3",
            "fow": "SINGLE_CARRIAGEWAY",
            "bear": 231
          },
          "pathAttributes": {
            "lfrcnp": "FRC_5",
            "dnp": 264
          }
        }
      ],
      "lastLocationReferencePoint": {
        "coordinates": {
          "longitude": 6.128159849031252,
          "latitude": 49.58552788500302
        },
        "lineAttributes": {
          "frc": "FRC_2",
          "fow": "SLIPROAD",
          "bear": 197
        }
      },
      "offsets": {
        "posOff": 25,
        "negOff": 0
      }
    },
    "pointLocationReference": null,
    "areaLocationReference": null
  }
}
```

### OpenLR™ XML Representation

```bash
$ curl -H "Accept: application/xml" http://localhost:8080/?data=CwRbWyNG9RpsCQCb/jsbtAT/6/+jK1lE
```

Output:

```xml
<OpenLR>
  <locationID />
  <binaryLocationReferences />
  <additionalInformation />
  <xmllocationReference>
    <lineLocationReference>
      <locationReferencePoint>
        <locationReferencePoint>
          <coordinates>
            <longitude>6.126819848985067</longitude>
            <latitude>49.608517884971576</latitude>
          </coordinates>
          <lineAttributes>
            <frc>FRC_3</frc>
            <fow>MULTIPLE_CARRIAGEWAY</fow>
            <bear>141</bear>
          </lineAttributes>
          <pathAttributes>
            <lfrcnp>FRC_3</lfrcnp>
            <dnp>557</dnp>
          </pathAttributes>
        </locationReferencePoint>
        <locationReferencePoint>
          <coordinates>
            <longitude>6.128369849029585</longitude>
            <latitude>49.603987884936856</latitude>
          </coordinates>
          <lineAttributes>
            <frc>FRC_3</frc>
            <fow>SINGLE_CARRIAGEWAY</fow>
            <bear>231</bear>
          </lineAttributes>
          <pathAttributes>
            <lfrcnp>FRC_5</lfrcnp>
            <dnp>264</dnp>
          </pathAttributes>
        </locationReferencePoint>
      </locationReferencePoint>
      <lastLocationReferencePoint>
        <coordinates>
          <longitude>6.128159849031252</longitude>
          <latitude>49.58552788500302</latitude>
        </coordinates>
        <lineAttributes>
          <frc>FRC_2</frc>
          <fow>SLIPROAD</fow>
          <bear>197</bear>
        </lineAttributes>
      </lastLocationReferencePoint>
      <offsets>
        <posOff>25</posOff>
        <negOff>0</negOff>
      </offsets>
    </lineLocationReference>
    <pointLocationReference />
    <areaLocationReference />
  </xmllocationReference>
</OpenLR>
```

## License

Released under [the Apache License](LICENSE).
