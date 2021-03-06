/******************************************************************************
 * Copyright (c) 2018 Chair for Applied Computer Science I, University of 
 * Bayreuth. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html 
 *****************************************************************************/
package de.ubt.ai1.supermod.mm.feature.client;

import de.ubt.ai1.supermod.mm.client.ProductConflict;

import de.ubt.ai1.supermod.mm.feature.FeatureGroup;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dangling Group Conflict</b></em>'.
 * This conflict is reported in case the feature container of a feature group is
 * not visible in a single-version feature model.
 * @author 	Felix Schwaegerl <felix.schwaegerl(at)uni(minus)bayreuth(dot)de>,
 * 			Johannes Schroepfer <Johannes.M.Schroepfer(at)uni(minus)bayreuth(dot)de>
 * @version	0.1.0
 * @since	0.1.0
 * @date	2018-01-09
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.ubt.ai1.supermod.mm.feature.client.DanglingGroupConflict#getContextGroup <em>Context Group</em>}</li>
 * </ul>
 *
 * @see de.ubt.ai1.supermod.mm.feature.client.SuperModFeatureClientPackage#getDanglingGroupConflict()
 * @model
 * @generated
 */
public interface DanglingGroupConflict extends ProductConflict {
	/**
	 * Returns the value of the '<em><b>Context Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Group</em>' reference.
	 * @see #setContextGroup(FeatureGroup)
	 * @see de.ubt.ai1.supermod.mm.feature.client.SuperModFeatureClientPackage#getDanglingGroupConflict_ContextGroup()
	 * @model
	 * @generated
	 */
	FeatureGroup getContextGroup();

	/**
	 * Sets the value of the '{@link de.ubt.ai1.supermod.mm.feature.client.DanglingGroupConflict#getContextGroup <em>Context Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Group</em>' reference.
	 * @see #getContextGroup()
	 * @generated
	 */
	void setContextGroup(FeatureGroup value);

} // DanglingGroupConflict
