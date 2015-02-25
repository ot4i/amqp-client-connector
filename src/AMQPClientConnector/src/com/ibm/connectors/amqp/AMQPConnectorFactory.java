package com.ibm.connectors.amqp;

import java.util.Properties;

import com.ibm.connectors.AbstractConnectorFactory;
import com.ibm.connectors.ConnectorException;
import com.ibm.connectors.InputConnector;
import com.ibm.connectors.AbstractInputConnector;
import com.ibm.connectors.OutputConnector;
import com.ibm.connectors.RequestConnector;
import com.ibm.mqlight.api.BytesDelivery;
import com.ibm.mqlight.api.ClientState;
import com.ibm.mqlight.api.CompletionListener;
import com.ibm.mqlight.api.DestinationAdapter;
import com.ibm.mqlight.api.NonBlockingClient;
import com.ibm.mqlight.api.Delivery;

public class AMQPConnectorFactory extends AbstractConnectorFactory {

	@Override
	public String getInfo() {
		return "AMQP Client Connector";
	}

	@Override
	public InputConnector createInputConnector(String name)
			throws ConnectorException {
		return new AbstractInputConnector(){
			
						NonBlockingClient client; 
						@Override
						public void start() throws ConnectorException {
							
							//use the properties configured by the user
							String topicName     = getProperty("topic");
							String serverAddress = new String("amqp://") + getProperty("hostname");
							
							client = NonBlockingClient.create(serverAddress, null, null);
							client.subscribe(topicName, new DestinationAdapter<Object>() {
							  public void onMessage(NonBlockingClient client, Void context, Delivery delivery) {
							    BytesDelivery bd = (BytesDelivery)delivery;
							      
							    //report metadata about the delivery
							    Properties deliveryProperties = new Properties();							      
							    deliveryProperties.putAll(bd.getProperties());							      
							      
							    //ask the framework to process the data and metadata
							    getCallback().processInboundData(bd.getData(),
							  		                           deliveryProperties);
							      
							      
							  }
							}, null, null);
						}
			
						@Override
						public void stop() throws ConnectorException {
							client.stop(new CompletionListener<Object>() {

								@Override
								public void onError(NonBlockingClient client,
										Object context, Exception exception) {
									System.out.println("Error stopping");
									
								}

								@Override
								public void onSuccess(NonBlockingClient client,
										Object context) {
									System.out.println("Stopped");						
								}
							}, null);

						}


						@Override
						public boolean isStarted() {	
							return client.getState()==ClientState.STARTED;
						}
						
					};
	}

	@Override
	public OutputConnector createOutputConnector(String name)
			throws ConnectorException {
		return null;
	}

	@Override
	public RequestConnector createRequestConnector(String name)
			throws ConnectorException {
		return null;
	}

}
