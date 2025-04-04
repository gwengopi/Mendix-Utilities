// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package myfirstmodule.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.mendix.core.Core;
import com.mendix.core.conf.Configuration;
import com.mendix.logging.ILogNode;

public class JA_Update_Constant extends CustomJavaAction<java.lang.String>
{
	private final java.lang.String ConstantToUpdate;
	private final java.lang.String valueToUpdate;

	public JA_Update_Constant(
		IContext context,
		java.lang.String _constantToUpdate,
		java.lang.String _valueToUpdate
	)
	{
		super(context);
		this.ConstantToUpdate = _constantToUpdate;
		this.valueToUpdate = _valueToUpdate;
	}

	@java.lang.Override
	public java.lang.String executeAction() throws Exception
	{
		// BEGIN USER CODE
		final ILogNode logger = Core.getLogger("JavaActionLogger");
		logger.info("Updating constant: " );
		final Configuration conf = Core.getConfiguration();

		logger.info(conf.getAdminUserName());
		logger.info(conf.getGuestUserRoleName());

		Set<String> constants = Core.getConfiguration().getPublicConstants();
		logger.info("Public constants size is "+constants.size());
		// Log all constants
		logger.info("Fetching all available constants in Mendix:");
		for (String constant : constants) {
			logger.info("constant name "+constant);
		}
//        logger.info(conf.getConstantValue("ConstantToUpdate") != null?conf.getConstantValue("ConstantToUpdate"):"Empty value");

		if (null != conf.getConstantValue(ConstantToUpdate) && conf.getConstantValue(ConstantToUpdate) != "") {
			logger.info(conf.getConstantValue(ConstantToUpdate));
		} else {
			logger.info("Value is not avilable");
		}
		logger.info("Reading value "+Core.getConfiguration().getConstantValue(ConstantToUpdate));

//		final Configuration confToUpdate = Core.getConfiguration();
		final Map<String, Object> configMapToUpdate = new HashMap<>();
		final Map<String, String> microflowConstantsToUpdate = new HashMap<>();
		microflowConstantsToUpdate.put(ConstantToUpdate, valueToUpdate);
		configMapToUpdate.put("MicroflowConstants", microflowConstantsToUpdate);
//        logger.error( conf1.getConstantValue("Constant"));
		// Apply the update
		Core.getConfiguration().updateConfiguration(configMapToUpdate, true);
		logger.info("Reading new  value "+Core.getConfiguration().getConstantValue(ConstantToUpdate));

		return Core.getConfiguration().getConstantValue(ConstantToUpdate).toString();
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "JA_Update_Constant";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
