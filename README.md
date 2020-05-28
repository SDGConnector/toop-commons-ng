# TOOP Commons NG

This is the successor project of the old [toop-commons](https://github.com/TOOP4EU/toop-commons) project.
The code contained in this project is used by:
* https://github.com/TOOP4EU/toop-connector-ng - TOOP Connector NG (TC NG)
* https://github.com/TOOP4EU/data-services-directory - Data Services Directory (DSD)
* https://github.com/TOOP4EU/toop-simulator-ng/ - TOOP Simulator NG
* https://github.com/TOOP4EU/toop-playground-ng/ - Playground NG (the previous DemoUI)

## Status


Working on `v2.0.0-beta5`
* Added new Schematrons to check if a document type is the expected one
* Improved the loading of XSDs for DCatAP Schemas
* Added enumeration `EIdentifierType` for the valid person and company identifier types

2020-05-26: release of `v2.0.0-beta4`
* Removed all methods deprecated in beta3
* Micro optimizations, but no material changes

2020-05-19: release of `v2.0.0-beta3`
* Initial copy from TOOP Connector NG for easier dependency reuse
* Added new Request query definition "Object Reference" to request a document with an ID only
* Renamed `getReader()` to `reader()`
* Updated the Schematron rules
* A new response object layout was introduced: list of RegRep `ObjectRef`s - it's referred to as "DocumentRef" internally
* The `EDMRequest` has a new mandatory property: "ResponseOption" - this determines if the payload is contained in the response or referenced
* `EDMRequest` now has explicit builder classes depending on the request type: `EDMRequest.BuilderConcept` , `EDMRequest.BuilderDocumentsByDistribution` and `EDMRequest.BuilderDocumentByID`
* `EDMResponse` now has explicit builder classes depending on the result layout: `EDMResponse.BuilderConcept`, `EDMResponse.BuilderDocument` and `EDMResponse.BuilderDocumentReference`
* `EDMExceptionBuilder` was renamed to `EDMExceptionPojo` and now has a separate `builder()` method like the other Pojos
* Schematron rules are now available in two different files and need to be executed subsequently 

2020-05-12: release of `v2.0.0-beta2`
* Changed the main EDM classes for request, response and error response to `EDMRequest`, `EDMResponse` and `EDMErrorResponse`
* Added `getReader()` and `getWriter()` methods to easily read and write these objects from and to different structures

2020-05-06: release of `v2.0.0-beta1`
* Libraries for creating the new data model
* Consisting of `toop-edm`, `toop-regrep`, `toop-kafka-client` and `toop-commons`
* Allows to create Requests, Responses and Errors according to the new EDM (Electronic Data Model)

## Maven coordinates

```xml
      <dependency>
        <groupId>eu.toop</groupId>
        <artifactId>toop-edm</artifactId>
        <version>2.0.0-beta4</version>
      </dependency>
```

The rest comes via transitive dependencies.

## Building

Requires at least

* Java 1.8 or later
* Apache Maven for building

Do an initial `mvn clean install` on the command line.

Afterwards don't forget to add the following paths to your build path (in your IDE):

* toop-regrep/target/generated-sources/xjc
* toop-edm/target/generated-sources/xjc

Note: the `toop-codelist-tools` is for internal usage only.

## Side notes

If you wander what "Pojo" means - it is very simple and stands for "Plain Old Java Object".
