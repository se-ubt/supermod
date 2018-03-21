/******************************************************************************
 * Copyright (c) 2014 Chair for Applied Computer Science I, University of 
 * Bayreuth. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html 
 *****************************************************************************/

package de.ubt.ai1.supermod.service.revision;

import com.google.inject.AbstractModule;

import de.ubt.ai1.supermod.service.IRevisionGraphProvider;
import de.ubt.ai1.supermod.service.IVersionDimensionMergeService;
import de.ubt.ai1.supermod.service.revision.impl.RevisionDimensionMergeService;
import de.ubt.ai1.supermod.service.revision.impl.RevisionGraphProvider;

/**
 * Guice module which defines bindings for version space services specific to
 * the SuperMod revision dimension.
 * 
 * @author 	Felix Schwaegerl <felix.schwaegerl(at)uni(minus)bayreuth(dot)de>
 * @version	0.1.0
 * @since	0.1.0
 * @date	01.08.2014
 */
public class SuperModRevisionModule extends AbstractModule {

	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		bind(IVersionDimensionMergeService.class)
				.annotatedWith(Revision.class)
				.to(RevisionDimensionMergeService.class);
		bind(IRevisionGraphProvider.class)
				.to(RevisionGraphProvider.class);
	}

}
