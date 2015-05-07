# amqp-client-connector
AMQP and IBM MQ Light connector and nodes for IBM Integration Bus

To install connector on IIB Server..
* download https://github.com/ot4i/amqp-client-connector/releases/download/v0.1/AMQPClientConnector.zip
* unzip to <MQSI_WORKPATH>/connectors where <<MQSI_WORKPATH> is $MQSI_WORKPATH ( unix) or %MQSI_WORKPATH% ( Windows) e.g. C:\ProgramData\IBM\MQSI or /var/mqsi or ~/iibconfig
  
To install nodes on IIB Tools
* download https://github.com/ot4i/amqp-client-connector/releases/download/v0.1/AMQPClientNodes.0.0.1.zip
* copy AMQPClientNodes_0.0.1.201505072135.jar, from the downloaded zip file, into the dropins directory of the toolkit install (e.g. C:\Program Files\IBM\IIB\10.0.x.y\tools\dropins
