/******************************************************************************
 * Copyright (c) 2014 Chair for Applied Computer Science I, University of 
 * Bayreuth. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html 
 *****************************************************************************/

/**
 * Provides implementations for a sub-set of the service interfaces defined in
 * the package {@link de.ubt.ai1.supermod.service} to implementation specific
 * to pure file product spaces, where two dimensions, {@link Feature} and
 * {@link File} are defined. Classes inside this package are not intended to be
 * instantiated. Rather, they should be injected by means of Guice, using the
 * bindings defined in {@link 
 * de.ubt.ai1.supermod.service.featfile.SuperModFeatFileModule}.
 *  *
 * @author 	Felix Schwaegerl <felix.schwaegerl(at)uni(minus)bayreuth(dot)de>
 * @version	0.1.0
 * @since	0.1.0
 * @date	02.03.2015
 */
package de.ubt.ai1.supermod.service.featfile.impl;