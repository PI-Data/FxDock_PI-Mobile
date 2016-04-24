// Copyright (c) 2016 Andy Goryachev <andy@goryachev.com>
package goryachev.fxdock;
import goryachev.fxdock.internal.FxDockRootPane;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * FxDockWindow.
 */
public abstract class FxDockWindow
	extends Stage
{
	public abstract FxDockPane createPane(String type);
	
	//
	
	private final FxDockRootPane root;
	
	
	public FxDockWindow()
	{
		root = new FxDockRootPane(this);
		Scene s = new Scene(root);
		setScene(s);
	}
	
	
	public void open()
	{
		FxDockFramework.open(this);
	}
}
