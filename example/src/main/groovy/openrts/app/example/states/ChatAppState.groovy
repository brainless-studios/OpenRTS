package openrts.app.example.states

import openrts.app.example.MultiplayerGame;
import groovy.transform.CompileStatic
import tonegod.gui.controls.windows.LoginBox
import tonegod.gui.core.Screen
import tonegod.gui.core.Element.Borders
import tonegod.gui.core.Element.Docking

import com.jme3.app.Application
import com.jme3.app.state.AppStateManager
import com.jme3.input.event.MouseButtonEvent
import com.jme3.math.Vector2f

@CompileStatic
class ChatAppState extends AppStateCommon {
	LoginBox loginWindow;

	public ChatAppState(MultiplayerGame main) {
		super(main);
		displayName = "Chat";
		show = true;
	}

	@Override
	public void cleanup() {
		super.cleanup();

		screen.removeElement(loginWindow);
	}

	public void finalizeUserLogin() {
		// Some call to your app to unload this AppState and load the next AppState
		main.sucessfullLoggedIn();
	}

	@Override
	public void updateState(float tpf) {
	}

	@Override
	public void cleanupState() {
		//		panel.hide();
	}

	@Override
	public void reshape() {
		//				if (panel != null) {
		//					panel.resize(panel.getWidth(),screen.getHeight(),Borders.SE);
		//				}
	}

	@Override
	protected void initState() {
		if (!init) {


			loginWindow = new LoginBox(screen,
					"loginWindow",
					new Vector2f((Float) (screen.getWidth()/2-175),(Float)(screen.getHeight()/2-125))) {
						@Override
						public void onButtonLoginPressed(MouseButtonEvent evt, boolean toggled) {
							// Some call to the server to log the client in
							finalizeUserLogin();
						}

						@Override
						public void onButtonCancelPressed(MouseButtonEvent arg0, boolean arg1) {
							// TODO Auto-generated method stub

						}
					};
			screen.addElement(loginWindow);

			init = true;
		}

		//				panel.show();
	}
}