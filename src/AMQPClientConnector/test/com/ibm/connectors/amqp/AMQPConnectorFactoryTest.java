package com.ibm.connectors.amqp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ibm.connectors.ConnectorException;
import com.ibm.connectors.ConnectorLogger;
import com.ibm.connectors.InputConnector;
import com.ibm.connectors.ConnectorCallback;
import com.ibm.connectors.ConnectorServices;
import com.ibm.connectors.SecurityDirector;

public class AMQPConnectorFactoryTest {
	
	class MockConnectorCallback implements ConnectorCallback{
		
		ArrayList<Object> inputData = new ArrayList<Object>();

		@Override
		public void processInboundData(Object data, Properties properties) {
			inputData.add(data);
			
		}

		@Override
		public void asyncSendSuccess(long id) throws ConnectorException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void asyncRequestSuccess(long id, Object response)
				throws ConnectorException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void asyncFailure(long id, Exception e)
				throws ConnectorException {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	class MockConnectorLogger implements ConnectorLogger{

		@Override
		public Logger getJavaLogger(String name) {
			// TODO Auto-generated method stub
			return Logger.getLogger("com.ibm.connectors.amqp");
		}
		
	}
	
	class MockConnectorServices implements ConnectorServices{

		@Override
		public SecurityDirector getSecurity() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ConnectorLogger getLogFactory() {
			// TODO Auto-generated method stub
			return new MockConnectorLogger();
		}
		
	};


	AMQPConnectorFactory  connectorFactory;
	MockConnectorCallback connectorCallback;
	MockConnectorServices connectorServices;
	
	@Before
	public void setUp() throws Exception {
		connectorFactory  = new AMQPConnectorFactory();
		connectorCallback = new MockConnectorCallback();
		connectorServices = new MockConnectorServices();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInfo() {
		String info = connectorFactory.getInfo();
		assert(info.equals("AMQP Client Connector"));
	}	
	
	private void publishTestMessage(){
		System.out.println("publish");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	};
	
	@Test
	public void testCreateInputConnector() throws ConnectorException {
		InputConnector inputConnector = connectorFactory.createInputConnector("TestConector");
		Properties props = new Properties();
		props.setProperty("topic", "public");
		props.setProperty("hostname", "localhost");
		assertNotNull("createInputConnector returned null", inputConnector );
		inputConnector.initialise("TestConnector", props, connectorCallback, connectorServices);
		inputConnector.start();
		publishTestMessage();
		assertEquals("unexpected number of input data",1, connectorCallback.inputData.size());
		
		assertTrue("input data is not a byte array",
				   connectorCallback.inputData.get(0) instanceof byte[]);
		
		assertArrayEquals("unexpected content of input data ",
				           new String("hello world").getBytes(),
				           (byte[])(connectorCallback.inputData.get(0)));		
		
	}
	
	@Ignore
	@Test
	public void testCreateOutputConnector() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testCreateRequestConnector() {
		fail("Not yet implemented");
	}

}
