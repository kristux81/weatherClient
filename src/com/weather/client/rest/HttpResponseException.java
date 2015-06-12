package com.weather.client.rest;

import java.io.IOException;

/**
 * @author krvsingh
 *
 */
public class HttpResponseException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1456467686L;

	/**
	 * The URL of resource retrieved.
	 */
	protected String resourceUrl;

	/**
	 * The response object.
	 */
	protected Object response;

	/**
	 * An <code>int</code> representing the three digit HTTP Status-Code.
	 * <ul>
	 * <li> 1xx: Informational
	 * <li> 2xx: Success
	 * <li> 3xx: Redirection
	 * <li> 4xx: Client Error
	 * <li> 5xx: Server Error
	 * </ul>
	 */
	protected int responseCode = -1;

	/**
	 * The HTTP response message.
	 */
	protected String responseMessage = null;

	/**
	 * Instantiates a new http response exception.
	 * 
	 * @param resourceUrl the resource url
	 * @param response the response
	 * @param responseCode the response code
	 * @param responseMessage the response message
	 */
	public HttpResponseException(String resourceUrl, Object response, int responseCode, String responseMessage)
	{
		super("" + responseCode + ": " + responseMessage);
		this.resourceUrl = resourceUrl;
		this.response = response;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	/**
	 * Return the URL of resource retrieved.
	 */
	public String getResourceUrl()
	{
		return resourceUrl;
	}

	/**
	 * Return the response object.
	 */
	public Object getResponse()
	{
		return response;
	}

	/**
	 * Gets the status code from an HTTP response message.
	 * For example, in the case of the following status lines:
	 * <PRE>
	 * HTTP/1.0 200 OK
	 * HTTP/1.0 401 Unauthorized
	 * </PRE>
	 * It will return 200 and 401 respectively.
	 * Returns -1 if no code can be discerned
	 * from the response (i.e., the response is not valid HTTP).
	 * @throws IOException if an error occurred connecting to the server.
	 * @return the HTTP Status-Code, or -1
	 */
	public int getResponseCode() throws IOException
	{
		return responseCode;
	}

	/**
	 * Gets the HTTP response message, if any, returned along with the
	 * response code from a server.  From responses like:
	 * <PRE>
	 * HTTP/1.0 200 OK
	 * HTTP/1.0 404 Not Found
	 * </PRE>
	 * Extracts the Strings "OK" and "Not Found" respectively.
	 * Returns null if none could be discerned from the responses 
	 * (the result was not valid HTTP).
	 * @throws IOException if an error occurred connecting to the server.
	 * @return the HTTP response message, or <code>null</code>
	 */
	public String getResponseMessage() throws IOException
	{
		return responseMessage;
	}
}
