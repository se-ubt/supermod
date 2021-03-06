/******************************************************************************
 * Copyright (c) 2014 Chair for Applied Computer Science I, University of 
 * Bayreuth. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html 
 *****************************************************************************/
package de.ubt.ai1.supermod.vcs.client.http.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import de.ubt.ai1.supermod.service.client.exceptions.SuperModClientException;
import de.ubt.ai1.supermod.service.client.exceptions.SuperModClientWrappedException;
import de.ubt.ai1.supermod.vcs.client.http.ILockHttpRequest;
import de.ubt.ai1.supermod.vcs.client.http.exceptions.SuperModClientResponseCodeException;

/**
 * Default implementation of the LOCK request service interface.
 *
 * @author 	Felix Schwaegerl <felix.schwaegerl(at)uni(minus)bayreuth(dot)de>
 * @version	0.1.0
 * @since	0.1.0
 * @date	10.11.2015
 */
public class LockHttpRequest
extends BasicHttpRequest
implements ILockHttpRequest {

	/* (non-Javadoc)
	 * @see de.ubt.ai1.supermod.vcs.client.http.ILockHttpRequest
	 * #isLocked(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isLocked(String repoUrl, String user)
			throws SuperModClientException {
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("user", user);
		HttpURLConnection conn;
		try {
			conn = createHttpConnection(repoUrl + "/lock", 
					GET, getPort(), queryParams, null);
			int responseCode = conn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				return true;
			}
			else if (responseCode == HttpURLConnection.HTTP_NO_CONTENT) {
				return false;
			}
			else {
				throw new SuperModClientResponseCodeException(responseCode,
						conn.getResponseMessage());
			}
		} catch (IOException e) {
			throw new SuperModClientWrappedException(e);
		}		
	}
	
	/* (non-Javadoc)
	 * @see de.ubt.ai1.supermod.vcs.client.http.ILockHttpRequest
	 * #getLockUser(java.lang.String, java.lang.String)
	 */
	@Override
	public String getLockUser(String repoUrl, String user)
			throws SuperModClientException {
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("user", user);
		HttpURLConnection conn;
		try {
			conn = createHttpConnection(repoUrl + "/lock/user", 
					GET, getPort(), queryParams, null);
			int responseCode = conn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				String response = getResponse(conn).trim();
				return response;
			}
			else {
				throw new SuperModClientResponseCodeException(responseCode,
						conn.getResponseMessage());
			}
		} catch (IOException e) {
			throw new SuperModClientWrappedException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see de.ubt.ai1.supermod.vcs.client.http.ILockHttpRequest
	 * #getLockDate(java.lang.String, java.lang.String)
	 */
	@Override
	public String getLockDate(String repoUrl, String user)
			throws SuperModClientException {
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("user", user);
		HttpURLConnection conn;
		try {
			conn = createHttpConnection(repoUrl + "/lock/date", 
					GET, getPort(), queryParams, null);
			int responseCode = conn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				String response = getResponse(conn).trim();
				return response;
			}
			else {
				throw new SuperModClientResponseCodeException(responseCode,
						conn.getResponseMessage());
			}
		} catch (IOException e) {
			throw new SuperModClientWrappedException(e);
		}
	}

	/* (non-Javadoc)
	 * @see de.ubt.ai1.supermod.vcs.client.http.ILockHttpRequest
	 * #lock(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean lock(String repoUrl, String user)
			throws SuperModClientException {
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("user", user);
		HttpURLConnection conn;
		try {
			conn = createHttpConnection(repoUrl + "/putlock", 
					PUT, getPort(), queryParams, "putlock");
			int responseCode = conn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				return true;
			}
			else {
				throw new SuperModClientResponseCodeException(responseCode,
						conn.getResponseMessage());
			}
		} catch (IOException e) {
			throw new SuperModClientWrappedException(e);
		}		
	}

	/* (non-Javadoc)
	 * @see de.ubt.ai1.supermod.vcs.client.http.ILockHttpRequest
	 * #unlock(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean unlock(String repoUrl, String user)
			throws SuperModClientException {
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("user", user);
		queryParams.put("release", "release");
		HttpURLConnection conn;
		try {
			conn = createHttpConnection(repoUrl + "/putlock", 
					PUT, getPort(), queryParams, "putlock");
			int responseCode = conn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				return true;
			}
			else if (responseCode == 423) {
				return false;
			}
			else {
				throw new SuperModClientResponseCodeException(responseCode,
						conn.getResponseMessage());
			}
		} catch (IOException e) {
			throw new SuperModClientWrappedException(e);
		}		
	}

	/* (non-Javadoc)
	 * @see de.ubt.ai1.supermod.vcs.client.http.ILockHttpRequest
	 * #forceUnlock(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean forceUnlock(String repoUrl, String user)
			throws SuperModClientException {
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("user", user);
		queryParams.put("release", "release");
		queryParams.put("force", "force");
		HttpURLConnection conn;
		try {
			conn = createHttpConnection(repoUrl + "/putlock", 
					PUT, getPort(), queryParams, "putlock");
			int responseCode = conn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				return true;
			}
			else if (responseCode == 423) {
				return false;
			}
			else {
				throw new SuperModClientResponseCodeException(responseCode,
						conn.getResponseMessage());
			}
		} catch (IOException e) {
			throw new SuperModClientWrappedException(e);
		}		
	}

}
