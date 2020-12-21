package core.gwt;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import core.GameMain;
import core.config.GameConfig;

/** Launches the GWT application. */
public class GwtLauncher extends GwtApplication {
		@Override
		public GwtApplicationConfiguration getConfig () {
			// Resizable application, uses available space in browser
//			return new GwtApplicationConfiguration(true);
			// Fixed size application:
			return new GwtApplicationConfiguration(GameConfig.SCREEN_HTML_DISPLAY_WIDTH, GameConfig.SCREEN_HTML_DISPLAY_HEIGHT);
		}

		@Override
		public ApplicationListener createApplicationListener () { 
			return new GameMain();
		}
}
