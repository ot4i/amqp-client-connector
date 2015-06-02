# amqp-client-connector
AMQP and IBM MQ Light connector and nodes for IBM Integration Bus

## Install pre-built binaries
To install connector on IIB Server..
* download https://github.com/ot4i/amqp-client-connector/releases/download/v0.1/AMQPClientConnector.0.0.1.zip
* unzip to `<MQSI_WORKPATH>/connectors` where `<MQSI_WORKPATH>` is $MQSI_WORKPATH ( unix) or %MQSI_WORKPATH% ( Windows) e.g. C:\ProgramData\IBM\MQSI or /var/mqsi or ~/iibconfig
  
To install nodes on IIB Tools
* download https://github.com/ot4i/amqp-client-connector/releases/download/v0.1/AMQPClientNodes.0.0.1.zip
* copy AMQPClientNodes_0.0.1.201505072135.jar, from the downloaded zip file, into the dropins directory of the toolkit install (e.g. C:\Program Files\IBM\IIB\10.0.x.y\tools\dropins


## Build from source
### Install build prereqs
* download and install [IBM Integration Bus] (http://www-03.ibm.com/software/products/en/ibm-integration-bus) which is available free of charge for developers.
* ensure that environment variable MQSI_FILEPATH has been set to the server directory of your IIB install ( e.g. /opt/IBM/IIB/server or C:\Program Files\IBM\IIB\10.0.0.0\server)
* download [mqlight client api](http://public.dhe.ibm.com/ibmdl/export/pub/software/websphere/messaging/mqkoa/mqlight-api-1.0.2015021901-SNAPSHOT-all.zip) and [install it](https://developer.ibm.com/messaging/mq-light/docs/?lang=java ), and its dependancies on your local maven repostoritory 

### Clone this repository
``
git clone https://github.com/ot4i/amqp-client-connector.git
``

### Compile and test this project
```
cd amqp-client-connector
gradlew build
```


#### NOTE 
There are 2 alternative approaches to install the dependancies. (1) via maven as above, and (2) manually.  If you chose to obtain the dependancies manually, then you must ensure that the CLASSPATH is confiugred wiht those jars before running gradlew




