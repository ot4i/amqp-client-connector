package com.ibm.connector.amqp;

import com.ibm.broker.config.appdev.InputTerminal;
import com.ibm.broker.config.appdev.Node;
import com.ibm.broker.config.appdev.NodeProperty;
import com.ibm.broker.config.appdev.OutputTerminal;

/*** 
 * <p>  <I>AMQPInputNodeNodeUDN</I> instance</p>
 * <p></p>
 */
public class AMQPInputNodeNodeUDN extends Node {

	private static final long serialVersionUID = 1L;

	// Node constants
	protected final static String NODE_TYPE_NAME = "com/ibm/connector/amqp/EventInputNode";
	protected final static String NODE_GRAPHIC_16 = "platform:/plugin/AMQPClientNodes/icons/full/obj16/com/ibm/connector/amqp/ComIbmEventInput.gif";
	protected final static String NODE_GRAPHIC_32 = "platform:/plugin/AMQPClientNodes/icons/full/obj30/com/ibm/connector/amqp/ComIbmEventInput.gif";

	protected final static String PROPERTY_CONNECTORNAME = "connectorName";
	protected final static String PROPERTY_TOPIC = "topic";
	protected final static String PROPERTY_HOSTNAME = "hostname";

	protected NodeProperty[] getNodeProperties() {
		return new NodeProperty[] {
			new NodeProperty(AMQPInputNodeNodeUDN.PROPERTY_CONNECTORNAME,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "AMQP","","",	"com/ibm/connector/amqp/ComIbmEventInput",	"AMQPClientNodes"),
			new NodeProperty(AMQPInputNodeNodeUDN.PROPERTY_TOPIC,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connector/amqp/ComIbmEventInput",	"AMQPClientNodes"),
			new NodeProperty(AMQPInputNodeNodeUDN.PROPERTY_HOSTNAME,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connector/amqp/ComIbmEventInput",	"AMQPClientNodes")
		};
	}

	public AMQPInputNodeNodeUDN() {
	}

	@Override
	public InputTerminal[] getInputTerminals() {
		return null;
	}

	public final OutputTerminal OUTPUT_TERMINAL_OUT = new OutputTerminal(this,"OutTerminal.out");
	@Override
	public OutputTerminal[] getOutputTerminals() {
		return new OutputTerminal[] {
			OUTPUT_TERMINAL_OUT
		};
	}

	@Override
	public String getTypeName() {
		return NODE_TYPE_NAME;
	}

	protected String getGraphic16() {
		return NODE_GRAPHIC_16;
	}

	protected String getGraphic32() {
		return NODE_GRAPHIC_32;
	}

	/**
	 * Set the <I>AMQPInputNodeNodeUDN</I> "<I>connectorName</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>connectorName</I>"
	 */
	public AMQPInputNodeNodeUDN setConnectorName(String value) {
		setProperty(AMQPInputNodeNodeUDN.PROPERTY_CONNECTORNAME, value);
		return this;
	}

	/**
	 * Get the <I>AMQPInputNodeNodeUDN</I> "<I>connectorName</I>" property
	 * 
	 * @return String; the value of the property "<I>connectorName</I>"
	 */
	public String getConnectorName() {
		return (String)getPropertyValue(AMQPInputNodeNodeUDN.PROPERTY_CONNECTORNAME);
	}

	/**
	 * Set the <I>AMQPInputNodeNodeUDN</I> "<I>topic</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>topic</I>"
	 */
	public AMQPInputNodeNodeUDN setTopic(String value) {
		setProperty(AMQPInputNodeNodeUDN.PROPERTY_TOPIC, value);
		return this;
	}

	/**
	 * Get the <I>AMQPInputNodeNodeUDN</I> "<I>topic</I>" property
	 * 
	 * @return String; the value of the property "<I>topic</I>"
	 */
	public String getTopic() {
		return (String)getPropertyValue(AMQPInputNodeNodeUDN.PROPERTY_TOPIC);
	}

	/**
	 * Set the <I>AMQPInputNodeNodeUDN</I> "<I>hostname</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>hostname</I>"
	 */
	public AMQPInputNodeNodeUDN setHostname(String value) {
		setProperty(AMQPInputNodeNodeUDN.PROPERTY_HOSTNAME, value);
		return this;
	}

	/**
	 * Get the <I>AMQPInputNodeNodeUDN</I> "<I>hostname</I>" property
	 * 
	 * @return String; the value of the property "<I>hostname</I>"
	 */
	public String getHostname() {
		return (String)getPropertyValue(AMQPInputNodeNodeUDN.PROPERTY_HOSTNAME);
	}

	public String getNodeName() {
		String retVal = super.getNodeName();
		if ((retVal==null) || retVal.equals(""))
			retVal = "AMQP Input Node";
		return retVal;
	};
}
