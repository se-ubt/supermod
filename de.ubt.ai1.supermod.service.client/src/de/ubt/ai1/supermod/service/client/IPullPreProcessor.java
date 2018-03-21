/******************************************************************************
 * Copyright (c) 2014 Chair for Applied Computer Science I, University of 
 * Bayreuth. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html 
 *****************************************************************************/
package de.ubt.ai1.supermod.service.client;

import de.ubt.ai1.supermod.mm.client.LocalRepository;

/**
 * Client service interface to manage the local repository before updating it
 * from remote repository via the "pull" operation.
 *
 * @author 	Felix Schwaegerl <felix.schwaegerl(at)uni(minus)bayreuth(dot)de>
 * @version	0.1.0
 * @since	0.1.0
 * @date	10.11.2015
 */
public interface IPullPreProcessor {
	
	/**
	 * To be implemented in order to perform the necessary pre processing
	 * steps before the repository will be pulled
	 *
	 * @param repo the local copy to be updated via "pull"
	 * @return true if pre-processing was successful, false if the 
	 * 			pull shall be canceled
	 */
	public boolean preProcess(LocalRepository repo);

}
