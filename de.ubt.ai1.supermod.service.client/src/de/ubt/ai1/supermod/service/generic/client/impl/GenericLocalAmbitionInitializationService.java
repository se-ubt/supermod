/******************************************************************************
 * Copyright (c) 2014 Chair for Applied Computer Science I, University of 
 * Bayreuth. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html 
 *****************************************************************************/
package de.ubt.ai1.supermod.service.generic.client.impl;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.ubt.ai1.supermod.mm.core.OptionBinding;
import de.ubt.ai1.supermod.mm.core.VersionSpace;
import de.ubt.ai1.supermod.service.client.ILocalAmbitionInitializationService;
import de.ubt.ai1.supermod.service.client.exceptions.SuperModClientException;
import de.ubt.ai1.supermod.service.client.exceptions.SuperModClientWrappedException;

/**
 * Generic implementation of the ambition initialization service.
 *
 * @author 	Felix Schwaegerl <felix.schwaegerl(at)uni(minus)bayreuth(dot)de>
 * @version	0.1.0
 * @since	0.1.0
 * @date	28.09.2015
 */
public class GenericLocalAmbitionInitializationService
implements ILocalAmbitionInitializationService {
	
	/* (non-Javadoc)
	 * @see de.ubt.ai1.supermod.service.client.ILocalChoiceInitializationService
	 * #initializeLocalChoice(de.ubt.ai1.supermod.mm.core.VersionSpace, 
	 * org.eclipse.emf.ecore.resource.ResourceSet, java.lang.String)
	 */
	@Override
	public OptionBinding initializeLocalAmbition(VersionSpace vs, 
			ResourceSet rs,	String repoUri) throws SuperModClientException {
		URI laUri = URI.createPlatformResourceURI(repoUri, true)
				.trimFileExtension().appendFileExtension("lamb");
		Resource laRes = rs.createResource(laUri);
		try {
			laRes.save(null);
		} catch (IOException e) {
			throw new SuperModClientWrappedException(e);
		}
		return null;
	}

}
