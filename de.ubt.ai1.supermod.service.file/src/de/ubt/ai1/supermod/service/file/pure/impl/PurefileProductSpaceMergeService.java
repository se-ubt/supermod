/******************************************************************************
 * Copyright (c) 2014 Chair for Applied Computer Science I, University of 
 * Bayreuth. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html 
 *****************************************************************************/

package de.ubt.ai1.supermod.service.file.pure.impl;

import com.google.inject.Inject;

import de.ubt.ai1.supermod.mm.core.ProductDimension;
import de.ubt.ai1.supermod.mm.core.ProductSpace;
import de.ubt.ai1.supermod.mm.core.SuperModCoreFactory;
import de.ubt.ai1.supermod.mm.core.VisibilityForest;
import de.ubt.ai1.supermod.mm.diff.MatchingRole;
import de.ubt.ai1.supermod.mm.diff.ProductSpaceMatching;
import de.ubt.ai1.supermod.service.IProductDimensionMergeService;
import de.ubt.ai1.supermod.service.IProductSpaceMergeService;
import de.ubt.ai1.supermod.service.file.File;

/**
 * Implementation of the product space merge service interface specific to
 * SuperMod's pure file product space type.
 *
 * @author 	Felix Schwaegerl <felix.schwaegerl(at)uni(minus)bayreuth(dot)de>
 * @version	0.1.0
 * @since	0.1.0
 * @date	30.07.2014
 */
public class PurefileProductSpaceMergeService 
implements IProductSpaceMergeService {
	
	@Inject
	@File
	private IProductDimensionMergeService fileSystemMergeService;

	/* (non-Javadoc)
	 * @see de.ubt.ai1.supermod.service.IProductSpaceMergeService
	 * #merge(de.ubt.ai1.supermod.mm.diff.ProductSpaceMatching, 
	 * de.ubt.ai1.supermod.mm.diff.MatchingRole, 
	 * de.ubt.ai1.supermod.mm.core.VisibilityForest)
	 */
	@Override
	public ProductSpace mergeOutPlace(ProductSpaceMatching psMatching,
			MatchingRole mergeRole, VisibilityForest visibilityForest) {
		ProductSpace ps = SuperModCoreFactory.eINSTANCE.createProductSpace();
		ProductDimension mergedPd = fileSystemMergeService.mergeOutPlace(
				psMatching.getDimensionMatchings().get(0),
				psMatching.getMatchingRoles(), mergeRole, visibilityForest);
		ps.getDimensions().add(mergedPd);
		return ps;
	}

	/* (non-Javadoc)
	 * @see de.ubt.ai1.supermod.service.IProductSpaceMergeService#mergeInPlace(
	 * de.ubt.ai1.supermod.mm.diff.ProductSpaceMatching,
	 * de.ubt.ai1.supermod.mm.diff.MatchingRole,
	 * de.ubt.ai1.supermod.mm.core.VisibilityForest)
	 */
	@Override
	public void mergeInPlace(ProductSpaceMatching psMatching,
			MatchingRole masterRole, VisibilityForest visibilityForest) {
		fileSystemMergeService.mergeInPlace(
				psMatching.getDimensionMatchings().get(0),
				psMatching.getMatchingRoles(), masterRole, visibilityForest);		
	}

}
