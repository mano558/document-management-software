package com.logicaldoc.gui.frontend.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.logicaldoc.gui.common.client.ServerException;

/**
 * The client side stub for the ClusterService Service. This service gives
 * access to the Clustering stuff.
 * 
 * @author Marco Meschieri - Logical Objects
 * @since 6.5
 */
@RemoteServiceRelativePath("cluster")
public interface ClusterService extends RemoteService {

	/**
	 * Shares a list of configuration parameters
	 */
	public void makeGlobal(String[] parameters) throws ServerException;

	/**
	 * Unshares a list of configuration parameters
	 */
	public void makeLocal(String[] parameters) throws ServerException;

	public static class Instance {
		private static ClusterServiceAsync instance;

		public static ClusterServiceAsync get() {
			if (instance == null) {
				instance = GWT.create(ClusterService.class);
			}
			return instance;
		}
	}
}