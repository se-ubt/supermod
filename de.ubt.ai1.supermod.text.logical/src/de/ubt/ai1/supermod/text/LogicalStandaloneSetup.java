/*
* generated by Xtext
*/
package de.ubt.ai1.supermod.text;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class LogicalStandaloneSetup extends LogicalStandaloneSetupGenerated{

	public static void doSetup() {
		new LogicalStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

