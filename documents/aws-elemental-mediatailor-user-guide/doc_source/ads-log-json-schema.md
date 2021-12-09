# ADS Log JSON Schema<a name="ads-log-json-schema"></a>

The following lists the JSON schema for the AWS Elemental MediaTailor ADS log\.

```
{
  "$schema": "http://json-schema.org/draft-07/schema#",
  "$id": "http://amazon.com/elemental/midas/mms/adsLogSchema.json",
  "type": "object",
  "title": "AWS Elemental MediaTailor ADS Log JSON Schema",
  "required": [
    "eventType",
    "eventTimestamp",
    "requestId",
    "sessionType",
    "eventDescription",
    "awsAccountId",
    "customerId",
    "originId",
    "sessionId"
  ],
  "additionalProperties": false,
  "properties": {
    "eventType": {
      "$id": "#/properties/eventType",
      "type": "string",
      "description": "The code for the event that triggered this log message. Example: <code>VAST_RESPONSE</code>.",
      "examples": [
        "FILLED_AVAIL"
      ]
    },
    "eventTimestamp": {
      "$id": "#/properties/eventTimestamp",
      "type": "string",
      "description": "The date and time of the event.",
      "examples": [
        "1970-01-01T00:00:00Z"
      ],
      "format": "date-time"
    },
    "requestId": {
      "$id": "#/properties/requestId",
      "type": "string",
      "description": "The MediaTailor request ID, which you can use to correlate multiple log entries for the same request.",
      "examples": [
        "c7c7ae8c-a61e-44e0-8efd-7723995337a1"
      ],
      "pattern": "^(.*)$"
    },
    "sessionType": {
      "$id": "#/properties/sessionType",
      "type": "string",
      "enum": [
        "HLS",
        "DASH"
      ],
      "description": "The player's stream type."
    },
    "eventDescription": {
      "$id": "#/properties/eventDescription",
      "type": "string",
      "description": "A short description of the event that triggered this log message, provided by the MediaTailor service. By default, this is empty. Example: <code>Got VAST response</code>.",
      "default": "",
      "examples": [
        "Got VAST response"
      ],
      "pattern": "^(.*)$"
    },
    "awsAccountId": {
      "$id": "#/properties/awsAccountId",
      "type": "string",
      "description": "The AWS account ID for the MediaTailor configuration that was used for the session."
    },
    "customerId": {
      "$id": "#/properties/customerId",
      "type": "string",
      "description": "The hashed version of the AWS account ID, which you can use to correlate multiple log entries.",
      "pattern": "^(.*)$"
    },
    "originId": {
      "$id": "#/properties/originId",
      "type": "string",
      "description": "The configuration name from the MediaTailor configuration. This is different from the video content source, which is also part of the configuration.",
      "examples": [
        "external-canary-dash-serverside-reporting-onebox"
      ],
      "pattern": "^(.*)$"
    },
    "sessionId": {
      "$id": "#/properties/sessionId",
      "type": "string",
      "description": "The unique numeric identifier that MediaTailor assigned to the player session. All requests that a player makes for a session have the same session ID. Example: <code>e039fd39-09f0-46b2-aca9-9871cc116cde</code>.",
      "examples": [
        "120b9873-c007-40c8-b3db-0f1bd194970b"
      ],
      "pattern": "^(.*)$"
    },
    "avail": {
      "$id": "#/properties/avail",
      "type": "object",
      "title": "avail",
      "description": "Information about an avail that MediaTailor fills with ads. Currently, for the <code>FILLED_AVAIL</code> event type, this is the plan created by MediaTailor when it first encounters the avail. How the avail is eventually filled may vary from this plan, depending on how the content plays out.  ",
      "required": [
        "creativeAds",
        "originAvailDuration",
        "filledDuration",
        "fillRate",
        "numAds",
        "slateAd",
        "availId"
      ],
      "additionalProperties":  false,
      "properties": {
        "originAvailDuration": {
          "$id": "#/properties/avail/originAvailDuration",
          "type": "number",
          "description": "The duration of the avail as specified in the content stream from the origin (<code>CUE_OUT</code> or <code>SCTE</code>)."
        },
        "filledDuration": {
          "$id": "#/properties/avail/filledDuration",
          "type": "number",
          "description": "The sum of the durations of all the ads inserted into the avail."
        },
        "fillRate": {
          "$id": "#/properties/avail/fillRate",
          "type": "number",
          "description": "The rate at which the ads fill the avail duration, from 0.0 (for 0%) to 1.0 (for 100%)."
        },
        "creativeAds": {
          "$id": "#/properties/avail/creativeAds",
          "type": "array",
          "description": "The ads that MediaTailor inserted into the avail.",
          "items": {
            "type": "object",
            "title": "creativeAd",
            "description": "Information about a single inserted ad.",
            "required": [
              "uri",
              "creativeUniqueId",
              "adContent",
              "trackingEvents",
              "vastDuration",
              "transcodedAdDuration"
            ],
            "additionalProperties": false,
            "properties": {
              "uri": { "$ref": "#/definitions/adMezzanineUri" },
              "creativeUniqueId": { "$ref": "#/definitions/creativeUniqueId" },
              "adContent": { "$ref": "#/definitions/adContent" },
              "trackingEvents": { "$ref": "#/definitions/trackingEvents" },
              "vastDuration": { "$ref": "#/definitions/vastDuration" },
              "transcodedAdDuration": { "$ref": "#/definitions/transcodedAdDuration" }
            }
          }
        },
        "numAds": {
          "$id": "#/properties/avail/numAds",
          "type": "number",
          "description": "The number of ads that MediaTailor inserted into the avail."
        },
        "slateAd": {
          "$id": "#/properties/avail/slateAd",
          "type": ["object", "null"],
          "title": "slateAd",
          "description": "Information about the slate ad, which MediaTailor uses to fill any unfilled segments in the avail.",
          "additionalProperties": false,
          "required": [
            "uri",
            "creativeUniqueId",
            "adContent",
            "transcodedAdDuration"
          ],
          "properties": {
            "uri": { "$ref": "#/definitions/adMezzanineUri" },
            "creativeUniqueId": { "$ref": "#/definitions/creativeUniqueId" },
            "adContent": { "$ref": "#/definitions/adContent" },
            "transcodedAdDuration": { "$ref": "#/definitions/transcodedAdDuration" }
          }
        },
        "availId": {
          "$id": "#/properties/avail/availId",
          "type": "string",
          "description": "The unique identifier for this avail. For HLS, this is the media sequence number where the avail begins. For DASH, this is the period ID."
        },
        "skippedAds": {
          "$id": "#/properties/avail/skippedAds",
          "type": "array",
          "description": "The ads that MediaTailor didn't insert, for reasons like <code>TRANSCODE_IN_PROGRESS</code> and <code>TRANSCODE_ERROR</code>.",
          "items": {
            "type": "object",
            "title": "skippedAd",
            "description": "Information about a single skipped ad.",
            "required": [
              "creativeUniqueId",
              "adMezzanineUrl",
              "skippedReason",
              "vastDuration"
            ],
            "additionalProperties": false,
            "properties": {
              "creativeUniqueId": { "$ref": "#/definitions/creativeUniqueId" },
              "adMezzanineUrl": {
                "type": "string",
                "description": "The mezzanine URL of the skipped ad."
              },
              "skippedReason": {
                "type": "string",
                "description": "The code that indicates why the ad wasn't inserted. Example: <code>TRANSCODE_IN_PROGRESS</code>."
              },
              "vastDuration": { "$ref": "#/definitions/vastDuration" },
              "transcodedAdDuration": { "$ref": "#/definitions/transcodedAdDuration" }
            }
          }
        }
      }
    },

    "vastResponse": {
      "$id": "#/properties/vastResponse",
      "type": "object",
      "title": "vastResponse",
      "description": "Information about the VAST response that MediaTailor received from the ADS.",
      "required": [
        "version",
        "vastAds",
        "errors"
      ],
      "additionalProperties":  false,
      "properties": {
        "version": {
          "$id": "#/properties/vastResponse/version",
          "type": "string",
          "description": "The VAST specification version, parsed from the <code>version</code> attribute of the <code>VAST</code> tag in the response.",
          "examples": [
            "3.0"
          ],
          "pattern": "^(.*)$"
        },
        "vastAds": {
          "$id": "#/properties/vastResponse/vastAds",
          "type": "array",
          "description": "The ads parsed from the VAST response.",
          "items": {
            "$ref": "#/definitions/vastAd"
          }
        },
        "errors": {
          "$id": "#/properties/vastResponse/errors",
          "type": "array",
          "description": "The error URLs parsed from the <code>Error</code> tags in the VAST response.",
          "items": {
            "type": "string",
            "description": "A single error URL."
          }
        }
      }
    },

    "vastAd": {
      "$ref": "#/definitions/vastAd"
    },

    "vodVastResponseTimeOffset": {
      "$id": "#/properties/vodVastResponseTimeOffset",
      "type": "number",
      "description": "The VMAP specific time offset for VOD ad insertion.",
      "examples": [
        5.0
      ]
    },

    "vodCreativeOffsets": {
      "$id": "#/properties/vodCreativeOffsets",
      "type": "object",
      "title": "vodCreativeOffsets",
      "description": "A map that indicates the time offsets in the manifest where MediaTailor will insert avails, based on the VMAP response.",
      "additionalProperties": {
        "type": "array",
        "$id": "#/properties/vodCreativeOffsets/entry",
        "description": "A mapping from a time offset in the manifest to a list of ads to insert at this time.",
        "items": {
          "type": "object",
          "$id": "#/properties/vodCreativeOffsets/entry/items",
          "title": "vodCreativeOffset",
          "description": "The list of ads to insert at the specified time offset.",
          "additionalProperties": false,
          "required": [
            "uri",
            "creativeUniqueId",
            "vastDuration",
            "transcodedAdDuration",
            "adContent",
            "trackingEvents"
          ],
          "properties": {
            "uri": { "$ref": "#/definitions/adMezzanineUri" },
            "creativeUniqueId": { "$ref": "#/definitions/creativeUniqueId" },
            "vastDuration": { "$ref": "#/definitions/vastDuration" },
            "transcodedAdDuration": { "$ref": "#/definitions/transcodedAdDuration" },
            "adContent": { "$ref": "#/definitions/adContent" },
            "trackingEvents": { "$ref": "#/definitions/trackingEvents" }
          }
        }
      }
    },

    "adsRequestUrl": {
      "$id": "#/properties/adsRequestUrl",
      "type": "string",
      "description": "The full URL of the ADS request made by MediaTailor."
    },

    "requestHeaders": {
      "$id": "#/properties/requestHeaders",
      "type": "array",
      "description": "The headers that MediaTailor included with the ADS request. Typically, the logs include these when a request to the ADS fails, to help with troubleshooting.",
      "items": {
        "type": "object",
        "title": "requestheaders",
        "description": "The name and value for a single header included in the ADS request.",
        "required": [
          "name",
          "value"
        ],
        "additionalProperties": false,
        "properties": {
          "name": {
            "type": "string",
            "description": "The name of the header."
          },
          "value": {
            "type": "string",
            "description": "The value of the header."
          }
        }
      }
    }
  },

  "oneOf": [
    { "$ref": "#/definitions/eventMakingAdsRequest" },
    { "$ref": "#/definitions/eventVastResponse" },
    { "$ref": "#/definitions/eventFilledAvail" },
    { "$ref": "#/definitions/eventErrorFiringBeaconFailed" },
    { "$ref": "#/definitions/eventWarningNoAdvertisements" },
    { "$ref": "#/definitions/eventUnknownHost" },
    { "$ref": "#/definitions/eventErrorAdsTimeout" },
    { "$ref": "#/definitions/eventPlannedAvail" },
    { "$ref": "#/definitions/eventEmptyVastResponse" },
    { "$ref": "#/definitions/eventErrorUnknown" },
    { "$ref": "#/definitions/eventVastRedirect" },
    { "$ref": "#/definitions/eventRedirectedVastResponse" },
    { "$ref": "#/definitions/eventErrorAdsResponseParse" },
    { "$ref": "#/definitions/eventErrorAdsInvalidResponse" },
    { "$ref": "#/definitions/eventErrorDisallowedHost"},
    { "$ref": "#/definitions/eventWarningDynamicVariableSubFailed"},
    { "$ref": "#/definitions/eventVodTimeBasedAvailPlanVastResponseForOffset" },
    { "$ref": "#/definitions/eventVodTimeBasedAvailPlanSuccess" }
  ],


  "definitions": {
    "eventMakingAdsRequest": {
      "$id": "#/definitions/eventMakingAdsRequest",
      "required": [
        "eventType",
        "adsRequestUrl"
      ],
      "properties": {
        "eventType": {
          "type": "string",
          "const": "MAKING_ADS_REQUEST"
        }
      }
    },

    "eventVastResponse": {
      "$id": "#/definitions/eventVastResponse",
      "required": [
        "eventType"
      ],
      "properties": {
        "eventType": {
          "type": "string",
          "const": "VAST_RESPONSE"
        }
      }
    },

    "eventFilledAvail": {
      "$id": "#/definitions/eventFilledAvail",
      "required": [
        "eventType",
        "avail"
      ],
      "properties": {
        "eventType": {
          "type": "string",
          "const": "FILLED_AVAIL"
        }
      }
    },

    "eventErrorFiringBeaconFailed": {
      "$id": "#/definitions/eventErrorFiringBeaconFailed",
      "required": [
        "eventType",
        "error",
        "beaconInfo"
      ],
      "properties": {
        "eventType": {
          "type": "string",
          "const": "ERROR_FIRING_BEACON_FAILED"
        }
      }
    },

    "eventWarningNoAdvertisements": {
      "$id": "#/definitions/eventWarningNoAdvertisements",
      "required": [
        "eventType"
      ],
      "properties": {
        "eventType": {
          "type": "string",
          "const": "WARNING_NO_ADVERTISEMENTS"
        }
      }
    },

    "eventUnknownHost": {
      "$id": "#/definitions/eventUnknownHost",
      "required": [
        "eventType",
        "requestHeaders"
      ],
      "properties": {
        "eventType": {
          "type": "string",
          "const": "ERROR_UNKNOWN_HOST"
        }
      }
    },

    "eventErrorAdsTimeout": {
      "$id": "#/definitions/eventErrorAdsTimeout",
      "required": [
        "eventType",
        "adsRequestUrl",
        "requestHeaders"
      ],
      "properties": {
        "eventType": {
          "type": "string",
          "const": "ERROR_ADS_TIMEOUT"
        }
      }
    },

    "eventPlannedAvail": {
      "$id": "#/definitions/eventPlannedAvail",
      "required": [
        "eventType"
      ],
      "properties": {
        "eventType": {
          "type": "string",
          "const": "PLANNED_AVAIL"
        }
      }
    },

    "eventEmptyVastResponse": {
      "$id": "#/definitions/eventEmptyVastResponse",
      "required": [
        "eventType"
      ],
      "properties": {
        "eventType": {
          "type": "string",
          "const": "EMPTY_VAST_RESPONSE"
        }
      }
    },

    "eventErrorUnknown": {
      "$id": "#/definitions/eventErrorUnknown",
      "required": [
        "eventType"
      ],
      "properties": {
        "eventType": {
          "type": "string",
          "const": "ERROR_UNKNOWN"
        }
      }
    },

    "eventVastRedirect": {
      "$id": "#/definitions/eventVastRedirect",
      "required": [
        "eventType"
      ],
      "properties": {
        "eventType": {
          "type": "string",
          "const": "VAST_REDIRECT"
        }
      }
    },

    "eventRedirectedVastResponse": {
      "$id": "#/definitions/eventRedirectedVastResponse",
      "required": [
        "eventType"
      ],
      "properties": {
        "eventType": {
          "type": "string",
          "const": "REDIRECTED_VAST_RESPONSE"
        }
      },
      "_comment": "NOTE that the property vastResponse is not required because empty vast responses do not contain a vastResponse."
    },

    "eventErrorAdsResponseParse": {
      "$id": "#/definitions/eventErrorAdsResponseParse",
      "required": [
        "eventType"
      ],
      "properties": {
        "eventType": {
          "type": "string",
          "const": "ERROR_ADS_RESPONSE_PARSE"
        }
      }
    },

    "eventErrorAdsInvalidResponse": {
      "$id": "#/definitions/eventErrorAdsInvalidResponse",
      "required": [
        "eventType",
        "additionalInfo"
      ],
      "properties": {
        "eventType": {
          "type": "string",
          "const": "ERROR_ADS_INVALID_RESPONSE"
        }
      }
    },

    "eventErrorDisallowedHost": {
      "$id": "#/definitions/eventErrorDisallowedHost",
      "required": [
        "eventType"
      ],
      "properties": {
        "eventType": {
          "type": "string",
          "const": "ERROR_DISALLOWED_HOST"
        }
      }
    },

    "eventWarningDynamicVariableSubFailed": {
      "$id": "#/definitions/eventWarningDynamicVariableSubFailed",
      "required": [
        "eventType",
        "adsRequestUrl"
      ],
      "properties": {
        "eventType": {
          "type": "string",
          "const": "WARNING_URL_VARIABLE_SUBSTITUTION_FAILED"
        }
      }
    },

    "eventVodTimeBasedAvailPlanVastResponseForOffset": {
      "$id": "#/definitions/eventVodTimeBasedAvailPlanVastResponseForOffset",
      "required": [
        "eventType",
        "vastResponse"
      ],
      "properties": {
        "eventType": {
          "type": "string",
          "const": "VOD_TIME_BASED_AVAIL_PLAN_VAST_RESPONSE_FOR_OFFSET"
        }
      }
    },

    "eventVodTimeBasedAvailPlanSuccess": {
      "$id": "#/definitions/eventVodTimeBasedAvailPlanSuccess",
      "required": [
        "eventType",
        "vodCreativeOffsets"
      ],
      "properties": {
        "eventType": {
          "type": "string",
          "const": "VOD_TIME_BASED_AVAIL_PLAN_SUCCESS"
        }
      }
    },

    "creativeUniqueId": {
      "type": "string",
      "description": "The unique identifier for the ad, used as a key for transcoding. This is the ID field for the creative in the VAST response, if available. Otherwise, it's the mezzanine URL of the ad. "
    },

    "vastDuration": {
      "type": "number",
      "description": "The duration of the ad, as parsed from the VAST response."
    },

    "transcodedAdDuration": {
      "type": "number",
      "description": "The duration of the ad, calculated from the transcoded asset."
    },

    "adContent": {
      "$id": "#/properties/adContent",
      "type": ["object", "null"],
      "title": "adContent",
      "description": "Information about the content of the inserted ad.",
      "additionalProperties": false,
      "properties": {
        "adPlaylistUris": {
          "$id": "#/properties/adContent/adPlaylistUris",
          "type": "object",
          "title": "adPlaylistUris",
          "description": "The mapping from the origin manifest for a variant to the ad manifest for the variant. For DASH, this contains a single entry, because all variants are represented in a single DASH manifest. ",
          "additionalProperties": {
            "$id": "#/properties/adContent/adPlaylistUris/adPlaylistUri",
            "type": "string",
            "description": "The URL of the ad manifest for the specific variant."
          }
        }
      }
    },

    "adMezzanineUri": {
      "type": "string",
      "description": "The URL of the mezzanine version of the ad, which is the input to the transcoder."
    },

    "trackingEvents": {
      "type": "object",
      "title": "trackingEvents",
      "description": "The tracking beacon URLs for the various tracking events for the ad. The keys are the event names, and the values are a list of beacon URLs.",

      "additionalProperties":  {
        "type": "array",
        "description": "The list of beacon URLs for the specified tracking event (impression, complete, and so on)",
        "items": {
          "type": "string",
          "description": "The beacon URLs for this tracking event."
        }
      }
    },

    "vastAd": {
      "$id": "#/properties/vastAd",
      "type": "object",
      "title": "vastAd",
      "description": "Information about a single ad parsed from the VAST response.",
      "required": [
        "vastAdId",
        "adSystem",
        "adTitle",
        "creativeId",
        "creativeAdId",
        "duration",
        "vastMediaFiles",
        "trackingEvents"
      ],
      "additionalProperties":  false,
      "properties": {
        "vastAdId": {
          "$id": "#/properties/vastAd/vastAdId",
          "type": "string",
          "description": "The value of the id attribute of the <code>Ad</code> tag in the VAST response",
          "examples": [
            "ad1"
          ]
        },
        "adSystem": {
          "$id": "#/properties/vastAd/adSystem",
          "type": "string",
          "description": "The value of the <code>AdSystem</code> tag in the VAST response.",
          "examples": [
            "GDFP"
          ]
        },
        "adTitle": {
          "$id": "#/properties/vastAd/adTitle",
          "type": "string",
          "description": "The media files that are available for the ad in the VAST response.",
          "examples": [
            "External NCA1C1L1 LinearInlineSkippable"
          ]
        },
        "creativeId": {
          "$id": "#/properties/vastAd/creativeId",
          "type": "string",
          "description": "The value of the id attribute of the <code>Creative</code> tag in the VAST response.",
          "examples": [
            "creative1"
          ]
        },
        "creativeAdId": {
          "$id": "#/properties/vastAd/creativeAdId",
          "type": "string",
          "description": "The value of the adId attribute of the <code>Creative</code> tag in the VAST response."
        },
        "duration": {
          "$id": "#/properties/vastAd/duration",
          "type": "number",
          "description": "The approximate duration of the ad, based on the <code>duration</code> tag in the <code>linear</code> element of the VAST response.",
          "examples": [
            30,
            30.0
          ]
        },
        "vastMediaFiles": {
          "$id": "#/properties/vastAd/vastMediaFiles",
          "type": "array",
          "description": "The list of available media files for the ad in the VAST response.",
          "items": {
            "$id": "#/properties/vastAd/vastMediaFiles/items",
            "type": "object",
            "title": "vastMediaFile",
            "description": "Information about a media file for the ad.",
            "required": [
              "uri",
              "id",
              "delivery",
              "type",
              "apiFramework",
              "width",
              "height",
              "bitrate"
            ],
            "additionalProperties":  false,
            "properties": {
              "uri": { "$ref": "#/definitions/adMezzanineUri" },
              "id": {
                "$id": "#/properties/vastAd/vastMediaFiles/items/properties/id",
                "type": "string",
                "description": "The value of the id attribute of the <code>MediaFile</code> tag.",
                "examples": [
                  "GDFP"
                ]
              },
              "delivery": {
                "$id": "#/properties/vastAd/vastMediaFiles/items/properties/delivery",
                "type": "string",
                "description": "The protocol used for the media file, set to either progressive or streaming.",
                "examples": [
                  "progressive"
                ]
              },
              "type": {
                "$id": "#/properties/vastAd/vastMediaFiles/items/properties/type",
                "type": "string",
                "description": "The MIME type of the media file, taken from the type attribute of the <code>MediaFile</code> tag.",
                "examples": [
                  "video/mp4"
                ]
              },
              "apiFramework": {
                "$id": "#/properties/vastAd/vastMediaFiles/items/properties/apiFramework",
                "type": "string",
                "description": "The API framework needed to manage the media file. Example: <code>VPAID</code>."
              },
              "width": {
                "$id": "#/properties/vastAd/vastMediaFiles/items/properties/width",
                "type": "integer",
                "description": "The pixel width of the media file.",
                "examples": [
                  1280
                ]
              },
              "height": {
                "$id": "#/properties/vastAd/vastMediaFiles/items/properties/height",
                "type": "integer",
                "description": "The pixel height of the media file.",
                "examples": [
                  720
                ]
              },
              "bitrate": {
                "$id": "#/properties/vastAd/vastMediaFiles/items/properties/bitrate",
                "type": "integer",
                "description": "The bitrate of the media file.",
                "examples": [
                  533
                ]
              }
            }
          }
        },
        "trackingEvents": { "$ref": "#/definitions/trackingEvents" },
        "vastAdTagUri": {
          "$id": "#/properties/vastAd/vastAdTagUri",
          "type": "string",
          "description": "The VMAP-specific redirect URI for an ad.",
          "examples": [
            "https://ads.redirect.com/redirect1"
          ]
        }
      }
    }

  }
}
```