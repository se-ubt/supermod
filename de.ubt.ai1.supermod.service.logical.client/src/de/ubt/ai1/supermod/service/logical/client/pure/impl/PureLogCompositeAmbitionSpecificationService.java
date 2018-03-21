/******************************************************************************
 * Copyright (c) 2014 Chair for Applied Computer Science I, University of 
 * Bayreuth. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html 
 *****************************************************************************/

package de.ubt.ai1.supermod.service.logical.client.pure.impl;

import com.google.inject.Inject;

import de.ubt.ai1.supermod.mm.client.LocalRepository;
import de.ubt.ai1.supermod.mm.core.OptionBinding;
import de.ubt.ai1.supermod.mm.logical.LogicalDimension;
import de.ubt.ai1.supermod.service.client.IAmbitionSpecificationService;
import de.ubt.ai1.supermod.service.client.ICompositeAmbitionSpecificationService;
import de.ubt.ai1.supermod.service.logical.ILogicalDimensionProvider;
import de.ubt.ai1.supermod.service.logical.Logical;

/**
 * An implementation of the composite ambition specification service, which
 * accesses an ambition specification service for the logical dimension.
 *
 * @author 	Felix Schwaegerl <felix.schwaegerl(at)uni(minus)bayreuth(dot)de>
 * @version	0.1.0
 * @since	0.1.0
 * @date	01.08.2014
 */
public class PureLogCompositeAmbitionSpecificationService 
implements ICompositeAmbitionSpecificationService {
	
	@Inject
	private ILogicalDimensionProvider logDimProvider;

	@Inject
	@Logical
	private IAmbitionSpecificationService logicalAmbitionSpecificationService;
	
	/* (non-Javadoc)
	 * @see de.ubt.ai1.supermod.service.client.
	 * ICompositeAmbitionSpecificationService#specifyCompositeAmbition(
	 * de.ubt.ai1.supermod.mm.core.VersionSpace, 
	 * de.ubt.ai1.supermod.mm.core.OptionBinding, 
	 * de.ubt.ai1.supermod.mm.core.OptionBinding)
	 */
	@Override
	public OptionBinding specifyCompositeAmbition(
			LocalRepository repo, OptionBinding compositeChoice,
			OptionBinding recordedAmbition,
			OptionBinding proposedCompositeAmbition) {
		LogicalDimension logDim = logDimProvider.getLogicalDimension(
				repo.getVersionSpace());
		return logicalAmbitionSpecificationService.specifyAmbition(
					logDim,	compositeChoice, recordedAmbition,
					proposedCompositeAmbition);
	}

	/* (non-Javadoc)
	 * @see de.ubt.ai1.supermod.service.client.
	 * ICompositeAmbitionSpecificationService#undoCompositeAmbitionSpecification
	 * (de.ubt.ai1.supermod.mm.core.VersionSpace,
	 * de.ubt.ai1.supermod.mm.core.OptionBinding)
	 */
	@Override
	public void undoCompositeAmbitionSpecification(LocalRepository repo,
			OptionBinding specifiedAmbition) {
		LogicalDimension logDim = logDimProvider.getLogicalDimension(
				repo.getVersionSpace());
		logicalAmbitionSpecificationService.undoAmbitionSpecification(
				logDim, specifiedAmbition);	
	}	

}
