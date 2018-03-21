/*
 * generated by Xtext
 */
package de.ubt.ai1.supermod.text;

import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.scoping.IScopeProvider;

import de.ubt.ai1.supermod.text.scoping.LogicalFragmentProvider;
import de.ubt.ai1.supermod.text.scoping.LogicalScopeProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class LogicalRuntimeModule extends de.ubt.ai1.supermod.text.AbstractLogicalRuntimeModule {
	
	@Override
	public Class<? extends IFragmentProvider> bindIFragmentProvider() {
		return LogicalFragmentProvider.class;
	}
	
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return LogicalScopeProvider.class;
	}
	
}
