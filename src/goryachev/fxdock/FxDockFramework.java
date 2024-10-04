// Copyright © 2016-2023 Andy Goryachev <andy@goryachev.com>
package goryachev.fxdock;
import de.pidata.service.base.ParameterList;
import goryachev.fxdock.internal.FrameworkBase;
import java.util.List;


/**
 * Docking Framework for JavaFX.
 */
public class FxDockFramework
{
	/** a generator must be plugged into the framework to provide custom windows and panes */ 
	public static interface Generator
	{
		public FxDockWindow createWindow( String windowPrefix );

		public FxDockWindow createWindowWithId( String dialogId, ParameterList parameterList );

		public FxDockWindow createWindowForDockPane( FxDockPane client );
		
		public FxDockPane createPane(String type, ParameterList parameterList );
	}
	
	//
	
	/** implementation */
	protected static FrameworkBase base = new FrameworkBase();
	
	
	/** set your own implementation if you dare */
	public static void setFrameworkBase(FrameworkBase b)
	{
		base = b;
	}
	
	
	/** generator allows for creation of custom docking Stages and docking Panes */ 
	public static void setGenerator(Generator g)
	{
		base.setGenerator(g);
	}
	
	
	public static FxDockWindow createWindow(String windowPrefix)
	{
		return base.createWindow(windowPrefix);
	}

	public static FxDockWindow createWindowForWithId( String dialogId, ParameterList parameterList ) {
		return base.createWindowWithId( dialogId, parameterList );
	}

	public static FxDockWindow createWindowForDockPane( FxDockPane client ) {
		return base.createWindowForDockPane( client );
	}

	public static FxDockPane createPane(String type, ParameterList parameterList )
	{
		return base.createPane(type, parameterList);
	}
	
	
	public static int loadLayout()
	{
		return base.loadLayout();
	}
	
	
	public static void saveLayout()
	{
		base.saveLayout();
	}
	

	public static void open(FxDockWindow w)
	{
		base.open(w);
	}
	
	
	/** returns topmost window */
	public static FxDockWindow findTopWindow(List<FxDockWindow> ws)
	{
		return base.findTopWindow(ws);
	}
	
	
	/** returns a list of visible windows, topmost window first */
	public static List<FxDockWindow> getWindows()
	{
		return base.getWindows();
	}
	
	
	/** returns the number of visible windows */
	public static int getWindowCount()
	{
		return base.getWindowCount();
	}
	
	
	public static void exit()
	{
		base.exit();
	}
}
